package com.ss.bduploader.net;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.ss.bduploader.BDUploadLog;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class BDUploadHostProcessor {
    private static final int BACKUP_DNS = 1;
    private static final int MAIN_DNS = 0;
    public static final int MSG_IS_BACUP_PARSE = 1;
    public static final int MSG_IS_MAIN_PARSE = 0;
    public static final int STATE_IS_IDLE = 0;
    public static final int STATE_IS_PARSE_END_ERROR = 2;
    public static final int STATE_IS_PARSE_END_SUC = 3;
    public static final int STATE_IS_WAIT_RESULT = 1;
    private static final String TAG = "BDUploadHostProcessor";
    private int mBackUpDelayedTime;
    private int mBackUpType;
    private Handler mHandler;
    public String mHost;
    public HashMap<BDUploadDNSParserListener, Integer> mListeners;
    private int mMainType;
    private BaseDNS[] mParsers;
    private int[] mStates;

    public BDUploadHostProcessor(String r1, Handler r2, int r3, int r4, int r5) {
        this.mMainType = r3;
        this.mBackUpType = r4;
        this.mHandler = r2;
        this.mHost = r1;
        this.mBackUpDelayedTime = r5;
        this.mStates = new int[2];
        this.mParsers = new BaseDNS[2];
        int r6 = 0;
    L3:
        if (r6 >= 2) goto L5;
        this.mParsers[r6] = null;
        r6 = r6 + 1;
        goto L3
    L5:
        int r7 = 0;
    L6:
        if (r7 >= 2) goto L8;
        this.mStates[r7] = 0;
        r7 = r7 + 1;
        goto L6
    L8:
        this.mListeners = new HashMap();
    }

    private BaseDNS createDNSParser(String r5, int r6, int r7) {
        if (r6 == 1) goto L9;
        if (r6 == 2) goto L9;
        if (r6 == 3) goto L9;
        BDUploadLog.d(TAG, String.format("create local dns parser for host:%s type:%d", new Object[]{r5, Integer.valueOf(r6)}));
        return new LocalDNS(r5, this.mHandler);
    L9:
        BDUploadLog.d(TAG, String.format("create http dns parser for host:%s type:%d", new Object[]{r5, Integer.valueOf(r6)}));
        return new HTTPDNS(r5, null, r6, this.mHandler);
    }

    private void doParseInternal(int r6, BDUploadDNSInfo r7) {
        BDUploadLog.d(TAG, String.format("----do parse internal what:%d info:%s", new Object[]{Integer.valueOf(r6), r7}));
        if (r7 != null) goto L5;
        return;
    L5:
        if (r6 == 0) goto L7;
    L11:
        if (r6 == 1) goto L13;
    L15:
        BDUploadLog.d(TAG, String.format("****do parse internal end", new Object[0]));
        return;
    L13:
        if (this.mParsers[1] != null) goto L15;
        BDUploadLog.d(TAG, String.format("create backup dns type:%d host:%s", new Object[]{Integer.valueOf(this.mMainType), r7.mHost}));
        this.mStates[1] = 1;
        this.mParsers[1] = createDNSParser(r7.mHost, this.mBackUpType, 1);
        this.mParsers[1].start();
        goto L15
    L7:
        if (this.mParsers[0] != null) goto L11;
        BDUploadLog.d(TAG, String.format("create main dns type:%d host:%s", new Object[]{Integer.valueOf(this.mMainType), r7.mHost}));
        this.mStates[0] = 1;
        this.mParsers[0] = createDNSParser(r7.mHost, this.mMainType, 0);
        this.mParsers[0].start();
        Message r8 = new Message();
        r8.what = 1;
        r8.obj = r7;
        if (this.mBackUpDelayedTime <= 0) goto L15;
        BDUploadLog.d(TAG, String.format("BackUpDelayedTime:%d send backup delay first", new Object[]{Integer.valueOf(this.mMainType)}));
        this.mHandler.sendMessageDelayed(r8, this.mBackUpDelayedTime * 1000);
        goto L15
    }

    public boolean isEnd() {
        int r1 = 0;
    L4:
        if (r1 >= 2) goto L13;
        if (this.mParsers[r1] == null) goto L12;
        int[] r3 = this.mStates;
        if (r3[r1] == 3) goto L12;
        if (r3[r1] == 2) goto L12;
        return false;
    L12:
        r1 = r1 + 1;
        goto L4
    L13:
        BDUploadLog.d(TAG, "all dns parse is end");
        return true;
    }

    public boolean isValidSourceId(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L7;
        String r7 = String.format("id: %s is empty", new Object[]{r8});
    L5:
        BDUploadLog.d(TAG, r7);
        return false;
    L7:
        int r0 = 0;
    L9:
        if (r0 >= 2) goto L17;
        BaseDNS[] r5 = this.mParsers;
        if (r5[r0] == null) goto L16;
        if (r8.equals(r5[r0].mId) == false) goto L16;
        BDUploadLog.d(TAG, String.format("id: %s is valid index: %d", new Object[]{r8, Integer.valueOf(r0)}));
        return true;
    L16:
        r0 = r0 + 1;
        goto L9
    L17:
        r7 = String.format("id: %s is valid", new Object[]{r8});
        goto L5
    }

    public void processMsg(int r8, BDUploadDNSInfo r9) {
        BDUploadLog.d(TAG, String.format("----processor pro msg what:%d host:%s info:%s", new Object[]{Integer.valueOf(r8), r9.mHost, r9}));
        if (r8 == 0) goto L16;
        if (r8 != 1) goto L19;
        int[] r1 = this.mStates;
        if (r1[0] == 1) goto L13;
        if (r1[0] == 2) goto L13;
        if (r1[0] != 3) goto L19;
    L13:
        if (r1[1] != 0) goto L19;
        String r2 = String.format("main dns is not end and backup dns is idle call backup dns", new Object[0]);
    L18:
        BDUploadLog.d(TAG, r2);
        doParseInternal(r8, r9);
    L19:
        BDUploadLog.d(TAG, String.format("****end processor pro msg what:%d host:%s info:%s", new Object[]{Integer.valueOf(r8), r9.mHost, r9}));
        return;
    L16:
        if (this.mStates[0] != 0) goto L19;
        r2 = String.format("main dns is idle call main dns", new Object[0]);
        goto L18
    }

    public void processResult(int r14, BDUploadDNSInfo r15) {
        BDUploadLog.d(TAG, String.format("----process result what:%d id:%s host:%s", new Object[]{Integer.valueOf(r14), r15.mId, r15.mHost}));
        if (r14 == 2) goto L6;
        if (r14 == 3) goto L6;
    L8:
        String r6 = null;
    L10:
        if (TextUtils.isEmpty(r6) == false) goto L14;
        String r13 = String.format("****process result err id is empty", new Object[0]);
    L12:
        BDUploadLog.d(TAG, r13);
        return;
    L14:
        int r7 = 0;
    L15:
        if (r7 >= 2) goto L27;
        BaseDNS[] r8 = this.mParsers;
        if (r8[r7] == null) goto L26;
        if (r6.equals(r8[r7].mId) == false) goto L26;
        this.mParsers[r7].close();
        this.mParsers[r7] = null;
        if (r14 != 3) goto L23;
        this.mStates[r7] = 3;
    L25:
        BDUploadLog.d(TAG, String.format("****process result parser index:%d is end, be close", new Object[]{Integer.valueOf(r7)}));
        goto L27
    L23:
        if (r14 != 2) goto L25;
        this.mStates[r7] = 2;
    L26:
        r7 = r7 + 1;
    L27:
        if (r7 != 0) goto L30;
        if (r14 != 2) goto L30;
        BDUploadLog.d(TAG, String.format("mian dns parse error, try back up dns", new Object[0]));
        processMsg(1, new BDUploadDNSInfo(BDUploadDNSParser.mGlobalBackType, r15.mHost, null, 0, null));
    L30:
        r13 = String.format("****end process result what:%d id:%s host:%s", new Object[]{Integer.valueOf(r14), r15.mId, r15.mHost});
    L6:
        if (r15 == null) goto L8;
        r6 = r15.mId;
        goto L10
    }
}

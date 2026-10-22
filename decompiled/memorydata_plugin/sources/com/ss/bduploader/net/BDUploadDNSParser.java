package com.ss.bduploader.net;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.bduploader.BDUploadLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes6.dex */
public class BDUploadDNSParser {
    public static final int BDUPLOAD_DNS_BACKUP_TYPE = 1;
    public static final int BDUPLOAD_DNS_DEFAULT_EXPIRED_TIME = 2;
    public static final int BDUPLOAD_DNS_MAIN_DELAYED_USE_BACKUP_TIME = 3;
    public static final int BDUPLOAD_DNS_MAIN_TYPE = 0;
    public static final int DNS_TYPE_HTTP_ALI = 1;
    public static final int DNS_TYPE_HTTP_GOOGLE = 3;
    public static final int DNS_TYPE_HTTP_OWN = 2;
    public static final int DNS_TYPE_LOCAL = 0;
    public static final int MSG_IS_PARSER_ERROR = 2;
    public static final int MSG_IS_PARSER_RETRY = 1;
    public static final int MSG_IS_PARSER_SUCCESS = 3;
    public static final int PARSER_IS_BACKUP = 1;
    public static final int PARSER_IS_MAIN = 0;
    private static final String TAG = "BDUploadDNSParser";
    public static int mGlobalBackType = 2;
    public static int mGlobalBackUpDelayedTime = 0;
    public static int mGlobalDefaultExpiredTime = 60;
    public static int mGlobalMainType;
    private static BDUploadDNSParser mInstance;
    private Handler mHandler;
    private Lock mLock;
    private Map<String, BDUploadHostProcessor> mProcessors;
    private int mRefCount;
    private int mState;
    private HandlerThread mThread;
    private int mTimeOut;
    private int mType;

    static {
    }

    public BDUploadDNSParser() {
        this.mTimeOut = 5;
        this.mLock = new ReentrantLock();
        this.mProcessors = new HashMap();
        HandlerThread r0 = new HandlerThread(TAG);
        this.mThread = r0;
        r0.start();
        final Looper r1 = this.mThread.getLooper();
        this.mHandler = new AnonymousClass1(this, r1);
    }

    static /* synthetic */ void access$000(BDUploadDNSParser r0, int r1, BDUploadDNSInfo r2) {
        r0.processParseMsg(r1, r2);
    }

    static /* synthetic */ void access$100(BDUploadDNSParser r0, int r1, BDUploadDNSInfo r2) {
        r0.proccessFailMsg(r1, r2);
    }

    static /* synthetic */ void access$200(BDUploadDNSParser r0, int r1, BDUploadDNSInfo r2) {
        r0.proccessSucMsg(r1, r2);
    }

    private void addListenerInternal(String r13, BDUploadDNSParserListener r14) {
        BDUploadDNSParserListener r15 = (BDUploadDNSParserListener) ZeusTransformUtils.wrapperContextForParams(r14, BDUploadDNSParserListener.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r13) == false) goto L5;
        return;
    L5:
        BDUploadLog.d(TAG, String.format("---add listener:%s for host:%s", new Object[]{r15, r13}));
        this.mLock.lock();
        BDUploadHostProcessor r0 = (BDUploadHostProcessor) ZeusTransformUtils.preCheckCast(this.mProcessors.get(r13), BDUploadHostProcessor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        BDUploadLog.d(TAG, String.format("get processor:%s", new Object[]{r0}));     // Catch: Throwable -> L19
        if (r0 != null) goto L9;
        r0 = new BDUploadHostProcessor(r13, this.mHandler, mGlobalMainType, mGlobalBackType, mGlobalBackUpDelayedTime);     // Catch: Throwable -> L19
        BDUploadLog.d(TAG, String.format("create processor:%s", new Object[]{r0}));     // Catch: Throwable -> L19
        boolean r1 = true;
    L10:
        if (r15 != null) goto L12;
    L14:
        this.mProcessors.put(r13, r0);     // Catch: Throwable -> L19
        if (r1 == false) goto L17;
        BDUploadLog.d(TAG, String.format("new processor implement parse", new Object[0]));     // Catch: Throwable -> L19
        r0.processMsg(0, new BDUploadDNSInfo(mGlobalMainType, r13, null, 0, null));     // Catch: Throwable -> L19
    L17:
        this.mLock.unlock();
        BDUploadLog.d(TAG, String.format("****end add listener", new Object[0]));
        return;
    L12:
        if (r0.mListeners.containsKey(r15) == true) goto L14;
        BDUploadLog.d(TAG, String.format("add listener", new Object[0]));     // Catch: Throwable -> L19
        r0.mListeners.put(r15, 1);     // Catch: Throwable -> L19
        goto L14
    L9:
        r1 = false;
    L19:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public static BDUploadDNSParser getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(BDUploadDNSParser.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new BDUploadDNSParser();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BDUploadDNSParser.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private void proccessFailMsg(int r17, BDUploadDNSInfo r18) {
        if (r18 != null) goto L5;
    L28:
        String r0 = String.format("proc fail msg  fail, info or host is null", new Object[0]);
    L23:
        BDUploadLog.d(TAG, r0);
        return;
    L5:
        if (r18.mHost == null) goto L28;
        BDUploadLog.d(TAG, String.format("----proc fail msg what:%d host:%s", new Object[]{Integer.valueOf(r17), r18.mHost}));
        this.mLock.lock();
        BDUploadHostProcessor r6 = (BDUploadHostProcessor) ZeusTransformUtils.preCheckCast(this.mProcessors.get(r18.mHost), BDUploadHostProcessor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        BDUploadLog.d(TAG, String.format("get processor:%s host:%s", new Object[]{r6, r18.mHost}));     // Catch: Throwable -> L25
        if (r6 != null) goto L11;
    L22:
        this.mLock.unlock();
        r0 = String.format("****end proc fail msg what", new Object[0]);
        goto L23
    L11:
        if (r6.isValidSourceId(r18.mId) == false) goto L22;
        r6.processResult(r17, r18);     // Catch: Throwable -> L25
        if (r6.isEnd() == false) goto L21;
        BDUploadLog.d(TAG, String.format("processor end, notify result", new Object[0]));     // Catch: Throwable -> L25
        Iterator<BDUploadDNSParserListener> r5 = r6.mListeners.keySet().iterator();     // Catch: Throwable -> L25
    L16:
        if (r5.hasNext() == false) goto L20;
        BDUploadDNSParserListener r9 = (BDUploadDNSParserListener) ZeusTransformUtils.preCheckCast(r5.next(), BDUploadDNSParserListener.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r9 == null) goto L16;
        BDUploadLog.d(TAG, String.format("listener:%s oncompletion fail", new Object[]{r9}));     // Catch: Throwable -> L25
        r9.onCompletion(0, r18.mHost, null, 0, null);     // Catch: Throwable -> L25
        goto L16
    L20:
        r6.mListeners.clear();     // Catch: Throwable -> L25
        this.mProcessors.remove(r18.mHost);     // Catch: Throwable -> L25
        goto L22
    L21:
        BDUploadLog.d(TAG, String.format("processor is not end", new Object[0]));     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    private void proccessSucMsg(int r14, BDUploadDNSInfo r15) {
        if (r15 != null) goto L5;
    L25:
        String r13 = String.format("proc suc msg  fail, info or host is null", new Object[0]);
    L20:
        BDUploadLog.d(TAG, r13);
        return;
    L5:
        if (r15.mHost == null) goto L25;
        BDUploadLog.d(TAG, String.format("----proc suc msg what:%d host:%s", new Object[]{Integer.valueOf(r14), r15.mHost}));
        this.mLock.lock();
        BDUploadHostProcessor r16 = (BDUploadHostProcessor) ZeusTransformUtils.preCheckCast(this.mProcessors.get(r15.mHost), BDUploadHostProcessor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        BDUploadLog.d(TAG, String.format("get processor:%s host:%s", new Object[]{r16, r15.mHost}));     // Catch: Throwable -> L22
        if (r16 != null) goto L11;
    L19:
        this.mLock.unlock();
        r13 = String.format("****end proc suc msg", new Object[0]);
        goto L20
    L11:
        if (r16.mListeners == null) goto L19;
        Iterator<BDUploadDNSParserListener> r3 = r16.mListeners.keySet().iterator();     // Catch: Throwable -> L22
    L14:
        if (r3.hasNext() == false) goto L18;
        BDUploadDNSParserListener r6 = (BDUploadDNSParserListener) ZeusTransformUtils.preCheckCast(r3.next(), BDUploadDNSParserListener.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r6 == null) goto L14;
        BDUploadLog.d(TAG, String.format("listener:%s oncompletion suc", new Object[]{r6}));     // Catch: Throwable -> L22
        r6.onCompletion(0, r15.mHost, r15.mIpList, r15.mExpiredTime, null);     // Catch: Throwable -> L22
        goto L14
    L18:
        r16.mListeners.clear();     // Catch: Throwable -> L22
        this.mProcessors.remove(r15.mHost);     // Catch: Throwable -> L22
        BDUploadLog.d(TAG, String.format("remove all listeners and remove host", new Object[0]));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    private void processParseMsg(int r8, BDUploadDNSInfo r9) {
        if (r9 != null) goto L5;
    L18:
        String r7 = String.format("proc parser msg  fail, info or host is null", new Object[0]);
    L13:
        BDUploadLog.d(TAG, r7);
        return;
    L5:
        if (r9.mHost == null) goto L18;
        BDUploadLog.d(TAG, String.format("----proc parser msg what:%d host:%s", new Object[]{Integer.valueOf(r8), r9.mHost}));
        this.mLock.lock();
        BDUploadHostProcessor r3 = (BDUploadHostProcessor) ZeusTransformUtils.preCheckCast(this.mProcessors.get(r9.mHost), BDUploadHostProcessor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r3 == null) goto L11;
        BDUploadLog.d(TAG, String.format("----get processor:%s host:%s", new Object[]{r3, r9.mHost}));     // Catch: Throwable -> L15
        r3.processMsg(r8, r9);     // Catch: Throwable -> L15
    L12:
        this.mLock.unlock();
        r7 = String.format("****end proc parser msg", new Object[0]);
        goto L13
    L11:
        BDUploadLog.d(TAG, String.format("****get processor null for host:%s", new Object[]{r9.mHost}));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    private void removeListenerInternal(String r7, BDUploadDNSParserListener r8) {
        BDUploadDNSParserListener r9 = (BDUploadDNSParserListener) ZeusTransformUtils.wrapperContextForParams(r8, BDUploadDNSParserListener.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r7) == true) goto L19;
        if (r9 == null) goto L22;
        BDUploadLog.d(TAG, String.format("---remove listener:%s for host:%s", new Object[]{r9, r7}));
        this.mLock.lock();
        BDUploadHostProcessor r0 = (BDUploadHostProcessor) ZeusTransformUtils.preCheckCast(this.mProcessors.get(r7), BDUploadHostProcessor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        BDUploadLog.d(TAG, String.format("get processor:%s", new Object[]{r0}));     // Catch: Throwable -> L16
        if (r0 == null) goto L10;
        BDUploadLog.d(TAG, String.format("remove listener", new Object[0]));     // Catch: Throwable -> L16
        r0.mListeners.remove(r9);     // Catch: Throwable -> L16
    L10:
        if (r0 != null) goto L12;
    L14:
        this.mLock.unlock();
        BDUploadLog.d(TAG, String.format("****end remove listener", new Object[0]));
        return;
    L12:
        if (r0.mListeners.size() != 0) goto L14;
        BDUploadLog.d(TAG, String.format("listeners empty remove host from processors", new Object[0]));     // Catch: Throwable -> L16
        this.mProcessors.remove(r7);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    L22:
        return;
    }

    public static void setIntValue(int r4, int r5) {
        BDUploadLog.d(TAG, String.format("****set value:%d for key:%d", new Object[]{Integer.valueOf(r5), Integer.valueOf(r4)}));
        if (r4 == 0) goto L12;
        if (r4 == 1) goto L11;
        if (r4 != 2) goto L7;
        mGlobalDefaultExpiredTime = r5;
        return;
    L7:
        if (r4 != 3) goto L17;
        mGlobalBackUpDelayedTime = r5;
        return;
    L17:
        return;
    L11:
        mGlobalBackType = r5;
        return;
    L12:
        mGlobalMainType = r5;
    }

    public void addHost(String r3, BDUploadDNSParserListener r4) {
        addListenerInternal(r3, (BDUploadDNSParserListener) ZeusTransformUtils.wrapperContextForParams(r4, BDUploadDNSParserListener.class, "com.obric.memorydata.plugin"));
    }

    public void postParseHostMsg(String r9, int r10) {
        BDUploadDNSInfo r7 = new BDUploadDNSInfo(r10, r9, null, 0, null);
        Message r11 = new Message();
        r11.what = 0;
        r11.obj = r7;
        this.mHandler.sendMessage(r11);
    }

    public void release() {
    }

    public void removeHost(String r3, BDUploadDNSParserListener r4) {
        removeListenerInternal(r3, (BDUploadDNSParserListener) ZeusTransformUtils.wrapperContextForParams(r4, BDUploadDNSParserListener.class, "com.obric.memorydata.plugin"));
    }
}

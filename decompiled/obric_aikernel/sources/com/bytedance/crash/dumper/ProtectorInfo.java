package com.bytedance.crash.dumper;

import com.bytedance.crash.Global;
import com.bytedance.crash.util.DateUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* JADX INFO: loaded from: classes.dex */
public class ProtectorInfo {
    private static final String HISTORY_FILE_NAME = "protector_history.txt";
    private static final String LOG_TAG = "NPTH_PROT";
    private File mDumpDir;
    private String mFormattedContent;
    private boolean mHasHistory;
    private boolean mIsFinalPerformed;
    private boolean mIsPerformed;
    private String mOriginScope;
    private int mPerformedCount;
    private String mPreviousScope;
    private String mScope;
    private String mSid;
    private int mTotalPerformedCount;

    public ProtectorInfo(File r10) {
        this.mDumpDir = null;
        this.mHasHistory = false;
        this.mSid = null;
        this.mPerformedCount = 0;
        this.mTotalPerformedCount = 0;
        this.mIsPerformed = false;
        this.mIsFinalPerformed = false;
        this.mOriginScope = null;
        this.mPreviousScope = null;
        this.mScope = null;
        this.mFormattedContent = null;
        this.mDumpDir = r10;
    }

    public void dump() {
        if (this.mDumpDir != null) goto L5;
        return;
    L5:
        if (this.mFormattedContent == null) goto L12;
        FileUtils.writeFile(new File(this.mDumpDir, HISTORY_FILE_NAME), this.mFormattedContent, false);     // Catch: Throwable -> L8
        NpthLog.i(LOG_TAG, "dump history file: " + this.mDumpDir.getName());     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    public String getOriginScope() {
        return this.mOriginScope;
    }

    public int getPerformedCount() {
        return this.mPerformedCount;
    }

    public String getPreviousScope() {
        return this.mPreviousScope;
    }

    public String getScope() {
        return this.mScope;
    }

    public String getSid() {
        return this.mSid;
    }

    public int getTotalPerformedCount() {
        return this.mTotalPerformedCount;
    }

    public boolean hasHistory() {
        return this.mHasHistory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean init() {
        char r10 = 0;
        if (this.mDumpDir != null) goto L5;
        return false;
    L5:
        File r11 = new File(Global.getRootDirectory(), HISTORY_FILE_NAME);
        if (r11.exists() == false) goto L82;
        if (r11.length() == 0) goto L82;
        String[] r12 = this.mDumpDir.getName().split("-");     // Catch: Throwable -> L79
        if (r12.length != 1) goto L15;
        long r13 = Long.parseLong(r12[0]);     // Catch: Throwable -> L79
        File r14 = this.mDumpDir.getParentFile();     // Catch: Throwable -> L79
        if (r14 == null) goto L16;
        r12 = r14.getName().split("-");     // Catch: Throwable -> L79
    L16:
        char r15 = 3;
        char r16 = 2;
        if (r12.length != 2) goto L19;
    L21:
        long r17 = Long.parseLong(r12[0]);     // Catch: Throwable -> L79
        int r18 = Integer.parseInt(r12[1]);     // Catch: Throwable -> L79
        if (r12.length != 3) goto L24;
        this.mPerformedCount = Integer.parseInt(r12[2]);     // Catch: Throwable -> L79
        this.mIsPerformed = true;     // Catch: Throwable -> L79
    L24:
        BufferedReader r19 = new BufferedReader(new FileReader(r11));     // Catch: Throwable -> L79
        String r20 = r19.readLine();     // Catch: Throwable -> L79
        if (r20 == null) goto L78;
        if (r20.equals("V002") == false) goto L78;
        StringBuilder r21 = null;
    L30:
        String r110 = r19.readLine();     // Catch: Throwable -> L79
        if (r110 == null) goto L93;
        String[] r111 = r110.split(" ");     // Catch: Throwable -> L79
        if (r111.length == 5) goto L91;
    L35:
        char r112 = r16;
    L67:
        r16 = r112;
        r10 = 0;
        r15 = 3;
        goto L30
    L91:
        long r22 = Long.parseLong(r111[r10]);     // Catch: Throwable -> L83
        long r113 = Long.parseLong(r111[1]);     // Catch: Throwable -> L83
        int r114 = Integer.parseInt(r111[r16]);     // Catch: Throwable -> L83
        int r23 = Integer.parseInt(r111[r15]);     // Catch: Throwable -> L83
        String r24 = r111[4];     // Catch: Throwable -> L83
        if (r114 != r18) goto L35;
        if (r22 < r17) goto L35;
        if (r13 == 0) goto L43;
    L44:
        if (r13 != 0) goto L46;
    L48:
        this.mTotalPerformedCount = r23;     // Catch: Throwable -> L83
        if (r23 != 1) goto L52;
        this.mOriginScope = r24;     // Catch: Throwable -> L83
    L52:
        if (this.mIsPerformed == true) goto L54;
        this.mPerformedCount = r23;     // Catch: Throwable -> L83
        this.mPreviousScope = r24;     // Catch: Throwable -> L83
    L61:
        if (r21 == null) goto L89;
        r112 = 2;
    L66:
        r21.append("No.");     // Catch: Throwable -> L84
        r21.append(r23);     // Catch: Throwable -> L84
        r21.append("\n  time: ");     // Catch: Throwable -> L84
        r21.append(DateUtils.formatDateMs(r22));     // Catch: Throwable -> L84
        r21.append("\n  scope: ");     // Catch: Throwable -> L84
        r21.append(r24);     // Catch: Throwable -> L84
        r21.append("\n");     // Catch: Throwable -> L84
        goto L67
    L89:
        this.mHasHistory = true;     // Catch: Throwable -> L58
        StringBuilder r115 = new StringBuilder();     // Catch: Throwable -> L58
        r115.append(r111[1]);     // Catch: Throwable -> L58
        r115.append('-');     // Catch: Throwable -> L58
        r112 = 2;
        r115.append(r111[2]);     // Catch: Throwable -> L84
        this.mSid = r115.toString();     // Catch: Throwable -> L84
        r21 = new StringBuilder();     // Catch: Throwable -> L84
    L58:
        r112 = 2;
        goto L67
    L54:
        int r116 = this.mPerformedCount;     // Catch: Throwable -> L83
        if (r116 != (r23 + 1)) goto L59;
        this.mPreviousScope = r24;     // Catch: Throwable -> L58
        goto L61
    L59:
        if (r116 != r23) goto L61;
        this.mScope = r24;     // Catch: Throwable -> L58
        goto L61
    L46:
        if (r22 <= r13) goto L48;
    L43:
        if (r113 != r17) goto L35;
    L93:
    L76:
        return false;
    L69:
        if (this.mIsPerformed == true) goto L71;
    L73:
        if (r21 == null) goto L75;
        this.mFormattedContent = ("sid: " + this.mSid + "\nperformed_count: " + this.mPerformedCount + "\ntotal_performed_count: " + this.mTotalPerformedCount + "\n--- --- ---\n") + r21.toString();     // Catch: Throwable -> L76
    L75:
        return true;
    L71:
        if (this.mPerformedCount != this.mTotalPerformedCount) goto L73;
        this.mIsFinalPerformed = true;     // Catch: Throwable -> L76
    L78:
        return false;
    L19:
        if (r12.length == 3) goto L21;
        return false;
    L15:
        r13 = 0;
    L80:
        return r10;
    L82:
        return false;
    }

    public boolean isFinalPerformed() {
        return this.mIsFinalPerformed;
    }

    public boolean isPerformed() {
        return this.mIsPerformed;
    }
}

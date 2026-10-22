package com.bytedance.crash.dumper;

import com.bytedance.crash.Global;
import com.bytedance.crash.util.DateUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* JADX INFO: loaded from: classes2.dex */
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

    public ProtectorInfo(File r3) {
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
        this.mDumpDir = r3;
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
        char r3 = 0;
        if (this.mDumpDir != null) goto L5;
        return false;
    L5:
        File r2 = new File(Global.getRootDirectory(), HISTORY_FILE_NAME);
        if (r2.exists() == false) goto L82;
        if (r2.length() == 0) goto L82;
        String[] r4 = this.mDumpDir.getName().split("-");     // Catch: Throwable -> L79
        if (r4.length != 1) goto L15;
        long r9 = Long.parseLong(r4[0]);     // Catch: Throwable -> L79
        File r5 = this.mDumpDir.getParentFile();     // Catch: Throwable -> L79
        if (r5 == null) goto L16;
        r4 = r5.getName().split("-");     // Catch: Throwable -> L79
    L16:
        char r6 = 3;
        char r11 = 2;
        if (r4.length != 2) goto L19;
    L21:
        long r12 = Long.parseLong(r4[0]);     // Catch: Throwable -> L79
        int r1 = Integer.parseInt(r4[1]);     // Catch: Throwable -> L79
        if (r4.length != 3) goto L24;
        this.mPerformedCount = Integer.parseInt(r4[2]);     // Catch: Throwable -> L79
        this.mIsPerformed = true;     // Catch: Throwable -> L79
    L24:
        BufferedReader r7 = new BufferedReader(new FileReader(r2));     // Catch: Throwable -> L79
        String r8 = r7.readLine();     // Catch: Throwable -> L79
        if (r8 == null) goto L78;
        if (r8.equals("V002") == false) goto L78;
        StringBuilder r10 = null;
    L30:
        String r14 = r7.readLine();     // Catch: Throwable -> L79
        if (r14 == null) goto L91;
        String[] r15 = r14.split(" ");     // Catch: Throwable -> L79
        if (r15.length == 5) goto L89;
    L35:
        char r16 = r11;
    L67:
        r11 = r16;
        r3 = 0;
        r6 = 3;
        goto L30
    L89:
        long r13 = Long.parseLong(r15[r3]);     // Catch: Throwable -> L83
        long r18 = Long.parseLong(r15[1]);     // Catch: Throwable -> L83
        int r17 = Integer.parseInt(r15[r11]);     // Catch: Throwable -> L83
        int r19 = Integer.parseInt(r15[r6]);     // Catch: Throwable -> L83
        String r20 = r15[4];     // Catch: Throwable -> L83
        if (r17 != r1) goto L35;
        if (r13 < r12) goto L35;
        if (r9 == 0) goto L43;
    L44:
        if (r9 != 0) goto L46;
    L48:
        this.mTotalPerformedCount = r19;     // Catch: Throwable -> L83
        if (r19 != 1) goto L52;
        this.mOriginScope = r20;     // Catch: Throwable -> L83
    L52:
        if (this.mIsPerformed == true) goto L54;
        this.mPerformedCount = r19;     // Catch: Throwable -> L83
        this.mPreviousScope = r20;     // Catch: Throwable -> L83
    L61:
        if (r10 == null) goto L87;
        r16 = 2;
    L66:
        r10.append("No.").append(r19).append("\n  time: ").append(DateUtils.formatDateMs(r13)).append("\n  scope: ").append(r20).append("\n");     // Catch: Throwable -> L84
        goto L67
    L87:
        this.mHasHistory = true;     // Catch: Throwable -> L58
        r16 = 2;
        this.mSid = new StringBuilder().append(r15[1]).append('-').append(r15[2]).toString();     // Catch: Throwable -> L84
        r10 = new StringBuilder();     // Catch: Throwable -> L84
    L58:
        r16 = 2;
        goto L67
    L54:
        int r110 = this.mPerformedCount;     // Catch: Throwable -> L83
        if (r110 != (r19 + 1)) goto L59;
        this.mPreviousScope = r20;     // Catch: Throwable -> L58
        goto L61
    L59:
        if (r110 != r19) goto L61;
        this.mScope = r20;     // Catch: Throwable -> L58
        goto L61
    L46:
        if (r13 <= r9) goto L48;
    L43:
        if (r18 != r12) goto L35;
    L91:
    L76:
        return false;
    L69:
        if (this.mIsPerformed == true) goto L71;
    L73:
        if (r10 == null) goto L75;
        this.mFormattedContent = ("sid: " + this.mSid + "\nperformed_count: " + this.mPerformedCount + "\ntotal_performed_count: " + this.mTotalPerformedCount + "\n--- --- ---\n") + r10.toString();     // Catch: Throwable -> L76
    L75:
        return true;
    L71:
        if (this.mPerformedCount != this.mTotalPerformedCount) goto L73;
        this.mIsFinalPerformed = true;     // Catch: Throwable -> L76
    L78:
        return false;
    L19:
        if (r4.length == 3) goto L21;
        return false;
    L15:
        r9 = 0;
    L80:
        return r3;
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

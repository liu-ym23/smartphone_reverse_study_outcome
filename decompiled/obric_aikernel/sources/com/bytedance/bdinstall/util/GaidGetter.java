package com.bytedance.bdinstall.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;

/* JADX INFO: loaded from: classes.dex */
public class GaidGetter {
    private static volatile Pair<String, Boolean> sGaidPair;
    private static GaidMonitor sMonitor;

    public static class GaidMonitor {
        private long mFileLoadBeginTime;
        private long mFileLoadEndTime;
        private long mFileSaveBeginTime;
        private long mFileSaveEndTime;
        private String mGaid;
        private boolean mGaidLimited;
        private long mSysCallBeginTime;
        private long mSysCallEndTime;
        private boolean mUsed;

        public GaidMonitor() {
            this.mGaid = null;
        }

        static /* synthetic */ void access$000(GaidMonitor r10) {
            r10.onSysCallBegin();
        }

        static /* synthetic */ void access$100(GaidMonitor r10) {
            r10.onSysCallEnd();
        }

        static /* synthetic */ void access$200(GaidMonitor r10, String r11) {
            r10.setGaid(r11);
        }

        static /* synthetic */ void access$300(GaidMonitor r10, boolean r11) {
            r10.setGaidLimited(r11);
        }

        static /* synthetic */ void access$400(GaidMonitor r10) {
            r10.onFileLoadBegin();
        }

        static /* synthetic */ void access$500(GaidMonitor r10) {
            r10.onFileLoadEnd();
        }

        static /* synthetic */ void access$600(GaidMonitor r10) {
            r10.onFileSaveBegin();
        }

        static /* synthetic */ void access$700(GaidMonitor r10) {
            r10.onFileSaveEnd();
        }

        private void onFileLoadBegin() {
            this.mFileLoadBeginTime = System.currentTimeMillis();
        }

        private void onFileLoadEnd() {
            this.mFileLoadEndTime = System.currentTimeMillis();
        }

        private void onFileSaveBegin() {
            this.mFileSaveBeginTime = System.currentTimeMillis();
        }

        private void onFileSaveEnd() {
            this.mFileSaveEndTime = System.currentTimeMillis();
        }

        private void onSysCallBegin() {
            this.mSysCallBeginTime = System.currentTimeMillis();
        }

        private void onSysCallEnd() {
            this.mSysCallEndTime = System.currentTimeMillis();
        }

        private void setGaid(String r10) {
        }

        private void setGaidLimited(boolean r10) {
            this.mGaidLimited = r10;
        }

        public long getFileLoadTs() {
            return this.mFileLoadEndTime - this.mFileLoadBeginTime;
        }

        public long getFileSaveTs() {
            return this.mFileSaveEndTime - this.mFileSaveBeginTime;
        }

        public String getGaid() {
            return this.mGaid;
        }

        public long getSysCallTs() {
            return this.mSysCallEndTime - this.mSysCallBeginTime;
        }

        public boolean isCache() {
            return this.mUsed;
        }

        public boolean isGaidLimited() {
            return this.mGaidLimited;
        }

        public void markUsed() {
            this.mUsed = true;
        }
    }

    static {
    }

    public GaidGetter() {
    }

    public static void clearSp(Context r10, InstallOptions r11) {
        LocalConstants.getCommonSp(r10, r11).edit().remove("google_aid").remove("gaid_limited").apply();
    }

    public static Pair<String, Boolean> getGaid(Context r10, InstallOptions r11) {
        if (isValidPair(sGaidPair) == true) goto L26;
        monitor-enter(GaidGetter.class);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (isValidPair(sGaidPair) == false) goto L11;
        Pair<String, Boolean> r12 = sGaidPair;     // Catch: Throwable -> L22
        monitor-exit(GaidGetter.class);     // Catch: Throwable -> L22
        return r12;
    L11:
        GaidMonitor r13 = new GaidMonitor();     // Catch: Throwable -> L22
        sMonitor = r13;     // Catch: Throwable -> L22
        GaidMonitor.access$000(r13);     // Catch: Throwable -> L22
        Pair<String, Boolean> r14 = getGoogleAdid(r11);     // Catch: Throwable -> L22
        GaidMonitor.access$100(sMonitor);     // Catch: Throwable -> L22
        GaidMonitor.access$200(sMonitor, (String) r14.first);     // Catch: Throwable -> L22
        GaidMonitor.access$300(sMonitor, ((Boolean) r14.second).booleanValue());     // Catch: Throwable -> L22
        String r15 = (String) r14.first;     // Catch: Throwable -> L22
        boolean r16 = ((Boolean) r14.second).booleanValue();     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r15) == false) goto L14;
        DrLog.e("Gaid#getGaid failed . rst = " + r14);     // Catch: Throwable -> L22
        GaidMonitor.access$400(sMonitor);     // Catch: Throwable -> L22
        SharedPreferences r17 = LocalConstants.getCommonSp(r10, r11);     // Catch: Throwable -> L22
        r15 = r17.getString("google_aid", null);     // Catch: Throwable -> L22
        r16 = r17.getBoolean("gaid_limited", false);     // Catch: Throwable -> L22
        GaidMonitor.access$500(sMonitor);     // Catch: Throwable -> L22
    L19:
        sGaidPair = new Pair(r15, Boolean.valueOf(r16));     // Catch: Throwable -> L22
        monitor-exit(GaidGetter.class);     // Catch: Throwable -> L22
        goto L26
    L14:
        GaidMonitor.access$600(sMonitor);     // Catch: Throwable -> L22
        SharedPreferences r18 = LocalConstants.getCommonSp(r10, r11);     // Catch: Throwable -> L22
        String r19 = r18.getString("google_aid", null);     // Catch: Throwable -> L22
        boolean r20 = r18.getBoolean("gaid_limited", false);     // Catch: Throwable -> L22
        if (TextUtils.equals(r19, r15) == false) goto L17;
        if (r20 != r16) goto L17;
    L18:
        GaidMonitor.access$700(sMonitor);     // Catch: Throwable -> L22
    L17:
        trySaveGoogleAid(r10, r11, r15, r16);     // Catch: Throwable -> L22
    L26:
        return sGaidPair;
    }

    private static Pair<String, Boolean> getGoogleAdid(InstallOptions r10) {
        return SensitiveUtils.getGoogleAdid(r10);
    L5:
        return new Pair(null, Boolean.FALSE);
    }

    public static GaidMonitor getMonitor() {
        return sMonitor;
    }

    private static boolean isValidPair(Pair<String, Boolean> r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.isEmpty((CharSequence) r10.first) == true) goto L6;
        return true;
    }

    private static void trySaveGoogleAid(Context r10, InstallOptions r11, String r12, boolean r13) {
        if (TextUtils.isEmpty(r12) == true) goto L8;
        if (r10 == null) goto L9;
        LocalConstants.getCommonSp(r10, r11).edit().putString("google_aid", r12).putBoolean("gaid_limited", r13).apply();
        return;
    L9:
        return;
    }
}

package com.bytedance.bdinstall.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

        static /* synthetic */ void access$000(GaidMonitor r0) {
            r0.onSysCallBegin();
        }

        static /* synthetic */ void access$100(GaidMonitor r0) {
            r0.onSysCallEnd();
        }

        static /* synthetic */ void access$200(GaidMonitor r0, String r1) {
            r0.setGaid(r1);
        }

        static /* synthetic */ void access$300(GaidMonitor r0, boolean r1) {
            r0.setGaidLimited(r1);
        }

        static /* synthetic */ void access$400(GaidMonitor r0) {
            r0.onFileLoadBegin();
        }

        static /* synthetic */ void access$500(GaidMonitor r0) {
            r0.onFileLoadEnd();
        }

        static /* synthetic */ void access$600(GaidMonitor r0) {
            r0.onFileSaveBegin();
        }

        static /* synthetic */ void access$700(GaidMonitor r0) {
            r0.onFileSaveEnd();
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

        private void setGaid(String r1) {
        }

        private void setGaidLimited(boolean r1) {
            this.mGaidLimited = r1;
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

    public static void clearSp(Context r2, InstallOptions r3) {
        LocalConstants.getCommonSp((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3).edit().remove("google_aid").remove("gaid_limited").apply();
    }

    public static Pair<String, Boolean> getGaid(Context r7, InstallOptions r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (isValidPair(sGaidPair) == true) goto L26;
        monitor-enter(GaidGetter.class);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (isValidPair(sGaidPair) == false) goto L11;
        Pair<String, Boolean> r10 = sGaidPair;     // Catch: Throwable -> L22
        monitor-exit(GaidGetter.class);     // Catch: Throwable -> L22
        return r10;
    L11:
        GaidMonitor r1 = new GaidMonitor();     // Catch: Throwable -> L22
        sMonitor = r1;     // Catch: Throwable -> L22
        GaidMonitor.access$000(r1);     // Catch: Throwable -> L22
        Pair<String, Boolean> r2 = getGoogleAdid(r8);     // Catch: Throwable -> L22
        GaidMonitor.access$100(sMonitor);     // Catch: Throwable -> L22
        GaidMonitor.access$200(sMonitor, (String) ZeusTransformUtils.preCheckCast(r2.first, String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L22
        GaidMonitor.access$300(sMonitor, ((Boolean) ZeusTransformUtils.preCheckCast(r2.second, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());     // Catch: Throwable -> L22
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.first, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        boolean r4 = ((Boolean) ZeusTransformUtils.preCheckCast(r2.second, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r3) == false) goto L14;
        DrLog.e("Gaid#getGaid failed . rst = " + r2);     // Catch: Throwable -> L22
        GaidMonitor.access$400(sMonitor);     // Catch: Throwable -> L22
        SharedPreferences r11 = LocalConstants.getCommonSp(r9, r8);     // Catch: Throwable -> L22
        r3 = r11.getString("google_aid", null);     // Catch: Throwable -> L22
        r4 = r11.getBoolean("gaid_limited", false);     // Catch: Throwable -> L22
        GaidMonitor.access$500(sMonitor);     // Catch: Throwable -> L22
    L19:
        sGaidPair = new Pair(r3, Boolean.valueOf(r4));     // Catch: Throwable -> L22
        monitor-exit(GaidGetter.class);     // Catch: Throwable -> L22
        goto L26
    L14:
        GaidMonitor.access$600(sMonitor);     // Catch: Throwable -> L22
        SharedPreferences r5 = LocalConstants.getCommonSp(r9, r8);     // Catch: Throwable -> L22
        String r6 = r5.getString("google_aid", null);     // Catch: Throwable -> L22
        boolean r12 = r5.getBoolean("gaid_limited", false);     // Catch: Throwable -> L22
        if (TextUtils.equals(r6, r3) == false) goto L17;
        if (r12 != r4) goto L17;
    L18:
        GaidMonitor.access$700(sMonitor);     // Catch: Throwable -> L22
    L17:
        trySaveGoogleAid(r9, r8, r3, r4);     // Catch: Throwable -> L22
    L26:
        return sGaidPair;
    }

    private static Pair<String, Boolean> getGoogleAdid(InstallOptions r2) {
        return SensitiveUtils.getGoogleAdid(r2);
    L5:
        return new Pair(null, false);
    }

    public static GaidMonitor getMonitor() {
        return sMonitor;
    }

    private static boolean isValidPair(Pair<String, Boolean> r2) {
        if (r2 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.first, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L6;
        return true;
    }

    private static void trySaveGoogleAid(Context r2, InstallOptions r3, String r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r4) == true) goto L8;
        if (r6 == null) goto L9;
        LocalConstants.getCommonSp(r6, r3).edit().putString("google_aid", r4).putBoolean("gaid_limited", r5).apply();
        return;
    L9:
        return;
    }
}

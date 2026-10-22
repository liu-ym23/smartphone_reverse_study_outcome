package com.bytedance.android.btm.impl.page.lifecycle;

import kotlin.Deprecated;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/btm/impl/page/lifecycle/ResumeFuncOrigin;", "", "", "isManual", "System", "ManualForward", "ManualBack", "ManualNotSure", "UserVisibleHint", "HybridRegister", "BackInternal", "Background", "BackActivity", "BackProcess", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final enum ResumeFuncOrigin extends Enum<ResumeFuncOrigin> {

    @Deprecated(message = "")
    public static final ResumeFuncOrigin BackActivity = null;
    public static final ResumeFuncOrigin BackInternal = null;

    @Deprecated(message = "")
    public static final ResumeFuncOrigin BackProcess = null;

    @Deprecated(message = "")
    public static final ResumeFuncOrigin Background = null;
    public static final ResumeFuncOrigin HybridRegister = null;
    public static final ResumeFuncOrigin ManualBack = null;
    public static final ResumeFuncOrigin ManualForward = null;
    public static final ResumeFuncOrigin ManualNotSure = null;
    public static final ResumeFuncOrigin System = null;
    public static final ResumeFuncOrigin UserVisibleHint = null;
    public static final /* synthetic */ ResumeFuncOrigin[] a = null;

    static {
        ResumeFuncOrigin r1 = new ResumeFuncOrigin("System", 0);
        System = r1;
        ResumeFuncOrigin r10 = new ResumeFuncOrigin("ManualForward", 1);
        ManualForward = r10;
        ResumeFuncOrigin r11 = new ResumeFuncOrigin("ManualBack", 2);
        ManualBack = r11;
        ResumeFuncOrigin r12 = new ResumeFuncOrigin("ManualNotSure", 3);
        ManualNotSure = r12;
        ResumeFuncOrigin r13 = new ResumeFuncOrigin("UserVisibleHint", 4);
        UserVisibleHint = r13;
        ResumeFuncOrigin r14 = new ResumeFuncOrigin("HybridRegister", 5);
        HybridRegister = r14;
        ResumeFuncOrigin r15 = new ResumeFuncOrigin("BackInternal", 6);
        BackInternal = r15;
        ResumeFuncOrigin r16 = new ResumeFuncOrigin("Background", 7);
        Background = r16;
        ResumeFuncOrigin r17 = new ResumeFuncOrigin("BackActivity", 8);
        BackActivity = r17;
        ResumeFuncOrigin r18 = new ResumeFuncOrigin("BackProcess", 9);
        BackProcess = r18;
        a = new ResumeFuncOrigin[]{r1, r10, r11, r12, r13, r14, r15, r16, r17, r18};
    }

    public static ResumeFuncOrigin valueOf(String r1) {
        return (ResumeFuncOrigin) a.a(ResumeFuncOrigin.class, r1);
    }

    public static ResumeFuncOrigin[] values() {
        return (ResumeFuncOrigin[]) a.clone();
    }

    public final boolean isManual() {
        if (ordinal() != ManualForward.ordinal()) goto L5;
    L10:
        return true;
    L5:
        if (ordinal() == ManualBack.ordinal()) goto L10;
        if (ordinal() == ManualNotSure.ordinal()) goto L10;
        return false;
    }

    public ResumeFuncOrigin(String r1, int r10) {
        super(r1, r10);
    }
}

package com.bytedance.android.btm.impl.page.lifecycle;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/btm/impl/page/lifecycle/ResumeFilterReason;", "", "PageStateDuplicate", "NativeStateError", "AppBackground", "NotTopActivity", "InfoStackNull", "ExecuteActivityResume", "IgnoreAShow", "FragmentNotAttach", "Invisible", "DialogNotShowing", "Other", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final enum ResumeFilterReason extends Enum<ResumeFilterReason> {
    public static final ResumeFilterReason AppBackground = null;
    public static final ResumeFilterReason DialogNotShowing = null;
    public static final ResumeFilterReason ExecuteActivityResume = null;
    public static final ResumeFilterReason FragmentNotAttach = null;
    public static final ResumeFilterReason IgnoreAShow = null;
    public static final ResumeFilterReason InfoStackNull = null;
    public static final ResumeFilterReason Invisible = null;
    public static final ResumeFilterReason NativeStateError = null;
    public static final ResumeFilterReason NotTopActivity = null;
    public static final ResumeFilterReason Other = null;
    public static final ResumeFilterReason PageStateDuplicate = null;
    public static final /* synthetic */ ResumeFilterReason[] a = null;

    static {
        ResumeFilterReason r1 = new ResumeFilterReason("PageStateDuplicate", 0);
        PageStateDuplicate = r1;
        ResumeFilterReason r10 = new ResumeFilterReason("NativeStateError", 1);
        NativeStateError = r10;
        ResumeFilterReason r11 = new ResumeFilterReason("AppBackground", 2);
        AppBackground = r11;
        ResumeFilterReason r12 = new ResumeFilterReason("NotTopActivity", 3);
        NotTopActivity = r12;
        ResumeFilterReason r13 = new ResumeFilterReason("InfoStackNull", 4);
        InfoStackNull = r13;
        ResumeFilterReason r14 = new ResumeFilterReason("ExecuteActivityResume", 5);
        ExecuteActivityResume = r14;
        ResumeFilterReason r15 = new ResumeFilterReason("IgnoreAShow", 6);
        IgnoreAShow = r15;
        ResumeFilterReason r16 = new ResumeFilterReason("FragmentNotAttach", 7);
        FragmentNotAttach = r16;
        ResumeFilterReason r17 = new ResumeFilterReason("Invisible", 8);
        Invisible = r17;
        ResumeFilterReason r18 = new ResumeFilterReason("DialogNotShowing", 9);
        DialogNotShowing = r18;
        ResumeFilterReason r19 = new ResumeFilterReason("Other", 10);
        Other = r19;
        a = new ResumeFilterReason[]{r1, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
    }

    public static ResumeFilterReason valueOf(String r1) {
        return (ResumeFilterReason) a.a(ResumeFilterReason.class, r1);
    }

    public static ResumeFilterReason[] values() {
        return (ResumeFilterReason[]) a.clone();
    }

    public ResumeFilterReason(String r1, int r10) {
        super(r1, r10);
    }
}

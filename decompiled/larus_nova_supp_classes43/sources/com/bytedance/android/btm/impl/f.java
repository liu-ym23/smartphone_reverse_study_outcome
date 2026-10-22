package com.bytedance.android.btm.impl;

import com.bytedance.android.btm.impl.page.lifecycle.ResumeFilterReason;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ResumeFilterReason.values().length];
        int[] r1 = new int[ResumeFilterReason.values().length];
        int[] r10 = new int[ResumeFilterReason.values().length];
        int[] r11 = new int[ResumeFilterReason.values().length];
        int[] r12 = new int[ResumeFilterReason.values().length];
        a = r12;
        r12[ResumeFilterReason.AppBackground.ordinal()] = 1;
        r12[ResumeFilterReason.NotTopActivity.ordinal()] = 2;
        r12[ResumeFilterReason.FragmentNotAttach.ordinal()] = 3;
        r12[ResumeFilterReason.Invisible.ordinal()] = 4;
        r12[ResumeFilterReason.NativeStateError.ordinal()] = 5;
    }
}

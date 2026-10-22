package com.bytedance.android.livesdk.interactivity.comment.newinput;

import com.bytedance.android.livesdk.interactivity.api.input.InputDialogFragmentSwitchType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[InputDialogFragmentSwitchType.values().length];
        a = r0;
        InputDialogFragmentSwitchType r1 = InputDialogFragmentSwitchType.SLIDE_RIGHT;
        r0[r1.ordinal()] = 1;
        InputDialogFragmentSwitchType r2 = InputDialogFragmentSwitchType.NONE;
        r0[r2.ordinal()] = 2;
        InputDialogFragmentSwitchType r4 = InputDialogFragmentSwitchType.FADE;
        r0[r4.ordinal()] = 3;
        int[] r3 = new int[InputDialogFragmentSwitchType.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        int[] r5 = new int[InputSectionType.values().length];
        c = r5;
        r5[InputSectionType.DANMAKU.ordinal()] = 1;
        r5[InputSectionType.WORD_ASSOCIATE.ordinal()] = 2;
        r5[InputSectionType.MENTION.ordinal()] = 3;
    }
}

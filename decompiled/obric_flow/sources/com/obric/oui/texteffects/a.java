package com.obric.oui.texteffects;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f14726a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f14727b = null;

    static {
        int[] r5 = new int[ODimPointEffectTextView.DimPointMode.values().length];
        r5[ODimPointEffectTextView.DimPointMode.PENDING.ordinal()] = 1;
        r5[ODimPointEffectTextView.DimPointMode.GENERATE.ordinal()] = 2;
        r5[ODimPointEffectTextView.DimPointMode.REWRITE.ordinal()] = 3;
        r5[ODimPointEffectTextView.DimPointMode.PROMPT_EXIT_TO_GENERATE.ordinal()] = 4;
        r5[ODimPointEffectTextView.DimPointMode.PROMPT_SWITCH.ordinal()] = 5;
        r5[ODimPointEffectTextView.DimPointMode.NONE.ordinal()] = 6;
        f14726a = r5;
        int[] r10 = new int[ODimPointEffectTextView.RewritePhase.values().length];
        r10[ODimPointEffectTextView.RewritePhase.EXITING_OLD_TEXT.ordinal()] = 1;
        r10[ODimPointEffectTextView.RewritePhase.ENTERING_NEW_TEXT.ordinal()] = 2;
        r10[ODimPointEffectTextView.RewritePhase.NONE.ordinal()] = 3;
        f14727b = r10;
    }
}

package br;

import com.obric.oui.coachmark.OCoachmarkView;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f978a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f979b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f980c = null;

    static {
        int[] r5 = new int[OCoachmarkView.ContentStyle.values().length];
        r5[OCoachmarkView.ContentStyle.PILL.ordinal()] = 1;
        r5[OCoachmarkView.ContentStyle.CARD.ordinal()] = 2;
        f978a = r5;
        int[] r10 = new int[OCoachmarkView.ActionStyle.values().length];
        r10[OCoachmarkView.ActionStyle.TEXT_ONLY.ordinal()] = 1;
        r10[OCoachmarkView.ActionStyle.FILLED_BUTTON.ordinal()] = 2;
        r10[OCoachmarkView.ActionStyle.NONE.ordinal()] = 3;
        f979b = r10;
        int[] r11 = new int[OCoachmarkView.ArrowPosition.values().length];
        r11[OCoachmarkView.ArrowPosition.TOP.ordinal()] = 1;
        r11[OCoachmarkView.ArrowPosition.BOTTOM.ordinal()] = 2;
        r11[OCoachmarkView.ArrowPosition.LEFT.ordinal()] = 3;
        r11[OCoachmarkView.ArrowPosition.RIGHT.ordinal()] = 4;
        f980c = r11;
    }
}

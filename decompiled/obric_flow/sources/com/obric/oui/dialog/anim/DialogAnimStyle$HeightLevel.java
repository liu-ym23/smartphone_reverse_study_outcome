package com.obric.oui.dialog.anim;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"com/obric/oui/dialog/anim/DialogAnimStyle$HeightLevel", "", "Lcom/obric/oui/dialog/anim/DialogAnimStyle$HeightLevel;", "", "maxRatio", "F", "getMaxRatio", "()F", "SMALL", "MEDIUM", "LARGE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum DialogAnimStyle$HeightLevel extends Enum<DialogAnimStyle$HeightLevel> {
    public static final DialogAnimStyle$HeightLevel LARGE = null;
    public static final DialogAnimStyle$HeightLevel MEDIUM = null;
    public static final DialogAnimStyle$HeightLevel SMALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DialogAnimStyle$HeightLevel[] f13088a = null;
    private final float maxRatio;

    static {
        DialogAnimStyle$HeightLevel r5 = new DialogAnimStyle$HeightLevel(0, "SMALL", 0.4f);
        SMALL = r5;
        DialogAnimStyle$HeightLevel r10 = new DialogAnimStyle$HeightLevel(1, "MEDIUM", 0.8f);
        MEDIUM = r10;
        DialogAnimStyle$HeightLevel r11 = new DialogAnimStyle$HeightLevel(2, "LARGE", 1.0f);
        LARGE = r11;
        f13088a = new DialogAnimStyle$HeightLevel[]{r5, r10, r11};
    }

    public DialogAnimStyle$HeightLevel(int r5, String r10, float r11) {
        super(r10, r5);
        this.maxRatio = r11;
    }

    public static DialogAnimStyle$HeightLevel valueOf(String r5) {
        return (DialogAnimStyle$HeightLevel) Enum.valueOf(DialogAnimStyle$HeightLevel.class, r5);
    }

    public static DialogAnimStyle$HeightLevel[] values() {
        return (DialogAnimStyle$HeightLevel[]) f13088a.clone();
    }

    public final float getMaxRatio() {
        return this.maxRatio;
    }
}

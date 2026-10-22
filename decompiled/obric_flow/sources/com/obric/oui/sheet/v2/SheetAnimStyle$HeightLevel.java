package com.obric.oui.sheet.v2;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"com/obric/oui/sheet/v2/SheetAnimStyle$HeightLevel", "", "Lcom/obric/oui/sheet/v2/SheetAnimStyle$HeightLevel;", "", "maxRatio", "F", "getMaxRatio", "()F", "SMALL", "MEDIUM", "LARGE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum SheetAnimStyle$HeightLevel extends Enum<SheetAnimStyle$HeightLevel> {
    public static final SheetAnimStyle$HeightLevel LARGE = null;
    public static final SheetAnimStyle$HeightLevel MEDIUM = null;
    public static final SheetAnimStyle$HeightLevel SMALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SheetAnimStyle$HeightLevel[] f14482a = null;
    private final float maxRatio;

    static {
        SheetAnimStyle$HeightLevel r5 = new SheetAnimStyle$HeightLevel(0, "SMALL", 0.4f);
        SMALL = r5;
        SheetAnimStyle$HeightLevel r10 = new SheetAnimStyle$HeightLevel(1, "MEDIUM", 0.8f);
        MEDIUM = r10;
        SheetAnimStyle$HeightLevel r11 = new SheetAnimStyle$HeightLevel(2, "LARGE", 1.0f);
        LARGE = r11;
        f14482a = new SheetAnimStyle$HeightLevel[]{r5, r10, r11};
    }

    public SheetAnimStyle$HeightLevel(int r5, String r10, float r11) {
        super(r10, r5);
        this.maxRatio = r11;
    }

    public static SheetAnimStyle$HeightLevel valueOf(String r5) {
        return (SheetAnimStyle$HeightLevel) Enum.valueOf(SheetAnimStyle$HeightLevel.class, r5);
    }

    public static SheetAnimStyle$HeightLevel[] values() {
        return (SheetAnimStyle$HeightLevel[]) f14482a.clone();
    }

    public final float getMaxRatio() {
        return this.maxRatio;
    }
}

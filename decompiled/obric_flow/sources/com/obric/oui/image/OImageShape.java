package com.obric.oui.image;

import kotlin.Metadata;
import sr.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/image/OImageShape;", "", "", "attrValue", "I", "getAttrValue", "()I", "Companion", "sr/b", "STANDARD", "ROUNDED", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OImageShape extends Enum<OImageShape> {
    public static final b Companion = null;
    public static final OImageShape ROUNDED = null;
    public static final OImageShape STANDARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OImageShape[] f13379a = null;
    private final int attrValue;

    static {
        OImageShape r5 = new OImageShape("STANDARD", 0, 0);
        STANDARD = r5;
        OImageShape r10 = new OImageShape("ROUNDED", 1, 1);
        ROUNDED = r10;
        f13379a = new OImageShape[]{r5, r10};
        Companion = new b();
    }

    public OImageShape(String r5, int r10, int r11) {
        super(r5, r10);
        this.attrValue = r11;
    }

    public static OImageShape valueOf(String r5) {
        return (OImageShape) Enum.valueOf(OImageShape.class, r5);
    }

    public static OImageShape[] values() {
        return (OImageShape[]) f13379a.clone();
    }

    public final int getAttrValue() {
        return this.attrValue;
    }
}

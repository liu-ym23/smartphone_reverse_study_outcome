package com.bytedance.android.live.revlink.impl.multianchor.constants;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/constants/GravityDef;", "", "TOP", "BOTTOM", "CENTER_HORIZONTAL", "LEFT", "RIGHT", "LEFT_TOP", "NO_GRAVITY", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GravityDef extends Enum<GravityDef> {
    public static final GravityDef BOTTOM = null;
    public static final GravityDef CENTER_HORIZONTAL = null;
    public static final GravityDef LEFT = null;
    public static final GravityDef LEFT_TOP = null;
    public static final GravityDef NO_GRAVITY = null;
    public static final GravityDef RIGHT = null;
    public static final GravityDef TOP = null;
    public static final /* synthetic */ GravityDef[] a = null;

    static {
        GravityDef r1 = new GravityDef("TOP", 0);
        TOP = r1;
        GravityDef r2 = new GravityDef("BOTTOM", 1);
        BOTTOM = r2;
        GravityDef r3 = new GravityDef("CENTER_HORIZONTAL", 2);
        CENTER_HORIZONTAL = r3;
        GravityDef r4 = new GravityDef("LEFT", 3);
        LEFT = r4;
        GravityDef r5 = new GravityDef("RIGHT", 4);
        RIGHT = r5;
        GravityDef r6 = new GravityDef("LEFT_TOP", 5);
        LEFT_TOP = r6;
        GravityDef r7 = new GravityDef("NO_GRAVITY", 6);
        NO_GRAVITY = r7;
        a = new GravityDef[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static GravityDef valueOf(String r1) {
        return (GravityDef) a.a(GravityDef.class, r1);
    }

    public static GravityDef[] values() {
        return (GravityDef[]) a.clone();
    }

    public GravityDef(String r1, int r2) {
        super(r1, r2);
    }
}

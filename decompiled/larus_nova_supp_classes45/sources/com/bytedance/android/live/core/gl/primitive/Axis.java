package com.bytedance.android.live.core.gl.primitive;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/core/gl/primitive/Axis;", "", "X", "Y", "Z", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Axis extends Enum<Axis> {
    public static final Axis X = null;
    public static final Axis Y = null;
    public static final Axis Z = null;
    public static final /* synthetic */ Axis[] a = null;

    static {
        Axis r1 = new Axis("X", 0);
        X = r1;
        Axis r2 = new Axis("Y", 1);
        Y = r2;
        Axis r3 = new Axis("Z", 2);
        Z = r3;
        a = new Axis[]{r1, r2, r3};
    }

    public static Axis valueOf(String r1) {
        return (Axis) r27.a.a(Axis.class, r1);
    }

    public static Axis[] values() {
        return (Axis[]) a.clone();
    }

    public Axis(String r1, int r2) {
        super(r1, r2);
    }
}

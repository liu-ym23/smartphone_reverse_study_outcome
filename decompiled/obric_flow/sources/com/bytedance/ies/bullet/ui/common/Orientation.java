package com.bytedance.ies.bullet.ui.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/Orientation;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum Orientation extends Enum<Orientation> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Orientation f6193a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Orientation f6194b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ Orientation[] f6195c = null;

    static {
        Orientation r5 = new Orientation("UNKNOWN", 0);
        f6193a = r5;
        Orientation r10 = new Orientation("PORTRAIT", 1);
        Orientation r11 = new Orientation("LANDSCAPE", 2);
        f6194b = r11;
        f6195c = new Orientation[]{r5, r10, r11};
    }

    public Orientation(String r5, int r10) {
        super(r5, r10);
    }

    public static Orientation valueOf(String r5) {
        return (Orientation) Enum.valueOf(Orientation.class, r5);
    }

    public static Orientation[] values() {
        return (Orientation[]) f6195c.clone();
    }
}

package com.bytedance.android.live.profile.p000enum;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profile/enum/DressClickArea;", "", "BorderRight", "BorderLeft", "Panel", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DressClickArea extends Enum<DressClickArea> {
    public static final DressClickArea BorderLeft = null;
    public static final DressClickArea BorderRight = null;
    public static final DressClickArea Panel = null;
    public static final /* synthetic */ DressClickArea[] a = null;

    static {
        DressClickArea r1 = new DressClickArea("BorderRight", 0);
        BorderRight = r1;
        DressClickArea r2 = new DressClickArea("BorderLeft", 1);
        BorderLeft = r2;
        DressClickArea r3 = new DressClickArea("Panel", 2);
        Panel = r3;
        a = new DressClickArea[]{r1, r2, r3};
    }

    public static DressClickArea valueOf(String r1) {
        return (DressClickArea) a.a(DressClickArea.class, r1);
    }

    public static DressClickArea[] values() {
        return (DressClickArea[]) a.clone();
    }

    public DressClickArea(String r1, int r2) {
        super(r1, r2);
    }
}

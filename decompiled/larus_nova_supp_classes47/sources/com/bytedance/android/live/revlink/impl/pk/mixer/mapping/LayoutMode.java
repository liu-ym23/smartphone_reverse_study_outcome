package com.bytedance.android.live.revlink.impl.pk.mixer.mapping;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/mixer/mapping/LayoutMode;", "", "Center", "CenterHorizontal", "CenterVertical", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LayoutMode extends Enum<LayoutMode> {
    public static final LayoutMode Center = null;
    public static final LayoutMode CenterHorizontal = null;
    public static final LayoutMode CenterVertical = null;
    public static final /* synthetic */ LayoutMode[] a = null;

    static {
        LayoutMode r1 = new LayoutMode("Center", 0);
        Center = r1;
        LayoutMode r2 = new LayoutMode("CenterHorizontal", 1);
        CenterHorizontal = r2;
        LayoutMode r3 = new LayoutMode("CenterVertical", 2);
        CenterVertical = r3;
        a = new LayoutMode[]{r1, r2, r3};
    }

    public static LayoutMode valueOf(String r1) {
        return (LayoutMode) a.a(LayoutMode.class, r1);
    }

    public static LayoutMode[] values() {
        return (LayoutMode[]) a.clone();
    }

    public LayoutMode(String r1, int r2) {
        super(r1, r2);
    }
}

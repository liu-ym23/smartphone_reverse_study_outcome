package com.bytedance.android.live.revlink.impl.behavior;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/behavior/IconResMode;", "", "IMAGE_MODEL", "DRAWABLE", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IconResMode extends Enum<IconResMode> {
    public static final IconResMode DRAWABLE = null;
    public static final IconResMode IMAGE_MODEL = null;
    public static final /* synthetic */ IconResMode[] a = null;

    static {
        IconResMode r1 = new IconResMode("IMAGE_MODEL", 0);
        IMAGE_MODEL = r1;
        IconResMode r2 = new IconResMode("DRAWABLE", 1);
        DRAWABLE = r2;
        a = new IconResMode[]{r1, r2};
    }

    public static IconResMode valueOf(String r1) {
        return (IconResMode) r27.a.a(IconResMode.class, r1);
    }

    public static IconResMode[] values() {
        return (IconResMode[]) a.clone();
    }

    public IconResMode(String r1, int r2) {
        super(r1, r2);
    }
}

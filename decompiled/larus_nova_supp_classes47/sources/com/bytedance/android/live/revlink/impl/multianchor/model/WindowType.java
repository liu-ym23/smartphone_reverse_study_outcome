package com.bytedance.android.live.revlink.impl.multianchor.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/model/WindowType;", "", "Anchor", "Guest", "Game", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum WindowType extends Enum<WindowType> {
    public static final WindowType Anchor = null;
    public static final WindowType Game = null;
    public static final WindowType Guest = null;
    public static final /* synthetic */ WindowType[] a = null;

    static {
        WindowType r1 = new WindowType("Anchor", 0);
        Anchor = r1;
        WindowType r2 = new WindowType("Guest", 1);
        Guest = r2;
        WindowType r3 = new WindowType("Game", 2);
        Game = r3;
        a = new WindowType[]{r1, r2, r3};
    }

    public static WindowType valueOf(String r1) {
        return (WindowType) a.a(WindowType.class, r1);
    }

    public static WindowType[] values() {
        return (WindowType[]) a.clone();
    }

    public WindowType(String r1, int r2) {
        super(r1, r2);
    }
}

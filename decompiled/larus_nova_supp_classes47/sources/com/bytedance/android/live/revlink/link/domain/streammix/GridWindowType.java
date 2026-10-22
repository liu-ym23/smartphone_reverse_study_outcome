package com.bytedance.android.live.revlink.link.domain.streammix;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/link/domain/streammix/GridWindowType;", "", "Anchor", "Audience", "Game", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GridWindowType extends Enum<GridWindowType> {
    public static final GridWindowType Anchor = null;
    public static final GridWindowType Audience = null;
    public static final GridWindowType Game = null;
    public static final /* synthetic */ GridWindowType[] a = null;

    static {
        GridWindowType r1 = new GridWindowType("Anchor", 0);
        Anchor = r1;
        GridWindowType r2 = new GridWindowType("Audience", 1);
        Audience = r2;
        GridWindowType r3 = new GridWindowType("Game", 2);
        Game = r3;
        a = new GridWindowType[]{r1, r2, r3};
    }

    public static GridWindowType valueOf(String r1) {
        return (GridWindowType) r27.a.a(GridWindowType.class, r1);
    }

    public static GridWindowType[] values() {
        return (GridWindowType[]) a.clone();
    }

    public GridWindowType(String r1, int r2) {
        super(r1, r2);
    }
}

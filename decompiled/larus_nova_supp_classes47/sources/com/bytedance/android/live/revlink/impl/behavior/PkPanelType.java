package com.bytedance.android.live.revlink.impl.behavior;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/behavior/PkPanelType;", "", "", "toConstInt", "Companion", "a", "PK", "Anchor", "GAME", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PkPanelType extends Enum<PkPanelType> {
    public static final PkPanelType Anchor = null;
    public static final a Companion = null;
    public static final PkPanelType GAME = null;
    public static final PkPanelType PK = null;
    public static final /* synthetic */ PkPanelType[] a = null;

    public static final class a {
        public a() {
        }

        public static PkPanelType a(Integer r2) {
            if (r2 != null) goto L5;
        L7:
            if (r2 != null) goto L10;
        L12:
            if (r2 != null) goto L15;
        L17:
            return null;
        L15:
            if (r2.intValue() != 2) goto L17;
            return PkPanelType.GAME;
        L10:
            if (r2.intValue() != 1) goto L12;
            return PkPanelType.Anchor;
        L5:
            if (r2.intValue() != 0) goto L7;
            return PkPanelType.PK;
        }
    }

    static {
        PkPanelType r1 = new PkPanelType("PK", 0);
        PK = r1;
        PkPanelType r2 = new PkPanelType("Anchor", 1);
        Anchor = r2;
        PkPanelType r3 = new PkPanelType("GAME", 2);
        GAME = r3;
        a = new PkPanelType[]{r1, r2, r3};
        Companion = new a();
    }

    public static PkPanelType valueOf(String r1) {
        return (PkPanelType) r27.a.a(PkPanelType.class, r1);
    }

    public static PkPanelType[] values() {
        return (PkPanelType[]) a.clone();
    }

    public final int toConstInt() {
        int r0 = i.a[ordinal()];
        if (r0 != 1) goto L5;
        return 0;
    L5:
        if (r0 != 2) goto L7;
        return 1;
    L7:
        if (r0 != 3) goto L10;
        return 2;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public PkPanelType(String r1, int r2) {
        super(r1, r2);
    }
}

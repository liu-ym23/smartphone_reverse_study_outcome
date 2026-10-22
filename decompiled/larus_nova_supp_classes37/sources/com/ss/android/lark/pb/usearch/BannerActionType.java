package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum BannerActionType extends Enum<BannerActionType> implements WireEnum {
    private static final /* synthetic */ BannerActionType[] $VALUES = null;
    public static final ProtoAdapter<BannerActionType> ADAPTER = null;
    public static final BannerActionType DisableFilterOption = null;
    public static final BannerActionType HighlightFilter = null;
    public static final BannerActionType NoAction = null;
    public static final BannerActionType ReSearch = null;
    public static final BannerActionType RouteTo = null;
    public static final BannerActionType SelectFilterOption = null;
    private final int value;

    static {
        BannerActionType r0 = new BannerActionType("NoAction", 0, 1);
        NoAction = r0;
        BannerActionType r1 = new BannerActionType("HighlightFilter", 1, 2);
        HighlightFilter = r1;
        BannerActionType r4 = new BannerActionType("SelectFilterOption", 2, 3);
        SelectFilterOption = r4;
        BannerActionType r6 = new BannerActionType("DisableFilterOption", 3, 4);
        DisableFilterOption = r6;
        BannerActionType r8 = new BannerActionType("ReSearch", 4, 5);
        ReSearch = r8;
        BannerActionType r10 = new BannerActionType("RouteTo", 5, 6);
        RouteTo = r10;
        $VALUES = new BannerActionType[]{r0, r1, r4, r6, r8, r10};
        ADAPTER = ProtoAdapter.newEnumAdapter(BannerActionType.class);
    }

    public static BannerActionType[] values() {
        return (BannerActionType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BannerActionType fromValue(int r0) {
        switch(r0) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return RouteTo;
    L8:
        return ReSearch;
    L10:
        return DisableFilterOption;
    L12:
        return SelectFilterOption;
    L14:
        return HighlightFilter;
    L16:
        return NoAction;
    }

    public static BannerActionType valueOf(String r1) {
        return (BannerActionType) a.a(BannerActionType.class, r1);
    }

    private BannerActionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

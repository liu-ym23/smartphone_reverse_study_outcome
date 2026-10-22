package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.android.lark.passport.base.core.log.LevelTypes;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum BannerTextType extends Enum<BannerTextType> implements WireEnum {
    private static final /* synthetic */ BannerTextType[] $VALUES = null;
    public static final ProtoAdapter<BannerTextType> ADAPTER = null;
    public static final BannerTextType CLICKABLE = null;
    public static final BannerTextType IMPORTANT = null;
    public static final BannerTextType INFO = null;
    private final int value;

    static {
        BannerTextType r0 = new BannerTextType("IMPORTANT", 0, 1);
        IMPORTANT = r0;
        BannerTextType r1 = new BannerTextType(LevelTypes.TYPE_INFO, 1, 2);
        INFO = r1;
        BannerTextType r4 = new BannerTextType("CLICKABLE", 2, 3);
        CLICKABLE = r4;
        $VALUES = new BannerTextType[]{r0, r1, r4};
        ADAPTER = ProtoAdapter.newEnumAdapter(BannerTextType.class);
    }

    public static BannerTextType[] values() {
        return (BannerTextType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BannerTextType fromValue(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return CLICKABLE;
    L13:
        return INFO;
    L15:
        return IMPORTANT;
    }

    public static BannerTextType valueOf(String r1) {
        return (BannerTextType) a.a(BannerTextType.class, r1);
    }

    private BannerTextType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

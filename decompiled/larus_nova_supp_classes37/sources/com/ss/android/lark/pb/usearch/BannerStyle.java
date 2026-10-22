package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum BannerStyle extends Enum<BannerStyle> implements WireEnum {
    private static final /* synthetic */ BannerStyle[] $VALUES = null;
    public static final ProtoAdapter<BannerStyle> ADAPTER = null;
    public static final BannerStyle INLINE_NORMAL = null;
    public static final BannerStyle INLINE_SMALL = null;
    public static final BannerStyle TOP_INFO = null;
    public static final BannerStyle TOP_WARN = null;
    private final int value;

    static {
        BannerStyle r0 = new BannerStyle("TOP_INFO", 0, 1);
        TOP_INFO = r0;
        BannerStyle r1 = new BannerStyle("TOP_WARN", 1, 2);
        TOP_WARN = r1;
        BannerStyle r4 = new BannerStyle("INLINE_SMALL", 2, 11);
        INLINE_SMALL = r4;
        BannerStyle r6 = new BannerStyle("INLINE_NORMAL", 3, 12);
        INLINE_NORMAL = r6;
        $VALUES = new BannerStyle[]{r0, r1, r4, r6};
        ADAPTER = ProtoAdapter.newEnumAdapter(BannerStyle.class);
    }

    public static BannerStyle[] values() {
        return (BannerStyle[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BannerStyle fromValue(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 11) goto L15;
        if (r1 == 12) goto L13;
        return null;
    L13:
        return INLINE_NORMAL;
    L15:
        return INLINE_SMALL;
    L17:
        return TOP_WARN;
    L19:
        return TOP_INFO;
    }

    public static BannerStyle valueOf(String r1) {
        return (BannerStyle) a.a(BannerStyle.class, r1);
    }

    private BannerStyle(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

package com.bytedance.android.live.profit.dress.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/TextAlignType;", "", "Middle", "Left", "Right", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TextAlignType extends Enum<TextAlignType> {
    public static final TextAlignType Left = null;
    public static final TextAlignType Middle = null;
    public static final TextAlignType Right = null;
    public static final /* synthetic */ TextAlignType[] a = null;

    static {
        TextAlignType r1 = new TextAlignType("Middle", 0);
        Middle = r1;
        TextAlignType r2 = new TextAlignType("Left", 1);
        Left = r2;
        TextAlignType r3 = new TextAlignType("Right", 2);
        Right = r3;
        a = new TextAlignType[]{r1, r2, r3};
    }

    public static TextAlignType valueOf(String r1) {
        return (TextAlignType) r27.a.a(TextAlignType.class, r1);
    }

    public static TextAlignType[] values() {
        return (TextAlignType[]) a.clone();
    }

    public TextAlignType(String r1, int r2) {
        super(r1, r2);
    }
}

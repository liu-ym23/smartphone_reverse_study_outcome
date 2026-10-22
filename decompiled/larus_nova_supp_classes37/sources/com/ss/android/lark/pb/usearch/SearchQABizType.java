package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum SearchQABizType extends Enum<SearchQABizType> implements WireEnum {
    private static final /* synthetic */ SearchQABizType[] $VALUES = null;
    public static final ProtoAdapter<SearchQABizType> ADAPTER = null;
    public static final SearchQABizType ConsumedQA = null;
    public static final SearchQABizType UnConsumedQA = null;
    public static final SearchQABizType Unknown = null;
    private final int value;

    static {
        SearchQABizType r0 = new SearchQABizType("Unknown", 0, 0);
        Unknown = r0;
        SearchQABizType r1 = new SearchQABizType("ConsumedQA", 1, 1);
        ConsumedQA = r1;
        SearchQABizType r3 = new SearchQABizType("UnConsumedQA", 2, 2);
        UnConsumedQA = r3;
        $VALUES = new SearchQABizType[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(SearchQABizType.class);
    }

    public static SearchQABizType[] values() {
        return (SearchQABizType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SearchQABizType fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return UnConsumedQA;
    L12:
        return ConsumedQA;
    L14:
        return Unknown;
    }

    public static SearchQABizType valueOf(String r1) {
        return (SearchQABizType) a.a(SearchQABizType.class, r1);
    }

    private SearchQABizType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

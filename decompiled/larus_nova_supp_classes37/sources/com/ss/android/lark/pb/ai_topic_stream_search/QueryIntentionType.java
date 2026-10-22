package com.ss.android.lark.pb.ai_topic_stream_search;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum QueryIntentionType extends Enum<QueryIntentionType> implements WireEnum {
    private static final /* synthetic */ QueryIntentionType[] $VALUES = null;
    public static final ProtoAdapter<QueryIntentionType> ADAPTER = null;
    public static final QueryIntentionType ANSWER_IN_SEARCH_QUESTION = null;
    public static final QueryIntentionType UNKNOWN_TYPE = null;
    private final int value;

    static {
        QueryIntentionType r0 = new QueryIntentionType("UNKNOWN_TYPE", 0, 0);
        UNKNOWN_TYPE = r0;
        QueryIntentionType r1 = new QueryIntentionType("ANSWER_IN_SEARCH_QUESTION", 1, 1);
        ANSWER_IN_SEARCH_QUESTION = r1;
        $VALUES = new QueryIntentionType[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(QueryIntentionType.class);
    }

    public static QueryIntentionType[] values() {
        return (QueryIntentionType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static QueryIntentionType fromValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return ANSWER_IN_SEARCH_QUESTION;
    L10:
        return UNKNOWN_TYPE;
    }

    public static QueryIntentionType valueOf(String r1) {
        return (QueryIntentionType) a.a(QueryIntentionType.class, r1);
    }

    private QueryIntentionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

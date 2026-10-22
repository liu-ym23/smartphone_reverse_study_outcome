package com.obric.memorydata.middleware.database;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/middleware/database/QueryType;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEFAULT", "SYNONYM", "SAME_PINYIN", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum QueryType extends Enum<QueryType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ QueryType[] $VALUES = null;
    public static final a Companion = null;
    public static final QueryType DEFAULT = null;
    public static final QueryType SAME_PINYIN = null;
    public static final QueryType SYNONYM = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/middleware/database/QueryType$Companion;", "", "<init>", "()V", "from", "Lcom/obric/memorydata/middleware/database/QueryType;", EventBody.KEY_VALUE, "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final QueryType a(String r5) {
            Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
            QueryType[] r4 = QueryType.values();
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            QueryType r2 = r4[r1];
            if (Intrinsics.areEqual(r2.getValue(), r5) == true) goto L12;
            r1 = r1 + 1;
            goto L3
        L12:
            return r2;
        L8:
            return null;
        }
    }

    private static final /* synthetic */ QueryType[] $values() {
        return new QueryType[]{DEFAULT, SYNONYM, SAME_PINYIN};
    }

    static {
        DEFAULT = new QueryType("DEFAULT", 0, "default");
        SYNONYM = new QueryType("SYNONYM", 1, "synonym");
        SAME_PINYIN = new QueryType("SAME_PINYIN", 2, "same_pinyin");
        QueryType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private QueryType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<QueryType> getEntries() {
        return $ENTRIES;
    }

    public static QueryType valueOf(String r2) {
        return (QueryType) ZeusTransformUtils.preCheckCast(Enum.valueOf(QueryType.class, r2), QueryType.class, "com.obric.memorydata.plugin");
    }

    public static QueryType[] values() {
        return (QueryType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), QueryType[].class, "com.obric.memorydata.plugin");
    }

    public final String getValue() {
        return this.value;
    }
}

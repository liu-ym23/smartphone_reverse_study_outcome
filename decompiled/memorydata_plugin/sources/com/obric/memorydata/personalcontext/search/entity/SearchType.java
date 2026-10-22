package com.obric.memorydata.personalcontext.search.entity;

import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0087\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/entity/SearchType;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ASSISTANT", "IN_APP", "GLOBAL", "MEMORY", "COMMON_GLOBAL_SEARCH", "PERSONAL_CONTEXT_SEARCH", "MEMORY_UPDATE", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SearchType extends Enum<SearchType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SearchType[] $VALUES = null;
    public static final SearchType ASSISTANT = null;
    public static final SearchType COMMON_GLOBAL_SEARCH = null;
    public static final a Companion = null;
    public static final SearchType GLOBAL = null;
    public static final SearchType IN_APP = null;
    public static final SearchType MEMORY = null;
    public static final SearchType MEMORY_UPDATE = null;
    public static final SearchType PERSONAL_CONTEXT_SEARCH = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/entity/SearchType$Companion;", "", "<init>", "()V", "fromValue", "Lcom/obric/memorydata/personalcontext/search/entity/SearchType;", EventBody.KEY_VALUE, "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final SearchType a(String r5) {
            Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
            SearchType[] r4 = SearchType.values();
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            SearchType r2 = r4[r1];
            if (Intrinsics.areEqual(r2.getValue(), r5) == true) goto L12;
            r1 = r1 + 1;
            goto L3
        L12:
            return r2;
        L8:
            return null;
        }
    }

    private static final /* synthetic */ SearchType[] $values() {
        return new SearchType[]{ASSISTANT, IN_APP, GLOBAL, MEMORY, COMMON_GLOBAL_SEARCH, PERSONAL_CONTEXT_SEARCH, MEMORY_UPDATE};
    }

    static {
        ASSISTANT = new SearchType("ASSISTANT", 0, "assistant");
        IN_APP = new SearchType("IN_APP", 1, "in_app");
        GLOBAL = new SearchType("GLOBAL", 2, "global");
        MEMORY = new SearchType("MEMORY", 3, SlardarSettingsConstants.PERF_KEY_MEMORY);
        COMMON_GLOBAL_SEARCH = new SearchType("COMMON_GLOBAL_SEARCH", 4, "common_global_search");
        PERSONAL_CONTEXT_SEARCH = new SearchType("PERSONAL_CONTEXT_SEARCH", 5, "personal_context_search");
        MEMORY_UPDATE = new SearchType("MEMORY_UPDATE", 6, "memory_update");
        SearchType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private SearchType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<SearchType> getEntries() {
        return $ENTRIES;
    }

    public static SearchType valueOf(String r2) {
        return (SearchType) ZeusTransformUtils.preCheckCast(Enum.valueOf(SearchType.class, r2), SearchType.class, "com.obric.memorydata.plugin");
    }

    public static SearchType[] values() {
        return (SearchType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SearchType[].class, "com.obric.memorydata.plugin");
    }

    public final String getValue() {
        return this.value;
    }
}

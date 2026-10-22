package com.obric.search.api.search.impl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.search.api.query.impl.FullTextSearchQuery;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0019BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/obric/search/api/search/impl/FullTextSearchSpec;", "Lcom/obric/search/api/search/intf/ISearchSpec;", "schemaName", "", ChatMessage.TYPE_QUERY, "Lcom/obric/search/api/query/impl/FullTextSearchQuery;", "rankMethod", "Lcom/obric/search/api/search/impl/FullTextSearchSpec$RankMethod;", "limit", "", TypedValues.CycleType.S_WAVE_OFFSET, "targetIdList", "", "(Ljava/lang/String;Lcom/obric/search/api/query/impl/FullTextSearchQuery;Lcom/obric/search/api/search/impl/FullTextSearchSpec$RankMethod;JJLjava/util/List;)V", "getLimit", "()J", "getOffset", "getQuery", "()Lcom/obric/search/api/query/impl/FullTextSearchQuery;", "getRankMethod", "()Lcom/obric/search/api/search/impl/FullTextSearchSpec$RankMethod;", "getSchemaName", "()Ljava/lang/String;", "getTargetIdList", "()Ljava/util/List;", "RankMethod", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FullTextSearchSpec implements com.obric.search.api.search.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FullTextSearchQuery f14954b;
    private final RankMethod c;
    private final long d;
    private final long e;
    private final List<Long> f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/search/api/search/impl/FullTextSearchSpec$RankMethod;", "", "(Ljava/lang/String;I)V", "None", "BM25", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum RankMethod extends Enum<RankMethod> {
        private static final /* synthetic */ RankMethod[] $VALUES = null;
        public static final RankMethod BM25 = null;
        public static final RankMethod None = null;

        private static final /* synthetic */ RankMethod[] $values() {
            return new RankMethod[]{None, BM25};
        }

        static {
            None = new RankMethod("None", 0);
            BM25 = new RankMethod("BM25", 1);
            $VALUES = $values();
        }

        private RankMethod(String r1, int r2) {
            super(r1, r2);
        }

        public static RankMethod valueOf(String r2) {
            return (RankMethod) ZeusTransformUtils.preCheckCast(Enum.valueOf(RankMethod.class, r2), RankMethod.class, "com.obric.memorydata.plugin");
        }

        public static RankMethod[] values() {
            return (RankMethod[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RankMethod[].class, "com.obric.memorydata.plugin");
        }
    }

    public FullTextSearchSpec(String r3, FullTextSearchQuery r4, RankMethod r5, long r6, long r8, List<Long> r10) {
        List<Long> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "schemaName");
        Intrinsics.checkNotNullParameter(r4, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r5, "rankMethod");
        Intrinsics.checkNotNullParameter(r11, "targetIdList");
        this.f14953a = r3;
        this.f14954b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r8;
        this.f = r11;
    }

    public /* synthetic */ FullTextSearchSpec(String r12, FullTextSearchQuery r13, RankMethod r14, long r15, long r17, List r19, int r20, DefaultConstructorMarker r21) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        if ((r20 & 4) == 0) goto L5;
        RankMethod r5 = RankMethod.None;
    L7:
        if ((r20 & 8) == 0) goto L9;
        long r6 = 0;
    L11:
        if ((r20 & 16) == 0) goto L13;
        long r8 = 0;
    L15:
        if ((r20 & 32) == 0) goto L17;
        r0 = CollectionsKt.emptyList();
    L17:
        this(r12, r13, r5, r6, r8, r0);
        return;
    L13:
        r8 = r17;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    @Override // com.obric.search.api.search.a.a
    public String a() {
        return this.f14953a;
    }

    public final FullTextSearchQuery b() {
        return this.f14954b;
    }

    public final RankMethod c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final long e() {
        return this.e;
    }

    public final List<Long> f() {
        return this.f;
    }
}

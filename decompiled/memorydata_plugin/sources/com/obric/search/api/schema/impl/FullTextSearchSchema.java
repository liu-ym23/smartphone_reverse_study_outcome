package com.obric.search.api.schema.impl;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "Lcom/obric/search/api/schema/intf/ISearchEngineSchema;", "schemaName", "", "columnList", "", "tokenizer", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema$TOKENIZER;", "isContentLess", "", "(Ljava/lang/String;Ljava/util/List;Lcom/obric/search/api/schema/impl/FullTextSearchSchema$TOKENIZER;Z)V", "getColumnList", "()Ljava/util/List;", "()Z", "getSchemaName", "()Ljava/lang/String;", "getTokenizer", "()Lcom/obric/search/api/schema/impl/FullTextSearchSchema$TOKENIZER;", "createExecutor", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaExecutor;", "context", "Landroid/content/Context;", "schemaContext", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaContext;", "TOKENIZER", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FullTextSearchSchema implements com.obric.search.api.schema.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f14942b;
    private final TOKENIZER c;
    private final boolean d;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/search/api/schema/impl/FullTextSearchSchema$TOKENIZER;", "", "sqlName", "", "typeCode", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getSqlName", "()Ljava/lang/String;", "getTypeCode", "()I", "O_TOKENIZER_1", "O_TOKENIZER_2", "O_TOKENIZER_3_FOR_TEST", "O_TOKENIZER_4_FOR_TEST", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum TOKENIZER extends Enum<TOKENIZER> {
        private static final /* synthetic */ TOKENIZER[] $VALUES = null;
        public static final TOKENIZER O_TOKENIZER_1 = null;
        public static final TOKENIZER O_TOKENIZER_2 = null;
        public static final TOKENIZER O_TOKENIZER_3_FOR_TEST = null;
        public static final TOKENIZER O_TOKENIZER_4_FOR_TEST = null;
        private final String sqlName;
        private final int typeCode;

        private static final /* synthetic */ TOKENIZER[] $values() {
            return new TOKENIZER[]{O_TOKENIZER_1, O_TOKENIZER_2, O_TOKENIZER_3_FOR_TEST, O_TOKENIZER_4_FOR_TEST};
        }

        static {
            O_TOKENIZER_1 = new TOKENIZER("O_TOKENIZER_1", 0, "OTokenizer1", 1);
            O_TOKENIZER_2 = new TOKENIZER("O_TOKENIZER_2", 1, "OTokenizer2", 2);
            O_TOKENIZER_3_FOR_TEST = new TOKENIZER("O_TOKENIZER_3_FOR_TEST", 2, "OTokenizer3", 1);
            O_TOKENIZER_4_FOR_TEST = new TOKENIZER("O_TOKENIZER_4_FOR_TEST", 3, "OTokenizer4", 2);
            $VALUES = $values();
        }

        private TOKENIZER(String r1, int r2, String r3, int r4) {
            super(r1, r2);
            this.sqlName = r3;
            this.typeCode = r4;
        }

        public static TOKENIZER valueOf(String r2) {
            return (TOKENIZER) ZeusTransformUtils.preCheckCast(Enum.valueOf(TOKENIZER.class, r2), TOKENIZER.class, "com.obric.memorydata.plugin");
        }

        public static TOKENIZER[] values() {
            return (TOKENIZER[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TOKENIZER[].class, "com.obric.memorydata.plugin");
        }

        public final String getSqlName() {
            return this.sqlName;
        }

        public final int getTypeCode() {
            return this.typeCode;
        }
    }

    public FullTextSearchSchema(String r3, List<String> r4, TOKENIZER r5, boolean r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "schemaName");
        Intrinsics.checkNotNullParameter(r7, "columnList");
        Intrinsics.checkNotNullParameter(r5, "tokenizer");
        this.f14941a = r3;
        this.f14942b = r7;
        this.c = r5;
        this.d = r6;
    }

    @Override // com.obric.search.api.schema.a.a
    public com.obric.search.api.schema.a.c a(Context r4, com.obric.search.api.schema.a.b r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        com.obric.search.api.schema.a.b r7 = (com.obric.search.api.schema.a.b) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.search.api.schema.a.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "schemaContext");
        if (this.d == false) goto L5;
        Object r8 = new b(a(), (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin"), this.f14942b);
    L7:
        return (com.obric.search.api.schema.a.c) ZeusTransformUtils.preCheckCast(r8, com.obric.search.api.schema.a.c.class, "com.obric.memorydata.plugin");
    L5:
        r8 = new c(a(), (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin"), this.f14942b);
        goto L7
    }

    @Override // com.obric.search.api.schema.a.a
    public String a() {
        return this.f14941a;
    }

    public final List<String> b() {
        return this.f14942b;
    }

    public final TOKENIZER c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }
}

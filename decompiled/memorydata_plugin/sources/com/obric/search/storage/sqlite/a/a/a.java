package com.obric.search.storage.sqlite.a.a;

import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.obric.search.common.log.RuntimeLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/search/storage/sqlite/schema/impl/SQLiteFts5Schema;", "Lcom/obric/search/storage/sqlite/schema/intf/ISQLiteTableSchema;", "tableName", "", "columnList", "", "tokenizer", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema$TOKENIZER;", "isContentLess", "", "(Ljava/lang/String;Ljava/util/List;Lcom/obric/search/api/schema/impl/FullTextSearchSchema$TOKENIZER;Z)V", "getTableName", "()Ljava/lang/String;", "toCreateTableSQLString", "toDeleteTableSQLString", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a implements com.obric.search.storage.sqlite.a.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0799a f14964a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14965b;
    private final List<String> c;
    private final FullTextSearchSchema.TOKENIZER d;
    private final boolean e;

    /* JADX INFO: renamed from: com.obric.search.storage.sqlite.a.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/search/storage/sqlite/schema/impl/SQLiteFts5Schema$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0799a {
        private C0799a() {
        }

        public /* synthetic */ C0799a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14966a = null;

        static {
            int[] r0 = new int[FullTextSearchSchema.TOKENIZER.values().length];
            r0[FullTextSearchSchema.TOKENIZER.O_TOKENIZER_2.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[FullTextSearchSchema.TOKENIZER.O_TOKENIZER_4_FOR_TEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[FullTextSearchSchema.TOKENIZER.O_TOKENIZER_1.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[FullTextSearchSchema.TOKENIZER.O_TOKENIZER_3_FOR_TEST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f14966a = r0;
        }
    }

    static {
        f14964a = new C0799a(null);
    }

    public a(String r3, List<String> r4, FullTextSearchSchema.TOKENIZER r5, boolean r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "tableName");
        Intrinsics.checkNotNullParameter(r7, "columnList");
        Intrinsics.checkNotNullParameter(r5, "tokenizer");
        this.f14965b = r3;
        this.c = r7;
        this.d = r5;
        this.e = r6;
    }

    public String a() {
        return this.f14965b;
    }

    @Override // com.obric.search.storage.sqlite.a.b.a
    public String b() {
        if (this.c.isEmpty() == false) goto L6;
        RuntimeLogger.f14958a.d("SQLiteFts5Schema", "Translate to SQL string error. Column list is empty!");
        return "";
    L6:
        StringBuilder r0 = new StringBuilder().append((String) ZeusTransformUtils.preCheckCast(this.c.get(0), String.class, "com.obric.memorydata.plugin"));
        int r1 = this.c.size();
        int r4 = 1;
    L7:
        if (r4 >= r1) goto L10;
        r0.append(", " + ((String) ZeusTransformUtils.preCheckCast(this.c.get(r4), String.class, "com.obric.memorydata.plugin")));
        r4 = r4 + 1;
        goto L7
    L10:
        if (this.e == false) goto L12;
        r0.append(", content=''");
    L12:
        int r2 = b.f14966a[this.d.ordinal()];
        if (r2 != 1) goto L15;
    L24:
        StringBuilder r3 = new StringBuilder().append("CREATE VIRTUAL TABLE ").append(a()).append(" USING fts5(").append(r0);
        String r5 = ", prefix='1 2 3 4 5', tokenize='";
    L26:
        return r3.append(r5).append(this.d.getSqlName()).append("')").toString();
    L15:
        if (r2 == 2) goto L24;
        if (r2 != 3) goto L19;
    L23:
        r3 = new StringBuilder().append("CREATE VIRTUAL TABLE ").append(a()).append(" USING fts5(").append(r0);
        r5 = ", tokenize='";
        goto L26
    L19:
        if (r2 == 4) goto L23;
        throw new NoWhenBranchMatchedException();
    }

    public String c() {
        return "DROP TABLE " + a();
    }
}

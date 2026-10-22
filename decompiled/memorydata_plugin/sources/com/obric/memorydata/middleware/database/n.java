package com.obric.memorydata.middleware.database;

import androidx.core.view.PointerIconCompat;
import com.obric.dejavu.library.IndexMetricType;
import com.obric.dejavu.library.KvEngineType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u001fJ\f\u0010 \u001a\u00020\u0005*\u00020\u0005H\u0002J\f\u0010!\u001a\u00020\u0005*\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/memorydata/middleware/database/VectorDbOptionsBuilder;", "", "<init>", "()V", "dbName", "", "dims", "", "personal", "", "createIfMissing", "errorIfExists", "compressLevel", "kvEngine", "Lcom/obric/dejavu/library/KvEngineType;", "indexCfg", "Lcom/obric/dejavu/library/DbIndexConfig;", "vlmDims", "setDbName", "setDims", "setPersonal", "setCreateIfMissing", "setErrorIfExists", "setCompressLevel", "setKvEngine", "setIndexCfg", "setVlmDims", "build", "Lcom/obric/dejavu/library/DbOptions;", "buildVlm", "buildPair", "Lkotlin/Pair;", "appendVlmSuffix", "appendPersonalSuffixIfNeeded", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11672a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11673b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private KvEngineType h;
    private com.obric.dejavu.library.a i;
    private int j;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/middleware/database/VectorDbOptionsBuilder$Companion;", "", "<init>", "()V", "DEFAULT_VLM_DB_NAME_SUFFIX", "", "DEFAULT_VLM_DIMS", "", "from", "Lcom/obric/memorydata/middleware/database/VectorDbOptionsBuilder;", "dbSchema", "Lcom/obric/memorydata/middleware/database/VectorDatabaseSchema;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final n a(m r14) {
            Intrinsics.checkNotNullParameter(r14, "dbSchema");
            return new n().a(r14.a()).a(r14.c()).a(r14.b()).b(true).a(new com.obric.dejavu.library.a(null, IndexMetricType.InnerProduct, 0, 0, 0, 0, 0, 0, 0, false, PointerIconCompat.TYPE_GRABBING, null));
        }
    }

    static {
        f11672a = new a(null);
    }

    public n() {
        this.f11673b = "";
        this.h = KvEngineType.LevelDb;
        this.i = new com.obric.dejavu.library.a(null, null, 0, 0, 0, 0, 0, 0, 0, false, 1023, null);
        this.j = 768;
    }

    private final String b(String r1) {
        return r1 + "_vlm";
    }

    private final String c(String r4) {
        if (this.d == true) goto L5;
        return r4;
    L5:
        i r3 = b.f11646a.a();
        if (r3.c() == false) goto L9;
        DatabaseIsolationTracker.f11642a.a("vector", r4, r3.b());
    L9:
        return r4 + '_' + r3.a();
    }

    public final com.obric.dejavu.library.d a() {
        return new com.obric.dejavu.library.d(c(this.f11673b), this.c, this.e, this.f, this.g, this.h, this.i);
    }

    public final n a(int r4) {
        ((n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin")).c = r4;
        return (n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin");
    }

    public final n a(com.obric.dejavu.library.a r4) {
        Intrinsics.checkNotNullParameter(r4, "indexCfg");
        ((n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin")).i = r4;
        return (n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin");
    }

    public final n a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "dbName");
        ((n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin")).f11673b = r4;
        return (n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin");
    }

    public final n a(boolean r4) {
        ((n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin")).d = r4;
        return (n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin");
    }

    public final com.obric.dejavu.library.d b() {
        return new com.obric.dejavu.library.d(c(b(this.f11673b)), this.j, this.e, this.f, this.g, this.h, this.i);
    }

    public final n b(boolean r4) {
        ((n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin")).e = r4;
        return (n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin");
    }

    public final Pair<com.obric.dejavu.library.d, com.obric.dejavu.library.d> c() {
        return TuplesKt.to(a(), b());
    }
}

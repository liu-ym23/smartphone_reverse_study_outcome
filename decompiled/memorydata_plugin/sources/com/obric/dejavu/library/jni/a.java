package com.obric.dejavu.library.jni;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.dejavu.library.DbKvResult;
import com.obric.dejavu.library.DbObjResult;
import com.obric.dejavu.library.DbStatus;
import com.obric.dejavu.library.c;
import com.obric.dejavu.library.d;
import com.obric.dejavu.library.e;
import com.obric.memorydata.memory.island.gr.IslandSession;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 22\u00020\u0001:\u00012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011H\u0016J(\u0010\u0012\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00130\u000fj\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0016J*\u0010\u0018\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016JM\u0010\u001f\u001a$\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020!0 0\u00130\u00130\u000fj\u0002`\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00132\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016¢\u0006\u0002\u0010(J \u0010\u001f\u001a\u00020)2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000bH\u0016J\b\u0010,\u001a\u00020\u0003H\u0016J\u0018\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u000bH\u0016J\b\u00101\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/dejavu/library/jni/DbInstanceImpl;", "Lcom/obric/dejavu/library/DbInstance;", "handle", "", "(J)V", "clear", "Lcom/obric/dejavu/library/DbStatus;", IslandSession.REOPEN_VALUE_CLOSE, "", "dims", "exists", "", "key", "", "getDbInfo", "Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/DbInfo;", "Lcom/obric/dejavu/library/DbInfoResult;", "getKeys", "", "Lcom/obric/dejavu/library/DbKeysResult;", CommonConsts.APM_INNER_EVENT_COST_START, "end", "getProperty", "insert", "vec", "", EventBody.KEY_VALUE, "normalize", ActivityLifecycle.NAME, "remove", "search", "Lkotlin/Pair;", "", "Lcom/obric/dejavu/library/DbVecResult;", "vecs", "k", "", "opt", "Lcom/obric/dejavu/library/DbSearchOption;", "([[FILcom/obric/dejavu/library/DbSearchOption;)Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/DbKvResult;", "getValue", "getVec", "size", "updateIndexConfig", "cfg", "Lcom/obric/dejavu/library/DbIndexConfig;", "rebuildNow", "validate", "Companion", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0386a f7891b = null;
    private final long c;

    /* JADX INFO: renamed from: com.obric.dejavu.library.jni.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ \u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b¨\u0006\u000e"}, d2 = {"Lcom/obric/dejavu/library/jni/DbInstanceImpl$Companion;", "", "()V", "openDb", "Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/DbInstance;", "Lcom/obric/dejavu/library/DbOpenResult;", "dirPrefix", "", "opt", "Lcom/obric/dejavu/library/DbOptions;", "dbName", "removeDb", "Lcom/obric/dejavu/library/DbStatus;", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0386a {
        private C0386a() {
        }

        public /* synthetic */ C0386a(DefaultConstructorMarker r1) {
            this();
        }

        public final DbObjResult<c> a(String r5, d r6) {
            Intrinsics.checkNotNullParameter(r5, "dirPrefix");
            Intrinsics.checkNotNullParameter(r6, "opt");
            new File(r5).mkdirs();     // Catch: Throwable -> L9
            long r7 = Bridge.createDb(r5, Bridge.INSTANCE.formatOptStr(r6));     // Catch: Throwable -> L9
            if (r7 < 0) goto L8;
            return new DbObjResult(DbStatus.f7870a.a(), new a(r7));
        L8:
            return new DbObjResult(new DbStatus(-1, "unnkown craete error."), null);
        L9:
            th = move-exception;
            String r8 = th.getMessage();
            if (r8 != null) goto L14;
            r8 = "";
        L14:
            return new DbObjResult(new DbStatus(-1, r8), null);
        }
    }

    static {
        f7891b = new C0386a(null);
    }

    public a(long r1) {
        this.c = r1;
    }

    @Override // com.obric.dejavu.library.c
    public DbKvResult a(String r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return Bridge.searchKv(this.c, r3, r4, r5);
    }

    @Override // com.obric.dejavu.library.c
    public DbObjResult<Pair<String, Float>[][]> a(float[][] r3, int r4, e r5) {
        Intrinsics.checkNotNullParameter(r3, "vecs");
        Intrinsics.checkNotNullParameter(r5, "opt");
        return Bridge.searchVec(this.c, r3, r4, Bridge.INSTANCE.formatOptStr(r5));
    }

    @Override // com.obric.dejavu.library.c
    public DbStatus a() {
        return Bridge.clear(this.c);
    }

    @Override // com.obric.dejavu.library.c
    public DbStatus a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return Bridge.remove(this.c, r3);
    }

    @Override // com.obric.dejavu.library.c
    public long b() {
        return Bridge.size(this.c);
    }

    @Override // com.obric.dejavu.library.c
    public long c() {
        return Bridge.dims(this.c);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Bridge.releaseDb(this.c);
    }

    @Override // com.obric.dejavu.library.c
    public String d() {
        return Bridge.name(this.c);
    }

    @Override // com.obric.dejavu.library.c
    public DbStatus insert(String r8, float[] r9, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        return Bridge.insert(this.c, r8, r9, r10, r11);
    }
}

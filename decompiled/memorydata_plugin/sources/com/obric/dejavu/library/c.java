package com.obric.dejavu.library;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.dejavu.library.jni.Bridge;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000b\u001a\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000eH&J,\u0010\u000f\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00100\fj\u0002`\u00112\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\nH&J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\bH&J\b\u0010\u001a\u001a\u00020\nH&J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH&JO\u0010\u001c\u001a$\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001e0\u001d0\u00100\u00100\fj\u0002`\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u00102\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H&¢\u0006\u0002\u0010%J$\u0010\u001c\u001a\u00020&2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\bH&J\b\u0010)\u001a\u00020\u0006H&J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\bH&J\b\u0010.\u001a\u00020\u0004H&¨\u00060"}, d2 = {"Lcom/obric/dejavu/library/DbInstance;", "Ljava/lang/AutoCloseable;", "()V", "clear", "Lcom/obric/dejavu/library/DbStatus;", "dims", "", "exists", "", "key", "", "getDbInfo", "Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/DbInfo;", "Lcom/obric/dejavu/library/DbInfoResult;", "getKeys", "", "Lcom/obric/dejavu/library/DbKeysResult;", CommonConsts.APM_INNER_EVENT_COST_START, "end", "getProperty", "insert", "vec", "", EventBody.KEY_VALUE, "normalize", ActivityLifecycle.NAME, "remove", "search", "Lkotlin/Pair;", "", "Lcom/obric/dejavu/library/DbVecResult;", "vecs", "k", "", "opt", "Lcom/obric/dejavu/library/DbSearchOption;", "([[FILcom/obric/dejavu/library/DbSearchOption;)Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/DbKvResult;", "getValue", "getVec", "size", "updateIndexConfig", "cfg", "Lcom/obric/dejavu/library/DbIndexConfig;", "rebuildNow", "validate", "Companion", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class c implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7876a = null;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ \u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¨\u0006\u0015"}, d2 = {"Lcom/obric/dejavu/library/DbInstance$Companion;", "", "()V", "openDb", "Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/DbInstance;", "Lcom/obric/dejavu/library/DbOpenResult;", "dirPrefix", "", "opt", "Lcom/obric/dejavu/library/DbOptions;", "dbName", "removeDb", "Lcom/obric/dejavu/library/DbStatus;", "setLogLevel", "", "level", "Lcom/obric/dejavu/library/LogLevel;", "setLogWriter", "writer", "Lcom/obric/dejavu/library/DbLogWriter;", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(DbLogWriter r2) {
            Bridge.setLogWriter((DbLogWriter) ZeusTransformUtils.wrapperContextForParams(r2, DbLogWriter.class, "com.obric.memorydata.plugin"));
        }

        public final void a(LogLevel r1) {
            Intrinsics.checkNotNullParameter(r1, "level");
            Bridge.setLogLevel(r1.getValue());
        }
    }

    static {
        f7876a = new a(null);
    }

    public c() {
    }

    public static /* synthetic */ DbStatus a(c r0, String r1, float[] r2, String r3, boolean r4, int r5, Object r6) {
        if (r6 != null) goto L15;
        if ((r5 & 2) == 0) goto L7;
        r2 = null;
    L7:
        if ((r5 & 4) == 0) goto L10;
        r3 = "";
    L10:
        if ((r5 & 8) == 0) goto L13;
        r4 = false;
    L13:
        return r0.insert(r1, r2, r3, r4);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insert");
    }

    public abstract DbKvResult a(String r1, boolean r2, boolean r3);

    public abstract DbObjResult<Pair<String, Float>[][]> a(float[][] r1, int r2, e r3);

    public abstract DbStatus a();

    public abstract DbStatus a(String r1);

    public abstract long b();

    public abstract long c();

    public abstract String d();

    public abstract DbStatus insert(String r1, float[] r2, String r3, boolean r4);
}

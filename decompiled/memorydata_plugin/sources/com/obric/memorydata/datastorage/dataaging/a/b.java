package com.obric.memorydata.datastorage.dataaging.a;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.util.EmbeddingState;
import com.obric.memorydata.personalcontext.util.c;
import com.obric.memorydata.personalcontext.vectordb.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/datastorage/dataaging/wrapper/VectorDatabaseWrapper;", "Lcom/obric/memorydata/datastorage/dataaging/wrapper/RoomDatabaseWrapper;", "openHelperProvider", "Lkotlin/Function0;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "deleteRowsByCondition", "", "tableName", "", "whereClause", "Companion", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends com.obric.memorydata.datastorage.dataaging.a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9700b = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/datastorage/dataaging/wrapper/VectorDatabaseWrapper$Companion;", "", "<init>", "()V", "TAG", "", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.datastorage.dataaging.a.b$b, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class C0464b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9701a = null;

        static {
            int[] r0 = new int[EmbeddingState.values().length];
            r0[EmbeddingState.USE_VLM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[EmbeddingState.USE_LITTLE_MODEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f9701a = r0;
        }
    }

    static {
        f9700b = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public b(Function0<? extends SupportSQLiteOpenHelper> r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "openHelperProvider");
        super(r4);
    }

    public /* synthetic */ b(Function0 r2, int r3, DefaultConstructorMarker r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = $$Lambda$b$l3ub07Xwm6desZv8vmUOTcVBOnM.INSTANCE;
    L5:
        this(r5);
    }

    private static final SupportSQLiteOpenHelper c() {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getOpenHelper();
    }

    public static /* synthetic */ SupportSQLiteOpenHelper lambda$l3ub07Xwm6desZv8vmUOTcVBOnM() {
        return c();
    }

    @Override // com.obric.memorydata.datastorage.dataaging.a.a, com.obric.memorydata.datastorage.dataaging.a.a.a
    public int a(String r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "tableName");
        Intrinsics.checkNotNullParameter(r14, "whereClause");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VectorDatabaseWrapper", "deleteRowsByCondition, tableName: " + r13 + ", whereClause: " + r14, false, 4, null);
        List<Long> r15 = a(r13, OaidModel.KEY_ID, r14);
        if (r15.isEmpty() == false) goto L5;
        return 0;
    L5:
        EmbeddingState r0 = c.f12363a.b();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r3.hasNext() == false) goto L17;
        long r6 = ((Number) ZeusTransformUtils.preCheckCast(r3.next(), Number.class, "com.obric.memorydata.plugin")).longValue();
        int r4 = C0464b.f9701a[r0.ordinal()];
        if (r4 != 1) goto L11;
        d r5 = new d(r13, true);
    L15:
        r5.delete(r6);
        goto L7
    L11:
        if (r4 == 2) goto L13;
        new d(r13, true).delete(r6);
        r5 = new d(r13, false);
        goto L15
    L13:
        r5 = new d(r13, false);
        goto L15
    L17:
        return b().delete(r13, "rowid in (?)", new String[]{CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null)});
    }
}

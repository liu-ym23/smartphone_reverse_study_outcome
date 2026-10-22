package com.obric.memorydata.personalcontext.vectordb;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.dejavu.library.DbKvResult;
import com.obric.dejavu.library.DbObjResult;
import com.obric.dejavu.library.DbStatus;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\rJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0005J9\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00190\u00180\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001dJG\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00190\u00180\u00142\u0006\u0010\u001f\u001a\u00020\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\"J\n\u0010#\u001a\u0004\u0018\u00010$H&R\u0018\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/memorydata/personalcontext/vectordb/AbstractVectorDao;", "", "<init>", "()V", LocationMonitorConst.TAG, "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "topKByKeysSearcher", "Lcom/obric/memorydata/personalcontext/vectordb/VectorTopKByKeysSearcher;", "size", "", "insert", "", OaidModel.KEY_ID, "vector", "", "delete", "clear", "getAllKeys", "", "searchAndDecrypt", "key", "search", "Lkotlin/Pair;", "", "limit", "", "minDistance", "([FILjava/lang/Float;)Ljava/util/List;", "searchByKeys", "queryVector", "keys", "minScore", "([FLjava/util/List;ILjava/lang/Float;)Ljava/util/List;", "getDbInstance", "Lcom/obric/dejavu/library/cipher/DbCipherInstance;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f12403b;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this.f12402a = getClass().getSimpleName();
        this.f12403b = new h(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ List a(a r0, float[] r1, int r2, Float r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L7;
        r3 = null;
    L7:
        return r0.a(r1, r2, r3);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: search");
    }

    private static final float[] a(com.obric.dejavu.library.cipher.d r0, long r1) {
        DbKvResult r2 = r0.b(String.valueOf(r1));
        if (r2.getStatus().a() == DbStatus.f7870a.a().a()) goto L7;
        return null;
    L7:
        return r2.getVec();
    }

    public static /* synthetic */ float[] lambda$qj9Au86zdcdwjNcwDfGdK_Z9oSo(com.obric.dejavu.library.cipher.d r0, long r1) {
        return a(r0, r1);
    }

    public final long a() {
        com.obric.dejavu.library.cipher.d r0 = c();
        if (r0 == null) goto L6;
        long r3 = System.currentTimeMillis();
        long r5 = r0.b();
        IRunLog r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r8 = this.f12402a;
        Intrinsics.checkNotNullExpressionValue(r8, LocationMonitorConst.TAG);
        IRunLog.a.a(r7, r8, "size " + r0.d() + ' ' + r5 + ", cost: " + (System.currentTimeMillis() - r3) + "ms", false, 4, null);
        return r5;
    L6:
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r4 = this.f12402a;
        Intrinsics.checkNotNullExpressionValue(r4, LocationMonitorConst.TAG);
        IRunLog.a.b(r2, r4, "size failed: vector database is unavailable", null, 4, null);
        return -1;
    }

    public final List<Pair<Long, Float>> a(float[] r17, int r18, Float r19) {
        Intrinsics.checkNotNullParameter(r17, "vector");
        List<Pair<Long, Float>> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        com.obric.dejavu.library.cipher.d r2 = c();
        if (r2 == null) goto L15;
        long r4 = System.currentTimeMillis();
        int r7 = 0;
        float[][] r6 = {r17};
        if (r19 == null) goto L7;
        float r8 = r19.floatValue();
    L8:
        DbObjResult<Pair<String, Float>[][]> r0 = r2.a(r6, r18, new com.obric.dejavu.library.e(true, 0, 0.0f, r8, null, 22, null));
        IRunLog r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r10 = this.f12402a;
        Intrinsics.checkNotNullExpressionValue(r10, LocationMonitorConst.TAG);
        IRunLog.a.a(r9, r10, "search " + r2.d() + ' ' + r0.a().a() + ' ' + r0.a().b() + ", cost: " + (System.currentTimeMillis() - r4) + "ms", false, 4, null);
        Pair[][] r3 = (Pair[][]) ZeusTransformUtils.preCheckCast(r0.b(), Pair[][].class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L15;
        Pair[] r5 = (Pair[]) ZeusTransformUtils.preCheckCast(ArraysKt.firstOrNull((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.memorydata.plugin")), Pair[].class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L15;
        int r11 = r5.length;
    L13:
        if (r7 >= r11) goto L15;
        Pair r12 = r5[r7];
        r1.add(new Pair(Long.valueOf(Long.parseLong((String) ZeusTransformUtils.preCheckCast(r12.getFirst(), String.class, "com.obric.memorydata.plugin"))), r12.getSecond()));
        r7 = r7 + 1;
        goto L13
    L7:
        r8 = Float.NaN;
    L15:
        return r1;
    }

    public final List<Pair<Long, Float>> a(float[] r7, List<Long> r8, int r9, Float r10) {
        List<Long> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "queryVector");
        Intrinsics.checkNotNullParameter(r2, "keys");
        final com.obric.dejavu.library.cipher.d r11 = c();
        if (r11 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return this.f12403b.a(r7, r2, r9, r10, new $$Lambda$a$qj9Au86zdcdwjNcwDfGdK_Z9oSo(r11));
    }

    public final float[] a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "key");
        com.obric.dejavu.library.cipher.d r0 = c();
        if (r0 == null) goto L6;
        DbKvResult r10 = r0.b(r9);
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r3 = this.f12402a;
        Intrinsics.checkNotNullExpressionValue(r3, LocationMonitorConst.TAG);
        IRunLog.a.a(r2, r3, "searchByKey " + r0.d() + ' ' + r10.getStatus().a() + ' ' + r10.getStatus().b(), false, 4, null);
        return r10.getVec();
    L6:
        return null;
    }

    public final boolean b() {
        com.obric.dejavu.library.cipher.d r0 = c();
        if (r0 == null) goto L8;
        long r2 = System.currentTimeMillis();
        DbStatus r4 = r0.a();
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r7 = this.f12402a;
        Intrinsics.checkNotNullExpressionValue(r7, LocationMonitorConst.TAG);
        IRunLog.a.a(r6, r7, "clear " + r0.d() + ' ' + r4.a() + ' ' + r4.b() + ", cost: " + (System.currentTimeMillis() - r2) + "ms", false, 4, null);
        if (r4.a() != 0) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public abstract com.obric.dejavu.library.cipher.d c();

    public final boolean delete(long r13) {
        com.obric.dejavu.library.cipher.d r0 = c();
        if (r0 == null) goto L8;
        long r2 = System.currentTimeMillis();
        DbStatus r4 = r0.a(String.valueOf(r13));
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r7 = this.f12402a;
        Intrinsics.checkNotNullExpressionValue(r7, LocationMonitorConst.TAG);
        IRunLog.a.a(r6, r7, "delete " + r0.d() + ' ' + r13 + ' ' + r4.a() + ' ' + r4.b() + ", cost: " + (System.currentTimeMillis() - r2) + "ms", false, 4, null);
        if (r4.a() != 0) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public final boolean insert(long r13, float[] r15) {
        Intrinsics.checkNotNullParameter(r15, "vector");
        com.obric.dejavu.library.cipher.d r0 = c();
        if (r0 == null) goto L8;
        long r2 = System.currentTimeMillis();
        DbStatus r16 = com.obric.dejavu.library.c.a((com.obric.dejavu.library.c) ZeusTransformUtils.preCheckCast(r0, com.obric.dejavu.library.c.class, "com.obric.memorydata.plugin"), String.valueOf(r13), r15, null, false, 12, null);
        RunLog r4 = RunLog.INSTANCE;
        String r12 = this.f12402a;
        Intrinsics.checkNotNullExpressionValue(r12, LocationMonitorConst.TAG);
        r4.debug(r12, "insert " + r0.d() + ' ' + r13 + ' ' + r16.a() + ' ' + r16.b() + ", cost: " + (System.currentTimeMillis() - r2) + "ms");
        if (r16.a() != 0) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }
}

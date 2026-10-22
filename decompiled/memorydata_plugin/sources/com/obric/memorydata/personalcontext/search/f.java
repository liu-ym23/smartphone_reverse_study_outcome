package com.obric.memorydata.personalcontext.search;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao;
import com.obric.memorydata.database.entity.i;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.util.EmbeddingState;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/EntitySearchPreloadUtils;", "", "<init>", "()V", "TAG", "", "PHOTO_PRELOAD_VECTOR_DB_NAME", "", "getPHOTO_PRELOAD_VECTOR_DB_NAME", "()Ljava/util/List;", "PHOTO_PRELOAD_VECTOR_DB_NAME$delegate", "Lkotlin/Lazy;", "PRELOAD_VECTOR_DB_MAP", "", "lastPhotoVectorDbPreloadTimeMap", "", "", "VECTOR_DB_PRELOAD_INTERVAL", "preloadPhotoVectorDb", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12311a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f12312b = null;
    private static final Map<String, List<String>> c = null;
    private static volatile Map<String, Long> d;

    static {
        f r0 = new f();
        f12311a = r0;
        f12312b = LazyKt.lazy($$Lambda$f$6e6NaicUeLnSqn1d44oeK0i08M.INSTANCE);
        c = MapsKt.mapOf(TuplesKt.to(AppInfo.Gallery.getPackageName(), r0.a()));
        d = (Map) ZeusTransformUtils.preCheckCast(new ConcurrentHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private f() {
    }

    private final List<String> a() {
        return (List) ZeusTransformUtils.preCheckCast(f12312b.getValue(), List.class, "com.obric.memorydata.plugin");
    }

    private static final void a(List r12, String r13, boolean r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        long r2 = System.currentTimeMillis();
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        long r6 = System.currentTimeMillis();
        com.obric.memorydata.personalcontext.vectordb.f.f12411a.a(r0, r14);
        RunLog.INSTANCE.debug("EntitySearchPreloadUtils", "packageName: " + r13 + " preloadPhotoVectorDb dbName: " + r0 + " cost: " + (System.currentTimeMillis() - r6));
        goto L4
    L6:
        RunLog.INSTANCE.debug("EntitySearchPreloadUtils", "packageName: " + r13 + " preloadPhotoVectorDb all cost: " + (System.currentTimeMillis() - r2));
    }

    private static final List b() {
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        IAppEntityVectorCopilotDao<i> r1 = s.a().getTextVectorCopilotDao(301);
        if (r1 == null) goto L7;
        String r2 = r1.getTableName();
        if (r2 == null) goto L7;
        r0.add(r2);
    L7:
        IAppEntityVectorCopilotDao<i> r3 = s.a().getImageVectorCopilotDao(301);
        if (r3 == null) goto L12;
        String r4 = r3.getTableName();
        if (r4 == null) goto L12;
        r0.add(r4);
    L12:
        IAppEntityVectorCopilotDao<i> r5 = s.a().getTextVectorCopilotDao(-304);
        if (r5 == null) goto L17;
        String r6 = r5.getTableName();
        if (r6 == null) goto L17;
        r0.add(r6);
    L17:
        IAppEntityVectorCopilotDao<i> r7 = s.a().getImageVectorCopilotDao(-304);
        if (r7 == null) goto L22;
        String r8 = r7.getTableName();
        if (r8 == null) goto L22;
        r0.add(r8);
    L22:
        IAppEntityVectorCopilotDao<i> r9 = s.a().getTextVectorCopilotDao(NetError.ERR_DISALLOWED_URL_SCHEME);
        if (r9 == null) goto L27;
        String r10 = r9.getTableName();
        if (r10 == null) goto L27;
        r0.add(r10);
    L27:
        return r0;
    }

    /* JADX INFO: renamed from: lambda$6e6NaicUeLnSqn1d-44oeK0i08M, reason: not valid java name */
    public static /* synthetic */ List m1093lambda$6e6NaicUeLnSqn1d44oeK0i08M() {
        return b();
    }

    /* JADX INFO: renamed from: lambda$lSfhSq24GI29gVadf3umPp-Q5GQ, reason: not valid java name */
    public static /* synthetic */ void m1094lambda$lSfhSq24GI29gVadf3umPpQ5GQ(List r0, String r1, boolean r2) {
        a(r0, r1, r2);
    }

    public final void a(final String r9) {
        Intrinsics.checkNotNullParameter(r9, ObricMemoryConstants.KEY_PACKAGE_NAME);
        final List r8 = (List) ZeusTransformUtils.preCheckCast(c.get(r9), List.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin");
        final boolean r2 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        RunLog.INSTANCE.debug("EntitySearchPreloadUtils", "preloadPhotoVectorDb packageName: " + r9 + " but preloadVectorDbList is empty");
        return;
    L12:
        Long r3 = (Long) ZeusTransformUtils.preCheckCast(d.get(r9), Long.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L15;
        long r4 = r3.longValue();
    L16:
        long r5 = System.currentTimeMillis();
        if (Math.abs(r5 - r4) >= 1000) goto L19;
        return;
    L19:
        d.put(r9, Long.valueOf(r5));
        if (com.obric.memorydata.personalcontext.util.c.f12363a.b() != EmbeddingState.USE_VLM) goto L22;
        r2 = true;
    L22:
        ThreadPoolContainer.Companion.execute(new $$Lambda$f$lSfhSq24GI29gVadf3umPpQ5GQ(r8, r9, r2));
        return;
    L15:
        r4 = 0;
        goto L16
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}

package com.obric.memorydata.personalcontext.external.a;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.memorydata.database.entity.hb;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.external.c;
import com.obric.memorydata.personalcontext.external.f;
import com.obric.memorydata.sdk.d;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005J\u0014\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eJ\"\u0010\u0015\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eJ\u0016\u0010\u0017\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/album/ExternalAlbumUpdateScheduler;", "", "<init>", "()V", "TAG", "", "NOTIFY_DELAY_MS", "", "notifyRunnableMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Runnable;", "onPhotoEntityDeleted", "", "deleteEntityIds", "", "entityType", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "onPhotoPreChanged", "appEntityList", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "onPhotoChanged", "successIds", "checkAlbumChanged", "albumIds", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12100a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Runnable> f12101b = null;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.external.a.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0653b extends TypeToken<List<? extends String>> {
        public C0653b() {
        }
    }

    static {
        f12100a = new b();
        f12101b = new ConcurrentHashMap();
    }

    private b() {
    }

    private static final Unit a(String r1) {
        com.obric.memorydata.personalcontext.external.a.a.f12099a.a(r1);
        return Unit.INSTANCE;
    }

    private static final void b(final String r1) {
        f12101b.remove(r1);
        d.a(new $$Lambda$b$4RgnNdYEPxpfuv6ZkQ3FDshIVDU(r1));
    }

    private final void b(List<String> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        c.f12108a.a("ExternalAlbumUpdateScheduler", "checkAlbumChanged, albumIds: " + r6);
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r8.hasNext() == false) goto L13;
        final String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        ConcurrentHashMap<String, Runnable> r1 = f12101b;
        Runnable r2 = (Runnable) ZeusTransformUtils.preCheckCast(r1.get(r9), Runnable.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        f.f12127a.a().removeCallbacks(r2);
    L12:
        f.f12127a.a().postDelay(3000, r2);
        goto L7
    L11:
        r2 = new $$Lambda$b$FlqcwfBBfpMvaUMYrTUD8lt5as(r9);
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin")).put(r9, r2);
        goto L12
    }

    public static /* synthetic */ Unit lambda$4RgnNdYEPxpfuv6ZkQ3FDshIVDU(String r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$FlqcwfBBfpMvaUMYrTUD8lt-5as, reason: not valid java name */
    public static /* synthetic */ void m1065lambda$FlqcwfBBfpMvaUMYrTUD8lt5as(String r0) {
        b(r0);
    }

    public final void a(List<? extends AppEntity> r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "appEntityList");
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == true) goto L5;
        return;
    L5:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L7:
        if (r16.hasNext() == false) goto L11;
        Object r3 = r16.next();
        if (ZeusTransformUtils.instanceOf(r3, PhotoEntity.class) == false) goto L7;
        r1.add(r3);
        goto L7
    L11:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r2.iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        r4.add(((PhotoEntity) ZeusTransformUtils.preCheckCast(r5.next(), PhotoEntity.class, "com.obric.memorydata.plugin")).getId());
        goto L13
    L15:
        List<String> r6 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        PhotoEntity r18 = (PhotoEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r17), PhotoEntity.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L51;
        String r19 = r18.get_packageName();
        if (r19 == null) goto L52;
        List<hb> r110 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoRawDbDao().queryByEntityIdListAndPackageName(r6, r19);
        Set r7 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Iterator r111 = ((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L22:
        if (r111.hasNext() == false) goto L36;
        String r8 = ((hb) ZeusTransformUtils.preCheckCast(r111.next(), hb.class, "com.obric.memorydata.plugin")).f();
        List r9 = null;
        r9 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r8, new C0653b().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L26 JsonSyntaxException -> L28
    L31:
        if (r9 == null) goto L22;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L34:
        if (r10.hasNext() == false) goto L22;
        r7.add((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"));
        goto L34
    L28:
        e = e;
        IRunLog r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r12 = new StringBuilder();
    L30:
        IRunLog.a.b(r11, "GsonExt", r12.append("toListObj error : ").append(e).toString(), null, 4, null);
    L26:
        e = e;
        r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r12 = new StringBuilder();
        goto L30
    L36:
        b(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")));
        return;
    L52:
        return;
    }

    public final void a(List<String> r11, int r12, String r13) {
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "deleteEntityIds");
        Intrinsics.checkNotNullParameter(r13, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (r12 == 301) goto L6;
        return;
    L6:
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == true) goto L8;
        return;
    L8:
        List<hb> r15 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoRawDbDao().queryByEntityIdListAndPackageName(r14, r13);
        Set r16 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r17.hasNext() == false) goto L24;
        String r18 = ((hb) ZeusTransformUtils.preCheckCast(r17.next(), hb.class, "com.obric.memorydata.plugin")).f();
        List r1 = null;
        r1 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r18, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L14 JsonSyntaxException -> L16
    L19:
        if (r1 == null) goto L10;
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L22:
        if (r19.hasNext() == false) goto L10;
        r16.add((String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.memorydata.plugin"));
        goto L22
    L16:
        e = e;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = new StringBuilder();
    L18:
        IRunLog.a.b(r4, "GsonExt", r3.append("toListObj error : ").append(e).toString(), null, 4, null);
    L14:
        e = e;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r3 = new StringBuilder();
        goto L18
    L24:
        b(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")));
    }

    public final void a(List<? extends AppEntity> r5, List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "appEntityList");
        Intrinsics.checkNotNullParameter(r8, "successIds");
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == true) goto L5;
        return;
    L5:
        Set r9 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        Object r2 = r11.next();
        if (ZeusTransformUtils.instanceOf(r2, PhotoEntity.class) == false) goto L7;
        r0.add(r2);
        goto L7
    L11:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L13:
        if (r13.hasNext() == false) goto L17;
        Object r3 = r13.next();
        if (r9.contains(((PhotoEntity) ZeusTransformUtils.preCheckCast(r3, PhotoEntity.class, "com.obric.memorydata.plugin")).getId()) == false) goto L13;
        r1.add(r3);
        goto L13
    L17:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L19:
        if (r16.hasNext() == false) goto L21;
        CollectionsKt.addAll(r15, (Iterable) ZeusTransformUtils.preCheckCast(((PhotoEntity) ZeusTransformUtils.preCheckCast(r16.next(), PhotoEntity.class, "com.obric.memorydata.plugin")).getInAlbum(), Iterable.class, "com.obric.memorydata.plugin"));
        goto L19
    L21:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L23:
        if (r19.hasNext() == false) goto L25;
        r18.add(((AlbumEntity) ZeusTransformUtils.preCheckCast(r19.next(), AlbumEntity.class, "com.obric.memorydata.plugin")).getId());
        goto L23
    L25:
        b(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));
    }
}

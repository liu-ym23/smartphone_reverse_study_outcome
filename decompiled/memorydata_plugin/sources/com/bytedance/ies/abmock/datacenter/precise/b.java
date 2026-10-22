package com.bytedance.ies.abmock.datacenter.precise;

import com.bytedance.ies.abmock.datacenter.storage.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001b\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016¢\u0006\u0002\u0010\u0019J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u001a\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/precise/PreciseExposure;", "Lcom/bytedance/ies/abmock/datacenter/precise/IVidExposureHandler;", "key", "", "(Ljava/lang/String;)V", "currentUid", "extraDidExposureHandler", "Lcom/bytedance/ies/abmock/datacenter/precise/ExposureHandler;", "getExtraDidExposureHandler", "()Lcom/bytedance/ies/abmock/datacenter/precise/ExposureHandler;", "extraDidExposureHandler$delegate", "Lkotlin/Lazy;", "extraUidExposureHandler", "appendExposureVids", "", "vids", "", "isUid", "", "([Ljava/lang/String;Z)V", "checkAndClearExposureVids", "allVids", "([Ljava/lang/String;)V", "clearExposureVids", "getExposureVids", "()[Ljava/lang/String;", "getExtraUidExposureHandler", "getStorageKey", "newExposureHandler", "storageKey", "vidsStringToList", "", "Companion", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2695a = null;
    private static final ConcurrentHashMap<String, b> f = null;
    private static final Lazy<e> g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2696b;
    private volatile String c;
    private volatile com.bytedance.ies.abmock.datacenter.precise.a d;
    private final Lazy e;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000bR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/precise/PreciseExposure$Companion;", "", "()V", "dataStorage", "Lcom/bytedance/ies/abmock/datacenter/storage/IDataStorage;", "getDataStorage", "()Lcom/bytedance/ies/abmock/datacenter/storage/IDataStorage;", "dataStorage$delegate", "Lkotlin/Lazy;", "keyMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/ies/abmock/datacenter/precise/PreciseExposure;", "getCombineExposureVids", "", "getPreciseExposure", "key", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final e a() {
            Object r2 = b.b().getValue();
            Intrinsics.checkNotNullExpressionValue(r2, "<get-dataStorage>(...)");
            return (e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.memorydata.plugin");
        }

        public final Set<String> b() {
            Set<String> r5 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
            ConcurrentHashMap r0 = b.c();
            monitor-enter(r0);
            Iterator r1 = ((Map) ZeusTransformUtils.preCheckCast(b.c(), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();     // Catch: Throwable -> L11
        L6:
            if (r1.hasNext() == false) goto L8;
            b r2 = (b) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
            CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"), r2.a());     // Catch: Throwable -> L11
            goto L6
        L8:
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r0);
            return r5;
        L11:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ies.abmock.datacenter.precise.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"com/bytedance/ies/abmock/datacenter/precise/PreciseExposure$newExposureHandler$vidStorage$1", "Lcom/bytedance/ies/abmock/datacenter/precise/ExposureHandler$IVidStorage;", "loadVids", "", "", "()[Ljava/lang/String;", "saveVids", "", "vids", "([Ljava/lang/String;)V", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0137b implements com.bytedance.ies.abmock.datacenter.precise.a.InterfaceC0136a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f2697a;

        C0137b(String r1) {
            this.f2697a = r1;
        }

        @Override // com.bytedance.ies.abmock.datacenter.precise.a.InterfaceC0136a
        public void a(String[] r2) {
            Intrinsics.checkNotNullParameter(r2, "vids");
            b.f2695a.a().b(this.f2697a, r2);
        }

        @Override // com.bytedance.ies.abmock.datacenter.precise.a.InterfaceC0136a
        public String[] a() {
            String[] r2 = b.f2695a.a().a(this.f2697a, new String[0]);
            Intrinsics.checkNotNullExpressionValue(r2, "dataStorage.getStringArr…geKey, arrayOf<String>())");
            return r2;
        }
    }

    static {
        f2695a = new a(null);
        f = new ConcurrentHashMap();
        g = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(PreciseExposure$Companion$dataStorage$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ com.bytedance.ies.abmock.datacenter.precise.a a(b r0, String r1) {
        return r0.a(r1);
    }

    private final com.bytedance.ies.abmock.datacenter.precise.a a(String r3) {
        return new com.bytedance.ies.abmock.datacenter.precise.a((com.bytedance.ies.abmock.datacenter.precise.a.InterfaceC0136a) ZeusTransformUtils.preCheckCast(new C0137b(r3), com.bytedance.ies.abmock.datacenter.precise.a.InterfaceC0136a.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ String a(b r0) {
        return r0.e();
    }

    public static final /* synthetic */ Lazy b() {
        return g;
    }

    public static final /* synthetic */ ConcurrentHashMap c() {
        return f;
    }

    private final com.bytedance.ies.abmock.datacenter.precise.a d() {
        return (com.bytedance.ies.abmock.datacenter.precise.a) ZeusTransformUtils.preCheckCast(this.e.getValue(), com.bytedance.ies.abmock.datacenter.precise.a.class, "com.obric.memorydata.plugin");
    }

    private final String e() {
        return "__extra_for_" + this.f2696b;
    }

    private final com.bytedance.ies.abmock.datacenter.precise.a f() {
        String r0 = c.f2698a.a();
        if (Intrinsics.areEqual(this.c, r0) == true) goto L6;
        this.c = r0;
        this.d = a('{' + e() + "}_{" + this.c + '}');
    L6:
        return this.d;
    }

    public String[] a() {
        String[] r0 = d().a();
        com.bytedance.ies.abmock.datacenter.precise.a r2 = f();
        if (r2 == null) goto L9;
        String[] r3 = r2.a();
        if (r3 == null) goto L9;
        return (String[]) ZeusTransformUtils.preCheckCast(ArraysKt.plus(r0, r3), String[].class, "com.obric.memorydata.plugin");
    L9:
        return r0;
    }
}

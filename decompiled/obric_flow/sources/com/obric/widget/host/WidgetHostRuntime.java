package com.obric.widget.host;

import android.content.Context;
import com.obric.widget.host.runtime.WidgetRenderStateStore;
import com.obric.widget.host.runtime.WidgetRuntimeServices;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\"\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J4\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007J4\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\b\u0010#\u001a\u00020\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/widget/host/WidgetHostRuntime;", "", "<init>", "()V", "LAUNCHER_HOST_ID", "", "hosts", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/widget/host/WidgetHost;", "hostFactories", "Lcom/obric/widget/host/WidgetHostFactory;", "runtimeServices", "Lcom/obric/widget/host/runtime/WidgetRuntimeServices;", "runtimeServicesLock", "registerHostFactory", "", "hostId", "factory", "replaceExisting", "", "unregisterHostFactory", "createHost", "context", "Landroid/content/Context;", "contract", "Lcom/obric/widget/host/WidgetHostContract;", "getHost", "launcherHost", "scope", "Lkotlinx/coroutines/CoroutineScope;", "perfReporter", "Lcom/obric/widget/host/WidgetPerfReporter;", "implementationServices", "Lcom/obric/widget/host/WidgetHostImplementationServices;", "clearRuntimeServices", "destroyAll", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetHostRuntime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetHostRuntime.kt\ncom/obric/widget/host/WidgetHostRuntime\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,128:1\n72#2,2:129\n72#2,2:132\n1#3:131\n1#3:134\n1863#4,2:135\n*S KotlinDebug\n*F\n+ 1 WidgetHostRuntime.kt\ncom/obric/widget/host/WidgetHostRuntime\n*L\n46#1:129,2\n73#1:132,2\n46#1:131\n73#1:134\n111#1:135,2\n*E\n"})
public final class WidgetHostRuntime {
    public static final WidgetHostRuntime INSTANCE = null;
    public static final String LAUNCHER_HOST_ID = "launcher";
    private static final ConcurrentHashMap<String, WidgetHostFactory> hostFactories = null;
    private static final ConcurrentHashMap<String, WidgetHost> hosts = null;
    private static final ConcurrentHashMap<String, WidgetRuntimeServices> runtimeServices = null;
    private static final Object runtimeServicesLock = null;

    static {
        INSTANCE = new WidgetHostRuntime();
        hosts = new ConcurrentHashMap();
        hostFactories = new ConcurrentHashMap();
        runtimeServices = new ConcurrentHashMap();
        runtimeServicesLock = new Object();
    }

    private WidgetHostRuntime() {
    }

    @JvmStatic
    public static final void clearRuntimeServices(String r5) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        runtimeServices.remove(r5);
    }

    @JvmStatic
    @JvmOverloads
    public static final WidgetHost createHost(String r5, Context r10) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        Intrinsics.checkNotNullParameter(r10, "context");
        return createHost$default(r5, r10, null, 4, null);
    }

    public static /* synthetic */ WidgetHost createHost$default(String r5, Context r10, WidgetHostContract r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L6;
        r11 = new DefaultWidgetHostContract(r10.getApplicationContext());
    L6:
        return createHost(r5, r10, r11);
    }

    @JvmStatic
    public static final void destroyAll() {
        Iterator<T> r5 = hosts.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((WidgetHost) r5.next()).destroy();
        goto L4
    L6:
        hosts.clear();
        runtimeServices.clear();
    }

    @JvmStatic
    public static final WidgetHost getHost(String r5) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        return hosts.get(r5);
    }

    @JvmStatic
    @JvmOverloads
    @WidgetHostImplementationApi
    public static final WidgetHostImplementationServices implementationServices(Context r10, String r11, CoroutineScope r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "hostId");
        Intrinsics.checkNotNullParameter(r12, "scope");
        return implementationServices$default(r10, r11, r12, null, false, 24, null);
    }

    public static /* synthetic */ WidgetHostImplementationServices implementationServices$default(Context r5, String r10, CoroutineScope r11, WidgetPerfReporter r12, boolean r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r12 = WidgetPerfReporter.Companion.getNO_OP();
    L6:
        if ((r14 & 16) == 0) goto L9;
        r13 = false;
    L9:
        return implementationServices(r5, r10, r11, r12, r13);
    }

    @JvmStatic
    public static final WidgetHost launcherHost(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return createHost$default("launcher", r5, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void registerHostFactory(String r5, WidgetHostFactory r10) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        Intrinsics.checkNotNullParameter(r10, "factory");
        registerHostFactory$default(r5, r10, false, 4, null);
    }

    public static /* synthetic */ void registerHostFactory$default(String r5, WidgetHostFactory r10, boolean r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = false;
    L5:
        registerHostFactory(r5, r10, r11);
    }

    @JvmStatic
    @JvmOverloads
    @WidgetHostImplementationApi
    public static final WidgetRuntimeServices runtimeServices(Context r10, String r11, CoroutineScope r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "hostId");
        Intrinsics.checkNotNullParameter(r12, "scope");
        return runtimeServices$default(r10, r11, r12, null, false, 24, null);
    }

    public static /* synthetic */ WidgetRuntimeServices runtimeServices$default(Context r5, String r10, CoroutineScope r11, WidgetPerfReporter r12, boolean r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r12 = WidgetPerfReporter.Companion.getNO_OP();
    L6:
        if ((r14 & 16) == 0) goto L9;
        r13 = false;
    L9:
        return runtimeServices(r5, r10, r11, r12, r13);
    }

    @JvmStatic
    public static final void unregisterHostFactory(String r5) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        hostFactories.remove(r5);
    }

    @JvmStatic
    @JvmOverloads
    public static final WidgetHost createHost(String r5, Context r10, WidgetHostContract r11) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "contract");
        Context r12 = r10.getApplicationContext();
        ConcurrentHashMap<String, WidgetHost> r13 = hosts;
        WidgetHost r14 = r13.get(r5);
        if (r14 != null) goto L12;
        WidgetHostFactory r15 = hostFactories.get(r5);
        if (r15 != null) goto L7;
        r15 = DefaultWidgetHostFactory.INSTANCE;
    L7:
        Intrinsics.checkNotNull(r12);
        WidgetHost r16 = r15.create(r5, r12, r11);
        WidgetHost r17 = r13.putIfAbsent(r5, r16);
        if (r17 != null) goto L10;
        r14 = r16;
        goto L12
    L10:
        r14 = r17;
    L12:
        return r14;
    }

    @JvmStatic
    @JvmOverloads
    @WidgetHostImplementationApi
    public static final WidgetHostImplementationServices implementationServices(Context r10, String r11, CoroutineScope r12, WidgetPerfReporter r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "hostId");
        Intrinsics.checkNotNullParameter(r12, "scope");
        Intrinsics.checkNotNullParameter(r13, "perfReporter");
        return implementationServices$default(r10, r11, r12, r13, false, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void registerHostFactory(String r5, WidgetHostFactory r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        Intrinsics.checkNotNullParameter(r10, "factory");
        hostFactories.put(r5, r10);
        if (r11 == false) goto L8;
        WidgetHost r12 = hosts.remove(r5);
        if (r12 == null) goto L9;
        r12.destroy();
        return;
    L9:
        return;
    }

    @JvmStatic
    @JvmOverloads
    @WidgetHostImplementationApi
    public static final WidgetRuntimeServices runtimeServices(Context r10, String r11, CoroutineScope r12, WidgetPerfReporter r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "hostId");
        Intrinsics.checkNotNullParameter(r12, "scope");
        Intrinsics.checkNotNullParameter(r13, "perfReporter");
        return runtimeServices$default(r10, r11, r12, r13, false, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    @WidgetHostImplementationApi
    public static final WidgetHostImplementationServices implementationServices(Context r5, String r10, CoroutineScope r11, WidgetPerfReporter r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "hostId");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r12, "perfReporter");
        return new DefaultWidgetHostImplementationServices(runtimeServices(r5, r10, r11, r12, r13));
    }

    @JvmStatic
    @JvmOverloads
    @WidgetHostImplementationApi
    public static final WidgetRuntimeServices runtimeServices(Context r10, String r11, CoroutineScope r12, WidgetPerfReporter r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "hostId");
        Intrinsics.checkNotNullParameter(r12, "scope");
        Intrinsics.checkNotNullParameter(r13, "perfReporter");
        Context r5 = r10.getApplicationContext();
        Object r15 = runtimeServicesLock;
        monitor-enter(r15);
        if (r14 == true) goto L19;
    L8:
        ConcurrentHashMap<String, WidgetRuntimeServices> r16 = runtimeServices;     // Catch: Throwable -> L6
        WidgetRuntimeServices r17 = r16.get(r11);     // Catch: Throwable -> L6
        if (r17 != null) goto L14;
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L6
        WidgetRenderStateStore r18 = null;
        r17 = new WidgetRuntimeServices(r5, r11, r12, r13, r18, 16, null);     // Catch: Throwable -> L6
        WidgetRuntimeServices r19 = r16.putIfAbsent(r11, r17);     // Catch: Throwable -> L6
        if (r19 == null) goto L14;
        r17 = r19;
    L14:
        WidgetRuntimeServices r20 = r17;     // Catch: Throwable -> L6
        monitor-exit(r15);
        return r20;
    L6:
        th = move-exception;
        throw th;
    L19:
        runtimeServices.remove(r11);     // Catch: Throwable -> L6
        goto L8
    }
}

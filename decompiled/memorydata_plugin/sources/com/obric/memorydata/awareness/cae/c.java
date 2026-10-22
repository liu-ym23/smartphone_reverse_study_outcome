package com.obric.memorydata.awareness.cae;

import android.os.Bundle;
import android.os.RemoteException;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.sdk.awareness.model.LocationInfo;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u0019\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\rH\u0002J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\rH\u0002J\u001a\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u000fH\u0002J\f\u0010!\u001a\u00020\"*\u00020\u001fH\u0002J\u0014\u0010#\u001a\u00020\u0005*\u00020\u001f2\u0006\u0010$\u001a\u00020\u0005H\u0002J\u001b\u0010%\u001a\u0004\u0018\u00010&*\u00020\u001f2\u0006\u0010$\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010'R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006("}, d2 = {"Lcom/obric/memorydata/awareness/cae/CaePoiObservationDispatcher;", "", "<init>", "()V", "TAG", "", "logger", "Lcom/obric/memorydata/middleware/api/logging/ModuleLogger;", "eventExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/ExecutorService;", "activePoiManager", "Lcom/obric/cae/libs/location/poi/IStarPoiManager;", "hasReceivedCallback", "", "eventDeduplicator", "Lcom/obric/memorydata/awareness/cae/PoiEventDeduplicator;", "callback", "com/obric/memorydata/awareness/cae/CaePoiObservationDispatcher$callback$1", "Lcom/obric/memorydata/awareness/cae/CaePoiObservationDispatcher$callback$1;", "onLocationServiceConnected", "", "service", "Lcom/obric/cae/libs/location/IStarLocationService;", "onLocationServiceDisconnected", "register", "manager", "restorePoiObservation", "handlePoiObservation", "poiData", "Landroid/os/Bundle;", "stateSync", "toPoiObservation", "Lcom/obric/memorydata/awareness/cae/PoiObservation;", "getStringOrEmptyCompat", "key", "getLongCompat", "", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Long;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8571a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final o f8572b = null;
    private static final ExecutorService c = null;
    private static com.obric.cae.libs.location.poi.d d;
    private static boolean e;
    private static final g f = null;
    private static final a g = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/awareness/cae/CaePoiObservationDispatcher$callback$1", "Lcom/obric/cae/libs/location/poi/IStarPoiCallback$Stub;", "onNearPoiReport", "", "poiData", "Landroid/os/Bundle;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends com.obric.cae.libs.location.poi.c.a {
        a() {
        }

        private static final void b(Bundle r2) {
            c.a(c.f8571a, r2, false);
            c r3 = c.f8571a;
            c.a(true);
        }

        /* JADX INFO: renamed from: lambda$DELL6AG-MCCQfJQnwd1VmB1HoVY, reason: not valid java name */
        public static /* synthetic */ void m493lambda$DELL6AGMCCQfJQnwd1VmB1HoVY(Bundle r0) {
            b(r0);
        }

        @Override // com.obric.cae.libs.location.poi.c
        public void a(Bundle r3) {
            RunLog.INSTANCE.debug("CaePoiObservationDispatcher", "收到实时 POI 回调，data=" + r3);
            if (r3 == null) goto L5;
            final Bundle r2 = new Bundle(r3);
        L6:
            c.b().execute(new $$Lambda$c$a$DELL6AGMCCQfJQnwd1VmB1HoVY(r2));
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
        f8571a = new c();
        f8572b = com.obric.memorydata.middleware.api.logging.b.f11611a.a("CaePoiObservationDispatcher");
        c = Executors.newSingleThreadExecutor($$Lambda$c$_o9A58uE4vqZR5CtDZ60yvAlxfA.INSTANCE);
        f = new g();
        g = new a();
    }

    private c() {
    }

    private final i a(Bundle r11) {
        return new i(a(r11, "poi_id"), a(r11, "poi_name"), a(r11, "aoi_id"), a(r11, "aoi_name"), a(r11, "new_type_name_l1"), a(r11, "new_type_name_l2"), a(r11, "new_type_name_l3"), b(r11, "timestamp"));
    }

    private final String a(Bundle r1, String r2) {
        Object r0 = r1.get(r2);
        if (r0 == null) goto L5;
        String r3 = r0.toString();
    L6:
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    L5:
        r3 = null;
        goto L6
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "cae_poi_observation");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void a(Bundle r18, boolean r19) {
        boolean r2 = true;
        if (r18 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        Map<String, ? extends Object> r5 = null;
        if (r18 == null) goto L11;
        Object r6 = r18.get("is_enter");
    L13:
        if (ZeusTransformUtils.instanceOf(r6, Boolean.class) == false) goto L15;
        Boolean r7 = (Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin");
    L16:
        PoiEventType r8 = PoiEventType.Companion.a(r7);
        o r9 = f8572b;
        com.obric.memorydata.middleware.api.logging.e r15 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L26;
        com.obric.memorydata.middleware.api.logging.g r10 = new com.obric.memorydata.middleware.api.logging.g();
        r10.a("state_sync", Boolean.valueOf(r19));
        if (r18 == null) goto L21;
        boolean r11 = true;
    L22:
        r10.a("has_poi_data", Boolean.valueOf(r11));
        r10.a("has_is_enter", Boolean.valueOf(r4));
        Object r12 = r7;
        if (r7 != null) goto L25;
        r12 = "missing";
    L25:
        r10.a("is_enter", r12);
        r10.a("event_name", r8.getEventName());
        Unit r1 = Unit.INSTANCE;
        r9.a("POI 回调解析完成", r15, r10.a());
        goto L26
    L21:
        r11 = false;
    L26:
        if (r18 != null) goto L28;
    L31:
        i r0 = null;
    L32:
        g r3 = f;
        if (r19 == false) goto L43;
        r3.a(r0, r8);
        IRunLog r13 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r14 = new StringBuilder().append("POI 事件去重基线已恢复，hasPoi=");
        if (r0 != null) goto L37;
    L39:
        r2 = false;
    L40:
        IRunLog.a.a(r13, "CaePoiObservationDispatcher", r14.append(r2).toString(), false, 4, null);
        return;
    L37:
        if (r0.d() != true) goto L39;
    L43:
        if (r3.b(r0, r8) == true) goto L46;
        RunLog.INSTANCE.debug("CaePoiObservationDispatcher", "POI 回调未产生新事件：observation=" + r0);
        return;
    L46:
        String r16 = "";
        if (AppContext.INSTANCE.isDebug() == false) goto L62;
        StringBuilder r17 = new StringBuilder().append("：poiId=");
        if (r0 == null) goto L51;
        String r20 = r0.a();
    L52:
        if (r20 != null) goto L54;
        r20 = "";
    L54:
        StringBuilder r21 = r17.append(r20).append("，poiName=");
        if (r0 == null) goto L57;
        String r22 = r0.b();
    L58:
        if (r22 == null) goto L61;
        r16 = r22;
    L61:
        r16 = r21.append(r16).toString();
        goto L62
    L57:
        r22 = null;
        goto L58
    L51:
        r20 = null;
    L62:
        Object r23 = FeatureManager.INSTANCE.getFeature("current_location_info");
        if (ZeusTransformUtils.instanceOf(r23, LocationInfo.class) == false) goto L65;
        LocationInfo r24 = (LocationInfo) ZeusTransformUtils.preCheckCast(r23, LocationInfo.class, "com.obric.memorydata.plugin");
    L66:
        if (r24 == null) goto L68;
        String r25 = r24.getLocationType();
    L70:
        if (h.f8599a.a(r25) == false) goto L73;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaePoiObservationDispatcher", "当前位置为 " + r25 + "，忽略 " + r8.getEventName() + r16, false, 4, null);
        return;
    L73:
        if (r0 == null) goto L75;
        r5 = r0.f();
    L75:
        if (r5 != null) goto L77;
        r5 = MapsKt.emptyMap();
    L77:
        AwarenessManager.INSTANCE.dispatchAwarenessEvent(r8.getEventName(), r5);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaePoiObservationDispatcher", "当前位置为 " + r25 + "，已发送 " + r8.getEventName() + r16, false, 4, null);
        return;
    L68:
        r25 = null;
        goto L70
    L65:
        r24 = null;
        goto L66
    L28:
        if (r18.keySet().isEmpty() == true) goto L31;
        r0 = a(r18);
        goto L32
    L15:
        r7 = null;
        goto L16
    L11:
        r6 = null;
        goto L13
    L5:
        if (r18.containsKey("is_enter") != true) goto L7;
        r4 = true;
        goto L8
    }

    private final void a(com.obric.cae.libs.location.poi.d r8) {
        com.obric.cae.libs.location.poi.d r7 = (com.obric.cae.libs.location.poi.d) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.cae.libs.location.poi.d.class, "com.obric.memorydata.plugin");
        r7.a((com.obric.cae.libs.location.poi.c) ZeusTransformUtils.preCheckCast(g, com.obric.cae.libs.location.poi.c.class, "com.obric.memorydata.plugin"));     // Catch: RemoteException -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaePoiObservationDispatcher", "POI 回调注册成功", false, 4, null);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        RunLog.INSTANCE.warn("CaePoiObservationDispatcher", "Remote POI callback registration failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private static final void a(com.obric.cae.libs.location.poi.d r6, Bundle r7) {
        com.obric.cae.libs.location.poi.d r8 = (com.obric.cae.libs.location.poi.d) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.cae.libs.location.poi.d.class, "com.obric.memorydata.plugin");
        if (d == r8) goto L5;
    L7:
        RunLog.INSTANCE.debug("CaePoiObservationDispatcher", "已收到实时 POI 回调，忽略较旧的 POI 快照");
        return;
    L5:
        if (e == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaePoiObservationDispatcher", "开始从 CAE 快照恢复 POI 事件去重基线", false, 4, null);
        f8571a.a(r7, true);
    }

    public static final /* synthetic */ void a(c r0, Bundle r1, boolean r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(boolean r0) {
        e = r0;
    }

    private final Long b(Bundle r1, String r2) {
        Object r0 = r1.get(r2);
        if (ZeusTransformUtils.instanceOf(r0, Number.class) == false) goto L6;
        return Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue());
    L6:
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L11;
        return null;
    L11:
        return StringsKt.toLongOrNull((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ ExecutorService b() {
        return c;
    }

    private static final void b(com.obric.cae.libs.location.b r6) {
        com.obric.cae.libs.location.b r7 = (com.obric.cae.libs.location.b) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.cae.libs.location.b.class, "com.obric.memorydata.plugin");
        com.obric.cae.libs.location.poi.d r0 = null;
        if (r7 != null) goto L13;
    L8:
        c r8 = f8571a;
        d = r0;
        e = false;
        if (r0 == null) goto L11;
        r8.a(r0);
        r8.b(r0);
        return;
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaePoiObservationDispatcher", "POI manager is unavailable after location service connected", null, 4, null);
        return;
    L13:
        r0 = r7.i();     // Catch: RemoteException -> L6
    L6:
        e = move-exception;
        RunLog.INSTANCE.warn("CaePoiObservationDispatcher", "Failed to obtain POI manager", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L8
    }

    private final void b(com.obric.cae.libs.location.poi.d r2) {
        final com.obric.cae.libs.location.poi.d r1 = (com.obric.cae.libs.location.poi.d) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.cae.libs.location.poi.d.class, "com.obric.memorydata.plugin");
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$c$2xR0a9mnXUjXgYHjYeiuhyH0K8(r1));
    }

    private static final void c() {
        d = null;
        e = false;
    }

    private static final void c(com.obric.cae.libs.location.poi.d r3) {
        final com.obric.cae.libs.location.poi.d r4 = (com.obric.cae.libs.location.poi.d) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.cae.libs.location.poi.d.class, "com.obric.memorydata.plugin");
        final Bundle r0 = r4.b();     // Catch: RemoteException -> L6
        c.execute(new $$Lambda$c$4O8WsMsJfob3Df7knnxyJZsSBY(r4, r0));
        return;
    L6:
        e = move-exception;
        RunLog.INSTANCE.warn("CaePoiObservationDispatcher", "Remote POI snapshot query failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: lambda$2xR0a9mnXUjXgY-HjYeiuhyH0K8, reason: not valid java name */
    public static /* synthetic */ void m491lambda$2xR0a9mnXUjXgYHjYeiuhyH0K8(com.obric.cae.libs.location.poi.d r0) {
        c(r0);
    }

    /* JADX INFO: renamed from: lambda$4O-8WsMsJfob3Df7knnxyJZsSBY, reason: not valid java name */
    public static /* synthetic */ void m492lambda$4O8WsMsJfob3Df7knnxyJZsSBY(com.obric.cae.libs.location.poi.d r0, Bundle r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$Mw8VCW2Vi5eWlRAqMnw_mr7nalQ() {
        c();
    }

    public static /* synthetic */ Thread lambda$_o9A58uE4vqZR5CtDZ60yvAlxfA(Runnable r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$cWtVpupgNT5TZpNdCdnHkeWmuy0(com.obric.cae.libs.location.b r0) {
        b(r0);
    }

    public final void a() {
        c.execute($$Lambda$c$Mw8VCW2Vi5eWlRAqMnw_mr7nalQ.INSTANCE);
    }

    public final void a(com.obric.cae.libs.location.b r2) {
        final com.obric.cae.libs.location.b r1 = (com.obric.cae.libs.location.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.cae.libs.location.b.class, "com.obric.memorydata.plugin");
        c.execute(new $$Lambda$c$cWtVpupgNT5TZpNdCdnHkeWmuy0(r1));
    }
}

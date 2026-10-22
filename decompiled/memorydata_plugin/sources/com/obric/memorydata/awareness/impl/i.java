package com.obric.memorydata.awareness.impl;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/awareness/impl/DataCenterReporter;", "", "<init>", "()V", "TAG", "", "MAX_RETRY", "", "RETRY_DELAY_MS", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "reportInitialStates", "context", "Landroid/content/Context;", "locationManager", "Lcom/android/datacenter/feature/LocationReportManager;", "registerFeatureListeners", "reportHomeCompanyStates", "currentLocationType", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f8695a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f8696b = null;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016J<\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016¨\u0006\u000f"}, d2 = {"com/obric/memorydata/awareness/impl/DataCenterReporter$registerFeatureListeners$1", "Lcom/obric/memorydata/awareness/api/EventListener;", "observable", "", "onEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.awareness.api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.a.a.a.a f8697a;

        a(com.a.a.a.a r1) {
            this.f8697a = r1;
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r2, Object r3, Object r4, Map<String, ? extends Object> r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "feature");
            RunLog.INSTANCE.debug("DataCenterReporter", "current location type changed: " + r4);
            i.a(i.f8695a, r4, this.f8697a);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r2, Map<String, ? extends Object> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "eventName");
        }

        @Override // com.obric.memorydata.awareness.api.a
        public boolean a() {
            return true;
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void b(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
            com.obric.memorydata.awareness.api.a.C0430a.a(this, r3, r4, r5, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016J<\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016J<\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016¨\u0006\u0010"}, d2 = {"com/obric/memorydata/awareness/impl/DataCenterReporter$registerFeatureListeners$2", "Lcom/obric/memorydata/awareness/api/EventListener;", "observable", "", "onEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "onFeatureEvent", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.awareness.api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.a.a.a.a f8698a;

        b(com.a.a.a.a r1) {
            this.f8698a = r1;
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r1, Object r2, Object r3, Map<String, ? extends Object> r4) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "feature");
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r2, Map<String, ? extends Object> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "eventName");
        }

        @Override // com.obric.memorydata.awareness.api.a
        public boolean a() {
            return true;
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void b(String r4, Object r5, Object r6, Map<String, ? extends Object> r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "feature");
            if (ZeusTransformUtils.instanceOf(r6, List.class) == false) goto L5;
            List r9 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        L6:
            if (r9 != null) goto L9;
            return;
        L9:
            if (r9.size() == 2) goto L11;
            return;
        L11:
            if (ZeusTransformUtils.instanceOf(r9.get(0), Number.class) == true) goto L13;
            return;
        L13:
            if (ZeusTransformUtils.instanceOf(r9.get(1), Number.class) == false) goto L18;
            Object r10 = r9.get(0);
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Number");
            double r1 = ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).doubleValue();
            Object r11 = r9.get(1);
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Number");
            double r12 = ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).doubleValue();
            RunLog.INSTANCE.debug("DataCenterReporter", "home gps changed: lon=" + r1 + ", lat=" + r12);
            this.f8698a.a(r1, r12);
            return;
        L18:
            return;
        L5:
            r9 = null;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016J<\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016J<\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016¨\u0006\u0010"}, d2 = {"com/obric/memorydata/awareness/impl/DataCenterReporter$registerFeatureListeners$3", "Lcom/obric/memorydata/awareness/api/EventListener;", "observable", "", "onEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "onFeatureEvent", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements com.obric.memorydata.awareness.api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.a.a.a.a f8699a;

        c(com.a.a.a.a r1) {
            this.f8699a = r1;
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r1, Object r2, Object r3, Map<String, ? extends Object> r4) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "feature");
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r2, Map<String, ? extends Object> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "eventName");
        }

        @Override // com.obric.memorydata.awareness.api.a
        public boolean a() {
            return true;
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void b(String r4, Object r5, Object r6, Map<String, ? extends Object> r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "feature");
            if (ZeusTransformUtils.instanceOf(r6, List.class) == false) goto L5;
            List r9 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        L6:
            if (r9 != null) goto L9;
            return;
        L9:
            if (r9.size() == 2) goto L11;
            return;
        L11:
            if (ZeusTransformUtils.instanceOf(r9.get(0), Number.class) == true) goto L13;
            return;
        L13:
            if (ZeusTransformUtils.instanceOf(r9.get(1), Number.class) == false) goto L18;
            Object r10 = r9.get(0);
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Number");
            double r1 = ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).doubleValue();
            Object r11 = r9.get(1);
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Number");
            double r12 = ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).doubleValue();
            RunLog.INSTANCE.debug("DataCenterReporter", "company gps changed: lon=" + r1 + ", lat=" + r12);
            this.f8699a.b(r1, r12);
            return;
        L18:
            return;
        L5:
            r9 = null;
            goto L6
        }
    }

    static {
        f8695a = new i();
        f8696b = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    private i() {
    }

    private final void a(Context r14, com.a.a.a.a r15) {
        RunLog.INSTANCE.debug("DataCenterReporter", "pkg: " + ((Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin")).getPackageName() + ", ts: " + System.currentTimeMillis());
        Object r16 = FeatureManager.INSTANCE.getFeature("current_location_type");
        RunLog.INSTANCE.debug("DataCenterReporter", "initial current location type feature: " + r16);
        a(r16, r15);
        Object r13 = FeatureManager.INSTANCE.getFeature("location_home_gps");
        RunLog.INSTANCE.debug("DataCenterReporter", "initial home gps feature: " + r13);
        List r0 = null;
        if (ZeusTransformUtils.instanceOf(r13, List.class) == false) goto L5;
        List r17 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
    L7:
        if (r17 != null) goto L9;
    L15:
        Object r18 = FeatureManager.INSTANCE.getFeature("location_company_gps");
        RunLog.INSTANCE.debug("DataCenterReporter", "initial company gps feature: " + r18);
        if (ZeusTransformUtils.instanceOf(r18, List.class) == false) goto L18;
        r0 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");
    L18:
        if (r0 != null) goto L20;
        return;
    L20:
        if (r0.size() == 2) goto L22;
        return;
    L22:
        if (ZeusTransformUtils.instanceOf(r0.get(0), Number.class) == true) goto L24;
        return;
    L24:
        if (ZeusTransformUtils.instanceOf(r0.get(1), Number.class) == false) goto L30;
        Object r19 = r0.get(0);
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.Number");
        double r6 = ((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        Object r110 = r0.get(1);
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlin.Number");
        double r1 = ((Number) ZeusTransformUtils.preCheckCast(r110, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        RunLog.INSTANCE.debug("DataCenterReporter", "report company gps: lon=" + r6 + ", lat=" + r1);
        r15.b(r6, r1);
        return;
    L30:
        return;
    L9:
        if (r17.size() != 2) goto L15;
        if (ZeusTransformUtils.instanceOf(r17.get(0), Number.class) == false) goto L15;
        if (ZeusTransformUtils.instanceOf(r17.get(1), Number.class) == false) goto L15;
        Object r7 = r17.get(0);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.Number");
        double r8 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        Object r111 = r17.get(1);
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.Number");
        double r9 = ((Number) ZeusTransformUtils.preCheckCast(r111, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        RunLog.INSTANCE.debug("DataCenterReporter", "report home gps: lon=" + r8 + ", lat=" + r9);
        r15.a(r8, r9);
        goto L15
    L5:
        r17 = null;
        goto L7
    }

    private final void a(com.a.a.a.a r4) {
        RunLog.INSTANCE.debug("DataCenterReporter", "register listeners for current location type and home/company gps");
        AwarenessManager.INSTANCE.registerAwarenessEvent("current_location_type", (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(new a(r4), com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        AwarenessManager.INSTANCE.registerAwarenessEvent("location_home_gps", (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(new b(r4), com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        AwarenessManager.INSTANCE.registerAwarenessEvent("location_company_gps", (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(new c(r4), com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(i r2, Context r3, com.a.a.a.a r4) {
        r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    public static final /* synthetic */ void a(i r0, com.a.a.a.a r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(i r0, Object r1, com.a.a.a.a r2) {
        r0.a(r1, r2);
    }

    private final void a(Object r7, com.a.a.a.a r8) {
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L5;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 != null) goto L9;
        return;
    L9:
        switch(r6.hashCode()) {
            case -1587201774: goto L32;
            case -991666997: goto L29;
            case 3208415: goto L25;
            case 3343892: goto L22;
            case 3387192: goto L19;
            case 950484093: goto L15;
            case 1618734500: goto L12;
            default: goto L38;
        };
    L38:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataCenterReporter", "ignore unsupported current location type: " + r6, null, 4, null);
        return;
    L12:
        if (r6.equals("subway_station") == false) goto L38;
    L34:
        boolean r9 = false;
    L35:
        boolean r10 = false;
    L36:
        Pair r11 = TuplesKt.to(r9, r10);
        boolean r12 = ((Boolean) ZeusTransformUtils.preCheckCast(r11.component1(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        boolean r13 = ((Boolean) ZeusTransformUtils.preCheckCast(r11.component2(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        RunLog.INSTANCE.debug("DataCenterReporter", "report location states: home=" + r12 + ", company=" + r13);
        r8.a(r12);
        r8.b(r13);
        return;
    L15:
        if (r6.equals("company") == false) goto L38;
        r9 = false;
        r10 = true;
        goto L36
    L19:
        if (r6.equals("none") == true) goto L34;
    L22:
        if (r6.equals("mall") == true) goto L34;
    L25:
        if (r6.equals("home") == false) goto L38;
        r9 = true;
        goto L35
    L29:
        if (r6.equals("airport") == true) goto L34;
    L32:
        if (r6.equals("railway_station") == true) goto L34;
    L5:
        r6 = null;
        goto L6
    }

    public final void a() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        com.a.a.a.a r2 = com.a.a.a.a.a(r0);
        RunLog.INSTANCE.debug("DataCenterReporter", "init DataCenterReporter");
        if (r2.a() == false) goto L5;
        RunLog.INSTANCE.debug("DataCenterReporter", "location service available: true");
        Intrinsics.checkNotNull(r2);
        a(r0, r2);
        a(r2);
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataCenterReporter", "Location report service unavailable", null, 4, null);
        r2.b();
        kotlinx.coroutines.i.a(f8696b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new DataCenterReporter$init$1(r2, r0, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}

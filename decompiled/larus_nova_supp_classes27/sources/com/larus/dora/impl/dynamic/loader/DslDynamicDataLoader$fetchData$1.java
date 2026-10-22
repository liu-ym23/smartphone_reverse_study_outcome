package com.larus.dora.impl.dynamic.loader;

import c59.d0;
import c59.h0;
import c59.s;
import c59.z;
import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.DoraResourceState;
import com.larus.dora.api.IDoraService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.network.http.y;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.loader.DslDynamicDataLoader$fetchData$1", f = "DslDynamicDataLoader.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"key", "pageDataCached"}, s = {"L$0", "L$1"})
final class DslDynamicDataLoader$fetchData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d.b $callback;
    final /* synthetic */ Map<String, String> $headers;
    final /* synthetic */ String $model;
    final /* synthetic */ String $pageKey;
    final /* synthetic */ Integer $productId;
    final /* synthetic */ Integer $vendorId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ d this$0;

    public DslDynamicDataLoader$fetchData$1(d r1, String r2, Integer r3, Integer r4, String r5, d.b r6, Map<String, String> r7, Continuation<? super DslDynamicDataLoader$fetchData$1> r8) {
        this.this$0 = r1;
        this.$pageKey = r2;
        this.$vendorId = r3;
        this.$productId = r4;
        this.$model = r5;
        this.$callback = r6;
        this.$headers = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DslDynamicDataLoader$fetchData$1(this.this$0, this.$pageKey, this.$vendorId, this.$productId, this.$model, this.$callback, this.$headers, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        d.a.c r2 = (d.a.c) this.L$1;
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r22);     // Catch: Exception -> L95
        d.a.c r12 = r2;
        Object r4 = r22;
    L57:
        y r5 = (com.larus.network.http.a) r4;     // Catch: Exception -> L95
        if ((r5 instanceof y) == false) goto L98;
        d.a.c r6 = (d.a.c) ((com.larus.network.http.a) r5).b;     // Catch: Exception -> L95
        g49.d.d("DSLDynamicDataLoader", "fetchData: get pageData from server");     // Catch: Exception -> L95
        if (Intrinsics.areEqual(r12, r6) == true) goto L102;
        StringBuilder r7 = new StringBuilder("fetchData: pageDataCached: oldConfig=");     // Catch: Exception -> L95
        z r0 = null;
        if (r12 == null) goto L66;
        d.a.b r8 = r12.b();     // Catch: Exception -> L95
        if (r8 == null) goto L66;
        z r9 = r8.a();     // Catch: Exception -> L95
    L67:
        r7.append(r9);     // Catch: Exception -> L95
        r7.append("?, newConfig=");     // Catch: Exception -> L95
        if (r6 == null) goto L72;
        d.a.b r11 = r6.b();     // Catch: Exception -> L95
        if (r11 == null) goto L72;
        r0 = r11.a();     // Catch: Exception -> L95
    L72:
        r7.append(r0);     // Catch: Exception -> L95
        g49.d.d("DSLDynamicDataLoader", r7.toString());     // Catch: Exception -> L95
        if (r6 == null) goto L97;
        d.a.b r13 = r6.b();     // Catch: Exception -> L95
        if (r13 == null) goto L97;
        z r14 = r13.a();     // Catch: Exception -> L95
        if (r14 == null) goto L97;
        d r15 = this.this$0;     // Catch: Exception -> L95
        d.b r16 = this.$callback;     // Catch: Exception -> L95
        String r17 = d.b;     // Catch: Exception -> L95
        r15.getClass();     // Catch: Exception -> L95
        if (d.c(r14) == false) goto L94;
        r16.b(r14);     // Catch: Exception -> L95
        String r18 = s.d(r6);     // Catch: Exception -> L95
        if (r18 == null) goto L83;
        g49.c.a(r3, r18);     // Catch: Exception -> L95
    L83:
        ConcurrentHashMap<String, String> r20 = d0.a;     // Catch: Exception -> L95
        d.a.C0066a r21 = r6.a();     // Catch: Exception -> L95
        if (r21 == null) goto L87;
        Map<String, String> r23 = r21.b();     // Catch: Exception -> L95
        if (r23 == null) goto L87;
    L88:
        d0.c(r23);     // Catch: Exception -> L95
        ConcurrentHashMap<String, String> r24 = h0.a;     // Catch: Exception -> L95
        d.a.C0066a r25 = r6.a();     // Catch: Exception -> L95
        if (r25 == null) goto L92;
        Map<String, String> r26 = r25.a();     // Catch: Exception -> L95
        if (r26 == null) goto L92;
    L93:
        h0.a(r26);     // Catch: Exception -> L95
    L92:
        r26 = MapsKt.emptyMap();     // Catch: Exception -> L95
    L87:
        r23 = MapsKt.emptyMap();     // Catch: Exception -> L95
        goto L88
    L94:
        r16.a();     // Catch: Exception -> L95
    L97:
        this.$callback.a();     // Catch: Exception -> L95
    L66:
        r9 = null;
    L102:
        return Unit.INSTANCE;
    L98:
        g49.d.b("DSLDynamicDataLoader", "fetchData error: " + r5);     // Catch: Exception -> L95
        this.$callback.onFail("fetchData fail");     // Catch: Exception -> L95
        goto L102
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r22);
        if (ObricFeatureServiceDelegate.b.b() == false) goto L28;
        d r27 = this.this$0;     // Catch: Exception -> L95
        String r28 = this.$pageKey;     // Catch: Exception -> L95
        String r30 = d.b;     // Catch: Exception -> L95
        r27.getClass();     // Catch: Exception -> L95
        if (Intrinsics.areEqual(r28, "device_list_v2") == false) goto L25;
        IDoraService r31 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L95
        if (r31 == null) goto L24;
        DoraResourceState r32 = r31.S0(DoraEnableScope.G1);     // Catch: Exception -> L95
        DoraResourceState r33 = DoraResourceState.READY;     // Catch: Exception -> L95
        if (r32 == r33) goto L25;
        if (r31.S0(DoraEnableScope.G2) == r33) goto L25;
    L24:
        boolean r34 = true;
    L26:
        if (r34 == false) goto L28;
    L46:
        String r35 = "device_list_p_v2";
    L49:
        d0.b();     // Catch: Exception -> L95
        d r36 = this.this$0;     // Catch: Exception -> L95
        Integer r37 = this.$productId;     // Catch: Exception -> L95
        String r38 = this.$model;     // Catch: Exception -> L95
        r36.getClass();     // Catch: Exception -> L95
        String r40 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{String.valueOf(r37), r38, r35}), "_", null, null, 0, null, null, 62, null).toLowerCase(Locale.US);     // Catch: Exception -> L95
        r12 = d.a(this.this$0, r40, this.$vendorId, this.$productId, r35, this.$callback);     // Catch: Exception -> L95
        com.larus.dora.api.network.a r41 = com.larus.dora.api.network.a.a;     // Catch: Exception -> L95
        String r42 = d.b + "/alice/w/starweave/page_data";     // Catch: Exception -> L95
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L95
        Integer r111 = this.$productId;     // Catch: Exception -> L95
        String r112 = this.$model;     // Catch: Exception -> L95
        r110.put("product_id", String.valueOf(r111));     // Catch: Exception -> L95
        r110.put("product_model_code", r112);     // Catch: Exception -> L95
        r110.put(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, r35);     // Catch: Exception -> L95
        JSONObject r43 = new JSONObject();     // Catch: Exception -> L95
        r43.put("project_pkg", "DoraLite");     // Catch: Exception -> L95
        IObricDoraService r44 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);     // Catch: Exception -> L95
        if (r44 == null) goto L52;
        boolean r45 = r44.m();     // Catch: Exception -> L95
    L53:
        r43.put("is_obric_smart_notification_enable", r45);     // Catch: Exception -> L95
        Unit r46 = Unit.INSTANCE;     // Catch: Exception -> L95
        r110.put("ext_condition_params", r43);     // Catch: Exception -> L95
        r110.put("biz_req_data", "??");     // Catch: Exception -> L95
        Map<String, String> r113 = this.$headers;     // Catch: Exception -> L95
        this.L$0 = r40;     // Catch: Exception -> L95
        this.L$1 = r12;     // Catch: Exception -> L95
        this.label = 1;     // Catch: Exception -> L95
        r4 = com.larus.dora.api.network.a.c(r41, d.a.c.class, r42, r110, r113, this, 232);     // Catch: Exception -> L95
        if (r4 != r10) goto L56;
        return r10;
    L56:
        r3 = r40;
        goto L57
    L52:
        r45 = false;
    L25:
        r34 = false;
    L28:
        d r47 = this.this$0;     // Catch: Exception -> L95
        String r48 = d.b;     // Catch: Exception -> L95
        r47.getClass();     // Catch: Exception -> L95
        IObricDoraService r50 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);     // Catch: Exception -> L95
        if (r50 == null) goto L31;
        boolean r51 = r50.t();     // Catch: Exception -> L95
    L32:
        if (r51 == true) goto L34;
        r35 = this.$pageKey;     // Catch: Exception -> L95
        goto L49
    L34:
        if (Intrinsics.areEqual(this.$pageKey, "device_manage_v3") == false) goto L37;
        r35 = "device_manage_p_v3";
        goto L49
    L37:
        if (Intrinsics.areEqual(this.$pageKey, "bind_device_v2") == false) goto L45;
        Integer r52 = this.$vendorId;     // Catch: Exception -> L95
        if (r52 == null) goto L45;
        if (r52.intValue() != 4096) goto L45;
        r35 = "bind_device_p_v2";
    L45:
        if (Intrinsics.areEqual(this.$pageKey, "device_list_v2") == true) goto L46;
        r35 = this.$pageKey;     // Catch: Exception -> L95
        goto L49
    L31:
        r51 = false;
    L95:
        e = move-exception;
        g49.d.b("DSLDynamicDataLoader", "onSuccess error: " + e.getMessage());
        this.$callback.onFail("fetchData fail: " + e.getMessage());
        goto L102
    }
}

package com.larus.e_commerce.impl.order;

import com.bytedance.keva.Keva;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import com.larus.network.http.w;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.e_commerce.impl.order.OrderSchemaService$getOrderListSchema$1", f = "OrderSchemaService.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
public final class OrderSchemaService$getOrderListSchema$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public OrderSchemaService$getOrderListSchema$1(Continuation<? super OrderSchemaService$getOrderListSchema$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new OrderSchemaService$getOrderListSchema$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
        Object r1 = r17;
    L11:
        y r2 = (a) r1;
        if ((r2 instanceof y) == false) goto L23;
        OrderSchemaInfoData r3 = (OrderSchemaInfoData) ((a) r2).b;
        FLogger.a.i("OrderSchemaService", "getOrderListSchema success: " + r3);
        if (r3 == null) goto L34;
        List<OrderSchemaData> r4 = r3.a();
        if (r4 == null) goto L34;
        OrderSchemaData r5 = (OrderSchemaData) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L34;
        String r6 = r5.a();
        if (r6 == null) goto L34;
        Keva r7 = OrderSchemaService.c;
        r7.storeString("order_list_schema", r6);
        r7.storeLong("order_list_schema_timestamp", System.currentTimeMillis());
        OrderSchemaService.a.postValue(new y(r6, null, 14));
    L34:
        return Unit.INSTANCE;
    L23:
        if ((r2 instanceof com.larus.network.http.f) == false) goto L34;
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("getOrderListSchema failed: ");
        com.larus.network.http.f r10 = (com.larus.network.http.f) r2;
        r9.append(r10.d);
        r8.e("OrderSchemaService", r9.toString());
        String r11 = OrderSchemaService.c.getString("order_list_schema", "sslocal://webcast_webview?url=https%3A%2F%2Fffh.jinritemai.com%2Fforest%2Frender%2Ffe%2Ftemplate%2Fchannel%2Fecommerce_orders_yata%2Fhtml%2Forder_list_pages.html%3F_pia_%3D1&disable_host_jsb_method=1&disable_thread_spread=1&use_wk_falcon=1&android_reuse_activity=1&decision_rule_id=16004720&loader_name=forest&enable_font_scale=1&hide_loading=0&pad_adapter=width_percent&screen_size_adaptation=1&landscape_custom_height=1&pad_use_phone_size=1&margin_right=0&margin_bottom=0&android_soft_input_mode=0&disable_input_scroll=1&top_level=1&host=aweme&user_id=3745363408721668&tab_id=0&enter_from=doubao_ecommerce_landing_page&douyinapps_test=1&cache_type=&cache_duration=86400&cache_overlay_timeout=5000&cache_order_count=3&bullet_storage_keys=iesec_order_list_preload_info,order_list_cache_html_3745363408721668_default_0_fullscreen&technology=h5&type=fullscreen&hide_nav_bar=1&trans_status_bar=1&web_bg_color=ffffff&status_bar_color=black");
        if ((r11 instanceof String) == true) goto L28;
        r11 = null;
    L28:
        if (r11 != null) goto L30;
    L32:
        OrderSchemaService.a.postValue(new com.larus.network.http.f(new AsyncThrowable(1, "get schema failed", r10.d), null));
        goto L34
    L30:
        if (OrderSchemaService.b() == true) goto L32;
        r8.i("OrderSchemaService", "getOrderListSchema failed, using cached schema: ".concat(r11));
        OrderSchemaService.a.postValue(new y(r11, null, 14));
        goto L34
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        OrderSchemaService.a.postValue(new w(null));
        JSONObject r12 = new JSONObject();
        JSONArray r14 = new JSONArray();
        r14.put("order_list_schema");
        Unit r15 = Unit.INSTANCE;
        r12.put("schema_type_list", r14);
        this.label = 1;
        r1 = HttpExtKt.k("Basic", OrderSchemaInfoData.class, "/alice/e_commerce/landing_page/schema", r12, null, null, false, null, null, null, this, 1008);
        if (r1 != r13) goto L11;
        return r13;
    }
}

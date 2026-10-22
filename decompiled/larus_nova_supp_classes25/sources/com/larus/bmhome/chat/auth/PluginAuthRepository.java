package com.larus.bmhome.chat.auth;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.bmhome.chat.auth.model.PluginAuthResponse;
import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.bmhome.chat.auth.model.PluginItemData;
import com.larus.network.http.HttpExtKt;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class PluginAuthRepository {
    public PluginAuthRepository() {
    }

    public final Object b(String r16, String r17, Continuation<? super PluginItem> r18) {
        if ((r18 instanceof PluginAuthRepository$requestPluginDetail$1) == false) goto L7;
        PluginAuthRepository$requestPluginDetail$1 r1 = (PluginAuthRepository$requestPluginDetail$1) r18;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        PluginAuthRepository$requestPluginDetail$1 r13 = r1;
        Object r0 = r13.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r13.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L17:
        com.larus.network.http.y r5 = (com.larus.network.http.a) r0;
        if ((r5 instanceof com.larus.network.http.y) == true) goto L22;
        return null;
    L22:
        return (PluginItem) ((com.larus.network.http.a) r5).b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        JSONObject r6 = new JSONObject();
        r6.put("bot_id", r16);
        r6.put("plugin_id", r17);
        Unit r7 = Unit.INSTANCE;
        r13.label = 1;
        r0 = HttpExtKt.k("Basic", PluginItem.class, "/alice/bot/plugin_detail", r6, null, null, true, null, null, null, r13, 944);
        if (r0 != r3) goto L17;
        return r3;
    L7:
        r1 = new PluginAuthRepository$requestPluginDetail$1(this, r18);
        goto L8
    }

    public final Object a(String r16, String r17, boolean r18, Continuation<? super Boolean> r19) {
        if ((r19 instanceof PluginAuthRepository$requestPluginAuth$1) == false) goto L7;
        PluginAuthRepository$requestPluginAuth$1 r1 = (PluginAuthRepository$requestPluginAuth$1) r19;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        PluginAuthRepository$requestPluginAuth$1 r13 = r1;
        Object r0 = r13.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r13.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L22:
        return Boxing.boxBoolean(((com.larus.network.http.a) r0) instanceof com.larus.network.http.y);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        JSONObject r6 = new JSONObject();
        r6.put("bot_id", r16);
        JSONArray r7 = new JSONArray();
        r7.put(r17);
        Unit r8 = Unit.INSTANCE;
        r6.put("plugin_ids", r7);
        if (r18 == false) goto L17;
        int r9 = 1;
    L18:
        r6.put("op_type", r9);
        r13.label = 1;
        r0 = HttpExtKt.k("Basic", PluginAuthResponse.class, "/alice/bot/plugin_auth", r6, null, null, true, null, null, null, r13, 944);
        if (r0 != r3) goto L22;
        return r3;
    L17:
        r9 = 2;
    L7:
        r1 = new PluginAuthRepository$requestPluginAuth$1(this, r19);
        goto L8
    }

    public final Object c(String r16, int r17, int r18, DowngradeSource r19, Continuation<? super PluginItemData> r20) {
        if ((r20 instanceof PluginAuthRepository$requestPluginList$1) == false) goto L7;
        PluginAuthRepository$requestPluginList$1 r1 = (PluginAuthRepository$requestPluginList$1) r20;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        PluginAuthRepository$requestPluginList$1 r12 = r1;
        Object r0 = r12.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r12.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L21:
        com.larus.network.http.y r5 = (com.larus.network.http.a) r0;
        if ((r5 instanceof com.larus.network.http.y) == true) goto L24;
        return null;
    L24:
        return (PluginItemData) ((com.larus.network.http.a) r5).b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        FlowDowngradeServiceDelegate r6 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r7 = new JSONObject();
        r7.put("bot_id", r16);
        r7.put("page_no", r17);
        r7.put("page_size", r18);
        Unit r8 = Unit.INSTANCE;
        if (r19 == null) goto L17;
        Map r11 = MapsKt.mapOf(TuplesKt.to("source", r19.getValue()));
    L18:
        r12.label = 1;
        r0 = IFlowDowngradeService.a.b(r6, "Basic", PluginItemData.class, "/alice/bot/plugin_list", r7, null, true, null, r11, r12, 944);
        if (r0 != r3) goto L21;
        return r3;
    L17:
        r11 = null;
    L7:
        r1 = new PluginAuthRepository$requestPluginList$1(this, r20);
        goto L8
    }
}

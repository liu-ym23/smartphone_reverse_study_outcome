package com.larksuite.component.card.cardcontainer.render;

import android.content.Context;
import com.bytedance.ee.bear.bitable.msgcenter.UniversalCardWrapper;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.openplatform.v1.TransSer2CliUniversalCardEntityRequest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larksuite.component.card.action.WithEntityCardActionService;
import com.larksuite.component.card.cardcontainer.UniversalCardLynxRender;
import com.larksuite.component.card.common.CommonBizContext;
import com.larksuite.component.card.common.CommonCardDependency;
import com.larksuite.component.card.monitor.UniversalCardMonitorData;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.context.CardStyle;
import com.larksuite.component.card.protocol.data.action.CardActionDependencyData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d extends com.larksuite.component.card.cardcontainer.render.a implements CoroutineScope {
    public static final /* synthetic */ int d = 0;
    public final /* synthetic */ CoroutineScope b;
    public final WithEntityCardActionService c;

    public static final class a {
    }

    static {
    }

    public final CoroutineContext getCoroutineContext() {
        return this.b.getCoroutineContext();
    }

    public d(UniversalCardLynxRender r2, CardConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "lynxRender");
        Intrinsics.checkNotNullParameter(r3, "cardConfig");
        super(r2, r3);
        this.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.c = new WithEntityCardActionService();
    }

    public static final Object c(d r3, String r4, Continuation r5) {
        r3.getClass();
        final j r6 = new j(IntrinsicsKt.intercepted(r5), 1);
        r6.C();
        TransSer2CliUniversalCardEntityRequest.Builder r7 = new TransSer2CliUniversalCardEntityRequest.Builder().universal_card_entity(r4);
        SdkSender.asynSendRequestNonWrap(Command.TRANS_SER2CLI_UNIVERSAL_CARD_ENTITY, r7, new CardRenderByServerEntityImpl$convertToClientEntityAsyncSuspend$2$1(r6), f.a);
        Object r8 = r6.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r8;
    }

    public final void d(Context r12, String r13, fz7.a r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "serverEntityJson");
        Intrinsics.checkNotNullParameter(r14, "cardRenderEntityConfig");
        JsonElement r1 = ((JsonObject) new Gson().fromJson(r13, JsonObject.class)).get("cardId");     // Catch: Throwable -> L14
        if (r1 == null) goto L7;
        String r2 = r1.getAsString();     // Catch: Throwable -> L14
        if (r2 == null) goto L7;
    L8:
        fz7.a.InterfaceC0109a r3 = r14.d;
        if (r3 == null) goto L11;
        UniversalCardWrapper.render.1.getOpenUrlService.1 r4 = r3.getOpenUrlService();
    L12:
        CardContext.a.C0026a r5 = new CardContext.a.C0026a();
        Intrinsics.checkNotNullParameter(r2, "key");
        r5.a = r2;
        OPTrace r6 = new OPTrace();
        Intrinsics.checkNotNullParameter(r6, "renderTrace");
        r5.b = r6;
        Intrinsics.checkNotNullParameter(r12, "context");
        r5.c = r12;
        CommonBizContext r15 = new CommonBizContext(r2);
        Intrinsics.checkNotNullParameter(r15, "bizContext");
        r5.f = r15;
        String r16 = r14.b;
        Intrinsics.checkNotNullParameter(r16, "host");
        r5.h = r16;
        UniversalCardMonitorData r17 = new UniversalCardMonitorData(r14.a, r14.b);
        Intrinsics.checkNotNullParameter(r17, "monitorData");
        r5.e = r17;
        String r19 = r14.a;
        Intrinsics.checkNotNullParameter(r19, "deliveryType");
        r5.i = r19;
        CommonCardDependency r110 = new CommonCardDependency(this.c, r4);
        Intrinsics.checkNotNullParameter(r110, "dependency");
        r5.k = r110;
        CardActionDependencyData r111 = new CardActionDependencyData("", false, false, null, 14, null);
        Intrinsics.checkNotNullParameter(r111, "cardActionDependencyData");
        r5.j = r111;
        CardStyle r112 = r14.e;
        Intrinsics.checkNotNullParameter(r112, "cardStyle");
        r5.l = r112;
        CardContext r9 = r5.a();
        Log.i("CardRenderByServerEntityImpl", "render by server entity, cardId: " + r9.getKey() + ", bizType: " + r9.getMonitorData().getBusinessType() + ", async: " + r14.c + ", ");
        BuildersKt.launch$default(this, null, null, new CardRenderByServerEntityImpl$render$1(r14, this, r13, null, r9, null), 3, null);
        return;
    L11:
        r4 = null;
    L7:
        r2 = "";
        goto L8
    }
}

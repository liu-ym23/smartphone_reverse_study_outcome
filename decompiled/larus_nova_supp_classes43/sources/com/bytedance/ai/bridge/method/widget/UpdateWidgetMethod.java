package com.bytedance.ai.bridge.method.widget;

import com.bytedance.ai.applet.db.WidgetContextHelper;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.bridge.widget.AbsUpdateWidgetMethodIDL;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.utils.g;
import com.bytedance.retrofit2.SsResponse;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import p4.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/widget/UpdateWidgetMethod;", "Lcom/bytedance/ai/bridge/widget/AbsUpdateWidgetMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/widget/AbsUpdateWidgetMethodIDL$UpdateWidgetRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/widget/AbsUpdateWidgetMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateWidgetMethod extends AbsUpdateWidgetMethodIDL {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.widget.UpdateWidgetMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.widget.UpdateWidgetMethod$handle$1", f = "UpdateWidgetMethod.kt", i = {0, 1, 1, 1, 2, 2}, l = {51, 59, 67}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "messageId", "it", "$this$launch", "messageId"}, s = {"L$0", "L$0", "L$1", "L$3", "L$0", "L$1"})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appId;
        final /* synthetic */ h<AbsUpdateWidgetMethodIDL.a> $callback;
        final /* synthetic */ AbsUpdateWidgetMethodIDL.b $params;
        final /* synthetic */ String $widgetData;
        final /* synthetic */ String $widgetId;
        final /* synthetic */ String $widgetInstanceId;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        public AnonymousClass1(AbsUpdateWidgetMethodIDL.b r1, String r10, h<AbsUpdateWidgetMethodIDL.a> r11, String r12, String r13, String r14, Continuation<? super AnonymousClass1> r15) {
            this.$params = r1;
            this.$widgetInstanceId = r10;
            this.$callback = r11;
            this.$widgetId = r12;
            this.$appId = r13;
            this.$widgetData = r14;
            super(2, r15);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.$params, this.$widgetInstanceId, this.$callback, this.$widgetId, this.$appId, this.$widgetData, r11);
            r12.L$0 = r10;
            return r12;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r22) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            String r10 = (String) this.L$7;
            h<AbsUpdateWidgetMethodIDL.a> r11 = (h) this.L$6;
            String r12 = (String) this.L$5;
            String r13 = (String) this.L$4;
            String r14 = (String) this.L$3;
            r4.h r15 = (r4.h) this.L$2;
            String r16 = (String) this.L$1;
            CoroutineScope r17 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r22);
            String r18 = r10;
            r4.h r19 = r15;
            String r20 = r14;
            String r21 = r13;
            String r23 = r12;
            h<AbsUpdateWidgetMethodIDL.a> r24 = r11;
            Object r25 = r22;
        L49:
            if (((Boolean) r25).booleanValue() == false) goto L52;
            g.a.i("AISDK_JSB_UpdateWidgetMethod", "call success, via=hostMessageDepend");
            Intrinsics.checkNotNullParameter(AbsUpdateWidgetMethodIDL.a.class, "<this>");
            h.a.b(r24, (ResultModel) c.a(AbsUpdateWidgetMethodIDL.a.class));
            b.a(r18, r20, r16, r21, r23);
            return Unit.INSTANCE;
        L52:
            g r26 = g.a;
            r26.w("AISDK_JSB_UpdateWidgetMethod", "updateWidgetMessage failed, messageId: " + r16 + ", widgetInstanceId: " + r20 + " for bd");
            UserAuthService r27 = UserAuthService.a;
            Intrinsics.checkNotNullParameter(r16, "messageId");
            Intrinsics.checkNotNullParameter(r20, "cardId");
            Intrinsics.checkNotNullParameter(r23, "widgetData");
            r4.h r28 = r19;
            SsResponse r29 = UserAuthService.d.updateWidgetMessageData(new s(r16, r20, r21, r23)).execute();     // Catch: Exception -> L65
            if (r29.isSuccessful() == true) goto L58;
        L63:
            r26.e("UserAuthService", "updateWidgetMessageData: Http Error, code = " + r29.code());     // Catch: Exception -> L65
        L81:
        L70:
            boolean r110 = false;
        L71:
            if (r110 == false) goto L74;
            g.a.i("AISDK_JSB_UpdateWidgetMethod", "call success, via=server");
            Intrinsics.checkNotNullParameter(AbsUpdateWidgetMethodIDL.a.class, "<this>");
            h.a.b(r24, (ResultModel) c.a(AbsUpdateWidgetMethodIDL.a.class));
            b.a(r18, r20, r16, r21, r23);
            return Unit.INSTANCE;
        L74:
            g r30 = g.a;
            StringBuilder r31 = new StringBuilder("call failed, errNo=");
            f3.a r32 = f3.a.f;
            r31.append(r32.a);
            r31.append(", msg=update widget failed, messageId: ");
            r31.append(r16);
            r31.append(", widgetInstanceId: ");
            r31.append(r20);
            r30.e("AISDK_JSB_UpdateWidgetMethod", r31.toString());
            h.a.a(r24, "update widget failed", r32, null, 10);
            if (r28 != null) goto L80;
        L78:
            h<AbsUpdateWidgetMethodIDL.a> r33 = this.$callback;
            g r34 = g.a;
            StringBuilder r35 = new StringBuilder("call failed, errNo=");
            f3.a r36 = f3.a.g;
            r35.append(r36.a);
            r35.append(", msg=hostMessageDepend is null");
            r34.e("AISDK_JSB_UpdateWidgetMethod", r35.toString());
            h.a.a(r33, "hostMessageDepend is null", r36, null, 10);
            Unit r37 = Unit.INSTANCE;
        L80:
            return Unit.INSTANCE;
        L58:
            if (r29.body() == null) goto L63;
            p4.a r38 = (p4.a) r29.body();     // Catch: Exception -> L65
            if (r38.d() == false) goto L62;
            r110 = true;
            goto L71
        L62:
            r26.e("UserAuthService", "updateWidgetMessageData: Server Error: " + r38);     // Catch: Exception -> L65
        L65:
            e = e;
        L69:
            g.a.e("UserAuthService", "updateWidgetMessageData ERROR: " + e.getMessage(), e);
        L67:
            e = e;
            r28 = r19;
            goto L69
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            String r39 = (String) this.L$3;
            h<AbsUpdateWidgetMethodIDL.a> r40 = (h) this.L$2;
            String r41 = (String) this.L$1;
            CoroutineScope r42 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r22);
            h<AbsUpdateWidgetMethodIDL.a> r111 = r40;
            Object r43 = r22;
        L39:
            if (((Widget) r43) != null) goto L42;
            g r44 = g.a;
            StringBuilder r45 = new StringBuilder("call failed, errNo=");
            f3.a r46 = f3.a.q;
            r45.append(r46.a);
            r45.append(", msg=can not find widget by widgetId: ");
            r45.append(r39);
            r44.e("AISDK_JSB_UpdateWidgetMethod", r45.toString());
            h.a.a(r111, "can not find widget by widgetId: " + r39, r46, null, 10);
            return Unit.INSTANCE;
        L42:
            String r112 = r41;
            r19 = r4.a.l;
            if (r19 == null) goto L78;
            String r47 = this.$widgetInstanceId;
            String r48 = this.$widgetId;
            String r49 = this.$widgetData;
            h<AbsUpdateWidgetMethodIDL.a> r50 = this.$callback;
            r18 = this.$appId;
            this.L$0 = r42;
            this.L$1 = r112;
            this.L$2 = r19;
            this.L$3 = r47;
            this.L$4 = r48;
            this.L$5 = r49;
            this.L$6 = r50;
            this.L$7 = r18;
            this.label = 3;
            r25 = r19.f(r112, r47, r48, r49, this);
            if (r25 != r0) goto L47;
            return r0;
        L47:
            r16 = r112;
            r24 = r50;
            r23 = r49;
            r21 = r48;
            r20 = r47;
            goto L49
        L11:
            CoroutineScope r51 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r22);
            Object r52 = r22;
        L15:
            r42 = r51;
            r41 = (String) r52;
            if (r41 != null) goto L18;
        L21:
            boolean r53 = true;
        L22:
            if (r53 == false) goto L25;
            g r54 = g.a;
            StringBuilder r55 = new StringBuilder("call failed, errNo=");
            f3.a r56 = f3.a.q;
            r55.append(r56.a);
            r55.append(", msg=can not find message by widgetInstanceId: ");
            r55.append(this.$widgetInstanceId);
            r54.e("AISDK_JSB_UpdateWidgetMethod", r55.toString());
            h.a.a(this.$callback, "can not find message by widgetInstanceId: " + this.$widgetInstanceId, r56, null, 10);
            return Unit.INSTANCE;
        L25:
            r39 = this.$widgetId;
            if (r39 == null) goto L42;
            if (r39.length() <= 0) goto L30;
            boolean r57 = true;
        L31:
            if (r57 == true) goto L34;
            r39 = null;
        L34:
            if (r39 == null) goto L42;
            String r58 = this.$appId;
            r111 = this.$callback;
            AIManager r113 = AIManager.a;
            this.L$0 = r42;
            this.L$1 = r41;
            this.L$2 = r111;
            this.L$3 = r39;
            this.label = 2;
            r43 = r113.E(r58, r39, null, this);
            if (r43 != r0) goto L39;
            return r0;
        L30:
            r57 = false;
            goto L31
        L18:
            if (r41.length() == 0) goto L21;
            r53 = false;
            goto L22
        L12:
            ResultKt.throwOnFailure(r22);
            r51 = (CoroutineScope) this.L$0;
            WidgetContextHelper r59 = WidgetContextHelper.a;
            String r60 = this.$params.getWidgetInstanceId();
            this.L$0 = r51;
            this.label = 1;
            r52 = r59.e(r60, this);
            if (r52 != r0) goto L15;
            return r0;
        }
    }

    static {
    }

    public UpdateWidgetMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r20, ParamModel r21, h r22) {
        AbsUpdateWidgetMethodIDL.b r1 = (AbsUpdateWidgetMethodIDL.b) r21;
        Intrinsics.checkNotNullParameter(r20, "bridgeContext");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r22, "callback");
        a0 r0 = r20.getContainerContext();
        if (r0 == null) goto L5;
        String r10 = r0.getAppletId();
    L6:
        g r11 = g.a;
        StringBuilder r12 = new StringBuilder("call start, widgetInstanceId=");
        r12.append(r1.getWidgetInstanceId());
        r12.append(", hasWidgetId=");
        String r13 = r1.getWidgetId();
        boolean r14 = false;
        if (r13 != null) goto L9;
    L12:
        boolean r15 = true;
    L13:
        r12.append(!r15);
        r12.append(", appId=");
        r12.append(r10);
        r11.i("AISDK_JSB_UpdateWidgetMethod", r12.toString());
        if (r10 != null) goto L16;
    L19:
        boolean r16 = true;
    L21:
        if (r16 == false) goto L23;
        StringBuilder r17 = new StringBuilder("call failed, errNo=");
        f3.a r18 = f3.a.f;
        r17.append(r18.a);
        r17.append(", msg=appId is empty");
        r11.e("AISDK_JSB_UpdateWidgetMethod", r17.toString());
        h.a.a(r22, "appId is empty", r18, null, 10);
        return;
    L23:
        String r19 = r1.getWidgetInstanceId();
        if (r19.length() != 0) goto L26;
        boolean r110 = true;
    L27:
        if (r110 == false) goto L29;
        StringBuilder r23 = new StringBuilder("call failed, errNo=");
        f3.a r24 = f3.a.h;
        r23.append(r24.a);
        r23.append(", msg=widgetInstanceId is empty");
        r11.e("AISDK_JSB_UpdateWidgetMethod", r23.toString());
        h.a.a(r22, "widgetInstanceId is empty", r24, null, 10);
        return;
    L29:
        String r111 = r1.getWidgetData();
        if (r111.length() != 0) goto L32;
        boolean r112 = true;
    L33:
        if (r112 == false) goto L35;
        StringBuilder r25 = new StringBuilder("call failed, errNo=");
        f3.a r26 = f3.a.h;
        r25.append(r26.a);
        r25.append(", msg=widgetData is empty");
        r11.e("AISDK_JSB_UpdateWidgetMethod", r25.toString());
        h.a.a(r22, "widgetData is empty", r26, null, 10);
        return;
    L35:
        String r113 = r1.getWidgetId();
        if (r113 != null) goto L38;
    L42:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r1, r19, r22, r113, r10, r111, null), 3, null);
        return;
    L38:
        if (r113.length() != 0) goto L40;
        r14 = true;
    L40:
        if (r14 == false) goto L42;
        StringBuilder r27 = new StringBuilder("call failed, errNo=");
        f3.a r28 = f3.a.h;
        r27.append(r28.a);
        r27.append(", msg=widgetId is empty");
        r11.e("AISDK_JSB_UpdateWidgetMethod", r27.toString());
        h.a.a(r22, "widgetId is empty", r28, null, 10);
        return;
    L32:
        r112 = false;
        goto L33
    L26:
        r110 = false;
        goto L27
    L16:
        if (r10.length() == 0) goto L19;
        r16 = false;
        goto L21
    L9:
        if (r13.length() == 0) goto L12;
        r15 = false;
        goto L13
    L5:
        r10 = null;
        goto L6
    }
}

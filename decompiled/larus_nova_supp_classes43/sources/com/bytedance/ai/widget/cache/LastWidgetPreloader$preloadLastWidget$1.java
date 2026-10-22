package com.bytedance.ai.widget.cache;

import android.os.Trace;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.LastWidgetPreloader$preloadLastWidget$1", f = "LastWidgetPreloader.kt", i = {0, 0, 0, 1, 1}, l = {69, 79}, m = "invokeSuspend", n = {"$this$launch", "widgetData", "resourceLoader", "$this$launch", "widgetData"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
final class LastWidgetPreloader$preloadLastWidget$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public LastWidgetPreloader$preloadLastWidget$1(Continuation<? super LastWidgetPreloader$preloadLastWidget$1> r10) {
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        LastWidgetPreloader$preloadLastWidget$1 r0 = new LastWidgetPreloader$preloadLastWidget$1(r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r11 = false;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ConversationWidgetData r1 = (ConversationWidgetData) this.L$1;
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r19);
    L69:
        g.a.i("LastWidgetPreloader", "preloadLastWidget: end loadTemplateAndCache widgetId = " + r1.getWidgetId());
    L71:
        g.a.i("LastWidgetPreloader", "preloadLastWidget: end");
        Trace.endSection();
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        b r13 = (b) this.L$2;
        ConversationWidgetData r14 = (ConversationWidgetData) this.L$1;
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r16 = r19;
        b r17 = r13;
        r1 = r14;
    L55:
        Widget r18 = (Widget) r16;
        if (r18 != null) goto L58;
        g.a.e("LastWidgetPreloader", "preloadLastWidget: widget is NULL");
        goto L71
    L58:
        if (c3.b.a(r18.C) == true) goto L66;
        g.a.i("LastWidgetPreloader", "preloadLastWidget: runApplet " + r1.getPackageName() + " cvsId=" + r1.getConversationId());
        String r110 = r1.getBotId();
        if (r110.length() != 0) goto L62;
        r11 = true;
    L62:
        if (r11 == false) goto L64;
        AppletRuntimeManager r20 = AppletRuntimeManager.INSTANCE;
        String r21 = r1.getConversationId();
        r20.getClass();
        String r111 = AppletRuntimeManager.h(r21);
    L65:
        r17.d(r1.getPackageName(), r1.getConversationId(), r111, r1.getMessageId(), "");
        goto L66
    L64:
        r111 = r110;
    L66:
        g.a.i("LastWidgetPreloader", "preloadLastWidget: start loadTemplateAndCache widgetId = " + r1.getWidgetId() + ", renderType = " + r18.o);
        this.L$0 = r15;
        this.L$1 = r1;
        this.L$2 = null;
        this.label = 2;
        if (r17.c(this) != r10) goto L69;
        return r10;
    L10:
        ResultKt.throwOnFailure(r19);
        r15 = (CoroutineScope) this.L$0;
        String r22 = c.a.getString("LAST_WIDGET", "");
        if (r22 != null) goto L13;
    L16:
        boolean r23 = true;
    L17:
        if (r23 == false) goto L75;
        g.a.e("LastWidgetPreloader", "preloadLastWidget: widgetJson is NULL");
        return Unit.INSTANCE;
    L75:
        Lazy r24 = com.bytedance.ai.applet.base.gson.e.a;     // Catch: Exception -> L22
        r1 = (ConversationWidgetData) com.bytedance.ai.applet.base.gson.e.b(r22, ConversationWidgetData.class);     // Catch: Exception -> L22
    L24:
        if (r1 != null) goto L26;
    L73:
        g.a.e("LastWidgetPreloader", "preloadLastWidget: widgetCache is NULL");
        return Unit.INSTANCE;
    L26:
        if (r1.getPackageName().length() != 0) goto L28;
        boolean r25 = true;
    L29:
        if (r25 == true) goto L73;
        if (r1.getWidgetId().length() != 0) goto L33;
        boolean r26 = true;
    L34:
        if (r26 == true) goto L73;
        if (r1.getConversationId().length() != 0) goto L38;
        boolean r27 = true;
    L39:
        if (r27 == true) goto L73;
        List<com.bytedance.ai.widget.a.C0055a> r28 = com.bytedance.ai.widget.a.a;
        String r29 = com.bytedance.ai.widget.a.a(r1.getPackageName(), r1.getWidgetId());
        if (r29 == null) goto L45;
        g.a.d("LastWidgetPreloader", "preloadLastWidget: degrade widgetId: " + r1.getWidgetId() + " -> " + r29);
        r1.setWidgetId(r29);
    L45:
        if (Intrinsics.areEqual(r1.getAppType(), "1") == false) goto L47;
        AIManager r30 = AIManager.a;
        AIManager.f(r1.getPackageName());
    L47:
        Trace.beginSection("preloadLastWidget");
        g.a.i("LastWidgetPreloader", "preloadLastWidget: packageName = " + r1.getPackageName() + ", widgetId = " + r1.getWidgetId());
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r31 = AppletRuntimeManager.d;
        if (r31 == null) goto L51;
        r17 = r31.B(r1);
        if (r17 == null) goto L51;
    L52:
        this.L$0 = r15;
        this.L$1 = r1;
        this.L$2 = r17;
        this.label = 1;
        r16 = r17.a(this);
        if (r16 != r10) goto L55;
        return r10;
    L51:
        r17 = new WidgetResourceLoader(r1);
        goto L52
    L38:
        r27 = false;
        goto L39
    L33:
        r26 = false;
        goto L34
    L28:
        r25 = false;
    L22:
        e = move-exception;
        g.a.e("LastWidgetPreloader", e.getMessage(), e);
        r1 = null;
        goto L24
    L13:
        if (r22.length() == 0) goto L16;
        r23 = false;
        goto L17
    }
}

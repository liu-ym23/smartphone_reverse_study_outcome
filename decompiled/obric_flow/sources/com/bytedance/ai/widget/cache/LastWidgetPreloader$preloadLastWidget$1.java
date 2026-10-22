package com.bytedance.ai.widget.cache;

import android.os.Trace;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.model.p;
import com.bytedance.ai.resource.j;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
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

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.LastWidgetPreloader$preloadLastWidget$1", f = "LastWidgetPreloader.kt", i = {0, 0, 0, 1, 1, 2, 2}, l = {63, 74, 76}, m = "invokeSuspend", n = {"$this$launch", "widgetData", "resourceLoader", "$this$launch", "widgetData", "$this$launch", "widgetData"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1"})
final class LastWidgetPreloader$preloadLastWidget$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConversationWidgetData f2936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f2937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2938c;
    public /* synthetic */ Object d;

    public LastWidgetPreloader$preloadLastWidget$1(Continuation r5) {
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        LastWidgetPreloader$preloadLastWidget$1 r11 = new LastWidgetPreloader$preloadLastWidget$1(r10);
        r11.d = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        LastWidgetPreloader$preloadLastWidget$1 r11 = new LastWidgetPreloader$preloadLastWidget$1(r10);
        r11.d = r5;
        return r11.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.f2938c;
        if (r10 == 0) goto L12;
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L10;
        if (r10 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ConversationWidgetData r11 = this.f2936a;
        CoroutineScope r12 = (CoroutineScope) this.d;
        ResultKt.throwOnFailure(r18);
    L70:
        String r13 = "preloadLastWidget: end loadTemplateAndCache widgetId = " + r11.getWidgetId();
        Intrinsics.checkNotNullParameter("LastWidgetPreloader", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L76;
        r14.i("LastWidgetPreloader", r13);
    L76:
        Intrinsics.checkNotNullParameter("LastWidgetPreloader", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L79;
        r15.i("LastWidgetPreloader", "preloadLastWidget: end");
    L79:
        Trace.endSection();
        return Unit.INSTANCE;
    L11:
        b r16 = this.f2937b;
        ConversationWidgetData r17 = this.f2936a;
        CoroutineScope r19 = (CoroutineScope) this.d;
        ResultKt.throwOnFailure(r18);
        b r110 = r16;
        r11 = r17;
        Object r20 = r18;
    L48:
        Widget r21 = (Widget) r20;
        if (r21 != null) goto L51;
        Intrinsics.checkNotNullParameter("LastWidgetPreloader", "tag");
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L76;
        r22.e("LastWidgetPreloader", "preloadLastWidget: widget is NULL");
        goto L76
    L51:
        if (ym.a.e(r21.C) == true) goto L59;
        String r111 = "preloadLastWidget: runApplet " + r11.getPackageName() + " cvsId=" + r11.getConversationId();
        Intrinsics.checkNotNullParameter("LastWidgetPreloader", "tag");
        t0.d r112 = com.bytedance.ai.utils.c.f2846a;
        if (r112 == null) goto L55;
        r112.i("LastWidgetPreloader", r111);
    L55:
        String r113 = r11.getBotId();
        if (r113.length() != 0) goto L58;
        Lazy r114 = p.f2292a;
        r113 = p.h(r11.getConversationId());
    L58:
        String r115 = r11.getPackageName();
        String r116 = r11.getConversationId();
        String r117 = r11.getMessageId();
        ((e) r110).getClass();
        e.d(r115, r116, r113, r117, "");
    L59:
        StringBuilder r23 = new StringBuilder("preloadLastWidget: start loadTemplateAndCache widgetId = ");
        r23.append(r11.getWidgetId());
        r23.append(", renderType = ");
        String r24 = androidx.room.jarjarred.org.antlr.runtime.a.v(r23, r21.f2268o, "LastWidgetPreloader", "tag");
        t0.d r118 = com.bytedance.ai.utils.c.f2846a;
        if (r118 == null) goto L63;
        r118.i("LastWidgetPreloader", r24);
    L63:
        if (Intrinsics.areEqual(r21.f2268o, "relax") == false) goto L67;
        this.d = r19;
        this.f2936a = r11;
        this.f2937b = null;
        this.f2938c = 2;
        e r119 = (e) r110;
        r119.getClass();
        if (e.e(r119, this) != r5) goto L70;
    L69:
        return r5;
    L67:
        this.d = r19;
        this.f2936a = r11;
        this.f2937b = null;
        this.f2938c = 3;
        e r120 = (e) r110;
        r120.getClass();
        if (e.f(r120, this) != r5) goto L70;
    L12:
        ResultKt.throwOnFailure(r18);
        r19 = (CoroutineScope) this.d;
        String r25 = c.f2983a.getString("LAST_WIDGET", "");
        if (r25 != null) goto L15;
    L86:
        Intrinsics.checkNotNullParameter("LastWidgetPreloader", "tag");
        t0.d r26 = com.bytedance.ai.utils.c.f2846a;
        if (r26 == null) goto L90;
        r26.e("LastWidgetPreloader", "preloadLastWidget: widgetJson is NULL");
    L90:
        return Unit.INSTANCE;
    L15:
        if (r25.length() == 0) goto L86;
        Intrinsics.checkNotNullParameter(ConversationWidgetData.class, "typeOfT");     // Catch: Exception -> L19
        r11 = (ConversationWidgetData) z0.a.a().fromJson(r25, ConversationWidgetData.class);     // Catch: Exception -> L19
    L24:
        if (r11 != null) goto L26;
    L81:
        Intrinsics.checkNotNullParameter("LastWidgetPreloader", "tag");
        t0.d r27 = com.bytedance.ai.utils.c.f2846a;
        if (r27 == null) goto L85;
        r27.e("LastWidgetPreloader", "preloadLastWidget: widgetCache is NULL");
    L85:
        return Unit.INSTANCE;
    L26:
        if (r11.getPackageName().length() == 0) goto L81;
        if (r11.getWidgetId().length() == 0) goto L81;
        if (r11.getConversationId().length() == 0) goto L81;
        if (Intrinsics.areEqual(r11.getAppType(), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L37;
        j r121 = j.f2734a;
        j.l(r11.getPackageName());
    L37:
        Trace.beginSection("preloadLastWidget");
        String r122 = "preloadLastWidget: packageName = " + r11.getPackageName() + ", widgetId = " + r11.getWidgetId();
        Intrinsics.checkNotNullParameter("LastWidgetPreloader", "tag");
        t0.d r123 = com.bytedance.ai.utils.c.f2846a;
        if (r123 == null) goto L40;
        r123.i("LastWidgetPreloader", r122);
    L40:
        t0.b r124 = p.f2294c;
        if (r124 == null) goto L44;
        r110 = r124.createWidgetResourceLoader(r11, null);
        if (r110 == null) goto L44;
    L45:
        this.d = r19;
        this.f2936a = r11;
        this.f2937b = r110;
        this.f2938c = 1;
        r20 = e.h((e) r110, this);
        if (r20 != r5) goto L48;
    L44:
        r110 = new e(r11);
    L19:
        e = move-exception;
        String r125 = e.getMessage();
        Intrinsics.checkNotNullParameter("LastWidgetPreloader", "tag");
        t0.d r126 = com.bytedance.ai.utils.c.f2846a;
        if (r126 == null) goto L23;
        r126.e("LastWidgetPreloader", r125, e);
    L23:
        r11 = null;
        goto L24
    }
}

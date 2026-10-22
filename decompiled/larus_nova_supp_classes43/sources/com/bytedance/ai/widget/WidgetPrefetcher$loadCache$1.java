package com.bytedance.ai.widget;

import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.widget.cache.WidgetResourceLoader;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.WidgetPrefetcher$loadCache$1", f = "WidgetPrefetcher.kt", i = {1, 1, 1, 1}, l = {28, 64, 80}, m = "invokeSuspend", n = {"context", "widgetInfo", "cbotId", "resourceLoader"}, s = {"L$1", "L$2", "L$3", "L$4"})
final class WidgetPrefetcher$loadCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ n this$0;

    public WidgetPrefetcher$loadCache$1(n r1, Continuation<? super WidgetPrefetcher$loadCache$1> r10) {
        this.this$0 = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new WidgetPrefetcher$loadCache$1(this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00b1 -> B:70:0x021a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00c1 -> B:70:0x021a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00cd -> B:70:0x021a). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r27) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        int r11 = 1;
        if (r10 == 0) goto L12;
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L10;
        if (r10 != 3) goto L9;
        ChannelIterator r12 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r27);
        WidgetPrefetcher$loadCache$1 r13 = this;
    L70:
        r11 = 1;
    L13:
        r13.L$0 = r12;
        r13.L$1 = null;
        r13.L$2 = null;
        r13.L$3 = null;
        r13.L$4 = null;
        r13.label = r11;
        Object r14 = r12.hasNext(r13);
        if (r14 != r1) goto L17;
        return r1;
    L17:
        if (((Boolean) r14).booleanValue() == false) goto L72;
        h5.k r15 = (h5.k) r12.next();
        com.bytedance.ai.utils.g r16 = com.bytedance.ai.utils.g.a;
        StringBuilder r17 = new StringBuilder("loadCache: ");
        WidgetInfo r18 = r15.f;
        if (r18 == null) goto L21;
        String r19 = r18.getWidgetId();
    L22:
        r17.append(r19);
        r17.append(" on ");
        r17.append(ThreadMethodProxy.currentThread().getName());
        r16.i("WidgetPrefetcher", r17.toString());
        WidgetInfo r110 = r15.f;
        if (r15.b == null) goto L70;
        if (r110 == null) goto L74;
        if (r110.getAppletId() == null) goto L70;
        if (r110.getWidgetId() == null) goto L70;
        if (Intrinsics.areEqual(r110.getWidgetId(), "system.login.authRequest") == true) goto L70;
        if (com.bytedance.ai.widget.cache.a.a.size() < 3) goto L36;
        boolean r111 = true;
    L37:
        if (r111 == false) goto L39;
        r16.i("WidgetPrefetcher", "loadCache: count is limited");
        SendChannel.a.a(r13.this$0.a);
        goto L72
    L39:
        r16.d("WidgetPrefetcher", "preload widget " + r110.getAppletId() + ' ' + r110.getWidgetId());
        String r112 = r15.e;
        if (r112 != null) goto L43;
        AppletRuntimeManager r113 = AppletRuntimeManager.INSTANCE;
        String r114 = r15.b;
        r113.getClass();
        r112 = AppletRuntimeManager.h(r114);
    L43:
        if (Intrinsics.areEqual(r110.getAppType(), "1") == false) goto L45;
        r110.getAppletId();
        AIManager r115 = AIManager.a;
        AIManager.f(r110.getAppletId());
    L45:
        Ref.ObjectRef r116 = new Ref.ObjectRef();
        r116.element = r110.getWidgetId();
        List<a.C0055a> r117 = a.a;
        String r118 = a.a(r110.getAppletId(), r110.getWidgetId());
        if (r118 == null) goto L48;
        r16.d("WidgetPrefetcher", "preload degrade widgetId: " + r110.getWidgetId() + " -> " + r118);
        r116.element = r118;
    L48:
        String r119 = r110.getAppletId();
        String r20 = (String) r116.element;
        if (r20 != null) goto L51;
        r20 = "";
    L51:
        String r120 = r112;
        ConversationWidgetData r21 = new ConversationWidgetData(r119, r20, r15.a(), r120, r15.b, r15.b(), null, null, r110.getVersionTag(), 192, null);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r22 = AppletRuntimeManager.d;
        if (r22 == null) goto L55;
        WidgetResourceLoader r23 = r22.B(r21);
        if (r23 == null) goto L55;
    L56:
        r13.L$0 = r12;
        r13.L$1 = r15;
        r13.L$2 = r110;
        r13.L$3 = r112;
        r13.L$4 = r23;
        r13.label = 2;
        Object r24 = r23.a(r13);
        if (r24 != r1) goto L59;
        return r1;
    L59:
        String r121 = r112;
        WidgetResourceLoader r25 = r23;
        ChannelIterator r26 = r12;
        com.bytedance.ai.widget.cache.b r28 = r25;
    L60:
        Widget r29 = (Widget) r24;
        if (r29 != null) goto L64;
        r12 = r26;
        goto L70
    L64:
        if (c3.b.a(r29.C) == true) goto L66;
        com.bytedance.ai.utils.g.a.d("WidgetPrefetcher", "preload runApplet " + r110.getAppletId() + " cvsId=" + r15.b);
        r28.d(r110.getAppletId(), r15.b, r121, r15.a(), r15.d);
    L66:
        r13.L$0 = r26;
        r13.L$1 = null;
        r13.L$2 = null;
        r13.L$3 = null;
        r13.L$4 = null;
        r13.label = 3;
        if (r28.c(r13) != r1) goto L69;
        return r1;
    L69:
        r12 = r26;
    L55:
        r23 = new WidgetResourceLoader(r21);
        goto L56
    L36:
        r111 = false;
        goto L37
    L74:
        if (0 == 0) goto L70;
        goto L70
    L21:
        r19 = null;
    L72:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r28 = (com.bytedance.ai.widget.cache.b) this.L$4;
        String r30 = (String) this.L$3;
        WidgetInfo r31 = (WidgetInfo) this.L$2;
        r15 = (h5.k) this.L$1;
        ChannelIterator r122 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r27);
        r121 = r30;
        r26 = r122;
        r13 = this;
        r110 = r31;
        r24 = r27;
        goto L60
    L11:
        r12 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r27);
        r14 = r27;
        r13 = this;
        goto L17
    L12:
        ResultKt.throwOnFailure(r27);
        r12 = this.this$0.a.iterator();
        r13 = this;
        goto L13
    }
}

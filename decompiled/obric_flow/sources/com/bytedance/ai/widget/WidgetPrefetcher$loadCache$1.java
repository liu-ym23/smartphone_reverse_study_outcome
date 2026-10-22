package com.bytedance.ai.widget;

import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
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
@DebugMetadata(c = "com.bytedance.ai.widget.WidgetPrefetcher$loadCache$1", f = "WidgetPrefetcher.kt", i = {1, 1, 1, 1}, l = {28, 58, 75, 77}, m = "invokeSuspend", n = {"context", "widgetInfo", "cbotId", "resourceLoader"}, s = {"L$1", "L$2", "L$3", "L$4"})
final class WidgetPrefetcher$loadCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kotlinx.coroutines.channels.k f2929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w2.r f2930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WidgetInfo f2931c;
    public String d;
    public com.bytedance.ai.widget.cache.b e;
    public int f;
    public final /* synthetic */ q g;

    public WidgetPrefetcher$loadCache$1(q r5, Continuation r10) {
        this.g = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new WidgetPrefetcher$loadCache$1(this.g, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        q r11 = this.g;
        return new WidgetPrefetcher$loadCache$1(r11, r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [kotlinx.coroutines.channels.k] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v6, types: [kotlinx.coroutines.channels.e, kotlinx.coroutines.channels.k] */
    /* JADX WARN: Type inference failed for: r10v7, types: [kotlinx.coroutines.channels.k] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00b6 -> B:65:0x0193). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00c6 -> B:65:0x0193). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00d3 -> B:65:0x0193). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0191 -> B:65:0x0193). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x01f2 -> B:65:0x0193). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x020a -> B:65:0x0193). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r27) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.f;
        int r11 = 1;
        if (r10 == 0) goto L14;
        if (r10 == 1) goto L13;
        if (r10 == 2) goto L12;
        if (r10 == 3) goto L11;
        if (r10 == 4) goto L11;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        kotlinx.coroutines.channels.k r12 = this.f2929a;
        ResultKt.throwOnFailure(r27);
        ?? r13 = r12;
    L65:
        r11 = 1;
        ?? r14 = r13;
    L15:
        this.f2929a = r14;
        this.f2930b = null;
        this.f2931c = null;
        this.d = null;
        this.e = null;
        this.f = r11;
        kotlinx.coroutines.channels.e r15 = (kotlinx.coroutines.channels.e) r14;
        Object r16 = r15.c(this);
        kotlinx.coroutines.channels.k r17 = r15;
        if (r16 != r5) goto L19;
    L79:
        return r5;
    L19:
        if (((Boolean) r16).booleanValue() == false) goto L81;
        r13 = (kotlinx.coroutines.channels.e) r17;
        w2.r r18 = (w2.r) r13.d();
        StringBuilder r19 = new StringBuilder("loadCache: ");
        WidgetInfo r110 = r18.e;
        if (r110 == null) goto L23;
        String r111 = r110.getWidgetId();
    L24:
        r19.append(r111);
        r19.append(" on ");
        r19.append(Thread.currentThread().getName());
        String r20 = r19.toString();
        Intrinsics.checkNotNullParameter("WidgetPrefetcher", "tag");
        t0.d r112 = com.bytedance.ai.utils.c.f2846a;
        if (r112 == null) goto L27;
        r112.i("WidgetPrefetcher", r20);
    L27:
        WidgetInfo r113 = r18.e;
        String r21 = r18.f22706b;
        if (r21 == null) goto L65;
        if (r113 == null) goto L82;
        if (r113.getAppletId() == null) goto L65;
        if (r113.getWidgetId() == null) goto L65;
        if (Intrinsics.areEqual(r113.getWidgetId(), "system.login.authRequest") == true) goto L65;
        if (com.bytedance.ai.widget.cache.a.f2981b.size() < 3) goto L44;
        Intrinsics.checkNotNullParameter("WidgetPrefetcher", "tag");
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L43;
        r22.i("WidgetPrefetcher", "loadCache: count is limited");
    L43:
        this.g.f3089a.o(null);
        goto L81
    L44:
        String r114 = "preload widget " + r113.getAppletId() + ' ' + r113.getWidgetId();
        Intrinsics.checkNotNullParameter("WidgetPrefetcher", "tag");
        t0.d r115 = com.bytedance.ai.utils.c.f2846a;
        if (r115 == null) goto L47;
        r115.d("WidgetPrefetcher", r114);
    L47:
        String r116 = r18.d;
        if (r116 != null) goto L50;
        String r23 = com.bytedance.ai.model.p.h(r21);
    L52:
        if (Intrinsics.areEqual(r113.getAppType(), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L54;
        r113.getAppletId();
        com.bytedance.ai.resource.j r117 = com.bytedance.ai.resource.j.f2734a;
        com.bytedance.ai.resource.j.l(r113.getAppletId());
    L54:
        ConversationWidgetData r118 = new ConversationWidgetData(r113.getAppletId(), r113.getWidgetId(), r18.a(), r23, r18.f22706b, null, null, null, null, 448, null);
        t0.b r24 = com.bytedance.ai.model.p.f2294c;
        if (r24 == null) goto L58;
        com.bytedance.ai.widget.cache.b r25 = r24.createWidgetResourceLoader(r118, null);
        if (r25 == null) goto L58;
    L59:
        this.f2929a = r13;
        this.f2930b = r18;
        this.f2931c = r113;
        this.d = r23;
        this.e = r25;
        this.f = 2;
        Object r119 = com.bytedance.ai.widget.cache.e.h((com.bytedance.ai.widget.cache.e) r25, this);
        if (r119 == r5) goto L79;
        com.bytedance.ai.widget.cache.b r26 = r25;
        String r28 = r23;
        com.bytedance.ai.widget.cache.b r29 = r26;
        r13 = r13;
    L63:
        Widget r120 = (Widget) r119;
        if (r120 == null) goto L65;
        if (ym.a.e(r120.C) == true) goto L73;
        StringBuilder r121 = new StringBuilder("preload runApplet ");
        r121.append(r113.getAppletId());
        r121.append(" cvsId=");
        String r122 = androidx.room.jarjarred.org.antlr.runtime.a.v(r121, r18.f22706b, "WidgetPrefetcher", "tag");
        t0.d r123 = com.bytedance.ai.utils.c.f2846a;
        if (r123 == null) goto L71;
        r123.d("WidgetPrefetcher", r122);
    L71:
        String r124 = r113.getAppletId();
        String r125 = r18.a();
        ((com.bytedance.ai.widget.cache.e) r29).getClass();
        com.bytedance.ai.widget.cache.e.d(r124, r18.f22706b, r28, r125, null);
    L73:
        if (Intrinsics.areEqual(r120.f2268o, "relax") == false) goto L77;
        this.f2929a = r13;
        this.f2930b = null;
        this.f2931c = null;
        this.d = null;
        this.e = null;
        this.f = 3;
        com.bytedance.ai.widget.cache.e r30 = (com.bytedance.ai.widget.cache.e) r29;
        r30.getClass();
        if (com.bytedance.ai.widget.cache.e.e(r30, this) != r5) goto L65;
    L77:
        this.f2929a = r13;
        this.f2930b = null;
        this.f2931c = null;
        this.d = null;
        this.e = null;
        this.f = 4;
        com.bytedance.ai.widget.cache.e r31 = (com.bytedance.ai.widget.cache.e) r29;
        r31.getClass();
        if (com.bytedance.ai.widget.cache.e.f(r31, this) != r5) goto L65;
    L58:
        r25 = new com.bytedance.ai.widget.cache.e(r118);
        goto L59
    L50:
        r23 = r116;
        goto L52
    L82:
        if (0 == 0) goto L65;
        goto L65
    L23:
        r111 = null;
    L81:
        return Unit.INSTANCE;
    L12:
        r29 = this.e;
        String r126 = this.d;
        r113 = this.f2931c;
        r18 = this.f2930b;
        kotlinx.coroutines.channels.k r127 = this.f2929a;
        ResultKt.throwOnFailure(r27);
        r28 = r126;
        r13 = r127;
        r119 = r27;
        goto L63
    L13:
        kotlinx.coroutines.channels.k r32 = this.f2929a;
        ResultKt.throwOnFailure(r27);
        r16 = r27;
        r17 = r32;
        goto L19
    L14:
        ResultKt.throwOnFailure(r27);
        kotlinx.coroutines.channels.f r33 = this.g.f3089a;
        r33.getClass();
        r14 = new kotlinx.coroutines.channels.e(r33);
        goto L15
    }
}

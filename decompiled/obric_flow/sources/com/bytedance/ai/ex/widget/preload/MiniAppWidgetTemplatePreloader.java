package com.bytedance.ai.ex.widget.preload;

import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.utils.c;
import com.bytedance.ai.widget.WidgetRenderType;
import com.bytedance.ai.widget.cache.a;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.utils.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.e2;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ$\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/ex/widget/preload/MiniAppWidgetTemplatePreloader;", "", "<init>", "()V", "TAG", "", "ensureTemplatePreloaded", "Lcom/bytedance/ai/ex/widget/preload/MiniAppWidgetTemplatePreloadResult;", "widget", "Lcom/bytedance/ai/model/objects/Widget;", "timeoutMs", "", "(Lcom/bytedance/ai/model/objects/Widget;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildPreloadToken", "packageName", "widgetId", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MiniAppWidgetTemplatePreloader {
    public static final MiniAppWidgetTemplatePreloader INSTANCE = null;
    private static final String TAG = "MiniAppWidgetTemplatePreloader";

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.preload.MiniAppWidgetTemplatePreloader$ensureTemplatePreloaded$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.preload.MiniAppWidgetTemplatePreloader", f = "MiniAppWidgetTemplatePreloader.kt", i = {0, 0, 0}, l = {51}, m = "ensureTemplatePreloaded", n = {"widget", "packageName", "widgetId"}, s = {"L$0", "L$1", "L$2"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MiniAppWidgetTemplatePreloader this$0;

        public AnonymousClass1(MiniAppWidgetTemplatePreloader r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.ensureTemplatePreloaded(null, 0, this);
        }
    }

    static {
        INSTANCE = new MiniAppWidgetTemplatePreloader();
    }

    private MiniAppWidgetTemplatePreloader() {
    }

    private final String buildPreloadToken(Widget r10, String r11, String r12) {
        return CollectionsKt.q(CollectionsKt.listOf(new String[]{r11, r12, String.valueOf(r10.f2260c), r10.f2268o.toString()}), ":", null, null, 0, null, null, 62);
    }

    public static String buildPreloadToken$default(MiniAppWidgetTemplatePreloader r5, Widget r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L8;
        r11 = r10.f2259b;
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        if ((r13 & 4) == 0) goto L13;
        r12 = r10.F;
        if (r12 != null) goto L13;
        r12 = "";
    L13:
        return r5.buildPreloadToken(r10, r11, r12);
    }

    public final Object ensureTemplatePreloaded(Widget r21, long r22, Continuation<? super MiniAppWidgetTemplatePreloadResult> r24) {
        Widget r5 = r21;
        if ((r24 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r10 = (AnonymousClass1) r24;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        String r15 = null;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        String r16 = (String) r10.L$2;
        String r17 = (String) r10.L$1;
        Widget r18 = (Widget) r10.L$0;
        ResultKt.throwOnFailure(r12);
        String r19 = r16;
        r5 = r18;
    L45:
        TemplateBundle r20 = (TemplateBundle) r12;
        if (r20 == null) goto L48;
        boolean r23 = a.f2980a;
        Intrinsics.checkNotNullParameter(r17, "packageName");
        Intrinsics.checkNotNullParameter(r19, "widgetId");
        Intrinsics.checkNotNullParameter(r20, "templateBundle");
        boolean r25 = a.f2980a;
        if (r25 == true) goto L53;
    L56:
        Intrinsics.checkNotNullParameter(r17, "packageName");
        Intrinsics.checkNotNullParameter(r19, "widgetId");
        if (r25 == true) goto L59;
        TemplateBundle r26 = null;
    L60:
        if (r26 == null) goto L62;
        r15 = INSTANCE.buildPreloadToken(r5, r17, r19);
    L62:
        String r27 = r15;
        if (r27 != null) goto L68;
        String r28 = b.j("template bundle loaded but cache token unavailable, package=", r17, ", widgetId=", r19);
        Intrinsics.checkNotNullParameter(TAG, "tag");
        d r29 = c.f2846a;
        if (r29 == null) goto L68;
        r29.w(TAG, r28);
    L68:
        return new MiniAppWidgetTemplatePreloadResult(true, r27, null, 4, null);
    L59:
        r26 = (TemplateBundle) a.f2982c.get(a.a(r17, r19));
        goto L60
    L53:
        if (a.f2981b.size() >= 3) goto L56;
        a.f2982c.put(a.a(r17, r19), r20);
        goto L56
    L48:
        return new MiniAppWidgetTemplatePreloadResult(false, null, "AppletLynxViewApi.getTemplateBundle returned null");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        String r30 = r5.f2259b;
        if (r30 != null) goto L17;
        r30 = "";
    L17:
        r19 = r5.F;
        if (r19 != null) goto L20;
        r19 = "";
    L20:
        String r31 = r5.f2268o;
        WidgetRenderType r110 = WidgetRenderType.f2932b;
        if (Intrinsics.areEqual(r31, "relax") == true) goto L74;
        if (StringsKt.isBlank(r5.G) == true) goto L74;
        if (StringsKt.isBlank(r30) == true) goto L72;
        if (StringsKt.isBlank(r19) == true) goto L72;
        boolean r32 = a.f2980a;
        Intrinsics.checkNotNullParameter(r30, "packageName");
        Intrinsics.checkNotNullParameter(r19, "widgetId");
        if (a.f2980a == true) goto L33;
        TemplateBundle r33 = null;
    L34:
        if (r33 != null) goto L36;
        MiniAppWidgetTemplatePreloader$ensureTemplatePreloaded$templateBundle$1 r34 = new MiniAppWidgetTemplatePreloader$ensureTemplatePreloaded$templateBundle$1(r5, null);
        r10.L$0 = r5;
        r10.L$1 = r30;
        r10.L$2 = r19;
        r10.label = 1;
        if (r22 <= 0) goto L70;
        Object r35 = e2.a(new d2(r22, r10), r34);
        if (r35 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L42;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L42:
        if (r35 != r13) goto L44;
        return r13;
    L44:
        String r111 = r30;
        r12 = r35;
        r17 = r111;
        goto L45
    L70:
        throw new TimeoutCancellationException("Timed out immediately");
    L36:
        return new MiniAppWidgetTemplatePreloadResult(true, INSTANCE.buildPreloadToken(r5, r30, r19), null, 4, null);
    L33:
        r33 = (TemplateBundle) a.f2982c.get(a.a(r30, r19));
    L72:
        return new MiniAppWidgetTemplatePreloadResult(false, null, "widget packageName or widgetId is blank");
    L74:
        return new MiniAppWidgetTemplatePreloadResult(true, null, null, 4, null);
    L7:
        r10 = new AnonymousClass1(this, r24);
        goto L8
    }
}

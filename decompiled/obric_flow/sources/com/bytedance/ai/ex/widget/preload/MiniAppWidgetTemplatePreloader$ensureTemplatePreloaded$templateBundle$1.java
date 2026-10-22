package com.bytedance.ai.ex.widget.preload;

import android.util.LruCache;
import com.bytedance.ai.lynx.i;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.e0;
import com.lynx.tasm.TemplateBundle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/lynx/tasm/TemplateBundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.ex.widget.preload.MiniAppWidgetTemplatePreloader$ensureTemplatePreloaded$templateBundle$1", f = "MiniAppWidgetTemplatePreloader.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
public final class MiniAppWidgetTemplatePreloader$ensureTemplatePreloaded$templateBundle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TemplateBundle>, Object> {
    final /* synthetic */ Widget $widget;
    int label;

    public MiniAppWidgetTemplatePreloader$ensureTemplatePreloaded$templateBundle$1(Widget r5, Continuation<? super MiniAppWidgetTemplatePreloader$ensureTemplatePreloaded$templateBundle$1> r10) {
        this.$widget = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new MiniAppWidgetTemplatePreloader$ensureTemplatePreloaded$templateBundle$1(this.$widget, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super TemplateBundle> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L8;
        ResultKt.throwOnFailure(r5);
        return r5;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        Widget r12 = this.$widget;
        String r13 = r12.f2276x;
        if (r13 != null) goto L12;
        r13 = "";
    L12:
        LruCache r14 = e0.f2711a;
        String r15 = e0.d(r12, r12.G);
        this.label = 1;
        Object r16 = i.b(r13, r15, this);
        if (r16 != r10) goto L15;
        return r10;
    L15:
        return r16;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super TemplateBundle> r10) {
        return ((MiniAppWidgetTemplatePreloader$ensureTemplatePreloaded$templateBundle$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}

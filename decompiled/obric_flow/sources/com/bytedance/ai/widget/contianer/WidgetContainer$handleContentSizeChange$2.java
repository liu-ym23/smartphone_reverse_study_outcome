package com.bytedance.ai.widget.contianer;

import com.bytedance.ai.api.model.view.WidgetEvent;
import java.util.Iterator;
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
import w0.m;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.contianer.WidgetContainer$handleContentSizeChange$2", f = "WidgetContainer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WidgetContainer$handleContentSizeChange$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WidgetContainer f3037a;

    public WidgetContainer$handleContentSizeChange$2(WidgetContainer r5, Continuation r10) {
        this.f3037a = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new WidgetContainer$handleContentSizeChange$2(this.f3037a, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        WidgetContainer r11 = this.f3037a;
        return new WidgetContainer$handleContentSizeChange$2(r11, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r5);
        WidgetContainer r10 = this.f3037a;
        WidgetEvent r11 = WidgetEvent.f1707a;
        r10.getClass();
        WidgetEvent r12 = WidgetEvent.f1707a;
        Intrinsics.checkNotNullParameter(r12, "event");
        Iterator r13 = r10.d.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        ((m) r13.next()).onEvent(r12);
        goto L4
    L7:
        return Unit.INSTANCE;
    }
}

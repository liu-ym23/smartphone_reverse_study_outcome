package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import android.view.View;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.android.accessibilityLib_Core.processor.ViewTraverseProcessor$rootViewOut$1", f = "ViewTraverseProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ViewTraverseProcessor$rootViewOut$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ View $activityRootView;
    int label;

    public ViewTraverseProcessor$rootViewOut$1(View r1, Continuation r10) {
        this.$activityRootView = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ViewTraverseProcessor$rootViewOut$1(this.$activityRootView, r11);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r10);
        WeakHashMap<View, WeakHashMap<View, Boolean>> r11 = ViewTraverseProcessor.d;     // Catch: Exception -> L21
        WeakHashMap<View, Boolean> r0 = r11.get(this.$activityRootView);     // Catch: Exception -> L21
        if (r0 == null) goto L14;
        monitor-enter(r0);     // Catch: Exception -> L21
        r0.clear();     // Catch: Throwable -> L11
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Exception -> L21
        goto L14
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L21
    L14:
        monitor-enter(r11);     // Catch: Exception -> L21
        WeakHashMap<View, Boolean> r12 = r11.remove(this.$activityRootView);     // Catch: Throwable -> L18
        monitor-exit(r11);     // Catch: Exception -> L21
        return r12;
    L18:
        th = move-exception;
        throw th;     // Catch: Exception -> L21
    L21:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L26;
        Context r13 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L26:
        return Unit.INSTANCE;
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

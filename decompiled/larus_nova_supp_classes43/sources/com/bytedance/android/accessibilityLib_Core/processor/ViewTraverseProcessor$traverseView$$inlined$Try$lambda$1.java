package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.accessibilityLib_Core.tool.AccessibilityCommonToolExtKt;
import java.lang.ref.WeakReference;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/accessibilityLib_Core/processor/ViewTraverseProcessor$traverseView$1$1"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.android.accessibilityLib_Core.processor.ViewTraverseProcessor$traverseView$1$1", f = "ViewTraverseProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ViewTraverseProcessor$traverseView$$inlined$Try$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $activityRootView$inlined;
    final /* synthetic */ int $resource$inlined;
    final /* synthetic */ TraverseFromType $traverseFromType$inlined;
    final /* synthetic */ WeakReference $weakRefRoot;
    int label;

    public ViewTraverseProcessor$traverseView$$inlined$Try$lambda$1(WeakReference r1, Continuation r10, View r11, TraverseFromType r12, int r13) {
        this.$weakRefRoot = r1;
        this.$activityRootView$inlined = r11;
        this.$traverseFromType$inlined = r12;
        this.$resource$inlined = r13;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ViewTraverseProcessor$traverseView$$inlined$Try$lambda$1(this.$weakRefRoot, r11, this.$activityRootView$inlined, this.$traverseFromType$inlined, this.$resource$inlined);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L57;
        ResultKt.throwOnFailure(r10);
        View r11 = (View) this.$weakRefRoot.get();
        if (r11 == null) goto L55;
        if (r11.isAttachedToWindow() == false) goto L9;
        WeakHashMap<View, WeakHashMap<View, Boolean>> r0 = ViewTraverseProcessor.d;
        final WeakHashMap<View, Boolean> r1 = r0.get(r11);
        if (r1 != null) goto L17;
        r1 = new WeakHashMap();
    L17:
        monitor-enter(r1);
        final int r12 = this.$resource$inlined;     // Catch: Throwable -> L51
        final TraverseFromType r13 = this.$traverseFromType$inlined;     // Catch: Throwable -> L51
        AccessibilityCommonToolExtKt.b(r11, new ViewTraverseProcessor$bfsVisitWithDiffTreeNode$1(r13, r1), new ViewTraverseProcessor$bfsVisitWithDiffTreeNode$2(r1, r13, r12));     // Catch: Throwable -> L51
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L51
        monitor-exit(r1);
        monitor-enter(r0);
        r0.put(r11, r1);     // Catch: Throwable -> L48
        monitor-exit(r0);
        WeakReference r15 = this.$weakRefRoot;
    L41:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L45;
        Context r16 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L45:
        Context r17 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        Unit r18 = Unit.INSTANCE;
    L47:
        return Unit.INSTANCE;
    L25:
        if (e.a(this.$traverseFromType$inlined) == false) goto L47;
        if (com.bytedance.android.accessibilityLib_Core.engine.b.c == false) goto L47;
        View r19 = (View) r15.get();     // Catch: Exception -> L41
        if (r19 == null) goto L33;
        ViewTreeObserver r20 = r19.getViewTreeObserver();     // Catch: Exception -> L41
    L34:
        if (r20 != null) goto L36;
    L38:
        if (r20 == null) goto L47;
        r20.addOnGlobalLayoutListener(new d(r15));     // Catch: Exception -> L41
        goto L47
    L36:
        if (r20.isAlive() == true) goto L38;
    L33:
        r20 = null;
    L48:
        th = move-exception;
        throw th;
    L51:
        th = move-exception;
        throw th;
    L9:
        if ((r11 + " don't attached window again ,return ") == null) goto L12;
        Context r21 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L12:
        return Unit.INSTANCE;
    L55:
        return Unit.INSTANCE;
    L57:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

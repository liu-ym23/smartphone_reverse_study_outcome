package com.ss.android.lark.quicklaunchbar.widget;

import android.animation.ValueAnimator;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.quicklaunchbar.widget.QuickLaunchBar$onPageScrollChange$1", f = "QuickLaunchBar.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, s = {})
final class QuickLaunchBar$onPageScrollChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ QuickLaunchBar this$0;

    public QuickLaunchBar$onPageScrollChange$1(QuickLaunchBar r1, Continuation<? super QuickLaunchBar$onPageScrollChange$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new QuickLaunchBar$onPageScrollChange$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:12:0x0027). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
        QuickLaunchBar$onPageScrollChange$1 r10 = this;
    L12:
        QuickLaunchBar r2 = r10.this$0;
        int r3 = QuickLaunchBar.g;
        r2.getClass();
        QuickLaunchBar r4 = r10.this$0;
        if (r4.f != 0) goto L14;
    L9:
        r10.label = 1;
        if (DelayKt.delay(400, r10) != r0) goto L12;
        return r0;
    L14:
        r4.getClass();
        int r5 = 0 - r10.this$0.f;
        if (r4.getQuickLaunchBarHeight() <= 0) goto L18;
        r4.g();
    L24:
        QuickLaunchBar r6 = r10.this$0;
        r6.getClass();
        r6.f = 0;
        goto L9
    L18:
        if (Math.abs(r5) < j08.b.a(r4.getContext(), 5.0f)) goto L24;
        if (r5 >= 0) goto L22;
        r4.g();
        goto L24
    L22:
        if (r4.e == false) goto L24;
        ValueAnimator r7 = ValueAnimator.ofInt(new int[]{r4.getQuickLaunchBarHeight(), 0});
        r7.addUpdateListener(new c(r4));
        r7.setDuration(300);
        r7.start();
        r4.e = false;
        goto L24
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        r10 = this;
        goto L9
    }
}

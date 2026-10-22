package com.larus.dora.impl.guide;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.DoraBatteryGuide$showGuideInternal$2", f = "DoraBatteryGuide.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraBatteryGuide$showGuideInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ View $anchorView;
    final /* synthetic */ Balloon $balloon;
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ DoraBatteryGuide this$0;

    public DoraBatteryGuide$showGuideInternal$2(View r1, Balloon r2, Context r3, DoraBatteryGuide r4, Continuation<? super DoraBatteryGuide$showGuideInternal$2> r5) {
        this.$anchorView = r1;
        this.$balloon = r2;
        this.$context = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraBatteryGuide$showGuideInternal$2(this.$anchorView, this.$balloon, this.$context, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<Object> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static View INVOKEVIRTUAL_com_larus_dora_impl_guide_DoraBatteryGuide$showGuideInternal$2_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r4);
        View r5 = this.$anchorView;
        if (r5 == null) goto L7;
        this.$balloon.s(r5, 0, c7.b(Boxing.boxInt(5)));
        return Unit.INSTANCE;
    L7:
        Context r6 = this.$context;
        if ((r6 instanceof Activity) == false) goto L10;
        Activity r7 = (Activity) r6;
    L11:
        if (r7 == null) goto L15;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L15;
        final View r9 = INVOKEVIRTUAL_com_larus_dora_impl_guide_DoraBatteryGuide$showGuideInternal$2_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r8);
    L16:
        if (r9 == null) goto L18;
        final Balloon r0 = this.$balloon;
        return Boxing.boxBoolean(r9.post(new g(r0, r9)));
    L18:
        g49.d.b("DoraBatteryGuide", "showGuide() failed: no anchor and context root is null");
        DoraBatteryGuide r10 = this.this$0;
        int r1 = DoraBatteryGuide.d;
        r10.k(404);
        DoraBatteryGuide r11 = this.this$0;
        t39.m r2 = r11.b;
        if (r2 == null) goto L22;
        r2.a(r11);
        return Unit.INSTANCE;
    L22:
        return null;
    L15:
        r9 = null;
        goto L16
    L10:
        r7 = null;
        goto L11
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

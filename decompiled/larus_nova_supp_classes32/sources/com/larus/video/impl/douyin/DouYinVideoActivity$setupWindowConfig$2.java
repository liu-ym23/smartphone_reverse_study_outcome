package com.larus.video.impl.douyin;

import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.video.impl.douyin.DouYinVideoActivity$setupWindowConfig$2", f = "DouYinVideoActivity.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
final class DouYinVideoActivity$setupWindowConfig$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    final /* synthetic */ DouYinVideoActivity this$0;

    public DouYinVideoActivity$setupWindowConfig$2(DouYinVideoActivity r1, Continuation<? super DouYinVideoActivity$setupWindowConfig$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DouYinVideoActivity$setupWindowConfig$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static View INVOKEVIRTUAL_com_larus_video_impl_douyin_DouYinVideoActivity$setupWindowConfig$2_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003b -> B:13:0x003e). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$1;
        int r4 = this.I$0;
        AppCompatActivity r5 = (DouYinVideoActivity) this.L$0;
        ResultKt.throwOnFailure(r11);
        DouYinVideoActivity$setupWindowConfig$2 r12 = this;
    L13:
        FrameLayout r6 = (FrameLayout) INVOKEVIRTUAL_com_larus_video_impl_douyin_DouYinVideoActivity$setupWindowConfig$2_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r5.getWindow()).findViewById(2131384840);
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("root_view isVisible: ");
        if (r6 != null) goto L16;
        Boolean r9 = null;
    L21:
        r8.append(r9);
        r7.d("DouYinVideoActivity", r8.toString());
        if (r6 == null) goto L24;
        e1.x(r6);
    L24:
        r2 = r2 + 1;
    L9:
        if (r2 >= r4) goto L26;
        r12.L$0 = r5;
        r12.I$0 = r4;
        r12.I$1 = r2;
        r12.label = 1;
        if (DelayKt.delay(50, r12) != r0) goto L13;
        return r0;
    L26:
        return Unit.INSTANCE;
    L16:
        if (r6.getVisibility() != 0) goto L18;
        boolean r10 = true;
    L19:
        r9 = Boxing.boxBoolean(r10);
        goto L21
    L18:
        r10 = false;
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        r5 = this.this$0;
        r2 = 0;
        r4 = 3;
        r12 = this;
        goto L9
    }
}

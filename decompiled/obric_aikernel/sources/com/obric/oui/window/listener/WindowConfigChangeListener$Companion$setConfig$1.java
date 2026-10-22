package com.obric.oui.window.listener;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import ia.a;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.obric.oui.window.listener.WindowConfigChangeListener$Companion$setConfig$1", f = "WindowConfigChangeListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WindowConfigChangeListener$Companion$setConfig$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Configuration $config;
    final /* synthetic */ Activity $context;
    final /* synthetic */ int $currentWindowHeight;
    final /* synthetic */ int $currentWindowWidth;
    int label;

    WindowConfigChangeListener$Companion$setConfig$1(Activity r10, Configuration r11, int r12, int r13, Continuation r14) {
        this.$context = r10;
        this.$config = r11;
        this.$currentWindowWidth = r12;
        this.$currentWindowHeight = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        return new WindowConfigChangeListener$Companion$setConfig$1(this.$context, this.$config, this.$currentWindowWidth, this.$currentWindowHeight, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return ((WindowConfigChangeListener$Companion$setConfig$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L33;
        ResultKt.throwOnFailure(r18);
        int r10 = this.$context.hashCode();
        Pair r11 = (Pair) WindowConfigChangeListener.access$getMConfigDiffMap$cp().get(Boxing.boxInt(r10));
        if (r11 != null) goto L7;
        WindowConfigChangeListener.Companion.k(WindowConfigChangeListener.Companion, (FragmentActivity) this.$context, this.$config, this.$currentWindowWidth, this.$currentWindowHeight, false, 16, null);
    L31:
        return Unit.INSTANCE;
    L7:
        int r12 = this.$config.diff((Configuration) r11.getFirst());
        if ((r12 & 128) == 0) goto L10;
    L29:
        WindowConfigChangeListener.Companion.k(WindowConfigChangeListener.Companion, (FragmentActivity) this.$context, this.$config, this.$currentWindowWidth, this.$currentWindowHeight, false, 16, null);
        goto L31
    L10:
        if ((r12 & 256) != 0) goto L29;
        if ((r12 & 1024) != 0) goto L29;
        if ((r12 & 2048) != 0) goto L29;
        if ((r12 & 4096) != 0) goto L29;
        if ((r12 & 16384) != 0) goto L29;
        if ((r12 & 512) != 0) goto L29;
        Pair r13 = (Pair) WindowConfigChangeListener.access$getMConfigDiffMap$cp().get(Boxing.boxInt(r10));
        if (r13 != null) goto L25;
    L28:
        Log.e("Window", "setConfigInternal due to window width diff");
        WindowConfigChangeListener.Companion.a(WindowConfigChangeListener.Companion, (FragmentActivity) this.$context, this.$config, this.$currentWindowWidth, this.$currentWindowHeight, true);
        goto L31
    L25:
        if (((Number) r13.getSecond()).intValue() != this.$currentWindowWidth) goto L28;
        if (a.f9451f.c().a() == this.$currentWindowWidth) goto L31;
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

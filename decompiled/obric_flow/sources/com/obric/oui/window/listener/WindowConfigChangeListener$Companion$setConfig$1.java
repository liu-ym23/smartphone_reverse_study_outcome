package com.obric.oui.window.listener;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import java.util.concurrent.ConcurrentHashMap;
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
import kotlinx.coroutines.CoroutineScope;
import m.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.obric.oui.window.listener.WindowConfigChangeListener$Companion$setConfig$1", f = "WindowConfigChangeListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WindowConfigChangeListener$Companion$setConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Configuration $config;
    final /* synthetic */ Activity $context;
    final /* synthetic */ int $currentWindowHeight;
    final /* synthetic */ int $currentWindowWidth;
    int label;

    public WindowConfigChangeListener$Companion$setConfig$1(Activity r5, Configuration r10, int r11, int r12, Continuation<? super WindowConfigChangeListener$Companion$setConfig$1> r13) {
        this.$context = r5;
        this.$config = r10;
        this.$currentWindowWidth = r11;
        this.$currentWindowHeight = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new WindowConfigChangeListener$Companion$setConfig$1(this.$context, this.$config, this.$currentWindowWidth, this.$currentWindowHeight, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L34;
        ResultKt.throwOnFailure(r5);
        int r10 = this.$context.hashCode();
        ConcurrentHashMap r11 = WindowConfigChangeListener.f14902c;
        Pair r12 = (Pair) r11.get(Boxing.boxInt(r10));
        if (r12 != null) goto L7;
        b.k((FragmentActivity) this.$context, this.$config, this.$currentWindowWidth, this.$currentWindowHeight);
    L32:
        return Unit.INSTANCE;
    L7:
        int r13 = this.$config.diff((Configuration) r12.getFirst());
        if ((r13 & 128) == 0) goto L10;
    L30:
        b.k((FragmentActivity) this.$context, this.$config, this.$currentWindowWidth, this.$currentWindowHeight);
        goto L32
    L10:
        if ((r13 & 256) != 0) goto L30;
        if ((r13 & 1024) != 0) goto L30;
        if ((r13 & 2048) != 0) goto L30;
        if ((r13 & 4096) != 0) goto L30;
        if ((r13 & 16384) != 0) goto L30;
        if ((r13 & 512) != 0) goto L30;
        Pair r14 = (Pair) r11.get(Boxing.boxInt(r10));
        if (r14 == null) goto L29;
        int r15 = ((Number) r14.getSecond()).intValue();
        int r16 = this.$currentWindowWidth;
        if (r15 != r16) goto L29;
        if (us.a.f22453c.f22006c == r16) goto L32;
    L29:
        Log.e("Window", "setConfigInternal due to window width diff");
        ConcurrentHashMap r17 = WindowConfigChangeListener.f14902c;
        b.k((FragmentActivity) this.$context, this.$config, this.$currentWindowWidth, this.$currentWindowHeight);
        goto L32
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((WindowConfigChangeListener$Companion$setConfig$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}

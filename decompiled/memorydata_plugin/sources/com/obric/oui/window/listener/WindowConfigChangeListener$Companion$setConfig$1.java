package com.obric.oui.window.listener;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.obric.oui.window.d.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.obric.oui.window.listener.WindowConfigChangeListener$Companion$setConfig$1", f = "WindowConfigChangeListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WindowConfigChangeListener$Companion$setConfig$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Configuration $config;
    final /* synthetic */ Activity $context;
    final /* synthetic */ int $currentWindowHeight;
    final /* synthetic */ int $currentWindowWidth;
    int label;

    WindowConfigChangeListener$Companion$setConfig$1(Activity r3, Configuration r4, int r5, int r6, Continuation<? super WindowConfigChangeListener$Companion$setConfig$1> r7) {
        Activity r8 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$context = ZeusTransformUtils.wrapperContext2Activity(r8, "com.obric.memorydata.plugin");
        this.$config = r4;
        this.$currentWindowWidth = r5;
        this.$currentWindowHeight = r6;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new WindowConfigChangeListener$Companion$setConfig$1(this.$context, this.$config, this.$currentWindowWidth, this.$currentWindowHeight, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((WindowConfigChangeListener$Companion$setConfig$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), WindowConfigChangeListener$Companion$setConfig$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L36;
        ResultKt.throwOnFailure(r20);
        int r1 = this.$context.hashCode();
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(WindowConfigChangeListener.access$getMConfigDiffMap$cp().get(Boxing.boxInt(r1)), Pair.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        WindowConfigChangeListener.a.a(WindowConfigChangeListener.Companion, (FragmentActivity) ZeusTransformUtils.preCheckCast(this.$context, FragmentActivity.class, "com.obric.memorydata.plugin"), this.$config, this.$currentWindowWidth, this.$currentWindowHeight, false, 16, null);
    L34:
        return Unit.INSTANCE;
    L7:
        int r3 = this.$config.diff((Configuration) ZeusTransformUtils.preCheckCast(r2.getFirst(), Configuration.class, "com.obric.memorydata.plugin"));
        if ((r3 & 128) == 0) goto L10;
    L32:
        WindowConfigChangeListener.a.a(WindowConfigChangeListener.Companion, (FragmentActivity) ZeusTransformUtils.preCheckCast(this.$context, FragmentActivity.class, "com.obric.memorydata.plugin"), this.$config, this.$currentWindowWidth, this.$currentWindowHeight, false, 16, null);
        goto L34
    L10:
        if ((r3 & 256) != 0) goto L32;
        if ((r3 & 1024) != 0) goto L32;
        if ((r3 & 2048) != 0) goto L32;
        if ((r3 & 4096) != 0) goto L32;
        if ((r3 & 16384) != 0) goto L32;
        if ((r3 & 512) != 0) goto L32;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(WindowConfigChangeListener.access$getMConfigDiffMap$cp().get(Boxing.boxInt(r1)), Pair.class, "com.obric.memorydata.plugin");
        boolean r5 = false;
        if (r4 != null) goto L26;
    L28:
        if (r5 == true) goto L30;
    L31:
        Log.e("Window", "setConfigInternal due to window width diff");
        WindowConfigChangeListener.a.a(WindowConfigChangeListener.Companion, (FragmentActivity) ZeusTransformUtils.preCheckCast(this.$context, FragmentActivity.class, "com.obric.memorydata.plugin"), this.$config, this.$currentWindowWidth, this.$currentWindowHeight, true);
        goto L34
    L30:
        if (a.f14897a.c().a() == this.$currentWindowWidth) goto L34;
    L26:
        if (((Number) ZeusTransformUtils.preCheckCast(r4.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue() != this.$currentWindowWidth) goto L28;
        r5 = true;
        goto L28
    L36:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

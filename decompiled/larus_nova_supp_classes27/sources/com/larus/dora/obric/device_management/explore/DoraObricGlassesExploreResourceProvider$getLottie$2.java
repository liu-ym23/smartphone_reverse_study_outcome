package com.larus.dora.obric.device_management.explore;

import com.larus.dora.impl.util.DoraResourceUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesLottieResource;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.explore.DoraObricGlassesExploreResourceProvider$getLottie$2", f = "DoraObricGlassesExploreResourceProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricGlassesExploreResourceProvider$getLottie$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b1>, Object> {
    final /* synthetic */ c1 $spec;
    int label;

    public DoraObricGlassesExploreResourceProvider$getLottie$2(c1 r1, Continuation<? super DoraObricGlassesExploreResourceProvider$getLottie$2> r2) {
        this.$spec = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraObricGlassesExploreResourceProvider$getLottie$2(this.$spec, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super b1> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L34;
        ResultKt.throwOnFailure(r6);
        String r7 = this.$spec.a;
        boolean r1 = true;
        if ((!StringsKt.isBlank(r7)) == true) goto L9;
        r7 = null;
    L9:
        if (r7 != null) goto L11;
    L14:
        boolean r3 = true;
    L16:
        if (r3 == false) goto L19;
        g49.d.e("DoraObricGlassesExploreResourceProvider", "lottie resourceName is empty");
        return null;
    L19:
        String r8 = DoraResourceUtil.f(r7);
        if ((!StringsKt.isBlank(r8)) == true) goto L23;
        r8 = null;
    L23:
        if (r8 != null) goto L25;
    L28:
        if (r1 == false) goto L32;
        g49.d.e("DoraObricGlassesExploreResourceProvider", "resolve lottie failed: resourceName=" + this.$spec.a);
        return null;
    L32:
        return new b1(r8);
    L25:
        if (StringsKt.isBlank(r8) == true) goto L28;
        r1 = false;
        goto L28
    L11:
        if (StringsKt.isBlank(r7) == true) goto L14;
        r3 = false;
        goto L16
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

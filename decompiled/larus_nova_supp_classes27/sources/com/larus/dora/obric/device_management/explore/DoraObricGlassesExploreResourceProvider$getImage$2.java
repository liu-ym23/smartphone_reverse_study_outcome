package com.larus.dora.obric.device_management.explore;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesImageResource$RemoteUrl;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.explore.DoraObricGlassesExploreResourceProvider$getImage$2", f = "DoraObricGlassesExploreResourceProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricGlassesExploreResourceProvider$getImage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DoraObricGlassesImageResource.RemoteUrl>, Object> {
    final /* synthetic */ x0 $spec;
    int label;

    public DoraObricGlassesExploreResourceProvider$getImage$2(x0 r1, Continuation<? super DoraObricGlassesExploreResourceProvider$getImage$2> r2) {
        this.$spec = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraObricGlassesExploreResourceProvider$getImage$2(this.$spec, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super DoraObricGlassesImageResource.RemoteUrl> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r5);
        String r6 = this.$spec.a;
        if ((!StringsKt.isBlank(r6)) == true) goto L8;
        r6 = null;
    L8:
        if (r6 != null) goto L10;
    L13:
        boolean r7 = true;
    L14:
        if (r7 == false) goto L17;
        g49.d.e("DoraObricGlassesExploreResourceProvider", "image resourceName is empty");
        return new DoraObricGlassesImageResource.RemoteUrl("");
    L17:
        t0 r0 = t0.a;
        x0 r2 = this.$spec;
        r0.getClass();
        int r1 = t0.a.a[r2.b.ordinal()];
        if (r1 != 1) goto L20;
        String r3 = "https://p3-starweave-source.byteimg.com/tos-cn-i-99ixvlomm4/dora/obric/glasses/explore/v1";
    L29:
        return new DoraObricGlassesImageResource.RemoteUrl(r3 + '/' + r2.a + ".png");
    L20:
        if (r1 != 2) goto L22;
        r3 = "https://p3-starweave-source.byteimg.com/tos-cn-i-99ixvlomm4/dora/obric/glasses/explore/detail/v1";
        goto L29
    L22:
        if (r1 != 3) goto L25;
        r3 = "https://p3-starweave-source.byteimg.com/tos-cn-i-99ixvlomm4/dora/obric/glasses/explore/basic/detail/v2";
        goto L29
    L25:
        throw new NoWhenBranchMatchedException();
    L10:
        if (StringsKt.isBlank(r6) == true) goto L13;
        r7 = false;
        goto L14
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

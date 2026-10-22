package com.larus.uaigc.creation.gallery.providers;

import com.facebook.datasource.DataSource;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.z2;
import com.tencent.open.log.TraceLevel;
import hq9.v1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationBottomProvider$prefetchToCreationBitmapCache$1$1", f = "CreationBottomProvider.kt", i = {}, l = {57, 61}, m = "invokeSuspend", n = {}, s = {})
final class CreationBottomProvider$prefetchToCreationBitmapCache$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ zo8.b $it;
    int label;

    public CreationBottomProvider$prefetchToCreationBitmapCache$1$1(zo8.b r1, Continuation<? super CreationBottomProvider$prefetchToCreationBitmapCache$1$1> r2) {
        this.$it = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationBottomProvider$prefetchToCreationBitmapCache$1$1(this.$it, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L29:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L15:
        DataSource r13 = (DataSource) r12;
    L16:
        v1 r14 = z2.a.getCreationShareSettings().a();
        if (r14 != null) goto L19;
    L21:
        r3 = false;
    L22:
        if (r3 == false) goto L29;
        String r4 = this.$it.a.e;
        if (r4 == null) goto L29;
        this.label = 2;
        if (ImageLoaderKt.A(r4, "creation_share_v2", null, null, null, this, 60) != r0) goto L29;
        return r0;
    L19:
        if (r14.c() != true) goto L21;
    L10:
        ResultKt.throwOnFailure(r12);
        String r5 = this.$it.a.d;
        if (r5 == null) goto L16;
        this.label = 1;
        r12 = ImageLoaderKt.A(r5, "creation_share_v2", null, null, null, this, 60);
        if (r12 != r0) goto L15;
        return r0;
    }
}

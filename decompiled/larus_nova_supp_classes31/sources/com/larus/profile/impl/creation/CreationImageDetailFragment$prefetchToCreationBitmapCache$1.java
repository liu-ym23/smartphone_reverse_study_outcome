package com.larus.profile.impl.creation;

import com.facebook.datasource.DataSource;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreation;
import com.tencent.open.log.TraceLevel;
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
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationImageDetailFragment$prefetchToCreationBitmapCache$1", f = "CreationImageDetailFragment.kt", i = {0}, l = {532, 536}, m = "invokeSuspend", n = {"imageInfo"}, s = {"L$0"})
final class CreationImageDetailFragment$prefetchToCreationBitmapCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ CreationImageDetailFragment this$0;

    public CreationImageDetailFragment$prefetchToCreationBitmapCache$1(CreationImageDetailFragment r1, Continuation<? super CreationImageDetailFragment$prefetchToCreationBitmapCache$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationImageDetailFragment$prefetchToCreationBitmapCache$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r13);
    L39:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ImageInfo r2 = (ImageInfo) this.L$0;
        ResultKt.throwOnFailure(r13);
    L29:
        DataSource r14 = (DataSource) r13;
    L30:
        if (r2 == null) goto L32;
        Image r15 = r2.i;
    L33:
        String r4 = i2.d(r15);
        if (r4 == null) goto L39;
        this.L$0 = null;
        this.label = 2;
        if (ImageLoaderKt.A(r4, "creation_share", null, null, null, this, 60) != r0) goto L39;
        return r0;
    L32:
        r15 = null;
        goto L33
    L10:
        ResultKt.throwOnFailure(r13);
        CreationImageDetailFragment r16 = this.this$0;
        UserCreation r3 = r16.I;
        if (r3 == null) goto L13;
        r2 = i2.a(r3, r16.ka0());
    L14:
        hq9.v1 r17 = com.larus.platform.service.z2.a.getCreationShareSettings().a();
        if (r17 != null) goto L17;
    L19:
        boolean r18 = false;
    L20:
        if (r18 == false) goto L30;
        if (r2 == null) goto L30;
        Image r19 = r2.d;
        if (r19 == null) goto L30;
        String r5 = r19.a;
        if (r5 == null) goto L30;
        this.L$0 = r2;
        this.label = 1;
        r13 = ImageLoaderKt.A(r5, "creation_share", null, null, null, this, 60);
        if (r13 != r0) goto L29;
        return r0;
    L17:
        if (r17.c() != true) goto L19;
        r18 = true;
        goto L20
    L13:
        r2 = null;
        goto L14
    }
}

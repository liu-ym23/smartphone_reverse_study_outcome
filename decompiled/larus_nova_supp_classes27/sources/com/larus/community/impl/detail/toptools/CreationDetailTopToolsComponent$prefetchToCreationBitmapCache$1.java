package com.larus.community.impl.detail.toptools;

import com.facebook.datasource.DataSource;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.z2;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.toptools.CreationDetailTopToolsComponent$prefetchToCreationBitmapCache$1", f = "CreationDetailTopToolsComponent.kt", i = {0}, l = {232, 236}, m = "invokeSuspend", n = {"imageInfo"}, s = {"L$0"})
final class CreationDetailTopToolsComponent$prefetchToCreationBitmapCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ CreationDetailTopToolsComponent this$0;

    public CreationDetailTopToolsComponent$prefetchToCreationBitmapCache$1(CreationDetailTopToolsComponent r1, Continuation<? super CreationDetailTopToolsComponent$prefetchToCreationBitmapCache$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationDetailTopToolsComponent$prefetchToCreationBitmapCache$1(this.this$0, r3);
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
    L40:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ImageInfo r2 = (ImageInfo) this.L$0;
        ResultKt.throwOnFailure(r13);
    L29:
        DataSource r14 = (DataSource) r13;
    L30:
        CreationDetailTopToolsComponent r15 = this.this$0;
        if (r2 == null) goto L33;
        Image r3 = r2.i;
    L34:
        int r4 = CreationDetailTopToolsComponent.w;
        r15.getClass();
        String r5 = CreationDetailTopToolsComponent.E3(r3);
        if (r5 == null) goto L40;
        this.L$0 = null;
        this.label = 2;
        if (ImageLoaderKt.A(r5, "creation_share", null, null, null, this, 60) != r0) goto L40;
        return r0;
    L33:
        r3 = null;
        goto L34
    L10:
        ResultKt.throwOnFailure(r13);
        CreationDetailTopToolsComponent r16 = this.this$0;
        int r6 = CreationDetailTopToolsComponent.w;
        UserCreation r17 = r16.h3();
        if (r17 == null) goto L13;
        this.this$0.getClass();
        r2 = CreationDetailTopToolsComponent.C3(r17);
    L14:
        v1 r18 = z2.a.getCreationShareSettings().a();
        if (r18 != null) goto L17;
    L19:
        boolean r110 = false;
    L20:
        if (r110 == false) goto L30;
        if (r2 == null) goto L30;
        Image r111 = r2.d;
        if (r111 == null) goto L30;
        String r7 = r111.a;
        if (r7 == null) goto L30;
        this.L$0 = r2;
        this.label = 1;
        r13 = ImageLoaderKt.A(r7, "creation_share", null, null, null, this, 60);
        if (r13 != r0) goto L29;
        return r0;
    L17:
        if (r18.c() != true) goto L19;
        r110 = true;
        goto L20
    L13:
        r2 = null;
        goto L14
    }
}

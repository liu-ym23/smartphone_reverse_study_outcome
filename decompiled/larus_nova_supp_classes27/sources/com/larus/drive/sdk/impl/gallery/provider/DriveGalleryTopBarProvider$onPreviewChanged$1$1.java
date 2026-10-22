package com.larus.drive.sdk.impl.gallery.provider;

import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.impl.service.t;
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
@DebugMetadata(c = "com.larus.drive.sdk.impl.gallery.provider.DriveGalleryTopBarProvider$onPreviewChanged$1$1", f = "DriveGalleryTopBarProvider.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
final class DriveGalleryTopBarProvider$onPreviewChanged$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DriveFileItem $file;
    int label;

    public DriveGalleryTopBarProvider$onPreviewChanged$1$1(DriveFileItem r1, Continuation<? super DriveGalleryTopBarProvider$onPreviewChanged$1$1> r2) {
        this.$file = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DriveGalleryTopBarProvider$onPreviewChanged$1$1(this.$file, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        e89.c r6 = t.a();
        DriveFileItem r2 = this.$file;
        String r3 = r2.b;
        int r4 = r2.d;
        this.label = 1;
        if (r6.b(r3, r4, true, this) != r0) goto L12;
        return r0;
    }
}

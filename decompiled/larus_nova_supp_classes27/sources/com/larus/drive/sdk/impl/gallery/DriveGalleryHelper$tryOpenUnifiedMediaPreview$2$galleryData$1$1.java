package com.larus.drive.sdk.impl.gallery;

import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.impl.gallery.datasource.DriveDataSourceHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/drive/sdk/api/gallery/bean/DriveGalleryData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.gallery.DriveGalleryHelper$tryOpenUnifiedMediaPreview$2$galleryData$1$1", f = "DriveGalleryHelper.kt", i = {}, l = {243}, m = "invokeSuspend", n = {}, s = {})
public final class DriveGalleryHelper$tryOpenUnifiedMediaPreview$2$galleryData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super z79.c>, Object> {
    final /* synthetic */ DriveFileItem $file;
    int label;

    public DriveGalleryHelper$tryOpenUnifiedMediaPreview$2$galleryData$1$1(DriveFileItem r1, Continuation<? super DriveGalleryHelper$tryOpenUnifiedMediaPreview$2$galleryData$1$1> r2) {
        this.$file = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DriveGalleryHelper$tryOpenUnifiedMediaPreview$2$galleryData$1$1(this.$file, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super z79.c> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        List r5 = (List) r4;
        if (r5 != null) goto L15;
        r5 = CollectionsKt.emptyList();
    L15:
        return CollectionsKt.firstOrNull(r5);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        DriveDataSourceHelper r6 = DriveDataSourceHelper.a;
        DriveFileItem r2 = this.$file;
        this.label = 1;
        r4 = r6.b(r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}

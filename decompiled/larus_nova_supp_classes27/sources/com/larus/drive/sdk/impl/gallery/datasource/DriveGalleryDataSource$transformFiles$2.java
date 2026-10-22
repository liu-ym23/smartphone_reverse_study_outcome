package com.larus.drive.sdk.impl.gallery.datasource;

import com.larus.drive.sdk.api.file.DriveFileItem;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import z79.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/drive/sdk/api/gallery/bean/DriveGalleryData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.gallery.datasource.DriveGalleryDataSource$transformFiles$2", f = "DriveGalleryDataSource.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
final class DriveGalleryDataSource$transformFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends c>>, Object> {
    final /* synthetic */ List<DriveFileItem> $files;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DriveGalleryDataSource this$0;

    public DriveGalleryDataSource$transformFiles$2(List<DriveFileItem> r1, DriveGalleryDataSource r2, Continuation<? super DriveGalleryDataSource$transformFiles$2> r3) {
        this.$files = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DriveGalleryDataSource$transformFiles$2 r0 = new DriveGalleryDataSource$transformFiles$2(this.$files, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<c>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L16:
        return CollectionsKt.flatten((Iterable) r12);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        List<DriveFileItem> r2 = this.$files;
        DriveGalleryDataSource r9 = this.this$0;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        r10.add(BuildersKt.async$default(r13, null, null, new DriveGalleryDataSource$transformFiles$2$1$1(r9, (DriveFileItem) r3.next(), null), 3, null));
        goto L10
    L12:
        this.label = 1;
        r12 = AwaitKt.a(r10, this);
        if (r12 != r0) goto L16;
        return r0;
    }
}

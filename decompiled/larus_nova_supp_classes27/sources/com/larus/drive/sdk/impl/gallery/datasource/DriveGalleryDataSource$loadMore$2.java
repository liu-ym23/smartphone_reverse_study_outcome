package com.larus.drive.sdk.impl.gallery.datasource;

import com.larus.gallery.api.b0;
import java.util.ArrayList;
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
import kotlinx.coroutines.CoroutineScopeKt;
import z79.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/larus/gallery/api/LoadingState$Success;", "", "Lcom/larus/drive/sdk/api/gallery/bean/DriveGalleryData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.gallery.datasource.DriveGalleryDataSource$loadMore$2", f = "DriveGalleryDataSource.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
final class DriveGalleryDataSource$loadMore$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b0.b<List<? extends c>>>, Object> {
    int label;
    final /* synthetic */ DriveGalleryDataSource this$0;

    public DriveGalleryDataSource$loadMore$2(DriveGalleryDataSource r1, Continuation<? super DriveGalleryDataSource$loadMore$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DriveGalleryDataSource$loadMore$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super b0.b<List<c>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L16:
        return new b0.b(r6, !((ArrayList) this.this$0.g).isEmpty(), !((ArrayList) this.this$0.f).isEmpty());
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        DriveGalleryDataSource r7 = this.this$0;
        ArrayList r2 = (ArrayList) r7.g;
        int r8 = Math.min(((Number) r7.d.getValue()).intValue(), r2.size());
        if (r8 != 0) goto L11;
        List r9 = CollectionsKt.emptyList();
    L12:
        DriveGalleryDataSource r3 = this.this$0;
        this.label = 1;
        r3.getClass();
        r6 = CoroutineScopeKt.coroutineScope(new DriveGalleryDataSource$transformFiles$2(r9, r3, null), this);
        if (r6 != r0) goto L16;
        return r0;
    L11:
        List r4 = CollectionsKt.toList(r2.subList(0, r8));
        r2.subList(0, r8).clear();
        r9 = r4;
        goto L12
    }
}

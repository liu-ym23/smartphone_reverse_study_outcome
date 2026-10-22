package com.larus.avlink.gallery.thumbnail;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.thumbnail.GalleryThumbnailFragment$handleDeleteButtonClick$doraState$1", f = "GalleryThumbnailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GalleryThumbnailFragment$handleDeleteButtonClick$doraState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    int label;

    public GalleryThumbnailFragment$handleDeleteButtonClick$doraState$1(Continuation<? super GalleryThumbnailFragment$handleDeleteButtonClick$doraState$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new GalleryThumbnailFragment$handleDeleteButtonClick$doraState$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r2);
        IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r3 == null) goto L9;
        DeviceService r4 = r3.device();
        if (r4 == null) goto L9;
        return Boxing.boxInt(r4.u());
    L9:
        return null;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

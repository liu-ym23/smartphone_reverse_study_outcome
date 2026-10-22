package com.larus.avlink.gallery.thumbnail;

import com.larus.avlink.gallery.viewmodel.ThumbnailViewModel;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.MediaInfo;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.thumbnail.GalleryThumbnailFragment$initView$6", f = "GalleryThumbnailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GalleryThumbnailFragment$initView$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GalleryThumbnailFragment this$0;

    public GalleryThumbnailFragment$initView$6(GalleryThumbnailFragment r1, Continuation<? super GalleryThumbnailFragment$initView$6> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GalleryThumbnailFragment$initView$6(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L47;
        ResultKt.throwOnFailure(r4);
        ThumbnailViewModel r5 = this.this$0.e;
        boolean r0 = true;
        int r1 = 0;
        if (r5 != null) goto L7;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == true) goto L31;
        ThumbnailManager r7 = ThumbnailManager.a;
        MediaInfo r8 = (MediaInfo) CollectionsKt.firstOrNull(ThumbnailManager.e);
        if (ThumbnailManager.f == true) goto L29;
        if (r8 != null) goto L15;
    L28:
        r0 = false;
        goto L29
    L15:
        if (r8.getThumbnailTypes() == null) goto L25;
        Byte[] r9 = r8.getThumbnailTypes();
        if (r9 != null) goto L19;
    L21:
        boolean r10 = false;
    L22:
        if (r10 == true) goto L25;
        boolean r11 = false;
    L26:
        if (r11 == false) goto L28;
    L19:
        if (r9.length != 0) goto L21;
        r10 = true;
    L25:
        r11 = true;
    L29:
        if (r0 == false) goto L31;
        this.this$0.X90();
    L45:
        return Unit.INSTANCE;
    L31:
        IDoraService r12 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r12 == null) goto L36;
        VisionService r13 = r12.V();
        if (r13 == null) goto L36;
        Pair r14 = r13.l();
    L37:
        GalleryThumbnailFragment r2 = this.this$0;
        if (r14 == null) goto L40;
        int r3 = ((Number) r14.getFirst()).intValue();
    L41:
        if (r14 == null) goto L43;
        r1 = ((Number) r14.getSecond()).intValue();
    L43:
        r2.ba0(r3, r1);
        goto L45
    L40:
        r3 = 0;
    L36:
        r14 = null;
        goto L37
    L7:
        if (r5.disableGainThumbnail() == true) goto L9;
        r6 = true;
        goto L10
    L47:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

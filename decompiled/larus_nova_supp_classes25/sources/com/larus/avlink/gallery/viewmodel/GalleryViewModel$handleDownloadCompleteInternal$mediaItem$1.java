package com.larus.avlink.gallery.viewmodel;

import com.larus.avlink.gallery.i;
import com.larus.bmhome.bigimg.t1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.model.GeoLocationInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/bigimg/MediaItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel$handleDownloadCompleteInternal$mediaItem$1", f = "GalleryViewModel.kt", i = {}, l = {790}, m = "invokeSuspend", n = {}, s = {})
public final class GalleryViewModel$handleDownloadCompleteInternal$mediaItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super t1>, Object> {
    final /* synthetic */ File $file;
    final /* synthetic */ GeoLocationInfo $geoLocationInfo;
    final /* synthetic */ String $mediaId;
    int label;
    final /* synthetic */ GalleryViewModel this$0;

    public GalleryViewModel$handleDownloadCompleteInternal$mediaItem$1(File r1, String r2, GalleryViewModel r3, GeoLocationInfo r4, Continuation<? super GalleryViewModel$handleDownloadCompleteInternal$mediaItem$1> r5) {
        this.$file = r1;
        this.$mediaId = r2;
        this.this$0 = r3;
        this.$geoLocationInfo = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new GalleryViewModel$handleDownloadCompleteInternal$mediaItem$1(this.$file, this.$mediaId, this.this$0, this.$geoLocationInfo, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super t1> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L15:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        int r7 = i.a;
        File r8 = this.$file;
        String r2 = this.$mediaId;
        Boolean r3 = (Boolean) GalleryViewModel.access$get_isSelectMode$p(this.this$0).getValue();
        if (r3 == null) goto L11;
        boolean r4 = r3.booleanValue();
    L12:
        GeoLocationInfo r5 = this.$geoLocationInfo;
        this.label = 1;
        r6 = i.a(r8, r2, r4, r5);
        if (r6 != r0) goto L15;
        return r0;
    L11:
        r4 = false;
        goto L12
    }
}

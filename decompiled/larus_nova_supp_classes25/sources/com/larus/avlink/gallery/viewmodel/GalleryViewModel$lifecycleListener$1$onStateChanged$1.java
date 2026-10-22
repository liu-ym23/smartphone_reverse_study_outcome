package com.larus.avlink.gallery.viewmodel;

import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.utils.logger.FLogger;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel$lifecycleListener$1$onStateChanged$1", f = "GalleryViewModel.kt", i = {}, l = {711}, m = "invokeSuspend", n = {}, s = {})
public final class GalleryViewModel$lifecycleListener$1$onStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $mediaId;
    final /* synthetic */ MediaMetadata $metadata;
    final /* synthetic */ MediaLifecycleState $newState;
    int label;
    final /* synthetic */ GalleryViewModel this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaLifecycleState.values().length];
            r0[MediaLifecycleState.DOWNLOADED_TEMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MediaLifecycleState.PROCESSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MediaLifecycleState.COMPLETED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public GalleryViewModel$lifecycleListener$1$onStateChanged$1(MediaLifecycleState r1, String r2, GalleryViewModel r3, MediaMetadata r4, Continuation<? super GalleryViewModel$lifecycleListener$1$onStateChanged$1> r5) {
        this.$newState = r1;
        this.$mediaId = r2;
        this.this$0 = r3;
        this.$metadata = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new GalleryViewModel$lifecycleListener$1$onStateChanged$1(this.$newState, this.$mediaId, this.this$0, this.$metadata, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        int r7 = a.a[this.$newState.ordinal()];
        if (r7 != 1) goto L11;
        FLogger.a.i(GalleryViewModel.TAG, "Download completed for media: " + this.$mediaId);
        GalleryViewModel r8 = this.this$0;
        String r2 = this.$mediaId;
        String r3 = this.$metadata.getFilePath();
        GeoLocationInfo r4 = this.$metadata.getGeoLocationInfo();
        this.label = 1;
        if (GalleryViewModel.access$handleDownloadCompleteInternal(r8, r2, r3, r4, this) != r0) goto L21;
        return r0;
    L11:
        if (r7 != 2) goto L13;
        FLogger.a.i(GalleryViewModel.TAG, "Processing completed for media: " + this.$mediaId + ", waiting for sync to complete");
        goto L21
    L13:
        if (r7 == 3) goto L15;
        FLogger.a.d(GalleryViewModel.TAG, "State " + this.$newState + " for media: " + this.$mediaId);
        goto L21
    L15:
        FLogger.a.i(GalleryViewModel.TAG, "Media fully completed: " + this.$mediaId + ", adding/updating UI");
        GalleryViewModel.access$handleMediaCompleteInternal(this.this$0, this.$mediaId, this.$metadata);
        goto L21
    }
}

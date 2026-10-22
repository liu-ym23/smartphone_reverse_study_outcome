package com.larus.avlink.gallery.view;

import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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
@DebugMetadata(c = "com.larus.avlink.gallery.view.MediaAlbumViewHelper$2$onStateChanged$1", f = "MediaAlbumViewHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MediaAlbumViewHelper$2$onStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $mediaId;
    final /* synthetic */ MediaMetadata $metadata;
    final /* synthetic */ MediaLifecycleState $newState;
    int label;
    final /* synthetic */ MediaAlbumViewHelper this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaLifecycleState.values().length];
            r0[MediaLifecycleState.DOWNLOADED_TEMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MediaLifecycleState.PROCESSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MediaLifecycleState.COMPLETED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public MediaAlbumViewHelper$2$onStateChanged$1(MediaLifecycleState r1, MediaAlbumViewHelper r2, String r3, MediaMetadata r4, Continuation<? super MediaAlbumViewHelper$2$onStateChanged$1> r5) {
        this.$newState = r1;
        this.this$0 = r2;
        this.$mediaId = r3;
        this.$metadata = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MediaAlbumViewHelper$2$onStateChanged$1(this.$newState, this.this$0, this.$mediaId, this.$metadata, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r3);
        int r4 = a.a[this.$newState.ordinal()];
        if (r4 != 1) goto L7;
        MediaAlbumViewHelper r5 = this.this$0;
        int r0 = MediaAlbumViewHelper.r;
        r5.c();
        MediaAlbumViewHelper.b(this.this$0, this.$mediaId, this.$metadata);
    L21:
        return Unit.INSTANCE;
    L7:
        if (r4 != 2) goto L9;
        MediaAlbumViewHelper.b(this.this$0, this.$mediaId, this.$metadata);
        goto L21
    L9:
        if (r4 != 3) goto L11;
        AlbumSyncBanner r6 = this.this$0.f;
        if (r6 == null) goto L17;
        r6.T5(z98.a.c.b);
    L17:
        this.this$0.c();
        MediaAlbumViewHelper.b(this.this$0, this.$mediaId, this.$metadata);
        goto L21
    L11:
        if (r4 == 4) goto L13;
        FLogger.a.d("MediaAlbumViewHelper", "State " + this.$newState + " for media: " + this.$mediaId);
        goto L21
    L13:
        MediaAlbumViewHelper.b(this.this$0, this.$mediaId, this.$metadata);
        goto L21
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

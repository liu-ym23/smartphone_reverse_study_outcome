package com.larus.avlink.gallery.executor;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.business.MediaLifecycleStateManager;
import com.larus.avlink.gallery.j;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.model.MediaInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaDownloadExecutor$saveMediaFile$2$task$3$onSuccessed$1", f = "MediaDownloadExecutor.kt", i = {}, l = {476}, m = "invokeSuspend", n = {}, s = {})
public final class MediaDownloadExecutor$saveMediaFile$2$task$3$onSuccessed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $currentSn;
    final /* synthetic */ String $filePath;
    final /* synthetic */ String $id;
    final /* synthetic */ long $mediaId;
    final /* synthetic */ MediaInfo $mediaInfo;
    final /* synthetic */ long $mediaSize;
    final /* synthetic */ String $mediaType;
    final /* synthetic */ long $startTime;
    int label;
    final /* synthetic */ MediaDownloadExecutor this$0;

    public static final class a implements Function1<MediaMetadata, MediaMetadata> {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final Object invoke(Object r33) {
            MediaMetadata r1 = (MediaMetadata) r33;
            Intrinsics.checkNotNullParameter(r1, "it");
            String r6 = new PolarisFileWrapper(this.a).getName();
            String r2 = this.a;
            return MediaMetadata.copy$default(r1, null, 0, null, r6, null, null, 0, 0, 0, 0, 0, 0.0d, 0, null, null, null, null, null, r2, r2, null, null, null, 0, 15990775, null);
        }
    }

    public MediaDownloadExecutor$saveMediaFile$2$task$3$onSuccessed$1(MediaInfo r1, long r2, String r4, String r5, MediaDownloadExecutor r6, long r7, String r9, long r10, String r12, Continuation<? super MediaDownloadExecutor$saveMediaFile$2$task$3$onSuccessed$1> r13) {
        this.$mediaInfo = r1;
        this.$mediaId = r2;
        this.$filePath = r4;
        this.$id = r5;
        this.this$0 = r6;
        this.$mediaSize = r7;
        this.$mediaType = r9;
        this.$startTime = r10;
        this.$currentSn = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r17, Continuation<?> r18) {
        return new MediaDownloadExecutor$saveMediaFile$2$task$3$onSuccessed$1(this.$mediaInfo, this.$mediaId, this.$filePath, this.$id, this.this$0, this.$mediaSize, this.$mediaType, this.$startTime, this.$currentSn, r18);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L18:
        MediaProcessingExecutor r13 = this.this$0.b;
        String r2 = this.$id;
        int r3 = MediaProcessingExecutor.k;
        r13.a(r2, false);
        Long r14 = this.$mediaInfo.getMediaId();
        if (r14 == null) goto L22;
        String r15 = r14.toString();
        if (r15 == null) goto L22;
    L23:
        MediaDownloadExecutor r4 = this.this$0;
        long r5 = this.$mediaSize;
        String r6 = this.$mediaType;
        long r7 = System.currentTimeMillis() - this.$startTime;
        r4.i(0, r5, r6, r7, 0, r15, this.$currentSn);
        return Unit.INSTANCE;
    L22:
        r15 = this.$id;
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        int r16 = j.a;
        if (Intrinsics.areEqual(j.d(this.$mediaInfo.getMediaType()), "video_mp4") == false) goto L15;
        StringBuilder r17 = new StringBuilder("src_");
        Long r8 = this.$mediaInfo.getMediaId();
        if (r8 == null) goto L13;
        long r9 = r8.longValue();
    L14:
        r17.append(r9);
        r17.append('_');
        r17.append(new PolarisFileWrapper(this.$filePath).getName());
        String r18 = r17.toString();
        int r10 = j0.a;
        a.d(this.$filePath, r18, this.$id);
        goto L15
    L13:
        r9 = this.$mediaId;
    L15:
        MediaLifecycleStateManager r11 = this.this$0.c;
        String r19 = this.$id;
        MediaLifecycleState r20 = MediaLifecycleState.DOWNLOADED_TEMP;
        a r21 = new a(this.$filePath);
        this.label = 1;
        if (MediaLifecycleStateManager.g(r11, r19, r20, r21, this, 8) != r0) goto L18;
        return r0;
    }
}

package com.larus.avlink.gallery.processor;

import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.power.monitor.AlbumVideoThermalRecorder;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/avlink/gallery/processor/ProcessResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.processor.VideoPackProcessor$processSync$2", f = "VideoPackProcessor.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
public final class VideoPackProcessor$processSync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super k>, Object> {
    final /* synthetic */ String $filePath;
    final /* synthetic */ MediaMetadata $metadata;
    int label;
    final /* synthetic */ VideoPackProcessor this$0;

    /* JADX INFO: renamed from: com.larus.avlink.gallery.processor.VideoPackProcessor$processSync$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/avlink/gallery/processor/ProcessResult;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.processor.VideoPackProcessor$processSync$2$1", f = "VideoPackProcessor.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super k>, Object> {
        final /* synthetic */ String $filePath;
        final /* synthetic */ MediaMetadata $metadata;
        int label;
        final /* synthetic */ VideoPackProcessor this$0;

        public AnonymousClass1(VideoPackProcessor r1, String r2, MediaMetadata r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$filePath = r2;
            this.$metadata = r3;
            super(1, r4);
        }

        public final Continuation<Unit> create(Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$filePath, this.$metadata, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super k> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            VideoPackProcessor r6 = this.this$0;
            String r2 = this.$filePath;
            MediaMetadata r3 = this.$metadata;
            this.label = 1;
            s98.c r4 = VideoPackProcessor.a;
            r5 = r6.c(r2, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public VideoPackProcessor$processSync$2(VideoPackProcessor r1, String r2, MediaMetadata r3, Continuation<? super VideoPackProcessor$processSync$2> r4) {
        this.this$0 = r1;
        this.$filePath = r2;
        this.$metadata = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new VideoPackProcessor$processSync$2(this.this$0, this.$filePath, this.$metadata, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super k> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        AlbumVideoThermalRecorder r9 = new AlbumVideoThermalRecorder(null);
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, this.$filePath, this.$metadata, null);
        this.label = 1;
        r8 = r9.d(r3, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}

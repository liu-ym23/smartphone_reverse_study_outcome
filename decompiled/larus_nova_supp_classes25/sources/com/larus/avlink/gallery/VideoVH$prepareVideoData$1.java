package com.larus.avlink.gallery;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.dora.VideoThumbnailHelper;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.VideoVH$prepareVideoData$1", f = "VideoVH.kt", i = {0, 0, 0, 1, 1}, l = {DoraCallStateCode.ENV_OBSERVE_AUTO_TIMER_ENTER_PAUSE, 207, 214, 233}, m = "invokeSuspend", n = {"$this$launch", "videoPath", "displaySize", "$this$launch", "displaySize"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
final class VideoVH$prepareVideoData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n1 $mediaInfo;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ VideoVH this$0;

    /* JADX INFO: renamed from: com.larus.avlink.gallery.VideoVH$prepareVideoData$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.VideoVH$prepareVideoData$1$1", f = "VideoVH.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ VideoVH.c $displaySize;
        final /* synthetic */ n1 $mediaInfo;
        final /* synthetic */ String $thumbnailPath;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ VideoVH this$0;

        public AnonymousClass1(VideoVH r1, n1 r2, VideoVH.c r3, String r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$mediaInfo = r2;
            this.$displaySize = r3;
            this.$thumbnailPath = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass1 r6 = new AnonymousClass1(this.this$0, this.$mediaInfo, this.$displaySize, this.$thumbnailPath, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L25;
            ResultKt.throwOnFailure(r4);
            if (CoroutineScopeKt.isActive((CoroutineScope) this.L$0) == false) goto L7;
            n1 r5 = this.this$0.r;
            if (r5 == null) goto L11;
            String r6 = r5.c;
        L13:
            if (Intrinsics.areEqual(r6, this.$mediaInfo.c) == true) goto L16;
            FLogger.a.i("VideoVH", "Skip stale prepared data callback for position=" + this.this$0.getBindingAdapterPosition());
            return Unit.INSTANCE;
        L16:
            VideoVH r7 = this.this$0;
            n1 r0 = this.$mediaInfo;
            VideoVH.c r1 = r7.t;
            if (r1 != null) goto L19;
            r1 = this.$displaySize;
        L19:
            VideoVH.a4(r7, r0, r1, this.$thumbnailPath);
            VideoVH r8 = this.this$0;
            if (r8.k == VideoVH.PlayState.PLAYING) goto L23;
            r8.b4();
        L23:
            return Unit.INSTANCE;
        L11:
            r6 = null;
            goto L13
        L7:
            return Unit.INSTANCE;
        L25:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.VideoVH$prepareVideoData$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.VideoVH$prepareVideoData$1$2", f = "VideoVH.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ VideoVH this$0;

        public AnonymousClass2(VideoVH r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            VideoVH r3 = this.this$0;
            int r0 = VideoVH.y;
            r3.b4();
            VideoVH r4 = this.this$0;
            r4.k = VideoVH.PlayState.DATA_READY;
            r4.d4();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public VideoVH$prepareVideoData$1(n1 r1, VideoVH r2, Continuation<? super VideoVH$prepareVideoData$1> r3) {
        this.$mediaInfo = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        VideoVH$prepareVideoData$1 r0 = new VideoVH$prepareVideoData$1(this.$mediaInfo, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r6 = true;
        if (r0 == 0) goto L19;
        if (r0 == 1) goto L16;
        if (r0 == 2) goto L13;
        if (r0 == 3) goto L11;
        if (r0 != 4) goto L10;
        ResultKt.throwOnFailure(r16);
    L77:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L67
        goto L77
    L13:
        VideoVH.c r1 = (VideoVH.c) this.L$1;
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L67
        VideoVH.c r11 = r1;
        CoroutineScope r9 = r5;
        Object r7 = r16;
    L53:
        String r12 = (String) r7;     // Catch: Exception -> L67
        if (CoroutineScopeKt.isActive(r9) == false) goto L66;
        if (r12 != null) goto L57;
    L60:
        if (r6 == true) goto L66;
        MainCoroutineDispatcher r3 = Dispatchers.getMain();     // Catch: Exception -> L67
        AnonymousClass1 r8 = new AnonymousClass1(this.this$0, this.$mediaInfo, r11, r12, null);     // Catch: Exception -> L67
        this.L$0 = null;     // Catch: Exception -> L67
        this.L$1 = null;     // Catch: Exception -> L67
        this.label = 3;     // Catch: Exception -> L67
        if (BuildersKt.withContext(r3, r8, this) != r2) goto L77;
        return r2;
    L57:
        if (StringsKt.isBlank(r12) == true) goto L60;
        r6 = false;
    L66:
        return Unit.INSTANCE;
    L16:
        VideoVH.c r4 = (VideoVH.c) this.L$2;
        String r10 = (String) this.L$1;
        r9 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L67
        Object r13 = r16;
    L45:
        if (((Boolean) r13).booleanValue() == false) goto L70;
        if (CoroutineScopeKt.isActive(r9) == false) goto L70;
        int r14 = VideoThumbnailHelper.a;     // Catch: Exception -> L67
        Context r15 = ((RecyclerView.ViewHolder) this.this$0).itemView.getContext();     // Catch: Exception -> L67
        this.L$0 = r9;     // Catch: Exception -> L67
        this.L$1 = r4;     // Catch: Exception -> L67
        this.L$2 = null;     // Catch: Exception -> L67
        this.label = 2;     // Catch: Exception -> L67
        r7 = VideoThumbnailHelper.b(r15, r10, this);     // Catch: Exception -> L67
        if (r7 != r2) goto L52;
        return r2;
    L52:
        r11 = r4;
    L70:
        return Unit.INSTANCE;
    L19:
        ResultKt.throwOnFailure(r16);
        CoroutineScope r17 = (CoroutineScope) this.L$0;
        n1 r18 = this.$mediaInfo;     // Catch: Exception -> L67
        yt8.p r19 = r18.b;     // Catch: Exception -> L67
        if ((r19 instanceof yt8.p) == false) goto L23;
        yt8.p r20 = r19;     // Catch: Exception -> L67
    L24:
        String r21 = r18.c;     // Catch: Exception -> L67
        if (r21 == null) goto L28;
        r10 = StringsKt.removePrefix(r21, "file://");     // Catch: Exception -> L67
        if (r10 == null) goto L28;
    L29:
        VideoVH r110 = this.this$0;     // Catch: Exception -> L67
        if (r20 == null) goto L32;
        Integer r111 = Boxing.boxInt(r20.l);     // Catch: Exception -> L67
    L33:
        if (r20 == null) goto L35;
        Integer r22 = Boxing.boxInt(r20.m);     // Catch: Exception -> L67
    L36:
        VideoVH.c r23 = VideoVH.Z3(r110, r10, r111, r22);     // Catch: Exception -> L67
        if (CoroutineScopeKt.isActive(r17) == false) goto L39;
        MainCoroutineDispatcher r112 = Dispatchers.getMain();     // Catch: Exception -> L67
        VideoVH$prepareVideoData$1$prepared$1 r113 = new VideoVH$prepareVideoData$1$prepared$1(this.this$0, this.$mediaInfo, r23, null);     // Catch: Exception -> L67
        this.L$0 = r17;     // Catch: Exception -> L67
        this.L$1 = r10;     // Catch: Exception -> L67
        this.L$2 = r23;     // Catch: Exception -> L67
        this.label = 1;     // Catch: Exception -> L67
        r13 = BuildersKt.withContext(r112, r113, this);     // Catch: Exception -> L67
        if (r13 != r2) goto L43;
        return r2;
    L43:
        r9 = r17;
        r4 = r23;
        goto L45
    L39:
        return Unit.INSTANCE;
    L35:
        r22 = null;
        goto L36
    L32:
        r111 = null;
    L28:
        r10 = "";
        goto L29
    L23:
        r20 = null;
    L67:
        e = move-exception;
        if ((e instanceof CancellationException) == true) goto L78;
        FLogger.a.e("VideoVH", "Error preparing video data: " + e.getMessage());
        MainCoroutineDispatcher r24 = Dispatchers.getMain();
        AnonymousClass2 r25 = new AnonymousClass2(this.this$0, null);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 4;
        if (BuildersKt.withContext(r24, r25, this) != r2) goto L77;
        return r2;
    L78:
        throw e;
    }
}

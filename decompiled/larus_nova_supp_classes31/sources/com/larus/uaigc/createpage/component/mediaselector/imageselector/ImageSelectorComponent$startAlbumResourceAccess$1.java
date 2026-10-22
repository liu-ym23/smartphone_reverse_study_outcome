package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.net.Uri;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$startAlbumResourceAccess$1", f = "ImageSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ImageSelectorComponent$startAlbumResourceAccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromInit;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$startAlbumResourceAccess$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$startAlbumResourceAccess$1$2", f = "ImageSelectorComponent.kt", i = {}, l = {1801}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $fastPreviewJob;
        final /* synthetic */ Ref.BooleanRef $preprocessPreviewShown;
        final /* synthetic */ Ref.BooleanRef $refImageSelectedNotified;
        final /* synthetic */ String $sourceLocalPath;
        final /* synthetic */ Uri $uri;
        int label;
        final /* synthetic */ ImageSelectorComponent this$0;

        public AnonymousClass2(ImageSelectorComponent r1, String r2, Uri r3, Job r4, Ref.BooleanRef r5, Ref.BooleanRef r6, Continuation<? super AnonymousClass2> r7) {
            this.this$0 = r1;
            this.$sourceLocalPath = r2;
            this.$uri = r3;
            this.$fastPreviewJob = r4;
            this.$refImageSelectedNotified = r5;
            this.$preprocessPreviewShown = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new AnonymousClass2(this.this$0, this.$sourceLocalPath, this.$uri, this.$fastPreviewJob, this.$refImageSelectedNotified, this.$preprocessPreviewShown, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.uaigc.createpage.component.mediaselector.imageselector.c1] */
        public final Object invokeSuspend(Object r20) {
            Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            ResultKt.throwOnFailure(r20);
        L21:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r20);
            ImageSelectorComponent r1 = this.this$0;
            Lazy<Long> r2 = ImageSelectorComponent.X;
            r1.getClass();
            r1.V = new c0(r1);
            r1.W = new d0(r1);
            ny9.s r3 = this.this$0.G3();
            if (r3 != null) goto L11;
        L13:
            boolean r4 = false;
        L14:
            if (r4 == false) goto L16;
            String r5 = "ai_beautify";
        L17:
            String r6 = r5;
            final ImageSelectorComponent r7 = this.this$0;
            final String r8 = this.$sourceLocalPath;
            final Job r15 = this.$fastPreviewJob;
            final Ref.BooleanRef r9 = this.$refImageSelectedNotified;
            Function1 r10 = new a1(r15, r7, r9);
            Function1 r11 = new b1(r15, r7, r8, r9);
            Uri r13 = this.$uri;
            final Ref.BooleanRef r14 = this.$preprocessPreviewShown;
            ?? r16 = new c1(r14, r15, r7, r8, r9);
            this.label = 1;
            if (ImageSelectorComponent.o5(r7, r8, r10, r11, null, r13, r6, null, r16, this, 200) != r12) goto L21;
            return r12;
        L16:
            r5 = "video_gen";
            goto L17
        L11:
            if (r3.B() != true) goto L13;
            r4 = true;
            goto L14
        }
    }

    public ImageSelectorComponent$startAlbumResourceAccess$1(Uri r1, ImageSelectorComponent r2, boolean r3, Continuation<? super ImageSelectorComponent$startAlbumResourceAccess$1> r4) {
        this.$uri = r1;
        this.this$0 = r2;
        this.$fromInit = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ImageSelectorComponent$startAlbumResourceAccess$1(this.$uri, this.this$0, this.$fromInit, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r20);
        String r4 = this.$uri.toString();
        final Ref.BooleanRef r7 = new Ref.BooleanRef();
        final ImageSelectorComponent r9 = this.this$0;
        Uri r10 = this.$uri;
        boolean r11 = this.$fromInit;
        Function0 r12 = new z0(r7, r9);
        Lazy<Long> r1 = ImageSelectorComponent.X;
        r9.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9), null, null, new ImageSelectorComponent$startAlbumUploadingUiForPipeline$1(r9, null), 3, null);
        r9.X3().setEnableShowReselectIcon(false);
        Job r6 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9), null, null, new ImageSelectorComponent$startAlbumUploadingUiForPipeline$2(r9, r10, r11, r12, null), 3, null);
        Ref.BooleanRef r8 = new Ref.BooleanRef();
        ImageSelectorComponent r2 = this.this$0;
        r2.E = UUID.randomUUID().toString();
        String r3 = this.this$0.E;
        if (r3 == null) goto L7;
        tx9.l0.d(r3);
    L8:
        ImageSelectorComponent r5 = this.this$0;
        r5.C = r4;
        r5.D = null;
        r5.F = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r5), Dispatchers.getMain(), null, new AnonymousClass2(this.this$0, r4, this.$uri, r6, r7, r8, null), 2, null);
        return Unit.INSTANCE;
    L7:
        FLogger.a.i("ImageSelectorComponent", "curUploadTaskId is null before recordUploadStartTime");
        goto L8
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static final void access$invokeSuspend$notifyRefImageSelected(Ref.BooleanRef r1, ImageSelectorComponent r2) {
        if (r1.element == true) goto L10;
        r1.element = true;
        Lazy<Long> r3 = ImageSelectorComponent.X;
        uy9.a r4 = r2.e4();
        if (r4 == null) goto L9;
        r4.aL();
        return;
    L9:
        return;
    }
}

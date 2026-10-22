package com.larus.chat.gallery.impl.preview.provider;

import android.graphics.Bitmap;
import androidx.fragment.app.FragmentActivity;
import com.larus.camera.api.IFlowCamera;
import com.larus.chat.gallery.impl.preview.OriginalImagePreloader;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.provider.PreviewBottomProvider$launchMarkPageWithAlbumResult$1", f = "PreviewBottomProvider.kt", i = {0, 1}, l = {977, 986}, m = "invokeSuspend", n = {"loadingJob", "loadingJob"}, s = {"L$0", "L$0"})
public final class PreviewBottomProvider$launchMarkPageWithAlbumResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ xp9.i $albumResult;
    final /* synthetic */ IFlowCamera $camera;
    final /* synthetic */ String $currentImagePath;
    final /* synthetic */ xy8.d $data;
    final /* synthetic */ String $rawImagePath;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PreviewBottomProvider this$0;

    /* JADX INFO: renamed from: com.larus.chat.gallery.impl.preview.provider.PreviewBottomProvider$launchMarkPageWithAlbumResult$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.chat.gallery.impl.preview.provider.PreviewBottomProvider$launchMarkPageWithAlbumResult$1$1", f = "PreviewBottomProvider.kt", i = {}, l = {969}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FragmentActivity $activity;
        int label;
        final /* synthetic */ PreviewBottomProvider this$0;

        public AnonymousClass1(PreviewBottomProvider r1, FragmentActivity r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$activity = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$activity, r4);
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
        L11:
            this.this$0.q = true;
            t19.s r7 = t19.s.a;
            FragmentActivity r2 = this.$activity;
            OriginalImagePreloader r3 = OriginalImagePreloader.a;
            String r4 = r2.getString(2131899436);
            r7.getClass();
            t19.s.e(r2, r4, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            this.label = 1;
            if (DelayKt.delay(500, this) != r0) goto L11;
            return r0;
        }
    }

    public PreviewBottomProvider$launchMarkPageWithAlbumResult$1(String r1, PreviewBottomProvider r2, FragmentActivity r3, IFlowCamera r4, xy8.d r5, String r6, xp9.i r7, Continuation<? super PreviewBottomProvider$launchMarkPageWithAlbumResult$1> r8) {
        this.$rawImagePath = r1;
        this.this$0 = r2;
        this.$activity = r3;
        this.$camera = r4;
        this.$data = r5;
        this.$currentImagePath = r6;
        this.$albumResult = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        PreviewBottomProvider$launchMarkPageWithAlbumResult$1 r9 = new PreviewBottomProvider$launchMarkPageWithAlbumResult$1(this.$rawImagePath, this.this$0, this.$activity, this.$camera, this.$data, this.$currentImagePath, this.$albumResult, r12);
        r9.L$0 = r11;
        return r9;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    public final Object invokeSuspend(Object r17) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r3 = this.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L13;
        if (r3 != 2) goto L12;
        Job r4 = (Job) this.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L9
        Object r5 = r17;
        r4 = r4;
    L43:
        Bitmap r14 = (Bitmap) r5;     // Catch: Throwable -> L9
        FLogger r6 = FLogger.a;     // Catch: Throwable -> L9
        StringBuilder r7 = new StringBuilder("launchMarkPageWithAlbumResult: prefetch currentImage result=");     // Catch: Throwable -> L9
        if (r14 == null) goto L46;
        boolean r0 = true;
    L47:
        r7.append(r0);     // Catch: Throwable -> L9
        r6.i("PreviewBottomProvider", r7.toString());     // Catch: Throwable -> L9
        PreviewBottomProvider r9 = this.this$0;     // Catch: Throwable -> L9
        FragmentActivity r10 = this.$activity;     // Catch: Throwable -> L9
        IFlowCamera r11 = this.$camera;     // Catch: Throwable -> L9
        xy8.d r12 = this.$data;     // Catch: Throwable -> L9
        String r13 = this.$currentImagePath;     // Catch: Throwable -> L9
        xp9.i r15 = this.$albumResult;     // Catch: Throwable -> L9
        int r1 = PreviewBottomProvider.x;     // Catch: Throwable -> L9
        r9.y(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L9
        if (r4 == 0) goto L50;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L50:
        this.this$0.B();
        this.this$0.p = false;
        return Unit.INSTANCE;
    L46:
        r0 = false;
    L9:
        th = th;
    L55:
        if (r4 == 0) goto L57;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L57:
        PreviewBottomProvider r8 = this.this$0;
        int r16 = PreviewBottomProvider.x;
        r8.B();
        this.this$0.p = false;
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        Job r18 = (Job) this.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L16
        Object r19 = r17;
    L31:
        boolean r20 = ((Boolean) r19).booleanValue();     // Catch: Throwable -> L16
        Job.DefaultImpls.cancel$default(r18, null, 1, null);     // Catch: Throwable -> L16
        PreviewBottomProvider r110 = this.this$0;     // Catch: Throwable -> L16
        int r111 = PreviewBottomProvider.x;     // Catch: Throwable -> L16
        r110.B();     // Catch: Throwable -> L16
        if (r20 == true) goto L39;
        FLogger.a.e("PreviewBottomProvider", "launchMarkPageWithAlbumResult: raw image load failed or timeout");     // Catch: Throwable -> L16
        t19.s r21 = t19.s.a;     // Catch: Throwable -> L16
        FragmentActivity r22 = this.$activity;     // Catch: Throwable -> L16
        OriginalImagePreloader r23 = OriginalImagePreloader.a;     // Catch: Throwable -> L16
        r21.getClass();     // Catch: Throwable -> L16
        t19.s.b(r22, 2131899435, false);     // Catch: Throwable -> L16
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L16
        if (r18 == null) goto L36;
        Job.DefaultImpls.cancel$default(r18, null, 1, null);
    L36:
        this.this$0.B();
        this.this$0.p = false;
        return r24;
    L39:
        CoroutineDispatcher r25 = Dispatchers.getIO();     // Catch: Throwable -> L16
        PreviewBottomProvider$launchMarkPageWithAlbumResult$1$bitmap$1 r112 = new PreviewBottomProvider$launchMarkPageWithAlbumResult$1$bitmap$1(this.$currentImagePath, null);     // Catch: Throwable -> L16
        this.L$0 = r18;     // Catch: Throwable -> L16
        this.label = 2;     // Catch: Throwable -> L16
        r5 = BuildersKt.withContext(r25, r112, this);     // Catch: Throwable -> L16
        if (r5 != r2) goto L42;
        return r2;
    L42:
        r4 = r18;
        goto L43
    L18:
        ResultKt.throwOnFailure(r17);
        CoroutineScope r26 = (CoroutineScope) this.L$0;
        String r27 = this.$rawImagePath;     // Catch: Throwable -> L53
        if (r27 != null) goto L22;
    L25:
        boolean r28 = true;
    L26:
        if (r28 == true) goto L38;
        r18 = BuildersKt.launch$default(r26, null, null, new AnonymousClass1(this.this$0, this.$activity, null), 3, null);     // Catch: Throwable -> L53
        OriginalImagePreloader r29 = OriginalImagePreloader.a;     // Catch: Throwable -> L16
        String r113 = this.$rawImagePath;     // Catch: Throwable -> L16
        this.L$0 = r18;     // Catch: Throwable -> L16
        this.label = 1;     // Catch: Throwable -> L16
        r19 = r29.b(r113, "PreviewBottomProvider#raw", this);     // Catch: Throwable -> L16
        if (r19 != r2) goto L31;
        return r2;
    L38:
        r18 = null;
        goto L39
    L22:
        if (r27.length() == 0) goto L25;
        r28 = false;
    L53:
        th = th;
        r4 = 0;
    L16:
        th = th;
        r4 = r3;
        goto L55
    }
}

package com.larus.dora.obric.device_management.setting.g.feedback;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.feedback.DoraObricGFeedbackFragment$ObricFeedbackImageAdapter$bindPreview$2", f = "DoraObricGFeedbackFragment.kt", i = {0}, l = {1367}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class DoraObricGFeedbackFragment$ObricFeedbackImageAdapter$bindPreview$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ DoraObricGFeedbackFragment.b.C0106b $holder;
    final /* synthetic */ boolean $isVideo;
    final /* synthetic */ Ref.ObjectRef<Job> $newPreviewJob;
    final /* synthetic */ String $previewKey;
    final /* synthetic */ int $targetSize;
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DoraObricGFeedbackFragment this$0;
    final /* synthetic */ DoraObricGFeedbackFragment.b this$1;

    public DoraObricGFeedbackFragment$ObricFeedbackImageAdapter$bindPreview$2(Uri r1, DoraObricGFeedbackFragment.b.C0106b r2, Ref.ObjectRef<Job> r3, DoraObricGFeedbackFragment r4, String r5, DoraObricGFeedbackFragment.b r6, boolean r7, Context r8, int r9, Continuation<? super DoraObricGFeedbackFragment$ObricFeedbackImageAdapter$bindPreview$2> r10) {
        this.$uri = r1;
        this.$holder = r2;
        this.$newPreviewJob = r3;
        this.this$0 = r4;
        this.$previewKey = r5;
        this.this$1 = r6;
        this.$isVideo = r7;
        this.$appContext = r8;
        this.$targetSize = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        DoraObricGFeedbackFragment$ObricFeedbackImageAdapter$bindPreview$2 r11 = new DoraObricGFeedbackFragment$ObricFeedbackImageAdapter$bindPreview$2(this.$uri, this.$holder, this.$newPreviewJob, this.this$0, this.$previewKey, this.this$1, this.$isVideo, this.$appContext, this.$targetSize, r14);
        r11.L$0 = r13;
        return r11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L12;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L8 CancellationException -> L10
    L18:
        Bitmap r15 = (Bitmap) r14;     // Catch: Exception -> L8 CancellationException -> L10
    L26:
        if (CoroutineScopeKt.isActive(r2) == true) goto L28;
    L40:
        DoraObricGFeedbackFragment.b.C0106b r16 = this.$holder;
        if (r16.i != this.$newPreviewJob.element) goto L44;
        r16.i = null;
    L44:
        return Unit.INSTANCE;
    L28:
        if (Intrinsics.areEqual(this.$holder.h, this.$uri) == false) goto L40;
        if (r15 == null) goto L32;
        DoraObricGFeedbackFragment r3 = this.this$0;
        int r4 = DoraObricGFeedbackFragment.A;
        r3.Y90().getThumbnailCache().put(this.$previewKey, r15);
        this.this$1.d.remove(this.$previewKey);
        this.$holder.a.setImageBitmap(r15);
    L35:
        DoraObricGFeedbackFragment.b.C0106b r17 = this.$holder;
        if (r17.i != this.$newPreviewJob.element) goto L39;
        r17.i = null;
    L39:
        return Unit.INSTANCE;
    L32:
        this.this$1.d.add(this.$previewKey);
        if (this.$isVideo == false) goto L35;
        this.$holder.a.setImageResource(2131240252);
    L8:
        Exception e = e;
    L22:
        pk4.j.c("DoraGFeedbackViewModel", "load feedback preview failed, uri=" + this.$uri, e);
    L24:
        r15 = null;
        goto L26
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r18 = (CoroutineScope) this.L$0;
        CoroutineDispatcher r5 = Dispatchers.getIO();     // Catch: Exception -> L20 CancellationException -> L23
        DoraObricGFeedbackFragment$ObricFeedbackImageAdapter$bindPreview$2$bitmap$1 r11 = new DoraObricGFeedbackFragment$ObricFeedbackImageAdapter$bindPreview$2$bitmap$1(this.this$1, this.$appContext, this.$uri, this.$isVideo, this.$targetSize, null);     // Catch: Exception -> L20 CancellationException -> L23
        this.L$0 = r18;     // Catch: Exception -> L20 CancellationException -> L23
        this.label = 1;     // Catch: Exception -> L20 CancellationException -> L23
        Object r6 = BuildersKt.withContext(r5, r11, this);     // Catch: Exception -> L20 CancellationException -> L23
        if (r6 != r0) goto L17;
        return r0;
    L17:
        r2 = r18;
        r14 = r6;
        goto L18
    L23:
        r2 = r18;
    L20:
        e = move-exception;
        r2 = r18;
        e = e;
        goto L22
    }
}

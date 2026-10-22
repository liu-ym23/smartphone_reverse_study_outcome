package com.ss.android.lark.integrator.im.impl.preview;

import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.biz.officesdk.im.preview.UrlPreviewCardType;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.integrator.im.impl.preview.OfficeUrlPreviewSessionImpl$scheduleRenderBuild$1", f = "OfficeUrlPreviewSessionImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OfficeUrlPreviewSessionImpl$scheduleRenderBuild$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OfficeUrlPreviewSessionImpl.b $buildKey;
    final /* synthetic */ UrlPreviewCardType $cardType;
    final /* synthetic */ UrlCardPreviewEntity $entity;
    final /* synthetic */ long $generation;
    final /* synthetic */ int $maxWidth;
    final /* synthetic */ String $previewId;
    final /* synthetic */ OfficeUrlPreviewSessionImpl.c $slotKey;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OfficeUrlPreviewSessionImpl this$0;

    public OfficeUrlPreviewSessionImpl$scheduleRenderBuild$1(OfficeUrlPreviewSessionImpl r1, UrlCardPreviewEntity r2, UrlPreviewCardType r3, int r4, String r5, long r6, OfficeUrlPreviewSessionImpl.c r8, OfficeUrlPreviewSessionImpl.b r9, Continuation<? super OfficeUrlPreviewSessionImpl$scheduleRenderBuild$1> r10) {
        this.this$0 = r1;
        this.$entity = r2;
        this.$cardType = r3;
        this.$maxWidth = r4;
        this.$previewId = r5;
        this.$generation = r6;
        this.$slotKey = r8;
        this.$buildKey = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        OfficeUrlPreviewSessionImpl$scheduleRenderBuild$1 r11 = new OfficeUrlPreviewSessionImpl$scheduleRenderBuild$1(this.this$0, this.$entity, this.$cardType, this.$maxWidth, this.$previewId, this.$generation, this.$slotKey, this.$buildKey, r14);
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
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r14);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        t6c.d r11 = this.this$0.f.a(this.$entity, this.$cardType, this.$maxWidth);     // Catch: Throwable -> L19 CancellationException -> L22
        if (r11 != null) goto L11;
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L19 CancellationException -> L22
        this.this$0.j.remove(this.$slotKey, this.$buildKey);
        return r16;
    L11:
        if (OfficeUrlPreviewSessionImpl.a(this.this$0, this.$previewId, this.$generation, this.$entity, this.$cardType, r11, this.$maxWidth) == false) goto L18;
        OfficeUrlPreviewSessionImpl r1 = this.this$0;     // Catch: Throwable -> L19 CancellationException -> L22
        List r2 = CollectionsKt.listOf(this.$previewId);     // Catch: Throwable -> L19 CancellationException -> L22
        r1.getClass();     // Catch: Throwable -> L19 CancellationException -> L22
        if (r2.isEmpty() == true) goto L18;
        if (r1.h.get() == true) goto L18;
        UICallbackExecutor.post(new d(r1, r2));     // Catch: Throwable -> L19 CancellationException -> L22
    L18:
        OfficeUrlPreviewSessionImpl r17 = this.this$0;
    L25:
        r17.j.remove(this.$slotKey, this.$buildKey);
        return Unit.INSTANCE;
    L27:
        th = move-exception;
        this.this$0.j.remove(this.$slotKey, this.$buildKey);
        throw th;
    L19:
        th = move-exception;
        Log.e("UrlPreviewSession", "create preview render failed: " + th);     // Catch: Throwable -> L27
        r17 = this.this$0;
    L22:
        e = move-exception;
        JobKt.cancel(r15.getCoroutineContext(), e);     // Catch: Throwable -> L27
        r17 = this.this$0;
        goto L25
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

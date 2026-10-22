package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderUrlPreviewInlines;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.coremdbiz.facade.plugins.markdown.MarkdownPlugin$Companion$scheduleDocumentPreload$1$job$1", f = "MarkdownPlugin.kt", i = {0, 1}, l = {306, 308}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
final class MarkdownPlugin$Companion$scheduleDocumentPreload$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $debounceMs;
    final /* synthetic */ MovableRenderConfig $movableRenderConfig;
    final /* synthetic */ h $renderKey;
    final /* synthetic */ MovableRenderUrlPreviewInlines $urlPreviewInlines;
    private /* synthetic */ Object L$0;
    int label;

    public MarkdownPlugin$Companion$scheduleDocumentPreload$1$job$1(long r1, h r3, MovableRenderConfig r4, MovableRenderUrlPreviewInlines r5, Continuation<? super MarkdownPlugin$Companion$scheduleDocumentPreload$1$job$1> r6) {
        this.$debounceMs = r1;
        this.$renderKey = r3;
        this.$movableRenderConfig = r4;
        this.$urlPreviewInlines = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        MarkdownPlugin$Companion$scheduleDocumentPreload$1$job$1 r7 = new MarkdownPlugin$Companion$scheduleDocumentPreload$1$job$1(this.$debounceMs, this.$renderKey, this.$movableRenderConfig, this.$urlPreviewInlines, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r0v6, types: [kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        if (r1 == 0) goto L17;
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L12;
        ?? r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: CancellationException -> L9 Exception -> L26
    L29:
        return Unit.INSTANCE;
    L9:
        e = e;
    L32:
        CoroutineScopeKt.cancel(r2, e);
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Exception -> L26 CancellationException -> L30
        r1 = r3;
    L21:
        MarkdownPlugin.Companion r8 = MarkdownPlugin.b;     // Catch: Exception -> L26 CancellationException -> L30
        if (MarkdownPlugin.Companion.b(this.$renderKey) != null) goto L29;
        h r9 = this.$renderKey;     // Catch: Exception -> L26 CancellationException -> L30
        MovableRenderConfig r4 = this.$movableRenderConfig;     // Catch: Exception -> L26 CancellationException -> L30
        MovableRenderUrlPreviewInlines r5 = this.$urlPreviewInlines;     // Catch: Exception -> L26 CancellationException -> L30
        this.L$0 = r1;     // Catch: Exception -> L26 CancellationException -> L30
        this.label = 2;     // Catch: Exception -> L26 CancellationException -> L30
        if (MarkdownPlugin.Companion.d(r9, r4, r5, this) != r0) goto L29;
        return r0;
    L17:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        long r10 = this.$debounceMs;     // Catch: Exception -> L26 CancellationException -> L30
        this.L$0 = r6;     // Catch: Exception -> L26 CancellationException -> L30
        this.label = 1;     // Catch: Exception -> L26 CancellationException -> L30
        r1 = r6;
        if (DelayKt.delay(r10, this) != r0) goto L21;
        return r0;
    L26:
        e = move-exception;
        Log.e("MarkdownPlugin", "Document preload failed", e);
    L30:
        e = e;
        r2 = r1;
        goto L32
    }
}

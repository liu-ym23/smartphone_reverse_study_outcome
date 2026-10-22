package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderUrlPreviewInlines;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/movable/ParsedMovableDocument;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.coremdbiz.facade.plugins.markdown.MarkdownPlugin$Companion$parseAndCacheDocumentDedup$deferred$1$1", f = "MarkdownPlugin.kt", i = {}, l = {344}, m = "invokeSuspend", n = {}, s = {})
public final class MarkdownPlugin$Companion$parseAndCacheDocumentDedup$deferred$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.ss.android.lark.movable.h>, Object> {
    final /* synthetic */ MovableRenderConfig $movableRenderConfig;
    final /* synthetic */ h $renderKey;
    final /* synthetic */ MovableRenderUrlPreviewInlines $urlPreviewInlines;
    int label;

    public MarkdownPlugin$Companion$parseAndCacheDocumentDedup$deferred$1$1(h r1, MovableRenderConfig r2, MovableRenderUrlPreviewInlines r3, Continuation<? super MarkdownPlugin$Companion$parseAndCacheDocumentDedup$deferred$1$1> r4) {
        this.$renderKey = r1;
        this.$movableRenderConfig = r2;
        this.$urlPreviewInlines = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MarkdownPlugin$Companion$parseAndCacheDocumentDedup$deferred$1$1(this.$renderKey, this.$movableRenderConfig, this.$urlPreviewInlines, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.ss.android.lark.movable.h> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L7
    L15:
        com.ss.android.lark.movable.h r7 = (com.ss.android.lark.movable.h) r6;     // Catch: Throwable -> L7
        HashMap<h, Deferred<com.ss.android.lark.movable.h>> r2 = MarkdownPlugin.d;
        h r3 = this.$renderKey;
        monitor-enter(r2);
        Deferred<com.ss.android.lark.movable.h> r4 = r2.remove(r3);     // Catch: Throwable -> L21
        monitor-exit(r2);
        return r7;
    L21:
        th = move-exception;
        throw th;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r6);
        MarkdownPlugin.Companion r8 = MarkdownPlugin.b;     // Catch: Throwable -> L7
        h r5 = this.$renderKey;     // Catch: Throwable -> L7
        MovableRenderConfig r9 = this.$movableRenderConfig;     // Catch: Throwable -> L7
        MovableRenderUrlPreviewInlines r10 = this.$urlPreviewInlines;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        r6 = r8.c(r5, r9, r10, this);     // Catch: Throwable -> L7
        if (r6 != r0) goto L15;
        return r0;
    L7:
        th = move-exception;
        HashMap<h, Deferred<com.ss.android.lark.movable.h>> r11 = MarkdownPlugin.d;
        h r12 = this.$renderKey;
        monitor-enter(r11);
        Deferred<com.ss.android.lark.movable.h> r13 = r11.remove(r12);     // Catch: Throwable -> L29
        throw th;
    L29:
        th = move-exception;
        throw th;
    }
}

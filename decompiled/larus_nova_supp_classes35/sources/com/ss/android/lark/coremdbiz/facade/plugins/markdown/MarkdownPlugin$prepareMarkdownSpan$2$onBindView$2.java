package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderUrlPreviewInlines;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.coremd.base.parse.m;
import com.ss.android.lark.movable.MarkdownMovableView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.coremdbiz.facade.plugins.markdown.MarkdownPlugin$prepareMarkdownSpan$2$onBindView$2", f = "MarkdownPlugin.kt", i = {}, l = {231}, m = "invokeSuspend", n = {}, s = {})
public final class MarkdownPlugin$prepareMarkdownSpan$2$onBindView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MovableRenderConfig $movableRenderConfig;
    final /* synthetic */ MarkdownMovableView $movableView;
    final /* synthetic */ m $nodeHandle;
    final /* synthetic */ h $renderKey;
    final /* synthetic */ MarkdownPlugin$prepareMarkdownSpan$2 $span;
    final /* synthetic */ MovableRenderUrlPreviewInlines $urlPreviewInlines;
    int label;

    public static final class a implements Runnable {
        public final /* synthetic */ MarkdownMovableView a;
        public final /* synthetic */ com.ss.android.lark.movable.h b;
        public final /* synthetic */ m c;
        public final /* synthetic */ MarkdownPlugin$prepareMarkdownSpan$2 d;

        public a(MarkdownMovableView r1, com.ss.android.lark.movable.h r2, m r3, MarkdownPlugin$prepareMarkdownSpan$2 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.j(this.b);     // Catch: Throwable -> L4
            this.c.a(this.d, true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public MarkdownPlugin$prepareMarkdownSpan$2$onBindView$2(h r1, MovableRenderConfig r2, MovableRenderUrlPreviewInlines r3, MarkdownMovableView r4, m r5, MarkdownPlugin$prepareMarkdownSpan$2 r6, Continuation<? super MarkdownPlugin$prepareMarkdownSpan$2$onBindView$2> r7) {
        this.$renderKey = r1;
        this.$movableRenderConfig = r2;
        this.$urlPreviewInlines = r3;
        this.$movableView = r4;
        this.$nodeHandle = r5;
        this.$span = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new MarkdownPlugin$prepareMarkdownSpan$2$onBindView$2(this.$renderKey, this.$movableRenderConfig, this.$urlPreviewInlines, this.$movableView, this.$nodeHandle, this.$span, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        com.ss.android.lark.movable.h r6 = (com.ss.android.lark.movable.h) r5;
        if (r6 == null) goto L14;
        MarkdownMovableView r2 = this.$movableView;
        r2.post(new a(r2, r6, this.$nodeHandle, this.$span));
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MarkdownPlugin.Companion r7 = MarkdownPlugin.b;
        h r8 = this.$renderKey;
        MovableRenderConfig r3 = this.$movableRenderConfig;
        MovableRenderUrlPreviewInlines r4 = this.$urlPreviewInlines;
        this.label = 1;
        r5 = MarkdownPlugin.Companion.d(r8, r3, r4, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}

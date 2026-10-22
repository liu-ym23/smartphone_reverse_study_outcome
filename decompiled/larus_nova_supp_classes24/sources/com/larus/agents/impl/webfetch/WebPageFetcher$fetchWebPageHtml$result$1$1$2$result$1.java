package com.larus.agents.impl.webfetch;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public /* synthetic */ class WebPageFetcher$fetchWebPageHtml$result$1$1$2$result$1 extends FunctionReferenceImpl implements Function0<Unit> {
    final /* synthetic */ AtomicBoolean $cancelled;
    final /* synthetic */ long $startedAtNanos;
    final /* synthetic */ WebPageFetcher this$0;

    public WebPageFetcher$fetchWebPageHtml$result$1$1$2$result$1(AtomicBoolean r7, WebPageFetcher r8, long r9) {
        this.$cancelled = r7;
        this.this$0 = r8;
        this.$startedAtNanos = r9;
        super(0, Intrinsics.Kotlin.class, "checkRunning", "run$checkRunning(Ljava/util/concurrent/atomic/AtomicBoolean;Lcom/larus/agents/impl/webfetch/WebPageFetcher;J)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m396invoke() {
        WebPageFetcher$fetchWebPageHtml$result$1$1$2.b(this.$cancelled, this.this$0, this.$startedAtNanos);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m396invoke();
        return Unit.INSTANCE;
    }
}

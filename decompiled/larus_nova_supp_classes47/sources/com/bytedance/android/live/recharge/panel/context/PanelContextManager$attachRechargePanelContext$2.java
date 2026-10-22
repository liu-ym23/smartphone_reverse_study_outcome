package com.bytedance.android.live.recharge.panel.context;

import com.bytedance.android.live.revenue.common.t;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final class PanelContextManager$attachRechargePanelContext$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ c $context;
    final /* synthetic */ PanelContextManager this$0;

    public PanelContextManager$attachRechargePanelContext$2(PanelContextManager r1, c r2) {
        this.this$0 = r1;
        this.$context = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m276invoke() {
        LinkedHashSet<c> r1 = this.this$0.a;
        monitor-enter(r1);
        jy0.b.a("Recharge/PanelContextManager", "detach panel context: " + this.$context + " (" + t.a(this.$context) + ')');     // Catch: Throwable -> L7
        CollectionsKt.removeAll(this.this$0.a, new PanelContextManager$attachRechargePanelContext$2$$special$$inlined$kmpSynchronized$lambda$1(this));     // Catch: Throwable -> L7
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m276invoke();
        return Unit.INSTANCE;
    }
}

package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import android.animation.Animator;
import com.bytedance.android.live.core.utils.h;
import com.bytedance.android.live.core.utils.s;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 4, 3})
final class AudienceExplainCardWidget$quickShowCard$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ s $listener;
    final /* synthetic */ AudienceExplainCardWidget this$0;

    public AudienceExplainCardWidget$quickShowCard$3(AudienceExplainCardWidget r1, s r2) {
        this.this$0 = r1;
        this.$listener = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m740invoke() {
        Animator r0 = this.this$0.d;
        if (r0 == null) goto L9;
        h.a(r0, new AudienceExplainCardWidget$quickShowCard$3$$special$$inlined$run$lambda$1(this));
        s r1 = this.$listener;
        if (r1 == null) goto L7;
        r0.addListener(r1);
    L7:
        r0.start();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m740invoke();
        return Unit.INSTANCE;
    }
}

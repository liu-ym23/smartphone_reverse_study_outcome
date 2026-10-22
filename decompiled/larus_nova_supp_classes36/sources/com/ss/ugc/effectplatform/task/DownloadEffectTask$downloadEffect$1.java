package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
final class DownloadEffectTask$downloadEffect$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DownloadEffectTask this$0;

    public DownloadEffectTask$downloadEffect$1(DownloadEffectTask r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1572invoke() {
        ExceptionResult r0 = new ExceptionResult(10017);
        DownloadEffectTask r1 = this.this$0;
        com.ss.ugc.effectplatform.repository.d r2 = r1.m.M;
        Effect r3 = r1.l;
        r2.getClass();
        com.ss.ugc.effectplatform.repository.d.a(r3, r0);
        DownloadEffectTask r4 = this.this$0;
        IEffectPlatformBaseListener r5 = r4.m.N.a(r4.n);
        if ((r5 instanceof hlc.d) == true) goto L5;
        r5 = null;
    L5:
        hlc.d r6 = (hlc.d) r5;
        if (r6 == null) goto L8;
        r6.onFail(this.this$0.l, r0);
    L8:
        DownloadEffectTask r7 = this.this$0;
        r7.m.N.c(r7.n);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1572invoke();
        return Unit.INSTANCE;
    }
}

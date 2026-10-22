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
public final class DownloadEffectTask$downloadEffect$2$onFailed$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ExceptionResult $e;
    final /* synthetic */ DownloadEffectTask.downloadEffect.2 this$0;

    public DownloadEffectTask$downloadEffect$2$onFailed$1(DownloadEffectTask.downloadEffect.2 r1, ExceptionResult r2) {
        this.this$0 = r1;
        this.$e = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1574invoke() {
        DownloadEffectTask r0 = this.this$0.a;
        com.ss.ugc.effectplatform.repository.d r1 = r0.m.M;
        Effect r2 = r0.l;
        ExceptionResult r3 = this.$e;
        r1.getClass();
        com.ss.ugc.effectplatform.repository.d.a(r2, r3);
        DownloadEffectTask r4 = this.this$0.a;
        IEffectPlatformBaseListener r5 = r4.m.N.a(r4.n);
        if ((r5 instanceof hlc.d) == true) goto L5;
        r5 = null;
    L5:
        hlc.d r6 = (hlc.d) r5;
        if (r6 == null) goto L9;
        r6.onFail(this.this$0.a.l, this.$e);
    L9:
        if (this.$e.getErrorCode() == 10019) goto L12;
        DownloadEffectTask r7 = this.this$0.a;
        r7.m.N.c(r7.n);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1574invoke();
        return Unit.INSTANCE;
    }
}

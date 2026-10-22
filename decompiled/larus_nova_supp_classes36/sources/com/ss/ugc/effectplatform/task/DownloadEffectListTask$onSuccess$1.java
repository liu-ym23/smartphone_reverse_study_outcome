package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
final class DownloadEffectListTask$onSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List $downloadedEffectList;
    final /* synthetic */ u this$0;

    public DownloadEffectListTask$onSuccess$1(u r1, List r2) {
        this.this$0 = r1;
        this.$downloadedEffectList = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1571invoke() {
        u r0 = this.this$0;
        IEffectPlatformBaseListener r1 = r0.l.N.a(r0.n);
        if (r1 == null) goto L5;
        r1.onSuccess(this.$downloadedEffectList);
    L5:
        u r2 = this.this$0;
        r2.l.N.c(r2.n);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1571invoke();
        return Unit.INSTANCE;
    }
}

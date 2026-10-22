package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.Effect;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
final class DownloadEffectTask$downloadEffect$2$onProgress$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $progress;
    final /* synthetic */ long $totalSize;
    final /* synthetic */ DownloadEffectTask.downloadEffect.2 this$0;

    public DownloadEffectTask$downloadEffect$2$onProgress$1(DownloadEffectTask.downloadEffect.2 r1, int r2, long r3) {
        this.this$0 = r1;
        this.$progress = r2;
        this.$totalSize = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1576invoke() {
        DownloadEffectTask r0 = this.this$0.a;
        com.ss.ugc.effectplatform.repository.d r1 = r0.m.M;
        Effect r2 = r0.l;
        int r3 = this.$progress;
        long r4 = this.$totalSize;
        r1.getClass();
        if (r2 == null) goto L12;
        String r5 = com.ss.ugc.effectplatform.model.b.a(r2);
        if (r5 == null) goto L12;
        z.c r6 = (z.c) com.ss.ugc.effectplatform.repository.d.b.get(r5);
        if (r6 == null) goto L12;
        Iterator r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        ((hlc.d) r7.next()).onProgress(r2, r3, r4);
    L12:
        DownloadEffectTask r8 = this.this$0.a;
        IEffectPlatformBaseListener r9 = r8.m.N.a(r8.n);
        if ((r9 instanceof hlc.d) == true) goto L15;
        r9 = null;
    L15:
        hlc.d r10 = (hlc.d) r9;
        if (r10 == null) goto L20;
        r10.onProgress(this.this$0.a.l, this.$progress, this.$totalSize);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1576invoke();
        return Unit.INSTANCE;
    }
}

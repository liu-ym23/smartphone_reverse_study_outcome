package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
public final class DownloadEffectTask$downloadEffect$2$onCancel$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DownloadEffectTask.downloadEffect.2 this$0;

    public DownloadEffectTask$downloadEffect$2$onCancel$1(DownloadEffectTask.downloadEffect.2 r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1573invoke() {
        DownloadEffectTask r0 = this.this$0.a;
        com.ss.ugc.effectplatform.repository.d r1 = r0.m.M;
        Effect r2 = r0.l;
        r1.getClass();
        if (r2 == null) goto L13;
        String r3 = com.ss.ugc.effectplatform.model.b.a(r2);
        if (r3 == null) goto L13;
        z.c r4 = (z.c) com.ss.ugc.effectplatform.repository.d.b.get(r3);
        if (r4 == null) goto L12;
        Iterator r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        ((hlc.d) r5.next()).onFail(r2, new ExceptionResult(10001, new Exception(String.valueOf(10001))));
    L12:
        com.ss.ugc.effectplatform.repository.d.b.remove(r3);
        com.ss.ugc.effectplatform.repository.d.a.remove(r3);
    L13:
        DownloadEffectTask r6 = this.this$0.a;
        IEffectPlatformBaseListener r7 = r6.m.N.a(r6.n);
        if ((r7 instanceof hlc.d) == true) goto L16;
        r7 = null;
    L16:
        hlc.d r8 = (hlc.d) r7;
        if (r8 == null) goto L21;
        r8.onFail(this.this$0.a.l, new ExceptionResult(10001, new Exception(String.valueOf(10001))));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1573invoke();
        return Unit.INSTANCE;
    }
}

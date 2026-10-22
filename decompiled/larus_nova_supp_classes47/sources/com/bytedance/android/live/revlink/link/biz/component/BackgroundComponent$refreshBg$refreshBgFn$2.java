package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class BackgroundComponent$refreshBg$refreshBgFn$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public BackgroundComponent$refreshBg$refreshBgFn$2(BackgroundComponent r8) {
        super(0, r8, BackgroundComponent.class, "refreshPlayerBg", "refreshPlayerBg()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m882invoke() {
        BackgroundComponent r0 = (BackgroundComponent) ((CallableReference) this).receiver;
        com.bytedance.android.live.revlink.link.domain.anchorimpl.b r1 = r0.b();
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(r0.getContext()) == false) goto L5;
        r0.getContext().getLinkDataSet().zn().setValue(new oq2.b(r1.a, r1.b, r1.c, r1.d));
        return;
    L5:
        NextLiveData r2 = r0.getContext().getLinkDataSet().Ed();
        String r3 = r1.a;
        String r4 = r1.b;
        if (r1.c == false) goto L8;
    L11:
        boolean r5 = true;
    L12:
        r2.setValue(new oq2.a(r3, r4, r5));
        return;
    L8:
        if (r1.d == true) goto L11;
        r5 = false;
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m882invoke();
        return Unit.INSTANCE;
    }
}

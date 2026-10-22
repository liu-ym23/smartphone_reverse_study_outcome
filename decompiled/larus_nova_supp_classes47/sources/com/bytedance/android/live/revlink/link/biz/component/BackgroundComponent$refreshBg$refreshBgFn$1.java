package com.bytedance.android.live.revlink.link.biz.component;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class BackgroundComponent$refreshBg$refreshBgFn$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public BackgroundComponent$refreshBg$refreshBgFn$1(BackgroundComponent r8) {
        super(0, r8, BackgroundComponent.class, "refreshInnerBg", "refreshInnerBg()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m881invoke() {
        BackgroundComponent r0 = (BackgroundComponent) ((CallableReference) this).receiver;
        com.bytedance.android.live.revlink.link.domain.anchorimpl.b r1 = r0.b();
        r0.getContext().getCommonService().d(r1);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m881invoke();
        return Unit.INSTANCE;
    }
}

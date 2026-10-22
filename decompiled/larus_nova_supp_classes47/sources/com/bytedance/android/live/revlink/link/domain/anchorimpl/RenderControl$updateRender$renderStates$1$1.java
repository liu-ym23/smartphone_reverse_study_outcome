package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RenderControl$updateRender$renderStates$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public RenderControl$updateRender$renderStates$1$1(WindowClickImpl r8) {
        super(0, r8, WindowClickImpl.class, "onWindowClick", "onWindowClick()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m935invoke() {
        ((WindowClickImpl) ((CallableReference) this).receiver).a();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m935invoke();
        return Unit.INSTANCE;
    }
}

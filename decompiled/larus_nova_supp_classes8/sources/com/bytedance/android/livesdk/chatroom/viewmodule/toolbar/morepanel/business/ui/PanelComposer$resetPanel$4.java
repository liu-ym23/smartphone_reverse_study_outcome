package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.ui;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.ComposePool;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kp1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkp1/b;", "Llp1/b;", "", "p1", "", "invoke", "(Lkp1/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PanelComposer$resetPanel$4 extends FunctionReferenceImpl implements Function1<b<lp1.b<Object>>, Unit> {
    public PanelComposer$resetPanel$4(PanelComposer r8) {
        super(1, r8, PanelComposer.class, "removeElementByReset", "removeElementByReset(Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/morepanel/core/element/IComposeElement;)V", 0);
    }

    public final void invoke(b<lp1.b<Object>> r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        PanelComposer r0 = (PanelComposer) ((CallableReference) this).receiver;
        ComposePool.c(r0.d, r3);
        View r1 = r3.e();
        if (r1 == null) goto L9;
        ViewGroup r2 = r0.f;
        if (r2 == null) goto L7;
        r2.removeView(r1);
    L7:
        r3.i();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((b) r1);
        return Unit.INSTANCE;
    }
}

package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftReceiverViewState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIReceiverView extends com.bytedance.android.anya.e<GiftPanelState, GiftReceiverViewState, GiftAction> {
    public final p1 k;
    public final Map<GiftReceiverViewState.Mode, BaseGiftMVIViewChildNode<GiftReceiverViewState, ?, ?>> l;
    public final Collection<com.bytedance.android.anya.z<GiftReceiverViewState, ?, ?>> m;
    public final Context n;
    public final ViewGroup o;

    public final void i() {
        p1 r0 = this.k;
        if (com.bytedance.android.scope.l.b(r0) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L9;
        com.bytedance.android.scope.l.c(r0);
        return;
    }

    public final Collection<com.bytedance.android.anya.z<GiftReceiverViewState, ?, ?>> p() {
        return this.m;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftPanelState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIReceiverView$bindToParent$1 r0 = GiftMVIReceiverView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public GiftMVIReceiverView(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "currentContext");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        this.n = r2;
        this.o = r3;
        com.bytedance.android.scope.m.e.getClass();
        p1 r4 = new p1(com.bytedance.android.scope.m.d);
        Intrinsics.checkNotNullParameter(r4, "scope");
        Intrinsics.checkNotNullParameter(r2, "value");
        r4.e = r2;
        if (r2 != e33.k.a) goto L5;
        String r5 = "context";
    L6:
        if (r5 != null) goto L10;
        com.bytedance.android.scope.l.a(r4);
        Unit r6 = Unit.INSTANCE;
        this.k = r4;
        this.l = new LinkedHashMap();
        final ArrayList r7 = new ArrayList();
        com.bytedance.android.scope.m.f(r4, new GiftMVIReceiverView$$special$$inlined$apply$lambda$1(r7, this));
        this.m = r7;
        return;
    L10:
        throw new UninitializedPropertyAccessException(r5);
    L5:
        r5 = null;
        goto L6
    }

    public final void q(com.bytedance.android.anya.k r4, MVIState r5, Function1 r6) {
        GiftReceiverViewState r7 = (GiftReceiverViewState) r5;
        Intrinsics.checkNotNullParameter(r4, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r7, "state");
        Intrinsics.checkNotNullParameter(r6, "dispatchDiff");
        com.bytedance.android.anya.r0<GiftReceiverViewState, GiftReceiverViewState.Mode> r8 = r7.getMode();
        Object r0 = r4.c.a(r8);
        if (r0 == null) goto L11;
        r4.b.a.invoke(r8);
        GiftReceiverViewState.Mode r1 = (GiftReceiverViewState.Mode) r0;
        Iterator r9 = ((LinkedHashMap) this.l).entrySet().iterator();
    L6:
        if (r9.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) r9.next();
        if (((GiftReceiverViewState.Mode) r2.getKey()) == r1) goto L9;
        ((BaseGiftMVIViewChildNode) r2.getValue()).p(8);
        goto L6
    L9:
        ((BaseGiftMVIViewChildNode) r2.getValue()).p(0);
    L11:
        r6.invoke(r4);
    }
}

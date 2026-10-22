package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.common.utility.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends RelativeLayout implements d {
    public Map<Integer, View> a;
    public final View b;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public final b getListener() {
        return null;
    }

    public final void setListener(b r1) {
    }

    public final View a() {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = (View) ((LinkedHashMap) this.a).get(2131381991);
        if (r0 != null) goto L12;
        View r1 = findViewById(2131381991);
        if (r1 == null) goto L10;
        this.a.put(2131381991, r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final View getView() {
        return this.b;
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new LinkedHashMap();
        this.b = View.inflate(r2, 2131567094, this);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.d
    public final void j(Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "endAction");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        Logger.d("PayFlowView", "FlowItemView, fadeIn");
    L5:
        z.a(this.b, 250, 0.0f, r5);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.d
    public final void k(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onHide");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        Logger.d("PayFlowView", "FlowItemView, slideOut, " + this);
    L5:
        z.f(this.b, r3);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.d
    public final void o(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "endAction");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        Logger.d("PayFlowView", "FlowItemView, slideIn, " + this);
    L5:
        z.e(this.b, r3);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.d
    public final void x(Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "onHide");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        Logger.d("PayFlowView", "FlowItemView, fadeOut, " + this);
    L5:
        z.c(this.b, 250, 0.0f, r5);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.d
    public final void y(int r4, Function1<? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "onTextWidthUpdated");
        ((TextView) a()).setText("+" + r4);
        ((TextView) a()).measure(0, 0);
        r5.invoke(Integer.valueOf(((TextView) a()).getMeasuredWidth()));
    }
}

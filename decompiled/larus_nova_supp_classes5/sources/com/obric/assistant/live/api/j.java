package com.obric.assistant.live.api;

import android.content.Context;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class j implements a {
    public static final j a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    public j() {
    }

    static {
        a = new j();
        b = LazyKt.lazy(new h());
        c = LazyKt.lazy(new i());
    }

    public static a t() {
        return (a) c.getValue();
    }

    public final boolean a() {
        return t().a();
    }

    public final void b() {
        t().b();
    }

    public final void collapseNotificationPanel() {
        t().collapseNotificationPanel();
    }

    public final boolean e() {
        return t().e();
    }

    public final void i() {
        t().i();
    }

    public final void init() {
        t().init();
    }

    public final void j() {
        t().j();
    }

    public final void k() {
        t().k();
    }

    public final void p() {
        t().p();
    }

    public final boolean c(ObricInteractionScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        return t().c(r2);
    }

    public final void f(boolean r2) {
        t().f(r2);
    }

    public final void g(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        t().g(r2);
    }

    public final void l(boolean r2) {
        t().l(false);
    }

    public final void m(boolean r2) {
        t().m(r2);
    }

    public final void q(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        t().q(r2);
    }

    public final void r(boolean r2) {
        t().r(false);
    }

    public final boolean s(ObricInteractionScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        return t().s(r2);
    }

    public final void h(Context r3, ObricState r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "obricState");
        if (r4.getScene() == ObricInteractionScene.AIGC_GENERATION_SCENE) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L11;
        FLogger.a.i("ObricLiveDelegate", "Skip AIGC generation live card for GR island");
        return;
    L11:
        t().h(r3, r4);
        return;
    L5:
        if (((Boolean) b.getValue()).booleanValue() == false) goto L7;
        r0 = true;
        goto L8
    }

    public final void n(boolean r2, boolean r3) {
        t().n(r2, r3);
    }

    public final void d(Context r2, ObricInteractionScene r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "scene");
        if (r3 == ObricInteractionScene.AIGC_GENERATION_SCENE) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        t().d(r2, r3, r4);
        return;
    L5:
        if (((Boolean) b.getValue()).booleanValue() == false) goto L7;
        r0 = true;
        goto L8
    }

    public final void o(Context r2, ObricInteractionScene r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r5, "conversationId");
        if (r3 == ObricInteractionScene.AIGC_GENERATION_SCENE) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        t().o(r2, r3, r4, r5);
        return;
    L5:
        if (((Boolean) b.getValue()).booleanValue() == false) goto L7;
        r0 = true;
        goto L8
    }
}

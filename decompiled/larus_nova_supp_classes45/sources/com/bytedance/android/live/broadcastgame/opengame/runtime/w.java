package com.bytedance.android.live.broadcastgame.opengame.runtime;

import android.content.Context;
import android.view.Surface;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.model.h0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class w implements q, p {
    public PluginContext a;
    public com.bytedance.android.live.broadcastgame.opengame.t b;
    public LiveBasePluginWithPanel c;
    public com.bytedance.android.live.broadcastgame.api.model.u d;
    public r e;
    public boolean f;
    public boolean g;
    public final Context h;
    public final DataCenter i;
    public final long j;
    public final boolean k;
    public final com.bytedance.android.live.broadcastgame.opengame.i l;
    public final /* synthetic */ i20.a m;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public void c(boolean r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public void notifyStartLinkCastResult(boolean r1, Surface r2, int r3) {
    }

    public abstract PluginContext q(Map<String, ? extends Object> r1);

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public void stopGameCastToAudience() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.q
    /* JADX INFO: renamed from: getContext, reason: collision with other method in class */
    public PluginContext mo311getContext() {
        PluginContext r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final com.bytedance.android.live.broadcastgame.opengame.t getPluginInfo() {
        com.bytedance.android.live.broadcastgame.opengame.t r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentPluginInfo");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void hide() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePluginRuntime", new Object[]{"on lifecycle: hide"});
        LiveBasePluginWithPanel r1 = this.c;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("plugin");
    L5:
        r1.onHide();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final Long i() {
        LiveBasePluginWithPanel r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("plugin");
    L6:
        return Long.valueOf(r0.e);
    }

    public void launch() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePluginRuntime", new Object[]{"on lifecycle: launch"});
        LiveBasePluginWithPanel r1 = this.c;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("plugin");
    L5:
        r1.f();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public void m() {
        r r0 = this.e;
        if (r0 == null) goto L6;
        r0.o();
        return;
    }

    public final com.bytedance.android.live.broadcastgame.opengame.t r() {
        com.bytedance.android.live.broadcastgame.opengame.t r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentPluginInfo");
    L5:
        return r0;
    }

    public final com.bytedance.android.live.broadcastgame.api.model.u s() {
        com.bytedance.android.live.broadcastgame.api.model.u r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("gameItem");
    L5:
        return r0;
    }

    public void start() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePluginRuntime", new Object[]{"on lifecycle: start, hasFail: ", Boolean.valueOf(this.g), ", isAutoShow: ", Boolean.valueOf(this.f)});
        LiveBasePluginWithPanel r1 = this.c;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("plugin");
    L5:
        r1.onStart();
        if (this.g == false) goto L9;
        this.g = false;
    L9:
        if (this.f == false) goto L12;
        g(null);
        return;
    }

    public void stop() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePluginRuntime", new Object[]{"on lifecycle: stop, dispose"});
        this.g = false;
        LiveBasePluginWithPanel r1 = this.c;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("plugin");
    L5:
        r1.onStop();
        r r2 = this.e;
        if (r2 == null) goto L8;
        r2.onStop();
    L8:
        this.m.b();
    }

    public final k t() {
        LiveBasePluginWithPanel r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("plugin");
    L5:
        return r0;
    }

    public final PluginContext u() {
        PluginContext r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
    L5:
        return r0;
    }

    public final Context getContext() {
        return this.h;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public void d(com.bytedance.android.live.broadcastgame.api.openplatform.a r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        PluginContext r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
    L5:
        r0.d(r3);
    }

    public void fail(String r7) {
        Intrinsics.checkNotNullParameter(r7, "error");
        int r1 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePluginRuntime", new Object[]{"on lifecycle: fail, error: " + r7});
        this.g = true;
        InteractGameContext r2 = InteractGameContext.Companion.getContext();
        if (r2 == null) goto L7;
        com.bytedance.live.datacontext.n<h0.c> r3 = r2.getOpenGameLaunchResult();
        if (r3 == null) goto L7;
        r3.setValue(new h0.a(null));
    L7:
        LiveBasePluginWithPanel r4 = this.c;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("plugin");
    L10:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r7, "error");
        Intrinsics.checkNotNullParameter(r7, "error");
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePlugin", new Object[]{"on lifecycle: onFail, error: ", r7});
        r4.d = true;
        p r0 = r4.k();
        if (r0 == null) goto L13;
        r0.fail(r7);
    L13:
        l r8 = r4.j;
        if (r8 == null) goto L17;
        r8.r0(null, LiveBasePluginWithPanel$onFail$1.INSTANCE);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void l(Map<String, String> r4) {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePluginRuntime", new Object[]{"on lifecycle: show"});
        LiveBasePluginWithPanel r1 = this.c;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("plugin");
    L5:
        r1.onShow(r4);
    }

    public w(Context r2, DataCenter r3, long r4, boolean r6, com.bytedance.android.live.broadcastgame.opengame.i r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.m = new i20.a();
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r6;
        this.l = r7;
        this.f = true;
    }
}

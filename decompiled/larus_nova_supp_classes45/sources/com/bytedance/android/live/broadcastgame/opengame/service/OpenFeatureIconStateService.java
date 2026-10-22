package com.bytedance.android.live.broadcastgame.opengame.service;

import com.bytedance.android.live.broadcastgame.api.model.ReloadPanelType;
import com.bytedance.android.live.broadcastgame.api.model.f0;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.o;
import com.bytedance.android.live.broadcastgame.opengame.runtime.p;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/OpenFeatureIconStateService;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/o;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureIconStateService implements y10.a, p, o {
    public final PluginContext a;

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.o
    public final void e() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void fail(String r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    @Override // y10.a
    public final void g() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void hide() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void l(Map<String, String> r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
        u r0 = this.a.m.e();
        if (r0 == null) goto L6;
        String r1 = r0.e();
        if (r1 == null) goto L6;
    L7:
        String r2 = r1;
        if (r2.length() <= 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L13;
        return;
    L13:
        if (this.a.p == true) goto L17;
        xs2.b.a().post(new f0(r2, ReloadPanelType.FROM_CAHCE, false, false, 4));
        return;
    L17:
        return;
    L10:
        r3 = false;
    L6:
        r1 = "";
        goto L7
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.o
    public final void f() {
        xs2.b r0 = xs2.b.a();
        u r1 = this.a.m.e();
        if (r1 == null) goto L6;
        String r2 = r1.e();
        if (r2 == null) goto L6;
    L7:
        r0.post(new f0(r2, null, true, true, 2));
        return;
    L6:
        r2 = "";
        goto L7
    }

    public OpenFeatureIconStateService(PluginContext r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.o
    public final void d(com.bytedance.android.live.broadcastgame.api.openplatform.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r2, "data");
    }
}

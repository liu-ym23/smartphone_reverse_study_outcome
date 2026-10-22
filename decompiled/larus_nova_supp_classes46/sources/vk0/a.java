package vk0;

import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.liveinteract.utils.j1;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.scope.o;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import m00.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements o, fc6.a {
    public final bn0.b a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final sk0.b L() {
        IMiddlewareBroadcastService r1 = k.f(IMiddlewareBroadcastService.class);
        if (r1 == null) goto L5;
        g r2 = r1.createVideoTalkView(TTMiddlewareLiveSDK.getContext(), "", false, true, false, null);
    L6:
        if (r2 != null) goto L8;
        return null;
    L8:
        return new sk0.b(r2, null);
    L5:
        r2 = null;
        goto L6
    }

    public final void k() {
        IFeatureService r0 = k.f(IFeatureService.class);
        if (r0 == null) goto L8;
        z90.a r1 = r0.getFeatureManager();
        if (r1 == null) goto L9;
        r1.i("is_strategy_support_scene", Boolean.FALSE, FeatureType.MONITOR);
        return;
    L9:
        return;
    }

    public final wk0.a n() {
        return new wk0.a();
    }

    public final b o() {
        return new b();
    }

    public final void R() {
        xs2.b.a().post(new pv0.b());
    }

    public final String d() {
        return j1.a();
    }

    public a(bn0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "myScope");
        this.a = r2;
    }
}

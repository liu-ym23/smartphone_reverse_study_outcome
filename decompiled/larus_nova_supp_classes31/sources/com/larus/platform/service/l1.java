package com.larus.platform.service;

import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.applet.utils.g;
import com.larus.platform.api.x2;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocateScene;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import hq9.y2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l1 implements x2 {
    public static final l1 a = null;
    public static final Lazy b = null;

    public l1() {
    }

    static {
        a = new l1();
        b = LazyKt.lazy(new k1());
    }

    public static x2 h() {
        return (x2) b.getValue();
    }

    @Override // com.larus.platform.api.x2
    public final void g() {
        Intrinsics.checkNotNullParameter("dora_location_poll_disabled", CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        x2 r0 = h();
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    @Override // com.larus.platform.api.x2
    public final boolean c() {
        x2 r0 = h();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.c();
    }

    @Override // com.larus.platform.api.x2
    public final void b(y2 r2) {
        x2 r0 = h();
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    @Override // com.larus.platform.api.x2
    public final Dialog d(FragmentActivity r2) {
        x2 r0 = h();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d(r2);
    }

    @Override // com.larus.platform.api.x2
    public final GeoLocationInfo e(long r2) {
        x2 r0 = h();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e(r2);
    }

    @Override // com.larus.platform.api.x2
    public final void a(LocateScene r2, hq9.a3 r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        x2 r0 = h();
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }

    @Override // com.larus.platform.api.x2
    public final void f(LocateScene r2, g r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        x2 r0 = h();
        if (r0 == null) goto L6;
        r0.f(r2, r3, r4);
        return;
    }
}

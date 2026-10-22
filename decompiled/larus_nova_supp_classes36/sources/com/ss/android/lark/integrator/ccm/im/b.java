package com.ss.android.lark.integrator.ccm.im;

import com.bytedance.ee.bear.lark.dependency.h;
import com.ss.android.lark.ccm_api.ICCMApi;
import com.ss.android.lark.integrator.ccm.spacekit.SpacekitSdkWrapper;
import com.ss.android.lark.utils.ApiUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import on4.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements h, r {
    public h.a a;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public final void a() {
        tt5.a.h("IDocSdkInitImpl", "checkAndInitDocSDK");
        ((ICCMApi) ApiUtils.getApi(ICCMApi.class)).checkAndInit();
    }

    public final void c() {
        tt5.a.h("IDocSdkInitImpl", "clearOnDocInitListener");
        ((CopyOnWriteArrayList) SpacekitSdkWrapper.b.a.b).remove(this);
        this.a = null;
    }

    public final void onInit() {
        h.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final void b(h.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        tt5.a.h("IDocSdkInitImpl", "setOnDocInitListener");
        this.a = r3;
        SpacekitSdkWrapper r4 = SpacekitSdkWrapper.b.a;
        if (((CopyOnWriteArrayList) r4.b).contains(this) == true) goto L6;
        ((CopyOnWriteArrayList) r4.b).add(this);
        return;
    }
}

package exb;

import com.ss.android.lark.officesdk.di.core.deps.webview.PlatformPluginVersion;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final exb.a a;
    public final d b;
    public otb.e c;
    public gxb.d d;
    public final HashMap<PlatformPluginVersion, Boolean> e;

    public static final class a {
    }

    static {
    }

    public final void a() {
        otb.e r0 = this.c;
        if (r0 == null) goto L5;
        HashMap<PlatformPluginVersion, Boolean> r1 = this.e;
        PlatformPluginVersion r2 = PlatformPluginVersion.SANDWICH;
        r0.isFeatureSupport("mixrender_sandwich_mode");
        Boolean r3 = Boolean.FALSE;
        r1.put(r2, r3);
        HashMap<PlatformPluginVersion, Boolean> r4 = this.e;
        PlatformPluginVersion r5 = PlatformPluginVersion.EMBED;
        r0.isFeatureSupport("mixrender_embed_mode");
        r4.put(r5, r3);
    L5:
        this.a.getClass();
        exb.a.c("PlatformPluginManager", "updateMixRenderState");
    }

    public b() {
        exb.a r0 = new exb.a();
        this.a = r0;
        this.b = new d(r0);
        this.e = new HashMap();
    }
}

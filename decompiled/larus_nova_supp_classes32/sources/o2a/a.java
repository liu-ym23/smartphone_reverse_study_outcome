package o2a;

import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import kotlin.jvm.internal.Intrinsics;
import l2a.u;
import zp9.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements k {
    public TTVideoEngine a;
    public volatile boolean b;

    public a() {
    }

    public final void a(boolean r3) {
        if (r3 == true) goto L4;
    L6:
        TTVideoEngine r0 = this.a;
        if (r0 == null) goto L9;
        r0.openTextureSR(true, r3);
    L9:
        boolean r1 = u.a;
        u.b("BmfVideoSRHelper", "openTextureSR, isOpen: " + r3);
        return;
    L4:
        if (this.b == true) goto L6;
        b("openTextureSR");
        goto L6
    }

    public final void b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        if (AppHost.a.isDebug() == false) goto L5;
        TTVideoEngineLog.turnOn(1, 1);
    L5:
        boolean r0 = u.a;
        u.b("BmfVideoSRHelper", "initBmfSR:" + r6);
        TTVideoEngine r7 = this.a;
        if (r7 == null) goto L9;
        this.b = true;
        TTVideoEngine.setIntValue(719, 1);
        r7.openTextureSR(true, true);
        r7.ignoreSRResolutionLimit(true);
        Bundle r2 = new Bundle();
        r2.putInt("effect_type", 5);
        r2.putInt("action", 21);
        r2.putInt("srAlgType", 17);
        r2.putInt("sr_backend", 3);
        r2.putInt("scale_type", 1);
        r2.putInt("pool_size", 2);
        r2.putString("kernelBinPath", b.a("bmf_bin"));
        r2.putString("oclModleName", "oclModuleName");
        r2.putString("dspModleName", "dspModuleName");
        r2.putString("programCacheDir", b.a("bmf_program"));
        r7.setEffect(r2);
        r7.asyncInitSR(false);
        r7.setSrMaxTextureSize(1600, 1600);
        r7.dynamicControlSR(true);
        u.b("BmfVideoSRHelper", "init Bmf, ttvideoEngine: " + r7.hashCode());
        return;
    }

    public final void e(TTVideoEngine r2) {
        Intrinsics.checkNotNullParameter(r2, "videoEngine");
        if ((r2 instanceof TTVideoEngine) == false) goto L5;
        TTVideoEngine r0 = r2;
    L6:
        if (r0 == null) goto L9;
        this.a = r2;
        return;
    L9:
        return;
    L5:
        r0 = null;
        goto L6
    }
}

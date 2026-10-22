package n78;

import com.larus.audio.y0;
import com.larus.business.debug.base.audio.module.TTSModule;
import com.larus.home.impl.sdk.s;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import m58.h;
import m58.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements y0 {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // com.larus.audio.y0
    public final float b() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r1 = false;
        if (r0 == null) goto L9;
        s r2 = r0.s0();
        if (r2 == null) goto L9;
        if (r2.isDoraConnected() != true) goto L9;
        boolean r3 = true;
    L10:
        Float r4 = null;
        if (r3 == false) goto L26;
        q r5 = h.d;
        if (r5 == null) goto L25;
        TTSModule r6 = r5.d();
        if (r6 == null) goto L25;
        Float r7 = Float.valueOf(r6.a());
        if (r7.floatValue() != 0.0f) goto L20;
        r1 = true;
    L20:
        if ((!r1) == false) goto L22;
        r4 = r7;
    L22:
        if (r4 == null) goto L25;
        return r4.floatValue();
    L25:
        return z2.a.getLoudnessConfig().b;
    L26:
        q r8 = h.d;
        if (r8 == null) goto L39;
        TTSModule r9 = r8.d();
        if (r9 == null) goto L39;
        Float r10 = Float.valueOf(r9.b());
        if (r10.floatValue() != 0.0f) goto L34;
        r1 = true;
    L34:
        if ((!r1) == false) goto L36;
        r4 = r10;
    L36:
        if (r4 == null) goto L39;
        return r4.floatValue();
    L39:
        return z2.a.getLoudnessConfig().a;
    L9:
        r3 = false;
        goto L10
    }

    @Override // com.larus.audio.y0
    public final int c() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r1 = false;
        if (r0 == null) goto L9;
        s r2 = r0.s0();
        if (r2 == null) goto L9;
        if (r2.isDoraConnected() != true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        return 1;
    L12:
        q r4 = h.d;
        if (r4 == null) goto L19;
        TTSModule r5 = r4.d();
        if (r5 == null) goto L19;
        if (r5.e() != true) goto L19;
        r1 = true;
    L19:
        if (r1 == false) goto L22;
        return 1;
    L22:
        return z2.a.getLoudnessConfig().c;
    L9:
        r3 = false;
        goto L10
    }
}

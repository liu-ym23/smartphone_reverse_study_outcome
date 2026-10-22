package g58;

import com.larus.home.impl.sdk.s;
import com.larus.media.MediaResourceManager;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ h a;
    public final /* synthetic */ Boolean b;

    public /* synthetic */ d(h r1, Boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h r0 = this.a;
        Boolean r1 = this.b;
        FLogger r2 = FLogger.a;
        r2.i("AiAsrManager", "set session released to true");
        IFlowSdkDepend r4 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r4 == null) goto L7;
        s r5 = r4.s0();
        if (r5 == null) goto L7;
        r5.j();
    L7:
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L12;
        s r7 = r6.s0();
        if (r7 == null) goto L12;
        r7.i(false);
    L12:
        r0.s = true;
        Boolean r8 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r8) == true) goto L15;
        ((com.larus.audio.call.record.f) r0.q.getValue()).stopRecord();
        ((com.larus.audio.call.record.f) r0.q.getValue()).release();
    L16:
        p r3 = r0.v;
        if (r3 == null) goto L19;
        r3.a();
    L19:
        r0.v = null;
        q r9 = r0.w;
        if (r9 == null) goto L22;
        r9.a();
    L22:
        r0.w = null;
        if (Intrinsics.areEqual(r1, r8) == true) goto L25;
        Lazy r10 = MediaResourceManager.a;
        MediaResourceManager.b(r0.y, r0.x);
    L25:
        r0.n = System.currentTimeMillis();
        r78.c r11 = r0.a;
        if (r11 == null) goto L29;
        r11.c(r0.b);
        return;
    L29:
        return;
    L15:
        r2.i("AiAsrManager", "record in DoraG, no stop record");
        goto L16
    }
}

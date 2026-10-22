package m1c;

import android.content.Context;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import com.ss.android.lark.utils.y0;
import e1c.d;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b extends k1c.a<Integer> implements DevicePerfManager.c {

    public static final class a {
    }

    static {
    }

    @Override // k1c.a
    public final Integer n() {
        return Integer.valueOf(DevicePerfManager.b.a.e.a);
    }

    public b() {
    }

    public final void a(int r3) {
        o(Integer.valueOf(r3));
        Log.d("Detector/TurboModeDetector", "onDevicePerfChanged:" + r3);
    }

    @Override // k1c.a, k1c.b
    public final void j(Context r5, d r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "manager");
        super.j(r5, r6);
        DevicePerfManager r7 = DevicePerfManager.b.a;
        r7.getClass();
        DevicePerfManager.PerfType r8 = DevicePerfManager.PerfType.ALL;
        Iterator r0 = r7.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        DevicePerfManager.a r1 = (DevicePerfManager.a) r0.next();
        if (y0.a(r1.d, "TurboModeDetector") == false) goto L4;
        if (r1.b != r8) goto L4;
        Log.w("DevicePerfManager", "found repeat register, key is: TurboModeDetector, perfType is: " + r8);
        boolean r2 = true;
    L11:
        if (r2 == true) goto L21;
        DevicePerfManager.PerfType r3 = DevicePerfManager.PerfType.ALL;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new bsb.d(r7, this, r8));
        r7.a.add(new DevicePerfManager.a(new SoftReference(this), r8, null));
        return;
    L21:
        return;
    L10:
        r2 = false;
        goto L11
    }
}

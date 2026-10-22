package gh;

import com.bytedance.pia.core.bridge.methods.c0;
import com.bytedance.pia.core.bridge.methods.g0;
import com.bytedance.pia.core.bridge.methods.i;
import com.bytedance.pia.core.bridge.methods.k0;
import com.bytedance.pia.core.bridge.methods.l;
import com.bytedance.pia.core.bridge.methods.o;
import com.bytedance.pia.core.bridge.methods.q0;
import com.bytedance.pia.core.bridge.methods.s;
import com.bytedance.pia.core.bridge.methods.s0;
import com.bytedance.pia.core.bridge.methods.u;
import com.bytedance.pia.core.bridge.methods.w;
import com.bytedance.pia.core.bridge.methods.z;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f17093b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f17094a;

    static {
        HashMap r5 = new HashMap();
        f17093b = r5;
        r5.put("pia.internal.setting.get", w.f7028a);
        r5.put("pia.internal.worker.create", g0.f6983a);
        r5.put("pia.internal.worker.postMessage", k0.f6997a);
        r5.put("pia.internal.worker.terminate", s0.f7022a);
        r5.put("pia.internal.worker.runTask", q0.f7016a);
        r5.put("pia.internal.boot.get", com.bytedance.pia.core.bridge.methods.c.f6967a);
        r5.put("pia.internal.cache.save", s.f7021a);
        r5.put("pia.internal.cache.getContent", i.f6989a);
        r5.put("pia.internal.cache.remove", o.f7007a);
        r5.put("pia.internal.cache.getHeaders", l.f6998a);
        r5.put("pia.internal.cache.updateManifest", u.f7024a);
        r5.put("pia.internal.tracing.get", z.f7031a);
        r5.put("pia.internal.tracing.set", c0.f6968a);
    }

    public a() {
        this.f17094a = new HashMap();
    }
}

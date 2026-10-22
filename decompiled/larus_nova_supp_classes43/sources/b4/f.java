package b4;

import com.bytedance.ai.bridge.method.net.core.RequestMethod;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public final String a;
    public Map<String, String> b;
    public boolean c;
    public Map<String, String> d;
    public byte[] e;
    public String f;
    public long g;
    public long h;
    public long i;
    public boolean j;
    public int k;

    public f(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.a = r10;
        this.k = -1;
    }

    public final m delete(IHostNetworkDepend r10) {
        Intrinsics.checkNotNullParameter(r10, "hostNetworkDepend");
        b r0 = b.a;
        RequestMethod r1 = RequestMethod.DELETE;
        r0.getClass();
        return b.f(r1, this, r10);
    }
}

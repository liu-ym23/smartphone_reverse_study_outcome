package bz0;

import com.bytedance.android.live.revenue.platform.container.impl.core.NativeHostServiceImpl;
import com.lynx.jsbridge.LynxModule;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends com.lynx.jsbridge.f {
    public final /* synthetic */ String d;
    public final /* synthetic */ Class e;
    public final /* synthetic */ Object f;

    public final Class<? extends LynxModule> a() {
        return this.e;
    }

    public final String b() {
        return this.d;
    }

    public final Object c() {
        return this.f;
    }

    public b(Class r2, NativeHostServiceImpl.a r3) {
        this.d = "aiolink-message";
        this.e = r2;
        this.f = r3;
    }
}

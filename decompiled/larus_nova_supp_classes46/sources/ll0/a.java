package ll0;

import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.di.JsBridgeModule_ProvideStateObserverFactory;
import com.bytedance.android.live.browser.jsbridge.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public i.d a;
    public com.bytedance.android.live.browser.utils.b b;
    public final Map<String, Object> c;

    /* JADX INFO: renamed from: ll0.a$a, reason: collision with other inner class name */
    public static final class C0231a {
    }

    static {
    }

    public a() {
        BrowserServiceImpl.Companion.getClass();
        s20.b r0 = BrowserServiceImpl.access$getDiComponent$cp();
        r0.getClass();
        i.d r1 = JsBridgeModule_ProvideStateObserverFactory.provideStateObserver(r0.b.a);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.a = r1;
        this.c = new LinkedHashMap();
    }
}

package o5;

import com.bytedance.ai.resource.core.net.OpenPlatformNetApi;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    static {
        a = LazyKt.lazy(new d());
        b = LazyKt.lazy(new e());
        c = LazyKt.lazy(new f());
    }

    public static OpenPlatformNetApi a() {
        return (OpenPlatformNetApi) b.getValue();
    }
}

package i00;

import com.bytedance.android.live.broadcast.api.scope.service.e;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface b {
    <T extends e> T a(KClass<T> r1);

    void d(Class r1, f00.b r2);

    void f(KClass r1, f00.b r2);

    <T extends e> T getService(Class<T> r1);
}

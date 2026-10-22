package ny0;

import com.bytedance.android.live.revenue.platform.container.api.CenterServiceType;
import com.google.gson.JsonObject;
import i57.g;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a extends f80.a {

    /* JADX INFO: renamed from: ny0.a$a, reason: collision with other inner class name */
    public static final class C0280a {
        public static /* synthetic */ Object a(a r1, KClass r2) {
            return r1.x(r2, CenterServiceType.BUSINESS_SERVICE);
        }
    }

    Object A(String r1, String r2, JsonObject r3, String r4, g r5);

    void J0(com.bytedance.platform.aio.a r1);

    void a(String r1, com.bytedance.platform.aio.a r2);

    void g(com.bytedance.platform.aio.a r1);

    <T> T x(KClass<T> r1, CenterServiceType r2);
}

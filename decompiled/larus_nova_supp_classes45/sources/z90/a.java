package z90;

import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.livesdkapi.depend.message.RoomFeatureValue;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a {

    /* JADX INFO: renamed from: z90.a$a, reason: collision with other inner class name */
    public static final class C0301a {
        public static /* synthetic */ boolean a(a r1, String r2, Object r3) {
            return r1.i(r2, r3, FeatureType.DYNAMIC);
        }
    }

    public interface b {
        <T> void a(String r1, T r2);
    }

    public interface c {
        void a(List<String> r1);
    }

    void a(String r1, b r2);

    <T> T b(String r1, String r2, T r3);

    boolean c(String r1, Object r2);

    void d(String r1, Map<String, RoomFeatureValue> r2);

    boolean e(b r1, List<String> r2);

    void f(c r1);

    void g(String r1);

    <T> T getFeature(String r1, T r2);

    void h(b r1);

    boolean i(String r1, Object r2, FeatureType r3);

    void j(b r1);
}

package jf;

import android.content.Context;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.common.api.jump.model.g;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface c {

    public static final class a {
        public static void b(String r1, g r10) {
            Intrinsics.checkNotNullParameter(r1, "clickArea");
            Intrinsics.checkNotNullParameter(r10, "promotionParams");
        }

        public static Map a(String r1, Map r10) {
            Intrinsics.checkNotNullParameter(r1, "eventName");
            Intrinsics.checkNotNullParameter(r10, "eventParams");
            return MapsKt.emptyMap();
        }
    }

    void a();

    void b();

    boolean c(Context r1, com.bytedance.android.btm.api.model.d r10, boolean r11);

    void d(Context r1, com.bytedance.android.btm.api.model.d r10);

    void e(Context r1, com.bytedance.android.btm.api.model.d r10);

    void f(String r1, g r10);

    void g(String r1, ql.a r10, BtmItemBuilder r11);

    void h();

    boolean i(String r1, com.bytedance.android.btm.api.model.d r10);

    Map<String, String> j(String r1, Map<String, String> r10);

    boolean k(String r1);

    void l();

    void m();

    void n(String r1, g r10);
}

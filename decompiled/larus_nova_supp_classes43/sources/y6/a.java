package y6;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class a {
    public final String a;

    public a() {
        this.a = "default";
    }

    public Map<String, n56.c> c() {
        return MapsKt.emptyMap();
    }

    public Map<String, f.b> j() {
        return MapsKt.emptyMap();
    }

    public Map<String, g<?, ?>> m() {
        return MapsKt.emptyMap();
    }

    public String a() {
        return this.a;
    }

    public Map<String, n56.c> d(c r10) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        return MapsKt.plus(c(), e(r10));
    }

    public Map<String, n56.c> e(c r10) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        return MapsKt.emptyMap();
    }

    public Map<String, f.b> h(HybridFragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        return MapsKt.emptyMap();
    }

    public Map<String, g<?, ?>> i(HybridFragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        return MapsKt.emptyMap();
    }

    public Map<String, f.b> k(c r10) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        return MapsKt.plus(j(), l(r10));
    }

    public Map<String, f.b> l(c r10) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        return MapsKt.emptyMap();
    }

    public Map<String, g<?, ?>> n(c r10) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        return MapsKt.plus(m(), o(r10));
    }

    public Map<String, g<?, ?>> o(c r10) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        return MapsKt.emptyMap();
    }

    public Map b(FragmentActivity r10, HybridDialog r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "dialogFragment");
        return MapsKt.emptyMap();
    }

    public Map f(FragmentActivity r10, Fragment r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "fragment");
        return MapsKt.emptyMap();
    }

    public Map g(FragmentActivity r10, HybridFragment r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "fragment");
        return MapsKt.emptyMap();
    }
}

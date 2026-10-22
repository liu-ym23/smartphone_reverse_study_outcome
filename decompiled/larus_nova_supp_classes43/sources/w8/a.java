package w8;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.api.bridge.RegisterPolicy;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.bridge.method.abs.ResultCodeEnumSerializer;
import com.bytedance.android.annie.bridge.p;
import com.bytedance.android.annie.util.h;
import com.bytedance.ies.web.jsbridge2.d0;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.ies.web.jsbridge2.q;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import e7.j0;
import e7.k0;
import io.reactivex.disposables.Disposable;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class a implements c {

    /* JADX INFO: renamed from: w8.a$a, reason: collision with other inner class name */
    public static final class C0210a implements q {
        public C0210a() {
        }

        public final <T> String a(T r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
            Class<?> r0 = r10.getClass();
            if (Intrinsics.areEqual(r0, JsonObject.class) == false) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L9;
            return r10.toString();
        L9:
            if (Intrinsics.areEqual(r0, String.class) == false) goto L12;
            return r10.toString();
        L12:
            if ((r10 instanceof k0) == false) goto L15;
            GsonBuilder r11 = h.a;
            r11.registerTypeHierarchyAdapter(j0.class, new ResultCodeEnumSerializer());
            return GsonProtectorUtils.toJson(r11.create(), r10);
        L15:
            return GsonProtectorUtils.toJson(h.b, r10);
        L5:
            r1 = Intrinsics.areEqual(r0, JsonArray.class);
            goto L6
        }

        public final <T> T b(String r10, Type r11) {
            Intrinsics.checkNotNullParameter(r10, "data");
            Intrinsics.checkNotNullParameter(r11, "type");
            return (T) GsonProtectorUtils.fromJson(h.b, r10, r11);
        }
    }

    public a() {
    }

    @Override // w8.c
    public d F1(HybridFragment r1, FragmentActivity r10) {
        Intrinsics.checkNotNullParameter(r1, "fragment");
        return null;
    }

    @Override // w8.c
    public void G0(y6.e r10, FragmentActivity r11) {
        Intrinsics.checkNotNullParameter(r10, "shareInfo");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // w8.c
    public p X(FragmentActivity r10, Fragment r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "fragment");
        return null;
    }

    @Override // w8.c
    public List<Disposable> Y(Function2<? super String, Object, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "action");
        return null;
    }

    @Override // w8.c
    public d k1(ia.c r1, FragmentActivity r10) {
        Intrinsics.checkNotNullParameter(r1, "container");
        return null;
    }

    @Override // w8.c
    public void l1(d0 r10) {
        Intrinsics.checkNotNullParameter(r10, "jsBridge2");
    }

    @Override // w8.c
    public f.b w(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        return null;
    }

    @Override // w8.c
    public q n1() {
        return new C0210a();
    }

    @Override // w8.c
    public Map N(RegisterPolicy r10) {
        Intrinsics.checkNotNullParameter(r10, "registerPolicy");
        return MapsKt.emptyMap();
    }

    @Override // w8.c
    public Map<String, y6.b<? extends f<?, ?>>> provideStateFulFragmentMethods(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        return MapsKt.emptyMap();
    }

    @Override // w8.c
    public Map<String, f.b> provideDefaultStatefulMethods(d0 r1, RegisterPolicy r10) {
        Intrinsics.checkNotNullParameter(r10, "registerPolicy");
        return MapsKt.emptyMap();
    }

    @Override // w8.c
    public Map<String, g<?, ?>> provideDefaultStatelessMethods(d0 r1, RegisterPolicy r10) {
        Intrinsics.checkNotNullParameter(r10, "registerPolicy");
        return MapsKt.emptyMap();
    }

    @Override // w8.c
    public e z0(JSBridgeManager r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "jsBridgeManager");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        return new b();
    }
}

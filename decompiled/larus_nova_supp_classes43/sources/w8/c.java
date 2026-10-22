package w8;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.api.bridge.RegisterPolicy;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.bridge.p;
import com.bytedance.ies.web.jsbridge2.d0;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.ies.web.jsbridge2.q;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface c extends com.bytedance.android.annie.service.a {
    d F1(HybridFragment r1, FragmentActivity r10);

    void G0(y6.e r1, FragmentActivity r10);

    Map N(RegisterPolicy r1);

    p X(FragmentActivity r1, Fragment r10);

    List<Disposable> Y(Function2<? super String, Object, Unit> r1);

    d k1(ia.c r1, FragmentActivity r10);

    void l1(d0 r1);

    q n1();

    Map<String, f.b> provideDefaultStatefulMethods(d0 r1, RegisterPolicy r10);

    Map<String, g<?, ?>> provideDefaultStatelessMethods(d0 r1, RegisterPolicy r10);

    Map<String, y6.b<? extends f<?, ?>>> provideStateFulFragmentMethods(Fragment r1);

    f.b w(View r1);

    e z0(JSBridgeManager r1, String r10);
}

package ja2;

import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenIndividualPriorityState;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface b {

    public interface a {
        void a(f<?> r1, int r2);

        void b();

        void c(f<?> r1);
    }

    void a();

    f<?> b(Function1<? super f<?>, Boolean> r1);

    int c();

    void clearAll();

    int d();

    void e(Function1<? super f<?>, Unit> r1);

    void f(PublicScreenIndividualPriorityState r1);

    int g();

    void h(f<?> r1, boolean r2, boolean r3);

    int i();

    void j(Function1<? super f<?>, Boolean> r1);

    long k();

    List<f<?>> l(ka2.a r1);

    void m(long r1);

    void onLoad();

    void onUnload();
}

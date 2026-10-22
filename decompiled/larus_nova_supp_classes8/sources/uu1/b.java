package uu1;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import java.util.List;
import java.util.Map;
import ju1.c;
import ju1.h;
import ju1.l;
import ju1.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface b {
    <T> void a(DynamicFactor<T> r1);

    void b(List<? extends DynamicFactor<? extends Object>> r1);

    void c(iu1.b r1);

    void destroy();

    n e(String r1);

    List<DynamicFactor<?>> f();

    Map<String, n> g();

    List<l> getSceneList();

    void h(String r1);

    long i();

    List<h> j();

    void k(Function2<? super String, ? super n, Unit> r1);

    List<c<Object>> m();

    List<iu1.b> o();

    void p(String r1, Object r2);

    void prepare();

    Map<String, Object> q();
}

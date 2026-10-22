package yy0;

import android.view.View;
import com.bytedance.android.live.revenue.platform.hybrid.api.dsl.HybridDSL;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@HybridDSL
public interface g {
    void a(Function1<? super View, Unit> r1);

    void b(Function0<Unit> r1);

    void c(Function3<? super View, ? super String, ? super String, Unit> r1);

    void d(Function3<? super View, ? super Integer, ? super String, Unit> r1);

    void e(Function2<? super Integer, ? super String, Boolean> r1);

    void f(Function2<? super View, ? super Boolean, Unit> r1);

    void g(Function2<? super Integer, ? super String, Unit> r1);

    void h(Function0<Unit> r1);
}

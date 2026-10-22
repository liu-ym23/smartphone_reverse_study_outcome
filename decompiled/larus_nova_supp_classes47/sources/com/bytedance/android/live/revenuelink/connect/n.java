package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.android.livesdk.link.model.i6;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface n {
    void b(com.bytedance.android.live.revlink.impl.multianchor.utils.t r1);

    void c(i6 r1);

    void d(d11.d r1, Map<String, String> r2);

    void e(d11.c r1, Map<String, String> r2);

    Disposable f(d11.d r1, Function1<? super d11.d, Unit> r2, Function1<? super d11.d, Unit> r3, Map<String, String> r4);

    void g(d11.b r1, Map<String, String> r2);

    void h(d11.g r1, Map<String, String> r2);

    void i(com.bytedance.android.live.revlink.impl.multianchor.utils.t r1);

    void j(d11.e r1);

    void k(d11.f r1, Map<String, String> r2);
}

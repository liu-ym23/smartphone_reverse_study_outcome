package com.bytedance.android.livesdk.ktvapi.model.mv;

import com.bytedance.android.livesdk.message.model.od;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface f {
    void a(k r1);

    void b(boolean r1, Function1<? super b, Unit> r2);

    void c(Function0<Unit> r1);

    void d(String r1, int r2, boolean r3);

    NextLiveData<od> e();

    NextLiveData<List<od>> f();

    void g(od r1);

    long getMId();

    String getSingerId();

    void h();

    k i();

    NextLiveData<ArrayList<od>> j();

    void k(boolean r1, Function1<? super a, Unit> r2);

    void release();
}

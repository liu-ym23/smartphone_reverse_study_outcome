package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.p2;
import io.reactivex.Observable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface t {
    p a();

    boolean b();

    List<x> c();

    int d(int r1);

    boolean e();

    p2 f();

    void finish();

    void g(x02.d r1);

    Observable<ExtraResponse<p2, ? extends Extra>> getObservable();

    void h(r r1);

    b0 i();

    boolean isDisposed();
}

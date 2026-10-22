package gy0;

import com.bytedance.android.annie.api.data.subscribe.BaseDataObsProvider;
import com.bytedance.android.live.base.IService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.Gson;
import dy0.c;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a extends IService, c {
    void D3(Gson r1, Function1<? super BaseDataObsProvider<?>, ? extends Disposable> r2);

    void P2(DataCenter r1);

    void m5(Gson r1, DataCenter r2, Function1<? super BaseDataObsProvider<?>, ? extends Disposable> r3);
}

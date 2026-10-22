package vy0;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import wy0.f;
import wy0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface c extends f80.a, dy0.c, b {
    Observable<g> B0(String r1);

    e J8(Context r1, Uri r2, Function1 r3);

    Disposable O3(f r1);

    Uri Q(String r1);

    HybridDialogImpl U0(Context r1, Uri r2, Function1 r3);

    com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a Ui(Context r1, Uri r2, Object r3, Function1 r4);

    void addHybridDebugTool(Context r1, ViewGroup r2, String r3, boolean r4);

    String appendFeedCommonParams(String r1, IRoom r2);

    void j1(Context r1, String r2);

    HybridDialogImpl mg(Context r1, Uri r2, Function1 r3);

    com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a q8(Context r1, Uri r2, Function1 r3);

    void sendEventToAllJsBridges(String r1, Object r2);

    void tn(zy0.b r1);

    Single<String> v8(String r1, Context r2);

    void x6(Context r1, String r2, Function1<? super yy0.e, Unit> r3);
}

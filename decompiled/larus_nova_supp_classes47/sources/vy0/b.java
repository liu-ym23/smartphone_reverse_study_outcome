package vy0;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.scope.o;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;
import wy0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b extends f80.a, o {
    Observable<g> B0(String r1);

    Disposable Sb(wy0.d r1);

    HybridDialogImpl U0(Context r1, Uri r2, Function1 r3);

    String appendCommonParams(String r1);

    void sendEventToAllJsBridges(String r1, Object r2);
}

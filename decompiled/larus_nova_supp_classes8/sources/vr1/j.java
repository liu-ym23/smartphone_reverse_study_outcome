package vr1;

import android.content.Context;
import android.net.Uri;
import android.view.Window;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.live.lynx.api.Jsb2MethodFinder;
import com.bytedance.android.livesdk.interactivity.interactive.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IBannerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface j {
    Jsb2MethodFinder A();

    Uri E(Uri r1, DataCenter r2);

    Disposable F(Function1<? super String, Unit> r1);

    Map<String, String> I(DataCenter r1);

    v61.a J(DataCenter r1, boolean r2, Function0 r3, Function0 r4);

    void K();

    <P, R> void a(Object r1, String r2, com.bytedance.ies.web.jsbridge2.g<P, R> r3);

    AnnieXWebKit c(Context r1, Uri r2, Object r3, Map r4, Function1 r5, Function2 r6);

    SSWebView d(Object r1);

    void dataMapping(String r1, String r2, Map<String, String> r3);

    void f(j0 r1);

    com.bytedance.live.datacontext.m<Boolean> g(DataCenter r1);

    HybridCard getHybridCard(Context r1, Uri r2, b7.a r3);

    MutableLiveData<String> getSeiUpdate();

    boolean h();

    void i(Object r1, Object r2);

    void j(DataCenter r1, CompositeDisposable r2, Function0<Unit> r3);

    void k(DataCenter r1, IRoom r2, km1.a r3, LifecycleOwner r4, Function1<? super IBannerInfo, Unit> r5, Function1<? super Throwable, Unit> r6, Function0<Unit> r7);

    void n(Object r1);

    void o(DataCenter r1);

    boolean q();

    void s(Object r1);

    void w(Window r1);

    void x(Object r1, String r2, Object r3);

    com.bytedance.live.datacontext.m<Boolean> y(DataCenter r1);
}

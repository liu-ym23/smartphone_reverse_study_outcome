package yr1;

import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.model.SendReplayTextEvent;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface g {
    void A(String r1, long r2, String r4);

    Disposable E(Function1<Object, Unit> r1);

    void F(DataCenter r1);

    void I();

    void J(boolean r1);

    Disposable K(Function4<? super Boolean, ? super Integer, ? super String, ? super Boolean, Unit> r1);

    void a(Episode r1, Map<String, String> r2);

    void c(long r1, String r3, Bundle r4);

    void d(LifecycleOwner r1, Function0<Unit> r2);

    void f();

    Disposable g(Function1<? super vk1.a, Unit> r1);

    Disposable h(Function5<? super Integer, ? super Integer, ? super Integer, ? super String, Object, Unit> r1);

    void i(LifecycleOwner r1, Function1<? super Uri, Unit> r2);

    void j(String r1, SendReplayTextEvent.Sender r2, Map<String, ? extends Object> r3);

    Disposable k(Function1<? super String, Unit> r1);

    Disposable n(Function6<? super Long, ? super String, ? super Bundle, ? super String, ? super Boolean, ? super Boolean, Unit> r1);

    void o();

    void q(LifecycleOwner r1, Function3<? super Integer, ? super Integer, ? super KeyEvent, Unit> r2);

    Disposable s(Function1<? super SendReplayTextEvent, Unit> r1);

    void w();

    void x(int r1, KeyEvent r2);

    void y(SendReplayTextEvent r1, boolean r2);
}

package ec0;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a {
    boolean a();

    boolean b();

    long c();

    void clearData();

    boolean d();

    MusicPanel e();

    void f(LifecycleOwner r1, Observer<Boolean> r2);

    boolean g();

    boolean h();

    void i();

    void j();

    void k();

    boolean l();

    void m(MusicPanel r1);

    Disposable n(Consumer<fd2.a> r1);

    long o();

    void p(LifecycleOwner r1, Observer<Boolean> r2);

    void q(boolean r1);

    void r(LifecycleOwner r1, Observer<Boolean> r2);

    void s(Context r1);
}

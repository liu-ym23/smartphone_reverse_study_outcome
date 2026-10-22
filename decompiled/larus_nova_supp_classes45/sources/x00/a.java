package x00;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a {
    IVoiceLiveTheme a(int r1);

    void c(IVoiceLiveTheme r1, int r2);

    void d(long r1, IVoiceLiveTheme r3);

    int e();

    void f(Observer<IVoiceLiveTheme> r1, int r2);

    void g(int r1, Function2<? super List<? extends IVoiceLiveTheme>, ? super Boolean, Unit> r2);

    void h(int r1);

    String[] i();

    void j(LifecycleOwner r1, Observer<IVoiceLiveTheme> r2, int r3);

    void k(int r1, long r2, Function2 r4);

    void l(int r1);

    void m(long r1, IVoiceLiveTheme r3, int r4);

    boolean n(int r1);

    boolean o(int r1);

    void p(LifecycleOwner r1, Observer<ArrayList<IVoiceLiveTheme>> r2, int r3);

    IVoiceLiveTheme q(int r1);

    String[] s();
}

package fd2;

import android.graphics.RectF;
import com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.KtvScrollLyricViewV2;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface l {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    public static final class b {
        public static /* synthetic */ void a(l r0, long r1, boolean r3, int r4) {
            if ((r4 & 2) == 0) goto L5;
            r3 = false;
        L5:
            r0.r(r1, r3, null);
        }
    }

    static {
        a = a.a;
    }

    void a();

    long b(int r1);

    void c(Function2<? super Integer, ? super Integer, Unit> r1);

    void d(Function1<? super g0, Unit> r1);

    void e(int r1, int r2);

    Long f();

    void g(Function2<? super Integer, ? super Integer, Unit> r1);

    KtvScrollLyricViewV2 getRenderView();

    int h();

    int i(long r1);

    com.bytedance.android.livesdk.ktvapi.config.a j();

    void k(a0 r1);

    long l(int r1);

    void m(int r1, int r2);

    void n(boolean r1);

    void o(RectF r1, int r2);

    void p();

    List<Object> q();

    void r(long r1, boolean r3, Boolean r4);

    void reset();

    int s(Integer r1, Long r2);
}

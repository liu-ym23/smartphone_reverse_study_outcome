package o1c;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.preload.v2.condition.ConditionSet;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface c<P, T> extends Runnable, Comparable<c<?, ?>> {

    public interface a {
        void b(c<?, ?> r1, int r2, Map<String, ? extends Object> r3);

        void e(c<?, ?> r1, int r2);

        void g(c<?, ?> r1);

        void k(c r1, boolean r2, Map r3);

        void m(c r1, Map r2);
    }

    ConditionSet C1();

    void J0(e1c.a r1);

    void J1(P r1, IGetDataCallback<?> r2);

    void K(e1c.d r1);

    void L(ConditionSet r1);

    long L0();

    void N0(boolean r1);

    d R();

    void S(int r1);

    boolean T0();

    void b0(IGetDataCallback<?> r1);

    void e1(ConditionSet r1);

    int f0();

    Biz getBiz();

    int getPriority();

    String getTaskId();

    void h1(P r1);

    boolean isInterrupted();

    Object j(Object r1);

    void k(boolean r1);

    void o0(ConditionSet r1);

    ConditionSet p0();

    void s1();

    void setPriority(int r1);

    ConditionSet w0();

    void y0(long r1);
}

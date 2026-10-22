package e6b;

import android.graphics.Point;
import com.ss.android.lark.blueprint.i;
import com.ss.android.lark.blueprint.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b<Data> {

    public interface a<Data, Cell extends m<Data>> {
        boolean c(Cell r1, Data r2, Point r3);

        void d(Cell r1, Data r2);

        void h(Cell r1, Data r2, Point r3);
    }

    boolean e(i<?, ?> r1, Data r2);

    void f(i<?, ?> r1, Data r2);

    void j(i<?, ?> r1, Data r2);
}

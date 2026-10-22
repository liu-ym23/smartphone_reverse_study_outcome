package lf6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public static final /* synthetic */ int b = 0;
    public final List<c> a;

    public static final class a {
        public final List<c> a;

        public a() {
            this.a = new ArrayList();
        }
    }

    public static final class b {
    }

    static {
    }

    public d(List r1) {
        this.a = r1;
    }

    public final void a(Function1<? super c, Unit> r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.invoke(r0.next());
        goto L4
    }
}

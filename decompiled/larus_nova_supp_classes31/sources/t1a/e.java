package t1a;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import t1a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface e<T extends c> {

    public static final class a {
        public static /* synthetic */ void a(e r1, boolean r2, Function1 r3) {
            r1.b(new d(), r2, r3);
        }
    }

    void a(Function1<? super T, ? extends T> r1);

    void b(Function2<? super T, ? super T, Boolean> r1, boolean r2, Function1<? super T, Unit> r3);

    void destroy();

    T getSource();
}

package yy8;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static final void a(Ref.BooleanRef r1, Ref.ObjectRef r2, Function0 r3) {
        if (r1.element == true) goto L10;
        r1.element = true;
        Function0 r4 = (Function0) r2.element;
        r2.element = null;
        if (r4 == null) goto L8;
        r4.invoke();
    L8:
        r3.invoke();
        return;
    }
}

package yda;

import com.obric.assistant.IObricAvailableManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static final void a(b r2, Function1<? super b, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "block");
        IObricAvailableManager.a.getClass();
        IObricAvailableManager r0 = IObricAvailableManager.a.a();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.a() != true) goto L7;
    L8:
        if (r1 == false) goto L11;
        r3.invoke(r2);
        return;
    L11:
        return;
    L7:
        r1 = false;
        goto L8
    }
}

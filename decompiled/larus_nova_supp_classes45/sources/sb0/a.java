package sb0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements InvocationHandler {
    public b a;

    public a() {
        this.a = null;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r3, Method r4, Object[] r5) {
        b r6 = this.a;
        if (r6 != null) goto L6;
        return null;
    L6:
        if (r5 == null) goto L13;
        if (r4 == null) goto L9;
        Object r7 = r4.invoke(r6, new Object[]{this});
    L10:
        if (r7 == null) goto L13;
        return r7;
    L9:
        r7 = null;
    L13:
        if (r4 != null) goto L15;
        return null;
    L15:
        return r4.invoke(this.a, new Object[0]);
    }
}

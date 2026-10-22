package kotlinx.coroutines.android;

import android.os.Build;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends AbstractCoroutineContextElement implements h0 {
    private volatile Object _preHandler;

    public b() {
        super(h0.f10523d);
        this._preHandler = this;
    }

    private final Method c0() {
        Object r10 = this._preHandler;
        if (r10 != this) goto L5;
        Method r11 = null;
        boolean r12 = false;
        Method r13 = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);     // Catch: Throwable -> L16
        if (Modifier.isPublic(r13.getModifiers()) == false) goto L12;
        if (Modifier.isStatic(r13.getModifiers()) == false) goto L12;
        r12 = true;
    L12:
        if (r12 == false) goto L14;
        r11 = r13;
    L14:
        this._preHandler = r11;
        return r11;
    L5:
        return (Method) r10;
    }

    @Override // kotlinx.coroutines.h0
    public void V(CoroutineContext r10, Throwable r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (26 <= r12) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L19;
        Method r14 = c0();
        Thread.UncaughtExceptionHandler r15 = null;
        if (r14 == null) goto L12;
        Object r16 = r14.invoke(null, new Object[0]);
    L14:
        if ((r16 instanceof Thread.UncaughtExceptionHandler) == false) goto L16;
        r15 = (Thread.UncaughtExceptionHandler) r16;
    L16:
        if (r15 == null) goto L20;
        r15.uncaughtException(Thread.currentThread(), r11);
        return;
    L20:
        return;
    L12:
        r16 = null;
        goto L14
    L19:
        return;
    L5:
        if (r12 >= 28) goto L7;
        r13 = true;
        goto L8
    }
}

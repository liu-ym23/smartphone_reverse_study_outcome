package kotlinx.coroutines.android;

import android.os.Build;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    private volatile Object _preHandler;

    public b() {
        super(CoroutineExceptionHandler.Key);
        this._preHandler = this;
    }

    public void handleException(CoroutineContext r6, Throwable r7) {
        int r8 = Build.VERSION.SDK_INT;
        boolean r1 = true;
        if (26 <= r8) goto L5;
    L7:
        boolean r9 = false;
    L8:
        if (r9 == false) goto L34;
        Object r10 = this._preHandler;
        Thread.UncaughtExceptionHandler r0 = null;
        if (r10 == this) goto L32;
        Method r11 = (Method) r10;
    L22:
        if (r11 == null) goto L24;
        Object r12 = r11.invoke(null, new Object[0]);
    L26:
        if ((r12 instanceof Thread.UncaughtExceptionHandler) == false) goto L28;
        r0 = (Thread.UncaughtExceptionHandler) r12;
    L28:
        if (r0 == null) goto L35;
        r0.uncaughtException(ThreadMethodProxy.currentThread(), r7);
        return;
    L35:
        return;
    L24:
        r12 = null;
        goto L26
    L32:
        r11 = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);     // Catch: Throwable -> L31
        if (Modifier.isPublic(r11.getModifiers()) == false) goto L17;
        if (Modifier.isStatic(r11.getModifiers()) == false) goto L17;
    L18:
        if (r1 == false) goto L20;
    L21:
        this._preHandler = r11;
    L17:
        r1 = false;
    L20:
        r11 = null;
        goto L21
    L34:
        return;
    L5:
        if (r8 >= 28) goto L7;
        r9 = true;
        goto L8
    }
}

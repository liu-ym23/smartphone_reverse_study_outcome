package kotlinx.coroutines.android;

import android.os.Build;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/android/AndroidExceptionPreHandler;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "_preHandler", "", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "preHandler", "Ljava/lang/reflect/Method;", "kotlinx-coroutines-android"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AndroidExceptionPreHandler extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    private volatile Object _preHandler;

    public AndroidExceptionPreHandler() {
        super((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(CoroutineExceptionHandler.f17198b, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
        this._preHandler = this;
    }

    private final Method preHandler() {
        Object r0 = this._preHandler;
        if (r0 != this) goto L5;
        Method r1 = null;
        boolean r3 = false;
        Method r2 = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);     // Catch: Throwable -> L16
        if (Modifier.isPublic(r2.getModifiers()) == false) goto L12;
        if (Modifier.isStatic(r2.getModifiers()) == false) goto L12;
        r3 = true;
    L12:
        if (r3 == false) goto L14;
        r1 = r2;
    L14:
        this._preHandler = r1;
        return r1;
    L5:
        return (Method) ZeusTransformUtils.preCheckCast(r0, Method.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext r4, Throwable r5) {
        CoroutineContext r6 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
        int r7 = Build.VERSION.SDK_INT;
        if (26 <= r7) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r8 == false) goto L19;
        Method r3 = preHandler();
        Thread.UncaughtExceptionHandler r9 = null;
        if (r3 == null) goto L12;
        Object r10 = r3.invoke(null, new Object[0]);
    L14:
        if (ZeusTransformUtils.instanceOf(r10, Thread.UncaughtExceptionHandler.class) == false) goto L16;
        r9 = (Thread.UncaughtExceptionHandler) ZeusTransformUtils.preCheckCast(r10, Thread.UncaughtExceptionHandler.class, "com.obric.memorydata.plugin");
    L16:
        if (r9 == null) goto L20;
        r9.uncaughtException(Thread.currentThread(), r5);
        return;
    L20:
        return;
    L12:
        r10 = null;
        goto L14
    L19:
        return;
    L5:
        if (r7 >= 28) goto L7;
        r8 = true;
        goto L8
    }
}

package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public abstract class x {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final CoroutineContext a(CoroutineContext r5, CoroutineContext r10, boolean r11) {
        Boolean r12 = Boolean.FALSE;
        boolean r13 = ((Boolean) r5.fold(r12, new com.bytedance.ai.applet.components.view.a(1))).booleanValue();
        boolean r14 = ((Boolean) r10.fold(r12, new com.bytedance.ai.applet.components.view.a(1))).booleanValue();
        if (r13 == true) goto L7;
        if (r14 == true) goto L7;
        return r5.plus(r10);
    L7:
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        r15.element = r10;
        EmptyCoroutineContext r16 = EmptyCoroutineContext.INSTANCE;
        CoroutineContext r17 = (CoroutineContext) r5.fold(r16, new com.bytedance.ai.applet.components.view.a(2));
        if (r14 == false) goto L11;
        r15.element = ((CoroutineContext) r15.element).fold(r16, new com.bytedance.ai.applet.components.view.a(3));
    L11:
        return r17.plus((CoroutineContext) r15.element);
    }

    public static final CoroutineContext b(CoroutineScope r5, CoroutineContext r10) {
        CoroutineContext r11 = a(r5.getCoroutineContext(), r10, true);
        if (r11 != Dispatchers.getDefault()) goto L5;
        return r11;
    L5:
        if (r11.get(ContinuationInterceptor.Key) == null) goto L7;
        return r11;
    L7:
        return r11.plus(Dispatchers.getDefault());
    }

    public static final g2 c(Continuation r5, CoroutineContext r10, Object r11) {
        g2 r12 = null;
        if ((r5 instanceof CoroutineStackFrame) == true) goto L6;
        return null;
    L6:
        if (r10.get(h2.f18923a) == null) goto L19;
        CoroutineStackFrame r13 = (CoroutineStackFrame) r5;
    L9:
        if ((r13 instanceof p0) == true) goto L17;
        r13 = r13.getCallerFrame();
        if (r13 == null) goto L17;
        if ((r13 instanceof g2) == false) goto L9;
        r12 = (g2) r13;
    L17:
        if (r12 == null) goto L19;
        r12.e0(r10, r11);
    L19:
        return r12;
    }
}

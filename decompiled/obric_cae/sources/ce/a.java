package ce;

import com.qualcomm.qti.qesdk.QesdkUtils;
import he.i;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements ae.d<Object>, d, Serializable {
    private final ae.d<Object> completion;

    public a(ae.d<Object> r8) {
        this.completion = r8;
    }

    public ae.d<j> create(ae.d<?> r8) {
        i.f(r8, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // ce.d
    public d getCallerFrame() {
        ae.d<Object> r8 = this.completion;
        if ((r8 instanceof d) == true) goto L7;
        return null;
    L7:
        return (d) r8;
    }

    public final ae.d<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        e r8 = (e) getClass().getAnnotation(e.class);
        String r10 = null;
        if (r8 == null) goto L58;
        int r11 = r8.v();
        if (r11 > 1) goto L53;
        int r12 = -1;
        Field r13 = getClass().getDeclaredField("label");     // Catch: Exception -> L17
        r13.setAccessible(true);     // Catch: Exception -> L17
        Object r14 = r13.get(this);     // Catch: Exception -> L17
        if ((r14 instanceof Integer) == false) goto L11;
        Integer r15 = (Integer) r14;     // Catch: Exception -> L17
    L12:
        if (r15 == null) goto L15;
        int r16 = r15.intValue();     // Catch: Exception -> L17
    L16:
        int r17 = r16 - 1;
    L18:
        if (r17 < 0) goto L21;
        r12 = r8.l()[r17];
    L21:
        f.a r18 = f.f3446b;
        f.a r19 = f.f3445a;
        if (r18 == null) goto L56;
    L26:
        if (r18 == r19) goto L47;
        Method r20 = r18.f3447a;
        if (r20 == null) goto L31;
        Object r110 = r20.invoke(getClass(), new Object[0]);
    L32:
        if (r110 == null) goto L47;
        Method r21 = r18.f3448b;
        if (r21 == null) goto L37;
        Object r111 = r21.invoke(r110, new Object[0]);
    L38:
        if (r111 == null) goto L47;
        Method r22 = r18.f3449c;
        if (r22 == null) goto L43;
        Object r112 = r22.invoke(r111, new Object[0]);
    L45:
        if ((r112 instanceof String) == false) goto L47;
        r10 = (String) r112;
        goto L47
    L43:
        r112 = null;
        goto L45
    L37:
        r111 = null;
        goto L38
    L31:
        r110 = null;
    L47:
        if (r10 != null) goto L49;
        String r113 = r8.c();
    L51:
        return new StackTraceElement(r113, r8.m(), r8.f(), r12);
    L49:
        r113 = r10 + '/' + r8.c();
        goto L51
    L56:
        f.a r23 = new f.a(Class.class.getDeclaredMethod("getModule", new Class[0]), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(QesdkUtils.TAGS.JSON_TAG_NAME, new Class[0]));     // Catch: Exception -> L25
        f.f3446b = r23;     // Catch: Exception -> L25
        r18 = r23;
    L25:
        f.f3446b = r19;
        r18 = r19;
        goto L26
    L15:
        r16 = 0;
        goto L16
    L11:
        r15 = null;
    L17:
        r17 = -1;
        goto L18
    L53:
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + r11 + ". Please update the Kotlin standard library.").toString());
    L58:
        return null;
    }

    public abstract Object invokeSuspend(Object r8);

    public void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // ae.d
    public final void resumeWith(Object r8) {
    L2:
        a r10 = (a) r2;
        ae.d<Object> r11 = r10.completion;
        i.c(r11);
        r8 = r10.invokeSuspend(r8);     // Catch: Throwable -> L6
        if (r8 == be.a.f3165a) goto L5;
    L8:
        r10.releaseIntercepted();
        if ((r11 instanceof a) == false) goto L11;
        ?? r12 = r11;
        goto L2
    L11:
        r11.resumeWith(r8);
        return;
    L5:
        return;
    L6:
        th = move-exception;
        r8 = defpackage.c.D(th);
        goto L8
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("Continuation at ");
        Object r10 = getStackTraceElement();
        if (r10 != null) goto L6;
        r10 = getClass().getName();
    L6:
        r8.append(r10);
        return r8.toString();
    }

    public ae.d<j> create(Object r8, ae.d<?> r10) {
        i.f(r10, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}

package ai;

import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile CopyOnWriteArrayList f212i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bi.a f214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f215c;
    public final List d;
    public final List e;
    public final Executor f;
    public final h.a g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArrayList f216h;

    public h0(k r5, bi.a r10, CopyOnWriteArrayList r11, ArrayList r12, ArrayList r13, h.a r14, Executor r15) {
        this.f213a = new ConcurrentHashMap();
        this.f215c = r5;
        this.f214b = r10;
        this.f216h = r11;
        this.d = Collections.unmodifiableList(r12);
        this.e = Collections.unmodifiableList(r13);
        this.g = r14;
        this.f = r15;
    }

    public final e a(Type r5, Annotation[] r10) {
        w0.b(r5, "returnType == null");
        w0.b(r10, "annotations == null");
        List r11 = this.e;
        int r12 = r11.indexOf(null) + 1;
        int r13 = r11.size();
        int r14 = r12;
    L3:
        if (r14 >= r13) goto L8;
        e r15 = ((d) r11.get(r14)).a(r5);
        if (r15 != null) goto L6;
        r14 = r14 + 1;
        goto L3
    L6:
        return r15;
    L8:
        StringBuilder r16 = new StringBuilder("Could not locate call adapter for ");
        r16.append(r5);
        r16.append(".\n  Tried:");
        int r17 = r11.size();
    L9:
        if (r12 >= r17) goto L12;
        r16.append("\n   * ");
        r16.append(((d) r11.get(r12)).getClass().getName());
        r12 = r12 + 1;
        goto L9
    L12:
        throw new IllegalArgumentException(r16.toString());
    }

    public final Object b(Class r5) {
        if (r5.isInterface() == false) goto L11;
        if (r5.getInterfaces().length > 0) goto L9;
        return Proxy.newProxyInstance(r5.getClassLoader(), new Class[]{r5}, new f0(this, r5));
    L9:
        throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
    L11:
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    public final i c(Type r5, Annotation[] r10, Annotation[] r11) {
        w0.b(r5, "type == null");
        w0.b(r11, "methodAnnotations == null");
        List r12 = this.d;
        int r13 = r12.indexOf(null) + 1;
        int r14 = r12.size();
        int r15 = r13;
    L3:
        if (r15 >= r14) goto L8;
        i r16 = ((h) r12.get(r15)).c(r5);
        if (r16 != null) goto L6;
        r15 = r15 + 1;
        goto L3
    L6:
        return r16;
    L8:
        StringBuilder r17 = new StringBuilder("Could not locate RequestBody converter for ");
        r17.append(r5);
        r17.append(".\n  Tried:");
        int r18 = r12.size();
    L9:
        if (r13 >= r18) goto L12;
        r17.append("\n   * ");
        r17.append(((h) r12.get(r13)).getClass().getName());
        r13 = r13 + 1;
        goto L9
    L12:
        throw new IllegalArgumentException(r17.toString());
    }

    public final i d(Type r5, Annotation[] r10) {
        w0.b(r5, "type == null");
        w0.b(r10, "annotations == null");
        List r11 = this.d;
        int r12 = r11.indexOf(null) + 1;
        int r13 = r11.size();
        int r14 = r12;
    L3:
        if (r14 >= r13) goto L8;
        i r15 = ((h) r11.get(r14)).d(r5, r10);
        if (r15 != null) goto L6;
        r14 = r14 + 1;
        goto L3
    L6:
        return r15;
    L8:
        StringBuilder r16 = new StringBuilder("Could not locate TypeInput converter for ");
        r16.append(r5);
        r16.append(".\n  Tried:");
        int r17 = r11.size();
    L9:
        if (r12 >= r17) goto L12;
        r16.append("\n   * ");
        r16.append(((h) r11.get(r12)).getClass().getName());
        r12 = r12 + 1;
        goto L9
    L12:
        throw new IllegalArgumentException(r16.toString());
    }

    public final i e(Type r5, Annotation[] r10) {
        w0.b(r5, "type == null");
        List r11 = this.d;
        int r12 = r11.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        i r14 = ((h) r11.get(r13)).e(r5);
        if (r14 != null) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L9:
        return a.f175i;
    }
}

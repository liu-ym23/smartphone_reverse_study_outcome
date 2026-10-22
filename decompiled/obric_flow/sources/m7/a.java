package m7;

import com.bytedance.apm.j;
import com.bytedance.geckox.c;
import java.util.concurrent.CopyOnWriteArrayList;
import n7.b;
import n7.d;
import n7.e;
import n7.f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f20019a = 0;

    static {
        if (r7.a.a(s7.a.class) != null) goto L13;
        c r5 = new c();
        r5.f4740a = false;
        r5.f4741b = false;
        e r10 = new e(r5, 0);
        new e(r5, 1);
        f r11 = new f(r5, 6);
        r11.f20210c = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        r11.d = new n7.a(r11);
        n7.c r12 = new n7.c(r5, 6);
        r12.f20208c = new b(r12, 120000, r5);
        d r13 = new d(r5, 6);
        if (r5.f4741b == true) goto L11;
        r5.d = r10;
        r5.e = r13;
        boolean r14 = j.f3887a;     // Catch: Throwable -> L14
    L9:
        r5.f4741b = true;
    L11:
        throw null;
    L13:
        throw new ClassCastException();
    }
}

package cc2;

import cc2.o;
import com.bytedance.android.live.core.log.ALogger;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class p<T extends o> {
    public final Set<T> a;
    public final Set<T> b;
    public boolean c;
    public final boolean d;
    public final n<T> e;

    public static final class a {
    }

    static {
    }

    public abstract Set<T> b();

    public abstract Set<T> c();

    public final void d() {
        this.a.clear();
        this.b.clear();
        a(null, null);
    }

    public p(boolean r2, n<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.d = r2;
        this.e = r3;
        this.a = new LinkedHashSet();
        this.b = new LinkedHashSet();
        this.c = r2;
    }

    public final void a(T r5, Boolean r6) {
        boolean r1 = true;
        if ((!this.b.isEmpty()) == false) goto L6;
        r1 = false;
    L10:
        if (r1 == this.c) goto L23;
        this.c = r1;
        StringBuilder r0 = new StringBuilder();
        String r2 = null;
        if (r5 == null) goto L14;
        String r3 = r5.a();
    L15:
        r0.append(r3);
        r0.append("'s visibility turn to ");
        r0.append(r1);
        r0.append(", cause ");
        if (r5 == null) goto L18;
        r2 = r5.b();
    L18:
        r0.append(r2);
        r0.append(" status turn to ");
        r0.append(r6);
        ALogger.i("VisibilityHelperLogger", r0.toString());
        if (r1 == false) goto L21;
        this.e.a(r5, r6);
        return;
    L21:
        this.e.b(r5, r6);
        return;
    L14:
        r3 = null;
        goto L15
    L23:
        return;
    L6:
        if ((!this.a.isEmpty()) == true) goto L10;
        r1 = this.d;
        goto L10
    }

    public final void e(T r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "factor");
        if (b().contains(r2) == false) goto L6;
        Set<T> r0 = this.b;
    L8:
        if (r3 == false) goto L10;
        r0.add(r2);
    L11:
        a(r2, Boolean.valueOf(r3));
        return;
    L10:
        r0.remove(r2);
        goto L11
    L6:
        if (c().contains(r2) == false) goto L13;
        r0 = this.a;
        goto L8
    }
}

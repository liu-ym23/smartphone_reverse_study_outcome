package k1c;

import android.content.Context;
import com.ss.android.lark.log.Log;
import e1c.d;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class a<T> implements b<T> {
    public final Set<g1c.b<T>> a;
    public e1c.b b;
    public final String c;

    /* JADX INFO: renamed from: k1c.a$a, reason: collision with other inner class name */
    public static final class C0160a {
    }

    static {
    }

    public abstract T n();

    public a() {
        this.a = Collections.newSetFromMap(new ConcurrentHashMap());
        this.c = getClass().getSimpleName();
    }

    @Override // k1c.b
    public final void h(g1c.b<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "condition");
        this.a.add(r2);
        o(n());
    }

    public final void o(T r9) {
        HashSet r0 = new HashSet();
        HashSet r1 = new HashSet();
        HashSet r2 = new HashSet();
        HashSet r3 = new HashSet();
        Iterator<T> r4 = this.a.iterator();
    L4:
        if (r4.hasNext() == false) goto L20;
        g1c.b r5 = (g1c.b) r4.next();
        r5.setValue(r9);
        if (r5.c() == false) goto L4;
        if (r5.isValid() == false) goto L4;
        if ((r5 instanceof i1c.a) == true) goto L11;
        if ((r5 instanceof h1c.a) == false) goto L4;
        h1c.a r6 = (h1c.a) r5;
        if (r6.isInterrupted() == true) goto L16;
        if (r6.d() == false) goto L4;
        r2.add(r5);
        goto L4
    L16:
        r1.add(r5);
        goto L4
    L11:
        r0.add(r5);
        goto L4
    L20:
        e1c.b r7 = null;
        if ((!r0.isEmpty()) == false) goto L27;
        e1c.b r8 = this.b;
        if (r8 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadManager");
        r8 = null;
    L25:
        r8.f(r0);
    L27:
        if ((!r1.isEmpty()) == false) goto L33;
        e1c.b r10 = this.b;
        if (r10 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadManager");
        r10 = null;
    L31:
        r10.i(r1);
    L33:
        if ((!r2.isEmpty()) == false) goto L39;
        e1c.b r11 = this.b;
        if (r11 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadManager");
        r11 = null;
    L37:
        r11.a(r2);
    L39:
        if ((!r3.isEmpty()) == false) goto L45;
        e1c.b r12 = this.b;
        if (r12 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadManager");
    L44:
        r7.h(r3);
        goto L45
    L43:
        r7 = r12;
    L45:
        Log.d("AbsDetector", "onConditionChanged:" + this.c + ", value:" + r9 + ", triggerCondition:" + r0.size() + ", interruptCondition:" + r1.size() + ", recoverCondition:" + r2.size() + ", cleanCondition:" + r3.size());
    }

    @Override // k1c.b
    public void j(Context r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "manager");
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r3;
    }
}

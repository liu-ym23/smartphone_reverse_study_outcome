package l50;

import java.util.ArrayList;
import java.util.Iterator;
import k50.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import m50.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements b {
    public final ArrayList<b> a;
    public boolean b;
    public Function0<Unit> c;

    public a() {
        this.a = new ArrayList();
    }

    @Override // l50.b
    public final boolean isFinished() {
        return this.b;
    }

    public final void b(b r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.add(r2);
        this.b = false;
    }

    @Override // l50.b
    public final boolean a(f r4, d r5, n50.b r6) {
        Intrinsics.checkNotNullParameter(r4, "rendererParams");
        Intrinsics.checkNotNullParameter(r5, "modelParams");
        Intrinsics.checkNotNullParameter(r6, "sceneParams");
        Iterator<b> r0 = this.a.iterator();
        boolean r1 = true;
    L4:
        if (r0.hasNext() == false) goto L9;
        b r2 = r0.next();
        r2.a(r4, r5, r6);
        if (r2.isFinished() == true) goto L4;
        r1 = false;
        goto L4
    L9:
        this.b = r1;
        if (r1 == false) goto L15;
        Function0<Unit> r7 = this.c;
        if (r7 == null) goto L15;
        Unit r8 = (Unit) r7.invoke();
    L15:
        return this.b;
    }
}

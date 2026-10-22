package f1;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f7295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f7296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<h> f7297c;

    @Deprecated
    public n() {
        this.f7295a = new HashMap();
        this.f7297c = new ArrayList();
    }

    public final boolean equals(Object r8) {
        if ((r8 instanceof n) == false) goto L10;
        n r10 = (n) r8;
        View r11 = r10.f7296b;
        if (this.f7296b == r11) goto L7;
        return false;
    L7:
        if (this.f7295a.equals(r10.f7295a) == false) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public final int hashCode() {
        int r8 = this.f7296b.hashCode() * 31;
        return this.f7295a.hashCode() + r8;
    }

    public final String toString() {
        StringBuilder r8 = android.aimedia.a.k("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        r8.append(this.f7296b);
        r8.append("\n");
        String r10 = defpackage.a.e(r8.toString(), "    values:");
        HashMap r11 = this.f7295a;
        Iterator r12 = r11.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        String r13 = (String) r12.next();
        r10 = r10 + "    " + r13 + ": " + r11.get(r13) + "\n";
        goto L4
    L6:
        return r10;
    }

    public n(View r8) {
        this.f7295a = new HashMap();
        this.f7297c = new ArrayList();
        this.f7296b = r8;
    }
}

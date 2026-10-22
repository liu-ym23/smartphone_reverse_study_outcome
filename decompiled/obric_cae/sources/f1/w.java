package f1;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: loaded from: classes.dex */
public final class w implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowId f7315a;

    public w(View r8) {
        this.f7315a = r8.getWindowId();
    }

    public final boolean equals(Object r8) {
        if ((r8 instanceof w) == true) goto L5;
    L7:
        return false;
    L5:
        if (((w) r8).f7315a.equals(this.f7315a) == false) goto L7;
        return true;
    }

    public final int hashCode() {
        return this.f7315a.hashCode();
    }
}

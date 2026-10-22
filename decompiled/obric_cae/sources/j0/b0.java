package j0;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class b0 implements me.b<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f8374a;

    public b0(ViewGroup r8) {
        this.f8374a = r8;
    }

    @Override // me.b
    public final Iterator<View> iterator() {
        ViewGroup r8 = this.f8374a;
        he.i.f(r8, "<this>");
        return new c0(r8);
    }
}

package or9;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;
import pr9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements h {
    public final Fragment a;

    @Override // pr9.h
    public final void N7() {
    }

    @Override // pr9.h
    public final void V5() {
    }

    @Override // pr9.h
    public final boolean onBackPressed() {
        return false;
    }

    @Override // pr9.h
    public final void xQ(pr9.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public b() {
        this.a = new Fragment();
    }

    @Override // pr9.h
    public final Fragment f() {
        return this.a;
    }
}

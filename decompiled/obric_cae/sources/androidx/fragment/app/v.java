package androidx.fragment.app;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class v extends androidx.lifecycle.h0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f2051j = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Fragment> f2052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, v> f2053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, androidx.lifecycle.k0> f2054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2057i;

    public class a implements androidx.lifecycle.i0.b {
        @Override // androidx.lifecycle.i0.b
        public final <T extends androidx.lifecycle.h0> T a(Class<T> r8) {
            return new v(true);
        }
    }

    static {
        f2051j = new a();
    }

    public v(boolean r8) {
        this.f2052d = new HashMap();
        this.f2053e = new HashMap();
        this.f2054f = new HashMap();
        this.f2056h = false;
        this.f2057i = false;
        this.f2055g = r8;
    }

    @Override // androidx.lifecycle.h0
    public final void b() {
        if (FragmentManager.G(3) == false) goto L5;
        Log.d("FragmentManager", "onCleared called for " + this);
    L5:
        this.f2056h = true;
    }

    public final void c(Fragment r8) {
        if (this.f2057i == true) goto L5;
        HashMap<String, Fragment> r10 = this.f2052d;
        if (r10.containsKey(r8.mWho) == false) goto L11;
        return;
    L11:
        r10.put(r8.mWho, r8);
        if (FragmentManager.G(2) == false) goto L16;
        Log.v("FragmentManager", "Updating retained Fragments: Added " + r8);
        return;
    L16:
        return;
    L5:
        if (FragmentManager.G(2) == false) goto L15;
        Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
        return;
    }

    public final void d(Fragment r8) {
        if (this.f2057i == false) goto L9;
        if (FragmentManager.G(2) == false) goto L17;
        Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
        return;
    L17:
        return;
    L9:
        if (this.f2052d.remove(r8.mWho) == null) goto L11;
        boolean r10 = true;
    L12:
        if (r10 == true) goto L14;
        return;
    L14:
        if (FragmentManager.G(2) == false) goto L19;
        Log.v("FragmentManager", "Updating retained Fragments: Removed " + r8);
        return;
    L19:
        return;
    L11:
        r10 = false;
        goto L12
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L19:
        return false;
    L8:
        if (v.class != r8.getClass()) goto L19;
        v r10 = (v) r8;
        if (this.f2052d.equals(r10.f2052d) == false) goto L18;
        if (this.f2053e.equals(r10.f2053e) == false) goto L18;
        if (this.f2054f.equals(r10.f2054f) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r8 = this.f2052d.hashCode() * 31;
        int r10 = (this.f2053e.hashCode() + r8) * 31;
        return this.f2054f.hashCode() + r10;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("FragmentManagerViewModel{");
        r8.append(Integer.toHexString(System.identityHashCode(this)));
        r8.append("} Fragments (");
        Iterator<Fragment> r10 = this.f2052d.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        r8.append(r10.next());
        if (r10.hasNext() == false) goto L4;
        r8.append(", ");
        goto L4
    L8:
        r8.append(") Child Non Config (");
        Iterator<String> r11 = this.f2053e.keySet().iterator();
    L10:
        if (r11.hasNext() == false) goto L14;
        r8.append(r11.next());
        if (r11.hasNext() == false) goto L10;
        r8.append(", ");
        goto L10
    L14:
        r8.append(") ViewModelStores (");
        Iterator<String> r12 = this.f2054f.keySet().iterator();
    L16:
        if (r12.hasNext() == false) goto L20;
        r8.append(r12.next());
        if (r12.hasNext() == false) goto L16;
        r8.append(", ");
        goto L16
    L20:
        r8.append(')');
        return r8.toString();
    }
}

package androidx.fragment.app;

import android.util.Log;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a extends z implements FragmentManager.k {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final FragmentManager f1923q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1924r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1925s;

    public a(FragmentManager r8) {
        r8.D();
        r<?> r10 = r8.f1877p;
        if (r10 == null) goto L5;
        r10.f2043b.getClassLoader();
    L5:
        this.f1925s = -1;
        this.f1923q = r8;
    }

    @Override // androidx.fragment.app.FragmentManager.k
    public final boolean a(ArrayList<a> r8, ArrayList<Boolean> r10) {
        if (FragmentManager.G(2) == false) goto L5;
        Log.v("FragmentManager", "Run: " + this);
    L5:
        r8.add(this);
        r10.add(Boolean.FALSE);
        if (this.f2073g == false) goto L13;
        FragmentManager r11 = this.f1923q;
        if (r11.f1865d != null) goto L10;
        r11.f1865d = new ArrayList();
    L10:
        r11.f1865d.add(this);
        return true;
    L13:
        return true;
    }

    public final void c(int r8) {
        if (this.f2073g == true) goto L6;
        return;
    L6:
        if (FragmentManager.G(2) == false) goto L8;
        Log.v("FragmentManager", "Bump nesting in " + this + " by " + r8);
    L8:
        ArrayList<z.a> r10 = this.f2067a;
        int r11 = r10.size();
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L16;
        z.a r13 = r10.get(r12);
        Fragment r14 = r13.f2084b;
        if (r14 == null) goto L15;
        r14.mBackStackNesting += r8;
        if (FragmentManager.G(2) == false) goto L15;
        Log.v("FragmentManager", "Bump nesting of " + r13.f2084b + " to " + r13.f2084b.mBackStackNesting);
    L15:
        r12 = r12 + 1;
        goto L9
    }

    public final int d(boolean r8) {
        if (this.f1924r == true) goto L14;
        if (FragmentManager.G(2) == false) goto L7;
        Log.v("FragmentManager", "Commit: " + this);
        PrintWriter r10 = new PrintWriter(new h0());
        f("  ", r10, true);
        r10.close();
    L7:
        this.f1924r = true;
        boolean r11 = this.f2073g;
        FragmentManager r12 = this.f1923q;
        if (r11 == false) goto L10;
        int r13 = r12.f1870i.getAndIncrement();
    L11:
        this.f1925s = r13;
        r12.v(this, r8);
        return this.f1925s;
    L10:
        r13 = -1;
        goto L11
    L14:
        throw new IllegalStateException("commit already called");
    }

    public final void e(int r8, Fragment r10, String r11, int r12) {
        Class<?> r13 = r10.getClass();
        int r14 = r13.getModifiers();
        if (r13.isAnonymousClass() == true) goto L35;
        if (Modifier.isPublic(r14) == false) goto L35;
        if (r13.isMemberClass() == false) goto L11;
        if (Modifier.isStatic(r14) == false) goto L35;
    L11:
        if (r11 == null) goto L20;
        String r15 = r10.mTag;
        if (r15 != null) goto L15;
    L19:
        r10.mTag = r11;
        goto L20
    L15:
        if (r11.equals(r15) == true) goto L19;
        throw new IllegalStateException("Can't change tag of fragment " + r10 + ": was " + r10.mTag + " now " + r11);
    L20:
        if (r8 != 0) goto L22;
    L32:
        b(new z.a(r10, r12));
        r10.mFragmentManager = this.f1923q;
        return;
    L22:
        if (r8 == (-1)) goto L31;
        int r16 = r10.mFragmentId;
        if (r16 == 0) goto L29;
        if (r16 == r8) goto L29;
        throw new IllegalStateException("Can't change container ID of fragment " + r10 + ": was " + r10.mFragmentId + " now " + r8);
    L29:
        r10.mFragmentId = r8;
        r10.mContainerId = r8;
        goto L32
    L31:
        throw new IllegalArgumentException("Can't add fragment " + r10 + " with tag " + r11 + " to container view with no id");
    L35:
        throw new IllegalStateException("Fragment " + r13.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    public final void f(String r8, PrintWriter r10, boolean r11) {
        if (r11 == false) goto L26;
        r10.print(r8);
        r10.print("mName=");
        r10.print(this.f2075i);
        r10.print(" mIndex=");
        r10.print(this.f1925s);
        r10.print(" mCommitted=");
        r10.println(this.f1924r);
        if (this.f2072f == 0) goto L7;
        r10.print(r8);
        r10.print("mTransition=#");
        r10.print(Integer.toHexString(this.f2072f));
    L7:
        if (this.f2068b == 0) goto L9;
    L10:
        r10.print(r8);
        r10.print("mEnterAnim=#");
        r10.print(Integer.toHexString(this.f2068b));
        r10.print(" mExitAnim=#");
        r10.println(Integer.toHexString(this.f2069c));
    L12:
        if (this.f2070d == 0) goto L14;
    L15:
        r10.print(r8);
        r10.print("mPopEnterAnim=#");
        r10.print(Integer.toHexString(this.f2070d));
        r10.print(" mPopExitAnim=#");
        r10.println(Integer.toHexString(this.f2071e));
    L17:
        if (this.f2076j == 0) goto L19;
    L20:
        r10.print(r8);
        r10.print("mBreadCrumbTitleRes=#");
        r10.print(Integer.toHexString(this.f2076j));
        r10.print(" mBreadCrumbTitleText=");
        r10.println(this.f2077k);
    L22:
        if (this.f2078l == 0) goto L24;
    L25:
        r10.print(r8);
        r10.print("mBreadCrumbShortTitleRes=#");
        r10.print(Integer.toHexString(this.f2078l));
        r10.print(" mBreadCrumbShortTitleText=");
        r10.println(this.f2079m);
        goto L26
    L24:
        if (this.f2079m == null) goto L26;
    L19:
        if (this.f2077k == null) goto L22;
    L14:
        if (this.f2071e == 0) goto L17;
    L9:
        if (this.f2069c == 0) goto L12;
    L26:
        ArrayList<z.a> r12 = this.f2067a;
        if (r12.isEmpty() == true) goto L57;
        r10.print(r8);
        r10.println("Operations:");
        int r13 = r12.size();
        int r14 = 0;
    L29:
        if (r14 >= r13) goto L62;
        z.a r15 = r12.get(r14);
        switch(r15.f2083a) {
            case 0: goto L43;
            case 1: goto L42;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            case 6: goto L37;
            case 7: goto L36;
            case 8: goto L35;
            case 9: goto L34;
            case 10: goto L33;
            default: goto L32;
        };
    L32:
        String r16 = "cmd=" + r15.f2083a;
    L44:
        r10.print(r8);
        r10.print("  Op #");
        r10.print(r14);
        r10.print(": ");
        r10.print(r16);
        r10.print(" ");
        r10.println(r15.f2084b);
        if (r11 == false) goto L56;
        if (r15.f2085c == 0) goto L49;
    L50:
        r10.print(r8);
        r10.print("enterAnim=#");
        r10.print(Integer.toHexString(r15.f2085c));
        r10.print(" exitAnim=#");
        r10.println(Integer.toHexString(r15.f2086d));
    L52:
        if (r15.f2087e == 0) goto L54;
    L55:
        r10.print(r8);
        r10.print("popEnterAnim=#");
        r10.print(Integer.toHexString(r15.f2087e));
        r10.print(" popExitAnim=#");
        r10.println(Integer.toHexString(r15.f2088f));
        goto L56
    L54:
        if (r15.f2088f == 0) goto L56;
    L49:
        if (r15.f2086d == 0) goto L52;
    L56:
        r14 = r14 + 1;
        goto L29
    L33:
        r16 = "OP_SET_MAX_LIFECYCLE";
        goto L44
    L34:
        r16 = "UNSET_PRIMARY_NAV";
        goto L44
    L35:
        r16 = "SET_PRIMARY_NAV";
        goto L44
    L36:
        r16 = "ATTACH";
        goto L44
    L37:
        r16 = "DETACH";
        goto L44
    L38:
        r16 = "SHOW";
        goto L44
    L39:
        r16 = "HIDE";
        goto L44
    L40:
        r16 = "REMOVE";
        goto L44
    L41:
        r16 = "REPLACE";
        goto L44
    L42:
        r16 = "ADD";
        goto L44
    L43:
        r16 = "NULL";
        goto L44
    L62:
        return;
    }

    public final void g() {
        ArrayList<z.a> r8 = this.f2067a;
        int r10 = r8.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L21;
        z.a r12 = r8.get(r11);
        Fragment r13 = r12.f2084b;
        if (r13 == null) goto L7;
        r13.setPopDirection(false);
        r13.setNextTransition(this.f2072f);
        r13.setSharedElementNames(this.f2080n, this.f2081o);
    L7:
        int r14 = r12.f2083a;
        FragmentManager r15 = this.f1923q;
        switch(r14) {
            case 1: goto L19;
            case 2: goto L10;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            default: goto L10;
        };
    L11:
        r15.T(r13, r12.f2090h);
    L20:
        r11 = r11 + 1;
        goto L3
    L12:
        r15.U(null);
        goto L20
    L13:
        r15.U(r13);
        goto L20
    L14:
        r13.setAnimations(r12.f2085c, r12.f2086d, r12.f2087e, r12.f2088f);
        r15.S(r13, false);
        r15.d(r13);
        goto L20
    L15:
        r13.setAnimations(r12.f2085c, r12.f2086d, r12.f2087e, r12.f2088f);
        r15.h(r13);
        goto L20
    L16:
        r13.setAnimations(r12.f2085c, r12.f2086d, r12.f2087e, r12.f2088f);
        r15.S(r13, false);
        FragmentManager.W(r13);
        goto L20
    L17:
        r13.setAnimations(r12.f2085c, r12.f2086d, r12.f2087e, r12.f2088f);
        r15.F(r13);
        goto L20
    L18:
        r13.setAnimations(r12.f2085c, r12.f2086d, r12.f2087e, r12.f2088f);
        r15.N(r13);
        goto L20
    L19:
        r13.setAnimations(r12.f2085c, r12.f2086d, r12.f2087e, r12.f2088f);
        r15.S(r13, false);
        r15.a(r13);
        goto L20
    L10:
        throw new IllegalArgumentException("Unknown cmd: " + r12.f2083a);
    }

    public final void h() {
        ArrayList<z.a> r8 = this.f2067a;
        int r10 = r8.size() - 1;
    L3:
        if (r10 < 0) goto L29;
        z.a r11 = r8.get(r10);
        Fragment r12 = r11.f2084b;
        if (r12 == null) goto L15;
        r12.setPopDirection(true);
        int r13 = this.f2072f;
        int r14 = 8194;
        if (r13 != 4097) goto L9;
    L14:
        r12.setNextTransition(r14);
        r12.setSharedElementNames(this.f2081o, this.f2080n);
        goto L15
    L9:
        if (r13 == 4099) goto L13;
        if (r13 == 8194) goto L12;
        r14 = 0;
        goto L14
    L12:
        r14 = 4097;
        goto L14
    L13:
        r14 = 4099;
    L15:
        int r15 = r11.f2083a;
        FragmentManager r16 = this.f1923q;
        switch(r15) {
            case 1: goto L27;
            case 2: goto L18;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            default: goto L18;
        };
    L19:
        r16.T(r12, r11.f2089g);
    L28:
        r10 = r10 - 1;
        goto L3
    L20:
        r16.U(r12);
        goto L28
    L21:
        r16.U(null);
        goto L28
    L22:
        r12.setAnimations(r11.f2085c, r11.f2086d, r11.f2087e, r11.f2088f);
        r16.S(r12, true);
        r16.h(r12);
        goto L28
    L23:
        r12.setAnimations(r11.f2085c, r11.f2086d, r11.f2087e, r11.f2088f);
        r16.d(r12);
        goto L28
    L24:
        r12.setAnimations(r11.f2085c, r11.f2086d, r11.f2087e, r11.f2088f);
        r16.S(r12, true);
        r16.F(r12);
        goto L28
    L25:
        r12.setAnimations(r11.f2085c, r11.f2086d, r11.f2087e, r11.f2088f);
        r16.getClass();
        FragmentManager.W(r12);
        goto L28
    L26:
        r12.setAnimations(r11.f2085c, r11.f2086d, r11.f2087e, r11.f2088f);
        r16.a(r12);
        goto L28
    L27:
        r12.setAnimations(r11.f2085c, r11.f2086d, r11.f2087e, r11.f2088f);
        r16.S(r12, true);
        r16.N(r12);
        goto L28
    L18:
        throw new IllegalArgumentException("Unknown cmd: " + r11.f2083a);
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder(128);
        r8.append("BackStackEntry{");
        r8.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1925s < 0) goto L6;
        r8.append(" #");
        r8.append(this.f1925s);
    L6:
        if (this.f2075i == null) goto L8;
        r8.append(" ");
        r8.append(this.f2075i);
    L8:
        r8.append("}");
        return r8.toString();
    }
}

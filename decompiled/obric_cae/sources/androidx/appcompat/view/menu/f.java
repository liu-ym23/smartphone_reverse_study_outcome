package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import j0.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class f implements c0.a {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f814z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<h> f820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<h> f821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<h> f823i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<h> f824j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f825k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f826l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f827m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f828n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f829o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f830p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f831q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f832r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f833s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f834t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList<h> f835u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CopyOnWriteArrayList<WeakReference<j>> f836v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public h f837w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f838x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f839y;

    public interface a {
        boolean a(f r8, MenuItem r10);

        void b(f r8);
    }

    public interface b {
        boolean b(h r8);
    }

    static {
        f814z = new int[]{1, 4, 5, 3, 2, 0};
    }

    public f(Context r8) {
        boolean r10 = false;
        this.f826l = 0;
        this.f830p = false;
        this.f831q = false;
        this.f832r = false;
        this.f833s = false;
        this.f834t = false;
        this.f835u = new ArrayList();
        this.f836v = new CopyOnWriteArrayList();
        this.f838x = false;
        this.f815a = r8;
        Resources r11 = r8.getResources();
        this.f816b = r11;
        this.f820f = new ArrayList();
        this.f821g = new ArrayList();
        this.f822h = true;
        this.f823i = new ArrayList();
        this.f824j = new ArrayList();
        this.f825k = true;
        if (r11.getConfiguration().keyboard != 1) goto L5;
    L7:
        this.f818d = r10;
        return;
    L5:
        if (z.b(ViewConfiguration.get(r8)) == false) goto L7;
        r10 = true;
        goto L7
    }

    public final h a(int r11, int r12, int r13, CharSequence r14) {
        int r8 = ((-65536) & r13) >> 16;
        if (r8 < 0) goto L16;
        if (r8 >= 6) goto L16;
        int r10 = (f814z[r8] << 16) | (65535 & r13);
        h r15 = new h(this, r11, r12, r13, r10, r14, this.f826l);
        ArrayList<h> r16 = this.f820f;
        int r17 = r16.size();
    L7:
        r17 = r17 - 1;
        if (r17 < 0) goto L12;
        if (r16.get(r17).f846d > r10) goto L7;
        int r18 = r17 + 1;
    L13:
        r16.add(r18, r15);
        q(true);
        return r15;
    L12:
        r18 = 0;
    L16:
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    @Override // android.view.Menu
    public final MenuItem add(int r8) {
        return a(0, 0, 0, this.f816b.getString(r8));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int r8, int r10, int r11, ComponentName r12, Intent[] r13, Intent r14, int r15, MenuItem[] r16) {
        PackageManager r17 = this.f815a.getPackageManager();
        int r18 = 0;
        List<ResolveInfo> r19 = r17.queryIntentActivityOptions(r12, r13, r14, 0);
        if (r19 == null) goto L5;
        int r20 = r19.size();
    L7:
        if ((r15 & 1) != 0) goto L9;
        removeGroup(r8);
    L9:
        if (r18 >= r20) goto L20;
        ResolveInfo r110 = r19.get(r18);
        int r21 = r110.specificIndex;
        if (r21 >= 0) goto L13;
        Intent r22 = r14;
    L14:
        Intent r23 = new Intent(r22);
        ActivityInfo r24 = r110.activityInfo;
        r23.setComponent(new ComponentName(r24.applicationInfo.packageName, r24.name));
        h r25 = a(r8, r10, r11, r110.loadLabel(r17));
        r25.setIcon(r110.loadIcon(r17));
        r25.f849g = r23;
        if (r16 == null) goto L19;
        int r111 = r110.specificIndex;
        if (r111 < 0) goto L19;
        r16[r111] = r25;
    L19:
        r18 = r18 + 1;
        goto L9
    L13:
        r22 = r13[r21];
        goto L14
    L20:
        return r20;
    L5:
        r20 = 0;
        goto L7
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int r8) {
        return addSubMenu(0, 0, 0, this.f816b.getString(r8));
    }

    public final void b(d r8) {
        c(r8, this.f815a);
    }

    public final void c(j r8, Context r10) {
        this.f836v.add(new WeakReference(r8));
        r8.h(r10, this);
        this.f825k = true;
    }

    @Override // android.view.Menu
    public final void clear() {
        h r8 = this.f837w;
        if (r8 == null) goto L5;
        e(r8);
    L5:
        this.f820f.clear();
        q(true);
    }

    public final void clearHeader() {
        this.f828n = null;
        this.f827m = null;
        this.f829o = null;
        q(false);
    }

    @Override // android.view.Menu
    public final void close() {
        d(true);
    }

    public final void d(boolean r8) {
        if (this.f834t == false) goto L5;
        return;
    L5:
        this.f834t = true;
        CopyOnWriteArrayList<WeakReference<j>> r10 = this.f836v;
        Iterator<WeakReference<j>> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        WeakReference<j> r12 = r11.next();
        j r13 = r12.get();
        if (r13 == null) goto L10;
        r13.a(this, r8);
        goto L7
    L10:
        r10.remove(r12);
        goto L7
    L12:
        this.f834t = false;
    }

    public boolean e(h r8) {
        CopyOnWriteArrayList<WeakReference<j>> r10 = this.f836v;
        boolean r11 = false;
        if (r10.isEmpty() == false) goto L5;
    L18:
        return r11;
    L5:
        if (this.f837w != r8) goto L18;
        y();
        Iterator<WeakReference<j>> r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L15;
        WeakReference<j> r13 = r12.next();
        j r14 = r13.get();
        if (r14 == null) goto L12;
        r11 = r14.c(r8);
        if (r11 == false) goto L9;
    L12:
        r10.remove(r13);
    L15:
        x();
        if (r11 == false) goto L18;
        this.f837w = null;
        goto L18
    }

    public boolean f(f r8, MenuItem r10) {
        a r11 = this.f819e;
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.a(r8, r10) == false) goto L7;
        return true;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int r8) {
        int r10 = size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L13;
        h r12 = this.f820f.get(r11);
        if (r12.getItemId() == r8) goto L6;
        if (r12.hasSubMenu() == false) goto L12;
        MenuItem r13 = ((f) r12.getSubMenu()).findItem(r8);
        if (r13 == null) goto L12;
        return r13;
    L12:
        r11 = r11 + 1;
        goto L3
    L6:
        return r12;
    L13:
        return null;
    }

    public boolean g(h r8) {
        CopyOnWriteArrayList<WeakReference<j>> r10 = this.f836v;
        boolean r11 = false;
        if (r10.isEmpty() == false) goto L5;
        return false;
    L5:
        y();
        Iterator<WeakReference<j>> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L13;
        WeakReference<j> r13 = r12.next();
        j r14 = r13.get();
        if (r14 == null) goto L10;
        r11 = r14.f(r8);
        if (r11 == false) goto L7;
    L10:
        r10.remove(r13);
    L13:
        x();
        if (r11 == false) goto L16;
        this.f837w = r8;
    L16:
        return r11;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int r8) {
        return this.f820f.get(r8);
    }

    public final h h(int r11, KeyEvent r12) {
        ArrayList<h> r8 = this.f835u;
        r8.clear();
        i(r8, r11, r12);
        if (r8.isEmpty() == false) goto L5;
        return null;
    L5:
        int r10 = r12.getMetaState();
        KeyCharacterMap.KeyData r13 = new KeyCharacterMap.KeyData();
        r12.getKeyData(r13);
        int r14 = r8.size();
        if (r14 == 1) goto L8;
        boolean r15 = o();
        int r16 = 0;
    L10:
        if (r16 >= r14) goto L30;
        h r17 = r8.get(r16);
        if (r15 == false) goto L14;
        char r18 = r17.f852j;
    L15:
        char[] r19 = r13.meta;
        if (r18 != r19[0]) goto L20;
        if ((r10 & 2) != 0) goto L20;
    L28:
        return r17;
    L20:
        if (r18 == r19[2]) goto L22;
    L23:
        if (r15 == false) goto L29;
        if (r18 != '\b') goto L29;
        if (r11 == 67) goto L28;
    L29:
        r16 = r16 + 1;
        goto L10
    L22:
        if ((r10 & 2) != 0) goto L28;
    L14:
        r18 = r17.f850h;
        goto L15
    L30:
        return null;
    L8:
        return r8.get(0);
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.f839y == false) goto L5;
        return true;
    L5:
        int r8 = size();
        int r10 = 0;
    L6:
        if (r10 >= r8) goto L11;
        if (this.f820f.get(r10).isVisible() == true) goto L9;
        r10 = r10 + 1;
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    public final void i(ArrayList r13, int r14, KeyEvent r15) {
        boolean r8 = o();
        int r10 = r15.getModifiers();
        KeyCharacterMap.KeyData r11 = new KeyCharacterMap.KeyData();
        if (r15.getKeyData(r11) == true) goto L6;
        if (r14 == 67) goto L6;
        return;
    L6:
        ArrayList<h> r12 = this.f820f;
        int r16 = r12.size();
        int r17 = 0;
    L7:
        if (r17 >= r16) goto L35;
        h r18 = r12.get(r17);
        if (r18.hasSubMenu() == false) goto L11;
        r18.f857o.i(r13, r14, r15);
    L11:
        if (r8 == false) goto L13;
        char r19 = r18.f852j;
    L14:
        if (r8 == false) goto L16;
        int r20 = r18.f853k;
    L18:
        if ((r10 & 69647) != (r20 & 69647)) goto L20;
        boolean r21 = true;
    L21:
        if (r21 == false) goto L34;
        if (r19 == 0) goto L34;
        char[] r22 = r11.meta;
        if (r19 == r22[0]) goto L32;
        if (r19 == r22[2]) goto L32;
        if (r8 == false) goto L34;
        if (r19 != '\b') goto L34;
        if (r14 != 67) goto L34;
    L32:
        if (r18.isEnabled() == false) goto L34;
        r13.add(r18);
    L34:
        r17 = r17 + 1;
        goto L7
    L20:
        r21 = false;
        goto L21
    L16:
        r20 = r18.f851i;
        goto L18
    L13:
        r19 = r18.f850h;
        goto L14
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int r8, KeyEvent r10) {
        if (h(r8, r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void j() {
        ArrayList<h> r8 = m();
        if (this.f825k == true) goto L5;
        return;
    L5:
        CopyOnWriteArrayList<WeakReference<j>> r10 = this.f836v;
        Iterator<WeakReference<j>> r11 = r10.iterator();
        boolean r12 = false;
    L7:
        if (r11.hasNext() == false) goto L12;
        WeakReference<j> r13 = r11.next();
        j r14 = r13.get();
        if (r14 == null) goto L10;
        r12 = r12 | r14.g();
        goto L7
    L10:
        r10.remove(r13);
        goto L7
    L12:
        ArrayList<h> r15 = this.f823i;
        ArrayList<h> r16 = this.f824j;
        r15.clear();
        r16.clear();
        if (r12 == false) goto L24;
        int r17 = r8.size();
        int r18 = 0;
    L15:
        if (r18 >= r17) goto L25;
        h r19 = r8.get(r18);
        if ((r19.f866x & 32) != 32) goto L19;
        boolean r20 = true;
    L20:
        if (r20 == false) goto L22;
        r15.add(r19);
    L23:
        r18 = r18 + 1;
        goto L15
    L22:
        r16.add(r19);
        goto L23
    L19:
        r20 = false;
    L25:
        this.f825k = false;
        return;
    L24:
        r16.addAll(m());
        goto L25
    }

    public String k() {
        return "android:menu:actionviewstates";
    }

    public f l() {
        return this;
    }

    public final ArrayList<h> m() {
        boolean r8 = this.f822h;
        ArrayList<h> r10 = this.f821g;
        if (r8 == true) goto L5;
        return r10;
    L5:
        r10.clear();
        ArrayList<h> r11 = this.f820f;
        int r12 = r11.size();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        h r14 = r11.get(r13);
        if (r14.isVisible() == false) goto L10;
        r10.add(r14);
    L10:
        r13 = r13 + 1;
        goto L6
    L11:
        this.f822h = false;
        this.f825k = true;
        return r10;
    }

    public boolean n() {
        return this.f838x;
    }

    public boolean o() {
        return this.f817c;
    }

    public boolean p() {
        return this.f818d;
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int r8, int r10) {
        return s(findItem(r8), null, r10);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int r8, KeyEvent r10, int r11) {
        h r12 = h(r8, r10);
        if (r12 == null) goto L5;
        boolean r13 = s(r12, null, r11);
    L7:
        if ((r11 & 2) == 0) goto L9;
        d(true);
    L9:
        return r13;
    L5:
        r13 = false;
        goto L7
    }

    public final void q(boolean r8) {
        if (this.f830p == true) goto L17;
        if (r8 == false) goto L6;
        this.f822h = true;
        this.f825k = true;
    L6:
        CopyOnWriteArrayList<WeakReference<j>> r10 = this.f836v;
        if (r10.isEmpty() == true) goto L29;
        y();
        Iterator<WeakReference<j>> r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L16;
        WeakReference<j> r12 = r11.next();
        j r13 = r12.get();
        if (r13 == null) goto L14;
        r13.d();
        goto L11
    L14:
        r10.remove(r12);
        goto L11
    L16:
        x();
        return;
    L29:
        return;
    L17:
        this.f831q = true;
        if (r8 == false) goto L28;
        this.f832r = true;
        return;
    }

    public final void r(int r8, MenuItem r10) {
        s(r10, null, r8);
    }

    @Override // android.view.Menu
    public final void removeGroup(int r8) {
        int r10 = size();
        int r11 = 0;
        int r12 = 0;
    L3:
        ArrayList<h> r13 = this.f820f;
        if (r12 >= r10) goto L9;
        if (r13.get(r12).f844b == r8) goto L10;
        r12 = r12 + 1;
    L10:
        if (r12 < 0) goto L31;
        int r14 = r13.size() - r12;
    L12:
        int r15 = r11 + 1;
        if (r11 >= r14) goto L22;
        if (r13.get(r12).f844b != r8) goto L22;
        if (r12 < 0) goto L21;
        if (r12 >= r13.size()) goto L21;
        r13.remove(r12);
    L21:
        r11 = r15;
    L22:
        q(true);
        return;
    L31:
        return;
    L9:
        r12 = -1;
        goto L10
    }

    @Override // android.view.Menu
    public final void removeItem(int r8) {
        int r10 = size();
        int r11 = 0;
    L3:
        ArrayList<h> r12 = this.f820f;
        if (r11 >= r10) goto L9;
        if (r12.get(r11).f843a == r8) goto L10;
        r11 = r11 + 1;
    L10:
        if (r11 >= 0) goto L12;
        return;
    L12:
        if (r11 >= r12.size()) goto L19;
        r12.remove(r11);
        q(true);
        return;
    L19:
        return;
    L9:
        r11 = -1;
        goto L10
    }

    public final boolean s(MenuItem r8, j r10, int r11) {
        h r12 = (h) r8;
        boolean r13 = false;
        if (r12 != null) goto L5;
    L71:
        return false;
    L5:
        if (r12.isEnabled() == false) goto L71;
        MenuItem.OnMenuItemClickListener r14 = r12.f858p;
        if (r14 != null) goto L10;
    L12:
        f r15 = r12.f856n;
        if (r15.f(r15, r12) == true) goto L25;
        Intent r16 = r12.f849g;
        if (r16 != null) goto L72;
    L21:
        j0.b r17 = r12.A;
        if (r17 != null) goto L24;
    L26:
        boolean r18 = false;
    L27:
        j0.b r19 = r12.A;
        if (r19 != null) goto L30;
    L32:
        boolean r20 = false;
    L34:
        if (r12.e() == false) goto L39;
        r18 = r18 | r12.expandActionView();
        if (r18 == true) goto L69;
    L70:
        return r18;
    L69:
        d(true);
        goto L70
    L39:
        if (r12.hasSubMenu() == true) goto L46;
        if (r20 == true) goto L46;
        if ((r11 & 1) != 0) goto L70;
    L46:
        if ((r11 & 4) != 0) goto L49;
        d(false);
    L49:
        if (r12.hasSubMenu() == true) goto L51;
        m r21 = new m(this.f815a, this, r12);
        r12.f857o = r21;
        r21.setHeaderTitle(r12.f847e);
    L51:
        m r22 = r12.f857o;
        if (r20 == false) goto L54;
        r19.f(r22);
    L54:
        CopyOnWriteArrayList<WeakReference<j>> r23 = this.f836v;
        if (r23.isEmpty() == true) goto L67;
        if (r10 == null) goto L59;
        r13 = r10.e(r22);
    L59:
        Iterator<WeakReference<j>> r24 = r23.iterator();
    L61:
        if (r24.hasNext() == false) goto L67;
        WeakReference<j> r25 = r24.next();
        j r26 = r25.get();
        if (r26 == null) goto L64;
        if (r13 == true) goto L61;
        r13 = r26.e(r22);
        goto L61
    L64:
        r23.remove(r25);
    L67:
        r18 = r18 | r13;
        if (r18 == true) goto L70;
    L30:
        if (r19.a() == false) goto L32;
        r20 = true;
        goto L34
    L24:
        if (r17.e() == false) goto L26;
    L72:
        r15.f815a.startActivity(r16);     // Catch: ActivityNotFoundException -> L19
    L19:
        e = move-exception;
        Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
    L25:
        r18 = true;
        goto L27
    L10:
        if (r14.onMenuItemClick(r12) == false) goto L12;
        goto L12
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int r8, boolean r10, boolean r11) {
        ArrayList<h> r12 = this.f820f;
        int r13 = r12.size();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L12;
        h r15 = r12.get(r14);
        if (r15.f844b != r8) goto L11;
        int r16 = r15.f866x & (-5);
        if (r11 == false) goto L9;
        int r17 = 4;
    L10:
        r15.f866x = r16 | r17;
        r15.setCheckable(r10);
        goto L11
    L9:
        r17 = 0;
    L11:
        r14 = r14 + 1;
        goto L3
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean r8) {
        this.f838x = r8;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int r8, boolean r10) {
        ArrayList<h> r11 = this.f820f;
        int r12 = r11.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        h r14 = r11.get(r13);
        if (r14.f844b != r8) goto L7;
        r14.setEnabled(r10);
    L7:
        r13 = r13 + 1;
        goto L3
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int r11, boolean r12) {
        ArrayList<h> r8 = this.f820f;
        int r10 = r8.size();
        int r13 = 0;
        boolean r14 = false;
    L4:
        if (r13 >= r10) goto L18;
        h r15 = r8.get(r13);
        if (r15.f844b != r11) goto L17;
        int r16 = r15.f866x;
        int r17 = r16 & (-9);
        if (r12 == false) goto L10;
        int r18 = 0;
    L11:
        int r19 = r17 | r18;
        r15.f866x = r19;
        if (r16 == r19) goto L14;
        boolean r20 = true;
    L15:
        if (r20 == false) goto L17;
        r14 = true;
        goto L17
    L14:
        r20 = false;
        goto L15
    L10:
        r18 = 8;
    L17:
        r13 = r13 + 1;
        goto L4
    L18:
        if (r14 == false) goto L25;
        q(true);
        return;
    }

    public final void setOptionalIconsVisible(boolean r8) {
        this.f833s = r8;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean r8) {
        this.f817c = r8;
        q(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f820f.size();
    }

    public final void t(j r8) {
        CopyOnWriteArrayList<WeakReference<j>> r10 = this.f836v;
        Iterator<WeakReference<j>> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        WeakReference<j> r12 = r11.next();
        j r13 = r12.get();
        if (r13 == null) goto L8;
        if (r13 != r8) goto L4;
    L8:
        r10.remove(r12);
        goto L4
    }

    public final void u(Bundle r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        SparseArray<Parcelable> r10 = r8.getSparseParcelableArray(k());
        int r11 = size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L15;
        MenuItem r13 = getItem(r12);
        View r14 = r13.getActionView();
        if (r14 == null) goto L12;
        if (r14.getId() == (-1)) goto L12;
        r14.restoreHierarchyState(r10);
    L12:
        if (r13.hasSubMenu() == false) goto L14;
        ((m) r13.getSubMenu()).u(r8);
    L14:
        r12 = r12 + 1;
        goto L5
    L15:
        int r15 = r8.getInt("android:menu:expandedactionview");
        if (r15 <= 0) goto L24;
        MenuItem r16 = findItem(r15);
        if (r16 == null) goto L25;
        r16.expandActionView();
        return;
    L25:
        return;
    }

    public final void v(Bundle r8) {
        int r10 = size();
        SparseArray<? extends Parcelable> r11 = null;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L17;
        MenuItem r13 = getItem(r12);
        View r14 = r13.getActionView();
        if (r14 == null) goto L14;
        if (r14.getId() == (-1)) goto L14;
        if (r11 != null) goto L10;
        r11 = new SparseArray();
    L10:
        r14.saveHierarchyState(r11);
        if (r13.isActionViewExpanded() == false) goto L14;
        r8.putInt("android:menu:expandedactionview", r13.getItemId());
    L14:
        if (r13.hasSubMenu() == false) goto L16;
        ((m) r13.getSubMenu()).v(r8);
    L16:
        r12 = r12 + 1;
        goto L3
    L17:
        if (r11 == null) goto L23;
        r8.putSparseParcelableArray(k(), r11);
        return;
    }

    public final void w(int r8, CharSequence r10, int r11, Drawable r12, View r13) {
        if (r13 == null) goto L5;
        this.f829o = r13;
        this.f827m = null;
        this.f828n = null;
    L14:
        q(false);
        return;
    L5:
        if (r8 <= 0) goto L7;
        this.f827m = this.f816b.getText(r8);
    L9:
        if (r11 <= 0) goto L11;
        Object r14 = androidx.core.content.a.f1674a;
        this.f828n = androidx.core.content.a.b.b(this.f815a, r11);
    L13:
        this.f829o = null;
        goto L14
    L11:
        if (r12 == null) goto L13;
        this.f828n = r12;
        goto L13
    L7:
        if (r10 == null) goto L9;
        this.f827m = r10;
        goto L9
    }

    public final void x() {
        this.f830p = false;
        if (this.f831q == false) goto L6;
        this.f831q = false;
        q(this.f832r);
        return;
    }

    public final void y() {
        if (this.f830p == true) goto L6;
        this.f830p = true;
        this.f831q = false;
        this.f832r = false;
        return;
    }

    @Override // android.view.Menu
    public final MenuItem add(int r8, int r10, int r11, int r12) {
        return a(r8, r10, r11, this.f816b.getString(r12));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int r8, int r10, int r11, int r12) {
        return addSubMenu(r8, r10, r11, this.f816b.getString(r12));
    }

    @Override // android.view.Menu
    public final MenuItem add(int r8, int r10, int r11, CharSequence r12) {
        return a(r8, r10, r11, r12);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int r8, int r10, int r11, CharSequence r12) {
        h r13 = a(r8, r10, r11, r12);
        m r14 = new m(this.f815a, this, r13);
        r13.f857o = r14;
        r14.setHeaderTitle(r13.f847e);
        return r14;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence r8) {
        return a(0, 0, 0, r8);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence r8) {
        return addSubMenu(0, 0, 0, r8);
    }
}

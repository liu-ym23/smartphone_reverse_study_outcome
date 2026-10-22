package g;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.v0;
import j0.j;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class g extends MenuInflater {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Class<?>[] f7455e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Class<?>[] f7456f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f7457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f7458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f7459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f7460d;

    public static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Class<?>[] f7461c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f7462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f7463b;

        static {
            f7461c = new Class[]{MenuItem.class};
        }

        public a(Object r8, String r10) {
            this.f7462a = r8;
            Class<?> r11 = r8.getClass();
            this.f7463b = r11.getMethod(r10, f7461c);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            StringBuilder r12 = defpackage.b.h("Couldn't resolve menu item onClick handler ", r10, " in class ");
            r12.append(r11.getName());
            InflateException r13 = new InflateException(r12.toString());
            r13.initCause(e);
            throw r13;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem r8) {
            Method r10 = this.f7463b;
            Class<?> r11 = r10.getReturnType();     // Catch: Exception -> L11
            Class<?> r12 = Boolean.TYPE;     // Catch: Exception -> L11
            Object r13 = this.f7462a;
            if (r11 == r12) goto L7;
            r10.invoke(r13, new Object[]{r8});     // Catch: Exception -> L11
            return true;
        L7:
            return ((Boolean) r10.invoke(r13, new Object[]{r8})).booleanValue();
        L11:
            e = move-exception;
            throw new RuntimeException(e);
        }
    }

    public class b {
        public CharSequence A;
        public CharSequence B;
        public ColorStateList C;
        public PorterDuff.Mode D;
        public final /* synthetic */ g E;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Menu f7464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7467d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7468e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f7469f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f7470g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f7471h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7472i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f7473j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public CharSequence f7474k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f7475l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7476m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public char f7477n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f7478o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public char f7479p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f7480q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f7481r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f7482s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f7483t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f7484u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f7485v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f7486w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f7487x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f7488y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public j0.b f7489z;

        public b(g r8, Menu r10) {
            this.E = r8;
            this.C = null;
            this.D = null;
            this.f7464a = r10;
            this.f7465b = 0;
            this.f7466c = 0;
            this.f7467d = 0;
            this.f7468e = 0;
            this.f7469f = true;
            this.f7470g = true;
        }

        public final <T> T a(String r8, Class<?>[] r10, Object[] r11) {
            Constructor<?> r12 = Class.forName(r8, false, this.E.f7459c.getClassLoader()).getConstructor(r10);     // Catch: Exception -> L4
            r12.setAccessible(true);     // Catch: Exception -> L4
            return (T) r12.newInstance(r11);
        L4:
            e = move-exception;
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + r8, e);
            return null;
        }

        public final void b(MenuItem r10) {
            MenuItem r8 = r10.setChecked(this.f7482s).setVisible(this.f7483t).setEnabled(this.f7484u);
            boolean r11 = false;
            if (this.f7481r < 1) goto L5;
            boolean r12 = true;
        L6:
            r8.setCheckable(r12).setTitleCondensed(this.f7475l).setIcon(this.f7476m);
            int r13 = this.f7485v;
            if (r13 < 0) goto L9;
            r10.setShowAsAction(r13);
        L9:
            String r14 = this.f7488y;
            g r15 = this.E;
            if (r14 == null) goto L20;
            if (r15.f7459c.isRestricted() == true) goto L18;
            if (r15.f7460d != null) goto L16;
            r15.f7460d = g.a(r15.f7459c);
        L16:
            r10.setOnMenuItemClickListener(new a(r15.f7460d, this.f7488y));
            goto L20
        L18:
            throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        L20:
            if (this.f7481r >= 2) goto L22;
        L35:
            String r16 = this.f7487x;
            if (r16 == null) goto L38;
            r10.setActionView((View) a(r16, g.f7455e, r15.f7457a));
            r11 = true;
        L38:
            int r17 = this.f7486w;
            if (r17 <= 0) goto L43;
            if (r11 == true) goto L42;
            r10.setActionView(r17);
            goto L43
        L42:
            Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        L43:
            j0.b r18 = this.f7489z;
            if (r18 != null) goto L46;
        L49:
            CharSequence r19 = this.A;
            boolean r20 = r10 instanceof c0.b;
            if (r20 == false) goto L52;
            ((c0.b) r10).setContentDescription(r19);
        L53:
            CharSequence r21 = this.B;
            if (r20 == false) goto L56;
            ((c0.b) r10).setTooltipText(r21);
        L57:
            char r22 = this.f7477n;
            int r23 = this.f7478o;
            if (r20 == false) goto L60;
            ((c0.b) r10).setAlphabeticShortcut(r22, r23);
        L61:
            char r24 = this.f7479p;
            int r25 = this.f7480q;
            if (r20 == false) goto L64;
            ((c0.b) r10).setNumericShortcut(r24, r25);
        L65:
            PorterDuff.Mode r26 = this.D;
            if (r26 == null) goto L70;
            if (r20 == false) goto L69;
            ((c0.b) r10).setIconTintMode(r26);
            goto L70
        L69:
            j.j(r10, r26);
        L70:
            ColorStateList r27 = this.C;
            if (r27 == null) goto L78;
            if (r20 == false) goto L74;
            ((c0.b) r10).setIconTintList(r27);
            return;
        L74:
            j.i(r10, r27);
            return;
        L78:
            return;
        L64:
            j.k(r10, r24, r25);
            goto L65
        L60:
            j.g(r10, r22, r23);
            goto L61
        L56:
            j.m(r10, r21);
            goto L57
        L52:
            j.h(r10, r19);
            goto L53
        L46:
            if ((r10 instanceof c0.b) == false) goto L48;
            ((c0.b) r10).a(r18);
            goto L49
        L48:
            Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            goto L49
        L22:
            if ((r10 instanceof androidx.appcompat.view.menu.h) == false) goto L25;
            androidx.appcompat.view.menu.h r28 = (androidx.appcompat.view.menu.h) r10;
            r28.f866x = (r28.f866x & (-5)) | 4;
            goto L35
        L25:
            if ((r10 instanceof h.c) == false) goto L35;
            h.c r29 = (h.c) r10;
            Method r30 = r29.f7852e;     // Catch: Exception -> L33
            c0.b r31 = r29.f7851d;
            if (r30 != null) goto L31;
            r29.f7852e = r31.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});     // Catch: Exception -> L33
        L31:
            r29.f7852e.invoke(r31, new Object[]{Boolean.TRUE});     // Catch: Exception -> L33
        L33:
            e = move-exception;
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
            goto L35
        L5:
            r12 = false;
            goto L6
        }
    }

    static {
        Class<?>[] r8 = {Context.class};
        f7455e = r8;
        f7456f = r8;
    }

    public g(Context r8) {
        super(r8);
        this.f7459c = r8;
        Object[] r10 = {r8};
        this.f7457a = r10;
        this.f7458b = r10;
    }

    public static Object a(Context r8) {
        if ((r8 instanceof Activity) == false) goto L6;
        return r8;
    L6:
        if ((r8 instanceof ContextWrapper) == true) goto L8;
        return r8;
    L8:
        return a(((ContextWrapper) r8).getBaseContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(XmlResourceParser r17, AttributeSet r18, Menu r19) {
        b r8 = new b(this, r19);
        int r10 = r17.getEventType();
    L3:
        int r11 = 2;
        if (r10 == 2) goto L5;
        r10 = r17.next();
        if (r10 != 1) goto L3;
    L12:
        boolean r12 = false;
        boolean r13 = false;
        String r14 = null;
    L13:
        if (r12 == true) goto L89;
        if (r10 == 1) goto L88;
        Menu r15 = r8.f7464a;
        if (r10 == r11) goto L40;
        if (r10 != 3) goto L86;
        String r16 = r17.getName();
        if (r13 == false) goto L25;
        if (r16.equals(r14) == false) goto L25;
        r13 = false;
        r14 = null;
    L25:
        if (r16.equals("group") == false) goto L28;
        r8.f7465b = 0;
        r8.f7466c = 0;
        r8.f7467d = 0;
        r8.f7468e = 0;
        r8.f7469f = true;
        r8.f7470g = true;
        goto L86
    L28:
        if (r16.equals("item") == false) goto L38;
        if (r8.f7471h == true) goto L86;
        j0.b r20 = r8.f7489z;
        if (r20 != null) goto L34;
    L36:
        r8.f7471h = true;
        r8.b(r15.add(r8.f7465b, r8.f7472i, r8.f7473j, r8.f7474k));
        goto L86
    L34:
        if (r20.a() == false) goto L36;
        r8.f7471h = true;
        r8.b(r15.addSubMenu(r8.f7465b, r8.f7472i, r8.f7473j, r8.f7474k).getItem());
        goto L86
    L38:
        if (r16.equals("menu") == false) goto L86;
        r12 = true;
    L86:
        r10 = r17.next();
        r11 = 2;
        goto L13
    L40:
        if (r13 == true) goto L86;
        String r21 = r17.getName();
        boolean r110 = r21.equals("group");
        g r22 = r8.E;
        if (r110 == false) goto L47;
        TypedArray r23 = r22.f7459c.obtainStyledAttributes(r18, c.a.f3230p);
        r8.f7465b = r23.getResourceId(1, 0);
        r8.f7466c = r23.getInt(3, 0);
        r8.f7467d = r23.getInt(4, 0);
        r8.f7468e = r23.getInt(5, 0);
        r8.f7469f = r23.getBoolean(2, true);
        r8.f7470g = r23.getBoolean(0, true);
        r23.recycle();
        goto L86
    L47:
        if (r21.equals("item") == false) goto L83;
        Context r24 = r22.f7459c;
        v0 r111 = new v0(r24, r24.obtainStyledAttributes(r18, c.a.f3231q));
        r8.f7472i = r111.i(2, 0);
        r8.f7473j = (r111.h(5, r8.f7466c) & (-65536)) | (r111.h(6, r8.f7467d) & 65535);
        r8.f7474k = r111.k(7);
        r8.f7475l = r111.k(8);
        r8.f7476m = r111.i(0, 0);
        String r25 = r111.j(9);
        if (r25 != null) goto L51;
        char r26 = 0;
    L52:
        r8.f7477n = r26;
        r8.f7478o = r111.h(16, 4096);
        String r27 = r111.j(10);
        if (r27 != null) goto L55;
        char r28 = 0;
    L56:
        r8.f7479p = r28;
        r8.f7480q = r111.h(20, 4096);
        if (r111.l(11) == false) goto L59;
        int r29 = r111.a(11, false);
    L60:
        r8.f7481r = r29;
        r8.f7482s = r111.a(3, false);
        r8.f7483t = r111.a(4, r8.f7469f);
        r8.f7484u = r111.a(1, r8.f7470g);
        r8.f7485v = r111.h(21, -1);
        r8.f7488y = r111.j(12);
        r8.f7486w = r111.i(13, 0);
        r8.f7487x = r111.j(15);
        String r30 = r111.j(14);
        if (r30 == null) goto L63;
        boolean r112 = true;
    L64:
        if (r112 == true) goto L66;
    L70:
        if (r112 == false) goto L72;
        Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
    L72:
        j0.b r31 = null;
    L73:
        r8.f7489z = r31;
        r8.A = r111.k(17);
        r8.B = r111.k(22);
        if (r111.l(19) == false) goto L76;
        r8.D = d0.b(r111.h(19, -1), r8.D);
        ColorStateList r32 = null;
    L78:
        if (r111.l(18) == false) goto L80;
        r8.C = r111.b(18);
    L81:
        r111.n();
        r8.f7471h = false;
        goto L86
    L80:
        r8.C = r32;
        goto L81
    L76:
        r32 = null;
        r8.D = null;
        goto L78
    L66:
        if (r8.f7486w != 0) goto L70;
        if (r8.f7487x != null) goto L70;
        r31 = (j0.b) r8.a(r30, f7456f, r22.f7458b);
        goto L73
    L63:
        r112 = false;
        goto L64
    L59:
        r29 = r8.f7468e;
        goto L60
    L55:
        r28 = r27.charAt(0);
        goto L56
    L51:
        r26 = r25.charAt(0);
        goto L52
    L83:
        if (r21.equals("menu") == false) goto L85;
        r8.f7471h = true;
        SubMenu r33 = r15.addSubMenu(r8.f7465b, r8.f7472i, r8.f7473j, r8.f7474k);
        r8.b(r33.getItem());
        b(r17, r18, r33);
        goto L86
    L85:
        r14 = r21;
        r13 = true;
        goto L86
    L88:
        throw new RuntimeException("Unexpected end of document");
    L89:
        return;
    L5:
        String r34 = r17.getName();
        if (r34.equals("menu") == false) goto L9;
        r10 = r17.next();
        goto L12
    L9:
        throw new RuntimeException("Expecting menu, got ".concat(r34));
    }

    @Override // android.view.MenuInflater
    public final void inflate(int r8, Menu r10) {
        if ((r10 instanceof c0.a) == true) goto L6;
        super.inflate(r8, r10);
        return;
    L6:
        XmlResourceParser r11 = null;
        r11 = this.f7459c.getResources().getLayout(r8);     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L15
        b(r11, Xml.asAttributeSet(r11), r10);     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L15
        r11.close();
        return;
    L10:
        th = move-exception;
        if (r11 == null) goto L20;
        r11.close();
    L20:
        throw th;
    L15:
        e = move-exception;
        throw new InflateException("Error inflating menu XML", e);     // Catch: Throwable -> L10
    L12:
        e = move-exception;
        throw new InflateException("Error inflating menu XML", e);     // Catch: Throwable -> L10
    }
}

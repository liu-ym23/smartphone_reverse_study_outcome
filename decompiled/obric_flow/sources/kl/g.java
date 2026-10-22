package kl;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.gyf.barlibrary.R$id;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f18669n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f18670o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final HashMap f18671p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FragmentActivity f18672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Window f18673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f18674c;
    public ViewGroup d;
    public b e;
    public a f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f18675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f18676i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f18677j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f18678k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f18679l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f18680m;

    static {
        f18669n = R$id.immersion_status_bar_view;
        f18670o = R$id.immersion_navigation_bar_view;
        f18671p = new HashMap();
    }

    public static boolean a(View r10) {
        if (r10.getFitsSystemWindows() == false) goto L6;
        return true;
    L6:
        if ((r10 instanceof ViewGroup) == false) goto L18;
        ViewGroup r11 = (ViewGroup) r10;
        int r5 = r11.getChildCount();
        int r12 = 0;
    L8:
        if (r12 >= r5) goto L18;
        View r13 = r11.getChildAt(r12);
        if ((r13 instanceof DrawerLayout) == false) goto L15;
        if (a(r13) == false) goto L15;
        return true;
    L15:
        if (r13.getFitsSystemWindows() == true) goto L16;
        r12 = r12 + 1;
        goto L8
    L16:
        return true;
    L18:
        return false;
    }

    public static void c(Window r5, String r10, boolean r11) {
        if (r5 == null) goto L13;
        Class<?> r12 = r5.getClass();
        Class<?> r13 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Exception -> L9
        int r14 = r13.getField(r10).getInt(r13);     // Catch: Exception -> L9
        Class r15 = Integer.TYPE;     // Catch: Exception -> L9
        Method r16 = r12.getMethod("setExtraFlags", new Class[]{r15, r15});     // Catch: Exception -> L9
        if (r11 == false) goto L7;
        r16.invoke(r5, new Object[]{Integer.valueOf(r14), Integer.valueOf(r14)});     // Catch: Exception -> L9
    L10:
        return;
    L7:
        r16.invoke(r5, new Object[]{0, Integer.valueOf(r14)});     // Catch: Exception -> L9
    L14:
        return;
    }

    public static g d(Fragment r10) {
        if (r10.getActivity() == null) goto L17;
        HashMap r5 = f18671p;
        g r11 = (g) r5.get(r10.getActivity().toString() + r10.toString());
        if (r11 != null) goto L15;
        FragmentActivity r12 = r10.getActivity();
        r11 = new g();
        r11.f18675h = 0;
        r11.f18676i = 0;
        r11.f18677j = false;
        r11.f18678k = null;
        new HashMap();
        r11.f18679l = false;
        r11.f18680m = false;
        r11.f18672a = r12;
        if (r12 == null) goto L14;
        if (r5.get(r12.toString()) == null) goto L12;
        r11.f18677j = true;
        Window r13 = r12.getWindow();
        r11.f18673b = r13;
        r11.g = r12.toString() + r10.toString();
        r11.e = new b();
        ViewGroup r14 = (ViewGroup) r13.getDecorView();
        r11.f18674c = r14;
        r11.d = (ViewGroup) r14.findViewById(R.id.content);
        r5.put(r10.getActivity().toString() + r10.toString(), r11);
        goto L15
    L12:
        throw new IllegalArgumentException("you should initialize ImmersionBar in Activity first if used in Fragment");
    L14:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    L15:
        return r11;
    L17:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    public final void b() {
        FragmentActivity r5 = this.f18672a;
        if (r5 != null) goto L5;
    L7:
        Iterator r10 = f18671p.entrySet().iterator();
    L9:
        if (r10.hasNext() == false) goto L15;
        Map.Entry r11 = (Map.Entry) r10.next();
        String r12 = (String) r11.getKey();
        String r13 = this.g;
        if (r12.contains(r13) == true) goto L14;
        if (((String) r11.getKey()).equals(r13) == false) goto L9;
    L14:
        r10.remove();
        goto L9
    L15:
        return;
    L5:
        if (this.f18678k == null) goto L7;
        r5.getContentResolver().unregisterContentObserver(this.f18678k);
        this.f18678k = null;
        goto L7
    }
}

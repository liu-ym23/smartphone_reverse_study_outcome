package ia;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.WindowManager;
import com.obric.oui.window.bean.WindowSizeClass;
import ga.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile WindowSizeClass f9446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f9447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ga.a f9448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Set<Integer> f9449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ArrayList<ha.a> f9450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f9451f = null;

    static {
        f9451f = new a();
        f9446a = WindowSizeClass.MINUS_ERROR_SIZE;
        f9447b = 1;
        f9448c = new ga.a(0.0f, 0.0f);
        f9449d = new LinkedHashSet();
        f9450e = new ArrayList();
    }

    private a() {
    }

    private final boolean b(Set<Integer> r10, int r11, Pair<Integer, Integer> r12) {
        if (r10.contains(Integer.valueOf(r11)) == true) goto L24;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r14 = r10.iterator();
    L6:
        if (r14.hasNext() == false) goto L9;
        r13.add(Integer.valueOf((((Number) r14.next()).intValue() - r12.getSecond().intValue()) - r12.getFirst().intValue()));
        goto L6
    L9:
        if (r13.contains(Integer.valueOf(r11)) == true) goto L24;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r16 = r10.iterator();
    L12:
        if (r16.hasNext() == false) goto L15;
        r15.add(Integer.valueOf(((Number) r16.next()).intValue() - r12.getSecond().intValue()));
        goto L12
    L15:
        if (r15.contains(Integer.valueOf(r11)) == true) goto L24;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r18 = r10.iterator();
    L18:
        if (r18.hasNext() == false) goto L21;
        r17.add(Integer.valueOf(((Number) r18.next()).intValue() - r12.getFirst().intValue()));
        goto L18
    L21:
        if (r17.contains(Integer.valueOf(r11)) == true) goto L24;
        return false;
    L24:
        return true;
    }

    private final void f(Context r10) {
        if ((!f9449d.isEmpty()) == false) goto L5;
        return;
    L5:
        Object r11 = null;
        if (r10 == null) goto L8;
        Object r12 = r10.getSystemService("window");
    L10:
        if ((r12 instanceof WindowManager) == false) goto L13;
        r11 = r12;
    L13:
        WindowManager r13 = (WindowManager) r11;
        if (r13 == null) goto L17;
        Point r14 = new Point();
        r13.getDefaultDisplay().getRealSize(r14);
        f9449d.add(Integer.valueOf(r14.x));
        f9449d.add(Integer.valueOf(r14.y));
        return;
    L17:
        return;
    L8:
        r12 = null;
        goto L10
    }

    public final void a(Activity r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "activity");
        f(r10);
        Pair<Integer, Integer> r13 = e(r10);
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return;
    L5:
        if (r10.isInMultiWindowMode() == true) goto L7;
        return;
    L7:
        if (b(f9449d, r11, r13) == true) goto L13;
        b(f9449d, r12, r13);
        return;
    }

    public final ga.a c() {
        return f9448c;
    }

    public final WindowSizeClass d() {
        return f9446a;
    }

    @SuppressLint({"InternalInsetResource"})
    public final Pair<Integer, Integer> e(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, "activity");
        Resources r11 = r10.getResources();
        return new Pair(Integer.valueOf(r11.getDimensionPixelSize(r11.getIdentifier("status_bar_height", "dimen", "android"))), Integer.valueOf(r11.getDimensionPixelSize(r11.getIdentifier("navigation_bar_height", "dimen", "android"))));
    }

    public final void g() {
        Iterator<ha.a> r10 = f9450e.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().a(new f(f9446a, f9448c));
        goto L4
    }

    public final WindowSizeClass h(Activity r10, int r11, int r12, boolean r13) {
        if (r10 == null) goto L60;
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        float r15 = r14.getDisplayMetrics().density;
        float r16 = r11 / r15;
        float r17 = r12 / r15;
        Log.d("AdaptedWindowSize", "setCurrentWindowSize: widthDP = " + r16 + ",heightDp = " + r17);
        f9448c = new ga.a(r16, r17);
        WindowSizeClass r18 = WindowSizeClass.FLOATING_WINDOW;
        if (r16 >= r18.getDpSize()) goto L7;
        Log.e("AdaptedWindowSize", "error,can not be minus status!!");
        r18 = WindowSizeClass.MINUS_ERROR_SIZE;
    L43:
        if (f9446a != r18) goto L45;
    L46:
        int r19 = f9447b;
        Resources r20 = r10.getResources();
        Intrinsics.checkNotNullExpressionValue(r20, "it.resources");
        if (r19 == r20.getConfiguration().orientation) goto L60;
    L48:
        f9446a = r18;
        Resources r21 = r10.getResources();
        if (r21 == null) goto L53;
        Configuration r22 = r21.getConfiguration();
        if (r22 == null) goto L53;
        int r23 = r22.orientation;
    L54:
        f9447b = r23;
        StringBuilder r24 = new StringBuilder();
        r24.append("当前档位：");
        r24.append(f9446a.getBaseGridConfig().a());
        r24.append('\n');
        r24.append("当前页面可用宽高：");
        r24.append(r16);
        r24.append(',');
        r24.append(r17);
        r24.append('\n');
        r24.append("decorViewWidth：");
        r24.append(r11);
        r24.append("，decorVideHeight: ");
        r24.append(r12);
        r24.append('\n');
        r24.append("multiWindowMode = ");
        if (Build.VERSION.SDK_INT < 24) goto L57;
        boolean r25 = r10.isInMultiWindowMode();
    L58:
        r24.append(r25);
        r24.append('\n');
        Log.d("AdaptedWindowSize", "windowMsg = " + r24.toString());
        goto L60
    L57:
        r25 = false;
    L53:
        r23 = 1;
        goto L54
    L45:
        if (r18 != WindowSizeClass.MINUS_ERROR_SIZE) goto L48;
    L7:
        if (r16 >= r18.getDpSize()) goto L9;
    L11:
        r18 = WindowSizeClass.SMALL_SPLIT_SCREEN;
        if (r16 >= r18.getDpSize()) goto L14;
    L16:
        r18 = WindowSizeClass.SMALLER_ANDROID_SCREEN;
        if (r16 >= r18.getDpSize()) goto L19;
    L21:
        r18 = WindowSizeClass.SMALL;
        if (r16 >= r18.getDpSize()) goto L24;
    L26:
        r18 = WindowSizeClass.STANDARD;
        if (r16 >= r18.getDpSize()) goto L29;
    L31:
        r18 = WindowSizeClass.NORMAL;
        if (r16 >= r18.getDpSize()) goto L34;
    L36:
        r18 = WindowSizeClass.LARGE;
        if (r16 >= r18.getDpSize()) goto L39;
    L41:
        r18 = WindowSizeClass.OVERSIZE;
        goto L43
    L39:
        if (r16 >= WindowSizeClass.OVERSIZE.getDpSize()) goto L41;
    L34:
        if (r16 >= WindowSizeClass.LARGE.getDpSize()) goto L36;
    L29:
        if (r16 >= WindowSizeClass.NORMAL.getDpSize()) goto L31;
    L24:
        if (r16 >= WindowSizeClass.STANDARD.getDpSize()) goto L26;
    L19:
        if (r16 >= WindowSizeClass.SMALL.getDpSize()) goto L21;
    L14:
        if (r16 >= WindowSizeClass.SMALLER_ANDROID_SCREEN.getDpSize()) goto L16;
    L9:
        if (r16 >= WindowSizeClass.SMALL_SPLIT_SCREEN.getDpSize()) goto L11;
    L60:
        return f9446a;
    }
}

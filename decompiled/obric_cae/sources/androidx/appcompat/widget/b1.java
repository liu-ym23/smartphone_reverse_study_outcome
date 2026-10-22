package androidx.appcompat.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f1104a = null;

    static {
        Method r8 = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});     // Catch: NoSuchMethodException -> L7
        f1104a = r8;     // Catch: NoSuchMethodException -> L7
        if (r8.isAccessible() == true) goto L11;
        r8.setAccessible(true);     // Catch: NoSuchMethodException -> L7
        return;
    L11:
        return;
    L7:
        Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
    }

    public static boolean a(View r8) {
        WeakHashMap<View, j0.h0> r10 = j0.w.f8437a;
        if (j0.w.e.d(r8) == 1) goto L7;
        return false;
    L7:
        return true;
    }
}

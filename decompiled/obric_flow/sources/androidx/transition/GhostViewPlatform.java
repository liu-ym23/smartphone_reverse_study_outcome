package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class GhostViewPlatform implements GhostView {
    private static final String TAG = "GhostViewApi21";
    private static Method sAddGhostMethod;
    private static boolean sAddGhostMethodFetched;
    private static Class<?> sGhostViewClass;
    private static boolean sGhostViewClassFetched;
    private static Method sRemoveGhostMethod;
    private static boolean sRemoveGhostMethodFetched;
    private final View mGhostView;

    private GhostViewPlatform(@NonNull View r5) {
        this.mGhostView = r5;
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static GhostView addGhost(View r5, ViewGroup r10, Matrix r11) {
        fetchAddGhostMethod();
        Method r12 = sAddGhostMethod;
        if (r12 != null) goto L11;
    L9:
        return null;
    L11:
        return new GhostViewPlatform((View) r12.invoke(null, new Object[]{r5, r10, r11}));
    L6:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }

    private static void fetchAddGhostMethod() {
        if (sAddGhostMethodFetched == false) goto L11;
        return;
    L11:
        fetchGhostViewClass();     // Catch: NoSuchMethodException -> L7
        Method r5 = sGhostViewClass.getDeclaredMethod("addGhost", new Class[]{View.class, ViewGroup.class, Matrix.class});     // Catch: NoSuchMethodException -> L7
        sAddGhostMethod = r5;     // Catch: NoSuchMethodException -> L7
        r5.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L9:
        sAddGhostMethodFetched = true;
        return;
    L7:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve addGhost method", e);
        goto L9
    }

    private static void fetchGhostViewClass() {
        if (sGhostViewClassFetched == true) goto L12;
        sGhostViewClass = Class.forName("android.view.GhostView");     // Catch: ClassNotFoundException -> L6
    L8:
        sGhostViewClassFetched = true;
        return;
    L6:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve GhostView class", e);
        goto L8
    }

    private static void fetchRemoveGhostMethod() {
        if (sRemoveGhostMethodFetched == false) goto L11;
        return;
    L11:
        fetchGhostViewClass();     // Catch: NoSuchMethodException -> L7
        Method r5 = sGhostViewClass.getDeclaredMethod("removeGhost", new Class[]{View.class});     // Catch: NoSuchMethodException -> L7
        sRemoveGhostMethod = r5;     // Catch: NoSuchMethodException -> L7
        r5.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L9:
        sRemoveGhostMethodFetched = true;
        return;
    L7:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve removeGhost method", e);
        goto L9
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static void removeGhost(View r5) {
        fetchRemoveGhostMethod();
        Method r10 = sRemoveGhostMethod;
        if (r10 != null) goto L11;
        return;
    L11:
        r10.invoke(null, new Object[]{r5});     // Catch: InvocationTargetException -> L6 IllegalAccessException -> L10
        goto L14
    L13:
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup r5, View r10) {
    }

    @Override // androidx.transition.GhostView
    public void setVisibility(int r5) {
        this.mGhostView.setVisibility(r5);
    }
}

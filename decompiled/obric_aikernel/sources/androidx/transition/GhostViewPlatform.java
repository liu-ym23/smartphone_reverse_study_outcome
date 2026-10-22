package androidx.transition;

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

    private GhostViewPlatform(@NonNull View r10) {
        this.mGhostView = r10;
    }

    static GhostView addGhost(View r10, ViewGroup r11, Matrix r12) {
        fetchAddGhostMethod();
        Method r13 = sAddGhostMethod;
        if (r13 != null) goto L11;
    L9:
        return null;
    L11:
        return new GhostViewPlatform((View) r13.invoke(null, new Object[]{r10, r11, r12}));
    L6:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }

    private static void fetchAddGhostMethod() {
        if (sAddGhostMethodFetched == false) goto L11;
        return;
    L11:
        fetchGhostViewClass();     // Catch: NoSuchMethodException -> L7
        Method r10 = sGhostViewClass.getDeclaredMethod("addGhost", new Class[]{View.class, ViewGroup.class, Matrix.class});     // Catch: NoSuchMethodException -> L7
        sAddGhostMethod = r10;     // Catch: NoSuchMethodException -> L7
        r10.setAccessible(true);     // Catch: NoSuchMethodException -> L7
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
        Method r10 = sGhostViewClass.getDeclaredMethod("removeGhost", new Class[]{View.class});     // Catch: NoSuchMethodException -> L7
        sRemoveGhostMethod = r10;     // Catch: NoSuchMethodException -> L7
        r10.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L9:
        sRemoveGhostMethodFetched = true;
        return;
    L7:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve removeGhost method", e);
        goto L9
    }

    static void removeGhost(View r10) {
        fetchRemoveGhostMethod();
        Method r11 = sRemoveGhostMethod;
        if (r11 != null) goto L12;
        return;
    L12:
        r11.invoke(null, new Object[]{r10});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L11
        goto L15
    L14:
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup r10, View r11) {
    }

    @Override // androidx.transition.GhostView
    public void setVisibility(int r10) {
        this.mGhostView.setVisibility(r10);
    }
}

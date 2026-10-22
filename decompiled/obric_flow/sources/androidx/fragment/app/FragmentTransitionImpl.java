package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class FragmentTransitionImpl {
    public FragmentTransitionImpl() {
    }

    public static void bfsAddViewChildren(List<View> r10, View r11) {
        int r5 = r10.size();
        if (containedBeforeIndex(r10, r11, r5) == false) goto L6;
        return;
    L6:
        if (ViewCompat.getTransitionName(r11) == null) goto L8;
        r10.add(r11);
    L8:
        int r12 = r5;
    L10:
        if (r12 >= r10.size()) goto L22;
        View r13 = r10.get(r12);
        if ((r13 instanceof ViewGroup) == false) goto L21;
        ViewGroup r14 = (ViewGroup) r13;
        int r15 = r14.getChildCount();
        int r16 = 0;
    L14:
        if (r16 >= r15) goto L21;
        View r17 = r14.getChildAt(r16);
        if (containedBeforeIndex(r10, r17, r5) == true) goto L20;
        if (ViewCompat.getTransitionName(r17) == null) goto L20;
        r10.add(r17);
    L20:
        r16 = r16 + 1;
    L21:
        r12 = r12 + 1;
        goto L10
    }

    private static boolean containedBeforeIndex(List<View> r5, View r10, int r11) {
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (r5.get(r12) == r10) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static boolean isNullOrEmpty(List r5) {
        if (r5 != null) goto L4;
    L7:
        return true;
    L4:
        if (r5.isEmpty() == true) goto L7;
        return false;
    }

    public abstract void addTarget(@NonNull Object r5, @NonNull View r10);

    public abstract void addTargets(@NonNull Object r5, @NonNull ArrayList<View> r10);

    public abstract void beginDelayedTransition(@NonNull ViewGroup r5, @Nullable Object r10);

    public abstract boolean canHandle(@NonNull Object r5);

    public abstract Object cloneTransition(@Nullable Object r5);

    public void getBoundsOnScreen(View r5, Rect r10) {
        if (ViewCompat.isAttachedToWindow(r5) == true) goto L5;
        return;
    L5:
        RectF r11 = new RectF();
        r11.set(0.0f, 0.0f, r5.getWidth(), r5.getHeight());
        r5.getMatrix().mapRect(r11);
        r11.offset(r5.getLeft(), r5.getTop());
        Object r12 = r5.getParent();
    L7:
        if ((r12 instanceof View) == false) goto L9;
        View r13 = (View) r12;
        r11.offset(-r13.getScrollX(), -r13.getScrollY());
        r13.getMatrix().mapRect(r11);
        r11.offset(r13.getLeft(), r13.getTop());
        r12 = r13.getParent();
        goto L7
    L9:
        int[] r14 = new int[2];
        r5.getRootView().getLocationOnScreen(r14);
        r11.offset(r14[0], r14[1]);
        r10.set(Math.round(r11.left), Math.round(r11.top), Math.round(r11.right), Math.round(r11.bottom));
    }

    public abstract Object mergeTransitionsInSequence(@Nullable Object r5, @Nullable Object r10, @Nullable Object r11);

    public abstract Object mergeTransitionsTogether(@Nullable Object r5, @Nullable Object r10, @Nullable Object r11);

    public ArrayList<String> prepareSetNameOverridesReordered(ArrayList<View> r5) {
        ArrayList<String> r10 = new ArrayList();
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        View r13 = r5.get(r12);
        r10.add(ViewCompat.getTransitionName(r13));
        ViewCompat.setTransitionName(r13, null);
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    public abstract void removeTarget(@NonNull Object r5, @NonNull View r10);

    public abstract void replaceTargets(@NonNull Object r5, @SuppressLint({"UnknownNullness"}) ArrayList<View> r10, @SuppressLint({"UnknownNullness"}) ArrayList<View> r11);

    public abstract void scheduleHideFragmentView(@NonNull Object r5, @NonNull View r10, @NonNull ArrayList<View> r11);

    public abstract void scheduleRemoveTargets(@NonNull Object r5, @Nullable Object r10, @Nullable ArrayList<View> r11, @Nullable Object r12, @Nullable ArrayList<View> r13, @Nullable Object r14, @Nullable ArrayList<View> r15);

    public abstract void setEpicenter(@NonNull Object r5, @NonNull Rect r10);

    public abstract void setEpicenter(@NonNull Object r5, @Nullable View r10);

    public void setListenerForTransitionEnd(@NonNull Fragment r5, @NonNull Object r10, @NonNull CancellationSignal r11, @NonNull Runnable r12) {
        r12.run();
    }

    public void setNameOverridesReordered(View r10, final ArrayList<View> r11, final ArrayList<View> r12, final ArrayList<String> r13, Map<String, String> r14) {
        final int r5 = r12.size();
        final ArrayList r15 = new ArrayList();
        int r16 = 0;
    L3:
        if (r16 >= r5) goto L14;
        View r17 = r11.get(r16);
        String r18 = ViewCompat.getTransitionName(r17);
        r15.add(r18);
        if (r18 == null) goto L13;
        ViewCompat.setTransitionName(r17, null);
        String r19 = r14.get(r18);
        int r20 = 0;
    L8:
        if (r20 >= r5) goto L13;
        if (r19.equals(r13.get(r20)) == true) goto L11;
        r20 = r20 + 1;
        goto L8
    L11:
        ViewCompat.setTransitionName(r12.get(r20), r18);
    L13:
        r16 = r16 + 1;
        goto L3
    L14:
        OneShotPreDrawListener.add(r10, new AnonymousClass1(this, r5, r12, r13, r11, r15));
    }

    public abstract void setSharedElementTargets(@NonNull Object r5, @NonNull View r10, @NonNull ArrayList<View> r11);

    public abstract void swapSharedElementTargets(@Nullable Object r5, @Nullable ArrayList<View> r10, @Nullable ArrayList<View> r11);

    public abstract Object wrapTransitionInSet(@Nullable Object r5);
}

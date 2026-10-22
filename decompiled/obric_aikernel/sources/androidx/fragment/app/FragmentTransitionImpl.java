package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class FragmentTransitionImpl {
    public FragmentTransitionImpl() {
    }

    protected static void bfsAddViewChildren(List<View> r10, View r11) {
        int r12 = r10.size();
        if (containedBeforeIndex(r10, r11, r12) == false) goto L6;
        return;
    L6:
        if (ViewCompat.getTransitionName(r11) == null) goto L8;
        r10.add(r11);
    L8:
        int r13 = r12;
    L10:
        if (r13 >= r10.size()) goto L22;
        View r14 = r10.get(r13);
        if ((r14 instanceof ViewGroup) == false) goto L21;
        ViewGroup r15 = (ViewGroup) r14;
        int r16 = r15.getChildCount();
        int r17 = 0;
    L14:
        if (r17 >= r16) goto L21;
        View r18 = r15.getChildAt(r17);
        if (containedBeforeIndex(r10, r18, r12) == true) goto L20;
        if (ViewCompat.getTransitionName(r18) == null) goto L20;
        r10.add(r18);
    L20:
        r17 = r17 + 1;
    L21:
        r13 = r13 + 1;
        goto L10
    }

    private static boolean containedBeforeIndex(List<View> r10, View r11, int r12) {
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r10.get(r13) == r11) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    static String findKeyForValue(Map<String, String> r10, String r11) {
        Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Map.Entry<String, String> r13 = r12.next();
        if (r11.equals(r13.getValue()) == false) goto L4;
        return r13.getKey();
    L9:
        return null;
    }

    protected static boolean isNullOrEmpty(List r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.isEmpty() == true) goto L7;
        return false;
    }

    public abstract void addTarget(Object r10, View r11);

    public abstract void addTargets(Object r10, ArrayList<View> r11);

    public abstract void beginDelayedTransition(ViewGroup r10, Object r11);

    public abstract boolean canHandle(Object r10);

    void captureTransitioningViews(ArrayList<View> r10, View r11) {
        if (r11.getVisibility() != 0) goto L15;
        boolean r12 = r11 instanceof ViewGroup;
        View r13 = r11;
        if (r12 == false) goto L12;
        ViewGroup r14 = (ViewGroup) r11;
        boolean r15 = ViewGroupCompat.isTransitionGroup(r14);
        r13 = r14;
        if (r15 == true) goto L12;
        int r16 = r14.getChildCount();
        int r17 = 0;
    L10:
        if (r17 >= r16) goto L16;
        captureTransitioningViews(r10, r14.getChildAt(r17));
        r17 = r17 + 1;
        goto L10
    L16:
        return;
    L12:
        r10.add(r13);
        return;
    }

    public abstract Object cloneTransition(Object r10);

    void findNamedViews(Map<String, View> r10, @NonNull View r11) {
        if (r11.getVisibility() != 0) goto L12;
        String r12 = ViewCompat.getTransitionName(r11);
        if (r12 == null) goto L8;
        r10.put(r12, r11);
    L8:
        if ((r11 instanceof ViewGroup) == false) goto L14;
        ViewGroup r13 = (ViewGroup) r11;
        int r14 = r13.getChildCount();
        int r15 = 0;
    L10:
        if (r15 >= r14) goto L15;
        findNamedViews(r10, r13.getChildAt(r15));
        r15 = r15 + 1;
        goto L10
    L15:
        return;
    L14:
        return;
    }

    protected void getBoundsOnScreen(View r10, Rect r11) {
        if (ViewCompat.isAttachedToWindow(r10) == true) goto L5;
        return;
    L5:
        RectF r12 = new RectF();
        r12.set(0.0f, 0.0f, r10.getWidth(), r10.getHeight());
        r10.getMatrix().mapRect(r12);
        r12.offset(r10.getLeft(), r10.getTop());
        Object r13 = r10.getParent();
    L7:
        if ((r13 instanceof View) == false) goto L9;
        View r14 = (View) r13;
        r12.offset(-r14.getScrollX(), -r14.getScrollY());
        r14.getMatrix().mapRect(r12);
        r12.offset(r14.getLeft(), r14.getTop());
        r13 = r14.getParent();
        goto L7
    L9:
        int[] r15 = new int[2];
        r10.getRootView().getLocationOnScreen(r15);
        r12.offset(r15[0], r15[1]);
        r11.set(Math.round(r12.left), Math.round(r12.top), Math.round(r12.right), Math.round(r12.bottom));
    }

    public abstract Object mergeTransitionsInSequence(Object r10, Object r11, Object r12);

    public abstract Object mergeTransitionsTogether(Object r10, Object r11, Object r12);

    ArrayList<String> prepareSetNameOverridesReordered(ArrayList<View> r10) {
        ArrayList<String> r11 = new ArrayList();
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        View r14 = r10.get(r13);
        r11.add(ViewCompat.getTransitionName(r14));
        ViewCompat.setTransitionName(r14, null);
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public abstract void removeTarget(Object r10, View r11);

    public abstract void replaceTargets(Object r10, ArrayList<View> r11, ArrayList<View> r12);

    public abstract void scheduleHideFragmentView(Object r10, View r11, ArrayList<View> r12);

    void scheduleNameReset(ViewGroup r10, final ArrayList<View> r11, final Map<String, String> r12) {
        OneShotPreDrawListener.add(r10, new AnonymousClass3(this, r11, r12));
    }

    public abstract void scheduleRemoveTargets(Object r10, Object r11, ArrayList<View> r12, Object r13, ArrayList<View> r14, Object r15, ArrayList<View> r16);

    public abstract void setEpicenter(Object r10, Rect r11);

    public abstract void setEpicenter(Object r10, View r11);

    public void setListenerForTransitionEnd(@NonNull Fragment r10, @NonNull Object r11, @NonNull CancellationSignal r12, @NonNull Runnable r13) {
        r13.run();
    }

    void setNameOverridesOrdered(View r10, final ArrayList<View> r11, final Map<String, String> r12) {
        OneShotPreDrawListener.add(r10, new AnonymousClass2(this, r11, r12));
    }

    void setNameOverridesReordered(View r10, final ArrayList<View> r11, final ArrayList<View> r12, final ArrayList<String> r13, Map<String, String> r14) {
        final int r15 = r12.size();
        final ArrayList r16 = new ArrayList();
        int r17 = 0;
    L3:
        if (r17 >= r15) goto L14;
        View r18 = r11.get(r17);
        String r19 = ViewCompat.getTransitionName(r18);
        r16.add(r19);
        if (r19 == null) goto L13;
        ViewCompat.setTransitionName(r18, null);
        String r20 = r14.get(r19);
        int r21 = 0;
    L8:
        if (r21 >= r15) goto L13;
        if (r20.equals(r13.get(r21)) == true) goto L11;
        r21 = r21 + 1;
        goto L8
    L11:
        ViewCompat.setTransitionName(r12.get(r21), r19);
    L13:
        r17 = r17 + 1;
        goto L3
    L14:
        OneShotPreDrawListener.add(r10, new AnonymousClass1(this, r15, r12, r13, r11, r16));
    }

    public abstract void setSharedElementTargets(Object r10, View r11, ArrayList<View> r12);

    public abstract void swapSharedElementTargets(Object r10, ArrayList<View> r11, ArrayList<View> r12);

    public abstract Object wrapTransitionInSet(Object r10);
}

package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class TransitionManager {
    private static final String LOG_TAG = "TransitionManager";
    private static Transition sDefaultTransition;
    static ArrayList<ViewGroup> sPendingTransitions;
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> sRunningTransitions;
    private ArrayMap<Scene, ArrayMap<Scene, Transition>> mScenePairTransitions;
    private ArrayMap<Scene, Transition> mSceneTransitions;

    private static class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        ViewGroup mSceneRoot;
        Transition mTransition;

        MultiListener(Transition r10, ViewGroup r11) {
            this.mTransition = r10;
            this.mSceneRoot = r11;
        }

        private void removeListeners() {
            this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
            this.mSceneRoot.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            removeListeners();
            if (TransitionManager.sPendingTransitions.remove(this.mSceneRoot) == true) goto L5;
            return true;
        L5:
            final ArrayMap<ViewGroup, ArrayList<Transition>> r10 = TransitionManager.getRunningTransitions();
            ArrayList<Transition> r11 = r10.get(this.mSceneRoot);
            ArrayList r12 = null;
            if (r11 != null) goto L9;
            r11 = new ArrayList();
            r10.put(this.mSceneRoot, r11);
        L11:
            r11.add(this.mTransition);
            this.mTransition.addListener(new AnonymousClass1(this, r10));
            this.mTransition.captureValues(this.mSceneRoot, false);
            if (r12 == null) goto L17;
            Iterator r13 = r12.iterator();
        L15:
            if (r13.hasNext() == false) goto L17;
            ((Transition) r13.next()).resume(this.mSceneRoot);
        L17:
            this.mTransition.playTransition(this.mSceneRoot);
            return true;
        L9:
            if (r11.size() <= 0) goto L11;
            r12 = new ArrayList(r11);
            goto L11
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
            removeListeners();
            TransitionManager.sPendingTransitions.remove(this.mSceneRoot);
            ArrayList<Transition> r11 = TransitionManager.getRunningTransitions().get(this.mSceneRoot);
            if (r11 != null) goto L5;
        L10:
            this.mTransition.clearValues(true);
            return;
        L5:
            if (r11.size() <= 0) goto L10;
            Iterator<Transition> r12 = r11.iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            r12.next().resume(this.mSceneRoot);
            goto L8
        }
    }

    static {
        sDefaultTransition = new AutoTransition();
        sRunningTransitions = new ThreadLocal();
        sPendingTransitions = new ArrayList();
    }

    public TransitionManager() {
        this.mSceneTransitions = new ArrayMap();
        this.mScenePairTransitions = new ArrayMap();
    }

    public static void beginDelayedTransition(@NonNull ViewGroup r10) {
        beginDelayedTransition(r10, null);
    }

    public static void beginDelayedTransition(@NonNull ViewGroup r10, @Nullable Transition r11) {
        if (sPendingTransitions.contains(r10) == false) goto L5;
        return;
    L5:
        if (ViewCompat.isLaidOut(r10) == false) goto L12;
        sPendingTransitions.add(r10);
        if (r11 != null) goto L9;
        r11 = sDefaultTransition;
    L9:
        Transition r12 = r11.clone();
        sceneChangeSetup(r10, r12);
        Scene.setCurrentScene(r10, null);
        sceneChangeRunTransition(r10, r12);
        return;
    }

    private static void changeScene(Scene r10, Transition r11) {
        ViewGroup r12 = r10.getSceneRoot();
        if (sPendingTransitions.contains(r12) == true) goto L16;
        Scene r13 = Scene.getCurrentScene(r12);
        if (r11 != null) goto L9;
        if (r13 == null) goto L8;
        r13.exit();
    L8:
        r10.enter();
        return;
    L9:
        sPendingTransitions.add(r12);
        Transition r14 = r11.clone();
        r14.setSceneRoot(r12);
        if (r13 != null) goto L12;
    L14:
        sceneChangeSetup(r12, r14);
        r10.enter();
        sceneChangeRunTransition(r12, r14);
        return;
    L12:
        if (r13.isCreatedFromLayoutResource() == false) goto L14;
        r14.setCanRemoveViews(true);
        goto L14
    }

    public static void endTransitions(ViewGroup r10) {
        sPendingTransitions.remove(r10);
        ArrayList<Transition> r11 = getRunningTransitions().get(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isEmpty() == true) goto L11;
        ArrayList r12 = new ArrayList(r11);
        int r13 = r12.size() - 1;
    L7:
        if (r13 < 0) goto L12;
        ((Transition) r12.get(r13)).forceToEnd(r10);
        r13 = r13 - 1;
        goto L7
    L12:
        return;
    }

    static ArrayMap<ViewGroup, ArrayList<Transition>> getRunningTransitions() {
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> r10 = sRunningTransitions.get();
        if (r10 == null) goto L7;
        ArrayMap<ViewGroup, ArrayList<Transition>> r11 = r10.get();
        if (r11 == null) goto L7;
        return r11;
    L7:
        ArrayMap<ViewGroup, ArrayList<Transition>> r12 = new ArrayMap();
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> r13 = new WeakReference(r12);
        sRunningTransitions.set(r13);
        return r12;
    }

    private Transition getTransition(Scene r10) {
        ViewGroup r11 = r10.getSceneRoot();
        if (r11 == null) goto L11;
        Scene r12 = Scene.getCurrentScene(r11);
        if (r12 == null) goto L11;
        ArrayMap<Scene, Transition> r13 = this.mScenePairTransitions.get(r10);
        if (r13 == null) goto L11;
        Transition r14 = r13.get(r12);
        if (r14 == null) goto L11;
        return r14;
    L11:
        Transition r15 = this.mSceneTransitions.get(r10);
        if (r15 == null) goto L15;
        return r15;
    L15:
        return sDefaultTransition;
    }

    public static void go(@NonNull Scene r10) {
        changeScene(r10, sDefaultTransition);
    }

    public static void go(@NonNull Scene r10, @Nullable Transition r11) {
        changeScene(r10, r11);
    }

    private static void sceneChangeRunTransition(ViewGroup r10, Transition r11) {
        if (r11 == null) goto L6;
        if (r10 == null) goto L7;
        MultiListener r12 = new MultiListener(r11, r10);
        r10.addOnAttachStateChangeListener(r12);
        r10.getViewTreeObserver().addOnPreDrawListener(r12);
        return;
    L7:
        return;
    }

    private static void sceneChangeSetup(ViewGroup r10, Transition r11) {
        ArrayList<Transition> r12 = getRunningTransitions().get(r10);
        if (r12 != null) goto L5;
    L10:
        if (r11 == null) goto L12;
        r11.captureValues(r10, true);
    L12:
        Scene r13 = Scene.getCurrentScene(r10);
        if (r13 == null) goto L17;
        r13.exit();
        return;
    L17:
        return;
    L5:
        if (r12.size() <= 0) goto L10;
        Iterator<Transition> r14 = r12.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r14.next().pause(r10);
        goto L8
    }

    public void setTransition(@NonNull Scene r10, @NonNull Scene r11, @Nullable Transition r12) {
        ArrayMap<Scene, Transition> r13 = this.mScenePairTransitions.get(r11);
        if (r13 != null) goto L5;
        r13 = new ArrayMap();
        this.mScenePairTransitions.put(r11, r13);
    L5:
        r13.put(r10, r12);
    }

    public void setTransition(@NonNull Scene r10, @Nullable Transition r11) {
        this.mSceneTransitions.put(r10, r11);
    }

    public void transitionTo(@NonNull Scene r10) {
        changeScene(r10, getTransition(r10));
    }
}

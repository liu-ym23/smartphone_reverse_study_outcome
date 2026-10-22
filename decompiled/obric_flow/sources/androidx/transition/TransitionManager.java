package androidx.transition;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
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

    public static class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        ViewGroup mSceneRoot;
        Transition mTransition;

        public MultiListener(Transition r5, ViewGroup r10) {
            this.mTransition = r5;
            this.mSceneRoot = r10;
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
            final ArrayMap<ViewGroup, ArrayList<Transition>> r5 = TransitionManager.getRunningTransitions();
            ArrayList<Transition> r10 = r5.get(this.mSceneRoot);
            ArrayList r11 = null;
            if (r10 != null) goto L9;
            r10 = new ArrayList();
            r5.put(this.mSceneRoot, r10);
        L11:
            r10.add(this.mTransition);
            this.mTransition.addListener(new AnonymousClass1(this, r5));
            this.mTransition.captureValues(this.mSceneRoot, false);
            if (r11 == null) goto L17;
            Iterator r12 = r11.iterator();
        L15:
            if (r12.hasNext() == false) goto L17;
            ((Transition) r12.next()).resume(this.mSceneRoot);
        L17:
            this.mTransition.playTransition(this.mSceneRoot);
            return true;
        L9:
            if (r10.size() <= 0) goto L11;
            r11 = new ArrayList(r10);
            goto L11
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r5) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r5) {
            removeListeners();
            TransitionManager.sPendingTransitions.remove(this.mSceneRoot);
            ArrayList<Transition> r10 = TransitionManager.getRunningTransitions().get(this.mSceneRoot);
            if (r10 != null) goto L5;
        L10:
            this.mTransition.clearValues(true);
            return;
        L5:
            if (r10.size() <= 0) goto L10;
            Iterator<Transition> r11 = r10.iterator();
        L8:
            if (r11.hasNext() == false) goto L10;
            r11.next().resume(this.mSceneRoot);
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

    public static void beginDelayedTransition(@NonNull ViewGroup r5) {
        beginDelayedTransition(r5, null);
    }

    private static void changeScene(Scene r5, Transition r10) {
        ViewGroup r11 = r5.getSceneRoot();
        if (sPendingTransitions.contains(r11) == true) goto L16;
        Scene r12 = Scene.getCurrentScene(r11);
        if (r10 != null) goto L9;
        if (r12 == null) goto L8;
        r12.exit();
    L8:
        r5.enter();
        return;
    L9:
        sPendingTransitions.add(r11);
        Transition r13 = r10.clone();
        if (r12 != null) goto L12;
    L14:
        sceneChangeSetup(r11, r13);
        r5.enter();
        sceneChangeRunTransition(r11, r13);
        return;
    L12:
        if (r12.isCreatedFromLayoutResource() == false) goto L14;
        r13.setCanRemoveViews(true);
        goto L14
    }

    @Nullable
    public static TransitionSeekController controlDelayedTransition(@NonNull ViewGroup r5, @NonNull Transition r10) {
        if (sPendingTransitions.contains(r5) == false) goto L5;
    L15:
        return null;
    L5:
        if (r5.isLaidOut() == false) goto L15;
        if (Build.VERSION.SDK_INT < 34) goto L15;
        if (r10.isSeekingSupported() == false) goto L14;
        sPendingTransitions.add(r5);
        Transition r11 = r10.clone();
        TransitionSet r12 = new TransitionSet();
        r12.addTransition(r11);
        sceneChangeSetup(r5, r12);
        Scene.setCurrentScene(r5, null);
        sceneChangeRunTransition(r5, r12);
        r5.invalidate();
        return r12.createSeekController();
    L14:
        throw new IllegalArgumentException("The Transition must support seeking.");
    }

    @Nullable
    public static TransitionSeekController createSeekController(@NonNull Scene r5, @NonNull Transition r10) {
        ViewGroup r11 = r5.getSceneRoot();
        if (r10.isSeekingSupported() == false) goto L24;
        if (sPendingTransitions.contains(r11) == false) goto L7;
        return null;
    L7:
        Scene r12 = Scene.getCurrentScene(r11);
        if (r11.isLaidOut() == true) goto L10;
    L19:
        if (r12 == null) goto L21;
        r12.exit();
    L21:
        r5.enter();
        return null;
    L10:
        if (Build.VERSION.SDK_INT < 34) goto L19;
        sPendingTransitions.add(r11);
        Transition r13 = r10.clone();
        TransitionSet r14 = new TransitionSet();
        r14.addTransition(r13);
        if (r12 != null) goto L15;
    L17:
        sceneChangeSetup(r11, r14);
        r5.enter();
        sceneChangeRunTransition(r11, r14);
        return r14.createSeekController();
    L15:
        if (r12.isCreatedFromLayoutResource() == false) goto L17;
        r14.setCanRemoveViews(true);
        goto L17
    L24:
        throw new IllegalArgumentException("The Transition must support seeking.");
    }

    public static void endTransitions(@Nullable ViewGroup r5) {
        sPendingTransitions.remove(r5);
        ArrayList<Transition> r10 = getRunningTransitions().get(r5);
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L11;
        ArrayList r11 = new ArrayList(r10);
        int r12 = r11.size() - 1;
    L7:
        if (r12 < 0) goto L12;
        ((Transition) r11.get(r12)).forceToEnd(r5);
        r12 = r12 - 1;
        goto L7
    L12:
        return;
    }

    @VisibleForTesting
    public static ArrayMap<ViewGroup, ArrayList<Transition>> getRunningTransitions() {
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> r5 = sRunningTransitions.get();
        if (r5 == null) goto L7;
        ArrayMap<ViewGroup, ArrayList<Transition>> r10 = r5.get();
        if (r10 == null) goto L7;
        return r10;
    L7:
        ArrayMap<ViewGroup, ArrayList<Transition>> r11 = new ArrayMap();
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> r12 = new WeakReference(r11);
        sRunningTransitions.set(r12);
        return r11;
    }

    private Transition getTransition(Scene r5) {
        Scene r10 = Scene.getCurrentScene(r5.getSceneRoot());
        if (r10 == null) goto L9;
        ArrayMap<Scene, Transition> r11 = this.mScenePairTransitions.get(r5);
        if (r11 == null) goto L9;
        Transition r12 = r11.get(r10);
        if (r12 == null) goto L9;
        return r12;
    L9:
        Transition r13 = this.mSceneTransitions.get(r5);
        if (r13 == null) goto L13;
        return r13;
    L13:
        return sDefaultTransition;
    }

    public static void go(@NonNull Scene r5) {
        changeScene(r5, sDefaultTransition);
    }

    private static void sceneChangeRunTransition(ViewGroup r5, Transition r10) {
        if (r10 == null) goto L6;
        if (r5 == null) goto L7;
        MultiListener r11 = new MultiListener(r10, r5);
        r5.addOnAttachStateChangeListener(r11);
        r5.getViewTreeObserver().addOnPreDrawListener(r11);
        return;
    L7:
        return;
    }

    private static void sceneChangeSetup(ViewGroup r5, Transition r10) {
        ArrayList<Transition> r11 = getRunningTransitions().get(r5);
        if (r11 != null) goto L5;
    L10:
        if (r10 == null) goto L12;
        r10.captureValues(r5, true);
    L12:
        Scene r12 = Scene.getCurrentScene(r5);
        if (r12 == null) goto L17;
        r12.exit();
        return;
    L17:
        return;
    L5:
        if (r11.size() <= 0) goto L10;
        Iterator<Transition> r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        r13.next().pause(r5);
        goto L8
    }

    public void setTransition(@NonNull Scene r5, @Nullable Transition r10) {
        this.mSceneTransitions.put(r5, r10);
    }

    public void transitionTo(@NonNull Scene r5) {
        changeScene(r5, getTransition(r5));
    }

    public static void beginDelayedTransition(@NonNull ViewGroup r5, @Nullable Transition r10) {
        if (sPendingTransitions.contains(r5) == false) goto L5;
        return;
    L5:
        if (r5.isLaidOut() == false) goto L12;
        sPendingTransitions.add(r5);
        if (r10 != null) goto L9;
        r10 = sDefaultTransition;
    L9:
        Transition r11 = r10.clone();
        sceneChangeSetup(r5, r11);
        Scene.setCurrentScene(r5, null);
        sceneChangeRunTransition(r5, r11);
        return;
    }

    public static void go(@NonNull Scene r5, @Nullable Transition r10) {
        changeScene(r5, r10);
    }

    public void setTransition(@NonNull Scene r5, @NonNull Scene r10, @Nullable Transition r11) {
        ArrayMap<Scene, Transition> r12 = this.mScenePairTransitions.get(r10);
        if (r12 != null) goto L5;
        r12 = new ArrayMap();
        this.mScenePairTransitions.put(r10, r12);
    L5:
        r12.put(r5, r11);
    }
}

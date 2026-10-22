package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    private static class MultiListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
        ViewGroup mSceneRoot;
        Transition mTransition;

        MultiListener(Transition r1, ViewGroup r2) {
            this.mTransition = r1;
            this.mSceneRoot = r2;
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
            final ArrayMap<ViewGroup, ArrayList<Transition>> r0 = TransitionManager.getRunningTransitions();
            ArrayList<Transition> r2 = (ArrayList) ZeusTransformUtils.preCheckCast(r0.get(this.mSceneRoot), ArrayList.class, "com.obric.memorydata.plugin");
            ArrayList r3 = null;
            if (r2 != null) goto L9;
            r2 = new ArrayList();
            r0.put(this.mSceneRoot, r2);
        L11:
            r2.add(this.mTransition);
            this.mTransition.addListener(new AnonymousClass1(this, r0));
            this.mTransition.captureValues(this.mSceneRoot, false);
            if (r3 == null) goto L17;
            Iterator r1 = r3.iterator();
        L15:
            if (r1.hasNext() == false) goto L17;
            ((Transition) ZeusTransformUtils.preCheckCast(r1.next(), Transition.class, "com.obric.memorydata.plugin")).resume(this.mSceneRoot);
        L17:
            this.mTransition.playTransition(this.mSceneRoot);
            return true;
        L9:
            if (r2.size() <= 0) goto L11;
            r3 = new ArrayList(r2);
            goto L11
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r1) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r4) {
            removeListeners();
            TransitionManager.sPendingTransitions.remove(this.mSceneRoot);
            ArrayList r5 = (ArrayList) ZeusTransformUtils.preCheckCast(TransitionManager.getRunningTransitions().get(this.mSceneRoot), ArrayList.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L5;
        L10:
            this.mTransition.clearValues(true);
            return;
        L5:
            if (r5.size() <= 0) goto L10;
            Iterator r6 = r5.iterator();
        L8:
            if (r6.hasNext() == false) goto L10;
            ((Transition) ZeusTransformUtils.preCheckCast(r6.next(), Transition.class, "com.obric.memorydata.plugin")).resume(this.mSceneRoot);
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

    public static void beginDelayedTransition(ViewGroup r1) {
        beginDelayedTransition(r1, null);
    }

    public static void beginDelayedTransition(ViewGroup r1, Transition r2) {
        if (sPendingTransitions.contains(r1) == false) goto L5;
        return;
    L5:
        if (ViewCompat.isLaidOut(r1) == false) goto L12;
        sPendingTransitions.add(r1);
        if (r2 != null) goto L9;
        r2 = sDefaultTransition;
    L9:
        Transition r3 = r2.clone();
        sceneChangeSetup(r1, r3);
        Scene.setCurrentScene(r1, null);
        sceneChangeRunTransition(r1, r3);
        return;
    }

    private static void changeScene(Scene r3, Transition r4) {
        ViewGroup r0 = r3.getSceneRoot();
        if (sPendingTransitions.contains(r0) == true) goto L16;
        Scene r1 = Scene.getCurrentScene(r0);
        if (r4 != null) goto L9;
        if (r1 == null) goto L8;
        r1.exit();
    L8:
        r3.enter();
        return;
    L9:
        sPendingTransitions.add(r0);
        Transition r5 = r4.clone();
        r5.setSceneRoot(r0);
        if (r1 != null) goto L12;
    L14:
        sceneChangeSetup(r0, r5);
        r3.enter();
        sceneChangeRunTransition(r0, r5);
        return;
    L12:
        if (r1.isCreatedFromLayoutResource() == false) goto L14;
        r5.setCanRemoveViews(true);
        goto L14
    }

    public static void endTransitions(ViewGroup r5) {
        sPendingTransitions.remove(r5);
        ArrayList r0 = (ArrayList) ZeusTransformUtils.preCheckCast(getRunningTransitions().get(r5), ArrayList.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L11;
        ArrayList r1 = new ArrayList(r0);
        int r2 = r1.size() - 1;
    L7:
        if (r2 < 0) goto L12;
        ((Transition) ZeusTransformUtils.preCheckCast(r1.get(r2), Transition.class, "com.obric.memorydata.plugin")).forceToEnd(r5);
        r2 = r2 - 1;
        goto L7
    L12:
        return;
    }

    static ArrayMap<ViewGroup, ArrayList<Transition>> getRunningTransitions() {
        WeakReference r0 = (WeakReference) ZeusTransformUtils.preCheckCast(sRunningTransitions.get(), WeakReference.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        ArrayMap<ViewGroup, ArrayList<Transition>> r1 = (ArrayMap) ZeusTransformUtils.preCheckCast(r0.get(), ArrayMap.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        return r1;
    L7:
        ArrayMap<ViewGroup, ArrayList<Transition>> r2 = new ArrayMap();
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> r3 = new WeakReference(r2);
        sRunningTransitions.set(r3);
        return r2;
    }

    private Transition getTransition(Scene r5) {
        ViewGroup r0 = r5.getSceneRoot();
        if (r0 == null) goto L11;
        Scene r1 = Scene.getCurrentScene(r0);
        if (r1 == null) goto L11;
        ArrayMap r2 = (ArrayMap) ZeusTransformUtils.preCheckCast(this.mScenePairTransitions.get(r5), ArrayMap.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        Transition r3 = (Transition) ZeusTransformUtils.preCheckCast(r2.get(r1), Transition.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        return r3;
    L11:
        Transition r4 = (Transition) ZeusTransformUtils.preCheckCast(this.mSceneTransitions.get(r5), Transition.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L15;
        return r4;
    L15:
        return sDefaultTransition;
    }

    public static void go(Scene r1) {
        changeScene(r1, sDefaultTransition);
    }

    public static void go(Scene r0, Transition r1) {
        changeScene(r0, r1);
    }

    private static void sceneChangeRunTransition(ViewGroup r1, Transition r2) {
        if (r2 == null) goto L6;
        if (r1 == null) goto L7;
        MultiListener r0 = new MultiListener(r2, r1);
        r1.addOnAttachStateChangeListener(r0);
        r1.getViewTreeObserver().addOnPreDrawListener(r0);
        return;
    L7:
        return;
    }

    private static void sceneChangeSetup(ViewGroup r4, Transition r5) {
        ArrayList r0 = (ArrayList) ZeusTransformUtils.preCheckCast(getRunningTransitions().get(r4), ArrayList.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L10:
        if (r5 == null) goto L12;
        r5.captureValues(r4, true);
    L12:
        Scene r6 = Scene.getCurrentScene(r4);
        if (r6 == null) goto L17;
        r6.exit();
        return;
    L17:
        return;
    L5:
        if (r0.size() <= 0) goto L10;
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((Transition) ZeusTransformUtils.preCheckCast(r1.next(), Transition.class, "com.obric.memorydata.plugin")).pause(r4);
        goto L8
    }

    public void setTransition(Scene r4, Scene r5, Transition r6) {
        ArrayMap<Scene, Transition> r0 = (ArrayMap) ZeusTransformUtils.preCheckCast(this.mScenePairTransitions.get(r5), ArrayMap.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new ArrayMap();
        this.mScenePairTransitions.put(r5, r0);
    L5:
        r0.put(r4, r6);
    }

    public void setTransition(Scene r1, Transition r2) {
        this.mSceneTransitions.put(r1, r2);
    }

    public void transitionTo(Scene r1) {
        changeScene(r1, getTransition(r1));
    }
}

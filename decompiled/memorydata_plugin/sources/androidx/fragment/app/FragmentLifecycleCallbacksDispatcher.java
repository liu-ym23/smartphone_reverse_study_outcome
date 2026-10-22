package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
class FragmentLifecycleCallbacksDispatcher {
    private final FragmentManager mFragmentManager;
    private final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> mLifecycleCallbacks;

    private static final class FragmentLifecycleCallbacksHolder {
        final FragmentManager.FragmentLifecycleCallbacks mCallback;
        final boolean mRecursive;

        FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks r1, boolean r2) {
            this.mCallback = r1;
            this.mRecursive = r2;
        }
    }

    FragmentLifecycleCallbacksDispatcher(FragmentManager r2) {
        this.mLifecycleCallbacks = new CopyOnWriteArrayList();
        this.mFragmentManager = r2;
    }

    void dispatchOnFragmentActivityCreated(Fragment r5, Bundle r6, boolean r7) {
        Fragment r0 = this.mFragmentManager.getParent();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentActivityCreated(r5, r6, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r1 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r2 = (FragmentLifecycleCallbacksHolder) ZeusTransformUtils.preCheckCast(r1.next(), FragmentLifecycleCallbacksHolder.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L12;
        if (r2.mRecursive == false) goto L7;
    L12:
        r2.mCallback.onFragmentActivityCreated(this.mFragmentManager, r5, r6);
        goto L7
    }

    void dispatchOnFragmentAttached(Fragment r6, boolean r7) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mFragmentManager.getHost().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Fragment r2 = this.mFragmentManager.getParent();
        if (r2 == null) goto L5;
        r2.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentAttached(r6, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r3 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r3.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r4 = (FragmentLifecycleCallbacksHolder) ZeusTransformUtils.preCheckCast(r3.next(), FragmentLifecycleCallbacksHolder.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L12;
        if (r4.mRecursive == false) goto L7;
    L12:
        r4.mCallback.onFragmentAttached(this.mFragmentManager, r6, r0);
        goto L7
    }

    void dispatchOnFragmentCreated(Fragment r5, Bundle r6, boolean r7) {
        Fragment r0 = this.mFragmentManager.getParent();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentCreated(r5, r6, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r1 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r2 = (FragmentLifecycleCallbacksHolder) ZeusTransformUtils.preCheckCast(r1.next(), FragmentLifecycleCallbacksHolder.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L12;
        if (r2.mRecursive == false) goto L7;
    L12:
        r2.mCallback.onFragmentCreated(this.mFragmentManager, r5, r6);
        goto L7
    }

    void dispatchOnFragmentDestroyed(Fragment r5, boolean r6) {
        Fragment r0 = this.mFragmentManager.getParent();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDestroyed(r5, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r1 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r2 = (FragmentLifecycleCallbacksHolder) ZeusTransformUtils.preCheckCast(r1.next(), FragmentLifecycleCallbacksHolder.class, "com.obric.memorydata.plugin");
        if (r6 == false) goto L12;
        if (r2.mRecursive == false) goto L7;
    L12:
        r2.mCallback.onFragmentDestroyed(this.mFragmentManager, r5);
        goto L7
    }

    void dispatchOnFragmentDetached(Fragment r5, boolean r6) {
        Fragment r0 = this.mFragmentManager.getParent();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDetached(r5, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r1 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r2 = (FragmentLifecycleCallbacksHolder) ZeusTransformUtils.preCheckCast(r1.next(), FragmentLifecycleCallbacksHolder.class, "com.obric.memorydata.plugin");
        if (r6 == false) goto L12;
        if (r2.mRecursive == false) goto L7;
    L12:
        r2.mCallback.onFragmentDetached(this.mFragmentManager, r5);
        goto L7
    }

    void dispatchOnFragmentPaused(Fragment r5, boolean r6) {
        Fragment r0 = this.mFragmentManager.getParent();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPaused(r5, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r1 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r2 = (FragmentLifecycleCallbacksHolder) ZeusTransformUtils.preCheckCast(r1.next(), FragmentLifecycleCallbacksHolder.class, "com.obric.memorydata.plugin");
        if (r6 == false) goto L12;
        if (r2.mRecursive == false) goto L7;
    L12:
        r2.mCallback.onFragmentPaused(this.mFragmentManager, r5);
        goto L7
    }

    void dispatchOnFragmentPreAttached(Fragment r6, boolean r7) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mFragmentManager.getHost().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Fragment r2 = this.mFragmentManager.getParent();
        if (r2 == null) goto L5;
        r2.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreAttached(r6, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r3 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r3.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r4 = (FragmentLifecycleCallbacksHolder) ZeusTransformUtils.preCheckCast(r3.next(), FragmentLifecycleCallbacksHolder.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L12;
        if (r4.mRecursive == false) goto L7;
    L12:
        r4.mCallback.onFragmentPreAttached(this.mFragmentManager, r6, r0);
        goto L7
    }

    void dispatchOnFragmentPreCreated(Fragment r5, Bundle r6, boolean r7) {
        Fragment r0 = this.mFragmentManager.getParent();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreCreated(r5, r6, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r1 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r2 = (FragmentLifecycleCallbacksHolder) ZeusTransformUtils.preCheckCast(r1.next(), FragmentLifecycleCallbacksHolder.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L12;
        if (r2.mRecursive == false) goto L7;
    L12:
        r2.mCallback.onFragmentPreCreated(this.mFragmentManager, r5, r6);
        goto L7
    }

    void dispatchOnFragmentResumed(Fragment r5, boolean r6) {
        Fragment r0 = this.mFragmentManager.getParent();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentResumed(r5, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r1 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r2 = (FragmentLifecycleCallbacksHolder) ZeusTransformUtils.preCheckCast(r1.next(), FragmentLifecycleCallbacksHolder.class, "com.obric.memorydata.plugin");
        if (r6 == false) goto L12;
        if (r2.mRecursive == false) goto L7;
    L12:
        r2.mCallback.onFragmentResumed(this.mFragmentManager, r5);
        goto L7
    }

    void dispatchOnFragmentSaveInstanceState(Fragment r5, Bundle r6, boolean r7) {
        Fragment r0 = this.mFragmentManager.getParent();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentSaveInstanceState(r5, r6, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r1 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r2 = (FragmentLifecycleCallbacksHolder) ZeusTransformUtils.preCheckCast(r1.next(), FragmentLifecycleCallbacksHolder.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L12;
        if (r2.mRecursive == false) goto L7;
    L12:
        r2.mCallback.onFragmentSaveInstanceState(this.mFragmentManager, r5, r6);
        goto L7
    }

    void dispatchOnFragmentStarted(Fragment r5, boolean r6) {
        Fragment r0 = this.mFragmentManager.getParent();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStarted(r5, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r1 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r2 = (FragmentLifecycleCallbacksHolder) ZeusTransformUtils.preCheckCast(r1.next(), FragmentLifecycleCallbacksHolder.class, "com.obric.memorydata.plugin");
        if (r6 == false) goto L12;
        if (r2.mRecursive == false) goto L7;
    L12:
        r2.mCallback.onFragmentStarted(this.mFragmentManager, r5);
        goto L7
    }

    void dispatchOnFragmentStopped(Fragment r5, boolean r6) {
        Fragment r0 = this.mFragmentManager.getParent();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStopped(r5, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r1 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r2 = (FragmentLifecycleCallbacksHolder) ZeusTransformUtils.preCheckCast(r1.next(), FragmentLifecycleCallbacksHolder.class, "com.obric.memorydata.plugin");
        if (r6 == false) goto L12;
        if (r2.mRecursive == false) goto L7;
    L12:
        r2.mCallback.onFragmentStopped(this.mFragmentManager, r5);
        goto L7
    }

    void dispatchOnFragmentViewCreated(Fragment r5, View r6, Bundle r7, boolean r8) {
        Fragment r0 = this.mFragmentManager.getParent();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewCreated(r5, r6, r7, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r1 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r2 = (FragmentLifecycleCallbacksHolder) ZeusTransformUtils.preCheckCast(r1.next(), FragmentLifecycleCallbacksHolder.class, "com.obric.memorydata.plugin");
        if (r8 == false) goto L12;
        if (r2.mRecursive == false) goto L7;
    L12:
        r2.mCallback.onFragmentViewCreated(this.mFragmentManager, r5, r6, r7);
        goto L7
    }

    void dispatchOnFragmentViewDestroyed(Fragment r5, boolean r6) {
        Fragment r0 = this.mFragmentManager.getParent();
        if (r0 == null) goto L5;
        r0.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewDestroyed(r5, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r1 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r2 = (FragmentLifecycleCallbacksHolder) ZeusTransformUtils.preCheckCast(r1.next(), FragmentLifecycleCallbacksHolder.class, "com.obric.memorydata.plugin");
        if (r6 == false) goto L12;
        if (r2.mRecursive == false) goto L7;
    L12:
        r2.mCallback.onFragmentViewDestroyed(this.mFragmentManager, r5);
        goto L7
    }

    public void registerFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks r2, boolean r3) {
        this.mLifecycleCallbacks.add(new FragmentLifecycleCallbacksHolder(r2, r3));
    }

    public void unregisterFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks r7) {
        CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> r0 = this.mLifecycleCallbacks;
        monitor-enter(r0);
        int r1 = 0;
        int r2 = this.mLifecycleCallbacks.size();     // Catch: Throwable -> L13
    L6:
        if (r1 >= r2) goto L11;
        if (((FragmentLifecycleCallbacksHolder) ZeusTransformUtils.preCheckCast(this.mLifecycleCallbacks.get(r1), FragmentLifecycleCallbacksHolder.class, "com.obric.memorydata.plugin")).mCallback == r7) goto L9;
        r1 = r1 + 1;     // Catch: Throwable -> L13
        goto L6
    L9:
        this.mLifecycleCallbacks.remove(r1);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }
}

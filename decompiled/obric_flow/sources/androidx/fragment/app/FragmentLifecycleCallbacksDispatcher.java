package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
class FragmentLifecycleCallbacksDispatcher {

    @NonNull
    private final FragmentManager mFragmentManager;

    @NonNull
    private final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> mLifecycleCallbacks;

    public static final class FragmentLifecycleCallbacksHolder {

        @NonNull
        final FragmentManager.FragmentLifecycleCallbacks mCallback;
        final boolean mRecursive;

        public FragmentLifecycleCallbacksHolder(@NonNull FragmentManager.FragmentLifecycleCallbacks r5, boolean r10) {
            this.mCallback = r5;
            this.mRecursive = r10;
        }
    }

    public FragmentLifecycleCallbacksDispatcher(@NonNull FragmentManager r5) {
        this.mLifecycleCallbacks = new CopyOnWriteArrayList();
        this.mFragmentManager = r5;
    }

    public void dispatchOnFragmentActivityCreated(@NonNull Fragment r5, @Nullable Bundle r10, boolean r11) {
        Fragment r12 = this.mFragmentManager.getParent();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentActivityCreated(r5, r10, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r13 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r14 = r13.next();
        if (r11 == false) goto L12;
        if (r14.mRecursive == false) goto L7;
    L12:
        r14.mCallback.onFragmentActivityCreated(this.mFragmentManager, r5, r10);
        goto L7
    }

    public void dispatchOnFragmentAttached(@NonNull Fragment r5, boolean r10) {
        Context r11 = this.mFragmentManager.getHost().getContext();
        Fragment r12 = this.mFragmentManager.getParent();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentAttached(r5, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r13 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r14 = r13.next();
        if (r10 == false) goto L12;
        if (r14.mRecursive == false) goto L7;
    L12:
        r14.mCallback.onFragmentAttached(this.mFragmentManager, r5, r11);
        goto L7
    }

    public void dispatchOnFragmentCreated(@NonNull Fragment r5, @Nullable Bundle r10, boolean r11) {
        Fragment r12 = this.mFragmentManager.getParent();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentCreated(r5, r10, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r13 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r14 = r13.next();
        if (r11 == false) goto L12;
        if (r14.mRecursive == false) goto L7;
    L12:
        r14.mCallback.onFragmentCreated(this.mFragmentManager, r5, r10);
        goto L7
    }

    public void dispatchOnFragmentDestroyed(@NonNull Fragment r5, boolean r10) {
        Fragment r11 = this.mFragmentManager.getParent();
        if (r11 == null) goto L5;
        r11.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDestroyed(r5, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r12 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r12.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r13 = r12.next();
        if (r10 == false) goto L12;
        if (r13.mRecursive == false) goto L7;
    L12:
        r13.mCallback.onFragmentDestroyed(this.mFragmentManager, r5);
        goto L7
    }

    public void dispatchOnFragmentDetached(@NonNull Fragment r5, boolean r10) {
        Fragment r11 = this.mFragmentManager.getParent();
        if (r11 == null) goto L5;
        r11.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDetached(r5, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r12 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r12.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r13 = r12.next();
        if (r10 == false) goto L12;
        if (r13.mRecursive == false) goto L7;
    L12:
        r13.mCallback.onFragmentDetached(this.mFragmentManager, r5);
        goto L7
    }

    public void dispatchOnFragmentPaused(@NonNull Fragment r5, boolean r10) {
        Fragment r11 = this.mFragmentManager.getParent();
        if (r11 == null) goto L5;
        r11.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPaused(r5, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r12 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r12.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r13 = r12.next();
        if (r10 == false) goto L12;
        if (r13.mRecursive == false) goto L7;
    L12:
        r13.mCallback.onFragmentPaused(this.mFragmentManager, r5);
        goto L7
    }

    public void dispatchOnFragmentPreAttached(@NonNull Fragment r5, boolean r10) {
        Context r11 = this.mFragmentManager.getHost().getContext();
        Fragment r12 = this.mFragmentManager.getParent();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreAttached(r5, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r13 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r14 = r13.next();
        if (r10 == false) goto L12;
        if (r14.mRecursive == false) goto L7;
    L12:
        r14.mCallback.onFragmentPreAttached(this.mFragmentManager, r5, r11);
        goto L7
    }

    public void dispatchOnFragmentPreCreated(@NonNull Fragment r5, @Nullable Bundle r10, boolean r11) {
        Fragment r12 = this.mFragmentManager.getParent();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreCreated(r5, r10, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r13 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r14 = r13.next();
        if (r11 == false) goto L12;
        if (r14.mRecursive == false) goto L7;
    L12:
        r14.mCallback.onFragmentPreCreated(this.mFragmentManager, r5, r10);
        goto L7
    }

    public void dispatchOnFragmentResumed(@NonNull Fragment r5, boolean r10) {
        Fragment r11 = this.mFragmentManager.getParent();
        if (r11 == null) goto L5;
        r11.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentResumed(r5, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r12 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r12.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r13 = r12.next();
        if (r10 == false) goto L12;
        if (r13.mRecursive == false) goto L7;
    L12:
        r13.mCallback.onFragmentResumed(this.mFragmentManager, r5);
        goto L7
    }

    public void dispatchOnFragmentSaveInstanceState(@NonNull Fragment r5, @NonNull Bundle r10, boolean r11) {
        Fragment r12 = this.mFragmentManager.getParent();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentSaveInstanceState(r5, r10, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r13 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r14 = r13.next();
        if (r11 == false) goto L12;
        if (r14.mRecursive == false) goto L7;
    L12:
        r14.mCallback.onFragmentSaveInstanceState(this.mFragmentManager, r5, r10);
        goto L7
    }

    public void dispatchOnFragmentStarted(@NonNull Fragment r5, boolean r10) {
        Fragment r11 = this.mFragmentManager.getParent();
        if (r11 == null) goto L5;
        r11.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStarted(r5, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r12 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r12.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r13 = r12.next();
        if (r10 == false) goto L12;
        if (r13.mRecursive == false) goto L7;
    L12:
        r13.mCallback.onFragmentStarted(this.mFragmentManager, r5);
        goto L7
    }

    public void dispatchOnFragmentStopped(@NonNull Fragment r5, boolean r10) {
        Fragment r11 = this.mFragmentManager.getParent();
        if (r11 == null) goto L5;
        r11.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStopped(r5, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r12 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r12.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r13 = r12.next();
        if (r10 == false) goto L12;
        if (r13.mRecursive == false) goto L7;
    L12:
        r13.mCallback.onFragmentStopped(this.mFragmentManager, r5);
        goto L7
    }

    public void dispatchOnFragmentViewCreated(@NonNull Fragment r5, @NonNull View r10, @Nullable Bundle r11, boolean r12) {
        Fragment r13 = this.mFragmentManager.getParent();
        if (r13 == null) goto L5;
        r13.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewCreated(r5, r10, r11, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r14 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r15 = r14.next();
        if (r12 == false) goto L12;
        if (r15.mRecursive == false) goto L7;
    L12:
        r15.mCallback.onFragmentViewCreated(this.mFragmentManager, r5, r10, r11);
        goto L7
    }

    public void dispatchOnFragmentViewDestroyed(@NonNull Fragment r5, boolean r10) {
        Fragment r11 = this.mFragmentManager.getParent();
        if (r11 == null) goto L5;
        r11.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewDestroyed(r5, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r12 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r12.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r13 = r12.next();
        if (r10 == false) goto L12;
        if (r13.mRecursive == false) goto L7;
    L12:
        r13.mCallback.onFragmentViewDestroyed(this.mFragmentManager, r5);
        goto L7
    }

    public void registerFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks r5, boolean r10) {
        this.mLifecycleCallbacks.add(new FragmentLifecycleCallbacksHolder(r5, r10));
    }

    public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks r5) {
        CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> r10 = this.mLifecycleCallbacks;
        monitor-enter(r10);
        int r11 = this.mLifecycleCallbacks.size();     // Catch: Throwable -> L9
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L12;
        if (this.mLifecycleCallbacks.get(r12).mCallback == r5) goto L8;
        r12 = r12 + 1;     // Catch: Throwable -> L9
        goto L5
    L8:
        this.mLifecycleCallbacks.remove(r12);     // Catch: Throwable -> L9
    L12:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}

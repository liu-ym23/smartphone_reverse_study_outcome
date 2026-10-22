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

    private static final class FragmentLifecycleCallbacksHolder {

        @NonNull
        final FragmentManager.FragmentLifecycleCallbacks mCallback;
        final boolean mRecursive;

        FragmentLifecycleCallbacksHolder(@NonNull FragmentManager.FragmentLifecycleCallbacks r10, boolean r11) {
            this.mCallback = r10;
            this.mRecursive = r11;
        }
    }

    FragmentLifecycleCallbacksDispatcher(@NonNull FragmentManager r10) {
        this.mLifecycleCallbacks = new CopyOnWriteArrayList();
        this.mFragmentManager = r10;
    }

    void dispatchOnFragmentActivityCreated(@NonNull Fragment r10, @Nullable Bundle r11, boolean r12) {
        Fragment r13 = this.mFragmentManager.getParent();
        if (r13 == null) goto L5;
        r13.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentActivityCreated(r10, r11, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r14 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r15 = r14.next();
        if (r12 == false) goto L12;
        if (r15.mRecursive == false) goto L7;
    L12:
        r15.mCallback.onFragmentActivityCreated(this.mFragmentManager, r10, r11);
        goto L7
    }

    void dispatchOnFragmentAttached(@NonNull Fragment r10, boolean r11) {
        Context r12 = this.mFragmentManager.getHost().getContext();
        Fragment r13 = this.mFragmentManager.getParent();
        if (r13 == null) goto L5;
        r13.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentAttached(r10, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r14 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r15 = r14.next();
        if (r11 == false) goto L12;
        if (r15.mRecursive == false) goto L7;
    L12:
        r15.mCallback.onFragmentAttached(this.mFragmentManager, r10, r12);
        goto L7
    }

    void dispatchOnFragmentCreated(@NonNull Fragment r10, @Nullable Bundle r11, boolean r12) {
        Fragment r13 = this.mFragmentManager.getParent();
        if (r13 == null) goto L5;
        r13.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentCreated(r10, r11, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r14 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r15 = r14.next();
        if (r12 == false) goto L12;
        if (r15.mRecursive == false) goto L7;
    L12:
        r15.mCallback.onFragmentCreated(this.mFragmentManager, r10, r11);
        goto L7
    }

    void dispatchOnFragmentDestroyed(@NonNull Fragment r10, boolean r11) {
        Fragment r12 = this.mFragmentManager.getParent();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDestroyed(r10, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r13 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r14 = r13.next();
        if (r11 == false) goto L12;
        if (r14.mRecursive == false) goto L7;
    L12:
        r14.mCallback.onFragmentDestroyed(this.mFragmentManager, r10);
        goto L7
    }

    void dispatchOnFragmentDetached(@NonNull Fragment r10, boolean r11) {
        Fragment r12 = this.mFragmentManager.getParent();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDetached(r10, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r13 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r14 = r13.next();
        if (r11 == false) goto L12;
        if (r14.mRecursive == false) goto L7;
    L12:
        r14.mCallback.onFragmentDetached(this.mFragmentManager, r10);
        goto L7
    }

    void dispatchOnFragmentPaused(@NonNull Fragment r10, boolean r11) {
        Fragment r12 = this.mFragmentManager.getParent();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPaused(r10, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r13 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r14 = r13.next();
        if (r11 == false) goto L12;
        if (r14.mRecursive == false) goto L7;
    L12:
        r14.mCallback.onFragmentPaused(this.mFragmentManager, r10);
        goto L7
    }

    void dispatchOnFragmentPreAttached(@NonNull Fragment r10, boolean r11) {
        Context r12 = this.mFragmentManager.getHost().getContext();
        Fragment r13 = this.mFragmentManager.getParent();
        if (r13 == null) goto L5;
        r13.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreAttached(r10, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r14 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r15 = r14.next();
        if (r11 == false) goto L12;
        if (r15.mRecursive == false) goto L7;
    L12:
        r15.mCallback.onFragmentPreAttached(this.mFragmentManager, r10, r12);
        goto L7
    }

    void dispatchOnFragmentPreCreated(@NonNull Fragment r10, @Nullable Bundle r11, boolean r12) {
        Fragment r13 = this.mFragmentManager.getParent();
        if (r13 == null) goto L5;
        r13.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreCreated(r10, r11, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r14 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r15 = r14.next();
        if (r12 == false) goto L12;
        if (r15.mRecursive == false) goto L7;
    L12:
        r15.mCallback.onFragmentPreCreated(this.mFragmentManager, r10, r11);
        goto L7
    }

    void dispatchOnFragmentResumed(@NonNull Fragment r10, boolean r11) {
        Fragment r12 = this.mFragmentManager.getParent();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentResumed(r10, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r13 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r14 = r13.next();
        if (r11 == false) goto L12;
        if (r14.mRecursive == false) goto L7;
    L12:
        r14.mCallback.onFragmentResumed(this.mFragmentManager, r10);
        goto L7
    }

    void dispatchOnFragmentSaveInstanceState(@NonNull Fragment r10, @NonNull Bundle r11, boolean r12) {
        Fragment r13 = this.mFragmentManager.getParent();
        if (r13 == null) goto L5;
        r13.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentSaveInstanceState(r10, r11, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r14 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r15 = r14.next();
        if (r12 == false) goto L12;
        if (r15.mRecursive == false) goto L7;
    L12:
        r15.mCallback.onFragmentSaveInstanceState(this.mFragmentManager, r10, r11);
        goto L7
    }

    void dispatchOnFragmentStarted(@NonNull Fragment r10, boolean r11) {
        Fragment r12 = this.mFragmentManager.getParent();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStarted(r10, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r13 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r14 = r13.next();
        if (r11 == false) goto L12;
        if (r14.mRecursive == false) goto L7;
    L12:
        r14.mCallback.onFragmentStarted(this.mFragmentManager, r10);
        goto L7
    }

    void dispatchOnFragmentStopped(@NonNull Fragment r10, boolean r11) {
        Fragment r12 = this.mFragmentManager.getParent();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStopped(r10, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r13 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r14 = r13.next();
        if (r11 == false) goto L12;
        if (r14.mRecursive == false) goto L7;
    L12:
        r14.mCallback.onFragmentStopped(this.mFragmentManager, r10);
        goto L7
    }

    void dispatchOnFragmentViewCreated(@NonNull Fragment r10, @NonNull View r11, @Nullable Bundle r12, boolean r13) {
        Fragment r14 = this.mFragmentManager.getParent();
        if (r14 == null) goto L5;
        r14.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewCreated(r10, r11, r12, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r15 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r15.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r16 = r15.next();
        if (r13 == false) goto L12;
        if (r16.mRecursive == false) goto L7;
    L12:
        r16.mCallback.onFragmentViewCreated(this.mFragmentManager, r10, r11, r12);
        goto L7
    }

    void dispatchOnFragmentViewDestroyed(@NonNull Fragment r10, boolean r11) {
        Fragment r12 = this.mFragmentManager.getParent();
        if (r12 == null) goto L5;
        r12.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewDestroyed(r10, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r13 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r14 = r13.next();
        if (r11 == false) goto L12;
        if (r14.mRecursive == false) goto L7;
    L12:
        r14.mCallback.onFragmentViewDestroyed(this.mFragmentManager, r10);
        goto L7
    }

    public void registerFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks r10, boolean r11) {
        this.mLifecycleCallbacks.add(new FragmentLifecycleCallbacksHolder(r10, r11));
    }

    public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks r10) {
        CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> r11 = this.mLifecycleCallbacks;
        monitor-enter(r11);
        int r12 = 0;
        int r13 = this.mLifecycleCallbacks.size();     // Catch: Throwable -> L13
    L6:
        if (r12 >= r13) goto L11;
        if (this.mLifecycleCallbacks.get(r12).mCallback == r10) goto L9;
        r12 = r12 + 1;     // Catch: Throwable -> L13
        goto L6
    L9:
        this.mLifecycleCallbacks.remove(r12);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }
}

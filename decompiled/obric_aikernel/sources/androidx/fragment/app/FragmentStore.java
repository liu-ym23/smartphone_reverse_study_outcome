package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class FragmentStore {
    private static final String TAG = "FragmentManager";
    private final HashMap<String, FragmentStateManager> mActive;
    private final ArrayList<Fragment> mAdded;
    private FragmentManagerViewModel mNonConfig;

    FragmentStore() {
        this.mAdded = new ArrayList();
        this.mActive = new HashMap();
    }

    void addFragment(@NonNull Fragment r10) {
        if (this.mAdded.contains(r10) == true) goto L14;
        ArrayList<Fragment> r11 = this.mAdded;
        monitor-enter(r11);
        this.mAdded.add(r10);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        r10.mAdded = true;
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new IllegalStateException("Fragment already added: " + r10);
    }

    void burpActive() {
        this.mActive.values().removeAll(Collections.singleton(null));
    }

    boolean containsActiveFragment(@NonNull String r10) {
        if (this.mActive.get(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    void dispatchStateChange(int r10) {
        Iterator<FragmentStateManager> r11 = this.mActive.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        FragmentStateManager r12 = r11.next();
        if (r12 == null) goto L4;
        r12.setFragmentManagerState(r10);
        goto L4
    }

    void dump(@NonNull String r10, @Nullable FileDescriptor r11, @NonNull PrintWriter r12, @Nullable String[] r13) {
        String r14 = r10 + "    ";
        if (this.mActive.isEmpty() == true) goto L11;
        r12.print(r10);
        r12.println("Active Fragments:");
        Iterator<FragmentStateManager> r15 = this.mActive.values().iterator();
    L6:
        if (r15.hasNext() == false) goto L11;
        FragmentStateManager r16 = r15.next();
        r12.print(r10);
        if (r16 != null) goto L9;
        r12.println("null");
        goto L6
    L9:
        Fragment r17 = r16.getFragment();
        r12.println(r17);
        r17.dump(r14, r11, r12, r13);
    L11:
        int r18 = this.mAdded.size();
        if (r18 <= 0) goto L16;
        r12.print(r10);
        r12.println("Added Fragments:");
        int r19 = 0;
    L14:
        if (r19 >= r18) goto L24;
        Fragment r20 = this.mAdded.get(r19);
        r12.print(r10);
        r12.print("  #");
        r12.print(r19);
        r12.print(": ");
        r12.println(r20.toString());
        r19 = r19 + 1;
        goto L14
    L24:
        return;
    }

    @Nullable
    Fragment findActiveFragment(@NonNull String r10) {
        FragmentStateManager r11 = this.mActive.get(r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        return r11.getFragment();
    }

    @Nullable
    Fragment findFragmentById(@IdRes int r10) {
        int r11 = this.mAdded.size() - 1;
    L3:
        if (r11 < 0) goto L10;
        Fragment r12 = this.mAdded.get(r11);
        if (r12 == null) goto L9;
        if (r12.mFragmentId != r10) goto L9;
        return r12;
    L9:
        r11 = r11 - 1;
        goto L3
    L10:
        Iterator<FragmentStateManager> r13 = this.mActive.values().iterator();
    L12:
        if (r13.hasNext() == false) goto L18;
        FragmentStateManager r14 = r13.next();
        if (r14 == null) goto L12;
        Fragment r15 = r14.getFragment();
        if (r15.mFragmentId != r10) goto L12;
        return r15;
    L18:
        return null;
    }

    @Nullable
    Fragment findFragmentByTag(@Nullable String r10) {
        if (r10 == null) goto L11;
        int r11 = this.mAdded.size() - 1;
    L4:
        if (r11 < 0) goto L11;
        Fragment r12 = this.mAdded.get(r11);
        if (r12 == null) goto L10;
        if (r10.equals(r12.mTag) == false) goto L10;
        return r12;
    L10:
        r11 = r11 - 1;
    L11:
        if (r10 == null) goto L20;
        Iterator<FragmentStateManager> r13 = this.mActive.values().iterator();
    L14:
        if (r13.hasNext() == false) goto L32;
        FragmentStateManager r14 = r13.next();
        if (r14 == null) goto L14;
        Fragment r15 = r14.getFragment();
        if (r10.equals(r15.mTag) == false) goto L14;
        return r15;
    L32:
        return null;
    L20:
        return null;
    }

    @Nullable
    Fragment findFragmentByWho(@NonNull String r10) {
        Iterator<FragmentStateManager> r11 = this.mActive.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        FragmentStateManager r12 = r11.next();
        if (r12 == null) goto L4;
        Fragment r13 = r12.getFragment().findFragmentByWho(r10);
        if (r13 == null) goto L4;
        return r13;
    L10:
        return null;
    }

    int findFragmentIndexInContainer(@NonNull Fragment r10) {
        ViewGroup r11 = r10.mContainer;
        if (r11 != null) goto L5;
        return -1;
    L5:
        int r12 = this.mAdded.indexOf(r10);
        int r13 = r12 - 1;
    L6:
        if (r13 < 0) goto L14;
        Fragment r14 = this.mAdded.get(r13);
        if (r14.mContainer != r11) goto L13;
        View r15 = r14.mView;
        if (r15 == null) goto L13;
        return r11.indexOfChild(r15) + 1;
    L13:
        r13 = r13 - 1;
    L14:
        r12 = r12 + 1;
        if (r12 >= this.mAdded.size()) goto L23;
        Fragment r16 = this.mAdded.get(r12);
        if (r16.mContainer != r11) goto L14;
        View r17 = r16.mView;
        if (r17 == null) goto L14;
        return r11.indexOfChild(r17);
    L23:
        return -1;
    }

    int getActiveFragmentCount() {
        return this.mActive.size();
    }

    @NonNull
    List<FragmentStateManager> getActiveFragmentStateManagers() {
        ArrayList r10 = new ArrayList();
        Iterator<FragmentStateManager> r11 = this.mActive.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        FragmentStateManager r12 = r11.next();
        if (r12 == null) goto L4;
        r10.add(r12);
        goto L4
    L8:
        return r10;
    }

    @NonNull
    List<Fragment> getActiveFragments() {
        ArrayList r10 = new ArrayList();
        Iterator<FragmentStateManager> r11 = this.mActive.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        FragmentStateManager r12 = r11.next();
        if (r12 == null) goto L8;
        Fragment r13 = r12.getFragment();
    L9:
        r10.add(r13);
        goto L4
    L8:
        r13 = null;
        goto L9
    L10:
        return r10;
    }

    @Nullable
    FragmentStateManager getFragmentStateManager(@NonNull String r10) {
        return this.mActive.get(r10);
    }

    @NonNull
    List<Fragment> getFragments() {
        if (this.mAdded.isEmpty() == true) goto L5;
        ArrayList<Fragment> r10 = this.mAdded;
        monitor-enter(r10);
        ArrayList r11 = new ArrayList(this.mAdded);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return r11;
    L11:
        th = move-exception;
        throw th;
    L5:
        return Collections.emptyList();
    }

    FragmentManagerViewModel getNonConfig() {
        return this.mNonConfig;
    }

    void makeActive(@NonNull FragmentStateManager r10) {
        Fragment r11 = r10.getFragment();
        if (containsActiveFragment(r11.mWho) == false) goto L5;
        return;
    L5:
        this.mActive.put(r11.mWho, r10);
        if (r11.mRetainInstanceChangedWhileDetached == false) goto L13;
        boolean r12 = r11.mRetainInstance;
        FragmentManagerViewModel r13 = this.mNonConfig;
        if (r12 == false) goto L10;
        r13.addRetainedFragment(r11);
    L11:
        r11.mRetainInstanceChangedWhileDetached = false;
        goto L13
    L10:
        r13.removeRetainedFragment(r11);
    L13:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L16;
        Log.v(TAG, "Added fragment to active set " + r11);
        return;
    }

    void makeInactive(@NonNull FragmentStateManager r10) {
        Fragment r11 = r10.getFragment();
        if (r11.mRetainInstance == false) goto L6;
        this.mNonConfig.removeRetainedFragment(r11);
    L6:
        if (this.mActive.put(r11.mWho, null) != null) goto L9;
        return;
    L9:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L12;
        Log.v(TAG, "Removed fragment from active set " + r11);
        return;
    }

    void moveToExpectedState() {
        Iterator<Fragment> r10 = this.mAdded.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Fragment r11 = r10.next();
        FragmentStateManager r12 = this.mActive.get(r11.mWho);
        if (r12 == null) goto L4;
        r12.moveToExpectedState();
        goto L4
    L8:
        Iterator<FragmentStateManager> r13 = this.mActive.values().iterator();
    L10:
        if (r13.hasNext() == false) goto L21;
        FragmentStateManager r14 = r13.next();
        if (r14 == null) goto L10;
        r14.moveToExpectedState();
        Fragment r15 = r14.getFragment();
        if (r15.mRemoving == true) goto L16;
    L18:
        boolean r16 = false;
    L19:
        if (r16 == false) goto L10;
        makeInactive(r14);
        goto L10
    L16:
        if (r15.isInBackStack() == true) goto L18;
        r16 = true;
        goto L19
    }

    void removeFragment(@NonNull Fragment r10) {
        ArrayList<Fragment> r11 = this.mAdded;
        monitor-enter(r11);
        this.mAdded.remove(r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        r10.mAdded = false;
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void resetActiveFragments() {
        this.mActive.clear();
    }

    void restoreAddedFragments(@Nullable List<String> r10) {
        this.mAdded.clear();
        if (r10 == null) goto L15;
        Iterator<String> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L20;
        String r12 = r11.next();
        Fragment r13 = findActiveFragment(r12);
        if (r13 == null) goto L14;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L12;
        Log.v(TAG, "restoreSaveState: added (" + r12 + "): " + r13);
    L12:
        addFragment(r13);
        goto L6
    L14:
        throw new IllegalStateException("No instantiated fragment for (" + r12 + ")");
    L20:
        return;
    }

    @NonNull
    ArrayList<FragmentState> saveActiveFragments() {
        ArrayList<FragmentState> r10 = new ArrayList(this.mActive.size());
        Iterator<FragmentStateManager> r11 = this.mActive.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        FragmentStateManager r12 = r11.next();
        if (r12 == null) goto L4;
        Fragment r13 = r12.getFragment();
        FragmentState r14 = r12.saveState();
        r10.add(r14);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L4;
        Log.v(TAG, "Saved state of " + r13 + ": " + r14.mSavedFragmentState);
        goto L4
    L10:
        return r10;
    }

    @Nullable
    ArrayList<String> saveAddedFragments() {
        ArrayList<Fragment> r10 = this.mAdded;
        monitor-enter(r10);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mAdded.isEmpty() == true) goto L7;
        ArrayList<String> r11 = new ArrayList(this.mAdded.size());     // Catch: Throwable -> L17
        Iterator<Fragment> r12 = this.mAdded.iterator();     // Catch: Throwable -> L17
    L11:
        if (r12.hasNext() == false) goto L15;
        Fragment r13 = r12.next();     // Catch: Throwable -> L17
        r11.add(r13.mWho);     // Catch: Throwable -> L17
        if (FragmentManager.isLoggingEnabled(2) == false) goto L11;
        Log.v(TAG, "saveAllState: adding fragment (" + r13.mWho + "): " + r13);     // Catch: Throwable -> L17
        goto L11
    L15:
        monitor-exit(r10);     // Catch: Throwable -> L17
        return r11;
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L17
        return null;
    }

    void setNonConfig(@NonNull FragmentManagerViewModel r10) {
        this.mNonConfig = r10;
    }
}

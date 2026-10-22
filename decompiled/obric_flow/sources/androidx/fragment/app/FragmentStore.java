package androidx.fragment.app;

import ai.j0;
import android.os.Bundle;
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
    private final HashMap<String, Bundle> mSavedState;

    public FragmentStore() {
        this.mAdded = new ArrayList();
        this.mActive = new HashMap();
        this.mSavedState = new HashMap();
    }

    public void addFragment(@NonNull Fragment r5) {
        if (this.mAdded.contains(r5) == true) goto L14;
        ArrayList<Fragment> r10 = this.mAdded;
        monitor-enter(r10);
        this.mAdded.add(r5);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        r5.mAdded = true;
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new IllegalStateException("Fragment already added: " + r5);
    }

    public void burpActive() {
        this.mActive.values().removeAll(Collections.singleton(null));
    }

    public boolean containsActiveFragment(@NonNull String r5) {
        if (this.mActive.get(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void dispatchStateChange(int r5) {
        Iterator<FragmentStateManager> r10 = this.mActive.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        FragmentStateManager r11 = r10.next();
        if (r11 == null) goto L4;
        r11.setFragmentManagerState(r5);
        goto L4
    }

    public void dump(@NonNull String r5, @Nullable FileDescriptor r10, @NonNull PrintWriter r11, @Nullable String[] r12) {
        String r13 = j0.j(r5, "    ");
        if (this.mActive.isEmpty() == true) goto L11;
        r11.print(r5);
        r11.println("Active Fragments:");
        Iterator<FragmentStateManager> r14 = this.mActive.values().iterator();
    L6:
        if (r14.hasNext() == false) goto L11;
        FragmentStateManager r15 = r14.next();
        r11.print(r5);
        if (r15 != null) goto L9;
        r11.println("null");
        goto L6
    L9:
        Fragment r16 = r15.getFragment();
        r11.println(r16);
        r16.dump(r13, r10, r11, r12);
    L11:
        int r17 = this.mAdded.size();
        if (r17 <= 0) goto L16;
        r11.print(r5);
        r11.println("Added Fragments:");
        int r18 = 0;
    L14:
        if (r18 >= r17) goto L24;
        Fragment r19 = this.mAdded.get(r18);
        r11.print(r5);
        r11.print("  #");
        r11.print(r18);
        r11.print(": ");
        r11.println(r19.toString());
        r18 = r18 + 1;
        goto L14
    L24:
        return;
    }

    @Nullable
    public Fragment findActiveFragment(@NonNull String r5) {
        FragmentStateManager r10 = this.mActive.get(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getFragment();
    }

    @Nullable
    public Fragment findFragmentById(@IdRes int r5) {
        int r10 = this.mAdded.size() - 1;
    L3:
        if (r10 < 0) goto L10;
        Fragment r11 = this.mAdded.get(r10);
        if (r11 == null) goto L9;
        if (r11.mFragmentId != r5) goto L9;
        return r11;
    L9:
        r10 = r10 - 1;
        goto L3
    L10:
        Iterator<FragmentStateManager> r12 = this.mActive.values().iterator();
    L12:
        if (r12.hasNext() == false) goto L18;
        FragmentStateManager r13 = r12.next();
        if (r13 == null) goto L12;
        Fragment r14 = r13.getFragment();
        if (r14.mFragmentId != r5) goto L12;
        return r14;
    L18:
        return null;
    }

    @Nullable
    public Fragment findFragmentByTag(@Nullable String r5) {
        if (r5 == null) goto L11;
        int r10 = this.mAdded.size() - 1;
    L4:
        if (r10 < 0) goto L11;
        Fragment r11 = this.mAdded.get(r10);
        if (r11 == null) goto L10;
        if (r5.equals(r11.mTag) == false) goto L10;
        return r11;
    L10:
        r10 = r10 - 1;
    L11:
        if (r5 == null) goto L20;
        Iterator<FragmentStateManager> r12 = this.mActive.values().iterator();
    L14:
        if (r12.hasNext() == false) goto L32;
        FragmentStateManager r13 = r12.next();
        if (r13 == null) goto L14;
        Fragment r14 = r13.getFragment();
        if (r5.equals(r14.mTag) == false) goto L14;
        return r14;
    L32:
        return null;
    L20:
        return null;
    }

    @Nullable
    public Fragment findFragmentByWho(@NonNull String r5) {
        Iterator<FragmentStateManager> r10 = this.mActive.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        FragmentStateManager r11 = r10.next();
        if (r11 == null) goto L4;
        Fragment r12 = r11.getFragment().findFragmentByWho(r5);
        if (r12 == null) goto L4;
        return r12;
    L10:
        return null;
    }

    public int findFragmentIndexInContainer(@NonNull Fragment r10) {
        ViewGroup r5 = r10.mContainer;
        if (r5 != null) goto L5;
        return -1;
    L5:
        int r11 = this.mAdded.indexOf(r10);
        int r12 = r11 - 1;
    L6:
        if (r12 < 0) goto L14;
        Fragment r13 = this.mAdded.get(r12);
        if (r13.mContainer != r5) goto L13;
        View r14 = r13.mView;
        if (r14 == null) goto L13;
        return r5.indexOfChild(r14) + 1;
    L13:
        r12 = r12 - 1;
    L14:
        r11 = r11 + 1;
        if (r11 >= this.mAdded.size()) goto L23;
        Fragment r15 = this.mAdded.get(r11);
        if (r15.mContainer != r5) goto L14;
        View r16 = r15.mView;
        if (r16 == null) goto L14;
        return r5.indexOfChild(r16);
    L23:
        return -1;
    }

    public int getActiveFragmentCount() {
        return this.mActive.size();
    }

    @NonNull
    public List<FragmentStateManager> getActiveFragmentStateManagers() {
        ArrayList r5 = new ArrayList();
        Iterator<FragmentStateManager> r10 = this.mActive.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        FragmentStateManager r11 = r10.next();
        if (r11 == null) goto L4;
        r5.add(r11);
        goto L4
    L8:
        return r5;
    }

    @NonNull
    public List<Fragment> getActiveFragments() {
        ArrayList r5 = new ArrayList();
        Iterator<FragmentStateManager> r10 = this.mActive.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        FragmentStateManager r11 = r10.next();
        if (r11 != null) goto L7;
        r5.add(null);
        goto L4
    L7:
        r5.add(r11.getFragment());
        goto L4
    L9:
        return r5;
    }

    @NonNull
    public HashMap<String, Bundle> getAllSavedState() {
        return this.mSavedState;
    }

    @Nullable
    public FragmentStateManager getFragmentStateManager(@NonNull String r5) {
        return this.mActive.get(r5);
    }

    @NonNull
    public List<Fragment> getFragments() {
        if (this.mAdded.isEmpty() == true) goto L5;
        ArrayList<Fragment> r5 = this.mAdded;
        monitor-enter(r5);
        ArrayList r10 = new ArrayList(this.mAdded);     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Throwable -> L11
        return r10;
    L11:
        th = move-exception;
        throw th;
    L5:
        return Collections.emptyList();
    }

    public FragmentManagerViewModel getNonConfig() {
        return this.mNonConfig;
    }

    @Nullable
    public Bundle getSavedState(@NonNull String r5) {
        return this.mSavedState.get(r5);
    }

    public void makeActive(@NonNull FragmentStateManager r5) {
        Fragment r10 = r5.getFragment();
        if (containsActiveFragment(r10.mWho) == false) goto L5;
        return;
    L5:
        this.mActive.put(r10.mWho, r5);
        if (r10.mRetainInstanceChangedWhileDetached == false) goto L13;
        if (r10.mRetainInstance == false) goto L10;
        this.mNonConfig.addRetainedFragment(r10);
    L11:
        r10.mRetainInstanceChangedWhileDetached = false;
        goto L13
    L10:
        this.mNonConfig.removeRetainedFragment(r10);
    L13:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L16;
        Log.v("FragmentManager", "Added fragment to active set " + r10);
        return;
    }

    public void makeInactive(@NonNull FragmentStateManager r5) {
        Fragment r10 = r5.getFragment();
        if (r10.mRetainInstance == false) goto L6;
        this.mNonConfig.removeRetainedFragment(r10);
    L6:
        if (this.mActive.get(r10.mWho) == r5) goto L9;
        return;
    L9:
        if (this.mActive.put(r10.mWho, null) != null) goto L12;
        return;
    L12:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L15;
        Log.v("FragmentManager", "Removed fragment from active set " + r10);
        return;
    }

    public void moveToExpectedState() {
        Iterator<Fragment> r5 = this.mAdded.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Fragment r10 = r5.next();
        FragmentStateManager r11 = this.mActive.get(r10.mWho);
        if (r11 == null) goto L4;
        r11.moveToExpectedState();
        goto L4
    L8:
        Iterator<FragmentStateManager> r12 = this.mActive.values().iterator();
    L10:
        if (r12.hasNext() == false) goto L23;
        FragmentStateManager r13 = r12.next();
        if (r13 == null) goto L10;
        r13.moveToExpectedState();
        Fragment r14 = r13.getFragment();
        if (r14.mRemoving == false) goto L10;
        if (r14.isInBackStack() == true) goto L10;
        if (r14.mBeingSaved == true) goto L20;
    L22:
        makeInactive(r13);
        goto L10
    L20:
        if (this.mSavedState.containsKey(r14.mWho) == true) goto L22;
        setSavedState(r14.mWho, r13.saveState());
        goto L22
    }

    public void removeFragment(@NonNull Fragment r5) {
        ArrayList<Fragment> r10 = this.mAdded;
        monitor-enter(r10);
        this.mAdded.remove(r5);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        r5.mAdded = false;
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void resetActiveFragments() {
        this.mActive.clear();
    }

    public void restoreAddedFragments(@Nullable List<String> r5) {
        this.mAdded.clear();
        if (r5 == null) goto L15;
        Iterator<String> r10 = r5.iterator();
    L6:
        if (r10.hasNext() == false) goto L20;
        String r11 = r10.next();
        Fragment r12 = findActiveFragment(r11);
        if (r12 == null) goto L14;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L12;
        Log.v("FragmentManager", "restoreSaveState: added (" + r11 + "): " + r12);
    L12:
        addFragment(r12);
        goto L6
    L14:
        throw new IllegalStateException(j0.k("No instantiated fragment for (", r11, ")"));
    L20:
        return;
    }

    public void restoreSaveState(@NonNull HashMap<String, Bundle> r5) {
        this.mSavedState.clear();
        this.mSavedState.putAll(r5);
    }

    @NonNull
    public ArrayList<String> saveActiveFragments() {
        ArrayList<String> r5 = new ArrayList(this.mActive.size());
        Iterator<FragmentStateManager> r10 = this.mActive.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        FragmentStateManager r11 = r10.next();
        if (r11 == null) goto L4;
        Fragment r12 = r11.getFragment();
        setSavedState(r12.mWho, r11.saveState());
        r5.add(r12.mWho);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L4;
        Log.v("FragmentManager", "Saved state of " + r12 + ": " + r12.mSavedFragmentState);
        goto L4
    L10:
        return r5;
    }

    @Nullable
    public ArrayList<String> saveAddedFragments() {
        ArrayList<Fragment> r5 = this.mAdded;
        monitor-enter(r5);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mAdded.isEmpty() == false) goto L11;
        monitor-exit(r5);     // Catch: Throwable -> L9
        return null;
    L11:
        ArrayList<String> r10 = new ArrayList(this.mAdded.size());     // Catch: Throwable -> L9
        Iterator<Fragment> r11 = this.mAdded.iterator();     // Catch: Throwable -> L9
    L13:
        if (r11.hasNext() == false) goto L17;
        Fragment r12 = r11.next();     // Catch: Throwable -> L9
        r10.add(r12.mWho);     // Catch: Throwable -> L9
        if (FragmentManager.isLoggingEnabled(2) == false) goto L13;
        Log.v("FragmentManager", "saveAllState: adding fragment (" + r12.mWho + "): " + r12);     // Catch: Throwable -> L9
        goto L13
    L17:
        monitor-exit(r5);     // Catch: Throwable -> L9
        return r10;
    }

    public void setNonConfig(@NonNull FragmentManagerViewModel r5) {
        this.mNonConfig = r5;
    }

    @Nullable
    public Bundle setSavedState(@NonNull String r5, @Nullable Bundle r10) {
        if (r10 == null) goto L6;
        return this.mSavedState.put(r5, r10);
    L6:
        return this.mSavedState.remove(r5);
    }
}

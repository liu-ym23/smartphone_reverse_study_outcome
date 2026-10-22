package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    private final HashMap<String, FragmentState> mSavedState;

    FragmentStore() {
        this.mAdded = new ArrayList();
        this.mActive = new HashMap();
        this.mSavedState = new HashMap();
    }

    void addFragment(Fragment r3) {
        if (this.mAdded.contains(r3) == true) goto L14;
        ArrayList<Fragment> r0 = this.mAdded;
        monitor-enter(r0);
        this.mAdded.add(r3);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        r3.mAdded = true;
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new IllegalStateException("Fragment already added: " + r3);
    }

    void burpActive() {
        this.mActive.values().removeAll(Collections.singleton(null));
    }

    boolean containsActiveFragment(String r1) {
        if (this.mActive.get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    void dispatchStateChange(int r4) {
        Iterator<FragmentStateManager> r3 = this.mActive.values().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        FragmentStateManager r0 = (FragmentStateManager) ZeusTransformUtils.preCheckCast(r3.next(), FragmentStateManager.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L4;
        r0.setFragmentManagerState(r4);
        goto L4
    }

    void dump(String r6, FileDescriptor r7, PrintWriter r8, String[] r9) {
        String r0 = r6 + "    ";
        if (this.mActive.isEmpty() == true) goto L11;
        r8.print(r6);
        r8.println("Active Fragments:");
        Iterator<FragmentStateManager> r1 = this.mActive.values().iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        FragmentStateManager r3 = (FragmentStateManager) ZeusTransformUtils.preCheckCast(r1.next(), FragmentStateManager.class, "com.obric.memorydata.plugin");
        r8.print(r6);
        if (r3 != null) goto L9;
        r8.println("null");
        goto L6
    L9:
        Fragment r4 = r3.getFragment();
        r8.println(r4);
        r4.dump(r0, r7, r8, r9);
    L11:
        int r10 = this.mAdded.size();
        if (r10 <= 0) goto L16;
        r8.print(r6);
        r8.println("Added Fragments:");
        int r11 = 0;
    L14:
        if (r11 >= r10) goto L24;
        Fragment r2 = (Fragment) ZeusTransformUtils.preCheckCast(this.mAdded.get(r11), Fragment.class, "com.obric.memorydata.plugin");
        r8.print(r6);
        r8.print("  #");
        r8.print(r11);
        r8.print(": ");
        r8.println(r2.toString());
        r11 = r11 + 1;
        goto L14
    L24:
        return;
    }

    Fragment findActiveFragment(String r2) {
        FragmentStateManager r1 = (FragmentStateManager) ZeusTransformUtils.preCheckCast(this.mActive.get(r2), FragmentStateManager.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.getFragment();
    }

    Fragment findFragmentById(int r5) {
        int r0 = this.mAdded.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L11;
        Fragment r1 = (Fragment) ZeusTransformUtils.preCheckCast(this.mAdded.get(r0), Fragment.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L3;
        if (r1.mFragmentId != r5) goto L3;
        return r1;
    L11:
        Iterator<FragmentStateManager> r4 = this.mActive.values().iterator();
    L13:
        if (r4.hasNext() == false) goto L19;
        FragmentStateManager r2 = (FragmentStateManager) ZeusTransformUtils.preCheckCast(r4.next(), FragmentStateManager.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
        Fragment r3 = r2.getFragment();
        if (r3.mFragmentId != r5) goto L13;
        return r3;
    L19:
        return null;
    }

    Fragment findFragmentByTag(String r5) {
        if (r5 == null) goto L12;
        int r1 = this.mAdded.size() - 1;
    L5:
        if (r1 < 0) goto L12;
        Fragment r2 = (Fragment) ZeusTransformUtils.preCheckCast(this.mAdded.get(r1), Fragment.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        if (r5.equals(r2.mTag) == false) goto L11;
        return r2;
    L11:
        r1 = r1 - 1;
    L12:
        if (r5 == null) goto L21;
        Iterator<FragmentStateManager> r4 = this.mActive.values().iterator();
    L15:
        if (r4.hasNext() == false) goto L33;
        FragmentStateManager r3 = (FragmentStateManager) ZeusTransformUtils.preCheckCast(r4.next(), FragmentStateManager.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L15;
        Fragment r6 = r3.getFragment();
        if (r5.equals(r6.mTag) == false) goto L15;
        return r6;
    L33:
        return null;
    L21:
        return null;
    }

    Fragment findFragmentByWho(String r4) {
        Iterator<FragmentStateManager> r3 = this.mActive.values().iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        FragmentStateManager r0 = (FragmentStateManager) ZeusTransformUtils.preCheckCast(r3.next(), FragmentStateManager.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L4;
        Fragment r1 = r0.getFragment().findFragmentByWho(r4);
        if (r1 == null) goto L4;
        return r1;
    L10:
        return null;
    }

    int findFragmentIndexInContainer(Fragment r7) {
        ViewGroup r0 = r7.mContainer;
        if (r0 != null) goto L5;
        return -1;
    L5:
        int r8 = this.mAdded.indexOf(r7);
        int r2 = r8 - 1;
    L7:
        if (r2 < 0) goto L15;
        Fragment r3 = (Fragment) ZeusTransformUtils.preCheckCast(this.mAdded.get(r2), Fragment.class, "com.obric.memorydata.plugin");
        if (r3.mContainer != r0) goto L14;
        if (r3.mView == null) goto L14;
        return r0.indexOfChild(r3.mView) + 1;
    L14:
        r2 = r2 - 1;
    L15:
        r8 = r8 + 1;
        if (r8 >= this.mAdded.size()) goto L24;
        Fragment r4 = (Fragment) ZeusTransformUtils.preCheckCast(this.mAdded.get(r8), Fragment.class, "com.obric.memorydata.plugin");
        if (r4.mContainer != r0) goto L15;
        if (r4.mView == null) goto L15;
        return r0.indexOfChild(r4.mView);
    L24:
        return -1;
    }

    int getActiveFragmentCount() {
        return this.mActive.size();
    }

    List<FragmentStateManager> getActiveFragmentStateManagers() {
        ArrayList r0 = new ArrayList();
        Iterator<FragmentStateManager> r4 = this.mActive.values().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        FragmentStateManager r1 = (FragmentStateManager) ZeusTransformUtils.preCheckCast(r4.next(), FragmentStateManager.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    List<Fragment> getActiveFragments() {
        ArrayList r0 = new ArrayList();
        Iterator<FragmentStateManager> r4 = this.mActive.values().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        FragmentStateManager r1 = (FragmentStateManager) ZeusTransformUtils.preCheckCast(r4.next(), FragmentStateManager.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L8;
        Fragment r2 = r1.getFragment();
    L9:
        r0.add(r2);
        goto L4
    L8:
        r2 = null;
        goto L9
    L10:
        return r0;
    }

    ArrayList<FragmentState> getAllSavedState() {
        return new ArrayList(this.mSavedState.values());
    }

    FragmentStateManager getFragmentStateManager(String r2) {
        return (FragmentStateManager) ZeusTransformUtils.preCheckCast(this.mActive.get(r2), FragmentStateManager.class, "com.obric.memorydata.plugin");
    }

    List<Fragment> getFragments() {
        if (this.mAdded.isEmpty() == true) goto L5;
        ArrayList<Fragment> r0 = this.mAdded;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mAdded);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    L5:
        return Collections.emptyList();
    }

    FragmentManagerViewModel getNonConfig() {
        return this.mNonConfig;
    }

    FragmentState getSavedState(String r2) {
        return (FragmentState) ZeusTransformUtils.preCheckCast(this.mSavedState.get(r2), FragmentState.class, "com.obric.memorydata.plugin");
    }

    void makeActive(FragmentStateManager r4) {
        Fragment r0 = r4.getFragment();
        if (containsActiveFragment(r0.mWho) == false) goto L5;
        return;
    L5:
        this.mActive.put(r0.mWho, r4);
        if (r0.mRetainInstanceChangedWhileDetached == false) goto L13;
        boolean r5 = r0.mRetainInstance;
        FragmentManagerViewModel r3 = this.mNonConfig;
        if (r5 == false) goto L10;
        r3.addRetainedFragment(r0);
    L11:
        r0.mRetainInstanceChangedWhileDetached = false;
        goto L13
    L10:
        r3.removeRetainedFragment(r0);
    L13:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L16;
        Log.v("FragmentManager", "Added fragment to active set " + r0);
        return;
    }

    void makeInactive(FragmentStateManager r3) {
        Fragment r4 = r3.getFragment();
        if (r4.mRetainInstance == false) goto L6;
        this.mNonConfig.removeRetainedFragment(r4);
    L6:
        if (((FragmentStateManager) ZeusTransformUtils.preCheckCast(this.mActive.put(r4.mWho, null), FragmentStateManager.class, "com.obric.memorydata.plugin")) != null) goto L9;
        return;
    L9:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L12;
        Log.v("FragmentManager", "Removed fragment from active set " + r4);
        return;
    }

    void moveToExpectedState() {
        Iterator<Fragment> r0 = this.mAdded.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Fragment r1 = (Fragment) ZeusTransformUtils.preCheckCast(r0.next(), Fragment.class, "com.obric.memorydata.plugin");
        FragmentStateManager r2 = (FragmentStateManager) ZeusTransformUtils.preCheckCast(this.mActive.get(r1.mWho), FragmentStateManager.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        r2.moveToExpectedState();
        goto L4
    L8:
        Iterator<FragmentStateManager> r3 = this.mActive.values().iterator();
    L10:
        if (r3.hasNext() == false) goto L26;
        FragmentStateManager r4 = (FragmentStateManager) ZeusTransformUtils.preCheckCast(r3.next(), FragmentStateManager.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L10;
        r4.moveToExpectedState();
        Fragment r5 = r4.getFragment();
        if (r5.mRemoving == true) goto L16;
    L18:
        boolean r6 = false;
    L19:
        if (r6 == false) goto L10;
        if (r5.mBeingSaved == true) goto L23;
    L25:
        makeInactive(r4);
        goto L10
    L23:
        if (this.mSavedState.containsKey(r5.mWho) == true) goto L25;
        r4.saveState();
        goto L25
    L16:
        if (r5.isInBackStack() == true) goto L18;
        r6 = true;
        goto L19
    }

    void removeFragment(Fragment r2) {
        ArrayList<Fragment> r0 = this.mAdded;
        monitor-enter(r0);
        this.mAdded.remove(r2);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        r2.mAdded = false;
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void resetActiveFragments() {
        this.mActive.clear();
    }

    void restoreAddedFragments(List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.mAdded.clear();
        if (r7 == null) goto L15;
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L20;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        Fragment r2 = findActiveFragment(r0);
        if (r2 == null) goto L14;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L12;
        Log.v("FragmentManager", "restoreSaveState: added (" + r0 + "): " + r2);
    L12:
        addFragment(r2);
        goto L6
    L14:
        throw new IllegalStateException("No instantiated fragment for (" + r0 + ")");
    L20:
        return;
    }

    void restoreSaveState(ArrayList<FragmentState> r4) {
        this.mSavedState.clear();
        Iterator<FragmentState> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        FragmentState r0 = (FragmentState) ZeusTransformUtils.preCheckCast(r5.next(), FragmentState.class, "com.obric.memorydata.plugin");
        this.mSavedState.put(r0.mWho, r0);
        goto L4
    }

    ArrayList<String> saveActiveFragments() {
        ArrayList<String> r0 = new ArrayList(this.mActive.size());
        Iterator<FragmentStateManager> r4 = this.mActive.values().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        FragmentStateManager r1 = (FragmentStateManager) ZeusTransformUtils.preCheckCast(r4.next(), FragmentStateManager.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L4;
        Fragment r2 = r1.getFragment();
        r1.saveState();
        r0.add(r2.mWho);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L4;
        Log.v("FragmentManager", "Saved state of " + r2 + ": " + r2.mSavedFragmentState);
        goto L4
    L10:
        return r0;
    }

    ArrayList<String> saveAddedFragments() {
        ArrayList<Fragment> r0 = this.mAdded;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mAdded.isEmpty() == true) goto L7;
        ArrayList<String> r1 = new ArrayList(this.mAdded.size());     // Catch: Throwable -> L17
        Iterator<Fragment> r6 = this.mAdded.iterator();     // Catch: Throwable -> L17
    L11:
        if (r6.hasNext() == false) goto L15;
        Fragment r2 = (Fragment) ZeusTransformUtils.preCheckCast(r6.next(), Fragment.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        r1.add(r2.mWho);     // Catch: Throwable -> L17
        if (FragmentManager.isLoggingEnabled(2) == false) goto L11;
        Log.v("FragmentManager", "saveAllState: adding fragment (" + r2.mWho + "): " + r2);     // Catch: Throwable -> L17
        goto L11
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return r1;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return null;
    }

    void setNonConfig(FragmentManagerViewModel r1) {
        this.mNonConfig = r1;
    }

    FragmentState setSavedState(String r2, FragmentState r3) {
        HashMap<String, FragmentState> r1 = this.mSavedState;
        if (r3 == null) goto L7;
        FragmentState r4 = r1.put(r2, r3);
    L6:
        return (FragmentState) ZeusTransformUtils.preCheckCast(r4, FragmentState.class, "com.obric.memorydata.plugin");
    L7:
        r4 = r1.remove(r2);
        goto L6
    }
}

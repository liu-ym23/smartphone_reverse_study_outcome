package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class FragmentManagerViewModel extends ViewModel {
    private static final ViewModelProvider.Factory FACTORY = null;
    private static final String TAG = "FragmentManager";
    private final HashMap<String, FragmentManagerViewModel> mChildNonConfigs;
    private boolean mHasBeenCleared;
    private boolean mHasSavedSnapshot;
    private boolean mIsStateSaved;
    private final HashMap<String, Fragment> mRetainedFragments;
    private final boolean mStateAutomaticallySaved;
    private final HashMap<String, ViewModelStore> mViewModelStores;

    static {
        FACTORY = new AnonymousClass1();
    }

    FragmentManagerViewModel(boolean r2) {
        this.mRetainedFragments = new HashMap();
        this.mChildNonConfigs = new HashMap();
        this.mViewModelStores = new HashMap();
        this.mHasBeenCleared = false;
        this.mHasSavedSnapshot = false;
        this.mIsStateSaved = false;
        this.mStateAutomaticallySaved = r2;
    }

    private void clearNonConfigStateInternal(String r4) {
        FragmentManagerViewModel r0 = (FragmentManagerViewModel) ZeusTransformUtils.preCheckCast(this.mChildNonConfigs.get(r4), FragmentManagerViewModel.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.onCleared();
        this.mChildNonConfigs.remove(r4);
    L5:
        ViewModelStore r1 = (ViewModelStore) ZeusTransformUtils.preCheckCast(this.mViewModelStores.get(r4), ViewModelStore.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        r1.clear();
        this.mViewModelStores.remove(r4);
        return;
    }

    static FragmentManagerViewModel getInstance(ViewModelStore r3) {
        return (FragmentManagerViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider(r3, FACTORY).get(FragmentManagerViewModel.class), FragmentManagerViewModel.class, "com.obric.memorydata.plugin");
    }

    void addRetainedFragment(Fragment r5) {
        if (this.mIsStateSaved == false) goto L9;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L15;
        Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
        return;
    L15:
        return;
    L9:
        if (this.mRetainedFragments.containsKey(r5.mWho) == false) goto L11;
        return;
    L11:
        this.mRetainedFragments.put(r5.mWho, r5);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L16;
        Log.v("FragmentManager", "Updating retained Fragments: Added " + r5);
        return;
    }

    void clearNonConfigState(Fragment r3) {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "Clearing non-config state for " + r3);
    L5:
        clearNonConfigStateInternal(r3.mWho);
    }

    void clearNonConfigState(String r3) {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + r3);
    L5:
        clearNonConfigStateInternal(r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L19;
        FragmentManagerViewModel r6 = (FragmentManagerViewModel) ZeusTransformUtils.preCheckCast(r5, FragmentManagerViewModel.class, "com.obric.memorydata.plugin");
        if (this.mRetainedFragments.equals(r6.mRetainedFragments) == false) goto L18;
        if (this.mChildNonConfigs.equals(r6.mChildNonConfigs) == false) goto L18;
        if (this.mViewModelStores.equals(r6.mViewModelStores) == false) goto L18;
        return true;
    L18:
        return false;
    }

    Fragment findRetainedFragmentByWho(String r2) {
        return (Fragment) ZeusTransformUtils.preCheckCast(this.mRetainedFragments.get(r2), Fragment.class, "com.obric.memorydata.plugin");
    }

    FragmentManagerViewModel getChildNonConfig(Fragment r4) {
        FragmentManagerViewModel r0 = (FragmentManagerViewModel) ZeusTransformUtils.preCheckCast(this.mChildNonConfigs.get(r4.mWho), FragmentManagerViewModel.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        FragmentManagerViewModel r1 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
        this.mChildNonConfigs.put(r4.mWho, r1);
        return r1;
    L6:
        return r0;
    }

    Collection<Fragment> getRetainedFragments() {
        return new ArrayList(this.mRetainedFragments.values());
    }

    @Deprecated
    FragmentManagerNonConfig getSnapshot() {
        if (this.mRetainedFragments.isEmpty() == true) goto L5;
    L9:
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<String, FragmentManagerViewModel>> r2 = this.mChildNonConfigs.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        FragmentManagerNonConfig r4 = ((FragmentManagerViewModel) ZeusTransformUtils.preCheckCast(r3.getValue(), FragmentManagerViewModel.class, "com.obric.memorydata.plugin")).getSnapshot();
        if (r4 == null) goto L11;
        r0.put((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin"), r4);
        goto L11
    L15:
        this.mHasSavedSnapshot = true;
        if (this.mRetainedFragments.isEmpty() == false) goto L23;
        if (r0.isEmpty() == false) goto L23;
        if (this.mViewModelStores.isEmpty() == false) goto L23;
        return null;
    L23:
        return new FragmentManagerNonConfig(new ArrayList(this.mRetainedFragments.values()), r0, new HashMap(this.mViewModelStores));
    L5:
        if (this.mChildNonConfigs.isEmpty() == false) goto L9;
        if (this.mViewModelStores.isEmpty() == false) goto L9;
        return null;
    }

    ViewModelStore getViewModelStore(Fragment r4) {
        ViewModelStore r0 = (ViewModelStore) ZeusTransformUtils.preCheckCast(this.mViewModelStores.get(r4.mWho), ViewModelStore.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        ViewModelStore r1 = new ViewModelStore();
        this.mViewModelStores.put(r4.mWho, r1);
        return r1;
    L6:
        return r0;
    }

    public int hashCode() {
        return (((this.mRetainedFragments.hashCode() * 31) + this.mChildNonConfigs.hashCode()) * 31) + this.mViewModelStores.hashCode();
    }

    boolean isCleared() {
        return this.mHasBeenCleared;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "onCleared called for " + this);
    L5:
        this.mHasBeenCleared = true;
    }

    void removeRetainedFragment(Fragment r4) {
        if (this.mIsStateSaved == false) goto L9;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L17;
        Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
        return;
    L17:
        return;
    L9:
        if (this.mRetainedFragments.remove(r4.mWho) == null) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L14;
        return;
    L14:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L19;
        Log.v("FragmentManager", "Updating retained Fragments: Removed " + r4);
        return;
    L19:
        return;
    L11:
        r3 = false;
        goto L12
    }

    @Deprecated
    void restoreFromSnapshot(FragmentManagerNonConfig r7) {
        this.mRetainedFragments.clear();
        this.mChildNonConfigs.clear();
        this.mViewModelStores.clear();
        if (r7 == null) goto L21;
        Collection<Fragment> r0 = r7.getFragments();
        if (r0 == null) goto L12;
        Iterator<Fragment> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Fragment r2 = (Fragment) ZeusTransformUtils.preCheckCast(r1.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        this.mRetainedFragments.put(r2.mWho, r2);
    L12:
        Map<String, FragmentManagerNonConfig> r3 = r7.getChildNonConfigs();
        if (r3 == null) goto L18;
        Iterator<Map.Entry<String, FragmentManagerNonConfig>> r4 = r3.entrySet().iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        FragmentManagerViewModel r6 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
        r6.restoreFromSnapshot((FragmentManagerNonConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), FragmentManagerNonConfig.class, "com.obric.memorydata.plugin"));
        this.mChildNonConfigs.put((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin"), r6);
    L18:
        Map<String, ViewModelStore> r8 = r7.getViewModelStores();
        if (r8 == null) goto L21;
        this.mViewModelStores.putAll(r8);
    L21:
        this.mHasSavedSnapshot = false;
    }

    void setIsStateSaved(boolean r1) {
        this.mIsStateSaved = r1;
    }

    boolean shouldDestroy(Fragment r2) {
        if (this.mRetainedFragments.containsKey(r2.mWho) == true) goto L6;
        return true;
    L6:
        if (this.mStateAutomaticallySaved == false) goto L10;
        return this.mHasBeenCleared;
    L10:
        return !this.mHasSavedSnapshot;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("FragmentManagerViewModel{");
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        r0.append("} Fragments (");
        Iterator<Fragment> r1 = this.mRetainedFragments.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        r0.append(r1.next());
        if (r1.hasNext() == false) goto L4;
        r0.append(", ");
        goto L4
    L8:
        r0.append(") Child Non Config (");
        Iterator<String> r2 = this.mChildNonConfigs.keySet().iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        r0.append((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin"));
        if (r2.hasNext() == false) goto L10;
        r0.append(", ");
        goto L10
    L14:
        r0.append(") ViewModelStores (");
        Iterator<String> r6 = this.mViewModelStores.keySet().iterator();
    L16:
        if (r6.hasNext() == false) goto L20;
        r0.append((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"));
        if (r6.hasNext() == false) goto L16;
        r0.append(", ");
        goto L16
    L20:
        r0.append(')');
        return r0.toString();
    }
}

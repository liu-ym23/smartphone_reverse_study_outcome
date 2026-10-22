package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
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

    public FragmentManagerViewModel(boolean r5) {
        this.mRetainedFragments = new HashMap();
        this.mChildNonConfigs = new HashMap();
        this.mViewModelStores = new HashMap();
        this.mHasBeenCleared = false;
        this.mHasSavedSnapshot = false;
        this.mIsStateSaved = false;
        this.mStateAutomaticallySaved = r5;
    }

    private void clearNonConfigStateInternal(@NonNull String r5, boolean r10) {
        FragmentManagerViewModel r11 = this.mChildNonConfigs.get(r5);
        if (r11 == null) goto L10;
        if (r10 == false) goto L9;
        ArrayList r12 = new ArrayList();
        r12.addAll(r11.mChildNonConfigs.keySet());
        Iterator r13 = r12.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        r11.clearNonConfigState((String) r13.next(), true);
    L9:
        r11.onCleared();
        this.mChildNonConfigs.remove(r5);
    L10:
        ViewModelStore r14 = this.mViewModelStores.get(r5);
        if (r14 == null) goto L15;
        r14.clear();
        this.mViewModelStores.remove(r5);
        return;
    }

    @NonNull
    public static FragmentManagerViewModel getInstance(ViewModelStore r5) {
        return (FragmentManagerViewModel) new ViewModelProvider(r5, FACTORY).get(FragmentManagerViewModel.class);
    }

    public void addRetainedFragment(@NonNull Fragment r5) {
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

    public void clearNonConfigState(@NonNull Fragment r5, boolean r10) {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "Clearing non-config state for " + r5);
    L5:
        clearNonConfigStateInternal(r5.mWho, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (FragmentManagerViewModel.class != r5.getClass()) goto L19;
        FragmentManagerViewModel r10 = (FragmentManagerViewModel) r5;
        if (this.mRetainedFragments.equals(r10.mRetainedFragments) == false) goto L18;
        if (this.mChildNonConfigs.equals(r10.mChildNonConfigs) == false) goto L18;
        if (this.mViewModelStores.equals(r10.mViewModelStores) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Nullable
    public Fragment findRetainedFragmentByWho(String r5) {
        return this.mRetainedFragments.get(r5);
    }

    @NonNull
    public FragmentManagerViewModel getChildNonConfig(@NonNull Fragment r5) {
        FragmentManagerViewModel r10 = this.mChildNonConfigs.get(r5.mWho);
        if (r10 != null) goto L6;
        FragmentManagerViewModel r11 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
        this.mChildNonConfigs.put(r5.mWho, r11);
        return r11;
    L6:
        return r10;
    }

    @NonNull
    public Collection<Fragment> getRetainedFragments() {
        return new ArrayList(this.mRetainedFragments.values());
    }

    @Nullable
    @Deprecated
    public FragmentManagerNonConfig getSnapshot() {
        if (this.mRetainedFragments.isEmpty() == true) goto L5;
    L9:
        HashMap r5 = new HashMap();
        Iterator<Map.Entry<String, FragmentManagerViewModel>> r10 = this.mChildNonConfigs.entrySet().iterator();
    L11:
        if (r10.hasNext() == false) goto L15;
        Map.Entry<String, FragmentManagerViewModel> r11 = r10.next();
        FragmentManagerNonConfig r12 = r11.getValue().getSnapshot();
        if (r12 == null) goto L11;
        r5.put(r11.getKey(), r12);
        goto L11
    L15:
        this.mHasSavedSnapshot = true;
        if (this.mRetainedFragments.isEmpty() == false) goto L23;
        if (r5.isEmpty() == false) goto L23;
        if (this.mViewModelStores.isEmpty() == false) goto L23;
        return null;
    L23:
        return new FragmentManagerNonConfig(new ArrayList(this.mRetainedFragments.values()), r5, new HashMap(this.mViewModelStores));
    L5:
        if (this.mChildNonConfigs.isEmpty() == false) goto L9;
        if (this.mViewModelStores.isEmpty() == false) goto L9;
        return null;
    }

    @NonNull
    public ViewModelStore getViewModelStore(@NonNull Fragment r5) {
        ViewModelStore r10 = this.mViewModelStores.get(r5.mWho);
        if (r10 != null) goto L6;
        ViewModelStore r11 = new ViewModelStore();
        this.mViewModelStores.put(r5.mWho, r11);
        return r11;
    L6:
        return r10;
    }

    public int hashCode() {
        int r5 = this.mRetainedFragments.hashCode() * 31;
        int r10 = (this.mChildNonConfigs.hashCode() + r5) * 31;
        return this.mViewModelStores.hashCode() + r10;
    }

    public boolean isCleared() {
        return this.mHasBeenCleared;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "onCleared called for " + this);
    L5:
        this.mHasBeenCleared = true;
    }

    public void removeRetainedFragment(@NonNull Fragment r5) {
        if (this.mIsStateSaved == false) goto L9;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L14;
        Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
        return;
    L14:
        return;
    L9:
        if (this.mRetainedFragments.remove(r5.mWho) != null) goto L11;
        return;
    L11:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L16;
        Log.v("FragmentManager", "Updating retained Fragments: Removed " + r5);
        return;
    }

    @Deprecated
    public void restoreFromSnapshot(@Nullable FragmentManagerNonConfig r5) {
        this.mRetainedFragments.clear();
        this.mChildNonConfigs.clear();
        this.mViewModelStores.clear();
        if (r5 == null) goto L21;
        Collection<Fragment> r10 = r5.getFragments();
        if (r10 == null) goto L12;
        Iterator<Fragment> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L12;
        Fragment r12 = r11.next();
        if (r12 == null) goto L8;
        this.mRetainedFragments.put(r12.mWho, r12);
    L12:
        Map<String, FragmentManagerNonConfig> r13 = r5.getChildNonConfigs();
        if (r13 == null) goto L18;
        Iterator<Map.Entry<String, FragmentManagerNonConfig>> r14 = r13.entrySet().iterator();
    L16:
        if (r14.hasNext() == false) goto L18;
        Map.Entry<String, FragmentManagerNonConfig> r15 = r14.next();
        FragmentManagerViewModel r16 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
        r16.restoreFromSnapshot(r15.getValue());
        this.mChildNonConfigs.put(r15.getKey(), r16);
    L18:
        Map<String, ViewModelStore> r17 = r5.getViewModelStores();
        if (r17 == null) goto L21;
        this.mViewModelStores.putAll(r17);
    L21:
        this.mHasSavedSnapshot = false;
    }

    public void setIsStateSaved(boolean r5) {
        this.mIsStateSaved = r5;
    }

    public boolean shouldDestroy(@NonNull Fragment r5) {
        if (this.mRetainedFragments.containsKey(r5.mWho) == true) goto L6;
        return true;
    L6:
        if (this.mStateAutomaticallySaved == false) goto L10;
        return this.mHasBeenCleared;
    L10:
        return !this.mHasSavedSnapshot;
    }

    @NonNull
    public String toString() {
        StringBuilder r5 = new StringBuilder("FragmentManagerViewModel{");
        r5.append(Integer.toHexString(System.identityHashCode(this)));
        r5.append("} Fragments (");
        Iterator<Fragment> r10 = this.mRetainedFragments.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        r5.append(r10.next());
        if (r10.hasNext() == false) goto L4;
        r5.append(", ");
        goto L4
    L8:
        r5.append(") Child Non Config (");
        Iterator<String> r11 = this.mChildNonConfigs.keySet().iterator();
    L10:
        if (r11.hasNext() == false) goto L14;
        r5.append(r11.next());
        if (r11.hasNext() == false) goto L10;
        r5.append(", ");
        goto L10
    L14:
        r5.append(") ViewModelStores (");
        Iterator<String> r12 = this.mViewModelStores.keySet().iterator();
    L16:
        if (r12.hasNext() == false) goto L20;
        r5.append(r12.next());
        if (r12.hasNext() == false) goto L16;
        r5.append(", ");
        goto L16
    L20:
        r5.append(')');
        return r5.toString();
    }

    public void clearNonConfigState(@NonNull String r5, boolean r10) {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        androidx.constraintlayout.motion.widget.a.A("Clearing non-config state for saved state of Fragment ", r5, "FragmentManager");
    L5:
        clearNonConfigStateInternal(r5, r10);
    }
}

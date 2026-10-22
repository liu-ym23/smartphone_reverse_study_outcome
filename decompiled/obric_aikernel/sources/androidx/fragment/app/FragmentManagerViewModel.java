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

    FragmentManagerViewModel(boolean r10) {
        this.mRetainedFragments = new HashMap();
        this.mChildNonConfigs = new HashMap();
        this.mViewModelStores = new HashMap();
        this.mHasBeenCleared = false;
        this.mHasSavedSnapshot = false;
        this.mIsStateSaved = false;
        this.mStateAutomaticallySaved = r10;
    }

    @NonNull
    static FragmentManagerViewModel getInstance(ViewModelStore r10) {
        return (FragmentManagerViewModel) new ViewModelProvider(r10, FACTORY).get(FragmentManagerViewModel.class);
    }

    void addRetainedFragment(@NonNull Fragment r10) {
        if (this.mIsStateSaved == false) goto L9;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L15;
        Log.v(TAG, "Ignoring addRetainedFragment as the state is already saved");
        return;
    L15:
        return;
    L9:
        if (this.mRetainedFragments.containsKey(r10.mWho) == false) goto L11;
        return;
    L11:
        this.mRetainedFragments.put(r10.mWho, r10);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L16;
        Log.v(TAG, "Updating retained Fragments: Added " + r10);
        return;
    }

    void clearNonConfigState(@NonNull Fragment r10) {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "Clearing non-config state for " + r10);
    L5:
        FragmentManagerViewModel r11 = this.mChildNonConfigs.get(r10.mWho);
        if (r11 == null) goto L8;
        r11.onCleared();
        this.mChildNonConfigs.remove(r10.mWho);
    L8:
        ViewModelStore r12 = this.mViewModelStores.get(r10.mWho);
        if (r12 == null) goto L12;
        r12.clear();
        this.mViewModelStores.remove(r10.mWho);
        return;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L19:
        return false;
    L8:
        if (FragmentManagerViewModel.class != r10.getClass()) goto L19;
        FragmentManagerViewModel r11 = (FragmentManagerViewModel) r10;
        if (this.mRetainedFragments.equals(r11.mRetainedFragments) == false) goto L18;
        if (this.mChildNonConfigs.equals(r11.mChildNonConfigs) == false) goto L18;
        if (this.mViewModelStores.equals(r11.mViewModelStores) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Nullable
    Fragment findRetainedFragmentByWho(String r10) {
        return this.mRetainedFragments.get(r10);
    }

    @NonNull
    FragmentManagerViewModel getChildNonConfig(@NonNull Fragment r10) {
        FragmentManagerViewModel r11 = this.mChildNonConfigs.get(r10.mWho);
        if (r11 != null) goto L6;
        FragmentManagerViewModel r12 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
        this.mChildNonConfigs.put(r10.mWho, r12);
        return r12;
    L6:
        return r11;
    }

    @NonNull
    Collection<Fragment> getRetainedFragments() {
        return new ArrayList(this.mRetainedFragments.values());
    }

    @Nullable
    @Deprecated
    FragmentManagerNonConfig getSnapshot() {
        if (this.mRetainedFragments.isEmpty() == true) goto L5;
    L9:
        HashMap r10 = new HashMap();
        Iterator<Map.Entry<String, FragmentManagerViewModel>> r11 = this.mChildNonConfigs.entrySet().iterator();
    L11:
        if (r11.hasNext() == false) goto L15;
        Map.Entry<String, FragmentManagerViewModel> r12 = r11.next();
        FragmentManagerNonConfig r13 = r12.getValue().getSnapshot();
        if (r13 == null) goto L11;
        r10.put(r12.getKey(), r13);
        goto L11
    L15:
        this.mHasSavedSnapshot = true;
        if (this.mRetainedFragments.isEmpty() == false) goto L23;
        if (r10.isEmpty() == false) goto L23;
        if (this.mViewModelStores.isEmpty() == false) goto L23;
        return null;
    L23:
        return new FragmentManagerNonConfig(new ArrayList(this.mRetainedFragments.values()), r10, new HashMap(this.mViewModelStores));
    L5:
        if (this.mChildNonConfigs.isEmpty() == false) goto L9;
        if (this.mViewModelStores.isEmpty() == false) goto L9;
        return null;
    }

    @NonNull
    ViewModelStore getViewModelStore(@NonNull Fragment r10) {
        ViewModelStore r11 = this.mViewModelStores.get(r10.mWho);
        if (r11 != null) goto L6;
        ViewModelStore r12 = new ViewModelStore();
        this.mViewModelStores.put(r10.mWho, r12);
        return r12;
    L6:
        return r11;
    }

    public int hashCode() {
        return (((this.mRetainedFragments.hashCode() * 31) + this.mChildNonConfigs.hashCode()) * 31) + this.mViewModelStores.hashCode();
    }

    boolean isCleared() {
        return this.mHasBeenCleared;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "onCleared called for " + this);
    L5:
        this.mHasBeenCleared = true;
    }

    void removeRetainedFragment(@NonNull Fragment r10) {
        if (this.mIsStateSaved == false) goto L9;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L17;
        Log.v(TAG, "Ignoring removeRetainedFragment as the state is already saved");
        return;
    L17:
        return;
    L9:
        if (this.mRetainedFragments.remove(r10.mWho) == null) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == true) goto L14;
        return;
    L14:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L19;
        Log.v(TAG, "Updating retained Fragments: Removed " + r10);
        return;
    L19:
        return;
    L11:
        r11 = false;
        goto L12
    }

    @Deprecated
    void restoreFromSnapshot(@Nullable FragmentManagerNonConfig r10) {
        this.mRetainedFragments.clear();
        this.mChildNonConfigs.clear();
        this.mViewModelStores.clear();
        if (r10 == null) goto L21;
        Collection<Fragment> r11 = r10.getFragments();
        if (r11 == null) goto L12;
        Iterator<Fragment> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        Fragment r13 = r12.next();
        if (r13 == null) goto L8;
        this.mRetainedFragments.put(r13.mWho, r13);
    L12:
        Map<String, FragmentManagerNonConfig> r14 = r10.getChildNonConfigs();
        if (r14 == null) goto L18;
        Iterator<Map.Entry<String, FragmentManagerNonConfig>> r15 = r14.entrySet().iterator();
    L16:
        if (r15.hasNext() == false) goto L18;
        Map.Entry<String, FragmentManagerNonConfig> r16 = r15.next();
        FragmentManagerViewModel r17 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
        r17.restoreFromSnapshot(r16.getValue());
        this.mChildNonConfigs.put(r16.getKey(), r17);
    L18:
        Map<String, ViewModelStore> r18 = r10.getViewModelStores();
        if (r18 == null) goto L21;
        this.mViewModelStores.putAll(r18);
    L21:
        this.mHasSavedSnapshot = false;
    }

    void setIsStateSaved(boolean r10) {
        this.mIsStateSaved = r10;
    }

    boolean shouldDestroy(@NonNull Fragment r10) {
        if (this.mRetainedFragments.containsKey(r10.mWho) == true) goto L6;
        return true;
    L6:
        if (this.mStateAutomaticallySaved == false) goto L10;
        return this.mHasBeenCleared;
    L10:
        return !this.mHasSavedSnapshot;
    }

    @NonNull
    public String toString() {
        StringBuilder r10 = new StringBuilder("FragmentManagerViewModel{");
        r10.append(Integer.toHexString(System.identityHashCode(this)));
        r10.append("} Fragments (");
        Iterator<Fragment> r11 = this.mRetainedFragments.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        r10.append(r11.next());
        if (r11.hasNext() == false) goto L4;
        r10.append(", ");
        goto L4
    L8:
        r10.append(") Child Non Config (");
        Iterator<String> r12 = this.mChildNonConfigs.keySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        r10.append(r12.next());
        if (r12.hasNext() == false) goto L10;
        r10.append(", ");
        goto L10
    L14:
        r10.append(") ViewModelStores (");
        Iterator<String> r13 = this.mViewModelStores.keySet().iterator();
    L16:
        if (r13.hasNext() == false) goto L20;
        r10.append(r13.next());
        if (r13.hasNext() == false) goto L16;
        r10.append(", ");
        goto L16
    L20:
        r10.append(')');
        return r10.toString();
    }
}

package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FragmentController {
    private final FragmentHostCallback<?> mHost;

    private FragmentController(FragmentHostCallback<?> r10) {
        this.mHost = r10;
    }

    @NonNull
    public static FragmentController createController(@NonNull FragmentHostCallback<?> r10) {
        return new FragmentController((FragmentHostCallback) Preconditions.checkNotNull(r10, "callbacks == null"));
    }

    public void attachHost(@Nullable Fragment r10) {
        FragmentHostCallback<?> r11 = this.mHost;
        r11.mFragmentManager.attachController(r11, r11, r10);
    }

    public void dispatchActivityCreated() {
        this.mHost.mFragmentManager.dispatchActivityCreated();
    }

    public void dispatchConfigurationChanged(@NonNull Configuration r10) {
        this.mHost.mFragmentManager.dispatchConfigurationChanged(r10);
    }

    public boolean dispatchContextItemSelected(@NonNull MenuItem r10) {
        return this.mHost.mFragmentManager.dispatchContextItemSelected(r10);
    }

    public void dispatchCreate() {
        this.mHost.mFragmentManager.dispatchCreate();
    }

    public boolean dispatchCreateOptionsMenu(@NonNull Menu r10, @NonNull MenuInflater r11) {
        return this.mHost.mFragmentManager.dispatchCreateOptionsMenu(r10, r11);
    }

    public void dispatchDestroy() {
        this.mHost.mFragmentManager.dispatchDestroy();
    }

    public void dispatchDestroyView() {
        this.mHost.mFragmentManager.dispatchDestroyView();
    }

    public void dispatchLowMemory() {
        this.mHost.mFragmentManager.dispatchLowMemory();
    }

    public void dispatchMultiWindowModeChanged(boolean r10) {
        this.mHost.mFragmentManager.dispatchMultiWindowModeChanged(r10);
    }

    public boolean dispatchOptionsItemSelected(@NonNull MenuItem r10) {
        return this.mHost.mFragmentManager.dispatchOptionsItemSelected(r10);
    }

    public void dispatchOptionsMenuClosed(@NonNull Menu r10) {
        this.mHost.mFragmentManager.dispatchOptionsMenuClosed(r10);
    }

    public void dispatchPause() {
        this.mHost.mFragmentManager.dispatchPause();
    }

    public void dispatchPictureInPictureModeChanged(boolean r10) {
        this.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(r10);
    }

    public boolean dispatchPrepareOptionsMenu(@NonNull Menu r10) {
        return this.mHost.mFragmentManager.dispatchPrepareOptionsMenu(r10);
    }

    @Deprecated
    public void dispatchReallyStop() {
    }

    public void dispatchResume() {
        this.mHost.mFragmentManager.dispatchResume();
    }

    public void dispatchStart() {
        this.mHost.mFragmentManager.dispatchStart();
    }

    public void dispatchStop() {
        this.mHost.mFragmentManager.dispatchStop();
    }

    @Deprecated
    public void doLoaderDestroy() {
    }

    @Deprecated
    public void doLoaderRetain() {
    }

    @Deprecated
    public void doLoaderStart() {
    }

    @Deprecated
    public void doLoaderStop(boolean r10) {
    }

    @Deprecated
    public void dumpLoaders(@NonNull String r10, @Nullable FileDescriptor r11, @NonNull PrintWriter r12, @Nullable String[] r13) {
    }

    public boolean execPendingActions() {
        return this.mHost.mFragmentManager.execPendingActions(true);
    }

    @Nullable
    public Fragment findFragmentByWho(@NonNull String r10) {
        return this.mHost.mFragmentManager.findFragmentByWho(r10);
    }

    @NonNull
    public List<Fragment> getActiveFragments(@SuppressLint({"UnknownNullness"}) List<Fragment> r10) {
        return this.mHost.mFragmentManager.getActiveFragments();
    }

    public int getActiveFragmentsCount() {
        return this.mHost.mFragmentManager.getActiveFragmentCount();
    }

    @NonNull
    public FragmentManager getSupportFragmentManager() {
        return this.mHost.mFragmentManager;
    }

    @SuppressLint({"UnknownNullness"})
    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void noteStateNotSaved() {
        this.mHost.mFragmentManager.noteStateNotSaved();
    }

    @Nullable
    public View onCreateView(@Nullable View r10, @NonNull String r11, @NonNull Context r12, @NonNull AttributeSet r13) {
        return this.mHost.mFragmentManager.getLayoutInflaterFactory().onCreateView(r10, r11, r12, r13);
    }

    @Deprecated
    public void reportLoaderStart() {
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable r10, @Nullable FragmentManagerNonConfig r11) {
        this.mHost.mFragmentManager.restoreAllState(r10, r11);
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable r10, @Nullable List<Fragment> r11) {
        this.mHost.mFragmentManager.restoreAllState(r10, new FragmentManagerNonConfig(r11, null, null));
    }

    @Deprecated
    public void restoreLoaderNonConfig(@SuppressLint({"UnknownNullness"}) SimpleArrayMap<String, LoaderManager> r10) {
    }

    public void restoreSaveState(@Nullable Parcelable r10) {
        FragmentHostCallback<?> r11 = this.mHost;
        if ((r11 instanceof ViewModelStoreOwner) == false) goto L7;
        r11.mFragmentManager.restoreSaveState(r10);
        return;
    L7:
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    @Nullable
    @Deprecated
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return null;
    }

    @Nullable
    @Deprecated
    public FragmentManagerNonConfig retainNestedNonConfig() {
        return this.mHost.mFragmentManager.retainNonConfig();
    }

    @Nullable
    @Deprecated
    public List<Fragment> retainNonConfig() {
        FragmentManagerNonConfig r10 = this.mHost.mFragmentManager.retainNonConfig();
        if (r10 != null) goto L5;
    L7:
        return null;
    L5:
        if (r10.getFragments() == null) goto L7;
        return new ArrayList(r10.getFragments());
    }

    @Nullable
    public Parcelable saveAllState() {
        return this.mHost.mFragmentManager.saveAllState();
    }
}

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

    private FragmentController(FragmentHostCallback<?> r5) {
        this.mHost = r5;
    }

    @NonNull
    public static FragmentController createController(@NonNull FragmentHostCallback<?> r5) {
        return new FragmentController((FragmentHostCallback) Preconditions.checkNotNull(r5, "callbacks == null"));
    }

    public void attachHost(@Nullable Fragment r5) {
        FragmentHostCallback<?> r10 = this.mHost;
        r10.mFragmentManager.attachController(r10, r10, r5);
    }

    public void dispatchActivityCreated() {
        this.mHost.mFragmentManager.dispatchActivityCreated();
    }

    @Deprecated
    public void dispatchConfigurationChanged(@NonNull Configuration r5) {
        this.mHost.mFragmentManager.dispatchConfigurationChanged(r5, true);
    }

    public boolean dispatchContextItemSelected(@NonNull MenuItem r5) {
        return this.mHost.mFragmentManager.dispatchContextItemSelected(r5);
    }

    public void dispatchCreate() {
        this.mHost.mFragmentManager.dispatchCreate();
    }

    @Deprecated
    public boolean dispatchCreateOptionsMenu(@NonNull Menu r5, @NonNull MenuInflater r10) {
        return this.mHost.mFragmentManager.dispatchCreateOptionsMenu(r5, r10);
    }

    public void dispatchDestroy() {
        this.mHost.mFragmentManager.dispatchDestroy();
    }

    public void dispatchDestroyView() {
        this.mHost.mFragmentManager.dispatchDestroyView();
    }

    @Deprecated
    public void dispatchLowMemory() {
        this.mHost.mFragmentManager.dispatchLowMemory(true);
    }

    @Deprecated
    public void dispatchMultiWindowModeChanged(boolean r5) {
        this.mHost.mFragmentManager.dispatchMultiWindowModeChanged(r5, true);
    }

    @Deprecated
    public boolean dispatchOptionsItemSelected(@NonNull MenuItem r5) {
        return this.mHost.mFragmentManager.dispatchOptionsItemSelected(r5);
    }

    @Deprecated
    public void dispatchOptionsMenuClosed(@NonNull Menu r5) {
        this.mHost.mFragmentManager.dispatchOptionsMenuClosed(r5);
    }

    public void dispatchPause() {
        this.mHost.mFragmentManager.dispatchPause();
    }

    @Deprecated
    public void dispatchPictureInPictureModeChanged(boolean r5) {
        this.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(r5, true);
    }

    @Deprecated
    public boolean dispatchPrepareOptionsMenu(@NonNull Menu r5) {
        return this.mHost.mFragmentManager.dispatchPrepareOptionsMenu(r5);
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
    public void doLoaderStop(boolean r5) {
    }

    @Deprecated
    public void dumpLoaders(@NonNull String r5, @Nullable FileDescriptor r10, @NonNull PrintWriter r11, @Nullable String[] r12) {
    }

    public boolean execPendingActions() {
        return this.mHost.mFragmentManager.execPendingActions(true);
    }

    @Nullable
    public Fragment findFragmentByWho(@NonNull String r5) {
        return this.mHost.mFragmentManager.findFragmentByWho(r5);
    }

    @NonNull
    public List<Fragment> getActiveFragments(@SuppressLint({"UnknownNullness"}) List<Fragment> r5) {
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
    public View onCreateView(@Nullable View r5, @NonNull String r10, @NonNull Context r11, @NonNull AttributeSet r12) {
        return this.mHost.mFragmentManager.getLayoutInflaterFactory().onCreateView(r5, r10, r11, r12);
    }

    @Deprecated
    public void reportLoaderStart() {
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable r5, @Nullable List<Fragment> r10) {
        this.mHost.mFragmentManager.restoreAllState(r5, new FragmentManagerNonConfig(r10, null, null));
    }

    @Deprecated
    public void restoreLoaderNonConfig(@SuppressLint({"UnknownNullness"}) SimpleArrayMap<String, LoaderManager> r5) {
    }

    @Deprecated
    public void restoreSaveState(@Nullable Parcelable r5) {
        FragmentHostCallback<?> r10 = this.mHost;
        if ((r10 instanceof ViewModelStoreOwner) == false) goto L7;
        r10.mFragmentManager.restoreSaveState(r5);
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
        FragmentManagerNonConfig r5 = this.mHost.mFragmentManager.retainNonConfig();
        if (r5 != null) goto L5;
    L7:
        return null;
    L5:
        if (r5.getFragments() == null) goto L7;
        return new ArrayList(r5.getFragments());
    }

    @Nullable
    @Deprecated
    public Parcelable saveAllState() {
        return this.mHost.mFragmentManager.saveAllState();
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable r5, @Nullable FragmentManagerNonConfig r10) {
        this.mHost.mFragmentManager.restoreAllState(r5, r10);
    }
}

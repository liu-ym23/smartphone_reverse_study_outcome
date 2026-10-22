package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FragmentController {
    private final FragmentHostCallback<?> mHost;

    private FragmentController(FragmentHostCallback<?> r1) {
        this.mHost = r1;
    }

    public static FragmentController createController(FragmentHostCallback<?> r3) {
        return new FragmentController((FragmentHostCallback) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r3, "callbacks == null"), FragmentHostCallback.class, "com.obric.memorydata.plugin"));
    }

    public void attachHost(Fragment r2) {
        FragmentManager r0 = this.mHost.mFragmentManager;
        FragmentHostCallback<?> r1 = this.mHost;
        r0.attachController(r1, r1, r2);
    }

    public void dispatchActivityCreated() {
        this.mHost.mFragmentManager.dispatchActivityCreated();
    }

    @Deprecated
    public void dispatchConfigurationChanged(Configuration r1) {
        this.mHost.mFragmentManager.dispatchConfigurationChanged(r1);
    }

    public boolean dispatchContextItemSelected(MenuItem r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin");
        return this.mHost.mFragmentManager.dispatchContextItemSelected(r4);
    }

    public void dispatchCreate() {
        this.mHost.mFragmentManager.dispatchCreate();
    }

    @Deprecated
    public boolean dispatchCreateOptionsMenu(Menu r3, MenuInflater r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.memorydata.plugin");
        return this.mHost.mFragmentManager.dispatchCreateOptionsMenu(r5, r4);
    }

    public void dispatchDestroy() {
        this.mHost.mFragmentManager.dispatchDestroy();
    }

    public void dispatchDestroyView() {
        this.mHost.mFragmentManager.dispatchDestroyView();
    }

    @Deprecated
    public void dispatchLowMemory() {
        this.mHost.mFragmentManager.dispatchLowMemory();
    }

    @Deprecated
    public void dispatchMultiWindowModeChanged(boolean r1) {
        this.mHost.mFragmentManager.dispatchMultiWindowModeChanged(r1);
    }

    @Deprecated
    public boolean dispatchOptionsItemSelected(MenuItem r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin");
        return this.mHost.mFragmentManager.dispatchOptionsItemSelected(r4);
    }

    @Deprecated
    public void dispatchOptionsMenuClosed(Menu r3) {
        Menu r4 = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.memorydata.plugin");
        this.mHost.mFragmentManager.dispatchOptionsMenuClosed(r4);
    }

    public void dispatchPause() {
        this.mHost.mFragmentManager.dispatchPause();
    }

    @Deprecated
    public void dispatchPictureInPictureModeChanged(boolean r1) {
        this.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(r1);
    }

    @Deprecated
    public boolean dispatchPrepareOptionsMenu(Menu r3) {
        Menu r4 = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.memorydata.plugin");
        return this.mHost.mFragmentManager.dispatchPrepareOptionsMenu(r4);
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
    public void doLoaderStop(boolean r1) {
    }

    @Deprecated
    public void dumpLoaders(String r1, FileDescriptor r2, PrintWriter r3, String[] r4) {
    }

    public boolean execPendingActions() {
        return this.mHost.mFragmentManager.execPendingActions(true);
    }

    public Fragment findFragmentByWho(String r1) {
        return this.mHost.mFragmentManager.findFragmentByWho(r1);
    }

    public List<Fragment> getActiveFragments(List<Fragment> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        return this.mHost.mFragmentManager.getActiveFragments();
    }

    public int getActiveFragmentsCount() {
        return this.mHost.mFragmentManager.getActiveFragmentCount();
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mHost.mFragmentManager;
    }

    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void noteStateNotSaved() {
        this.mHost.mFragmentManager.noteStateNotSaved();
    }

    public View onCreateView(View r3, String r4, Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        return this.mHost.mFragmentManager.getLayoutInflaterFactory().onCreateView(r3, r4, r7, r8);
    }

    @Deprecated
    public void reportLoaderStart() {
    }

    @Deprecated
    public void restoreAllState(Parcelable r3, FragmentManagerNonConfig r4) {
        Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        this.mHost.mFragmentManager.restoreAllState(r5, r4);
    }

    @Deprecated
    public void restoreAllState(Parcelable r3, List<Fragment> r4) {
        Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.mHost.mFragmentManager.restoreAllState(r5, new FragmentManagerNonConfig(r6, null, null));
    }

    @Deprecated
    public void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> r1) {
    }

    @Deprecated
    public void restoreSaveState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(this.mHost, ViewModelStoreOwner.class) == false) goto L7;
        this.mHost.mFragmentManager.restoreSaveState(r4);
        return;
    L7:
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    @Deprecated
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return null;
    }

    @Deprecated
    public FragmentManagerNonConfig retainNestedNonConfig() {
        return this.mHost.mFragmentManager.retainNonConfig();
    }

    @Deprecated
    public List<Fragment> retainNonConfig() {
        FragmentManagerNonConfig r1 = this.mHost.mFragmentManager.retainNonConfig();
        if (r1 != null) goto L5;
    L7:
        return null;
    L5:
        if (r1.getFragments() == null) goto L7;
        return new ArrayList(r1.getFragments());
    }

    @Deprecated
    public Parcelable saveAllState() {
        return this.mHost.mFragmentManager.saveAllState();
    }
}

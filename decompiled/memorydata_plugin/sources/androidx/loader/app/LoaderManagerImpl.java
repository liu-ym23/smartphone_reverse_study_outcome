package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.content.Loader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
class LoaderManagerImpl extends LoaderManager {
    static boolean DEBUG = false;
    static final String TAG = "LoaderManager";
    private final LifecycleOwner mLifecycleOwner;
    private final LoaderViewModel mLoaderViewModel;

    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {
        private final Bundle mArgs;
        private final int mId;
        private LifecycleOwner mLifecycleOwner;
        private final Loader<D> mLoader;
        private LoaderObserver<D> mObserver;
        private Loader<D> mPriorLoader;

        LoaderInfo(int r1, Bundle r2, Loader<D> r3, Loader<D> r4) {
            this.mId = r1;
            this.mArgs = r2;
            this.mLoader = r3;
            this.mPriorLoader = r4;
            r3.registerListener(r1, this);
        }

        Loader<D> destroy(boolean r3) {
            if (LoaderManagerImpl.DEBUG == false) goto L5;
            Log.v(LoaderManagerImpl.TAG, "  Destroying: " + this);
        L5:
            this.mLoader.cancelLoad();
            this.mLoader.abandon();
            LoaderObserver<D> r0 = this.mObserver;
            if (r0 == null) goto L10;
            removeObserver(r0);
            if (r3 == false) goto L10;
            r0.reset();
        L10:
            this.mLoader.unregisterListener(this);
            if (r0 != null) goto L13;
        L14:
            if (r3 == false) goto L18;
        L15:
            this.mLoader.reset();
            return this.mPriorLoader;
        L18:
            return this.mLoader;
        L13:
            if (r0.hasDeliveredData() == false) goto L15;
            goto L14
        }

        public void dump(String r4, FileDescriptor r5, PrintWriter r6, String[] r7) {
            r6.print(r4);
            r6.print("mId=");
            r6.print(this.mId);
            r6.print(" mArgs=");
            r6.println(this.mArgs);
            r6.print(r4);
            r6.print("mLoader=");
            r6.println(this.mLoader);
            this.mLoader.dump(r4 + "  ", r5, r6, r7);
            if (this.mObserver == null) goto L5;
            r6.print(r4);
            r6.print("mCallbacks=");
            r6.println(this.mObserver);
            this.mObserver.dump(r4 + "  ", r6);
        L5:
            r6.print(r4);
            r6.print("mData=");
            r6.println(getLoader().dataToString(getValue()));
            r6.print(r4);
            r6.print("mStarted=");
            r6.println(hasActiveObservers());
        }

        Loader<D> getLoader() {
            return this.mLoader;
        }

        boolean isCallbackWaitingForData() {
            if (hasActiveObservers() == true) goto L5;
            return false;
        L5:
            LoaderObserver<D> r2 = this.mObserver;
            if (r2 != null) goto L8;
            return false;
        L8:
            if (r2.hasDeliveredData() == true) goto L12;
            return true;
        L12:
            return false;
        }

        void markForRedelivery() {
            LifecycleOwner r0 = this.mLifecycleOwner;
            LoaderObserver<D> r1 = this.mObserver;
            if (r0 == null) goto L7;
            if (r1 == null) goto L8;
            super.removeObserver(r1);
            observe(r0, r1);
            return;
        L8:
            return;
        }

        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            if (LoaderManagerImpl.DEBUG == false) goto L5;
            Log.v(LoaderManagerImpl.TAG, "  Starting: " + this);
        L5:
            this.mLoader.startLoading();
        }

        @Override // androidx.lifecycle.LiveData
        public void onInactive() {
            if (LoaderManagerImpl.DEBUG == false) goto L5;
            Log.v(LoaderManagerImpl.TAG, "  Stopping: " + this);
        L5:
            this.mLoader.stopLoading();
        }

        @Override // androidx.loader.content.Loader.OnLoadCompleteListener
        public void onLoadComplete(Loader<D> r3, D r4) {
            if (LoaderManagerImpl.DEBUG == false) goto L6;
            Log.v(LoaderManagerImpl.TAG, "onLoadComplete: " + this);
        L6:
            if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
            setValue(r4);
            return;
        L9:
            if (LoaderManagerImpl.DEBUG == false) goto L11;
            Log.w(LoaderManagerImpl.TAG, "onLoadComplete was incorrectly called on a background thread");
        L11:
            postValue(r4);
        }

        @Override // androidx.lifecycle.LiveData
        public void removeObserver(Observer<? super D> r3) {
            super.removeObserver((Observer) ZeusTransformUtils.wrapperContextForParams(r3, Observer.class, "com.obric.memorydata.plugin"));
            this.mLifecycleOwner = null;
            this.mObserver = null;
        }

        Loader<D> setCallback(LifecycleOwner r3, LoaderManager.LoaderCallbacks<D> r4) {
            LifecycleOwner r5 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
            LoaderManager.LoaderCallbacks r6 = (LoaderManager.LoaderCallbacks) ZeusTransformUtils.wrapperContextForParams(r4, LoaderManager.LoaderCallbacks.class, "com.obric.memorydata.plugin");
            LoaderObserver<D> r0 = new LoaderObserver(this.mLoader, r6);
            observe(r5, r0);
            LoaderObserver<D> r7 = this.mObserver;
            if (r7 == null) goto L5;
            removeObserver(r7);
        L5:
            this.mLifecycleOwner = r5;
            this.mObserver = r0;
            return this.mLoader;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(D r1) {
            super.setValue(r1);
            Loader<D> r2 = this.mPriorLoader;
            if (r2 == null) goto L6;
            r2.reset();
            this.mPriorLoader = null;
            return;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder(64);
            r0.append("LoaderInfo{");
            r0.append(Integer.toHexString(System.identityHashCode(this)));
            r0.append(" #");
            r0.append(this.mId);
            r0.append(" : ");
            DebugUtils.buildShortClassTag(this.mLoader, r0);
            r0.append("}}");
            return r0.toString();
        }
    }

    static class LoaderObserver<D> implements Observer<D> {
        private final LoaderManager.LoaderCallbacks<D> mCallback;
        private boolean mDeliveredData;
        private final Loader<D> mLoader;

        LoaderObserver(Loader<D> r3, LoaderManager.LoaderCallbacks<D> r4) {
            LoaderManager.LoaderCallbacks<D> r5 = (LoaderManager.LoaderCallbacks) ZeusTransformUtils.wrapperContextForParams(r4, LoaderManager.LoaderCallbacks.class, "com.obric.memorydata.plugin");
            this.mDeliveredData = false;
            this.mLoader = r3;
            this.mCallback = r5;
        }

        public void dump(String r1, PrintWriter r2) {
            r2.print(r1);
            r2.print("mDeliveredData=");
            r2.println(this.mDeliveredData);
        }

        boolean hasDeliveredData() {
            return this.mDeliveredData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(D r3) {
            if (LoaderManagerImpl.DEBUG == false) goto L5;
            Log.v(LoaderManagerImpl.TAG, "  onLoadFinished in " + this.mLoader + ": " + this.mLoader.dataToString(r3));
        L5:
            this.mCallback.onLoadFinished(this.mLoader, r3);
            this.mDeliveredData = true;
        }

        void reset() {
            if (this.mDeliveredData == true) goto L5;
            return;
        L5:
            if (LoaderManagerImpl.DEBUG == false) goto L7;
            Log.v(LoaderManagerImpl.TAG, "  Resetting: " + this.mLoader);
        L7:
            this.mCallback.onLoaderReset(this.mLoader);
        }

        public String toString() {
            return this.mCallback.toString();
        }
    }

    static class LoaderViewModel extends ViewModel {
        private static final ViewModelProvider.Factory FACTORY = null;
        private boolean mCreatingLoader;
        private SparseArrayCompat<LoaderInfo> mLoaders;

        static {
            FACTORY = new AnonymousClass1();
        }

        LoaderViewModel() {
            this.mLoaders = new SparseArrayCompat();
            this.mCreatingLoader = false;
        }

        static LoaderViewModel getInstance(ViewModelStore r3) {
            return (LoaderViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider(r3, FACTORY).get(LoaderViewModel.class), LoaderViewModel.class, "com.obric.memorydata.plugin");
        }

        public void dump(String r6, FileDescriptor r7, PrintWriter r8, String[] r9) {
            if (this.mLoaders.size() <= 0) goto L8;
            r8.print(r6);
            r8.println("Loaders:");
            String r0 = r6 + "    ";
            int r1 = 0;
        L6:
            if (r1 >= this.mLoaders.size()) goto L10;
            LoaderInfo r2 = (LoaderInfo) ZeusTransformUtils.preCheckCast(this.mLoaders.valueAt(r1), LoaderInfo.class, "com.obric.memorydata.plugin");
            r8.print(r6);
            r8.print("  #");
            r8.print(this.mLoaders.keyAt(r1));
            r8.print(": ");
            r8.println(r2.toString());
            r2.dump(r0, r7, r8, r9);
            r1 = r1 + 1;
            goto L6
        L10:
            return;
        }

        void finishCreatingLoader() {
            this.mCreatingLoader = false;
        }

        <D> LoaderInfo<D> getLoader(int r2) {
            return (LoaderInfo) ZeusTransformUtils.preCheckCast(this.mLoaders.get(r2), LoaderInfo.class, "com.obric.memorydata.plugin");
        }

        boolean hasRunningLoaders() {
            int r0 = this.mLoaders.size();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            if (((LoaderInfo) ZeusTransformUtils.preCheckCast(this.mLoaders.valueAt(r2), LoaderInfo.class, "com.obric.memorydata.plugin")).isCallbackWaitingForData() == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        boolean isCreatingLoader() {
            return this.mCreatingLoader;
        }

        void markForRedelivery() {
            int r0 = this.mLoaders.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            ((LoaderInfo) ZeusTransformUtils.preCheckCast(this.mLoaders.valueAt(r1), LoaderInfo.class, "com.obric.memorydata.plugin")).markForRedelivery();
            r1 = r1 + 1;
            goto L3
        }

        @Override // androidx.lifecycle.ViewModel
        public void onCleared() {
            super.onCleared();
            int r0 = this.mLoaders.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            ((LoaderInfo) ZeusTransformUtils.preCheckCast(this.mLoaders.valueAt(r1), LoaderInfo.class, "com.obric.memorydata.plugin")).destroy(true);
            r1 = r1 + 1;
            goto L3
        L5:
            this.mLoaders.clear();
        }

        void putLoader(int r1, LoaderInfo r2) {
            this.mLoaders.put(r1, r2);
        }

        void removeLoader(int r1) {
            this.mLoaders.remove(r1);
        }

        void startCreatingLoader() {
            this.mCreatingLoader = true;
        }
    }

    static {
    }

    LoaderManagerImpl(LifecycleOwner r3, ViewModelStore r4) {
        this.mLifecycleOwner = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
        this.mLoaderViewModel = LoaderViewModel.getInstance(r4);
    }

    private <D> Loader<D> createAndInstallLoader(int r3, Bundle r4, LoaderManager.LoaderCallbacks<D> r5, Loader<D> r6) {
        LoaderManager.LoaderCallbacks<D> r7 = (LoaderManager.LoaderCallbacks) ZeusTransformUtils.wrapperContextForParams(r5, LoaderManager.LoaderCallbacks.class, "com.obric.memorydata.plugin");
        this.mLoaderViewModel.startCreatingLoader();     // Catch: Throwable -> L20
        Loader<D> r0 = r7.onCreateLoader(r3, r4);     // Catch: Throwable -> L20
        if (r0 == null) goto L19;
        if (r0.getClass().isMemberClass() == true) goto L8;
    L12:
        LoaderInfo r1 = new LoaderInfo(r3, r4, r0, r6);     // Catch: Throwable -> L20
        if (DEBUG == false) goto L15;
        Log.v(TAG, "  Created new loader " + r1);     // Catch: Throwable -> L20
    L15:
        this.mLoaderViewModel.putLoader(r3, r1);     // Catch: Throwable -> L20
        this.mLoaderViewModel.finishCreatingLoader();
        return r1.setCallback(this.mLifecycleOwner, r7);
    L8:
        if (Modifier.isStatic(r0.getClass().getModifiers()) == true) goto L12;
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + r0);     // Catch: Throwable -> L20
    L19:
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        this.mLoaderViewModel.finishCreatingLoader();
        throw th;
    }

    @Override // androidx.loader.app.LoaderManager
    public void destroyLoader(int r3) {
        if (this.mLoaderViewModel.isCreatingLoader() == true) goto L16;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L14;
        if (DEBUG == false) goto L9;
        Log.v(TAG, "destroyLoader in " + this + " of " + r3);
    L9:
        LoaderInfo r0 = this.mLoaderViewModel.getLoader(r3);
        if (r0 == null) goto L17;
        r0.destroy(true);
        this.mLoaderViewModel.removeLoader(r3);
        return;
    L17:
        return;
    L14:
        throw new IllegalStateException("destroyLoader must be called on the main thread");
    L16:
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.LoaderManager
    @Deprecated
    public void dump(String r1, FileDescriptor r2, PrintWriter r3, String[] r4) {
        this.mLoaderViewModel.dump(r1, r2, r3, r4);
    }

    @Override // androidx.loader.app.LoaderManager
    public <D> Loader<D> getLoader(int r2) {
        if (this.mLoaderViewModel.isCreatingLoader() == true) goto L10;
        LoaderInfo<D> r1 = this.mLoaderViewModel.getLoader(r2);
        if (r1 != null) goto L11;
        return null;
    L11:
        return r1.getLoader();
    L10:
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.LoaderManager
    public boolean hasRunningLoaders() {
        return this.mLoaderViewModel.hasRunningLoaders();
    }

    @Override // androidx.loader.app.LoaderManager
    public <D> Loader<D> initLoader(int r5, Bundle r6, LoaderManager.LoaderCallbacks<D> r7) {
        LoaderManager.LoaderCallbacks<D> r8 = (LoaderManager.LoaderCallbacks) ZeusTransformUtils.wrapperContextForParams(r7, LoaderManager.LoaderCallbacks.class, "com.obric.memorydata.plugin");
        if (this.mLoaderViewModel.isCreatingLoader() == true) goto L20;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L18;
        LoaderInfo<D> r0 = this.mLoaderViewModel.getLoader(r5);
        if (DEBUG == false) goto L9;
        Log.v(TAG, "initLoader in " + this + ": args=" + r6);
    L9:
        if (r0 != null) goto L13;
        return createAndInstallLoader(r5, r6, r8, null);
    L13:
        if (DEBUG == false) goto L16;
        Log.v(TAG, "  Re-using existing loader " + r0);
    L16:
        return r0.setCallback(this.mLifecycleOwner, r8);
    L18:
        throw new IllegalStateException("initLoader must be called on the main thread");
    L20:
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.LoaderManager
    public void markForRedelivery() {
        this.mLoaderViewModel.markForRedelivery();
    }

    @Override // androidx.loader.app.LoaderManager
    public <D> Loader<D> restartLoader(int r3, Bundle r4, LoaderManager.LoaderCallbacks<D> r5) {
        LoaderManager.LoaderCallbacks<D> r6 = (LoaderManager.LoaderCallbacks) ZeusTransformUtils.wrapperContextForParams(r5, LoaderManager.LoaderCallbacks.class, "com.obric.memorydata.plugin");
        if (this.mLoaderViewModel.isCreatingLoader() == true) goto L17;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L15;
        if (DEBUG == false) goto L9;
        Log.v(TAG, "restartLoader in " + this + ": args=" + r4);
    L9:
        LoaderInfo<D> r0 = this.mLoaderViewModel.getLoader(r3);
        Loader<D> r1 = null;
        if (r0 == null) goto L13;
        r1 = r0.destroy(false);
    L13:
        return createAndInstallLoader(r3, r4, r6, r1);
    L15:
        throw new IllegalStateException("restartLoader must be called on the main thread");
    L17:
        throw new IllegalStateException("Called while creating a loader");
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        r0.append("LoaderManager{");
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        r0.append(" in ");
        DebugUtils.buildShortClassTag(this.mLifecycleOwner, r0);
        r0.append("}}");
        return r0.toString();
    }
}

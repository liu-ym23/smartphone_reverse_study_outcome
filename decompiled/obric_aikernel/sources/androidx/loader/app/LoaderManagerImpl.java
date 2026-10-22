package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
class LoaderManagerImpl extends LoaderManager {
    static boolean DEBUG = false;
    static final String TAG = "LoaderManager";

    @NonNull
    private final LifecycleOwner mLifecycleOwner;

    @NonNull
    private final LoaderViewModel mLoaderViewModel;

    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {

        @Nullable
        private final Bundle mArgs;
        private final int mId;
        private LifecycleOwner mLifecycleOwner;

        @NonNull
        private final Loader<D> mLoader;
        private LoaderObserver<D> mObserver;
        private Loader<D> mPriorLoader;

        LoaderInfo(int r10, @Nullable Bundle r11, @NonNull Loader<D> r12, @Nullable Loader<D> r13) {
            this.mId = r10;
            this.mArgs = r11;
            this.mLoader = r12;
            this.mPriorLoader = r13;
            r12.registerListener(r10, this);
        }

        @MainThread
        Loader<D> destroy(boolean r10) {
            if (LoaderManagerImpl.DEBUG == false) goto L5;
            Log.v(LoaderManagerImpl.TAG, "  Destroying: " + this);
        L5:
            this.mLoader.cancelLoad();
            this.mLoader.abandon();
            LoaderObserver<D> r11 = this.mObserver;
            if (r11 == null) goto L10;
            removeObserver(r11);
            if (r10 == false) goto L10;
            r11.reset();
        L10:
            this.mLoader.unregisterListener(this);
            if (r11 != null) goto L13;
        L14:
            if (r10 == false) goto L18;
        L15:
            this.mLoader.reset();
            return this.mPriorLoader;
        L18:
            return this.mLoader;
        L13:
            if (r11.hasDeliveredData() == false) goto L15;
            goto L14
        }

        public void dump(String r10, FileDescriptor r11, PrintWriter r12, String[] r13) {
            r12.print(r10);
            r12.print("mId=");
            r12.print(this.mId);
            r12.print(" mArgs=");
            r12.println(this.mArgs);
            r12.print(r10);
            r12.print("mLoader=");
            r12.println(this.mLoader);
            this.mLoader.dump(r10 + "  ", r11, r12, r13);
            if (this.mObserver == null) goto L5;
            r12.print(r10);
            r12.print("mCallbacks=");
            r12.println(this.mObserver);
            this.mObserver.dump(r10 + "  ", r12);
        L5:
            r12.print(r10);
            r12.print("mData=");
            r12.println(getLoader().dataToString(getValue()));
            r12.print(r10);
            r12.print("mStarted=");
            r12.println(hasActiveObservers());
        }

        @NonNull
        Loader<D> getLoader() {
            return this.mLoader;
        }

        boolean isCallbackWaitingForData() {
            if (hasActiveObservers() == true) goto L5;
            return false;
        L5:
            LoaderObserver<D> r10 = this.mObserver;
            if (r10 != null) goto L8;
            return false;
        L8:
            if (r10.hasDeliveredData() == true) goto L12;
            return true;
        L12:
            return false;
        }

        void markForRedelivery() {
            LifecycleOwner r10 = this.mLifecycleOwner;
            LoaderObserver<D> r11 = this.mObserver;
            if (r10 == null) goto L7;
            if (r11 == null) goto L8;
            super.removeObserver(r11);
            observe(r10, r11);
            return;
        L8:
            return;
        }

        @Override // androidx.lifecycle.LiveData
        protected void onActive() {
            if (LoaderManagerImpl.DEBUG == false) goto L5;
            Log.v(LoaderManagerImpl.TAG, "  Starting: " + this);
        L5:
            this.mLoader.startLoading();
        }

        @Override // androidx.lifecycle.LiveData
        protected void onInactive() {
            if (LoaderManagerImpl.DEBUG == false) goto L5;
            Log.v(LoaderManagerImpl.TAG, "  Stopping: " + this);
        L5:
            this.mLoader.stopLoading();
        }

        @Override // androidx.loader.content.Loader.OnLoadCompleteListener
        public void onLoadComplete(@NonNull Loader<D> r10, @Nullable D r11) {
            if (LoaderManagerImpl.DEBUG == false) goto L6;
            Log.v(LoaderManagerImpl.TAG, "onLoadComplete: " + this);
        L6:
            if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
            setValue(r11);
            return;
        L9:
            if (LoaderManagerImpl.DEBUG == false) goto L11;
            Log.w(LoaderManagerImpl.TAG, "onLoadComplete was incorrectly called on a background thread");
        L11:
            postValue(r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void removeObserver(@NonNull Observer<? super D> r10) {
            super.removeObserver(r10);
            this.mLifecycleOwner = null;
            this.mObserver = null;
        }

        @NonNull
        @MainThread
        Loader<D> setCallback(@NonNull LifecycleOwner r10, @NonNull LoaderManager.LoaderCallbacks<D> r11) {
            LoaderObserver<D> r12 = new LoaderObserver(this.mLoader, r11);
            observe(r10, r12);
            LoaderObserver<D> r13 = this.mObserver;
            if (r13 == null) goto L5;
            removeObserver(r13);
        L5:
            this.mLifecycleOwner = r10;
            this.mObserver = r12;
            return this.mLoader;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(D r10) {
            super.setValue(r10);
            Loader<D> r11 = this.mPriorLoader;
            if (r11 == null) goto L6;
            r11.reset();
            this.mPriorLoader = null;
            return;
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder(64);
            r10.append("LoaderInfo{");
            r10.append(Integer.toHexString(System.identityHashCode(this)));
            r10.append(" #");
            r10.append(this.mId);
            r10.append(" : ");
            DebugUtils.buildShortClassTag(this.mLoader, r10);
            r10.append("}}");
            return r10.toString();
        }
    }

    static class LoaderObserver<D> implements Observer<D> {

        @NonNull
        private final LoaderManager.LoaderCallbacks<D> mCallback;
        private boolean mDeliveredData;

        @NonNull
        private final Loader<D> mLoader;

        LoaderObserver(@NonNull Loader<D> r10, @NonNull LoaderManager.LoaderCallbacks<D> r11) {
            this.mDeliveredData = false;
            this.mLoader = r10;
            this.mCallback = r11;
        }

        public void dump(String r10, PrintWriter r11) {
            r11.print(r10);
            r11.print("mDeliveredData=");
            r11.println(this.mDeliveredData);
        }

        boolean hasDeliveredData() {
            return this.mDeliveredData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable D r10) {
            if (LoaderManagerImpl.DEBUG == false) goto L5;
            Log.v(LoaderManagerImpl.TAG, "  onLoadFinished in " + this.mLoader + ": " + this.mLoader.dataToString(r10));
        L5:
            this.mCallback.onLoadFinished(this.mLoader, r10);
            this.mDeliveredData = true;
        }

        @MainThread
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

        @NonNull
        static LoaderViewModel getInstance(ViewModelStore r10) {
            return (LoaderViewModel) new ViewModelProvider(r10, FACTORY).get(LoaderViewModel.class);
        }

        public void dump(String r10, FileDescriptor r11, PrintWriter r12, String[] r13) {
            if (this.mLoaders.size() <= 0) goto L8;
            r12.print(r10);
            r12.println("Loaders:");
            String r14 = r10 + "    ";
            int r15 = 0;
        L6:
            if (r15 >= this.mLoaders.size()) goto L10;
            LoaderInfo r16 = this.mLoaders.valueAt(r15);
            r12.print(r10);
            r12.print("  #");
            r12.print(this.mLoaders.keyAt(r15));
            r12.print(": ");
            r12.println(r16.toString());
            r16.dump(r14, r11, r12, r13);
            r15 = r15 + 1;
            goto L6
        L10:
            return;
        }

        void finishCreatingLoader() {
            this.mCreatingLoader = false;
        }

        <D> LoaderInfo<D> getLoader(int r10) {
            return this.mLoaders.get(r10);
        }

        boolean hasRunningLoaders() {
            int r10 = this.mLoaders.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L9;
            if (this.mLoaders.valueAt(r11).isCallbackWaitingForData() == true) goto L6;
            r11 = r11 + 1;
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
            int r10 = this.mLoaders.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            this.mLoaders.valueAt(r11).markForRedelivery();
            r11 = r11 + 1;
            goto L3
        }

        @Override // androidx.lifecycle.ViewModel
        protected void onCleared() {
            super.onCleared();
            int r10 = this.mLoaders.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            this.mLoaders.valueAt(r11).destroy(true);
            r11 = r11 + 1;
            goto L3
        L5:
            this.mLoaders.clear();
        }

        void putLoader(int r10, @NonNull LoaderInfo r11) {
            this.mLoaders.put(r10, r11);
        }

        void removeLoader(int r10) {
            this.mLoaders.remove(r10);
        }

        void startCreatingLoader() {
            this.mCreatingLoader = true;
        }
    }

    static {
    }

    LoaderManagerImpl(@NonNull LifecycleOwner r10, @NonNull ViewModelStore r11) {
        this.mLifecycleOwner = r10;
        this.mLoaderViewModel = LoaderViewModel.getInstance(r11);
    }

    @NonNull
    @MainThread
    private <D> Loader<D> createAndInstallLoader(int r10, @Nullable Bundle r11, @NonNull LoaderManager.LoaderCallbacks<D> r12, @Nullable Loader<D> r13) {
        this.mLoaderViewModel.startCreatingLoader();     // Catch: Throwable -> L19
        Loader<D> r14 = r12.onCreateLoader(r10, r11);     // Catch: Throwable -> L19
        if (r14 == null) goto L18;
        if (r14.getClass().isMemberClass() == true) goto L7;
    L11:
        LoaderInfo r15 = new LoaderInfo(r10, r11, r14, r13);     // Catch: Throwable -> L19
        if (DEBUG == false) goto L14;
        Log.v(TAG, "  Created new loader " + r15);     // Catch: Throwable -> L19
    L14:
        this.mLoaderViewModel.putLoader(r10, r15);     // Catch: Throwable -> L19
        this.mLoaderViewModel.finishCreatingLoader();
        return r15.setCallback(this.mLifecycleOwner, r12);
    L7:
        if (Modifier.isStatic(r14.getClass().getModifiers()) == true) goto L11;
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + r14);     // Catch: Throwable -> L19
    L18:
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.mLoaderViewModel.finishCreatingLoader();
        throw th;
    }

    @Override // androidx.loader.app.LoaderManager
    @MainThread
    public void destroyLoader(int r10) {
        if (this.mLoaderViewModel.isCreatingLoader() == true) goto L16;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L14;
        if (DEBUG == false) goto L9;
        Log.v(TAG, "destroyLoader in " + this + " of " + r10);
    L9:
        LoaderInfo r11 = this.mLoaderViewModel.getLoader(r10);
        if (r11 == null) goto L17;
        r11.destroy(true);
        this.mLoaderViewModel.removeLoader(r10);
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
    public void dump(String r10, FileDescriptor r11, PrintWriter r12, String[] r13) {
        this.mLoaderViewModel.dump(r10, r11, r12, r13);
    }

    @Override // androidx.loader.app.LoaderManager
    @Nullable
    public <D> Loader<D> getLoader(int r10) {
        if (this.mLoaderViewModel.isCreatingLoader() == true) goto L10;
        LoaderInfo<D> r11 = this.mLoaderViewModel.getLoader(r10);
        if (r11 != null) goto L11;
        return null;
    L11:
        return r11.getLoader();
    L10:
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.LoaderManager
    public boolean hasRunningLoaders() {
        return this.mLoaderViewModel.hasRunningLoaders();
    }

    @Override // androidx.loader.app.LoaderManager
    @NonNull
    @MainThread
    public <D> Loader<D> initLoader(int r10, @Nullable Bundle r11, @NonNull LoaderManager.LoaderCallbacks<D> r12) {
        if (this.mLoaderViewModel.isCreatingLoader() == true) goto L20;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L18;
        LoaderInfo<D> r13 = this.mLoaderViewModel.getLoader(r10);
        if (DEBUG == false) goto L9;
        Log.v(TAG, "initLoader in " + this + ": args=" + r11);
    L9:
        if (r13 != null) goto L13;
        return createAndInstallLoader(r10, r11, r12, null);
    L13:
        if (DEBUG == false) goto L16;
        Log.v(TAG, "  Re-using existing loader " + r13);
    L16:
        return r13.setCallback(this.mLifecycleOwner, r12);
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
    @NonNull
    @MainThread
    public <D> Loader<D> restartLoader(int r10, @Nullable Bundle r11, @NonNull LoaderManager.LoaderCallbacks<D> r12) {
        if (this.mLoaderViewModel.isCreatingLoader() == true) goto L17;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L15;
        if (DEBUG == false) goto L9;
        Log.v(TAG, "restartLoader in " + this + ": args=" + r11);
    L9:
        LoaderInfo<D> r13 = this.mLoaderViewModel.getLoader(r10);
        Loader<D> r14 = null;
        if (r13 == null) goto L13;
        r14 = r13.destroy(false);
    L13:
        return createAndInstallLoader(r10, r11, r12, r14);
    L15:
        throw new IllegalStateException("restartLoader must be called on the main thread");
    L17:
        throw new IllegalStateException("Called while creating a loader");
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder(128);
        r10.append("LoaderManager{");
        r10.append(Integer.toHexString(System.identityHashCode(this)));
        r10.append(" in ");
        DebugUtils.buildShortClassTag(this.mLifecycleOwner, r10);
        r10.append("}}");
        return r10.toString();
    }
}

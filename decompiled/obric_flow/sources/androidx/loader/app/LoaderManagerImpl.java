package androidx.loader.app;

import ai.j0;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.constraintlayout.motion.widget.a;
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

        public LoaderInfo(int r5, @Nullable Bundle r10, @NonNull Loader<D> r11, @Nullable Loader<D> r12) {
            this.mId = r5;
            this.mArgs = r10;
            this.mLoader = r11;
            this.mPriorLoader = r12;
            r11.registerListener(r5, this);
        }

        @MainThread
        public Loader<D> destroy(boolean r5) {
            if (LoaderManagerImpl.DEBUG == false) goto L5;
            Log.v(LoaderManagerImpl.TAG, "  Destroying: " + this);
        L5:
            this.mLoader.cancelLoad();
            this.mLoader.abandon();
            LoaderObserver<D> r10 = this.mObserver;
            if (r10 == null) goto L10;
            removeObserver(r10);
            if (r5 == false) goto L10;
            r10.reset();
        L10:
            this.mLoader.unregisterListener(this);
            if (r10 != null) goto L13;
        L14:
            if (r5 == false) goto L18;
        L15:
            this.mLoader.reset();
            return this.mPriorLoader;
        L18:
            return this.mLoader;
        L13:
            if (r10.hasDeliveredData() == false) goto L15;
            goto L14
        }

        public void dump(String r5, FileDescriptor r10, PrintWriter r11, String[] r12) {
            r11.print(r5);
            r11.print("mId=");
            r11.print(this.mId);
            r11.print(" mArgs=");
            r11.println(this.mArgs);
            r11.print(r5);
            r11.print("mLoader=");
            r11.println(this.mLoader);
            this.mLoader.dump(j0.j(r5, "  "), r10, r11, r12);
            if (this.mObserver == null) goto L5;
            r11.print(r5);
            r11.print("mCallbacks=");
            r11.println(this.mObserver);
            this.mObserver.dump(j0.j(r5, "  "), r11);
        L5:
            r11.print(r5);
            r11.print("mData=");
            r11.println(getLoader().dataToString(getValue()));
            r11.print(r5);
            r11.print("mStarted=");
            r11.println(hasActiveObservers());
        }

        @NonNull
        public Loader<D> getLoader() {
            return this.mLoader;
        }

        public boolean isCallbackWaitingForData() {
            if (hasActiveObservers() == true) goto L5;
            return false;
        L5:
            LoaderObserver<D> r5 = this.mObserver;
            if (r5 != null) goto L8;
            return false;
        L8:
            if (r5.hasDeliveredData() == true) goto L12;
            return true;
        L12:
            return false;
        }

        public void markForRedelivery() {
            LifecycleOwner r5 = this.mLifecycleOwner;
            LoaderObserver<D> r10 = this.mObserver;
            if (r5 == null) goto L7;
            if (r10 == null) goto L8;
            super.removeObserver(r10);
            observe(r5, r10);
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
        public void onLoadComplete(@NonNull Loader<D> r5, @Nullable D r10) {
            if (LoaderManagerImpl.DEBUG == false) goto L6;
            Log.v(LoaderManagerImpl.TAG, "onLoadComplete: " + this);
        L6:
            if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
            setValue(r10);
            return;
        L9:
            if (LoaderManagerImpl.DEBUG == false) goto L11;
            Log.w(LoaderManagerImpl.TAG, "onLoadComplete was incorrectly called on a background thread");
        L11:
            postValue(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void removeObserver(@NonNull Observer<? super D> r5) {
            super.removeObserver(r5);
            this.mLifecycleOwner = null;
            this.mObserver = null;
        }

        @NonNull
        @MainThread
        public Loader<D> setCallback(@NonNull LifecycleOwner r5, @NonNull LoaderManager.LoaderCallbacks<D> r10) {
            LoaderObserver<D> r11 = new LoaderObserver(this.mLoader, r10);
            observe(r5, r11);
            LoaderObserver<D> r12 = this.mObserver;
            if (r12 == null) goto L5;
            removeObserver(r12);
        L5:
            this.mLifecycleOwner = r5;
            this.mObserver = r11;
            return this.mLoader;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(D r5) {
            super.setValue(r5);
            Loader<D> r10 = this.mPriorLoader;
            if (r10 == null) goto L6;
            r10.reset();
            this.mPriorLoader = null;
            return;
        }

        public String toString() {
            StringBuilder r5 = a.x(64, "LoaderInfo{");
            r5.append(Integer.toHexString(System.identityHashCode(this)));
            r5.append(" #");
            r5.append(this.mId);
            r5.append(" : ");
            DebugUtils.buildShortClassTag(this.mLoader, r5);
            r5.append("}}");
            return r5.toString();
        }
    }

    public static class LoaderObserver<D> implements Observer<D> {

        @NonNull
        private final LoaderManager.LoaderCallbacks<D> mCallback;
        private boolean mDeliveredData;

        @NonNull
        private final Loader<D> mLoader;

        public LoaderObserver(@NonNull Loader<D> r5, @NonNull LoaderManager.LoaderCallbacks<D> r10) {
            this.mDeliveredData = false;
            this.mLoader = r5;
            this.mCallback = r10;
        }

        public void dump(String r5, PrintWriter r10) {
            r10.print(r5);
            r10.print("mDeliveredData=");
            r10.println(this.mDeliveredData);
        }

        public boolean hasDeliveredData() {
            return this.mDeliveredData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable D r5) {
            if (LoaderManagerImpl.DEBUG == false) goto L5;
            Log.v(LoaderManagerImpl.TAG, "  onLoadFinished in " + this.mLoader + ": " + this.mLoader.dataToString(r5));
        L5:
            this.mCallback.onLoadFinished(this.mLoader, r5);
            this.mDeliveredData = true;
        }

        @MainThread
        public void reset() {
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

    public static class LoaderViewModel extends ViewModel {
        private static final ViewModelProvider.Factory FACTORY = null;
        private boolean mCreatingLoader;
        private SparseArrayCompat<LoaderInfo> mLoaders;

        static {
            FACTORY = new AnonymousClass1();
        }

        public LoaderViewModel() {
            this.mLoaders = new SparseArrayCompat();
            this.mCreatingLoader = false;
        }

        @NonNull
        public static LoaderViewModel getInstance(ViewModelStore r5) {
            return (LoaderViewModel) new ViewModelProvider(r5, FACTORY).get(LoaderViewModel.class);
        }

        public void dump(String r5, FileDescriptor r10, PrintWriter r11, String[] r12) {
            if (this.mLoaders.size() <= 0) goto L8;
            r11.print(r5);
            r11.println("Loaders:");
            String r13 = r5 + "    ";
            int r14 = 0;
        L6:
            if (r14 >= this.mLoaders.size()) goto L10;
            LoaderInfo r15 = this.mLoaders.valueAt(r14);
            r11.print(r5);
            r11.print("  #");
            r11.print(this.mLoaders.keyAt(r14));
            r11.print(": ");
            r11.println(r15.toString());
            r15.dump(r13, r10, r11, r12);
            r14 = r14 + 1;
            goto L6
        L10:
            return;
        }

        public void finishCreatingLoader() {
            this.mCreatingLoader = false;
        }

        public <D> LoaderInfo<D> getLoader(int r5) {
            return this.mLoaders.get(r5);
        }

        public boolean hasRunningLoaders() {
            int r5 = this.mLoaders.size();
            int r10 = 0;
        L3:
            if (r10 >= r5) goto L9;
            if (this.mLoaders.valueAt(r10).isCallbackWaitingForData() == true) goto L6;
            r10 = r10 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        public boolean isCreatingLoader() {
            return this.mCreatingLoader;
        }

        public void markForRedelivery() {
            int r5 = this.mLoaders.size();
            int r10 = 0;
        L3:
            if (r10 >= r5) goto L5;
            this.mLoaders.valueAt(r10).markForRedelivery();
            r10 = r10 + 1;
            goto L3
        }

        @Override // androidx.lifecycle.ViewModel
        public void onCleared() {
            super.onCleared();
            int r5 = this.mLoaders.size();
            int r10 = 0;
        L3:
            if (r10 >= r5) goto L5;
            this.mLoaders.valueAt(r10).destroy(true);
            r10 = r10 + 1;
            goto L3
        L5:
            this.mLoaders.clear();
        }

        public void putLoader(int r5, @NonNull LoaderInfo r10) {
            this.mLoaders.put(r5, r10);
        }

        public void removeLoader(int r5) {
            this.mLoaders.remove(r5);
        }

        public void startCreatingLoader() {
            this.mCreatingLoader = true;
        }
    }

    public LoaderManagerImpl(@NonNull LifecycleOwner r5, @NonNull ViewModelStore r10) {
        this.mLifecycleOwner = r5;
        this.mLoaderViewModel = LoaderViewModel.getInstance(r10);
    }

    @NonNull
    @MainThread
    private <D> Loader<D> createAndInstallLoader(int r5, @Nullable Bundle r10, @NonNull LoaderManager.LoaderCallbacks<D> r11, @Nullable Loader<D> r12) {
        this.mLoaderViewModel.startCreatingLoader();     // Catch: Throwable -> L12
        Loader<D> r13 = r11.onCreateLoader(r5, r10);     // Catch: Throwable -> L12
        if (r13 == null) goto L21;
        if (r13.getClass().isMemberClass() == true) goto L8;
    L14:
        LoaderInfo r14 = new LoaderInfo(r5, r10, r13, r12);     // Catch: Throwable -> L12
        if (DEBUG == false) goto L17;
        Log.v(TAG, "  Created new loader " + r14);     // Catch: Throwable -> L12
    L17:
        this.mLoaderViewModel.putLoader(r5, r14);     // Catch: Throwable -> L12
        this.mLoaderViewModel.finishCreatingLoader();
        return r14.setCallback(this.mLifecycleOwner, r11);
    L8:
        if (Modifier.isStatic(r13.getClass().getModifiers()) == true) goto L14;
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + r13);     // Catch: Throwable -> L12
    L21:
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.mLoaderViewModel.finishCreatingLoader();
        throw th;
    }

    @Override // androidx.loader.app.LoaderManager
    @MainThread
    public void destroyLoader(int r5) {
        if (this.mLoaderViewModel.isCreatingLoader() == true) goto L16;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L14;
        if (DEBUG == false) goto L9;
        Log.v(TAG, "destroyLoader in " + this + " of " + r5);
    L9:
        LoaderInfo r10 = this.mLoaderViewModel.getLoader(r5);
        if (r10 == null) goto L17;
        r10.destroy(true);
        this.mLoaderViewModel.removeLoader(r5);
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
    public void dump(String r5, FileDescriptor r10, PrintWriter r11, String[] r12) {
        this.mLoaderViewModel.dump(r5, r10, r11, r12);
    }

    @Override // androidx.loader.app.LoaderManager
    @Nullable
    public <D> Loader<D> getLoader(int r5) {
        if (this.mLoaderViewModel.isCreatingLoader() == true) goto L10;
        LoaderInfo<D> r10 = this.mLoaderViewModel.getLoader(r5);
        if (r10 != null) goto L11;
        return null;
    L11:
        return r10.getLoader();
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
    public <D> Loader<D> initLoader(int r5, @Nullable Bundle r10, @NonNull LoaderManager.LoaderCallbacks<D> r11) {
        if (this.mLoaderViewModel.isCreatingLoader() == true) goto L20;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L18;
        LoaderInfo<D> r12 = this.mLoaderViewModel.getLoader(r5);
        if (DEBUG == false) goto L9;
        Log.v(TAG, "initLoader in " + this + ": args=" + r10);
    L9:
        if (r12 != null) goto L13;
        return createAndInstallLoader(r5, r10, r11, null);
    L13:
        if (DEBUG == false) goto L16;
        Log.v(TAG, "  Re-using existing loader " + r12);
    L16:
        return r12.setCallback(this.mLifecycleOwner, r11);
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
    public <D> Loader<D> restartLoader(int r5, @Nullable Bundle r10, @NonNull LoaderManager.LoaderCallbacks<D> r11) {
        if (this.mLoaderViewModel.isCreatingLoader() == true) goto L18;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L16;
        if (DEBUG == false) goto L9;
        Log.v(TAG, "restartLoader in " + this + ": args=" + r10);
    L9:
        LoaderInfo<D> r12 = this.mLoaderViewModel.getLoader(r5);
        if (r12 == null) goto L12;
        Loader<D> r13 = r12.destroy(false);
    L14:
        return createAndInstallLoader(r5, r10, r11, r13);
    L12:
        r13 = null;
        goto L14
    L16:
        throw new IllegalStateException("restartLoader must be called on the main thread");
    L18:
        throw new IllegalStateException("Called while creating a loader");
    }

    public String toString() {
        StringBuilder r5 = a.x(128, "LoaderManager{");
        r5.append(Integer.toHexString(System.identityHashCode(this)));
        r5.append(" in ");
        DebugUtils.buildShortClassTag(this.mLifecycleOwner, r5);
        r5.append("}}");
        return r5.toString();
    }
}

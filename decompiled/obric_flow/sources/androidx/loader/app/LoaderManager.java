package androidx.loader.app;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class LoaderManager {

    public interface LoaderCallbacks<D> {
        @NonNull
        @MainThread
        Loader<D> onCreateLoader(int r5, @Nullable Bundle r10);

        @MainThread
        void onLoadFinished(@NonNull Loader<D> r5, D r10);

        @MainThread
        void onLoaderReset(@NonNull Loader<D> r5);
    }

    public LoaderManager() {
    }

    public static void enableDebugLogging(boolean r5) {
        LoaderManagerImpl.DEBUG = r5;
    }

    @NonNull
    public static <T extends LifecycleOwner & ViewModelStoreOwner> LoaderManager getInstance(@NonNull T r5) {
        return new LoaderManagerImpl(r5, r5.getViewModelStore());
    }

    @MainThread
    public abstract void destroyLoader(int r5);

    @Deprecated
    public abstract void dump(String r5, FileDescriptor r10, PrintWriter r11, String[] r12);

    @Nullable
    public abstract <D> Loader<D> getLoader(int r5);

    public boolean hasRunningLoaders() {
        return false;
    }

    @NonNull
    @MainThread
    public abstract <D> Loader<D> initLoader(int r5, @Nullable Bundle r10, @NonNull LoaderCallbacks<D> r11);

    public abstract void markForRedelivery();

    @NonNull
    @MainThread
    public abstract <D> Loader<D> restartLoader(int r5, @Nullable Bundle r10, @NonNull LoaderCallbacks<D> r11);
}

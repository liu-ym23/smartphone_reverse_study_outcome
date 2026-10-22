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
        Loader<D> onCreateLoader(int r10, @Nullable Bundle r11);

        @MainThread
        void onLoadFinished(@NonNull Loader<D> r10, D r11);

        @MainThread
        void onLoaderReset(@NonNull Loader<D> r10);
    }

    public LoaderManager() {
    }

    public static void enableDebugLogging(boolean r10) {
        LoaderManagerImpl.DEBUG = r10;
    }

    @NonNull
    public static <T extends LifecycleOwner & ViewModelStoreOwner> LoaderManager getInstance(@NonNull T r10) {
        return new LoaderManagerImpl(r10, r10.getViewModelStore());
    }

    @MainThread
    public abstract void destroyLoader(int r10);

    @Deprecated
    public abstract void dump(String r10, FileDescriptor r11, PrintWriter r12, String[] r13);

    @Nullable
    public abstract <D> Loader<D> getLoader(int r10);

    public boolean hasRunningLoaders() {
        return false;
    }

    @NonNull
    @MainThread
    public abstract <D> Loader<D> initLoader(int r10, @Nullable Bundle r11, @NonNull LoaderCallbacks<D> r12);

    public abstract void markForRedelivery();

    @NonNull
    @MainThread
    public abstract <D> Loader<D> restartLoader(int r10, @Nullable Bundle r11, @NonNull LoaderCallbacks<D> r12);
}

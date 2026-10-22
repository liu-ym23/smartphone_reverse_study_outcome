package androidx.loader.app;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.content.Loader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class LoaderManager {

    public interface LoaderCallbacks<D> {
        Loader<D> onCreateLoader(int r1, Bundle r2);

        void onLoadFinished(Loader<D> r1, D r2);

        void onLoaderReset(Loader<D> r1);
    }

    public LoaderManager() {
    }

    public static void enableDebugLogging(boolean r0) {
        LoaderManagerImpl.DEBUG = r0;
    }

    public static <T extends LifecycleOwner & ViewModelStoreOwner> LoaderManager getInstance(T r3) {
        LifecycleOwner r4 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
        return new LoaderManagerImpl(r4, ((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).getViewModelStore());
    }

    public abstract void destroyLoader(int r1);

    @Deprecated
    public abstract void dump(String r1, FileDescriptor r2, PrintWriter r3, String[] r4);

    public abstract <D> Loader<D> getLoader(int r1);

    public boolean hasRunningLoaders() {
        return false;
    }

    public abstract <D> Loader<D> initLoader(int r1, Bundle r2, LoaderCallbacks<D> r3);

    public abstract void markForRedelivery();

    public abstract <D> Loader<D> restartLoader(int r1, Bundle r2, LoaderCallbacks<D> r3);
}

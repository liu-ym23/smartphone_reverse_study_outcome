package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes.dex */
public class ViewModelProviders {

    @Deprecated
    public static class DefaultFactory extends ViewModelProvider.AndroidViewModelFactory {
        @Deprecated
        public DefaultFactory(@NonNull Application r5) {
            super(r5);
        }
    }

    @Deprecated
    public ViewModelProviders() {
    }

    private static Activity checkActivity(Fragment r5) {
        FragmentActivity r10 = r5.getActivity();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
    }

    private static Application checkApplication(Activity r5) {
        Application r10 = r5.getApplication();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    @NonNull
    @MainThread
    public static ViewModelProvider of(@NonNull Fragment r5) {
        return of(r5, null);
    }

    @NonNull
    @MainThread
    public static ViewModelProvider of(@NonNull FragmentActivity r5) {
        return of(r5, null);
    }

    @NonNull
    @MainThread
    public static ViewModelProvider of(@NonNull Fragment r5, @Nullable ViewModelProvider.Factory r10) {
        Application r11 = checkApplication(checkActivity(r5));
        if (r10 != null) goto L6;
        r10 = ViewModelProvider.AndroidViewModelFactory.getInstance(r11);
    L6:
        return new ViewModelProvider(r5.getViewModelStore(), r10);
    }

    @NonNull
    @MainThread
    public static ViewModelProvider of(@NonNull FragmentActivity r5, @Nullable ViewModelProvider.Factory r10) {
        Application r11 = checkApplication(r5);
        if (r10 != null) goto L6;
        r10 = ViewModelProvider.AndroidViewModelFactory.getInstance(r11);
    L6:
        return new ViewModelProvider(r5.getViewModelStore(), r10);
    }
}

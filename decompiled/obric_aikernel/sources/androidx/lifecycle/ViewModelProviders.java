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
        public DefaultFactory(@NonNull Application r10) {
            super(r10);
        }
    }

    @Deprecated
    public ViewModelProviders() {
    }

    private static Activity checkActivity(Fragment r10) {
        FragmentActivity r11 = r10.getActivity();
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
    }

    private static Application checkApplication(Activity r10) {
        Application r11 = r10.getApplication();
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    @NonNull
    @MainThread
    public static ViewModelProvider of(@NonNull Fragment r10) {
        return of(r10, null);
    }

    @NonNull
    @MainThread
    public static ViewModelProvider of(@NonNull Fragment r10, @Nullable ViewModelProvider.Factory r11) {
        Application r12 = checkApplication(checkActivity(r10));
        if (r11 != null) goto L6;
        r11 = ViewModelProvider.AndroidViewModelFactory.getInstance(r12);
    L6:
        return new ViewModelProvider(r10.getViewModelStore(), r11);
    }

    @NonNull
    @MainThread
    public static ViewModelProvider of(@NonNull FragmentActivity r10) {
        return of(r10, null);
    }

    @NonNull
    @MainThread
    public static ViewModelProvider of(@NonNull FragmentActivity r10, @Nullable ViewModelProvider.Factory r11) {
        Application r12 = checkApplication(r10);
        if (r11 != null) goto L6;
        r11 = ViewModelProvider.AndroidViewModelFactory.getInstance(r12);
    L6:
        return new ViewModelProvider(r10.getViewModelStore(), r11);
    }
}

package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 28)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class CoreComponentFactory extends android.app.AppComponentFactory {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface CompatWrapped {
        Object getWrapper();
    }

    public CoreComponentFactory() {
    }

    static <T> T checkCompatWrapper(T r10) {
        if ((r10 instanceof CompatWrapped) == false) goto L7;
        T r11 = (T) ((CompatWrapped) r10).getWrapper();
        if (r11 == null) goto L7;
        return r11;
    L7:
        return r10;
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public Activity instantiateActivity(@NonNull ClassLoader r10, @NonNull String r11, @Nullable Intent r12) {
        return (Activity) checkCompatWrapper(super.instantiateActivity(r10, r11, r12));
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public Application instantiateApplication(@NonNull ClassLoader r10, @NonNull String r11) {
        return (Application) checkCompatWrapper(super.instantiateApplication(r10, r11));
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public ContentProvider instantiateProvider(@NonNull ClassLoader r10, @NonNull String r11) {
        return (ContentProvider) checkCompatWrapper(super.instantiateProvider(r10, r11));
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public BroadcastReceiver instantiateReceiver(@NonNull ClassLoader r10, @NonNull String r11, @Nullable Intent r12) {
        return (BroadcastReceiver) checkCompatWrapper(super.instantiateReceiver(r10, r11, r12));
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public Service instantiateService(@NonNull ClassLoader r10, @NonNull String r11, @Nullable Intent r12) {
        return (Service) checkCompatWrapper(super.instantiateService(r10, r11, r12));
    }
}

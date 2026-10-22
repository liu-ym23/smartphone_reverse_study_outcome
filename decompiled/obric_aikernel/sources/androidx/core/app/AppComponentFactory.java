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

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
public class AppComponentFactory extends android.app.AppComponentFactory {
    public AppComponentFactory() {
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public final Activity instantiateActivity(@NonNull ClassLoader r10, @NonNull String r11, @Nullable Intent r12) {
        return (Activity) CoreComponentFactory.checkCompatWrapper(instantiateActivityCompat(r10, r11, r12));
    }

    @NonNull
    public Activity instantiateActivityCompat(@NonNull ClassLoader r10, @NonNull String r11, @Nullable Intent r12) {
        return (Activity) Class.forName(r11, false, r10).asSubclass(Activity.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public final Application instantiateApplication(@NonNull ClassLoader r10, @NonNull String r11) {
        return (Application) CoreComponentFactory.checkCompatWrapper(instantiateApplicationCompat(r10, r11));
    }

    @NonNull
    public Application instantiateApplicationCompat(@NonNull ClassLoader r10, @NonNull String r11) {
        return (Application) Class.forName(r11, false, r10).asSubclass(Application.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public final ContentProvider instantiateProvider(@NonNull ClassLoader r10, @NonNull String r11) {
        return (ContentProvider) CoreComponentFactory.checkCompatWrapper(instantiateProviderCompat(r10, r11));
    }

    @NonNull
    public ContentProvider instantiateProviderCompat(@NonNull ClassLoader r10, @NonNull String r11) {
        return (ContentProvider) Class.forName(r11, false, r10).asSubclass(ContentProvider.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public final BroadcastReceiver instantiateReceiver(@NonNull ClassLoader r10, @NonNull String r11, @Nullable Intent r12) {
        return (BroadcastReceiver) CoreComponentFactory.checkCompatWrapper(instantiateReceiverCompat(r10, r11, r12));
    }

    @NonNull
    public BroadcastReceiver instantiateReceiverCompat(@NonNull ClassLoader r10, @NonNull String r11, @Nullable Intent r12) {
        return (BroadcastReceiver) Class.forName(r11, false, r10).asSubclass(BroadcastReceiver.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public final Service instantiateService(@NonNull ClassLoader r10, @NonNull String r11, @Nullable Intent r12) {
        return (Service) CoreComponentFactory.checkCompatWrapper(instantiateServiceCompat(r10, r11, r12));
    }

    @NonNull
    public Service instantiateServiceCompat(@NonNull ClassLoader r10, @NonNull String r11, @Nullable Intent r12) {
        return (Service) Class.forName(r11, false, r10).asSubclass(Service.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }
}

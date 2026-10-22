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
    public final Activity instantiateActivity(@NonNull ClassLoader r5, @NonNull String r10, @Nullable Intent r11) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Activity) CoreComponentFactory.checkCompatWrapper(instantiateActivityCompat(r5, r10, r11));
    }

    @NonNull
    public Activity instantiateActivityCompat(@NonNull ClassLoader r5, @NonNull String r10, @Nullable Intent r11) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Activity) Class.forName(r10, false, r5).asSubclass(Activity.class).getDeclaredConstructor(null).newInstance(null);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public final Application instantiateApplication(@NonNull ClassLoader r5, @NonNull String r10) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Application) CoreComponentFactory.checkCompatWrapper(instantiateApplicationCompat(r5, r10));
    }

    @NonNull
    public Application instantiateApplicationCompat(@NonNull ClassLoader r5, @NonNull String r10) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Application) Class.forName(r10, false, r5).asSubclass(Application.class).getDeclaredConstructor(null).newInstance(null);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public final ContentProvider instantiateProvider(@NonNull ClassLoader r5, @NonNull String r10) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (ContentProvider) CoreComponentFactory.checkCompatWrapper(instantiateProviderCompat(r5, r10));
    }

    @NonNull
    public ContentProvider instantiateProviderCompat(@NonNull ClassLoader r5, @NonNull String r10) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (ContentProvider) Class.forName(r10, false, r5).asSubclass(ContentProvider.class).getDeclaredConstructor(null).newInstance(null);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public final BroadcastReceiver instantiateReceiver(@NonNull ClassLoader r5, @NonNull String r10, @Nullable Intent r11) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (BroadcastReceiver) CoreComponentFactory.checkCompatWrapper(instantiateReceiverCompat(r5, r10, r11));
    }

    @NonNull
    public BroadcastReceiver instantiateReceiverCompat(@NonNull ClassLoader r5, @NonNull String r10, @Nullable Intent r11) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (BroadcastReceiver) Class.forName(r10, false, r5).asSubclass(BroadcastReceiver.class).getDeclaredConstructor(null).newInstance(null);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public final Service instantiateService(@NonNull ClassLoader r5, @NonNull String r10, @Nullable Intent r11) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Service) CoreComponentFactory.checkCompatWrapper(instantiateServiceCompat(r5, r10, r11));
    }

    @NonNull
    public Service instantiateServiceCompat(@NonNull ClassLoader r5, @NonNull String r10, @Nullable Intent r11) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Service) Class.forName(r10, false, r5).asSubclass(Service.class).getDeclaredConstructor(null).newInstance(null);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }
}

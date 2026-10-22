package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class CoreComponentFactory extends AppComponentFactory {

    public interface a {
        Object a();
    }

    public CoreComponentFactory() {
    }

    public static <T> T a(T r8) {
        if ((r8 instanceof a) == false) goto L7;
        T r10 = (T) ((a) r8).a();
        if (r10 == null) goto L7;
        return r10;
    L7:
        return r8;
    }

    @Override // android.app.AppComponentFactory
    public final Activity instantiateActivity(ClassLoader r8, String r10, Intent r11) {
        return (Activity) a(super.instantiateActivity(r8, r10, r11));
    }

    @Override // android.app.AppComponentFactory
    public final Application instantiateApplication(ClassLoader r8, String r10) {
        return (Application) a(super.instantiateApplication(r8, r10));
    }

    @Override // android.app.AppComponentFactory
    public final ContentProvider instantiateProvider(ClassLoader r8, String r10) {
        return (ContentProvider) a(super.instantiateProvider(r8, r10));
    }

    @Override // android.app.AppComponentFactory
    public final BroadcastReceiver instantiateReceiver(ClassLoader r8, String r10, Intent r11) {
        return (BroadcastReceiver) a(super.instantiateReceiver(r8, r10, r11));
    }

    @Override // android.app.AppComponentFactory
    public final Service instantiateService(ClassLoader r8, String r10, Intent r11) {
        return (Service) a(super.instantiateService(r8, r10, r11));
    }
}

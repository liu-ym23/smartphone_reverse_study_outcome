package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AppComponentFactory extends android.app.AppComponentFactory {
    public AppComponentFactory() {
    }

    @Override // android.app.AppComponentFactory
    public final Activity instantiateActivity(ClassLoader r1, String r2, Intent r3) {
        return (Activity) ZeusTransformUtils.preCheckCast(CoreComponentFactory.checkCompatWrapper((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(instantiateActivityCompat(r1, r2, r3), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")), Activity.class, "com.obric.memorydata.plugin");
    }

    public Activity instantiateActivityCompat(ClassLoader r1, String r2, Intent r3) {
        return (Activity) ZeusTransformUtils.preCheckCast(Class.forName(r2, false, r1).asSubclass(Activity.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), Activity.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    public final Application instantiateApplication(ClassLoader r1, String r2) {
        return (Application) ZeusTransformUtils.preCheckCast(CoreComponentFactory.checkCompatWrapper((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(instantiateApplicationCompat(r1, r2), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")), Application.class, "com.obric.memorydata.plugin");
    }

    public Application instantiateApplicationCompat(ClassLoader r1, String r2) {
        return (Application) ZeusTransformUtils.preCheckCast(Class.forName(r2, false, r1).asSubclass(Application.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), Application.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    public final PluginContentProvider instantiateProvider(ClassLoader r1, String r2) {
        return (PluginContentProvider) ZeusTransformUtils.preCheckCast(CoreComponentFactory.checkCompatWrapper(instantiateProviderCompat(r1, r2)), PluginContentProvider.class, "com.obric.memorydata.plugin");
    }

    public PluginContentProvider instantiateProviderCompat(ClassLoader r1, String r2) {
        return (PluginContentProvider) ZeusTransformUtils.preCheckCast(Class.forName(r2, false, r1).asSubclass(ContentProvider.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), PluginContentProvider.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    public final PluginBroadcastReceiver instantiateReceiver(ClassLoader r1, String r2, Intent r3) {
        return (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(CoreComponentFactory.checkCompatWrapper(instantiateReceiverCompat(r1, r2, r3)), PluginBroadcastReceiver.class, "com.obric.memorydata.plugin");
    }

    public PluginBroadcastReceiver instantiateReceiverCompat(ClassLoader r1, String r2, Intent r3) {
        return (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(Class.forName(r2, false, r1).asSubclass(BroadcastReceiver.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), PluginBroadcastReceiver.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    public final Service instantiateService(ClassLoader r1, String r2, Intent r3) {
        return (Service) ZeusTransformUtils.preCheckCast(CoreComponentFactory.checkCompatWrapper((Service) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(instantiateServiceCompat(r1, r2, r3), "com.obric.memorydata.plugin"), Service.class, "com.obric.memorydata.plugin")), Service.class, "com.obric.memorydata.plugin");
    }

    public Service instantiateServiceCompat(ClassLoader r1, String r2, Intent r3) {
        return (Service) ZeusTransformUtils.preCheckCast(Class.forName(r2, false, r1).asSubclass(Service.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), Service.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }
}

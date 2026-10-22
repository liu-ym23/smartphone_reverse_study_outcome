package com.lynx.tasm.library;

import android.app.Application;
import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.service.IServiceProvider;
import el9.a;
import i8a.n;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxLibraryRegistry {
    private static final String TAG = "LynxLibraryRegistry";
    private static final Set<String> sRegisteredGlobalProviders = null;
    private final LynxViewBuilder mBuilder;
    private final Context mContext;

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    static {
        sRegisteredGlobalProviders = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public Context getContextOrThrow() {
        Context r0 = this.mContext;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Context is only available in setupGlobal().");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_tasm_library_LynxLibraryRegistry_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    private static IServiceProvider createService(Class<? extends IServiceProvider> r6) {
        Object r3 = r6.getField("INSTANCE").get(null);     // Catch: Throwable -> L7 NoSuchFieldException -> L15
        if ((r3 instanceof IServiceProvider) == false) goto L16;
        return (IServiceProvider) r3;
    L7:
        th = move-exception;
        LLog.w(TAG, "Failed to read service singleton " + r6.getName() + ": " + th);
    L16:
        Constructor<? extends IServiceProvider> r4 = r6.getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L12
        r4.setAccessible(true);     // Catch: Throwable -> L12
        return r4.newInstance(new Object[0]);
    L12:
        th = move-exception;
        LLog.e(TAG, "Failed to create service " + r6.getName() + ": " + th);
        return null;
    }

    public void addBehaviors(List<com.lynx.tasm.behavior.a> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == true) goto L13;
        LynxViewBuilder r0 = this.mBuilder;
        if (r0 == null) goto L9;
        r0.addBehaviors(r2);
        return;
    L9:
        LynxEnv.inst().addBehaviors(r2);
        return;
    }

    public void registerService(Class<? extends IServiceProvider> r2) {
        IServiceProvider r3 = createService(r2);
        if (r3 == null) goto L6;
        n.c().d(r3);
        return;
    }

    public void registerService(IServiceProvider r2) {
        n.c().d(r2);
    }

    private LynxLibraryRegistry(Context r1, LynxViewBuilder r2) {
        this.mContext = r1;
        this.mBuilder = r2;
    }

    private static void setup(LynxLibraryRegistry r4, String[] r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        String r2 = r5[r1];
        if (r2 == null) goto L10;
        if (r2.length() == 0) goto L10;
        setupProvider(r4, r2);
    L10:
        r1 = r1 + 1;
        goto L3
    }

    private static void setupGlobal(LynxLibraryRegistry r5, String[] r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L16;
        String r2 = r6[r1];
        if (r2 == null) goto L15;
        if (r2.length() == 0) goto L15;
        Set<String> r3 = sRegisteredGlobalProviders;
        if (r3.add(r2) == false) goto L15;
        if (setupProvider(r5, r2) == true) goto L15;
        r3.remove(r2);
    L15:
        r1 = r1 + 1;
        goto L3
    }

    private static boolean setupProvider(LynxLibraryRegistry r5, String r6) {
        Constructor r2 = INVOKESTATIC_com_lynx_tasm_library_LynxLibraryRegistry_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r6).getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L9
        r2.setAccessible(true);     // Catch: Throwable -> L9
        Object r3 = r2.newInstance(new Object[0]);     // Catch: Throwable -> L9
        if ((r3 instanceof LynxLibraryProvider) == false) goto L7;
        ((LynxLibraryProvider) r3).register(r5);     // Catch: Throwable -> L9
        return true;
    L7:
        LLog.e(TAG, r6 + " does not implement LynxLibraryProvider");     // Catch: Throwable -> L9
    L11:
        return false;
    L9:
        th = move-exception;
        LLog.w(TAG, "Skip unavailable Lynx library provider " + r6 + ": " + th);
        goto L11
    }

    public void registerModule(String r2, Class<? extends LynxModule> r3) {
        registerModule(r2, r3, null);
    }

    public static void setup(LynxViewBuilder r2, String[] r3) {
        setup(new LynxLibraryRegistry(null, r2), r3);
    }

    public static void setupGlobal(Context r2, String[] r3) {
        setupGlobal(new LynxLibraryRegistry(r2, null), r3);
        Context r4 = r2.getApplicationContext();
        if ((r4 instanceof Application) == false) goto L6;
        n.c().b((Application) r4);
        return;
    }

    public void registerModule(String r2, Class<? extends LynxModule> r3, Object r4) {
        LynxViewBuilder r0 = this.mBuilder;
        if (r0 == null) goto L5;
        r0.registerModule(r2, r3, r4);
        return;
    L5:
        LynxEnv.inst().registerModule(r2, r3, r4);
    }
}

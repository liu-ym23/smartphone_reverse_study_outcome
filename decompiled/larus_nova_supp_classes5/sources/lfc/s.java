package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class s implements kfc.a {
    public s() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class c() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.app.MiuiNotification");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.MiuiNotification");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.MiuiNotification");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.app.MiuiNotification");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.MiuiNotification");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.MiuiNotification");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.MiuiNotification");
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2", "com.i.miui.launcher"});
    }

    @Override // kfc.a
    public final void a(Context r6, ComponentName r7, int r8) throws RedBadgerException {
        Object r0 = "";
        if (r6 == null) goto L30;
        if (r7 == null) goto L39;
        if (r8 >= 0) goto L33;
        r8 = 0;
    L33:
        Object r1 = c().newInstance();     // Catch: Throwable -> L16
        Field r2 = r1.getClass().getDeclaredField("messageCount");     // Catch: Throwable -> L16
        r2.setAccessible(true);     // Catch: Throwable -> L16
        if (r8 != 0) goto L31;
        Object r3 = "";
    L12:
        r2.set(r1, String.valueOf(r3));     // Catch: Throwable -> L14
    L14:
        r2.set(r1, Integer.valueOf(r8));     // Catch: Throwable -> L16
        return;
    L37:
        return;
    L31:
        r3 = Integer.valueOf(r8);     // Catch: Throwable -> L14
    L16:
        th = move-exception;
        Intent r4 = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
        r4.putExtra("android.intent.extra.update_application_component_name", r7.getPackageName() + "/" + r7.getClassName());
        if (r8 == 0) goto L21;
        r0 = Integer.valueOf(r8);
    L21:
        r4.putExtra("android.intent.extra.update_application_message_text", String.valueOf(r0));
        if (nfc.a.a(r6, r4) == false) goto L29;
        r6.sendBroadcast(r4);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L29:
        throw new RedBadgerException("unable to resolve intent: " + r4.toString());
    L39:
        return;
    }
}

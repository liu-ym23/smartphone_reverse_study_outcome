package com.obric.assistant.settings.autogui;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class o0 {
    public static final Lazy a = null;

    public static final class a {
        public final List<String> a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "BlockedAppsResult(packages=" + this.a + ", success=" + this.b + ')';
        }

        public a(List<String> r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "packages");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = LazyKt.lazy(new n0());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.provider.DeviceConfig");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.provider.DeviceConfig");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.provider.DeviceConfig");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.provider.DeviceConfig");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.provider.DeviceConfig");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.provider.DeviceConfig");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.provider.DeviceConfig");
    }

    public static a b() {
        if (Build.VERSION.SDK_INT < 37) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        String r4 = "";
        Method r5 = (Method) a.getValue();
        if (r5 != null) goto L54;
        FLogger.a.e("ObricComputerControlConfigReader", "getDeviceConfigString skip, DeviceConfig.getString unresolved, namespace: computer_control, name: blocked_automatable_apps");
        String r9 = null;
    L24:
        FLogger r1 = FLogger.a;
        r1.i("ObricComputerControlConfigReader", "getBlockedAutomatableAppPackagesResult, rawValue: " + r9);
        if (r9 != null) goto L29;
        return new a(CollectionsKt.emptyList(), false);
    L29:
        if (StringsKt.isBlank(r9) == false) goto L32;
        List r2 = CollectionsKt.emptyList();
    L53:
        return new a(r2, true);
    L32:
        if (Intrinsics.areEqual(StringsKt.trim(r9).toString(), "*") == false) goto L34;
        r1.i("ObricComputerControlConfigReader", "parseList, INCLUDE_EVERYTHING, return empty package list");
        r2 = CollectionsKt.emptyList();
        goto L53
    L34:
        List r3 = StringsKt.split$default(r9, new String[]{","}, false, 0, 6, null);
        ArrayList r6 = new ArrayList();
        Iterator r7 = r3.iterator();
    L36:
        if (r7.hasNext() == false) goto L51;
        String r8 = StringsKt.trim((String) r7.next()).toString();
        if (r8.length() != 0) goto L40;
        boolean r10 = true;
    L41:
        if (r10 == true) goto L48;
        String r11 = StringsKt.trim(StringsKt.substringBefore$default(r8, ":", null, 2, null)).toString();
        if (r11.length() != 0) goto L46;
        boolean r12 = true;
    L47:
        if (r12 == true) goto L48;
    L49:
        if (r11 == null) goto L36;
        r6.add(r11);
        goto L36
    L46:
        r12 = false;
    L48:
        r11 = null;
        goto L49
    L40:
        r10 = false;
        goto L41
    L51:
        r2 = CollectionsKt.distinct(r6);
        goto L53
    L54:
        Object r13 = r5.invoke(null, new Object[]{"computer_control", "blocked_automatable_apps", ""});     // Catch: Throwable -> L21
        if ((r13 instanceof String) == false) goto L17;
        String r14 = (String) r13;     // Catch: Throwable -> L21
    L18:
        if (r14 == null) goto L23;
        r4 = r14;
    L23:
        r9 = r4;
        goto L24
    L17:
        r14 = null;
    L21:
        th = move-exception;
        FLogger.a.e("ObricComputerControlConfigReader", "getDeviceConfigString failed, namespace: computer_control, name: blocked_automatable_apps", th);
        r4 = null;
        goto L23
    L8:
        return new a(CollectionsKt.emptyList(), true);
    L5:
        r0 = false;
        goto L6
    }
}

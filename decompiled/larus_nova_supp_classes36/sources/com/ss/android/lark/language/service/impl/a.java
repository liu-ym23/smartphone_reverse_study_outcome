package com.ss.android.lark.language.service.impl;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.larksuite.framework.utils.Reflect;
import com.larksuite.framework.utils.b0;
import com.larksuite.framework.utils.x;
import com.larksuite.framework.utils.z;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.language.api.LocaleWatchScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.log.LogLevel;
import com.suite.lark.platform.component.dyres.DyResUtils;
import cpb.d;
import dagger.Lazy;
import e0c.k;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements apb.b {
    public static final /* synthetic */ int f = 0;
    public final ConcurrentHashMap<zob.b, Object> a;
    public LanguageChangeBroadcastReceiver b;
    public final c c;
    public final CopyOnWriteArrayList<zob.a> d;
    public final C0168a e;

    /* JADX INFO: renamed from: com.ss.android.lark.language.service.impl.a$a, reason: collision with other inner class name */
    public class C0168a implements Lazy<apb.a> {
        public final Object get() {
            return (apb.a) k.a(LarkAppContext.inst().getContext(), apb.a.class);
        }

        public C0168a() {
        }
    }

    public static final class b {
        public static final apb.b a = null;

        static {
            int r0 = a.f;
            if (Build.VERSION.SDK_INT < 33) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
            apb.b r2 = new LanguageSettingServiceApi33();
        L9:
            a = r2;
            return;
        L8:
            r2 = new a();
            goto L9
        L5:
            r1 = false;
            goto L6
        }
    }

    static {
        new Locale("en", "US");
        if (Build.VERSION.SDK_INT < 24) goto L6;
        LocaleList.getDefault();
        return;
    }

    @Override // apb.b
    public final boolean a() {
        return ((apb.a) this.e.get()).a();
    }

    @Override // apb.b
    public final Locale e() {
        return ((apb.a) this.e.get()).e();
    }

    @Override // apb.b
    public final Locale getCacheLanguageSetting() {
        return this.c.a();
    }

    @Override // apb.b
    public final Locale getLanguageSetting() {
        return ((apb.a) this.e.get()).getLanguageSetting();
    }

    public a() {
        this.a = new ConcurrentHashMap();
        this.d = new CopyOnWriteArrayList();
        this.e = new C0168a();
        this.c = c.a.a;
    }

    @Override // apb.b
    public final String b() {
        Locale r0 = getLanguageSetting();
        if (r0 != null) goto L5;
        isGooglePlay();
        return "en";
    L5:
        return r0.getLanguage().toLowerCase();
    }

    @Override // apb.b
    public final Locale g() {
        Locale r0 = getCacheLanguageSetting();
        if (r0 == null) goto L7;
        if (TextUtils.isEmpty(r0.getLanguage()) == true) goto L7;
        return r0;
    L7:
        return ((apb.a) this.e.get()).c();
    }

    @Override // apb.b
    public final boolean isGooglePlay() {
        return LarkAppContext.inst().buildConfig().isUsPackage();
    }

    public static apb.b o() {
        return b.a;
    }

    @Override // apb.b
    public final void c(zob.b r3) {
        LanguageChangeBroadcastReceiver r0 = this.b;
        if (r0 != null) goto L6;
        this.a.put(r3, new Object());
        return;
    L6:
        if (r0.a.contains(r3) == true) goto L11;
        r0.a.add(r3);
        return;
    }

    @Override // apb.b
    public final String d(Locale r2) {
        return ((apb.a) this.e.get()).d(r2);
    }

    @Override // apb.b
    public final void h(Configuration r7) {
        Locale r0 = getLanguageSetting();
        boolean r2 = false;
        if (x.b() == false) goto L5;
        Locale r1 = r7.getLocales().get(0);
    L6:
        Log.i("LaunchLocaleWatch", "scene= isSameWithSetting, context's locale is " + r0 + ", target locale is " + r1);
        if (TextUtils.equals(r1.getLanguage(), r0.getLanguage()) == true) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == true) goto L14;
    L18:
        r2 = r3;
    L20:
        if (r2 == false) goto L23;
        Log.i("LanguageSettingService", "currentLocale equals configLocale, configLocale: " + r1);
        return;
    L23:
        if (x.b() == false) goto L25;
        r7.setLocale(r0);
    L26:
        Log.i("LanguageSettingService", "changed the locale of newConfig, configLocale: " + r1);
        return;
    L25:
        r7.locale = r0;
        goto L26
    L14:
        if (TextUtils.equals(DyResUtils.ResI18n.zh_CN, r0.getLanguage() + "_" + r0.getCountry()) == false) goto L18;
        if (TextUtils.equals(r0.getScript(), r1.getScript()) == true) goto L18;
    L9:
        if (TextUtils.equals(r1.getCountry(), r0.getCountry()) == false) goto L11;
        r3 = true;
        goto L12
    L5:
        r1 = r7.locale;
        goto L6
    }

    @Override // apb.b
    public final Context j(Context r6) {
        Locale r0 = getLanguageSetting();
        if (p(r6, r0) == false) goto L6;
        Log.i("LanguageSettingService", "same locale");
        return r6;
    L6:
        Configuration r1 = new Configuration(r6.getResources().getConfiguration());
        int r2 = Build.VERSION.SDK_INT;
        if (r2 < 24) goto L9;
        r1.setLocale(r0);
    L10:
        Resources r3 = r6.getResources();
        DisplayMetrics r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics());
        r6.getResources().updateConfiguration(r1, r4);
        Context r5 = r6.createConfigurationContext(r1);
        NewMiraResourcesManager.getInstance().install(r5);
        if (r2 <= 27) goto L14;
        n(r5.getResources(), r6.getResources());
    L14:
        if (p(r5, r0) == false) goto L16;
        return r5;
    L16:
        return r6;
    L9:
        r1.locale = r0;
        goto L10
    }

    @Override // apb.b
    public final void k(zob.b r3) {
        Iterator<Map.Entry<zob.b, Object>> r0 = this.a.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r0.next().getKey() != r3) goto L4;
        this.a.remove(r3);
    L8:
        LanguageChangeBroadcastReceiver r1 = this.b;
        if (r1 == null) goto L17;
        if (r3 != null) goto L12;
        r1.getClass();
        return;
    L12:
        r1.a.remove(r3);
        return;
    }

    @Override // apb.b
    public final void l(Application r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Locale r0 = getLanguageSetting();
        if (p(r4, r0) == true) goto L19;
        StringBuilder r1 = new StringBuilder("change application's lcoale ");
        int r2 = d.a;
        r1.append(d.a.a(r4));
        r1.append(" to ");
        r1.append(r0);
        Log.i("LaunchLocaleWatch", r1.toString());
        Context r3 = j(r4.getBaseContext());
        new Reflect(r4).i("mBase", r3);
        Iterator<zob.a> r5 = this.d.iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        zob.a r6 = r5.next();
        if (r6 == null) goto L8;
        r6.a();
        goto L8
    L12:
        Log.i("LanguageSettingService", "update language setting");
        return;
    }

    public static void n(Resources r7, Resources r8) {
        AssetManager r9 = r7.getAssets();     // Catch: Exception -> L4
        AssetManager r10 = r8.getAssets();     // Catch: Exception -> L4
        Method r0 = b0.b(AssetManager.class, "getApkAssets", new Class[0]);     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        Object r11 = r0.invoke(r10, new Object[0]);     // Catch: Exception -> L4
        Method r1 = b0.b(AssetManager.class, "setApkAssets", new Class[]{r11.getClass(), Boolean.TYPE});     // Catch: Exception -> L4
        r1.setAccessible(true);     // Catch: Exception -> L4
        r1.invoke(r9, new Object[]{r11, Boolean.TRUE});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("LanguageSettingService", e.getMessage());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    @Override // apb.b
    public final void f(Application r20, yob.b r21) {
        int r0 = cpb.c.a;
        Intrinsics.checkNotNullParameter(r20, "application");
        int r1 = d.a;
        d.a.c(LocaleWatchScene.APPLICATION_INIT, r20).a(LogLevel.INFO);
        r20.registerActivityLifecycleCallbacks(new cpb.a(r20));
        r20.registerComponentCallbacks(new cpb.b(r20));
        LanguageChangeBroadcastReceiver r12 = new LanguageChangeBroadcastReceiver();
        IntentFilter r13 = new IntentFilter();
        r13.addAction(r20.getPackageName() + ".language.action.LANGUAGE_BROADCAST");
        if (Build.VERSION.SDK_INT < 33) goto L29;
        String r6 = LanguageChangeBroadcastReceiver.a(r20);
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L75;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L75:
    L23:
        e = e;
        String r17 = r6;
    L25:
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L28;
        ReceiverRegisterCrashOptimizer.registerReceiver(r12, r13, r17, null, 4);
    L56:
        this.b = r12;
        if (r12.a.contains(r21) == true) goto L61;
        r12.a.add(r21);
    L61:
        if (this.a.isEmpty() == true) goto L70;
        Iterator<Map.Entry<zob.b, Object>> r2 = this.a.entrySet().iterator();
    L64:
        if (r2.hasNext() == false) goto L69;
        Map.Entry<zob.b, Object> r3 = r2.next();
        LanguageChangeBroadcastReceiver r4 = this.b;
        zob.b r5 = r3.getKey();
        if (r4.a.contains(r5) == true) goto L64;
        r4.a.add(r5);
        goto L64
    L69:
        this.a.clear();
    L70:
        Locale r7 = getLanguageSetting();
        int r8 = d.a;
        Locale r9 = d.a.a(r20);
        int r10 = cpb.c.a;
        cpb.c.a.a(LocaleWatchScene.APPLICATION_INIT, r20, r7, r9);
        m(r20, r7);
        return;
    L28:
        throw e;
    L80:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L19;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r13) == false) goto L19;
        r17 = r6;
        int r11 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r12, r13, 4, r6, null, 5, r20).result;     // Catch: Exception -> L21
        if (r11 == 1) goto L18;
        if (r11 == 2) goto L17;
        if (r11 == 3) goto L79;
        r20.registerReceiver(r12, r13, r17, null, 4);     // Catch: Exception -> L21
    L79:
        goto L56
    L17:
        new Intent();     // Catch: Exception -> L21
        goto L79
    L18:
        r20.registerReceiver(r12, r13, r17, null, 4);     // Catch: Exception -> L21
    L19:
        r17 = r6;
        r20.registerReceiver(r12, r13, r17, null, 4);     // Catch: Exception -> L21
    L21:
        e = e;
        goto L25
    L29:
        String r14 = LanguageChangeBroadcastReceiver.a(r20);
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L77;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L77:
        String r15 = ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize();     // Catch: Exception -> L51
        if (r15 == 0) goto L47;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r13) == false) goto L47;
        int r16 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r12, r13, 0, r14, null, 4, r20).result;     // Catch: Exception -> L45
        if (r16 == 1) goto L44;
        if (r16 == 2) goto L43;
        if (r16 == 3) goto L56;
        String r18 = r14;
        r20.registerReceiver(r12, r13, r18, null);     // Catch: Exception -> L49
        r15 = r18;
    L82:
        goto L56
    L43:
        r15 = r14;
        new Intent();     // Catch: Exception -> L49
        goto L82
    L44:
        String r19 = r14;
        r20.registerReceiver(r12, r13, r19, null);     // Catch: Exception -> L49
        r15 = r19;
    L45:
        e = e;
        r15 = r14;
    L53:
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L72;
        ReceiverRegisterCrashOptimizer.registerReceiver(r12, r13, r15, null);
        goto L56
    L72:
        throw e;
    L47:
        String r22 = r14;
        r20.registerReceiver(r12, r13, r22, null);     // Catch: Exception -> L49
        r15 = r22;
    L49:
        e = e;
    L51:
        e = e;
        r15 = r14;
        goto L53
    }

    @Override // apb.b
    public final Context i(Context r4, Locale r5) {
        Configuration r0 = new Configuration(r4.getResources().getConfiguration());
        if (Build.VERSION.SDK_INT < 24) goto L5;
        r0.setLocale(r5);
    L6:
        Resources r6 = r4.getResources();
        DisplayMetrics r7 = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics());
        r4.getResources().updateConfiguration(r0, r7);
        Context r8 = r4.createConfigurationContext(r0);
        NewMiraResourcesManager.getInstance().install(r8);
        return r8;
    L5:
        r0.locale = r5;
        goto L6
    }

    @Override // apb.b
    public final boolean m(Application r6, Locale r7) {
        if (p(r6, r7) == true) goto L28;
        Configuration r0 = r6.getResources().getConfiguration();
        int r2 = Build.VERSION.SDK_INT;
        if (r2 < 24) goto L7;
        Locale r1 = r0.getLocales().get(0);
    L8:
        Configuration r4 = new Configuration(r0);
        if (r2 < 24) goto L11;
        r4.setLocale(r7);
    L12:
        Resources r3 = r6.getResources();
        r6.getResources().updateConfiguration(r4, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()));
        Context r5 = r6.createConfigurationContext(r4);
        NewMiraResourcesManager.getInstance().install(r5);
        if (r2 <= 27) goto L16;
        n(r5.getResources(), r6.getResources());
    L16:
        if (p(r5, r7) == false) goto L24;
        new Reflect(r6).i("mBase", r5);
        Iterator<zob.a> r8 = this.d.iterator();
    L19:
        if (r8.hasNext() == false) goto L24;
        zob.a r9 = r8.next();
        if (r9 == null) goto L19;
        r9.a();
    L24:
        if (z.e(r6) == false) goto L34;
        Intent r10 = new Intent();
        r10.putExtra("KEY_ORIGIN_LOCALE", r1);
        r10.putExtra("KEY_NEW_LOCALE", r7);
        int r11 = LanguageChangeBroadcastReceiver.b;
        r10.setAction(r6.getPackageName() + ".language.action.LANGUAGE_BROADCAST");
        r10.setPackage(r6.getPackageName());
        r6.sendBroadcast(r10, LanguageChangeBroadcastReceiver.a(r6));
        return true;
    L34:
        return true;
    L11:
        r4.locale = r7;
        goto L12
    L7:
        r1 = r0.locale;
        goto L8
    L28:
        return false;
    }

    public final boolean p(Context r5, Locale r6) {
        Locale r7 = r5.getResources().getConfiguration().locale;
        Log.i("LaunchLocaleWatch", "scene= isSameWithSetting, context's locale is " + r7 + ", target locale is " + r6);
        if (TextUtils.equals(r6.getLanguage(), r7.getLanguage()) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
    L14:
        return r0;
    L10:
        if (TextUtils.equals(DyResUtils.ResI18n.zh_CN, r7.getLanguage() + "_" + r7.getCountry()) == false) goto L14;
        if (TextUtils.equals(r7.getScript(), r6.getScript()) == true) goto L14;
        return false;
    L5:
        if (TextUtils.equals(r6.getCountry(), r7.getCountry()) == false) goto L7;
        r0 = true;
        goto L8
    }
}

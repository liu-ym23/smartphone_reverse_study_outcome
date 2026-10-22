package com.ss.android.lark.language.service.impl;

import android.app.Application;
import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.component.dyres.DyResUtils;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LanguageSettingServiceApi33 implements apb.b {
    public final Lazy a;
    public final CopyOnWriteArrayList<zob.a> b;
    public final CopyOnWriteArrayList<zob.b> c;
    public final Lazy d;

    @Override // apb.b
    public final void h(Configuration r1) {
    }

    @Override // apb.b
    public final Context i(Context r1, Locale r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return r1;
    }

    @Override // apb.b
    public final Context j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return r2;
    }

    @Override // apb.b
    public final void l(Application r1) {
    }

    @Override // apb.b
    public final Locale getCacheLanguageSetting() {
        return ((c) this.d.getValue()).a();
    }

    @Override // apb.b
    public final boolean isGooglePlay() {
        LarkAppContext.Companion.getClass();
        return LarkAppContext.access$getInstance$cp().buildConfig().isUsPackage();
    }

    public final apb.a n() {
        return (apb.a) this.a.getValue();
    }

    public LanguageSettingServiceApi33() {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.PUBLICATION;
        this.a = LazyKt.lazy(r0, LanguageSettingServiceApi33$globalLanguageService$2.INSTANCE);
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
        this.d = LazyKt.lazy(r0, LanguageSettingServiceApi33$localeCache$2.INSTANCE);
    }

    @Override // apb.b
    public final boolean a() {
        return n().a();
    }

    @Override // apb.b
    public final String b() {
        Locale r0 = getLanguageSetting();
        if (r0 == null) goto L8;
        String r1 = r0.getLanguage();
        if (r1 == null) goto L8;
        String r2 = r1.toLowerCase(Locale.getDefault());
        if (r2 == null) goto L8;
        return r2;
    L8:
        isGooglePlay();
        return "en";
    }

    @Override // apb.b
    public final Locale e() {
        return n().getLanguageSetting();
    }

    @Override // apb.b
    public final Locale g() {
        Locale r0 = getCacheLanguageSetting();
        if (TextUtils.isEmpty(r0.getLanguage()) == true) goto L5;
        return r0;
    L5:
        return b.a;
    }

    @Override // apb.b
    public final Locale getLanguageSetting() {
        return n().getLanguageSetting();
    }

    @Override // apb.b
    public final void c(zob.b r2) {
        if (r2 == null) goto L5;
        this.c.add(r2);
        return;
    }

    @Override // apb.b
    public final String d(Locale r2) {
        Intrinsics.checkNotNullParameter(r2, "locale");
        return n().d(r2);
    }

    @Override // apb.b
    public final void k(zob.b r2) {
        this.c.remove(r2);
    }

    @Override // apb.b
    public final void f(Application r6, yob.b r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Locale r0 = n().getLanguageSetting();
        Locale r1 = n().f();
        c(r7);
        Log.i("LaunchLocaleWatch", "scene= isSameWithSetting, context's locale is " + r0 + ", target locale is " + r1);
        Intrinsics.checkNotNull(r1);
        String r8 = r1.getLanguage();
        Intrinsics.checkNotNull(r0);
        boolean r2 = false;
        if (TextUtils.equals(r8, r0.getLanguage()) == true) goto L5;
    L7:
        boolean r9 = false;
    L8:
        if (r9 == true) goto L10;
    L14:
        r2 = r9;
    L15:
        if (r2 == true) goto L18;
        m(r6, r0);
        return;
    L18:
        return;
    L10:
        if (TextUtils.equals(DyResUtils.ResI18n.zh_CN, r0.getLanguage() + '_' + r0.getCountry()) == false) goto L14;
        if (TextUtils.equals(r0.getScript(), r1.getScript()) == true) goto L14;
    L5:
        if (TextUtils.equals(r1.getCountry(), r0.getCountry()) == false) goto L7;
        r9 = true;
        goto L8
    }

    @Override // apb.b
    public final boolean m(Application r7, Locale r8) {
        Intrinsics.checkNotNullParameter(r7, "application");
        Intrinsics.checkNotNullParameter(r8, "locale");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "locale");
        Locale r0 = r7.getResources().getConfiguration().locale;
        Log.i("LaunchLocaleWatch", "scene= isSameWithSetting, context's locale is " + r0 + ", target locale is " + r8);
        if (TextUtils.equals(r8.getLanguage(), r0.getLanguage()) == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
    L14:
        if (r1 == false) goto L16;
    L35:
        return false;
    L16:
        if (Build.VERSION.SDK_INT < 33) goto L35;
        LocaleManager r9 = (LocaleManager) r7.getSystemService(LocaleManager.class);
        LocaleList r2 = r9.getApplicationLocales();
        if (r2.isEmpty() == false) goto L20;
        r2 = r9.getSystemLocales();
    L20:
        Locale r3 = r2.get(0);
        Intrinsics.checkNotNull(r3);
        if (a() == false) goto L23;
        r9.setApplicationLocales(LocaleList.getEmptyLocaleList());
    L24:
        Iterator<zob.a> r10 = this.b.iterator();
    L26:
        if (r10.hasNext() == false) goto L30;
        zob.a r4 = r10.next();
        if (r4 == null) goto L26;
        r4.a();
        goto L26
    L30:
        Iterator<zob.b> r11 = this.c.iterator();
    L32:
        if (r11.hasNext() == false) goto L34;
        r11.next().a(r3, r8);
        goto L32
    L34:
        return true;
    L23:
        r9.setApplicationLocales(new LocaleList(new Locale[]{r8}));
        goto L24
    L10:
        if (TextUtils.equals(DyResUtils.ResI18n.zh_CN, r0.getLanguage() + '_' + r0.getCountry()) == false) goto L14;
        if (TextUtils.equals(r0.getScript(), r8.getScript()) == true) goto L14;
        r1 = false;
        goto L14
    L5:
        if (TextUtils.equals(r8.getCountry(), r0.getCountry()) == false) goto L7;
        r1 = true;
        goto L8
    }
}

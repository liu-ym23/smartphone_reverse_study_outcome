package com.ss.android.lark.language.service.impl;

import android.app.LocaleManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.core.storage.CoreStorage;
import com.ss.android.lark.language.loader.BaseLanguageLoader;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class GlobalLanguageServiceImpl implements apb.a {
    public static boolean e;
    public final com.ss.android.lark.core.storage.b a;
    public final Locale b;
    public final Lazy c;
    public final Lazy d;

    public static final class a {
    }

    static {
        e = true;
    }

    @Override // apb.a
    public final Locale e() {
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        if (Build.VERSION.SDK_INT < 33) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        LarkAppContext.Companion.getClass();
        return ((LocaleManager) LarkAppContext.access$getInstance$cp().getContext().getSystemService(LocaleManager.class)).getSystemLocales().get(0);
    L9:
        LocaleListCompat r2 = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        Log.i("GlobalLanguageServiceImpl", r2.toString());
        Locale r3 = r2.get(0);
        Intrinsics.checkNotNull(r3);
        return r3;
    L5:
        r1 = false;
        goto L6
    }

    @Override // apb.a
    public final Locale getLanguageSetting() {
        com.ss.android.lark.storage.a r0 = CoreStorage.a;
        Intrinsics.checkNotNullParameter("COMMON", "scene");
        com.ss.android.lark.storage.kv.repo.a r1 = LarkKVStorage.g(CoreStorage.a, "COMMON", true);
        String r2 = r1.getString("params_language_locale", "");
        String r4 = r1.getString("params_language_contry", "");
        String r3 = r1.getString("params_language_script", "");
        if (TextUtils.isEmpty(r2) == true) goto L5;
    L7:
        e = false;
        Locale r5 = new Locale.Builder().setLanguage(r2).setRegion(r4).setScript(r3).build();
    L8:
        Locale r6 = b(r5);
        c.a.a.a = r6;
        Locale.setDefault(r6);
        return r6;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L7;
        e = true;
        r5 = e();
        goto L8
    }

    @Override // apb.a
    public final Locale f() {
        return b(e());
    }

    @Override // apb.a
    public final String g() {
        return d(getLanguageSetting());
    }

    @Override // apb.a
    public final boolean a() {
        return e;
    }

    @Override // apb.a
    public final Locale c() {
        return this.b;
    }

    @Inject
    public GlobalLanguageServiceImpl(com.ss.android.lark.core.storage.b r3) {
        Intrinsics.checkNotNullParameter(r3, "globalCoreStorage");
        this.a = r3;
        this.b = new Locale("en", "US");
        this.c = LazyKt.lazy(new GlobalLanguageServiceImpl$globalCoreRepo$2(this));
        this.d = LazyKt.lazy(new GlobalLanguageServiceImpl$languageLoader$2(this));
    }

    public final Locale b(Locale r12) {
        BaseLanguageLoader r0 = (BaseLanguageLoader) this.d.getValue();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r12, "locale");
        String r1 = r12.getCountry();
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        String r3 = r12.getLanguage() + '_' + r12.getCountry();
    L12:
        boolean r4 = Intrinsics.areEqual("zh", r12.getLanguage());
        Log.i("LaunchLocaleWatch", "checkSupportLanguage--->locale tag is " + r3);
        if (((HashMap) r0.e.getValue()).containsKey(r3) == false) goto L15;
        if (r4 == true) goto L15;
        return r12;
    L15:
        Intrinsics.checkNotNull(r3);
        String r13 = r12.getScript();
        Locale r5 = new Locale("en", "US");
        Locale r7 = new Locale("zh", "CN");
        Locale r8 = new Locale("zh", "TW");
        Locale r9 = new Locale("zh", "HK");
        if (r4 == true) goto L18;
        Iterator r14 = ((LinkedHashMap) r0.c.getValue()).keySet().iterator();
    L29:
        if (r14.hasNext() == false) goto L33;
        Locale r6 = (Locale) r14.next();
        if (StringsKt.startsWith$default(r3, r6.getLanguage(), false, 2, null) == false) goto L29;
        Log.i("LaunchLocaleWatch", "degraded locale2NameMap language, result: " + dpb.a.a(r6));
        Intrinsics.checkNotNull(r6);
        return r6;
    L33:
        Log.i("LaunchLocaleWatch", "degraded language, result: " + dpb.a.a(r5));
        return r5;
    L18:
        if (StringsKt.startsWith$default(r3, "zh_TW", false, 2, null) == false) goto L21;
    L25:
        r7 = r8;
    L26:
        Locale r15 = new Locale.Builder().setLanguage(r7.getLanguage()).setRegion(r7.getCountry()).setScript(r13).build();
        Log.i("LaunchLocaleWatch", "degraded chinese language, result: " + dpb.a.a(r15));
        Intrinsics.checkNotNull(r15);
        return r15;
    L21:
        if (StringsKt.startsWith$default(r3, "zh_HK", false, 2, null) == false) goto L24;
        r7 = r9;
        goto L26
    L24:
        if (Intrinsics.areEqual(r13, "Hant") == false) goto L26;
    L11:
        r3 = r12.getLanguage();
        goto L12
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // apb.a
    public final String d(Locale r3) {
        Intrinsics.checkNotNullParameter(r3, "locale");
        String r4 = r3.getLanguage() + '_' + r3.getCountry().toUpperCase(Locale.getDefault());
        if (Intrinsics.areEqual("in_ID", r4) == false) goto L6;
        return "id_ID";
    L6:
        return r4;
    }
}

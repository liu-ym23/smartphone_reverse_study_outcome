package com.bytedance.android.live.core.i18n;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.config.yn;
import com.bytedance.common.utility.Logger;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import w50.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static a h;
    public String a;
    public long b;
    public Map<String, String> c;
    public I18nUpdateManager d;
    public final C0140a e;
    public com.bytedance.android.live.core.i18n.b f;
    public final b g;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.i18n.a$a, reason: collision with other inner class name */
    public class C0140a implements I18nUpdateManager.f {
        public final /* synthetic */ a a;

        public C0140a(a r1) {
            this.a = r1;
        }
    }

    public class b implements com.bytedance.android.live.core.i18n.b.a {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }
    }

    public static a b() {
        if (h != null) goto L6;
        h = new a();
    L6:
        return h;
    }

    public a() {
        this.a = "";
        this.b = 0;
        this.c = new HashMap();
        this.e = new C0140a(this);
        this.g = new b(this);
    }

    public final String a(String r5) {
        if (((Boolean) yn.a.getValue()).booleanValue() == false) goto L5;
        return null;
    L5:
        if (r5 != null) goto L8;
        return null;
    L8:
        if (this.c.containsKey(r5) == true) goto L14;
        I18nUpdateManager r0 = this.d;
        if (r0 == null) goto L12;
        r0.update(this.b);
    L12:
        h.a().c(r5, null);
        return null;
    L14:
        String r1 = this.c.get(r5);
        h.a().c(r5, r1);
        return r1;
    }

    public final void c(Locale r7) {
        if (((Boolean) yn.a.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        h r0 = h.a();
        r0.getClass();
        if (v.a() == true) goto L9;
        r0.h++;
    L9:
        Logger.d("i18n_translation", "wanna switch locale");
        if (r7 != null) goto L13;
        Logger.e("i18n_translation", "new locale is empty, return");
        return;
    L13:
        String r8 = r7.getLanguage() + Item.MIX_ID_SEPERATOR + r7.getCountry().toLowerCase();
        Logger.d("i18n_translation", "new locale is " + r8);
        if (TextUtils.equals(r8, this.a) == false) goto L17;
        Logger.d("i18n_translation", "new locale is equals to current locale, return");
        return;
    L17:
        I18nUpdateManager r1 = this.d;
        if (r1 == null) goto L25;
        Logger.d("i18n_translation", "I18nUpdateManager destroy");
        r1.b.removeCallbacksAndMessages(null);
        Disposable r5 = r1.h;
        if (r5 != null) goto L22;
    L24:
        r1.c = null;
        goto L25
    L22:
        if (r5.isDisposed() == true) goto L24;
        r1.h.dispose();
    L25:
        com.bytedance.android.live.core.i18n.b r2 = this.f;
        if (r2 == null) goto L38;
        Logger.d("i18n_translation", "I18nDbManager destroy");
        Disposable r6 = r2.g;
        if (r6 != null) goto L30;
    L32:
        Disposable r9 = r2.h;
        if (r9 != null) goto L35;
    L37:
        r2.b = null;
        goto L38
    L35:
        if (r9.isDisposed() == true) goto L37;
        r2.h.dispose();
        goto L37
    L30:
        if (r6.isDisposed() == true) goto L32;
        r2.g.dispose();
    L38:
        this.c.clear();
        this.b = 0;
        this.f = new com.bytedance.android.live.core.i18n.b(r8, this.g);
        this.d = new I18nUpdateManager(r8, this.e);
        if (TextUtils.isEmpty(this.a) == false) goto L41;
        Logger.d("i18n_translation", "switch locale when app start, first query db");
        this.f.a();
    L42:
        this.a = r8;
        h r11 = h.a();
        r11.getClass();
        if (v.a() == true) goto L47;
        r11.i++;
        return;
    L47:
        return;
    L41:
        Logger.d("i18n_translation", "switch locale during app running, directly query api");
        this.d.update(this.b);
        goto L42
    }
}

package com.ss.android.lark.language.service.impl;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import e0c.k;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public Locale a;

    public static final class a {
        public static final c a = null;

        static {
            a = new c();
        }
    }

    public final Locale a() {
        if (this.a != null) goto L6;
        this.a = ((apb.a) k.a(LarkAppContext.inst().getContext(), apb.a.class)).getLanguageSetting();
    L6:
        return this.a;
    }

    public final boolean b() {
        return "en".equals(a().getLanguage().toLowerCase());
    }

    public final boolean c() {
        Locale r0 = a();
        if ("zh".equals(r0.getLanguage().toLowerCase()) == true) goto L5;
    L7:
        return false;
    L5:
        if ("CN".equals(r0.getCountry().toUpperCase()) == false) goto L7;
        return true;
    }

    public final boolean d() {
        Locale r0 = a();
        if ("zh".equals(r0.getLanguage().toLowerCase()) == true) goto L5;
    L7:
        return false;
    L5:
        if ("HK".equals(r0.getCountry().toUpperCase()) == false) goto L7;
        return true;
    }

    public final boolean e() {
        Locale r0 = a();
        if ("zh".equals(r0.getLanguage().toLowerCase()) == true) goto L5;
    L7:
        return false;
    L5:
        if ("TW".equals(r0.getCountry().toUpperCase()) == false) goto L7;
        return true;
    }

    public c() {
    }
}

package com.ss.android.lark.officesdk.language;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.init.IOfficeSdkLanguageProvider;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class OfficeGlobalLanguageServiceImpl implements apb.a {
    public static final Locale c = null;
    public static final Locale d = null;
    public static final Locale e = null;
    public static final Locale f = null;
    public static final Locale g = null;
    public static final List<Locale> h = null;
    public static final List<Locale> i = null;
    public final Lazy a;
    public final Lazy b;

    public static final class a {
    }

    public final boolean a() {
        return true;
    }

    static {
        Locale r0 = new Locale("zh", "CN");
        c = r0;
        Locale r1 = new Locale("zh", "HK");
        d = r1;
        Locale r3 = new Locale("zh", "TW");
        e = r3;
        Locale r2 = new Locale("en", "US");
        f = r2;
        Locale r4 = new Locale("es", "419");
        g = r4;
        h = CollectionsKt.listOf(new Locale[]{r0, r1, r3});
        i = CollectionsKt.listOf(new Locale[]{r2, new Locale("id", "ID"), new Locale("ms", "MY"), new Locale("de", "DE"), new Locale("es", "ES"), new Locale("fr", "FR"), new Locale("it", "IT"), new Locale("pt", "BR"), new Locale("vi", "VN"), new Locale("ru", "RU"), new Locale("th", "TH"), new Locale("ja", "JP"), new Locale("ko", "KR"), r0, r1, r3, new Locale("ar"), new Locale("en", "GB"), r4, new Locale("fil"), new Locale("tr"), new Locale("uz")});
    }

    public final Locale c() {
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L6;
        return f;
    L6:
        return c;
    }

    public final Locale e() {
        return ((IOfficeSdkLanguageProvider) this.b.getValue()).getLocale();
    }

    public final Locale getLanguageSetting() {
        return ((IOfficeSdkLanguageProvider) this.b.getValue()).getLocale();
    }

    @Inject
    public OfficeGlobalLanguageServiceImpl() {
        this.a = LazyKt.lazy(new OfficeGlobalLanguageServiceImpl$isOverseaPackage$2(this));
        this.b = LazyKt.lazy(OfficeGlobalLanguageServiceImpl$languageProvider$2.INSTANCE);
    }

    public final Locale f() {
        return b(e());
    }

    public final String g() {
        return d(getLanguageSetting());
    }

    public final Locale b(Locale r8) {
        if (StringsKt.equals("zh", r8.getLanguage(), true) == false) goto L5;
        String r0 = r8.getCountry();
        Locale r1 = Locale.ROOT;
        String r2 = r0.toUpperCase(r1);
        String r9 = r8.getScript().toUpperCase(r1);     // Catch: Throwable -> L58
    L60:
        if (Intrinsics.areEqual(r9, "HANS") == false) goto L64;
        return c;
    L64:
        if (Intrinsics.areEqual(r9, "HANT") == true) goto L66;
        int r10 = r2.hashCode();
        if (r10 == 2155) goto L102;
        if (r10 == 2307) goto L98;
        if (r10 == 2466) goto L94;
        if (r10 == 2476) goto L91;
        if (r10 == 2644) goto L88;
        if (r10 != 2691) goto L123;
        if (r2.equals("TW") == false) goto L123;
        return e;
    L123:
        return c;
    L88:
        if (r2.equals("SG") == false) goto L123;
    L105:
        return c;
    L91:
        if (r2.equals("MY") == true) goto L105;
    L94:
        if (r2.equals("MO") == false) goto L123;
        return d;
    L98:
        if (r2.equals("HK") == false) goto L123;
        return d;
    L102:
        if (r2.equals("CN") == true) goto L105;
    L66:
        if (Intrinsics.areEqual(r2, "TW") == false) goto L69;
        return e;
    L69:
        return d;
    L58:
        r9 = "";
        goto L60
    L5:
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L51;
        String r3 = r8.getLanguage();
        Locale r4 = Locale.ROOT;
        String r5 = r3.toLowerCase(r4);
        String r11 = r8.getCountry().toUpperCase(r4);
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L9;
        List<Locale> r6 = i;
    L10:
        Iterator<T> r7 = r6.iterator();
    L11:
        Object r12 = null;
        if (r7.hasNext() == false) goto L21;
        Object r13 = r7.next();
        Locale r14 = (Locale) r13;
        if (StringsKt.equals(r14.getLanguage(), r5, true) == true) goto L16;
    L18:
        boolean r15 = false;
    L19:
        if (r15 == false) goto L11;
    L22:
        Locale r16 = (Locale) r13;
        if (r16 == null) goto L26;
        return r16;
    L26:
        if (Intrinsics.areEqual("es", r5) == false) goto L29;
        return g;
    L29:
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L31;
        List<Locale> r17 = i;
    L32:
        Iterator<T> r18 = r17.iterator();
    L34:
        if (r18.hasNext() == false) goto L38;
        Object r19 = r18.next();
        if (StringsKt.equals(((Locale) r19).getLanguage(), r5, true) == false) goto L34;
        r12 = r19;
    L38:
        Locale r20 = (Locale) r12;
        if (r20 != null) goto L118;
        StringBuilder r21 = new StringBuilder("unsupported locale ");
        r21.append(r5);
        r21.append('-');
        r21.append(r11);
        r21.append(", fallback to ");
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L44;
        Locale r22 = f;
    L45:
        r21.append(r22);
        Log.i("OfficeLanguageService", r21.toString());
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L48;
        Locale r23 = f;
    L116:
        return r23;
    L48:
        r23 = c;
        goto L116
    L44:
        r22 = c;
        goto L45
    L118:
        return r20;
    L31:
        r17 = h;
        goto L32
    L16:
        if (StringsKt.equals(r14.getCountry(), r11, true) == false) goto L18;
        r15 = true;
        goto L19
    L21:
        r13 = null;
        goto L22
    L9:
        r6 = h;
        goto L10
    L51:
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L53;
        r23 = f;
        goto L116
    L53:
        r23 = c;
        goto L116
    }

    public final String d(Locale r3) {
        Intrinsics.checkNotNullParameter(r3, "locale");
        Locale r4 = b(r3);
        String r0 = r4.getCountry();
        Intrinsics.checkNotNull(r0);
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        String r5 = r4.getLanguage();
    L10:
        if (Intrinsics.areEqual("in_ID", r5) == false) goto L12;
        r5 = "id_ID";
    L12:
        Intrinsics.checkNotNull(r5);
        return r5;
    L8:
        r5 = r4.getLanguage() + '_' + r0.toUpperCase(Locale.getDefault());
        goto L10
    L5:
        r1 = false;
        goto L6
    }
}

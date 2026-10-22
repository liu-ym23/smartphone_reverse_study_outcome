package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class LocaleListCompat {
    private static final LocaleListCompat sEmptyLocaleList = null;
    private final LocaleListInterface mImpl;

    static {
        sEmptyLocaleList = create(new Locale[0]);
    }

    public static LocaleListCompat getAdjustedDefault() {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return wrap(Api24Impl.getAdjustedDefault());
    L7:
        return create(new Locale[]{Locale.getDefault()});
    }

    public static LocaleListCompat getDefault() {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return wrap(Api24Impl.getDefault());
    L7:
        return create(new Locale[]{Locale.getDefault()});
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public boolean isEmpty() {
        return this.mImpl.isEmpty();
    }

    public int size() {
        return this.mImpl.size();
    }

    public String toLanguageTags() {
        return this.mImpl.toLanguageTags();
    }

    public String toString() {
        return this.mImpl.toString();
    }

    public Object unwrap() {
        return this.mImpl.getLocaleList();
    }

    public static LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    private LocaleListCompat(LocaleListInterface r1) {
        this.mImpl = r1;
    }

    public static LocaleListCompat create(Locale... r2) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return wrap(Api24Impl.createLocaleList(r2));
    L7:
        return new LocaleListCompat(new LocaleListCompatWrapper(r2));
    }

    public static Locale forLanguageTagCompat(String r6) {
        if (r6.contains("-") == false) goto L17;
        String[] r0 = r6.split("-", -1);
        if (r0.length <= 2) goto L9;
        return new Locale(r0[0], r0[1], r0[2]);
    L9:
        if (r0.length <= 1) goto L13;
        return new Locale(r0[0], r0[1]);
    L13:
        if (r0.length != 1) goto L31;
        return new Locale(r0[0]);
    L31:
        throw new IllegalArgumentException("Can not parse language tag: [" + r6 + "]");
    L17:
        if (r6.contains("_") == false) goto L33;
        String[] r1 = r6.split("_", -1);
        if (r1.length <= 2) goto L23;
        return new Locale(r1[0], r1[1], r1[2]);
    L23:
        if (r1.length <= 1) goto L27;
        return new Locale(r1[0], r1[1]);
    L27:
        if (r1.length != 1) goto L31;
        return new Locale(r1[0]);
    L33:
        return new Locale(r6);
    }

    public static LocaleListCompat forLanguageTags(String r4) {
        if (r4 == null) goto L12;
        if (r4.isEmpty() == true) goto L12;
        String[] r5 = r4.split(",", -1);
        int r0 = r5.length;
        Locale[] r1 = new Locale[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L10;
        r1[r2] = Api21Impl.forLanguageTag(r5[r2]);
        r2 = r2 + 1;
        goto L7
    L10:
        return create(r1);
    L12:
        return getEmptyLocaleList();
    }

    public static LocaleListCompat wrap(LocaleList r2) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(r2));
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof LocaleListCompat) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mImpl.equals(((LocaleListCompat) r2).mImpl) == false) goto L7;
        return true;
    }

    public Locale get(int r2) {
        return this.mImpl.get(r2);
    }

    public Locale getFirstMatch(String[] r2) {
        return this.mImpl.getFirstMatch(r2);
    }

    public int indexOf(Locale r2) {
        return this.mImpl.indexOf(r2);
    }

    public static LocaleListCompat wrap(Object r0) {
        return wrap((LocaleList) r0);
    }

    public static boolean matchesLanguageAndScript(Locale r2, Locale r3) {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return LocaleList.matchesLanguageAndScript(r2, r3);
    L7:
        return Api21Impl.matchesLanguageAndScript(r2, r3);
    }
}

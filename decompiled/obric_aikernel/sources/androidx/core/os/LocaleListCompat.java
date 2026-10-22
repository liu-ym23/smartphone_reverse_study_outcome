package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.core.text.ICUCompat;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class LocaleListCompat {
    private static final LocaleListCompat sEmptyLocaleList = null;
    private final LocaleListInterface mImpl;

    @RequiresApi(21)
    static class Api21Impl {
        private static final Locale[] PSEUDO_LOCALE = null;

        static {
            PSEUDO_LOCALE = new Locale[]{new Locale("en", "XA"), new Locale("ar", "XB")};
        }

        private Api21Impl() {
        }

        @DoNotInline
        static Locale forLanguageTag(String r10) {
            return Locale.forLanguageTag(r10);
        }

        private static boolean isPseudoLocale(Locale r10) {
            Locale[] r11 = PSEUDO_LOCALE;
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            if (r11[r13].equals(r10) == true) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @DoNotInline
        static boolean matchesLanguageAndScript(@NonNull Locale r10, @NonNull Locale r11) {
            if (r10.equals(r11) == false) goto L6;
            return true;
        L6:
            if (r10.getLanguage().equals(r11.getLanguage()) == true) goto L9;
            return false;
        L9:
            if (isPseudoLocale(r10) == false) goto L11;
        L24:
            return false;
        L11:
            if (isPseudoLocale(r11) == true) goto L24;
            String r12 = ICUCompat.maximizeAndGetScript(r10);
            if (r12.isEmpty() == false) goto L23;
            String r13 = r10.getCountry();
            if (r13.isEmpty() == false) goto L18;
            return true;
        L18:
            if (r13.equals(r11.getCountry()) == false) goto L21;
            return true;
        L21:
            return false;
        L23:
            return r12.equals(ICUCompat.maximizeAndGetScript(r11));
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleList createLocaleList(Locale... r10) {
            return new LocaleList(r10);
        }

        @DoNotInline
        static LocaleList getAdjustedDefault() {
            return LocaleList.getAdjustedDefault();
        }

        @DoNotInline
        static LocaleList getDefault() {
            return LocaleList.getDefault();
        }
    }

    static {
        sEmptyLocaleList = create(new Locale[0]);
    }

    private LocaleListCompat(LocaleListInterface r10) {
        this.mImpl = r10;
    }

    @NonNull
    public static LocaleListCompat create(@NonNull Locale... r10) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return wrap(Api24Impl.createLocaleList(r10));
    L7:
        return new LocaleListCompat(new LocaleListCompatWrapper(r10));
    }

    static Locale forLanguageTagCompat(String r10) {
        if (r10.contains("-") == false) goto L17;
        String[] r11 = r10.split("-", -1);
        if (r11.length <= 2) goto L9;
        return new Locale(r11[0], r11[1], r11[2]);
    L9:
        if (r11.length <= 1) goto L13;
        return new Locale(r11[0], r11[1]);
    L13:
        if (r11.length != 1) goto L31;
        return new Locale(r11[0]);
    L31:
        throw new IllegalArgumentException("Can not parse language tag: [" + r10 + "]");
    L17:
        if (r10.contains("_") == false) goto L33;
        String[] r12 = r10.split("_", -1);
        if (r12.length <= 2) goto L23;
        return new Locale(r12[0], r12[1], r12[2]);
    L23:
        if (r12.length <= 1) goto L27;
        return new Locale(r12[0], r12[1]);
    L27:
        if (r12.length != 1) goto L31;
        return new Locale(r12[0]);
    L33:
        return new Locale(r10);
    }

    @NonNull
    public static LocaleListCompat forLanguageTags(@Nullable String r10) {
        if (r10 == null) goto L16;
        if (r10.isEmpty() == true) goto L16;
        String[] r11 = r10.split(",", -1);
        int r12 = r11.length;
        Locale[] r13 = new Locale[r12];
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L14;
        if (Build.VERSION.SDK_INT < 21) goto L11;
        Locale r15 = Api21Impl.forLanguageTag(r11[r14]);
    L12:
        r13[r14] = r15;
        r14 = r14 + 1;
        goto L7
    L11:
        r15 = forLanguageTagCompat(r11[r14]);
        goto L12
    L14:
        return create(r13);
    L16:
        return getEmptyLocaleList();
    }

    @NonNull
    @Size(min = 1)
    public static LocaleListCompat getAdjustedDefault() {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return wrap(Api24Impl.getAdjustedDefault());
    L7:
        return create(new Locale[]{Locale.getDefault()});
    }

    @NonNull
    @Size(min = 1)
    public static LocaleListCompat getDefault() {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return wrap(Api24Impl.getDefault());
    L7:
        return create(new Locale[]{Locale.getDefault()});
    }

    @NonNull
    public static LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @RequiresApi(21)
    public static boolean matchesLanguageAndScript(@NonNull Locale r10, @NonNull Locale r11) {
        if (BuildCompat.isAtLeastT() == false) goto L7;
        return LocaleList.matchesLanguageAndScript(r10, r11);
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L11;
        return Api21Impl.matchesLanguageAndScript(r10, r11);
    L11:
        throw new UnsupportedOperationException("This method is only supported on API level 21+");
    }

    @NonNull
    @RequiresApi(24)
    public static LocaleListCompat wrap(@NonNull LocaleList r10) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(r10));
    }

    @RequiresApi(24)
    @Deprecated
    public static LocaleListCompat wrap(Object r10) {
        return wrap((LocaleList) r10);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof LocaleListCompat) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mImpl.equals(((LocaleListCompat) r10).mImpl) == false) goto L7;
        return true;
    }

    @Nullable
    public Locale get(int r10) {
        return this.mImpl.get(r10);
    }

    @Nullable
    public Locale getFirstMatch(@NonNull String[] r10) {
        return this.mImpl.getFirstMatch(r10);
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    @IntRange(from = -1)
    public int indexOf(@Nullable Locale r10) {
        return this.mImpl.indexOf(r10);
    }

    public boolean isEmpty() {
        return this.mImpl.isEmpty();
    }

    @IntRange(from = 0)
    public int size() {
        return this.mImpl.size();
    }

    @NonNull
    public String toLanguageTags() {
        return this.mImpl.toLanguageTags();
    }

    @NonNull
    public String toString() {
        return this.mImpl.toString();
    }

    @Nullable
    public Object unwrap() {
        return this.mImpl.getLocaleList();
    }
}

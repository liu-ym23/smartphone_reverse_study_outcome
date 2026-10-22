package androidx.core.os;

import ai.j0;
import android.os.Build;
import android.os.LocaleList;
import androidx.activity.e;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.core.text.ICUCompat;
import androidx.room.writer.DaoWriter;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class LocaleListCompat {
    private static final LocaleListCompat sEmptyLocaleList = null;
    private final LocaleListInterface mImpl;

    @RequiresApi(21)
    public static class Api21Impl {
        private static final Locale[] PSEUDO_LOCALE = null;

        static {
            PSEUDO_LOCALE = new Locale[]{new Locale("en", "XA"), new Locale("ar", "XB")};
        }

        private Api21Impl() {
        }

        @DoNotInline
        public static Locale forLanguageTag(String r5) {
            return Locale.forLanguageTag(r5);
        }

        private static boolean isPseudoLocale(Locale r5) {
            Locale[] r10 = PSEUDO_LOCALE;
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L9;
            if (r10[r12].equals(r5) == true) goto L6;
            r12 = r12 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @DoNotInline
        public static boolean matchesLanguageAndScript(@NonNull Locale r5, @NonNull Locale r10) {
            if (r5.equals(r10) == false) goto L6;
            return true;
        L6:
            if (r5.getLanguage().equals(r10.getLanguage()) == true) goto L9;
            return false;
        L9:
            if (isPseudoLocale(r5) == false) goto L11;
        L24:
            return false;
        L11:
            if (isPseudoLocale(r10) == true) goto L24;
            String r11 = ICUCompat.maximizeAndGetScript(r5);
            if (r11.isEmpty() == false) goto L23;
            String r12 = r5.getCountry();
            if (r12.isEmpty() == false) goto L18;
            return true;
        L18:
            if (r12.equals(r10.getCountry()) == false) goto L21;
            return true;
        L21:
            return false;
        L23:
            return r11.equals(ICUCompat.maximizeAndGetScript(r10));
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static LocaleList createLocaleList(Locale... r5) {
            return new LocaleList(r5);
        }

        @DoNotInline
        public static LocaleList getAdjustedDefault() {
            return LocaleList.getAdjustedDefault();
        }

        @DoNotInline
        public static LocaleList getDefault() {
            return LocaleList.getDefault();
        }
    }

    static {
        sEmptyLocaleList = create(new Locale[0]);
    }

    private LocaleListCompat(LocaleListInterface r5) {
        this.mImpl = r5;
    }

    @NonNull
    public static LocaleListCompat create(@NonNull Locale... r5) {
        return wrap(Api24Impl.createLocaleList(r5));
    }

    public static Locale forLanguageTagCompat(String r10) {
        if (r10.contains(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD) == false) goto L17;
        String[] r5 = r10.split(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD, -1);
        if (r5.length <= 2) goto L9;
        return new Locale(r5[0], r5[1], r5[2]);
    L9:
        if (r5.length <= 1) goto L13;
        return new Locale(r5[0], r5[1]);
    L13:
        if (r5.length != 1) goto L31;
        return new Locale(r5[0]);
    L31:
        throw new IllegalArgumentException(j0.k("Can not parse language tag: [", r10, "]"));
    L17:
        if (r10.contains("_") == false) goto L33;
        String[] r11 = r10.split("_", -1);
        if (r11.length <= 2) goto L23;
        return new Locale(r11[0], r11[1], r11[2]);
    L23:
        if (r11.length <= 1) goto L27;
        return new Locale(r11[0], r11[1]);
    L27:
        if (r11.length != 1) goto L31;
        return new Locale(r11[0]);
    L33:
        return new Locale(r10);
    }

    @NonNull
    public static LocaleListCompat forLanguageTags(@Nullable String r5) {
        if (r5 == null) goto L12;
        if (r5.isEmpty() == true) goto L12;
        String[] r10 = r5.split(",", -1);
        int r11 = r10.length;
        Locale[] r12 = new Locale[r11];
        int r13 = 0;
    L7:
        if (r13 >= r11) goto L10;
        r12[r13] = Api21Impl.forLanguageTag(r10[r13]);
        r13 = r13 + 1;
        goto L7
    L10:
        return create(r12);
    L12:
        return getEmptyLocaleList();
    }

    @NonNull
    @Size(min = 1)
    public static LocaleListCompat getAdjustedDefault() {
        return wrap(Api24Impl.getAdjustedDefault());
    }

    @NonNull
    @Size(min = 1)
    public static LocaleListCompat getDefault() {
        return wrap(Api24Impl.getDefault());
    }

    @NonNull
    public static LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    @RequiresApi(21)
    public static boolean matchesLanguageAndScript(@NonNull Locale r5, @NonNull Locale r10) {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return e.v(r5, r10);
    L7:
        return Api21Impl.matchesLanguageAndScript(r5, r10);
    }

    @RequiresApi(24)
    @Deprecated
    public static LocaleListCompat wrap(Object r5) {
        return wrap((LocaleList) r5);
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof LocaleListCompat) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mImpl.equals(((LocaleListCompat) r5).mImpl) == false) goto L7;
        return true;
    }

    @Nullable
    public Locale get(int r5) {
        return this.mImpl.get(r5);
    }

    @Nullable
    public Locale getFirstMatch(@NonNull String[] r5) {
        return this.mImpl.getFirstMatch(r5);
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    @IntRange(from = -1)
    public int indexOf(@Nullable Locale r5) {
        return this.mImpl.indexOf(r5);
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

    @NonNull
    @RequiresApi(24)
    public static LocaleListCompat wrap(@NonNull LocaleList r5) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(r5));
    }
}

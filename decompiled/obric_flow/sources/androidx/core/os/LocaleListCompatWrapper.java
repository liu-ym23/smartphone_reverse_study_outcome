package androidx.core.os;

import ai.j0;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class LocaleListCompatWrapper implements LocaleListInterface {
    private static final Locale EN_LATN = null;
    private static final Locale LOCALE_AR_XB = null;
    private static final Locale LOCALE_EN_XA = null;
    private static final Locale[] sEmptyList = null;
    private final Locale[] mList;

    @NonNull
    private final String mStringRepresentation;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static String getScript(Locale r5) {
            return r5.getScript();
        }
    }

    static {
        sEmptyList = new Locale[0];
        LOCALE_EN_XA = new Locale("en", "XA");
        LOCALE_AR_XB = new Locale("ar", "XB");
        EN_LATN = LocaleListCompat.forLanguageTagCompat("en-Latn");
    }

    public LocaleListCompatWrapper(@NonNull Locale... r10) {
        if (r10.length != 0) goto L5;
        this.mList = sEmptyList;
        this.mStringRepresentation = "";
        return;
    L5:
        ArrayList r5 = new ArrayList();
        HashSet r11 = new HashSet();
        StringBuilder r12 = new StringBuilder();
        int r13 = 0;
    L7:
        if (r13 >= r10.length) goto L19;
        Locale r14 = r10[r13];
        if (r14 == null) goto L18;
        if (r11.contains(r14) == true) goto L16;
        Locale r15 = (Locale) r14.clone();
        r5.add(r15);
        toLanguageTag(r12, r15);
        if (r13 >= (r10.length - 1)) goto L15;
        r12.append(',');
    L15:
        r11.add(r15);
    L16:
        r13 = r13 + 1;
        goto L7
    L18:
        throw new NullPointerException(j0.h(r13, "list[", "] is null"));
    L19:
        this.mList = (Locale[]) r5.toArray(new Locale[0]);
        this.mStringRepresentation = r12.toString();
    }

    private Locale computeFirstMatch(Collection<String> r5, boolean r10) {
        int r11 = computeFirstMatchIndex(r5, r10);
        if (r11 != (-1)) goto L6;
        return null;
    L6:
        return this.mList[r11];
    }

    private int computeFirstMatchIndex(Collection<String> r5, boolean r10) {
        Locale[] r11 = this.mList;
        if (r11.length != 1) goto L6;
        return 0;
    L6:
        if (r11.length != 0) goto L10;
        return -1;
    L10:
        if (r10 == false) goto L16;
        int r12 = findFirstMatchIndex(EN_LATN);
        if (r12 != 0) goto L14;
        return 0;
    L14:
        if (r12 >= Integer.MAX_VALUE) goto L16;
    L17:
        Iterator<String> r13 = r5.iterator();
    L19:
        if (r13.hasNext() == false) goto L25;
        int r14 = findFirstMatchIndex(LocaleListCompat.forLanguageTagCompat(r13.next()));
        if (r14 == 0) goto L22;
        if (r14 >= r12) goto L19;
        r12 = r14;
        goto L19
    L22:
        return 0;
    L25:
        if (r12 != Integer.MAX_VALUE) goto L27;
        return 0;
    L27:
        return r12;
    L16:
        r12 = Integer.MAX_VALUE;
        goto L17
    }

    private int findFirstMatchIndex(Locale r5) {
        int r10 = 0;
    L3:
        Locale[] r11 = this.mList;
        if (r10 >= r11.length) goto L9;
        if (matchScore(r5, r11[r10]) > 0) goto L7;
        r10 = r10 + 1;
        goto L3
    L7:
        return r10;
    L9:
        return Integer.MAX_VALUE;
    }

    private static String getLikelyScript(Locale r5) {
        String r10 = Api21Impl.getScript(r5);
        if (r10.isEmpty() == true) goto L5;
        return r10;
    L5:
        return "";
    }

    private static boolean isPseudoLocale(Locale r5) {
        if (LOCALE_EN_XA.equals(r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (LOCALE_AR_XB.equals(r5) == true) goto L8;
        return false;
    }

    @IntRange(from = 0, to = 1)
    private static int matchScore(Locale r5, Locale r10) {
        if (r5.equals(r10) == false) goto L6;
        return 1;
    L6:
        if (r5.getLanguage().equals(r10.getLanguage()) == true) goto L9;
        return 0;
    L9:
        if (isPseudoLocale(r5) == false) goto L11;
    L24:
        return 0;
    L11:
        if (isPseudoLocale(r10) == true) goto L24;
        String r11 = getLikelyScript(r5);
        if (r11.isEmpty() == false) goto L23;
        String r12 = r5.getCountry();
        if (r12.isEmpty() == false) goto L18;
        return 1;
    L18:
        if (r12.equals(r10.getCountry()) == false) goto L21;
        return 1;
    L21:
        return 0;
    L23:
        return r11.equals(getLikelyScript(r10)) ? 1 : 0;
    }

    @VisibleForTesting
    public static void toLanguageTag(StringBuilder r5, Locale r10) {
        r5.append(r10.getLanguage());
        String r11 = r10.getCountry();
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isEmpty() == true) goto L9;
        r5.append('-');
        r5.append(r10.getCountry());
        return;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof LocaleListCompatWrapper) == true) goto L8;
        return false;
    L8:
        Locale[] r11 = ((LocaleListCompatWrapper) r10).mList;
        if (this.mList.length == r11.length) goto L11;
        return false;
    L11:
        int r5 = 0;
    L12:
        Locale[] r12 = this.mList;
        if (r5 >= r12.length) goto L18;
        if (r12[r5].equals(r11[r5]) == false) goto L16;
        r5 = r5 + 1;
        goto L12
    L16:
        return false;
    L18:
        return true;
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int r5) {
        if (r5 < 0) goto L6;
        Locale[] r10 = this.mList;
        if (r5 >= r10.length) goto L6;
        return r10[r5];
    L6:
        return null;
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale getFirstMatch(@NonNull String[] r5) {
        return computeFirstMatch(Arrays.asList(r5), false);
    }

    @Override // androidx.core.os.LocaleListInterface
    @Nullable
    public Object getLocaleList() {
        return null;
    }

    public int hashCode() {
        Locale[] r5 = this.mList;
        int r10 = r5.length;
        int r11 = 1;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11 = (r11 * 31) + r5[r12].hashCode();
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(Locale r5) {
        int r10 = 0;
    L3:
        Locale[] r11 = this.mList;
        if (r10 >= r11.length) goto L9;
        if (r11[r10].equals(r5) == true) goto L7;
        r10 = r10 + 1;
        goto L3
    L7:
        return r10;
    L9:
        return -1;
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        if (this.mList.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.mList.length;
    }

    @Override // androidx.core.os.LocaleListInterface
    public String toLanguageTags() {
        return this.mStringRepresentation;
    }

    @NonNull
    public String toString() {
        StringBuilder r5 = new StringBuilder("[");
        int r10 = 0;
    L3:
        Locale[] r11 = this.mList;
        if (r10 >= r11.length) goto L9;
        r5.append(r11[r10]);
        if (r10 >= (this.mList.length - 1)) goto L8;
        r5.append(',');
    L8:
        r10 = r10 + 1;
        goto L3
    L9:
        r5.append("]");
        return r5.toString();
    }
}

package androidx.core.os;

import android.os.Build;
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
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static String getScript(Locale r10) {
            return r10.getScript();
        }
    }

    static {
        sEmptyList = new Locale[0];
        LOCALE_EN_XA = new Locale("en", "XA");
        LOCALE_AR_XB = new Locale("ar", "XB");
        EN_LATN = LocaleListCompat.forLanguageTagCompat("en-Latn");
    }

    LocaleListCompatWrapper(@NonNull Locale... r10) {
        if (r10.length != 0) goto L6;
        this.mList = sEmptyList;
        String r11 = "";
    L5:
        this.mStringRepresentation = r11;
        return;
    L6:
        ArrayList r12 = new ArrayList();
        HashSet r13 = new HashSet();
        StringBuilder r14 = new StringBuilder();
        int r15 = 0;
    L8:
        if (r15 >= r10.length) goto L20;
        Locale r16 = r10[r15];
        if (r16 == null) goto L19;
        if (r13.contains(r16) == true) goto L17;
        Locale r17 = (Locale) r16.clone();
        r12.add(r17);
        toLanguageTag(r14, r17);
        if (r15 >= (r10.length - 1)) goto L16;
        r14.append(',');
    L16:
        r13.add(r17);
    L17:
        r15 = r15 + 1;
        goto L8
    L19:
        throw new NullPointerException("list[" + r15 + "] is null");
    L20:
        this.mList = (Locale[]) r12.toArray(new Locale[0]);
        r11 = r14.toString();
        goto L5
    }

    private Locale computeFirstMatch(Collection<String> r10, boolean r11) {
        int r12 = computeFirstMatchIndex(r10, r11);
        if (r12 != (-1)) goto L6;
        return null;
    L6:
        return this.mList[r12];
    }

    private int computeFirstMatchIndex(Collection<String> r10, boolean r11) {
        Locale[] r12 = this.mList;
        if (r12.length != 1) goto L6;
        return 0;
    L6:
        if (r12.length != 0) goto L10;
        return -1;
    L10:
        if (r11 == false) goto L16;
        int r13 = findFirstMatchIndex(EN_LATN);
        if (r13 != 0) goto L14;
        return 0;
    L14:
        if (r13 >= Integer.MAX_VALUE) goto L16;
    L17:
        Iterator<String> r14 = r10.iterator();
    L19:
        if (r14.hasNext() == false) goto L25;
        int r15 = findFirstMatchIndex(LocaleListCompat.forLanguageTagCompat(r14.next()));
        if (r15 == 0) goto L22;
        if (r15 >= r13) goto L19;
        r13 = r15;
        goto L19
    L22:
        return 0;
    L25:
        if (r13 != Integer.MAX_VALUE) goto L27;
        return 0;
    L27:
        return r13;
    L16:
        r13 = Integer.MAX_VALUE;
        goto L17
    }

    private int findFirstMatchIndex(Locale r10) {
        int r11 = 0;
    L3:
        Locale[] r12 = this.mList;
        if (r11 >= r12.length) goto L9;
        if (matchScore(r10, r12[r11]) > 0) goto L7;
        r11 = r11 + 1;
        goto L3
    L7:
        return r11;
    L9:
        return Integer.MAX_VALUE;
    }

    private static String getLikelyScript(Locale r10) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        String r11 = Api21Impl.getScript(r10);
        if (r11.isEmpty() == true) goto L7;
        return r11;
    L7:
        return "";
    }

    private static boolean isPseudoLocale(Locale r10) {
        if (LOCALE_EN_XA.equals(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (LOCALE_AR_XB.equals(r10) == true) goto L8;
        return false;
    }

    @IntRange(from = 0, to = 1)
    private static int matchScore(Locale r10, Locale r11) {
        if (r10.equals(r11) == false) goto L6;
        return 1;
    L6:
        if (r10.getLanguage().equals(r11.getLanguage()) == true) goto L9;
        return 0;
    L9:
        if (isPseudoLocale(r10) == false) goto L11;
    L24:
        return 0;
    L11:
        if (isPseudoLocale(r11) == true) goto L24;
        String r12 = getLikelyScript(r10);
        if (r12.isEmpty() == false) goto L23;
        String r13 = r10.getCountry();
        if (r13.isEmpty() == false) goto L18;
        return 1;
    L18:
        if (r13.equals(r11.getCountry()) == false) goto L21;
        return 1;
    L21:
        return 0;
    L23:
        return r12.equals(getLikelyScript(r11)) ? 1 : 0;
    }

    @VisibleForTesting
    static void toLanguageTag(StringBuilder r10, Locale r11) {
        r10.append(r11.getLanguage());
        String r12 = r11.getCountry();
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.isEmpty() == true) goto L9;
        r10.append('-');
        r10.append(r11.getCountry());
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
        int r12 = 0;
    L12:
        Locale[] r13 = this.mList;
        if (r12 >= r13.length) goto L18;
        if (r13[r12].equals(r11[r12]) == false) goto L16;
        r12 = r12 + 1;
        goto L12
    L16:
        return false;
    L18:
        return true;
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int r10) {
        if (r10 < 0) goto L6;
        Locale[] r11 = this.mList;
        if (r10 >= r11.length) goto L6;
        return r11[r10];
    L6:
        return null;
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale getFirstMatch(@NonNull String[] r10) {
        return computeFirstMatch(Arrays.asList(r10), false);
    }

    @Override // androidx.core.os.LocaleListInterface
    @Nullable
    public Object getLocaleList() {
        return null;
    }

    public int hashCode() {
        Locale[] r10 = this.mList;
        int r11 = r10.length;
        int r12 = 1;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12 = (r12 * 31) + r10[r13].hashCode();
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(Locale r10) {
        int r11 = 0;
    L3:
        Locale[] r12 = this.mList;
        if (r11 >= r12.length) goto L9;
        if (r12[r11].equals(r10) == true) goto L7;
        r11 = r11 + 1;
        goto L3
    L7:
        return r11;
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
        StringBuilder r10 = new StringBuilder();
        r10.append("[");
        int r11 = 0;
    L3:
        Locale[] r12 = this.mList;
        if (r11 >= r12.length) goto L9;
        r10.append(r12[r11]);
        if (r11 >= (this.mList.length - 1)) goto L8;
        r10.append(',');
    L8:
        r11 = r11 + 1;
        goto L3
    L9:
        r10.append("]");
        return r10.toString();
    }
}

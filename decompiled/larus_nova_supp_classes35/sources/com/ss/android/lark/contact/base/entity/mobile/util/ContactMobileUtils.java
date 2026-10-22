package com.ss.android.lark.contact.base.entity.mobile.util;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import h9b.b;
import io.michaelrocks.libphonenumber.android.NumberParseException;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import io.michaelrocks.libphonenumber.android.Phonenumber;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ContactMobileUtils {
    public static final Token a = null;
    public static PhoneNumberUtil b;
    public static final HashMap<Character, Character> c = null;
    public static final char[] d = null;
    public static final int[] e = null;
    public static final int f = 0;
    public static final int g = 0;
    public static final char[] h = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ContactType {
        public static final int ALL = 3;
        public static final int EMAIL = 1;
        public static final int PHONE = 2;
    }

    static {
        new Token("LARK-PSDA-contact_mobile_utils_read_contacts_permission");
        a = new Token("LARK-PSDA-contact_mobile_utils_contact_query");
        c = new HashMap();
        char[] r1 = {21834, 33453, 25830, 25645, 34558, 21457, 22134, 21704, 20987, 21888, 22403, 22920, 25343, 21734, 21866, 26399, 28982, 25746, 22604, 25366, 26132, 21387, 21277};
        d = r1;
        e = new int[r1.length + 1];
        f = 45217;
        g = 63486;
        h = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'W', 'X', 'Y', 'Z'};
        int r0 = 0;
    L3:
        char[] r2 = d;
        if (r0 >= r2.length) goto L6;
        e[r0] = b(r2[r0]);
        r0 = r0 + 1;
        goto L3
    L6:
        e[r2.length] = g;
        c.put((char) 36911, 'L');
    }

    public static int b(char r3) {
        byte[] r4 = (BuildConfig.FLAVOR + r3).getBytes("GB2312");     // Catch: Exception -> L9
        if (r4.length >= 2) goto L6;
        return 0;
    L6:
        return ((r4[0] << 8) & 65280) + (r4[1] & 255);
    L9:
        return 0;
    }

    public static String c(String r7) {
        if (TextUtils.isEmpty(r7) == true) goto L5;
        StringBuilder r0 = new StringBuilder();
        int r2 = 0;
    L8:
        if (r2 >= r7.length()) goto L30;
        char r3 = r7.charAt(r2);
        Character r4 = c.get(Character.valueOf(r3));
        if (r4 == null) goto L13;
        r3 = r4.charValue();
    L28:
        r0.append(r3);
        r2 = r2 + 1;
        goto L8
    L13:
        if (r3 >= 'a') goto L15;
    L17:
        if (r3 >= 'A') goto L19;
    L21:
        int r5 = b(r3);
        if (r5 >= f) goto L24;
    L27:
        r3 = '#';
        goto L28
    L24:
        if (r5 > g) goto L27;
        char[] r6 = h;
        int[] r8 = e;
        r3 = r6[a(r5, r8, 0, r8.length - 1)];
        goto L28
    L19:
        if (r3 > 'Z') goto L21;
    L15:
        if (r3 > 'z') goto L17;
        r3 = (char) ((r3 - 'a') + 65);
        goto L28
    L30:
        return r0.toString();
    L5:
        return "#";
    }

    public static boolean d(Pair<Integer, String> r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (((Integer) r2.first).intValue() != 86) goto L10;
        return b.b("^[1]\\d{10}$", (CharSequence) r2.second);
    L10:
        return b.b("^\\d{1,14}$", (CharSequence) r2.second);
    }

    public static Pair<Integer, String> e(int r8, String r9) {
        if (TextUtils.isEmpty(r9) == true) goto L5;
        if (r9 != null) goto L8;
        String r0 = BuildConfig.FLAVOR;
    L16:
        if (r0.isEmpty() == false) goto L20;
        return Pair.create(Integer.valueOf(r8), BuildConfig.FLAVOR);
    L20:
        if (r9.trim().startsWith("+") == false) goto L22;
        if (b != null) goto L26;
        b = PhoneNumberUtil.c(LarkContext.getApplication());     // Catch: NumberParseException -> L32
    L26:
        PhoneNumberUtil r10 = b;     // Catch: NumberParseException -> L32
        r10.getClass();     // Catch: NumberParseException -> L32
        Phonenumber.PhoneNumber r7 = new Phonenumber.PhoneNumber();     // Catch: NumberParseException -> L32
        r10.s("+" + r0, BuildConfig.FLAVOR, false, true, r7);     // Catch: NumberParseException -> L32
        int r11 = r7.getCountryCode();     // Catch: NumberParseException -> L32
        if (r11 != 0) goto L31;
        return Pair.create(Integer.valueOf(r8), r0);
    L31:
        return Pair.create(Integer.valueOf(r11), String.valueOf(r7.getNationalNumber()));
    L33:
        return Pair.create(Integer.valueOf(r8), r0);
    L22:
        return Pair.create(Integer.valueOf(r8), r0);
    L8:
        StringBuilder r1 = new StringBuilder();
        char[] r2 = r9.toCharArray();
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        char r5 = r2[r4];
        if (Character.isDigit(r5) == false) goto L13;
        r1.append(r5);
    L13:
        r4 = r4 + 1;
        goto L9
    L14:
        r0 = r1.toString();
        goto L16
    L5:
        return Pair.create(Integer.valueOf(r8), BuildConfig.FLAVOR);
    }

    public static int a(int r2, int[] r3, int r4, int r5) {
        int r0 = (r4 + r5) / 2;
        if (r0 == r4) goto L12;
        int r1 = r3[r0];
        if (r1 == r2) goto L12;
        if (r1 <= r2) goto L9;
        r5 = r0;
    L11:
        return a(r2, r3, r4, r5);
    L9:
        r4 = r0;
    L12:
        return r0;
    }
}

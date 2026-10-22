package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.export.entity.chatter.OpenChatter;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m {
    public static final okb.a a = null;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ChatterNameDisplayRule.values().length];
            a = r0;
            r0[ChatterNameDisplayRule.ALIAS_NAME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[ChatterNameDisplayRule.NICKNAME_NAME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[ChatterNameDisplayRule.ALIAS_NICKNAME_NAME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[ChatterNameDisplayRule.NICKNAME_ALIAS_NAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[ChatterNameDisplayRule.NICKNAME_WITH_ALIAS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        a = ImSdkProxy.b();
    }

    public static char a(ChatChatter r5, Locale r6) {
        if (r5 != null) goto L5;
        return '#';
    L5:
        String r1 = r5.getName();
        String r2 = r5.getLocalizedName();
        String r7 = r5.getNamePy();
        if (TextUtils.isEmpty(r2) == false) goto L11;
        if (TextUtils.isEmpty(r1) == false) goto L11;
        return '#';
    L11:
        if (TextUtils.isEmpty(r2) == false) goto L13;
        char r3 = r1.charAt(0);
    L15:
        if (Locale.CHINESE.getLanguage().equals(r6.getLanguage()) == false) goto L20;
        if (TextUtils.isEmpty(r7) == true) goto L20;
        r3 = r7.charAt(0);
    L20:
        if ('A' > r3) goto L25;
        if (r3 > 'Z') goto L25;
    L28:
        boolean r8 = true;
    L30:
        if (r8 == true) goto L32;
        return '#';
    L32:
        return String.valueOf(r3).toUpperCase().charAt(0);
    L25:
        if ('a' <= r3) goto L27;
    L29:
        r8 = false;
        goto L30
    L27:
        if (r3 > 'z') goto L29;
    L13:
        r3 = r2.charAt(0);
        goto L15
    }

    public static String c(String r2, String r3) {
        okb.a r0 = a;
        Locale r1 = r0.getCacheLanguageSetting();
        if (r1 != null) goto L7;
        Log.e("ChatterNameUtil", "getDisplayName failed: locale is null");
        return r0.c().getLanguage();
    L7:
        if (Locale.ENGLISH.getLanguage().equals(r1.getLanguage()) == true) goto L9;
    L11:
        return r2;
    L9:
        if (TextUtils.isEmpty(r3) == true) goto L11;
        return r3;
    }

    public static String b(OpenChatter r9, ChatterNameDisplayRule r10, boolean r11) {
        String r0 = BuildConfig.FLAVOR;
        if (r9 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        if ((r9 instanceof ChatChatter) == false) goto L12;
        ChatChatter r1 = (ChatChatter) r9;
        if (r1.isOncallDuty() == true) goto L10;
        String r2 = r1.getNickName();
    L13:
        String r5 = r2;
        String r6 = r9.getAlias();
        String r3 = r9.getName();
        String r4 = r9.getLocalizedName();
        String r7 = r9.getEnName();
        if (r11 == false) goto L17;
        r0 = r9.getNameWithAnotherName();
    L17:
        return d(r3, r7, r4, r5, r6, r0, r10);
    L10:
        return r1.getName();
    L12:
        r2 = null;
        goto L13
    }

    public static String d(String r2, String r3, String r4, String r5, String r6, String r7, ChatterNameDisplayRule r8) {
        int r9 = a.a[r8.ordinal()];
        if (r9 == 1) goto L40;
        if (r9 == 2) goto L37;
        if (r9 == 3) goto L31;
        if (r9 == 4) goto L25;
        if (r9 != 5) goto L43;
        if (com.larksuite.framework.utils.f0.a(r5) == true) goto L22;
        StringBuilder r10 = new StringBuilder();
        r10.append(r5);
        if (com.larksuite.framework.utils.f0.a(r6) == true) goto L18;
        String r11 = String.format("(%s)", new Object[]{r6});
    L19:
        r10.append(r11);
        return r10.toString();
    L18:
        r11 = BuildConfig.FLAVOR;
        goto L19
    L22:
        if (com.larksuite.framework.utils.f0.a(r6) == true) goto L43;
        return r6;
    L43:
        if (com.larksuite.framework.utils.f0.a(r7) == true) goto L46;
        return r7;
    L46:
        if (TextUtils.isEmpty(r4) == true) goto L49;
        r2 = r4;
    L49:
        return c(r2, r3);
    L25:
        if (com.larksuite.framework.utils.f0.a(r5) == true) goto L28;
        return r5;
    L28:
        if (com.larksuite.framework.utils.f0.a(r6) == true) goto L43;
        return r6;
    L31:
        if (com.larksuite.framework.utils.f0.a(r6) == true) goto L34;
        return r6;
    L34:
        if (com.larksuite.framework.utils.f0.a(r5) == true) goto L43;
        return r5;
    L37:
        if (com.larksuite.framework.utils.f0.a(r5) == true) goto L43;
        return r5;
    L40:
        if (com.larksuite.framework.utils.f0.a(r6) == true) goto L43;
        return r6;
    }
}

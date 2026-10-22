package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import java.util.Comparator;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements Comparator<Chatter> {
    public final Locale a;

    public l() {
        this.a = m.a.getCacheLanguageSetting();
    }

    @Override // java.util.Comparator
    public final int compare(Chatter r6, Chatter r7) {
        Chatter r8 = r6;
        Chatter r9 = r7;
        if (r8.getLocalizedName() != null) goto L5;
        String r0 = r8.getName();
    L7:
        if (r9.getLocalizedName() != null) goto L9;
        String r1 = r9.getName();
    L11:
        if (Locale.CHINESE.getLanguage().equals(this.a.getLanguage()) == false) goto L23;
        String r2 = r8.getNamePy();
        if (TextUtils.isEmpty(r2) == false) goto L15;
    L17:
        String r3 = r9.getNamePy();
        if (TextUtils.isEmpty(r3) == true) goto L23;
        if (r3.equals("#") == true) goto L23;
        r1 = r3;
        goto L23
    L15:
        if (r2.equals("#") == true) goto L17;
        r0 = r2;
    L23:
        if (r0.equalsIgnoreCase(r1) == false) goto L26;
        return r8.getId().compareTo(r9.getId());
    L26:
        return r0.toUpperCase().compareTo(r1.toUpperCase());
    L9:
        r1 = r9.getLocalizedName();
        goto L11
    L5:
        r0 = r8.getLocalizedName();
        goto L7
    }
}

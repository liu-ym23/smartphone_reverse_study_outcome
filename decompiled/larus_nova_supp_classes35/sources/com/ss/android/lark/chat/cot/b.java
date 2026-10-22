package com.ss.android.lark.chat.cot;

import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.contact.base.entity.api.ContactMobileApi$From;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final Set<String> a = null;
    public static final Regex b = null;
    public static final Regex c = null;
    public static final Regex d = null;
    public static final Regex e = null;

    static {
        a = SetsKt.setOf(new String[]{ChatFromType.SEARCH, "bash", "read", "write", "edit", ContactMobileApi$From.DOC, ChatFromType.CALENDAR, "task", "vc_meeting", "meeting"});
        RegexOption r1 = RegexOption.IGNORE_CASE;
        b = new Regex("^[a-z0-9][a-z0-9_-]*_(?:outlined|filled|colorful)$", r1);
        c = new Regex("^https://", r1);
        d = new Regex("^data:image/", r1);
        e = new Regex("^(?:[a-z]+:)?img_(?:v\\d+_)?[a-z0-9][a-z0-9_-]*$", r1);
    }

    public static c a(String r11, String r12, String r13, boolean r14) {
        boolean r0 = true;
        if (r11 != null) goto L5;
    L50:
        String r15 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{r13, r12}), " ", null, null, 0, null, null, 62, null);
        if (r15.length() == 0) goto L54;
        r0 = false;
    L54:
        String r16 = null;
        if (r0 == true) goto L81;
        String r17 = r15.toLowerCase(Locale.ROOT);
        String r18 = ChatFromType.SEARCH;
        if (StringsKt.contains$default(r17, ChatFromType.SEARCH, false, 2, null) == false) goto L60;
    L80:
        r16 = r18;
        goto L81
    L60:
        if (StringsKt.contains$default(r17, "web", false, 2, null) == true) goto L80;
        r18 = "read";
        if (StringsKt.contains$default(r17, "read", false, 2, null) == true) goto L80;
        r18 = "write";
        if (StringsKt.contains$default(r17, "write", false, 2, null) == true) goto L80;
        r18 = "edit";
        if (StringsKt.contains$default(r17, "edit", false, 2, null) == true) goto L80;
        if (StringsKt.contains$default(r17, "run", false, 2, null) == false) goto L74;
    L79:
        r16 = "bash";
        goto L81
    L74:
        if (StringsKt.contains$default(r17, "exec", false, 2, null) == true) goto L79;
        if (StringsKt.contains$default(r17, "bash", false, 2, null) == true) goto L79;
        if (StringsKt.contains$default(r17, "shell", false, 2, null) == true) goto L79;
    L81:
        if (r16 == null) goto L85;
        return new c.a(r16);
    L85:
        return c.b.a;
    L5:
        if (r11.length() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L11;
    L30:
        boolean r3 = false;
    L32:
        if (r3 == false) goto L50;
        if (e.matches(r11) == true) goto L86;
        if (r14 == false) goto L46;
        if (c.containsMatchIn(r11) == false) goto L40;
    L43:
        if (r0 == false) goto L46;
        return new c.d(r11);
    L40:
        if (d.containsMatchIn(r11) == true) goto L43;
        r0 = false;
    L46:
        if (a.contains(r11) == false) goto L49;
        return new c.a(r11);
    L49:
        return new c.f(r11);
    L86:
        return new c.C0087c(r11);
    L11:
        if (a.contains(r11) == false) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L19;
    L31:
        r3 = true;
        goto L32
    L19:
        if (e.matches(r11) == true) goto L31;
        if (r14 == false) goto L30;
        if (c.containsMatchIn(r11) == false) goto L24;
    L27:
        boolean r5 = true;
    L28:
        if (r5 == false) goto L30;
    L24:
        if (d.containsMatchIn(r11) == true) goto L27;
        r5 = false;
        goto L28
    L13:
        if (b.matches(r11) == true) goto L16;
        r4 = false;
        goto L17
    L7:
        r2 = false;
        goto L8
    }
}

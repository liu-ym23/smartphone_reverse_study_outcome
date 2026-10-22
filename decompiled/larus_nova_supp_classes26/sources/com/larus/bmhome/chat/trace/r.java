package com.larus.bmhome.chat.trace;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r {
    public static final boolean a(Message r6) {
        if (r6 != null) goto L5;
        return true;
    L5:
        String r1 = r6.getMessageId();
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        if (Intrinsics.areEqual(r1, "ui-separator") == false) goto L11;
        return true;
    L11:
        if (StringsKt.contains$default(r1, "prompt", false, 2, null) == false) goto L13;
        return true;
    L13:
        if (StringsKt.contains$default(r1, "loading", false, 2, null) == false) goto L15;
        return true;
    L15:
        if (StringsKt.contains$default(r1, "answering", false, 2, null) == false) goto L17;
        return true;
    L17:
        if (com.larus.bmhome.chat.bean.d.H0(r6) == true) goto L34;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        String r7 = r6.getMessageId();
        if (r7 != null) goto L21;
    L23:
        boolean r8 = false;
    L24:
        if (r8 == false) goto L26;
        return true;
    L26:
        if (StringsKt.contains$default(r1, "fake_message", false, 2, null) == true) goto L36;
        return false;
    L36:
        return true;
    L21:
        if (StringsKt.endsWith$default(r7, "-fix-suggest", false, 2, null) != true) goto L23;
        r8 = true;
        goto L24
    L34:
        return true;
    }

    public static final boolean b(Message r5) {
        if (r5 != null) goto L5;
        return true;
    L5:
        String r6 = r5.getMessageId();
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        if (Intrinsics.areEqual(r6, "ui-separator") == false) goto L11;
        return true;
    L11:
        if (StringsKt.contains$default(r6, "prompt", false, 2, null) == false) goto L13;
        return true;
    L13:
        if (StringsKt.contains$default(r6, "loading", false, 2, null) == false) goto L15;
        return true;
    L15:
        if (StringsKt.contains$default(r6, "answering", false, 2, null) == false) goto L17;
        return true;
    L17:
        if (StringsKt.contains$default(r6, "fake_message", false, 2, null) == true) goto L25;
        return false;
    L25:
        return true;
    }
}

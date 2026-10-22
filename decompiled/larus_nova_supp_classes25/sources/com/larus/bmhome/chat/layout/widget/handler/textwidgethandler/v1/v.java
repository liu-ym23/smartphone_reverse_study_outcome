package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v {
    public static final a a(lw8.g r11) {
        Intrinsics.checkNotNullParameter(r11, "span");
        Uri r0 = UriProtector.parse(r11.a());
        String r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        Set<String> r3 = com.larus.bmhome.chat.list.trace.a.a;     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L13
        JSONObject r4 = com.larus.bmhome.chat.list.trace.a.b(r0);     // Catch: Throwable -> L13
        String r5 = UriProtector.getQueryParameter(r0, "inline_doc_id");     // Catch: Throwable -> L13
        if (r5 != null) goto L34;
        r5 = r4.optString("doc_id");     // Catch: Throwable -> L13
    L34:
        String r6 = r4.optString("inline_display_position");     // Catch: Throwable -> L11
        r1 = r4.optString("doc_position");     // Catch: Throwable -> L9
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        String r7 = r5;
        String r8 = r1;
    L16:
        String r9 = r6;
        if (new Regex("^\\[\\d{1,2}\\]$").matches(r11.getTitle()) == false) goto L21;
        String r10 = "number";
    L19:
        String r12 = r10;
        if (new Regex("^\\[\\d{1,2}\\]$").matches(r11.getTitle()) == false) goto L29;
        String r13 = StringsKt.trim(r11.getTitle(), new char[]{'[', ']'});
    L33:
        return new a(r12, r13, r7, r8, r9);
    L29:
        if (Intrinsics.areEqual(r11.getTitle(), "[__LINK_ICON]") == false) goto L31;
        r13 = "";
        goto L33
    L31:
        r13 = StringsKt.trim(StringsKt.trim(r11.getTitle(), new char[]{'[', ']'}), new char[]{'(', ')'});
        goto L33
    L21:
        if (Intrinsics.areEqual(r11.getTitle(), "[__LINK_ICON]") == false) goto L23;
        r10 = "link";
        goto L19
    L23:
        r10 = "icon";
    L9:
        Throwable th = th;
        String r14 = r1;
        r1 = r5;
        String r15 = r14;
    L15:
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        r8 = r15;
        r7 = r1;
    L11:
        th = th;
        r6 = null;
        r1 = r5;
        r15 = null;
    L13:
        th = move-exception;
        th = th;
        r15 = null;
        r6 = null;
        goto L15
    }

    public static final String b(String r14) {
        Intrinsics.checkNotNullParameter(r14, "tableContent");
        if (r14.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "";
    L9:
        StringBuilder r1 = new StringBuilder();
        Regex r3 = new Regex("\\[(.*?)]\\((.*?)\\)");
        Iterator r15 = StringsKt.split$default(r14, new String[]{"\n"}, false, 0, 6, null).iterator();
    L11:
        if (r15.hasNext() == false) goto L35;
        List r6 = StringsKt.split$default(StringsKt.trim((String) r15.next()).toString(), new String[]{"|"}, false, 0, 6, null);
        Iterator r7 = r6.iterator();
        int r8 = 0;
    L14:
        if (r7.hasNext() == false) goto L33;
        Object r9 = r7.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        String r11 = (String) r9;
        if (r11.length() <= 0) goto L21;
        boolean r12 = true;
    L22:
        if (r12 == false) goto L30;
        if (StringsKt.startsWith$default(r11, "<data-", false, 2, null) == true) goto L30;
        if (r3.containsMatchIn(r11) == false) goto L28;
        r11 = r3.replace(r11, new u());
    L28:
        r1.append(r11);
    L30:
        if (r8 == (r6.size() - 1)) goto L32;
        r1.append("|");
    L32:
        r8 = r10;
        goto L14
    L21:
        r12 = false;
        goto L22
    L33:
        r1.append("\n");
        goto L11
    L35:
        return r1.toString();
    L5:
        r0 = false;
        goto L6
    }
}

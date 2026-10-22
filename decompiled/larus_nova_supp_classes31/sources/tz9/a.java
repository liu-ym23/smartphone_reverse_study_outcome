package tz9;

import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.im.bean.message.Message;
import dp8.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final String a(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Map r0 = r5.getExt();
        Integer r1 = null;
        if (r0 == null) goto L5;
        String r2 = (String) r0.get("ai_create_show_mode");
    L6:
        String r3 = "";
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        if (r2.length() != 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L39;
        int r6 = r5.getContentType();
        if (r6 != 6) goto L17;
    L36:
        r3 = "pure";
    L38:
        return r3;
    L17:
        if (r6 == 2021) goto L36;
        if (r6 != 2022) goto L38;
        CreationMsgContentData r7 = e.c(r5);
        if (r7 == null) goto L26;
        CreationInfo r8 = r7.creationInfo;
        if (r8 == null) goto L26;
        r1 = r8.layoutType;
    L26:
        if (r1 != null) goto L29;
    L31:
        if (r1 == null) goto L38;
        if (r1.intValue() != 2) goto L38;
        r3 = "two_part";
        goto L38
    L29:
        if (r1.intValue() != 1) goto L31;
        r3 = "mixed";
        goto L38
    L39:
        return r2;
    L12:
        r4 = false;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public static final String b(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getExt();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (String) r2.get("ai_creation_tool_list");
    }
}

package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static void a(String r5, ChatHitPointExtraParams.Occasion r6, Map<String, PreviewHangPoint> r7) {
        ChatHitPointExtraParams.Click r0 = ChatHitPointExtraParams.Click.OPEN_URL;
        String r1 = "none";
        if (r7 != null) goto L5;
        com.ss.android.lark.statistics.chat.o r8 = new com.ss.android.lark.statistics.chat.o("none");
        ChatHitPointExtraParams.IsSucceedParse r2 = ChatHitPointExtraParams.IsSucceedParse.NONE;
    L26:
        if (TextUtils.isEmpty(r5) == true) goto L35;
        int r3 = fkb.a.a;
        if (TextUtils.isEmpty(r5) == true) goto L34;
        int r4 = r5.indexOf("?");
        if (r4 == (-1)) goto L34;
        r5 = r5.substring(0, r4);
    L34:
        r1 = r5;
    L35:
        com.ss.android.lark.statistics.chat.n r9 = new com.ss.android.lark.statistics.chat.n(r1);
        ChatHitPointExtraParams.Target r10 = ChatHitPointExtraParams.Target.NONE;
        if (r6 != null) goto L38;
        r6 = ChatHitPointExtraParams.Occasion.MSG;
    L38:
        s5c.d r11 = r0.plus(r8).plus(r9).plus(r6).plus(r2).plus(r10);
        Lazy r12 = ChatHitPointNew.a;
        Intrinsics.checkNotNullParameter(r11, "param");
        ChatHitPointNew.d().sendEvent("im_url_parse_click", r11.plus(ChatParamUtils.e()).toJson());
        return;
    L5:
        Iterator<PreviewHangPoint> r13 = r7.values().iterator();
    L6:
        String r14 = null;
        if (r13.hasNext() == false) goto L11;
        PreviewHangPoint r15 = r13.next();
        if (TextUtils.equals(r15.getUrl(), r5) == false) goto L6;
    L12:
        if (r15 != null) goto L14;
        r8 = new com.ss.android.lark.statistics.chat.o("none");
        r2 = ChatHitPointExtraParams.IsSucceedParse.NONE;
        goto L26
    L14:
        String r16 = r15.getPreviewId();
        if (TextUtils.isEmpty(r16) == false) goto L17;
        r16 = "none";
    L17:
        com.ss.android.lark.statistics.chat.o r17 = new com.ss.android.lark.statistics.chat.o(r16);
        if (r15.getUrlCardPreviewEntity() == null) goto L21;
        r14 = r15.getUrlCardPreviewEntity().getInlineEntity().getTitle();
    L21:
        if (TextUtils.isEmpty(r14) == false) goto L23;
        ChatHitPointExtraParams.IsSucceedParse r18 = ChatHitPointExtraParams.IsSucceedParse.FALSE;
    L24:
        r2 = r18;
        r8 = r17;
        goto L26
    L23:
        r18 = ChatHitPointExtraParams.IsSucceedParse.TRUE;
        goto L24
    L11:
        r15 = null;
        goto L12
    }
}

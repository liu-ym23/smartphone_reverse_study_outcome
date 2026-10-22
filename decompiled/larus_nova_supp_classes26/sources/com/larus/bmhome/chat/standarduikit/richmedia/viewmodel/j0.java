package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VideoData;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tx9.c2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j0 {
    public static final String a(Message r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Map r0 = r6.getExt();
        boolean r1 = true;
        if (r0 == null) goto L16;
        String r2 = (String) r0.get("req_id");
        if (r2 == null) goto L16;
        if (r2.length() <= 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L16;
        return r2;
    L9:
        r5 = false;
    L16:
        String r7 = (String) com.larus.im.bean.message.a.U(r6).get("req_id");
        if (r7 != null) goto L19;
        return null;
    L19:
        if (r7.length() > 0) goto L22;
        r1 = false;
    L22:
        if (r1 == true) goto L24;
        return null;
    L24:
        return r7;
    }

    public static final i0 b(fn8.c r11, Message r12, String r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "message");
        String r2 = r12.getReplyId();
        if (r2 != null) goto L5;
        String r4 = "";
    L6:
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Map r0 = com.larus.im.bean.message.a.U(r12);
        Set r3 = c2.a;
        boolean r5 = false;
        if (r0 == null) goto L13;
        String r1 = (String) r0.get("agent_mode");
        if (r1 == null) goto L13;
        Integer r6 = StringsKt.toIntOrNull(r1);
        if (r6 == null) goto L13;
        int r7 = r6.intValue();
    L14:
        fn8.b r8 = r11.h;
        boolean r9 = r8 instanceof fn8.b.d;
        if (r9 == false) goto L17;
    L28:
        String r10 = "search";
    L29:
        if (r13 != null) goto L32;
        r13 = "";
    L32:
        if (r9 == false) goto L41;
        fn8.b.d r15 = (fn8.b.d) r8;
        Long r16 = r15.a.id;
        if (r16 == null) goto L37;
        String r17 = r16.toString();
        if (r17 == null) goto L37;
    L117:
        fn8.b r18 = r11.h;
        if ((r18 instanceof fn8.b.d) == false) goto L121;
        String r19 = ((fn8.b.d) r18).a.docId;
    L136:
        String r20 = r19;
    L139:
        return new i0(r4, r7, r10, r13, r17, r20, a(r12));
    L121:
        if ((r18 instanceof fn8.b.e) == false) goto L124;
        r19 = ((fn8.b.e) r18).a.itemId;
        goto L136
    L124:
        if ((r18 instanceof fn8.b.a) == false) goto L127;
    L137:
        r20 = null;
        goto L139
    L127:
        if ((r18 instanceof fn8.b.C0108b) == false) goto L132;
        Map r110 = ((fn8.b.C0108b) r18).a.extra;
        if (r110 == null) goto L137;
        r19 = (String) r110.get("doc_id");
        goto L136
    L132:
        if ((r18 instanceof fn8.b.c) == false) goto L141;
        Map r111 = ((fn8.b.c) r18).a.extra;
        if (r111 == null) goto L137;
        r19 = (String) r111.get("doc_id");
        goto L136
    L141:
        throw new NoWhenBranchMatchedException();
    L37:
        r17 = r15.a.itemId;
        if (r17 != null) goto L117;
        r17 = r11.a;
        goto L117
    L41:
        if ((r8 instanceof fn8.b.e) == false) goto L50;
        fn8.b.e r21 = (fn8.b.e) r8;
        Long r112 = r21.a.id;
        if (r112 == null) goto L46;
        r17 = r112.toString();
        if (r17 != null) goto L117;
    L46:
        r17 = r21.a.itemId;
        if (r17 != null) goto L117;
        r17 = r11.a;
        goto L117
    L50:
        if ((r8 instanceof fn8.b.a) == false) goto L108;
        CreationItem r22 = ((fn8.b.a) r8).a;
        String r23 = r11.a;
        String r24 = r22.id;
        if (r24 != null) goto L106;
        Integer r25 = r22.type;
        if (r25 != null) goto L57;
    L70:
        if (r25 == null) goto L101;
        if (r25.intValue() != 2) goto L101;
        VideoData r113 = r22.video;
        if (r113 == null) goto L86;
        r17 = r113.vid;
        if (r17 == null) goto L86;
        if (r17.length() <= 0) goto L81;
        boolean r26 = true;
    L82:
        if (r26 == true) goto L85;
        r17 = null;
    L85:
        if (r17 != null) goto L117;
    L81:
        r26 = false;
    L86:
        VideoData r114 = r22.video;
        if (r114 == null) goto L97;
        Cover r115 = r114.cover;
        if (r115 == null) goto L97;
        r17 = r115.key;
        if (r17 == null) goto L97;
        if (r17.length() <= 0) goto L95;
        r5 = true;
    L95:
        if (r5 == false) goto L97;
    L98:
        if (r17 != null) goto L117;
    L105:
        r17 = r23;
    L97:
        r17 = null;
    L101:
        if (r23.length() != 0) goto L103;
        r5 = true;
    L103:
        if (r5 == false) goto L105;
        r23 = "creation-" + (r14 - 1);
        goto L105
    L57:
        if (r25.intValue() != 1) goto L70;
        ImageData r116 = r22.image;
        if (r116 == null) goto L105;
        r17 = r116.key;
        if (r17 == null) goto L105;
        if (r17.length() <= 0) goto L65;
        r5 = true;
    L65:
        if (r5 == true) goto L68;
        r17 = null;
    L68:
        if (r17 != null) goto L117;
    L106:
        r17 = r24;
        goto L117
    L108:
        if ((r8 instanceof fn8.b.C0108b) == false) goto L113;
        r17 = ((fn8.b.C0108b) r8).a.id;
        if (r17 != null) goto L117;
        r17 = r11.a;
        goto L117
    L113:
        if ((r8 instanceof fn8.b.c) == false) goto L143;
        r17 = ((fn8.b.c) r8).a.id;
        if (r17 != null) goto L117;
        r17 = r11.a;
        goto L117
    L143:
        throw new NoWhenBranchMatchedException();
    L17:
        if ((r8 instanceof fn8.b.e) == true) goto L28;
        if ((r8 instanceof fn8.b.C0108b) == true) goto L28;
        if ((r8 instanceof fn8.b.c) == true) goto L28;
        if ((r8 instanceof fn8.b.a) == false) goto L27;
        r10 = "generate";
        goto L29
    L27:
        throw new NoWhenBranchMatchedException();
    L13:
        r7 = 0;
        goto L14
    L5:
        r4 = r2;
        goto L6
    }
}

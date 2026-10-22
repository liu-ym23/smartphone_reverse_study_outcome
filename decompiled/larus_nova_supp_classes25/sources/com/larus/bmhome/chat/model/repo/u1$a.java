package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.callback.IIMCallback;
import com.larus.platform.model.upload.UploadDataType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u1$a {
    public static /* synthetic */ void a(u1 r9, String r10, List r11, String r12, String r13) {
        r9.k(r10, r11, r12, true, r13, null, true, null);
    }

    public static /* synthetic */ void c(u1 r10, Message r11, String r12, Map r13, ChatPageContext r14) {
        r10.h(r11, r12, r13, false, null, null, null, r14, null);
    }

    public static /* synthetic */ void g(u1 r6, String r7, String r8, NestedFileContent r9, IIMCallback r10) {
        r6.v(r7, r8, r9, new LinkedHashMap(), r10);
    }

    public static /* synthetic */ void d(u1 r6, String r7, ic8.w r8, Message r9, boolean r10, int r11) {
        if ((r11 & 16) == 0) goto L5;
        boolean r5 = true;
    L6:
        r6.e(r7, r8, r9, null, r5);
        return;
    L5:
        r5 = r10;
        goto L6
    }

    public static /* synthetic */ void b(u1 r14, String r15, NestedFileContent r16, String r17, wc9.e r18, String r19, Map r20, ReferenceInfo r21, ChatPageContext r22, Function1 r23, int r24) {
        if ((r24 & 64) == 0) goto L5;
        LinkedHashMap r10 = new LinkedHashMap();
    L7:
        if ((r24 & 128) == 0) goto L9;
        ReferenceInfo r11 = null;
    L10:
        r14.b(r15, r16, r17, r18, r19, r20, r10, r11, r22, r23);
        return;
    L9:
        r11 = r21;
        goto L10
    L5:
        r10 = null;
        goto L7
    }

    public static /* synthetic */ void e(u1 r13, wc9.e r14, String r15, String r16, List r17, String r18, IIMCallback r19, boolean r20, boolean r21, Long r22, int r23) {
        if ((r23 & 32) == 0) goto L5;
        IIMCallback r9 = null;
    L7:
        if ((r23 & 64) == 0) goto L9;
        boolean r10 = false;
    L11:
        if ((r23 & 128) == 0) goto L13;
        boolean r11 = true;
    L15:
        if ((r23 & 256) == 0) goto L17;
        Long r12 = null;
    L18:
        r13.f(r14, r15, r16, r17, r18, r9, r10, r11, r12);
        return;
    L17:
        r12 = r22;
        goto L18
    L13:
        r11 = r21;
        goto L15
    L9:
        r10 = r20;
        goto L11
    L5:
        r9 = r19;
        goto L7
    }

    public static /* synthetic */ void h(u1 r15, String r16, String r17, UploadDataType r18, Function1 r19, Function1 r20, Function1 r21, String r22, Boolean r23, mr9.c r24, String r25, FlowResourceScene r26, String r27, int r28) {
        if ((r28 & 256) == 0) goto L5;
        String r9 = null;
    L7:
        if ((r28 & 512) == 0) goto L9;
        Boolean r10 = null;
    L11:
        if ((r28 & 1024) == 0) goto L13;
        mr9.c r11 = null;
    L15:
        if ((r28 & 2048) == 0) goto L17;
        String r12 = null;
    L19:
        if ((r28 & 4096) == 0) goto L21;
        FlowResourceScene r13 = null;
    L23:
        if ((r28 & 8192) == 0) goto L25;
        String r14 = null;
    L26:
        r15.u(r16, r17, r18, r19, r20, r21, false, null, r9, r10, r11, r12, r13, r14);
        return;
    L25:
        r14 = r27;
        goto L26
    L21:
        r13 = r26;
        goto L23
    L17:
        r12 = r25;
        goto L19
    L13:
        r11 = r24;
        goto L15
    L9:
        r10 = r23;
        goto L11
    L5:
        r9 = r22;
        goto L7
    }

    public static /* synthetic */ void f(u1 r16, String r17, String r18, String r19, Map r20, Function2 r21, MessageStatus r22, String r23, boolean r24, ReferenceInfo r25, String r26, String r27, ChatPageContext r28, Long r29, boolean r30, int r31) {
        if ((r31 & 16) == 0) goto L5;
        Map r5 = null;
    L7:
        if ((r31 & 32) == 0) goto L9;
        Function2 r6 = null;
    L11:
        if ((r31 & 64) == 0) goto L13;
        MessageStatus r7 = null;
    L15:
        if ((r31 & 128) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r31 & 256) == 0) goto L21;
        boolean r9 = true;
    L23:
        if ((r31 & 512) == 0) goto L25;
        ReferenceInfo r10 = null;
    L27:
        if ((r31 & 2048) == 0) goto L29;
        String r12 = null;
    L31:
        if ((r31 & 4096) == 0) goto L33;
        ChatPageContext r13 = null;
    L35:
        if ((r31 & 8192) == 0) goto L37;
        Long r14 = null;
    L39:
        if ((r31 & 16384) == 0) goto L41;
        boolean r15 = true;
    L42:
        r16.s(r17, r18, r19, null, r5, r6, r7, r8, r9, r10, r26, r12, r13, r14, r15);
        return;
    L41:
        r15 = r30;
        goto L42
    L37:
        r14 = r29;
        goto L39
    L33:
        r13 = r28;
        goto L35
    L29:
        r12 = r27;
        goto L31
    L25:
        r10 = r25;
        goto L27
    L21:
        r9 = r24;
        goto L23
    L17:
        r8 = r23;
        goto L19
    L13:
        r7 = r22;
        goto L15
    L9:
        r6 = r21;
        goto L11
    L5:
        r5 = r20;
        goto L7
    }
}

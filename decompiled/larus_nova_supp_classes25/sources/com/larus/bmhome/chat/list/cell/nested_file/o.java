package com.larus.bmhome.chat.list.cell.nested_file;

import android.content.Context;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.api.k0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.service.ICreationReportService;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o implements Function1 {
    public final /* synthetic */ NewNestedFileCell a;

    public /* synthetic */ o(NewNestedFileCell r1) {
        this.a = r1;
    }

    public final Object invoke(Object r26) {
        NewNestedFileCell r1 = this.a;
        Message r2 = (Message) r26;
        int r3 = NewNestedFileCell.s;
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.getClass();
        q0 r4 = lf8.a.b(r1);
        String r5 = null;
        if (r4 == null) goto L9;
        k0 r6 = r4.Q7();
        if (r6 == null) goto L9;
        com.larus.bmhome.chat.component.trace.z r7 = (com.larus.bmhome.chat.component.trace.z) r6.invoke();
        if (r7 == null) goto L9;
        Set r8 = r7.OM();
    L10:
        String r9 = r2.getMessageId();
        if (r8 != null) goto L13;
    L15:
        boolean r10 = false;
    L16:
        if (r10 == false) goto L46;
        if (r9 != null) goto L19;
        r9 = "";
    L19:
        r8.add(r9);
        hy9.d r11 = ICreationReportService.a.j();
        Context r12 = lf8.a.getContext(r1);
        if (r12 == null) goto L22;
        String r13 = r12.getString(2131906331);
    L23:
        BotModel r14 = r1.f;
        if (r14 == null) goto L26;
        String r15 = r14.getBotId();
    L27:
        Pair r16 = r1.t();
        if (r16 == null) goto L36;
        z0 r17 = (z0) r16.getFirst();
        if (r17 == null) goto L36;
        com.larus.bmhome.actionbar.model.r r18 = r17.q;
        if (r18 == null) goto L36;
        Integer r19 = r18.a;
        if (r19 == null) goto L36;
        String r110 = r19.toString();
    L37:
        Pair r20 = r1.t();
        if (r20 == null) goto L44;
        z0 r21 = (z0) r20.getFirst();
        if (r21 == null) goto L44;
        com.larus.bmhome.actionbar.model.r r22 = r21.q;
        if (r22 == null) goto L44;
        r5 = r22.g;
    L44:
        ChatControlTrace r23 = ChatControlTrace.b;
        r23.getClass();
        hy9.d.a.b(r11, r13, null, null, "picture_overview", "single_function", r15, null, r110, r5, r23.bb(ChatControlTrace.y), null, null, null, null, null, null, null, null, 1047622);
    L36:
        r110 = null;
        goto L37
    L26:
        r15 = null;
        goto L27
    L22:
        r13 = null;
    L46:
        return Unit.INSTANCE;
    L13:
        if (CollectionsKt.contains(r8, r9) == true) goto L15;
        r10 = true;
    L9:
        r8 = null;
        goto L10
    }
}

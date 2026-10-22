package com.larus.doc.impl.chat;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.IMessageExtService;
import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import va8.d0;
import va8.l0;
import va8.r;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/doc/impl/chat/DocMessageExtServiceImpl;", "Lcom/larus/bmhome/chat/api/IMessageExtService;", "<init>", "()V", "setSendMessageExt", "", "map", "", "", FlowProtocolAbility.FEATURE_CONVERSATION, "Lcom/larus/im/bean/conversation/Conversation;", "metadata", "Lcom/larus/bmhome/chat/api/IMessageExtService$QueryData;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocMessageExtServiceImpl implements IMessageExtService {
    public static final Map<String, String> a = null;

    public static final class a {
    }

    public DocMessageExtServiceImpl() {
    }

    public final String service() {
        return "";
    }

    static {
        a = new LinkedHashMap();
    }

    public final void b(Map r1, IMessageExtService.a r2) {
        Intrinsics.checkNotNullParameter(r1, "map");
    }

    public final void a(Map<String, String> r4, e r5, IMessageExtService.a r6) {
        Intrinsics.checkNotNullParameter(r4, "map");
        Fragment r7 = com.larus.doc.impl.chat.a.a();
        if (r7 == null) goto L9;
        t1a.b r8 = s1a.a.g(r7);
        if (r8 == null) goto L9;
        r r9 = r8.getAbility(r.class);
        if (r9 == null) goto L9;
        String r10 = r9.WE();
    L10:
        boolean r0 = false;
        if (r10 == null) goto L25;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (Intrinsics.areEqual(r10, "doc_ai_edit") == false) goto L15;
    L22:
        boolean r2 = true;
    L23:
        if (r2 != true) goto L25;
        r0 = true;
        goto L25
    L15:
        if (Intrinsics.areEqual(r10, "doc_create_list") == true) goto L22;
        if (Intrinsics.areEqual(r10, "doc_create_empty") == true) goto L22;
        if (Intrinsics.areEqual(r10, "doc_exist_content") == true) goto L22;
        r2 = false;
    L25:
        if (r0 == true) goto L28;
        FLogger.a.i("DocMessageExtServiceImpl", "It is not doc scene, just return, scene=" + r10);
        return;
    L28:
        Map<String, String> r11 = a;
        if ((!r11.isEmpty()) == false) goto L31;
        r4.putAll(r11);
    L31:
        Fragment r12 = com.larus.doc.impl.chat.a.a();
        if (r12 == null) goto L38;
        t1a.b r13 = s1a.a.g(r12);
        if (r13 == null) goto L38;
        g39.a r14 = r13.getAbility(g39.a.class);
        if (r14 == null) goto L38;
        r14.u2(r4);
    L38:
        Fragment r15 = com.larus.doc.impl.chat.a.a();
        if (r15 == null) goto L45;
        t1a.b r16 = s1a.a.g(r15);
        if (r16 == null) goto L45;
        l0 r17 = r16.getAbility(l0.class);
        if (r17 == null) goto L45;
        r17.D7(r4, null);
    L45:
        Fragment r18 = com.larus.doc.impl.chat.a.a();
        if (r18 == null) goto L52;
        t1a.b r20 = s1a.a.g(r18);
        if (r20 == null) goto L52;
        r r21 = r20.getAbility(r.class);
        if (r21 == null) goto L52;
        r21.GS(r4);
    L52:
        Fragment r22 = com.larus.doc.impl.chat.a.a();
        if (r22 == null) goto L60;
        t1a.b r23 = s1a.a.g(r22);
        if (r23 == null) goto L61;
        d0 r24 = r23.getAbility(d0.class);
        if (r24 == null) goto L62;
        r24.Z4();
        return;
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L9:
        r10 = null;
        goto L10
    }
}

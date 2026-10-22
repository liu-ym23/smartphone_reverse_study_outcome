package rj8;

import com.larus.bmhome.chat.ChatParam;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.a {
    public final /* synthetic */ d a;

    @Override // com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.a
    public final void a() {
        b r0 = this.a.b;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public c(d r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.a
    public final void b(String r42, String r43, String r44, String r45, int r46) {
        Intrinsics.checkNotNullParameter(r42, "cardType");
        d r1 = this.a;
        r1.getClass();
        ri8.c r2 = ri8.c.a;
        a r3 = r1.a;
        if (r3 == null) goto L7;
        Message r4 = r3.b;
        if (r4 == null) goto L7;
        String r5 = r4.getMessageId();
    L8:
        a r6 = r1.a;
        if (r6 == null) goto L13;
        Message r7 = r6.b;
        if (r7 == null) goto L13;
        String r8 = r7.getConversationId();
    L14:
        StringBuilder r9 = new StringBuilder();
        a r10 = r1.a;
        if (r10 == null) goto L19;
        Message r11 = r10.b;
        if (r11 == null) goto L19;
        String r12 = r11.getMessageId();
    L20:
        r9.append(r12);
        r9.append('_');
        a r13 = r1.a;
        if (r13 == null) goto L23;
        Integer r14 = Integer.valueOf(r13.e);
    L24:
        r9.append(r14);
        r9.append("_code");
        String r15 = r9.toString();
        a r16 = r1.a;
        if (r16 == null) goto L31;
        Function0<ChatParam> r17 = r16.i;
        if (r17 == null) goto L31;
        ChatParam r18 = (ChatParam) r17.invoke();
        if (r18 == null) goto L31;
        String r30 = r18.e;
    L32:
        a r19 = r1.a;
        if (r19 == null) goto L35;
        String r20 = r19.a;
    L37:
        if (r20 != null) goto L39;
        String r110 = "";
    L40:
        if (r19 == null) goto L44;
        boolean r21 = true;
        if (r19.q != true) goto L44;
    L45:
        if (r21 == false) goto L47;
        String r22 = "thinking_progress";
    L48:
        String r111 = r22;
        String r33 = r1.b();
        if (r43 != null) goto L51;
        String r34 = "";
    L52:
        a r23 = r1.a;
        if (r23 == null) goto L55;
        Function0<Map<String, Object>> r36 = r23.k;
    L56:
        ri8.c.m(r15, r5, r8, null, r33, null, Integer.valueOf(r46), null, r111, null, r42, r110, null, null, r34, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r30, null, null, r45, r44, null, r36, null, null, -536890712, 52);
        return;
    L55:
        r36 = null;
        goto L56
    L51:
        r34 = r43;
        goto L52
    L47:
        r22 = "within_text";
    L44:
        r21 = false;
        goto L45
    L39:
        r110 = r20;
        goto L40
    L35:
        r20 = null;
    L31:
        r30 = null;
        goto L32
    L23:
        r14 = null;
    L19:
        r12 = null;
    L13:
        r8 = null;
    L7:
        r5 = null;
        goto L8
    }

    @Override // com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.a
    public final void c(String r43, String r44, String r45, String r46, int r47, Boolean r48, Long r49) {
        Intrinsics.checkNotNullParameter(r45, "cardId");
        Intrinsics.checkNotNullParameter(r46, "status");
        ri8.c r1 = ri8.c.a;
        a r2 = this.a.a;
        if (r2 == null) goto L7;
        Message r3 = r2.b;
        if (r3 == null) goto L7;
        String r4 = r3.getMessageId();
    L8:
        a r5 = this.a.a;
        if (r5 == null) goto L13;
        Message r6 = r5.b;
        if (r6 == null) goto L13;
        String r7 = r6.getConversationId();
    L14:
        a r8 = this.a.a;
        if (r8 == null) goto L21;
        Function0<ChatParam> r9 = r8.i;
        if (r9 == null) goto L21;
        ChatParam r10 = (ChatParam) r9.invoke();
        if (r10 == null) goto L21;
        String r31 = r10.e;
    L22:
        d r11 = this.a;
        a r12 = r11.a;
        if (r12 == null) goto L25;
        String r13 = r12.a;
    L26:
        if (r13 != null) goto L28;
        r13 = "";
    L28:
        String r26 = r13;
        if (r12 == null) goto L33;
        boolean r14 = true;
        if (r12.q != true) goto L33;
    L34:
        if (r14 == false) goto L36;
        String r15 = "thinking_progress";
    L37:
        String r16 = r15;
        String r17 = r11.b();
        a r18 = this.a.a;
        if (r18 == null) goto L40;
        Function0<Map<String, Object>> r38 = r18.k;
    L41:
        ri8.c.n(null, r45, r4, r7, null, r17, null, Integer.valueOf(r47), null, r16, null, r43, r26, null, null, null, null, null, null, null, null, null, null, null, r46, null, null, null, null, r31, null, null, r44, r48, r49, null, r38, null, -553654959, 40);
        return;
    L40:
        r38 = null;
        goto L41
    L36:
        r15 = "within_text";
    L33:
        r14 = false;
        goto L34
    L25:
        r13 = null;
    L21:
        r31 = null;
    L13:
        r7 = null;
    L7:
        r4 = null;
        goto L8
    }
}

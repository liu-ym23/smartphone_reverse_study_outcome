package wh8;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.showcase.Case;
import com.larus.utils.p0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final e a;
    public BotModel b;
    public Message c;
    public String d;
    public final String e;
    public final RecommendFrom f;
    public final Integer g;
    public final String h;
    public final IconImage i;
    public final Integer j;
    public final Case k;
    public final boolean l;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        e r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        BotModel r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Message r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        RecommendFrom r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        IconImage r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Case r31 = this.k;
        if (r31 == null) goto L46;
        r1 = r31.hashCode();
    L46:
        int r32 = (r30 + r1) * 31;
        if (this.l == false) goto L49;
        int r33 = 1231;
    L51:
        return r32 + r33;
    L49:
        r33 = 1237;
        goto L51
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConversationData(conversation=" + this.a + ", botModel=" + this.b + ", message=" + this.c + ", senderName=" + this.d + ", requestId=" + this.e + ", recommendFrom=" + this.f + ", recommendBotType=" + this.g + ", relatedCvsId=" + this.h + ", secondIconImage=" + this.i + ", loadMoreStatus=" + this.j + ", caseData=" + this.k + ", isLoadingFooter=" + this.l + ')';
    }

    public final String b() {
        e r0 = this.a;
        boolean r1 = false;
        if (r0 == null) goto L10;
        Integer r2 = r0.v;
        if (r2 == null) goto L10;
        if (r2.intValue() != 6) goto L10;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L23;
        int r4 = p0.a;
        String r5 = p0.a(this.a.c);
        if (r5 == null) goto L16;
        return r5;
    L16:
        BotModel r6 = this.b;
        if (r6 == null) goto L19;
        String r7 = r6.getName();
    L20:
        String r8 = p0.a(r7);
        if (r8 == null) goto L23;
        return r8;
    L19:
        r7 = null;
    L23:
        BotModel r9 = this.b;
        if (r9 == null) goto L31;
        Integer r10 = r9.getBotType();
        if (r10 == null) goto L31;
        if (r10.intValue() != 4) goto L31;
        r1 = true;
    L31:
        if (r1 == false) goto L39;
        int r11 = p0.a;
        BotModel r12 = this.b;
        if (r12 == null) goto L35;
        String r13 = r12.getName();
    L36:
        String r14 = p0.a(r13);
        if (r14 == null) goto L39;
        return r14;
    L35:
        r13 = null;
    L39:
        return null;
    L10:
        r3 = false;
        goto L12
    }

    public final boolean c() {
        e r0 = this.a;
        if (r0 == null) goto L10;
        Integer r1 = r0.v;
        if (r1 == null) goto L10;
        if (r1.intValue() != 6) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L25;
        BotModel r3 = this.b;
        if (r3 == null) goto L20;
        Integer r4 = r3.getBotType();
        if (r4 == null) goto L20;
        if (r4.intValue() != 4) goto L20;
        boolean r5 = true;
    L21:
        if (r5 == true) goto L26;
        return false;
    L26:
        return true;
    L20:
        r5 = false;
        goto L21
    L25:
        return true;
    L10:
        r2 = false;
        goto L11
    }

    public final String d() {
        StringBuilder r0 = new StringBuilder("ConversationData{");
        e r1 = this.a;
        Long r4 = null;
        if (r1 == null) goto L10;
        StringBuilder r5 = new StringBuilder("conv(");
        String r6 = r1.c;
        if (r6 == null) goto L7;
        String r7 = StringsKt.take(r6, 4);
    L8:
        r5.append(r7);
        r5.append(",id=");
        r5.append(r1.a);
        r5.append(",status=");
        r5.append(r1.t);
        r5.append(",botType=");
        r5.append(r1.v);
        r5.append(",type=");
        r5.append(r1.j);
        r5.append(",badge=");
        r5.append(r1.l);
        r5.append('_');
        r5.append(r1.m);
        r5.append(",pin=");
        r5.append(r1.e);
        r5.append(",updateTime=");
        r5.append(r1.d);
        r5.append('_');
        r5.append(r1.u);
        r5.append("), ");
        r0.append(r5.toString());
        goto L10
    L7:
        r7 = null;
    L10:
        if (this.b == null) goto L25;
        StringBuilder r2 = new StringBuilder("bot(");
        BotModel r8 = this.b;
        if (r8 == null) goto L14;
        String r9 = r8.getBotId();
    L15:
        r2.append(r9);
        r2.append('_');
        BotModel r10 = this.b;
        if (r10 == null) goto L18;
        Integer r11 = r10.getBotType();
    L19:
        r2.append(r11);
        r2.append('_');
        BotModel r3 = this.b;
        if (r3 == null) goto L22;
        Integer r12 = r3.getBotStatus();
    L23:
        r2.append(r12);
        r2.append("), ");
        r0.append(r2.toString());
        goto L25
    L22:
        r12 = null;
        goto L23
    L18:
        r11 = null;
        goto L19
    L14:
        r9 = null;
    L25:
        if (this.c == null) goto L39;
        StringBuilder r13 = new StringBuilder("msg=(");
        Message r14 = this.c;
        if (r14 == null) goto L29;
        String r15 = r14.getMessageId();
    L30:
        r13.append(r15);
        r13.append(',');
        Message r16 = this.c;
        if (r16 == null) goto L33;
        Integer r17 = Integer.valueOf(r16.getMessageStatusLocal());
    L34:
        r13.append(r17);
        r13.append(',');
        Message r18 = this.c;
        if (r18 == null) goto L37;
        r4 = Long.valueOf(r18.getCreateTime());
    L37:
        r13.append(r4);
        r13.append("), ");
        r0.append(r13.toString());
        goto L39
    L33:
        r17 = null;
        goto L34
    L29:
        r15 = null;
    L39:
        if (this.k == null) goto L41;
        r0.append("caseData, ");
    L41:
        r0.append("}");
        return r0.toString();
    }

    public static a a(a r16, e r17, Message r18, int r19) {
        if ((r19 & 1) == 0) goto L5;
        e r4 = r16.a;
    L7:
        if ((r19 & 2) == 0) goto L9;
        BotModel r5 = r16.b;
    L11:
        if ((r19 & 4) == 0) goto L13;
        Message r6 = r16.c;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r7 = r16.d;
    L19:
        if ((r19 & 16) == 0) goto L21;
        String r8 = r16.e;
    L23:
        if ((r19 & 32) == 0) goto L25;
        RecommendFrom r9 = r16.f;
    L27:
        if ((r19 & 64) == 0) goto L29;
        Integer r10 = r16.g;
    L31:
        if ((r19 & 128) == 0) goto L33;
        String r11 = r16.h;
    L35:
        if ((r19 & 256) == 0) goto L37;
        IconImage r12 = r16.i;
    L39:
        if ((r19 & 512) == 0) goto L41;
        Integer r13 = r16.j;
    L43:
        if ((r19 & 1024) == 0) goto L45;
        Case r14 = r16.k;
    L47:
        if ((r19 & 2048) == 0) goto L49;
        boolean r15 = r16.l;
    L50:
        r16.getClass();
        return new a(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    L49:
        r15 = false;
        goto L50
    L45:
        r14 = null;
        goto L47
    L41:
        r13 = null;
        goto L43
    L37:
        r12 = null;
        goto L39
    L33:
        r11 = null;
        goto L35
    L29:
        r10 = null;
        goto L31
    L25:
        r9 = null;
        goto L27
    L21:
        r8 = null;
        goto L23
    L17:
        r7 = null;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r5 = null;
        goto L11
    L5:
        r4 = r17;
        goto L7
    }

    public a(e r1, BotModel r2, Message r3, String r4, String r5, RecommendFrom r6, Integer r7, String r8, IconImage r9, Integer r10, Case r11, boolean r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
    }

    public /* synthetic */ a(e r17, BotModel r18, Message r19, String r20, String r21, RecommendFrom r22, Integer r23, String r24, IconImage r25, Integer r26, Case r27, boolean r28, int r29) {
        if ((r29 & 2) == 0) goto L5;
        BotModel r5 = null;
    L7:
        if ((r29 & 4) == 0) goto L9;
        Message r6 = null;
    L11:
        if ((r29 & 8) == 0) goto L13;
        String r7 = null;
    L15:
        if ((r29 & 16) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r29 & 32) == 0) goto L21;
        RecommendFrom r9 = null;
    L23:
        if ((r29 & 64) == 0) goto L25;
        Integer r10 = null;
    L27:
        if ((r29 & 128) == 0) goto L29;
        String r11 = null;
    L31:
        if ((r29 & 256) == 0) goto L33;
        IconImage r12 = null;
    L35:
        if ((r29 & 512) == 0) goto L37;
        Integer r13 = null;
    L39:
        if ((r29 & 1024) == 0) goto L41;
        Case r14 = null;
    L43:
        if ((r29 & 2048) == 0) goto L45;
        boolean r15 = false;
    L46:
        this(r17, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        return;
    L45:
        r15 = r28;
        goto L46
    L41:
        r14 = r27;
        goto L43
    L37:
        r13 = r26;
        goto L39
    L33:
        r12 = r25;
        goto L35
    L29:
        r11 = r24;
        goto L31
    L25:
        r10 = r23;
        goto L27
    L21:
        r9 = r22;
        goto L23
    L17:
        r8 = r21;
        goto L19
    L13:
        r7 = r20;
        goto L15
    L9:
        r6 = r19;
        goto L11
    L5:
        r5 = r18;
        goto L7
    }
}

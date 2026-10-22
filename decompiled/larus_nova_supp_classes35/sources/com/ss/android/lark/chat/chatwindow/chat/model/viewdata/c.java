package com.ss.android.lark.chat.chatwindow.chat.model.viewdata;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.time.format.entity.TimePreciseness;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements com.ss.android.lark.chat.core.model.b.a<y6b.c<?>> {
    public final jdb.g a;
    public final int b;
    public final boolean c;
    public m2b.a d;
    public boolean e;
    public boolean f;

    public final boolean d(y6b.c<?> r6) {
        Boolean r0 = ReplyInThreadUtil.a;
        if (r6 != null) goto L6;
    L8:
        boolean r2 = false;
    L9:
        if (r2 == true) goto L11;
    L13:
        m2b.a r3 = this.d;
        if (r3 == null) goto L18;
        if (r3.Y() == false) goto L18;
    L20:
        if (r6 != null) goto L23;
    L25:
        boolean r4 = false;
    L26:
        if (r4 == false) goto L28;
        w4b.c.f r5 = ChatCoreModule.a().getMyAIDependency();
        long r7 = r6.L;
        r5.b();
    L28:
        if (r6 != null) goto L31;
    L33:
        boolean r8 = false;
    L34:
        if (r8 == false) goto L40;
        m2b.a r9 = this.d;
        if (r9 != null) goto L38;
    L39:
        return true;
    L38:
        if (r9.Y() == true) goto L39;
    L40:
        m2b.a r10 = this.d;
        if (r10 == null) goto L45;
        if (r10.Y() == true) goto L45;
    L47:
        return false;
    L45:
        if (r6.Z() == false) goto L47;
        return true;
    L31:
        if (r6.S1 != Message.ThreadMessageType.THREAD_ROOT_MESSAGE) goto L33;
        r8 = true;
        goto L34
    L23:
        if (r6.S1 != Message.ThreadMessageType.THREAD_ROOT_MESSAGE) goto L25;
        r4 = true;
    L18:
        if (r6.d() == false) goto L20;
        return true;
    L11:
        if (r6.T1 <= 0) goto L13;
        return true;
    L6:
        if (r6.S1 != Message.ThreadMessageType.THREAD_ROOT_MESSAGE) goto L8;
        r2 = true;
        goto L9
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void c(List r7, int r8) {
        int r0 = Math.max(0, r8 - 1);
    L3:
        ArrayList r2 = (ArrayList) r7;
        if (r0 >= r2.size()) goto L19;
        int r3 = r0 - 1;
        if (r3 >= 0) goto L8;
        y6b.c r4 = null;
    L9:
        y6b.c r5 = (y6b.c) ListProtector.get(r2, r0);
        if (r0 != (r2.size() - 1)) goto L12;
        boolean r6 = true;
    L14:
        if (f(r4, r5, r6) == false) goto L18;
        if (r0 <= (1 + r8)) goto L18;
        return;
    L18:
        r0 = r0 + 1;
        goto L3
    L12:
        r6 = false;
        goto L14
    L8:
        r4 = (y6b.c) ListProtector.get(r2, r3);
        goto L9
    }

    public c(jdb.g r2, int r3, boolean r4) {
        this.e = true;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static y6b.g e(y6b.c r5, boolean r6, boolean r7) {
        long r1 = r5.m * 1000;
        y6b.g r0 = new y6b.g(r1, r6, r7);
        if (r1 <= 0) goto L5;
        c7c.a r8 = new c7c.a();
        r8.b(DisplayPattern.RELATIVE);
        r8.c(LengthType.LONG);
        ChatCoreModule.a().getTimeFormatDependency().a();
        r8.h = false;
        r8.d(TimePreciseness.MINUTE);
        r8.j = true;
        r0.e = c7c.b.c(UIHelper.getContext(), new Date(r1), r8);
    L5:
        if (r6 == false) goto L7;
        c7c.a r9 = new c7c.a();
        r9.b(DisplayPattern.RELATIVE);
        r9.j = true;
        r0.d = c7c.b.a(UIHelper.getContext(), new Date(r1), r9);
    L7:
        return r0;
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void a(List<y6b.c<?>> r7, int r8, int r9) {
        int r0 = Math.max(0, r8 - 1);
    L3:
        ArrayList r2 = (ArrayList) r7;
        if (r0 >= r2.size()) goto L19;
        int r3 = r0 - 1;
        if (r3 >= 0) goto L8;
        y6b.c r4 = null;
    L9:
        y6b.c r5 = (y6b.c) ListProtector.get(r2, r0);
        boolean r6 = true;
        if (r0 == (r2.size() - 1)) goto L14;
        r6 = false;
    L14:
        if (f(r4, r5, r6) == false) goto L18;
        if (r0 <= (r8 + r9)) goto L18;
        return;
    L18:
        r0 = r0 + 1;
        goto L3
    L8:
        r4 = (y6b.c) ListProtector.get(r2, r3);
        goto L9
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void b(List<y6b.c<?>> r7, int r8, int r9) {
        if (this.e == false) goto L9;
        ArrayList r3 = (ArrayList) r7;
        if (this.b > ((y6b.c) ListProtector.get(r3, r3.size() - 1)).p) goto L7;
        boolean r0 = true;
    L8:
        this.f = r0;
        goto L9
    L7:
        r0 = false;
    L9:
        this.e = false;
        int r1 = Math.max(0, r8 - 1);
    L10:
        ArrayList r4 = (ArrayList) r7;
        if (r1 >= r4.size()) goto L26;
        int r5 = r1 - 1;
        if (r5 >= 0) goto L15;
        y6b.c r6 = null;
    L16:
        y6b.c r10 = (y6b.c) ListProtector.get(r4, r1);
        if (r1 != (r4.size() - 1)) goto L19;
        boolean r11 = true;
    L21:
        if (f(r6, r10, r11) == false) goto L25;
        if (r1 <= (r8 + r9)) goto L25;
        return;
    L25:
        r1 = r1 + 1;
        goto L10
    L19:
        r11 = false;
        goto L21
    L15:
        r6 = (y6b.c) ListProtector.get(r4, r5);
        goto L16
    }

    public final boolean f(y6b.c r18, y6b.c r19, boolean r20) {
        if (r19.isPreMessage() == false) goto L5;
    L11:
        boolean r3 = false;
    L12:
        int r6 = r19.R2;
        if (r18 == null) goto L15;
        long r7 = r18.m;
        long r9 = r19.m;
        boolean r11 = !com.larksuite.framework.utils.e.a(r9 * 1000, 1000 * r7);
        if (this.c == true) goto L22;
    L30:
        boolean r12 = false;
    L32:
        if ((r9 - r7) > 300) goto L112;
        if (r12 == true) goto L112;
        Message.Type r8 = r18.getType();
        Message.Type r10 = Message.Type.SYSTEM;
        if (r8 == r10) goto L37;
        boolean r13 = true;
    L39:
        if (r19.getType() == r10) goto L41;
        boolean r14 = true;
    L42:
        boolean r15 = r18.o.c(r18).equals(r19.o.c(r19));
        if (r13 == false) goto L70;
        if (r14 == false) goto L70;
        if (r15 == false) goto L93;
        boolean r16 = o2b.a.a;
        if (o2b.a.a(this.a) == false) goto L49;
    L51:
        boolean r17 = true;
    L52:
        if (r3 == false) goto L55;
        r17 = false;
    L55:
        if (r18.getType() != Message.Type.UNKNOWN) goto L58;
        r17 = false;
    L58:
        if (r18.U == r19.U) goto L61;
        r17 = false;
    L61:
        if (d(r18) == false) goto L63;
    L64:
        r17 = false;
    L66:
        if (r18.G != null) goto L93;
        if (r19.G != null) goto L93;
    L94:
        if (r17 == false) goto L114;
        boolean r4 = o2b.a.a;
        if (o2b.a.a(this.a) == false) goto L114;
        if (r18.j() == false) goto L103;
        if (r19.j() == true) goto L103;
        r17 = false;
    L111:
        r18.T2 = true;
        r19.T2 = true;
    L103:
        if (r18.j() == true) goto L108;
        if (r19.j() == false) goto L108;
    L110:
        r17 = true;
    L108:
        if (r18.j() == false) goto L110;
        r19.j();
    L114:
        if (r17 == false) goto L130;
        boolean r21 = o2b.a.a;
        if (o2b.a.a(this.a) == false) goto L127;
        r19.Q2 = true;
        r19.R2 = 2;
        if (r18.Q2 == true) goto L124;
        r18.R2 = 1;
        if (r19.j() == false) goto L122;
        r18.R2 = 0;
    L134:
        if (r20 == false) goto L139;
        if (r19.R2 != 2) goto L139;
        r19.R2 = 3;
    L139:
        if (r19.R2 == r6) goto L143;
        return false;
    L143:
        return true;
    L122:
        r19.R2 = 3;
        goto L134
    L124:
        if (r19.j() == false) goto L126;
        r18.R2 = 3;
        goto L134
    L126:
        r18.R2 = 2;
        goto L134
    L127:
        r19.Q2 = true;
        r19.R2 = 2;
        if (r18.Q2 == true) goto L134;
        r18.R2 = 1;
        goto L134
    L130:
        r19.Q2 = false;
        if (r18.Q2 == false) goto L133;
        r18.R2 = 3;
    L133:
        r19.R2 = 0;
        goto L134
    L63:
        if (d(r19) == false) goto L66;
    L49:
        if (TextUtils.isEmpty(r19.R) == true) goto L51;
        r17 = false;
    L93:
        r17 = false;
    L70:
        String r5 = r18.o.c(r18);
        String r22 = r19.o.c(r19);
        if (r18.getType() != r10) goto L78;
        T r23 = r18.o;
        if (r23 == 0) goto L78;
        if ((r23.a instanceof SystemContent) == false) goto L78;
        boolean r24 = false;
    L79:
        if (r24 == false) goto L93;
        if (r19.getType() != r10) goto L88;
        T r25 = r19.o;
        if (r25 == 0) goto L88;
        if ((r25.a instanceof SystemContent) == false) goto L88;
        boolean r26 = false;
    L89:
        if (r26 == false) goto L93;
        if (TextUtils.equals(r5, r22) == false) goto L93;
        r17 = true;
    L88:
        r26 = true;
    L78:
        r24 = true;
        goto L79
    L41:
        r14 = false;
        goto L42
    L37:
        r13 = false;
    L112:
        r17 = false;
        goto L114
    L22:
        if ((r9 - r7) >= 1800) goto L28;
        if (r11 == true) goto L28;
        if (r3 == false) goto L27;
        r19.S2 = e(r19, false, r3);
    L29:
        r12 = true;
        goto L32
    L27:
        r19.S2 = null;
    L28:
        r19.S2 = e(r19, r11, r3);
        goto L29
    L15:
        if (this.c == false) goto L17;
        r19.S2 = e(r19, true, r3);
    L17:
        r19.Q2 = false;
        r19.T2 = true;
        return false;
    L5:
        if (this.f == false) goto L11;
        if (r19.p != this.b) goto L11;
        if (r19.q == false) goto L11;
        r3 = true;
        goto L12
    }
}

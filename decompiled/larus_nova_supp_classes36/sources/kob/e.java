package kob;

import com.ss.android.lark.biz.im.api.extension.keyboard.inputstate.InputStateHandler;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.keyboard.base.n;
import com.ss.android.lark.keyboard.base.o;
import com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor;
import cya.g;
import cya.h;
import cya.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements InputStateHandler<com.ss.android.lark.keyboard.inputstate.c> {
    public final com.ss.android.lark.keyboard.inputstate.a a;
    public final int b;

    public final g<?> a() {
        return new job.c(this.a);
    }

    public final int getCode() {
        return this.b;
    }

    public e(FlowChatKeyboardEditor.b r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.a = r2;
        this.b = 2;
    }

    public final InputStateHandler.TransformResult b(h r14, h r15) {
        com.ss.android.lark.keyboard.inputstate.c r16 = (com.ss.android.lark.keyboard.inputstate.c) r15;
        Intrinsics.checkNotNullParameter(r14, "from");
        Intrinsics.checkNotNullParameter(r16, "to");
        int r0 = r14.a();
        boolean r1 = true;
        if (r0 != 1) goto L5;
        cya.a r2 = (cya.a) ((h) r16).a.a(cya.a.c);
        if (r2 != null) goto L66;
        r2 = cya.a.a.a();
    L66:
        i r3 = (i) ((h) r16).a.a(i.h);
        if (r3 != null) goto L70;
        r3 = i.a.a();
    L70:
        if (r2.b.length() != 0) goto L72;
        boolean r4 = true;
    L73:
        if (r4 == true) goto L75;
    L79:
        r1 = false;
    L80:
        if (r1 == false) goto L83;
        a.b(r14, this.a, r16, false);
    L83:
        return InputStateHandler.TransformResult.KeepTo;
    L75:
        if (com.ss.android.lark.widget.richtext.i.l(r2.a) == true) goto L80;
        if (r3.d == false) goto L79;
    L72:
        r4 = false;
        goto L73
    L5:
        if (r0 != 2) goto L7;
        n r5 = r14.a;
        n.a r6 = i.h;
        i r7 = (i) r5.a(r6);
        if (r7 != null) goto L51;
        r7 = i.a.a();
    L51:
        n r17 = r14.a;
        n.a r8 = cya.a.c;
        cya.a r18 = (cya.a) r17.a(r8);
        if (r18 != null) goto L54;
        r18 = cya.a.a.a();
    L54:
        i r9 = (i) ((h) r16).a.a(r6);
        if (r9 != null) goto L58;
        r9 = i.a.a();
    L58:
        if (ReplyActionUtils.c() == false) goto L89;
        if (Intrinsics.areEqual(r7.a, r9.a) == false) goto L89;
        ((h) r16).a.b(r8, r18);
        r9.e = true;
        ((h) r16).a.b(r6, r9);
        return InputStateHandler.TransformResult.KeepTo;
    L89:
        return InputStateHandler.TransformResult.KeepTo;
    L7:
        if (r0 != 8) goto L84;
        cya.a r10 = (cya.a) ((h) r16).a.a(cya.a.c);
        if (r10 != null) goto L12;
        r10 = cya.a.a.a();
    L12:
        n r11 = ((h) r16).a;
        n.a r12 = i.h;
        i r13 = (i) r11.a(r12);
        if (r13 != null) goto L16;
        r13 = i.a.a();
    L16:
        if (r10.b.length() != 0) goto L18;
        boolean r19 = true;
    L19:
        if (r19 == true) goto L21;
    L25:
        boolean r20 = false;
    L26:
        o r21 = (o) r14.a.a(o.f);
        if (r21 != null) goto L30;
        r21 = new o(0);
    L30:
        if (Intrinsics.areEqual(((h) r16).a.a(com.ss.android.lark.keyboard.inputstate.d.j), Boolean.TRUE) == false) goto L36;
        com.ss.android.lark.keyboard.inputstate.a r22 = this.a;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Intrinsics.checkNotNullParameter(r22, "dependency");
        Intrinsics.checkNotNullParameter(r16, "toState");
        i r23 = (i) r14.a.a(r12);
        if (r23 == null) goto L85;
        a.c(r14, r22, r16, true);
        i r110 = new i(r23.a, r23.b, r23.c, false, false, r23.f, r23.g);
        ((h) r16).a.b(r12, r110);
        r22.l(new n());
    L85:
        return InputStateHandler.TransformResult.KeepTo;
    L36:
        if (r20 == false) goto L87;
        if (r21.d.length() == 0) goto L41;
        r1 = false;
    L41:
        if (r1 == false) goto L87;
        com.ss.android.lark.keyboard.inputstate.a r24 = this.a;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Intrinsics.checkNotNullParameter(r24, "dependency");
        Intrinsics.checkNotNullParameter(r16, "stateToDrop");
        a.a(r14, r24, r16, false);
        i r111 = (i) ((h) r16).a.a(r12);
        if (r111 == null) goto L86;
        r111.d = false;
        r14.a.b(r12, r111);
        r24.u(r111);
    L86:
        return InputStateHandler.TransformResult.KeepFrom;
    L87:
        return InputStateHandler.TransformResult.KeepBoth;
    L21:
        if (com.ss.android.lark.widget.richtext.i.l(r10.a) == false) goto L23;
    L24:
        r20 = true;
        goto L26
    L23:
        if (r13.d == false) goto L25;
    L18:
        r19 = false;
        goto L19
    L84:
        return InputStateHandler.TransformResult.KeepBoth;
    }
}

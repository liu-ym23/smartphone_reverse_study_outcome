package kob;

import com.ss.android.lark.dto.draft.QueryStatusInfo;
import com.ss.android.lark.keyboard.base.n;
import com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import cya.h;
import cya.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final void a(h r6, com.ss.android.lark.keyboard.inputstate.a r7, h r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "dependency");
        Intrinsics.checkNotNullParameter(r8, "stateToDrop");
        n r10 = r8.a;
        n.a r0 = cya.a.c;
        cya.a r11 = (cya.a) r10.a(r0);
        if (r11 != null) goto L5;
        r11 = cya.a.a.a();
    L5:
        String r1 = r11.b;
        RichText r12 = r11.a;
        if (r1.length() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
    L14:
        FlowChatKeyboardEditor r3 = r7.r();
        String r4 = r3.K();
        RichText r5 = ExtensionEditTextCompatKt.b(r3.c());
        if (r9 == false) goto L17;
        String r13 = r4 + r1;
    L18:
        if (r9 == false) goto L20;
        RichText r14 = com.ss.android.lark.widget.richtext.utils.a.b(r5, r12);
    L21:
        r6.a.b(r0, new cya.a(r14, r13));
        i r15 = (i) r6.a.a(i.h);
        if (r15 == null) goto L24;
        r15.d = false;
    L24:
        r7.l(r6.a);
        return;
    L20:
        r14 = com.ss.android.lark.widget.richtext.utils.a.b(r12, r5);
        goto L21
    L17:
        r13 = r1 + r4;
        goto L18
    L11:
        if (com.ss.android.lark.widget.richtext.i.l(r12) == false) goto L14;
        Log.i("ExtInputState", "append input info is empty , method return");
        return;
    L8:
        r2 = false;
        goto L9
    }

    public static final void b(h r1, com.ss.android.lark.keyboard.inputstate.a r2, h r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "dependency");
        Intrinsics.checkNotNullParameter(r3, "toState");
        c(r1, r2, r3, r4);
        i r5 = (i) r3.a.a(i.h);
        if (r5 == null) goto L5;
        r5.d = false;
    L5:
        r2.l(new n());
    }

    public static final void c(h r7, com.ss.android.lark.keyboard.inputstate.a r8, h r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "dependency");
        Intrinsics.checkNotNullParameter(r9, "toState");
        n r0 = r7.a;
        n.a r1 = cya.a.c;
        cya.a r2 = (cya.a) r0.a(r1);
        if (r2 != null) goto L5;
        r2 = cya.a.a.a();
    L5:
        i r3 = (i) r7.a.a(i.h);
        String r4 = r2.b;
        RichText r5 = r2.a;
        boolean r6 = false;
        if (r4.length() != 0) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == true) goto L11;
    L13:
        if (r6 == false) goto L16;
        if (r3 != null) goto L16;
        return;
    L16:
        r7.a.b(r1, cya.a.a.a());
        FlowChatKeyboardEditor r12 = r8.r();
        if (r6 == true) goto L19;
        if (r10 == true) goto L19;
    L20:
        if (r6 == true) goto L22;
        if (r10 == true) goto L22;
    L25:
        cya.a r13 = (cya.a) r9.a.a(r1);
        if (r13 == null) goto L28;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r13.b = r4;
    L28:
        if (r13 == null) goto L30;
        RichText r14 = r13.a;
        Intrinsics.checkNotNull(r5);
        RichText r15 = com.ss.android.lark.widget.richtext.utils.a.b(r14, r5);
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r13.a = r15;
    L30:
        r9.a.b(r1, r13);
        n r16 = r9.a;
        QueryStatusInfo.a r17 = QueryStatusInfo.Companion;
        r16.b(r17, r7.a.a(r17));
        return;
    L22:
        r5 = ExtensionEditTextCompatKt.c(r12.c());
        if (r5 != null) goto L25;
        r5 = com.ss.android.lark.widget.richtext.c.a();
    L19:
        r4 = r12.K();
        goto L20
    L11:
        if (com.ss.android.lark.widget.richtext.i.l(r5) == false) goto L13;
        r6 = true;
        goto L13
    L8:
        r11 = false;
        goto L9
    }
}

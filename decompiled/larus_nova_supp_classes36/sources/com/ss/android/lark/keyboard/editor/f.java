package com.ss.android.lark.keyboard.editor;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.keyboard.base.q;
import com.ss.android.lark.keyboard.editor.input.r;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.statistics.chat.p;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements r {
    public final /* synthetic */ d a;
    public final /* synthetic */ Chat b;

    @Override // com.ss.android.lark.keyboard.editor.input.r
    public final void a() {
        d r0 = this.a;
        FlowChatKeyboardEditor r1 = r0.m;
        if (r1 == null) goto L19;
        Chat r2 = this.b;
        com.ss.android.lark.keyboard.b r3 = r1.J();
        boolean r4 = false;
        if (r3 == null) goto L12;
        cya.d r5 = com.ss.android.lark.keyboard.a.a(r3);
        if (r5 == null) goto L12;
        if (r5.c(4) != true) goto L12;
        r4 = true;
    L12:
        if (r4 == true) goto L14;
    L16:
        String r6 = UIHelper.mustacheFormat(2131890793, "group_name", r2.getName());
    L17:
        Context r7 = r0.getContext();
        Intrinsics.checkNotNull(r6);
        UDToast.show(r7, r6);
        return;
    L14:
        if (r0.e.getChat().isAllowPost() == true) goto L16;
        r6 = UIHelper.mustacheFormat(2131891079, "ChatName", r2.getName());
        goto L17
    }

    @Override // com.ss.android.lark.keyboard.editor.input.r
    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        this.a.e.cancelRecallMessage(r2);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.r
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        this.a.e.recallMsg(r2);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.r
    public final void f(q r4) {
        Intrinsics.checkNotNullParameter(r4, "sendInfo");
        com.ss.android.lark.keyboard.base.r r0 = r4.j;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.t != true) goto L7;
    L8:
        p.b(r1, r4.g, r4.h);
        d r2 = this.a;
        FlowChatKeyboardEditor r3 = r2.m;
        if (r3 == null) goto L12;
        k.a.a(r3.J().e(), d.a.a);
        r2.e.onSendRichText(r4);
        return;
    L12:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public f(d r1, Chat r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.ss.android.lark.keyboard.editor.input.r
    public final void c(Context r3, q r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "sendInfo");
        d r0 = this.a;
        if (r0.m == null) goto L6;
        r0.e.sendAttachments(r3, r4);
        return;
    }

    @Override // com.ss.android.lark.keyboard.editor.input.r
    public final void b(String r9, String r10, RichText r11, s5c.d r12) {
        Intrinsics.checkNotNullParameter(r9, "messageId");
        Intrinsics.checkNotNullParameter(r10, "title");
        Intrinsics.checkNotNullParameter(r11, "richText");
        d r0 = this.a;
        r0.e.reEditMsg(r10, r11, r9, r0.getContext(), r12, null);
    }
}

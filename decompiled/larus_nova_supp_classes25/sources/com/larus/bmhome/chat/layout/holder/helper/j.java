package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j extends a1 {
    public final JSONObject j;
    public final Function0<Unit> k;
    public final Function0<Unit> l;
    public final Function0<Unit> m;
    public final Function0<Unit> n;

    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final void d() {
        tx9.t1.a(null, null, "chat", "assistant", this.a.getMessageId(), Boolean.valueOf(com.larus.bmhome.chat.bean.d.Q0(this.a)), null, null, null, "default", null, "private", null, Boolean.FALSE, "code", null, 76707);
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final void a(com.larus.bmhome.chat.layout.holder.menu.item.a.C0061a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.w());
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.o());
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.y0());
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.h());
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.e());
        r3.a(new o0(this.k));
        r3.a(new q(this.l));
        r3.a(new l2(this.m));
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.k());
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final ef8.b c(final View r15) {
        Intrinsics.checkNotNullParameter(r15, "view");
        return new ef8.b(this.a, this.c, this.b, by7.h.g(r15), new i(r15), null, null, null, null, null, this.j, 2016);
    }

    public j(Message r8, com.larus.bmhome.chat.api.q0 r9, com.larus.bmhome.chat.api.q0.a r10, boolean r11, com.larus.bmhome.chat.markdown.code.g r12, com.larus.bmhome.chat.markdown.code.h r13, com.larus.bmhome.chat.markdown.code.f r14, com.larus.bmhome.chat.markdown.code.i r15) {
        k r4 = new k(r11);
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r4, "popMenuGroupCreator");
        JSONObject r6 = new JSONObject("{}");
        r6.put("content_type", 9999);
        Unit r16 = Unit.INSTANCE;
        super(r8, r9, r10, r4, null, r6);
        this.j = null;
        this.k = r12;
        this.l = r13;
        this.m = r14;
        this.n = r15;
    }
}

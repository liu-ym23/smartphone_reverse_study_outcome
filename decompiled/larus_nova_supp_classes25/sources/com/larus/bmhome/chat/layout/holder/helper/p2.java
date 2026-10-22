package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p2 extends a1 {
    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final void a(com.larus.bmhome.chat.layout.holder.menu.item.a.C0061a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.w());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.o());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.m0());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.h());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.e());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.m());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.k());
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final ef8.b c(final View r15) {
        Intrinsics.checkNotNullParameter(r15, "view");
        return new ef8.b(this.a, this.c, this.b, by7.h.g(r15), new o2(r15), null, null, null, null, null, null, 4064);
    }

    public p2(Message r9, com.larus.bmhome.chat.api.q0 r10, com.larus.bmhome.chat.api.q0.a r11, t0 r12) {
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r12, "popMenuGroupCreator");
        super(r9, r10, r11, r12, null, 48);
    }
}

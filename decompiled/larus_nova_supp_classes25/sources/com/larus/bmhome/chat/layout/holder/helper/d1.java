package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d1 extends a1 {
    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final void a(com.larus.bmhome.chat.layout.holder.menu.item.a.C0061a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.y0());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.h());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.e());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.m());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.q0());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.k());
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final ef8.b c(final View r15) {
        Intrinsics.checkNotNullParameter(r15, "view");
        return new ef8.b(this.a, this.c, this.b, by7.h.g(r15), new c1(r15), null, null, null, null, null, null, 4064);
    }

    public d1(Message r8, com.larus.bmhome.chat.api.q0 r9, com.larus.bmhome.chat.api.q0.a r10) {
        r1 r4 = new r1();
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r4, "popMenuGroupCreator");
        super(r8, r9, r10, r4, null, 48);
    }
}

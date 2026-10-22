package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import com.larus.bmhome.chat.layout.holder.menu.item.SaveSearchImageMenuHandler;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SearchImageInfo;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n2 extends a1 {
    public final SearchImageInfo j;
    public final JSONObject k;

    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final void a(com.larus.bmhome.chat.layout.holder.menu.item.a.C0061a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.w());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.o());
        r2.a(new SaveSearchImageMenuHandler());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.z0());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.h());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.e());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.m0());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.m());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.k());
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final ef8.b c(final View r15) {
        Intrinsics.checkNotNullParameter(r15, "view");
        return new ef8.b(this.a, this.c, this.b, by7.h.g(r15), new m2(r15), null, this.j, null, null, null, this.k, 1952);
    }

    public n2(Message r9, com.larus.bmhome.chat.api.q0 r10, com.larus.bmhome.chat.api.q0.a r11, SearchImageInfo r12, t0 r13) {
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r12, "imgItem");
        Intrinsics.checkNotNullParameter(r13, "popMenuGroupCreator");
        super(r9, r10, r11, r13, null, 48);
        this.j = r12;
        this.k = null;
    }
}

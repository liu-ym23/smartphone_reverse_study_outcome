package com.larus.bmhome.chat.layout.holder.image;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.layout.holder.menu.item.AttachmentCiteCopyMenuHandler;
import com.larus.bmhome.chat.layout.holder.menu.item.SaveImageMenuHandler;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.t1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p0 extends com.larus.bmhome.chat.layout.holder.helper.a1 {
    public final df8.a j;
    public final JSONObject k;

    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final void d() {
        t1.a(null, null, "chat", "assistant", this.a.getMessageId(), Boolean.valueOf(com.larus.bmhome.chat.bean.d.Q0(this.a)), null, null, null, "default", null, "private", null, Boolean.FALSE, "pic", null, 76707);
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final void a(com.larus.bmhome.chat.layout.holder.menu.item.a.C0061a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        r2.a(new AttachmentCiteCopyMenuHandler());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.d());
        r2.a(new SaveImageMenuHandler());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.v0());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.m0());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.h());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.e());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.m());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.k());
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final ef8.b c(final View r15) {
        Intrinsics.checkNotNullParameter(r15, "view");
        return new ef8.b(this.a, this.c, this.b, by7.h.g(r15), new o0(this, r15), this.j, null, null, null, null, this.k, 1984);
    }

    public p0(Message r9, com.larus.bmhome.chat.api.q0 r10, com.larus.bmhome.chat.api.q0.a r11, df8.a r12, ViewGroup r13, com.larus.bmhome.chat.layout.holder.helper.t0 r14, JSONObject r15) {
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r14, "popMenuGroupCreator");
        if (r15 == null) goto L6;
        String r0 = r15.toString();
        if (r0 == null) goto L6;
    L7:
        JSONObject r7 = new JSONObject(r0);
        r7.put("content_type", 6);
        Unit r1 = Unit.INSTANCE;
        super(r9, r10, r11, r14, r13, r7);
        this.j = r12;
        this.k = r15;
        return;
    L6:
        r0 = "{}";
        goto L7
    }
}

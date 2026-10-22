package gf8;

import android.view.View;
import by7.h;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.layout.holder.helper.a1;
import com.larus.bmhome.chat.layout.holder.helper.f;
import com.larus.bmhome.chat.layout.holder.menu.item.AttachmentCiteCopyMenuHandler;
import com.larus.bmhome.chat.layout.holder.menu.item.SaveVideoMenuHandler;
import com.larus.bmhome.chat.layout.holder.menu.item.k;
import com.larus.bmhome.chat.layout.holder.menu.item.m;
import com.larus.bmhome.chat.layout.holder.menu.item.m0;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.t1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c extends a1 {
    public final AiGenVideoContentData j;
    public final JSONObject k;

    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final void d() {
        t1.a(null, null, "chat", "assistant", this.a.getMessageId(), Boolean.valueOf(d.Q0(this.a)), null, null, null, "default", null, "private", null, Boolean.FALSE, "video", null, 76707);
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final void a(com.larus.bmhome.chat.layout.holder.menu.item.a.C0061a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        r2.a(new AttachmentCiteCopyMenuHandler());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.d());
        r2.a(new SaveVideoMenuHandler());
        r2.a(new com.larus.bmhome.chat.layout.holder.menu.item.a1());
        r2.a(new m0());
        r2.a(new m());
        r2.a(new k());
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final ef8.b c(final View r15) {
        Intrinsics.checkNotNullParameter(r15, "view");
        return new ef8.b(this.a, this.c, this.b, h.g(r15), new b(this, r15), null, null, null, this.j, null, this.k, 1504);
    }

    public c(Message r8, q0 r9, q0.a r10, AiGenVideoContentData r11, JSONObject r12) {
        f r4 = new f("creativity_answer_action", new a());
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r4, "popMenuGroupCreator");
        if (r12 == null) goto L6;
        String r0 = r12.toString();
        if (r0 == null) goto L6;
    L7:
        JSONObject r6 = new JSONObject(r0);
        r6.put("content_type", 5);
        Unit r1 = Unit.INSTANCE;
        super(r8, r9, r10, r4, null, r6);
        this.j = r11;
        this.k = r12;
        return;
    L6:
        r0 = "{}";
        goto L7
    }
}

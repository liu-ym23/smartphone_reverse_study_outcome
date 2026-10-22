package com.larus.bmhome.chat.layout.holder.image;

import android.net.Uri;
import com.larus.im.bean.message.Message;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f0 {
    public final HashMap<String, Long> a;

    public static final class a {
    }

    static {
    }

    public f0() {
        this.a = new HashMap();
    }

    public static String a(Message r1, String r2) {
        return r1.getMessageId() + "_" + r2;
    }

    public final void b(Message r5, String r6, boolean r7, Uri r8, boolean r9, String r10, boolean r11, int r12) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r8 != null) goto L6;
        return;
    L6:
        String r0 = a(r5, r6);
        Long r1 = this.a.get(r0);
        by7.a r2 = new by7.a("generate_image_load_success");
        r2.d("image_format", r10);
        r2.d("message_id", r5.getMessageId());
        r2.d("image_id", r6);
        r2.d("is_from_cache", Integer.valueOf(r7 ? 1 : 0));
        r2.d("conversation_id", r5.getConversationId());
        if (r1 == null) goto L9;
        r1.longValue();
        r2.d("duration", Long.valueOf(System.currentTimeMillis() - r1.longValue()));
    L9:
        r2.d("is_intermediate", Integer.valueOf(r9 ? 1 : 0));
        r2.d("url", r8.toString());
        r2.d("is_scroll_box", Integer.valueOf(r11 ? 1 : 0));
        r2.d("position", Integer.valueOf(r12 + 1));
        r2.b();
    }
}

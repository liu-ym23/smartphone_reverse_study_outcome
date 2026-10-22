package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface t0 {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ List a(t0 r12, Context r13, Message r14, Function0 r15, com.larus.bmhome.chat.api.q0 r16, BotModel r17, wc9.e r18, com.larus.bmhome.chat.api.q0.a r19, JSONObject r20, int r21) {
            if ((r21 & 4) == 0) goto L5;
            Function0 r6 = null;
        L7:
            if ((r21 & 128) == 0) goto L9;
            JSONObject r11 = null;
        L11:
            return r12.a(r13, r14, r6, r16, r17, r18, r19, r11);
        L9:
            r11 = r20;
            goto L11
        L5:
            r6 = r15;
            goto L7
        }
    }

    List<ot8.a> a(Context r1, Message r2, Function0<Message> r3, com.larus.bmhome.chat.api.q0 r4, BotModel r5, wc9.e r6, com.larus.bmhome.chat.api.q0.a r7, JSONObject r8);

    void b(List<String> r1);
}

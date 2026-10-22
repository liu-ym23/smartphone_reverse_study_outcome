package h7b;

import android.util.LruCache;
import com.larksuite.framework.utils.i0;
import com.ss.android.lark.biz.im.api.h0;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.api.service.impl.q1;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import w4b.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k {
    public final ChatService a;
    public final u b;
    public final q1 c;
    public final LruCache<String, Chat> d;
    public final i0<ChatChatter> e;

    public class a implements h0 {
        public final /* synthetic */ k a;

        public a(k r1) {
            this.a = r1;
        }

        public final void a(Chatter r7) {
            k r0 = this.a;
            r0.getClass();
            if (r7 != null) goto L6;
            return;
        L6:
            if ((r7 instanceof ChatChatter) == false) goto L14;
            ChatChatter r8 = (ChatChatter) r7;
            ChatChatter r1 = (ChatChatter) r0.e.a(r8.getChatId(), r8.getId());
            if (r1 != null) goto L11;
            return;
        L11:
            if (r1.getUpdateTime() > r8.getUpdateTime()) goto L15;
            r0.e.b(r8.getId(), r8.getId(), r8);
            return;
        L15:
            return;
        }
    }

    public static class b {
        public static final k a = null;

        static {
            a = new k();
        }
    }

    public k() {
        this.a = ChatService.c.a;
        this.b = ChatCoreModule.a().getLoginDependency();
        this.c = q1.d.a;
        this.d = new LruCache(200);
        this.e = new i0();
        a r0 = new a(this);
        ImSdkService.c().J1(r0);
    }
}

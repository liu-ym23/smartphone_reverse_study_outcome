package com.ss.android.lark.chatwindow.view.tip;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.chat.ChatHitPoint;
import com.ss.android.lark.utils.UIHelper;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a<T> {
    public final List<MessageInfo> a;
    public final r7b.c b;
    public final Context c;
    public boolean d;
    public c e;

    /* JADX INFO: renamed from: com.ss.android.lark.chatwindow.view.tip.a$a, reason: collision with other inner class name */
    public static class C0121a {
        public String a;

        public C0121a() {
        }
    }

    public interface b<T> {
        boolean a(MessageInfo r1, T r2);

        int b(T r1);
    }

    public interface c {
        void a(int r1, boolean r2);

        void b(Message r1);
    }

    public abstract int b();

    public abstract int c();

    public abstract String d();

    public abstract boolean f();

    public abstract boolean g();

    public abstract boolean h();

    public abstract boolean i();

    public final void e() {
        String r2 = "up";
        if (((ArrayList) this.a).isEmpty() == true) goto L14;
        Message r0 = ((MessageInfo) ListProtector.get(this.a, 0)).getMessage();
        this.e.b(r0);
        int r7 = c();
        boolean r8 = f();
        boolean r1 = r0.isAtAll();
        o5c.b r9 = ChatHitPoint.a.b();
        JSONObject r4 = new JSONObject().put("unread_total", r7).put("chat_mode", "classic");
        if (r8 == true) goto L8;
        r2 = "down";
    L8:
        JSONObject r3 = r4.put("direction", r2);
        if (r1 == false) goto L11;
        String r5 = "all";
    L12:
        r9.sendEvent("new_message_mention_click", r3.put(IPortraitService.TYPE, r5));
        return;
    L11:
        r5 = "user";
        goto L12
    L14:
        if (c() <= 0) goto L21;
        this.e.a(b(), true ^ f());
        int r6 = c();
        boolean r10 = f();
        o5c.b r11 = ChatHitPoint.a.b();
        JSONObject r12 = new JSONObject().put("unread_total", r6).put("chat_mode", "classic");
        if (r10 == true) goto L19;
        r2 = "down";
    L19:
        r11.sendEvent("new_message_toast_click", r12.put("direction", r2));
        return;
    L21:
        if (g() == false) goto L23;
        this.e.a(b(), true);
        int r13 = c();
        ChatHitPoint.a.b().sendEvent("message_dialog_back_to_bottom_click", new JSONObject().put("unread_total", r13).put("chat_mode", "classic"));
        return;
    L23:
        Log.e("BaseNewMessageTiphandleOnTipClick, unReadAtMessage is 0, newMessageCount is 0");
    }

    public a(Context r2, r7b.c r3) {
        this.a = new ArrayList();
        this.c = r2;
        this.b = r3;
    }

    public String a(Message r3, String r4) {
        if (r3.isAtAll() == false) goto L6;
        return UIHelper.mustacheFormat(2131891529, "chatter_name", r4);
    L6:
        if (r3.isOtherAtMe() == true) goto L11;
        return null;
    L11:
        return UIHelper.mustacheFormat(2131891531, "chatter_name", r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j(List<T> r4, b<T> r5) {
        Iterator r6 = ((ArrayList) r4).iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        Object r0 = r6.next();
        Iterator r1 = ((ArrayList) this.a).iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        if (r5.a((MessageInfo) r1.next(), r0) == false) goto L7;
        r1.remove();
        goto L7
    }
}

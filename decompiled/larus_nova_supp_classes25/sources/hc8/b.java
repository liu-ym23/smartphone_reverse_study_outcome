package hc8;

import com.larus.bmhome.chat.auth.model.PluginAuth;
import com.larus.bmhome.chat.auth.model.PluginAuthType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ String a(b r1, Message r2, BotModel r3, boolean r4, int r5) {
            if ((r5 & 4) == 0) goto L6;
            r4 = false;
        L6:
            return r1.d(r2, r3, r4, false);
        }
    }

    boolean a(Message r1);

    String b();

    String c();

    String d(Message r1, BotModel r2, boolean r3, boolean r4);

    boolean e(Message r1, String r2);

    hc8.a f(String r1);

    void g(Message r1, Message r2, BotModel r3, PluginAuthType r4, u7 r5);

    PluginAuth h(Message r1);

    String i();

    boolean j(Message r1);

    PluginAuthType k(String r1, String r2);

    String l();

    void m(String r1, String r2);

    String n();
}

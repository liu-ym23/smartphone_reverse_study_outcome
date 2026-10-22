package do8;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface a {
    boolean a();

    String b();

    CoroutineScope c();

    Boolean d();

    q0 e();

    com.larus.trace.tracknode.a f();

    LruSet<String> g();

    String getBotId();

    String getChatType();

    String getConversationId();

    String getCurrentPage();

    Fragment getHostFragment();

    Boolean h(Message r1);

    BotModel i();

    String j();
}

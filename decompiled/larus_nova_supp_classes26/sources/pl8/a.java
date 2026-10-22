package pl8;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.bot.BotModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface a {
    void a();

    String b();

    LifecycleCoroutineScope c();

    Boolean d();

    com.larus.trace.tracknode.a f();

    q0 getAdapter();

    String getBotId();

    String getChatType();

    String getConversationId();

    String getCurrentPage();

    FragmentManager getFragmentManager();

    BotModel i();
}

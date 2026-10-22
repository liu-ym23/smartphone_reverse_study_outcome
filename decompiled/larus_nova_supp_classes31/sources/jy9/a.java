package jy9;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface a {
    c a();

    void b();

    Function0<List<Message>> c();

    boolean d();

    Function4<nr9.g, String, Map<String, String>, Map<String, String>, Unit> e();

    com.larus.trace.tracknode.a f();

    Fragment g();

    q0 getAdapter();

    Context getContext();

    Message getMessage();

    CoroutineScope getScope();

    BotModel i();
}

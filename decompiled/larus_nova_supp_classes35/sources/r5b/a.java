package r5b;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.api.message.params.l;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.CoreMessageListComponent;
import java.util.Map;
import mya.h;
import mya.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a {
    boolean I();

    Fragment R();

    boolean X();

    boolean Y();

    boolean a();

    boolean b0();

    boolean d();

    <T extends l> T d0(Class<T> r1);

    boolean e0();

    void g(i r1);

    String getChatId();

    FragmentActivity getContext();

    boolean h();

    void h0(Map<Class<? extends l>, ? extends l> r1);

    boolean isAIChat();

    boolean isGroup();

    boolean isMeeting();

    boolean isSecretChat();

    void j(long r1);

    h j5();

    long k();

    lya.a l();

    boolean m();

    boolean o();

    boolean q();

    boolean r();

    void u(CoreMessageListComponent.c r1);
}

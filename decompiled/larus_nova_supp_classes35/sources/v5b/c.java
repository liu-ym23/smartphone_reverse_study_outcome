package v5b;

import com.ss.android.lark.chat.entity.message.Message;
import java.util.HashMap;
import kotlin.Deprecated;
import v5b.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface c<T extends a<?>> {
    y6b.b a();

    T b();

    boolean c();

    boolean d();

    boolean e();

    void f(int r1, String r2);

    String g();

    String getChatId();

    long getCreateTime();

    @Deprecated(message = "do not use this method out of chat module")
    int getGroupType();

    String getId();

    Message.Type getType();

    String getcId();

    boolean h();

    String i();

    boolean isPreMessage();

    boolean j();

    HashMap<Integer, String> k();

    boolean l();

    boolean m();

    <T> T n(Class<T> r1);

    boolean na();
}

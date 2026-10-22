package qob;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.widget.richtext.RichText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {
    Message a(m5b.d r1);

    void b(m5b.d r1);

    PartialReplyInfo c();

    String d();

    Message e(String r1, String r2, String r3, String r4, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r5);

    com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo f();

    void g(m5b.d r1);

    String getChatId();

    String h();

    void i();

    void j(Message r1, String r2, String r3, String r4);

    String k();

    MonitorMessageSendCallback l(String r1, String r2, int r3);

    void m(String r1);

    com.ss.android.lark.keyboard.b n();

    void o(String r1, String r2, String r3, RichText r4);

    void p(Message r1, String r2);
}

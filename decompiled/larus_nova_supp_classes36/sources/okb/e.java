package okb;

import com.bytedance.lark.pb.basic.v1.CardContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface e extends ikb.f {
    gya.a<Content> a(MessageType r1);

    void b();

    CardContent c(com.ss.android.lark.chat.entity.message.content.CardContent r1);

    List<gya.a<Content>> d();
}

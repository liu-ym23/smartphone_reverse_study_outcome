package aqb;

import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.g1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class k {
    public k() {
    }

    public void a(Chat r1) {
        throw null;
    }

    public void b(Chat r1) {
        throw null;
    }

    public void c(Chat r1, Map<String, ? extends Chatter> r2) {
        throw null;
    }

    public void d(g1 r1) {
        throw null;
    }

    public void e(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "preMessageInfo");
    }

    public void f(PushMessageReactions r1) {
        throw null;
    }

    public void g(PushMessageReadStates r2) {
        Intrinsics.checkNotNullParameter(r2, "readStates");
    }

    public void h(ThreadTopic r2) {
        Intrinsics.checkNotNullParameter(r2, "threadTopic");
    }
}

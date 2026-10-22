package w4b;

import com.bytedance.lark.pb.basic.v1.FeedCard;
import com.ss.android.lark.feed.app.entity.UpdateUnreadStatusScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface m {
    void a(com.ss.android.lark.chat.chatwindow.chat.v2.push.c.b r1);

    void b(String r1, FeedCard.EntityType r2, boolean r3, UpdateUnreadStatusScene r4);

    void c(com.ss.android.lark.chat.chatwindow.chat.v2.push.c.b r1);

    void d();

    void e();

    void f(Long r1, Long r2);

    void g();

    int getBadge();
}

package h4b;

import androidx.fragment.app.FragmentActivity;
import b3b.f;
import b3b.h;
import b3b.i;
import b3b.q;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.ChatAdapterV2;
import com.ss.android.lark.chat.chatwindow.chat.a;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.MessageListEventDispatchFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.functions.Function0;
import v4b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface c<A extends com.ss.android.lark.chat.chatwindow.chat.a> {

    public interface a {
        boolean a(y6b.c r1, com.ss.android.lark.chat.message.menu.context.a r2);

        void b(y6b.c<?> r1, int r2);

        void c(y6b.c r1, com.ss.android.lark.chat.message.menu.context.a r2);
    }

    ChatAdapterV2 a();

    i b(Chat r1, v r2, FragmentActivity r3, IMessageListViewModel r4, MessageListEventDispatchFeature.a r5, m2b.a r6);

    e3b.a c(Chat r1, v r2, FragmentActivity r3, IMessageListViewModel r4, MessageListEventDispatchFeature.a r5, m2b.a r6);

    h d(Chat r1, FragmentActivity r2, IMessageListViewModel r3, m2b.a r4);

    q e(Chat r1, v r2, FragmentActivity r3, IMessageListViewModel r4, m2b.a r5, IMessageListComponent.f r6);

    void f(SceneCoordinateRecyclerView r1, Function0 r2);

    void g(SceneCoordinateRecyclerView r1, com.ss.android.lark.chat.chatwindow.chat.a r2, m2b.a r3, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.c r4, f r5, d r6, v4b.c r7, Function0 r8);
}

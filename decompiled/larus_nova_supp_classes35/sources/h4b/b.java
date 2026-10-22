package h4b;

import androidx.fragment.app.FragmentActivity;
import b3b.f;
import b3b.h;
import b3b.i;
import b3b.q;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.ChatAdapterV2;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.MessageListEventDispatchFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v4b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class b implements c<ChatAdapterV2> {
    public final Class<? extends q2b.a> a;
    public e3b.a b;

    @Override // h4b.c
    public q e(Chat r1, v r2, FragmentActivity r3, IMessageListViewModel r4, m2b.a r5, IMessageListComponent.f r6) {
        Intrinsics.checkNotNullParameter(r1, "chat");
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        return null;
    }

    @Override // h4b.c
    public final void f(SceneCoordinateRecyclerView r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "noPreMessages");
    }

    @Override // h4b.c
    public final ChatAdapterV2 a() {
        return new ChatAdapterV2();
    }

    public b(Class<? extends q2b.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "factoryClass");
        this.a = r2;
    }

    @Override // h4b.c
    public h d(Chat r2, FragmentActivity r3, IMessageListViewModel r4, m2b.a r5) {
        Intrinsics.checkNotNullParameter(r2, "chat");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        return new d3b.a(r3, r4, r5);
    }

    @Override // h4b.c
    public i b(Chat r7, v r8, FragmentActivity r9, IMessageListViewModel r10, MessageListEventDispatchFeature.a r11, m2b.a r12) {
        Intrinsics.checkNotNullParameter(r7, "chat");
        Intrinsics.checkNotNullParameter(r8, "chatContainer");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        Intrinsics.checkNotNullParameter(r11, "dependency");
        e3b.a r13 = this.b;
        if (r13 != null) goto L7;
        e3b.a r14 = new e3b.a(r8, r9, r10, r11, r12);
        this.b = r14;
        return r14;
    L7:
        return r13;
    }

    @Override // h4b.c
    public final e3b.a c(Chat r7, v r8, FragmentActivity r9, IMessageListViewModel r10, MessageListEventDispatchFeature.a r11, m2b.a r12) {
        Intrinsics.checkNotNullParameter(r7, "chat");
        Intrinsics.checkNotNullParameter(r8, "chatContainer");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        Intrinsics.checkNotNullParameter(r11, "dependency");
        e3b.a r13 = this.b;
        if (r13 != null) goto L7;
        e3b.a r14 = new e3b.a(r8, r9, r10, r11, r12);
        this.b = r14;
        return r14;
    L7:
        return r13;
    }

    @Override // h4b.c
    public /* bridge */ /* synthetic */ void g(SceneCoordinateRecyclerView r1, com.ss.android.lark.chat.chatwindow.chat.a r2, m2b.a r3, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.c r4, f r5, d r6, v4b.c r7, Function0 r8) {
        h(r1, (ChatAdapterV2) r2, r3, r4, r5, r6, r7, r8);
    }

    public void h(SceneCoordinateRecyclerView r16, ChatAdapterV2 r17, m2b.a r18, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.c r19, f r20, d r21, v4b.c r22, Function0 r23) {
        Intrinsics.checkNotNullParameter(r16, "recyclerView");
        Intrinsics.checkNotNullParameter(r17, "adapter");
        Intrinsics.checkNotNullParameter(r18, "messageContext");
        Intrinsics.checkNotNullParameter(r19, "onCellClickHandler");
        Intrinsics.checkNotNullParameter(r20, "callbackHub");
        Intrinsics.checkNotNullParameter(r23, "complete");
        a r4 = new a(r19);
        com.ss.android.lark.blueprint.d r1 = this.a.getConstructor(new Class[]{m2b.a.class, e6b.b.a.class, f.class, d.class, v4b.c.class}).newInstance(new Object[]{r18, r4, r20, r21, r22}).create();
        r17.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r17.b = r1;
        r23.invoke();
    }
}

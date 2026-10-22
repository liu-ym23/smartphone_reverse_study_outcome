package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll;

import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollAlign;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollEvent;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import com.ss.android.lark.biz.im.api.extension.scroll.e;
import com.ss.android.lark.biz.im.api.s0;
import com.ss.android.lark.biz.im.api.w0;
import com.ss.android.lark.chat.base.view.recycleview.ItemShineManager;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import s2b.n;
import s2b.q;
import t6b.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageListScrollFeature implements com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a {
    public static final /* synthetic */ int h = 0;
    public final m a;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b b;
    public final Lazy c;
    public ItemShineManager<?> d;
    public boolean e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.InterfaceC0063a {
        public final /* synthetic */ MessageListScrollFeature a;

        public b(MessageListScrollFeature r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.InterfaceC0063a
        public final void l(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b r5) {
            Intrinsics.checkNotNullParameter(r5, "event");
            if ((r5 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.f) == false) goto L20;
            MessageListScrollFeature r6 = this.a;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r0 = r6.l();
            if (r0 == null) goto L18;
            SceneCoordinateRecyclerView r1 = r0.getRecyclerView();
            if (r1 == null) goto L18;
            LinearLayoutManager r2 = r1.getLayoutManager();
            if ((r2 instanceof LinearLayoutManager) == false) goto L11;
            LinearLayoutManager r3 = r2;
        L12:
            if (r3 != null) goto L14;
            Log.e("MessageListScrollFeature", "scrollDispatcher attach failed,layoutManager == null");
        L15:
            com.ss.android.lark.biz.im.api.extension.scroll.c r4 = r6.m();
            if ((r4 instanceof com.ss.android.lark.chat.chatwindow.chat.scroll.d) == false) goto L21;
            n r7 = ((com.ss.android.lark.chat.chatwindow.chat.scroll.d) r4).a;
            r7.b = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.b(r6);
            return;
        L21:
            return;
        L14:
            r6.m().b(r1, r3);
            goto L15
        L11:
            r3 = null;
        L18:
            Log.e("MessageListScrollFeature", "scrollDispatcher attach failed, recycler view == null");
            return;
        }
    }

    public static final class c implements com.ss.android.lark.biz.im.api.extension.scroll.b {
        public final /* synthetic */ int a;
        public final /* synthetic */ MessageListScrollFeature b;
        public final /* synthetic */ q c;

        public static final class a implements Runnable {
            public final /* synthetic */ ItemShineManager<?> a;
            public final /* synthetic */ ItemShineManager b;

            public a(ItemShineManager<?> r1, ItemShineManager r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ItemShineManager<?> r0 = this.a;     // Catch: Throwable -> L14
                if (r0 == null) goto L7;
                g2b.a r1 = r0.e;     // Catch: Throwable -> L14
                if (r1 == null) goto L7;
                r1.cancel();     // Catch: Throwable -> L14
            L7:
                ItemShineManager r2 = this.b;     // Catch: Throwable -> L14
                if (r2 != null) goto L10;
                return;
            L10:
                if (r2.e != null) goto L12;
                r2.a();     // Catch: Throwable -> L14
            L12:
                r2.e.b();     // Catch: Throwable -> L14
                return;
            L14:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L21;
                throw th;
            }
        }

        public static final class b<I> implements com.ss.android.lark.chat.base.view.recycleview.b.InterfaceC0030b {
            public static final b<I> a = null;

            static {
                a = new b();
            }

            public b() {
            }

            @Override // com.ss.android.lark.chat.base.view.recycleview.b.InterfaceC0030b
            public final boolean a(Object r4, Object r5) {
                y6b.c r6 = (y6b.c) r4;
                y6b.c r7 = (y6b.c) r5;
                if (r6 == null) goto L5;
                String r8 = r6.c;
            L6:
                if (r7 == null) goto L8;
                String r9 = r7.c;
            L10:
                return StringsKt.equals$default(r8, r9, false, 2, null);
            L8:
                r9 = null;
                goto L10
            L5:
                r8 = null;
                goto L6
            }
        }

        public final void a(String r4, ScrollEvent r5) {
            Intrinsics.checkNotNullParameter(r4, "taskId");
            Intrinsics.checkNotNullParameter(r5, "event");
            if (this.a != (-1)) goto L5;
            return;
        L5:
            MessageListScrollFeature r6 = this.b;
            if (r6.e == false) goto L17;
            ItemShineManager<?> r7 = r6.d;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r8 = r6.l();
            if (r8 == null) goto L10;
            SceneCoordinateRecyclerView r9 = r8.getRecyclerView();
        L11:
            ItemShineManager<?> r0 = new ItemShineManager(r9, this.c, b.a);
            r0.d = this.a;
            r0.a();
            MessageListScrollFeature r10 = this.b;
            r10.d = r0;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r11 = r10.l();
            if (r11 == null) goto L18;
            PointRecoderRecyclerView r12 = r11.getRecyclerView();
            if (r12 == null) goto L19;
            r12.post(new a(r7, r0));
            return;
        L19:
            return;
        L18:
            return;
        L10:
            r9 = null;
            goto L11
        }

        public final void b(String r1, ScrollEvent r2) {
            com.ss.android.lark.biz.im.api.extension.scroll.b.a.c(r1, r2);
        }

        public final void c(String r2, ScrollEvent r3) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Intrinsics.checkNotNullParameter(r3, "event");
        }

        public final void d(String r1, ScrollEvent r2) {
            com.ss.android.lark.biz.im.api.extension.scroll.b.a.b(r1, r2);
        }

        public final void e(String r1, ScrollEvent r2) {
            com.ss.android.lark.biz.im.api.extension.scroll.b.a.a(r1, r2);
        }

        public c(int r1, MessageListScrollFeature r2, q r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ Function0<String> a;

        public d(Function0<String> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onActivityResult(int r1, int r2, Intent r3) {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStart() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStop() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void x(i7b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "initData");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a
    public final void a() {
        ItemShineManager<?> r0 = this.d;
        if (r0 == null) goto L8;
        g2b.a r1 = r0.e;
        if (r1 == null) goto L9;
        r1.a();
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a
    public final s0 b() {
        return this.a.c();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a
    public final a1 h() {
        return this.a.e();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a
    public final w0 i() {
        return this.a.d();
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a l() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L6:
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a) r0.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a.class);
    }

    public final com.ss.android.lark.biz.im.api.extension.scroll.c m() {
        return (com.ss.android.lark.biz.im.api.extension.scroll.c) this.g.getValue();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void onDestroy() {
        ItemShineManager<?> r0 = this.d;
        if (r0 == null) goto L8;
        g2b.a r2 = r0.e;
        if (r2 == null) goto L7;
        r2.cancel();
    L7:
        r0.e = null;
    L8:
        this.d = null;
        m().a();
        m().detach();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void onPause() {
        com.ss.android.lark.biz.im.api.extension.scroll.c r0 = m();
        e.a.getClass();
        r0.c(e.a.b);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void onResume() {
        com.ss.android.lark.biz.im.api.extension.scroll.c r0 = m();
        e.a.getClass();
        r0.d(e.a.b);
    }

    public MessageListScrollFeature(m r2) {
        Intrinsics.checkNotNullParameter(r2, "spec");
        this.a = r2;
        this.c = LazyKt.lazy(LazyThreadSafetyMode.NONE, new MessageListScrollFeature$titleBarHeight$2(this));
        this.e = true;
        this.f = LazyKt.lazy(new MessageListScrollFeature$isNewScrollEnable$2(this));
        this.g = LazyKt.lazy(new MessageListScrollFeature$scrollDispatcher$2(this));
    }

    public final void F(ScrollScene r6) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        IMessageListViewModel r1 = r0.f();
        if (r1 != null) goto L8;
        return;
    L8:
        Chat r2 = (Chat) r1.getCurrentChat().getValue();
        s0 r3 = this.a.c();
        if (r3 == null) goto L13;
        Integer r4 = r3.a(r2);
        if (r4 == null) goto L13;
        int r5 = r4.intValue();
    L15:
        com.ss.android.lark.biz.im.api.extension.scroll.d r7 = new com.ss.android.lark.biz.im.api.extension.scroll.d(r6);
        Function1 r8 = ScrollEvent.j;
        Intrinsics.checkNotNullParameter(r8, "value");
        r7.b = r8;
        ScrollAlign r9 = ScrollAlign.BOTTOM;
        Intrinsics.checkNotNullParameter(r9, "value");
        r7.d = r9;
        r7.e = false;
        r7.f = 0;
        r7.b(-268435456);
        final ScrollEvent r10 = r7.a();
        Function0<String> r11 = new MessageListScrollFeature$scrollToLatestMessageOfChatImmediately$scrollAction$1(this, r10);
        if (r1.containsPosition(r5) == false) goto L18;
        r11.invoke();
        return;
    L18:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r12 = l();
        if (r12 == null) goto L21;
        r12.s(new d(r11));
    L21:
        r1.loadSpecialPage(r5, new UIGetDataCallback(new MessageListScrollFeature$scrollToLatestMessageOfChatImmediately$2()));
        return;
    L13:
        if (r2 == null) goto L23;
        r5 = r2.getLastMessagePosition();
        goto L15
    L23:
        Log.w(TitlebarViewModel.LOG_TAG, "scrollToBottomImmediate: chat is null");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void y(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.b = r2;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r2 = null;
    L5:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r3 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a) r2.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.class);
        if (r3 == null) goto L9;
        r3.k(new b(this));
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a
    public final void e(int r5, boolean r6) {
        if ((m() instanceof com.ss.android.lark.chat.chatwindow.chat.scroll.d) == false) goto L6;
        com.ss.android.lark.biz.im.api.extension.scroll.a.a(m(), ScrollScene.CARD_MESSAGE_STREAM, r5, r6);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a
    public final void r(ScrollScene r12, int r13, boolean r14, int r15) {
        Intrinsics.checkNotNullParameter(r12, "scene");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r2 = l();
        if (r2 == null) goto L5;
        com.ss.android.lark.chat.chatwindow.chat.a r3 = r2.getAdapter();
    L6:
        final q r1 = new q(r3, r13);
        r1.b = this.a.e();
        com.ss.android.lark.biz.im.api.extension.scroll.c r16 = m();
        Intrinsics.checkNotNullParameter(r12, "scene");
        Function1<RecyclerView, Integer> r4 = new MessageListScrollFeature$scrollItemToCenter$1$1(r1);
        Intrinsics.checkNotNullParameter(r4, "value");
        ScrollAlign r6 = ScrollAlign.CENTER;
        Intrinsics.checkNotNullParameter(r6, "value");
        r16.f(new ScrollEvent(r12, r4, null, r6, r14, 150, new c(r15, this, r1)));
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a
    public final void t3(ScrollScene r16, int r17, boolean r18, boolean r19, IMessageListComponent.k r20, Function1<? super MessageInfo, Boolean> r21) {
        Intrinsics.checkNotNullParameter(r16, "scene");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.b;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        IMessageListViewModel r5 = r0.f();
        if (r5 != null) goto L10;
        Log.w("MessageListScrollFeature", "scrollToPosition viewModel == null");
        return;
    L10:
        if (r5.containsPosition(r17) == false) goto L27;
        MessageInfo r2 = r5.getDataOnPosition(r17);
        if (r21 != null) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == false) goto L20;
        Log.i("MessageListScrollFeature", "intercept scrollToPosition " + r17);
        return;
    L20:
        if (r19 == false) goto L22;
        com.ss.android.lark.biz.im.api.extension.scroll.a.a(m(), r16, 0, true);
        return;
    L22:
        if (r18 == false) goto L24;
        int r4 = 1;
    L25:
        r(r16, r17, true, r4);
        return;
    L24:
        r4 = -1;
        goto L25
    L14:
        if (((Boolean) r21.invoke(r2)).booleanValue() != true) goto L16;
        r3 = true;
        goto L17
    L27:
        if (r20 == null) goto L29;
        r20.b();
    L29:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r6 = this.b;
        if (r6 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L33:
        BuildersKt.launch$default(r1.c(), Dispatchers.getIO(), null, new MessageListScrollFeature$scrollToPosition$1(r5, r17, r21, r20, r19, this, r16, r18, null), 2, null);
        return;
    L32:
        r1 = r6;
        goto L33
    }
}

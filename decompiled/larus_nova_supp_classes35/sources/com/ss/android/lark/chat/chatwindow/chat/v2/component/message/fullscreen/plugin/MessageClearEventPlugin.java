package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageClearEventPlugin extends d {
    public final v a;
    public final Lazy b;

    public static final class a<T> implements Observer {
        public final /* synthetic */ c a;
        public final /* synthetic */ MessageClearEventPlugin b;
        public final /* synthetic */ Fragment c;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.MessageClearEventPlugin$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0069a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[PageType.values().length];
                r0[PageType.CHAT_WINDOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[PageType.CHAT_THREAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[PageType.REPLY_IN_THREAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public a(c r1, MessageClearEventPlugin r2, Fragment r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r11) {
            int r3 = ((Chat) r11).getFirstMessagePosition();
            y6b.a<?> r1 = this.a.c.getItem();
            if (r1 == null) goto L35;
            MessageFullScreenViewModel.c r12 = (MessageFullScreenViewModel.c) this.a.c.getLaunch().getValue();
            if (r12 == null) goto L36;
            PageType r0 = r12.a.getPageType();
            int r2 = C0069a.a[r0.ordinal()];
            if (r2 == 1) goto L25;
            if (r2 == 2) goto L25;
            if (r2 != 3) goto L37;
            Message r13 = r12.b;
            if (r13 != null) goto L19;
            return;
        L19:
            if (r13.isReplyInThreadRootMessage() == false) goto L22;
            MessageClearEventPlugin.b(this.b, r1.A(), r3, this.c);
            return;
        L22:
            if (r13.isReplyInThreadChildMessage() == false) goto L32;
            BuildersKt.launch$default((CoroutineScope) this.b.b.getValue(), null, null, new MessageClearEventPlugin$onCreate$1$2(r13, this.b, r3, this.c, null), 3, null);
            return;
        L32:
            return;
        L37:
            return;
        L25:
            if ((r1 instanceof y6b.c) == true) goto L27;
        L29:
            MessageClearEventPlugin.b(this.b, r1.A(), r3, this.c);
            return;
        L27:
            if (((y6b.c) r1).L <= 0) goto L29;
            BuildersKt.launch$default((CoroutineScope) this.b.b.getValue(), null, null, new MessageClearEventPlugin$onCreate$1$1(r1, this.b, r3, this.c, null), 3, null);
            return;
        L36:
            return;
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.d, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.a
    public final void onDestroy() {
        CoroutineScopeKt.cancel$default((CoroutineScope) this.b.getValue(), null, 1, null);
    }

    public MessageClearEventPlugin(v r2) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        this.a = r2;
        this.b = LazyKt.lazy(MessageClearEventPlugin$scope$2.INSTANCE);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.a
    public final void a(c r4) {
        Intrinsics.checkNotNullParameter(r4, "pluginContext");
        Fragment r0 = r4.b;
        r4.c.getChatLiveData().observe(r0, new a(r4, this, r0));
    }

    public static final void b(final MessageClearEventPlugin r1, int r2, int r3, final Fragment r4) {
        r1.getClass();
        Function0<Unit> r0 = new MessageClearEventPlugin$checkClosePageByMessage$1(r4, r1);
        if (r2 > r3) goto L6;
        r0.invoke();
        return;
    }
}

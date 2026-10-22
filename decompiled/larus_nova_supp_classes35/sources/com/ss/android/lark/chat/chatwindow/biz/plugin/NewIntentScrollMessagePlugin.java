package com.ss.android.lark.chat.chatwindow.biz.plugin;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.c;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class NewIntentScrollMessagePlugin extends c {
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c g;
    public ScrollToNewMessageRunnable h;
    public final Lazy i;

    public static final class ScrollToNewMessageRunnable implements Function0<Unit> {
        public final com.ss.android.lark.chat.chatwindow.chat.v2.component.c a;
        public final fxa.b b;

        public final void a() {
            final IMessageListComponent r1 = (IMessageListComponent) this.a.a(IMessageListComponent.class);
            if (r1 == null) goto L6;
            IMessageListComponent.CC.scrollToPosition$default(r1, ScrollScene.NEW_INTENT_SCROLL, this.b.o(), true, false, null, new NewIntentScrollMessagePlugin$ScrollToNewMessageRunnable$invoke$1$1(this, r1), 16, null);
            return;
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }

        public ScrollToNewMessageRunnable(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, fxa.b r3) {
            Intrinsics.checkNotNullParameter(r2, "chatApp");
            Intrinsics.checkNotNullParameter(r3, "chatBundle");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void D() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r0 = this.g;
        if (r0 == null) goto L5;
        r0.t((NewIntentScrollMessagePlugin$newIntentHandler$2.a) this.i.getValue());
    L5:
        super.D();
    }

    public NewIntentScrollMessagePlugin() {
        this.i = LazyKt.lazy(new NewIntentScrollMessagePlugin$newIntentHandler$2(this));
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatApp");
        Intrinsics.checkNotNullParameter(r3, "initData");
        super.C(r2, r3);
        this.g = r2;
        r2.k0((NewIntentScrollMessagePlugin$newIntentHandler$2.a) this.i.getValue());
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r4 = this.g;
        if (r4 == null) goto L10;
        Fragment r5 = r4.getFragment();
        if (r5 == null) goto L11;
        Lifecycle r6 = r5.getLifecycle();
        if (r6 == null) goto L12;
        r6.addObserver(new NewIntentScrollMessagePlugin$onCreate$1(this));
        return;
    L12:
        return;
    L11:
        return;
    }
}

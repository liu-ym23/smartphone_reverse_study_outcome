package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q implements c0.a {
    public final String a;
    public final WeakReference<a> b;
    public final b c;

    public interface a {
        void onQuitGroup(boolean r1);

        void updateDissolveGroupLocalFlag(boolean r1);
    }

    public static final class b implements aqb.c {
        public final /* synthetic */ q a;

        public b(q r1) {
            this.a = r1;
        }

        public final void a(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "chatId");
            if (Intrinsics.areEqual(this.a.a, r2) == false) goto L8;
            a r4 = this.a.b.get();
            if (r4 == null) goto L9;
            r4.onQuitGroup(r3);
            return;
        L9:
            return;
        }

        public final void b(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "chatId");
            if (Intrinsics.areEqual(this.a.a, r2) == false) goto L8;
            a r4 = this.a.b.get();
            if (r4 == null) goto L9;
            r4.updateDissolveGroupLocalFlag(r3);
            return;
        L9:
            return;
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        ChatCoreModule.a().getChatSettingDependency().a(this.c);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        ChatCoreModule.a().getChatSettingDependency().c(this.c);
    }

    public q(String r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "mChatId");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.a = r2;
        this.b = new WeakReference(r3);
        this.c = new b(this);
    }
}

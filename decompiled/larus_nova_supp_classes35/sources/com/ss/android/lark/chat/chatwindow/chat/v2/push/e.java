package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements c0.a {
    public final a a;

    public interface a {
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c {
        public c() {
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        ChatCoreModule.a().getPushDependency().f();
        ChatCoreModule.a().getPushDependency().h();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        ChatCoreModule.a().getPushDependency().k();
        ChatCoreModule.a().getPushDependency().l();
    }

    public e(String r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "mChatId");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.a = r3;
        new WeakReference(this.a);
        new c();
        new b();
    }
}

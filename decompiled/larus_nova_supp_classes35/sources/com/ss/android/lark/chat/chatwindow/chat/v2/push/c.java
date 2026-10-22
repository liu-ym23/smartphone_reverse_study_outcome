package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements c0.a {
    public final WeakReference<a> a;
    public final b b;

    public interface a {
        void onBadgeChange(int r1);
    }

    public static final class b implements aqb.j {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void onBadgeChange(int r2) {
            a r0 = this.a.a.get();
            if (r0 == null) goto L6;
            r0.onBadgeChange(r2);
            return;
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        ChatCoreModule.a().getFeedDependency().a(this.b);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        ChatCoreModule.a().getFeedDependency().c(this.b);
    }

    public c(a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a = new WeakReference(r2);
        this.b = new b(this);
    }
}

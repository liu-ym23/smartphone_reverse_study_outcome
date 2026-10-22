package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements c0.a {
    public final WeakReference<a> a;
    public final b b;

    public interface a {
        void onPushUploadProgress(String r1, int r2);
    }

    public static final class b implements aqb.g {
        public final /* synthetic */ g a;

        public b(g r1) {
            this.a = r1;
        }

        public final void onPushUploadProgress(String r2, int r3) {
            a r0 = this.a.a.get();
            if (r0 == null) goto L6;
            r0.onPushUploadProgress(r2, r3);
            return;
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        ChatCoreModule.a().getPushDependency().b(this.b);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        ChatCoreModule.a().getPushDependency().d(this.b);
    }

    public g(a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a = new WeakReference(r2);
        this.b = new b(this);
    }
}

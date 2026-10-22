package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatFileAuthorityPushHandler implements c0.a {
    public final com.ss.android.lark.auditsdk.v2.receivecheck.a a;
    public final WeakReference<b> b;
    public final Lazy c;

    public static final class a {
    }

    public interface b {
        void onPushFileAuthority(Map<String, ValidateIMFileResult> r1);
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        this.a.a((com.ss.android.lark.auditsdk.v2.receivecheck.a.a) this.c.getValue());
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        this.a.c((com.ss.android.lark.auditsdk.v2.receivecheck.a.a) this.c.getValue());
    }

    public ChatFileAuthorityPushHandler(com.ss.android.lark.auditsdk.v2.receivecheck.a r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "checker");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.a = r2;
        this.b = new WeakReference(r3);
        this.c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new ChatFileAuthorityPushHandler$observer$2(this));
    }
}

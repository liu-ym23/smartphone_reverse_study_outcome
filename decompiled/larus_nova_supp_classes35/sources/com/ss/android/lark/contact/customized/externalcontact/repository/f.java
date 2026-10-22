package com.ss.android.lark.contact.customized.externalcontact.repository;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.GetChatApplicationBadgeResponse;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements com.ss.android.lark.sdk.f.a {
    public static final f a = null;

    public static final class a implements com.ss.android.lark.sdk.g.b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void a(byte[] r3) {
            Lazy r0 = OfficeExternalContactRepository.a;
            Intrinsics.checkNotNull(r3);
            GetChatApplicationBadgeResponse r4 = (GetChatApplicationBadgeResponse) GetChatApplicationBadgeResponse.ADAPTER.decode(r3);     // Catch: Exception -> L5
            CoreThreadPool.getDefault().getUIExecutor().execute(new g(r4));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e(e.getMessage());
        }
    }

    static {
        a = new f();
    }

    public f() {
    }

    public final void a() {
        com.ss.android.lark.sdk.g.e.a.b(Command.PUSH_CHAT_APPLICATION_BADGE, a.a);
    }
}

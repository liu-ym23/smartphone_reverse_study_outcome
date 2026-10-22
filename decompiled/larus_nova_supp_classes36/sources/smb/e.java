package smb;

import android.content.Context;
import com.larus.search.impl.LarkChatServiceProxyImpl;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@OfficeSDKUserScope
public final class e implements dza.b {
    @Inject
    public e() {
    }

    public final void a(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "chatId");
        int r0 = FlowChatModule.d;
        FlowChatModule r1 = FlowChatModule.a.a();
        ChatBundle.a r2 = new ChatBundle.a();
        r2.a = r4;
        r2.b(Boolean.TRUE);
        r1.e(r3, new ChatBundle(r2), null);
    }

    public final void b(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "threadId");
        int r0 = FlowChatModule.d;
        FlowChatModule r1 = FlowChatModule.a.a();
        l1.a r2 = new l1.a();
        r2.e = r4;
        r2.w = Boolean.TRUE;
        l1 r5 = new l1(r2);
        r1.getClass();
        FlowChatModule.g(r3, r5);
    }

    public final void c(Context r2, ChatBundle r3, LarkChatServiceProxyImpl.openLarkChat.1 r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatBundle");
        int r0 = FlowChatModule.d;
        FlowChatModule.a.a().e(r2, r3, r4);
    }
}

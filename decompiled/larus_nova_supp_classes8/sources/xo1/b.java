package xo1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.j;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils.MorePanelBubbleAlog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements j {
    public final String a;
    public final BubbleEnv b;

    public b(BubbleEnv r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.b = r2;
        this.a = "CommonBubbleInterceptor";
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.j
    public final boolean a(i r5) {
        Intrinsics.checkNotNullParameter(r5, "bubble");
        if (this.b.a().d() == false) goto L6;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r6 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r6.d(this.a);
        r6.c("气泡展示被拦截，24小时展示频控限制");
        MorePanelBubbleAlog.a(r6.b());
        return true;
    L6:
        g.b r7 = this.b.a().query(r5.getId());
        if (r7 != null) goto L10;
        return false;
    L10:
        if (r7.e() == false) goto L14;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r8 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r8.d(this.a);
        r8.c("气泡展示被拦截，该气泡已经完成展示了");
        MorePanelBubbleAlog.a(r8.b());
        return true;
    L14:
        if (r7.d() >= 3) goto L16;
    L22:
        return false;
    L16:
        if (r7.b() != 1001) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == true) goto L22;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r10 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r10.d(this.a);
        r10.c("气泡展示被拦截，该气泡已经展示过3次了");
        MorePanelBubbleAlog.a(r10.b());
        return true;
    L18:
        r9 = false;
        goto L19
    }
}

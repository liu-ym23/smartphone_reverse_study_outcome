package xo1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.j;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils.MorePanelBubbleAlog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import lk1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements j {
    public final BubbleEnv a;

    public a(BubbleEnv r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.j
    public final boolean a(i r4) {
        Intrinsics.checkNotNullParameter(r4, "bubble");
        BubbleEnv r5 = this.a;
        boolean r0 = false;
        if (r5 == null) goto L12;
        DataCenter r6 = r5.c;
        if (r6 == null) goto L12;
        c.i2.getClass();
        mk1.a r7 = c.a.a(r6).getComponentStatus("room_auth_toolbar_bubble");
        if (r7 != null) goto L9;
    L10:
        r0 = true;
    L11:
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r8 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r8.d("BubbleRoomAuthInterceptor");
        r8.c("气泡房间管控: " + r0);
        MorePanelBubbleAlog.a(r8.b());
        goto L12
    L9:
        if (r7.a() == true) goto L11;
    L12:
        return r0;
    }
}

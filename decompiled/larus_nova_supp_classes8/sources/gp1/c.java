package gp1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements a {
    public c() {
    }

    @Override // gp1.a
    public final boolean a(a2 r2) {
        Intrinsics.checkNotNullParameter(r2, "button");
        if (r2 != ToolbarButton.VS_MESSAGE_BOARD) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // gp1.a
    public final ExtendedToolbarButton.b b(a2 r2) {
        Intrinsics.checkNotNullParameter(r2, "button");
        ExtendedToolbarButton.a r3 = ExtendedToolbarButton.h;
        ToolbarButton r0 = ToolbarButton.VS_MESSAGE_BOARD;
        r3.getClass();
        ExtendedToolbarButton.b r4 = ExtendedToolbarButton.a.a(r0);
        r4.d = 1;
        return r4;
    }
}

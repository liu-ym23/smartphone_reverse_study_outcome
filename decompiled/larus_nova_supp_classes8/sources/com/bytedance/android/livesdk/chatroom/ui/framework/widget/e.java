package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ Object a;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 b;

    public e(Object r1, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        mk1.a r4 = (mk1.a) r3;
        Intrinsics.checkNotNullParameter(r4, "castScreen");
        if (r4.b() == true) goto L5;
        return;
    L5:
        if ((this.a instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) == false) goto L9;
        ALogger.e("liveRefinedDegrade", "auth castScreen update to hide castscreentoolbar");
        this.b.d(ToolbarButton.GAME_CAST_SCREEN, (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) this.a);
        return;
    }
}

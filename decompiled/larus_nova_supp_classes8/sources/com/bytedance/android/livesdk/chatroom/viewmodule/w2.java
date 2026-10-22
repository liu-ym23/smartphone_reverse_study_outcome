package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w2 implements com.bytedance.android.scope.o, y0 {
    public final String a;
    public final u2 b;
    public final /* synthetic */ y0 c;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.y0
    public final com.bytedance.android.livesdk.chatroom.model.e3 Qn() {
        return this.c.Qn();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.y0
    public final boolean Z5(long r2) {
        return this.c.Z5(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.y0
    public final boolean fi(long r2) {
        return this.c.fi(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.y0
    public final void ve() {
        this.c.ve();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.y0
    public final int wm(long r2) {
        return this.c.wm(r2);
    }

    public final void onStart() {
        ALogger.d(this.a, "on sticker service start");
    }

    public final void onStop() {
        ALogger.d(this.a, "on sticker service stop");
    }

    public w2(u2 r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.c = r2.n();
        this.b = r2;
        this.a = "StickerService";
    }
}

package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoader;
import com.bytedance.android.livesdk.chatroom.utils.y2;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ResKeyEnum;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n implements vr1.w, com.bytedance.android.scope.o {
    public n() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.w
    public final void a(HSImageView r3, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r4, Object r5, com.bytedance.android.livesdk.vscore_impl.behavior.a r6) {
        Intrinsics.checkNotNullParameter(r4, "button");
        Intrinsics.checkNotNullParameter(r6, "callback");
        SkinLoader.c.getClass();
        if (SkinLoader.a.b() == false) goto L10;
        SkinLoader r7 = SkinLoader.a.e(r4);
        if (r3 == null) goto L11;
        ResKeyEnum r0 = ResKeyEnum.MULTI_CAMERA;
        if (r7.b(y2.b(r0)) == null) goto L12;
        r6.b();
        r7.c(y2.a(r0, r5), r3, new m(r6));
        return;
    L12:
        return;
    L11:
        return;
    }
}

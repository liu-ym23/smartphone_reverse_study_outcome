package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;
import com.bytedance.android.live.room.IMiddlewareRoomService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o0 implements View.OnClickListener {
    public final /* synthetic */ j0.c a;

    public o0(j0.c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (this.a.o.a == null) goto L17;
        IMiddlewareRoomService r4 = jc1.k.f(IMiddlewareRoomService.class);
        if (r4 != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 != true) goto L18;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r6 = this.a.o.a;
        if (r6 == null) goto L15;
        r6.v0();
    L15:
        i40.h.a("V3 landscape on audio2text click");
        this.a.h(false);
        j0.c.g(this.a, "voice_to_text");
        return;
    L18:
        return;
    L7:
        if (r4.checkOrLoadAudioResource() != true) goto L9;
        r5 = true;
        goto L10
    }
}

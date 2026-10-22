package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f1 implements View.OnTouchListener {
    public final /* synthetic */ d1.c a;

    public f1(d1.c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r13, MotionEvent r14) {
        int r15 = r14.getAction();
        if (r15 != 0) goto L5;
        this.a.w.clear();
        d1.c.g(this.a);
    L19:
        return false;
    L5:
        if (r15 == 1) goto L9;
        if (r15 != 2) goto L19;
        d1.c.g(this.a);
        goto L19
    L9:
        d1.c.g(this.a);
        String r16 = CollectionsKt.joinToString$default(this.a.w, "|", null, null, 0, null, null, 62, null);
        int r2 = com.bytedance.android.livesdk.interactivity.comment.utils.a.a;
        Intrinsics.checkNotNullParameter(r16, "exposedTypes");
        HashMap r3 = new HashMap();
        r3.put("emoji_type", r16);
        MiddlewareRoomContext r17 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r17 == null) goto L16;
        com.bytedance.live.datacontext.i r18 = r17.isAnchor();
        if (r18 == null) goto L16;
        if (((Boolean) r18.getValue()).booleanValue() != true) goto L16;
        String r19 = "1";
    L17:
        r3.put("is_anchor", r19);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_quick_emoji_slide", r3, new Object[]{IRoom.class, new am2.x()});
    L16:
        r19 = "0";
        goto L17
    }
}

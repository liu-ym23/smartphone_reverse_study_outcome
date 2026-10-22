package com.bytedance.android.livesdk.chatroom.ui.livesticker.utils;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.viewmodule.AnchorStickerWrapperWidget;
import com.bytedance.android.livesdk.chatroom.widget.u;
import com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(View r7) {
        Intrinsics.checkNotNullParameter(r7, "sticker");
        if ((r7.getTag() instanceof RoomDecoration) == false) goto L28;
        Object r0 = r7.getTag();
        if (r0 == null) goto L27;
        RoomDecoration r1 = (RoomDecoration) r0;
        long r2 = r1.getId();
        AnchorStickerWrapperWidget.F.getClass();
        if (r2 != AnchorStickerWrapperWidget.E) goto L9;
    L25:
        return false;
    L9:
        if (r1.getId() == AnchorStickerWrapperWidget.D) goto L25;
        u.P.getClass();
        if (u.c.c() == true) goto L14;
        return true;
    L14:
        if ((r7.getTag(2131389517) instanceof Integer) == false) goto L29;
        Object r8 = r7.getTag(2131389517);
        if (r8 == null) goto L22;
        if (u.c.d(((Integer) r8).intValue()) == false) goto L30;
        f2.c(s1.B(2131916157), 0);
        return false;
    L30:
        return true;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L29:
        return true;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration");
    L28:
        return false;
    }
}

package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q<T> implements Observer {
    public final /* synthetic */ o a;
    public final /* synthetic */ View b;

    public q(o r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r3) {
        VideoViewParams r4 = (VideoViewParams) r3;
        if (r4 == null) goto L10;
        RoomSpecificSceneTypeInfo r0 = this.a.getContext().c().getSceneTypeInfo();
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isCommentaryRoom() != true) goto L12;
        ViewGroup.LayoutParams r1 = this.b.getLayoutParams();
        r1.width = r4.a + MathKt.roundToInt(UtilityKotlinExtentionsKt.h(1));
        this.b.setLayoutParams(r1);
        return;
    L12:
        return;
    }
}

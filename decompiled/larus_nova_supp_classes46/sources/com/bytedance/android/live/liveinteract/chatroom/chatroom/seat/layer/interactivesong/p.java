package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p {
    public final TextSwitcher a;
    public final TextView b;
    public final TextView c;

    public p(View r3) {
        Intrinsics.checkNotNullParameter(r3, "parentContext");
        TextSwitcher r0 = (TextSwitcher) r3.findViewById(2131385176);
        this.a = r0;
        this.b = (TextView) r3.findViewById(2131368348);
        this.c = (TextView) r3.findViewById(2131380893);
        r0.setMeasureAllChildren(false);
        r0.setInAnimation(AnimationUtils.loadAnimation(r0.getContext(), 2130772691));
        r0.setOutAnimation(AnimationUtils.loadAnimation(r0.getContext(), 2130772692));
        r0.setCurrentText("0");
    }
}

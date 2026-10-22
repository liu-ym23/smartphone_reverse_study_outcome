package com.bytedance.android.livesdk.interactivity.roomintro.view;

import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.x0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ RoomIntroDialogV2 a;

    public v(RoomIntroDialogV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Boolean r4 = (Boolean) r3;
        if (r4 == null) goto L21;
        r4.booleanValue();
        ViewGroup r0 = this.a.m;
        if (r0 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r0);
    L7:
        ViewGroup r1 = this.a.m;
        if (r1 == null) goto L11;
        r1.setOnClickListener(x0.a(new RoomIntroDialogV2$initPoi$1$1(this)));
    L11:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L16;
        TextView r5 = this.a.p;
        if (r5 == null) goto L22;
        r5.setText(s1.B(2131919915));
        return;
    L22:
        return;
    L16:
        if (Intrinsics.areEqual(r4, Boolean.FALSE) == false) goto L24;
        TextView r6 = this.a.p;
        if (r6 == null) goto L25;
        r6.setText(s1.B(2131919917));
        return;
    L25:
        return;
    L24:
        return;
    }
}

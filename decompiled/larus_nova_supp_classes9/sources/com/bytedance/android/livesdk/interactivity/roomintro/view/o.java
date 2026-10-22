package com.bytedance.android.livesdk.interactivity.roomintro.view;

import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.x0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ RoomIntroDialogV2 a;

    public o(RoomIntroDialogV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Boolean r4 = (Boolean) r3;
        if (r4 == null) goto L24;
        r4.booleanValue();
        ViewGroup r0 = this.a.n;
        if (r0 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r0);
    L7:
        RoomIntroDialogV2 r1 = this.a;
        if (r1.t == true) goto L10;
        RoomIntroDialogV2.T90(r1, "livesdk_live_room_detail_announce_info_show");
        this.a.t = true;
    L10:
        ViewGroup r2 = this.a.n;
        if (r2 == null) goto L14;
        r2.setOnClickListener(x0.a(new RoomIntroDialogV2$initAnnounce$1$1(this)));
    L14:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L19;
        TextView r5 = this.a.o;
        if (r5 == null) goto L25;
        r5.setText(s1.B(2131919915));
        return;
    L25:
        return;
    L19:
        if (Intrinsics.areEqual(r4, Boolean.FALSE) == false) goto L27;
        TextView r6 = this.a.o;
        if (r6 == null) goto L28;
        r6.setText(s1.B(2131919917));
        return;
    L28:
        return;
    L27:
        return;
    }
}

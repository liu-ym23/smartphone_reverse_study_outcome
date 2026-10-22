package com.bytedance.android.livesdk.interactivity.roomintro.view;

import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ RoomIntroDialogV2 a;

    public q(RoomIntroDialogV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        if (((gz.b) r4) == null) goto L24;
        ViewGroup r5 = this.a.q;
        if (r5 == null) goto L8;
        UtilityKotlinExtentionsKt.w(r5);
    L8:
        RoomIntroDialogV2 r6 = this.a;
        TextView r0 = r6.r;
        if (r0 == null) goto L23;
        RoomIntroDataSource r7 = r6.d;
        gz.b r1 = null;
        if (r7 == null) goto L21;
        PropertyOwner r8 = r7.m;
        if (r8 == null) goto L15;
        r1 = (gz.b) r8.a;
    L15:
        if (r1 != null) goto L17;
    L19:
        gz.b r9 = s1.B(2131919909);
    L20:
        r1 = r9;
        goto L21
    L17:
        if (r1.a != true) goto L19;
        r9 = r1.b;
    L21:
        r0.setText(r1);
        return;
    L23:
        return;
    }
}

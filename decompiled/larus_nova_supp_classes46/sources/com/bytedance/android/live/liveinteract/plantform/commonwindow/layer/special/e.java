package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class e extends jg0.a<MultiLinkSpecialViewBinder.a> {
    public MultiLinkSpecialViewBinder.a e;
    public HSImageView f;
    public View g;
    public ImageView h;

    public void r() {
        throw null;
    }

    @Override // jg0.c, jg0.f
    public void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.a(r2);
        this.f = q().findViewById(2131389536);
        this.h = (ImageView) q().findViewById(2131389651);
        this.g = q().findViewById(2131389539);
        TextView r3 = (TextView) q().findViewById(2131389541);
    }

    public void s(MultiLinkSpecialViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        this.e = r2;
        if (r2 != null) goto L5;
    L9:
        ImageView r3 = this.h;
        if (r3 == null) goto L12;
        UtilityKotlinExtentionsKt.t(r3);
    L12:
        r();
        return;
    L5:
        if (r2.l != LinkmicPositionItem.LinkmicPositionStatus.LOCKED.ordinal()) goto L9;
        ImageView r4 = this.h;
        if (r4 == null) goto L12;
        UtilityKotlinExtentionsKt.w(r4);
        goto L12
    }

    public e(MicSeatScene r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        super(r2, r3);
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void k(Object r1, int r2, Bundle r3) {
        t((MultiLinkSpecialViewBinder.a) r1, r2, r3);
    }

    public void t(MultiLinkSpecialViewBinder.a r1, int r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "itemData");
        Intrinsics.checkNotNullParameter(r3, "payload");
        this.e = r1;
    }
}

package pg0;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.view.PositionNameTv;
import com.bytedance.android.live.liveinteract.view.SeatPosTagLabelTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends b {
    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.a k;

    @Override // pg0.b, jg0.c
    public final int o() {
        return 2131566565;
    }

    @Override // pg0.b, jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkFloatWindow1v8SmallGuestStatusLayer.name();
    }

    @Override // pg0.e
    public final void r() {
        View r0 = this.k.m(2131362580);
        if (r0 == null) goto L19;
        this.e = (TextView) r0;
        Object r1 = this.k.m(2131389701);
        if (r1 == null) goto L17;
        this.f = (PositionNameTv) r1;
        Object r2 = this.k.m(2131389764);
        if (r2 == null) goto L15;
        this.g = (SeatPosTagLabelTextView) r2;
        View r3 = this.k.m(2131389660);
        if (r3 == null) goto L13;
        this.h = (TextView) r3;
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.view.SeatPosTagLabelTextView");
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.view.PositionNameTv");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public a(MicSeatScene r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.a r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "basicLayer");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r2, r4);
        this.k = r3;
    }
}

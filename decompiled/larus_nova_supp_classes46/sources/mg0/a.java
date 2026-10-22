package mg0;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkPCLandscapeViewBinder;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends jg0.a<MultiLinkPCLandscapeViewBinder.a> {
    @Override // jg0.c
    public final int o() {
        return 2131566597;
    }

    @Override // jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkPCLandscapeMicSeatBasicLayer.name();
    }

    @Override // jg0.c, jg0.f
    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.a(r2);
        HSImageView r3 = q().findViewById(2131389536);
    }

    @Override // jg0.c, jg0.f
    public final void j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public a(MicSeatScene r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        super(r2, r3);
    }

    @Override // jg0.f
    public final void d(Object r1, int r2) {
        Intrinsics.checkNotNullParameter((MultiLinkPCLandscapeViewBinder.a) r1, "itemData");
    }

    @Override // jg0.f
    public final void k(Object r1, int r2, Bundle r3) {
        Intrinsics.checkNotNullParameter((MultiLinkPCLandscapeViewBinder.a) r1, "itemData");
        Intrinsics.checkNotNullParameter(r3, "payload");
    }
}

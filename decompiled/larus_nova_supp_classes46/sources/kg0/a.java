package kg0;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import jg0.c;
import kotlin.jvm.internal.Intrinsics;
import tf0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends c<e> {
    @Override // jg0.c
    public final int o() {
        return 2131566599;
    }

    @Override // jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkDummyLayer.name();
    }

    public a(MicSeatScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        super(r2, null);
    }

    @Override // jg0.f
    public final void d(Object r1, int r2) {
        Intrinsics.checkNotNullParameter((e) r1, "itemData");
    }

    @Override // jg0.f
    public final void k(Object r1, int r2, Bundle r3) {
        Intrinsics.checkNotNullParameter((e) r1, "itemData");
        Intrinsics.checkNotNullParameter(r3, "payload");
    }
}

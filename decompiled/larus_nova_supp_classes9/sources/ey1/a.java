package ey1;

import android.content.Context;
import com.bytedance.android.livesdk.gift.blindbox.BlindBoxGiftPlugin;
import com.bytedance.android.livesdk.gift.blindbox.c;
import com.bytedance.android.livesdk.gift.platform.business.h;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements h.a {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h.a
    public final h a(DataCenter r8, Context r9) {
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        Intrinsics.checkNotNullParameter(r9, "context");
        IRoom r0 = (IRoom) r8.get("data_room", null);
        if (r0 == null) goto L5;
        boolean r2 = r0.isMediaRoom();
    L6:
        if (r0 == null) goto L8;
        long r3 = r0.getId();
    L9:
        JSONObject r1 = new JSONObject();
        c.f(r1, "is_enabled", Boolean.TRUE);
        c.f(r1, "room_id", Long.valueOf(r3));
        c.f(r1, "is_media_room", Boolean.valueOf(r2));
        c.e("ttlive_blind_box_plugin_status", 0, r1);
        jy0.b.a("ttlive_blind_box", "ttlive_blind_box_plugin_status " + r1);
        return new BlindBoxGiftPlugin(r8, r9);
    L8:
        r3 = 0;
        goto L9
    L5:
        r2 = false;
        goto L6
    }
}

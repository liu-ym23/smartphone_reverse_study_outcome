package com.bytedance.android.live.network.impl.interceptor;

import android.content.DialogInterface;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements DialogInterface.OnClickListener {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r6) {
        Map r7 = MapsKt.mapOf(TuplesKt.to("button_type", "cancel"));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_face_verification_popup_click", r7, new Object[]{am2.x.class, Room.class});
        r5.dismiss();
    }
}

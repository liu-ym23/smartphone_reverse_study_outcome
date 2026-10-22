package com.bytedance.android.live.network.impl.interceptor;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements DialogInterface.OnClickListener {
    public final /* synthetic */ Activity a;

    public g(Activity r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r6) {
        Map r7 = MapsKt.mapOf(TuplesKt.to("button_type", "confirm"));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_face_verification_popup_click", r7, new Object[]{am2.x.class, Room.class});
        Pattern r8 = DSLimitInterceptor.a;
        DSLimitInterceptor.d(this.a, PbRequest.SwitchType.RECHARGE);
        r5.dismiss();
    }
}

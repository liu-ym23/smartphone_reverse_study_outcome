package ek0;

import am2.x;
import am2.z;
import android.content.DialogInterface;
import android.os.Bundle;
import com.bytedance.android.live.broadcast.api.model.IMiddlewareAnchorVideoResolutionManager;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements DialogInterface.OnClickListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ Bundle b;

    public b(c r1, Bundle r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dialog");
        if (this.a.getContext() == null) goto L7;
        DataCenter r7 = this.a.c;
        if (r7 == null) goto L7;
        r7.put("cmd_exit_room", this.b);
    L7:
        this.a.getClass();
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("resolution", ((IMiddlewareAnchorVideoResolutionManager) va1.b.a.a.a(IMiddlewareAnchorVideoResolutionManager.class)).getCurrentResolution());
        j0 r0 = j0.l();
        x r2 = new x();
        r2.b = "live_take_detail";
        r2.e = "click";
        r2.a = "live_take";
        r0.sendLog("livesdk_anchor_close_live_confirm", r8, new Object[]{IRoom.class, r2, new z()});
        r5.dismiss();
    }
}

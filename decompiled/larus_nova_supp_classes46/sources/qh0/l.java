package qh0;

import am2.x;
import android.content.DialogInterface;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements DialogInterface.OnClickListener {
    public final /* synthetic */ h a;

    public l(h r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r6) {
        this.a.e.invoke();
        HashMap r7 = new HashMap();
        r7.put("verify_type", "underage");
        j0.l().sendLog("livesdk_guest_connection_verify_popup_click", r7, new Object[]{IRoom.class, new x()});
        r5.dismiss();
    }
}

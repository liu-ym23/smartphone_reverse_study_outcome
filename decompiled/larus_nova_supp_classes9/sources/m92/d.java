package m92;

import android.view.View;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.p;
import com.bytedance.android.livesdk.interactivity.pin.business.microapp.PinMicroAppHighlightPageItemView;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.i;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ PinMicroAppHighlightPageItemView a;
    public final /* synthetic */ String b;

    public d(PinMicroAppHighlightPageItemView r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        PinMicroAppHighlightPageItemView r9 = this.a;
        String r0 = this.b;
        int r1 = PinMicroAppHighlightPageItemView.n;
        r9.getClass();
        if (r0 == null) goto L17;
        RoomContext r10 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r10 == null) goto L12;
        i r11 = r10.isAnchor();
        if (r11 == null) goto L12;
        Boolean r13 = (Boolean) r11.getValue();
        if (r13 == null) goto L12;
        r13.booleanValue();
    L12:
        Pair r14 = p.b(r0, "live_other", g4.d(), "comment_pin", "comment_pin", LaunchParamConstant.Scene.c);
        if (r14 == null) goto L18;
        u.l().h("mp_click", (Map) r14.getSecond(), new Object[]{Room.class});
        TTLiveSDK.hostService().hostOpenPlatform().openMiniApp((String) r14.getFirst(), null);
        return;
    L18:
        return;
    }
}

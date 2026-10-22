package cp0;

import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.live.openplatform.impl.miniappanchor.cast.AnchorCastContextService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.live.datacontext.j;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ AnchorCastContextService a;

    public a(AnchorCastContextService r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        Long r10 = (Long) r9;
        AnchorCastContextService r11 = this.a;
        int r0 = AnchorCastContextService.e;
        uq0.a r12 = r11.a;
        if (r12 == null) goto L12;
        JSONObject r4 = new JSONObject().put("path", r12.b).put("query", m.g(r12.c)).put("app_id", r12.a);
        int r13 = qo0.a.a;
        qo0.a.c("AnchorCastContextService", "miniapp_anchor_operation_page_sei: " + r4);
        RoomContext r14 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r14 == null) goto L13;
        j r15 = r14.getLiveStream();
        if (r15 == null) goto L14;
        com.bytedance.android.live.pushstream.d r2 = (com.bytedance.android.live.pushstream.d) r15.getValue();
        if (r2 == null) goto L15;
        r2.c1("miniapp_anchor_operation_page_sei", r4, 1, false, false);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}

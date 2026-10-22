package ii0;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;
import rj0.k;
import rj0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends BaseMonitor {
    public static final b a = null;

    static {
        a = new b();
    }

    public static boolean l() {
        k.m2.getClass();
        if (k.a.a() != null) goto L15;
        l.n2.getClass();
        l r0 = l.a.a();
        if (r0 != null) goto L7;
    L8:
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r1 = IVoiceChatAdminService.a.a();
        if (r1 != null) goto L11;
    L13:
        return false;
    L11:
        if (r1.isEngineOn() != true) goto L13;
        return true;
    L7:
        if (r0.isEngineOn() != true) goto L8;
        return true;
    L15:
        return true;
    }

    public b() {
    }

    public static void m(Throwable r3, JSONObject r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if ((r3 instanceof ApiServerException) == false) goto L9;
        ApiServerException r5 = (ApiServerException) r3;
        r4.put("error_code", r5.getErrorCode());
        String r6 = r5.getErrorMsg();
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r4.put("error_msg", r6);
        return;
    L9:
        r4.put("error_code", -1);
        r4.put("error_msg", r3.toString());
    }

    public final void o(String r4, JSONObject r5) {
        JSONObject r0 = new JSONObject();
        r0.put("event_name", r4);
        LiveTracingMonitor.f("ttlive_guest_battle_event", LiveTracingMonitor.EventModule.BIG_PARTY, r0, new JSONObject(), r5);
    }

    public final void n(String r5, String r6, String r7, ExceptionResult r8) {
        JSONObject r0 = new JSONObject();
        BaseMonitor.add(r0, "business_api_name", "guest_battle_sticker_load_finish");
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        BaseMonitor.add(r0, "effectName", r5);
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        BaseMonitor.add(r0, "effectId", r6);
        BaseMonitor.add(r0, "dressId", "");
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        BaseMonitor.add(r0, "id", r7);
        if (r8 == null) goto L14;
        BaseMonitor.add(r0, "error_code", r8.getErrorCode());
        BaseMonitor.add(r0, "msg", r8.getMsg());
        BaseMonitor.add(r0, "extra", r8.toString());
        BaseMonitor.add(r0, "success", "0");
    L15:
        o("guest_battle_sticker_load_finish", r0);
        x.t0("guest_battle_sticker_load_finish", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("extra", r0.toString())}));
        return;
    L14:
        BaseMonitor.add(r0, "success", "1");
        goto L15
    }
}

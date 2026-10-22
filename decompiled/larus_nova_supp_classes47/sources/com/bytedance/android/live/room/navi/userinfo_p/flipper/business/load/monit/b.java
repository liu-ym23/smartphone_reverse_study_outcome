package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.t;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements Runnable {
    public final /* synthetic */ AnchorTextInfoChangeMonitor a;

    public b(AnchorTextInfoChangeMonitor r1) {
        this.a = r1;
    }

    public final void a() {
        ALogger.i("AnchorTextInfoChangeMonitor", "run task");
        AnchorTextInfoChangeMonitor r0 = this.a;
        r0.e(r0.m);
        o91.a.C0285a r1 = o91.a.a;
        r1.getClass();
        o91.a.C0285a.a = false;
        if (this.a.i.isEmpty() == false) goto L9;
        Disposable r2 = this.a.j;
        if (r2 == null) goto L7;
        r2.dispose();
    L7:
        ALogger.i("AnchorTextInfoChangeMonitor", "end interval task");
        return;
    L9:
        tlc.d r3 = this.a.i.pollFirst();
        if ((r3 instanceof t) == true) goto L12;
        r3 = null;
    L12:
        t r4 = (t) r3;
        AnchorTextInfoChangeMonitor r5 = this.a;
        r5.k.e = r4;
        r5.e(r5.l);
        if (r4 != null) goto L15;
    L17:
        AnchorTextInfoChangeMonitor r6 = this.a;
        r6.getClass();
        if ((r4 instanceof t) == false) goto L24;
        Map r7 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("anchor_id", a0.n(r6.f).getOwnerUserIdString().toString()), TuplesKt.to("room_id", a0.n(r6.f).getIdStr()), TuplesKt.to("biz_type", String.valueOf(r4.bizType))});
        String r8 = r4.extra;
        if (r8 != null) goto L23;
        r8 = "";
    L23:
        r7.putAll(JsonUtil.jsonObjectToMap(new JSONObject(r8)));
        j0.l().sendLog("livesdk_anchor_profile_module_abnormal_info_entrance_show", r7, new Object[0]);
    L24:
        ALogger.i("AnchorTextInfoChangeMonitor", "begin show view, list remain size: " + this.a.i.size());
        return;
    L15:
        if (r4.bizType != BizType.ANCHOR_BIZ_PANEL.getValue()) goto L17;
        r1.getClass();
        o91.a.C0285a.a = true;
        goto L17
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

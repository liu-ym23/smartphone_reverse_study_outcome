package com.bytedance.android.live.profit.taskcenter.preload;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;

    public i(d r1, long r2, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r12) {
        Long r13 = (Long) r12;
        d r14 = this.a;
        long r1 = this.b;
        String r3 = this.c;
        r14.getClass();
        ALogger.i("TaskCenterService", "preload task center data api.");
        m r0 = o3.f().C1();
        boolean r4 = true;
        if (r0 == null) goto L17;
        Map r2 = (Map) r0.getValue();
        if (r2 == null) goto L17;
        String r5 = (String) r2.get("gold_pendant_count_down");
        if (r5 == null) goto L11;
        Integer r6 = StringsKt.toIntOrNull(r5);
        if (r6 == null) goto L11;
        int r7 = r6.intValue();
    L12:
        if (r7 <= 0) goto L14;
        boolean r8 = true;
    L15:
        if (r8 != true) goto L17;
    L18:
        JSONObject r9 = new JSONObject();
        d60.b.a(r9, "enter_method", d.a("enter_method"));
        d60.b.a(r9, "enter_from_merge", d.a("enter_from_merge"));
        d60.b.a(r9, "preload_source", "all");
        d60.b.a(r9, "live_enter_source", d.a("enter_from_merge") + '-' + d.a("enter_method"));
        d60.b.a(r9, "task_center_refactor_v1", 1);
        d60.b.a(r9, "request_id", r14.f.getRoom().getRequestId());
        if (r4 == false) goto L21;
        d60.b.a(r9, "hash_gold_box", 1);
    L21:
        RxUtilKt.c(((ITaskCenterApi) vh6.c.b(com.bytedance.android.livesdk.revenue.service.network.a.class).getService(ITaskCenterApi.class)).getTaskCenterData(r1, r3, 1, r9.toString()).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r14), f.a), r14.a);
        return;
    L14:
        r8 = false;
    L11:
        r7 = 0;
    L17:
        r4 = false;
        goto L18
    }
}

package com.bytedance.android.anniex.monitor;

import com.bytedance.ies.bullet.core.k;
import i36.d;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class MonitorManager$onLynxViewAsyncLayoutEnd$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $sessionId;
    final /* synthetic */ boolean $success;

    public MonitorManager$onLynxViewAsyncLayoutEnd$1(String r1, boolean r10) {
        this.$sessionId = r1;
        this.$success = r10;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m262invoke() {
        Map<String, d> r0 = MonitorManager.a;
        k r1 = MonitorManager.f(this.$sessionId);
        JSONObject r10 = new JSONObject();
        r10.put("lynx_async_layout_result", this.$success);
        r1.b(r10, null);
        ExecutorService r11 = com.bytedance.ies.bullet.service.monitor.a.a;
        com.bytedance.ies.bullet.service.monitor.a.c(this.$sessionId, "lynx_async_layout_result", Boolean.valueOf(this.$success));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m262invoke();
        return Unit.INSTANCE;
    }
}

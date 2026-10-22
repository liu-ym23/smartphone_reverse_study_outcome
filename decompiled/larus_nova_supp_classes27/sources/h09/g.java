package h09;

import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class g implements Function0 {
    public final /* synthetic */ long a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;

    public /* synthetic */ g(long r1, long r3, int r5) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
    }

    public final Object invoke() {
        long r0 = this.a;
        long r2 = this.b;
        int r4 = this.c;
        JSONObject r5 = new JSONObject();
        r5.put("total_cost", r0);
        r5.put("register_audit_cost", r2);
        r5.put("launch_stage", r4);
        return r5;
    }
}

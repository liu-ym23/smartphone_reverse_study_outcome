package f2;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ h2.a a;

    public /* synthetic */ a(h2.a r1) {
        this.a = r1;
    }

    public final Object invoke() {
        h2.a r0 = this.a;
        com.bytedance.ai.settings.d r1 = com.bytedance.ai.settings.d.a;
        boolean r10 = r0.k;
        r1.getClass();
        com.bytedance.ai.settings.d.b = r10;
        g37.a r11 = g37.a.c("flow_ai_sdk");
        r11.a = new com.bytedance.ai.settings.c();
        g37.a.c("flow_ai_sdk").e(true);
        return Unit.INSTANCE;
    }
}

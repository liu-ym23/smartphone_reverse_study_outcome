package m5;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class w implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Map c;

    public /* synthetic */ w(String r1, long r10, Map r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final Object invoke() {
        String r0 = this.a;
        long r1 = this.b;
        Map<? extends String, ? extends Object> r10 = this.c;
        com.bytedance.ai.utils.g r11 = com.bytedance.ai.utils.g.a;
        r11.d("AppletEventMonitorManager", "onLoadTemplateEnd: " + r0);
        i1 r12 = y0.a;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r0, "traceId");
        Intrinsics.checkNotNullParameter(r10, "eventInfo");
        r11.d(r12.h, "onLoadTemplateEnd: " + r0 + ", " + r1);
        h1 r13 = d1.d(r12.c, r0);
        r13.d("applet_load_widget_template_end", Long.valueOf(r1));
        d1.a(r12.e, r0).d.putAll(r10);
        d1.b(r12.d, r0).d("load_template_duration", Long.valueOf(r1 - r13.c("applet_load_widget_template_start")));
        return Unit.INSTANCE;
    }
}

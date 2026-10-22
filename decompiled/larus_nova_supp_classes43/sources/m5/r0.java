package m5;

import android.util.LruCache;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class r0 implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ Map d;

    public /* synthetic */ r0(String r1, String r10, long r11, Map r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }

    public final Object invoke() {
        String r0 = this.a;
        String r1 = this.b;
        long r10 = this.c;
        Map<? extends String, ? extends Object> r11 = this.d;
        com.bytedance.ai.utils.g r12 = com.bytedance.ai.utils.g.a;
        r12.d("AppletEventMonitorManager", "onReplyMessageReceived: " + r0);
        i1 r13 = y0.a;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r0, "traceId");
        Intrinsics.checkNotNullParameter(r1, "replyId");
        r12.d(r13.h, "onReplyMessageReceived: " + r0 + ", " + r1 + ", " + r10);
        long r14 = d1.c(r13.g, r1).c("user_input");
        if (r14 <= 0) goto L11;
        h1 r15 = d1.c(r13.g, r0);
        r15.d("reply_message", Long.valueOf(r10));
        r15.d("user_input", Long.valueOf(r14));
        if (r11 == null) goto L11;
        LruCache<String, Map<String, Object>> r16 = r13.i;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Intrinsics.checkNotNullParameter(r0, "traceId");
        Map<String, Object> r17 = r16.get(r0);
        if (r17 != null) goto L9;
        r17 = new LinkedHashMap();
        r16.put(r0, r17);
    L9:
        r17.putAll(r11);
    L11:
        return Unit.INSTANCE;
    }
}

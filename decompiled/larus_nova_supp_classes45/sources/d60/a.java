package d60;

import a60.d;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final AtomicLong a = null;

    static {
        a = new AtomicLong();
    }

    public static final JSONObject a(List<d> r11) {
        Intrinsics.checkNotNullParameter(r11, "events");
        List<d> r12 = r11;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L31;
        d r1 = (d) r13.next();
        Intrinsics.checkNotNullParameter(r1, "event");
        e r3 = r1.a;
        JSONObject r4 = r1.b;
        JSONObject r5 = r1.c;
        JSONObject r2 = r1.d;
        Intrinsics.checkNotNullParameter(r3, "traceMeta");
        JSONObject r6 = new JSONObject();
        b.a(r6, "event_type", r3.a);
        b.a(r6, "business_type", r3.b);
        b.a(r6, "trace_id", r3.c);
        b.a(r6, "log_id", r3.d);
        b.a(r6, "product_id", r3.e);
        b.a(r6, "step", r3.f);
        b.a(r6, "room_id", r3.g);
        b.a(r6, "anchor_id", r3.h);
        b.a(r6, "user_id", r3.i);
        Integer r7 = r3.j;
        JSONObject r8 = null;
        if (r7 == null) goto L8;
        String r9 = String.valueOf(r7.intValue());
    L9:
        b.a(r6, "err_code", r9);
        b.a(r6, "err_msg", r3.k);
        b.a(r6, "index", r3.l);
        IMiddleWareHostContext r14 = k.f(IMiddleWareHostContext.class);
        if (r14 == null) goto L14;
        String r15 = r14.getChannel();
        if (r15 == null) goto L14;
        b.a(r6, "channel", r15);
    L14:
        if (r2 != null) goto L16;
    L18:
        b.a(r6, "category", r4);
        b.a(r6, "metric", r5);
        if (r2 == null) goto L30;
        JSONObject r16 = new JSONObject();
        Iterator<String> r17 = r2.keys();
    L23:
        if (r17.hasNext() == false) goto L29;
        String r18 = r17.next();
        Object r19 = r2.opt(r18);
        if (r19 == null) goto L27;
        String r21 = r19.toString();
    L28:
        b.a(r16, r18, r21);
        goto L23
    L27:
        r21 = null;
        goto L28
    L29:
        r8 = r16;
    L30:
        b.a(r6, "extra", r8);
        r0.add(r6);
        goto L4
    L16:
        if (r2.opt("timestamp") == null) goto L18;
        b.a(r6, "timestamp", Long.valueOf(r2.optLong("timestamp")));
        goto L18
    L8:
        r9 = null;
        goto L9
    L31:
        JSONObject r110 = new JSONObject();
        b.a(r110, "timestamp", Long.valueOf(System.currentTimeMillis()));
        b.a(r110, "seq_num", Long.valueOf(a.getAndIncrement()));
        b.a(r110, "data", r0);
        return r110;
    }
}

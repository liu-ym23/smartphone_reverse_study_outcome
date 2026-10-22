package com.bytedance.android.livesdk.dynamicstrategy.impl.nfa;

import com.bytedance.android.livesdk.log.filter.v;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements v {
    public static final List<a> a = null;
    public static final f b = null;

    public interface a {
        void a(String r1, Map<String, Object> r2);
    }

    public static final class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Map b;

        public b(String r1, Map r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator r0 = ((ArrayList) f.a).iterator();     // Catch: Throwable -> L7
        L4:
            if (r0.hasNext() == false) goto L16;
            ((a) r0.next()).a(this.a, this.b);     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public f() {
    }

    public final void Rd() {
    }

    public final void onRemove() {
    }

    static {
        b = new f();
        a = new ArrayList();
    }

    public static void a(String r3, Map r4) {
        Intrinsics.checkNotNullParameter(r3, "eventKey");
        Intrinsics.checkNotNullParameter(r4, "eventParams");
        Map r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("event_info.name", r3)});
        Iterator r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) r5.next();
        String r2 = (String) r1.getValue();
        if (r2 == null) goto L4;
        r0.put(r1.getKey(), r2);
        goto L4
    L8:
        AndroidSchedulers.mainThread().scheduleDirect(new b(r3, r0));
    }

    public final void L9(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        a(r2, r3);
    }
}

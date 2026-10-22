package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiRegisterViewListenContext {
    public final HashMap<CallContext, List<String>> a;
    public final HashMap<Object, CallContext> b;
    public final Map<String, LiveData<Pair<String, JSONObject>>> c;
    public final MultiRegisterViewListenContext$sendDataToLynxObserver$1 d;
    public final HashMap<String, LiveData<?>> e;

    public final void a() {
        Iterator<String> r0 = this.e.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = r0.next();
        LiveData r2 = (LiveData) ((LinkedHashMap) this.c).get(r1);
        if (r2 == null) goto L4;
        x.e(r2, this.d);
        goto L4
    }

    public final void b() {
        Iterator<String> r0 = this.e.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = r0.next();
        LiveData r2 = (LiveData) ((LinkedHashMap) this.c).get(r1);
        if (r2 == null) goto L4;
        r2.removeObserver(this.d);
        goto L4
    L8:
        HashMap<CallContext, List<String>> r3 = this.a;
        if (r3 == null) goto L11;
        r3.clear();
    L11:
        HashMap<Object, CallContext> r4 = this.b;
        if (r4 == null) goto L20;
        r4.clear();
        return;
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.MultiRegisterViewListenContext$sendDataToLynxObserver$1] */
    public MultiRegisterViewListenContext(HashMap<String, LiveData<?>> r6) {
        Intrinsics.checkNotNullParameter(r6, "dataMap");
        this.e = r6;
        this.a = new HashMap();
        this.b = new HashMap();
        LinkedHashMap r0 = new LinkedHashMap(MapsKt.mapCapacity(r6.size()));
        Iterator<T> r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r7.next();
        Object r2 = r1.getKey();
        String r3 = (String) r1.getKey();
        r0.put(r2, e.b((LiveData) r1.getValue(), r3, FormatType.NEW));
        goto L4
    L6:
        this.c = r0;
        this.d = new MultiRegisterViewListenContext$sendDataToLynxObserver$1(this);
    }

    public final void d(CallContext r5) {
        Intrinsics.checkNotNullParameter(r5, "callContext");
        HashMap<Object, CallContext> r0 = this.b;
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r0.containsKey(r5.d) == false) goto L6;
        HashMap<CallContext, List<String>> r1 = this.a;
        HashMap<Object, CallContext> r2 = this.b;
        Intrinsics.checkNotNullParameter(r5, "context");
        r1.remove(r2.get(r5.d));
        HashMap<Object, CallContext> r3 = this.b;
        Intrinsics.checkNotNullParameter(r5, "context");
        r3.remove(r5.d);
        return;
    }

    public final void c(CallContext r6, List<String> r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "tags");
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        HashMap<Object, CallContext> r1 = this.b;
        Intrinsics.checkNotNullParameter(r6, "context");
        if (r1.containsKey(r6.d) == false) goto L8;
        HashMap<CallContext, List<String>> r2 = this.a;
        HashMap<Object, CallContext> r3 = this.b;
        Intrinsics.checkNotNullParameter(r6, "context");
        r2.remove(r3.get(r6.d));
        HashMap<Object, CallContext> r4 = this.b;
        Intrinsics.checkNotNullParameter(r6, "context");
        r4.remove(r6.d);
    L8:
        HashMap<Object, CallContext> r5 = this.b;
        Intrinsics.checkNotNullParameter(r6, "context");
        r5.put(r6.d, r6);
        this.a.put(r6, r7);
        Map<String, LiveData<Pair<String, JSONObject>>> r8 = this.c;
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator r10 = ((LinkedHashMap) r8).entrySet().iterator();
    L10:
        if (r10.hasNext() == false) goto L14;
        Map.Entry r12 = (Map.Entry) r10.next();
        if (r7.contains((String) r12.getKey()) == false) goto L10;
        r9.put(r12.getKey(), r12.getValue());
        goto L10
    L14:
        Iterator r13 = r9.entrySet().iterator();
    L16:
        if (r13.hasNext() == false) goto L21;
        Map.Entry r14 = (Map.Entry) r13.next();
        String r15 = (String) r14.getKey();
        Pair r16 = (Pair) ((LiveData) r14.getValue()).getValue();
        if (r16 == null) goto L16;
        String r17 = (String) r16.component1();
        JSONObject r18 = (JSONObject) r16.component2();
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter("H5_revenueInteractData", "key");
        Intrinsics.checkNotNullParameter(r18, "value");
        r6.b("H5_revenueInteractData", r18);
        goto L16
    }
}

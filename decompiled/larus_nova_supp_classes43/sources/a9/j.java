package a9;

import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.xbridge.mix.DefaultMixMethodCache;
import com.bytedance.android.annie.xbridge.mix.StateMethodFinder;
import com.bytedance.android.annie.xbridge.mix.k;
import com.bytedance.android.annie.xbridge.mix.t;
import com.bytedance.ies.web.jsbridge2.d0;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j implements i {
    public static final j a = null;
    public static final Collection<WeakReference<JSBridgeManager>> b = null;
    public static final Collection<y6.a> c = null;

    public j() {
    }

    static {
        a = new j();
        b = new CopyOnWriteArraySet();
        c = new CopyOnWriteArraySet();
    }

    public static void H1(JSBridgeManager r10) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        Collection<WeakReference<JSBridgeManager>> r0 = b;
        CopyOnWriteArraySet r1 = (CopyOnWriteArraySet) r0;
        r1.add(new WeakReference(r10));
    }

    public static void I1(JSBridgeManager r10) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        Iterator r0 = ((CopyOnWriteArraySet) b).iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        WeakReference r1 = (WeakReference) r0.next();
        if (Intrinsics.areEqual(r1.get(), r10) == false) goto L4;
        ((CopyOnWriteArraySet) b).remove(r1);
        return;
    }

    @Override // a9.i
    public final void I0(y6.a r10) {
        Intrinsics.checkNotNullParameter(r10, "factory");
        if (((CopyOnWriteArraySet) c).add(r10) == false) goto L21;
        Iterator r1 = ((CopyOnWriteArraySet) b).iterator();
    L6:
        if (r1.hasNext() == false) goto L21;
        JSBridgeManager r11 = (JSBridgeManager) ((WeakReference) r1.next()).get();
        if (r11 == null) goto L6;
        Intrinsics.checkNotNullParameter(r10, "factory");
        Iterator<T> r12 = r10.d(r11).entrySet().iterator();
    L11:
        if (r12.hasNext() == false) goto L13;
        Map.Entry r13 = (Map.Entry) r12.next();
        r11.registerMethod((String) r13.getKey(), (n56.c) r13.getValue());
        goto L11
    L13:
        Iterator<T> r14 = r10.n(r11).entrySet().iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        Map.Entry r15 = (Map.Entry) r14.next();
        r11.registerMethod((String) r15.getKey(), (com.bytedance.ies.web.jsbridge2.g) r15.getValue());
        goto L15
    L17:
        Iterator<T> r16 = r10.k(r11).entrySet().iterator();
    L19:
        if (r16.hasNext() == false) goto L6;
        Map.Entry r17 = (Map.Entry) r16.next();
        r11.registerMethod((String) r17.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r17.getValue());
    L21:
        com.bytedance.android.annie.xbridge.mix.e r18 = t.a;
        Intrinsics.checkNotNullParameter(r10, "factory");
        t.b.add(r10);
        if (com.bytedance.ies.bullet.service.base.h.W() == false) goto L39;
        ConcurrentHashMap<String, Integer> r0 = t.e;
        String r19 = r10.a();
        Integer r20 = r0.get(r10.a());
        int r21 = 1;
        if (r20 == null) goto L26;
        r21 = 1 + r20.intValue();
    L26:
        r0.put(r19, Integer.valueOf(r21));
        Integer r22 = r0.get(r10.a());
        if (r22 != null) goto L29;
        return;
    L29:
        if (r22.intValue() <= 10) goto L41;
        com.bytedance.android.monitorV2.g r23 = com.bytedance.android.monitorV2.g.e();
        jz2.d.a r24 = new jz2.d.a("anniex_live_jsb_factory_register_warning");
        r24.b = "webcast_cn_container";
        r24.b(0);
        JSONObject r25 = new JSONObject();
        r25.put("businessType", r10.a());
        Unit r26 = Unit.INSTANCE;
        r24.d = r25;
        JSONObject r27 = new JSONObject();
        r27.put("count", r22.intValue());
        r24.e = r27;
        jz2.d r28 = r24.a();
        r23.getClass();
        com.bytedance.android.monitorV2.g.c(r28);
        return;
    L41:
        return;
    }

    @Override // a9.i
    public final void x0(y6.a r13) {
        Intrinsics.checkNotNullParameter(r13, "factory");
        Iterator r1 = ((CopyOnWriteArraySet) b).iterator();
    L4:
        if (r1.hasNext() == false) goto L29;
        JSBridgeManager r10 = (JSBridgeManager) ((WeakReference) r1.next()).get();
        if (r10 == null) goto L4;
        Intrinsics.checkNotNullParameter(r13, "factory");
        Iterator r11 = SetsKt.plus(SetsKt.plus(r13.k(r10).keySet(), r13.n(r10).keySet()), r13.d(r10).keySet()).iterator();
    L9:
        if (r11.hasNext() == false) goto L4;
        String r12 = (String) r11.next();
        if (Intrinsics.areEqual(r12, "getStorage") == false) goto L13;
    L14:
        com.bytedance.android.annie.param.a r14 = r10.a;
        if (r14 == null) goto L19;
        x8.b r15 = r14.d;
        if (r15 == null) goto L19;
        r15.e(r10.r, "===unregisterMethod url:" + r10.m + "  methodName:" + r12 + "===");
    L19:
        d0 r16 = r10.c;
        if (r16 == null) goto L23;
        r16.g(r12);
    L23:
        if (com.bytedance.ies.bullet.base.settings.c.a().f() != 1) goto L9;
        if (r10.u == false) goto L9;
        DefaultMixMethodCache r17 = r10.v;
        if (r17 == null) goto L9;
        r17.f(r12);
        goto L9
    L13:
        if (Intrinsics.areEqual(r12, "setStorage") == false) goto L19;
    L29:
        ((CopyOnWriteArraySet) c).remove(r13);
        com.bytedance.android.annie.xbridge.mix.e r18 = t.a;
        Intrinsics.checkNotNullParameter(r13, "factory");
        t.b.remove(r13);
        t.d.remove(r13);
        if (com.bytedance.ies.bullet.service.base.h.W() == false) goto L34;
        ConcurrentHashMap<String, Integer> r19 = t.e;
        Integer r20 = r19.get(r13.a());
        if (r20 == null) goto L34;
        r19.put(r13.a(), Integer.valueOf(r20.intValue() - 1));
    L34:
        CopyOnWriteArraySet r21 = (CopyOnWriteArraySet) t.c;
        r21.size();
        if (com.bytedance.ies.bullet.base.settings.c.a().f() != 1) goto L53;
        Iterator r22 = r21.iterator();
    L38:
        if (r22.hasNext() == false) goto L77;
        StateMethodFinder r23 = (StateMethodFinder) ((WeakReference) r22.next()).get();
        if (r23 == null) goto L38;
        Intrinsics.checkNotNullParameter(r13, "factory");
        y6.c r24 = new JSBridgeManager(null);
        Objects.toString(r13);
        System.currentTimeMillis();
        Iterator r25 = SetsKt.plus(SetsKt.plus(r13.k(r24).keySet(), r13.n(r24).keySet()), r13.d(r24).keySet()).iterator();
    L43:
        if (r25.hasNext() == false) goto L52;
        String r26 = (String) r25.next();
        if (Intrinsics.areEqual(r26, "getStorage") == true) goto L49;
        if (Intrinsics.areEqual(r26, "setStorage") == true) goto L49;
    L49:
        k r27 = r23.i;
        if (r27 == null) goto L43;
        Intrinsics.checkNotNullParameter(r26, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        r27.c.remove(r26);
        goto L43
    L52:
        r13.toString();
        System.currentTimeMillis();
        goto L38
    L77:
        return;
    }

    @Override // a9.i
    public final <T> void sendEventToAllJsBridges(String r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Iterator<T> r0 = b.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        JSBridgeManager r1 = (JSBridgeManager) ((WeakReference) r0.next()).get();
        if (r1 == null) goto L4;
        r1.sendJSEvent(r10, r11);
        goto L4
    }
}

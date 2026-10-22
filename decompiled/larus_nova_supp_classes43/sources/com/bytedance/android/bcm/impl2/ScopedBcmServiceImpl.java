package com.bytedance.android.bcm.impl2;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.SharedPreferenceUtil;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import pc.f;
import pc.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0006H\u0016R\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R'\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/bcm/impl2/ScopedBcmServiceImpl;", "Llc/d;", "Llc/f;", "config", "", "init", "", "biz", "Llc/c;", "getScope", "event", "btm", "", "isEventAppendBcmChainEnabled", "", "getEventAppendBcmChainMaxLength", "Lkc/a;", "chain", "filterBcmChain", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "bcmBizApiMap$delegate", "Lkotlin/Lazy;", "getBcmBizApiMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "bcmBizApiMap", "<init>", "()V", "bcm-impl-v2_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class ScopedBcmServiceImpl implements lc.d {
    private final String TAG;
    private final Lazy bcmBizApiMap$delegate;

    public static final class a implements Runnable {
        public a() {
        }

        public static void a() {
            Lazy r0 = ScopedBcmConfigManager.a;
            ALogger r1 = ALogger.d;
            r1.a("ScopedBcmConfigManager", false, ScopedBcmConfigManager$fetchBcmConfig$1.INSTANCE);
            BtmSetting.d.getClass();     // Catch: Throwable -> L22
            Gson r10 = BtmSetting.b();     // Catch: Throwable -> L22
            SharedPreferenceUtil r11 = (SharedPreferenceUtil) ScopedBcmConfigManager.c.getValue();     // Catch: Throwable -> L22
            if (r11 == null) goto L7;
            String r12 = r11.c("scope_list", "");     // Catch: Throwable -> L22
        L8:
            final pc.d r13 = (pc.d) r10.fromJson(r12, pc.d.class);     // Catch: Throwable -> L22
            if (r13 != null) goto L12;
            r13 = new pc.d();     // Catch: Throwable -> L22
        L12:
            r1.a("ScopedBcmConfigManager", false, new ScopedBcmConfigManager$loadFromCache$1(r13));     // Catch: Throwable -> L22
            Iterator<pc.e> r14 = r13.a().iterator();     // Catch: Throwable -> L22
        L13:
            if (r14.hasNext() == false) goto L32;
            pc.e r15 = r14.next();     // Catch: Throwable -> L22
            SharedPreferenceUtil r16 = (SharedPreferenceUtil) ScopedBcmConfigManager.c.getValue();     // Catch: Throwable -> L22
            if (r16 == null) goto L18;
            String r17 = r16.c("scope_config_" + r15.a(), "");     // Catch: Throwable -> L22
        L19:
            if (r17 == null) goto L13;
            String r18 = r15.a();     // Catch: Throwable -> L22
            BtmSetting.d.getClass();     // Catch: Throwable -> L22
            ScopedBcmConfigManager.a(r18, (f) BtmSetting.b().fromJson(r17, f.class));     // Catch: Throwable -> L22
            goto L13
        L18:
            r17 = null;
            goto L19
        L32:
            throw null;
        L7:
            r12 = null;
        L22:
            th = move-exception;
            ALogger.d.a("ScopedBcmConfigManager", false, new ScopedBcmConfigManager$loadFromCache$3(th));
            int r19 = b.a;
            com.bytedance.android.btm.impl.thread.b.e.a(new com.bytedance.android.bcm.impl2.a(ScopedBcmConfigManager$loadFromCache$4.INSTANCE, th), true);
            throw null;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final ConcurrentHashMap<String, lc.c> getBcmBizApiMap() {
        return (ConcurrentHashMap) this.bcmBizApiMap$delegate.getValue();
    }

    public ScopedBcmServiceImpl() {
        this.TAG = "ScopedBcmServiceImpl";
        this.bcmBizApiMap$delegate = LazyKt.lazy(ScopedBcmServiceImpl$bcmBizApiMap$2.INSTANCE);
    }

    @Override // lc.d
    public int getEventAppendBcmChainMaxLength(String r10) {
        Set r11 = (Set) ((ConcurrentHashMap) ScopedBcmConfigManager.b.getValue()).get(r10);
        int r0 = 0;
        if (r11 == null) goto L8;
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r0 = RangesKt.coerceAtLeast(r0, ((g) r12.next()).b.c());
    L8:
        return r0;
    }

    @Override // lc.d
    public lc.c getScope(String r10) {
        ConcurrentHashMap<String, lc.c> r0 = getBcmBizApiMap();
        lc.c r1 = r0.get(r10);
        if (r1 != null) goto L9;
        r1 = new ScopedBcmHolder(r10);
        lc.c r11 = r0.putIfAbsent(r10, r1);
        if (r11 == null) goto L9;
        r1 = r11;
    L9:
        return r1;
    }

    public void init(lc.f r10) {
        if (BtmSetting.d.c().a() == 1) goto L5;
        return;
    L5:
        ALogger.d.a(this.TAG, false, AnonymousClass1.INSTANCE);
        com.bytedance.android.btm.impl.thread.b.e.a(new a(), true);
    }

    public kc.a filterBcmChain(kc.a r10, String r11) {
        List<kc.a.C0174a> r0 = r10.a;
        ArrayList r1 = new ArrayList();
        Iterator<T> r12 = r0.iterator();
    L4:
        if (r12.hasNext() == false) goto L44;
        kc.a.C0174a r13 = (kc.a.C0174a) r12.next();
        int r14 = e.j;
        e r15 = new e();
        r15.c = r13.c;
        r15.e = r13.e;
        r15.f = r13.f;
        kc.a.C0174a.C0175a r16 = r13.g;
        if (r16 == null) goto L24;
        BcmParams r17 = r16.a;
        if (r17 == null) goto L24;
        Map<String, Object> r18 = r17.toMap();
        if (r18 == null) goto L24;
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r20 = r18.entrySet().iterator();
    L13:
        if (r20.hasNext() == false) goto L22;
        Map.Entry<String, Object> r21 = r20.next();
        String r22 = r21.getKey();
        String r23 = r13.c;
        if (r23 != null) goto L19;
        r23 = "";
    L19:
        if (isEventAppendBcmChainEnabled(r11, r23) == false) goto L13;
        r19.put(r21.getKey(), r21.getValue());
        goto L13
    L22:
        if ((!r19.isEmpty()) == false) goto L24;
        r15.h = cd.a.a(r19);
    L24:
        kc.a.C0174a.C0175a r24 = r13.g;
        if (r24 == null) goto L43;
        BcmParams r25 = r24.b;
        if (r25 == null) goto L43;
        Map<String, Object> r26 = r25.toMap();
        if (r26 == null) goto L43;
        LinkedHashMap r27 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r28 = r26.entrySet().iterator();
    L32:
        if (r28.hasNext() == false) goto L41;
        Map.Entry<String, Object> r29 = r28.next();
        String r30 = r29.getKey();
        String r31 = r13.c;
        if (r31 != null) goto L38;
        r31 = "";
    L38:
        if (isEventAppendBcmChainEnabled(r11, r31) == false) goto L32;
        r27.put(r29.getKey(), r29.getValue());
        goto L32
    L41:
        if ((!r27.isEmpty()) == false) goto L43;
        r15.i = cd.a.a(r27);
    L43:
        r1.add(r15);
        goto L4
    L44:
        r10.a = r1;
        return r10;
    }

    @Override // lc.d
    public boolean isEventAppendBcmChainEnabled(String r10, String r11) {
        Set r12 = (Set) ((ConcurrentHashMap) ScopedBcmConfigManager.b.getValue()).get(r10);
        if (r12 == null) goto L65;
        Set r13 = r12;
        if ((r13 instanceof Collection) == true) goto L7;
    L9:
        Iterator r14 = r13.iterator();
    L11:
        if (r14.hasNext() == false) goto L50;
        g r1 = (g) r14.next();
        if (r1.b.d() != 1) goto L31;
        if ((!r1.b.b().isEmpty()) == false) goto L46;
        List<String> r15 = r1.b.b();
        if ((r15 instanceof Collection) == true) goto L19;
    L21:
        Iterator<T> r16 = r15.iterator();
    L23:
        if (r16.hasNext() == false) goto L27;
        if (StringsKt.startsWith$default(r11, (String) r16.next(), false, 2, null) == false) goto L23;
        boolean r17 = true;
    L28:
        if (r17 == false) goto L46;
    L47:
        boolean r18 = false;
    L48:
        if (r18 == false) goto L11;
        boolean r19 = true;
    L51:
        if (r19 != true) goto L66;
        return true;
    L66:
        return false;
    L27:
        r17 = false;
        goto L28
    L19:
        if (r15.isEmpty() == false) goto L21;
    L46:
        r18 = true;
        goto L48
    L31:
        if (r1.b.a().isEmpty() == true) goto L47;
        List<String> r20 = r1.b.a();
        if ((r20 instanceof Collection) == true) goto L35;
    L37:
        Iterator<T> r21 = r20.iterator();
    L39:
        if (r21.hasNext() == false) goto L43;
        if ((!StringsKt.startsWith$default(r11, (String) r21.next(), false, 2, null)) == true) goto L39;
        boolean r22 = false;
    L44:
        if (r22 == false) goto L46;
    L43:
        r22 = true;
        goto L44
    L35:
        if (r20.isEmpty() == false) goto L37;
    L50:
        r19 = false;
        goto L51
    L7:
        if (r13.isEmpty() == false) goto L9;
    L65:
        return false;
    }
}

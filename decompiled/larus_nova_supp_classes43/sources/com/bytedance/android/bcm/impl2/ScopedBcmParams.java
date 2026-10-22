package com.bytedance.android.bcm.impl2;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.bcm.impl2.model.BcmAllowMode;
import com.bytedance.android.btm.api.inner.ALogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import pc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\n\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0006\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000J\u0006\u0010\b\u001a\u00020\u0007J\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\n\u001a\u00020\tR\u0017\u0010\r\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/bcm/impl2/ScopedBcmParams;", "Lcom/bytedance/android/bcm/api/model/BcmParams;", "", "", "", "params", "merge", "", "isEmpty", "Lcom/bytedance/android/bcm/impl2/model/BcmAllowMode;", "mode", "", "toMap", "biz", "Ljava/lang/String;", "getBiz", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "bcm-impl-v2_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class ScopedBcmParams extends BcmParams {
    public static final a Companion = null;
    public static final String TAG = "_ScopedBcmParams";
    private final String biz;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isEmpty() {
        return getMap().isEmpty();
    }

    public final String getBiz() {
        return this.biz;
    }

    public ScopedBcmParams(String r1) {
        this.biz = r1;
    }

    @Override // com.bytedance.android.bcm.api.model.BcmParams
    public final ScopedBcmParams merge(Map<String, ? extends Object> r10) {
        if (r10.isEmpty() == false) goto L5;
        return this;
    L5:
        Map<String, Object> r0 = getMap();
        monitor-enter(r0);
        Iterator<Map.Entry<String, ? extends Object>> r11 = r10.entrySet().iterator();     // Catch: Throwable -> L14
    L9:
        if (r11.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r1 = r11.next();     // Catch: Throwable -> L14
        a(r1.getKey(), r1.getValue());     // Catch: Throwable -> L14
        goto L9
    L11:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
        return this;
    L14:
        th = move-exception;
        throw th;
    }

    public final Map<String, Object> toMap(BcmAllowMode r10) {
        Lazy r0 = ScopedBcmConfigManager.a;
        String r1 = this.biz;
        f r11 = (f) ((ConcurrentHashMap) ScopedBcmConfigManager.a.getValue()).get(r1);
        if (r11 == null) goto L25;
        Map<String, pc.a> r12 = r11.a();
        if (r12 == null) goto L25;
        Map<String, Object> r13 = getMap();
        monitor-enter(r13);
        Map<String, Object> r14 = getMap();     // Catch: Throwable -> L21
        LinkedHashMap r15 = new LinkedHashMap();     // Catch: Throwable -> L21
        Iterator<Map.Entry<String, Object>> r16 = r14.entrySet().iterator();     // Catch: Throwable -> L21
    L10:
        if (r16.hasNext() == false) goto L18;
        Map.Entry<String, Object> r17 = r16.next();     // Catch: Throwable -> L21
        pc.a r18 = r12.get(r17.getKey());     // Catch: Throwable -> L21
        if (r18 == null) goto L14;
        int r19 = r18.a();     // Catch: Throwable -> L21
    L16:
        if (r10.isEnabled(r19) == false) goto L10;
        r15.put(r17.getKey(), r17.getValue());     // Catch: Throwable -> L21
        goto L10
    L14:
        r19 = 0;
        goto L16
    L18:
        Map<String, Object> r20 = MapsKt.toMutableMap(r15);     // Catch: Throwable -> L21
        monitor-exit(r13);
        return r20;
    L21:
        th = move-exception;
        throw th;
    L25:
        return new LinkedHashMap();
    }

    public final ScopedBcmParams merge(ScopedBcmParams r1) {
        return merge(r1.getMap());
    }

    public final void a(final String r10, Object r11) {
        Lazy r0 = ScopedBcmConfigManager.a;
        String r1 = this.biz;
        f r12 = (f) ((ConcurrentHashMap) ScopedBcmConfigManager.a.getValue()).get(r1);
        if (r12 == null) goto L9;
        Map<String, pc.a> r13 = r12.a();
        if (r13 == null) goto L9;
        boolean r14 = true;
        if (r13.containsKey(r10) != true) goto L9;
    L11:
        if (r14 == true) goto L14;
        ALogger.d.a(TAG, false, new ScopedBcmParams$putVal$1(this, r10));
        return;
    L14:
        if (r11 != null) goto L17;
        return;
    L17:
        if ((r11 instanceof String) == false) goto L20;
    L30:
        getMap().put(r10, r11);
        return;
    L20:
        if ((r11 instanceof Number) == true) goto L30;
        if ((r11 instanceof Boolean) == true) goto L30;
        if ((r11 instanceof JSONObject) == true) goto L30;
        if ((r11 instanceof JSONArray) == true) goto L30;
        getMap().put(r10, JSONObject.wrap(r11));     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        ALogger.d.a(TAG, false, new ScopedBcmParams$putVal$2(this, r10, th));
        getMap().put(r10, r11.toString());
        return;
    L9:
        r14 = false;
        goto L11
    }
}

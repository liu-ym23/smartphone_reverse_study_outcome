package com.bytedance.android.bcm.impl2;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.bcm.impl2.model.BcmAllowMode;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004J$\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004J.\u0010\u0010\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\u0000J\u0006\u0010\u0013\u001a\u00020\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/bcm/impl2/ScopedBcmContent;", "Ljava/io/Serializable;", "", "scope", "", "", "params", "", "mergePageParams", "mergeUnitParams", "", "scopes", "Lcom/bytedance/android/bcm/impl2/model/BcmAllowMode;", "mode", "Lkotlin/Pair;", "Lcom/bytedance/android/bcm/api/model/BcmParams;", "snapshot", "copy", "", "isEmpty", "<init>", "()V", "bcm-impl-v2_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class ScopedBcmContent implements Serializable {
    public final transient Map<String, ScopedBcmParams> a;
    public final transient Map<String, ScopedBcmParams> b;

    public final ScopedBcmContent copy() {
        ScopedBcmContent r0 = new ScopedBcmContent();
        Iterator r1 = ((ConcurrentHashMap) r0.a).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r10 = (Map.Entry) r1.next();
        r0.mergePageParams((String) r10.getKey(), ((ScopedBcmParams) r10.getValue()).toMap());
        goto L4
    L6:
        Iterator r11 = ((ConcurrentHashMap) r0.b).entrySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        Map.Entry r12 = (Map.Entry) r11.next();
        r0.mergeUnitParams((String) r12.getKey(), ((ScopedBcmParams) r12.getValue()).toMap());
        goto L8
    L10:
        return r0;
    }

    public final boolean isEmpty() {
        if (((ConcurrentHashMap) this.a).isEmpty() == true) goto L5;
    L7:
        return false;
    L5:
        if (((ConcurrentHashMap) this.b).isEmpty() == false) goto L7;
        return true;
    }

    public ScopedBcmContent() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
    }

    public final void mergePageParams(String r10, Map<String, ? extends Object> r11) {
        ConcurrentHashMap r0 = (ConcurrentHashMap) this.a;
        Object r1 = r0.get(r10);
        if (r1 != null) goto L5;
        r1 = new ScopedBcmParams(r10);
        r0.put(r10, r1);
    L5:
        ((ScopedBcmParams) r1).merge(r11);
    }

    public final void mergeUnitParams(String r10, Map<String, ? extends Object> r11) {
        ConcurrentHashMap r0 = (ConcurrentHashMap) this.b;
        Object r1 = r0.get(r10);
        if (r1 != null) goto L5;
        r1 = new ScopedBcmParams(r10);
        r0.put(r10, r1);
    L5:
        ((ScopedBcmParams) r1).merge(r11);
    }

    public final Pair<BcmParams, BcmParams> snapshot(List<String> r10, BcmAllowMode r11) {
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        BcmParams r0 = new BcmParams();
        BcmParams r1 = new BcmParams();
        Iterator<T> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L16;
        String r13 = (String) r12.next();
        ScopedBcmParams r14 = (ScopedBcmParams) ((ConcurrentHashMap) this.a).get(r13);
        if (r14 == null) goto L12;
        r0.merge(r14.toMap(r11));
    L12:
        ScopedBcmParams r15 = (ScopedBcmParams) ((ConcurrentHashMap) this.b).get(r13);
        if (r15 == null) goto L8;
        r1.merge(r15.toMap(r11));
        goto L8
    L16:
        return TuplesKt.to(r0, r1);
    }
}

package com.bytedance.forest.utils;

import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.w;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f4652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PoolType f4653b;

    public n(int r5, PoolType r10) {
        this.f4653b = r10;
        this.f4652a = new m(this, r5);
    }

    public final void a(h r20) {
        r20.e = this;
        final w r5 = r20.d;
        d r10 = r5.B;
        ResourceFrom r11 = r5.f4444u;
        ResourceFrom r12 = ResourceFrom.f4339b;
        if (r11 == r12) goto L72;
        ResourceFrom r13 = ResourceFrom.d;
        if (r11 == r13) goto L7;
    L9:
        a r14 = r5.f4441q.getCacheKey$forest_release();
        PoolType r15 = this.f4653b;
        if (r14 != null) goto L13;
        d.b(r10, 3, "MemoryManager", "[" + r15 + "]updateCache: cache key is empty", false, null, null, 56);
        return;
    L13:
        final boolean r16 = true;
        com.bytedance.forest.model.p r17 = r20.f4625a;
        if (r17 != null) goto L16;
    L17:
        String r18 = r5.f4443t;
        if (r18 != null) goto L20;
    L70:
        d.b(r10, 3, "MemoryManager", "[" + r15 + "]updateCache: cache in-memory buffer is not provided and file path is empty", false, null, null, 56);
        return;
    L20:
        if (r18.length() == 0) goto L70;
    L22:
        m r19 = this.f4652a;
        final h r110 = (h) r19.get(r14);
        final h r21 = new h(r5, this);
        com.bytedance.forest.model.p r22 = r21.f4625a;
        if (r22 == null) goto L28;
        if (r22.isCacheReady$forest_release() == true) goto L28;
        r22.fulfillListener$forest_release(new ResourcePool$updateCache$$inlined$also$lambda$1(r21, r5));
    L28:
        if (r110 == null) goto L45;
        w r23 = r110.d;
        if ((r23 instanceof com.bytedance.forest.postprocessor.g) == true) goto L32;
        r23 = null;
    L32:
        com.bytedance.forest.postprocessor.g r24 = (com.bytedance.forest.postprocessor.g) r23;
        if (r24 == null) goto L37;
        if (r24.D == true) goto L45;
    L37:
        if ((r5 instanceof com.bytedance.forest.postprocessor.g) == true) goto L39;
        w r25 = null;
    L40:
        com.bytedance.forest.postprocessor.g r26 = (com.bytedance.forest.postprocessor.g) r25;
        if (r26 == null) goto L45;
        if (r26.D != true) goto L45;
        final boolean r27 = true;
    L46:
        if (r110 != null) goto L48;
    L50:
        r16 = false;
    L52:
        if (r5.f4444u == r13) goto L54;
        if (r110 != null) goto L54;
    L60:
        final h r28 = (h) r19.put(r14, r21);
        if (r28 == null) goto L65;
        f r29 = r28.f4627c;
        if (r29 == null) goto L66;
        r29.close();
    L66:
        d.c(r10, 4, "MemoryManager", null, null, new ResourcePool$updateCache$3(this, r28, r21), 24);
        if (r110 == r28) goto L74;
        d.c(r10, 5, "MemoryManager", null, null, new ResourcePool$updateCache$4(this, r110, r28), 28);
        return;
    L74:
        return;
    L65:
        r28 = null;
    L54:
        if (r27 == true) goto L60;
        if (r16 == true) goto L60;
        d.c(r5.B, 4, "MemoryManager", null, null, new ResourcePool$updateCache$2(this, r16, r27, r110), 28);
        f r30 = r21.f4627c;
        if (r30 == null) goto L73;
        r30.close();
        return;
    L73:
        return;
    L48:
        if (r110.f4626b == r21.f4626b) goto L50;
    L39:
        r25 = r5;
    L45:
        r27 = false;
        goto L46
    L16:
        if (r17.isCacheProvided$forest_release() == true) goto L22;
    L7:
        if (r5.f4445v != r12) goto L9;
        return;
    }

    public final h b(a r5) {
        if (r5 == null) goto L10;
        h r10 = (h) this.f4652a.remove(r5);
        if (r10 == null) goto L10;
        f r11 = r10.f4627c;
        if (r11 == null) goto L9;
        r11.close();
    L9:
        return r10;
    L10:
        return null;
    }
}

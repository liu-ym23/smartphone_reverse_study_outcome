package com.google.common.cache;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
class LocalCache$ManualSerializationProxy<K, V> extends j implements Serializable {
    private static final long serialVersionUID = 1;
    final int concurrencyLevel;
    transient c delegate;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final com.google.common.base.p keyEquivalence;
    final LocalCache$Strength keyStrength;
    final h loader;
    final long maxWeight;
    final w0 removalListener;
    final com.google.common.base.h0 ticker;
    final com.google.common.base.p valueEquivalence;
    final LocalCache$Strength valueStrength;
    final z0 weigher;

    public LocalCache$ManualSerializationProxy(q0 r5) {
        this.keyStrength = r5.g;
        this.valueStrength = r5.f8748h;
        this.keyEquivalence = r5.e;
        this.valueEquivalence = r5.f;
        this.expireAfterWriteNanos = r5.f8752l;
        this.expireAfterAccessNanos = r5.f8751k;
        this.maxWeight = r5.f8749i;
        this.weigher = r5.f8750j;
        this.concurrencyLevel = r5.d;
        this.removalListener = r5.f8754n;
        com.google.common.base.g0 r10 = com.google.common.base.h0.f8659a;
        com.google.common.base.h0 r11 = r5.f8755o;
        if (r11 != r10) goto L5;
    L6:
        r11 = null;
    L7:
        this.ticker = r11;
        this.loader = r5.f8758r;
        return;
    L5:
        if (r11 != f.f8703q) goto L7;
        goto L6
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        f r10 = recreateCacheBuilder();
        r10.a();
        this.delegate = new LocalCache$LocalManualCache(r10);
    }

    private Object readResolve() {
        return this.delegate;
    }

    @Override // com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    public f recreateCacheBuilder() {
        f r5 = new f();
        r5.f8705a = true;
        r5.f8706b = -1;
        r5.f8707c = -1;
        r5.d = -1;
        r5.f8708h = -1;
        r5.f8709i = -1;
        r5.f8714n = f.f8701o;
        LocalCache$Strength r10 = this.keyStrength;
        LocalCache$Strength r11 = r5.f;
        if (r11 != null) goto L5;
        boolean r12 = true;
    L6:
        com.google.common.base.b0.s("Key strength was already set to %s", r12, r11);
        r10.getClass();
        r5.f = r10;
        LocalCache$Strength r13 = this.valueStrength;
        LocalCache$Strength r14 = r5.g;
        if (r14 != null) goto L9;
        boolean r15 = true;
    L10:
        com.google.common.base.b0.s("Value strength was already set to %s", r15, r14);
        r13.getClass();
        r5.g = r13;
        com.google.common.base.p r16 = this.keyEquivalence;
        com.google.common.base.p r17 = r5.f8710j;
        if (r17 != null) goto L13;
        boolean r18 = true;
    L14:
        com.google.common.base.b0.s("key equivalence was already set to %s", r18, r17);
        r16.getClass();
        r5.f8710j = r16;
        com.google.common.base.p r19 = this.valueEquivalence;
        com.google.common.base.p r20 = r5.f8711k;
        if (r20 != null) goto L17;
        boolean r21 = true;
    L18:
        com.google.common.base.b0.s("value equivalence was already set to %s", r21, r20);
        r19.getClass();
        r5.f8711k = r19;
        int r22 = this.concurrencyLevel;
        int r23 = r5.f8706b;
        if (r23 != (-1)) goto L21;
        boolean r24 = true;
    L22:
        com.google.common.base.b0.q(r23, "concurrency level was already set to %s", r24);
        if (r22 <= 0) goto L25;
        boolean r25 = true;
    L26:
        com.google.common.base.b0.i(r25);
        r5.f8706b = r22;
        w0 r26 = this.removalListener;
        if (r5.f8712l != null) goto L29;
        boolean r27 = true;
    L30:
        com.google.common.base.b0.t(r27);
        r26.getClass();
        r5.f8712l = r26;
        r5.f8705a = false;
        long r28 = this.expireAfterWriteNanos;
        if (r28 <= 0) goto L41;
        TimeUnit r110 = TimeUnit.NANOSECONDS;
        long r111 = r5.f8708h;
        if (r111 != (-1)) goto L35;
        boolean r112 = true;
    L36:
        com.google.common.base.b0.r("expireAfterWrite was already set to %s ns", r111, r112);
        if (r28 < 0) goto L39;
        boolean r29 = true;
    L40:
        com.google.common.base.b0.j(r29, "duration cannot be negative: %s %s", r28, r110);
        r5.f8708h = r110.toNanos(r28);
        goto L41
    L39:
        r29 = false;
        goto L40
    L35:
        r112 = false;
    L41:
        long r30 = this.expireAfterAccessNanos;
        if (r30 <= 0) goto L52;
        TimeUnit r31 = TimeUnit.NANOSECONDS;
        long r113 = r5.f8709i;
        if (r113 != (-1)) goto L46;
        boolean r114 = true;
    L47:
        com.google.common.base.b0.r("expireAfterAccess was already set to %s ns", r113, r114);
        if (r30 < 0) goto L50;
        boolean r32 = true;
    L51:
        com.google.common.base.b0.j(r32, "duration cannot be negative: %s %s", r30, r31);
        r5.f8709i = r31.toNanos(r30);
        goto L52
    L50:
        r32 = false;
        goto L51
    L46:
        r114 = false;
    L52:
        z0 r33 = this.weigher;
        if (r33 != CacheBuilder$OneWeigher.INSTANCE) goto L55;
        long r34 = this.maxWeight;
        if (r34 == (-1)) goto L99;
        long r115 = r5.f8707c;
        if (r115 != (-1)) goto L85;
        boolean r116 = true;
    L86:
        com.google.common.base.b0.r("maximum size was already set to %s", r115, r116);
        long r117 = r5.d;
        if (r117 != (-1)) goto L89;
        boolean r35 = true;
    L90:
        com.google.common.base.b0.r("maximum weight was already set to %s", r117, r35);
        if (r5.e != null) goto L93;
        boolean r36 = true;
    L94:
        com.google.common.base.b0.u(r36, "maximum size can not be combined with weigher");
        if (r34 < 0) goto L97;
        boolean r37 = true;
    L98:
        com.google.common.base.b0.g("maximum size must not be negative", r37);
        r5.f8707c = r34;
        goto L99
    L97:
        r37 = false;
        goto L98
    L93:
        r36 = false;
        goto L94
    L89:
        r35 = false;
        goto L90
    L85:
        r116 = false;
    L99:
        com.google.common.base.h0 r38 = this.ticker;
        if (r38 != null) goto L102;
    L106:
        return r5;
    L102:
        if (r5.f8713m != null) goto L104;
        boolean r39 = true;
    L105:
        com.google.common.base.b0.t(r39);
        r5.f8713m = r38;
        goto L106
    L104:
        r39 = false;
        goto L105
    L55:
        if (r5.e != null) goto L57;
        boolean r40 = true;
    L58:
        com.google.common.base.b0.t(r40);
        if (r5.f8705a == false) goto L65;
        long r118 = r5.f8707c;
        if (r118 != (-1)) goto L63;
        boolean r41 = true;
    L64:
        com.google.common.base.b0.r("weigher can not be combined with maximum size", r118, r41);
        goto L65
    L63:
        r41 = false;
    L65:
        r33.getClass();
        r5.e = r33;
        long r42 = this.maxWeight;
        if (r42 == (-1)) goto L99;
        long r119 = r5.d;
        if (r119 != (-1)) goto L70;
        boolean r120 = true;
    L71:
        com.google.common.base.b0.r("maximum weight was already set to %s", r119, r120);
        long r121 = r5.f8707c;
        if (r121 != (-1)) goto L74;
        boolean r43 = true;
    L75:
        com.google.common.base.b0.r("maximum size was already set to %s", r121, r43);
        if (r42 < 0) goto L78;
        boolean r44 = true;
    L79:
        com.google.common.base.b0.g("maximum weight must not be negative", r44);
        r5.d = r42;
        goto L99
    L78:
        r44 = false;
        goto L79
    L74:
        r43 = false;
        goto L75
    L70:
        r120 = false;
        goto L71
    L57:
        r40 = false;
        goto L58
    L29:
        r27 = false;
        goto L30
    L25:
        r25 = false;
        goto L26
    L21:
        r24 = false;
        goto L22
    L17:
        r21 = false;
        goto L18
    L13:
        r18 = false;
        goto L14
    L9:
        r15 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    @Override // com.google.common.cache.j, com.google.common.collect.z2
    public c delegate() {
        return this.delegate;
    }
}

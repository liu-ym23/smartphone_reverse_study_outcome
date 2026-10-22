package c12;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t implements fd6.a<String> {
    public static a b;
    public static h c;
    public static fd6.b<String> d;
    public com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.f a;

    public t() {
        kjc.a.call(new o(this));
    }

    public final fd6.b<String> a(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r1, com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r2) {
        if (r1 != null) goto L4;
    L10:
        a r3 = b;
        if (r3 == null) goto L13;
        return r3;
    L13:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r4 = r2.a;
        fd6.b<String> r5 = this.a.a(r4);
        d = r5;
        a r6 = new a(new h(r5));
        b = r6;
        return r6;
    L4:
        if (r1.m == true) goto L10;
        h r7 = c;
        if (r7 == null) goto L8;
        return r7;
    L8:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r8 = r2.a;
        fd6.b<String> r9 = this.a.a(r8);
        d = r9;
        h r10 = new h(r9);
        c = r10;
        return r10;
    }
}

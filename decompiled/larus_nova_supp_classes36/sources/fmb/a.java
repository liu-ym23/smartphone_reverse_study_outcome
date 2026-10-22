package fmb;

import com.ss.android.lark.featuregating.FeatureGatingModule;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final Object a = null;
    public static volatile boolean b;

    /* JADX INFO: renamed from: fmb.a$a, reason: collision with other inner class name */
    public static class C0263a extends fn4.a {
        public final void c() {
        }

        public C0263a() {
        }

        public final boolean b(String r3, boolean r4, boolean r5) {
            if (r5 == false) goto L4;
            boolean r6 = FeatureGatingModule.getFeatureGatingService().isEnable(r3);
        L5:
            tt5.a.h("LarkFGRepository", "getBoolean, key = " + r3 + ", value = " + r6 + ", consistent = " + r5);
            return r6;
        L4:
            r6 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable(r3);
            goto L5
        }
    }

    static {
        a = new Object();
    }
}

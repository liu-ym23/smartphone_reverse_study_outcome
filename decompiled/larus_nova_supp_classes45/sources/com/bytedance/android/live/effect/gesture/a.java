package com.bytedance.android.live.effect.gesture;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final List<String> c = null;
    public final int a;
    public final C0187a b;

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.gesture.a$a, reason: collision with other inner class name */
    public static class C0187a {
        public int a;
        public float b;
        public float c;
        public long d;

        public C0187a() {
        }
    }

    static {
        c = Arrays.asList(new String[]{"BEGAN", "MOVED", "STATIONARY", "ENDED", "CANCELED"});
    }

    public a(int r1, C0187a r2) {
        this.a = r1;
        this.b = r2;
    }
}

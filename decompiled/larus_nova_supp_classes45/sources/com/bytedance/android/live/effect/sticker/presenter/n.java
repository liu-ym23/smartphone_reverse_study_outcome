package com.bytedance.android.live.effect.sticker.presenter;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface n {
    public static final a a = null;

    public static final class a {
        public static final List<String> a = null;
        public static final int b = 0;
        public static final /* synthetic */ a c = null;

        public a() {
        }

        static {
            c = new a();
            List<String> r0 = CollectionsKt.listOf(new String[]{com.bytedance.android.live.effect.api.d0.i, "beautyclassify", com.bytedance.android.live.effect.api.d0.k, com.bytedance.android.live.effect.api.d0.l, "livebody"});
            a = r0;
            r0.size();
            b = r0.size() - 1;
        }
    }

    public static final class b {
        public static /* synthetic */ void a(n r1, h r2) {
            r1.f(r2, "");
        }

        public static /* synthetic */ void b(n r1, h r2) {
            r1.a(r2, "");
        }
    }

    static {
        a = a.c;
    }

    void a(h r1, String r2);

    List<String> b();

    boolean c();

    boolean d();

    boolean e();

    void f(h r1, String r2);

    String g();

    void h(String r1, String r2);

    Map<String, BeautyModeInfo> i();
}

package com.bytedance.android.live.core.privacy.av.api;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface b {
    public static final a a = null;

    public static final class a {
        public static final C0147a a = null;
        public static final /* synthetic */ a b = null;

        /* JADX INFO: renamed from: com.bytedance.android.live.core.privacy.av.api.b$a$a, reason: collision with other inner class name */
        public static final class C0147a implements b {
            public C0147a() {
            }

            @Override // com.bytedance.android.live.core.privacy.av.api.b
            public final void a(String r2, String r3, String r4, Map r5, com.bytedance.android.live.core.privacy.av.api.a r6, AudioAndVideoException r7) {
                Intrinsics.checkNotNullParameter(r2, "biz");
                Intrinsics.checkNotNullParameter(r3, "sense");
                Intrinsics.checkNotNullParameter(r4, "type");
                Intrinsics.checkNotNullParameter(r5, "params");
                Intrinsics.checkNotNullParameter(r6, "config");
                Intrinsics.checkNotNullParameter(r7, "exception");
            }

            @Override // com.bytedance.android.live.core.privacy.av.api.b
            public final void b(String r2, String r3, String r4, Map<String, String> r5, com.bytedance.android.live.core.privacy.av.api.a r6) {
                Intrinsics.checkNotNullParameter(r2, "biz");
                Intrinsics.checkNotNullParameter(r3, "sense");
                Intrinsics.checkNotNullParameter(r4, "type");
                Intrinsics.checkNotNullParameter(r5, "params");
                Intrinsics.checkNotNullParameter(r6, "config");
            }

            @Override // com.bytedance.android.live.core.privacy.av.api.b
            public final void c(String r2, String r3, String r4, Map<String, String> r5, com.bytedance.android.live.core.privacy.av.api.a r6) {
                Intrinsics.checkNotNullParameter(r2, "biz");
                Intrinsics.checkNotNullParameter(r3, "sense");
                Intrinsics.checkNotNullParameter(r4, "type");
                Intrinsics.checkNotNullParameter(r5, "params");
                Intrinsics.checkNotNullParameter(r6, "config");
            }

            @Override // com.bytedance.android.live.core.privacy.av.api.b
            public final void d(String r2, String r3, String r4, Map<String, String> r5, com.bytedance.android.live.core.privacy.av.api.a r6) {
                Intrinsics.checkNotNullParameter(r2, "biz");
                Intrinsics.checkNotNullParameter(r3, "sense");
                Intrinsics.checkNotNullParameter(r4, "type");
                Intrinsics.checkNotNullParameter(r5, "params");
                Intrinsics.checkNotNullParameter(r6, "config");
            }
        }

        public a() {
        }

        static {
            b = new a();
            a = new C0147a();
        }
    }

    static {
        a = a.b;
    }

    void a(String r1, String r2, String r3, Map r4, com.bytedance.android.live.core.privacy.av.api.a r5, AudioAndVideoException r6);

    void b(String r1, String r2, String r3, Map<String, String> r4, com.bytedance.android.live.core.privacy.av.api.a r5);

    void c(String r1, String r2, String r3, Map<String, String> r4, com.bytedance.android.live.core.privacy.av.api.a r5);

    void d(String r1, String r2, String r3, Map<String, String> r4, com.bytedance.android.live.core.privacy.av.api.a r5);
}

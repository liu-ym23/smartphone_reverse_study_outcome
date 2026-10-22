package com.bytedance.android.live.browser.schema.core;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements com.bytedance.android.live.browser.schema.core.b {
    public static final /* synthetic */ int d = 0;
    public final d a;
    public final a b;
    public final com.bytedance.android.live.browser.schema.core.b c;

    public static abstract class a {
        public static final /* synthetic */ int a = 0;

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.schema.core.c$a$a, reason: collision with other inner class name */
        public static final class C0131a extends a {
            public final long b;

            @Override // com.bytedance.android.live.browser.schema.core.c.a
            public final boolean a() {
                if (SystemClock.uptimeMillis() <= this.b) goto L5;
                return true;
            L5:
                return false;
            }

            public C0131a(long r2, long r4, TimeUnit r6) {
                Intrinsics.checkNotNullParameter(r6, "timeUnit");
                this.b = r2 + r6.toMillis(r4);
            }
        }

        public static final class b {
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.schema.core.c$a$c, reason: collision with other inner class name */
        public static final class C0132c extends a {
            public static final C0132c b = null;

            @Override // com.bytedance.android.live.browser.schema.core.c.a
            public final boolean a() {
                return true;
            }

            static {
                b = new C0132c();
            }

            public C0132c() {
            }
        }

        static {
        }

        public a() {
        }

        public abstract boolean a();
    }

    public static final class b {
        public static c b(d r7, com.bytedance.android.live.browser.schema.core.strategy.d r8) {
            Intrinsics.checkNotNullParameter(r7, "ruleSpec");
            Intrinsics.checkNotNullParameter(r8, "strategyRegister");
            int r1 = a.a;
            return new c(r7, new a.C0131a(SystemClock.uptimeMillis(), r7.a(), TimeUnit.SECONDS), new com.bytedance.android.live.browser.schema.core.a(new RedirectRuleCreator(r7, r8)));
        }

        public static c a(d r7, com.bytedance.android.live.browser.schema.core.strategy.d r8, long r9, TimeUnit r11) {
            Intrinsics.checkNotNullParameter(r7, "ruleSpec");
            Intrinsics.checkNotNullParameter(r8, "strategyRegister");
            Intrinsics.checkNotNullParameter(r11, "timeUnit");
            int r1 = a.a;
            return new c(r7, new a.C0131a(SystemClock.uptimeMillis(), r9, r11), new com.bytedance.android.live.browser.schema.core.a(new RedirectRuleCreator(r7, r8)));
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.browser.schema.core.b
    public final RedirectRule get(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.c.get(r2);
    }

    public c(d r1, a r2, com.bytedance.android.live.browser.schema.core.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

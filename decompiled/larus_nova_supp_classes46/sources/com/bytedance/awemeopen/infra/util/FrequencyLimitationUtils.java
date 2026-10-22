package com.bytedance.awemeopen.infra.util;

import android.content.SharedPreferences;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class FrequencyLimitationUtils {
    public static final ConcurrentHashMap<String, Long> a = null;

    public static final class InstallationCounter implements b {
        public final String a;
        public final Lazy b;

        @Override // com.bytedance.awemeopen.infra.util.FrequencyLimitationUtils.b
        public final long getCount() {
            return ((SharedPreferences) this.b.getValue()).getLong(this.a, 0);
        }

        @Override // com.bytedance.awemeopen.infra.util.FrequencyLimitationUtils.b
        public final void a() {
            long r0 = getCount();
            ((SharedPreferences) this.b.getValue()).edit().putLong(this.a, r0 + 1).apply();
        }

        public InstallationCounter(String r2) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            this.a = r2;
            this.b = LazyKt.lazy(FrequencyLimitationUtils$InstallationCounter$sp$2.INSTANCE);
        }
    }

    public static final class a implements b {
        public final String a;

        @Override // com.bytedance.awemeopen.infra.util.FrequencyLimitationUtils.b
        public final long getCount() {
            Long r0 = FrequencyLimitationUtils.a.get(this.a);
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.longValue();
        }

        @Override // com.bytedance.awemeopen.infra.util.FrequencyLimitationUtils.b
        public final void a() {
            long r0 = getCount();
            FrequencyLimitationUtils.a.put(this.a, Long.valueOf(r0 + 1));
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            this.a = r2;
        }
    }

    public interface b {
        void a();

        long getCount();
    }

    static {
        a = new ConcurrentHashMap();
    }

    public static b a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        if (r3 == 0) goto L10;
        if (r3 != 1) goto L8;
        return new a(r2);
    L8:
        throw new IllegalArgumentException("no scope support for " + r3);
    L10:
        return new InstallationCounter(r2);
    }
}

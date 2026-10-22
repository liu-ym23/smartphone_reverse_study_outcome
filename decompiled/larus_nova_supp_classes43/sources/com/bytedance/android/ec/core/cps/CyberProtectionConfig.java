package com.bytedance.android.ec.core.cps;

import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.security.Sword.Sword;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class CyberProtectionConfig {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final CyberProtectionConfig c = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/cps/CyberProtectionConfig$ConfigError;", "", "Decode", "Lack", "JSON", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ConfigError extends Enum<ConfigError> {
        public static final ConfigError Decode = null;
        public static final ConfigError JSON = null;
        public static final ConfigError Lack = null;
        public static final /* synthetic */ ConfigError[] a = null;

        static {
            ConfigError r1 = new ConfigError("Decode", 0);
            Decode = r1;
            ConfigError r10 = new ConfigError("Lack", 1);
            Lack = r10;
            ConfigError r11 = new ConfigError("JSON", 2);
            JSON = r11;
            a = new ConfigError[]{r1, r10, r11};
        }

        public static ConfigError valueOf(String r1) {
            return (ConfigError) r27.a.a(ConfigError.class, r1);
        }

        public static ConfigError[] values() {
            return (ConfigError[]) a.clone();
        }

        public ConfigError(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a {
        public final int a;
        public final int b;
        public final ConfigError c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof a) == false) goto L12;
            a r11 = (a) r10;
            if (this.a == r11.a) goto L8;
            return false;
        L8:
            if (this.b == r11.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b) * 31;
            ConfigError r1 = this.c;
            if (r1 == null) goto L5;
            int r10 = r1.hashCode();
        L7:
            return r0 + r10;
        L5:
            r10 = 0;
            goto L7
        }

        public final String toString() {
            return "ConfigAttribution(r=" + this.a + ", c=" + this.b + ", configError=" + this.c + ")";
        }

        public a(int r1, int r10, ConfigError r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    public CyberProtectionConfig() {
    }

    static {
        c = new CyberProtectionConfig();
        a = LazyKt.lazy(CyberProtectionConfig$localRepo$2.INSTANCE);
        b = LazyKt.lazy(CyberProtectionConfig$ecDynamicEventEnable$2.INSTANCE);
    }

    public static Pair a(String r10, Class r11) {
        byte[] r12 = Sword.clientUnpackedBase64(r10);     // Catch: Throwable -> L11
        if (r12 == null) goto L9;
        String r13 = StringsKt.decodeToString(r12);     // Catch: Throwable -> L11
        if (r13 == null) goto L9;
        Pair r14 = TuplesKt.to(r13, null);     // Catch: Throwable -> L11
        if (r14 == null) goto L9;
    L12:
        String r1 = (String) r14.component1();
        ConfigError r15 = (ConfigError) r14.component2();
        if (r15 != null) goto L23;
        int r16 = t0.a;     // Catch: Throwable -> L17
        return TuplesKt.to(t0.a.a.fromJson(r1, r11), null);
    L18:
        return TuplesKt.to(null, ConfigError.JSON);
    L23:
        return TuplesKt.to(null, r15);
    L9:
        r14 = TuplesKt.to(null, ConfigError.Decode);     // Catch: Throwable -> L11
    L11:
        r14 = TuplesKt.to(null, ConfigError.Decode);
        goto L12
    }
}

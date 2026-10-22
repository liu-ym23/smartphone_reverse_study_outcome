package com.bytedance.privacy.attestation;

import com.bytedance.privacy.exception.BdPrivacyException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
public class AttestationConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean[] f2994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2995b;
    private final boolean c;

    /* JADX INFO: renamed from: com.bytedance.privacy.attestation.AttestationConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final enum IdType extends Enum<IdType> {
        private static final /* synthetic */ IdType[] $VALUES = null;
        public static final IdType RPDID = null;
        public static final IdType RPUID = null;
        public static final IdType UDID = null;

        private static /* synthetic */ IdType[] $values() {
            return new IdType[]{UDID, RPDID, RPUID};
        }

        static {
            UDID = new IdType("UDID", 0);
            RPDID = new IdType("RPDID", 1);
            RPUID = new IdType("RPUID", 2);
            $VALUES = $values();
        }

        private IdType(String r1, int r2) {
            super(r1, r2);
        }

        public static IdType valueOf(String r2) {
            return (IdType) ZeusTransformUtils.preCheckCast(Enum.valueOf(IdType.class, r2), IdType.class, "com.obric.memorydata.plugin");
        }

        public static IdType[] values() {
            return (IdType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), IdType[].class, "com.obric.memorydata.plugin");
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean[] f2996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f2997b;
        private boolean c;

        public a() {
            this.f2996a = new boolean[IdType.values().length];
            this.c = false;
        }

        static /* synthetic */ boolean[] a(a r0) {
            return r0.f2996a;
        }

        static /* synthetic */ String b(a r0) {
            return r0.f2997b;
        }

        static /* synthetic */ boolean c(a r0) {
            return r0.c;
        }

        public a a(IdType r3) {
            this.f2996a[r3.ordinal()] = true;
            return this;
        }

        public a a(String r3) {
            if (r3 == null) goto L12;
            if (r3.isEmpty() == true) goto L12;
            int r0 = com.bytedance.privacy.d.a.o();
            if (r3.getBytes(StandardCharsets.UTF_8).length > r0) goto L10;
            this.f2997b = r3;
            return this;
        L10:
            throw new BdPrivacyException("customInfo too long (max " + r0 + " bytes)");
        L12:
            throw new BdPrivacyException("customInfo must not be null or empty");
        }

        public AttestationConfig a() {
            return new AttestationConfig(this, null);
        }
    }

    private AttestationConfig(a r4) {
        this.f2994a = (boolean[]) ZeusTransformUtils.preCheckCast(a.a(r4).clone(), boolean[].class, "com.obric.memorydata.plugin");
        this.f2995b = a.b(r4);
        this.c = a.c(r4);
    }

    /* synthetic */ AttestationConfig(a r1, AnonymousClass1 r2) {
        this(r1);
    }

    public String a() {
        return this.f2995b;
    }

    public boolean a(IdType r1) {
        return this.f2994a[r1.ordinal()];
    }

    public boolean b() {
        return this.c;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("AttestationConfig{");
        r0.append("requestedIds=[");
        IdType[] r1 = IdType.values();
        int r2 = r1.length;
        boolean r4 = true;
        int r5 = 0;
    L3:
        if (r5 >= r2) goto L10;
        IdType r6 = r1[r5];
        if (this.f2994a[r6.ordinal()] == false) goto L9;
        if (r4 == true) goto L8;
        r0.append(", ");
    L8:
        r0.append(r6.name());
        r4 = false;
    L9:
        r5 = r5 + 1;
        goto L3
    L10:
        r0.append("]");
        if (this.f2995b == null) goto L13;
        r0.append(", customInfo='").append(this.f2995b).append('\'');
    L13:
        r0.append(", devHealthStatusRequired=").append(this.c);
        r0.append('}');
        return r0.toString();
    }
}

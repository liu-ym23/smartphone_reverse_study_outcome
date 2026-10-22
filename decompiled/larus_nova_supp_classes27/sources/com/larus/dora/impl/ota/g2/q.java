package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface q {

    public static final class a implements q {
        private final long downloadedBytes;
        private final com.larus.dora.impl.ota.g2.e key;
        private final long operationId;
        private final e5 pkg;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
            return false;
        L12:
            if (this.operationId == r9.operationId) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.pkg, r9.pkg) == true) goto L18;
            return false;
        L18:
            if (this.downloadedBytes == r9.downloadedBytes) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.key.hashCode() * 31;
            long r1 = this.operationId;
            int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.pkg.hashCode()) * 31;
            long r3 = this.downloadedBytes;
            return r2 + ((int) (r3 ^ (r3 >>> 32)));
        }

        public final String toString() {
            return "CheckDownloadSpace(key=" + this.key + ", operationId=" + this.operationId + ", pkg=" + this.pkg + ", downloadedBytes=" + this.downloadedBytes + ')';
        }

        public final long a() {
            return this.downloadedBytes;
        }

        public final com.larus.dora.impl.ota.g2.e b() {
            return this.key;
        }

        public final long c() {
            return this.operationId;
        }

        public final e5 d() {
            return this.pkg;
        }

        public a(com.larus.dora.impl.ota.g2.e r2, long r3, e5 r5, long r6) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r5, "pkg");
            this.key = r2;
            this.operationId = r3;
            this.pkg = r5;
            this.downloadedBytes = r6;
        }
    }

    public static final class b implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long operationId;
        private final CheckPurpose purpose;
        private final com.larus.dora.impl.ota.g2.g request;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
            return false;
        L12:
            if (this.operationId == r9.operationId) goto L15;
            return false;
        L15:
            if (this.purpose == r9.purpose) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.request, r9.request) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.key.hashCode() * 31;
            long r1 = this.operationId;
            return ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.purpose.hashCode()) * 31) + this.request.hashCode();
        }

        public final String toString() {
            return "CheckLatest(key=" + this.key + ", operationId=" + this.operationId + ", purpose=" + this.purpose + ", request=" + this.request + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.operationId;
        }

        public final com.larus.dora.impl.ota.g2.g c() {
            return this.request;
        }

        public b(com.larus.dora.impl.ota.g2.e r2, long r3, CheckPurpose r5, com.larus.dora.impl.ota.g2.g r6) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r5, "purpose");
            Intrinsics.checkNotNullParameter(r6, "request");
            this.key = r2;
            this.operationId = r3;
            this.purpose = r5;
            this.request = r6;
        }
    }

    public static final class c implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final OtaMode mode;
        private final long operationId;
        private final String ownerId;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r9 = (c) r8;
            if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r9.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.operationId == r9.operationId) goto L18;
            return false;
        L18:
            if (this.mode == r9.mode) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
            long r1 = this.operationId;
            return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.mode.hashCode();
        }

        public final String toString() {
            return "ConnectP2p(key=" + this.key + ", ownerId=" + this.ownerId + ", operationId=" + this.operationId + ", mode=" + this.mode + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final OtaMode b() {
            return this.mode;
        }

        public final long c() {
            return this.operationId;
        }

        public final String d() {
            return this.ownerId;
        }

        public c(com.larus.dora.impl.ota.g2.e r2, String r3, long r4, OtaMode r6) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "ownerId");
            Intrinsics.checkNotNullParameter(r6, "mode");
            this.key = r2;
            this.ownerId = r3;
            this.operationId = r4;
            this.mode = r6;
        }
    }

    public static final class d implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final OtaMode mode;
        private final String ownerId;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.key, r6.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r6.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.mode == r6.mode) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31) + this.mode.hashCode();
        }

        public final String toString() {
            return "DeclareType(key=" + this.key + ", ownerId=" + this.ownerId + ", mode=" + this.mode + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final OtaMode b() {
            return this.mode;
        }

        public final String c() {
            return this.ownerId;
        }

        public d(com.larus.dora.impl.ota.g2.e r2, String r3, OtaMode r4) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "ownerId");
            Intrinsics.checkNotNullParameter(r4, "mode");
            this.key = r2;
            this.ownerId = r3;
            this.mode = r4;
        }
    }

    public static final class e implements q {
        private final Integer discardDownloadId;
        private final long effectId;
        private final com.larus.dora.impl.ota.g2.e key;
        private final e5 pkg;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof e) == true) goto L8;
            return false;
        L8:
            e r9 = (e) r8;
            if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
            return false;
        L12:
            if (this.effectId == r9.effectId) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.pkg, r9.pkg) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.discardDownloadId, r9.discardDownloadId) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.key.hashCode() * 31;
            long r1 = this.effectId;
            int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.pkg.hashCode()) * 31;
            Integer r3 = this.discardDownloadId;
            if (r3 != null) goto L5;
            int r4 = 0;
        L7:
            return r2 + r4;
        L5:
            r4 = r3.hashCode();
            goto L7
        }

        public final String toString() {
            return "DeletePackage(key=" + this.key + ", effectId=" + this.effectId + ", pkg=" + this.pkg + ", discardDownloadId=" + this.discardDownloadId + ')';
        }

        public final Integer a() {
            return this.discardDownloadId;
        }

        public final long b() {
            return this.effectId;
        }

        public final com.larus.dora.impl.ota.g2.e c() {
            return this.key;
        }

        public final e5 d() {
            return this.pkg;
        }

        public /* synthetic */ e(com.larus.dora.impl.ota.g2.e r7, long r8, e5 r10) {
            this(r7, r8, r10, null);
        }

        public e(com.larus.dora.impl.ota.g2.e r2, long r3, e5 r5, Integer r6) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r5, "pkg");
            this.key = r2;
            this.effectId = r3;
            this.pkg = r5;
            this.discardDownloadId = r6;
        }
    }

    public static final class f implements q {
        private final s event;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.event, ((f) r4).event) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.event.hashCode();
        }

        public final String toString() {
            return "Dispatch(event=" + this.event + ')';
        }

        public final s a() {
            return this.event;
        }

        public f(s r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            this.event = r2;
        }
    }

    public static final class g implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long operationId;
        private final String ownerId;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof g) == true) goto L8;
            return false;
        L8:
            g r9 = (g) r8;
            if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r9.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.operationId == r9.operationId) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
            long r1 = this.operationId;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "EnableWifi(key=" + this.key + ", ownerId=" + this.ownerId + ", operationId=" + this.operationId + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.operationId;
        }

        public final String c() {
            return this.ownerId;
        }
    }

    public static final class h implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long operationId;
        private final BlockReason reason;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof h) == true) goto L8;
            return false;
        L8:
            h r9 = (h) r8;
            if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
            return false;
        L12:
            if (this.operationId == r9.operationId) goto L15;
            return false;
        L15:
            if (this.reason == r9.reason) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.key.hashCode() * 31;
            long r1 = this.operationId;
            return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.reason.hashCode();
        }

        public final String toString() {
            return "PauseDownload(key=" + this.key + ", operationId=" + this.operationId + ", reason=" + this.reason + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.operationId;
        }

        public final BlockReason c() {
            return this.reason;
        }

        public h(com.larus.dora.impl.ota.g2.e r2, long r3, BlockReason r5) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r5, "reason");
            this.key = r2;
            this.operationId = r3;
            this.reason = r5;
        }
    }

    public static final class i implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long operationId;
        private final e5 pkg;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof i) == true) goto L8;
            return false;
        L8:
            i r9 = (i) r8;
            if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
            return false;
        L12:
            if (this.operationId == r9.operationId) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.pkg, r9.pkg) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.key.hashCode() * 31;
            long r1 = this.operationId;
            return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.pkg.hashCode();
        }

        public final String toString() {
            return "PrepareDownload(key=" + this.key + ", operationId=" + this.operationId + ", pkg=" + this.pkg + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.operationId;
        }

        public final e5 c() {
            return this.pkg;
        }

        public i(com.larus.dora.impl.ota.g2.e r2, long r3, e5 r5) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r5, "pkg");
            this.key = r2;
            this.operationId = r3;
            this.pkg = r5;
        }
    }

    public static final class j implements q {
        private final String ownerId;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof j) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.ownerId, ((j) r4).ownerId) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.ownerId.hashCode();
        }

        public final String toString() {
            return "ReleaseWifi(ownerId=" + this.ownerId + ')';
        }

        public final String a() {
            return this.ownerId;
        }

        public j(String r2) {
            Intrinsics.checkNotNullParameter(r2, "ownerId");
            this.ownerId = r2;
        }
    }

    public static final class k implements q {
        private final boolean awaitDispatch;
        private final p5 event;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof k) == true) goto L8;
            return false;
        L8:
            k r6 = (k) r5;
            if (Intrinsics.areEqual(this.event, r6.event) == true) goto L12;
            return false;
        L12:
            if (this.awaitDispatch == r6.awaitDispatch) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.event.hashCode() * 31;
            if (this.awaitDispatch == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "Report(event=" + this.event + ", awaitDispatch=" + this.awaitDispatch + ')';
        }

        public final boolean a() {
            return this.awaitDispatch;
        }

        public final p5 b() {
            return this.event;
        }

        public k(p5 r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "event");
            this.event = r2;
            this.awaitDispatch = r3;
        }
    }

    public static final class l implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final boolean onlyWifi;
        private final long operationId;
        private final e5 pkg;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof l) == true) goto L8;
            return false;
        L8:
            l r9 = (l) r8;
            if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
            return false;
        L12:
            if (this.operationId == r9.operationId) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.pkg, r9.pkg) == true) goto L18;
            return false;
        L18:
            if (this.onlyWifi == r9.onlyWifi) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.key.hashCode() * 31;
            long r1 = this.operationId;
            int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.pkg.hashCode()) * 31;
            if (this.onlyWifi == false) goto L5;
            int r3 = 1231;
        L7:
            return r2 + r3;
        L5:
            r3 = 1237;
            goto L7
        }

        public final String toString() {
            return "StartDownload(key=" + this.key + ", operationId=" + this.operationId + ", pkg=" + this.pkg + ", onlyWifi=" + this.onlyWifi + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final boolean b() {
            return this.onlyWifi;
        }

        public final long c() {
            return this.operationId;
        }

        public final e5 d() {
            return this.pkg;
        }

        public l(com.larus.dora.impl.ota.g2.e r2, long r3, e5 r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r5, "pkg");
            this.key = r2;
            this.operationId = r3;
            this.pkg = r5;
            this.onlyWifi = r6;
        }
    }

    public static final class m implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long operationId;
        private final String ownerId;
        private final e5 pkg;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof m) == true) goto L8;
            return false;
        L8:
            m r9 = (m) r8;
            if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r9.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.operationId == r9.operationId) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.pkg, r9.pkg) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
            long r1 = this.operationId;
            return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.pkg.hashCode();
        }

        public final String toString() {
            return "StartUpload(key=" + this.key + ", ownerId=" + this.ownerId + ", operationId=" + this.operationId + ", pkg=" + this.pkg + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.operationId;
        }

        public final String c() {
            return this.ownerId;
        }

        public final e5 d() {
            return this.pkg;
        }

        public m(com.larus.dora.impl.ota.g2.e r2, String r3, long r4, e5 r6) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "ownerId");
            Intrinsics.checkNotNullParameter(r6, "pkg");
            this.key = r2;
            this.ownerId = r3;
            this.operationId = r4;
            this.pkg = r6;
        }
    }

    public static final class n implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long operationId;
        private final String ownerId;
        private final FailureReason reason;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof n) == true) goto L8;
            return false;
        L8:
            n r9 = (n) r8;
            if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r9.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.operationId == r9.operationId) goto L18;
            return false;
        L18:
            if (this.reason == r9.reason) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
            long r1 = this.operationId;
            return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.reason.hashCode();
        }

        public final String toString() {
            return "StopUpload(key=" + this.key + ", ownerId=" + this.ownerId + ", operationId=" + this.operationId + ", reason=" + this.reason + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.operationId;
        }

        public final String c() {
            return this.ownerId;
        }

        public final FailureReason d() {
            return this.reason;
        }

        public n(com.larus.dora.impl.ota.g2.e r2, String r3, long r4, FailureReason r6) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "ownerId");
            Intrinsics.checkNotNullParameter(r6, "reason");
            this.key = r2;
            this.ownerId = r3;
            this.operationId = r4;
            this.reason = r6;
        }
    }
}

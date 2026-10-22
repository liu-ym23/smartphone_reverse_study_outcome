package nub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.rtc.RecordingRtcOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class d {

    public static final class a extends d {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((a) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "Error(err=" + this.a + ')';
        }

        public a(int r1) {
            this.a = r1;
        }
    }

    public static final class b extends d {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "FirstRemoteAudioFrame(rtcJoinId=" + this.a + ')';
        }

        public b(String r1) {
            this.a = r1;
        }
    }

    public static final class c extends d {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "JoinChannelSuccess(channel=" + this.a + ", rtcJoinId=" + this.b + ')';
        }

        public c(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: nub.d$d, reason: collision with other inner class name */
    public static final class C0169d extends d {
        public final oub.a a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0169d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0169d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            oub.a r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "LocalAudioVolumeIndication(rtcAudioVolumeInfo=" + this.a + ')';
        }

        public C0169d(oub.a r1) {
            this.a = r1;
        }
    }

    public static final class e extends d {
        public static final e a = null;

        static {
            a = new e();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof e) == true) goto L9;
            return false;
        L9:
            e r4 = (e) r3;
            return true;
        }

        public final int hashCode() {
            return 324999721;
        }

        public final String toString() {
            return "MicCaptureError";
        }

        public e() {
        }
    }

    public static final class f extends d {
        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof f) == true) goto L9;
            return false;
        L9:
            ((f) r3).getClass();
            return true;
        }

        public final int hashCode() {
            return 1237;
        }

        public final String toString() {
            return "NetworkQualityChanged(isWeak=false)";
        }
    }

    public static final class g extends d {
        public final RecordingRtcOperation a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof g) == true) goto L9;
            return false;
        L9:
            if (this.a == ((g) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "OperationCall(operation=" + this.a + ')';
        }

        public g(RecordingRtcOperation r2) {
            Intrinsics.checkNotNullParameter(r2, "operation");
            this.a = r2;
        }
    }

    public static final class h extends d {
        public final RecordingRtcOperation a;
        public final int b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof h) == true) goto L8;
            return false;
        L8:
            h r6 = (h) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "OperationFailure(operation=" + this.a + ", resultCode=" + this.b + ", resultSource=" + this.c + ')';
        }

        public h(RecordingRtcOperation r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "operation");
            Intrinsics.checkNotNullParameter(r4, "resultSource");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class i extends d {
        public final byte[] a;

        public i(byte[] r1) {
            this.a = r1;
        }
    }

    public static final class j extends d {
        public final byte[] a;

        public j(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
        }
    }

    public static final class k extends d {
        public final int a;
        public final float b;
        public final float c;
        public final float d;
        public final float e;
        public final float f;
        public final float g;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof k) == true) goto L8;
            return false;
        L8:
            k r6 = (k) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r6.b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.c, r6.c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.d, r6.d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.e, r6.e) == 0) goto L24;
            return false;
        L24:
            if (Float.compare(this.f, r6.f) == 0) goto L27;
            return false;
        L27:
            if (Float.compare(this.g, r6.g) == 0) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            return (((((((((((this.a * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f)) * 31) + Float.floatToIntBits(this.g);
        }

        public final String toString() {
            return "SysStatsEvent(cpuCores=" + this.a + ", cpuAppUsage=" + this.b + ", cpuTotalUsage=" + this.c + ", memoryUsage=" + this.d + ", fullMemory=" + this.e + ", totalMemoryUsage=" + this.f + ", freeMemory=" + this.g + ')';
        }

        public k(int r1, float r2, float r3, float r4, float r5, float r6, float r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    public static final class l extends d {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof l) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((l) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "UserJoined(identifier=" + this.a + ')';
        }

        public final String getIdentifier() {
            return this.a;
        }

        public l(String r1) {
            this.a = r1;
        }
    }

    public static final class m extends d {
        public final String a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof m) == true) goto L8;
            return false;
        L8:
            m r6 = (m) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.b;
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "UserOffline(identifier=" + this.a + ", reason=" + this.b + ')';
        }

        public final String getIdentifier() {
            return this.a;
        }

        public m(String r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class n extends d {
        public static final n a = null;

        static {
            a = new n();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof n) == true) goto L9;
            return false;
        L9:
            n r4 = (n) r3;
            return true;
        }

        public final int hashCode() {
            return -853161847;
        }

        public final String toString() {
            return "WeakNetWorkQuality";
        }

        public n() {
        }
    }

    public d() {
    }
}

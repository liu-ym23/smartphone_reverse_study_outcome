package sub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.external_audio.ExternalAudioSourceMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface b {

    public static final class a {
        public final int a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "AudioFormatRequest(sampleRate=" + this.a + ", channel=" + this.b + ')';
        }

        public a(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: sub.b$b, reason: collision with other inner class name */
    public static final class C0190b {
        public final boolean a;
        public final int b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0190b) == true) goto L8;
            return false;
        L8:
            C0190b r6 = (C0190b) r5;
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
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = ((r0 * 31) + this.b) * 31;
            String r2 = this.c;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "InitResult(success=" + this.a + ", bufferSize=" + this.b + ", errorMessage=" + this.c + ')';
        }

        public C0190b(boolean r1, int r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public /* synthetic */ C0190b(boolean r2, int r3, String r4, int r5) {
            if ((r5 & 2) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = null;
        L8:
            this(r2, r3, r4);
        }
    }

    public static final class c {
        public final boolean a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            String r2 = this.b;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "StartResult(success=" + this.a + ", errorMessage=" + this.b + ')';
        }

        public c(boolean r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    void a();

    ExternalAudioSourceMode b();

    void c();

    void close();

    C0190b d(a r1);

    void pause();

    int read(byte[] r1, int r2);

    c startCapture();
}

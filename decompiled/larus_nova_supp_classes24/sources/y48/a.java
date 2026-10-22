package y48;

import com.larus.asr.VoiceInputType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class a {

    /* JADX INFO: renamed from: y48.a$a, reason: collision with other inner class name */
    public static final class C0137a extends a {
        public static final C0137a a = null;

        static {
            a = new C0137a();
        }

        public C0137a() {
        }
    }

    public static final class b extends a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a {
        public final boolean a;
        public final VoiceInputType b;

        public c() {
            this(0);
        }

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
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (r0 * 31) + this.b.hashCode();
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "Submit(handsFree=" + this.a + ", voiceInputType=" + this.b + ')';
        }

        public c(int r2) {
            VoiceInputType r3 = VoiceInputType.TouchSpeaker;
            Intrinsics.checkNotNullParameter(r3, "voiceInputType");
            this.a = false;
            this.b = r3;
        }
    }

    public a() {
    }
}

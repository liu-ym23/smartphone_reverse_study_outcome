package hia;

import by7.e;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.im.bean.bot.SpeakerVoice;
import com.obric.audio.continuous_talk.k0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.CallbackFlowBuilder;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface a {
    public static final C0057a a = null;

    /* JADX INFO: renamed from: hia.a$a, reason: collision with other inner class name */
    public static final class C0057a {
        public static final /* synthetic */ C0057a a = null;

        static {
            a = new C0057a();
        }

        public C0057a() {
        }
    }

    public interface b {
        CallbackFlowBuilder a(long r1);

        void b();
    }

    public static final class c {
        public final Map<String, String> a;
        public final boolean b;

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
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "LLMContextInfo(params=" + this.a + ", isFinish=" + this.b + ')';
        }

        public c(Map<String, String> r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "params");
            this.a = r2;
            this.b = r3;
        }
    }

    public static abstract class d {

        /* JADX INFO: renamed from: hia.a$d$a, reason: collision with other inner class name */
        public static final class C0058a extends d {
            public final int a;
            public final String b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0058a) == true) goto L8;
                return false;
            L8:
                C0058a r6 = (C0058a) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "FAILURE(errorCode=" + this.a + ", errorMsg=" + this.b + ')';
            }

            public C0058a(int r2, String r3) {
                Intrinsics.checkNotNullParameter(r3, "errorMsg");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class b extends d {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public d() {
        }
    }

    static {
        a = C0057a.a;
    }

    d I0(JSONObject r1);

    boolean a(String r1);

    boolean a0();

    void b();

    d.b c();

    d d(JSONObject r1);

    void e(k0 r1);

    d f(String r1, String r2, Integer r3, Integer r4, String r5, String r6, SpeakerVoice r7, de8.c r8, e r9, String r10, String r11, String r12, RealtimeCallParam.l r13);

    void g();

    i1<AVKitDuplexState> h();

    Flow<r58.d> i();

    boolean isActive();

    void j(boolean r1);

    boolean k();

    Flow<hia.b> s();
}

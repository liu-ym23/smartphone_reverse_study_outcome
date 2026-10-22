package g58;

import com.larus.audio.call.tracer.AudioFileSaver;
import com.larus.media.MediaLevel;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MixPriority;
import com.larus.media.o0;
import com.larus.media.v;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h {
    public static final /* synthetic */ int z = 0;
    public r78.c a;
    public String b;
    public JSONObject c;
    public y58.a d;
    public AudioFileSaver e;
    public boolean f;
    public final Lazy g;
    public String h;
    public String i;
    public int j;
    public String k;
    public long l;
    public long m;
    public long n;
    public long o;
    public final Lazy p;
    public final Lazy q;
    public boolean r;
    public boolean s;
    public p68.c t;
    public final ExecutorService u;
    public p v;
    public q w;
    public final com.larus.media.model.a x;
    public final com.larus.media.model.a y;

    public static final class a {
    }

    public static final class b implements v {
        public b() {
        }

        public final boolean b(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            Map r0 = o0.a;
            return o0.a("AI_NOTE", r2.getScene());
        }

        public final void e(lk9.g r1) {
            v.a.d(r1);
        }

        public final void f(MediaResourceManager.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void a(lk9.g r1, float r2) {
            v.a.f(r1, r2);
        }

        public final void d(lk9.g r1, lk9.g r2) {
            v.a.c(r1, r2);
        }

        public final void g(lk9.g r1, float r2) {
            v.a.g(r1, r2);
        }

        public final void i(lk9.g r1, lk9.g r2) {
            v.a.e(r1, r2);
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r3, lk9.g r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "current");
            Intrinsics.checkNotNullParameter(r4, "applicant");
            FLogger.a.i("AiAsrManager", "PlayApplicant, gainOccupiedStrategy, current: " + r3.getScene() + ", applicant:" + r4.getScene());
            Map r6 = o0.a;
            return o0.b("AI_NOTE", r4.getScene());
        }
    }

    public static final class c implements v {
        public c() {
        }

        public final boolean b(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            return true;
        }

        public final void e(lk9.g r1) {
            v.a.d(r1);
        }

        public final void f(MediaResourceManager.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void a(lk9.g r3, float r4) {
            Intrinsics.checkNotNullParameter(r3, "applicant");
            FLogger.a.i("AiAsrManager", "RecordApplicant, onMediaResume, applicant:" + r3.getScene());
        }

        public final void d(lk9.g r1, lk9.g r2) {
            v.a.c(r1, r2);
        }

        public final void g(lk9.g r1, float r2) {
            v.a.g(r1, r2);
        }

        public final void i(lk9.g r1, lk9.g r2) {
            v.a.e(r1, r2);
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r3, lk9.g r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "current");
            Intrinsics.checkNotNullParameter(r4, "applicant");
            FLogger.a.i("AiAsrManager", "RecordApplicant, gainOccupiedStrategy, current: " + r3.getScene() + ", applicant:" + r4.getScene());
            if (Intrinsics.areEqual(r4.getScene(), "CALL") == false) goto L5;
        L13:
            t0.a.postDelayed(new o(), 500);
            return MediaOccupyStrategy.REJECT;
        L5:
            if (Intrinsics.areEqual(r4.getScene(), "O_CALL") == true) goto L13;
            if (Intrinsics.areEqual(r4.getScene(), "asr") == true) goto L13;
            if (Intrinsics.areEqual(r4.getScene(), "dora") == true) goto L13;
            return v.a.b(r3, r4);
        }
    }

    static {
    }

    public h() {
        this.b = "";
        this.g = LazyKt.lazy(new g58.a());
        this.p = LazyKt.lazy(new g58.b());
        this.q = LazyKt.lazy(new g58.c());
        this.u = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("/AiAsrManager"));
        int r12 = MediaLevel.RECORD_LOW.getValue();
        MixPriority r1 = MixPriority.DEFAULT;
        this.x = new com.larus.media.model.a(null, "AI_NOTE", false, 0, 1, false, r1.getValue(), false, false, r12, false, new c(), 1453);
        int r26 = MediaLevel.PLAY_BIG_HIGH.getValue();
        this.y = new com.larus.media.model.a(null, "AI_NOTE", false, 0, 2, false, r1.getValue(), false, false, r26, false, new b(), 1453);
    }

    public final i58.e c() {
        return (i58.e) this.g.getValue();
    }

    public static final void a(h r3) {
        if (r3.f == false) goto L5;
        i58.e r0 = r3.c();
        final String r1 = r3.h;
        final Integer r2 = Integer.valueOf(r3.j);
        final String r4 = r3.k;
        r0.getClass();
        l0.b(new i58.b(r1, r2, r4));
        return;
    L5:
        i58.e r5 = r3.c();
        String r6 = r3.h;
        Integer r7 = Integer.valueOf(r3.j);
        String r8 = r3.k;
        r5.getClass();
        l0.b(new i58.a(r6, r7, r8));
    }

    public static final void b(final h r3, String r4) {
        r3.getClass();
        FLogger.a.i("AiAsrManager", "stopSession");
        r3.r = false;
        p68.c r0 = r3.t;
        if (r0 == null) goto L5;
        r0.e(r4);
    L5:
        r3.t = null;
        final r78.c r1 = r3.a;
        r3.a = null;
        r3.u.submit(new g(r3, r1));
    }
}

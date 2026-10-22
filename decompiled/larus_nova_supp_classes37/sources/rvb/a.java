package rvb;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmSubtitleAsrOptConfig;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.helper.MmSubtitleSmoothType;
import com.ss.android.lark.pb.minutes.v1.RecordingSubtitleData;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final MmSubtitleSmoothType a;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a b;
    public final String c;
    public final ConcurrentHashMap<Long, d> d;
    public final ConcurrentHashMap<Long, Boolean> e;
    public final ConcurrentHashMap<String, Long> f;
    public Handler g;
    public final AtomicBoolean h;
    public final List<c> i;
    public final int j;
    public final MmSubtitleAsrOptConfig k;

    /* JADX INFO: renamed from: rvb.a$a, reason: collision with other inner class name */
    public static final class C0186a {
    }

    public static abstract class b {

        /* JADX INFO: renamed from: rvb.a$b$a, reason: collision with other inner class name */
        public static final class C0187a extends b {
            public static final C0187a a = null;

            static {
                a = new C0187a();
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if ((r3 instanceof C0187a) == true) goto L9;
                return false;
            L9:
                C0187a r4 = (C0187a) r3;
                return true;
            }

            public final int hashCode() {
                return 734576710;
            }

            public final String toString() {
                return "Finished";
            }

            public C0187a() {
            }
        }

        /* JADX INFO: renamed from: rvb.a$b$b, reason: collision with other inner class name */
        public static final class C0188b extends b {
            public static final C0188b a = null;

            static {
                a = new C0188b();
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if ((r3 instanceof C0188b) == true) goto L9;
                return false;
            L9:
                C0188b r4 = (C0188b) r3;
                return true;
            }

            public final int hashCode() {
                return 1589704869;
            }

            public final String toString() {
                return "NoChange";
            }

            public C0188b() {
            }
        }

        public static final class c extends b {
            public final int a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof c) == true) goto L9;
                return false;
            L9:
                if (this.a == ((c) r4).a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a;
            }

            public final String toString() {
                return "Progress(nextIndex=" + this.a + ')';
            }

            public c(int r1) {
                this.a = r1;
            }
        }

        public b() {
        }
    }

    public interface c {
        void a(RecordingSubtitleData r1, String r2, MmSubtitleSmoothType r3);
    }

    public static final class d {
        public final RecordingSubtitleData a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "SmoothSubtitleState(data=" + this.a + ", progress=" + this.b + ')';
        }

        public d(RecordingSubtitleData r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Handler r0 = this.a.g;     // Catch: Throwable -> L12
            if (r0 == null) goto L5;
            r0.removeCallbacksAndMessages(null);     // Catch: Throwable -> L12
        L5:
            Handler r1 = this.a.g;     // Catch: Throwable -> L12
            if (r1 == null) goto L10;
            Looper r2 = r1.getLooper();     // Catch: Throwable -> L12
            if (r2 == null) goto L10;
            ThreadMethodProxy.quit(r2);     // Catch: Throwable -> L12
        L10:
            this.a.g = null;     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L16;
            return;
        L16:
            throw th;
        }
    }

    static {
    }

    public final void a() {
        lvb.a.e(this.c, "clearCache");
        this.d.clear();
        this.h.set(false);
        this.f.clear();
        Handler r0 = this.g;
        if (r0 == null) goto L6;
        r0.post(new e(this));
        return;
    }

    public static boolean b(RecordingSubtitleData r2) {
        if (r2.sound_type == RecordingSubtitleData.SoundType.NOISE) goto L10;
        RecordingSubtitleData.Subtitle r3 = r2.target;
        if (r3 == null) goto L10;
        if (TextUtils.isEmpty(r3.content) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public a(MmSubtitleSmoothType r3, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r4) {
        Intrinsics.checkNotNullParameter(r3, "smoothType");
        Intrinsics.checkNotNullParameter(r4, "mmUccApi");
        this.a = r3;
        this.b = r4;
        this.c = "MmSmoothSubtitleManager_" + r3.name();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.h = new AtomicBoolean(false);
        this.i = new CopyOnWriteArrayList();
        this.j = 100;
        this.k = r4.getSettingsService().f;
    }

    public final void c(RecordingSubtitleData r4, String r5) {
        if (this.h.get() == false) goto L8;
        Iterator r0 = ((CopyOnWriteArrayList) this.i).iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        ((c) r0.next()).a(r4, r5, this.a);
        goto L6
    L10:
        return;
    }
}

package c3b;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.media.MediaMutex;
import com.ss.android.lark.media.MediaType;
import com.ss.android.lark.media.Scene;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static InterfaceC0015a a;
    public static final b b = null;

    /* JADX INFO: renamed from: c3b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0015a {

        /* JADX INFO: renamed from: c3b.a$a$a, reason: collision with other inner class name */
        public static final class C0016a implements InterfaceC0015a {
            public final MediaMutex.LockError a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0016a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0016a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Error(lockError=" + this.a + ')';
            }

            public C0016a(MediaMutex.LockError r2) {
                Intrinsics.checkNotNullParameter(r2, "lockError");
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: c3b.a$a$b */
        public static final class b implements InterfaceC0015a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: c3b.a$a$c */
        public static final class c implements InterfaceC0015a {
            public final Scene a;
            public final MediaType b;
            public final String c;

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
                if (this.b == r6.b) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
                String r1 = this.c;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public final String toString() {
                return "Interrupted(byScene=" + this.a + ", type=" + this.b + ", interruptMsg=" + this.c + ')';
            }

            public final MediaType getType() {
                return this.b;
            }

            public c(Scene r2, MediaType r3) {
                Intrinsics.checkNotNullParameter(r2, "byScene");
                Intrinsics.checkNotNullParameter(r3, IPortraitService.TYPE);
                this.a = r2;
                this.b = r3;
                this.c = BuildConfig.FLAVOR;
            }
        }

        /* JADX INFO: renamed from: c3b.a$a$d */
        public static final class d implements InterfaceC0015a {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }
    }

    public static final class b implements com.ss.android.lark.media.a {
        public b() {
        }

        public final void onSuccess() {
            InterfaceC0015a r0 = a.a;
            a.a = InterfaceC0015a.d.a;
            Log.i("AudioPlayMutexController", "media occupy success");
        }

        public final void a(MediaMutex.LockError r3) {
            Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_ERROR);
            InterfaceC0015a r0 = a.a;
            a.a = new InterfaceC0015a.C0016a(r3);
            Log.w("AudioPlayMutexController", "media is occupied by " + r3.getOccupiedScene());
        }

        public final void b(Scene r3, MediaType r4) {
            Intrinsics.checkNotNullParameter(r3, "byScene");
            Intrinsics.checkNotNullParameter(r4, IPortraitService.TYPE);
            Log.i("AudioPlayMutexController", "Interrupted byScene:" + r3 + ",type:" + r4 + ",interruptMsg:");
            InterfaceC0015a r0 = a.a;
            a.a = new InterfaceC0015a.c(r3, r4);
        }

        public final void c(Scene r3, MediaType r4) {
            Intrinsics.checkNotNullParameter(r3, "fromScene");
            Intrinsics.checkNotNullParameter(r4, IPortraitService.TYPE);
            Log.i("AudioPlayMutexController", "InterruptionEnd fromScene:" + r3 + ",type:" + r4);
        }
    }

    static {
        a = InterfaceC0015a.b.a;
        b = new b();
    }

    public static void a() {
        if ((a instanceof InterfaceC0015a.d) == true) goto L6;
        Log.i("AudioPlayMutexController", "releaseMediaResource isOccupied=false");
        return;
    L6:
        Log.i("AudioPlayMutexController", "releaseMediaResource unlock");
        a = InterfaceC0015a.b.a;
        MediaMutex.r.n(Scene.IM_Audio_Play, b);
    }

    public static boolean b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if ((a instanceof InterfaceC0015a.d) == false) goto L5;
        Log.i("AudioPlayMutexController", "occupyMediaResource isOccupied");
    L6:
        InterfaceC0015a r0 = a;
        if ((r0 instanceof InterfaceC0015a.d) == false) goto L10;
        return true;
    L10:
        if ((r0 instanceof InterfaceC0015a.C0016a) == false) goto L13;
        UDToast.show(r4, ((InterfaceC0015a.C0016a) r0).a.getErrorMessage());
    L17:
        return false;
    L13:
        if ((r0 instanceof InterfaceC0015a.c) == false) goto L17;
        String r1 = ((InterfaceC0015a.c) r0).c;
        if (r1 == null) goto L17;
        UDToast.show(r4, r1);
        goto L17
    L5:
        MediaMutex.r.getClass();
        Log.i("AudioPlayMutexController", "occupyMediaResource tryLock, fg:true");
        MediaMutex.r.l(Scene.IM_Audio_Play, true, b, true);
        goto L6
    }
}

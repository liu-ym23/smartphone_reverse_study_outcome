package com.bytedance.android.live.broadcastgame.xplay;

import com.google.gson.JsonObject;
import io.reactivex.Completable;
import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface e {

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.xplay.e$a$a, reason: collision with other inner class name */
        public static final class C0102a extends a {
            public final Throwable a;

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof C0102a) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.a, ((C0102a) r2).a) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                Throwable r0 = this.a;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
            }

            public final String toString() {
                return "Failed(cause=" + this.a + ")";
            }

            public C0102a(Throwable r2) {
                Intrinsics.checkNotNullParameter(r2, "cause");
                this.a = r2;
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
            public final float a;

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof c) == true) goto L6;
                return false;
            L6:
                if (Float.compare(this.a, ((c) r2).a) == 0) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                return Float.floatToIntBits(this.a);
            }

            public final String toString() {
                return "Loading(progress=" + this.a + ")";
            }

            public c(float r1) {
                this.a = r1;
            }
        }

        public a() {
        }
    }

    Completable J();

    void a(a r1);

    Completable c();

    Completable d();

    Observable<Unit> f();

    Completable g();

    XplayApi.j getRtcInfo();

    void handleAnchorPanelJSBInvoke(String r1, JsonObject r2, Function1<? super JsonObject, Unit> r3);
}

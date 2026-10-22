package com.larus.camera.impl.edulibs.camera;

import android.content.Context;
import com.larus.camera.impl.edulibs.cameraapi.IdentifyDetectionResult;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import nx8.d;
import nx8.i;
import nx8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final a a = null;
    public static final d b = null;
    public static b c;
    public static nx8.a d;
    public static final Map<String, IdentifyDetectionResult> e = null;

    /* JADX INFO: renamed from: com.larus.camera.impl.edulibs.camera.a$a, reason: collision with other inner class name */
    public static final class C0075a implements k {
        public static final C0075a a = null;

        static {
            a = new C0075a();
        }

        public C0075a() {
        }

        @Override // nx8.k
        public final void d(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            FLogger.a.d(r2, r3);
        }

        @Override // nx8.k
        public final void i(String r2, String r3) {
            Intrinsics.checkNotNullParameter("EduCamera", "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            FLogger.a.i("EduCamera", r3);
        }

        @Override // nx8.k
        public final void e(String r2, String r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            FLogger.a.e(r2, r3, r4);
        }
    }

    public static final class b implements k {
        public final k a;

        public b(k r2) {
            Intrinsics.checkNotNullParameter(r2, "logger");
            this.a = r2;
        }

        @Override // nx8.k
        public final void d(String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "tag");
            Intrinsics.checkNotNullParameter(r5, "msg");
            this.a.d("EduCamera", "[" + r4 + ']' + r5);
        }

        @Override // nx8.k
        public final void i(String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "tag");
            Intrinsics.checkNotNullParameter(r5, "msg");
            this.a.i("EduCamera", "[" + r4 + ']' + r5);
        }

        @Override // nx8.k
        public final void e(String r4, String r5, Throwable r6) {
            Intrinsics.checkNotNullParameter(r4, "tag");
            Intrinsics.checkNotNullParameter(r5, "msg");
            this.a.e("EduCamera", "[" + r4 + ']' + r5, r6);
        }
    }

    public a() {
    }

    static {
        a = new a();
        b = new d(0);
        c = new b(C0075a.a);
        e = new LinkedHashMap();
    }

    public final c a(Context r2, i r3, Map r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "eduImageScene");
        return new c(r2, r3, r4);
    }
}

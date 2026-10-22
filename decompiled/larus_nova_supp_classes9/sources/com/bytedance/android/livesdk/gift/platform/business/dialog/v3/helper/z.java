package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.anya.q0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z implements com.bytedance.android.scope.o {

    public static final class a implements mb.c {
        public a() {
        }

        public final void a(String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter("ttlive_anya_executor", "tag");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void logD(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void logW(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }
    }

    public static final class b implements mb.c {
        public b() {
        }

        public final void a(String r3, Throwable r4) {
            Intrinsics.checkNotNullParameter("ttlive_anya_executor", "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            jy0.b.b("ttlive_anya_executor", r3, r4);
        }

        public final void logD(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            jy0.b.a(r2, r3);
        }

        public final void logW(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "tag");
            Intrinsics.checkNotNullParameter(r4, "msg");
            jy0.b.f(r3, r4, null, 4);
        }
    }

    public z() {
    }

    public final void onStop() {
    }

    public final void onStart() {
        boolean r0 = q0.a;
        ReadOnlyProperty r1 = m.b;
        KProperty[] r2 = m.a;
        q0.a = ((Boolean) r1.getValue(null, r2[0])).booleanValue();
        q0.b = ((Boolean) m.c.getValue(null, r2[1])).booleanValue();
        q0.c = ((Boolean) m.d.getValue(null, r2[2])).booleanValue();
        q0.d = ((Boolean) m.e.getValue(null, r2[3])).booleanValue();
        q0.e = ((Boolean) m.f.getValue(null, r2[4])).booleanValue();
        q0.f = ((Boolean) m.h.getValue(null, r2[6])).booleanValue();
        if (((Boolean) m.g.getValue(null, r2[5])).booleanValue() == false) goto L5;
        mb.c r3 = mb.a.a;
        mb.a.a = new a();
        return;
    L5:
        mb.c r4 = mb.a.a;
        mb.a.a = new b();
    }
}

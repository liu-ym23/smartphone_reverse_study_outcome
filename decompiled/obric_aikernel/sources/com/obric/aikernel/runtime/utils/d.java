package com.obric.aikernel.runtime.utils;

import android.util.Log;
import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f5417a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f5418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f5419c = null;

    public static final class a implements c {
        a() {
        }

        @Override // com.obric.aikernel.runtime.utils.c
        public void a(String r10, String r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, "message");
            switch(r12) {
                case 2: goto L9;
                case 3: goto L8;
                case 4: goto L7;
                case 5: goto L6;
                case 6: goto L5;
                case 7: goto L5;
                default: goto L8;
            };
        L5:
            Log.e(r10, r11);
            return;
        L6:
            Log.w(r10, r11);
            return;
        L7:
            Log.i(r10, r11);
            return;
        L8:
            Log.d(r10, r11);
            return;
        L9:
            Log.v(r10, r11);
        }

        @Override // com.obric.aikernel.runtime.utils.c
        public void aeeLog(int r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, "tag");
            Intrinsics.checkNotNullParameter(r12, "content");
            a(r11, r12, r10);
        }

        @Override // com.obric.aikernel.runtime.utils.c
        public void b(String r10, JSONObject r11) {
            Intrinsics.checkNotNullParameter(r10, "key");
            Intrinsics.checkNotNullParameter(r11, "data");
            Log.i("TRACKING-" + r10, r11.toString(0));
        }
    }

    static {
        f5417a = new d();
        f5419c = new a();
    }

    private d() {
    }

    @Override // com.obric.aikernel.runtime.utils.c
    public void a(String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "message");
        c r13 = f5418b;
        if (r13 != null) goto L5;
        r13 = f5419c;
    L5:
        r13.a(r10, r11, r12);
    }

    @Override // com.obric.aikernel.runtime.utils.c
    public void aeeLog(int r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "tag");
        Intrinsics.checkNotNullParameter(r12, "content");
        c r13 = f5418b;
        if (r13 != null) goto L5;
        r13 = f5419c;
    L5:
        r13.aeeLog(r10, r11, r12);
    }

    @Override // com.obric.aikernel.runtime.utils.c
    public void b(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "data");
        c r12 = f5418b;
        if (r12 != null) goto L5;
        r12 = f5419c;
    L5:
        r12.b(r10, r11);
    }

    public final void c(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "message");
        a(r10, r11, 3);
    }

    public final void d(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "message");
        c(r10, r11);
    }

    public final void e(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "message");
        a(r10, r11, 6);
    }

    public final void f(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "message");
        e(r10, r11);
    }

    public final void g(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "message");
        a(r10, r11, 4);
    }

    public final void h(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "version");
        Intrinsics.checkNotNullParameter(r13, "message");
        aeeLog(4, r10 + '-' + r11 + '@' + r12, r13);
    }

    public final void i(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "message");
        g(r10, r11);
    }

    public final void j(c r10) {
        f5418b = r10;
    }

    public final void k(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "message");
        a(r10, r11, 2);
    }

    public final void l(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "message");
        a(r10, r11, 5);
    }
}

package com.bytedance.android.annie.ng;

import android.app.Application;
import com.bytedance.android.annie.Annie;
import com.bytedance.ies.bullet.base.BulletSdk;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final o8.c a;
    public final o8.b b;
    public final o8.d c;

    public static final class a {
        public final Application a;

        public final void a() {
            boolean r0 = BulletSdk.a;
            BulletSdk.c(this.a);
            Application r1 = this.a;
            Application r10 = g.a;
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            g.a = r1;
            d r11 = new d(e.b, e.c, e.d);
            f r12 = new f();
            Intrinsics.checkNotNullParameter(r11, "<set-?>");
            g.b = r11;
            Intrinsics.checkNotNullParameter(r12, "<set-?>");
            com.bytedance.android.annie.ng.a.C0073a r13 = new com.bytedance.android.annie.ng.a.C0073a("host");
            AnnieGlobalConfig$Builder$init$2 r14 = AnnieGlobalConfig$Builder$init$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r14, "block");
            r14.invoke(r13.d);
            AnnieGlobalConfig$Builder$init$3 r15 = AnnieGlobalConfig$Builder$init$3.INSTANCE;
            Intrinsics.checkNotNullParameter(r15, "block");
            r15.invoke(r13.b);
            AnnieGlobalConfig$Builder$init$4 r16 = AnnieGlobalConfig$Builder$init$4.INSTANCE;
            Intrinsics.checkNotNullParameter(r16, "block");
            r16.invoke(r13.c);
            AnnieGlobalConfig$Builder$init$5 r17 = AnnieGlobalConfig$Builder$init$5.INSTANCE;
            Intrinsics.checkNotNullParameter(r17, "block");
            r17.invoke(r13.e);
            r13.a();
            if (g.g == true) goto L5;
            ((b9.b) Annie.getService$default(b9.b.class, null, 2, null)).init();
        L5:
            g.g = true;
            Map<String, j> r18 = i.b;
            monitor-enter(r18);
            Iterator r19 = ((LinkedHashMap) r18).entrySet().iterator();     // Catch: Throwable -> L14
        L9:
            if (r19.hasNext() == false) goto L11;
            ((j) ((Map.Entry) r19.next()).getValue()).onCallback();     // Catch: Throwable -> L14
            goto L9
        L11:
            Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L14
            monitor-exit(r18);
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public a(Application r10) {
            Intrinsics.checkNotNullParameter(r10, "application");
            this.a = r10;
        }
    }

    public d(o8.c r10, o8.b r11, o8.d r12) {
        o8.a r0 = e.a;
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}

package com.ss.android.lark.contact.base.service;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.api.OpenConfig;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.ViewUtils;
import com.ss.android.lark.utils.r0;
import com.ss.android.lark.utils.s0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c0 {
    public static final /* synthetic */ int a = 0;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.contact.base.service.c0$a$a, reason: collision with other inner class name */
        public static final class C0167a extends s0.c<z8b.a> {
            public final /* synthetic */ ApiUtils.a<z8b.a> j;

            public final Object c() {
                final s0.b r0 = new s0.b();
                int r1 = c0.a;
                a0.g(true);
                int r2 = d.a;
                d.b(new InviteExternalService$Companion$getInvitationInfo$1(r0));
                if (r0.b.get() == true) goto L9;
                r0.a.await();     // Catch: InterruptedException -> L6
            L6:
                e = move-exception;
                e.printStackTrace();
            L9:
                return (z8b.a) r0.c;
            }

            public C0167a(ApiUtils.a<z8b.a> r1) {
                this.j = r1;
            }

            public final void d(Object r2) {
                ApiUtils.a<z8b.a> r0 = this.j;
                r0.consume((z8b.a) r2);
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ ApiUtils.a<z8b.a> a;

            public b(ApiUtils.a<z8b.a> r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.consume(null);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @JvmStatic
        public static void a(Context r4, ApiUtils.a r5) {
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "consumer");
            C0167a r0 = new C0167a(r5);
            b r1 = new b(r5);
            ((s0.c) r0).g = OpenConfig.DEFAULT_LOADING_TIMEOUT;
            ((s0.c) r0).h = r1;
            ViewUtils.runOnUiThread(new r0(r4, r0));
        }
    }

    static {
    }
}

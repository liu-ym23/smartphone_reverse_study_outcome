package com.bytedance.android.live.cloudgrouplive.core;

import a40.m;
import android.content.DialogInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.cloudgrouplive.model.CloudGroupLivePipelineStatus;
import com.bytedance.android.live.cloudgrouplive.rtc.CloudGroupLiveRTCManager;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.message.model.d3;
import com.bytedance.android.livesdk.widget.x0;
import e40.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements m {
    public final /* synthetic */ CloudGroupLiveManager a;

    public static final class a implements DialogInterface.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public c(CloudGroupLiveManager r1) {
        this.a = r1;
    }

    @Override // a40.m
    public final void b3(long r9) {
        ALogger.i("CloudGroupLiveManager", "joinCloudGroupLive success duration " + r9);
        d r0 = this.a.l;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNullParameter("success", "<set-?>");
        r0.g = "success";
    L5:
        d r1 = this.a.l;
        if (r1 == null) goto L8;
        r1.h = r9;
    L8:
        if (r1 == null) goto L10;
        Intrinsics.checkNotNullParameter("success", "<set-?>");
        r1.e = "success";
    L10:
        d r11 = this.a.l;
        if (r11 == null) goto L13;
        r11.f = System.currentTimeMillis() - this.a.o;
    L13:
        d r12 = this.a.l;
        if (r12 == null) goto L16;
        int r13 = f40.a.a;
        f40.a.c(r12);
    L16:
        this.a.g(CloudGroupLivePipelineStatus.START);
        CloudGroupLiveManager r14 = this.a;
        d40.a r2 = r14.j;
        long r6 = 0;
        if (r2 == null) goto L25;
        d3 r15 = r14.k;
        if (r15 == null) goto L23;
        Long r16 = r15.E();
        if (r16 == null) goto L23;
        long r3 = r16.longValue();
    L24:
        r2.a(r3, this.a.d(), "join_success");
    L23:
        r3 = 0;
    L25:
        f r17 = this.a.g;
        if (r17 == null) goto L28;
        ALogger.i("CloudGroupLiveWindowManager", "receive showView");
        int r4 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.WINDOW_MANAGER, "showView", 0, null, 28);
        r17.c(0);
        r17.b(140);
    L28:
        xs2.b r18 = xs2.b.a();
        d3 r5 = this.a.k;
        if (r5 == null) goto L33;
        Long r7 = r5.E();
        if (r7 == null) goto L33;
        r6 = r7.longValue();
    L33:
        d3 r8 = this.a.k;
        if (r8 == null) goto L37;
        IBaseUser r19 = r8.getFromUser();
        if (r19 == null) goto L37;
    L38:
        r18.post(new dh1.b(1, new dh1.a(r6, r19, null)));
        x0.b r21 = new x0.b(this.a.getContext(), 4);
        r21.m(2131915845);
        r21.l(2131915844);
        r21.i(0, 2131915861, a.a);
        r21.k(0, true);
        r21.n();
        return;
    L37:
        r19 = new User();
        goto L38
    }

    @Override // a40.m
    public final void a3(long r3, Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "throwable");
        ALogger.i("CloudGroupLiveManager", "joinCloudGroupLive failed duration " + r3 + " error " + r5);
        d r0 = this.a.l;
        if (r0 == null) goto L5;
        String r6 = String.valueOf(r5.getMessage());
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r0.g = r6;
    L5:
        d r7 = this.a.l;
        if (r7 == null) goto L8;
        r7.h = r3;
    L8:
        if (r7 == null) goto L10;
        int r4 = f40.a.a;
        f40.a.c(r7);
    L10:
        this.a.g(CloudGroupLivePipelineStatus.END);
        CloudGroupLiveRTCManager r8 = this.a.e;
        if (r8 == null) goto L14;
        r8.f("join_api_failed");
        return;
    }
}

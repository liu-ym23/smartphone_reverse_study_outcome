package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.q2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public final yz0.k b;
    public final q2 c;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.a$a, reason: collision with other inner class name */
    public static final class C0040a<T> implements Consumer {
        public final /* synthetic */ a a;

        public C0040a(a r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            a r0 = this.a;
            r0.getClass();
            mz0.n r1 = new mz0.n();
            r0.d(r1);
            mz0.o r2 = new mz0.o(r1.a);
            a.c(r2);
            r2.a("bar_type", "2312");
            r2.a("banner_info", "normal");
            r0.a(r2);
            r2.a("notice_text", (String) r6);
            cy0.e.a.getClass();
            cy0.j r7 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r8 = com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r8);
            ((f80.a) r8).w3("livesdk_gift_bar_show", r1.a, r1.b);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Unit r6 = (Unit) r5;
            a r7 = this.a;
            r7.getClass();
            mz0.n r0 = new mz0.n();
            r7.d(r0);
            mz0.o r1 = new mz0.o(r0.a);
            r1.a("bar_type", "2312");
            r1.a("banner_info", "normal");
            r7.a(r1);
            a.c(r1);
            r1.a("button_type", "check");
            cy0.e.a.getClass();
            cy0.j r8 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r9);
            ((f80.a) r9).w3("livesdk_activity_gift_bar_click", r0.a, r0.b);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            q2.a r8 = (q2.a) r7;
            a r0 = this.a;
            r0.getClass();
            mz0.n r1 = new mz0.n();
            h1 r2 = null;
            String r3 = r8.a;     // Catch: Exception -> L24
            if (r3 == null) goto L6;
            long r4 = CastLongProtector.parseLong(r3);     // Catch: Exception -> L24
        L7:
            r2 = GiftManagerKt.j(r4, null);     // Catch: Exception -> L24
            goto L8
        L6:
            r4 = 0;
        L8:
            r0.d(r1);
            mz0.o r5 = new mz0.o(r1.a);
            a.c(r5);
            r0.a(r5);
            String r6 = r8.a;
            if (r6 == null) goto L11;
            r5.a("gift_id", r6);
        L11:
            String r9 = r8.b;
            if (r9 == null) goto L15;
            r5.a("prop_id", r9);
        L15:
            if (r8.d == false) goto L19;
            String r10 = r0.c.getScene();
            if (r10 == null) goto L19;
            r5.a("guide_type", r10);
        L19:
            if (r2 == null) goto L21;
            int r11 = r2.getDiamondCount();
        L22:
            r5.a("gift_price", String.valueOf(r11));
            r5.a("gift_cnt", String.valueOf(r8.e));
            r5.a("event_session_id", r8.f);
            cy0.e.a.getClass();
            cy0.j r13 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r14);
            ((f80.a) r14).w3("livesdk_gift_combo_show", r1.a, r1.b);
            return;
        L21:
            r11 = 0;
            goto L22
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            q2.a r7 = (q2.a) r6;
            a r0 = this.a;
            r0.getClass();
            mz0.n r1 = new mz0.n();
            r0.d(r1);
            mz0.o r2 = new mz0.o(r1.a);
            a.c(r2);
            r0.a(r2);
            String r3 = r7.a;
            if (r3 == null) goto L5;
            r2.a("gift_id", r3);
        L5:
            String r4 = r7.b;
            if (r4 == null) goto L9;
            r2.a("prop_id", r4);
        L9:
            if (r7.d == false) goto L13;
            String r5 = r0.c.getScene();
            if (r5 == null) goto L13;
            r2.a("guide_type", r5);
        L13:
            r2.a("long_press_cnt", String.valueOf(r7.c));
            cy0.e.a.getClass();
            cy0.j r8 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r9);
            ((f80.a) r9).w3("livesdk_gift_combo_click", r1.a, r1.b);
            Iterator r10 = da0.a.a.iterator();
        L15:
            if (r10.hasNext() == false) goto L17;
            ((ca0.p) r10.next()).v();
            goto L15
        }
    }

    public final void onStart() {
        RxUtilKt.c(this.c.X4().subscribe(new C0040a(this)), this.a);
        RxUtilKt.c(this.c.w5().subscribe(new b(this)), this.a);
        RxUtilKt.c(this.c.K5().subscribe(new c(this)), this.a);
        RxUtilKt.c(this.c.bh().subscribe(new d(this)), this.a);
    }

    public final void onStop() {
        this.a.dispose();
    }

    public static void c(mz0.o r2) {
        r2.a("user_id", com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId());
    }

    public final void a(mz0.o r3) {
        if (this.b.isAnchor() == false) goto L5;
        String r0 = "1";
    L6:
        r3.a("is_anchor", r0);
        return;
    L5:
        r0 = "0";
        goto L6
    }

    public final void d(mz0.n r3) {
        mz0.m r0 = new mz0.m();
        r0.b(LogCommon.PAGE_SOURCE_LOG);
        r0.b(LogCommon.ROOM);
        r0.b(LogCommon.DRAWER_LOG);
        List r4 = r3.b;
        ArrayList r5 = (ArrayList) r4;
        r5.addAll(r0.a);
    }

    public a(yz0.k r2, q2 r3) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "carnivalInRoomMessageService");
        this.b = r2;
        this.c = r3;
        this.a = new CompositeDisposable();
    }
}

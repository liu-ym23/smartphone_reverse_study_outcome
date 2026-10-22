package com.ss.android.lark.integrator.ccm.dependency.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.location.Location;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.location.dto.AddressComponent;
import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.location.dto.LocationConstants$NameType;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class z0 implements com.bytedance.ee.bear.lark.dependency.r {

    public static final class a implements ew4.p {
        public final /* synthetic */ com.bytedance.ee.bear.lark.dependency.r.a a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ z0 c;

        public a(com.bytedance.ee.bear.lark.dependency.r.a r1, Activity r2, z0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a(ew4.o r4) {
            com.bytedance.ee.bear.lark.dependency.r.a r0 = this.a;
            if (r0 == null) goto L10;
            Activity r1 = this.b;
            if (r4 == null) goto L7;
            POIInfo r5 = z0.i(this.c, r4);
        L8:
            r0.a(r1, r5);
            return;
        L7:
            r5 = null;
            goto L8
        }
    }

    public static final class b implements ew4.i {
        public final /* synthetic */ com.ss.android.lark.location.service.h.a a;
        public final /* synthetic */ z0 b;

        public b(com.ss.android.lark.location.service.h.a r1, z0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(ew4.h r6) {
            if (r6 != null) goto L6;
            com.ss.android.lark.location.service.h.a r7 = this.a;
            if (r7 == null) goto L10;
            r7.a(null);
            return;
        L10:
            return;
        L6:
            com.ss.android.lark.location.service.h.a r0 = this.a;
            if (r0 == null) goto L12;
            POIInfo r1 = new POIInfo();
            this.b.getClass();
            AddressComponent.a r2 = new AddressComponent.a();
            String r3 = r6.a;
            Intrinsics.checkNotNullParameter(r3, "country");
            r2.a = r3;
            String r4 = r6.b;
            Intrinsics.checkNotNullParameter(r4, "province");
            r2.b = r4;
            String r5 = r6.c;
            Intrinsics.checkNotNullParameter(r5, "city");
            r2.c = r5;
            String r8 = r6.d;
            Intrinsics.checkNotNullParameter(r8, "district");
            r2.d = r8;
            String r9 = r6.e;
            Intrinsics.checkNotNullParameter(r9, "township");
            r2.e = r9;
            String r10 = r6.f;
            Intrinsics.checkNotNullParameter(r10, "neighborhood");
            r2.f = r10;
            String r11 = r6.g;
            Intrinsics.checkNotNullParameter(r11, LocationConstants$NameType.BUILDING);
            r2.g = r11;
            String r12 = r6.h;
            Intrinsics.checkNotNullParameter(r12, "address");
            r2.h = r12;
            r1.setAddressComponent(r2.a());
            r0.a(r1);
            return;
        }
    }

    public static final class c implements ew4.p {
        public final /* synthetic */ com.ss.android.lark.location.service.g.a a;
        public final /* synthetic */ z0 b;

        public c(com.ss.android.lark.location.service.g.a r1, z0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(ew4.o r3) {
            com.ss.android.lark.location.service.g.a r0 = this.a;
            if (r0 == null) goto L9;
            if (r3 == null) goto L6;
            LarkLocation r4 = z0.h(this.b, r3);
        L7:
            r0.a(r4);
            return;
        L6:
            r4 = null;
            goto L7
        }
    }

    @Inject
    public z0() {
    }

    public static ew4.a0 j() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Application r1 = LarkContext.getApplication();     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L4
        UserSession r2 = ((com.ss.android.lark.passportc.convention.a) e0c.k.a(r1, com.ss.android.lark.passportc.convention.a.class)).b();     // Catch: Throwable -> L4
        Object r3 = Result.constructor-impl((ew4.a0) e0c.k.b(((com.ss.android.lark.passportc.internal.v) e0c.k.a(r1, com.ss.android.lark.passportc.internal.v.class)).c(r2), ew4.a0.class));     // Catch: Throwable -> L4
    L6:
        ew4.u r4 = ew4.u.a;
        if (Result.isFailure-impl(r3) == false) goto L10;
        r3 = r4;
    L10:
        return (ew4.a0) r3;
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static String k(Token r0) {
        if (r0 == null) goto L4;
        String r1 = r0.getIdentifier();
    L5:
        if (r1 != null) goto L8;
        return "";
    L8:
        return r1;
    L4:
        r1 = null;
        goto L5
    }

    public static final LarkLocation h(z0 r2, ew4.o r3) {
        r2.getClass();
        LarkLocation r4 = new LarkLocation(new Location(""));
        r4.setLatitude(r3.a);
        r4.setLongitude(r3.b);
        r4.a = r3.d;
        r4.b = r3.e;
        r4.c = r3.f;
        r4.d = r3.g;
        r4.e = r3.h;
        r4.f = r3.i;
        int r0 = r3.j;
        if (r0 != 2) goto L5;
        int r1 = 40100;
    L9:
        r4.g = r1;
        r4.i = r3.k;
        return r4;
    L5:
        if (r0 == 3) goto L7;
        r1 = 0;
        goto L9
    L7:
        r1 = 40400;
        goto L9
    }

    public static final POIInfo i(z0 r2, ew4.o r3) {
        r2.getClass();
        POIInfo r4 = new POIInfo();
        r4.setLatitude(r3.a);
        r4.setLongitude(r3.b);
        r4.setLocationName(r3.c);
        r4.setLocationAddress(r3.d);
        int r0 = r3.j;
        if (r0 != 2) goto L5;
        int r1 = 40100;
    L9:
        r4.setErrorCode(r1);
        r4.setErrorMsg(r3.k);
        return r4;
    L5:
        if (r0 == 3) goto L7;
        r1 = 0;
        goto L9
    L7:
        r1 = 40400;
        goto L9
    }

    public final Fragment a(FragmentActivity r11, Token r12, wb5.c r13) {
        Intrinsics.checkNotNullParameter(r12, "token");
        return j().V1(r11, k(r12), new ew4.q(r13.a, r13.b, r13.c, r13.d, r13.e));
    }

    public final void b(Context r3, Token r4, com.ss.android.lark.location.service.g.a r5) {
        Intrinsics.checkNotNullParameter(r4, "token");
        if (r3 != null) goto L6;
        r5.a(null);
        return;
    L6:
        j().w1(r3, k(r4), new c(r5, this));
    }

    public final Fragment d(FragmentActivity r3, Token r4, vp4.h r5) {
        Intrinsics.checkNotNullParameter(r4, "token");
        if (r3 != null) goto L7;
        return null;
    L7:
        return j().U1(r3, k(r4), new a1(r5, r3, this));
    }

    public final void e(Activity r11, Token r12, wb5.c r13) {
        Intrinsics.checkNotNullParameter(r12, "token");
        j().x1(r11, k(r12), new ew4.q(r13.a, r13.b, r13.c, r13.d, r13.e));
    }

    public final void f(Activity r3, Token r4, com.bytedance.ee.bear.lark.dependency.r.a r5) {
        Intrinsics.checkNotNullParameter(r4, "token");
        if (r3 != null) goto L5;
        return;
    L5:
        j().I(r3, k(r4), new a(r5, r3, this));
    }

    public final void c(Context r8, double r9, double r11, com.ss.android.lark.location.service.h.a r13) {
        if (r8 != null) goto L5;
        r13.a(null);
        return;
    L5:
        j().J1(r8, r9, r11, new b(r13, this));
    }

    public final void g(Context r3, Token r4, String r5, LocationHelper.d.a r6) {
        Intrinsics.checkNotNullParameter(r4, "token");
        Intrinsics.checkNotNullParameter(r5, "accuracy");
        if (r3 != null) goto L6;
        r6.a(null);
        return;
    L6:
        String r0 = "best";
        if (Intrinsics.areEqual(r5, "best") == true) goto L10;
        r0 = "high";
    L10:
        j().b0(r3, k(r4), r0, new b1(r6, this));
    }
}

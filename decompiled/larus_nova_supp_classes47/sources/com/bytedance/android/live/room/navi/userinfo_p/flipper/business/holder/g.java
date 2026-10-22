package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementBasicVM;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.UserInfoVM;
import com.bytedance.android.livesdk.utils.r1;
import com.bytedance.android.livesdk.widget.rollingTextView.RollingTextView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class g extends CommonTabHolder {
    public static final int n = 0;
    public static final int o = 0;
    public u91.a h;
    public boolean i;
    public Disposable j;
    public RollingTextView k;
    public long l;
    public Disposable m;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "DiggCount(num=" + this.a + ", unit=" + this.b + ")";
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "num");
            Intrinsics.checkNotNullParameter(r3, "unit");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ n b;

        public c(g r1, n r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            u32.k r4 = (u32.k) sh6.c.b((sh6.b) r3);
            if (r4 == null) goto L6;
            g r0 = this.a;
            r0.getClass();
            r0.j = r4.Lo().compose(RxUtil.rxSchedulerHelper()).subscribe(new h(r0));
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ g a;

        public d(g r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            g r5 = this.a;
            int r0 = g.r(r5);
            Intrinsics.checkNotNullParameter(r5, "$this$setTextColor");
            View r6 = r5.a().findViewById(2131390378);
            if ((r6 instanceof TextView) == true) goto L5;
            r6 = null;
        L5:
            TextView r7 = (TextView) r6;
            if (r7 == null) goto L8;
            r7.setTextColor(r0);
        L8:
            g r8 = this.a;
            RollingTextView r1 = r8.k;
            if (r1 == null) goto L12;
            r1.setTextColor(g.r(r8));
            return;
        }
    }

    public static int t(long r5) {
        if (r5 >= 10000) goto L6;
        return 0;
    L6:
        if (r5 < 100000000) goto L11;
        return 100000000;
    L11:
        return 10000;
    }

    static {
        n = ColorProtector.parseColor("#FACE15");
        o = ColorProtector.parseColor("#b3ffffff");
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void l() {
        q("like_cnt");
        View r0 = this.f.findViewById(2131390379);
        Disposable r2 = null;
        if ((r0 instanceof RollingTextView) == true) goto L5;
        r0 = null;
    L5:
        RollingTextView r1 = (RollingTextView) r0;
        this.k = r1;
        if (r1 != null) goto L8;
    L12:
        INavigationProxyService r3 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r3 == null) goto L21;
        l81.d r4 = r3.getDiggContext(this.e);
        if (r4 == null) goto L21;
        m<Boolean> r5 = r4.d(this.e);
        if (r5 == null) goto L21;
        Observable r6 = r5.a();
        if (r6 == null) goto L21;
        r2 = r6.subscribe(new d(this));
    L21:
        this.m = r2;
        return;
    L8:
        if (a0.d(this.e, false) == false) goto L10;
        r1.b(1, 12.0f);
    L11:
        r1.setTextColor(o);
        goto L12
    L10:
        r1.b(1, 8.0f);
        goto L11
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void p() {
        super.p();
        this.i = false;
        Disposable r0 = this.j;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.j = null;
        Disposable r1 = this.m;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.m = null;
    }

    public static final int r(g r2) {
        r2.getClass();
        INavigationProxyService r0 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r0 == null) goto L12;
        l81.d r1 = r0.getDiggContext(r2.e);
        if (r1 == null) goto L12;
        m<Boolean> r3 = r1.d(r2.e);
        if (r3 == null) goto L12;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L12;
        return n;
    L12:
        return o;
    }

    public static b s(long r5) {
        int r0 = t(r5);
        if (r0 == 0) goto L12;
        if (r0 == 10000) goto L15;
        if (r0 == 100000000) goto L14;
        return new b(String.valueOf(r5), "");
    L14:
        return new b(r1.a(Double.valueOf((r5 * 1.0d) / ((double) 100000000))), s1.B(2131911605));
    L15:
        return new b(r1.a(Double.valueOf((r5 * 1.0d) / ((double) 10000))), s1.B(2131911607));
    L12:
        return new b(String.valueOf(r5), "");
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void k(u91.a r5) {
        this.h = r5;
        if (this.i == true) goto L43;
        this.i = true;
        if (r5 != null) goto L7;
    L10:
        if (r5 != null) goto L12;
    L41:
        com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.e(this, s1.C(2131911604, new Object[]{""}));
        return;
    L12:
        if (r5.b == true) goto L41;
    L13:
        INavigationProxyService r6 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        Long r0 = null;
        if (r6 == null) goto L18;
        l81.d r7 = r6.getDiggContext(this.e);
        if (r7 == null) goto L18;
        n<u32.k> r8 = r7.b(this.e);
    L19:
        if (r8 == null) goto L23;
        u32.k r1 = (u32.k) r8.getValue();
        if (r1 == null) goto L23;
        this.j = r1.Lo().compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this));
    L24:
        if (r1 != null) goto L31;
        if (r8 == null) goto L31;
        Observable r2 = r8.a();
        if (r2 == null) goto L31;
        Disposable r9 = r2.subscribe(new c(this, r8));
        if (r9 == null) goto L31;
        RxUtilKt.c(r9, this.c);
    L31:
        if (r1 == null) goto L33;
        long r3 = r1.getDiggCount();
    L36:
        r0 = Long.valueOf(r3);
    L37:
        if (r0 == null) goto L39;
        long r4 = r0.longValue();
    L40:
        v(r4);
        return;
    L39:
        r4 = 0;
        goto L40
    L33:
        IRoom r10 = this.d;
        if (r10 == null) goto L37;
        r3 = r10.getDiggCount();
    L23:
        r1 = null;
    L18:
        r8 = null;
        goto L19
    L7:
        if (r5.b != true) goto L10;
        if (r5.c == 1) goto L13;
    }

    public final void v(long r7) {
        if (a0.d(this.e, false) == false) goto L17;
        u91.a r0 = this.h;
        if (r0 != null) goto L7;
    L24:
        this.l = r7;
        return;
    L7:
        if (r0.c != 1) goto L24;
        b r1 = s(r7);
        String r2 = r1.a;
        String r3 = r1.b;
        String r4 = r2 + r3;
        UserInfoVM.Companion.getClass();
        aa1.a r5 = UserInfoVM.b.b();
        if (r5 == null) goto L13;
        ElementBasicVM r6 = r5.getBasicVm();
        if (r6 == null) goto L13;
        ElementBasicVM.updateAccessibilityDesc$default(r6, r4, null, 2, null);
    L13:
        RollingTextView r8 = this.k;
        if (r8 == null) goto L16;
        r8.a(r2, u(r7, this.l));
    L16:
        com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.e(this, r3);
        goto L24
    L17:
        b r9 = s(r7);
        String r10 = r9.a;
        String r12 = r9.b;
        String r13 = s1.B(2131911606);
        if (r13 != null) goto L20;
        r13 = "";
    L20:
        RollingTextView r14 = this.k;
        if (r14 == null) goto L23;
        r14.a(r10, u(r7, this.l));
    L23:
        com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.e(this, r12 + r13);
        goto L24
    }

    public final boolean u(long r4, long r6) {
        INavigationProxyService r0 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r0 == null) goto L12;
        l81.d r1 = r0.getDiggContext(this.e);
        if (r1 == null) goto L12;
        m<Boolean> r2 = r1.d(this.e);
        if (r2 == null) goto L12;
        if (((Boolean) r2.getValue()).booleanValue() == true) goto L12;
        return false;
    L12:
        if (t(r4) == t(r6)) goto L14;
        return false;
    L14:
        return true;
    }

    public g(IRoom r2, DataCenter r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r2, r3, r4);
    }
}

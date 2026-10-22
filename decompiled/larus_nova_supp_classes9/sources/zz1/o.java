package zz1;

import com.bytedance.android.live.base.model.user.v;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import oc6.j0;
import oc6.l0;
import oc6.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o implements y, com.bytedance.android.scope.o {
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.m a;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r5) {
            PayGrade r6 = (PayGrade) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            j0 r0 = new j0();
            r0.p(r6.getScore());
            r0.l(r6.getLevel());
            r0.s(r6.getThis_grade_max_diamond());
            r0.t(r6.getThis_grade_min_diamond());
            r0.i(r6.getGrade_describe());
            r0.m(r6.getNew_im_icon_with_level());
            v r1 = vh7.f.c(v.class);
            v r2 = r0.a();
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r2.getBuffLevel();
        L6:
            r1.setBuffLevel(r4);
            v r7 = r0.a();
            if (r7 == null) goto L9;
            py.k r8 = r7.getBuffBadge();
        L10:
            r1.setBuffBadge(r8);
            v r9 = r0.a();
            if (r9 == null) goto L13;
            int r10 = r9.getEndTime();
        L14:
            r1.setEndTime(r10);
            v r11 = r0.a();
            if (r11 == null) goto L17;
            r3 = r11.getStatus();
        L17:
            r1.setStatus(r3);
            Unit r13 = Unit.INSTANCE;
            r0.b(r1);
            r0.n(r6.getNew_live_icon());
            r0.j(r6.getGrade_describe_shining());
            r0.c(r6.getDescribe_type());
            r0.h(r6.getExtra());
            r0.g(r6.getEffectType());
            r0.q(r6.getShortDesc());
            r0.r(r6.getShortPreDesc());
            r0.k(r6.getJumpSchema());
            r0.e(r6.getEffectImg());
            r0.d(r6.getEffectDurationMilli());
            r0.f(r6.getEffectPlayTimes());
            r0.o(r6.getRecentConsumeBadge());
            return r0;
        L13:
            r10 = 0;
            goto L14
        L9:
            r8 = null;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            String r3 = (String) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            l0 r0 = new l0();
            r0.c(r3);
            return r0;
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Observable<j0> observePayGrade() {
        return this.a.l.map(a.a);
    }

    public final Observable<l0> observeTouchPositionInfo() {
        return this.a.k.map(b.a);
    }

    public o(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.m r2) {
        Intrinsics.checkNotNullParameter(r2, "profitDataStore");
        this.a = r2;
    }
}

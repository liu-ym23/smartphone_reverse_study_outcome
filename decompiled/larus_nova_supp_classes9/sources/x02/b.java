package x02;

import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.platform.core.model.d0;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.m0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.n0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.o0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.p0;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends d0 {
    public b() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d0, com.bytedance.android.livesdk.gift.platform.core.model.s
    public final y a(com.bytedance.android.livesdk.gift.platform.core.model.t r11, y r13, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.r> r14, Function1<? super y, Unit> r15) {
        Intrinsics.checkNotNullParameter(r11, "info");
        Intrinsics.checkNotNullParameter(r13, "response");
        Intrinsics.checkNotNullParameter(r14, "listener");
        Intrinsics.checkNotNullParameter(r15, "nextPlugin");
        if (Lists.isEmpty(r11.i().n) == false) goto L5;
        return r13;
    L5:
        int r16 = 0;
        boolean r17 = false;
        Object r0 = null;
        if ((r13 instanceof y.c.a.C0067a) == false) goto L17;
        i12.e r18 = i12.o.b();
        if (r18 == null) goto L10;
        r0 = com.bytedance.android.scope.m.e.d(r18, m0.class);
    L10:
        m0 r1 = (m0) r0;
        if (r1 == null) goto L55;
        ArrayList<e3> r19 = r11.i().n;
        long r2 = r11.i().b;
        if (((y.c.a.C0067a) r13).d.getErrorCode() != 4006067) goto L15;
        r17 = true;
    L15:
        r1.c(r19, r2, r17);
    L55:
        return r13;
    L17:
        if ((r13 instanceof y.d) == false) goto L49;
        ArrayList<e3> r110 = r11.i().n;
        if (r110 == null) goto L55;
        i12.e r3 = i12.o.b();
        if (r3 == null) goto L23;
        Object r4 = com.bytedance.android.scope.m.e.d(r3, m0.class);
    L24:
        m0 r5 = (m0) r4;
        if (r5 == null) goto L55;
        long r8 = r11.i().b;
        Intrinsics.checkNotNullParameter(r110, "pluginInfo");
        ArrayList<sz1.a> r6 = r5.a.get(String.valueOf(r8));
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = null;
        if (r6 == null) goto L29;
        int r111 = r6.size();
    L30:
        if (r16 >= r111) goto L43;
        if (r6 == null) goto L35;
        sz1.a r9 = (sz1.a) ListProtector.get(r6, r16);
        if (r9 == null) goto L35;
        ArrayList<e3> r10 = gz1.c.g(r9);
    L37:
        if (gz1.c.h(r10, r110) == true) goto L38;
        r16 = r16 + 1;
        goto L30
    L38:
        if (r6 == null) goto L40;
        r0 = (sz1.a) ListProtector.get(r6, r16);
    L40:
        r7.element = r0;
    L35:
        r10 = null;
    L43:
        if (((sz1.a) r7.element) == null) goto L46;
        Single.create(new n0(r5, r8, r7)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new o0(r5, r6, r7, r8));
        r5.b.put(String.valueOf(r8), r110);
        goto L55
    L46:
        if (gz1.c.h(r110, r5.b.get(String.valueOf(r8))) == true) goto L55;
        Single.create(new p0(r5, r8, r110)).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
        r5.b.put(String.valueOf(r8), r110);
        goto L55
    L29:
        r111 = 0;
        goto L30
    L23:
        r4 = null;
        goto L24
    L49:
        i12.e r112 = i12.o.b();
        if (r112 == null) goto L52;
        r0 = com.bytedance.android.scope.m.e.d(r112, m0.class);
    L52:
        m0 r20 = (m0) r0;
        if (r20 == null) goto L55;
        r20.c(r11.i().n, r11.i().b, false);
        goto L55
    }
}

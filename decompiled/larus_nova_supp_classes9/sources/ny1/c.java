package ny1;

import android.content.Context;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.model.h;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.t0;
import com.bytedance.android.livesdk.gift.model.u0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.l;
import com.bytedance.android.livesdk.gift.platform.core.model.k;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import oy1.d;
import oy1.e;
import oy1.f;
import oy1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends l {
    public final CompositeDisposable e;

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean o(AbsPanel<?> r1, int r2, int r3, IBaseUser r4, boolean r5, List<? extends IBaseUser> r6, n r7, k r8, k r9, l1 r10, com.bytedance.android.livesdk.gift.model.n r11, String r13, int r14, String r15, com.bytedance.android.livesdk.gift.platform.core.model.a r16) {
        Intrinsics.checkNotNullParameter(r4, "toUser");
        Intrinsics.checkNotNullParameter(r7, "showInfo");
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.h
    public final void onDestroy() {
        super.onDestroy();
        this.e.clear();
    }

    public c(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
        this.e = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean A(AbsPanel<?> r25, int r26, int r27, IBaseUser r28, boolean r29, List<? extends IBaseUser> r30, boolean r31, n r33, k r34, k r35, l1 r36, com.bytedance.android.livesdk.gift.model.n r37, String r38, String r39, com.bytedance.android.livesdk.gift.platform.core.model.a r310) {
        Intrinsics.checkNotNullParameter(r28, "toUser");
        Intrinsics.checkNotNullParameter(r33, "showInfo");
        h r1 = null;
        if (r25 == null) goto L5;
        Object r0 = r25.h;
    L7:
        if ((r0 instanceof h1) == true) goto L9;
        r0 = null;
    L9:
        h1 r3 = (h1) r0;
        boolean r2 = false;
        if (r3 != null) goto L13;
        return false;
    L13:
        if (r3.getBizType() != 1) goto L54;
        ArrayList r4 = new ArrayList();
        r4.add(new oy1.b());
        r4.add(new f());
        r4.add(new d());
        r4.add(new g());
        r4.add(new oy1.c());
        r4.add(new e());
        Iterator r5 = CollectionsKt.asSequence(r4).iterator();
    L16:
        if (r5.hasNext() == false) goto L20;
        if (((oy1.a) r5.next()).a(r3) == true) goto L16;
    L21:
        if (r2 == false) goto L52;
        t0 r6 = r3.getGoodsBizItem();
        if (r6 == null) goto L25;
        r1 = r6.a();
    L25:
        long r7 = 0;
        if (r1 == null) goto L30;
        u0 r8 = r1.c();
        if (r8 == null) goto L30;
        long r9 = r8.b();
    L31:
        if (r1 == null) goto L33;
        long r10 = r1.a();
    L34:
        yz0.k r11 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), yz0.k.class);
        if (r11 == null) goto L39;
        IRoom r13 = r11.getRoom();
        if (r13 == null) goto L39;
        long r14 = r13.getId();
    L40:
        if (r11 == null) goto L46;
        IRoom r15 = r11.getRoom();
        if (r15 == null) goto L46;
        String r16 = r15.getAnchorId();
        if (r16 == null) goto L46;
        r7 = CastLongProtector.parseLong(r16);
    L46:
        if (r1 == null) goto L49;
        String r17 = r1.b();
        if (r17 == null) goto L49;
    L50:
        tz0.b r18 = tz0.b.a;
        uz0.e r19 = new uz0.e();
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "$this$beforeConfigureRequest");
        uz0.f r20 = new uz0.f(((uz0.a) r19).b);
        r20.a("goods_id", Long.valueOf(r9).toString());
        Long r110 = 1L;
        r20.a("count", r110.toString());
        r20.a("consume_scene", Long.valueOf(r10).toString());
        r20.a("room_id", Long.valueOf(r14).toString());
        r20.a("extra", r17);
        r20.a("to_user_id", Long.valueOf(r7).toString());
        r20.a("buy_goods_source", "direct_sale");
        Intrinsics.checkNotNullParameter(r19, "$this$afterConfigureRequest");
        boolean r210 = r2;
        RxUtilKt.c(com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.Revenue, "/webcast/goods/buy/", TypesJVMKt.getJavaType(Reflection.typeOf(Unit.class)), Extra.class, ((uz0.a) r19).d, ((uz0.a) r19).a, ((uz0.a) r19).b, ((uz0.a) r19).c, r19.e, r19.f, r19.g).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r3, r7, r14, r9, r35, r34), b.a), this.e);
        return r210;
    L49:
        r17 = BuildConfig.FLAVOR;
    L39:
        r14 = 0;
        goto L40
    L33:
        r10 = 0;
    L30:
        r9 = 0;
        goto L31
    L52:
        return r2;
    L20:
        r2 = true;
        goto L21
    L54:
        return false;
    L5:
        r0 = null;
        goto L7
    }
}

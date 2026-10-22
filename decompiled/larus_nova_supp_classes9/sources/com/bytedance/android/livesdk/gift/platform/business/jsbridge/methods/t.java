package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.s0;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t<T> implements SingleOnSubscribe {
    public final /* synthetic */ SendGiftMethod.a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ CompositeDisposable d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ t a;
        public final /* synthetic */ SingleEmitter b;

        public a(t r1, SingleEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r11) {
            List<h1> r13 = ((s0) ((ExtraResponse) r11).data).getGiftList();
            if (r13 != null) goto L5;
        L8:
            Throwable r14 = new Throwable("empty resp");
            c0 r1 = c0.a;
            t r0 = this.a;
            r1.q(r0.b, r0.c, 1, r14);
            this.b.onError(r14);
            return;
        L5:
            if (r13.isEmpty() == true) goto L8;
            ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).s5(r13);
            t r15 = this.a;
            com.bytedance.android.livesdk.gift.platform.core.utils.h.t(r15.b, r15.c, 1, null);
            c0 r16 = c0.a;
            t r17 = this.a;
            String r5 = r17.b;
            long r6 = r17.c;
            c0.a.q(r5, r6, 1, null);
            this.b.onSuccess(1);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ t a;
        public final /* synthetic */ SingleEmitter b;

        public b(t r1, SingleEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            t r0 = this.a;
            com.bytedance.android.livesdk.gift.platform.core.utils.h.t(r0.b, r0.c, 1, r8);
            c0 r1 = c0.a;
            t r2 = this.a;
            r1.q(r2.b, r2.c, 1, r8);
            this.b.onError(r8);
        }
    }

    public t(SendGiftMethod.a r1, String r2, long r3, CompositeDisposable r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final void subscribe(SingleEmitter<Object> r11) {
        Intrinsics.checkNotNullParameter(r11, "emitter");
        jy0.b.d("SendGiftMethod", "fetch gift from remote, id" + this.a.g());
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map r2 = ((uz0.a) r1).b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r3 = this.b;
        Intrinsics.checkNotNullParameter("gift_ids", "$this$setTo");
        if (r3 == null) goto L5;
        r2.put("gift_ids", r3);
    L5:
        String r4 = Long.valueOf(this.c).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r4 == null) goto L8;
        r2.put("room_id", r4);
    L8:
        Integer r5 = 1;
        String r6 = r5.toString();
        Intrinsics.checkNotNullParameter("fetch_from", "$this$setTo");
        if (r6 == null) goto L11;
        r2.put("fetch_from", r6);
    L11:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        RxUtilKt.c(com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/gift/detail/", TypesJVMKt.getJavaType(Reflection.typeOf(s0.class)), Extra.class, ((uz0.a) r1).d, ((uz0.a) r1).a, ((uz0.a) r1).b, ((uz0.a) r1).c).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r11), new b(this, r11)), this.d);
    }
}

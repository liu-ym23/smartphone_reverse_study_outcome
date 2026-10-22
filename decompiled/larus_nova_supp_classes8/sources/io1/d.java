package io1;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.room.l;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ fo1.b a;

        public a(fo1.b r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Integer r8 = (Integer) r7;
            int r9 = d.a;
            fo1.b r10 = this.a;
            DataCenter r0 = r10.b();
            Room r1 = r10.c();
            l r11 = r10.s;
            if (r11 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("roomLogger");
        L5:
            HashMap r2 = new HashMap();
            IUser r3 = r1.author();
            if (r3 == null) goto L8;
            String r4 = r3.getUserId();
        L9:
            r2.put("anchor_id", String.valueOf(r4));
            r2.put("room_id", String.valueOf(r1.id));
            r2.put("duration", String.valueOf(r11.getDuration()));
            com.bytedance.android.livesdk.log.d.c(r0, "live_ad", "live_watch_onemin", r2);
            com.bytedance.android.livesdk.log.d.c(r0, "live_ad", "livesdk_watch_onemin", r2);
            com.bytedance.android.live.core.feed.a.a r12 = com.bytedance.android.live.core.feed.a.d;
            if (r12.a().c(Long.valueOf(r1.id)) == false) goto L12;
        L13:
            com.bytedance.android.livesdk.log.d.c(r0, "draw_ad", "click", r2);
            return;
        L12:
            if (r12.a().b(Long.valueOf(r1.id)) == true) goto L13;
            return;
        L8:
            r4 = null;
            goto L9
        }
    }

    static {
    }

    public static void a(fo1.b r4) {
        Intrinsics.checkNotNullParameter(r4, "interactionContext");
        if (tb1.c.a == false) goto L6;
        ((ObservableSubscribeProxy) Observable.just(1).delay(60000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(r4.q))).subscribe(new a(r4), RxUtil.getNoOpThrowable());
        return;
    }
}

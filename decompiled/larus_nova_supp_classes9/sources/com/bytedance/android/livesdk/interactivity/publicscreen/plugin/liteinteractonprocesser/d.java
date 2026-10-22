package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.k;
import com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.api.LiteInteractionApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a {
    public final DataCenter b;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r1) {
            com.bytedance.android.live.network.response.a r2 = (com.bytedance.android.live.network.response.a) r1;
            k.a("RequestProcessor request success");
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            int r0 = k.a;
            StringBuilder r1 = new StringBuilder("RequestProcessor request error: ");
            if (r4 == null) goto L5;
            String r5 = r4.getMessage();
        L6:
            r1.append(r5);
            String r6 = r1.toString();
            Intrinsics.checkNotNullParameter(r6, "msg");
            ALogger.e("LiteInteractionHelper", r6);
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final String a() {
        return "RequestProcessor";
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final boolean b(long r4) {
        if (r4 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public d(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final void c(t42.a r4, com.bytedance.android.live.base.model.liteinteraction.a r5, CompositeDisposable r6) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r5, "actions");
        Intrinsics.checkNotNullParameter(r6, "cd");
        Room r7 = z.o(this.b);
        LiteInteractionApi r0 = (LiteInteractionApi) com.bytedance.android.live.network.c.b().e(LiteInteractionApi.class);
        if (r0 == null) goto L14;
        Observable<com.bytedance.android.live.network.response.a> r8 = r0.queryLiteInteraction(r7.getRoomId(), r7.getAnchorId(), r5.d());
        if (r8 == null) goto L15;
        Observable r9 = r8.subscribeOn(Schedulers.io());
        if (r9 == null) goto L16;
        Observable r10 = r9.observeOn(AndroidSchedulers.mainThread());
        if (r10 == null) goto L17;
        Disposable r11 = r10.subscribe(a.a, b.a);
        if (r11 == null) goto L18;
        RxUtilKt.c(r11, r6);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }
}

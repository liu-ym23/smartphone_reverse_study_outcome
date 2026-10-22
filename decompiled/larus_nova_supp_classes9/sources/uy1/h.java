package uy1;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.grouplive.component.k;
import com.bytedance.android.livesdk.gift.grouplive.component.n;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.j;
import com.bytedance.android.scope.l;
import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements o {
    public final CompositeDisposable a;
    public k b;
    public final yz0.k c;
    public final i12.e d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            sh6.b r4 = (sh6.b) r3;
            boolean r5 = iy0.e.b(this.a.c.getRoom());
            jy0.b.d("GroupLiveRts Old", "isGroupLive2: " + r5 + " GROUP_LIVE_CONTAINER_RTS: " + qy1.a.a());
            if (r5 == true) goto L5;
        L6:
            h r6 = this.a;
            if (r6.b != null) goto L16;
            i12.e r7 = r6.d;
            if (l.b(r7) == true) goto L12;
            r7 = null;
        L12:
            if (r7 == null) goto L17;
            h r8 = this.a;
            n r0 = new n(r8.d);
            Intrinsics.checkNotNullParameter(r0, "scope");
            r0.I();
            l.a(r0);
            Unit r1 = Unit.INSTANCE;
            r8.b = r0;
            return;
        L17:
            return;
        L16:
            return;
        L5:
            if (qy1.a.a() == false) goto L6;
        }
    }

    public final void onStart() {
        com.bytedance.live.datacontext.n r0 = this.d.getRoomContext().getInteractionDataPrepared();
        if (((IRoom) r0.getValue()) == null) goto L14;
        boolean r1 = iy0.e.b(this.c.getRoom());
        jy0.b.d("GroupLiveRts Old", "isGroupLive1: " + r1 + " GROUP_LIVE_CONTAINER_RTS: " + qy1.a.a());
        if (r1 == true) goto L7;
    L8:
        i12.e r2 = this.d;
        if (l.b(r2) == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L19;
        n r3 = new n(this.d);
        Intrinsics.checkNotNullParameter(r3, "scope");
        r3.I();
        l.a(r3);
        Unit r4 = Unit.INSTANCE;
        this.b = r3;
        return;
    L19:
        return;
    L7:
        if (qy1.a.a() == false) goto L8;
        return;
    L14:
        Disposable r5 = r0.a().subscribe(new a(this));
        if (r5 == null) goto L21;
        RxUtilKt.c(r5, this.a);
        return;
    }

    public final void onStop() {
        j r0 = this.b;
        if (r0 != null) goto L5;
    L10:
        this.b = null;
        this.a.clear();
        return;
    L5:
        if (l.b(r0) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        l.c(r0);
        goto L10
    }

    public h(yz0.k r2, i12.e r3) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "giftScope");
        this.c = r2;
        this.d = r3;
        this.a = new CompositeDisposable();
    }
}

package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r0 implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public boolean b;
    public final NextLiveData<zg1.h2> c;
    public final GiftReceiverRepoService d;
    public final OpenDialogService e;
    public final DataCenter f;
    public final yz0.k g;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ r0 a;

        public a(r0 r1) {
            this.a = r1;
        }

        public final void accept(T r6) {
            r0 r0 = this.a;
            if ((r6 instanceof zg1.o3) == false) goto L21;
            zg1.o3 r7 = (zg1.o3) r6;
            r0.getClass();
            Bundle r1 = r7.b;
            if (r1 == null) goto L12;
            GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r2 == null) goto L12;
            com.bytedance.live.datacontext.n<Bundle> r3 = r2.getGiftLogExtra();
            if (r3 == null) goto L12;
            r3.setValue(r1);
        L12:
            if (r7.e == false) goto L16;
            IBaseUser r4 = r0.a(r7.d);
            if (r4 != null) goto L19;
            r4 = r7.a;
        L19:
            r0.e.g(r4, r7.g, r7.b, r7);
            r0.f.put("data_gift_send_extra", r7.c);
            return;
        L16:
            r4 = r7.a;
            if (r4 != null) goto L19;
            r4 = r0.a(r7.d);
            goto L19
        L21:
            if ((r6 instanceof zg1.g0) == false) goto L32;
            zg1.g0 r8 = (zg1.g0) r6;
            r0.getClass();
            int r5 = r8.a;
            if (r5 == 2) goto L25;
        L27:
            if (r5 == 2) goto L29;
            return;
        L29:
            if (r8.b != 2) goto L46;
            ay1.b.C(false);
            return;
        L46:
            return;
        L25:
            if (r8.b != 1) goto L27;
            ay1.b.C(true);
            return;
        L32:
            if ((r6 instanceof zg1.u2) == false) goto L35;
            zg1.u2 r9 = (zg1.u2) r6;
            r0.getClass();
            return;
        L35:
            if ((r6 instanceof HorizontalPlayEvent) == false) goto L49;
            r0.getClass();
            int r10 = ((HorizontalPlayEvent) r6).what;
            if (r10 != 3) goto L40;
            r0.b = true;
            return;
        L40:
            if (r10 != 4) goto L51;
            r0.b = false;
            return;
        L51:
            return;
        }
    }

    public final void onStart() {
        c(zg1.o3.class);
        c(zg1.g0.class);
        c(zg1.u2.class);
        c(HorizontalPlayEvent.class);
    }

    public final void onStop() {
        this.a.dispose();
    }

    public final IBaseUser a(String r5) {
        IBaseUser r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        IBaseUser r1 = this.g.getRoom().getOwner();
        if (r1 == null) goto L12;
        String r2 = r1.getIdString();
        if (r2 == null) goto L12;
        if (Intrinsics.areEqual(r2, r5) == false) goto L12;
        r0 = this.g.getRoom().getOwner();
    L12:
        Iterator<IBaseUser> r3 = this.d.k().a.iterator();
    L14:
        if (r3.hasNext() == false) goto L22;
        IBaseUser r4 = r3.next();
        if (Intrinsics.areEqual(r4.getIdString(), r5) == false) goto L14;
        return r4;
    L22:
        return r0;
    }

    public final <T> void c(Class<T> r2) {
        RxUtilKt.c(xs2.b.a().b(r2).subscribe(new a(this)), this.a);
    }

    public final void onEvent(zg1.h2 r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.c.setValue(r2);
    }

    public r0(GiftReceiverRepoService r2, OpenDialogService r3, Context r4, DataCenter r5, yz0.k r6) {
        Intrinsics.checkNotNullParameter(r2, "receiverRepoService");
        Intrinsics.checkNotNullParameter(r3, "openDialogService");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "roomDataService");
        this.d = r2;
        this.e = r3;
        this.f = r5;
        this.g = r6;
        this.a = new CompositeDisposable();
        this.c = new NextLiveData();
    }
}

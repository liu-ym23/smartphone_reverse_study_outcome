package com.bytedance.android.live.broadcastgame.openplatform.behavior;

import android.view.View;
import com.bytedance.android.live.broadcastgame.openplatform.miniapp.OpenOPAppHelper;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mh1.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends b7.a {
    public final /* synthetic */ com.bytedance.android.live.broadcastgame.openplatform.behavior.a.b a;
    public final /* synthetic */ Ref.ObjectRef b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            SubscriberJsEvent r4 = (SubscriberJsEvent) r3;
            if (r4 != null) goto L5;
            return;
        L5:
            if ((!Intrinsics.areEqual(r4.getEventName(), this.a.a.a.c)) == true) goto L13;
            com.bytedance.android.live.broadcastgame.openplatform.behavior.a.b r5 = this.a.a;
            p r0 = r5.a.e;
            if (r0 == null) goto L12;
            int r1 = OpenOPAppHelper.a;
            OpenOPAppHelper.b(r5.b.getContext(), this.a.a.a.d, r0);
            return;
        L12:
            return;
        }
    }

    public final void onRelease() {
        Disposable r0 = (Disposable) this.b.element;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void onLoadSuccess(View r3) {
        Ref.ObjectRef r4 = this.b;
        IBrowserService r0 = (IBrowserService) k.f(IBrowserService.class);
        if (r0 == null) goto L9;
        Observable<SubscriberJsEvent> r1 = r0.registerJsEventSubscriber(this.a.a.c);
        if (r1 == null) goto L9;
        Observable r2 = r1.observeOn(AndroidSchedulers.mainThread());
        if (r2 == null) goto L9;
        Disposable r5 = r2.subscribe(new a(this));
    L10:
        r4.element = r5;
        return;
    L9:
        r5 = null;
        goto L10
    }

    public b(com.bytedance.android.live.broadcastgame.openplatform.behavior.a.b r1, Ref.ObjectRef r2) {
        this.a = r1;
        this.b = r2;
    }
}

package com.bytedance.android.livesdk.interactivity.interactive;

import android.content.Context;
import com.bytedance.android.live.base.model.message.o5;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.g2;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class LiveInteractivePresenter extends com.bytedance.android.livesdk.chatroom.presenter.n<IView> implements vlc.l {
    public String e;
    public final CompositeDisposable f;
    public final Boolean g;
    public final m0 h;
    public IRoomEventHub i;

    public interface IView extends IWidget {
        void HR(com.bytedance.android.live.base.model.message.n r1);

        void Nj(long r1);

        void b20(String r1, long r2, float r4, JSONObject r5);

        /* synthetic */ Context getContext();

        void jP(long r1);

        void ux(o5 r1);

        void wz(ku2.b r1);

        void zP(String r1);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.android.livesdk.interactivity.interactive.m0] */
    public LiveInteractivePresenter() {
        this.e = BuildConfig.FLAVOR;
        this.f = new CompositeDisposable();
        this.g = (Boolean) g2.a.getValue();
        this.h = new m0(this);
    }

    public void detachView() {
        super.detachView();
        this.f.clear();
        IRoomEventHub r0 = this.i;
        if (r0 == null) goto L5;
        r0.getSeiUpdate().removeObserver(this.h);
    L5:
        this.i = null;
    }

    public /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((IView) r1);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.livesdk.interactivity.interactive.j0] */
    public void g0(IView r3) {
        super.c0(r3);
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().f(new j0(this));
        vlc.d r4 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d;
        if (r4 == null) goto L5;
        r4.addMessageListener(xq1.b.a(ku2.e.i), this);
    L5:
        IRoomEventHub r5 = this.i;
        if (r5 == null) goto L8;
        r5.getSeiUpdate().observeForever(this.h);
    L8:
        Disposable r6 = Observable.interval(1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new k0(this), new l0(this));
        this.f.add(r6);
    }

    public final void h0(boolean r6) {
        this.e = BuildConfig.FLAVOR;
        IView r0 = ((q46.b) this).a;
        if (r0 == null) goto L7;
        if (r6 == false) goto L8;
        r0.jP(p6.b() / 1000);
        return;
    L8:
        return;
    }

    public void onMessage(tlc.d r2) {
        if (((q46.b) this).a != null) goto L6;
        return;
    L6:
        if ((r2 instanceof com.bytedance.android.live.base.model.message.n) == false) goto L9;
        o82.h.b("receive activity interactive message");
        ((q46.b) this).a.HR((com.bytedance.android.live.base.model.message.n) r2);
        return;
    }
}

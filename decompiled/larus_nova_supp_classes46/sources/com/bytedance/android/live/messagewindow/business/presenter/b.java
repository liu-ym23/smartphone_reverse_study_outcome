package com.bytedance.android.live.messagewindow.business.presenter;

import android.text.TextUtils;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.messagewindow.service.dependenceproxy.IMsgWindowProxyService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.message.model.m1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jc1.k;
import kotlin.Deprecated;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends AbsCommonCardPresenter<m1> {
    public final String e;
    public Float f;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.messagewindow.business.presenter.b$b, reason: collision with other inner class name */
    public static final class C0126b<T> implements Consumer {
        public final /* synthetic */ b a;

        public C0126b(b r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            SubscriberJsEvent r4 = (SubscriberJsEvent) r3;
            ALogger.i(this.a.e, "subscribe jsEvent: close_bottom_right_card");
            if (TextUtils.equals("close_bottom_right_card", r4.getEventName()) == false) goto L7;
            ((AbsCommonCardPresenter.a) ((q46.b) this.a).a).gG(JsEventType.CLOSE_CARD, r4.getParams());
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r5) {
            IFollowPair r6 = (IFollowPair) r5;
            if (r6 == null) goto L13;
            int r7 = r6.getFollowStatus();
            l71.c r0 = k.n(IMsgWindowProxyService.class).getExternalBrowserService();
            if (r0 == null) goto L14;
            JSONObject r1 = new JSONObject();
            boolean r3 = true;
            if (r7 == 2) goto L11;
            if (r7 == 1) goto L11;
            r3 = false;
        L11:
            r1.put("follow_status", r3);
            Unit r8 = Unit.INSTANCE;
            r0.enqueueEvent("follow_card_status_change", r1);
            return;
        L14:
            return;
        }
    }

    static {
    }

    @Deprecated(message = "新卡片不再使用该jsEvent通信")
    public final void h0() {
        this.b.add(k.n(IBaseBrowserService.class).registerJsEventSubscriber("close_bottom_right_card").observeOn(AndroidSchedulers.mainThread()).subscribe(new C0126b(this)));
    }

    @Deprecated(message = "新卡片不再使用该jsEvent通信")
    public final void i0() {
        CompositeDisposable r0 = this.b;
        com.bytedance.android.livesdk.user.e r1 = k.n(IMiddlewareUserService.class).user();
        DataCenter r2 = this.d;
        if (r2 == null) goto L8;
        IRoom r3 = (IRoom) r2.get("data_room", null);
        if (r3 == null) goto L8;
        String r4 = r3.getOwnerUserIdString();
        if (r4 == null) goto L8;
    L9:
        r0.add(r1.u0(r4).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(c.a));
        return;
    L8:
        r4 = "0";
        goto L9
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter
    public final String d0() {
        return this.e;
    }

    public b(DataCenter r1) {
        super(r1);
        this.e = "PortraitBottomRightCommonCardPresenter";
    }
}

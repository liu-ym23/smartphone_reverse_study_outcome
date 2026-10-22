package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.IWelfareApi;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.qy0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/welfare/right/WelfareAudienceWelfareServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WelfareAudienceWelfareServiceWidget extends RoomRecyclableWidget {
    public final Lazy a;
    public final CompositeDisposable b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ WelfareAudienceWelfareServiceWidget a;

        public a(WelfareAudienceWelfareServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r11) {
            Long r12 = (Long) r11;
            WelfareAudienceWelfareServiceWidget r13 = this.a;
            DataCenter r0 = ((Widget) r13).dataCenter;
            if (r0 == null) goto L14;
            Long r1 = (Long) r0.get("data_live_welfare_donation_click_count", 0L);
            if (r1 != null) goto L7;
            return;
        L7:
            if (r1.longValue() <= 0) goto L16;
            RoomContext r2 = r13.getDataContext();
            if (r2 == null) goto L17;
            ((IWelfareApi) r13.a.getValue()).reportWelfareClick(((Room) r2.getRoom().getValue()).id, 0, System.currentTimeMillis() / ((long) BubbleId.PadCast), 1).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r13), d.a);
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        this.b.dispose();
    }

    public WelfareAudienceWelfareServiceWidget() {
        this.a = LazyKt.lazy(WelfareAudienceWelfareServiceWidget$welfareApi$2.INSTANCE);
        this.b = new CompositeDisposable();
    }

    public final void onLoad(Object[] r6) {
        IBrowserService r7 = k.f(IBrowserService.class);
        if (r7 == null) goto L9;
        Observable r8 = r7.registerExternalMethodFactory(new b(this));
        if (r8 == null) goto L9;
        ObservableSubscribeProxy r9 = (ObservableSubscribeProxy) r8.as(autoDispose());
        if (r9 == null) goto L9;
        r9.subscribe();
    L9:
        qy0 r10 = qy0.a;
        if (r10.getValue().e() <= 0) goto L13;
        j.a r0 = j.a;
        Disposable r11 = j.a(r10.getValue().e(), r10.getValue().e(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        this.b.add(r11);
        return;
    }
}

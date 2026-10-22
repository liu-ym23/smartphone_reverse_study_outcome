package com.bytedance.android.livesdk.chatroom.widget;

import android.text.TextUtils;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.chatroom.utils.u2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/XBridgeServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XBridgeServiceWidget extends RoomRecyclableWidget {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ XBridgeServiceWidget a;

        public b(XBridgeServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            SubscriberJsEvent r11 = (SubscriberJsEvent) r10;
            ALogger.i("XBridgeServiceWidget", "subscribe jsEvent: anchor_live_room_event");
            if (TextUtils.equals("anchor_live_room_event", r11.getEventName()) == false) goto L30;
            XBridgeServiceWidget r1 = this.a;
            Map r12 = r11.getParams();
            int r2 = XBridgeServiceWidget.a;
            r1.getClass();
            if (r12 == null) goto L8;
            Object r5 = r12.get("need_remove");
        L9:
            String r6 = String.valueOf(r5);
            if (r12 == null) goto L12;
            Object r7 = r12.get("room_id");
        L13:
            String r8 = String.valueOf(r7);
            if (r12 == null) goto L16;
            Object r13 = r12.get("multi_reason");
        L17:
            String r14 = String.valueOf(r13);
        L24:
            e = move-exception;
            SafetyGuard.a(null, null, e.getMessage());
        L26:
            xs2.b r0 = xs2.b.a();
            zg1.h1 r3 = new zg1.h1(55, (IRoom) ((Widget) r1).dataCenter.get("data_room", null));
            r3.e = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("multi_reason", r14), TuplesKt.to("need_remove", r6)});
            Unit r15 = Unit.INSTANCE;
            r0.post(r3);
            return;
        L19:
            if (TextUtils.isEmpty(r6) == true) goto L26;
            if (TextUtils.equals(r6, "true") == false) goto L26;
            ALogger.i("XBridgeServiceWidget", "jsEvent anchor_live_room_event, need to delete room after reporting: ".concat(r8));     // Catch: Exception -> L24
            u2.a(r8);     // Catch: Exception -> L24
            jc1.k.n(IHostBusiness.class).postDeleteReportRoomEvent(r8);     // Catch: Exception -> L24
            goto L26
        L16:
            r13 = null;
            goto L17
        L12:
            r7 = null;
            goto L13
        L8:
            r5 = null;
            goto L9
        }
    }

    static {
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
    }

    public XBridgeServiceWidget() {
    }

    public final void onLoad(Object[] r2) {
        ((ObservableSubscribeProxy) jc1.k.n(IBrowserService.class).registerJsEventSubscriber("anchor_live_room_event").observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new b(this));
    }
}

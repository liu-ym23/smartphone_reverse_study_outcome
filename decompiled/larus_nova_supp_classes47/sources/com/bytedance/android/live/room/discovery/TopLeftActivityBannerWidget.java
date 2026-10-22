package com.bytedance.android.live.room.discovery;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.rowcontract.RowRecyclableWidget;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdk.message.model.InRoomBannerMessage;
import com.bytedance.android.livesdkapi.banner.BannerData;
import com.bytedance.android.livesdkapi.banner.IBannerManager;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/discovery/TopLeftActivityBannerWidget;", "Lcom/bytedance/android/live/rowcontract/RowRecyclableWidget;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopLeftActivityBannerWidget extends RowRecyclableWidget implements vlc.l, Observer<KVData> {
    public static final /* synthetic */ int f = 0;
    public vo1.a a;
    public LinearLayout b;
    public vlc.d c;
    public Room d;
    public boolean e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ TopLeftActivityBannerWidget a;

        public b(TopLeftActivityBannerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            BannerInRoomCollection r10 = ((BannerData) r9).getData();
            if (r10.getSceneBanner() != null) goto L71;
            TopLeftActivityBannerWidget r0 = this.a;
            int r1 = TopLeftActivityBannerWidget.f;
            r0.getClass();
            TopLeftActivityBannerWidget r2 = this.a;
            BannerInRoomCollection.BannerInfo r12 = r10.getTopLeftActivityBanner();
            if (r12 != null) goto L13;
            LinearLayout r13 = r2.b;
            if (r13 == null) goto L9;
            r13.setVisibility(8);
        L9:
            LinearLayout r14 = r2.b;
            if (r14 == null) goto L12;
            r14.removeAllViews();
        L12:
            Unit r15 = Unit.INSTANCE;
            return;
        L13:
            r2.getClass();
            Unit r3 = Unit.INSTANCE;
            String r4 = r12.getUrl();
            if (r4 != null) goto L16;
        L19:
            boolean r5 = true;
        L21:
            if (r5 == false) goto L42;
            List r16 = r12.getBannerList();
            if (r16 == null) goto L79;
            LinearLayout r6 = r2.b;
            if (r6 == null) goto L28;
            r6.removeAllViews();
        L28:
            Iterator<T> r17 = r16.iterator();
        L30:
            if (r17.hasNext() == false) goto L80;
            b1 r7 = (b1) r17.next();
            View r8 = LayoutInflater.from(((Widget) r2).context).inflate(2131566419, r2.b, false);
            if (r8 == null) goto L41;
            ImageView r18 = (ImageView) r8;
            jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r7.getImage(), new s0(r18, r2));
            LinearLayout r19 = r2.b;
            if (r19 == null) goto L36;
            r19.setVisibility(0);
        L36:
            LinearLayout r20 = r2.b;
            if (r20 == null) goto L39;
            r20.addView(r18);
        L39:
            Unit r22 = Unit.INSTANCE;
            r18.setOnClickListener(new t0(r7, r2));
            r2.wq(String.valueOf(r7.getId()), "live_banner_show");
            goto L30
        L41:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        L80:
            return;
        L79:
            return;
        L42:
            String r23 = r12.getUrl();
            int r24 = vo1.e.a;
            vo1.a r25 = new vo1.a();
            r2.a = r25;
            Context r26 = ((Widget) r2).context;
            if (r26 == null) goto L70;
            vo1.i.a.a(r25, (Activity) r26, r23, null, new q0(r2));
            int r27 = com.bytedance.android.livesdk.utils.e.a;
            Intrinsics.checkNotNullParameter(r25, "$this$getWebView");
            if (r25.hybridType() != IHybridComponent.HybridType.H5) goto L47;
            WebView r28 = (WebView) r25.g();
        L47:
            vo1.a r29 = r2.a;
            if (r29 == null) goto L52;
            View r30 = r29.c();
            if (r30 == null) goto L52;
            r30.setBackgroundColor(0);
            r30.setLayoutParams(new FrameLayout.LayoutParams(s1.f(64.0f), s1.f(64.0f)));
        L52:
            LinearLayout r32 = r2.b;
            if (r32 == null) goto L60;
            r32.removeAllViews();
            vo1.a r33 = r2.a;
            if (r33 == null) goto L59;
            View r34 = r33.c();
            if (r34 == null) goto L59;
            r32.addView(r34);
        L59:
            r32.setVisibility(0);
        L60:
            vo1.a r35 = r2.a;
            if (r35 == null) goto L65;
            View r36 = r35.c();
            if (r36 == null) goto L65;
            r36.setOnTouchListener(new r0(r2, r23));
        L65:
            vo1.a r37 = r2.a;
            if (r37 == null) goto L68;
            r37.loadUrl(r23);
        L68:
            r2.wq(r23, "live_banner_show");
            return;
        L70:
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        L16:
            if (r4.length() == 0) goto L19;
            r5 = false;
            goto L21
        L71:
            this.a.getClass();
            Unit r38 = Unit.INSTANCE;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131568034;
    }

    public final String getSpm() {
        return "a100.a100.a129";
    }

    public final Animator startShowAnimation() {
        return null;
    }

    public final void onUnload() {
        vlc.d r0 = this.c;
        if (r0 == null) goto L5;
        r0.removeMessageListener(this);
    L5:
        vo1.a r1 = this.a;
        if (r1 == null) goto L12;
        View r2 = r1.c();
        if (r2 == null) goto L12;
        LinearLayout r3 = this.b;
        if (r3 == null) goto L12;
        r3.removeView(r2);
    L12:
        vo1.a r4 = this.a;
        if (r4 == null) goto L15;
        r4.release();
    L15:
        ((Widget) this).dataCenter.removeObserver(this);
    }

    public TopLeftActivityBannerWidget() {
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r6.getKey()) == true) goto L29;
        String r0 = r6.getKey();
        int r1 = r0.hashCode();
        if (r1 == (-1357019912)) goto L16;
        if (r1 == 1060055221) goto L13;
        return;
    L13:
        if (r0.equals("data_keyboard_status") == true) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(r6.getKey(), "data_pre_show_keyboard") == true) goto L31;
        Boolean r7 = (Boolean) r6.getData();
        Intrinsics.checkNotNull(r7);
        if (r7.booleanValue() == false) goto L23;
        ((Widget) this).contentView.setVisibility(8);
        return;
    L23:
        ((Widget) this).contentView.setVisibility(0);
        return;
    L31:
        return;
    L16:
        if (r0.equals("data_pre_show_keyboard") == true) goto L18;
        return;
    }

    public final void onInit(Object[] r3) {
        this.b = (LinearLayout) ((Widget) this).contentView.findViewById(2131387275);
        ((Widget) this).contentView.findViewById(2131375988).setVisibility(8);
        ((TextView) ((Widget) this).contentView.findViewById(2131367549)).setVisibility(8);
    }

    public final void onLoad(Object[] r4) {
        this.d = (Room) ((Widget) this).dataCenter.get("data_room", new Room());
        this.e = com.bytedance.android.live.core.utils.z.b(((Widget) this).dataCenter).c;
        vlc.d r5 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        this.c = r5;
        if (r5 == null) goto L5;
        r5.addMessageListener(MessageType.IN_ROOM_BANNER_MESSAGE.getIntType(), this);
    L5:
        ((Widget) this).dataCenter.observe("data_pre_show_keyboard", this).observe("data_xt_landscape_tab_change", this).observe("data_keyboard_status", this);
        IBannerManager r6 = (IBannerManager) ((Widget) this).dataCenter.get("data_in_room_banner_manager", null);
        if (r6 == null) goto L17;
        Room r0 = this.d;
        if (r0 == null) goto L10;
        long r1 = r0.getRoomId();
    L11:
        Observable r7 = r6.observeBanner(r1, 0);
        if (r7 == null) goto L18;
        ObservableSubscribeProxy r8 = (ObservableSubscribeProxy) r7.as(autoDispose());
        if (r8 == null) goto L19;
        r8.subscribe(new b(this));
        return;
    L19:
        return;
    L18:
        return;
    L10:
        r1 = 0;
        goto L11
    }

    public final void onMessage(tlc.d r8) {
        if ((r8 instanceof InRoomBannerMessage) == false) goto L45;
        InRoomBannerMessage r9 = (InRoomBannerMessage) r8;
        if (r9.getPosition() != 2) goto L46;
        String r10 = GsonProtectorUtils.toJson(GsonHelper.getDefault(), r9.getExtra());
        JSONObject r0 = new JSONObject();
        r0.put("type", "refresh");
        r0.put(Constants.Keys.DATA, r10);
        JSONObject r12 = new JSONObject();
        com.bytedance.android.livesdk.log.filter.n0 r1 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r5 = "";
        if ((r1 instanceof com.bytedance.android.livesdk.log.filter.n0) == false) goto L15;
        com.bytedance.android.livesdk.log.filter.n0 r2 = r1;
        if (((com.bytedance.android.livesdk.log.filter.a) r2).b.containsKey("enter_from") == false) goto L12;
        String r3 = (String) ((com.bytedance.android.livesdk.log.filter.a) r2).b.get("enter_from");
    L12:
        if (((com.bytedance.android.livesdk.log.filter.a) r2).b.containsKey("source") == false) goto L14;
        String r4 = (String) ((com.bytedance.android.livesdk.log.filter.a) r2).b.get("source");
    L14:
        HashMap r6 = new HashMap();
        Map r7 = com.bytedance.android.livesdk.log.e0.a;
        String r13 = (String) r6.get("enter_from_merge");
        String r14 = (String) r6.get("enter_method");
    L16:
        JSONObject r15 = r12.put("enter_from_merge", r13).put("enter_method", r14);
        if (this.e == false) goto L19;
        String r16 = "live_take_detail";
    L20:
        JSONObject r17 = r15.put("event_page", r16);
        Room r18 = this.d;
        if (r18 == null) goto L24;
        String r19 = String.valueOf(r18.id);
        if (r19 == null) goto L24;
    L25:
        JSONObject r20 = r17.put("room_id", r19);
        Room r22 = this.d;
        if (r22 == null) goto L29;
        String r23 = r22.getOwnerUserIdString();
        if (r23 == null) goto L29;
    L30:
        JSONObject r24 = r20.put("anchor_id", r23);
        Room r25 = this.d;
        if (r25 == null) goto L34;
        String r26 = r25.getRequestId();
        if (r26 == null) goto L34;
    L35:
        JSONObject r27 = r24.put("request_id", r26);
        Room r28 = this.d;
        if (r28 == null) goto L41;
        String r29 = r28.getLog_pb();
        if (r29 == null) goto L41;
        r5 = r29;
    L41:
        r27.put("log_pb", r5);
        r0.put("log", r12);
        vo1.a r30 = this.a;
        if (r30 == null) goto L47;
        r30.sendJsEvent("H5_roomStatusChange", r0);
        return;
    L47:
        return;
    L34:
        r26 = "";
    L29:
        r23 = "";
    L24:
        r19 = "";
        goto L25
    L19:
        r16 = "live_detail";
        goto L20
    L15:
        r14 = "";
        r13 = r14;
        goto L16
    L46:
        return;
    }

    public final void wq(String r5, String r6) {
        HashMap r0 = new HashMap();
        r0.put("banner_id", r5);
        r0.put("request_page", "topleft");
        com.bytedance.android.livesdk.log.g r7 = com.bytedance.android.livesdk.log.u.l();
        Object[] r1 = new Object[3];
        r1[0] = Room.class;
        am2.x r2 = new am2.x();
        r2.a = "live_function";
        if (this.e == false) goto L5;
        String r3 = "live_take_detail";
    L6:
        r2.b = r3;
        r1[1] = r2;
        r1[2] = new am2.z();
        r7.sendLog(r6, r0, r1);
        return;
    L5:
        r3 = "live_detail";
        goto L6
    }
}

package com.bytedance.android.live.messagewindow.business.presenter;

import am2.x;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.api.messagewindow.api.CommonCardInfoRetrofitApi;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.service.dependenceproxy.IMsgWindowProxyService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.b7;
import com.bytedance.android.livesdk.message.model.i3;
import com.bytedance.android.livesdk.message.model.m1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.BackendGeneratedData;
import com.bytedance.android.livesdkapi.model.BackendItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/messagewindow/business/presenter/CommonCardServiceWidgetPresenter;", "Lq46/b;", "Lcom/bytedance/android/live/messagewindow/business/presenter/CommonCardServiceWidgetPresenter$b;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "b", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonCardServiceWidgetPresenter extends q46.b<b> implements l, Observer<KVData> {
    public static final /* synthetic */ int g = 0;
    public final CompositeDisposable b;
    public vlc.d c;
    public final List<String> d;
    public final DataCenter e;
    public final o f;

    public static final class a {
    }

    public interface b extends q46.a {
        void Up(Throwable r1);

        void onEvent(z61.a r1);

        void r80(f71.c.a r1);

        void rj(f71.a r1);
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ CommonCardServiceWidgetPresenter a;

        public c(CommonCardServiceWidgetPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            f71.c.a r3 = (f71.c.a) r2;
            b r0 = (b) ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.r80(r3);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ CommonCardServiceWidgetPresenter a;

        public d(CommonCardServiceWidgetPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            b r0 = (b) ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.Up(r3);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ CommonCardServiceWidgetPresenter a;

        public e(CommonCardServiceWidgetPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            b r0 = (b) ((q46.b) this.a).a;
            r0.onEvent((z61.a) r2);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ CommonCardServiceWidgetPresenter a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;

        public f(CommonCardServiceWidgetPresenter r1, boolean r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            f71.c r8 = (f71.c) r7;
            if (r8 == null) goto L12;
            f71.c.a r2 = r8.data;
            if (r2 == null) goto L12;
            List r3 = r2.commonCardArea;
            if (r3 == null) goto L12;
            Iterator<T> r4 = r3.iterator();
        L10:
            if (r4.hasNext() == false) goto L12;
            i3 r5 = (i3) r4.next();
            CommonCardServiceWidgetPresenter r6 = this.a;
            Integer r9 = r5.type;
            int r10 = CommonCardServiceWidgetPresenter.g;
            r6.f0(r9, "room_enter_common_card", "1");
        L12:
            if (r8 == null) goto L21;
            f71.c.a r11 = r8.data;
            if (r11 == null) goto L21;
            List r12 = r11.bottomRightCardArea;
            if (r12 == null) goto L21;
            Iterator<T> r13 = r12.iterator();
        L19:
            if (r13.hasNext() == false) goto L21;
            m1 r14 = (m1) r13.next();
            CommonCardServiceWidgetPresenter r15 = this.a;
            Integer r16 = r14.type;
            int r17 = CommonCardServiceWidgetPresenter.g;
            r15.f0(r16, "room_enter_common_card", "1");
        L21:
            b r0 = (b) ((q46.b) this.a).a;
            if (r0 == null) goto L25;
            r0.r80(r8.data);
        L25:
            if (this.b == true) goto L30;
            a50.a r18 = (a50.a) LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue();
            if (r18 != null) goto L29;
            return;
        L29:
            if (r18.b() == false) goto L30;
            return;
        L30:
            CommonCardServiceWidgetPresenter.c0(this.a, "0", this.c);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ CommonCardServiceWidgetPresenter a;

        public g(CommonCardServiceWidgetPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            CommonCardServiceWidgetPresenter r0 = this.a;
            int r2 = CommonCardServiceWidgetPresenter.g;
            r0.f0(-1, "room_enter_common_card", "0");
            b r1 = (b) ((q46.b) this.a).a;
            if (r1 == null) goto L6;
            r1.Up(r6);
            return;
        }
    }

    static {
    }

    public final void detachView() {
        ((q46.b) this).a = null;
        this.b.clear();
        vlc.d r0 = this.c;
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    public final void e0() {
        DataCenter r0 = this.e;
        vlc.d r2 = null;
        if (r0 == null) goto L5;
        r2 = (vlc.d) r0.get("data_message_manager", null);
    L5:
        this.c = r2;
        if (r2 == null) goto L13;
        Iterator<T> r1 = this.d.iterator();
    L9:
        if (r1.hasNext() == false) goto L16;
        String r3 = (String) r1.next();
        vlc.d r4 = this.c;
        if (r4 == null) goto L9;
        r4.addMessageListener(r3, this);
    L16:
        e r5 = new e(this);
        this.b.add(xs2.b.a().b(z61.a.class).observeOn(AndroidSchedulers.mainThread()).subscribe(r5));
        return;
    L13:
        DataCenter r6 = this.e;
        if (r6 == null) goto L16;
        r6.observe("data_message_manager", this);
        goto L16
    }

    public final void d0() {
        if (v.a() == true) goto L5;
    L7:
        o r0 = this.f;
        Boolean r1 = null;
        if (r0 == null) goto L10;
        Boolean r2 = r0.isAnchor();
    L12:
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == false) goto L41;
        i r3 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r3 == null) goto L24;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r4 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_data_request");
        o r5 = this.f;
        if (r5 == null) goto L20;
        r1 = r5.isAnchor();
    L20:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L22;
        String r6 = "1";
    L23:
        r4.b("is_anchor", r6);
        r4.b("scene", "backend");
        Unit r7 = Unit.INSTANCE;
        r3.b(r4.a());
        goto L24
    L22:
        r6 = "0";
    L24:
        IMsgWindowProxyService r8 = k.f(IMsgWindowProxyService.class);
        if (r8 == null) goto L44;
        l71.d r9 = r8.getLiveRoomBackendUtils();
        if (r9 == null) goto L45;
        DataCenter r10 = this.e;
        if (r10 == null) goto L33;
        IRoom r11 = a0.n(r10);
        if (r11 == null) goto L33;
        long r12 = r11.getId();
    L34:
        long r13 = r12;
        DataCenter r14 = this.e;
        Function0<Unit> r15 = new CommonCardServiceWidgetPresenter$getCommonCardDataInfo$4(this);
        Function3<f71.c.a, BackendGeneratedData, BackendItem, Unit> r16 = new CommonCardServiceWidgetPresenter$getCommonCardDataInfo$5(this);
        CompositeDisposable r17 = this.b;
        a50.a r18 = (a50.a) LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue();
        if (r18 != null) goto L37;
    L39:
        boolean r19 = false;
    L40:
        r9.b(r13, r14, f71.c.a.class, r15, r16, r17, r19, false);
        return;
    L37:
        if (r18.b() != true) goto L39;
        r19 = true;
    L33:
        r12 = 0;
        goto L34
    L45:
        return;
    L44:
        return;
    L41:
        g0(true);
        return;
    L10:
        r2 = null;
        goto L12
    L5:
        if (((Boolean) m71.a.a.getValue()).booleanValue() == false) goto L7;
        RxUtilKt.c(RxUtilKt.h(xs2.b.a().b(f71.c.a.class)).subscribe(new c(this), new d(this)), this.b);
    }

    public final void g0(boolean r12) {
        long r0 = System.currentTimeMillis();
        JSONObject r2 = new JSONObject();
        DataCenter r3 = this.e;
        String r4 = null;
        if (r3 == null) goto L9;
        IRoom r5 = a0.n(r3);
        if (r5 == null) goto L9;
        String r6 = r5.getRequestId();
        if (r6 == null) goto L9;
    L10:
        r2.put("request_id", r6);
        i r7 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r7 == null) goto L22;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r8 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_data_request");
        o r9 = this.f;
        if (r9 == null) goto L16;
        Boolean r10 = r9.isAnchor();
    L18:
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L20;
        String r11 = "1";
    L21:
        r8.b("is_anchor", r11);
        r8.b("scene", "common_card");
        Unit r13 = Unit.INSTANCE;
        r7.b(r8.a());
        goto L22
    L20:
        r11 = "0";
        goto L21
    L16:
        r10 = null;
    L22:
        CommonCardInfoRetrofitApi r14 = (CommonCardInfoRetrofitApi) com.bytedance.android.live.network.c.b().e(CommonCardInfoRetrofitApi.class);
        o r15 = this.f;
        if (r15 == null) goto L29;
        m r16 = r15.getRoom();
        if (r16 == null) goto L29;
        IRoom r17 = (IRoom) r16.getValue();
        if (r17 == null) goto L29;
        long r18 = r17.getRoomId();
    L30:
        DataCenter r19 = this.e;
        if (r19 == null) goto L33;
        r4 = (String) r19.get("data_live_room_enter_source", null);
    L33:
        RxUtilKt.c(RxUtilKt.h(r14.queryCommonCardInfo(r18, r4, r2.toString(), 1)).subscribe(new f(this, r12, r0), new g(this)), this.b);
        return;
    L29:
        r18 = 0;
    L9:
        r6 = null;
        goto L10
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r0 = r5.getKey();
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.hashCode() == (-1434292000)) goto L12;
        return;
    L12:
        if (r0.equals("data_message_manager") == false) goto L22;
        vlc.d r6 = (vlc.d) r5.getData();
        if (r6 == null) goto L30;
        this.c = r6;
        Iterator<T> r7 = this.d.iterator();
    L18:
        if (r7.hasNext() == false) goto L31;
        String r1 = (String) r7.next();
        vlc.d r2 = this.c;
        if (r2 == null) goto L18;
        r2.addMessageListener(r1, this);
        goto L18
    L31:
        return;
    L30:
        return;
    L22:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onMessage(tlc.d r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if ((r7 instanceof b7) == false) goto L56;
        b7 r8 = (b7) r7;
        boolean r1 = false;
        if (v.a() == true) goto L18;
        m1 r0 = r8.getBottomRightCardData();
        if (r0 == null) goto L18;
        Integer r2 = r0.mockType;
        if (r2 != null) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 != true) goto L18;
        r1 = true;
        goto L18
    L13:
        if (r2.intValue() != 1) goto L15;
        r3 = true;
    L18:
        if (r1 == true) goto L62;
        int r4 = r8.getAction();
        Integer r5 = null;
        if (r4 != 1) goto L23;
        i3 r6 = r8.getCommonCard();
        if (r6 == null) goto L48;
        Integer r9 = r6.type;
        if (r9 == null) goto L48;
        r5 = r9;
    L51:
        f0(r5, "room_msg", "1");
        b r10 = (b) ((q46.b) this).a;
        if (r10 == null) goto L61;
        int r11 = f71.a.c;
        Intrinsics.checkNotNullParameter(r8, "cardData");
        r10.rj(new f71.a(1, r8));
        return;
    L61:
        return;
    L48:
        m1 r12 = r8.getBottomRightCardData();
        if (r12 == null) goto L51;
        r5 = r12.type;
        goto L51
    L23:
        if (r4 != 2) goto L25;
        b r13 = (b) ((q46.b) this).a;
        if (r13 == null) goto L59;
        int r14 = f71.a.c;
        Intrinsics.checkNotNullParameter(r8, "cardData");
        r13.rj(new f71.a(2, r8));
        return;
    L59:
        return;
    L25:
        if (r4 != 3) goto L63;
        i3 r15 = r8.getCommonCard();
        if (r15 == null) goto L33;
        Integer r16 = r15.type;
        if (r16 == null) goto L33;
        r5 = r16;
    L36:
        f0(r5, "room_msg", "1");
        b r17 = (b) ((q46.b) this).a;
        if (r17 == null) goto L57;
        int r18 = f71.a.c;
        Intrinsics.checkNotNullParameter(r8, "cardData");
        r17.rj(new f71.a(3, r8));
        return;
    L57:
        return;
    L33:
        m1 r19 = r8.getBottomRightCardData();
        if (r19 == null) goto L36;
        r5 = r19.type;
        goto L36
    L63:
        return;
    L62:
        return;
    }

    public CommonCardServiceWidgetPresenter(DataCenter r1, o r2) {
        this.e = r1;
        this.f = r2;
        this.b = new CompositeDisposable();
        this.d = CollectionsKt.listOf("WebcastCommonCardAreaMessage");
    }

    public static final void c0(CommonCardServiceWidgetPresenter r12, String r13, long r14) {
        o r0 = r12.f;
        if (r0 == null) goto L9;
        m r1 = r0.I2();
        if (r1 == null) goto L9;
        Long r2 = (Long) r1.getValue();
        if (r2 == null) goto L9;
        long r3 = r2.longValue();
    L11:
        if (r3 > 0) goto L13;
        return;
    L13:
        if (r14 <= 0) goto L53;
        long r5 = System.currentTimeMillis();
        o r4 = r12.f;
        if (r4 == null) goto L50;
        m r6 = r4.getRoom();
        if (r6 == null) goto L51;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L52;
        long r8 = r7.getRoomId();
        String r9 = "1";
        if (Intrinsics.areEqual(r13, "1") == false) goto L35;
        IMsgWindowProxyService r10 = k.f(IMsgWindowProxyService.class);
        if (r10 == null) goto L30;
        l71.d r11 = r10.getLiveRoomBackendUtils();
        if (r11 == null) goto L30;
        Long r15 = r11.a(r8);
        if (r15 == null) goto L30;
        long r16 = r15.longValue();
    L32:
        if (r16 > 0) goto L34;
        long r17 = 0;
    L37:
        if (r17 <= 0) goto L54;
        j0 r18 = j0.l();
        Pair[] r19 = new Pair[5];
        r19[0] = TuplesKt.to("total_time", String.valueOf(r5 - r3));
        o r110 = r12.f;
        if (r110 == null) goto L42;
        Boolean r111 = r110.isAnchor();
    L44:
        if (Intrinsics.areEqual(r111, Boolean.TRUE) == true) goto L47;
        r9 = "0";
    L47:
        r19[1] = TuplesKt.to("is_anchor", r9);
        r19[2] = TuplesKt.to("type", r13);
        r19[3] = TuplesKt.to("room_id", String.valueOf(r8));
        r19[4] = TuplesKt.to("api_cost_time", String.valueOf(r17));
        r18.sendLog("livesdk_common_card_api_cost_time", MapsKt.mapOf(r19), new Object[]{IRoom.class, x.class});
        return;
    L42:
        r111 = null;
        goto L44
    L54:
        return;
    L34:
        r17 = r14 - r16;
    L30:
        r16 = 0;
        goto L32
    L35:
        r17 = r5 - r14;
        goto L37
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L53:
        return;
    L9:
        r3 = 0;
        goto L11
    }

    public final void f0(Integer r5, String r6, String r7) {
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L20;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r1 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_data_received");
        o r2 = this.f;
        if (r2 == null) goto L8;
        Boolean r3 = r2.isAnchor();
    L10:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L12;
        String r4 = "1";
    L13:
        r1.b("is_anchor", r4);
        if (r5 == null) goto L17;
        String r8 = String.valueOf(r5.intValue());
        if (r8 == null) goto L17;
    L18:
        r1.b("type", r8);
        r1.b("result", r7);
        r1.b("scene", r6);
        Unit r9 = Unit.INSTANCE;
        r0.b(r1.a());
        return;
    L17:
        r8 = "-1";
        goto L18
    L12:
        r4 = "0";
        goto L13
    L8:
        r3 = null;
        goto L10
    }
}

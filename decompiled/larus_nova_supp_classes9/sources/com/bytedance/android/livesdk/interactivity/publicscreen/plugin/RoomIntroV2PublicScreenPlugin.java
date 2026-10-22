package com.bytedance.android.livesdk.interactivity.publicscreen.plugin;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.PoiStoreInfoApi;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.x;
import com.bytedance.android.livesdk.message.model.ck;
import com.bytedance.android.livesdk.message.model.dk;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.announcement.IMiddlewareAnnouncementService;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorLocationPoiInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.message.AppointmentInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class RoomIntroV2PublicScreenPlugin extends x implements l {
    public static final /* synthetic */ int g = 0;
    public Disposable b;
    public final Lazy c;
    public final DataCenter d;
    public final o e;
    public final WeakReference<Context> f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RoomIntroV2PublicScreenPlugin a;
        public final /* synthetic */ ck b;

        public b(RoomIntroV2PublicScreenPlugin r1, ck r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.network.response.e r5 = (com.bytedance.android.live.network.response.e) r4;
            StringBuilder r0 = new StringBuilder("request poi address success, resp: ");
            dk r1 = null;
            if (r5 == null) goto L7;
            dk r2 = (dk) ((ExtraResponse) r5).data;
            if (r2 == null) goto L7;
            String r3 = r2.toString();
        L8:
            r0.append(r3);
            ALogger.i("RoomIntroV2PublicScreenPlugin", r0.toString());
            if (r5 == null) goto L11;
            r1 = (dk) ((ExtraResponse) r5).data;
        L11:
            ck r6 = this.b;
            r6.d = r1;
            this.a.r(r6);
            return;
        L7:
            r3 = null;
            goto L8
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ RoomIntroV2PublicScreenPlugin a;
        public final /* synthetic */ ck b;

        public c(RoomIntroV2PublicScreenPlugin r1, ck r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            StringBuilder r0 = new StringBuilder("request poi store info error: ");
            if (r4 == null) goto L5;
            String r5 = r4.getMessage();
        L6:
            r0.append(r5);
            ALogger.e("RoomIntroV2PublicScreenPlugin", r0.toString());
            this.a.r(this.b);
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void q() {
        j r0 = this.e.getMessageManager();
        if (r0 == null) goto L5;
        r0.c(new RoomIntroV2PublicScreenPlugin$onUnload$1(this));
    L5:
        Disposable r1 = this.b;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public final void onMessage(tlc.d r13) {
        Disposable r1 = null;
        if ((r13 instanceof ck) == true) goto L5;
        r13 = null;
    L5:
        final ck r14 = (ck) r13;
        if (r14 != null) goto L8;
        return;
    L8:
        AppointmentInfo r0 = r14.G();
        if (r0 == null) goto L11;
        String r2 = r0.getAppointmentId();
    L12:
        ALogger.i("RoomIntroV2PublicScreenPlugin", "receive RoomIntroMessage");
        boolean r4 = false;
        if (r14.H() == false) goto L66;
        LiveToolbarData r3 = z.o(this.d).getToolbarData();
        if (r3 == null) goto L31;
        List r5 = r3.getToolbarDataList();
        if (r5 == null) goto L31;
        Iterator r6 = r5.iterator();
    L20:
        if (r6.hasNext() == false) goto L27;
        Object r7 = r6.next();
        if (((IToolbarComponentData) r7).getId() != 1) goto L24;
        boolean r8 = true;
    L25:
        if (r8 == false) goto L20;
    L29:
        if (((IToolbarComponentData) r7) == null) goto L31;
        ALogger.i("RoomIntroV2PublicScreenPlugin", "room has COMMERCE_CART");
        boolean r9 = true;
    L32:
        if (r9 == false) goto L66;
        Disposable r10 = this.b;
        if (r10 == null) goto L36;
        r10.dispose();
    L36:
        IMiddlewareHostBusiness r11 = k.f(IMiddlewareHostBusiness.class);
        if (r11 == null) goto L39;
        String r15 = r11.getCurrentUserAddress(this.f.get(), null, -1);
    L40:
        String r16 = (String) this.d.get("data_enter_ecom_live_params", BuildConfig.FLAVOR);
        if (r16 != null) goto L43;
    L44:
        r4 = true;
    L45:
        if (r4 == false) goto L106;
    L50:
        String r17 = null;
    L51:
        Room r18 = z.o(this.d);
        String r19 = r18.getAnchorId();
        long r20 = r18.getRoomId();
        PoiStoreInfoApi r21 = (PoiStoreInfoApi) com.bytedance.android.live.network.c.b().e(PoiStoreInfoApi.class);
        if (r21 != null) goto L54;
        Observable<com.bytedance.android.live.network.response.e<dk>> r23 = null;
    L59:
        if (r23 == null) goto L65;
        Observable r24 = r23.subscribeOn(Schedulers.io());
        if (r24 == null) goto L65;
        Observable r25 = r24.observeOn(AndroidSchedulers.mainThread());
        if (r25 == null) goto L65;
        r1 = r25.subscribe(new b(this, r14), new c(this, r14));
    L65:
        this.b = r1;
        return;
    L54:
        if (r17 == null) goto L56;
        Long r26 = StringsKt.toLongOrNull(r17);
    L57:
        r23 = r21.getPoiStoreInfo(1001, r26, r15, r19, Long.valueOf(r20));
        goto L59
    L56:
        r26 = null;
        goto L57
    L106:
        r17 = new JSONObject(r16).optString("store_id");     // Catch: Exception -> L48
    L48:
        e = move-exception;
        ALogger.e("RoomIntroV2PublicScreenPlugin", "get storeId error: " + e.getMessage());
        goto L50
    L43:
        if (r16.length() != 0) goto L45;
    L39:
        r15 = null;
        goto L40
    L24:
        r8 = false;
        goto L25
    L27:
        r7 = null;
    L31:
        ALogger.i("RoomIntroV2PublicScreenPlugin", "room has not COMMERCE_CART");
        r9 = false;
    L66:
        Boolean r27 = this.e.isAnchor();
        Boolean r28 = Boolean.FALSE;
        if (Intrinsics.areEqual(r27, r28) == false) goto L89;
        if (r2.a(r2) == false) goto L89;
        AppointmentInfo r29 = r14.G();
        if (r29 == null) goto L77;
        List r30 = r29.getScheduledWeekdays();
        if (r30 == null) goto L77;
        if (r30.isEmpty() != true) goto L77;
        boolean r31 = false;
    L108:
        Disposable r33 = this.b;     // Catch: Exception -> L86
        if (r33 == null) goto L81;
        r33.dispose();     // Catch: Exception -> L86
    L81:
        IMiddlewareAnnouncementService r34 = k.f(IMiddlewareAnnouncementService.class);     // Catch: Exception -> L86
        if (r34 == null) goto L84;
        Intrinsics.checkNotNull(r2);     // Catch: Exception -> L86
        r1 = r34.queryAnnouncementStatus(CastLongProtector.parseLong(r2), r31, new AnonymousClass3(this, r14), new AnonymousClass4(this, r14));     // Catch: Exception -> L86
    L84:
        this.b = r1;     // Catch: Exception -> L86
        return;
    L86:
        e = move-exception;
        ALogger.e("RoomIntroV2PublicScreenPlugin", "appointmentId query crash");
        ALogger.e("RoomIntroV2PublicScreenPlugin", e);
        r(r14);
        return;
    L77:
        r31 = true;
    L89:
        if (((Boolean) this.c.getValue()).booleanValue() == true) goto L91;
    L104:
        ALogger.i("RoomIntroV2PublicScreenPlugin", "no local life poi & no poi & no appointment");
        r(r14);
        return;
    L91:
        if (Intrinsics.areEqual(this.e.isAnchor(), r28) == false) goto L104;
        if (r14.E() == null) goto L104;
        AnchorLocationPoiInfo r35 = r14.E();
        if (r35 == null) goto L97;
        long r36 = r35.getPoiId();
    L99:
        if (r36 <= 0) goto L104;
        StringBuilder r37 = new StringBuilder("has local life poi = ");
        AnchorLocationPoiInfo r38 = r14.E();
        if (r38 == null) goto L103;
        r1 = r38.toString();
    L103:
        r37.append(r1);
        ALogger.i("RoomIntroV2PublicScreenPlugin", r37.toString());
        r(r14);
        return;
    L97:
        r36 = 0;
        goto L99
    L11:
        r2 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void p(com.bytedance.android.livesdk.interactivity.api.publicscreen.l r2) {
        Intrinsics.checkNotNullParameter(r2, "publicScreenContext");
        j r3 = this.e.getMessageManager();
        if (r3 == null) goto L6;
        r3.c(new RoomIntroV2PublicScreenPlugin$onLoad$1(this));
        return;
    }

    public final void r(ck r3) {
        ALogger.i("RoomIntroV2PublicScreenPlugin", "insert RoomIntroMessage");
        if (r3.isFromFirstRequest() == false) goto L5;
        r3.setIsFromFirstRequest(false);
    L5:
        r3.e = true;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r0 = o();
        if (r0 == null) goto L13;
        j<? extends v42.b> r1 = r0.getMessageLogicFacade();
        if (r1 == null) goto L14;
        v42.b r2 = (v42.b) r1.getValue();
        if (r2 == null) goto L15;
        r2.b(r3);
        return;
    L15:
        return;
    L14:
        return;
    }

    public RoomIntroV2PublicScreenPlugin(DataCenter r2, o r3, WeakReference<Context> r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        Intrinsics.checkNotNullParameter(r4, "contextRef");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.c = LazyKt.lazy(RoomIntroV2PublicScreenPlugin$isLocalLifePoiEnable$2.INSTANCE);
    }
}

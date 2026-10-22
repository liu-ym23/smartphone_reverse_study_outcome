package com.bytedance.android.livesdk.interactivity.multicamera;

import am2.x;
import android.content.Context;
import b42.b;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.filter.u;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.android.livesdkapi.eventbus.ChangeCameraStreamEvent;
import com.bytedance.android.livesdkapi.toolbar.ToolbarBehaviorData;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import ec2.n1;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import pp1.c;
import zg1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/multicamera/MultiCameraServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lb42/b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiCameraServiceWidget extends MiddlewareRoomRecyclableWidget implements b, Observer<KVData> {
    public ym0.b a;
    public ym0.a b;
    public ym0.a c;
    public ym0.a d;
    public final Map<Integer, b42.a> e;
    public Disposable f;
    public final a g;
    public final Lazy h;
    public final Lazy i;

    public static final class a<T> implements com.bytedance.android.livesdk.app.dataholder.Observer {
        public final /* synthetic */ MultiCameraServiceWidget a;

        public a(MultiCameraServiceWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Integer r5 = (Integer) r4;
            if (r5 != null) goto L6;
            return;
        L6:
            if (r5.intValue() != 2) goto L25;
            ym0.a r6 = this.a.b;
            if (r6 == null) goto L10;
            Long r7 = Long.valueOf(r6.b());
        L11:
            ym0.a r1 = this.a.d;
            if (r1 == null) goto L14;
            Long r2 = Long.valueOf(r1.b());
        L16:
            if ((!Intrinsics.areEqual(r7, r2)) == false) goto L26;
            this.a.Qh();
            h92.a.a("Put CMD_CURRENT_SUB_CAMERA_EXIT_LINK_ONLINE");
            DataCenter r8 = ((Widget) this.a).dataCenter;
            if (r8 == null) goto L20;
            r8.put("cmd_current_sub_camera_exit_online", Boolean.TRUE);
        L20:
            Disposable r9 = this.a.f;
            if (r9 == null) goto L23;
            r9.dispose();
        L23:
            MultiCameraServiceWidget r10 = this.a;
            r10.f = null;
            r10.b = r10.d;
            r10.c = null;
            r10.wq();
            return;
        L26:
            return;
        L14:
            r2 = null;
            goto L16
        L10:
            r7 = null;
            goto L11
        }
    }

    public final void onInit(Object[] r1) {
    }

    @Override // b42.b
    public final void Qh() {
        DataCenter r0 = ((Widget) this).dataCenter;
        IBaseStreamUrl r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = a0.n(r0);
    L6:
        h92.a.a("Exit Sub Camera:" + this.b + ", Switch To Main Camera:" + this.d);
        ym0.a r3 = this.d;
        if (r3 == null) goto L17;
        ChangeCameraStreamEvent r4 = new ChangeCameraStreamEvent();
        r4.setCameraId(r3.b());
        r4.setStreamId(r3.f());
        r4.setCameraType(r3.d());
        r4.setCameraLoadingText(r3.h());
        r4.setCameraScene(r3.c());
        if (r2 == null) goto L11;
        r1 = r2.getStreamUrl();
    L11:
        r4.setStreamUrl(r1);
        if (r2 == null) goto L14;
        long r5 = r2.getRoomId();
    L15:
        r4.setRoomId(r5);
        this.c = r3;
        xs2.b.a().post(r4);
        return;
    L14:
        r5 = 0;
        goto L15
    L17:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // b42.b
    public final void m6() {
        h92.a.a("showMultiCameraToolbarGuide");
        if (((Boolean) ((Property) this.h.getValue()).getValue()).booleanValue() == false) goto L11;
        Context r1 = ((Widget) this).context;
        if (r1 == null) goto L8;
        String r2 = r1.getString(2131920519);
        if (r2 == null) goto L8;
    L9:
        c r0 = new c(r2, null, null, 0, null, null, 0, 0, null, 0, 8190);
        y3.m(((Widget) this).dataCenter).b(ToolbarButton.MULTI_CAMERA, r0);
        ((Property) this.h.getValue()).setValue(Boolean.FALSE);
        return;
    L8:
        r2 = BuildConfig.FLAVOR;
        goto L9
    }

    @Override // b42.b
    public final void on() {
        ym0.b r0 = this.a;
        IBaseStreamUrl r1 = null;
        if (r0 == null) goto L5;
        List r2 = r0.b();
    L6:
        ym0.a r3 = this.b;
        ym0.a r4 = this.d;
        int r5 = h92.a.a;
        StringBuilder r6 = new StringBuilder("cameraInfo Size:");
        if (r2 == null) goto L9;
        Integer r7 = Integer.valueOf(r2.size());
    L10:
        r6.append(r7);
        r6.append(", Curr Camera Id:");
        if (r3 == null) goto L13;
        Long r8 = Long.valueOf(r3.b());
    L14:
        r6.append(r8);
        r6.append(" Main Camera Id:");
        if (r4 == null) goto L17;
        Long r9 = Long.valueOf(r4.b());
    L18:
        r6.append(r9);
        h92.a.a(r6.toString());
        if (this.c == null) goto L21;
        return;
    L21:
        ym0.b r10 = this.a;
        if (r10 == null) goto L26;
        List r11 = r10.b();
        if (r11 == null) goto L26;
        int r13 = r11.size();
    L28:
        if (r13 >= 2) goto L30;
        return;
    L30:
        ym0.a r14 = this.b;
        ym0.a r15 = this.d;
        if (r14 == null) goto L99;
        if (r15 != null) goto L34;
        return;
    L34:
        if (r14.b() == r15.b()) goto L42;
        Boolean r16 = Boolean.TRUE;
        ym0.b r17 = this.a;
        if (r17 == null) goto L40;
        List r18 = r17.b();
        if (r18 == null) goto L40;
        ym0.a r19 = (ym0.a) CollectionsKt.last(r18);
    L41:
        Pair r20 = TuplesKt.to(r16, r19);
    L49:
        boolean r21 = ((Boolean) r20.component1()).booleanValue();
        ym0.a r23 = (ym0.a) r20.component2();
        if (r21 == true) goto L68;
        DataCenter r24 = ((Widget) this).dataCenter;
        if (r24 == null) goto L54;
        m r25 = (m) r24.get("data_broadcast_pause_state", null);
    L55:
        if (r25 == null) goto L60;
        int r26 = r25.a;
        if (r26 == 1) goto L59;
        if (r26 != 2) goto L60;
    L59:
        boolean r27 = true;
    L61:
        if (r27 == false) goto L65;
        f2.b(2131915349, 0);
        return;
    L65:
        if (hd0.c.f().h() == false) goto L68;
        f2.b(2131920645, 0);
        return;
    L60:
        r27 = false;
        goto L61
    L54:
        r25 = null;
    L68:
        h92.a.a("Switch To Camera:" + r23);
        if (r23 != null) goto L71;
        return;
    L71:
        Map<Integer, b42.a> r28 = this.e;
        ym0.b r29 = this.a;
        if (r29 == null) goto L74;
        Integer r30 = r29.a();
    L75:
        b42.a r31 = (b42.a) ((LinkedHashMap) r28).get(r30);
        if (r31 != null) goto L78;
    L79:
        DataCenter r33 = ((Widget) this).dataCenter;
        if (r33 == null) goto L82;
        IRoom r34 = a0.n(r33);
    L83:
        this.c = r23;
        ChangeCameraStreamEvent r35 = new ChangeCameraStreamEvent();
        r35.setCameraId(r23.b());
        r35.setStreamId(r23.f());
        r35.setCameraType(r23.d());
        r35.setCameraLoadingText(r23.h());
        r35.setCameraScene(r23.c());
        if (r34 == null) goto L86;
        r1 = r34.getStreamUrl();
    L86:
        r35.setStreamUrl(r1);
        if (r34 == null) goto L89;
        long r36 = r34.getRoomId();
    L90:
        r35.setRoomId(r36);
        xs2.b.a().post(r35);
        DataCenter r37 = ((Widget) this).dataCenter;
        if (r37 == null) goto L93;
        r37.put("cmd_enter_sub_camera_time", Long.valueOf(System.currentTimeMillis()));
    L93:
        int r38 = r23.c();
        j0 r39 = j0.l();
        Pair[] r40 = new Pair[2];
        r40[0] = TuplesKt.to("entrance_action_type", "click");
        if (r38 != 1) goto L96;
        String r41 = "1";
    L97:
        r40[1] = TuplesKt.to("is_vr_multicamera", r41);
        r39.sendLog("livesdk_live_multicamera_entrance", MapsKt.mapOf(r40), new Object[]{IRoom.class, x.class});
        return;
    L96:
        r41 = "0";
        goto L97
    L89:
        r36 = 0;
        goto L90
    L82:
        r34 = null;
        goto L83
    L78:
        if (r31.a(r21, r14, r23, getContext()) != true) goto L79;
        return;
    L74:
        r30 = null;
    L40:
        r19 = null;
        goto L41
    L42:
        Boolean r43 = Boolean.FALSE;
        ym0.b r44 = this.a;
        if (r44 == null) goto L47;
        List r45 = r44.b();
        if (r45 == null) goto L47;
        ym0.a r46 = (ym0.a) ListProtector.get(r45, 0);
    L48:
        r20 = TuplesKt.to(r43, r46);
    L47:
        r46 = null;
        goto L48
    L99:
        return;
    L26:
        r13 = 0;
        goto L28
    L17:
        r9 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L9:
        r7 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void onUnload() {
        h r0 = i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter);
        if (r0 == null) goto L5;
        r0.getMultiCameraContext().setValue(null);
    L5:
        hd0.c.f().e(this.g);
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L8;
        r1.removeObserver(this);
    L8:
        Disposable r2 = this.f;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        this.f = null;
        ((LinkedHashMap) this.e).clear();
        this.b = null;
        this.a = null;
        this.d = null;
        wq();
    }

    public MultiCameraServiceWidget() {
        this.e = new LinkedHashMap();
        this.g = new a(this);
        this.h = LazyKt.lazy(MultiCameraServiceWidget$shouldShowMultiCameraGuideBubble$2.INSTANCE);
        this.i = LazyKt.lazy(MultiCameraServiceWidget$shouldShowSubCameraBackBubble$2.INSTANCE);
    }

    public final void wq() {
        u r0 = j0.l().c(IRoom.class);
        if (r0 != null) goto L5;
    L7:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L11;
        r1.put("cmd_current_camera_info", this.b);
        return;
    L11:
        return;
    L5:
        if ((r0 instanceof u) == false) goto L7;
        r0.C(this.b);
        goto L7
    }

    public final void onStart() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStart();
    }

    public final void onChanged(Object r20) {
        KVData r0 = (KVData) r20;
        if (r0 == null) goto L176;
        String r3 = r0.getKey();
        int r4 = r3.hashCode();
        boolean r5 = true;
        Integer r9 = null;
        Integer r10 = null;
        r10 = null;
        String r11 = null;
        Integer r13 = null;
        if (r4 == (-435307162)) goto L127;
        if (r4 == 795622401) goto L51;
        if (r4 == 1995521258) goto L13;
        return;
    L13:
        if (r3.equals("cmd_specific_behavior_loaded") == false) goto L166;
        ALogger.d("VR_Multi_Reopen", "data " + r0.toString());
        ToolbarBehaviorData r1 = (ToolbarBehaviorData) r0.getData();
        if (r1 != null) goto L17;
        return;
    L17:
        if (r1.getId() == 42) goto L19;
    L21:
        boolean r6 = false;
    L22:
        if (r6 == true) goto L25;
        r1 = null;
    L25:
        if (r1 == null) goto L168;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L47
        ym0.b r2 = (ym0.b) new Gson().fromJson(r1.getExtraData(), ym0.b.class);     // Catch: Throwable -> L47
        this.a = r2;     // Catch: Throwable -> L47
        if (r2 == null) goto L39;
        List r8 = r2.b();     // Catch: Throwable -> L47
        if (r8 == null) goto L39;
        if (r8.size() > 1) goto L34;
        r5 = false;
    L34:
        if (r5 == true) goto L37;
        r8 = null;
    L37:
        if (r8 == null) goto L39;
        ym0.a r14 = (ym0.a) CollectionsKt.last(r8);     // Catch: Throwable -> L47
    L40:
        this.b = r14;     // Catch: Throwable -> L47
        this.d = r14;     // Catch: Throwable -> L47
        StringBuilder r15 = new StringBuilder("机位数量 : ");     // Catch: Throwable -> L47
        ym0.b r16 = this.a;     // Catch: Throwable -> L47
        if (r16 == null) goto L45;
        List r17 = r16.b();     // Catch: Throwable -> L47
        if (r17 == null) goto L45;
        r10 = Integer.valueOf(r17.size());     // Catch: Throwable -> L47
    L45:
        r15.append(r10);     // Catch: Throwable -> L47
        ALogger.i("VR_Multi_Reopen", r15.toString());     // Catch: Throwable -> L47
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L49:
        Result.box-impl(r18);
        return;
    L39:
        r14 = null;
    L47:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L168:
        return;
    L19:
        if (r1.isFold() == true) goto L21;
        r6 = true;
        goto L22
    L166:
        return;
    L51:
        if (r3.equals("cmd_current_sub_camera_state") == false) goto L170;
        es0.a r21 = (es0.a) r0.getData();
        if ((r21 instanceof es0.a.c) == false) goto L70;
        Disposable r23 = this.f;
        if (r23 == null) goto L57;
        r23.dispose();
    L57:
        this.f = null;
        ym0.a r24 = this.c;
        this.b = r24;
        this.c = null;
        if (r24 == null) goto L125;
        String r25 = r24.g();
        if (r25 == null) goto L125;
        if (r25.length() > 0) goto L65;
        r5 = false;
    L65:
        if (r5 == false) goto L67;
        r11 = r25;
    L67:
        if (r11 == null) goto L125;
        f2.c(r11, 0);
    L125:
        wq();
        return;
    L70:
        if ((r21 instanceof es0.a.a) == false) goto L76;
        Disposable r26 = this.f;
        if (r26 == null) goto L74;
        r26.dispose();
    L74:
        this.f = null;
        this.c = null;
        goto L125
    L76:
        if ((r21 instanceof es0.a.b) == false) goto L81;
        Disposable r27 = this.f;
        if (r27 == null) goto L80;
        r27.dispose();
    L80:
        this.f = null;
        goto L125
    L81:
        ym0.a r28 = this.c;
        this.b = r28;
        this.c = null;
        if (r28 == null) goto L94;
        String r29 = r28.g();
        if (r29 == null) goto L94;
        if (r29.length() <= 0) goto L88;
        boolean r30 = true;
    L89:
        if (r30 == true) goto L92;
        r29 = null;
    L92:
        if (r29 == null) goto L94;
        f2.c(r29, 0);
        goto L94
    L88:
        r30 = false;
    L94:
        ym0.b r31 = this.a;
        if (r31 == null) goto L97;
        r13 = r31.a();
    L97:
        if (r13 == null) goto L125;
        if (r13.intValue() != 1) goto L125;
        if (((Boolean) ((Property) this.i.getValue()).getValue()).booleanValue() == false) goto L125;
        c r33 = new c(((Widget) this).context.getString(2131920518), null, null, 0, null, null, 0, 0, null, 0, 8190);
        this.f = Observable.timer(10, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.interactivity.multicamera.a(this, r33));
        int r34 = r33.e * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        Intrinsics.checkNotNullParameter("退出VR", "type");
        HashMap r35 = new HashMap();
        Intrinsics.checkNotNullParameter(r35, "logMap");
        o r36 = j0.l().c(x.class);
        if (r36 == null) goto L109;
        Map r37 = r36.getMap();
        if (r37 == null) goto L109;
        String r38 = (String) r37.get("action_type");
        if (r38 == null) goto L109;
    L111:
        if (r36 == null) goto L116;
        Map r110 = r36.getMap();
        if (r110 == null) goto L116;
        String r111 = (String) r110.get("enter_from_merge");
        if (r111 == null) goto L116;
    L118:
        if (r36 == null) goto L123;
        Map r39 = r36.getMap();
        if (r39 == null) goto L123;
        String r40 = (String) r39.get("enter_method");
        if (r40 == null) goto L123;
    L124:
        r35.put("enter_from_merge", r111);
        r35.put("enter_method", r40);
        r35.put("room_id", "null");
        r35.put("anchor_id", BuildConfig.FLAVOR);
        r35.put("action_type", r38);
        r35.put("duration", String.valueOf(r34));
        r35.put("bubble_type", "退出VR");
        j0.l().sendLog("livesdk_live_vr_bubble_show", r35, new Object[0]);
    L123:
        r40 = BuildConfig.FLAVOR;
    L116:
        r111 = BuildConfig.FLAVOR;
    L109:
        r38 = BuildConfig.FLAVOR;
        goto L111
    L170:
        return;
    L127:
        if (r3.equals("cmd_specific_behavior_un_loaded") == false) goto L172;
        ToolbarBehaviorData r41 = (ToolbarBehaviorData) r0.getData();
        if (r41 != null) goto L131;
        return;
    L131:
        if (r41.getId() == 42) goto L133;
    L135:
        boolean r43 = false;
    L136:
        if (r43 == true) goto L139;
        r41 = null;
    L139:
        if (r41 == null) goto L174;
        ym0.b r44 = this.a;
        if (r44 == null) goto L145;
        List r45 = r44.b();
        if (r45 == null) goto L145;
        r45.clear();
    L145:
        ym0.a r46 = this.b;
        if (r46 == null) goto L148;
        long r47 = r46.b();
    L149:
        ym0.a r48 = this.d;
        if (r48 != null) goto L152;
    L153:
        ym0.b r49 = this.a;
        if (r49 == null) goto L156;
        r9 = r49.a();
    L156:
        if (r9 != null) goto L159;
    L161:
        int r50 = 2131920520;
    L162:
        f2.b(r50, 0);
        Qh();
        return;
    L159:
        if (r9.intValue() != 1) goto L161;
        r50 = 2131920521;
        goto L162
    L152:
        if (r47 != r48.b()) goto L153;
        return;
    L148:
        r47 = 0;
        goto L149
    L174:
        return;
    L133:
        if (r41.isFold() == true) goto L135;
        r43 = true;
        goto L136
    L172:
        return;
    }

    public final void onLoad(Object[] r8) {
        h r9 = i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter);
        if (r9 == null) goto L5;
        r9.getMultiCameraContext().setValue(this);
    L5:
        DataCenter r10 = ((Widget) this).dataCenter;
        ym0.a r2 = null;
        if (r10 == null) goto L28;
        IRoom r11 = a0.n(r10);
        if (r11 == null) goto L28;
        ILiveToolbarData r13 = r11.getToolbarData();
        if (r13 == null) goto L28;
        List r14 = r13.getToolbarDataList();
        if (r14 == null) goto L28;
        Iterator r15 = r14.iterator();
    L15:
        if (r15.hasNext() == false) goto L22;
        Object r3 = r15.next();
        if (((IToolbarComponentData) r3).getId() != 42) goto L19;
        boolean r4 = true;
    L20:
        if (r4 == false) goto L15;
    L23:
        IToolbarComponentData r5 = (IToolbarComponentData) r3;
        if (r5 == null) goto L28;
        String r16 = r5.getExtraData();
        if (r16 == null) goto L28;
        this.a = (ym0.b) GsonProtectorUtils.fromJson(new Gson(), r16, ym0.b.class);
        goto L28
    L19:
        r4 = false;
        goto L20
    L22:
        r3 = null;
    L28:
        ym0.b r17 = this.a;
        if (r17 == null) goto L41;
        List r18 = r17.b();
        if (r18 == null) goto L41;
        if (r18.size() <= 1) goto L35;
        boolean r6 = true;
    L36:
        if (r6 == true) goto L39;
        r18 = null;
    L39:
        if (r18 == null) goto L41;
        r2 = (ym0.a) CollectionsKt.last(r18);
        goto L41
    L35:
        r6 = false;
    L41:
        this.b = r2;
        this.d = r2;
        DataCenter r19 = ((Widget) this).dataCenter;
        if (r19 == null) goto L44;
        r19.put("cmd_current_camera_info", r2);
    L44:
        ym0.b r20 = this.a;
        if (r20 == null) goto L50;
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L50;
        r7.put("cmd_multicamera_biz_type", r20.a());
    L50:
        if (this.a == null) goto L63;
        Integer r21 = (Integer) ((Widget) this).dataCenter.get("cmd_multicamera_biz_type", -1);
        if (r21 != null) goto L55;
    L57:
        boolean r23 = false;
    L58:
        j0 r24 = j0.l();
        Pair[] r25 = new Pair[2];
        r25[0] = TuplesKt.to("entrance_action_type", "show");
        if (r23 == false) goto L61;
        String r26 = "1";
    L62:
        r25[1] = TuplesKt.to("is_vr_multicamera", r26);
        r24.sendLog("livesdk_live_multicamera_entrance", MapsKt.mapOf(r25), new Object[]{Room.class, x.class});
        goto L63
    L61:
        r26 = "0";
        goto L62
    L55:
        if (r21.intValue() != 1) goto L57;
        r23 = true;
    L63:
        wq();
        DataCenter r27 = ((Widget) this).dataCenter;
        if (r27 == null) goto L68;
        r27.observe("cmd_current_sub_camera_state", this);
        r27.observe("cmd_specific_behavior_un_loaded", this);
        if (((Boolean) n1.a.getValue()).booleanValue() == false) goto L68;
        r27.observe("cmd_specific_behavior_loaded", this);
    L68:
        hd0.c.f().c(this.g);
        h92.a.a("MultiCameraServiceWidget onLoad CurrCamera:" + this.b);
    }

    @Override // b42.b
    public final void xj(b42.a r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.e.put(1, r3);
    }
}

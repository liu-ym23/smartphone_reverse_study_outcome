package qp1;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.message.s5;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vs.VSRoomLifeCycleObserver$checkNeedSeekToLatest$$inlined$let$lambda$1;
import com.bytedance.android.livesdk.chatroom.vs.gesture.VSGestureViewManagerHelper;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.vscore_api.paidlive.scope.g;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import fq1.p;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jc1.k;
import jm1.h;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements h, l {
    public PlayerProgressServiceContext a;
    public final CompositeDisposable b;
    public final DataCenter c;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ e a;

        public b(e r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            vlc.d r4 = (vlc.d) sh6.c.b((sh6.b) r3);
            if (r4 == null) goto L6;
            r4.addMessageListener(xq1.b.a(ku2.e.m), this.a);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ e a;

        public c(e r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            if (this.a.d() == false) goto L24;
            boolean r4 = this.a.c();
            PlayerProgressServiceContext r0 = this.a.a;
            if (r0 == null) goto L13;
            m r1 = r0.getVsRoomEnableSeek();
            if (r1 == null) goto L13;
            if (((Boolean) r1.getValue()).booleanValue() != r4) goto L13;
            boolean r5 = false;
        L14:
            if (r5 == false) goto L21;
            PlayerProgressServiceContext r6 = this.a.a;
            if (r6 == null) goto L22;
            m r7 = r6.getVsRoomEnableSeek();
            if (r7 == null) goto L23;
            r7.setValue(Boolean.valueOf(r4));
            return;
        L23:
            return;
        L22:
            return;
        L21:
            return;
        L13:
            r5 = true;
            goto L14
        }
    }

    static {
    }

    public final void onOrientationChangeV2(int r1) {
    }

    public final void onRoomBackgroundV2() {
    }

    public final void onRoomPrepareV2(boolean r1) {
    }

    public final boolean c() {
        DataCenter r0 = this.c;
        if (r0 == null) goto L5;
        IRoom r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r0);
    L7:
        if (r1 == null) goto L17;
        IRoomAuthStatus r2 = r1.getRoomAuthStatus();
        if (r2 == null) goto L17;
        ju2.d r3 = r2.castToOrNull(ju2.d.class);
        if (r3 == null) goto L17;
        if (r3.getSeek() != 1) goto L17;
        if (r.A().isVrCamera(this.c) == true) goto L17;
        boolean r4 = true;
    L18:
        boolean r5 = d();
        if (r4 == false) goto L22;
        if (r5 == false) goto L22;
        return true;
    L22:
        return false;
    L17:
        r4 = false;
        goto L18
    L5:
        r1 = null;
        goto L7
    }

    public final boolean d() {
        DataCenter r0 = this.c;
        if (r0 == null) goto L10;
        IRoom r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r0);
        if (r1 == null) goto L10;
        if (ju2.e.a(r1) != true) goto L10;
        return ((Boolean) VSSettingKeys.LIVE_VS_LIVE_ENABLE_PLAY_BACK.getValue()).booleanValue();
    L10:
        return true;
    }

    public e(DataCenter r1) {
        this.c = r1;
        this.b = new CompositeDisposable();
    }

    public final void b(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r2, "room");
    }

    public final void onMessage(tlc.d r5) {
        if ((r5 instanceof s5) == false) goto L54;
        s5 r6 = (s5) r5;
        if (r6.getSwitchType() == 1) goto L7;
        return;
    L7:
        if (d() == true) goto L9;
        return;
    L9:
        DataCenter r0 = this.c;
        if (r0 == null) goto L12;
        IRoom r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r0);
    L13:
        if (r1 == null) goto L23;
        IRoomAuthStatus r2 = r1.getRoomAuthStatus();
        if (r2 == null) goto L23;
        ju2.d r3 = r2.castToOrNull(ju2.d.class);
        if (r3 == null) goto L23;
        if (r6.getSwitchOn() == false) goto L21;
        long r4 = 1;
    L22:
        r3.setSeek(r4);
        goto L23
    L21:
        r4 = 2;
    L23:
        boolean r7 = c();
        PlayerProgressServiceContext r8 = this.a;
        if (r8 == null) goto L31;
        m r9 = r8.getVsRoomEnableSeek();
        if (r9 == null) goto L31;
        if (((Boolean) r9.getValue()).booleanValue() != r7) goto L31;
        boolean r10 = false;
    L32:
        if (r10 == false) goto L56;
        if (r7 == true) goto L48;
        PlayerProgressServiceContext r11 = this.a;
        if (r11 == null) goto L40;
        m r12 = r11.getAtLatest();
        if (r12 == null) goto L40;
        if (((Boolean) r12.getValue()).booleanValue() == true) goto L48;
    L40:
        String r13 = r6.getSwitchDisplayText();
        if (r13 == null) goto L43;
        f2.c(r13, 0);
    L43:
        PlayerProgressServiceContext r14 = this.a;
        if (r14 == null) goto L48;
        m r15 = r14.getAtLatest();
        if (r15 == null) goto L48;
        r15.setValue(Boolean.TRUE);
    L48:
        PlayerProgressServiceContext r16 = this.a;
        if (r16 == null) goto L57;
        m r17 = r16.getVsRoomEnableSeek();
        if (r17 == null) goto L58;
        r17.setValue(Boolean.valueOf(r7));
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L31:
        r10 = true;
        goto L32
    L12:
        r1 = null;
        goto L13
    }

    public final void K0(IRoom r10, ls2.a r11) {
        Intrinsics.checkNotNullParameter(r10, "room");
        Intrinsics.checkNotNullParameter(r11, "enterExtra");
        r.a().d(r10.isVsRoom());
        LifecycleOwner r2 = null;
        if (r10.isMergeVSRoom() == false) goto L68;
        DataCenter r0 = this.c;
        u r4 = r.u(r0, null, 2);
        if (r0 == null) goto L50;
        IVSPlayerService r5 = (IVSPlayerService) k.f(IVSPlayerService.class);
        if (r5 == null) goto L11;
        IPlayerProgressService r6 = r5.provideVSProgressService(r0);
        if (r6 == null) goto L11;
        PlayerProgressServiceContext r7 = r6.provideContext(r0);
    L12:
        this.a = r7;
        if (r7 == null) goto L17;
        m r8 = r7.getVsRoomEnableSeek();
        if (r8 == null) goto L17;
        r8.setValue(Boolean.valueOf(c()));
    L17:
        PlayerProgressServiceContext r9 = this.a;
        if (r9 == null) goto L50;
        m r12 = r9.getAtLatest();
        if (r12 == null) goto L50;
        if (((Boolean) r12.getValue()).booleanValue() == true) goto L50;
        PlayerProgressServiceContext r13 = this.a;
        if (r13 == null) goto L29;
        m r14 = r13.getVsRoomEnableSeek();
        if (r14 == null) goto L29;
        if (((Boolean) r14.getValue()).booleanValue() == true) goto L50;
    L29:
        final ILivePlayerClient r15 = r.p().currentClient();
        if (r15 == null) goto L36;
        IRoomEventHub r16 = r15.getEventHub();
        if (r16 == null) goto L36;
        MutableLiveData r17 = r16.getFirstFrame();
        if (r17 == null) goto L36;
        Boolean r18 = (Boolean) r17.getValue();
    L38:
        if (Intrinsics.areEqual(r18, Boolean.TRUE) == false) goto L40;
        r15.seekBy(0);
        goto L50
    L40:
        DataCenter r19 = this.c;
        if (r19 == null) goto L50;
        LifecycleOwner r20 = r19.lifecycleOwner;
        if (r20 == null) goto L50;
        if (r15 == null) goto L50;
        IRoomEventHub r21 = r15.getEventHub();
        if (r21 == null) goto L50;
        MutableLiveData r22 = r21.getFirstFrame();
        if (r22 == null) goto L50;
        r22.observe(r20, new VSRoomLifeCycleObserver$checkNeedSeekToLatest$$inlined$let$lambda$1(r15));
    L36:
        r18 = null;
    L11:
        r7 = null;
    L50:
        if (r4 == null) goto L58;
        m<Long> r23 = r4.cameraId();
        if (r23 == null) goto L58;
        Observable r24 = r23.a();
        if (r24 == null) goto L58;
        Disposable r25 = r24.subscribe(new c(this));
        if (r25 == null) goto L58;
        RxUtilKt.c(r25, this.b);
    L58:
        u r1 = r.u(r0, null, 2);
        if (r1 == null) goto L68;
        j<vlc.d> r3 = r1.a();
        if (r3 == null) goto L68;
        if (r3.hasValue() == false) goto L67;
        vlc.d r26 = (vlc.d) r3.getValue();
        if (r26 == null) goto L68;
        r26.addMessageListener(xq1.b.a(ku2.e.m), this);
        goto L68
    L67:
        r3.b().subscribe(new b(this));
    L68:
        g.a(r10.getId(), null).K0(r10, r11);
        DataCenter r110 = this.c;
        if (r110 == null) goto L71;
        LifecycleOwner r111 = r110.lifecycleOwner;
    L73:
        if ((r111 instanceof Fragment) == false) goto L76;
        r2 = r111;
    L76:
        Fragment r27 = (Fragment) r2;
        if (r27 == null) goto L82;
        fq1.c r112 = fq1.d.a();
        if (r112 == null) goto L83;
        r112.d(r27.getActivity(), r27, false);
        return;
    L83:
        return;
    L82:
        return;
    L71:
        r111 = null;
        goto L73
    }

    public final void a(long r1, boolean r3, IRoom r4, boolean r5, ls2.e r6) {
        Intrinsics.checkNotNullParameter(r6, "error");
        if (r5 == true) goto L5;
        return;
    L5:
        this.b.clear();
        vlc.d r7 = xq1.b.b().n(this.c);
        if (r7 == null) goto L8;
        r7.removeMessageListener(this);
    L8:
        if (r4 == null) goto L10;
        r4.isMergeVSRoom();
    L10:
        g.a(r1, null).T0(r4, r6);
        if (((Boolean) VSSettingKeys.LIVE_VS_USE_COMPONENT_STRATEGY_IN_PORTRAIT.getValue()).booleanValue() == false) goto L16;
        if (r4 == null) goto L16;
        if (r4.isMergeVSRoom() != true) goto L16;
        p.a().c();
    L16:
        VSGestureViewManagerHelper.b();
    }
}

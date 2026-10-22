package gn0;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter;
import com.bytedance.android.live.multilink.impl.control.setting.FetchSettingType;
import com.bytedance.android.live.multilink.impl.control.setting.PaidLinkConfigType;
import com.bytedance.android.live.multilink.impl.i;
import com.bytedance.android.live.multilink.impl.j;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.chatroom.interact.model.y;
import com.bytedance.android.livesdk.chatroom.model.interact.b1;
import com.bytedance.android.livesdk.chatroom.model.interact.d1;
import com.bytedance.android.livesdk.chatroom.model.interact.l;
import com.bytedance.android.livesdk.chatroom.model.interact.n;
import com.bytedance.android.livesdk.chatroom.model.interact.p1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.utils.b5;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import yz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final g a;
    public gn0.a b;
    public yz0.f c;
    public final CompositeDisposable d;
    public final bn0.b e;
    public final com.bytedance.android.live.multilink.impl.control.b f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ FetchSettingType b;
        public final /* synthetic */ long c;

        public a(b r1, FetchSettingType r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r8) {
            ExtraResponse r9 = (ExtraResponse) r8;
            int r0 = wh0.c.a;
            FetchSettingType r1 = this.b;
            if (r1 == null) goto L6;
            String r2 = r1.getSource();
            if (r2 == null) goto L6;
        L7:
            boolean r3 = this.a.e();
            Intrinsics.checkNotNullParameter(r9, "response");
            Intrinsics.checkNotNullParameter(r2, "source");
            String r4 = "call updateLinkSettingByApi, source = " + r2 + ", logId = " + r9.logId + ", responseData = " + ((n) r9.data);
            jy0.b.c("ttlive_link", r4, null, 4);
            if (((Boolean) vm2.e.P.getValue(null, vm2.e.a[40])).booleanValue() == false) goto L11;
            if (r3 == false) goto L11;
            boolean r5 = true;
        L12:
            if (r5 == false) goto L14;
            TalkRoomBusinessFullLinkMonitor.a.getClass();
            TalkRoomBusinessFullLinkMonitor.Q(r4, r2);
        L14:
            TalkRoomBusinessFullLinkMonitor r6 = TalkRoomBusinessFullLinkMonitor.a;
            long r7 = this.c;
            String r10 = r9.logId;
            r6.getClass();
            Intrinsics.checkNotNullParameter(r10, "logId");
            TalkRoomBusinessFullLinkMonitor.Z(LinkMonitorData.GetSettingApiMonitorData, TalkRoomBusinessFullLinkMonitor.h(r7), r10, new JSONObject());
            n r11 = (n) r9.data;
            gn0.a r12 = this.a.b;
            if (r12 == null) goto L20;
            LinkMultiControlPresenter r13 = (LinkMultiControlPresenter) r12;
            if (r11.getSettings() == null) goto L19;
            IInteractService r14 = (IInteractService) k.f(IInteractService.class);
            IInteractService.linkMicSettings.postValue(KotlinTypeUtilsKt.castElementType(r11.getSettings()));
            k.f(IKtvService.class).handleSettingUpdate(KotlinTypeUtilsKt.castElementType(r11.getSettings()));
        L19:
            ((com.bytedance.android.livesdk.chatroom.presenter.n) r13).c.put("cmd_open_paid_link_setting_panel_after_fetch_audience_setting", Boolean.TRUE);
        L20:
            b.a(this.a, r11, this.b);
            return;
        L11:
            r5 = false;
        L6:
            r2 = "fetchAudienceSetting";
            goto L7
        }
    }

    /* JADX INFO: renamed from: gn0.b$b, reason: collision with other inner class name */
    public static final class C0216b<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ long b;

        public C0216b(b r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            jy0.b.c("ttlive_link", "fetchAudienceLinkSetting failed " + r6, null, 4);
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.b;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.Y(LinkMonitorData.GetSettingApiMonitorData, TalkRoomBusinessFullLinkMonitor.h(r1), r6, new JSONObject());
            gn0.a r2 = this.a.b;
            if (r2 == null) goto L6;
            x.C(r6, ((LinkMultiControlPresenter) r2).j);
            return;
        }
    }

    public final boolean e() {
        g r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isAnchor();
    }

    public final IRoom f() {
        g r0 = this.a;
        if (r0 == null) goto L5;
        IRoomBase r1 = r0.getRoom();
    L7:
        return (IRoom) r1;
    L5:
        r1 = null;
        goto L7
    }

    public final void d() {
        if (f() == null) goto L12;
        IRoom r0 = f();
        if (r0 == null) goto L7;
        IBaseUser r1 = r0.getOwnerKt();
    L8:
        if (r1 == null) goto L13;
        i97.a r2 = i97.a.a;
        final c r3 = new c(this, System.currentTimeMillis());
        final LinkMultiControlPresenter r4 = (LinkMultiControlPresenter) this.f;
        r4.getClass();
        LinkMicRoomDataSyncModel r5 = LinkWRDSHelper.b();
        long r6 = System.currentTimeMillis();
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = vh7.f.c(n.class);
        ((SingleSubscribeProxy) Single.create(new com.bytedance.android.live.liveinteract.wrds.e(r5, r6, r7)).as(r4.e0())).subscribe(new i(r4, r3), new j(r4, r3));
        return;
    L13:
        return;
    L7:
        r1 = null;
        goto L8
    }

    public static void g(y r6) {
        if (r6.getContent() == null) goto L21;
        p1 r0 = r6.getContent();
        if (r0 == null) goto L7;
        d1 r1 = r0.getNormalPaidLinkmicSettingContent();
    L8:
        if (r1 == null) goto L21;
        com.bytedance.tools.kcp.spongepreference.runtime.a r2 = com.bytedance.android.livesdk.sharedpref.d.N;
        KProperty[] r3 = com.bytedance.android.livesdk.sharedpref.d.a;
        r2.setValue(null, r3[38], Boolean.TRUE);
        p1 r4 = r6.getContent();
        int r5 = 0;
        if (r4 == null) goto L14;
        d1 r7 = r4.getNormalPaidLinkmicSettingContent();
        if (r7 == null) goto L14;
        int r8 = (int) r7.getLimitedTime();
    L15:
        com.bytedance.android.livesdk.sharedpref.d.O.setValue(null, r3[39], Integer.valueOf(r8));
        p1 r9 = r6.getContent();
        if (r9 == null) goto L20;
        d1 r10 = r9.getNormalPaidLinkmicSettingContent();
        if (r10 == null) goto L20;
        r5 = (int) r10.getPaidCount();
    L20:
        com.bytedance.android.livesdk.sharedpref.d.P.setValue(null, r3[40], Integer.valueOf(r5));
        return;
    L14:
        r8 = 0;
        goto L15
    L7:
        r1 = null;
    L21:
        com.bytedance.android.livesdk.sharedpref.d.N.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[38], Boolean.FALSE);
    }

    public static void h(y r4) {
        if (r4.getContent() == null) goto L21;
        p1 r0 = r4.getContent();
        if (r0 == null) goto L7;
        d1 r1 = r0.getNormalPaidLinkmicSettingContent();
    L8:
        if (r1 == null) goto L21;
        com.bytedance.android.livesdk.sharedpref.d.K.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[35], Boolean.TRUE);
        p1 r2 = r4.getContent();
        int r3 = 0;
        if (r2 == null) goto L14;
        d1 r5 = r2.getNormalPaidLinkmicSettingContent();
        if (r5 == null) goto L14;
        int r6 = (int) r5.getLimitedTime();
    L15:
        com.bytedance.android.livesdk.sharedpref.d.g(r6);
        p1 r7 = r4.getContent();
        if (r7 == null) goto L20;
        d1 r8 = r7.getNormalPaidLinkmicSettingContent();
        if (r8 == null) goto L20;
        r3 = (int) r8.getPaidCount();
    L20:
        com.bytedance.android.livesdk.sharedpref.d.k(r3);
        return;
    L14:
        r6 = 0;
        goto L15
    L7:
        r1 = null;
    L21:
        com.bytedance.android.livesdk.sharedpref.d.K.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[35], Boolean.FALSE);
    }

    public static void i(y r7) {
        if (r7.getContent() == null) goto L14;
        p1 r0 = r7.getContent();
        if (r0 == null) goto L7;
        b1 r1 = r0.getNormalPaidLinkmicDescContent();
    L8:
        if (r1 == null) goto L14;
        com.bytedance.tools.kcp.spongepreference.runtime.a r2 = com.bytedance.android.livesdk.sharedpref.d.R;
        KProperty[] r5 = com.bytedance.android.livesdk.sharedpref.d.a;
        r2.setValue(null, r5[42], Boolean.TRUE);
        p1 r8 = r7.getContent();
        if (r8 == null) goto L16;
        b1 r9 = r8.getNormalPaidLinkmicDescContent();
        if (r9 == null) goto L17;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        com.bytedance.android.livesdk.sharedpref.d.S.setValue(null, r5[43], r9);
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r1 = null;
    L14:
        com.bytedance.tools.kcp.spongepreference.runtime.a r10 = com.bytedance.android.livesdk.sharedpref.d.R;
        KProperty[] r3 = com.bytedance.android.livesdk.sharedpref.d.a;
        r10.setValue(null, r3[42], Boolean.FALSE);
        b1 r11 = vh7.f.c(b1.class);
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        com.bytedance.android.livesdk.sharedpref.d.S.setValue(null, r3[43], r11);
    }

    public static void j(y r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$isOpenExt");
        boolean r4 = r3.isOpen();
        com.bytedance.android.livesdk.sharedpref.d.Q.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[41], Boolean.valueOf(r4));
    }

    public final void b(FetchSettingType r18) {
        if (f() == null) goto L46;
        IRoom r1 = f();
        String r2 = null;
        if (r1 == null) goto L7;
        IBaseUser r3 = r1.getOwnerKt();
    L8:
        if (r3 == null) goto L47;
        i97.a r4 = i97.a.a;
        long r5 = System.currentTimeMillis();
        int r6 = eg0.a.a;
        IRoomBase r7 = f();
        if (r7 == null) goto L13;
        Long r8 = Long.valueOf(IRoomKtKt.getId(r7));
    L14:
        IRoom r9 = f();
        if (r9 == null) goto L19;
        IBaseUser r10 = r9.getOwnerKt();
        if (r10 == null) goto L19;
        Intrinsics.checkNotNullParameter(r10, "$this$secUidExt");
        String r11 = r10.getCastSecUid();
    L20:
        IRoom r12 = f();
        if (r12 == null) goto L25;
        String r13 = IRoomKt_androidKt.getOwnerUserIdString(r12);
        if (r13 == null) goto L25;
        Long r14 = StringsKt.toLongOrNull(r13);
    L26:
        IRoom r15 = f();
        if (r15 == null) goto L29;
        r2 = IRoomKt_androidKt.getOwnerUserIdString(r15);
    L29:
        an0.b r16 = an0.b.a;
        uz0.c r17 = new uz0.c();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "$this$beforeConfigureRequest");
        Map r19 = ((uz0.a) r17).b;
        Intrinsics.checkNotNullParameter(r19, "queriesMap");
        if (r8 == null) goto L34;
        String r20 = Long.valueOf(r8.longValue()).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r20 == null) goto L34;
        r19.put("room_id", r20);
    L34:
        Intrinsics.checkNotNullParameter("sec_owner_id", "$this$setTo");
        if (r11 == null) goto L37;
        r19.put("sec_owner_id", r11);
    L37:
        if (r14 == null) goto L41;
        String r21 = Long.valueOf(r14.longValue()).toString();
        Intrinsics.checkNotNullParameter("owner_id", "$this$setTo");
        if (r21 == null) goto L41;
        r19.put("owner_id", r21);
    L41:
        Intrinsics.checkNotNullParameter("owner_open_id", "$this$setTo");
        if (r2 == null) goto L44;
        r19.put("owner_open_id", r2);
    L44:
        Intrinsics.checkNotNullParameter(r17, "$this$afterConfigureRequest");
        Observable r22 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(r16.b(), "/webcast/linkmic_audience/get_settings/", TypesJVMKt.getJavaType(Reflection.typeOf(n.class)), Extra.class, ((uz0.a) r17).d, ((uz0.a) r17).a, ((uz0.a) r17).b, ((uz0.a) r17).c);
        int r23 = p.a;
        r22.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r18, r5), new C0216b(this, r5));
        return;
    L25:
        r14 = null;
    L19:
        r11 = null;
        goto L20
    L13:
        r8 = null;
        goto L14
    L47:
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final void c(FetchSettingType r2) {
        if (e() == false) goto L5;
    L7:
        b(r2);
        return;
    L5:
        if (vm2.e.i() == false) goto L7;
        d();
    }

    public b(bn0.b r2, com.bytedance.android.live.multilink.impl.control.b r3) {
        Intrinsics.checkNotNullParameter(r3, "controlHostService");
        this.e = r2;
        this.f = r3;
        this.a = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), g.class);
        this.d = new CompositeDisposable();
    }

    public static final void a(b r26, n r27, FetchSettingType r28) {
        r26.getClass();
        boolean r2 = r27.getAudioChatOnlyAcceptFollowerApply();
        com.bytedance.tools.kcp.spongepreference.runtime.a r3 = com.bytedance.android.livesdk.sharedpref.d.e;
        KProperty[] r4 = com.bytedance.android.livesdk.sharedpref.d.a;
        r3.setValue(null, r4[3], Boolean.valueOf(r2));
        com.bytedance.android.livesdk.sharedpref.d.h.setValue(null, r4[6], Boolean.valueOf(r27.getAudioChatAcceptNeedVerified()));
        gn0.a r7 = r26.b;
        if (r7 == null) goto L5;
        gn0.a.C0215a.a(r7, "data_voice_talk_apply_need_verify", null, null, r27.getAudioChatAcceptNeedVerified(), null, 22);
    L5:
        boolean r8 = false;
        if (r28 != FetchSettingType.AnchorAudioAttach) goto L22;
        List r0 = r27.getSettings();
        if (r0 == null) goto L213;
        Iterator r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L18;
        Object r5 = r1.next();
        if (((y) r5).getKey() != 23) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L11;
    L19:
        y r9 = (y) r5;
        if (r9 == null) goto L370;
        Intrinsics.checkNotNullParameter(r9, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.o.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[13], Boolean.valueOf(r9.isOpen()));
        return;
    L370:
        return;
    L15:
        r6 = false;
        goto L16
    L18:
        r5 = null;
        goto L19
    L213:
        return;
    L22:
        com.bytedance.android.livesdk.sharedpref.d.c.setValue(null, r4[1], Boolean.valueOf(r27.getVideoTalkOnlyAcceptFollower()));
        com.bytedance.android.livesdk.sharedpref.d.i.setValue(null, r4[7], Boolean.valueOf(r27.getAcceptNeedVerified()));
        gn0.a r12 = r26.b;
        if (r12 == null) goto L25;
        gn0.a.C0215a.a(r12, "data_video_talk_apply_need_verify", null, null, r27.getAcceptNeedVerified(), null, 22);
    L25:
        int r11 = 51;
        com.bytedance.android.livesdk.sharedpref.d.a0.setValue(null, r4[51], Boolean.valueOf(r27.getIntimateChatAcceptNeedVerified()));
        com.bytedance.android.livesdk.sharedpref.d.i(r27.getIntimateChatOnlyJoinThroughInvitation());
        com.bytedance.android.livesdk.sharedpref.d.h(r27.getIntimateOnlyAcceptFollowerApply());
        List r10 = r27.getSettings();
        if (r28 == null) goto L29;
        String r13 = r28.getSource();
        if (r13 == null) goto L29;
    L31:
        if (r10 != null) goto L33;
    L87:
        List r14 = r27.getSettings();
        if (r14 == null) goto L372;
        Iterator r15 = r14.iterator();
    L91:
        if (r15.hasNext() == false) goto L373;
        y r16 = (y) r15.next();
        int r17 = r16.getKey();
        if (r17 != 28) goto L95;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.p.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[14], Boolean.valueOf(r16.isOpen()));
        goto L91
    L95:
        if (r17 != 29) goto L97;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.q.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[15], Boolean.valueOf(r16.isOpen()));
        goto L91
    L97:
        if (r17 != 33) goto L98;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.s.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[17], Boolean.valueOf(r16.isOpen()));
        gn0.a r18 = r26.b;
        if (r18 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r18, null, 33, r16, r16.isOpen(), null, 17);
        goto L91
    L98:
        if (r17 != 34) goto L100;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.l(r16.isOpen());
        gn0.a r19 = r26.b;
        if (r19 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r19, null, 34, r16, r16.isOpen(), null, 17);
        goto L91
    L100:
        if (r17 != 61) goto L102;
        gn0.a r110 = r26.b;
        if (r110 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r110, null, 61, r16, r16.isOpen(), null, 17);
        goto L91
    L102:
        if (r17 != 62) goto L104;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.Y.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[49], Boolean.valueOf(r16.isOpen()));
        gn0.a r111 = r26.b;
        if (r111 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r111, null, 62, r16, r16.isOpen(), null, 17);
        goto L91
    L104:
        if (r17 != 72) goto L106;
        gn0.a r112 = r26.b;
        if (r112 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r112, null, 72, r16, r16.isOpen(), "AudApi", 1);
        goto L91
    L106:
        if (r17 != 73) goto L108;
        gn0.a r113 = r26.b;
        if (r113 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r113, null, 73, r16, r16.isOpen(), null, 17);
        goto L91
    L108:
        if (r17 != 76) goto L110;
        gn0.a r114 = r26.b;
        if (r114 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r114, null, 76, r16, r16.isOpen(), null, 17);
        goto L91
    L110:
        if (r17 != 77) goto L112;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.E.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[29], Boolean.valueOf(r16.isOpen()));
        goto L91
    L112:
        if (r17 != 93) goto L114;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.d(r16.isOpen());
        goto L91
    L114:
        if (r17 != 94) goto L115;
        gn0.a r115 = r26.b;
        if (r115 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r115, null, 94, r16, r16.isOpen(), null, 17);
        goto L91
    L115:
        switch(r17) {
            case 10: goto L130;
            case 11: goto L127;
            case 12: goto L126;
            case 13: goto L123;
            case 14: goto L122;
            default: goto L117;
        };
    L122:
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.i(r16.isOpen());
        goto L91
    L123:
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.W.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[47], Boolean.valueOf(r16.isOpen()));
        int r20 = com.bytedance.android.live.multilink.impl.control.b.a.a(r26.f);
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        k(r20, "data_intimate_chat_support_send_gift_to_linker", r16.isOpen());
        gn0.a r21 = r26.b;
        if (r21 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r21, "data_intimate_chat_support_send_gift_to_linker", null, null, r16.isOpen(), null, 22);
        goto L91
    L126:
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.h(r16.isOpen());
        goto L91
    L127:
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.j.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[8], Boolean.valueOf(r16.isOpen()));
        int r22 = com.bytedance.android.live.multilink.impl.control.b.a.a(r26.f);
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        k(r22, "data_big_party_support_send_gift_to_linker", r16.isOpen());
        gn0.a r23 = r26.b;
        if (r23 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r23, "data_big_party_support_send_gift_to_linker", null, null, r16.isOpen(), null, 22);
        goto L91
    L130:
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.c.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[1], Boolean.valueOf(r16.isOpen()));
        goto L91
    L117:
        switch(r17) {
            case 18: goto L149;
            case 37: goto L148;
            case 40: goto L147;
            case 47: goto L144;
            case 69: goto L141;
            case 82: goto L140;
            case 90: goto L137;
            case 105: goto L136;
            case 107: goto L133;
            case 109: goto L132;
            case 113: goto L131;
            default: goto L118;
        };
    L131:
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.x.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[22], Boolean.valueOf(r16.isOpen()));
        goto L91
    L132:
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.w.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[21], Boolean.valueOf(r16.isOpen()));
        goto L91
    L133:
        gn0.a r116 = r26.b;
        if (r116 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r116, null, 107, r16, r16.isOpen(), null, 17);
        goto L91
    L136:
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.e(r16.isOpen());
        goto L91
    L137:
        gn0.a r117 = r26.b;
        if (r117 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r117, null, 90, r16, r16.isOpen(), null, 17);
        goto L91
    L140:
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.t.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[18], Boolean.valueOf(r16.isOpen()));
        goto L91
    L141:
        gn0.a r118 = r26.b;
        if (r118 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r118, null, 69, r16, r16.isOpen(), null, 17);
        goto L91
    L144:
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.v.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[20], Boolean.valueOf(r16.isOpen()));
        gn0.a r24 = r26.b;
        if (r24 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r24, "data_voice_chat_pre_online_on", null, null, r16.isOpen(), null, 22);
        goto L91
    L147:
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.D.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[28], Boolean.valueOf(r16.isOpen()));
        goto L91
    L148:
        com.bytedance.android.livesdk.sharedpref.d.z.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[24], Integer.valueOf(r16.getValue()));
        goto L91
    L149:
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.X.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[48], Boolean.valueOf(r16.isOpen()));
        int r25 = com.bytedance.android.live.multilink.impl.control.b.a.a(r26.f);
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        k(r25, "data_audio_chat_support_send_gift_to_linker", r16.isOpen());
        gn0.a r29 = r26.b;
        if (r29 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r29, "data_audio_chat_support_send_gift_to_linker", null, null, r16.isOpen(), null, 22);
        goto L91
    L118:
        switch(r17) {
            case 22: goto L166;
            case 23: goto L165;
            case 24: goto L162;
            case 25: goto L152;
            default: goto L120;
        };
    L152:
        bn0.b r30 = r26.e;
        if (r30 == null) goto L159;
        jn0.b r31 = jn0.c.a(r30);
        if (r31 == null) goto L159;
        BehaviorSubject<Boolean> r32 = r31.dk();
        if (r32 == null) goto L159;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        r32.onNext(Boolean.valueOf(r16.isOpen()));
    L159:
        gn0.a r33 = r26.b;
        if (r33 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r33, "data_support_send_gift_to_official_channel_host", null, null, r16.isOpen(), null, 22);
        goto L91
    L162:
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.m.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[11], Boolean.valueOf(r16.isOpen()));
        gn0.a r34 = r26.b;
        if (r34 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r34, null, 24, null, r16.isOpen(), null, 21);
        goto L91
    L165:
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.o.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[13], Boolean.valueOf(r16.isOpen()));
        goto L91
    L166:
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.n.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[12], Boolean.valueOf(r16.isOpen()));
        goto L91
    L120:
        switch(r17) {
            case 52: goto L182;
            case 53: goto L178;
            case 54: goto L173;
            case 55: goto L168;
            default: goto L91;
        };
    L168:
        if (vm2.e.f() == true) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.C.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[27], Boolean.valueOf(r16.isOpen()));
        gn0.a r119 = r26.b;
        if (r119 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r119, null, 55, r16, r16.isOpen(), null, 17);
        goto L91
    L173:
        if (vm2.e.f() == true) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.B.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[26], Boolean.valueOf(r16.isOpen()));
        gn0.a r120 = r26.b;
        if (r120 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r120, null, 54, r16, r16.isOpen(), null, 17);
        goto L91
    L178:
        if (vm2.e.f() == true) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.A.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[25], Boolean.valueOf(r16.isOpen()));
        gn0.a r121 = r26.b;
        if (r121 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r121, null, 53, r16, r16.isOpen(), null, 17);
        goto L91
    L182:
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.y.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[23], Boolean.valueOf(r16.isOpen()));
        gn0.a r122 = r26.b;
        if (r122 == null) goto L91;
        Intrinsics.checkNotNullParameter(r16, "$this$isOpenExt");
        gn0.a.C0215a.a(r122, null, 52, r16, r16.isOpen(), null, 17);
        goto L91
    L373:
        return;
    L372:
        return;
    L33:
        if (r10.isEmpty() == true) goto L87;
        Iterator r35 = r10.iterator();
        boolean r123 = false;
    L37:
        if (r35.hasNext() == false) goto L79;
        y r124 = (y) r35.next();
        int r125 = r124.getKey();
        if (r125 == r11) goto L54;
        if (r125 == 89) goto L53;
        switch(r125) {
            case 41: goto L48;
            case 42: goto L47;
            case 43: goto L46;
            case 44: goto L45;
            default: goto L43;
        };
    L46:
        com.bytedance.android.livesdk.sharedpref.d.p(r124.getValue());
        r123 = true;
        goto L37
    L48:
        com.bytedance.android.livesdk.sharedpref.d.j(r124.getValue());
        r8 = true;
        goto L37
    L43:
        switch(r125) {
            case 63: goto L52;
            case 64: goto L51;
            case 65: goto L50;
            case 66: goto L49;
            default: goto L77;
        };
    L49:
        h(r124);
        goto L77
    L50:
        i(r124);
        goto L77
    L51:
        j(r124);
        goto L77
    L52:
        g(r124);
    L77:
        r11 = 51;
        goto L37
    L45:
        com.bytedance.android.livesdk.sharedpref.d.o(r124.getValue());
        goto L77
    L47:
        com.bytedance.android.livesdk.sharedpref.d.f(r124.getValue());
        goto L77
    L53:
        com.bytedance.android.livesdk.sharedpref.d.T.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[44], Integer.valueOf(r124.getValue()));
        goto L77
    L54:
        int r126 = r124.getValue();
        com.bytedance.tools.kcp.spongepreference.runtime.a r127 = com.bytedance.android.livesdk.sharedpref.d.J;
        KProperty[] r128 = com.bytedance.android.livesdk.sharedpref.d.a;
        r127.setValue(null, r128[34], Integer.valueOf(r126));
        if (r124.getContent() == null) goto L77;
        p1 r129 = r124.getContent();
        if (r129 == null) goto L59;
        l r130 = r129.getApplicationReasonContent();
    L60:
        if (r130 == null) goto L77;
        p1 r131 = r124.getContent();
        String r132 = "";
        if (r131 == null) goto L67;
        l r133 = r131.getApplicationReasonContent();
        if (r133 == null) goto L67;
        String r134 = r133.getManualReason();
        if (r134 == null) goto L67;
    L68:
        Intrinsics.checkNotNullParameter(r134, "<set-?>");
        com.bytedance.android.livesdk.sharedpref.d.U.setValue(null, r128[45], r134);
        p1 r36 = r124.getContent();
        if (r36 == null) goto L76;
        l r37 = r36.getApplicationReasonContent();
        if (r37 == null) goto L76;
        String r38 = r37.getDefaultReason();
        if (r38 == null) goto L76;
        r132 = r38;
    L76:
        Intrinsics.checkNotNullParameter(r132, "<set-?>");
        com.bytedance.android.livesdk.sharedpref.d.V.setValue(null, r128[46], r132);
    L67:
        r134 = "";
        goto L68
    L59:
        r130 = null;
        goto L60
    L79:
        if (r8 == true) goto L81;
        com.bytedance.android.livesdk.sharedpref.d.j(-1);
        com.bytedance.android.livesdk.sharedpref.d.f(-1);
    L81:
        jy0.b.d("ttlive_link_paid", "interactAudienceConfig ".concat(r13));
        if (r123 == true) goto L84;
        com.bytedance.android.livesdk.sharedpref.d.p(-1);
        com.bytedance.android.livesdk.sharedpref.d.o(-1);
    L84:
        jy0.b.d("ttlive_link_paid", "videoTalkConfig ".concat(r13));
        gn0.a r39 = r26.b;
        if (r39 == null) goto L87;
        ((LinkMultiControlPresenter) r39).C0(PaidLinkConfigType.All);
    L29:
        r13 = "fetchSetting";
        goto L31
    }

    public static void k(int r4, String r5, boolean r6) {
        int r0 = b5.a;
        boolean r1 = true;
        if ((r4 & 32) != 32) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L11;
        if (Intrinsics.areEqual("data_big_party_support_send_gift_to_linker", r5) == false) goto L11;
        com.bytedance.android.live.revenue.core.util.f.a(ca0.k.class).setAllowSendToGuest(r6);
        return;
    L11:
        if ((r4 & 2) != 2) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L19;
        if (Intrinsics.areEqual("data_intimate_chat_support_send_gift_to_linker", r5) == false) goto L19;
        com.bytedance.android.live.revenue.core.util.f.a(ca0.k.class).setAllowSendToGuest(r6);
        return;
    L19:
        if ((r4 & 8) == 8) goto L22;
        r1 = false;
    L22:
        if (r1 == true) goto L24;
        return;
    L24:
        if (Intrinsics.areEqual("data_audio_chat_support_send_gift_to_linker", r5) == false) goto L30;
        com.bytedance.android.live.revenue.core.util.f.a(ca0.k.class).setAllowSendToGuest(r6);
        return;
    L30:
        return;
    L13:
        r3 = false;
        goto L14
    L5:
        r2 = false;
        goto L6
    }
}

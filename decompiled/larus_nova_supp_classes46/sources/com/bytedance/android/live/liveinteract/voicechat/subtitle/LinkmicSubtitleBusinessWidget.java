package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkProfitApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.plantform.utils.v0;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.voicechat.radio.RadioSubtitleBusinessWidget;
import com.bytedance.android.live.liveinteract.voicechat.radio.context.RadioStageContext;
import com.bytedance.android.live.liveinteract.voicechat.stage.AudioChatStageContext;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.LinkFinishResult;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.bytedance.android.livesdk.chatroom.model.interact.SubtitleEventType;
import com.bytedance.android.livesdk.chatroom.model.interact.UpdateSubtitleType;
import com.bytedance.android.livesdk.chatroom.model.interact.q2;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedSubtitleMode;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.ILinkmicProfitMessage;
import com.bytedance.android.livesdk.message.model.l9;
import com.bytedance.android.livesdk.message.model.m9;
import com.bytedance.android.livesdk.message.model.n9;
import com.bytedance.android.livesdk.message.model.o9;
import com.bytedance.android.livesdk.message.model.ua;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\b\u0012\u0004\u0012\u00020\u00070\u0006:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/subtitle/LinkmicSubtitleBusinessWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Lnj0/b;", "Lvb6/f;", "Lvlc/l;", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$RecordStatusChangeListener;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class LinkmicSubtitleBusinessWidget extends PlatformMultiLinkWidget implements nj0.b, vb6.f, vlc.l, ILiveRecordService.RecordStatusChangeListener, Observer<KVData> {
    public static final int x = 0;
    public static final int y = 0;
    public final CompositeDisposable a;
    public vlc.d b;
    public yb6.e c;
    public com.bytedance.android.live.pushstream.d d;
    public LinkmicSubtitleBusinessContext e;
    public long f;
    public final CopyOnWriteArrayList<nj0.d> g;
    public final Map<String, Boolean> h;
    public final ArrayList<ILinkPlayerInfoBridge> i;
    public final ArrayList<String> j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public boolean s;
    public Integer t;
    public int u;
    public boolean v;
    public boolean w;

    public static final class a {
    }

    public static final class b implements nj0.c {
        public final /* synthetic */ IAudioSubtitleContent a;

        public b(IAudioSubtitleContent r1) {
            this.a = r1;
        }

        @Override // nj0.c
        public final void a(boolean r1, CustomApiServerException r2) {
            if (r1 == false) goto L5;
            com.bytedance.android.livesdk.sharedpref.e r3 = b6.p0;
            IAudioSubtitleContent r4 = this.a;
            r3.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r3, r4);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LinkmicSubtitleBusinessWidget a;

        public c(LinkmicSubtitleBusinessWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Boolean r6 = (Boolean) r5;
            int r0 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
            com.bytedance.android.live.liveinteract.voicechat.stage.a.e("registerStageShow", "receive callback isStageShow=" + r6 + ", subtitleStatus=" + ((LinkmicSubtitleStatus) this.a.Aq().getStatus().getValue()) + ", exclusionEvents=" + this.a.h);
            this.a.h.put("stage_is_insert", r6);
            if (((LinkmicSubtitleStatus) this.a.Aq().getStatus().getValue()) != LinkmicSubtitleStatus.OPEN) goto L18;
            LinkmicSubtitleBusinessWidget r1 = this.a;
            boolean r2 = r6.booleanValue();
            r1.getClass();
            LinkmicSubtitleUIContext.a r3 = LinkmicSubtitleUIContext.Companion;
            nj0.f r4 = r3.a();
            if (r4 == null) goto L14;
            Pair<Float, Float> r7 = r4.Db(r2);
            if (r7 == null) goto L14;
            if (r1.isAnchor() == false) goto L11;
            r1.Ck(r7);
        L11:
            nj0.f r8 = r3.a();
            if (r8 == null) goto L14;
            r8.ic(((Number) r7.getFirst()).floatValue(), ((Number) r7.getSecond()).floatValue(), "update_position_from_stage_subtitle_change");
        L14:
            this.a.dr(false);
            if (r6.booleanValue() == false) goto L17;
            this.a.Eq();
            goto L18
        L17:
            this.a.a.add(Observable.timer(1000, TimeUnit.MILLISECONDS).subscribe(new m(this)));
        L18:
            this.a.fr();
            this.a.cr();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LinkmicSubtitleBusinessWidget a;
        public final /* synthetic */ boolean b;

        public d(LinkmicSubtitleBusinessWidget r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] updatePublicScreenHeight, enterRoom=" + this.b);
            ((Widget) this.a).dataCenter.put("data_adjust_public_screen_for_subtitle", 0);
        }
    }

    public static final class e implements nj0.c {
        public final /* synthetic */ IAudioSubtitleContent a;

        public e(IAudioSubtitleContent r1) {
            this.a = r1;
        }

        @Override // nj0.c
        public final void a(boolean r1, CustomApiServerException r2) {
            if (r1 == false) goto L5;
            com.bytedance.android.livesdk.sharedpref.e r3 = b6.p0;
            IAudioSubtitleContent r4 = this.a;
            r3.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r3, r4);
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ LinkmicSubtitleBusinessWidget a;
        public final /* synthetic */ nj0.c b;
        public final /* synthetic */ UpdateSubtitleType c;
        public final /* synthetic */ IAudioSubtitleContent d;
        public final /* synthetic */ String e;
        public final /* synthetic */ long f;

        public f(LinkmicSubtitleBusinessWidget r1, nj0.c r2, UpdateSubtitleType r3, IAudioSubtitleContent r4, String r5, long r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void accept(Object r9) {
            com.bytedance.android.live.network.response.a r10 = (com.bytedance.android.live.network.response.a) r9;
            nj0.c r0 = this.b;
            if (r0 == null) goto L6;
            r0.a(true, null);
        L6:
            if (this.c == UpdateSubtitleType.UNKNOWN) goto L8;
        L16:
            TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
            LinkmicSubtitleBusinessWidget r2 = this.a;
            int r3 = LinkmicSubtitleBusinessWidget.x;
            long r4 = r2.getRoom().getId();
            String r5 = this.e;
            long r6 = this.f;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r5, "content");
            Intrinsics.checkNotNullParameter(r10, "response");
            JSONObject r7 = new JSONObject();
            r7.put("room_id", r4);
            r7.put("content", r5);
            TalkRoomBusinessFullLinkMonitor.Z(LinkMonitorData.UpdateAudioSubtitleSettingMonitorData, TalkRoomBusinessFullLinkMonitor.h(r6), r10.logId, r7);
            return;
        L8:
            if (this.d.getStatus() != IAudioSubtitleContent.SwitchStatus.SWITCH_ON.getValue()) goto L13;
            LinkmicSubtitleBusinessWidget r8 = this.a;
            r8.getClass();
            if ((r8 instanceof RadioSubtitleBusinessWidget) == false) goto L12;
            this.a.Aq().getStatus().setValue(LinkmicSubtitleStatus.CHECK_IN);
            this.a.Mq();
            goto L16
        L12:
            this.a.Zq(true);
            goto L16
        L13:
            LinkmicSubtitleBusinessWidget r11 = this.a;
            int r12 = LinkmicSubtitleBusinessWidget.x;
            r11.ar();
            LinkmicSubtitleBusinessWidget r13 = this.a;
            r13.getClass();
            if ((r13 instanceof RadioSubtitleBusinessWidget) == false) goto L16;
            this.a.Nq();
            LinkmicSubtitleBusinessWidget r14 = this.a;
            r14.o = false;
            r14.k = false;
            goto L16
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ LinkmicSubtitleBusinessWidget a;
        public final /* synthetic */ nj0.c b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;

        public g(LinkmicSubtitleBusinessWidget r1, nj0.c r2, String r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r9) {
            CustomApiServerException r10 = (Throwable) r9;
            nj0.c r0 = this.b;
            if (r0 != null) goto L5;
        L9:
            TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
            LinkmicSubtitleBusinessWidget r2 = this.a;
            int r3 = LinkmicSubtitleBusinessWidget.x;
            long r4 = r2.getRoom().getId();
            String r5 = this.c;
            long r6 = this.d;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r5, "content");
            JSONObject r7 = new JSONObject();
            r7.put("room_id", r4);
            r7.put("content", r5);
            TalkRoomBusinessFullLinkMonitor.Y(LinkMonitorData.UpdateAudioSubtitleSettingMonitorData, TalkRoomBusinessFullLinkMonitor.h(r6), r10, r7);
            return;
        L5:
            if ((r10 instanceof CustomApiServerException) == true) goto L7;
            CustomApiServerException r8 = null;
        L8:
            r0.a(false, r8);
            goto L9
        L7:
            r8 = r10;
            goto L8
        }
    }

    public final void Am(ei6.a r1, int r2, long r3, Exception r5) {
    }

    public final void E2() {
    }

    public final void H1() {
    }

    public final void M1() {
    }

    public void Mq() {
    }

    public void Nq() {
    }

    public final void W(long r1, OperateType r3) {
        Intrinsics.checkNotNullParameter(r3, "operationType");
    }

    public final void X1(int r1, int r2, Exception r3) {
    }

    public final void Y4() {
    }

    public final void c1(long r1, OperateType r3, BaseCheckException r4) {
        Intrinsics.checkNotNullParameter(r3, "operationType");
        Intrinsics.checkNotNullParameter(r4, "exception");
    }

    public final void k4() {
    }

    public final void q2(int r1, int r2, int r3) {
    }

    public final void ra() {
    }

    public final void s1() {
    }

    public final void t1() {
    }

    static {
        x = UtilityKotlinExtentionsKt.i(52);
        y = UtilityKotlinExtentionsKt.i(32);
    }

    public final LinkmicSubtitleBusinessContext Aq() {
        LinkmicSubtitleBusinessContext r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L5:
        return r0;
    }

    public ArrayList<ILinkPlayerInfoBridge> Bq() {
        ArrayList<ILinkPlayerInfoBridge> r0 = this.i;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L16;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r2 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r2 == null) goto L16;
        Collection<? extends ILinkPlayerInfoBridge> r3 = r2.getOnlineUserList();
        if (r3 == null) goto L16;
        this.i.clear();
        this.i.addAll(r3);
    L16:
        return this.i;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void Eq() {
        StringBuilder r0 = new StringBuilder("[AudioSubtitle] status=");
        LinkmicSubtitleBusinessContext r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L5:
        r0.append((LinkmicSubtitleStatus) r1.getStatus().getValue());
        r0.append(", hasExclusion=");
        r0.append(Fq());
        r0.append(", subtitleIsShow=");
        LinkmicSubtitleUIContext.a r2 = LinkmicSubtitleUIContext.Companion;
        nj0.f r3 = r2.a();
        if (r3 == null) goto L8;
        Boolean r4 = Boolean.valueOf(r3.J9());
    L9:
        r0.append(r4);
        r0.append(" \nexclusionEvents=");
        r0.append(this.h);
        ALogger.i("LinkmicSubtitleBusinessWidget", r0.toString());
        if (isAnchor() == true) goto L14;
        LinkmicSubtitleBusinessContext.Companion.getClass();
        if (LinkmicSubtitleBusinessContext.a.c() == true) goto L14;
        return;
    L14:
        LinkmicSubtitleBusinessContext r5 = this.e;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L18:
        if (((LinkmicSubtitleStatus) r5.getStatus().getValue()) == LinkmicSubtitleStatus.OPEN) goto L20;
        nj0.f r6 = r2.a();
        if (r6 == null) goto L48;
        r6.dh();
        return;
    L48:
        return;
    L20:
        if (Fq() == false) goto L29;
        nj0.f r7 = r2.a();
        if (r7 != null) goto L24;
        return;
    L24:
        if (r7.J9() != true) goto L41;
        nj0.f r8 = r2.a();
        if (r8 == null) goto L42;
        r8.dh();
        return;
    L42:
        return;
    L41:
        return;
    L29:
        if (isAnchor() == false) goto L33;
        nj0.f r9 = r2.a();
        if (r9 == null) goto L44;
        r9.Kj();
        return;
    L44:
        return;
    L33:
        int r10 = g0.a;
        nj0.f r11 = r2.a();
        if (r11 == null) goto L46;
        r11.Kj();
        return;
    L46:
        return;
    L8:
        r4 = null;
        goto L9
    }

    public final boolean Fq() {
        Map<String, Boolean> r0 = this.h;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r2 = ((LinkedHashMap) r0).entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Map.Entry r3 = (Map.Entry) r2.next();
        if (((Boolean) r3.getValue()).booleanValue() == false) goto L4;
        r1.put(r3.getKey(), r3.getValue());
        goto L4
    L9:
        return !r1.isEmpty();
    }

    public final boolean Gq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        List<Integer> r1 = null;
        if (r0 == null) goto L5;
        nh0.f r2 = (nh0.f) r0.get("data_multi_link_dynamic_layout_info_change", new nh0.f(null, null, null, null, null, null, false, 255));
    L6:
        if (r2 == null) goto L8;
        sf0.b r3 = r2.e;
    L9:
        if (r3 == null) goto L11;
        r1 = r3.b;
    L11:
        if (r1 != null) goto L13;
    L15:
        return false;
    L13:
        if (r1.contains(8) != true) goto L15;
        return true;
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public Boolean Iq() {
        cg6.a r0 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 == null) goto L7;
        hg6.g r1 = r0.getRtcManager();
        if (r1 == null) goto L7;
        return Boolean.valueOf(r1.A());
    L7:
        return null;
    }

    public boolean Kq() {
        AudioChatStageContext r0 = AudioChatStageContext.Companion.getContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isStageShowing();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        boolean r3 = r2.booleanValue();
    L10:
        if (r3 == false) goto L12;
    L13:
        return true;
    L12:
        if (Jq() == true) goto L13;
        return false;
    L9:
        r3 = false;
        goto L10
    }

    public final void Tq() {
        int r0 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        StringBuilder r1 = new StringBuilder("registerAudioChatStageObservable, isStageObservableReady=");
        r1.append(this.s);
        r1.append(", Observable=");
        AudioChatStageContext.a r2 = AudioChatStageContext.Companion;
        r1.append(r2.a());
        com.bytedance.android.live.liveinteract.voicechat.stage.a.e("registerStageShow", r1.toString());
        if (this.s == false) goto L6;
        return;
    L6:
        if (r2.a() == null) goto L8;
        this.s = true;
    L8:
        Observable<Boolean> r3 = r2.a();
        if (r3 == null) goto L13;
        Disposable r4 = r3.subscribe(new c(this));
        if (r4 == null) goto L13;
        RxUtilKt.c(r4, this.a);
    L13:
        ((Widget) this).dataCenter.observe("data_multi_lick_dynamic_event_change", this);
    }

    public void Wq() {
        cg6.a r0 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 == null) goto L8;
        hg6.g r1 = r0.getRtcManager();
        if (r1 == null) goto L9;
        r1.g(this);
        return;
    L9:
        return;
    }

    public final void ar() {
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] stopSubtitle, isRtcSubtitleStoping=" + this.o + ", realRtcSubtitleOpenStatus=" + this.k);
        if (isAnchor() == true) goto L8;
        if (vm2.c.b().getGuestSubtitleFromRtc() == true) goto L8;
        return;
    L8:
        if (this.o == false) goto L10;
        return;
    L10:
        if (this.k == true) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual(Iq(), Boolean.FALSE) == false) goto L16;
        this.k = false;
        return;
    L16:
        this.o = true;
        StringBuilder r0 = new StringBuilder("[AudioSubtitle] stopSubtitle, real call mediaManager: ");
        r0.append(this.c);
        r0.append(", rtcClient: ");
        yb6.e r2 = this.c;
        if (r2 == null) goto L19;
        ei6.a r3 = r2.Z0();
    L20:
        r0.append(r3);
        ALogger.i("LinkmicSubtitleBusinessWidget", r0.toString());
        yb6.e r1 = this.c;
        if (r1 == null) goto L29;
        ei6.a r4 = r1.Z0();
        if (r4 == null) goto L30;
        zi6.d r5 = r4.c();
        if (r5 == null) goto L31;
        r5.b();
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L19:
        r3 = null;
        goto L20
    }

    public final IRoom getRoom() {
        return com.bytedance.android.live.core.utils.a0.n(((Widget) this).dataCenter);
    }

    public final boolean isAnchor() {
        return com.bytedance.android.live.core.utils.a0.d(((Widget) this).dataCenter, false);
    }

    @Override // nj0.b
    public final boolean isRecording() {
        Boolean r0 = (Boolean) ((LinkedHashMap) this.h).get("recording");
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public void xq() {
        cg6.a r0 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 == null) goto L8;
        hg6.g r1 = r0.getRtcManager();
        if (r1 == null) goto L9;
        r1.G(this);
        return;
    L9:
        return;
    }

    public boolean yq() {
        int r0 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.c(getRoom()) == false) goto L7;
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.a(je0.d.h(), this.w, Gq()) == false) goto L7;
    L8:
        return true;
    L7:
        if (Jq() == true) goto L8;
        return false;
    }

    public boolean zq() {
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() == 5) goto L5;
        return true;
    L5:
        return false;
    }

    public LinkmicSubtitleBusinessWidget() {
        this.a = new CompositeDisposable();
        this.g = new CopyOnWriteArrayList();
        this.h = new LinkedHashMap();
        this.i = new ArrayList();
        this.j = new ArrayList();
        int r0 = com.bytedance.android.live.liveinteract.voicechat.radio.e.a;
        this.v = com.bytedance.android.live.liveinteract.voicechat.radio.e.d(isAnchor());
    }

    @Override // nj0.b
    public final void Cf() {
        if (isAnchor() == false) goto L9;
        f2.c(s1.B(2131915144), 0);
        IAudioSubtitleContent r0 = (IAudioSubtitleContent) b6.p0.getValue();
        r0.setStatus(IAudioSubtitleContent.SwitchStatus.SWITCH_OFF.getValue());
        vh7.c r1 = jm2.a.d(r0);
        if (r1 == null) goto L8;
        N5((IAudioSubtitleContent) r1, UpdateSubtitleType.UNKNOWN, new b(r0));
        this.p = true;
    L10:
        t.d("caption_move");
        String r2 = u0.f(je0.d.h(), Integer.valueOf(je0.d.f()), je0.d.d(), Integer.valueOf(TalkRoomLogUtils.b.a), null, null, 48);
        LinkmicSubtitleBusinessContext r3 = this.e;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L13:
        Lq("caption_move", r2, t.b(Integer.valueOf(((q2) r3.getLinkmicSubtitleSettingStatus().getValue()).getSubtitleType())));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent");
    L9:
        f2.c(s1.B(2131915145), 0);
        com.bytedance.android.livesdk.sharedpref.e r4 = b6.x;
        Boolean r5 = Boolean.FALSE;
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r5);
        goto L10
    }

    public final void Cq() {
        if (vm2.c.b().getGuestSubtitleFromRtc() == false) goto L19;
        LinkmicSubtitleBusinessContext.Companion.getClass();
        if (LinkmicSubtitleBusinessContext.a.c() == false) goto L20;
        LinkmicSubtitleBusinessContext r0 = this.e;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L10:
        if (((LinkmicSubtitleStatus) r0.getStatus().getValue()) != LinkmicSubtitleStatus.OPEN) goto L21;
        yb6.e r1 = this.c;
        if (r1 == null) goto L22;
        yb6.n r2 = r1.K();
        if (r2 != null) goto L16;
        return;
    L16:
        if (r2.e != true) goto L24;
        int r3 = g0.a;
        Zq(true);
        ((Widget) this).dataCenter.put("data_recover_from_online_float_window_start_subtitle", Boolean.FALSE);
        return;
    L24:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    public final boolean Jq() {
        if (com.bytedance.android.live.liveinteract.voicechat.radio.e.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.v == false) goto L7;
        return true;
    }

    public void Pq() {
        if (Jq() == true) goto L5;
        return;
    L5:
        if (isAnchor() == false) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(Iq(), Boolean.FALSE) == false) goto L14;
        jk0.c r0 = RadioStageContext.Companion.a();
        if (r0 == null) goto L15;
        r0.p9();
        return;
    L15:
        return;
    }

    public void Qq() {
        if (Jq() == true) goto L5;
        return;
    L5:
        if (isAnchor() == false) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(Iq(), Boolean.FALSE) == false) goto L14;
        jk0.c r0 = RadioStageContext.Companion.a();
        if (r0 == null) goto L15;
        r0.K9();
        return;
    L15:
        return;
    }

    public void Rq() {
        if (Jq() == false) goto L8;
        jk0.c r0 = RadioStageContext.Companion.a();
        if (r0 == null) goto L9;
        r0.p9();
        return;
    L9:
        return;
    }

    public void Sq() {
        if (Jq() == false) goto L8;
        jk0.c r0 = RadioStageContext.Companion.a();
        if (r0 == null) goto L9;
        r0.K9();
        return;
    L9:
        return;
    }

    public final void cr() {
        if (vm2.c.b().getDismissKtvComponentLyricsAndMidiOnStageSubtitle() == true) goto L5;
        return;
    L5:
        IKtvService r0 = jc1.k.f(IKtvService.class);
        if (r0 == null) goto L8;
        boolean r1 = r0.getKtvComponentLyricsViewShowStatus();
    L9:
        LinkmicSubtitleBusinessContext r2 = this.e;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L12:
        boolean r4 = false;
        if (((LinkmicSubtitleStatus) r2.getStatus().getValue()) == LinkmicSubtitleStatus.OPEN) goto L15;
        boolean r3 = false;
    L19:
        boolean r5 = Kq();
        IKtvService r6 = jc1.k.f(IKtvService.class);
        if (r6 == null) goto L22;
        boolean r7 = r6.isCurrentUserIsSinger();
    L23:
        IKtvService r8 = jc1.k.f(IKtvService.class);
        if (r8 == null) goto L26;
        boolean r9 = r8.hasEnterMultiChorusQueue();
    L27:
        IKtvService r10 = jc1.k.f(IKtvService.class);
        if (r10 == null) goto L30;
        boolean r11 = r10.getHideLyricsWhenSubtitleOpenSwitch();
    L31:
        if (r3 == false) goto L37;
        if (r5 == false) goto L37;
        if (r7 == true) goto L37;
        if (r9 == true) goto L37;
        if (r11 == false) goto L37;
        r4 = true;
    L37:
        boolean r12 = true ^ r4;
        if (r1 == r12) goto L43;
        IKtvService r13 = jc1.k.f(IKtvService.class);
        if (r13 == null) goto L44;
        r13.updateKtvComponentLyricsViewShowStatus(r12);
        return;
    L44:
        return;
    L43:
        return;
    L30:
        r11 = false;
        goto L31
    L26:
        r9 = false;
        goto L27
    L22:
        r7 = false;
        goto L23
    L15:
        if (isAnchor() == true) goto L17;
        int r14 = g0.a;
    L17:
        r3 = true;
        goto L19
    L8:
        r1 = true;
        goto L9
    }

    public final void fr() {
        Boolean r0 = Iq();
        Boolean r1 = Boolean.FALSE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L6;
        return;
    L6:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() != 5) goto L8;
    L9:
        boolean r2 = false;
        if (this.k == true) goto L12;
    L16:
        boolean r3 = false;
    L18:
        if (r3 == false) goto L28;
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] ksong start, stop subtitle");
        ar();
        if (isAnchor() == false) goto L22;
        f2.b(2131919518, 0);
    L22:
        this.l = true;
        if (isAnchor() == false) goto L28;
        s r4 = t.a;
        if (Intrinsics.areEqual(r4.d.get("ksong"), r1) == false) goto L28;
        r4.d.put("ksong", Boolean.TRUE);
        r4.c.put("ksong", Long.valueOf(System.currentTimeMillis()));
    L28:
        if (this.k == false) goto L30;
    L52:
        if (r2 == false) goto L62;
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] ksong stop, start subtitle");
        Zq(true);
        if (isAnchor() == false) goto L63;
        s r5 = t.a;
        if (Intrinsics.areEqual(r5.d.get("ksong"), Boolean.TRUE) == true) goto L58;
        return;
    L58:
        if (t.a("ksong") == 0) goto L65;
        t.f("ksong");
        r5.d.put("ksong", r1);
        return;
    L65:
        return;
    L63:
        return;
    L62:
        return;
    L30:
        if (yq() == true) goto L34;
        if (this.m == true) goto L52;
    L34:
        if (isAnchor() == false) goto L45;
        if (((IAudioSubtitleContent) b6.p0.getValue()).getStatus() != IAudioSubtitleContent.SwitchStatus.SWITCH_ON.getValue()) goto L45;
        if (Intrinsics.areEqual((Boolean) ((IInteractService) jc1.k.n(IInteractService.class)).subtitleExceptPlayModeOpen().first, r1) == false) goto L45;
        LinkmicSubtitleBusinessContext r6 = this.e;
        if (r6 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L43:
        if (((LinkmicSubtitleStatus) r6.getStatus().getValue()) == LinkmicSubtitleStatus.UNKNOWN) goto L45;
    L51:
        r2 = true;
    L45:
        if (isAnchor() == true) goto L52;
        LinkmicSubtitleBusinessContext r7 = this.e;
        if (r7 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L50:
        if (((LinkmicSubtitleStatus) r7.getStatus().getValue()) != LinkmicSubtitleStatus.OPEN) goto L52;
    L12:
        if (this.m == false) goto L16;
        if (yq() == true) goto L16;
        r3 = true;
        goto L18
    L8:
        if (Jq() == true) goto L9;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return je0.d.f();
    }

    public boolean hr() {
        z5 r0 = getRoom().getLinkerDetail();
        if (r0 == null) goto L5;
        List r1 = r0.getPlayModes();
    L7:
        return com.bytedance.android.livesdk.chatroom.interact.model.d0.b(r1);
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onCreate() {
        super.onCreate();
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] LinkmicSubtitleBusinessWidget#onCreate(), guest setting is " + ((Boolean) b6.x.getValue()));
        Pair r0 = com.bytedance.live.datacontext.d.a(LinkmicSubtitleBusinessWidget$initDataContext$pair$1.INSTANCE);
        LinkmicSubtitleBusinessContext r2 = (LinkmicSubtitleBusinessContext) r0.getFirst();
        r2.getService().d(this);
        com.bytedance.live.datacontext.b.a(r2, nj0.a.class);
        this.e = r2;
        this.a.add((Disposable) r0.getSecond());
        boolean r3 = false;
        List r5 = null;
        if (isAnchor() == true) goto L8;
        LinkmicSubtitleBusinessContext.Companion.getClass();
        if (LinkmicSubtitleBusinessContext.a.c() == true) goto L8;
    L71:
        IMiddlewareLiveService r1 = jc1.k.f(IMiddlewareLiveService.class);
        if (r1 == null) goto L74;
        Boolean r4 = this.h.put("recording", Boolean.valueOf(r1.isRecording(((Widget) this).dataCenter)));
    L74:
        com.bytedance.live.datacontext.m r6 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getCleanMode();
        if (r6 == null) goto L84;
        Integer r7 = (Integer) r6.getValue();
        if (r7 == null) goto L84;
        int r8 = r7.intValue();
        Map<String, Boolean> r9 = this.h;
        if (r8 == 0) goto L81;
        boolean r10 = true;
    L82:
        Boolean r11 = r9.put("clearScreen", Boolean.valueOf(r10));
        goto L84
    L81:
        r10 = false;
    L84:
        if (isAnchor() == true) goto L97;
        LinkmicSubtitleBusinessContext.Companion.getClass();
        if (LinkmicSubtitleBusinessContext.a.c() == false) goto L97;
        z5 r12 = getRoom().getLinkerDetail();
        if (r12 == null) goto L90;
        List r13 = r12.getPlayModes();
    L92:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.b(r13) == false) goto L97;
        if (vm2.d.q0().isOpenSmoothViewMock() == false) goto L97;
        this.h.put("enterRoomSmooth", Boolean.TRUE);
        this.a.add(Observable.timer(10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.voicechat.subtitle.d(this)));
        goto L97
    L90:
        r13 = null;
    L97:
        if (vm2.c.b().getExclusionUpdateAreaHeight() == false) goto L99;
        this.h.put("updateAreaHeight", Boolean.TRUE);
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] set EXCLUSION_UPDATE_AREA_HEIGHT = true");
    L99:
        int r14 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.d() == false) goto L109;
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.a(je0.d.h(), this.w, Gq()) == false) goto L109;
        if (PadConfigUtils.c() == true) goto L109;
        if (FoldScreenUtils.f() == true) goto L109;
        Map<String, Boolean> r15 = this.h;
        Boolean r16 = Boolean.TRUE;
        r15.put("stage_is_insert", r16);
        this.h.put("stage_can_insert", r16);
    L109:
        if (((Boolean) com.bytedance.android.live.core.setting.y.a.getValue()).booleanValue() == false) goto L112;
        int r17 = com.bytedance.android.live.liveinteract.voicechat.radio.e.a;
        this.v = com.bytedance.android.live.liveinteract.voicechat.radio.e.d(isAnchor());
    L112:
        if (Jq() == false) goto L114;
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] set EXCLUSION_RADIO_STAGE_IS_INSERT = true");
        this.h.put("radiolink_stage_is_insert", Boolean.TRUE);
    L114:
        com.bytedance.live.datacontext.m r18 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r18 == null) goto L121;
        IRoom r19 = (IRoom) r18.getValue();
        if (r19 == null) goto L121;
        z5 r20 = r19.getLinkerDetail();
        if (r20 == null) goto L121;
        String r21 = r20.getClientUiInfo();
    L122:
        ClientUIInfo r22 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.a.a(r21);
        if (vm2.c.b().getClassicTeamFightSubtitleBugfix() == false) goto L130;
        if (r22 == null) goto L130;
        List r23 = r22.getUiFeatureList();
        if (r23 == null) goto L130;
        if (r23.contains(4) != true) goto L130;
        this.w = true;
        this.h.put("stage_can_insert", Boolean.FALSE);
    L130:
        IKtvService r24 = jc1.k.f(IKtvService.class);
        if (r24 == null) goto L133;
        boolean r25 = r24.isKtvIsSingingState();
    L134:
        this.m = r25;
        if (isAnchor() == false) goto L147;
        z5 r26 = getRoom().getLinkerDetail();
        if (r26 == null) goto L139;
        List r27 = r26.getPlayModes();
    L141:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.b(r27) == false) goto L147;
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] continue linkmic change status to check in");
        LinkmicSubtitleBusinessContext r28 = this.e;
        if (r28 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L145:
        r28.getStatus().setValue(LinkmicSubtitleStatus.CHECK_IN);
        goto L147
    L139:
        r27 = null;
    L147:
        if (isAnchor() == false) goto L155;
        DataCenter r29 = ((Widget) this).dataCenter;
        Boolean r30 = Boolean.FALSE;
        if (Intrinsics.areEqual((Boolean) r29.get("link_audio_subtitle_receive_check_in_message", r30), Boolean.TRUE) == false) goto L155;
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] LinkMultiControlWidget receive check in, change status to check in");
        LinkmicSubtitleBusinessContext r31 = this.e;
        if (r31 != null) goto L153;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L153:
        r31.getStatus().setValue(LinkmicSubtitleStatus.CHECK_IN);
        ((Widget) this).dataCenter.put("link_audio_subtitle_receive_check_in_message", r30);
    L155:
        if (isAnchor() == true) goto L174;
        LinkmicSubtitleBusinessContext.Companion.getClass();
        if (LinkmicSubtitleBusinessContext.a.c() == false) goto L174;
        z5 r32 = getRoom().getLinkerDetail();
        if (r32 == null) goto L161;
        List r33 = r32.getPlayModes();
    L163:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.b(r33) == false) goto L172;
        this.h.put("subtitleEmpty", Boolean.TRUE);
        int r34 = g0.a;
        if (g0.a(getRoom()) == true) goto L170;
        LinkmicSubtitleBusinessContext r35 = this.e;
        if (r35 != null) goto L169;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L169:
        r35.getStatus().setValue(LinkmicSubtitleStatus.OPEN);
        dr(true);
    L170:
        Eq();
    L172:
        if (((Boolean) ((Widget) this).dataCenter.get("data_recover_from_online_float_window_start_subtitle", Boolean.FALSE)).booleanValue() == false) goto L174;
        Cq();
        goto L174
    L161:
        r33 = null;
    L174:
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r36 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r36 == null) goto L180;
        List<? extends ILinkPlayerInfoBridge> r37 = r36.getOnlineUserList();
        if (r37 == null) goto L180;
        this.i.clear();
        this.i.addAll(r37);
        br(r37);
    L180:
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.d() == false) goto L191;
        z5 r38 = getRoom().getLinkerDetail();
        if (r38 == null) goto L184;
        r5 = r38.getPlayModes();
    L184:
        if (r5 != null) goto L186;
    L188:
        if (r3 == false) goto L192;
        RxUtilKt.c(((LinkProfitApi) com.bytedance.android.live.network.c.b().e(LinkProfitApi.class)).getPlayModeInfo(getRoom().getId(), true).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.voicechat.subtitle.b(this), com.bytedance.android.live.liveinteract.voicechat.subtitle.c.a), this.a);
        return;
    L192:
        return;
    L186:
        if (r5.contains(7L) == false) goto L188;
        r3 = true;
        goto L188
    L191:
        return;
    L133:
        r25 = false;
    L121:
        r21 = null;
    L8:
        if (isAnchor() == true) goto L20;
        this.a.add(xs2.b.a().b(pv0.c.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this)));
        int r39 = v0.a;
        if (v0.a(((Widget) this).dataCenter) == false) goto L20;
        IMultiLinkServiceExternal r40 = jc1.k.f(IMultiLinkServiceExternal.class);
        if (r40 == null) goto L20;
        Observable r41 = r40.registerCurrentStateChangeForAllScene(((Widget) this).dataCenter);
        if (r41 == null) goto L20;
        Observable r42 = r41.observeOn(AndroidSchedulers.mainThread());
        if (r42 == null) goto L20;
        ObservableSubscribeProxy r43 = (ObservableSubscribeProxy) r42.as(AutoDispose.bind(this));
        if (r43 == null) goto L20;
        r43.subscribe(new n(this));
    L20:
        DataCenter r44 = ((Widget) this).dataCenter;
        if (r44 == null) goto L23;
        vlc.d r45 = (vlc.d) r44.get("data_message_manager", null);
    L24:
        this.b = r45;
        if (r45 == null) goto L27;
        r45.addMessageListener(MessageType.LINK_MIC_PROFIT.getKey(), this);
    L27:
        vlc.d r46 = this.b;
        if ((r46 instanceof xlc.a) == true) goto L30;
        r46 = null;
    L30:
        xlc.a r47 = (xlc.a) r46;
        if (r47 == null) goto L33;
        r47.D(MessageType.LINK_MIC_PLAYMODE.getIntType(), this, "SubtitleStatusSubSyncKey");
    L33:
        xq();
        this.a.add(xs2.b.a().b(i1.class).subscribe(new i(this)));
        IMiddlewareLiveService r48 = jc1.k.f(IMiddlewareLiveService.class);
        if (r48 == null) goto L36;
        r48.addRecordStatsChangeListener(this, ((Widget) this).dataCenter);
    L36:
        this.a.add(xs2.b.a().b(zg1.s.class).subscribe(new j(this)));
        this.a.add(xs2.b.a().b(jd0.d.class).subscribe(new k(this)));
        ((Widget) this).dataCenter.observe("cmd_multi_enter_room_remove_view_mock", this);
        ((Widget) this).dataCenter.observe("data_online_changed_list", this);
        ((Widget) this).dataCenter.observe("data_recover_from_online_float_window_start_subtitle", this);
        ((Widget) this).dataCenter.observe("cmd_linkmic_subtitle_ui_widget_load", this);
        ((Widget) this).dataCenter.observe("data_voice_chat_public_screen_height", this);
        ((Widget) this).dataCenter.observe("cmd_audio_chat_stage_widget_init", this);
        ((Widget) this).dataCenter.observe("cmd_ktv_component_hide_lyrics_when_subtitle_open_switch_status_change", this);
        ((Widget) this).dataCenter.observe("data_multi_link_dynamic_layout_info_change", this);
        ((Widget) this).dataCenter.observe("cmd_current_user_multi_chorus_role_change", this);
        ((Widget) this).dataCenter.observe("data_multi_link_dynamic_layout_info_change", this);
        Tq();
        LinkmicSubtitleBusinessContext r49 = this.e;
        if (r49 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L39:
        Disposable r50 = r49.getStatus().a().subscribe(new l(this));
        if (r50 == null) goto L42;
        RxUtilKt.c(r50, this.a);
    L42:
        Integer r51 = je0.d.h();
        if (r51 == null) goto L45;
        int r52 = r51.intValue();
    L46:
        this.u = r52;
        com.bytedance.live.datacontext.j r53 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r53 == null) goto L55;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r54 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r53.getValue();
        if (r54 == null) goto L55;
        BehaviorSubject r55 = r54.a();
        if (r55 == null) goto L55;
        Disposable r56 = r55.subscribe(new com.bytedance.android.live.liveinteract.voicechat.subtitle.e(this));
        if (r56 == null) goto L55;
        RxUtilKt.c(r56, this.a);
    L55:
        IKtvService r57 = jc1.k.f(IKtvService.class);
        if (r57 == null) goto L61;
        Disposable r58 = IKtvService.b.b(r57, null, new com.bytedance.android.live.liveinteract.voicechat.subtitle.f(this), 3);
        if (r58 == null) goto L61;
        RxUtilKt.c(r58, this.a);
    L61:
        if (vm2.c.b().getClassicTeamFightSubtitleBugfix() == false) goto L71;
        TeamFightContext r59 = TeamFightContext.Companion.getContext();
        if (r59 == null) goto L71;
        com.bytedance.live.datacontext.m<Integer> r60 = r59.getFightStatus();
        if (r60 == null) goto L71;
        Observable r61 = r60.a();
        if (r61 == null) goto L71;
        Disposable r62 = r61.subscribe(new com.bytedance.android.live.liveinteract.voicechat.subtitle.g(this));
        if (r62 == null) goto L71;
        RxUtilKt.c(r62, this.a);
        goto L71
    L45:
        r52 = 0;
        goto L46
    L23:
        r45 = null;
        goto L24
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        StringBuilder r0 = new StringBuilder("[AudioSubtitle] onDestroy this.hash:");
        r0.append(hashCode());
        r0.append(", mDataContext.hash:");
        LinkmicSubtitleBusinessContext r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L5:
        r0.append(r1.hashCode());
        ALogger.i("LinkmicSubtitleBusinessWidget", r0.toString());
        IKtvService r2 = jc1.k.f(IKtvService.class);
        if (r2 == null) goto L8;
        r2.updateKtvComponentLyricsViewShowStatus(true);
    L8:
        this.l = false;
        LinkmicSubtitleBusinessContext r3 = this.e;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L12:
        if (((LinkmicSubtitleStatus) r3.getStatus().getValue()) != LinkmicSubtitleStatus.OPEN) goto L17;
        ar();
        LinkmicSubtitleBusinessContext r4 = this.e;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L16:
        r4.getStatus().setValue(LinkmicSubtitleStatus.CLOSE);
        this.r = 0;
    L17:
        dr(false);
        if (isAnchor() == false) goto L20;
        String r5 = "live_end";
    L21:
        String r6 = u0.f(Integer.valueOf(this.u), Integer.valueOf(je0.d.f()), je0.d.d(), Integer.valueOf(TalkRoomLogUtils.b.a), null, null, 48);
        s r7 = t.a;
        LinkmicSubtitleBusinessContext r8 = this.e;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L24:
        Lq(r5, r6, t.b(Integer.valueOf(((q2) r8.getLinkmicSubtitleSettingStatus().getValue()).getSubtitleType())));
        LinkmicSubtitleUIContext.a r9 = LinkmicSubtitleUIContext.Companion;
        nj0.f r10 = r9.a();
        if (r10 == null) goto L27;
        r10.V7();
    L27:
        nj0.f r11 = r9.a();
        if (r11 == null) goto L30;
        r11.dh();
    L30:
        Iterator<Map.Entry<String, Boolean>> r12 = t.a.d.entrySet().iterator();
    L32:
        if (r12.hasNext() == false) goto L36;
        Map.Entry<String, Boolean> r13 = r12.next();
        if (r13.getValue().booleanValue() == false) goto L32;
        s r14 = t.a;
        t.f(r13.getKey());
        goto L32
    L36:
        t.j();
        vlc.d r15 = this.b;
        if (r15 == null) goto L39;
        r15.removeMessageListener(this);
    L39:
        Wq();
        IMiddlewareLiveService r16 = jc1.k.f(IMiddlewareLiveService.class);
        if (r16 == null) goto L42;
        r16.removeRecordStatsChangeListener(this, ((Widget) this).dataCenter);
    L42:
        this.a.clear();
        ((Widget) this).dataCenter.removeObserver(this);
        return;
    L20:
        r5 = "quit_watch";
        goto L21
    }

    public static final void wq(LinkmicSubtitleBusinessWidget r3) {
        if (r3.Kq() == false) goto L5;
    L10:
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", Integer.valueOf(SubtitleEventType.CLEAR.ordinal()));
        r3.Yq(r0);
        return;
    L5:
        if (vm2.c.b().getSubtitlePatchLynxEnable() == true) goto L10;
        nj0.f r4 = LinkmicSubtitleUIContext.Companion.a();
        if (r4 == null) goto L12;
        r4.V7();
        return;
    }

    @Override // nj0.b
    public final void Ck(Pair<Float, Float> r5) {
        Intrinsics.checkNotNullParameter(r5, "newPosition");
        IAudioSubtitleContent r0 = (IAudioSubtitleContent) b6.p0.getValue();
        if (r0 == null) goto L7;
        q2 r1 = r0.getSubtitleStatus();
        if (r1 == null) goto L7;
        r1.setX(((Number) r5.getFirst()).floatValue());
        r1.setY(((Number) r5.getSecond()).floatValue());
    L7:
        vh7.c r6 = jm2.a.d(r0);
        if (r6 == null) goto L12;
        N5((IAudioSubtitleContent) r6, UpdateSubtitleType.COORDINATE, new e(r0));
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent");
    }

    public final void H4(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void M4(cc6.b r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final ec6.a O2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "liveCoreSetting");
        Intrinsics.checkNotNullParameter(r2, "liveCoreSetting");
        Intrinsics.checkNotNullParameter(r2, "liveCoreSetting");
        return null;
    }

    public final void Ra(com.bytedance.android.live.liveinteract.multianchor.model.b r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public void Yq(JsonObject r5) {
        Intrinsics.checkNotNullParameter(r5, "extraObject");
        if (Jq() == false) goto L7;
        jk0.c r0 = RadioStageContext.Companion.a();
        if (r0 == null) goto L11;
        r0.il(r5);
        return;
    L11:
        return;
    L7:
        ih0.b r1 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(((Widget) this).dataCenter);
        if (r1 == null) goto L13;
        r1.Dk("audiochat_stage", "subtitle", r5, false);
        return;
    }

    public final void Zq(boolean r4) {
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] startSubtitle, isKSongPlaying=" + this.m + ", ExcpetPlayMode=" + ((Boolean) ((IInteractService) jc1.k.n(IInteractService.class)).subtitleExceptPlayModeOpen().first) + ", isRtcSubtitleStarting=" + this.n + ", realRtcSubtitleOpenStatus=" + this.k);
        if (qi0.e.c() == false) goto L12;
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r0 == null) goto L12;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L12;
        if (r1.isPrivatePlay() != true) goto L12;
        return;
    L12:
        if (isAnchor() == true) goto L17;
        if (vm2.c.b().getGuestSubtitleFromRtc() == true) goto L17;
        return;
    L17:
        if (this.m == true) goto L19;
    L21:
        if (r4 == false) goto L26;
        if (Intrinsics.areEqual((Boolean) ((IInteractService) jc1.k.n(IInteractService.class)).subtitleExceptPlayModeOpen().first, Boolean.TRUE) == false) goto L26;
        return;
    L26:
        if (zq() == false) goto L29;
        return;
    L29:
        if (this.n == false) goto L31;
        return;
    L31:
        if (this.k == false) goto L34;
        return;
    L34:
        if (Intrinsics.areEqual(Iq(), Boolean.TRUE) == false) goto L48;
        this.n = true;
        StringBuilder r5 = new StringBuilder("[AudioSubtitle] startSubtitle, real call mediaManager: ");
        r5.append(this.c);
        r5.append(", rtcClient: ");
        yb6.e r2 = this.c;
        if (r2 == null) goto L38;
        ei6.a r3 = r2.Z0();
    L39:
        r5.append(r3);
        ALogger.i("LinkmicSubtitleBusinessWidget", r5.toString());
        yb6.e r6 = this.c;
        if (r6 == null) goto L49;
        ei6.a r7 = r6.Z0();
        if (r7 == null) goto L50;
        zi6.d r8 = r7.c();
        if (r8 == null) goto L51;
        r8.a(new dg2.i(LiveWrappedSubtitleMode.SUBTITLE_MODE_RECOGINTE));
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L38:
        r3 = null;
        goto L39
    L48:
        return;
    L19:
        if (yq() == true) goto L21;
    }

    public final void ag(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void br(List<? extends ILinkPlayerInfoBridge> r4) {
        this.j.clear();
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r1 = r5.next();
        if (((ILinkPlayerInfoBridge) r1).isEnlarged() == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        Iterator r6 = r0.iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        String r2 = ((ILinkPlayerInfoBridge) r6.next()).getInteractId();
        if (r2 == null) goto L10;
        this.j.add(r2);
        goto L10
    }

    public final void dr(boolean r4) {
        if (r4 == false) goto L4;
        this.a.add(Observable.timer(vm2.c.b().getEnterRoomDelayAdjustPublicScreenTime(), TimeUnit.MILLISECONDS).subscribe(new d(this, r4)));
        return;
    L4:
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] updatePublicScreenHeight, enterRoom=" + r4);
        ((Widget) this).dataCenter.put("data_adjust_public_screen_for_subtitle", 0);
    }

    public final void er(List<nj0.g> r4) {
        Intrinsics.checkNotNullParameter(r4, "subtitleItemList");
        if (((ArrayList) r4).isEmpty() == false) goto L5;
        return;
    L5:
        g0.g(r4);
        List<nj0.g> r0 = r.b;
        if (r.a(Kq(), r4) == false) goto L8;
        return;
    L8:
        r.b(r4);
        if (Kq() == false) goto L12;
        int r1 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        JsonObject r5 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.h(r4);
        r5.addProperty("type", Integer.valueOf(SubtitleEventType.CONTENT.ordinal()));
        Yq(r5);
        return;
    L12:
        if (vm2.c.b().getSubtitlePatchLynxEnable() == false) goto L18;
        int r2 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        JsonObject r6 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.h(r4);
        r6.addProperty("type", Integer.valueOf(SubtitleEventType.CONTENT.ordinal()));
        r6.addProperty("biz_id", "audiochat_stage");
        JsonObject r3 = new JsonObject();
        r3.add("data", r6);
        r3.addProperty("type", "subtitle");
        nj0.f r7 = LinkmicSubtitleUIContext.Companion.a();
        if (r7 == null) goto L23;
        HybridCard r8 = r7.Ya();
        if (r8 == null) goto L24;
        r8.sendJsEvent("onLinkmicStatusChange", r3);
        return;
    L24:
        return;
    L23:
        return;
    L18:
        nj0.f r9 = LinkmicSubtitleUIContext.Companion.a();
        if (r9 == null) goto L26;
        r9.dq(r4);
        return;
    }

    public final void fe(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    @Override // nj0.b
    public final void guestAudioSubtitleSwitchSetting(boolean r15) {
        if (r15 == false) goto L10;
        Map<String, Boolean> r1 = this.h;
        Boolean r2 = Boolean.TRUE;
        r1.put("subtitleEmpty", r2);
        s r3 = t.a;
        LinkedHashMap r4 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r4, null, null, 6);
        t.i(r4);
        j0.l().sendLog("livesdk_audience_voiceroom_caption_open", r4, new Object[]{IRoom.class});
        s r5 = t.a;
        long r6 = System.currentTimeMillis();
        r5.b = r6;
        r5.a = r6;
        String r7 = u0.f(je0.d.h(), Integer.valueOf(je0.d.f()), je0.d.d(), Integer.valueOf(TalkRoomLogUtils.b.a), null, null, 48);
        LinkmicSubtitleBusinessContext r8 = this.e;
        if (r8 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L7:
        t.h(r7, t.b(Integer.valueOf(((q2) r8.getLinkmicSubtitleSettingStatus().getValue()).getSubtitleType())));
        if (Intrinsics.areEqual(Iq(), r2) == false) goto L20;
        Zq(true);
    L20:
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.d() == false) goto L22;
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", Integer.valueOf(SubtitleEventType.GUEST_SUBTITLE_OPTION.ordinal()));
        r0.addProperty("guest_subtitle_option", Boolean.valueOf(r15));
        Yq(r0);
    L22:
        Eq();
        cr();
        return;
    L10:
        nj0.f r9 = LinkmicSubtitleUIContext.Companion.a();
        if (r9 == null) goto L13;
        r9.V7();
    L13:
        t.d("more");
        String r10 = u0.f(je0.d.h(), Integer.valueOf(je0.d.f()), je0.d.d(), Integer.valueOf(TalkRoomLogUtils.b.a), null, null, 48);
        LinkmicSubtitleBusinessContext r11 = this.e;
        if (r11 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L16:
        Lq("more", r10, t.b(Integer.valueOf(((q2) r11.getLinkmicSubtitleSettingStatus().getValue()).getSubtitleType())));
        if (Intrinsics.areEqual(Iq(), Boolean.TRUE) == false) goto L20;
        ar();
        goto L20
    }

    public final void onChange(ILiveRecordService.RecordStatus r12) {
        Intrinsics.checkNotNullParameter(r12, "status");
        boolean r2 = false;
        if (isAnchor() == false) goto L10;
        LinkmicSubtitleBusinessContext r0 = this.e;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L8:
        if (((LinkmicSubtitleStatus) r0.getStatus().getValue()) != LinkmicSubtitleStatus.OPEN) goto L10;
    L20:
        if (r12 != ILiveRecordService.RecordStatus.RECORDING) goto L28;
        s r1 = t.a;
        if (Intrinsics.areEqual(r1.d.get("record"), Boolean.FALSE) == false) goto L46;
        nj0.f r3 = LinkmicSubtitleUIContext.Companion.a();
        if (r3 == null) goto L46;
        if (r3.J9() != true) goto L46;
        r1.d.put("record", Boolean.TRUE);
        r1.c.put("record", Long.valueOf(System.currentTimeMillis()));
    L46:
        Map<String, Boolean> r4 = this.h;
        ILiveRecordService.RecordStatus r5 = ILiveRecordService.RecordStatus.RECORDING;
        if (r12 != r5) goto L49;
        boolean r6 = true;
    L50:
        r4.put("recording", Boolean.valueOf(r6));
        Eq();
        if (Kq() == false) goto L57;
        JsonObject r7 = new JsonObject();
        if (r12 != r5) goto L55;
        r2 = true;
    L55:
        r7.addProperty("hide", Boolean.valueOf(r2));
        r7.addProperty("type", Integer.valueOf(SubtitleEventType.HIDE.ordinal()));
        Yq(r7);
        return;
    L57:
        return;
    L49:
        r6 = false;
        goto L50
    L28:
        s r8 = t.a;
        if (Intrinsics.areEqual(r8.d.get("record"), Boolean.TRUE) == false) goto L46;
        if (t.a("record") == 0) goto L46;
        r8.d.put("record", Boolean.FALSE);
        t.f("record");
        int r9 = nd0.g.a;
        LinkmicSubtitleBusinessContext r10 = this.e;
        if (r10 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L36:
        if (((LinkmicSubtitleStatus) r10.getStatus().getValue()) != LinkmicSubtitleStatus.OPEN) goto L38;
        boolean r11 = true;
    L39:
        nj0.f r13 = LinkmicSubtitleUIContext.Companion.a();
        if (r13 != null) goto L42;
    L44:
        boolean r14 = false;
    L45:
        nd0.g.b(r11, r14, String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - 0)), "record");
        goto L46
    L42:
        if (r13.J9() != true) goto L44;
        r14 = true;
        goto L45
    L38:
        r11 = false;
    L10:
        if (isAnchor() == true) goto L46;
        LinkmicSubtitleBusinessContext.Companion.getClass();
        if (LinkmicSubtitleBusinessContext.a.c() == false) goto L46;
        LinkmicSubtitleBusinessContext r15 = this.e;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L17:
        if (((LinkmicSubtitleStatus) r15.getStatus().getValue()) != LinkmicSubtitleStatus.OPEN) goto L46;
        int r16 = g0.a;
        goto L20
    }

    public final void onChanged(Object r10) {
        KVData r11 = (KVData) r10;
        if (isViewValid() == false) goto L132;
        if (r11 == null) goto L133;
        Object r0 = r11.getData();
        if ((r0 instanceof Object) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L170;
        String r1 = r11.getKey();
        boolean r6 = true;
        switch(r1.hashCode()) {
            case -2134402895: goto L129;
            case -1785913804: goto L105;
            case -1093702240: goto L95;
            case -784823845: goto L90;
            case -777052631: goto L59;
            case -686813666: goto L56;
            case -519077210: goto L51;
            case -279118790: goto L46;
            case 302906966: goto L17;
            case 864816559: goto L14;
            default: goto L171;
        };
    L171:
        return;
    L14:
        if (r1.equals("cmd_current_user_multi_chorus_role_change") == false) goto L134;
    L57:
        cr();
        return;
    L134:
        return;
    L17:
        if (r1.equals("data_multi_link_dynamic_layout_info_change") == false) goto L135;
        nh0.f r2 = (nh0.f) r11.getData();
        if (r2 != null) goto L22;
        return;
    L22:
        if (r2.e == null) goto L44;
        int r3 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.d() == true) goto L26;
        return;
    L26:
        if (PadConfigUtils.c() == false) goto L28;
        return;
    L28:
        if (FoldScreenUtils.f() == true) goto L138;
        nh0.f r12 = (nh0.f) r11.getData();
        if (r12 == null) goto L173;
        nh0.e r13 = r12.b;
        if (r13 == null) goto L35;
        int r14 = r13.b;
    L36:
        boolean r15 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a(Integer.valueOf(r14), this.w, Gq());
        if ((!Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.h).get("stage_can_insert"), Boolean.valueOf(r15))) == false) goto L40;
        this.h.put("stage_can_insert", Boolean.valueOf(r15));
        this.h.put("subtitleEmpty", Boolean.TRUE);
        Eq();
    L40:
        if (Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.h).get("stage_is_insert"), Boolean.TRUE) == false) goto L139;
        if (r15 == true) goto L140;
        this.h.put("stage_is_insert", Boolean.FALSE);
        return;
    L140:
        return;
    L139:
        return;
    L35:
        r14 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurUILayout();
        goto L36
    L173:
        return;
    L138:
        return;
    L44:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.linkbase.DynamicFrameInfo");
    L135:
        return;
    L46:
        if (r1.equals("data_recover_from_online_float_window_start_subtitle") == true) goto L48;
        return;
    L48:
        if (Intrinsics.areEqual((Boolean) r11.getData(), Boolean.TRUE) == false) goto L143;
        Cq();
        return;
    L143:
        return;
    L51:
        if (r1.equals("cmd_linkmic_subtitle_ui_widget_load") == true) goto L53;
        return;
    L53:
        if (((Boolean) vm2.d.S6.getValue(null, vm2.d.a[406(0x196, float:5.69E-43)])).booleanValue() == false) goto L146;
        Eq();
        return;
    L146:
        return;
    L56:
        if (r1.equals("cmd_ktv_component_hide_lyrics_when_subtitle_open_switch_status_change") == true) goto L57;
        return;
    L59:
        if (r1.equals("data_voice_chat_public_screen_height") == false) goto L150;
        Integer r16 = (Integer) r11.getData();
        if (r16 == null) goto L151;
        int r17 = r16.intValue();
        StringBuilder r4 = new StringBuilder("[AudioSubtitle] updateAreaHeight, publicScreenHeight=");
        r4.append(r17);
        r4.append(", status=");
        LinkmicSubtitleBusinessContext r5 = this.e;
        if (r5 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L65:
        r4.append((LinkmicSubtitleStatus) r5.getStatus().getValue());
        r4.append(", LinkmicSubtitleUIService=");
        LinkmicSubtitleUIContext.a r7 = LinkmicSubtitleUIContext.Companion;
        r4.append(r7.a());
        ALogger.i("LinkmicSubtitleBusinessWidget", r4.toString());
        LinkmicSubtitleBusinessContext r8 = this.e;
        if (r8 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L69:
        if (((LinkmicSubtitleStatus) r8.getStatus().getValue()) == LinkmicSubtitleStatus.OPEN) goto L71;
        return;
    L71:
        if (this.r == r17) goto L73;
        this.r = r17;
        s1.G(r17);
        f2.g();
    L73:
        nj0.f r9 = r7.a();
        if (r9 == null) goto L76;
        int r18 = r9.Vf();
    L77:
        int r19 = s1.j(2131169237);
        int r20 = (x + r17) + y;
        int r21 = (r18 - r19) - r20;
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] updateAreaHeight, dragParentViewHeight=" + r18 + ", publicScreenHeight=" + r17 + ", deleteAreaHeight=" + r19 + ", dragAreaHeight=" + r21 + ", forbiddenAreaHeight=" + r20);
        nj0.f r110 = r7.a();
        if (r110 == null) goto L81;
        r110.Sl(r19, r21, r20);
    L81:
        if (Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.h).get("updateAreaHeight"), Boolean.TRUE) == false) goto L153;
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] set EXCLUSION_UPDATE_AREA_HEIGHT = false");
        this.h.put("updateAreaHeight", Boolean.FALSE);
        LinkmicSubtitleBusinessContext r111 = this.e;
        if (r111 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L85:
        q2 r112 = (q2) r111.getLinkmicSubtitleSettingStatus().getValue();
        nj0.f r22 = r7.a();
        if (r22 == null) goto L88;
        r22.ic((float) r112.getX(), (float) r112.getY(), "update_position_from_update_area_height");
    L88:
        Eq();
        return;
    L153:
        return;
    L76:
        r18 = s1.w();
        goto L77
    L151:
        return;
    L150:
        return;
    L90:
        if (r1.equals("cmd_multi_enter_room_remove_view_mock") == true) goto L92;
        return;
    L92:
        if (Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.h).get("enterRoomSmooth"), Boolean.TRUE) == false) goto L156;
        this.h.put("enterRoomSmooth", Boolean.FALSE);
        Eq();
        return;
    L156:
        return;
    L95:
        if (r1.equals("data_online_changed_list") == false) goto L158;
        List r113 = (List) r11.getData();
        if (r113 != null) goto L99;
    L102:
        if (r6 == true) goto L159;
        this.i.clear();
        this.i.addAll(r113);
        br(this.i);
        return;
    L159:
        return;
    L99:
        if (r113.isEmpty() == true) goto L102;
        r6 = false;
        goto L102
    L158:
        return;
    L105:
        if (r1.equals("data_multi_lick_dynamic_event_change") == false) goto L161;
        int r23 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.d() == true) goto L109;
        return;
    L109:
        if (PadConfigUtils.c() == false) goto L111;
        return;
    L111:
        if (FoldScreenUtils.f() == true) goto L164;
        nh0.f r114 = (nh0.f) r11.getData();
        if (r114 != null) goto L116;
        return;
    L116:
        if (Intrinsics.areEqual(r114.a, "linkmic") == false) goto L165;
        nh0.e r115 = r114.b;
        if (r115 == null) goto L120;
        int r116 = r115.b;
    L121:
        boolean r117 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a(Integer.valueOf(r116), this.w, Gq());
        if ((!Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.h).get("stage_can_insert"), Boolean.valueOf(r117))) == false) goto L125;
        this.h.put("stage_can_insert", Boolean.valueOf(r117));
        this.h.put("subtitleEmpty", Boolean.TRUE);
        Eq();
    L125:
        if (Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.h).get("stage_is_insert"), Boolean.TRUE) == false) goto L166;
        if (r117 == true) goto L167;
        this.h.put("stage_is_insert", Boolean.FALSE);
        return;
    L167:
        return;
    L166:
        return;
    L120:
        r116 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurUILayout();
        goto L121
    L165:
        return;
    L164:
        return;
    L161:
        return;
    L129:
        if (r1.equals("cmd_audio_chat_stage_widget_init") == false) goto L169;
        Tq();
        return;
    L169:
        return;
    L170:
        return;
    L133:
        return;
    }

    public final void onMessage(tlc.d r21) {
        tlc.d r1 = r21;
        boolean r6 = true;
        if ((r1 instanceof ILinkmicProfitMessage) == false) goto L152;
        ILinkmicProfitMessage r2 = (ILinkmicProfitMessage) r1;
        int r3 = r2.getMsgType();
        if (r3 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_AudioSubtitleCheckIn.getValue()) goto L24;
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] receive checkin message, msg_ig=" + r2.getMessageId());
        if (vm2.c.b().getAnchorEnable() == true) goto L9;
        return;
    L9:
        m9 r4 = r2.getAudioSubtitleCheckInContent();
        if (r4 == null) goto L16;
        int r5 = nd0.g.a;
        nd0.g.f(this.f, r4.getVersionId(), r2);
        if (r4.getVersionId() >= this.f) goto L14;
        return;
    L14:
        this.f = r4.getVersionId();
    L16:
        if (isAnchor() == false) goto L228;
        LinkmicSubtitleBusinessContext r7 = this.e;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L20:
        r7.getStatus().setValue(LinkmicSubtitleStatus.CHECK_IN);
        if (((IAudioSubtitleContent) b6.p0.getValue()).getStatus() != IAudioSubtitleContent.SwitchStatus.SWITCH_ON.getValue()) goto L229;
        Zq(false);
        return;
    L229:
        return;
    L228:
        return;
    L24:
        if (r3 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_AudioSubtitleStart.getValue()) goto L58;
        o9 r8 = r2.getAudioSubtitleStartContent();
        if (r8 != null) goto L28;
    L34:
        this.h.put("subtitleEmpty", Boolean.TRUE);
        f2.b(2131915147, 0);
        LinkmicSubtitleBusinessContext r9 = this.e;
        if (r9 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L37:
        r9.getStatus().setValue(LinkmicSubtitleStatus.OPEN);
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] receive subtitle start message");
        dr(false);
        o9 r10 = r2.getAudioSubtitleStartContent();
        if (r10 == null) goto L47;
        ua r11 = r10.castToOrNull(ua.class);
        if (r11 == null) goto L47;
        q2 r12 = r11.getLinkmicSubtitleSettingStatus();
        if (r12 == null) goto L47;
        LinkmicSubtitleBusinessContext r13 = this.e;
        if (r13 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L46:
        r13.getLinkmicSubtitleSettingStatus().setValue(r12);
        gr(r12, "update_position_from_start_im");
    L47:
        Eq();
        Iterator<nj0.d> r14 = this.g.iterator();
    L49:
        if (r14.hasNext() == false) goto L52;
        r14.next().a();
        goto L49
    L52:
        if (isAnchor() == false) goto L54;
    L56:
        cr();
        Pq();
        return;
    L54:
        if (Intrinsics.areEqual(Iq(), Boolean.TRUE) == false) goto L56;
        int r15 = g0.a;
        Zq(true);
        goto L56
    L28:
        if (isAnchor() == false) goto L31;
        int r16 = nd0.g.a;
        nd0.g.f(this.f, r8.getVersionId(), r2);
    L31:
        if (r8.getVersionId() >= this.f) goto L33;
        return;
    L33:
        this.f = r8.getVersionId();
        goto L34
    L58:
        if (r3 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_AudioSubtitleClose.getValue()) goto L232;
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] receive subtitle close message");
        n9 r17 = r2.getAudioSubtitleCloseContent();
        if (r17 == null) goto L69;
        if (isAnchor() == false) goto L65;
        int r18 = nd0.g.a;
        nd0.g.f(this.f, r17.getVersionId(), r2);
    L65:
        if (r17.getVersionId() >= this.f) goto L67;
        return;
    L67:
        this.f = r17.getVersionId();
    L69:
        if (isAnchor() == true) goto L77;
        LinkmicSubtitleBusinessContext.Companion.getClass();
        if (LinkmicSubtitleBusinessContext.a.c() == false) goto L77;
        t.d("anchor_close");
        String r19 = u0.f(je0.d.h(), Integer.valueOf(je0.d.f()), je0.d.d(), Integer.valueOf(TalkRoomLogUtils.b.a), null, null, 48);
        LinkmicSubtitleBusinessContext r20 = this.e;
        if (r20 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L75:
        Lq("anchor_close", r19, t.b(Integer.valueOf(((q2) r20.getLinkmicSubtitleSettingStatus().getValue()).getSubtitleType())));
    L77:
        if (isAnchor() == false) goto L124;
        LinkmicSubtitleBusinessContext r22 = this.e;
        if (r22 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L81:
        LinkmicSubtitleStatus r23 = (LinkmicSubtitleStatus) r22.getStatus().getValue();
        LinkmicSubtitleStatus r24 = LinkmicSubtitleStatus.OPEN;
        if (r23 != r24) goto L123;
        com.bytedance.android.livesdk.sharedpref.e r25 = b6.p0;
        if (((IAudioSubtitleContent) r25.getValue()).getStatus() != IAudioSubtitleContent.SwitchStatus.SWITCH_ON.getValue()) goto L103;
        t.d("playmode_contra");
        String r26 = u0.f(je0.d.h(), Integer.valueOf(je0.d.f()), je0.d.d(), Integer.valueOf(TalkRoomLogUtils.b.a), null, null, 48);
        LinkmicSubtitleBusinessContext r27 = this.e;
        if (r27 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L88:
        Lq("playmode_contra", r26, t.b(Integer.valueOf(((q2) r27.getLinkmicSubtitleSettingStatus().getValue()).getSubtitleType())));
        int r28 = nd0.g.a;
        LinkmicSubtitleBusinessContext r29 = this.e;
        if (r29 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L92:
        if (((LinkmicSubtitleStatus) r29.getStatus().getValue()) != r24) goto L94;
        boolean r30 = true;
    L95:
        nj0.f r31 = LinkmicSubtitleUIContext.Companion.a();
        if (r31 != null) goto L98;
    L100:
        r6 = false;
    L101:
        s r32 = t.a;
        r32.getClass();
        nd0.g.a(r30, r6, String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - r32.a)), "playmode_contra");
        goto L123
    L98:
        if (r31.J9() != true) goto L100;
    L94:
        r30 = false;
        goto L95
    L103:
        if (((IAudioSubtitleContent) r25.getValue()).getStatus() != IAudioSubtitleContent.SwitchStatus.SWITCH_OFF.getValue()) goto L123;
        if (this.p == true) goto L123;
        s r33 = t.a;
        String r34 = r33.f;
        t.d(r34);
        String r35 = u0.f(je0.d.h(), Integer.valueOf(je0.d.f()), je0.d.d(), Integer.valueOf(TalkRoomLogUtils.b.a), null, null, 48);
        LinkmicSubtitleBusinessContext r110 = this.e;
        if (r110 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L109:
        Lq(r34, r35, t.b(Integer.valueOf(((q2) r110.getLinkmicSubtitleSettingStatus().getValue()).getSubtitleType())));
        int r36 = nd0.g.a;
        LinkmicSubtitleBusinessContext r37 = this.e;
        if (r37 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L113:
        if (((LinkmicSubtitleStatus) r37.getStatus().getValue()) != r24) goto L115;
        boolean r38 = true;
    L116:
        nj0.f r39 = LinkmicSubtitleUIContext.Companion.a();
        if (r39 != null) goto L119;
    L121:
        r6 = false;
    L122:
        nd0.g.a(r38, r6, String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - r33.a)), r34);
        goto L123
    L119:
        if (r39.J9() != true) goto L121;
    L115:
        r38 = false;
    L123:
        this.p = false;
    L124:
        Iterator<Map.Entry<String, Boolean>> r40 = t.a.d.entrySet().iterator();
    L126:
        if (r40.hasNext() == false) goto L130;
        Map.Entry<String, Boolean> r41 = r40.next();
        if (r41.getValue().booleanValue() == false) goto L126;
        s r42 = t.a;
        t.f(r41.getKey());
        goto L126
    L130:
        t.j();
        if (Intrinsics.areEqual(Iq(), Boolean.TRUE) == false) goto L136;
        this.l = false;
        if (this.k == false) goto L136;
        ar();
    L136:
        if (isAnchor() == true) goto L138;
        int r43 = g0.a;
    L138:
        f2.b(2131915146, 0);
        LinkmicSubtitleBusinessContext r44 = this.e;
        if (r44 != null) goto L141;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L141:
        r44.getStatus().setValue(LinkmicSubtitleStatus.CLOSE);
        dr(false);
        Eq();
        nj0.f r45 = LinkmicSubtitleUIContext.Companion.a();
        if (r45 == null) goto L144;
        r45.V7();
    L144:
        Iterator<nj0.d> r46 = this.g.iterator();
    L146:
        if (r46.hasNext() == false) goto L149;
        r46.next().a();
        goto L146
    L149:
        if (vm2.c.b().getExclusionUpdateAreaHeight() == false) goto L151;
        this.h.put("updateAreaHeight", Boolean.TRUE);
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] set EXCLUSION_UPDATE_AREA_HEIGHT = true");
    L151:
        this.r = 0;
        this.t = null;
        cr();
        Qq();
        return;
    L232:
        return;
    L152:
        boolean r47 = r1 instanceof l9;
        if (r47 == false) goto L234;
        l9 r48 = (l9) r1;
        if (Intrinsics.areEqual(r48.getWrdsSubKeyFlex(), "SubtitleStatusSubSyncKey") == false) goto L235;
        int r49 = nd0.g.a;
        Intrinsics.checkNotNullParameter(r48, MultiLinkOpenSource.MESSAGE);
        JSONObject r111 = new JSONObject();
        r111.put("msg_id", r48.getMessageIdFlex());     // Catch: Exception -> L177
        q2 r50 = r48.getLinkmicSubtitleSettingStatus();     // Catch: Exception -> L177
        if (r50 == null) goto L160;
        Double r51 = Double.valueOf(r50.getX());     // Catch: Exception -> L177
    L161:
        r111.put("x", r51);     // Catch: Exception -> L177
        q2 r52 = r48.getLinkmicSubtitleSettingStatus();     // Catch: Exception -> L177
        if (r52 == null) goto L164;
        Double r53 = Double.valueOf(r52.getY());     // Catch: Exception -> L177
    L165:
        r111.put("y", r53);     // Catch: Exception -> L177
        q2 r54 = r48.getLinkmicSubtitleSettingStatus();     // Catch: Exception -> L177
        if (r54 == null) goto L168;
        Integer r55 = Integer.valueOf(r54.getSubtitleStyle());     // Catch: Exception -> L177
    L169:
        r111.put("style", r55);     // Catch: Exception -> L177
        if (nd0.e.b() != true) goto L172;
    L175:
        nd0.c.o(nd0.c.a, LinkMonitorData.ReceiveSubtitlePlaymodeMsgMonitorData, r111, 0, null, false, 28);     // Catch: Exception -> L177
    L186:
        if (r47 == true) goto L188;
        r1 = null;
    L188:
        l9 r56 = (l9) r1;
        if (r56 == null) goto L236;
        q2 r57 = r56.getLinkmicSubtitleSettingStatus();
        if (r57 == null) goto L237;
        Integer r58 = this.t;
        int r59 = r57.getSubtitleType();
        this.t = Integer.valueOf(r59);
        if (this.q == false) goto L195;
    L209:
        if (r58 == null) goto L213;
        int r60 = r58.intValue();
        if (r60 == r59) goto L213;
        s r61 = t.a;
        Integer r62 = je0.d.h();
        Integer r63 = Integer.valueOf(je0.d.f());
        List<Integer> r112 = je0.d.d();
        com.bytedance.android.live.liveinteract.plantform.utils.h r65 = TalkRoomLogUtils.b;
        t.h(u0.f(r62, r63, r112, Integer.valueOf(r65.a), null, null, 48), t.b(Integer.valueOf(r59)));
        t.e(null, u0.f(je0.d.h(), Integer.valueOf(je0.d.f()), je0.d.d(), Integer.valueOf(r65.a), null, null, 48), t.b(Integer.valueOf(r60)));
    L213:
        com.bytedance.android.livesdk.sharedpref.e r66 = b6.p0;
        IAudioSubtitleContent r67 = (IAudioSubtitleContent) r66.getValue();
        r67.setSubtitleStatus(r57);
        com.bytedance.android.livesdk.sharedpref.f.d(r66, r67);
        LinkmicSubtitleBusinessContext r68 = this.e;
        if (r68 != null) goto L216;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L216:
        r68.getLinkmicSubtitleSettingStatus().setValue(r57);
        int r69 = g0.a;
        if (g0.a(getRoom()) == false) goto L238;
        gr(r57, "update_position_from_playmode_im");
        return;
    L238:
        return;
    L195:
        if (isAnchor() == true) goto L209;
        LinkmicSubtitleBusinessContext.Companion.getClass();
        if (LinkmicSubtitleBusinessContext.a.c() == false) goto L209;
        if (hr() == false) goto L209;
        if (r57.getActivateStatus() != 1) goto L209;
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] guestEnterRoomReceiveWRDSIM");
        this.q = true;
        LinkmicSubtitleBusinessContext r70 = this.e;
        if (r70 != null) goto L205;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L205:
        r70.getStatus().setValue(LinkmicSubtitleStatus.OPEN);
        if (((Boolean) ((Widget) this).dataCenter.get("data_recover_from_online_float_window_start_subtitle", Boolean.FALSE)).booleanValue() == false) goto L208;
        Cq();
    L208:
        dr(true);
        Eq();
        Pq();
        goto L209
    L237:
        return;
    L236:
        return;
    L172:
        if (nd0.e.c() == true) goto L175;
        nd0.c.o(nd0.c.a, LinkMonitorData.ReceiveSubtitlePlaymodeMsgMonitorDataWithSample, r111, 0, null, false, 28);     // Catch: Exception -> L177
        goto L186
    L168:
        r55 = null;
        goto L169
    L164:
        r53 = null;
        goto L165
    L160:
        r51 = null;
    L177:
        StringBuilder r71 = new StringBuilder("receiveSubtitlePlaymodeMsg error, x=");
        q2 r72 = r48.getLinkmicSubtitleSettingStatus();
        if (r72 == null) goto L180;
        Double r73 = Double.valueOf(r72.getX());
    L181:
        r71.append(r73);
        r71.append(", y=");
        q2 r74 = r48.getLinkmicSubtitleSettingStatus();
        if (r74 == null) goto L184;
        Double r75 = Double.valueOf(r74.getY());
    L185:
        r71.append(r75);
        jy0.b.c("hjl-test", r71.toString(), null, 4);
        goto L186
    L184:
        r75 = null;
        goto L185
    L180:
        r73 = null;
        goto L181
    L235:
        return;
    }

    @Override // nj0.b
    public final void sd(String r6) {
        Intrinsics.checkNotNullParameter(r6, "json");
        LinkmicSubtitleBusinessContext r1 = this.e;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L6:
        if (((LinkmicSubtitleStatus) r1.getStatus().getValue()) == LinkmicSubtitleStatus.OPEN) goto L8;
        return;
    L8:
        if (isAnchor() == true) goto L37;
        LinkmicSubtitleBusinessContext.Companion.getClass();
        if (LinkmicSubtitleBusinessContext.a.c() == false) goto L38;
        Boolean r2 = Iq();
        Boolean r3 = Boolean.FALSE;
        if (Intrinsics.areEqual(r2, r3) == false) goto L39;
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.b(r6) == true) goto L16;
    L32:
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.e(r6);
        return;
    L16:
        if (vm2.d.u() == true) goto L18;
    L34:
        String r4 = JSONObjectProtectorUtils.getString(LiveSeiUtil.c(r6), "audio_subtitle");     // Catch: Exception -> L31
        if (r4 == null) goto L40;
        String r5 = JSONObjectProtectorUtils.getString(new JSONObject(r4), "subtitles");     // Catch: Exception -> L31
        if (r5 != null) goto L25;
        return;
    L25:
        if (Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.h).get("subtitleEmpty"), Boolean.TRUE) == true) goto L27;
    L29:
        er(g0.e(r5, Bq()));     // Catch: Exception -> L31
        return;
    L27:
        if (Kq() == true) goto L29;
        this.h.put("subtitleEmpty", r3);     // Catch: Exception -> L31
        Eq();     // Catch: Exception -> L31
        goto L29
    L40:
        return;
    L31:
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.e(r6);
        return;
    L18:
        if (g0.d(r6) == true) goto L34;
    L39:
        return;
    L38:
        return;
    }

    public final void y1(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void z2(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public static void gr(q2 r4, String r5) {
        StringBuilder r0 = new StringBuilder("[AudioSubtitle] updateSubtitleStyleAndPosition, LinkmicSubtitleUIContext=");
        LinkmicSubtitleUIContext.a r1 = LinkmicSubtitleUIContext.Companion;
        r0.append(r1.a());
        ALogger.i("LinkmicSubtitleBusinessWidget", r0.toString());
        nj0.f r2 = r1.a();
        if (r2 == null) goto L5;
        r2.dk(r4.getSubtitleStyle());
    L5:
        nj0.f r3 = r1.a();
        if (r3 == null) goto L9;
        r3.ic((float) r4.getX(), (float) r4.getY(), r5);
        return;
    }

    public final void C2(long r1, ExtraResponse<? extends IJoinChannelResult, Extra> r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    public final void F2(long r1, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
    }

    public final void Fk(long r1, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
    }

    public final void I2(ei6.a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "client");
        Intrinsics.checkNotNullParameter(r3, "source");
        vb6.f.a.b(r2, r3);
    }

    public final void U8(long r1, ExtraResponse<IApplyResult, Extra> r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    public final void Wb(long r1, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
    }

    public final void Xf(long r1, ExtraResponse<? extends g1, Extra> r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    public final void Zk(long r1, ei6.a r3) {
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r3, "client");
    }

    public final void bp(long r1, ExtraResponse<LinkFinishResult, Extra> r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    public final void lf(long r1, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
    }

    public final void o1(long r1, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
    }

    public final void t5(ec6.a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "client");
        Intrinsics.checkNotNullParameter(r3, "source");
        vb6.f.a.a(r2, r3);
    }

    public final void u4(long r1, ec6.a r3) {
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r3, "client");
    }

    public final void uf(long r1, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
    }

    public final void wn(long r1, ExtraResponse<com.bytedance.android.livesdk.chatroom.model.interact.m, Extra> r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    public final void yp(long r1, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
    }

    public static void Lq(String r7, String r8, String r9) {
        s r0 = t.a;
        Intrinsics.checkNotNullParameter(r7, "requestPage");
        Intrinsics.checkNotNullParameter(r9, "subtitleType");
        LinkedHashMap r1 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r1, null, null, 6);
        t.i(r1);
        if (r8 == null) goto L5;
        r1.put("enlarge_show_type", r8);
    L5:
        r1.put("request_page", r7);
        s r2 = t.a;
        r2.getClass();
        r1.put("duration", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - r2.a)));
        r1.put("caption_type", r9);
        r1.put("play_mode", u0.b());
        if (r2.a == 0) goto L8;
        j0.l().sendLog("livesdk_audience_voiceroom_caption_use_duration", r1, new Object[]{IRoom.class});
    L8:
        t.e(r7, r8, r9);
    }

    @Override // nj0.b
    public final void N5(IAudioSubtitleContent r14, UpdateSubtitleType r15, nj0.c r16) {
        Intrinsics.checkNotNullParameter(r14, "content");
        Intrinsics.checkNotNullParameter(r15, "updateType");
        Gson r0 = com.bytedance.android.live.liveinteract.animation.universalwidget.utils.a.a;
        if (r0 == null) goto L6;
        String r1 = GsonProtectorUtils.toJson(r0, r14);
        if (r1 == null) goto L6;
    L7:
        String r8 = r1;
        long r9 = System.currentTimeMillis();
        Disposable r2 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateAudioSubtitleSetting(getRoom().getId(), r8, r15.ordinal()).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this, r16, r15, r14, r8, r9), new g(this, r16, r8, r9));
        this.a.add(r2);
        return;
    L6:
        r1 = "";
        goto L7
    }

    @Override // nj0.b
    public final void anchorAudioSubtitleSwitchSetting(boolean r3, String r4, nj0.c r5) {
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        Intrinsics.checkNotNullParameter(r5, "listener");
        if (r3 == false) goto L5;
        s r6 = t.a;
        r6.getClass();
        Intrinsics.checkNotNullParameter("manual", "<set-?>");
        r6.e = "manual";
    L6:
        IAudioSubtitleContent r7 = (IAudioSubtitleContent) b6.p0.getValue();
        if (r3 == false) goto L9;
        int r0 = IAudioSubtitleContent.SwitchStatus.SWITCH_ON.getValue();
    L10:
        r7.setStatus(r0);
        vh7.c r8 = jm2.a.d(r7);
        if (r8 == null) goto L15;
        N5((IAudioSubtitleContent) r8, UpdateSubtitleType.UNKNOWN, r5);
        t.c(r3);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent");
    L9:
        r0 = IAudioSubtitleContent.SwitchStatus.SWITCH_OFF.getValue();
        goto L10
    L5:
        s r1 = t.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r1.f = r4;
        goto L6
    }

    public final void vc(ei6.a r7, final int r8, long r9, final Object... r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        UtilityKotlinExtentionsKt.s(0, false, false, new LinkmicSubtitleBusinessWidget$onRtcInfo$1(this, r8, r11), 7);
    }
}

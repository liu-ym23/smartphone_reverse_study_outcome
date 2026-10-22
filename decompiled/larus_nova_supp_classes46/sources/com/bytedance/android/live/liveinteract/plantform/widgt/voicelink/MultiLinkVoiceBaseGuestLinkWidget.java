package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import am2.x;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.banner.BannerWidget;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkResultDialogFragment;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkResultDialogFragmentV2;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.interactivesong.logger.InteractiveSongLoggerKt;
import com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.api.LinkPaidLinkApi;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.v;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.live.liveinteract.voicechat.dialog.AudioTalkBeInvitedDialogV2;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.liveinteract.widget.widget.ChatRoomGuestAppliedDialog;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.soloktv.IPlatformSoloKtvService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.AudienceLeaveSourceEnum;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.interact.b1;
import com.bytedance.android.livesdk.chatroom.model.interact.j1;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.bizlink.api.business.anchor2guest.base.BizLinkServiceType;
import com.bytedance.live.bizlink.impl.platform.manager.MultiLinkGuestManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import w20.xc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/widgt/voicelink/MultiLinkVoiceBaseGuestLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/widgt/MultiLinkBaseGuestLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "Lcom/bytedance/android/live/liveinteract/plantform/widgt/voicelink/b;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class MultiLinkVoiceBaseGuestLinkWidget extends MultiLinkBaseGuestLinkWidget<ILinkPlayerInfoBridge> implements com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b {
    public boolean A;
    public final String B;
    public KtvMusic C;
    public String D;
    public String E;
    public g0 F;
    public IMessageBoardInfo G;
    public com.bytedance.android.live.liveinteract.plantform.model.f H;
    public com.bytedance.android.live.liveinteract.voicechat.util.k I;
    public boolean J;
    public boolean K;
    public GuestTalkBeInvitedDialog L;
    public com.bytedance.android.live.liveinteract.widget.widget.q M;
    public ChatMatchWidget N;
    public VoiceChatMuteManager O;
    public uf0.d P;
    public uf0.c Q;
    public boolean R;
    public final CompositeDisposable S;
    public LinkResultDialogFragmentV2 T;
    public Disposable U;
    public com.bytedance.android.live.pushstream.d s;
    public m00.h t;
    public v u;
    public ne0.c v;
    public String w;
    public LinkApplyType x;
    public long y;
    public boolean z;

    public static final class a {
    }

    public static final class b extends vb6.a {
        public final /* synthetic */ MultiLinkVoiceBaseGuestLinkWidget a;

        public b(MultiLinkVoiceBaseGuestLinkWidget r1) {
            this.a = r1;
        }

        public final void Zk(long r1, ei6.a r3) {
            Intrinsics.checkNotNullParameter(r3, "client");
            hg6.g r2 = this.a.P2();
            if (r2 == null) goto L6;
            r2.p(this.a);
            return;
        }
    }

    public static final class c implements com.bytedance.android.live.liveinteract.widget.widget.a {
        public final /* synthetic */ MultiLinkVoiceBaseGuestLinkWidget a;

        @Override // com.bytedance.android.live.liveinteract.widget.widget.a
        public final void show() {
            ChatMatchWidget r0 = this.a.N;
            if (r0 == null) goto L6;
            r0.zq(null, true, "", Boolean.FALSE);
            return;
        }

        public c(MultiLinkVoiceBaseGuestLinkWidget r1) {
            this.a = r1;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceBaseGuestLinkWidget a;
        public final /* synthetic */ g1 b;
        public final /* synthetic */ BannerWidget.a c;

        public d(MultiLinkVoiceBaseGuestLinkWidget r1, g1 r2, e r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            Long r8 = (Long) r7;
            FragmentActivity r9 = ((Widget) this.a).context;
            if (r9 == null) goto L19;
            FragmentManager r10 = r9.getSupportFragmentManager();
            LinkResultDialogFragment.l.getClass();
            String r1 = LinkResultDialogFragment.k;
            if (r10.findFragmentByTag(r1) != null) goto L17;
            MultiLinkVoiceBaseGuestLinkWidget r11 = this.a;
            LinkResultDialogFragmentV2.a r2 = LinkResultDialogFragmentV2.u;
            g1 r3 = this.b;
            AudienceLeaveSourceEnum r4 = AudienceLeaveSourceEnum.AudienceLeave_Leave;
            BannerWidget.a r5 = this.c;
            r2.getClass();
            r11.T = LinkResultDialogFragmentV2.a.a(r3, r4, r5);
            MultiLinkVoiceBaseGuestLinkWidget r12 = this.a;
            LinkResultDialogFragmentV2 r6 = r12.T;
            if (r6 == null) goto L23;
            FragmentActivity r13 = ((Widget) r12).context;
            if (r13 == null) goto L16;
            FragmentManager r14 = r13.getSupportFragmentManager();
            LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, r1, r0);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r14, r6, r0) == true) goto L25;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
        L14:
            r6.showNow(r14, r1);
            return;
        L25:
            return;
        L16:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        L23:
            return;
        L17:
            return;
        L19:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public static final class e implements BannerWidget.a {
        public final /* synthetic */ MultiLinkVoiceBaseGuestLinkWidget a;
        public final /* synthetic */ g1 b;

        @Override // com.bytedance.android.live.liveinteract.banner.BannerWidget.a
        public final boolean a() {
            return true;
        }

        public e(MultiLinkVoiceBaseGuestLinkWidget r1, g1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.live.liveinteract.banner.BannerWidget.a
        public final void b(boolean r10, Map<String, String> r11) {
            g1 r0 = this.b;
            Intrinsics.checkNotNull(r0);
            IRoom r1 = this.a.getMRoom();
            Intrinsics.checkNotNull(r1);
            MultiLinkVoiceBaseGuestLinkWidget r12 = this.a;
            TalkRoomLogUtils.f0(r0, r1, r12.E, d5.b(r12.w), this.a.Nq(), this.a.Mq(), r10, je0.d.Z(), this.a.x);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceBaseGuestLinkWidget a;
        public final /* synthetic */ h1 b;
        public final /* synthetic */ g c;

        public f(MultiLinkVoiceBaseGuestLinkWidget r1, h1 r2, g r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            Long r8 = (Long) r7;
            FragmentActivity r9 = ((Widget) this.a).context;
            if (r9 == null) goto L19;
            FragmentManager r10 = r9.getSupportFragmentManager();
            LinkResultDialogFragment.l.getClass();
            String r1 = LinkResultDialogFragment.k;
            if (r10.findFragmentByTag(r1) != null) goto L17;
            MultiLinkVoiceBaseGuestLinkWidget r11 = this.a;
            LinkResultDialogFragmentV2.a r2 = LinkResultDialogFragmentV2.u;
            LinkerSysKickOutContent r3 = this.b.getMLinkerSysKickOutContent();
            AudienceLeaveSourceEnum r4 = AudienceLeaveSourceEnum.AudienceLeave_Sys_Kick_Out;
            g r5 = this.c;
            r2.getClass();
            r11.T = LinkResultDialogFragmentV2.a.c(r3, r4, r5);
            MultiLinkVoiceBaseGuestLinkWidget r12 = this.a;
            LinkResultDialogFragmentV2 r6 = r12.T;
            if (r6 == null) goto L23;
            FragmentActivity r13 = ((Widget) r12).context;
            if (r13 == null) goto L16;
            FragmentManager r14 = r13.getSupportFragmentManager();
            LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, r1, r0);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r14, r6, r0) == true) goto L25;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
        L14:
            r6.showNow(r14, r1);
            return;
        L25:
            return;
        L16:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        L23:
            return;
        L17:
            return;
        L19:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public static final class g implements BannerWidget.a {
        public final /* synthetic */ MultiLinkVoiceBaseGuestLinkWidget a;

        @Override // com.bytedance.android.live.liveinteract.banner.BannerWidget.a
        public final boolean a() {
            return true;
        }

        public g(MultiLinkVoiceBaseGuestLinkWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.banner.BannerWidget.a
        public final void b(boolean r11, Map<String, String> r12) {
            IRoom r1 = this.a.getMRoom();
            MultiLinkVoiceBaseGuestLinkWidget r2 = this.a;
            TalkRoomLogUtils.e0(null, r1, r2.E, d5.b(r2.w), this.a.Nq(), this.a.Mq(), r11, je0.d.Z(), this.a.x, r12);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceBaseGuestLinkWidget a;

        public h(MultiLinkVoiceBaseGuestLinkWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r20) {
            com.bytedance.android.livesdk.chatroom.model.interact.h1 r1 = (com.bytedance.android.livesdk.chatroom.model.interact.h1) ((com.bytedance.android.live.network.response.e) r20).data;
            if (r1.getPaidCount() == null) goto L6;
            com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.c.u;
            Long r3 = r1.getPaidCount();
            Intrinsics.checkNotNull(r3);
            Integer r4 = Integer.valueOf((int) r3.longValue());
            r2.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r2, r4);
        L6:
            if (r1.getLimitedTime() == null) goto L8;
            com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.c.v;
            Long r6 = r1.getLimitedTime();
            Intrinsics.checkNotNull(r6);
            Integer r7 = Integer.valueOf((int) r6.longValue());
            r5.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r5, r7);
        L8:
            ArrayList r8 = new ArrayList();
            List r9 = r1.getPaidTags();
            Intrinsics.checkNotNull(r9);
            Iterator r10 = r9.iterator();
        L10:
            if (r10.hasNext() == false) goto L15;
            String r11 = ((j1) r10.next()).getName();
            if (r11 != null) goto L14;
            r11 = "";
        L14:
            r8.add(r11);
            goto L10
        L15:
            b1 r12 = (b1) com.bytedance.android.livesdk.sharedpref.c.g1.getValue();
            r12.setSavedTagInfos(r1.getPaidTags());
            String r13 = r1.getPaidDesc();
            Intrinsics.checkNotNull(r13);
            r12.setSavedDesc(r13);
            boolean r14 = false;
            this.a.Tq(false);
            Context r15 = ((Widget) this.a).context;
            Long r16 = r1.getPaidCount();
            Intrinsics.checkNotNull(r16);
            int r17 = (int) r16.longValue();
            Long r18 = r1.getLimitedTime();
            Intrinsics.checkNotNull(r18);
            int r19 = (int) r18.longValue();
            List r21 = CollectionsKt.toList(r8);
            String r22 = r1.getPaidDesc();
            int r23 = fj0.e.a;
            Intrinsics.checkNotNullParameter(r15, "context");
            Intrinsics.checkNotNullParameter("voice_live", "type");
            String r24 = vm2.d.l().applyLinkSchema;
            if (TextUtils.isEmpty(r24) == true) goto L41;
            HashMap r25 = new HashMap();
            r25.put("live_type", "voice_live");
            r25.put("paid_count", String.valueOf(r17));
            r25.put("limit_time", String.valueOf(r19));
            r25.put("reason_required", String.valueOf(((Number) com.bytedance.android.livesdk.sharedpref.c.r.getValue()).intValue()));
            r25.put("reason_template_manual", com.bytedance.android.livesdk.sharedpref.c.s.getValue());
            r25.put("reason_template_default", com.bytedance.android.livesdk.sharedpref.c.t.getValue());
            if (r21 == null) goto L20;
            String r26 = CollectionsKt.joinToString$default(r21, "|", null, null, 0, null, null, 62, null);
        L22:
            if (String.valueOf(r26).length() <= 0) goto L24;
            boolean r27 = true;
        L25:
            if (r27 == false) goto L27;
            r25.put("linkmic_tag", String.valueOf(r26));
        L27:
            if (r22 == null) goto L34;
            if (r22.length() <= 0) goto L31;
            r14 = true;
        L31:
            if (r14 != true) goto L34;
            r25.put("paid_desc", r22);
        L34:
            if (fj0.e.e() == false) goto L36;
            r25.put("live_anonymous_paid_link_mic", "1");
        L36:
            TalkRoomLogUtils.B0(r25, null, null, 6);
            String r28 = y0.b(r24, r25);
            ALogger.i("ttlive_link_paid", "applySchema = " + r28);
            jc1.k.n(IBaseLiveActionHandler.class).handle(r15, r28);
            return;
        L24:
            r27 = false;
            goto L25
        L20:
            r26 = null;
            goto L22
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceBaseGuestLinkWidget a;

        public i(MultiLinkVoiceBaseGuestLinkWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            this.a.Tq(false);
            ALogger.e("ttlive_link_paid", "getPaidInfoBeforeApply failed " + ((Throwable) r4).getMessage());
            f2.b(2131917082, 0);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final int Cq() {
        return 8;
    }

    public abstract int Mq();

    public abstract tf0.o Qq();

    public final void Tq(boolean r1) {
    }

    public yf6.b Yq() {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public int getScene() {
        return 8;
    }

    public void B() {
        ChatRoomGuestAppliedDialog r0 = new ChatRoomGuestAppliedDialog(((Widget) this).context, ((Widget) this).dataCenter, new c(this));
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r0);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
    }

    public final VoiceChatMuteManager Pq() {
        VoiceChatMuteManager r0 = this.O;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onCreate() {
        multiLinkRoomScopeFallback();
        Iq("onCreate");
        sg6.b r1 = xq();
        if (r1 == null) goto L5;
        r1.b(Kq(), ((Widget) this).context);
    L5:
        super.onCreate();
        m00.h r2 = this.t;
        if ((r2 instanceof v0) == true) goto L8;
        r2 = null;
    L8:
        v0 r3 = (v0) r2;
        if (r3 == null) goto L13;
        yf6.b r4 = Yq();
        if (r4 == null) goto L13;
        r4.i9(gc6.b.c(r3, null));
    L13:
        hg6.g r5 = P2();
        if (r5 == null) goto L18;
        xi0.b r6 = r5.O();
        if (r6 == null) goto L18;
        r6.p(this);
    L18:
        fj0.b.a.b = false;
        mz0.f r7 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if ((r7 instanceof mz0.f) == false) goto L104;
        mz0.f r8 = r7;
        String r9 = r8.m();
        if (TextUtils.isEmpty(r9) == true) goto L24;
        this.w = r9;
    L24:
        if (TextUtils.isEmpty(this.w) == false) goto L26;
        int r10 = bh0.a.a;
        String r11 = String.valueOf(com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_CANCELED_BY_SERVER);
    L27:
        String r12 = r8.d();
        int r13 = r8.getApplyType();
        sf0.a r15 = new sf0.a(-1, d5.b(r11), r13, 0, null, null, null, 0, 0, 0, false, false, 0, null, null, 0, 524280);
        if (r12 != null) goto L30;
    L42:
        String r14 = r8.l();
        String r16 = r8.e();
        if (r16 != null) goto L45;
        r16 = "";
    L45:
        String r17 = r8.k();
        String r18 = r8.f();
        if (r18 != null) goto L48;
        String r19 = "";
    L50:
        if (TextUtils.equals(r16, "") == true) goto L54;
        if (TextUtils.equals(r16, "apply") == true) goto L54;
    L58:
        boolean r24 = false;
    L59:
        boolean r20 = qi0.e.c();
        if (r24 == true) goto L84;
        if (r20 == false) goto L70;
        com.bytedance.live.datacontext.m r21 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r21 == null) goto L70;
        IRoom r22 = (IRoom) r21.getValue();
        if (r22 == null) goto L70;
        if (r22.isPrivatePlay() == true) goto L84;
    L70:
        if (TextUtils.equals(r16, "reply") == false) goto L104;
        if (TextUtils.equals(r14, "true") == false) goto L104;
        if (((Boolean) ((Widget) this).dataCenter.get("data_strong_reach_auto_apply_already", Boolean.FALSE)).booleanValue() == true) goto L104;
        ((Widget) this).dataCenter.put("data_strong_reach_auto_apply_already", Boolean.TRUE);
        jy0.b.f("ttlive_link", "voice_auto_linkmic from " + this.w + ' ' + r13, null, 4);
        cg6.a r23 = Bq();
        if (r23 == null) goto L104;
        MultiLinkGuestManager r25 = r23.W4();
        if (r25 == null) goto L104;
        IRoom r26 = getMRoom();
        Intrinsics.checkNotNull(r26);
        long r110 = r26.getRoomId();
        if (r17 != null) goto L82;
        String r111 = "";
    L83:
        r25.j(new sf0.e(r110, r111, r19, ReplyType.Agree.ordinal(), 0, 48, 0));
        goto L104
    L82:
        r111 = r17;
    L84:
        DataCenter r27 = ((Widget) this).dataCenter;
        Boolean r28 = Boolean.TRUE;
        r27.put("data_strong_reach_auto_apply_already", r28);
        jy0.b.f("ttlive_link", "voice_auto_linkmic from " + this.w + ' ' + r13, null, 4);
        Intrinsics.checkNotNullParameter("voice_auto_linkmic", "<set-?>");
        r15.h = "voice_auto_linkmic";
        if (isKtvOn() == false) goto L90;
        if (r13 <= 0) goto L88;
        int r112 = r13;
    L89:
        r15.c = r112;
    L94:
        DataCenter r29 = ((Widget) this).dataCenter;
        if (r29 == null) goto L97;
        Boolean r30 = (Boolean) r29.get("cmd_open_paid_link_setting_panel_after_fetch_audience_setting", Boolean.FALSE);
    L99:
        if (Intrinsics.areEqual(r30, r28) == false) goto L101;
        Wq(r15);
        goto L104
    L101:
        Disposable r31 = Observable.timer(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.i(this, r15));
        this.U = r31;
        if (r31 == null) goto L104;
        this.S.add(r31);
        goto L104
    L97:
        r30 = null;
        goto L99
    L88:
        r112 = LinkApplyType.NORMAL.getValue();
        goto L89
    L90:
        if (r13 <= 0) goto L92;
        int r113 = r13;
    L93:
        r15.c = r113;
        goto L94
    L92:
        r113 = LinkApplyType.STRONG_REACH.getValue();
    L54:
        if (TextUtils.equals(r14, "true") == false) goto L58;
        if (((Boolean) ((Widget) this).dataCenter.get("data_strong_reach_auto_apply_already", Boolean.FALSE)).booleanValue() == true) goto L58;
        r24 = true;
        goto L59
    L48:
        r19 = r18;
        goto L50
    L30:
        if (TextUtils.equals(r12, "true") == false) goto L42;
        jy0.b.f("ttlive_link", "voice_auto_apply from " + this.w + ' ' + r13, null, 4);
        Intrinsics.checkNotNullParameter("voice_auto_apply", "<set-?>");
        r15.h = "voice_auto_apply";
        if (isKtvOn() == false) goto L37;
        if (r13 <= 0) goto L35;
        int r114 = r13;
    L36:
        r15.c = r114;
    L41:
        Wq(r15);
        goto L104
    L35:
        r114 = LinkApplyType.CITYSONG.getValue();
        goto L36
    L37:
        if (r13 <= 0) goto L39;
        int r115 = r13;
    L40:
        r15.c = r115;
        goto L41
    L39:
        r115 = LinkApplyType.CITY.getValue();
        goto L40
    L26:
        r11 = this.w;
        Intrinsics.checkNotNull(r11);
    L104:
        this.E = TalkRoomLogUtils.k;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void onStart() {
        if (this.u == null) goto L5;
        md().n0(this.u);
    L5:
        super.onStart();
    }

    private final boolean isKtvOn() {
        if (je0.d.f() != 9) goto L5;
        return true;
    L5:
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).I1();
        if (r0 == null) goto L10;
        Boolean r1 = (Boolean) r0.getValue();
        if (r1 == null) goto L10;
        return r1.booleanValue();
    L10:
        return false;
    }

    public final int C0() {
        if (isKtvOn() == false) goto L11;
        Integer r0 = je0.d.h();
        if (r0 != null) goto L8;
    L10:
        return 9;
    L8:
        if (r0.intValue() != 61) goto L10;
        return -1;
    L11:
        tf0.o r1 = Qq();
        if (r1 != null) goto L18;
        return 0;
    L18:
        return r1.C0();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void H1() {
        super.H1();
        ChatMatchWidget r0 = this.N;
        if (r0 == null) goto L6;
        r0.H1();
        return;
    }

    public int Lq() {
        ILinkPlayerInfoBridge r0 = Aq().p(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getSilenceStatus();
    }

    public final boolean Nq() {
        yf6.b r0 = Yq();
        if (r0 == null) goto L7;
        vf6.a r1 = r0.a9();
        if (r1 == null) goto L7;
        return r1.a;
    L7:
        return false;
    }

    public final void Sq() {
        if (vm2.d.i0() == false) goto L28;
        Context r0 = ((Widget) this).context;
        String r1 = this.w;
        Intrinsics.checkNotNull(r1);
        int r2 = fj0.e.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r1, "applySource");
        Intrinsics.checkNotNullParameter("voice_live", "type");
        String r3 = vm2.d.l().applyLinkSchema;
        if (TextUtils.isEmpty(r3) == true) goto L26;
        HashMap r4 = new HashMap();
        String r5 = u0.j(je0.d.h());
        if (r5 == null) goto L9;
        r4.put("layout_type", r5);
    L9:
        r4.put("function_type2", TalkRoomLogUtils.h);
        r4.put("live_type", "voice_live");
        int r6 = bh0.a.a;
        if (Intrinsics.areEqual(r1, String.valueOf(101)) == false) goto L13;
        r4.put("request_page", "seat");
    L25:
        TalkRoomLogUtils.B0(r4, null, null, 6);
        String r7 = y0.b(r3, r4);
        ALogger.i("ttlive_link_paid", "applySchema = " + r7);
        jc1.k.n(IBaseLiveActionHandler.class).handle(r0, r7);
        goto L26
    L13:
        if (Intrinsics.areEqual(r1, String.valueOf(102)) == false) goto L16;
        r4.put("request_page", "bottom");
        goto L25
    L16:
        if (Intrinsics.areEqual(r1, String.valueOf(113)) == false) goto L19;
        r4.put("request_page", "card");
        goto L25
    L19:
        if (Intrinsics.areEqual(r1, String.valueOf(114)) == false) goto L22;
        r4.put("request_page", "live_song");
        goto L25
    L22:
        if (tc0.c.h().J == 114) goto L24;
        r4.put("request_page", "");
        goto L25
    L24:
        r4.put("request_page", "live_song");
    L26:
        Tq(false);
        MultiLinkEventModule r8 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a;
        String r9 = this.w;
        Intrinsics.checkNotNull(r9);
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.c(r9);
        return;
    L28:
        LinkPaidLinkApi r10 = (LinkPaidLinkApi) com.bytedance.android.live.network.c.b().e(LinkPaidLinkApi.class);
        IRoom r11 = getMRoom();
        Intrinsics.checkNotNull(r11);
        this.S.add(r10.getPaidInfoBeforeApply(r11.getId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this), new i(this)));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onDestroy() {
        sg6.b r0 = xq();
        Fragment r1 = null;
        if (r0 == null) goto L5;
        r0.j(null);
    L5:
        i0 r2 = TalkRoomLogUtils.a;
        String r3 = this.E;
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        TalkRoomLogUtils.k = r3;
        if (this.S.isDisposed() == true) goto L11;
        this.S.dispose();
    L11:
        GuestTalkBeInvitedDialog r4 = this.L;
        if (r4 != null) goto L14;
    L22:
        this.T = null;
        Context r5 = ((Widget) this).context;
        if ((r5 instanceof FragmentActivity) == true) goto L25;
        r5 = null;
    L25:
        FragmentActivity r6 = (FragmentActivity) r5;
        if (r6 == null) goto L30;
        FragmentManager r7 = r6.getSupportFragmentManager();
        if (r7 == null) goto L30;
        LinkResultDialogFragment.l.getClass();
        Fragment r8 = r7.findFragmentByTag(LinkResultDialogFragment.k);
    L32:
        if ((r8 instanceof DialogFragment) == false) goto L35;
        r1 = r8;
    L35:
        DialogFragment r9 = (DialogFragment) r1;
        if (r9 != null) goto L47;
    L43:
        super.onDestroy();
        return;
    L47:
        r9.dismissAllowingStateLoss();     // Catch: Exception -> L39
    L39:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r10 = DialogFragmentLancet.sLastShowStack;
        if (r10 == null) goto L43;
        com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L30:
        r8 = null;
        goto L32
    L14:
        if (r4.isShowing() != true) goto L22;
        GuestTalkBeInvitedDialog r11 = this.L;
        Intrinsics.checkNotNull(r11);
        r11.dismiss();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r12 = DialogFragmentLancet.sLastShowStack;
        if (r12 == null) goto L22;
        com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L22
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b
    public final v s0() {
        return md().s0();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final y zq() {
        return Aq();
    }

    public BizLinkServiceType Kq() {
        return BizLinkServiceType.VoiceGuest;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b
    public final m00.h Tj() {
        return this.t;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b
    public final com.bytedance.android.live.pushstream.d Xh() {
        return this.s;
    }

    public MultiLinkVoiceBaseGuestLinkWidget(tc0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "dataHolder");
        super(r2);
        this.B = "";
        this.S = new CompositeDisposable();
    }

    public void H0(z0 r6) {
        Intrinsics.checkNotNullParameter(r6, MultiLinkOpenSource.MESSAGE);
        this.J = true;
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (this.R == false) goto L7;
        return;
    L7:
        if (this.s == null) goto L25;
        cg6.a r0 = Bq();
        if (r0 == null) goto L21;
        jg6.a r1 = r0.e5();
        if (r1 == null) goto L21;
        kg6.e r2 = r1.b();
        if (r2 == null) goto L21;
        if (je0.d.G() == false) goto L17;
    L19:
        boolean r3 = false;
    L20:
        r2.t(new kg6.b(true, r3, "kickout", 8));
        goto L21
    L17:
        if (je0.d.p() == true) goto L19;
        r3 = true;
    L21:
        ((Widget) this).dataCenter.put("data_self_is_silenced", Boolean.TRUE);
        VoiceChatMuteManager r7 = this.O;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L24:
        r7.i = System.currentTimeMillis();
    L25:
        ((Widget) this).dataCenter.put("data_talk_room_capture_audio_notification_show_state", Boolean.FALSE);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void H4(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        IPlatformSoloKtvService r3 = jc1.k.f(IPlatformSoloKtvService.class);
        if (r3 == null) goto L6;
        r3.onGuestLinkPermit();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b
    public final void Jc(m00.h r4) {
        this.t = r4;
        yf6.b r0 = Yq();
        if (r0 == null) goto L12;
        ec6.a r2 = null;
        if ((r4 instanceof v0) == true) goto L7;
        r4 = null;
    L7:
        v0 r5 = (v0) r4;
        if (r5 == null) goto L10;
        r2 = gc6.b.c(r5, null);
    L10:
        r0.i9(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b
    public final void Nl(com.bytedance.android.live.pushstream.d r1) {
        this.s = r1;
    }

    public void O(sf0.a r7) {
        Intrinsics.checkNotNullParameter(r7, "applyParams");
        int r0 = com.bytedance.android.live.liveinteract.utils.h1.a;
        ne0.c r1 = this.v;
        Context r2 = ((Widget) this).context;
        DataCenter r3 = ((Widget) this).dataCenter;
        int r4 = r7.a;
        String r5 = String.valueOf(r7.b);
        LinkApplyType r8 = com.bytedance.android.live.liveinteract.api.chatroom.model.a.a(r7.c);
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r8, "applyType");
        if (r1 == null) goto L6;
        r1.d0(mi0.c.b, new mi0.d(r4, r5, r8));
        return;
    }

    public void P(h1 r5) {
        Intrinsics.checkNotNullParameter(r5, MultiLinkOpenSource.MESSAGE);
        g r0 = new g(this);
        LinkResultDialogFragmentV2.u.getClass();
        RxUtilKt.c(RxUtilKt.h(Observable.timer(LinkResultDialogFragmentV2.s, TimeUnit.MILLISECONDS)).subscribe(new f(this, r5, r0)), this.S);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void P8(final com.bytedance.android.live.liveinteract.multianchor.model.b r5) {
        Intrinsics.checkNotNullParameter(r5, "linkMicMessage");
        i97.a r1 = i97.a.a;
        this.y = System.currentTimeMillis();
        com.bytedance.android.live.liveinteract.plantform.model.e r2 = r5.getGameInviteInfo();
        if (r2 == null) goto L8;
        if (r2.isGameInvite() != true) goto L8;
        this.E = "game_invite";
    L11:
        fj0.b.a.b = false;
        if (((Boolean) vm2.d.B1.getValue(null, vm2.d.a[129(0x81, float:1.81E-43)])).booleanValue() == false) goto L14;
        int r3 = AudioTalkBeInvitedDialogV2.t;
        IRoom r4 = getMRoom();
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r5, "linkMicMessage");
        GuestTalkBeInvitedDialog r0 = new AudioTalkBeInvitedDialogV2();
        r0.i = r4;
        r0.j = r5;
    L15:
        this.L = r0;
        r0.p = new MultiLinkVoiceBaseGuestLinkWidget$onReceiveInvitation$1(this, r5);
        int r6 = com.bytedance.android.live.broadcastgame.api.g.a;
        FragmentActivity r7 = com.bytedance.android.live.broadcastgame.api.g.a(((Widget) this).context);
        if (r7 == null) goto L28;
        GuestTalkBeInvitedDialog r8 = this.L;
        if (r8 == null) goto L29;
        FragmentManager r9 = r7.getSupportFragmentManager();
        LandscapeRestrictionOperation r10 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, "GuestTalkBeInvitedDialog", r10);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r9, r8, r10) == true) goto L30;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L23:
        r8.show(r9, "GuestTalkBeInvitedDialog");
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L14:
        int r11 = GuestTalkBeInvitedDialog.q;
        IRoom r12 = getMRoom();
        Intrinsics.checkNotNull(r12);
        Intrinsics.checkNotNullParameter(r12, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r5, "linkMicMessage");
        r0 = new GuestTalkBeInvitedDialog();
        r0.i = r12;
        r0.j = r5;
    L8:
        if (r5.getMessageBoardInfo() == null) goto L10;
        this.E = "gift_message_invite";
        this.G = r5.getMessageBoardInfo();
        goto L11
    L10:
        this.E = "invite";
        goto L11
    }

    public v0 Q0(String r3) {
        m00.h r4 = ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).createVoiceRoomVideoView(((Widget) this).context, r3);
        m00.h r1 = null;
        if ((r4 instanceof v0) == true) goto L5;
        r4 = null;
    L5:
        m00.h r5 = (v0) r4;
        if ((r5 instanceof m00.h) == false) goto L9;
        r1 = r5;
    L9:
        m00.h r2 = r1;
        this.t = r2;
        Intrinsics.checkNotNull(r2);
        this.s = r2.getLiveStream();
        return r5;
    }

    public final void Wq(sf0.a r12) {
        Intrinsics.checkNotNullParameter(r12, "applyParams");
        tf0.o r0 = Qq();
        if (r0 == null) goto L5;
        r0.p();
    L5:
        this.w = String.valueOf(r12.b);
        boolean r6 = true;
        if (this.I == null) goto L16;
        IRoom r1 = getMRoom();
        LinkedHashMap r7 = new LinkedHashMap();
        if (r1 != null) goto L10;
    L14:
        r7.put("audience_connection_type", "voice");
        j0 r2 = j0.l();
        x r9 = new x();
        r9.b = "live_detail";
        r9.a = "live";
        r9.e = "click";
        r2.sendLog("audience_connection_apply", r7, new Object[]{r9, x.class, IRoom.class});
        goto L16
    L10:
        if (r1.getStreamType() != LiveMode.AUDIO) goto L12;
        String r3 = "radio";
    L13:
        r7.put("room_type", r3);
        goto L14
    L12:
        r3 = "video";
    L16:
        if (TextUtils.equals(r12.g, "linkin_empty_stub_click") == true) goto L18;
    L43:
        fj0.a r4 = fj0.b.a;
        if (r12.j > 0) goto L47;
        r6 = false;
    L47:
        r4.b = r6;
        boolean r5 = r12.m;
        int r8 = r12.n;
        r4.g = r5;
        r4.h = r8;
        xc.a r10 = r12.p;
        if (r10 == null) goto L52;
        Intrinsics.checkNotNull(r10);
        if (r10.a() == null) goto L52;
        xc.a r11 = r12.p;
        Intrinsics.checkNotNull(r11);
        Integer r13 = r11.a();
        Intrinsics.checkNotNull(r13);
        r4.i = r13.intValue();
    L53:
        i97.a r14 = i97.a.a;
        this.y = System.currentTimeMillis();
        yf6.b r15 = Yq();
        if (r15 == null) goto L57;
        r15.apply(r12);
        return;
    L57:
        return;
    L52:
        r4.i = 0;
        goto L53
    L18:
        if (vm2.e.h() == false) goto L43;
        if (this.I == null) goto L43;
        com.bytedance.android.livesdk.chatroom.o r16 = com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        if (r16 == null) goto L28;
        com.bytedance.live.datacontext.m r17 = r16.getCleanMode();
        if (r17 == null) goto L28;
        Integer r18 = (Integer) r17.getValue();
        if (r18 == null) goto L28;
        int r19 = r18.intValue();
    L29:
        if (r19 <= 0) goto L43;
        HashMap r20 = new HashMap();
        if (r19 == 1) goto L41;
        if (r19 == 2) goto L40;
        if (r19 != 3) goto L36;
        String r21 = "simple_mode";
    L42:
        r20.put("mode_type", r21);
        r20.put("action_type", "click");
        r20.put("connection_type", "video");
        j0.l().sendLog("livesdk_connection_click_under_screen_clear", r20, new Object[]{new x(), IRoom.class});
        goto L43
    L36:
        if (r19 == 13) goto L38;
        r21 = "unknown_mode";
        goto L42
    L38:
        r21 = "focus_mode";
        goto L42
    L40:
        r21 = "pure_mode";
        goto L42
    L41:
        r21 = "origin_mode";
    L28:
        r19 = 0;
        goto L29
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public void bd(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        tf0.o r3 = Qq();
        if (r3 == null) goto L6;
        r3.G();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void be(ExtraResponse<? extends IJoinChannelResult, Extra> r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        super.be(r3);
        vh7.c r4 = jm2.a.d((vh7.c) r3.data);
        if (r4 == null) goto L17;
        com.bytedance.android.livesdk.link.model.bridge.i0 r5 = (com.bytedance.android.livesdk.link.model.bridge.i0) r4;
        tf0.o r0 = Qq();
        if (r0 == null) goto L8;
        r0.f();
    L8:
        if (vm2.d.m().useJoinChannelList == false) goto L14;
        y r1 = Aq();
        if ((r1 instanceof y) == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L14;
        r1.E(r5);
    L14:
        this.i = r5.isPaidLinkmic();
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.link.model.bridge.IJoinChannelResultBridge");
    }

    public void i(IApplyResult r5) {
        ChatMatchWidget r0 = this.N;
        if (r0 == null) goto L10;
        Intrinsics.checkNotNull(r0);
        if (r5 == null) goto L7;
        a5 r6 = r5.getDisplayText();
    L8:
        r0.zq(r6, false, "", Boolean.FALSE);
        return;
    L7:
        r6 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public void l1(g1 r5) {
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L5;
        Boolean r0 = Boolean.TRUE;
        r6.put("DATA_DISCONNECT_LINK", r0);
        ((Widget) this).dataCenter.put("DATA_DISCONNECT_LINK_BYSELF", r0);
    L5:
        com.bytedance.android.live.liveinteract.linksecurity.c r7 = com.bytedance.android.live.liveinteract.linksecurity.c.g;
        LinkedHashMap r1 = new LinkedHashMap();
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        com.bytedance.android.live.core.privacy.av.api.b.a.a r2 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r3 = com.bytedance.android.live.core.privacy.av.api.a.b;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r2, "callback");
        Intrinsics.checkNotNullParameter(r3, "config");
        r7.c("sense_disconnect_by_self", r1, r2, r3);
        this.K = false;
        VoiceChatMuteManager r4 = this.O;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L8:
        r4.t(false);
        tf0.o r8 = Qq();
        if (r8 == null) goto L12;
        r8.N();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b
    public final void n0(v r1) {
        this.u = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void ti(ExtraResponse<? extends IJoinChannelResult, Extra> r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        if (isViewValid() == true) goto L5;
        return;
    L5:
        com.bytedance.android.live.liveinteract.plantform.utils.k.a(((Widget) this).context, 5);
        hd0.c r4 = hd0.c.f();
        r4.e = SystemClock.currentThreadTimeMillis();
    }

    public void w(g1 r5) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        jy0.b.d("VoiceGuestLinkWidget", String.format("showLinkResultDialog, showLinkResultDialog: %s", Arrays.copyOf(new Object[]{r5}, 1)));
        if (r5 != null) goto L5;
        return;
    L5:
        e r1 = new e(this, r5);
        if (je0.d.t(je0.d.h()) == true) goto L8;
        return;
    L8:
        if (je0.d.A() == false) goto L10;
        LinkResultDialogFragmentV2.u.getClass();
        RxUtilKt.c(RxUtilKt.h(Observable.timer(LinkResultDialogFragmentV2.s, TimeUnit.MILLISECONDS)).subscribe(new d(this, r5, r1)), this.S);
        return;
    L10:
        LinkResultDialogFragment.l.getClass();
        LinkResultDialogFragment r6 = LinkResultDialogFragment.a.a(r5, r1);
        FragmentActivity r2 = ((Widget) this).context;
        if (r2 == null) goto L18;
        FragmentManager r3 = r2.getSupportFragmentManager();
        String r4 = LinkResultDialogFragment.k;
        LandscapeRestrictionOperation r7 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, r4, r7);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r6, r7) == true) goto L25;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L16:
        r6.show(r3, r4);
        return;
    L25:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void T3(com.bytedance.android.livesdk.chatroom.model.interact.m r1, int r2) {
        GuestTalkBeInvitedDialog r3 = this.L;
        if (r3 == null) goto L6;
        r3.X90();
        return;
    }

    public void showFollowGuideDialog(boolean r8, tf0.q r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        u r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r0 != null) goto L5;
        return;
    L5:
        com.bytedance.live.datacontext.m r1 = r0.y1();
        if (r1 == null) goto L8;
        r1.setValue(Boolean.TRUE);
    L8:
        com.bytedance.android.livesdk.common.b r2 = this.M;
        if (r2 == null) goto L13;
        Intrinsics.checkNotNull(r2);
        if (r2.isShowing() == false) goto L13;
        return;
    L13:
        com.bytedance.android.live.liveinteract.widget.widget.q r3 = new com.bytedance.android.live.liveinteract.widget.widget.q(((Widget) this).context, com.bytedance.android.live.liveinteract.api.utils.m.j(this), this, r8, r9);
        this.M = r3;
        Intrinsics.checkNotNull(r3);
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L20;
        DialogLancet.handleBlockedDialogShow(r3);
        return;
    L20:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L17:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
    }

    public void t(sf0.a r8, IApplyResult r9) {
        Intrinsics.checkNotNullParameter(r8, "applyParams");
        Intrinsics.checkNotNullParameter(r9, "applyResult");
        ILinkPanelService r1 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r1 == null) goto L12;
        Context r2 = ((Widget) this).context;
        IRoom r3 = getMRoom();
        a5 r4 = r9.getDisplayText();
        i0 r10 = TalkRoomLogUtils.a;
        String r11 = this.w;
        LinkApplyType r0 = this.x;
        if (r11 == null) goto L9;
        Integer r12 = StringsKt.toIntOrNull(r11);
        if (r12 == null) goto L9;
        String r13 = TalkRoomLogUtils.w(r12.intValue(), r0);
    L10:
        r1.pj(r2, r3, r4, r13, r8.a);
        return;
    L9:
        r13 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public void u4(long r1, ec6.a r3) {
        Intrinsics.checkNotNullParameter(r3, "client");
        vb6.g r2 = yq();
        if (r2 == null) goto L6;
        r2.X0(new b(this), false);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public void Ng(sf0.a r25, long r26, ExtraResponse<? extends IApplyResult, Extra> r28) {
        Intrinsics.checkNotNullParameter(r25, "applyParams");
        Intrinsics.checkNotNullParameter(r28, "response");
        IApplyResult r2 = (IApplyResult) r28.data;
        if (r2 != null) goto L5;
        return;
    L5:
        TeamFightContext.Companion.i(r25.i, r25.a);
        this.E = "apply";
        int r4 = je0.d.j(Aq());
        this.z = r2.getAutoJoinFull();
        g0 r5 = (g0) ((Widget) this).dataCenter.get("data_link_mic_pos_tag_info", null);
        if (r5 == null) goto L8;
        Long r6 = Long.valueOf(r5.getTagType());
    L9:
        g0 r3 = r2.getMicPosTagInfo();
        if (r6 != null) goto L12;
    L13:
        if (r3 == null) goto L15;
        this.F = r3;
        Intrinsics.checkNotNull(r3);
        r6 = Long.valueOf(r3.getTagType());
    L15:
        com.bytedance.android.live.liveinteract.voicechat.util.k r7 = this.I;
        if (r7 == null) goto L225;
        String r10 = this.w;
        boolean r11 = Nq();
        isKtvOn();
        KtvMusic r12 = this.C;
        String r13 = this.D;
        boolean r14 = this.z;
        boolean r15 = this.A;
        IRoom r16 = getMRoom();
        Intrinsics.checkNotNull(r16);
        ICircleInfo r17 = r16.getCircleInfo();
        int r8 = r25.a;
        String r9 = this.E;
        Intrinsics.checkNotNull(r9);
        int r1 = r25.c;
        Intrinsics.checkNotNullParameter(r9, "connectType");
        HashMap r18 = new HashMap();
        Long r19 = r6;
        if (TextUtils.isEmpty(r10) == true) goto L73;
        int r110 = bh0.a.a;
        int r20 = r8;
        if (Intrinsics.areEqual(r10, String.valueOf(101)) == false) goto L23;
        r18.put("request_page", "seat");
    L75:
        if (tc0.c.h().K != LinkApplyType.MATCH.getValue()) goto L77;
        r18.put("request_page", tc0.c.h().L.getValue());
    L77:
        String r21 = tc0.c.h().M;
        if (TextUtils.isEmpty(r21) == true) goto L80;
        r18.put("is_task", "1");
        r18.put("activity_name", r21);
    L80:
        String r22 = "0";
        if (r11 == false) goto L83;
        r18.put("is_approve_needed", "0");
    L85:
        if (((Boolean) r7.e.get("data_audio_chat_support_send_gift_to_linker", Boolean.TRUE)).booleanValue() == false) goto L87;
        Object r0 = "on";
        Object r111 = "off";
    L88:
        r18.put("gift_guest_switch_type", r0);
        if (r12 == null) goto L97;
        if (r13 != null) goto L92;
        r13 = "";
        String r23 = r13;
    L93:
        r18.put("from_request_type", r13);
        r18.put("song_id", String.valueOf(r12.getId()));
        String r112 = r12.getTitle();
        if (r112 != null) goto L96;
        r112 = r23;
    L96:
        r18.put("song_name", r112);
        r18.put("is_priority_sing", "0");
    L98:
        int r24 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        TalkRoomLogUtils.B0(r18, Integer.valueOf(r24), null, 4);
        if (Intrinsics.areEqual((String) r18.get("request_page"), "live_song") == false) goto L101;
    L108:
        r18.put("guest_connection_type", "live_song");
    L109:
        if (r14 == false) goto L111;
        Object r27 = "1";
    L112:
        r18.put("is_full", r27);
        if (r15 == false) goto L115;
        Object r29 = "1";
    L116:
        r18.put("is_fans_guide", r29);
        r18.put("link_cnt", String.valueOf(r4));
        t r30 = j0.l().c(x.class);
        if (r30 != null) goto L119;
    L132:
        i0 r31 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.y0(r18, false);
        gk0.a.b.getClass();
        r18.put("previous_page", gk0.a.C0214a.c());
        if (((Boolean) r7.e.get("data_link_mic_is_quick_invite", Boolean.FALSE)).booleanValue() == false) goto L135;
        Object r32 = "1";
    L136:
        r18.put("is_quick_invite", r32);
        TalkRoomLogUtils.L0(r18);
        if (r17 == null) goto L141;
        String r33 = r17.getCircleName();
        if (r33 == null) goto L141;
        r18.put("circle_name", r33);
    L141:
        y r34 = (y) ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r34 == null) goto L144;
        Integer r35 = Integer.valueOf(r34.n());
    L145:
        r18.put("seat_num", String.valueOf(r35));
        if (r34 == null) goto L167;
        CopyOnWriteArrayList<LinkmicPositionItem> r36 = r34.e;
        if (r36 == null) goto L167;
        Iterator<LinkmicPositionItem> r37 = r36.iterator();
    L151:
        if (r37.hasNext() == false) goto L159;
        LinkmicPositionItem r38 = r37.next();
        int r39 = r20;
        if (((int) r38.getPosition()) != r39) goto L155;
        boolean r40 = true;
    L156:
        if (r40 == true) goto L157;
        r20 = r39;
        goto L151
    L157:
        LinkmicPositionItem r41 = r38;
    L160:
        LinkmicPositionItem r42 = r41;
        if (r42 == null) goto L167;
        String r43 = r42.getActiveName();
        if (r43 != null) goto L165;
        r43 = r23;
    L165:
        r18.put("seat_name", r43);
        goto L167
    L155:
        r40 = false;
        goto L156
    L159:
        r41 = null;
    L167:
        if (com.bytedance.android.live.liveinteract.voicechat.util.e.a(false) == false) goto L169;
        r18.put("is_pre_link", "1");
    L170:
        TalkRoomLogUtils.N0(r18, r10, false);
        TeamFightContext.a r44 = TeamFightContext.Companion;
        if (r44.h() == false) goto L181;
        TeamFightContext r45 = r44.getContext();
        if (r45 == null) goto L179;
        com.bytedance.live.datacontext.m<Integer> r46 = r45.getCurrentApplyTeam();
        if (r46 == null) goto L179;
        Integer r47 = (Integer) r46.getValue();
        if (r47 == null) goto L179;
        int r48 = r47.intValue();
    L180:
        li0.b r49 = li0.b.b;
        r18.put("grouppk_group", li0.b.d(r48));
    L179:
        r48 = 0;
    L181:
        i0 r50 = TalkRoomLogUtils.a;
        String r51 = TalkRoomLogUtils.r();
        if (r51 != null) goto L184;
        String r52 = r9;
    L185:
        r18.put("connect_type", r52);
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == true) goto L188;
    L190:
        r18.put("is_rechargeble", r22);
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L196;
        r18.put("recharge_mode", "normal");
        r18.put("recharge_price", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().a));
        if (fj0.e.d() == false) goto L195;
        r18.put("anonymous_switch", "on");
        goto L196
    L195:
        r18.put("anonymous_switch", r111);
    L196:
        String r53 = tc0.c.h().F;
        if (r53 != null) goto L199;
        r53 = r23;
    L199:
        r18.put("apply_reason", r53);
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L219;
        r18.put("time", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().b));
        int r54 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().a;
        r18.put("money", String.valueOf(r54));
        PaidLinkMicContext r55 = PaidLinkMicContext.Companion.getContext();
        if (r55 == null) goto L208;
        com.bytedance.live.datacontext.m<Integer> r56 = r55.getDiscountMode();
        if (r56 == null) goto L208;
        Integer r57 = (Integer) r56.getValue();
        if (r57 == null) goto L208;
        int r58 = r57.intValue();
    L209:
        if (r58 == 1) goto L215;
        if (r58 == 2) goto L214;
        if (r58 == 3) goto L213;
        String r113 = r23;
    L216:
        r18.put("discount_type", r113);
        com.bytedance.android.live.liveinteract.voicechat.util.k.E(r18, r54, r58);
        if (fj0.b.a.g == false) goto L219;
        r18.put("is_vip_recharge_privilege", "1");
        goto L219
    L213:
        r113 = "strategy";
        goto L216
    L214:
        r113 = "activity";
        goto L216
    L215:
        r113 = "vip";
    L208:
        r58 = 0;
    L219:
        InteractiveSongLoggerKt.b(r18);
        r18.put("play_mode", u0.b());
        b1 r59 = (b1) com.bytedance.android.livesdk.sharedpref.c.g1.getValue();
        fj0.a r60 = fj0.b.a;
        r18.put("rechargeable_label", fj0.b.i(r59.getSavedTagInfos()));
        r18.put("rechargeable_intro", r59.getSavedDesc());
        if (r19 == null) goto L224;
        long r61 = r19.longValue();
        if (r61 <= 0) goto L224;
        r18.put("tag_type", String.valueOf(r61));
    L224:
        boolean r62 = false;
        TalkRoomLogUtils.T0(r18, false);
        ii0.a.c(r18, true);
        j0.l().sendLog("livesdk_guest_connection_apply", r18, new Object[]{IRoom.class, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
    L226:
        Tq(r62);
        return;
    L188:
        if (fj0.b.a.b == false) goto L190;
        r22 = "1";
        goto L190
    L184:
        r52 = r51;
        goto L185
    L169:
        r18.put("is_pre_link", "0");
        goto L170
    L144:
        r35 = null;
        goto L145
    L135:
        r32 = "0";
        goto L136
    L119:
        if ((r30 instanceof t) == false) goto L132;
        t r63 = r30;
        String r65 = r63.b();
        if (r65 != null) goto L123;
    L126:
        boolean r66 = true;
    L127:
        if (r66 == true) goto L132;
        String r67 = r63.b();
        if (r67 != null) goto L131;
        r67 = r23;
    L131:
        r18.put("previous_page", r67);
        goto L132
    L123:
        if (r65.length() == 0) goto L126;
        r66 = false;
        goto L127
    L115:
        r29 = "0";
        goto L116
    L111:
        r27 = "0";
        goto L112
    L101:
        if (Intrinsics.areEqual((String) r18.get("request_page"), "live_chorus") == true) goto L108;
        Integer r68 = Integer.valueOf(r24);
        if (r12 == null) goto L106;
        boolean r69 = true;
    L107:
        TalkRoomLogUtils.D0(r18, r68, r69);
        goto L109
    L106:
        r69 = false;
        goto L107
    L92:
        r23 = "";
        goto L93
    L97:
        r23 = "";
        r18.put("is_priority_sing", "0");
        goto L98
    L87:
        r0 = "off";
        r111 = r0;
        goto L88
    L83:
        r18.put("is_approve_needed", "1");
        goto L85
    L23:
        if (Intrinsics.areEqual(r10, String.valueOf(102)) == false) goto L26;
        r18.put("request_page", "bottom");
        goto L75
    L26:
        if (Intrinsics.areEqual(r10, String.valueOf(103)) == false) goto L29;
        r18.put("request_page", "popup");
        goto L75
    L29:
        if (Intrinsics.areEqual(r10, String.valueOf(104)) == false) goto L32;
        r18.put("request_page", "seat_popup");
        goto L75
    L32:
        if (Intrinsics.areEqual(r10, String.valueOf(109)) == false) goto L35;
        r18.put("request_page", "emoji_panel");
        r18.put("connect_type", "apply");
        goto L75
    L35:
        if (Intrinsics.areEqual(r10, String.valueOf(108)) == false) goto L38;
        r18.put("request_page", "pre_link_seat");
        r18.put("connect_type", "apply");
        goto L75
    L38:
        if (Intrinsics.areEqual(r10, String.valueOf(com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_CANCELED_BY_SERVER)) == false) goto L41;
        r18.put("connect_type", "apply");
        goto L75
    L41:
        if (Intrinsics.areEqual(r10, String.valueOf(110)) == false) goto L44;
        r18.put("request_page", "task");
        r18.put("connect_type", "apply");
        goto L75
    L44:
        if (Intrinsics.areEqual(r10, String.valueOf(112)) == false) goto L47;
        r18.put("request_page", "apply_panel");
        goto L75
    L47:
        if (Intrinsics.areEqual(r10, String.valueOf(113)) == false) goto L50;
        r18.put("request_page", "card");
        goto L75
    L50:
        if (Intrinsics.areEqual(r10, String.valueOf(114)) == false) goto L57;
        if (r1 != LinkApplyType.KTV_MULTI_CHORUS.getValue()) goto L54;
        Object r70 = "live_chorus";
    L55:
        r18.put("request_page", r70);
        goto L75
    L54:
        r70 = "live_song";
        goto L55
    L57:
        if (Intrinsics.areEqual(r10, String.valueOf(115)) == false) goto L60;
        r18.put("request_page", "associated_apply");
        goto L75
    L60:
        if (Intrinsics.areEqual(r10, String.valueOf(118)) == false) goto L63;
        r18.put("request_page", "preview_theme_promote_link");
        goto L75
    L63:
        if (Intrinsics.areEqual(r10, String.valueOf(119)) == false) goto L66;
        r18.put("request_page", "preview_game_promote_link");
        goto L75
    L66:
        if (tc0.c.h().J == 114) goto L69;
        Intrinsics.checkNotNull(r10);
        r18.put("request_page", r10);
        goto L75
    L69:
        if (r1 != LinkApplyType.KTV_MULTI_CHORUS.getValue()) goto L71;
        Object r71 = "live_chorus";
    L72:
        r18.put("request_page", r71);
        goto L75
    L71:
        r71 = "live_song";
        goto L72
    L73:
        r20 = r8;
        goto L75
    L225:
        r62 = false;
        goto L226
    L12:
        if (r6.longValue() != 0) goto L15;
    L8:
        r6 = null;
        goto L9
    }

    public void v(String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r13, "from");
        String r0 = vm2.d.l().commentSchema;
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r1 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if (r1 == null) goto L7;
        Map r4 = r1.getMap();
        if (r4 == null) goto L7;
        String r5 = (String) r4.get("enter_from_merge");
    L9:
        if (r5 != null) goto L11;
        String r6 = "";
    L18:
        if (r1 == null) goto L22;
        Map r7 = r1.getMap();
        if (r7 == null) goto L22;
        String r8 = (String) r7.get("enter_method");
    L23:
        if (r8 != null) goto L25;
        String r9 = "";
    L32:
        if (r1 == null) goto L36;
        Map r10 = r1.getMap();
        if (r10 == null) goto L36;
        String r11 = (String) r10.get("action_type");
    L37:
        if (r11 != null) goto L39;
        String r2 = "";
    L45:
        HashMap r12 = new HashMap();
        IRoom r16 = getMRoom();
        Intrinsics.checkNotNull(r16);
        r12.put("service_provider_id", r16.getOwnerUserIdString());
        r12.put("service_order_id", this.B);
        IRoom r17 = getMRoom();
        Intrinsics.checkNotNull(r17);
        r12.put("room_id", String.valueOf(r17.getId()));
        IRoom r18 = getMRoom();
        Intrinsics.checkNotNull(r18);
        r12.put("anchor_id", r18.getOwnerUserIdString());
        r12.put("live_type", "voice_live");
        r12.put("enter_from_merge", r6);
        r12.put("enter_method", r9);
        r12.put("action_type", r2);
        TalkRoomLogUtils.B0(r12, null, null, 6);
        if (r14 != null) goto L48;
        r14 = "";
    L48:
        r12.put("connection_time", r14);
        if (r15 != null) goto L51;
        r15 = "";
    L51:
        r12.put("connection_cost", r15);
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r12.put("limited_time", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().b));
        r12.put("play_mode", "rechargeable_normal");
        String r19 = y0.b(r0, r12);
        jy0.b.d("ttlive_link_paid", "showPaidLinkCommentDialog from=" + r13 + " commentSchema=" + r19);
        jc1.k.n(IBaseLiveActionHandler.class).handle(((Widget) this).context, r19);
        return;
    L39:
        if (r1 == null) goto L43;
        Map r3 = r1.getMap();
        if (r3 == null) goto L43;
        String r20 = (String) r3.get("action_type");
    L44:
        r2 = String.valueOf(r20);
    L43:
        r20 = null;
    L36:
        r11 = null;
        goto L37
    L25:
        if (r1 == null) goto L29;
        Map r21 = r1.getMap();
        if (r21 == null) goto L29;
        String r22 = (String) r21.get("enter_method");
    L30:
        r9 = String.valueOf(r22);
    L29:
        r22 = null;
    L22:
        r8 = null;
        goto L23
    L11:
        if (r1 == null) goto L15;
        Map r23 = r1.getMap();
        if (r23 == null) goto L15;
        String r24 = (String) r23.get("enter_from_merge");
    L16:
        r6 = String.valueOf(r24);
    L15:
        r24 = null;
    L7:
        r5 = null;
        goto L9
    }

    public final void Rq(KtvMusic r22, String r23, LinkApplyType r24, int r25, tf0.b r26) {
        Intrinsics.checkNotNullParameter(r23, "requestType");
        Intrinsics.checkNotNullParameter(r24, "applyType");
        this.C = r22;
        this.D = r23;
        this.x = r24;
        this.w = String.valueOf(r25);
        StringBuilder r2 = new StringBuilder("ktvApply:");
        if (r22 == null) goto L5;
        String r1 = r22.getTitle();
    L6:
        r2.append(r1);
        jy0.b.d("ttlive_ktv", r2.toString());
        LinkApplyType r3 = this.x;
        if (r3 == null) goto L9;
        int r6 = r3.getValue();
    L10:
        Wq(new sf0.a(-1, r25, r6, 0, LinkMatchType.NONE, "", "ktv_apply", 0, 0, 0, false, false, 0, r26, null, 0, 507648));
        return;
    L9:
        r6 = 0;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}

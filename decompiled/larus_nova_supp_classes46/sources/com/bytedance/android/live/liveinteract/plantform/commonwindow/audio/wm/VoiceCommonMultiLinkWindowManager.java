package com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.wm;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.s2;
import com.bytedance.android.live.core.setting.x2;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.animation.m0;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimManager;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimTaskState;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.p;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.SeatAnimationView;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.customizestream.CustomizeStreamContext;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.VoiceCommonLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder.MultiLinkPreOnlineViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserVirtualAvatarViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.context.MultiLinkDynamicContext;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.k0;
import com.bytedance.android.live.liveinteract.plantform.model.s0;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.LinkRoomFightItemDecoration;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.utils.h1;
import com.bytedance.android.live.liveinteract.videotalk.emoji.t;
import com.bytedance.android.live.liveinteract.videotalk.ui.BaseEqualGridItemDecoration;
import com.bytedance.android.live.liveinteract.view.PaidLinkCountDownView;
import com.bytedance.android.live.liveinteract.view.PositionNameTv;
import com.bytedance.android.live.liveinteract.view.RadioTextBoardView;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.liveinteract.voicechat.MuteStateChecker;
import com.bytedance.android.live.liveinteract.voicechat.emoji.VoiceChatInteractEmojiPanel;
import com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.liveinteract.widget.widget.ChatRoomGuestAppliedDialog;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IHostSocial;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.LinkFinishResult;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.message.model.qb;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.LynxView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import sh0.j0;
import vlc.l;
import yb6.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u0006:\u0001\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/audio/wm/VoiceCommonMultiLinkWindowManager;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/wm/BaseMultiLinkWindowManager;", "Lcom/bytedance/android/live/liveinteract/animation/InteractAnimationController$d;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvb6/f;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class VoiceCommonMultiLinkWindowManager extends BaseMultiLinkWindowManager implements InteractAnimationController.d, l, Observer<KVData>, vb6.f {
    public static final /* synthetic */ int k0 = 0;
    public final EmojiSoundManager I;
    public final SeatAnimManager J;
    public vlc.d K;
    public qb L;
    public ng0.e M;
    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c N;
    public ih0.d O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public final ConcurrentHashMap<Integer, ArrayList<AnimatorSet>> S;
    public boolean T;
    public String U;
    public boolean V;
    public boolean W;
    public boolean X;
    public final View Y;
    public final GLSurfaceView Z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ VoiceCommonMultiLinkWindowManager a;

        public b(VoiceCommonMultiLinkWindowManager r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Boolean r5 = (Boolean) r4;
            VoiceCommonMultiLinkWindowManager r0 = this.a;
            List r1 = (List) r0.B.f().getValue();
            if (r1 != null) goto L5;
            r1 = CollectionsKt.emptyList();
        L5:
            int r2 = VoiceCommonMultiLinkWindowManager.k0;
            r0.f1(r1);
            if (je0.d.r() == false) goto L14;
            cg6.a r3 = this.a.g1();
            if (r3 == null) goto L14;
            vb6.g r6 = r3.O5();
            if (r6 == null) goto L14;
            yb6.e r7 = r6.j();
            if (r7 == null) goto L14;
            r7.G();
        L14:
            cg6.a r8 = this.a.g1();
            if (r8 == null) goto L25;
            vb6.g r9 = r8.O5();
            if (r9 == null) goto L25;
            yb6.e r10 = r9.j();
            if (r10 == null) goto L25;
            n r11 = r10.K();
            if (r11 == null) goto L25;
            boolean r12 = true;
            if (r11.e != true) goto L25;
        L27:
            if (r5.booleanValue() == false) goto L29;
            return;
        L29:
            if (vm2.d.S0() == false) goto L31;
            if (r12 == true) goto L31;
            return;
        L31:
            IInteractService r13 = (IInteractService) jc1.k.f(IInteractService.class);
            IVoiceLiveTheme r14 = null;
            if (r13 == null) goto L34;
            x00.a r15 = r13.getThemeManager(je0.d.r(), this.a.C);
        L35:
            if (r15 == null) goto L37;
            this.a.getClass();
            r14 = r15.q(2);
        L37:
            com.bytedance.android.live.liveinteract.plantform.base.g r16 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
            if (r16 == null) goto L45;
            com.bytedance.android.live.ui.c r17 = r16.y4();
            if (r17 == null) goto L46;
            r17.b(r14);
            return;
        L46:
            return;
        L45:
            return;
        L34:
            r15 = null;
        L25:
            r12 = false;
            goto L27
        }
    }

    public static final class c implements wh0.a {
        public final /* synthetic */ VoiceCommonMultiLinkWindowManager a;

        public c(VoiceCommonMultiLinkWindowManager r1) {
            this.a = r1;
        }

        @Override // wh0.a
        public final boolean a(String r6) {
            VoiceCommonMultiLinkWindowManager r0 = this.a;
            int r1 = VoiceCommonMultiLinkWindowManager.k0;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r2 = r0.d;
            String r3 = null;
            if (r2 == null) goto L25;
            List<tf0.e> r4 = r2.getDataList();
            if (r4 == null) goto L25;
            Iterator<T> r5 = r4.iterator();
        L8:
            if (r5.hasNext() == false) goto L23;
            Object r7 = r5.next();
            tf0.e r8 = (tf0.e) r7;
            if ((r8 instanceof MultiLinkGuestViewBinder.a) == true) goto L12;
            r8 = null;
        L12:
            MultiLinkGuestViewBinder.a r9 = (MultiLinkGuestViewBinder.a) r8;
            if (r9 == null) goto L19;
            ch0.e r10 = r9.k;
            if (r10 == null) goto L19;
            ILinkPlayerInfoBridge r11 = r10.a;
            if (r11 == null) goto L19;
            String r12 = r11.getInteractId();
        L21:
            if (Intrinsics.areEqual(r12, r6) == false) goto L8;
        L24:
            tf0.e r13 = (tf0.e) r7;
        L27:
            if ((r13 instanceof MultiLinkGuestViewBinder.a) == true) goto L29;
            r13 = null;
        L29:
            MultiLinkGuestViewBinder.a r14 = (MultiLinkGuestViewBinder.a) r13;
            if (r14 == null) goto L38;
            ch0.e r15 = r14.k;
            if (r15 == null) goto L38;
            ILinkPlayerInfoBridge r16 = r15.a;
            if (r16 == null) goto L38;
            IBaseUser r17 = r16.getUser();
            if (r17 == null) goto L38;
            String r18 = r17.getIdString();
        L39:
            Room r19 = m.i().getCurrentRoom();
            if (r19 == null) goto L43;
            r3 = r19.getOwnerUserIdString();
        L43:
            return Intrinsics.areEqual(r18, r3);
        L38:
            r18 = null;
        L19:
            r12 = null;
            goto L21
        L23:
            r7 = null;
        L25:
            r13 = null;
            goto L27
        }

        @Override // wh0.a
        public final int b(String r3) {
            VoiceCommonMultiLinkWindowManager r0 = this.a;
            int r1 = VoiceCommonMultiLinkWindowManager.k0;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r2 = r0.d;
            if (r2 != null) goto L7;
            return -1;
        L7:
            return r2.S0(r3);
        }
    }

    public static final class d implements com.bytedance.android.live.liveinteract.widget.widget.a {
        public final /* synthetic */ VoiceCommonMultiLinkWindowManager a;
        public final /* synthetic */ IRoom b;

        @Override // com.bytedance.android.live.liveinteract.widget.widget.a
        public final void show() {
            this.a.q1(true, this.b);
        }

        public d(VoiceCommonMultiLinkWindowManager r1, IRoom r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ VoiceCommonMultiLinkWindowManager a;

        public e(VoiceCommonMultiLinkWindowManager r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List<ch0.e> r4 = (List) r3;
            VoiceCommonMultiLinkWindowManager r0 = this.a;
            int r1 = VoiceCommonMultiLinkWindowManager.k0;
            r0.m1(r4, "mergeDataListChange");
            r0.f1(r4);
            r0.i1(false);
            r0.l1(false);
            if (r0.n == true) goto L7;
            r0.r1();
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ VoiceCommonMultiLinkWindowManager a;

        public f(VoiceCommonMultiLinkWindowManager r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            VoiceCommonMultiLinkWindowManager r5 = this.a;
            List<ch0.e> r0 = (List) r5.B.f().getValue();
            if (r0 != null) goto L5;
            r0 = CollectionsKt.emptyList();
        L5:
            int r1 = VoiceCommonMultiLinkWindowManager.k0;
            r5.m1(r0, "orderSingStageChange");
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ VoiceCommonMultiLinkWindowManager a;

        public g(VoiceCommonMultiLinkWindowManager r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            jd0.a r3 = (jd0.a) r2;
            VoiceCommonMultiLinkWindowManager r4 = this.a;
            int r0 = VoiceCommonMultiLinkWindowManager.k0;
            r4.p1();
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ VoiceCommonMultiLinkWindowManager a;

        public h(VoiceCommonMultiLinkWindowManager r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            com.bytedance.android.live.liveinteract.plantform.datamerge.a r5 = this.a.h;
            if (r5 == null) goto L10;
            BehaviorSubject<List<tf0.e>> r6 = r5.b;
            if (r6 == null) goto L11;
            List<? extends tf0.e> r7 = (List) r6.getValue();
            if (r7 == null) goto L12;
            VoiceCommonMultiLinkWindowManager r0 = this.a;
            int r1 = VoiceCommonMultiLinkWindowManager.k0;
            r0.e1(r7);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class i<T, R> implements Function {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final Object apply(Object r3) {
            com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            LinkMicRoomDataSyncModel r0 = LinkWRDSHelper.b();
            Intrinsics.checkNotNullParameter(r4, "response");
            return Single.create(new com.bytedance.android.live.liveinteract.wrds.i(r0, r4));
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ VoiceCommonMultiLinkWindowManager a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;

        public j(VoiceCommonMultiLinkWindowManager r1, int r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r12) {
            com.bytedance.android.live.network.response.e r13 = (com.bytedance.android.live.network.response.e) r12;
            this.a.P = false;
            DATA r0 = r13.data;
            TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
            long r2 = this.b;
            long r3 = this.c;
            String r14 = r13.logId;
            r1.getClass();
            TalkRoomBusinessFullLinkMonitor.E0(r2, r3, r14);
            x.N(true, this.b, System.currentTimeMillis() - this.c, null);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ VoiceCommonMultiLinkWindowManager a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;

        public k(VoiceCommonMultiLinkWindowManager r1, int r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r9) {
            Throwable r5 = (Throwable) r9;
            VoiceCommonMultiLinkWindowManager r10 = this.a;
            r10.P = false;
            ExceptionUtils.handleException(r10.getContext(), r5);
            TalkRoomBusinessFullLinkMonitor r11 = TalkRoomBusinessFullLinkMonitor.a;
            long r0 = this.b;
            long r2 = this.c;
            r11.getClass();
            TalkRoomBusinessFullLinkMonitor.D0(r0, r2, r5);
            x.N(false, this.b, System.currentTimeMillis() - this.c, r5);
        }
    }

    static {
    }

    public final void Am(ei6.a r1, int r2, long r3, Exception r5) {
    }

    public final void E2() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void F0() {
    }

    public final void H1() {
    }

    public final void M1() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void O() {
        this.o = false;
        if (this.n == true) goto L10;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 == null) goto L9;
        r0.T8();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void O0() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void P() {
        com.bytedance.live.datacontext.m r0 = m.i().getRoom();
        if (r0 == null) goto L10;
        IRoom r2 = (IRoom) r0.getValue();
        if (r2 == null) goto L11;
        Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.ROOM);
        ILinkPanelService r1 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r1 == null) goto L12;
        r1.pj(getContext(), r2, null, null, -1);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void W(long r1, OperateType r3) {
        Intrinsics.checkNotNullParameter(r3, "operationType");
    }

    public final void X1(int r1, int r2, Exception r3) {
    }

    public final void Y4() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void a(View r1, MotionEvent r2) {
    }

    public final void c1(long r1, OperateType r3, BaseCheckException r4) {
        Intrinsics.checkNotNullParameter(r3, "operationType");
        Intrinsics.checkNotNullParameter(r4, "exception");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final int j0() {
        return 2;
    }

    public final void k4() {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean lo(int r1) {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final /* bridge */ /* synthetic */ com.bytedance.android.live.ui.c m0() {
        return null;
    }

    public final void q2(int r1, int r2, int r3) {
    }

    public final void ra() {
    }

    public final void s1() {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean si() {
        return false;
    }

    public final void t1() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final FrameLayout D() {
        VoiceCommonLinkSeatWindowView r0 = (VoiceCommonLinkSeatWindowView) this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getInteractiveSongMvBg();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void J0() {
        if (this.z.getUiLayout() != 30) goto L26;
        Integer r0 = (Integer) this.C.get("data_enlarge_stage_bottom_pos", 0);
        if (r0 != null) goto L8;
    L9:
        InteractionWidgetsPosContext r1 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, this.C, 0, 2);
        if (r1 == null) goto L23;
        com.bytedance.live.datacontext.m r2 = r1.getAudioTalkBottomPos();
        if (r2 == null) goto L23;
        r2.setValue(this.C.get("data_enlarge_stage_bottom_pos", 0));
    L23:
        this.C.put("data_adjust_public_screen_for_subtitle", 0);
        return;
    L8:
        if (r0.intValue() != 0) goto L9;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3 = this.z;
        if (r3 == null) goto L25;
        pn0.f r4 = r3.d;
        if (r4 == null) goto L23;
        InteractionWidgetsPosContext r5 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, this.C, 0, 2);
        if (r5 == null) goto L23;
        com.bytedance.live.datacontext.m r6 = r5.getAudioTalkBottomPos();
        if (r6 == null) goto L23;
        r6.setValue(Integer.valueOf((((r4.c.b + ((pn0.f.c) ListProtector.get(r4.d, 0)).d) + ((pn0.f.c) ListProtector.get(r4.d, 0)).f) + s1.f(30.0f)) + s1.f(62.0f)));
        goto L23
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkWindowLayoutConfig");
    L26:
        MultiLinkFrequencyOptConfig r7 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.n(Integer.valueOf(this.z.m()), Integer.valueOf(this.z.getUiLayout())) == false) goto L41;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r8 = this.z;
        if (r8 == null) goto L39;
        pn0.f r9 = r8.d;
        if (r9 == null) goto L37;
        InteractionWidgetsPosContext r10 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, this.C, 0, 2);
        if (r10 == null) goto L37;
        com.bytedance.live.datacontext.m r11 = r10.getAudioTalkBottomPos();
        if (r11 == null) goto L37;
        pn0.f.b r12 = r9.c;
        r11.setValue(Integer.valueOf(r12.b + r12.d));
    L37:
        this.C.put("data_adjust_public_screen_for_subtitle", 0);
        return;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkWindowLayoutConfig");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final BaseEqualGridItemDecoration a0() {
        if (aj0.b.c(this.z.getUiLayout()) == true) goto L7;
        return null;
    L7:
        return new LinkRoomFightItemDecoration(this.z.getUiLayout(), new ColorDrawable(s1.h(2131107750)));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void end() {
        if (this.n == true) goto L8;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 == null) goto L8;
        r0.T8();
    L8:
        super.end();
        this.I.c();
        ((LinkedHashMap) this.J.a).clear();
        vlc.d r1 = this.K;
        if (r1 == null) goto L11;
        r1.removeMessageListener(this);
    L11:
        this.e.clear();
        jd0.g r2 = new jd0.g(false);
        xs2.b.a().post(r2);
        DataCenter r3 = this.C;
        if (r3 == null) goto L14;
        r3.put("cmd_interact_audio", r2);
    L14:
        j1(false, null, "");
        l1(true);
        v1(-1);
        DataCenter r4 = this.C;
        if (r4 == null) goto L17;
        r4.removeObserver(this);
    L17:
        cg6.a r5 = g1();
        if (r5 == null) goto L22;
        hg6.g r6 = r5.getRtcManager();
        if (r6 == null) goto L22;
        r6.g(this);
    L22:
        this.R = false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final zj0.d g0() {
        return new zj0.f.b(this.z.j(), this.z.getUiLayout(), this.z.m(), null, 24);
    }

    public final cg6.a g1() {
        j1 r0 = this.G;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final List<s0> getHeadPointList() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        List r1 = null;
        if (r0 == null) goto L7;
        ih0.b r2 = r0.dynamicService(this.C);
        if (r2 == null) goto L7;
        ih0.c r3 = r2.Z9();
    L8:
        StringBuilder r4 = new StringBuilder("getHeadPointList hybridView: ");
        r4.append(r3);
        r4.append('-');
        if (r3 == null) goto L11;
        View r5 = r3.S0();
    L12:
        r4.append(r5 instanceof LynxView);
        r4.append(" ;hybridView.getHybridView(): ");
        if (r3 == null) goto L15;
        View r6 = r3.getHybridView();
    L16:
        r4.append(r6);
        r4.append('-');
        if (r3 == null) goto L19;
        View r7 = r3.getHybridView();
    L20:
        r4.append(r7 instanceof LynxView);
        ALogger.d("VoiceCommonMultiLinkWindowManager", r4.toString());
        if (BaseMultiLinkWindowManager.t0(r3) == false) goto L29;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r8 = this.h;
        if (r8 == null) goto L27;
        BehaviorSubject<List<tf0.e>> r9 = r8.b;
        if (r9 == null) goto L27;
        r1 = (List) r9.getValue();
    L27:
        int r10 = dd0.a.a;
        return dd0.a.c(r3, r1);
    L29:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r11 = this.d;
        if (r11 == null) goto L32;
        LinkMicRecyclerView r12 = r11.getRecyclerView();
    L33:
        int r13 = dd0.a.a;
        return dd0.a.b(r12, this.i, null);
    L32:
        r12 = null;
        goto L33
    L19:
        r7 = null;
        goto L20
    L15:
        r6 = null;
        goto L16
    L11:
        r5 = null;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final sf0.b getLinkmicAreaFrameInfo() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 == null) goto L10;
        LinkMicRecyclerView r1 = r0.getRecyclerView();
        if (r1 == null) goto L10;
        int r2 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        sf0.b r3 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.e(r1, this.z.getUiLayout());
        sf0.c r4 = r3.c;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r5 = this.z;
        r4.a = r5.b;
        List<Integer> r6 = r5.e;
        if (r6 == null) goto L9;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r3.b = r6;
    L9:
        return r3;
    L10:
        boolean r7 = r.a;
        sf0.b r8 = null;
        if (r.j(Integer.valueOf(this.z.getUiLayout()), 0, 6) == false) goto L20;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r9 = this.z;
        if ((r9 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.m) == true) goto L15;
        r9 = null;
    L15:
        if (r9 != null) goto L17;
        return null;
    L17:
        Pair<Integer, Integer> r10 = i0(d0(), c0());
        r8 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a(r9, ((Number) r10.getFirst()).intValue(), ((Number) r10.getSecond()).intValue());
        r8.c.a = r9.b;
        List<Integer> r11 = r9.e;
        if (r11 == null) goto L20;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r8.b = r11;
    L20:
        return r8;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final RecyclerView getMicSeatRecyclerView() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRecyclerView();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final sf0.c getTopLeftSeatFrameInfo() {
        hg0.d r0 = this.i;
        Integer r1 = null;
        if (r0 == null) goto L50;
        RecyclerView r2 = r0.a;
        int r3 = 0;
        if (r2 == null) goto L7;
        RecyclerView.ViewHolder r4 = r2.findViewHolderForAdapterPosition(0);
    L9:
        if ((r4 instanceof hg0.b) == false) goto L51;
        Iterator r5 = ((ArrayList) ((hg0.b) r4).l().a).iterator();
    L12:
        if (r5.hasNext() == false) goto L52;
        jg0.f r6 = (jg0.f) r5.next();
        if ((r6 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.n) == false) goto L12;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.n r7 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.n) r6;
        r7.getClass();
        StringBuilder r8 = new StringBuilder("userInfoContainer x: ");
        ViewGroup r9 = r7.E;
        if (r9 == null) goto L18;
        Float r10 = Float.valueOf(r9.getX());
    L19:
        r8.append(r10);
        r8.append(" y: ");
        ViewGroup r11 = r7.E;
        if (r11 == null) goto L22;
        Float r12 = Float.valueOf(r11.getX());
    L23:
        r8.append(r12);
        r8.append(" w: ");
        ViewGroup r13 = r7.E;
        if (r13 == null) goto L26;
        Integer r14 = Integer.valueOf(r13.getWidth());
    L27:
        r8.append(r14);
        r8.append(" h: ");
        ViewGroup r15 = r7.E;
        if (r15 == null) goto L30;
        r1 = Integer.valueOf(r15.getHeight());
    L30:
        r8.append(r1);
        ALogger.d("MultiLinkHamletAvatarUserInfoLayer", r8.toString());
        ViewGroup r16 = r7.E;
        if (r16 == null) goto L33;
        int r17 = (int) r16.getX();
    L34:
        int r18 = (int) s1.G(r17);
        ViewGroup r19 = r7.E;
        if (r19 == null) goto L37;
        int r20 = (int) r19.getY();
    L38:
        int r21 = (int) s1.G(r20);
        ViewGroup r22 = r7.E;
        if (r22 == null) goto L41;
        int r23 = r22.getMeasuredWidth();
    L42:
        int r24 = (int) s1.G(r23);
        ViewGroup r25 = r7.E;
        if (r25 == null) goto L46;
        r3 = r25.getMeasuredHeight();
    L46:
        return new sf0.c(r18, r21, r24, (int) s1.G(r3));
    L41:
        r23 = 0;
        goto L42
    L37:
        r20 = 0;
        goto L38
    L33:
        r17 = 0;
        goto L34
    L26:
        r14 = null;
        goto L27
    L22:
        r12 = null;
        goto L23
    L18:
        r10 = null;
        goto L19
    L52:
        return null;
    L51:
        return null;
    L7:
        r4 = null;
        goto L9
    L50:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final boolean isDynamicAnimating() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 == null) goto L7;
        ug0.a r1 = r0.getRvLayoutManager();
        if (r1 == null) goto L7;
        return r1.isDynamicAnimating();
    L7:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final q50.b jq() {
        GLSurfaceView r2 = this.Z;
        return new q50.b(new q50.a(r2, k50.e.a(r2)), 5);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void k0() {
        if (this.n == false) goto L6;
        this.N.g(this.z);
        return;
    }

    public final void p1() {
        if (this.R == true) goto L20;
        CustomizeStreamContext.a r0 = CustomizeStreamContext.Companion;
        if (r0.getContext() == null) goto L25;
        this.R = true;
        com.bytedance.android.live.liveinteract.customizestream.a.a("VoiceCommonMultiLinkWindowManager", "initCustomizeStreamObserver");
        List r1 = (List) this.B.f().getValue();
        if (r1 != null) goto L10;
        r1 = CollectionsKt.emptyList();
    L10:
        f1(r1);
        CustomizeStreamContext r2 = r0.getContext();
        if (r2 == null) goto L21;
        com.bytedance.live.datacontext.m<Boolean> r3 = r2.getCustomizeStreamStarted();
        if (r3 == null) goto L22;
        Observable r4 = r3.a();
        if (r4 == null) goto L23;
        Disposable r5 = r4.subscribe(new b(this));
        if (r5 == null) goto L24;
        RxUtilKt.c(r5, this.e);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L25:
        return;
    }

    public final void r1() {
        if (this.n == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 != null) goto L8;
    L10:
        SurfaceView r1 = this.B.R0();
        if (r1 == null) goto L16;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r2 = this.d;
        if (r2 == null) goto L17;
        r2.Ye(r1);
        return;
    L17:
        return;
    L16:
        return;
    L8:
        if (r0.Gi() != true) goto L10;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final boolean u0() {
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEngineOn() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final FrameLayout v() {
        if (this.d == null) goto L7;
        return (FrameLayout) this.y.findViewById(2131375525);
    L7:
        return (FrameLayout) this.y.findViewById(2131375526);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final FrameLayout vj() {
        View r0 = this.Y;
        if (r0 == null) goto L7;
        return (FrameLayout) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, vg0.a
    public final void S4() {
        if (je0.d.r() == false) goto L14;
        cg6.a r0 = g1();
        if (r0 == null) goto L12;
        vb6.g r1 = r0.O5();
        if (r1 == null) goto L12;
        yb6.e r2 = r1.j();
        if (r2 == null) goto L12;
        r2.G();
    L12:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L16;
        i1(false);
        return;
    L16:
        return;
    L14:
        i1(false);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final boolean y0() {
        return je0.d.H();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void L() {
        r1();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void b0() {
        super.b0();
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final void Bn(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        this.J.g(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean Ed(int r5) {
        if (this.z.getUiLayout() == 24) goto L5;
        return true;
    L5:
        if (r.j(null, 0, 7) == false) goto L13;
        ih0.b r6 = MultiLinkDynamicContext.Companion.a(this.C, null);
        if (r6 != null) goto L9;
        return true;
    L9:
        if (r6.isDynamicAnimating() != true) goto L21;
        return false;
    L21:
        return true;
    L13:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r7 = this.d;
        if (r7 != null) goto L16;
        return true;
    L16:
        if (r7.gg() != true) goto L24;
        return false;
    L24:
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void G0(KVData r7) {
        Intrinsics.checkNotNullParameter(r7, "value");
        super.G0(r7);
        String r0 = r7.getKey();
        if (r0.hashCode() == (-759613521)) goto L6;
        return;
    L6:
        if (r0.equals("data_hamlet_avatar_layout_animate") == false) goto L69;
        String r8 = (String) r7.getData();
        if (r8 == null) goto L70;
        List<tf0.e> r1 = e();
        RecyclerView.ViewHolder r2 = null;
        int r3 = -1;
        if (r1 == null) goto L44;
        Iterator<T> r4 = r1.iterator();
        int r5 = 0;
    L13:
        if (r4.hasNext() == false) goto L44;
        Object r6 = r4.next();
        int r9 = r5 + 1;
        if (r5 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        tf0.e r10 = (tf0.e) r6;
        if ((r10 instanceof MultiLinkGuestViewBinder.a) == false) goto L31;
        ch0.e r11 = ((MultiLinkGuestViewBinder.a) r10).k;
        if (r11 == null) goto L26;
        ILinkPlayerInfoBridge r12 = r11.a;
        if (r12 == null) goto L26;
        IBaseUser r13 = r12.getUser();
        if (r13 == null) goto L26;
        String r14 = r13.getIdString();
    L28:
        if (Intrinsics.areEqual(r14, r8) == false) goto L31;
        r3 = r10.a;
    L43:
        r5 = r9;
    L26:
        r14 = null;
    L31:
        if ((r10 instanceof MultiLinkAudioFirstUserViewBinder.a) == false) goto L43;
        ch0.e r15 = ((MultiLinkAudioFirstUserViewBinder.a) r10).k;
        if (r15 == null) goto L39;
        ILinkPlayerInfoBridge r16 = r15.a;
        if (r16 == null) goto L39;
        IBaseUser r17 = r16.getUser();
        if (r17 == null) goto L39;
        String r18 = r17.getIdString();
    L41:
        if (Intrinsics.areEqual(r18, r8) == false) goto L43;
        r3 = r10.a;
    L39:
        r18 = null;
    L44:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r19 = this.d;
        if (r19 == null) goto L50;
        LinkMicRecyclerView r20 = r19.getRecyclerView();
        if (r20 == null) goto L50;
        r2 = r20.findViewHolderForAdapterPosition(r3);
    L50:
        if ((r2 instanceof MultiLinkAudioFirstUserViewBinder.ItemViewHolder) == false) goto L57;
        jg0.g<MultiLinkGuestViewBinder.a> r21 = ((MultiLinkAudioFirstUserViewBinder.ItemViewHolder) r2).a;
        if (r21 == null) goto L71;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r22 = r21.h();
        if (r22 == null) goto L72;
        r22.t();
        return;
    L72:
        return;
    L71:
        return;
    L57:
        if ((r2 instanceof MultiLinkGuestViewBinder.ItemViewHolder) == false) goto L74;
        jg0.g<MultiLinkGuestViewBinder.a> r23 = ((MultiLinkGuestViewBinder.ItemViewHolder) r2).a;
        if (r23 == null) goto L75;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r24 = r23.h();
        if (r24 == null) goto L76;
        r24.t();
        return;
    L76:
        return;
    L75:
        return;
    L74:
        return;
    L70:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void H0(List<? extends tf0.e> r4) {
        Intrinsics.checkNotNullParameter(r4, "windowList");
        I0(r4);
        if (this.z.getUiLayout() != 7) goto L13;
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L11;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = r0.getLinkUserInfoCenter();
        if (r1 == null) goto L11;
        List<T> r2 = r1.getOnlineUserList();
        if (r2 == 0) goto L11;
        int r3 = r2.size();
    L12:
        wf0.b.d(r3, this.n);
    L11:
        r3 = 0;
    L13:
        final qb r5 = this.L;
        if (r5 == null) goto L20;
        this.L = null;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r6 = this.d;
        if (r6 == null) goto L20;
        ViewGroup r7 = r6.td();
        if (r7 == null) goto L20;
        int r8 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.e;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.a.a(r7, new VoiceCommonMultiLinkWindowManager$consumeCacheSyncDataDependWindowListChange$1(this, r5));
    L20:
        e1(r4);
    }

    public final void H4(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void I0(List<? extends tf0.e> r9) {
        Intrinsics.checkNotNullParameter(r9, "list");
        int r0 = this.z.getUiLayout();
        int r1 = c1.a;
        int r3 = 128;
        if (c1.a(Integer.valueOf(this.z.m()), Integer.valueOf(r0)) == true) goto L5;
        MultiLinkFrequencyOptConfig r2 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.e(null, Integer.valueOf(r0)) == false) goto L17;
        if (FoldScreenUtils.e() == false) goto L13;
    L14:
        r3 = 256;
    L15:
        BaseMultiLinkWindowManager.L0(this, r3, 2);
        return;
    L13:
        if (PadConfigUtils.c() == false) goto L15;
    L17:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.c(null, Integer.valueOf(r0)) == false) goto L37;
        if (FoldScreenUtils.e() == false) goto L21;
    L22:
        r3 = 256;
    L24:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L30;
        if (r9.size() <= 1) goto L28;
        BaseMultiLinkWindowManager.L0(this, r3, 2);
        return;
    L28:
        BaseMultiLinkWindowManager.L0(this, 0, 3);
        return;
    L30:
        if (r0 != 25) goto L32;
    L35:
        BaseMultiLinkWindowManager.L0(this, f0(), 2);
        return;
    L32:
        if (r0 == 29) goto L35;
        BaseMultiLinkWindowManager.L0(this, r3, 2);
        return;
    L21:
        if (PadConfigUtils.c() == false) goto L24;
    L37:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.b(Integer.valueOf(r0)) == false) goto L45;
        if (FoldScreenUtils.e() == false) goto L41;
    L42:
        r3 = 256;
    L43:
        BaseMultiLinkWindowManager.L0(this, r3, 2);
        return;
    L41:
        if (PadConfigUtils.c() == false) goto L43;
    L45:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.h(null, Integer.valueOf(r0)) == false) goto L47;
    L53:
        BaseMultiLinkWindowManager.L0(this, f0(), 2);
        return;
    L47:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.i(null, Integer.valueOf(r0)) == true) goto L53;
        if (r0 != 30) goto L52;
        BaseMultiLinkWindowManager.L0(this, f0(), 2);
        return;
    L52:
        BaseMultiLinkWindowManager.L0(this, 0, 3);
        return;
    L5:
        if (r9.size() < 2) goto L7;
        BaseMultiLinkWindowManager.L0(this, 128, 2);
        return;
    L7:
        BaseMultiLinkWindowManager.L0(this, 0, 3);
    }

    public final void M4(cc6.b r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final EPointF Mj(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r2, "uid");
        int r3 = k(r2);
        if (r3 >= 0) goto L7;
        return null;
    L7:
        return h1(r3);
    }

    public final ec6.a O2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "liveCoreSetting");
        Intrinsics.checkNotNullParameter(r2, "liveCoreSetting");
        Intrinsics.checkNotNullParameter(r2, "liveCoreSetting");
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean Pf(int r3) {
        if (this.z.getUiLayout() == 65) goto L5;
        return true;
    L5:
        if (((PointF) h1(r3)).x != 0.0f) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, vg0.a
    public final void Q3(MultiLinkSpecialViewBinder.a r4) {
        Intrinsics.checkNotNullParameter(r4, "itemData");
        if (this.n == false) goto L7;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r0 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r0 == null) goto L9;
        r0.showInviteAndPermitDialog(false, "seat", r4.k);
        return;
    L9:
        return;
    L7:
        f2.b(2131923208, 0);
    }

    public final void Ra(com.bytedance.android.live.liveinteract.multianchor.model.b r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, vg0.a
    public final void V3(MultiLinkPreOnlineViewBinder.a r3) {
        Intrinsics.checkNotNullParameter(r3, "itemData");
        Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r0 != null) goto L6;
    L14:
        if (r0 != null) goto L17;
        return;
    L17:
        if (r0.intValue() != 1) goto L23;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r4 = IVoiceChatGuestService.a.a();
        if (r4 == null) goto L24;
        r4.showFastMatchDialog("seat");
        return;
    L24:
        return;
    L23:
        return;
    L6:
        if (r0.intValue() != 0) goto L14;
        if (h1.d() == true) goto L10;
    L12:
        int r5 = -1;
    L13:
        u1(r5, 108, "from_pre_online_seat");
        return;
    L10:
        if (li0.d.g(null) == false) goto L12;
        r5 = r3.m;
        goto L13
    }

    public final void ag(com.bytedance.android.livesdk.link.model.bridge.h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, vg0.a
    public final void d2(MultiLinkNormalEmptyViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        K3(r2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [android.widget.TextView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11, types: [android.widget.TextView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v23 */
    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final ArrayList dm(int r12) {
        ArrayList<AnimatorSet> r0 = this.S.get(Integer.valueOf(r12));
        View r1 = null;
        PaidLinkCountDownView r2 = null;
        r2 = null;
        r2 = null;
        if (r0 == null) goto L10;
        Iterator<AnimatorSet> r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        if (r3.next().isRunning() == false) goto L6;
        return null;
    L10:
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        r4.element = new ArrayList();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r5 = this.d;
        if (r5 == null) goto L15;
        LinkMicRecyclerView r6 = r5.getRecyclerView();
        if (r6 == null) goto L15;
        RecyclerView.ViewHolder r7 = r6.findViewHolderForAdapterPosition(r12);
    L16:
        IInteractService r8 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r8 == null) goto L21;
        ih0.b r9 = r8.dynamicService(this.C);
        if (r9 == null) goto L21;
        ih0.c r10 = r9.Z9();
    L23:
        if (BaseMultiLinkWindowManager.t0(r10) == false) goto L33;
        if (r10 == null) goto L26;
        View r11 = r10.getHybridView();
    L27:
        LynxView r13 = (LynxView) r11;
        if (r13 == null) goto L30;
        View r14 = r13.findViewByName("micseat_guest_avatar_ct_" + r12);
    L31:
        ?? r15 = null;
        HSImageView r16 = null;
        r1 = r14;
        ?? r17 = 0;
    L74:
        if (r1 == null) goto L79;
        if (r1.getVisibility() != 0) goto L79;
        ((ArrayList) r4.element).add(r1);
    L79:
        if (r15 != null) goto L81;
    L87:
        if (r16 != null) goto L89;
    L91:
        if (r17 != 0) goto L93;
    L99:
        int r18 = m0.a;
        AnimatorSet r19 = m0.a((ArrayList) r4.element, 1.0f, 1.2f, 200);
        Ref.ObjectRef r20 = new Ref.ObjectRef();
        r20.element = m0.a((ArrayList) r4.element, 1.2f, 1.0f, 200);
        Ref.ObjectRef r21 = new Ref.ObjectRef();
        r21.element = m0.a((ArrayList) r4.element, 1.0f, 1.1f, 200);
        Ref.ObjectRef r22 = new Ref.ObjectRef();
        r22.element = m0.a((ArrayList) r4.element, 1.1f, 1.0f, 200);
        r19.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        AnimatorSet r23 = (AnimatorSet) r20.element;
        if (r23 == null) goto L102;
        r23.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
    L102:
        AnimatorSet r24 = (AnimatorSet) r21.element;
        if (r24 == null) goto L105;
        r24.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
    L105:
        AnimatorSet r25 = (AnimatorSet) r22.element;
        if (r25 == null) goto L108;
        r25.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
    L108:
        r19.addListener(new com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.wm.a(this, r20, r12, r4));
        AnimatorSet r26 = (AnimatorSet) r20.element;
        if (r26 == null) goto L111;
        r26.addListener(new com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.wm.b(this, r21, r12, r4));
    L111:
        AnimatorSet r27 = (AnimatorSet) r21.element;
        if (r27 == null) goto L114;
        r27.addListener(new com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.wm.c(this, r22, r12, r4));
    L114:
        AnimatorSet r28 = (AnimatorSet) r22.element;
        if (r28 == null) goto L117;
        r28.addListener(new com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.wm.d(this, r12, r4));
    L117:
        ArrayList<AnimatorSet> r29 = new ArrayList();
        Intrinsics.checkNotNull(r19);
        r29.add(r19);
        AnimatorSet r30 = (AnimatorSet) r20.element;
        Intrinsics.checkNotNull(r30);
        r29.add(r30);
        AnimatorSet r31 = (AnimatorSet) r21.element;
        Intrinsics.checkNotNull(r31);
        r29.add(r31);
        AnimatorSet r32 = (AnimatorSet) r22.element;
        Intrinsics.checkNotNull(r32);
        r29.add(r32);
        r19.start();
        this.S.put(Integer.valueOf(r12), r29);
        return r29;
    L93:
        if (r17.getVisibility() != 0) goto L99;
        ((ArrayList) r4.element).add(r17);
        ArrayList r33 = (ArrayList) r4.element;
        ViewParent r34 = r17.getParent();
        if (r34 == null) goto L98;
        r33.add((ViewGroup) r34);
        goto L99
    L98:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L89:
        if (r16.getVisibility() != 0) goto L91;
        ((ArrayList) r4.element).add(r16);
        goto L91
    L81:
        if (r15.getVisibility() != 0) goto L87;
        ((ArrayList) r4.element).add(r15);
        ArrayList r35 = (ArrayList) r4.element;
        ViewParent r36 = r15.getParent();
        if (r36 == null) goto L86;
        r35.add((ViewGroup) r36);
        goto L87
    L86:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L30:
        r14 = null;
        goto L31
    L26:
        r11 = null;
        goto L27
    L33:
        if ((r7 instanceof hg0.b) == false) goto L73;
        IInteractService r37 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r37 == null) goto L39;
        ih0.b r38 = r37.dynamicService(this.C);
        if (r38 == null) goto L39;
        r38.Z9();
    L39:
        hg0.b r39 = (hg0.b) r7;
        jg0.g r40 = r39.l();
        if (r40 == null) goto L46;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r41 = r40.h();
        if (r41 == null) goto L46;
        View r42 = r41.l();
        if (r42 == null) goto L46;
        ImageView r43 = (ImageView) r42.findViewById(2131389564);
    L47:
        jg0.g r44 = r39.l();
        if (r44 == null) goto L54;
        pg0.e r45 = r44.s();
        if (r45 == null) goto L54;
        View r46 = r45.l();
        if (r46 == null) goto L54;
        PositionNameTv r47 = (PositionNameTv) r46.findViewById(2131389701);
    L55:
        jg0.g r48 = r39.l();
        if (r48 == null) goto L62;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r49 = r48.h();
        if (r49 == null) goto L62;
        View r50 = r49.l();
        if (r50 == null) goto L62;
        r16 = r50.findViewById(2131389466);
    L63:
        jg0.g r51 = r39.l();
        if (r51 == null) goto L70;
        pg0.e r52 = r51.s();
        if (r52 == null) goto L70;
        View r53 = r52.l();
        if (r53 == null) goto L70;
        r2 = (PaidLinkCountDownView) r53.findViewById(2131389700);
    L70:
        if (r2 == null) goto L72;
        r2.setDataCenter(this.C);
    L72:
        r17 = r2;
        r1 = r43;
        r15 = r47;
    L62:
        r16 = null;
    L54:
        r47 = null;
    L46:
        r43 = null;
        goto L47
    L73:
        r17 = 0;
        r15 = null;
        r16 = null;
    L21:
        r10 = null;
    L15:
        r7 = null;
        goto L16
    }

    public final void e1(List<? extends tf0.e> r6) {
        InteractiveSongContext.a r0 = InteractiveSongContext.Companion;
        InteractiveSongContext r1 = r0.getContext();
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r2 = r1.m130isOpenInteractiveSong();
        if (r2 == null) goto L9;
        Boolean r3 = (Boolean) r2.getValue();
        if (r3 == null) goto L9;
        boolean r4 = r3.booleanValue();
    L10:
        boolean r5 = r.a;
        if (r.j(Integer.valueOf(this.z.getUiLayout()), 0, 6) == false) goto L13;
    L15:
        if (r4 == true) goto L20;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r7 = this.d;
        if (r7 == null) goto L44;
        r7.jf();
        return;
    L44:
        return;
    L20:
        int r8 = com.bytedance.android.live.liveinteract.aimv.b.a;
        boolean r9 = com.bytedance.android.live.liveinteract.aimv.b.b(je0.d.e(null));
        if ((CollectionsKt.firstOrNull(r6) instanceof MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) == false) goto L26;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r10 = this.d;
        if (r10 == null) goto L45;
        r10.Ha(this.z, r9);
        return;
    L45:
        return;
    L26:
        if (this.z.getUiLayout() != 30) goto L35;
        if ((CollectionsKt.firstOrNull(r6) instanceof MultiLinkAudioFirstUserViewBinder.a) == false) goto L35;
        if (r0.f() == false) goto L35;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r11 = this.d;
        if (r11 == null) goto L47;
        r11.Ha(this.z, r9);
        return;
    L47:
        return;
    L35:
        if (this.z.getUiLayout() != 26) goto L40;
        if (r9 == false) goto L40;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r12 = this.d;
        if (r12 == null) goto L49;
        r12.Ha(this.z, r9);
        return;
    L49:
        return;
    L40:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r13 = this.d;
        if (r13 == null) goto L51;
        r13.jf();
        return;
    L51:
        return;
    L13:
        if (this.z.getUiLayout() == 30) goto L15;
        return;
    L9:
        r4 = false;
        goto L10
    }

    public final void f1(List r10) {
        cg6.a r0 = g1();
        if (r0 == null) goto L9;
        hg6.g r1 = r0.getRtcManager();
        if (r1 == null) goto L9;
        if (r1.A() != true) goto L9;
    L10:
        boolean r2 = true;
    L12:
        CustomizeStreamContext.a r3 = CustomizeStreamContext.Companion;
        CustomizeStreamContext r4 = r3.getContext();
        if (r4 == null) goto L19;
        com.bytedance.live.datacontext.m<Boolean> r5 = r4.getCustomizeStreamStarted();
        if (r5 == null) goto L19;
        Boolean r6 = (Boolean) r5.getValue();
        if (r6 == null) goto L19;
        boolean r7 = r6.booleanValue();
    L20:
        boolean r8 = r.a;
        if (r.j(Integer.valueOf(this.z.getUiLayout()), 0, 6) == true) goto L23;
        return;
    L23:
        String r9 = "";
        View r11 = null;
        if (r7 == false) goto L108;
        if (r2 == false) goto L108;
        com.bytedance.android.live.liveinteract.customizestream.b r12 = r3.a();
        if (r12 == null) goto L30;
        String r13 = r12.B5();
        if (r13 == null) goto L30;
    L31:
        Iterator r14 = r10.iterator();
    L33:
        if (r14.hasNext() == false) goto L41;
        Object r15 = r14.next();
        IBaseUser r16 = ((ch0.e) r15).a.getUser();
        if (r16 == null) goto L37;
        String r17 = r16.getIdString();
    L39:
        if (Intrinsics.areEqual(r17, r13) == false) goto L33;
    L42:
        ch0.e r18 = (ch0.e) r15;
        CustomizeStreamContext.a r19 = CustomizeStreamContext.Companion;
        CustomizeStreamContext r20 = r19.getContext();
        if (r20 == null) goto L82;
        com.bytedance.live.datacontext.m<Boolean> r21 = r20.getCustomizeStreamStarted();
        if (r21 == null) goto L82;
        if (((Boolean) r21.getValue()).booleanValue() != true) goto L82;
        if (r18 == null) goto L82;
        InteractiveSongContext r22 = InteractiveSongContext.Companion.getContext();
        if (r22 == null) goto L82;
        ILinkPlayerInfoBridge r23 = r18.a;
        if (je0.d.q() == false) goto L73;
        ch0.j r24 = r18.c;
        boolean r25 = ((Boolean) r22.isShowPlayer().getValue()).booleanValue();
        if (r24 == null) goto L59;
        String r26 = r24.a;
    L60:
        com.bytedance.android.live.liveinteract.customizestream.b r110 = r19.a();
        if (r110 == null) goto L63;
        String r111 = r110.m8();
    L64:
        boolean r112 = Intrinsics.areEqual(r26, r111);
        if (r25 == false) goto L82;
        if (r24 == null) goto L82;
        if (r24.c != 1) goto L82;
        if (r23.getMLinkType() != 1) goto L82;
        if (r112 == false) goto L82;
    L81:
        boolean r113 = true;
    L83:
        if (r113 == false) goto L96;
        if (r18 == null) goto L88;
        ch0.h r114 = r18.b;
        if (r114 == null) goto L88;
        r11 = r114.b;
    L88:
        if (r18 == null) goto L95;
        ch0.h r115 = r18.b;
        if (r115 == null) goto L95;
        String r116 = r115.a;
        if (r116 == null) goto L95;
        r9 = r116;
    L95:
        k1(true, r11, r9);
        return;
    L96:
        if (r18 == null) goto L100;
        ch0.h r117 = r18.b;
        if (r117 == null) goto L100;
        r11 = r117.b;
    L100:
        if (r18 == null) goto L107;
        ch0.h r118 = r18.b;
        if (r118 == null) goto L107;
        String r119 = r118.a;
        if (r119 == null) goto L107;
        r9 = r119;
    L107:
        k1(false, r11, r9);
        return;
    L63:
        r111 = null;
        goto L64
    L59:
        r26 = null;
        goto L60
    L73:
        ch0.h r120 = r18.b;
        if (r23.getMLinkType() != 1) goto L82;
        if (r23.getMLinkType() != 1) goto L82;
        if (r120 == null) goto L79;
        View r121 = r120.b;
    L80:
        if (r121 == null) goto L82;
    L79:
        r121 = null;
    L82:
        r113 = false;
        goto L83
    L37:
        r17 = null;
        goto L39
    L41:
        r15 = null;
    L30:
        r13 = "0";
    L108:
        k1(false, null, "");
        return;
    L19:
        r7 = false;
    L9:
        if (je0.d.r() == true) goto L10;
        r2 = false;
        goto L12
    }

    public final void fe(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final EPointF h1(int r7) {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        View r1 = null;
        if (r0 == null) goto L7;
        ih0.b r2 = r0.dynamicService(this.C);
        if (r2 == null) goto L7;
        ih0.c r3 = r2.Z9();
    L8:
        float r4 = 1.0f;
        if (BaseMultiLinkWindowManager.t0(r3) == false) goto L31;
        if (r3 == null) goto L13;
        r1 = r3.getHybridView();
    L13:
        if ((r1 instanceof LynxView) == false) goto L30;
        LynxView r5 = r3.getHybridView();
        if (r5 == null) goto L28;
        View r6 = r5.findViewByName("micseat_container_" + r7);
        int r8 = dd0.a.a;
        if (r6 == null) goto L19;
        r4 = r6.getScaleX();
    L19:
        LynxView r9 = r3.getHybridView();
        if (r9 == null) goto L26;
        View r10 = r9.findViewByName("micseat_guest_avatar_" + r7);
        if (dd0.a.i(r10) == false) goto L90;
        return dd0.a.f(r6, r4);
    L90:
        return dd0.a.f(r10, r4);
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.LynxView");
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.LynxView");
    L30:
        return new EPointF(0.0f, 0.0f);
    L31:
        hg0.d r11 = this.i;
        if (r11 == null) goto L42;
        RecyclerView r12 = r11.a;
        if (r12 == null) goto L36;
        RecyclerView.ViewHolder r13 = r12.findViewHolderForAdapterPosition(r7);
    L38:
        if ((r13 instanceof hg0.b) == false) goto L42;
        jg0.g r14 = ((hg0.b) r13).l();
        if (r14 == null) goto L42;
        View r15 = r14.p();
    L43:
        if (r15 == null) goto L46;
        r1 = r15;
    L66:
        int[] r16 = new int[2];
        if (r1 == null) goto L70;
        r1.getLocationOnScreen(r16);
    L70:
        if (this.z.getUiLayout() != 24) goto L80;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r17 = this.d;
        if (r17 == null) goto L80;
        LinkMicRecyclerView r18 = r17.getRecyclerView();
        if (r18 == null) goto L80;
        RecyclerView.ViewHolder r19 = r18.findViewHolderForAdapterPosition(r7);
        if (r19 == null) goto L80;
        View r20 = r19.itemView;
        if (r20 == null) goto L80;
        r4 = r20.getScaleX();
    L80:
        int r21 = 0;
        float r22 = r16[0];
        if (r1 == null) goto L83;
        int r23 = r1.getWidth();
    L84:
        float r24 = 2;
        float r25 = r22 + ((r23 * r4) / r24);
        float r26 = r16[1];
        if (r1 == null) goto L88;
        r21 = r1.getHeight();
    L88:
        return new EPointF(r25, r26 + ((r21 * r4) / r24));
    L83:
        r23 = 0;
        goto L84
    L46:
        if (this.z.getUiLayout() != 29) goto L57;
        if (r7 != 0) goto L57;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r27 = this.d;
        if (r27 == null) goto L66;
        LinkMicRecyclerView r28 = r27.getRecyclerView();
        if (r28 == null) goto L66;
        RecyclerView.ViewHolder r29 = r28.findViewHolderForAdapterPosition(r7);
        if (r29 == null) goto L66;
        View r30 = r29.itemView;
        if (r30 == null) goto L66;
        r1 = r30.findViewById(2131389468);
    L57:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r31 = this.d;
        if (r31 == null) goto L66;
        LinkMicRecyclerView r32 = r31.getRecyclerView();
        if (r32 == null) goto L66;
        RecyclerView.ViewHolder r33 = r32.findViewHolderForAdapterPosition(r7);
        if (r33 == null) goto L66;
        View r34 = r33.itemView;
        if (r34 == null) goto L66;
        r1 = r34.findViewById(2131389564);
        goto L66
    L36:
        r13 = null;
    L42:
        r15 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final void i1(boolean r8) {
        if (vm2.h.h0().d() == true) goto L6;
        return;
    L6:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L8;
    L17:
        IRoom r0 = null;
        if (r8 == false) goto L25;
        com.bytedance.android.live.liveinteract.videotalk.utils.c r3 = this.b;
        if ((r3 instanceof com.bytedance.android.live.liveinteract.videotalk.utils.i) == true) goto L22;
        r3 = null;
    L22:
        com.bytedance.android.live.liveinteract.videotalk.utils.i r4 = (com.bytedance.android.live.liveinteract.videotalk.utils.i) r3;
        if (r4 == null) goto L25;
        r4.a.clear();
    L25:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r5 = this.h;
        if (r5 == null) goto L32;
        BehaviorSubject<List<tf0.e>> r6 = r5.b;
        if (r6 == null) goto L32;
        List r7 = (List) r6.getValue();
        if (r7 == null) goto L32;
        tf0.e r9 = (tf0.e) CollectionsKt.firstOrNull(r7);
    L34:
        if ((r9 instanceof MultiLinkGuestViewBinder.a) == true) goto L36;
        r9 = null;
    L36:
        MultiLinkGuestViewBinder.a r10 = (MultiLinkGuestViewBinder.a) r9;
        if (r10 == null) goto L39;
        ch0.e r11 = r10.k;
    L40:
        InteractiveSongContext.a r12 = InteractiveSongContext.Companion;
        com.bytedance.live.datacontext.m r13 = m.i().getRoom();
        if (r13 == null) goto L44;
        r0 = (IRoom) r13.getValue();
    L44:
        if (r12.e(r0, je0.d.h()) == false) goto L52;
        Integer r1 = je0.d.h();
        if (r1 == null) goto L48;
        int r2 = r1.intValue();
    L50:
        if (InteractiveSongContext.a.d(r12, r11, r2, false, 4) == false) goto L52;
        boolean r14 = true;
    L53:
        if (r14 == true) goto L55;
    L58:
        if (r14 == false) goto L60;
        return;
    L60:
        if (this.Q == true) goto L62;
        if (r8 == true) goto L62;
        return;
    L62:
        this.Q = false;
        v1(-1);
        return;
    L55:
        if (this.Q == false) goto L57;
        if (r8 == false) goto L58;
    L57:
        this.Q = true;
        v1(0);
        return;
    L48:
        r2 = 0;
    L52:
        r14 = false;
        goto L53
    L39:
        r11 = null;
    L32:
        r9 = null;
        goto L34
    L8:
        if (je0.d.q() == true) goto L10;
    L15:
        this.Q = false;
        v1(-1);
        return;
    L10:
        if (vm2.h.h0().e() == false) goto L17;
        if (this.X == true) goto L17;
        if (je0.d.f() == 16) goto L17;
        goto L15
    }

    public final void l1(boolean r4) {
        if (this.z.getUiLayout() != 16) goto L28;
        ALogger.i("VoiceCommonMultiLinkWindowManager", "handleDanmuGameClip, isShowPlayer: " + this.X + ", isEnd: " + r4);
        com.bytedance.android.live.liveinteract.plantform.base.g r0 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r0 == null) goto L7;
        com.bytedance.android.live.ui.c r1 = r0.y4();
    L9:
        if (r4 == false) goto L15;
        v1(-1);
        if (r1 == null) goto L27;
        r1.n();
        return;
    L27:
        return;
    L15:
        if (je0.d.H() == true) goto L17;
        if (r1 == null) goto L33;
        r1.n();
        return;
    L33:
        return;
    L17:
        if (this.X == false) goto L21;
        v1(qi0.e.a(16));
        if (r1 == null) goto L29;
        r1.k();
        return;
    L29:
        return;
    L21:
        v1(-1);
        if (r1 == null) goto L31;
        r1.n();
        return;
    L31:
        return;
    L7:
        r1 = null;
        goto L9
    }

    public final void n1(qb r6) {
        ng0.e r0 = this.M;
        pn0.f.c r1 = null;
        int r2 = 0;
        if (r0 != null) goto L14;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r3 = this.d;
        if (r3 == null) goto L9;
        ViewGroup r4 = r3.td();
        if (r4 == null) goto L9;
        RadioTextBoardView r5 = (RadioTextBoardView) r4.findViewById(2131383612);
    L11:
        if ((r5 instanceof RadioTextBoardView) == true) goto L13;
        r5 = null;
    L13:
        r0 = new ng0.e(r5, 0, this.C);
    L9:
        r5 = null;
    L14:
        this.M = r0;
        if (r0.b() == true) goto L17;
        return;
    L17:
        if (this.M != null) goto L19;
    L78:
        ng0.e r7 = this.M;
        if (r7 == null) goto L89;
        r7.d(r6);
        return;
    L89:
        return;
    L19:
        if (ng0.e.c(r6) != true) goto L78;
        boolean r8 = r.a;
        if (r.j(Integer.valueOf(this.z.getUiLayout()), 0, 6) == false) goto L58;
        pn0.f r9 = this.z.d;
        if (r9 == null) goto L27;
        List<pn0.f.c> r10 = r9.d;
        if (r10 == null) goto L27;
        int r11 = r10.size();
    L28:
        if (r11 <= 0) goto L85;
        pn0.f r12 = this.z.d;
        if (r12 == null) goto L34;
        List<pn0.f.c> r13 = r12.d;
        if (r13 == null) goto L34;
        r1 = (pn0.f.c) CollectionsKt.firstOrNull(r13);
    L34:
        if (r1 == null) goto L36;
        int r14 = r1.c;
    L37:
        Integer r15 = Integer.valueOf(r14);
        if (r1 == null) goto L40;
        int r16 = r1.d;
    L41:
        Pair r17 = TuplesKt.to(r15, Integer.valueOf(r16));
        if (r1 == null) goto L44;
        int r18 = r1.e;
    L45:
        Integer r19 = Integer.valueOf(r18);
        if (r1 == null) goto L48;
        int r20 = r1.f;
    L49:
        Pair r21 = TuplesKt.to(r19, Integer.valueOf(r20));
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r22 = this.d;
        if (r22 == null) goto L54;
        ConstraintLayout.LayoutParams r23 = r22.getCurRvLayoutParams();
        if (r23 == null) goto L54;
        r2 = ((ViewGroup.MarginLayoutParams) r23).topMargin;
    L54:
        ng0.e r24 = this.M;
        if (r24 == null) goto L82;
        r24.a((r2 + ((Number) r17.getSecond()).intValue()) + ((Number) r21.getSecond()).intValue(), r6);
        return;
    L82:
        return;
    L48:
        r20 = 0;
        goto L49
    L44:
        r18 = 0;
        goto L45
    L40:
        r16 = 0;
        goto L41
    L36:
        r14 = 0;
        goto L37
    L85:
        return;
    L27:
        r11 = 0;
        goto L28
    L58:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r25 = this.d;
        if (r25 == null) goto L63;
        RecyclerView r26 = r25.getRecyclerView();
        if (r26 == null) goto L63;
        int r27 = r26.getChildCount();
    L64:
        if (r27 <= 0) goto L86;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r28 = this.d;
        if (r28 == null) goto L87;
        ug0.a r29 = r28.getRvLayoutManager();
        if (r29 == null) goto L88;
        Pair<Integer, Integer> r30 = r29.c(0);
        Pair<Integer, Integer> r31 = r29.a(0);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r32 = this.d;
        if (r32 == null) goto L74;
        RecyclerView r33 = r32.getRecyclerView();
        if (r33 == null) goto L74;
        r2 = r33.getTop();
    L74:
        ng0.e r34 = this.M;
        if (r34 == null) goto L83;
        r34.a((r2 + ((Number) r30.getSecond()).intValue()) + ((Number) r31.getSecond()).intValue(), r6);
        return;
    L83:
        return;
    L88:
        return;
    L87:
        return;
    L86:
        return;
    L63:
        r27 = 0;
        goto L64
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        G0((KVData) r1);
    }

    public final void onMessage(final tlc.d r7) {
        LinkMicRecyclerView r1 = null;
        View r2 = null;
        if ((r7 instanceof w8) == false) goto L58;
        w8 r8 = (w8) r7;
        if (r8.isThanksInteractEmoji() == false) goto L10;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.b() == true) goto L10;
        return;
    L10:
        if (r8.isFriendTreeInteractEmoji() == false) goto L13;
        return;
    L13:
        if (r8.isSoundEmoji() == false) goto L15;
        this.I.d(r8);
    L15:
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L20;
        ih0.b r3 = r0.dynamicService(this.C);
        if (r3 == null) goto L20;
        ih0.c r4 = r3.Z9();
    L21:
        StringBuilder r5 = new StringBuilder("getHeadPointList hybridView: ");
        r5.append(r4);
        r5.append('-');
        if (r4 == null) goto L24;
        View r6 = r4.S0();
    L25:
        r5.append(r6 instanceof AnnieCard);
        r5.append(" ;hybridView.getHybridView(): ");
        if (r4 == null) goto L28;
        View r9 = r4.getHybridView();
    L29:
        r5.append(r9);
        r5.append('-');
        if (r4 == null) goto L32;
        View r10 = r4.getHybridView();
    L33:
        r5.append(r10 instanceof LynxView);
        ALogger.d("VoiceCommonMultiLinkWindowManager", r5.toString());
        if (BaseMultiLinkWindowManager.t0(r4) == false) goto L56;
        if (r4 == null) goto L38;
        r2 = r4.getHybridView();
    L38:
        if ((r2 instanceof LynxView) == false) goto L100;
        IBaseUser r11 = r8.getFromUser();
        if (r11 == null) goto L43;
        String r12 = r11.getIdString();
        if (r12 == null) goto L43;
    L44:
        Intrinsics.checkNotNullParameter(r12, "uid");
        int r13 = k(r12);
        LynxView r14 = r4.getHybridView();
        if (r14 == null) goto L55;
        View r15 = r14.findViewByName("micseat_container_" + r13);
        LynxView r16 = r4.getHybridView();
        if (r16 == null) goto L53;
        View r17 = r16.findViewByName("micseat_guest_avatar_" + r13);
        if ((r15 instanceof ViewGroup) == false) goto L101;
        if (r17 == null) goto L102;
        SeatAnimManager r18 = this.J;
        int r19 = p.a;
        r18.c(p.a(ag1.b.a(r8)), r8, (ViewGroup) r15, r17);
        return;
    L102:
        return;
    L101:
        return;
    L53:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.LynxView");
    L55:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.LynxView");
    L43:
        r12 = "";
        goto L44
    L100:
        return;
    L56:
        SeatAnimManager r20 = this.J;
        int r21 = p.a;
        r20.b(p.a(ag1.b.a(r8)));
        return;
    L32:
        r10 = null;
        goto L33
    L28:
        r9 = null;
        goto L29
    L24:
        r6 = null;
    L20:
        r4 = null;
        goto L21
    L58:
        if ((r7 instanceof com.bytedance.android.livesdk.link.model.bridge.h1) == false) goto L71;
        com.bytedance.android.livesdk.link.model.bridge.h1 r22 = (com.bytedance.android.livesdk.link.model.bridge.h1) r7;
        if (r22.getMType() != 53) goto L105;
        ILinkerChangeMediaInfoContent r23 = r22.getLinkerChangeMediaInfoContent();
        if (r23 == null) goto L106;
        ILinkmicMediaParam r24 = r23.getLinkmicMediaParam();
        if (r24 == null) goto L107;
        k0 r25 = r24.getUpdateMediaInfoNotify();
        if (r25 != null) goto L68;
        return;
    L68:
        if (r25.getNeedUpdate() == false) goto L109;
        int r26 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.b.a;
        String r27 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.b.a((int) r25.getPosition());
        this.D.ca(com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.b.b((int) r25.getPosition()), r27);
        return;
    L109:
        return;
    L107:
        return;
    L106:
        return;
    L105:
        return;
    L71:
        if ((r7 instanceof qb) == false) goto L111;
        boolean r28 = r.a;
        int r29 = 0;
        if (r.j(Integer.valueOf(this.z.getUiLayout()), 0, 6) == false) goto L75;
        n1((qb) r7);
        return;
    L75:
        View r30 = this.y.findViewById(2131383612);
        boolean r31 = r30 instanceof RadioTextBoardView;
        Object r32 = r30;
        if (r31 == true) goto L79;
        r32 = null;
    L79:
        if (((RadioTextBoardView) r32) == null) goto L87;
        int r33 = ng0.e.f;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r34 = this.d;
        if (r34 == null) goto L84;
        r1 = r34.getRecyclerView();
    L84:
        if (ng0.e.a.a(r1) == false) goto L87;
        n1((qb) r7);
        return;
    L87:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r35 = this.d;
        if (r35 == null) goto L92;
        RecyclerView r36 = r35.getRecyclerView();
        if (r36 == null) goto L92;
        r29 = r36.getChildCount();
    L92:
        if (r29 <= 0) goto L98;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r37 = this.d;
        if (r37 == null) goto L114;
        ViewGroup r38 = r37.td();
        if (r38 == null) goto L115;
        int r39 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.e;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.a.a(r38, new AnonymousClass2(this, r7));
        return;
    L115:
        return;
    L114:
        return;
    L98:
        this.L = (qb) r7;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final int qq(int r3) {
        if (this.z.getUiLayout() == 22) goto L10;
        if (r3 == 4) goto L8;
        return s1.j(2131169273);
    L8:
        return s1.f(90.0f);
    L10:
        return s1.j(2131169274);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void setDynamicAnimatorListener(Function0<Unit> r2) {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 == null) goto L8;
        ug0.a r1 = r0.getRvLayoutManager();
        if (r1 == null) goto L9;
        r1.setDynamicAnimatorListener(r2);
        return;
    L9:
        return;
    }

    public final void v1(int r5) {
        Path r0 = new Path();
        if (((Boolean) s2.a.getValue()).booleanValue() == true) goto L5;
    L9:
        float r2 = 0.0f;
        float r1 = 0.0f;
    L10:
        com.bytedance.android.live.liveinteract.videotalk.utils.c r3 = this.b;
        if (r3 == null) goto L13;
        Path r6 = r3.a(r5, r2, r1);
    L14:
        r0.addPath(r6);
        com.bytedance.android.live.liveinteract.plantform.base.g r7 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r7 == null) goto L20;
        com.bytedance.android.live.ui.c r8 = r7.y4();
        if (r8 == null) goto L21;
        r8.o(r0);
        return;
    L21:
        return;
    L20:
        return;
    L13:
        r6 = new Path();
        goto L14
    L5:
        if (this.z.getUiLayout() != 27) goto L7;
    L8:
        r2 = s1.f(8.0f);
        r1 = s1.f(8.0f);
        goto L10
    L7:
        if (this.z.getUiLayout() != 30) goto L9;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, vg0.a
    public final void w1(MultiLinkGuestViewBinder.a r13) {
        Intrinsics.checkNotNullParameter(r13, "itemData");
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 != null) goto L5;
    L16:
        com.bytedance.live.datacontext.m r1 = m.i().getRoom();
        String r2 = null;
        if (r1 == null) goto L19;
        IRoom r3 = (IRoom) r1.getValue();
    L20:
        boolean r4 = v0(r13.k.a.getUser());
        ILinkPlayerInfoBridge r5 = r13.k.a;
        IBaseUser r6 = r5.getUser();
        if (r6 == null) goto L23;
        String r7 = r6.getIdString();
    L24:
        if (r3 == null) goto L26;
        String r8 = r3.getOwnerUserIdString();
    L28:
        if (Intrinsics.areEqual(r7, r8) == false) goto L31;
        boolean r9 = tb1.d.a;
        this.C.put("cmd_open_interact_manage_dialog_by_anchor", Boolean.TRUE);
        BaseMultiLinkWindowManager.B0(r13);
        return;
    L31:
        BaseMultiLinkWindowManager.B0(r13);
        if (r4 == false) goto L48;
        if (((IInteractService) jc1.k.n(IInteractService.class)).isEnableTalkRoomEmoji() == false) goto L48;
        DataCenter r10 = this.C;
        if (r5.getSilenceStatus() == 0) goto L38;
        boolean r11 = true;
    L39:
        r10.put("data_self_is_silenced", Boolean.valueOf(r11));
        if (hd0.c.f().h() == false) goto L44;
        t r12 = new t();
        r12.e(getContext());
        r12.f(this.C);
        r12.g(true);
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r12.d = "seat";
        r12.c().a();
        return;
    L44:
        if (hd0.c.f().g() == false) goto L48;
        xs2.b.a().post(new UserProfileEvent(r5.getUser()).setClickUserPosition("linked_audience_multiaudience").setReportSource("audience_audio").setReportType("data_card_linked_audience_mutiaudience").setShowSendGift(true));
        return;
    L38:
        r11 = false;
    L48:
        if (je0.d.c0() == true) goto L50;
    L69:
        boolean r14 = hd0.c.f().h();
        boolean r15 = jc1.k.n(IMiddlewareUserService.class).user().c();
        if (this.n == true) goto L92;
        if (r15 == false) goto L75;
        if (r14 == true) goto L92;
        int r16 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        if (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.b(r5) == true) goto L92;
    L75:
        if (r4 == true) goto L92;
        if (r15 == false) goto L86;
        if (r14 == true) goto L86;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.b r17 = MultiRevenueDataContext.a.b();
        Intrinsics.checkNotNull(r17);
        yi0.a r18 = r17.d(getContext(), r5);
        if (r18 != null) goto L82;
        return;
    L82:
        if (DialogLancet.shouldBlockDialogShow(r18) == false) goto L102;
        DialogLancet.handleBlockedDialogShow(r18);
        return;
    L102:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L98
    L85:
        DialogLancet.beforeDialogShow(r18);
        r18.show();
        DialogLancet.afterDialogShow(r18);
        return;
    L86:
        IBaseUser r19 = r5.getUser();
        if (r19 == null) goto L90;
        r2 = r19.getIdString();
    L90:
        if ((!Intrinsics.areEqual(r2, BaseMultiLinkWindowManager.R0())) == false) goto L107;
        xs2.b.a().post(new UserProfileEvent(r5.getUser()).setClickUserPosition("linked_audience_multiaudience").setReportSource("audience_audio").setReportType("data_card_linked_audience_mutiaudience").setShowSendGift(true));
        return;
    L107:
        return;
    L92:
        com.bytedance.android.live.liveinteract.voicechat.dialog.p r110 = new com.bytedance.android.live.liveinteract.voicechat.dialog.p(getContext(), this.C, r5, this.n);
        r110.G = "seat";
        if (DialogLancet.shouldBlockDialogShow(r110) == false) goto L100;
        DialogLancet.handleBlockedDialogShow(r110);
        return;
    L100:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L99
    L96:
        DialogLancet.beforeDialogShow(r110);
        r110.show();
        DialogLancet.afterDialogShow(r110);
        return;
    L50:
        if (this.n == true) goto L54;
        if (r4 == true) goto L69;
        if (hd0.c.f().h() == false) goto L69;
    L54:
        ih0.d r20 = this.O;
        if ((r20 instanceof VoiceChatInteractEmojiPanel) == false) goto L60;
        if (r20 == null) goto L60;
        if (r20.p() != true) goto L60;
        return;
    L60:
        Context r21 = getContext();
        DataCenter r22 = this.C;
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r22, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "userInfo");
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        int r23 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        boolean r111 = true ^ com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.b(r5);
        if (hg6.i.a() == false) goto L63;
        ih0.d r112 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.j;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r5, "seat", false);
    L67:
        this.O = r112;
        r112.a();
        return;
    L63:
        VoiceChatInteractEmojiPanel r24 = new VoiceChatInteractEmojiPanel(r21, r22, r5);
        Intrinsics.checkNotNullParameter("seat", "<set-?>");
        r24.k = "seat";
        r24.r = r111;
        tb6.c r113 = r24.x;
        if (r113 == null) goto L66;
        r113.a();
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r113.d = "seat";
    L66:
        r112 = r24;
        goto L67
    L26:
        r8 = null;
        goto L28
    L23:
        r7 = null;
        goto L24
    L19:
        r3 = null;
        goto L20
    L5:
        if (r0.isEngineOn() == true) goto L16;
        o r25 = m.l(this.C, 0L);
        if (r25 == null) goto L16;
        com.bytedance.live.datacontext.m r26 = r25.getCleanMode();
        if (r26 == null) goto L16;
        if (((Number) r26.getValue()).intValue() != 2) goto L16;
        if (vm2.e.h() == false) goto L16;
        ALogger.w("VoiceCommonMultiLinkWindowManager", "rejected guest stub click for pure clean mode");
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean wc(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return this.J.f(r2);
    }

    public final void x1(int r15) {
        ALogger.d("VoiceCommonMultiLinkWindowManager", "updateLinkedPosition toPosition  : " + r15);
        if (((Boolean) vm2.d.U5.getValue(null, vm2.d.a[356(0x164, float:4.99E-43)])).booleanValue() == true) goto L6;
        return;
    L6:
        if (this.P == false) goto L8;
        return;
    L8:
        this.P = true;
        com.bytedance.live.datacontext.m r0 = m.i().getRoom();
        if (r0 == null) goto L15;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L16;
        long r2 = System.currentTimeMillis();
        this.e.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateLinkerPosition(r1.getId(), r1.getId(), r15, 5).subscribeOn(Schedulers.io()).flatMap(i.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this, r15, r2), new k(this, r15, r2)));
        int r3 = zl(BaseMultiLinkWindowManager.R0());
        TalkRoomLogUtils.p1(r3, r15, Integer.valueOf(li0.d.d(r3)), Integer.valueOf(li0.d.d(r15)));
        return;
    L16:
        return;
    }

    public final void y1(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void z1(boolean r4) {
        if (r4 == false) goto L11;
        int r1 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c.i;
        Integer r2 = je0.d.h();
        if (r2 == null) goto L7;
        int r3 = r2.intValue();
    L9:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c.a.a(r3) == false) goto L11;
        return;
    L7:
        r3 = 0;
    L11:
        if (r4 == false) goto L13;
        int r5 = -s1.f(90.0f);
    L14:
        ObjectAnimator.ofFloat(this.y, "translationY", new float[]{r5}).setDuration(300).start();
        return;
    L13:
        r5 = 0;
        goto L14
    }

    public final void z2(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final int zl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return k(r2);
    }

    public final void C2(long r1, ExtraResponse<? extends IJoinChannelResult, Extra> r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final EPointF C7(int r1, int r2) {
        return h1(r1);
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

    @Override // com.bytedance.android.live.liveinteract.animation.InteractAnimationController.d
    public final EmojiSoundManager I8(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fromUid");
        Intrinsics.checkNotNullParameter(r3, "toUid");
        return this.I;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, vg0.a
    public final void K3(MultiLinkNormalEmptyViewBinder.a r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r19, "itemData");
        ALogger.d("VoiceCommonMultiLinkWindowManager", "onEmptyStubClick itemData:" + r19.b());
        Integer r2 = je0.d.h();
        if (r2 != null) goto L6;
    L87:
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == true) goto L90;
    L96:
        int r3 = r19.t;
        if (r3 >= 0) goto L100;
        r3 = r19.b();
    L100:
        int r4 = r3;
        int r5 = r19.b();
        com.bytedance.live.datacontext.m r6 = m.i().getRoom();
        if (r6 == null) goto L238;
        IRoom r8 = (IRoom) r6.getValue();
        if (r8 != null) goto L106;
        return;
    L106:
        if (this.n == false) goto L108;
        M(r20, "seat", r4);
        return;
    L108:
        Integer r7 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r7 != null) goto L112;
    L137:
        Integer r9 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r9 != null) goto L141;
    L198:
        boolean r1 = false;
        int r10 = bh0.a.a;
        if (r20 == false) goto L201;
        int r11 = 104;
    L203:
        if (this.z.j() == 9) goto L209;
        com.bytedance.live.datacontext.m r12 = m.d().I1();
        if (r12 != null) goto L208;
    L210:
        if (r1 == false) goto L212;
        r4 = -1;
    L212:
        u1(r4, r11, "linkin_empty_stub_click");
        return;
    L208:
        if (((Boolean) r12.getValue()).booleanValue() != true) goto L210;
    L209:
        r1 = true;
        goto L210
    L201:
        r11 = 101;
        goto L203
    L141:
        if (2 != r9.intValue()) goto L198;
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r13 = IVoiceChatAdminService.a.a();
        if (r13 == null) goto L145;
        MuteStateChecker r14 = r13.muteChecker();
    L146:
        if (r14 == null) goto L152;
        IVoiceChatAdminService r15 = IVoiceChatAdminService.a.a();
        if (r15 == null) goto L152;
        MuteStateChecker r16 = r15.muteChecker();
        if (r16 == null) goto L152;
        r16.a("empty_stub", false);
    L152:
        int r17 = h1.a;
        com.bytedance.android.live.liveinteract.revenue.fight.b r18 = ((IInteractService) jc1.k.n(IInteractService.class)).teamFightService();
        if (r18 != null) goto L155;
    L157:
        boolean r21 = false;
    L158:
        if (r21 == false) goto L165;
        if (li0.d.g(null) == true) goto L165;
        if (li0.d.d(zl(BaseMultiLinkWindowManager.R0())) == li0.d.d(r5)) goto L165;
        f2.b(2131922784, 0);
    L165:
        if (r20 == false) goto L180;
        Integer r22 = je0.d.h();
        if (r22 != null) goto L170;
    L177:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.util.d.e(r20, -1);
        return;
    L170:
        if (r22.intValue() != 26) goto L177;
        if (r19.b() != 1) goto L177;
        if (jc1.k.n(IMiddlewareUserService.class).user().E(Long.valueOf(r8.getRoomId())) == true) goto L177;
        f2.b(2131923204, 0);
        return;
    L180:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.util.d.a(this.n) == true) goto L182;
        x1(r4);
        return;
    L182:
        if (((Boolean) vm2.d.Y6.getValue(null, vm2.d.a[412(0x19c, float:5.77E-43)])).booleanValue() == true) goto L184;
        Context r23 = getContext();
        Boolean r24 = Boolean.TRUE;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.util.d.f(r23, r8, r4, r20, r24, r24, new VoiceCommonMultiLinkWindowManager$onEmptyStubClickedWithGuideShow$2(this));
        return;
    L184:
        Integer r25 = je0.d.h();
        if (r25 != null) goto L188;
    L195:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.util.d.e(r20, r4);
        return;
    L188:
        if (r25.intValue() != 26) goto L195;
        if (r19.b() != 1) goto L195;
        if (jc1.k.n(IMiddlewareUserService.class).user().E(Long.valueOf(r8.getRoomId())) == true) goto L195;
        f2.b(2131923204, 0);
        return;
    L155:
        if (r18.u5() != true) goto L157;
        r21 = true;
        goto L158
    L145:
        r14 = null;
        goto L146
    L112:
        if (1 != r7.intValue()) goto L137;
        if (h1.a() == false) goto L117;
        h1.f(j0.a(this.C), getContext(), this.C);
        return;
    L117:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.a.a(r8) == false) goto L124;
        ChatRoomGuestAppliedDialog r26 = new ChatRoomGuestAppliedDialog(getContext(), this.C, new d(this, r8));
        if (DialogLancet.shouldBlockDialogShow(r26) == false) goto L216;
        DialogLancet.handleBlockedDialogShow(r26);
        return;
    L216:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L214
    L122:
        DialogLancet.beforeDialogShow(r26);
        r26.show();
        DialogLancet.afterDialogShow(r26);
        return;
    L124:
        if (com.bytedance.android.live.liveinteract.plantform.utils.s0.a(r8) == false) goto L129;
        int r110 = r19.b();
        Intrinsics.checkNotNullParameter(r8, PbRequest.SwitchType.ROOM);
        ILinkPanelService r27 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r27 == null) goto L232;
        r27.pj(getContext(), r8, null, "seat", r110);
        return;
    L232:
        return;
    L129:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.a.b() == false) goto L131;
        q1(false, r8);
        return;
    L131:
        com.bytedance.android.live.liveinteract.voicechat.dialog.g r28 = new com.bytedance.android.live.liveinteract.voicechat.dialog.g(getContext(), this.C, r8);
        if (DialogLancet.shouldBlockDialogShow(r28) == false) goto L218;
        DialogLancet.handleBlockedDialogShow(r28);
        return;
    L218:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L215
    L135:
        DialogLancet.beforeDialogShow(r28);
        r28.show();
        DialogLancet.afterDialogShow(r28);
        return;
    L238:
        return;
    L90:
        if (this.n == false) goto L95;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r29 = IVoiceChatGuestService.a.a();
        if (r29 == null) goto L96;
        if (r29.isEngineOn() == true) goto L96;
    L95:
        xs2.b.a().post(new com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.h());
        goto L96
    L6:
        if (r2.intValue() != 65) goto L87;
        ni0.e r30 = new ni0.e();
        Context r31 = getContext();
        Intrinsics.checkNotNullParameter(r31, "context");
        if ((System.currentTimeMillis() - r30.b) < 1000) goto L228;
        r30.b = System.currentTimeMillis();
        com.bytedance.live.datacontext.m r32 = m.i().getRoom();
        if (r32 == null) goto L19;
        IRoom r33 = (IRoom) r32.getValue();
        if (r33 == null) goto L19;
        if (r33.getVisibilityRange() != 16) goto L19;
        if (je0.d.D() == true) goto L19;
        f2.c("仅支持房主邀请好友", 0);
        return;
    L19:
        IHostSocial r34 = jc1.k.n(IHostSocial.class);
        IMiddlewareHostSocial.ICommonInviteParams r35 = new IMiddlewareHostSocial.ICommonInviteParams();
        String r36 = qi0.c.h();
        com.bytedance.live.datacontext.m r111 = m.i().getRoom();
        if (r111 == null) goto L24;
        IRoom r112 = (IRoom) r111.getValue();
        if (r112 == null) goto L24;
        Integer r113 = Integer.valueOf(r112.getVisibilityRange());
    L25:
        String r114 = "";
        if (r113 != null) goto L29;
    L31:
        if (r113 != null) goto L34;
    L36:
        String r115 = "";
    L37:
        r35.setContext(r31);
        r35.setInitHeight(Integer.valueOf((int) (((double) UIUtils.getScreenHeight(jc1.a.b())) * 0.8d)));
        r35.setScene(r115);
        r35.setSelectType(IMiddlewareHostSocial.ICommonInviteParams.ISelectTypeEnum.MULTI_SELECT_RIGHT);
        r35.setBottomBtnText("邀请一起玩");
        HashMap r116 = new HashMap();
        r116.put("conversation_id", r36);
        Unit r117 = Unit.INSTANCE;
        r35.setExtMap(r116);
        HashMap r118 = new HashMap();
        com.bytedance.live.datacontext.m r119 = m.i().getRoom();
        if (r119 == null) goto L42;
        IRoom r120 = (IRoom) r119.getValue();
        if (r120 == null) goto L42;
        Integer r121 = Integer.valueOf(r120.getVisibilityRange());
    L43:
        if (r121 != null) goto L46;
    L48:
        if (r121 != null) goto L51;
    L53:
        r118.put("chat_type", r114);
        r118.put("conversation_id", r36);
        r118.put("live_type", ((IInteractService) jc1.k.n(IInteractService.class)).getLiveTypeForLog());
        r118.put("function_type2", ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionTypeForLog());
        r118.put("anchor_id", je0.d.a());
        r118.put("room_id", String.valueOf(je0.d.a0()));
        r118.put("game_id", qi0.c.i());
        r118.put("game_name", qi0.c.j());
        r118.put("enter_from", "co_play_game");
        r118.put("enter_method", "click_co_play_game");
        r35.setMobMap(r118);
        long r122 = System.currentTimeMillis();
        ArrayList r37 = new ArrayList();
        Iterable r38 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter().getOnlineUserList();
        if (r38 == null) goto L68;
        Iterable r39 = r38;
        ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r39, 10));
        Iterator r40 = r39.iterator();
    L57:
        if (r40.hasNext() == false) goto L67;
        ILinkPlayerInfoBridge r124 = (ILinkPlayerInfoBridge) r40.next();
        IBaseUser r125 = r124.getUser();
        if (r125 == null) goto L61;
        String r41 = r125.getUserId();
    L62:
        IBaseUser r126 = r124.getUser();
        if (r126 == null) goto L65;
        Intrinsics.checkNotNullParameter(r126, "$this$secUidExt");
        String r42 = r126.getCastSecUid();
    L66:
        r123.add(new IMiddlewareHostSocial.ICommonInviteParams.ISelectedContact(r41, r42));
        goto L57
    L65:
        r42 = null;
        goto L66
    L61:
        r41 = null;
        goto L62
    L67:
        ALogger.i("GroupLiveGameInviteUtils", "getDisableInviteUserList, onlineUserList: " + r123);
        r37.addAll(r123);
    L68:
        Map<String, Long> r43 = ni0.e.c;
        if (r43 == null) goto L85;
        LinkedHashMap r44 = new LinkedHashMap();
        Iterator r45 = ((LinkedHashMap) r43).entrySet().iterator();
    L72:
        if (r45.hasNext() == false) goto L80;
        Map.Entry r46 = (Map.Entry) r45.next();
        long r127 = r122;
        if ((r122 - ((Number) r46.getValue()).longValue()) >= r30.a) goto L76;
        boolean r128 = true;
    L77:
        if (r128 == false) goto L79;
        r44.put(r46.getKey(), r46.getValue());
    L79:
        r122 = r127;
        goto L72
    L76:
        r128 = false;
        goto L77
    L80:
        ArrayList r47 = new ArrayList(r44.size());
        Iterator r48 = r44.entrySet().iterator();
    L82:
        if (r48.hasNext() == false) goto L84;
        r47.add(new IMiddlewareHostSocial.ICommonInviteParams.ISelectedContact((String) ((Map.Entry) r48.next()).getKey(), null));
        goto L82
    L84:
        ALogger.i("GroupLiveGameInviteUtils", "getDisableInviteUserList, inviteSuccessUserList: " + r47);
        r37.addAll(r47);
    L85:
        r35.setDisableUserList(r37);
        r35.setClickCallback(new ni0.h(r30, r31));
        ALogger.i("GroupLiveGameInviteUtils", "showInvitePage，roomVisibilityRange: " + r113 + ", params: " + r35.getMobMap());
        Unit r49 = Unit.INSTANCE;
        r34.showNewInviteFriendActivity(r35);
        return;
    L51:
        if (17 != r121.intValue()) goto L53;
        r114 = "group";
        goto L53
    L46:
        if (16 != r121.intValue()) goto L48;
        r114 = "private";
    L42:
        r121 = null;
        goto L43
    L34:
        if (17 != r113.intValue()) goto L36;
        r115 = IMiddlewareHostSocial.ICommonInviteParams.IChatSceneTypeEnum.GROUP_PLAY_GAME_INVITE.getValue();
        goto L37
    L29:
        if (16 != r113.intValue()) goto L31;
        r115 = IMiddlewareHostSocial.ICommonInviteParams.IChatSceneTypeEnum.SINGLE_PLAY_GAME_INVITE.getValue();
    L24:
        r113 = null;
        goto L25
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean K5(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "fromUserId");
        Intrinsics.checkNotNullParameter(r5, "toUSerId");
        SeatAnimManager r0 = this.J;
        SeatAnimationView r6 = (SeatAnimationView) ((LinkedHashMap) r0.a).get(r4);
        if (r6 == null) goto L6;
        SeatAnimTaskState r7 = r6.getTaskState();
        if (r7 == null) goto L6;
    L7:
        SeatAnimationView r8 = (SeatAnimationView) ((LinkedHashMap) r0.a).get(r5);
        if (r8 == null) goto L11;
        SeatAnimTaskState r9 = r8.getTaskState();
        if (r9 == null) goto L11;
    L12:
        SeatAnimTaskState r1 = SeatAnimTaskState.LINK_SUC_ANIM;
        if (r7 == r1) goto L20;
        if (r9 == r1) goto L20;
        SeatAnimTaskState r2 = SeatAnimTaskState.REVENUE_DRESS_ANIM;
        if (r7 == r2) goto L20;
        if (r9 == r2) goto L20;
        boolean r10 = false;
    L21:
        if (r10 == false) goto L24;
        return false;
    L24:
        if (this.z.getUiLayout() == 24) goto L26;
        return true;
    L26:
        if (r.j(null, 0, 7) == false) goto L33;
        ih0.b r11 = MultiLinkDynamicContext.Companion.a(this.C, null);
        if (r11 != null) goto L30;
    L31:
        return true;
    L30:
        if (r11.isDynamicAnimating() != true) goto L31;
        return false;
    L33:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r12 = this.d;
        if (r12 != null) goto L36;
    L37:
        return true;
    L36:
        if (r12.gg() != true) goto L37;
        return false;
    L20:
        r10 = true;
    L11:
        r9 = SeatAnimTaskState.IDLE;
    L6:
        r7 = SeatAnimTaskState.IDLE;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [android.widget.TextView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [android.widget.TextView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v17 */
    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final ArrayList Ka(int r8, float r9) {
        ArrayList<AnimatorSet> r0 = this.S.get(Integer.valueOf(r8));
        View r1 = null;
        PaidLinkCountDownView r2 = null;
        r2 = null;
        r2 = null;
        if (r0 == null) goto L10;
        Iterator<AnimatorSet> r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        if (r3.next().isRunning() == false) goto L6;
        return null;
    L10:
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        r4.element = new ArrayList();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r5 = this.d;
        if (r5 == null) goto L15;
        LinkMicRecyclerView r6 = r5.getRecyclerView();
        if (r6 == null) goto L15;
        RecyclerView.ViewHolder r7 = r6.findViewHolderForAdapterPosition(r8);
    L17:
        if ((r7 instanceof MultiLinkAudioFirstUserVirtualAvatarViewBinder.ItemViewHolder) == false) goto L19;
        return null;
    L19:
        IInteractService r10 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r10 == null) goto L24;
        ih0.b r11 = r10.dynamicService(this.C);
        if (r11 == null) goto L24;
        ih0.c r12 = r11.Z9();
    L26:
        if (BaseMultiLinkWindowManager.t0(r12) == false) goto L36;
        if (r12 == null) goto L29;
        View r13 = r12.getHybridView();
    L30:
        LynxView r14 = (LynxView) r13;
        if (r14 == null) goto L33;
        View r15 = r14.findViewByName("micseat_guest_avatar_ct_" + r8);
    L34:
        ?? r16 = null;
        HSImageView r17 = null;
        r1 = r15;
        ?? r18 = 0;
    L72:
        if (r1 != null) goto L74;
    L76:
        if (r16 != null) goto L78;
    L84:
        if (r17 != null) goto L86;
    L88:
        if (r18 != 0) goto L90;
    L92:
        int r19 = m0.a;
        AnimatorSet r20 = m0.a((ArrayList) r4.element, 1.0f, r9, 250);
        Ref.ObjectRef r21 = new Ref.ObjectRef();
        r21.element = m0.a((ArrayList) r4.element, r9, 1.0f, 200);
        r20.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r20.addListener(new com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.wm.e(this, r21, r8, r4));
        AnimatorSet r22 = (AnimatorSet) r21.element;
        if (r22 == null) goto L95;
        r22.addListener(new com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.wm.f(this, r8, r4));
    L95:
        ArrayList<AnimatorSet> r23 = new ArrayList();
        Intrinsics.checkNotNull(r20);
        r23.add(r20);
        AnimatorSet r24 = (AnimatorSet) r21.element;
        Intrinsics.checkNotNull(r24);
        r23.add(r24);
        r20.start();
        this.S.put(Integer.valueOf(r8), r23);
        return r23;
    L90:
        if (r18.getVisibility() != 0) goto L92;
        ((ArrayList) r4.element).add(r18);
        goto L92
    L86:
        if (r17.getVisibility() != 0) goto L88;
        ((ArrayList) r4.element).add(r17);
        goto L88
    L78:
        if (r16.getVisibility() != 0) goto L84;
        ((ArrayList) r4.element).add(r16);
        ArrayList r25 = (ArrayList) r4.element;
        ViewParent r26 = r16.getParent();
        if (r26 == null) goto L83;
        r25.add((ViewGroup) r26);
        goto L84
    L83:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L74:
        if (r1.getVisibility() != 0) goto L76;
        ((ArrayList) r4.element).add(r1);
        goto L76
    L33:
        r15 = null;
        goto L34
    L29:
        r13 = null;
        goto L30
    L36:
        if ((r7 instanceof hg0.b) == false) goto L71;
        hg0.b r27 = (hg0.b) r7;
        jg0.g r28 = r27.l();
        if (r28 == null) goto L44;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r29 = r28.h();
        if (r29 == null) goto L44;
        View r30 = r29.l();
        if (r30 == null) goto L44;
        ImageView r31 = (ImageView) r30.findViewById(2131389564);
    L45:
        jg0.g r32 = r27.l();
        if (r32 == null) goto L52;
        pg0.e r33 = r32.s();
        if (r33 == null) goto L52;
        View r34 = r33.l();
        if (r34 == null) goto L52;
        PositionNameTv r35 = (PositionNameTv) r34.findViewById(2131389701);
    L53:
        jg0.g r36 = r27.l();
        if (r36 == null) goto L60;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r37 = r36.h();
        if (r37 == null) goto L60;
        View r38 = r37.l();
        if (r38 == null) goto L60;
        r17 = r38.findViewById(2131389466);
    L61:
        jg0.g r39 = r27.l();
        if (r39 == null) goto L68;
        pg0.e r40 = r39.s();
        if (r40 == null) goto L68;
        View r41 = r40.l();
        if (r41 == null) goto L68;
        r2 = (PaidLinkCountDownView) r41.findViewById(2131389700);
    L68:
        if (r2 == null) goto L70;
        r2.setDataCenter(this.C);
    L70:
        r18 = r2;
        r1 = r31;
        r16 = r35;
    L60:
        r17 = null;
    L52:
        r35 = null;
    L44:
        r31 = null;
        goto L45
    L71:
        r18 = 0;
        r16 = null;
        r17 = null;
    L24:
        r12 = null;
    L15:
        r7 = null;
        goto L17
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final EPointF Kl(int r1, int r2) {
        return h1(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void U0(int r1, int r2) {
        super.U0(r1, r2);
        if (this.z.getUiLayout() != 30) goto L5;
    L6:
        i1(true);
    L8:
        if (this.z.getUiLayout() != 16) goto L11;
        l1(false);
        return;
    L11:
        return;
    L5:
        if (this.z.getUiLayout() != 27) goto L8;
        goto L6
    }

    public final void U8(long r1, ExtraResponse<IApplyResult, Extra> r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void W0(tf0.j r1, boolean r2) {
        super.W0(r1, r2);
        if ((r1 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.m) == true) goto L5;
        r1 = null;
    L5:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.m) r1;
        if (r3 != null) goto L8;
    L12:
        l0(d0(), c0());
        i1(true);
        l1(false);
        return;
    L8:
        if (((Boolean) x2.a.getValue()).booleanValue() == false) goto L12;
        if (this.n == false) goto L12;
        this.N.g(r3);
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean W7(EPointF r3, EPointF r4) {
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        if (this.z.getUiLayout() == 65) goto L5;
        return true;
    L5:
        if (((PointF) r3).x != 0.0f) goto L8;
        return false;
    L8:
        if (((PointF) r4).x != 0.0f) goto L12;
        return false;
    L12:
        return true;
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

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final com.bytedance.android.live.liveinteract.videotalk.utils.h Z(int r5, int r6) {
        float r0 = this.z.q(r6);
        float r1 = this.z.s(r5, r6);
        boolean r2 = gh0.b.a;
        gh0.b.a("ScreenAdjust", "createImageViewStrategy, containerWidth = " + r5 + ", containerHeight = " + r6 + ", sx = 0.0, sy = " + r0 + ", windowWidth = " + r5 + ", windowHeight = " + r1, false);
        int r3 = com.bytedance.android.live.liveinteract.videotalk.utils.d.a;
        return com.bytedance.android.live.liveinteract.videotalk.utils.d.a(r5, r6, this.z);
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

    public final void m1(List<ch0.e> r7, String r8) {
        StringBuilder r0 = new StringBuilder("[3d-avatar] handleFirstSeatVirtualAvatar isEnableVirtualAvatarLayer=");
        InteractiveSongContext.a r1 = InteractiveSongContext.Companion;
        View r2 = null;
        r0.append(r1.e(je0.d.e(null), Integer.valueOf(this.z.getUiLayout())));
        r0.append(", source=");
        r0.append(r8);
        ALogger.i("VoiceCommonMultiLinkWindowManager", r0.toString());
        boolean r9 = r.a;
        if (r.j(Integer.valueOf(this.z.getUiLayout()), 0, 6) == true) goto L5;
        return;
    L5:
        String r3 = "";
        if (r1.e(je0.d.e(null), Integer.valueOf(this.z.getUiLayout())) == false) goto L99;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r10 = this.h;
        if (r10 == null) goto L14;
        BehaviorSubject<List<tf0.e>> r11 = r10.b;
        if (r11 == null) goto L14;
        List r12 = (List) r11.getValue();
        if (r12 == null) goto L14;
        tf0.e r13 = (tf0.e) ListProtector.get(r12, 0);
    L15:
        boolean r4 = r13 instanceof MultiLinkAudioFirstUserVirtualAvatarViewBinder.a;
        if (r4 == true) goto L24;
        if (this.z.getUiLayout() == 30) goto L20;
    L22:
        j1(false, null, "");
        return;
    L20:
        if ((r13 instanceof MultiLinkAudioFirstUserViewBinder.a) == false) goto L22;
    L24:
        if (this.z.getUiLayout() == 30) goto L26;
        if (r4 == true) goto L39;
        r13 = null;
    L39:
        MultiLinkAudioFirstUserVirtualAvatarViewBinder.a r14 = (MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) r13;
        if (r14 == null) goto L48;
        ch0.e r15 = r14.k;
        if (r15 == null) goto L48;
        ILinkPlayerInfoBridge r16 = r15.a;
        if (r16 == null) goto L48;
        IBaseUser r17 = r16.getUser();
        if (r17 == null) goto L48;
        String r18 = r17.getIdString();
    L50:
        if (r18 != null) goto L52;
    L55:
        boolean r5 = true;
    L56:
        if (r5 == false) goto L58;
        return;
    L58:
        Iterator<T> r19 = r7.iterator();
    L60:
        if (r19.hasNext() == false) goto L68;
        Object r6 = r19.next();
        IBaseUser r20 = ((ch0.e) r6).a.getUser();
        if (r20 == null) goto L64;
        String r21 = r20.getIdString();
    L66:
        if (Intrinsics.areEqual(r21, r18) == false) goto L60;
    L69:
        ch0.e r22 = (ch0.e) r6;
        InteractiveSongContext.a r23 = InteractiveSongContext.Companion;
        Integer r24 = je0.d.h();
        if (r24 == null) goto L72;
        int r25 = r24.intValue();
    L74:
        if (InteractiveSongContext.a.d(r23, r22, r25, false, 4) == false) goto L87;
        if (r22 == null) goto L79;
        ch0.h r26 = r22.b;
        if (r26 == null) goto L79;
        r2 = r26.b;
    L79:
        if (r22 == null) goto L86;
        ch0.h r27 = r22.b;
        if (r27 == null) goto L86;
        String r28 = r27.a;
        if (r28 == null) goto L86;
        r3 = r28;
    L86:
        j1(true, r2, r3);
        return;
    L87:
        if (r22 == null) goto L91;
        ch0.h r29 = r22.b;
        if (r29 == null) goto L91;
        r2 = r29.b;
    L91:
        if (r22 == null) goto L98;
        ch0.h r30 = r22.b;
        if (r30 == null) goto L98;
        String r31 = r30.a;
        if (r31 == null) goto L98;
        r3 = r31;
    L98:
        j1(false, r2, r3);
        return;
    L72:
        r25 = 0;
        goto L74
    L64:
        r21 = null;
        goto L66
    L68:
        r6 = null;
        goto L69
    L52:
        if (r18.length() == 0) goto L55;
        r5 = false;
    L48:
        r18 = null;
        goto L50
    L26:
        if ((r13 instanceof MultiLinkAudioFirstUserViewBinder.a) == true) goto L28;
        r13 = null;
    L28:
        MultiLinkAudioFirstUserViewBinder.a r32 = (MultiLinkAudioFirstUserViewBinder.a) r13;
        if (r32 == null) goto L48;
        ch0.e r33 = r32.k;
        if (r33 == null) goto L48;
        ILinkPlayerInfoBridge r34 = r33.a;
        if (r34 == null) goto L48;
        IBaseUser r35 = r34.getUser();
        if (r35 == null) goto L48;
        r18 = r35.getIdString();
    L14:
        r13 = null;
        goto L15
    L99:
        j1(false, null, "");
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final int ma(int r7, int r8) {
        IRoom r1 = null;
        if (this.z.getUiLayout() == 22) goto L35;
        if (this.z.getUiLayout() == 24) goto L35;
        if (this.z.getUiLayout() == 28) goto L35;
        if (r7 != 0) goto L103;
        CustomizeStreamContext r0 = CustomizeStreamContext.Companion.getContext();
        if (r0 == null) goto L30;
        com.bytedance.live.datacontext.m<Boolean> r2 = r0.getGuestInCustomizeStreamLayout();
        if (r2 == null) goto L30;
        if (((Boolean) r2.getValue()).booleanValue() != true) goto L30;
        hg0.d r9 = this.i;
        if (r9 == null) goto L100;
        RecyclerView r10 = r9.a;
        if (r10 == null) goto L20;
        RecyclerView.ViewHolder r11 = r10.findViewHolderForAdapterPosition(r7);
    L22:
        if ((r11 instanceof hg0.b) == false) goto L26;
        jg0.g r12 = ((hg0.b) r11).l();
        if (r12 == null) goto L26;
        r1 = r12.q();
    L26:
        if (r1 == null) goto L100;
        return r1.intValue();
    L20:
        r11 = null;
    L100:
        return s1.j(2131168793);
    L30:
        if (r8 == 4) goto L102;
        return s1.j(2131169269);
    L102:
        return s1.f(102.0f);
    L103:
        return s1.j(2131169271);
    L35:
        if (r.j(null, 0, 7) == false) goto L66;
        IInteractService r13 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r13 == null) goto L41;
        ih0.b r14 = r13.dynamicService(this.C);
        if (r14 == null) goto L41;
        ih0.c r15 = r14.Z9();
    L42:
        float r3 = 1.0f;
        if (BaseMultiLinkWindowManager.t0(r15) == false) goto L55;
        if (r15 == null) goto L47;
        r1 = r15.getHybridView();
    L47:
        if ((r1 instanceof LynxView) == false) goto L55;
        LynxView r16 = r15.getHybridView();
        if (r16 == null) goto L54;
        View r17 = r16.findViewByName("micseat_container_" + r7);
        int r18 = dd0.a.a;
        if (r17 == null) goto L65;
        r3 = r17.getScaleX();
    L65:
        return (int) (s1.j(2131169270) * r3);
    L54:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.LynxView");
    L55:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r19 = this.d;
        if (r19 == null) goto L65;
        LinkMicRecyclerView r20 = r19.getRecyclerView();
        if (r20 == null) goto L65;
        RecyclerView.ViewHolder r21 = r20.findViewHolderForAdapterPosition(r7);
        if (r21 == null) goto L65;
        View r22 = r21.itemView;
        if (r22 == null) goto L65;
        r3 = r22.getScaleX();
    L41:
        r15 = null;
        goto L42
    L66:
        Integer r23 = je0.d.h();
        if (r23 != null) goto L70;
    L87:
        com.bytedance.live.datacontext.m r24 = m.i().getRoom();
        if (r24 == null) goto L90;
        r1 = (IRoom) r24.getValue();
    L90:
        if (r1 == null) goto L93;
        String r25 = r1.getOwnerUserIdString();
        if (r25 == null) goto L93;
    L94:
        Intrinsics.checkNotNullParameter(r25, "uid");
        if (r7 != k(r25)) goto L98;
        return s1.j(2131169270);
    L98:
        return s1.j(2131169272);
    L93:
        r25 = "";
        goto L94
    L70:
        if (r23.intValue() != 28) goto L87;
        if (r7 != 0) goto L106;
        hg0.d r26 = this.i;
        if (r26 == null) goto L105;
        RecyclerView r27 = r26.a;
        if (r27 == null) goto L77;
        RecyclerView.ViewHolder r28 = r27.findViewHolderForAdapterPosition(r7);
    L79:
        if ((r28 instanceof hg0.b) == false) goto L83;
        jg0.g r29 = ((hg0.b) r28).l();
        if (r29 == null) goto L83;
        r1 = r29.q();
    L83:
        if (r1 == null) goto L105;
        return r1.intValue();
    L77:
        r28 = null;
    L105:
        return s1.j(2131168793);
    L106:
        return s1.j(2131169271);
    }

    public final void o1(long r1, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
    }

    public final void q1(boolean r3, IRoom r4) {
        Intrinsics.checkNotNullParameter(r4, PbRequest.SwitchType.ROOM);
        String r0 = ChatMatchWidget.o;
        ChatMatchViewModel r1 = (ChatMatchViewModel) com.bytedance.live.datacontext.d.e("ChatMatchWidget", ChatMatchViewModel.class);
        if (r1 == null) goto L5;
        r1.showMatchDialog(r3);
        return;
    L5:
        com.bytedance.android.live.liveinteract.voicechat.dialog.g r5 = new com.bytedance.android.live.liveinteract.voicechat.dialog.g(getContext(), this.C, r4);
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(r5);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final /* bridge */ /* synthetic */ void r(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1, Boolean r2) {
        W0(r1, r2.booleanValue());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void r0(int r2, int r3) {
        l0(r2, r3);
        if (MultiLinkLoadWidgetUtils.g() == true) goto L22;
        com.bytedance.android.live.ui.c r4 = this.a;
        if (r4 == null) goto L23;
        HSImageView r5 = r4.o;
        if (r5 == null) goto L9;
        r5.setAlpha(0.0f);
    L9:
        HSImageView r6 = r4.p;
        if (r6 == null) goto L12;
        r6.setAlpha(0.0f);
    L12:
        com.bytedance.android.live.ui.o r7 = r4.q;
        if (r7 == null) goto L15;
        r7.setThemeViewAlpha(0.0f);
    L15:
        HSImageView r8 = r4.r;
        if (r8 == null) goto L18;
        r8.setAlpha(0.0f);
    L18:
        ImageView r9 = r4.s;
        if (r9 == null) goto L24;
        r9.setAlpha(0.0f);
        return;
    L24:
        return;
    L23:
        return;
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

    public static void u1(int r2, int r3, String r4) {
        ALogger.d("VoiceCommonMultiLinkWindowManager", "tryCheckAndApply position applySource fromSource : " + r2 + " - " + r3 + " - " + r4);
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 == null) goto L6;
        r0.checkAndApply(r2, String.valueOf(r3), LinkApplyType.NORMAL.getValue(), r4);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final int D0(List<ti6.f> r20, Map<String, Integer> r21, Map<String, ? extends Object> r22) {
        Intrinsics.checkNotNullParameter(r20, "list");
        Intrinsics.checkNotNullParameter(r21, "posMap");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c r6 = this.N;
        c r7 = new c(this);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r20, "list");
        Intrinsics.checkNotNullParameter(r21, "posMap");
        Intrinsics.checkNotNullParameter(r7, "listener");
        String r11 = "";
        if (((Boolean) vm2.i.N.getValue(null, vm2.i.a[38])).booleanValue() == false) goto L190;
        wh0.d r8 = r6.d;
        if (r8 == null) goto L189;
        Intrinsics.checkNotNullParameter(r20, "list");
        Intrinsics.checkNotNullParameter(r21, "posMap");
        Intrinsics.checkNotNullParameter(r7, "listener");
        int r4 = wh0.e.a;
        Integer r5 = Integer.valueOf(r8.g.m());
        Integer r9 = Integer.valueOf(r8.g.getUiLayout());
        if (r9 == null) goto L9;
        int r10 = r9.intValue();
    L11:
        if (aj0.b.c(r10) == false) goto L14;
    L12:
        boolean r12 = true;
    L17:
        if (r12 == false) goto L20;
        r8.g(r20, r21, r22, r7);
        return 0;
    L20:
        if (r8.e.f() == false) goto L104;
        if (r8.e.g() != 2) goto L24;
        boolean r3 = true;
    L25:
        Iterator<ti6.f> r13 = r20.iterator();
    L27:
        if (r13.hasNext() == false) goto L90;
        ti6.f r14 = r13.next();
        String r15 = r8.e.i(r14.b);
        if (r15 != null) goto L31;
        r15 = r11;
    L31:
        boolean r16 = Intrinsics.areEqual(r15, r8.e.B5());
        if (r15.length() <= 0) goto L34;
        boolean r17 = true;
    L35:
        if (r17 == true) goto L37;
    L43:
        boolean r18 = false;
    L44:
        int r19 = r7.b(r14.b);
        r14.n = !r18;
        if (r19 < 0) goto L86;
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r110 = r8.a;
        if (r110 == null) goto L59;
        Iterator<T> r111 = r110.iterator();
    L50:
        if (r111.hasNext() == false) goto L57;
        Object r112 = r111.next();
        if (((com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d) r112).c() != r19) goto L54;
        boolean r113 = true;
    L55:
        if (r113 == false) goto L50;
    L58:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d r114 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d) r112;
    L60:
        if (r114 == null) goto L87;
        Pair<Double, Double> r115 = r8.b(r114);
        r21.put(r14.b, Integer.valueOf(r19));
        if (r18 == false) goto L64;
        double r116 = 1.0d;
    L66:
        if (r18 == false) goto L68;
        double r117 = 1.0d;
    L69:
        r14.f = r116;
        r14.g = r117;
        if (r18 == false) goto L72;
        double r118 = 0.0d;
    L73:
        if (r18 == false) goto L75;
        double r119 = 0.0d;
    L76:
        r14.d = r118;
        r14.e = r119;
        if (r18 == false) goto L79;
        int r120 = 1;
    L80:
        r14.a = r120;
        r14.c(r15);
        if (r18 == false) goto L83;
        int r23 = 100;
    L84:
        r14.o = r23;
        r14.l = true;
        r14.m = r3;
        goto L87
    L83:
        r23 = 0;
        goto L84
    L79:
        r120 = 2;
        goto L80
    L75:
        r119 = ((Number) r115.getSecond()).doubleValue();
        goto L76
    L72:
        r118 = ((Number) r115.getFirst()).doubleValue();
        goto L73
    L68:
        r117 = 0.0d;
        goto L69
    L64:
        r116 = 0.0d;
    L87:
        if (r18 == false) goto L89;
        r14.z = true;
    L89:
        r11 = r11;
        goto L27
    L54:
        r113 = false;
        goto L55
    L57:
        r112 = null;
        goto L58
    L59:
        r114 = null;
        goto L60
    L86:
        r14.f = 0.1d;
        r14.g = 0.1d;
        r14.d = 1.0d;
        r14.e = 1.0d;
        r14.l = false;
        r14.m = r3;
        goto L87
    L37:
        if (r8.e.o(r14.b) == true) goto L43;
        if (r8.e.l(r14.b) != 1) goto L43;
        if (r16 == false) goto L43;
        if (r3 == true) goto L43;
        r18 = true;
        goto L44
    L34:
        r17 = false;
        goto L35
    L90:
        String r121 = r11;
        if (r3 == false) goto L469;
        String r2 = r8.e.m();
        if (r2 != null) goto L95;
        String r122 = r121;
    L96:
        ti6.f r24 = new ti6.f();
        r24.a = 1;
        r24.f = 1.0d;
        r24.g = 1.0d;
        r24.y = r122;
        yz0.g r25 = r8.c;
        if (r25 == null) goto L101;
        IRoomBase r26 = r25.getRoom();
        if (r26 == null) goto L101;
        String r123 = r26.getIdStr();
    L102:
        r24.b(r123);
        r24.d = 0.0d;
        r24.e = 0.0d;
        r24.o = 1;
        r24.z = true;
        r20.add(r24);
        return 0;
    L101:
        r123 = null;
        goto L102
    L95:
        r122 = r2;
        goto L96
    L469:
        return 0;
    L24:
        r3 = false;
        goto L25
    L104:
        if (r8.e.e(r8.g.getUiLayout()) == false) goto L153;
        Iterator<ti6.f> r1 = r20.iterator();
    L107:
        if (r1.hasNext() == false) goto L480;
        ti6.f r27 = r1.next();
        String r28 = r8.e.i(r27.b);
        if (r28 != null) goto L112;
        r28 = "";
    L112:
        if (r28.length() <= 0) goto L114;
        boolean r29 = true;
    L115:
        if (r29 == true) goto L117;
    L121:
        boolean r30 = false;
    L122:
        int r31 = r7.b(r27.b);
        r27.n = !r30;
        if (r31 >= 0) goto L124;
        r27.f = 0.1d;
        r27.g = 0.1d;
        r27.d = 1.0d;
        r27.e = 1.0d;
        r27.l = false;
        goto L107
    L124:
        r21.put(r27.b, Integer.valueOf(r31));
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r32 = r8.a;
        if (r32 == null) goto L137;
        Iterator<T> r33 = r32.iterator();
    L128:
        if (r33.hasNext() == false) goto L135;
        Object r124 = r33.next();
        if (((com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d) r124).c() != r31) goto L132;
        boolean r125 = true;
    L133:
        if (r125 == false) goto L128;
    L136:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d r126 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d) r124;
    L138:
        if (r126 == null) goto L107;
        Pair<Double, Double> r34 = r8.c(r126);
        Pair<Double, Double> r35 = r8.b(r126);
        double r127 = ((Number) r34.getFirst()).doubleValue();
        double r128 = ((Number) r34.getSecond()).doubleValue();
        r27.f = r127;
        r27.g = r128;
        if (r30 == false) goto L142;
        double r129 = ((Number) r35.getFirst()).doubleValue();
    L143:
        if (r30 == false) goto L145;
        double r36 = ((Number) r35.getSecond()).doubleValue();
    L146:
        r27.d = r129;
        r27.e = r36;
        if (r30 == false) goto L149;
        int r37 = 1;
    L150:
        r27.a = r37;
        r27.c(r28);
        r27.l = true;
        goto L107
    L149:
        r37 = 2;
        goto L150
    L145:
        r36 = 1.0d;
        goto L146
    L142:
        r129 = 1.0d;
        goto L143
    L132:
        r125 = false;
        goto L133
    L135:
        r124 = null;
        goto L136
    L137:
        r126 = null;
        goto L138
    L117:
        if (r8.e.o(r27.b) == true) goto L121;
        if (r8.e.l(r27.b) != 1) goto L121;
        r30 = true;
        goto L122
    L114:
        r29 = false;
        goto L115
    L480:
        return 0;
    L153:
        if (wh0.e.a(Integer.valueOf(r8.g.m()), Integer.valueOf(r8.g.getUiLayout())) == false) goto L156;
        r8.f(r20, r21, r7);
        return 0;
    L156:
        if (wh0.e.b(Integer.valueOf(r8.g.m()), Integer.valueOf(r8.g.getUiLayout())) == false) goto L158;
        r8.f(r20, r21, r7);
        return 0;
    L158:
        Integer r38 = Integer.valueOf(r8.g.m());
        Integer r39 = Integer.valueOf(r8.g.getUiLayout());
        if (r39 != null) goto L162;
    L164:
        if (r38 != null) goto L167;
    L169:
        boolean r40 = false;
    L170:
        if (r40 == false) goto L172;
        r8.f(r20, r21, r7);
        return 0;
    L172:
        Iterator<ti6.f> r41 = r20.iterator();
    L174:
        if (r41.hasNext() == false) goto L481;
        ti6.f r42 = r41.next();
        int r43 = r7.b(r42.b);
        tc0.b r44 = r8.b;
        if (r44 == null) goto L179;
        String r45 = r44.Vd();
        if (r45 == null) goto L179;
    L180:
        String r46 = r8.e.i(r42.b);
        if (r46 != null) goto L183;
        r46 = "";
    L183:
        if (r43 < 0) goto L186;
        r21.put(r42.b, Integer.valueOf(r43));
        wh0.b r47 = r8.e;
        r8.g.getClass();
        r47.n(r42, r43);
    L186:
        if (Intrinsics.areEqual(r45, r42.b) == true) goto L187;
        r42.a = 2;
        r42.f = 0.1d;
        r42.g = 0.1d;
        r42.c(r46);
        r42.d = 1.0d;
        r42.e = 1.0d;
        goto L174
    L187:
        r42.a = 1;
        r42.f = 1.0d;
        r42.g = 1.0d;
        r42.c(r46);
        r42.d = 0.0d;
        r42.e = 0.0d;
        r42.i = 0;
    L179:
        r45 = "";
        goto L180
    L481:
        return 0;
    L167:
        if (r38.intValue() != 37) goto L169;
    L163:
        r40 = true;
        goto L170
    L162:
        if (r39.intValue() != 65) goto L164;
    L14:
        if (aj0.b.b(r5) == true) goto L12;
        r12 = false;
        goto L17
    L9:
        r10 = 0;
        goto L11
    L189:
        return 0;
    L190:
        MultiLinkFrequencyOptConfig r48 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        Integer r49 = Integer.valueOf(r6.g.m());
        Integer r50 = Integer.valueOf(r6.g.getUiLayout());
        if (r50 == null) goto L193;
        int r51 = r50.intValue();
    L195:
        if (aj0.b.c(r51) == false) goto L198;
    L196:
        boolean r52 = true;
    L201:
        if (r52 == false) goto L203;
        r6.l(r20, r21, r22, r7);
        return 0;
    L203:
        CustomizeStreamContext.a r53 = CustomizeStreamContext.Companion;
        CustomizeStreamContext r54 = r53.getContext();
        if (r54 == null) goto L210;
        com.bytedance.live.datacontext.m<Boolean> r55 = r54.getCustomizeStreamStarted();
        if (r55 == null) goto L210;
        Boolean r56 = (Boolean) r55.getValue();
        if (r56 == null) goto L210;
        boolean r57 = r56.booleanValue();
    L211:
        if (r57 == false) goto L319;
        CustomizeStreamContext r58 = r53.getContext();
        if (r58 == null) goto L219;
        com.bytedance.live.datacontext.m<Integer> r59 = r58.getCustomizeStreamType();
        if (r59 == null) goto L219;
        if (((Number) r59.getValue()).intValue() != 2) goto L219;
        boolean r60 = true;
    L220:
        Iterator<ti6.f> r61 = r20.iterator();
    L222:
        if (r61.hasNext() == false) goto L302;
        ti6.f r62 = r61.next();
        ch0.e r63 = r6.a(r62.b);
        if (r63 == null) goto L226;
        ch0.h r65 = r63.b;
    L227:
        if (r63 == null) goto L229;
        ILinkPlayerInfoBridge r66 = r63.a;
    L230:
        if (r66 == null) goto L235;
        IBaseUser r130 = r66.getUser();
        if (r130 == null) goto L235;
        String r131 = r130.getIdString();
        if (r131 == null) goto L235;
    L236:
        com.bytedance.android.live.liveinteract.customizestream.b r132 = CustomizeStreamContext.Companion.a();
        if (r132 == null) goto L239;
        String r133 = r132.B5();
    L240:
        boolean r134 = Intrinsics.areEqual(r131, r133);
        if (r131.length() <= 0) goto L243;
        boolean r135 = true;
    L244:
        if (r135 == false) goto L255;
        if (r65 == null) goto L247;
        View r67 = r65.b;
    L248:
        if (r67 == null) goto L255;
        if (r66 == null) goto L255;
        if (r66.getMLinkType() != 1) goto L255;
        if (r134 == false) goto L255;
        if (r60 == true) goto L255;
        boolean r68 = true;
    L256:
        int r69 = r7.b(r62.b);
        r62.n = !r68;
        if (r69 < 0) goto L298;
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r136 = r6.a;
        if (r136 == null) goto L271;
        Iterator<T> r137 = r136.iterator();
    L262:
        if (r137.hasNext() == false) goto L269;
        Object r138 = r137.next();
        if (((com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d) r138).c() != r69) goto L266;
        boolean r139 = true;
    L267:
        if (r139 == false) goto L262;
    L270:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d r140 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d) r138;
    L272:
        if (r140 == null) goto L299;
        Pair<Double, Double> r141 = r6.d(r140);
        r21.put(r62.b, Integer.valueOf(r69));
        if (r68 == false) goto L276;
        double r142 = 1.0d;
    L278:
        if (r68 == false) goto L280;
        double r70 = 1.0d;
    L281:
        r62.f = r142;
        r62.g = r70;
        if (r68 == false) goto L284;
        double r71 = 0.0d;
    L285:
        if (r68 == false) goto L287;
        double r143 = 0.0d;
    L288:
        r62.d = r71;
        r62.e = r143;
        if (r68 == false) goto L291;
        int r72 = 1;
    L292:
        r62.a = r72;
        r62.c(r131);
        if (r68 == false) goto L295;
        int r73 = 100;
    L296:
        r62.o = r73;
        r62.l = true;
        r62.m = r60;
        goto L299
    L295:
        r73 = 0;
        goto L296
    L291:
        r72 = 2;
        goto L292
    L287:
        r143 = ((Number) r141.getSecond()).doubleValue();
        goto L288
    L284:
        r71 = ((Number) r141.getFirst()).doubleValue();
        goto L285
    L280:
        r70 = 0.0d;
        goto L281
    L276:
        r142 = 0.0d;
    L299:
        if (r68 == false) goto L301;
        r62.z = true;
    L301:
        r7 = r7;
        r6 = r6;
        goto L222
    L266:
        r139 = false;
        goto L267
    L269:
        r138 = null;
        goto L270
    L271:
        r140 = null;
        goto L272
    L298:
        r62.f = 0.1d;
        r62.g = 0.1d;
        r62.d = 1.0d;
        r62.e = 1.0d;
        r62.l = false;
        r62.m = r60;
        goto L299
    L247:
        r67 = null;
    L255:
        r68 = false;
        goto L256
    L243:
        r135 = false;
        goto L244
    L239:
        r133 = null;
    L235:
        r131 = "";
        goto L236
    L229:
        r66 = null;
        goto L230
    L226:
        r65 = null;
        goto L227
    L302:
        if (r60 == false) goto L475;
        CustomizeStreamContext r74 = CustomizeStreamContext.Companion.getContext();
        if (r74 == null) goto L311;
        com.bytedance.live.datacontext.m<String> r75 = r74.getCustomizeWTNStreamID();
        if (r75 == null) goto L311;
        String r76 = (String) r75.getValue();
        if (r76 == null) goto L311;
        String r144 = r76;
    L312:
        ti6.f r77 = new ti6.f();
        r77.a = 1;
        r77.f = 1.0d;
        r77.g = 1.0d;
        r77.y = r144;
        com.bytedance.live.datacontext.m r78 = m.i().getRoom();
        if (r78 == null) goto L317;
        IRoom r79 = (IRoom) r78.getValue();
        if (r79 == null) goto L317;
        String r145 = r79.getIdStr();
    L318:
        r77.b(r145);
        r77.d = 0.0d;
        r77.e = 0.0d;
        r77.o = 1;
        r77.z = true;
        r20.add(r77);
        return 0;
    L317:
        r145 = null;
    L311:
        r144 = "";
        goto L312
    L475:
        return 0;
    L219:
        r60 = false;
        goto L220
    L319:
        int r80 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c.i;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c.a.a(r6.g.getUiLayout()) == false) goto L383;
        Iterator<ti6.f> r81 = r20.iterator();
    L323:
        if (r81.hasNext() == false) goto L482;
        ti6.f r82 = r81.next();
        ch0.e r83 = r6.a(r82.b);
        if (r83 == null) goto L327;
        ch0.h r84 = r83.b;
    L328:
        if (r83 == null) goto L330;
        ILinkPlayerInfoBridge r85 = r83.a;
    L331:
        if (r85 == null) goto L336;
        IBaseUser r86 = r85.getUser();
        if (r86 == null) goto L336;
        String r87 = r86.getIdString();
        if (r87 == null) goto L336;
    L338:
        if (r87.length() <= 0) goto L340;
        boolean r88 = true;
    L341:
        if (r88 == false) goto L351;
        if (r84 == null) goto L351;
        if (r84.c == true) goto L351;
        if (r84.b == null) goto L351;
        if (r85 == null) goto L351;
        if (r85.getMLinkType() != 1) goto L351;
        boolean r89 = true;
    L352:
        int r90 = r7.b(r82.b);
        r82.n = !r89;
        if (r90 >= 0) goto L354;
        r82.f = 0.1d;
        r82.g = 0.1d;
        r82.d = 1.0d;
        r82.e = 1.0d;
        r82.l = false;
        goto L323
    L354:
        r21.put(r82.b, Integer.valueOf(r90));
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r91 = r6.a;
        if (r91 == null) goto L367;
        Iterator<T> r92 = r91.iterator();
    L358:
        if (r92.hasNext() == false) goto L365;
        Object r146 = r92.next();
        if (((com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d) r146).c() != r90) goto L362;
        boolean r147 = true;
    L363:
        if (r147 == false) goto L358;
    L366:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d r148 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d) r146;
    L368:
        if (r148 == null) goto L323;
        Pair<Double, Double> r93 = r6.e(r148);
        Pair<Double, Double> r94 = r6.d(r148);
        double r149 = ((Number) r93.getFirst()).doubleValue();
        double r150 = ((Number) r93.getSecond()).doubleValue();
        r82.f = r149;
        r82.g = r150;
        if (r89 == false) goto L372;
        double r151 = ((Number) r94.getFirst()).doubleValue();
    L373:
        if (r89 == false) goto L375;
        double r152 = ((Number) r94.getSecond()).doubleValue();
    L376:
        r82.d = r151;
        r82.e = r152;
        if (r89 == false) goto L379;
        int r95 = 1;
    L380:
        r82.a = r95;
        r82.c(r87);
        r82.l = true;
        goto L323
    L379:
        r95 = 2;
        goto L380
    L375:
        r152 = 1.0d;
        goto L376
    L372:
        r151 = 1.0d;
        goto L373
    L362:
        r147 = false;
        goto L363
    L365:
        r146 = null;
        goto L366
    L367:
        r148 = null;
    L351:
        r89 = false;
        goto L352
    L340:
        r88 = false;
    L336:
        r87 = "";
        goto L338
    L330:
        r85 = null;
        goto L331
    L327:
        r84 = null;
        goto L328
    L482:
        return 0;
    L383:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.g(Integer.valueOf(r6.g.m()), Integer.valueOf(r6.g.getUiLayout())) == false) goto L386;
        r6.k(r20, r21, r7);
        return 0;
    L386:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.h(Integer.valueOf(r6.g.m()), Integer.valueOf(r6.g.getUiLayout())) == false) goto L389;
        r6.k(r20, r21, r7);
        return 0;
    L389:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.i(Integer.valueOf(r6.g.m()), Integer.valueOf(r6.g.getUiLayout())) == false) goto L391;
        r6.k(r20, r21, r7);
        return 0;
    L391:
        Iterator<ti6.f> r96 = r20.iterator();
    L393:
        if (r96.hasNext() == false) goto L483;
        ti6.f r97 = r96.next();
        int r98 = r7.b(r97.b);
        String r99 = tc0.c.h().f;
        ch0.e r100 = r6.a(r97.b);
        if (r100 == null) goto L402;
        ILinkPlayerInfoBridge r101 = r100.a;
        if (r101 == null) goto L402;
        IBaseUser r102 = r101.getUser();
        if (r102 == null) goto L402;
        String r103 = r102.getIdString();
        if (r103 == null) goto L402;
    L403:
        if (r98 < 0) goto L410;
        r21.put(r97.b, Integer.valueOf(r98));
        List r104 = (List) r6.f.f().getValue();
        if (r104 == null) goto L407;
        int r105 = r104.size();
    L408:
        com.bytedance.android.live.liveinteract.spatial.a.f(r97, r105, r6.g.n(), r98);
        goto L410
    L407:
        r105 = 0;
    L410:
        if (TextUtils.equals(r99, r97.b) == true) goto L411;
        r97.a = 2;
        r97.f = 0.1d;
        r97.g = 0.1d;
        r97.c(r103);
        r97.d = 1.0d;
        r97.e = 1.0d;
        goto L393
    L411:
        r97.a = 1;
        r97.f = 1.0d;
        r97.g = 1.0d;
        r97.c(r103);
        r97.d = 0.0d;
        r97.e = 0.0d;
        r97.i = 0;
    L402:
        r103 = "";
        goto L403
    L483:
        return 0;
    L210:
        r57 = false;
        goto L211
    L198:
        if (aj0.b.b(r49) == true) goto L196;
        r52 = false;
        goto L201
    L193:
        r51 = 0;
        goto L195
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void M(boolean r2, String r3, int r4) {
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r0 = IVoiceChatAdminService.a.a();
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r3);
        r0.showInviteAndPermitDialog(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final void Mb(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "url");
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean Mk(EPointF r2, EPointF r3, EPointF r4) {
        Intrinsics.checkNotNullParameter(r2, "currentPoint");
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        InteractAnimationController.d.a.a(r2, r3, r4);
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean ha(EPointF r2, EPointF r3, EPointF r4) {
        Intrinsics.checkNotNullParameter(r2, "currentPoint");
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        InteractAnimationController.d.a.b(r2, r3, r4);
        return false;
    }

    public final void j1(boolean r3, View r4, String r5) {
        ALogger.i("VoiceCommonMultiLinkWindowManager", "[3d-avatar] handleAvatarVideoDisplay showAvatarVideo=" + r3 + ", surfaview=" + r4 + ", interactId=" + r5 + ", isAvatarVideoShowing=" + this.V + ", linkmicStatusChange=" + this.W);
        if (r3 == true) goto L5;
    L6:
        if (r3 == true) goto L8;
    L34:
        if (r3 == false) goto L36;
        return;
    L36:
        if (this.V == false) goto L62;
        this.V = false;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r6 = this.d;
        if (r6 == null) goto L41;
        r6.T8();
    L41:
        if (je0.d.r() == false) goto L49;
        cg6.a r7 = g1();
        if (r7 == null) goto L49;
        vb6.g r8 = r7.O5();
        if (r8 == null) goto L49;
        yb6.e r9 = r8.j();
        if (r9 == null) goto L49;
        r9.G();
    L49:
        i1(false);
        if (vm2.h.h0().f() == false) goto L63;
        com.bytedance.android.live.liveinteract.plantform.base.g r10 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r10 == null) goto L64;
        com.bytedance.android.live.ui.c r11 = r10.y4();
        if (r11 == null) goto L65;
        r11.n();
        return;
    L65:
        return;
    L64:
        return;
    L63:
        return;
    L62:
        return;
    L8:
        if (this.V == false) goto L34;
        if (this.W == false) goto L34;
    L11:
        this.V = true;
        if (this.W == false) goto L14;
        this.W = false;
    L14:
        if (r4 == null) goto L19;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r1 = this.d;
        if (r1 == null) goto L19;
        r1.zk(r5, r4, true);
    L19:
        if (je0.d.r() == false) goto L27;
        cg6.a r12 = g1();
        if (r12 == null) goto L27;
        vb6.g r13 = r12.O5();
        if (r13 == null) goto L27;
        yb6.e r14 = r13.j();
        if (r14 == null) goto L27;
        r14.G();
    L27:
        i1(false);
        if (vm2.h.h0().f() == false) goto L57;
        com.bytedance.android.live.liveinteract.plantform.base.g r15 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r15 == null) goto L58;
        com.bytedance.android.live.ui.c r16 = r15.y4();
        if (r16 == null) goto L59;
        r16.k();
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L5:
        if (this.V == false) goto L11;
        goto L6
    }

    public final void k1(boolean r4, View r5, String r6) {
        com.bytedance.android.live.liveinteract.customizestream.a.a("VoiceCommonMultiLinkWindowManager", "handleCustomizeStreamDisplay showVideoStream=" + r4 + ", surfaview=" + r5 + ", interactId=" + r6 + ", isCustomizeStreamShowing=" + this.T + ", linkmicStatusChange=" + this.W);
        if (r4 == true) goto L5;
    L6:
        if (r4 == false) goto L12;
        if (this.T == false) goto L12;
        if (this.W == false) goto L12;
    L13:
        this.T = true;
        this.U = r6;
        if (this.W == false) goto L16;
        this.W = false;
    L16:
        if (r5 == null) goto L21;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r7 = this.d;
        if (r7 == null) goto L21;
        r7.Pj(r6, r5, true);
    L21:
        if (je0.d.r() == false) goto L45;
        cg6.a r8 = g1();
        if (r8 == null) goto L46;
        vb6.g r9 = r8.O5();
        if (r9 == null) goto L47;
        yb6.e r10 = r9.j();
        if (r10 == null) goto L48;
        r10.G();
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L12:
        if ((!Intrinsics.areEqual(r6, this.U)) == true) goto L13;
        if (r4 == false) goto L31;
        return;
    L31:
        if (this.T == false) goto L51;
        this.T = false;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r11 = this.d;
        if (r11 == null) goto L36;
        r11.T8();
    L36:
        if (je0.d.r() == false) goto L52;
        cg6.a r12 = g1();
        if (r12 == null) goto L53;
        vb6.g r13 = r12.O5();
        if (r13 == null) goto L54;
        yb6.e r14 = r13.j();
        if (r14 == null) goto L55;
        r14.G();
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L5:
        if (this.T == false) goto L13;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void l(boolean r2, Pair<Integer, Integer> r3, Pair<Integer, Integer> r4) {
        Intrinsics.checkNotNullParameter(r3, "livePlayerVideoSize");
        Intrinsics.checkNotNullParameter(r4, "livePlayerLayoutSize");
        super.l(r2, r3, r4);
        RxUtilKt.c(RxUtilKt.h(this.B.f()).subscribe(new e(this)), this.e);
        InteractiveSongContext.a r5 = InteractiveSongContext.Companion;
        InteractiveSongContext r6 = r5.getContext();
        if (r6 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r7 = r6.getShowOrderSingStage();
        if (r7 == null) goto L11;
        Observable r8 = r7.a();
        if (r8 == null) goto L11;
        Disposable r9 = r8.subscribe(new f(this));
        if (r9 == null) goto L11;
        RxUtilKt.c(r9, this.e);
    L11:
        Disposable r10 = xs2.b.a().b(jd0.a.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this));
        if (r10 == null) goto L14;
        RxUtilKt.c(r10, this.e);
    L14:
        p1();
        vlc.d r11 = (vlc.d) this.C.get("data_message_manager", null);
        this.K = r11;
        if (r11 == null) goto L17;
        r11.addMessageListener(MessageType.LINK_MIC_DYNAMIC_EMOJI_MESSAGE.getKey(), this);
    L17:
        vlc.d r12 = this.K;
        if (r12 == null) goto L20;
        r12.addMessageListener(MessageType.LINK_MIC_FRIEND_ONLINE_MESSAGE.getKey(), this);
    L20:
        vlc.d r13 = this.K;
        if (r13 == null) goto L23;
        r13.addMessageListener(MessageType.LINKER.getKey(), this);
    L23:
        xlc.a r14 = this.K;
        if (r14 != null) goto L26;
    L28:
        jd0.g r15 = new jd0.g(true);
        xs2.b.a().post(r15);
        DataCenter r16 = this.C;
        if (r16 == null) goto L31;
        r16.put("cmd_interact_audio", r15);
    L31:
        i1(false);
        l1(false);
        RxUtilKt.c(xs2.b.a().b(zg1.g.class).subscribe(new com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.wm.g(this)), this.e);
        DataCenter r17 = this.C;
        if (r17 == null) goto L34;
        r17.observeForever("data_hamlet_avatar_layout_animate", this);
    L34:
        cg6.a r18 = g1();
        if (r18 == null) goto L39;
        hg6.g r19 = r18.getRtcManager();
        if (r19 == null) goto L39;
        r19.G(this);
    L39:
        InteractiveSongContext r20 = r5.getContext();
        if (r20 == null) goto L49;
        com.bytedance.live.datacontext.m<Boolean> r21 = r20.m130isOpenInteractiveSong();
        if (r21 == null) goto L50;
        Observable r22 = r21.a();
        if (r22 == null) goto L51;
        Disposable r23 = r22.subscribe(new h(this));
        if (r23 == null) goto L52;
        RxUtilKt.c(r23, this.e);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L26:
        if ((r14 instanceof xlc.a) == false) goto L28;
        r14.y(MessageType.ROOM_TEXT_BG_MESSAGE.getIntType(), this);
        goto L28
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final EPointF Se(int r17, int r18, EPointF r19, EPointF r20) {
        Intrinsics.checkNotNullParameter(r19, "startPoint");
        Intrinsics.checkNotNullParameter(r20, "endPoint");
        if (this.z.getUiLayout() == 22) goto L34;
        EPointF r5 = new EPointF();
        if (r17 != 0) goto L7;
        ((PointF) r5).x = ((PointF) r20).x;
        ((PointF) r5).y = ((PointF) r19).y - s1.f(20.0f);
    L32:
        ALogger.d("VoiceCommonMultiLinkWindowManager", "getControlPoint 1v8 from:" + r17 + " to:" + r18 + " startPoint:" + r19 + " endPoint:" + r20 + " ControlPoint:" + r5);
        return r5;
    L7:
        if (r18 != 0) goto L9;
        ((PointF) r5).x = ((PointF) r19).x;
        ((PointF) r5).y = ((PointF) r20).y - s1.f(20.0f);
        goto L32
    L9:
        float r12 = 2;
        ((PointF) r5).x = (((PointF) r19).x + ((PointF) r20).x) / r12;
        if (1 > r17) goto L18;
        if (4 < r17) goto L18;
        if (1 > r18) goto L18;
        if (4 < r18) goto L18;
        float r6 = ((PointF) r19).y;
        int r13 = s1.f(45.0f);
    L30:
        float r7 = r6 - r13;
    L31:
        ((PointF) r5).y = r7;
    L18:
        if (5 > r17) goto L27;
        if (8 < r17) goto L27;
        if (5 > r18) goto L27;
        if (8 < r18) goto L27;
        r6 = ((PointF) r19).y;
        r13 = s1.f(45.0f);
    L27:
        if (Math.abs(r17 - r18) != 4) goto L29;
        r7 = (((PointF) r19).y + ((PointF) r20).y) / r12;
        goto L31
    L29:
        r6 = Math.min(((PointF) r19).y, ((PointF) r20).y);
        r13 = s1.f(45.0f);
        goto L30
    L34:
        EPointF r8 = new EPointF();
        float r9 = ((PointF) r19).x;
        float r14 = ((PointF) r20).x;
        if (r9 != r14) goto L39;
        float r15 = ((PointF) r19).y;
        if (r15 == ((PointF) r20).y) goto L39;
        ((PointF) r8).x = r9;
        ((PointF) r8).y = r15 - s1.f(24.0f);
    L44:
        ALogger.d("VoiceCommonMultiLinkWindowManager", "getControlPoint 3x3 from:" + r17 + " to:" + r18 + " startPoint:" + r19 + " endPoint:" + r20 + " ControlPoint:" + r8);
        return r8;
    L39:
        if (r9 == r14) goto L43;
        float r16 = ((PointF) r19).y;
        if (r16 != ((PointF) r20).y) goto L43;
        ((PointF) r8).x = (r9 + r14) / 2;
        ((PointF) r8).y = r16 - s1.f(24.0f);
    L43:
        float r110 = 2;
        ((PointF) r8).x = (r9 + r14) / r110;
        ((PointF) r8).y = ((((PointF) r19).y + ((PointF) r20).y) / r110) - s1.f(24.0f);
        goto L44
    }

    public final void vc(ei6.a r7, final int r8, long r9, Object... r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        UtilityKotlinExtentionsKt.s(0, false, false, new VoiceCommonMultiLinkWindowManager$onRtcInfo$1(this, r8), 7);
    }

    public VoiceCommonMultiLinkWindowManager(Context r17, ConstraintLayout r18, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r19, zj0.c r20, com.bytedance.android.live.liveinteract.plantform.datamerge.d r21, DataCenter r22, tf0.o.a r23, PlatformMultiLinkWidget r24, View r25, GLSurfaceView r26, com.bytedance.android.live.pushstream.d r27, PlatformMultiLinkWidget r28) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "containerView");
        Intrinsics.checkNotNullParameter(r19, "layoutConfig");
        Intrinsics.checkNotNullParameter(r21, "dataMergeCenter");
        Intrinsics.checkNotNullParameter(r22, "dataCenter");
        Intrinsics.checkNotNullParameter(r23, "callBack");
        Intrinsics.checkNotNullParameter(r24, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r25, "interactEmojiLayout");
        Intrinsics.checkNotNullParameter(r26, "renderContainer");
        super(r17, r18, r19, r20, r21, r22, r23, r24, r27, r28);
        this.Y = r25;
        this.Z = r26;
        this.I = new EmojiSoundManager(r17, this.n, r27);
        this.J = new SeatAnimManager(r19.j());
        this.N = new com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c(r22, r21, r19, r28);
        this.S = new ConcurrentHashMap();
        this.U = "0";
    }
}

package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.h0;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimManager;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.VideoTalkRoomApplyCancelDialog;
import com.bytedance.android.live.liveinteract.linkbase.api.SeatItemId;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkPaidViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSelfDisciplineEndViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.live.liveinteract.plantform.core.RtcManager;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.k0;
import com.bytedance.android.live.liveinteract.plantform.model.s0;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.videotalk.avatarmix.MicseatMixerFactory;
import com.bytedance.android.live.liveinteract.videotalk.avatarmix.MicseatType;
import com.bytedance.android.live.liveinteract.videotalk.emoji.VideoTalkDynamicEmojiDialog;
import com.bytedance.android.live.liveinteract.videotalk.utils.z;
import com.bytedance.android.live.liveinteract.voicechat.emoji.VideoTalkInteractEmojiPanel;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.liveinteract.widget.widget.ChatRoomGuestAppliedDialog;
import com.bytedance.android.live.ui.ClipFrameLayout;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.interact.model.e0;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
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
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sh0.i0;
import sh0.j0;
import uf2.d0;
import zg1.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/wm/CommonMultiLinkWindowManager;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/wm/BaseMultiLinkWindowManager;", "Lcom/bytedance/android/live/liveinteract/animation/InteractAnimationController$d;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class CommonMultiLinkWindowManager extends BaseMultiLinkWindowManager implements InteractAnimationController.d, vlc.l, Observer<KVData> {
    public static final /* synthetic */ int W = 0;
    public final EmojiSoundManager I;
    public final SeatAnimManager J;
    public vlc.d K;
    public z L;
    public tj0.g M;
    public final sj0.a N;
    public int O;
    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c P;
    public o Q;
    public final Rect R;
    public final GestureDetector S;
    public boolean T;
    public final View U;
    public final GLSurfaceView V;

    public static final class a {
    }

    public static final class b extends GestureDetector.SimpleOnGestureListener {
        public long a;
        public final long b;
        public final /* synthetic */ CommonMultiLinkWindowManager c;

        public b(CommonMultiLinkWindowManager r3) {
            this.c = r3;
            this.b = ((Number) vm2.d.S7.getValue(null, vm2.d.a[457(0x1c9, float:6.4E-43)])).longValue();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "e");
            this.a = SystemClock.elapsedRealtime();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r6) {
            Intrinsics.checkNotNullParameter(r6, "e");
            if ((SystemClock.elapsedRealtime() - this.a) >= this.b) goto L5;
            return false;
        L5:
            CommonMultiLinkWindowManager r0 = this.c;
            int r1 = CommonMultiLinkWindowManager.W;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r2 = r0.d;
            tf0.e r3 = null;
            if (r2 == null) goto L9;
            List<tf0.e> r4 = r2.getDataList();
            if (r4 == null) goto L9;
        L16:
            if (ListUtils.notEmpty(r4) == false) goto L27;
            if (r4 == null) goto L19;
            tf0.e r5 = (tf0.e) ListProtector.get(r4, 0);
        L21:
            if ((r5 instanceof MultiLinkFirstUserViewBinder.a) == false) goto L24;
            r3 = r5;
        L24:
            MultiLinkFirstUserViewBinder.a r7 = (MultiLinkFirstUserViewBinder.a) r3;
            if (r7 == null) goto L27;
            r0.w1(r7);
            goto L27
        L19:
            r5 = null;
        L27:
            return false;
        L9:
            com.bytedance.android.live.liveinteract.plantform.datamerge.a r8 = r0.h;
            if (r8 == null) goto L14;
            BehaviorSubject<List<tf0.e>> r9 = r8.b;
            if (r9 == null) goto L14;
            r4 = (List) r9.getValue();
        L14:
            r4 = null;
            goto L16
        }
    }

    public static final class c implements wh0.a {
        public final /* synthetic */ CommonMultiLinkWindowManager a;

        public c(CommonMultiLinkWindowManager r1) {
            this.a = r1;
        }

        @Override // wh0.a
        public final boolean a(String r6) {
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.a.d;
            String r1 = null;
            if (r0 == null) goto L25;
            List<tf0.e> r2 = r0.getDataList();
            if (r2 == null) goto L25;
            Iterator<T> r3 = r2.iterator();
        L8:
            if (r3.hasNext() == false) goto L23;
            Object r4 = r3.next();
            tf0.e r5 = (tf0.e) r4;
            if ((r5 instanceof MultiLinkGuestViewBinder.a) == true) goto L12;
            r5 = null;
        L12:
            MultiLinkGuestViewBinder.a r7 = (MultiLinkGuestViewBinder.a) r5;
            if (r7 == null) goto L19;
            ch0.e r8 = r7.k;
            if (r8 == null) goto L19;
            ILinkPlayerInfoBridge r9 = r8.a;
            if (r9 == null) goto L19;
            String r10 = r9.getInteractId();
        L21:
            if (Intrinsics.areEqual(r10, r6) == false) goto L8;
        L24:
            tf0.e r11 = (tf0.e) r4;
        L27:
            if ((r11 instanceof MultiLinkGuestViewBinder.a) == true) goto L29;
            r11 = null;
        L29:
            MultiLinkGuestViewBinder.a r12 = (MultiLinkGuestViewBinder.a) r11;
            if (r12 == null) goto L38;
            ch0.e r13 = r12.k;
            if (r13 == null) goto L38;
            ILinkPlayerInfoBridge r14 = r13.a;
            if (r14 == null) goto L38;
            IBaseUser r15 = r14.getUser();
            if (r15 == null) goto L38;
            String r16 = r15.getIdString();
        L39:
            Room r17 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
            if (r17 == null) goto L43;
            r1 = r17.getOwnerUserIdString();
        L43:
            return Intrinsics.areEqual(r16, r1);
        L38:
            r16 = null;
        L19:
            r10 = null;
            goto L21
        L23:
            r4 = null;
        L25:
            r11 = null;
            goto L27
        }

        @Override // wh0.a
        public final int b(String r2) {
            com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.a.d;
            if (r0 != null) goto L7;
            return -1;
        L7:
            return r0.S0(r2);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ CommonMultiLinkWindowManager a;

        public d(CommonMultiLinkWindowManager r1) {
            this.a = r1;
        }

        public final void a() {
            int r0 = this.a.d0();
            int r1 = this.a.c0();
            a0 r2 = new a0(0);
            r2.b = (int) (this.a.z.q(r1) + this.a.z.s(r0, r1));
            this.a.C.put("cmd_equal_talkroom_state_change", r2);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements com.bytedance.android.live.liveinteract.widget.widget.a {
        public final /* synthetic */ CommonMultiLinkWindowManager a;
        public final /* synthetic */ int b;

        @Override // com.bytedance.android.live.liveinteract.widget.widget.a
        public final void show() {
            CommonMultiLinkWindowManager r0 = this.a;
            int r1 = this.b;
            int r2 = CommonMultiLinkWindowManager.W;
            r0.k1(r1, true);
        }

        public e(CommonMultiLinkWindowManager r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ CommonMultiLinkWindowManager a;

        public f(CommonMultiLinkWindowManager r1) {
            this.a = r1;
        }

        public final void accept(Object r26) {
            List<? extends tf0.e> r1 = (List) r26;
            CommonMultiLinkWindowManager r2 = this.a;
            int r3 = CommonMultiLinkWindowManager.W;
            r2.n1(r1);
            CommonMultiLinkWindowManager r4 = this.a;
            String r5 = "";
            if (r4.M == null) goto L139;
            int r6 = r1.size();
            if (r6 == r4.O) goto L9;
            z r7 = r4.L;
            if (r7 == null) goto L9;
            r7.d();
        L9:
            r4.O = r6;
            ArrayList r8 = new ArrayList();
            Iterator<T> r9 = r1.iterator();
            int r10 = 0;
        L11:
            if (r9.hasNext() == false) goto L132;
            T r11 = r9.next();
            int r12 = r10 + 1;
            if (r10 >= 0) goto L15;
            CollectionsKt.throwIndexOverflow();
        L15:
            tf0.e r13 = (tf0.e) r11;
            if (r10 != (r1.size() - 1)) goto L18;
            boolean r14 = true;
        L20:
            if ((r13 instanceof MultiLinkGuestViewBinder.a) == false) goto L69;
            ch0.e r15 = ((MultiLinkGuestViewBinder.a) r13).k;
            ILinkPlayerInfoBridge r16 = r15.a;
            ch0.h r17 = r15.b;
            r4.h(r16.getInteractId());
            int r18 = r4.h(r16.getInteractId());
            pn0.f r19 = r4.P.g.d;
            if (r19 == null) goto L24;
            List<pn0.f.c> r20 = r19.d;
        L25:
            if (r20 == null) goto L37;
            Iterator<T> r110 = r20.iterator();
        L28:
            if (r110.hasNext() == false) goto L35;
            T r111 = r110.next();
            if (((pn0.f.c) r111).a != r18) goto L32;
            boolean r21 = true;
        L33:
            if (r21 == false) goto L28;
        L36:
            pn0.f.c r22 = r111;
        L38:
            if (r22 != null) goto L40;
            Iterator<T> r112 = r9;
            int r113 = r12;
        L131:
            r9 = r112;
            r10 = r113;
            goto L11
        L40:
            r112 = r9;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c r23 = r4.P;
            r113 = r12;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.h r114 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.d.c(r19.c);
            com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.h r0 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.d.b(r19.b);
            r23.getClass();
            ti6.f r24 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c.f(r22, r114, r0);
            com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c r25 = r4.P;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.h r115 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.d.c(r19.c);
            com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.h r116 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.d.b(r19.b);
            r25.getClass();
            ti6.f r27 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c.b(r22, r20, r115, r116);
            if (r24 == null) goto L131;
            ALogger.i("BaseMultiLinkWindowManager", "updateAudioStreamFromBaseCommon1 position:" + r18 + " region:" + com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.d.a(r24));
            z r28 = r4.L;
            if (r28 == null) goto L45;
            r28.f(r16, r17, r24, r14);
        L45:
            String r117 = r16.getInteractId();
            if (r117 == null) goto L131;
            if (r16.getLinkType() != 2) goto L50;
        L53:
            boolean r118 = true;
        L54:
            if (r118 == false) goto L131;
            if (r27 == null) goto L131;
            MicseatType r29 = MicseatType.VideoVoice;
            IBaseUser r30 = r16.getUser();
            if (r30 == null) goto L66;
            py.k r31 = r30.getAvatarMedium();
            if (r31 == null) goto L66;
            List r32 = r31.getUrls();
            if (r32 == null) goto L66;
            String r33 = (String) ListProtector.get(r32, 0);
            if (r33 == null) goto L66;
            String r210 = r33;
        L67:
            r8.add(new com.bytedance.android.live.liveinteract.videotalk.avatarmix.d(r117, r29, r210, r27, r24, r16.getUserPosition()));
        L66:
            r210 = "";
            goto L67
        L50:
            if (r16.getLinkType() == 0) goto L53;
            r118 = false;
            goto L54
        L32:
            r21 = false;
            goto L33
        L35:
            r111 = (T) null;
            goto L36
        L37:
            r22 = null;
            goto L38
        L24:
            r20 = null;
            goto L25
        L69:
            r112 = r9;
            r113 = r12;
            if ((r13 instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L73;
            r10 = ((MultiLinkNormalEmptyViewBinder.a) r13).b();
        L81:
            ILinkPlayerInfoBridge r34 = (ILinkPlayerInfoBridge) vh7.f.c(ILinkPlayerInfoBridge.class);
            r34.setInteractId("");
            r34.setUserPosition(r10);
            pn0.f r35 = r4.P.g.d;
            if (r35 == null) goto L84;
            List<pn0.f.c> r36 = r35.d;
        L85:
            if (r36 == null) goto L97;
            Iterator<T> r37 = r36.iterator();
        L88:
            if (r37.hasNext() == false) goto L95;
            T r38 = r37.next();
            if (((pn0.f.c) r38).a != r10) goto L92;
            boolean r119 = true;
        L93:
            if (r119 == false) goto L88;
        L96:
            pn0.f.c r39 = r38;
        L98:
            com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c r40 = r4.P;
            if (r35 == null) goto L103;
            pn0.f.b r120 = r35.c;
            if (r120 == null) goto L103;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.h r121 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.d.c(r120);
        L104:
            if (r35 == null) goto L108;
            pn0.f.a r122 = r35.b;
            if (r122 == null) goto L108;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.h r123 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.d.b(r122);
        L109:
            r40.getClass();
            ti6.f r41 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c.f(r39, r121, r123);
            com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c r124 = r4.P;
            if (r35 == null) goto L114;
            pn0.f.b r125 = r35.c;
            if (r125 == null) goto L114;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.h r126 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.d.c(r125);
        L115:
            if (r35 == null) goto L119;
            pn0.f.a r42 = r35.b;
            if (r42 == null) goto L119;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.h r43 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.d.b(r42);
        L120:
            r124.getClass();
            ti6.f r211 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c.b(r39, r36, r126, r43);
            z r44 = r4.L;
            if (r44 == null) goto L123;
            r44.f(r34, null, r41, r14);
        L123:
            StringBuilder r45 = new StringBuilder("updateAudioStreamFromBaseCommon2 position:");
            r45.append(r10);
            r45.append(" region:");
            if (r41 == null) goto L126;
            String r46 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.d.a(r41);
        L127:
            r45.append(r46);
            ALogger.i("BaseMultiLinkWindowManager", r45.toString());
            if (r211 == null) goto L131;
            if (r41 == null) goto L131;
            r8.add(new com.bytedance.android.live.liveinteract.videotalk.avatarmix.d("empty-" + r34.getUserPosition(), MicseatType.Empty, "", r211, r41, r34.getUserPosition()));
            goto L131
        L126:
            r46 = null;
        L119:
            r43 = null;
        L114:
            r126 = null;
        L108:
            r123 = null;
        L103:
            r121 = null;
            goto L104
        L92:
            r119 = false;
            goto L93
        L95:
            r38 = (T) null;
            goto L96
        L97:
            r39 = null;
            goto L98
        L84:
            r36 = null;
            goto L85
        L73:
            if ((r13 instanceof MultiLinkPaidViewBinder.a) == false) goto L76;
            r10 = ((MultiLinkPaidViewBinder.a) r13).l;
            goto L81
        L76:
            if ((r13 instanceof MultiLinkSpecialViewBinder.a) == false) goto L79;
            r10 = ((MultiLinkSpecialViewBinder.a) r13).k;
            goto L81
        L79:
            if ((r13 instanceof MultiLinkSelfDisciplineEndViewBinder.a) == false) goto L81;
            r10 = ((MultiLinkSelfDisciplineEndViewBinder.a) r13).l;
            goto L81
        L18:
            r14 = false;
            goto L20
        L132:
            String r47 = null;
            tj0.g r48 = r4.M;
            if (r48 == null) goto L136;
            r48.b(r8, false);
        L136:
            if (je0.d.r() == false) goto L138;
            r4.N.update();
        L138:
            r4.C.put("cmd_trigger_update_effect_stream", r8);
        L140:
            Iterator<T> r49 = r1.iterator();
        L142:
            if (r49.hasNext() == false) goto L159;
            Object r50 = (T) r49.next();
            Object r51 = (tf0.e) r50;
            if ((r51 instanceof MultiLinkGuestViewBinder.a) == true) goto L146;
            r51 = r47;
        L146:
            MultiLinkGuestViewBinder.a r52 = (MultiLinkGuestViewBinder.a) r51;
            if (r52 == null) goto L155;
            ch0.e r53 = r52.k;
            if (r53 == null) goto L155;
            ILinkPlayerInfoBridge r54 = r53.a;
            if (r54 == null) goto L155;
            IBaseUser r55 = r54.getUser();
            if (r55 == null) goto L155;
            String r56 = r55.getIdString();
        L157:
            if (Intrinsics.areEqual(r56, gh0.a.c()) == false) goto L142;
        L160:
            tf0.e r57 = (tf0.e) r50;
            if (r57 == null) goto L187;
            Object r58 = r57.i.get(SeatItemId.SEAT_WIDGET.name());
            if ((r58 instanceof nh0.m) == true) goto L165;
            r58 = r47;
        L165:
            nh0.m r59 = (nh0.m) r58;
            final o r60 = this.a.Q;
            if (r60 != null) goto L168;
            return;
        L168:
            if (com.bytedance.android.live.liveinteract.revenue.common.vieweffect.c.a(r59) == false) goto L170;
            r60.a.c("");
            return;
        L170:
            int r61 = com.bytedance.android.live.liveinteract.revenue.battle.i.a;
            if (r59 == null) goto L176;
            String r62 = r59.h();
            if (r62 == null) goto L176;
            String r63 = r62;
        L177:
            Function1<String, Unit> r65 = new CommonWidgetFaceEffectManager$processWidgetInfo$effectName$1(r60);
            CommonWidgetFaceEffectManager$processWidgetInfo$effectName$2 r66 = CommonWidgetFaceEffectManager$processWidgetInfo$effectName$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r63, "dressId");
            Intrinsics.checkNotNullParameter(r65, "onSuccess");
            Intrinsics.checkNotNullParameter(r66, "onFail");
            com.bytedance.android.live.profit.dress.s r67 = yt0.c.a().getDressData(r63, 33, com.bytedance.android.live.liveinteract.revenue.battle.i.a(), "CommonWidgetResouce asyncCrownBeautyEffectId", new com.bytedance.android.live.liveinteract.revenue.battle.a(r65, r66));
            if (r67 == null) goto L180;
            String r68 = r67.d;
        L181:
            kh0.a r69 = r60.a;
            if (r68 == null) goto L185;
            r5 = r68;
        L185:
            r69.c(r5);
            return;
        L180:
            r68 = r47;
        L176:
            r63 = "";
            goto L177
        L187:
            return;
        L155:
            r56 = r47;
            goto L157
        L159:
            r50 = (T) r47;
            goto L160
        L139:
            r47 = null;
            goto L140
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r3) {
            ALogger.e("BaseMultiLinkWindowManager", "windowListHelper.windowListObservable error", (Throwable) r3);
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ CommonMultiLinkWindowManager a;

        public h(CommonMultiLinkWindowManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.live.liveinteract.plantform.datamerge.a r0 = this.a.h;     // Catch: Throwable -> L10
            if (r0 == null) goto L13;
            BehaviorSubject<List<tf0.e>> r1 = r0.b;     // Catch: Throwable -> L10
            if (r1 == null) goto L17;
            List<? extends tf0.e> r2 = (List) r1.getValue();     // Catch: Throwable -> L10
            if (r2 == null) goto L18;
            CommonMultiLinkWindowManager r3 = this.a;     // Catch: Throwable -> L10
            int r4 = CommonMultiLinkWindowManager.W;     // Catch: Throwable -> L10
            r3.n1(r2);     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L17:
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ CommonMultiLinkWindowManager a;
        public final /* synthetic */ List b;

        public i(CommonMultiLinkWindowManager r1, List r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            Path r0 = new Path();
            Iterator r1 = this.b.iterator();
            int r2 = 0;
        L4:
            if (r1.hasNext() == false) goto L31;
            Object r3 = r1.next();
            int r5 = r2 + 1;
            if (r2 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            tf0.e r4 = (tf0.e) r3;
            CommonMultiLinkWindowManager r6 = this.a;
            if (r6.T == false) goto L16;
            com.bytedance.android.live.liveinteract.videotalk.utils.c r7 = r6.b;
            if (r7 == null) goto L13;
            Path r8 = r7.a(r2, 0.0f, 0.0f);
        L14:
            r0.addPath(r8);
        L29:
            r2 = r5;
            goto L4
        L13:
            r8 = new Path();
            goto L14
        L16:
            if ((r4 instanceof MultiLinkGuestViewBinder.a) == true) goto L18;
            r4 = null;
        L18:
            MultiLinkGuestViewBinder.a r9 = (MultiLinkGuestViewBinder.a) r4;
            if (r9 == null) goto L29;
            ILinkPlayerInfoBridge r10 = r9.k.a;
            if (r10.getUser() == null) goto L29;
            if (je0.d.x(Integer.valueOf(r10.getLinkType())) == false) goto L29;
            int r11 = this.a.h(r10.getInteractId());
            com.bytedance.android.live.liveinteract.videotalk.utils.c r12 = this.a.b;
            if (r12 == null) goto L27;
            Path r13 = r12.a(r11, 0.0f, 0.0f);
        L28:
            r0.addPath(r13);
            goto L29
        L27:
            r13 = new Path();
            goto L28
        L31:
            if (this.a.z.getUiLayout() != 16) goto L39;
            this.a.getClass();
            if (je0.d.H() == false) goto L39;
            int r14 = qi0.e.a;
            int r15 = qi0.e.a(this.a.z.getUiLayout());
            com.bytedance.android.live.liveinteract.videotalk.utils.c r16 = this.a.b;
            if (r16 == null) goto L37;
            Path r17 = r16.a(r15, 0.0f, 0.0f);
        L38:
            r0.addPath(r17);
            goto L39
        L37:
            r17 = new Path();
        L39:
            com.bytedance.android.live.ui.c r18 = this.a.a;
            if (r18 == null) goto L42;
            r18.o(r0);
        L42:
            com.bytedance.android.live.liveinteract.animation.universalwidget.a.f0.getClass();
            com.bytedance.android.live.liveinteract.animation.universalwidget.a r19 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C0014a.a();
            if (r19 == null) goto L52;
            r19.Jl(r0);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ CommonMultiLinkWindowManager a;
        public final /* synthetic */ List b;

        public j(CommonMultiLinkWindowManager r1, List r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            Path r0 = new Path();
            Iterator r1 = this.b.iterator();
        L3:
            ClipFrameLayout r3 = null;
            if (r1.hasNext() == false) goto L35;
            ClipFrameLayout r2 = (tf0.e) r1.next();
            if ((r2 instanceof MultiLinkGuestViewBinder.a) == false) goto L9;
            r3 = r2;
        L9:
            MultiLinkGuestViewBinder.a r4 = (MultiLinkGuestViewBinder.a) r3;
            if (r4 == null) goto L3;
            ILinkPlayerInfoBridge r5 = r4.k.a;
            if (r5.getUser() == null) goto L3;
            if (je0.d.x(Integer.valueOf(r5.getLinkType())) == false) goto L3;
            int r6 = this.a.h(r5.getInteractId());
            if (r6 == 0) goto L3;
            CommonMultiLinkWindowManager r7 = this.a;
            pn0.f r8 = r7.z.d;
            int r9 = 0;
            if (r8 == null) goto L28;
            pn0.f.b r10 = r8.c;
            int r11 = r10.a;
            if (r11 > 0) goto L24;
            r11 = 0;
        L24:
            int r12 = r10.b;
            if (r12 <= 0) goto L27;
            r9 = r12;
        L27:
            int r13 = r9;
            r9 = r11;
        L29:
            com.bytedance.android.live.liveinteract.videotalk.utils.c r14 = r7.b;
            if (r14 == null) goto L33;
            Path r15 = r14.b(r6, -r9, -r13);
            if (r15 == null) goto L33;
        L34:
            r0.addPath(r15);
        L33:
            r15 = new Path();
            goto L34
        L28:
            r13 = 0;
            goto L29
        L35:
            ClipFrameLayout r16 = this.a.getFirstSeatVHShadowContainer();
            if ((r16 instanceof ClipFrameLayout) == false) goto L39;
            r3 = r16;
        L39:
            ClipFrameLayout r17 = r3;
            if (r17 == null) goto L54;
            r17.setMClipPath(r0);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public boolean Ed(int r1) {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final ArrayList Ka(int r1, float r2) {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public void O() {
        this.o = false;
        m1();
        this.D.Y7().clear();
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public boolean Pf(int r1) {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final ArrayList dm(int r1) {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public int j0() {
        return 3;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public boolean lo(int r1) {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean si() {
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void F0() {
        boolean r1 = true;
        if (this.n == true) goto L8;
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isEngineOn() == true) goto L8;
        return;
    L8:
        int r2 = this.z.j();
        int r3 = this.z.getUiLayout();
        if (r3 != 109) goto L11;
    L32:
        r1 = false;
    L33:
        if (r1 == false) goto L42;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r4 = this.d;
        if (r4 == null) goto L43;
        ViewGroup r5 = r4.td();
        if (r5 == null) goto L44;
        r5.post(new d(this));
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L11:
        if (r3 == 110) goto L32;
        if (r3 == 111) goto L32;
        if (r3 == 112) goto L32;
        if (r3 == 15) goto L32;
        if (r3 == 65) goto L32;
        if (r3 == 16) goto L32;
        if (r2 == 8) goto L30;
        if (r2 == 12) goto L33;
        if (r2 == 16) goto L33;
    L30:
        if (r3 != 4) goto L32;
        goto L32
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void O0() {
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r0 = this.h;
        if (r0 == null) goto L10;
        BehaviorSubject<List<tf0.e>> r1 = r0.b;
        if (r1 == null) goto L11;
        Disposable r2 = r1.subscribe(new f(this), g.a);
        if (r2 == null) goto L12;
        RxUtilKt.c(r2, this.e);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public zj0.d g0() {
        return new zj0.d.b(this.z.j(), this.z.getUiLayout(), this.z.m(), 0, 0, 24);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public List<s0> getHeadPointList() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        List<tf0.e> r1 = null;
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
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r13 = this.d;
        if (r13 == null) goto L36;
        r1 = r13.getDataList();
    L36:
        int r14 = dd0.a.a;
        return dd0.a.b(r12, this.i, r1);
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
    public final RecyclerView getMicSeatRecyclerView() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRecyclerView();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final int getUserCount() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.d;
        int r1 = 0;
        if (r0 == null) goto L19;
        List<tf0.e> r2 = r0.getDataList();
        if (r2 == null) goto L19;
        List<tf0.e> r3 = r2;
        if ((r3 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L19;
        if ((((tf0.e) r4.next()) instanceof MultiLinkGuestViewBinder.a) == false) goto L13;
        r1 = r1 + 1;
        if (r1 >= 0) goto L13;
        CollectionsKt.throwCountOverflow();
        goto L13
    L9:
        if (r3.isEmpty() == false) goto L11;
    L19:
        return r1;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final q50.b jq() {
        GLSurfaceView r2 = this.V;
        return new q50.b(new q50.a(r2, k50.e.a(r2)), 5);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void k0() {
        com.bytedance.android.live.pushstream.d r0 = this.F;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getLiveCore() != null) goto L7;
        return;
    L7:
        if (this.n == false) goto L22;
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L23;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 != null) goto L13;
        return;
    L13:
        if (((Boolean) vm2.d.U1.getValue(null, vm2.d.a[148(0x94, float:2.07E-43)])).booleanValue() == false) goto L15;
        this.L = new z(r2, this.z.getUiLayout(), this.G);
    L15:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c r3 = this.P;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r4 = this.z;
        if (r4 == null) goto L19;
        r3.g(r4);
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkWindowLayoutConfig");
    L23:
        return;
    }

    public final void l1() {
        if (this.n == false) goto L5;
        return;
    L5:
        SurfaceView r0 = this.D.q1();
        if (r0 == null) goto L11;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r1 = this.d;
        if (r1 == null) goto L12;
        r1.pd(r0);
        return;
    L12:
        return;
    }

    public final void m1() {
        if (this.n == false) goto L5;
        return;
    L5:
        SurfaceView r0 = this.D.q1();
        if (r0 == null) goto L11;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r1 = this.d;
        if (r1 == null) goto L12;
        r1.le(r0);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final boolean u0() {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEngineOn() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final FrameLayout v() {
        return (FrameLayout) this.y.findViewById(2131375525);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final FrameLayout vj() {
        View r0 = this.U;
        if (r0 == null) goto L7;
        return (FrameLayout) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public void end() {
        m1();
        super.end();
        z r0 = this.L;
        if (r0 == null) goto L12;
        CompositeDisposable r2 = r0.j;
        if (r2 == null) goto L8;
        r2.dispose();
    L8:
        if (r0.m == false) goto L11;
        r0.d();
        r0.k = null;
    L11:
        r0.d.clear();
        r0.c.clear();
    L12:
        this.L = null;
        o r1 = this.Q;
        if (r1 == null) goto L18;
        kh0.a r3 = r1.a;
        h0 r4 = kh0.b.a(r3.e);
        if (r4 == null) goto L17;
        h0 r5 = r4;
        r5.f(r3.c);
    L17:
        ALogger.i("CommonLokiEffectManager", "[unregistEffectListener]");
    L18:
        this.I.c();
        ((LinkedHashMap) this.J.a).clear();
        vlc.d r6 = this.K;
        if (r6 == null) goto L21;
        r6.removeMessageListener(this);
    L21:
        this.e.clear();
        e1("end");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final boolean y0() {
        return je0.d.H();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public void L() {
        l1();
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

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final List<bd0.b> H(boolean r23) {
        Integer r1 = null;
        if (r23 == false) goto L7;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r2 = this.d;
        if (r2 == null) goto L13;
        ConstraintLayout r3 = r2.getSingleSurfaceViewContainer();
    L14:
        if (r3 == null) goto L16;
        float r4 = r3.getWidth();
        float r5 = r3.getHeight();
        int r6 = 0;
        float r7 = 0;
        if (r4 <= r7) goto L77;
        if (r5 <= r7) goto L77;
        Pair<Integer, Integer> r8 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.g.a(r3);
        int r9 = ((Number) r8.component1()).intValue();
        int r10 = ((Number) r8.component2()).intValue();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r11 = this.d;
        if (r11 == null) goto L75;
        RecyclerView r12 = r11.getRecyclerView();
        if (r12 == null) goto L75;
        Pair<Integer, Integer> r13 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.g.a(r12);
        if (r13 == null) goto L75;
        ArrayList r14 = new ArrayList();
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r15 = this.h;
        if (r15 == null) goto L73;
        BehaviorSubject<List<tf0.e>> r16 = r15.b;
        if (r16 == null) goto L73;
        List r17 = (List) r16.getValue();
        if (r17 == null) goto L73;
        Iterator r18 = r17.iterator();
    L37:
        if (r18.hasNext() == false) goto L73;
        Object r19 = (tf0.e) r18.next();
        if ((r19 instanceof MultiLinkGuestViewBinder.a) == true) goto L41;
        r19 = r1;
    L41:
        MultiLinkGuestViewBinder.a r110 = (MultiLinkGuestViewBinder.a) r19;
        if (r110 == null) goto L37;
        int r111 = r110.a;
        int r112 = ((Number) r13.getFirst()).intValue();
        int r113 = ((Number) r13.getSecond()).intValue();
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(r1, r6, 7) == false) goto L48;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r114 = this.d;
        if (r114 == null) goto L53;
        Pair<Integer, Integer> r20 = r114.vn(r111, this.z.d);
    L54:
        if (r20 == null) goto L55;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(null, r6, 7) == false) goto L61;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r115 = this.d;
        if (r115 == null) goto L66;
        Pair<Integer, Integer> r21 = r115.Yl(r111, this.z.d);
    L67:
        if (r21 != null) goto L69;
    L68:
        r1 = null;
        r6 = 0;
        goto L37
    L69:
        int r116 = (r112 + ((Number) r20.getFirst()).intValue()) - r9;
        float r117 = r116 / r4;
        float r118 = ((r113 + ((Number) r20.getSecond()).intValue()) - r10) / r5;
        float r22 = ((Number) r21.getFirst()).floatValue() / r4;
        float r24 = ((Number) r21.getSecond()).floatValue() / r5;
        String r25 = r110.k.a.getInteractId();
        if (r25 != null) goto L72;
        r25 = "";
    L72:
        r14.add(new bd0.b(r25, r117, r118, r22, r24));
    L66:
        r21 = null;
        goto L67
    L61:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r26 = this.d;
        if (r26 == null) goto L66;
        ug0.a r27 = r26.getRvLayoutManager();
        if (r27 == null) goto L66;
        r21 = r27.a(r111);
        goto L67
    L55:
        r1 = null;
    L53:
        r20 = null;
        goto L54
    L48:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r28 = this.d;
        if (r28 == null) goto L53;
        ug0.a r29 = r28.getRvLayoutManager();
        if (r29 == null) goto L53;
        r20 = r29.c(r111);
    L73:
        return r14;
    L75:
        return new ArrayList();
    L77:
        return new ArrayList();
    L16:
        return new ArrayList();
    L13:
        r3 = null;
        goto L14
    L7:
        ILivePlayerClient r30 = hs0.a.b.getCurrentClient();
        if (r30 == null) goto L10;
        IRenderView r31 = r30.getRenderView();
    L11:
        if (r31 == null) goto L13;
        r3 = r31.getSelfView();
        goto L14
    L10:
        r31 = null;
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public void H0(List<? extends tf0.e> r2) {
        Intrinsics.checkNotNullParameter(r2, "windowList");
        I0(r2);
        if (this.z.getUiLayout() != 7) goto L14;
        IInteractService r3 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r3 == null) goto L11;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r4 = r3.getLinkUserInfoCenter();
        if (r4 == null) goto L11;
        List<T> r5 = r4.getOnlineUserList();
        if (r5 == 0) goto L11;
        int r6 = r5.size();
    L12:
        wf0.b.d(r6, this.n);
        return;
    L11:
        r6 = 0;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void I0(List<? extends tf0.e> r7) {
        Intrinsics.checkNotNullParameter(r7, "list");
        int r0 = this.z.getUiLayout();
        int r1 = c1.a;
        if (c1.a(Integer.valueOf(this.z.m()), Integer.valueOf(r0)) == true) goto L5;
        MultiLinkFrequencyOptConfig r2 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.e(null, Integer.valueOf(r0)) == false) goto L11;
    L28:
        BaseMultiLinkWindowManager.L0(this, f0(), 2);
        return;
    L11:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.m(null, Integer.valueOf(r0)) == true) goto L28;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.g(null, Integer.valueOf(r0)) == true) goto L28;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.c(null, Integer.valueOf(r0)) == false) goto L25;
        int r3 = f0();
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == true) goto L20;
        BaseMultiLinkWindowManager.L0(this, r3, 2);
        return;
    L20:
        if (r7.size() <= 1) goto L22;
        BaseMultiLinkWindowManager.L0(this, r3, 2);
        return;
    L22:
        BaseMultiLinkWindowManager.L0(this, 0, 3);
        return;
    L25:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.h(null, Integer.valueOf(r0)) == false) goto L27;
        BaseMultiLinkWindowManager.L0(this, f0(), 2);
        return;
    L27:
        BaseMultiLinkWindowManager.L0(this, 0, 3);
        return;
    L5:
        if (r7.size() < 2) goto L7;
        BaseMultiLinkWindowManager.L0(this, f0(), 2);
        return;
    L7:
        BaseMultiLinkWindowManager.L0(this, 0, 3);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public EPointF Mj(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r2, "uid");
        int r3 = k(r2);
        if (r3 >= 0) goto L7;
        return null;
    L7:
        return g1(r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, vg0.a
    public void Q3(MultiLinkSpecialViewBinder.a r4) {
        Intrinsics.checkNotNullParameter(r4, "itemData");
        if (this.n == false) goto L8;
        rj0.k.m2.getClass();
        rj0.k r0 = rj0.k.a.a();
        if (r0 == null) goto L9;
        rj0.k.b.c(r0, "seat", r4.k, 8);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, vg0.a
    public void d2(MultiLinkNormalEmptyViewBinder.a r4) {
        Intrinsics.checkNotNullParameter(r4, "itemData");
        if (this.n == false) goto L7;
        rj0.k.m2.getClass();
        rj0.k r0 = rj0.k.a.a();
        if (r0 == null) goto L26;
        rj0.k.b.c(r0, "seat", r4.b(), 8);
        return;
    L26:
        return;
    L7:
        Integer r1 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r1 != null) goto L11;
    L15:
        if (r1 != null) goto L18;
    L20:
        if (r1 != null) goto L23;
        return;
    L23:
        if (r1.intValue() != 2) goto L31;
        i1(r4.b());
        return;
    L31:
        return;
    L18:
        if (r1.intValue() != 1) goto L20;
        j1(r4.b());
        return;
    L11:
        if (r1.intValue() != 0) goto L15;
        rj0.l.n2.getClass();
        rj0.l r2 = rj0.l.a.a();
        if (r2 == null) goto L28;
        int r5 = r4.b;
        int r3 = bh0.a.a;
        rj0.l.b.a(r2, r5, 101, "video_empty_stub_click");
        return;
    }

    public final void e1(String r7) {
        ALogger.i("MicseatMixer#WindowManager", "destroyMicseatMixer from ".concat(r7));
        this.T = false;
        tj0.g r0 = this.M;
        if (r0 != null) goto L5;
    L19:
        this.M = null;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r8 = this.h;
        if (r8 == null) goto L23;
        r8.u();
    L23:
        if (je0.d.r() == false) goto L31;
        sj0.a r9 = this.N;
        r9.getClass();
        Intrinsics.checkNotNullParameter("destroyMicseatMixer", "from");
        ALogger.i("MicseatMixer#AnchorPreviewUpdater", "release from destroyMicseatMixer");
        r9.a.post(new sj0.b(r9));
        return;
    L31:
        return;
    L5:
        if (r0.a == false) goto L19;
        r0.a = false;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a r10 = r0.c;
        if (r10 == null) goto L16;
        Iterator<T> r2 = r10.a.values().iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        Pair r3 = (Pair) r2.next();
        ((Bitmap) r3.getSecond()).recycle();
        String r4 = (String) r3.getFirst();
        MemoryCache r5 = ImagePipelineFactory.getInstance().getImagePipeline().getBitmapMemoryCache();
        if (r5 == null) goto L11;
        r5.removeAll(new com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.b(r4));
        goto L11
    L15:
        r10.a.clear();
    L16:
        r0.c = null;
        r0.d = null;
        r0.f.release();
        tf0.o.a r11 = r0.g;
        if (r11 == null) goto L19;
        r11.f();
        goto L19
    }

    public final EPointF g1(int r6) {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        View r1 = null;
        if (r0 == null) goto L7;
        ih0.b r2 = r0.dynamicService(this.C);
        if (r2 == null) goto L7;
        ih0.c r3 = r2.Z9();
    L9:
        if (BaseMultiLinkWindowManager.t0(r3) == false) goto L32;
        if (r3 == null) goto L13;
        r1 = r3.getHybridView();
    L13:
        if ((r1 instanceof LynxView) == false) goto L31;
        LynxView r4 = r3.getHybridView();
        if (r4 == null) goto L29;
        View r5 = r4.findViewByName("micseat_container_" + r6);
        int r7 = dd0.a.a;
        if (r5 == null) goto L19;
        float r8 = r5.getScaleX();
    L20:
        LynxView r9 = r3.getHybridView();
        if (r9 == null) goto L27;
        View r10 = r9.findViewByName("micseat_guest_avatar_" + r6);
        if (dd0.a.i(r10) == false) goto L42;
        return dd0.a.f(r5, r8);
    L42:
        return dd0.a.f(r10, r8);
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.LynxView");
    L19:
        r8 = 1.0f;
        goto L20
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.LynxView");
    L31:
        return new EPointF(0.0f, 0.0f);
    L32:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r11 = this.d;
        if (r11 == null) goto L40;
        LinkMicRecyclerView r12 = r11.getRecyclerView();
        if (r12 == null) goto L40;
        RecyclerView.ViewHolder r13 = r12.findViewHolderForAdapterPosition(r6);
        if (r13 == null) goto L40;
        return f1(this, r13.itemView);
    L40:
        return new EPointF();
    L7:
        r3 = null;
        goto L9
    }

    public final void h1(String r7) {
        Boolean r0 = (Boolean) this.C.get("data_micseat_mix_stream_state", Boolean.FALSE);
        ALogger.i("MicseatMixer#WindowManager", "initMicseatMixer from " + r7 + ", isMicseatMixStreamEnable = " + r0);
        if (r0.booleanValue() == true) goto L5;
        return;
    L5:
        ih0.c r1 = null;
        if (je0.d.r() == true) goto L8;
        rj0.l.n2.getClass();
        rj0.l r8 = rj0.l.a.a();
        if (r8 != null) goto L13;
    L60:
        if (this.M == null) goto L86;
        IInteractService r9 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r9 == null) goto L66;
        ih0.b r10 = r9.dynamicService(this.C);
        if (r10 == null) goto L66;
        r1 = r10.Z9();
    L66:
        if (r1 == null) goto L80;
        tj0.g r11 = this.M;
        if (r11 == null) goto L80;
        LynxView r2 = r1.getHybridView();
        if (r2 == null) goto L78;
        LynxView r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "container");
        if (r11.a == true) goto L80;
        r11.a = true;
        r11.c = new com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a();
        r11.d = new com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.c(r3);
        r11.f.init();
        tf0.o.a r12 = r11.g;
        if (r12 == null) goto L80;
        r12.f();
        goto L80
    L78:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.LynxView");
    L80:
        if (je0.d.r() == false) goto L82;
        this.N.b("initMicseatMixer");
    L82:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r13 = this.h;
        if (r13 == null) goto L85;
        r13.u();
    L85:
        this.C.put("cmd_link_window_layout_config_changed", this.z);
    L86:
        this.T = true;
        return;
    L13:
        if (r8.isEngineOn() != true) goto L60;
        if (this.M != null) goto L60;
        int r14 = MicseatMixerFactory.a;
        rj0.l r15 = rj0.l.a.a();
        if (r15 == null) goto L21;
        com.bytedance.android.live.pushstream.d r16 = r15.getLiveStream();
        if (r16 == null) goto L21;
        d0 r17 = r16.getLiveCore();
    L22:
        com.bytedance.android.live.liveinteract.plantform.base.b.h0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.b r4 = com.bytedance.android.live.liveinteract.plantform.base.b.a.a();
        if (r4 == null) goto L31;
        hg6.g r5 = r4.P2();
        if (r5 == null) goto L31;
        ec6.b r6 = r5.R();
        if (r6 == null) goto L31;
        com.bytedance.android.live.pushstream.d r18 = gc6.b.a(r6);
        if (r18 == null) goto L31;
        d0 r19 = r18.getLiveCore();
    L32:
        com.bytedance.android.live.liveinteract.plantform.base.b r20 = com.bytedance.android.live.liveinteract.plantform.base.b.a.a();
        if (r20 == null) goto L41;
        hg6.g r21 = r20.P2();
        if (r21 == null) goto L41;
        ec6.b r22 = r21.R();
        if (r22 == null) goto L41;
        com.bytedance.android.live.pushstream.d r23 = gc6.b.a(r22);
        if (r23 == null) goto L41;
        d0 r24 = r23.getLiveCore();
    L42:
        com.bytedance.android.live.liveinteract.plantform.base.b r25 = com.bytedance.android.live.liveinteract.plantform.base.b.a.a();
        if (r25 == null) goto L45;
        hg6.g r26 = r25.P2();
    L47:
        if ((r26 instanceof RtcManager) == true) goto L49;
        r26 = null;
    L49:
        RtcManager r27 = (RtcManager) r26;
        if (r17 != null) goto L52;
        r17 = r19;
    L52:
        if (r17 == null) goto L55;
        r24 = r17;
    L55:
        if (r24 != null) goto L57;
        r24 = null;
    L57:
        if (r24 == null) goto L60;
        Intrinsics.checkNotNullParameter(r24, "liveCore");
        this.M = new tj0.g(new uj0.b(r24), null);
        goto L60
    L45:
        r26 = null;
    L41:
        r24 = null;
    L31:
        r19 = null;
    L21:
        r17 = null;
        goto L22
    L8:
        if (this.M != null) goto L60;
        int r28 = MicseatMixerFactory.a;
        this.M = MicseatMixerFactory.Companion.a(this.D);
        goto L60
    }

    public void i1(final int r9) {
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.util.d.a(this.n) == true) goto L5;
        X0(r9);
        return;
    L5:
        if (((Boolean) vm2.d.Y6.getValue(null, vm2.d.a[412(0x19c, float:5.77E-43)])).booleanValue() == true) goto L13;
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L12;
        IRoom r2 = (IRoom) r0.getValue();
        if (r2 == null) goto L16;
        Context r1 = getContext();
        Boolean r6 = Boolean.TRUE;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.util.d.f(r1, r2, r9, false, r6, r6, new CommonMultiLinkWindowManager$onEmptyItemClickWhileOnline$1(this, r9));
        return;
    L16:
        return;
    L12:
        return;
    L13:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.util.d.e(false, r9);
    }

    public void j1(int r5) {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L34;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 != null) goto L8;
        return;
    L8:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.a.a(r1) == false) goto L15;
        ChatRoomGuestAppliedDialog r2 = new ChatRoomGuestAppliedDialog(getContext(), this.C, new e(this, r5));
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L30;
        DialogLancet.handleBlockedDialogShow(r2);
        return;
    L30:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L13:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
        return;
    L15:
        if (com.bytedance.android.live.liveinteract.plantform.utils.s0.a(r1) == false) goto L20;
        rj0.l.n2.getClass();
        rj0.l r6 = rj0.l.a.a();
        if (r6 == null) goto L37;
        r6.Sj();
        return;
    L37:
        return;
    L20:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.a.b() == false) goto L22;
        k1(r5, false);
        return;
    L22:
        VideoTalkRoomApplyCancelDialog r3 = new VideoTalkRoomApplyCancelDialog(getContext(), this.C, r5);
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L32;
        DialogLancet.handleBlockedDialogShow(r3);
        return;
    L32:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
    L26:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
        return;
    }

    public final void n1(List<? extends tf0.e> r8) {
        if (MultiLinkLoadWidgetUtils.g() == false) goto L6;
        int r0 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.i.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.i.a(this.z, r8, this.b, this.a, this.T, new CommonMultiLinkWindowManager$updateClipDynamic$1(this));
        int r1 = vd0.a.g;
        vd0.a r2 = vd0.a.C0284a.a(this.C);
        wd0.b r3 = r2.c;
        r3.i = r8;
        r2.d.a(r3, r2.a, r2.b);
    L52:
        if (vm2.d.J0().c() == false) goto L61;
        p1(r8);
        return;
    L61:
        return;
    L6:
        if (MultiLinkLoadWidgetUtils.f() == false) goto L50;
        Path r4 = new Path();
        Iterator<T> r5 = r8.iterator();
        int r6 = 0;
    L9:
        if (r5.hasNext() == false) goto L36;
        Object r7 = r5.next();
        int r9 = r6 + 1;
        if (r6 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        tf0.e r10 = (tf0.e) r7;
        if (this.T == false) goto L21;
        com.bytedance.android.live.liveinteract.videotalk.utils.c r11 = this.b;
        if (r11 == null) goto L18;
        Path r12 = r11.a(r6, 0.0f, 0.0f);
    L19:
        r4.addPath(r12);
    L34:
        r6 = r9;
        goto L9
    L18:
        r12 = new Path();
        goto L19
    L21:
        if ((r10 instanceof MultiLinkGuestViewBinder.a) == true) goto L23;
        r10 = null;
    L23:
        MultiLinkGuestViewBinder.a r13 = (MultiLinkGuestViewBinder.a) r10;
        if (r13 == null) goto L34;
        ILinkPlayerInfoBridge r14 = r13.k.a;
        if (r14.getUser() == null) goto L34;
        if (je0.d.x(Integer.valueOf(r14.getLinkType())) == false) goto L34;
        com.bytedance.android.live.liveinteract.videotalk.utils.c r15 = this.b;
        if (r15 == null) goto L32;
        Path r16 = r15.a(r6, 0.0f, 0.0f);
    L33:
        r4.addPath(r16);
        goto L34
    L32:
        r16 = new Path();
        goto L33
    L36:
        if (this.z.getUiLayout() == 16) goto L38;
    L44:
        com.bytedance.android.live.ui.c r17 = this.a;
        if (r17 == null) goto L47;
        r17.o(r4);
    L47:
        com.bytedance.android.live.liveinteract.animation.universalwidget.a.f0.getClass();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r18 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C0014a.a();
        if (r18 == null) goto L52;
        r18.Jl(r4);
        goto L52
    L38:
        if (je0.d.H() == false) goto L44;
        int r19 = qi0.e.a;
        int r20 = qi0.e.a(this.z.getUiLayout());
        com.bytedance.android.live.liveinteract.videotalk.utils.c r21 = this.b;
        if (r21 == null) goto L42;
        Path r22 = r21.a(r20, 0.0f, 0.0f);
    L43:
        r4.addPath(r22);
        goto L44
    L42:
        r22 = new Path();
        goto L43
    L50:
        this.y.post(new i(this, r8));
        goto L52
    }

    public void onMessage(tlc.d r7) {
        if ((r7 instanceof w8) == false) goto L57;
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
        View r1 = null;
        if (r0 == null) goto L20;
        ih0.b r2 = r0.dynamicService(this.C);
        if (r2 == null) goto L20;
        ih0.c r3 = r2.Z9();
    L21:
        StringBuilder r4 = new StringBuilder("getHeadPointList hybridView: ");
        r4.append(r3);
        r4.append('-');
        if (r3 == null) goto L24;
        View r5 = r3.S0();
    L25:
        r4.append(r5 instanceof AnnieCard);
        r4.append(" ;hybridView.getHybridView(): ");
        if (r3 == null) goto L28;
        View r6 = r3.getHybridView();
    L29:
        r4.append(r6);
        r4.append('-');
        if (r3 == null) goto L32;
        View r9 = r3.getHybridView();
    L33:
        r4.append(r9 instanceof LynxView);
        ALogger.d("VoiceCommonMultiLinkWindowManager", r4.toString());
        if (BaseMultiLinkWindowManager.t0(r3) == false) goto L55;
        if (r3 == null) goto L38;
        r1 = r3.getHybridView();
    L38:
        if ((r1 instanceof LynxView) == false) goto L70;
        IBaseUser r10 = r8.getFromUser();
        if (r10 == null) goto L43;
        String r11 = r10.getIdString();
        if (r11 == null) goto L43;
    L44:
        Intrinsics.checkNotNullParameter(r11, "uid");
        int r12 = k(r11);
        LynxView r13 = r3.getHybridView();
        if (r13 == null) goto L54;
        View r14 = r13.findViewByName("micseat_container_" + r12);
        LynxView r15 = r3.getHybridView();
        if (r15 == null) goto L52;
        View r16 = r15.findViewByName("micseat_guest_avatar_" + r12);
        if ((r14 instanceof ViewGroup) == false) goto L71;
        SeatAnimManager r17 = this.J;
        int r18 = com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.p.a;
        s1.j(2131169229);
        r17.c(com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.p.a(ag1.b.a(r8)), r8, (ViewGroup) r14, r16);
        return;
    L71:
        return;
    L52:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.LynxView");
    L54:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.LynxView");
    L43:
        r11 = "";
        goto L44
    L70:
        return;
    L55:
        SeatAnimManager r19 = this.J;
        int r20 = com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.p.a;
        r19.b(com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.p.a(ag1.b.a(r8)));
        return;
    L32:
        r9 = null;
        goto L33
    L28:
        r6 = null;
        goto L29
    L24:
        r5 = null;
    L20:
        r3 = null;
        goto L21
    L57:
        if ((r7 instanceof h1) == false) goto L74;
        h1 r21 = (h1) r7;
        if (r21.getMType() != 53) goto L75;
        ILinkerChangeMediaInfoContent r22 = r21.getLinkerChangeMediaInfoContent();
        if (r22 == null) goto L76;
        ILinkmicMediaParam r23 = r22.getLinkmicMediaParam();
        if (r23 == null) goto L77;
        k0 r24 = r23.getUpdateMediaInfoNotify();
        if (r24 != null) goto L67;
        return;
    L67:
        if (r24.getNeedUpdate() == false) goto L79;
        int r25 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.b.a;
        String r26 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.b.a((int) r24.getPosition());
        this.D.ca(com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.b.b((int) r24.getPosition()), r26);
        return;
    L79:
        return;
    L77:
        return;
    L76:
        return;
    L75:
        return;
    }

    public void p1(List<? extends tf0.e> r4) {
        Intrinsics.checkNotNullParameter(r4, "windowList");
        if (this.z.getUiLayout() != 7) goto L5;
    L13:
        IGameDataService r0 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r0 == null) goto L26;
        com.bytedance.live.datacontext.m r1 = r0.getClearScreen();
        if (r1 == null) goto L26;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L26;
        ViewGroup r5 = getFirstSeatVHShadowContainer();
        if ((r5 instanceof ClipFrameLayout) == true) goto L22;
        r5 = null;
    L22:
        ClipFrameLayout r6 = (ClipFrameLayout) r5;
        if (r6 == null) goto L29;
        r6.setMClipPath(null);
        return;
    L29:
        return;
    L26:
        this.y.post(new j(this, r4));
        return;
    L5:
        if (this.z.getUiLayout() == 15) goto L13;
        ViewGroup r7 = getFirstSeatVHShadowContainer();
        if ((r7 instanceof ClipFrameLayout) == true) goto L9;
        r7 = null;
    L9:
        ClipFrameLayout r8 = (ClipFrameLayout) r7;
        if (r8 == null) goto L28;
        r8.setMClipPath(null);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final int qq(int r1) {
        return s1.j(2131169230);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, vg0.a
    public void w1(MultiLinkGuestViewBinder.a r14) {
        Intrinsics.checkNotNullParameter(r14, "itemData");
        BaseMultiLinkWindowManager.B0(r14);
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 != null) goto L5;
    L16:
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        Object r2 = null;
        if (r1 == null) goto L19;
        IRoom r3 = (IRoom) r1.getValue();
    L20:
        boolean r4 = v0(r14.k.a.getUser());
        ILinkPlayerInfoBridge r15 = r14.k.a;
        if (r4 == false) goto L44;
        if (((IInteractService) jc1.k.n(IInteractService.class)).isEnableTalkRoomEmoji() == false) goto L44;
        DataCenter r8 = this.C;
        if (r15.getSilenceStatus() == 0) goto L27;
        boolean r11 = true;
    L28:
        r8.put("data_self_is_silenced", Boolean.valueOf(r11));
        if (hd0.c.f().h() == false) goto L40;
        com.bytedance.android.live.liveinteract.videotalk.emoji.t r16 = new com.bytedance.android.live.liveinteract.videotalk.emoji.t();
        r16.e(getContext());
        r16.f(this.C);
        r16.g(true);
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r16.d = "seat";
        q0 r17 = r16.b();
        if ((r17 instanceof VideoTalkDynamicEmojiDialog) == false) goto L34;
        r2 = r17;
    L34:
        VideoTalkDynamicEmojiDialog r5 = (VideoTalkDynamicEmojiDialog) r2;
        if (r5 == null) goto L37;
        r5.K = this.D.l6();
    L37:
        r17.a();
        return;
    L40:
        if (hd0.c.f().g() == false) goto L44;
        xs2.b.a().post(new UserProfileEvent(r15.getUser()).setClickUserPosition("pk_linked_audience").setReportSource("audience_audio").setReportType("data_card_linked_audience").setShowSendGift(true));
        return;
    L27:
        r11 = false;
    L44:
        if (je0.d.c0() == false) goto L62;
        if (r4 == true) goto L62;
        if (this.n == false) goto L49;
    L50:
        Context r6 = getContext();
        DataCenter r7 = this.C;
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        Intrinsics.checkNotNullParameter(r15, "userInfo");
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        if (hg6.i.a() == false) goto L53;
        ih0.d r9 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.j;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r15, "seat", false);
    L58:
        if (this.z.getUiLayout() != 6) goto L60;
        r9.v0(h(r15.getInteractId()));
    L60:
        r9.a();
        return;
    L53:
        VideoTalkInteractEmojiPanel r10 = new VideoTalkInteractEmojiPanel(r6, r7, r15);
        Intrinsics.checkNotNullParameter("seat", "<set-?>");
        r10.k = "seat";
        r10.r = false;
        tb6.c r12 = r10.x;
        if (r12 == null) goto L56;
        r12.a();
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r12.d = "seat";
    L56:
        r9 = r10;
        goto L58
    L49:
        if (hd0.c.f().h() == true) goto L50;
    L62:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L78;
        if (r4 == true) goto L78;
        if (r3 == null) goto L66;
        String r13 = r3.getOwnerUserIdString();
    L67:
        IBaseUser r18 = r15.getUser();
        if (r18 == null) goto L70;
        String r19 = r18.getIdString();
    L72:
        if ((!Intrinsics.areEqual(r13, r19)) == false) goto L78;
        com.bytedance.android.live.liveinteract.videotalk.dialog.n r20 = new com.bytedance.android.live.liveinteract.videotalk.dialog.n(getContext(), r15, false, "", this.C);
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r20.n = "seat";
        r20.B = r15.getUserPosition();
        if (DialogLancet.shouldBlockDialogShow(r20) == false) goto L130;
        DialogLancet.handleBlockedDialogShow(r20);
        return;
    L130:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L127
    L77:
        DialogLancet.beforeDialogShow(r20);
        r20.show();
        DialogLancet.afterDialogShow(r20);
        return;
    L70:
        r19 = null;
        goto L72
    L66:
        r13 = null;
    L78:
        if (r4 == false) goto L85;
        com.bytedance.android.live.liveinteract.videotalk.dialog.n r21 = new com.bytedance.android.live.liveinteract.videotalk.dialog.n(getContext(), r15, false, "", this.C);
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r21.n = "seat";
        r21.B = r15.getUserPosition();
        if (DialogLancet.shouldBlockDialogShow(r21) == false) goto L132;
        DialogLancet.handleBlockedDialogShow(r21);
        return;
    L132:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L128
    L83:
        DialogLancet.beforeDialogShow(r21);
        r21.show();
        DialogLancet.afterDialogShow(r21);
        return;
    L85:
        if (this.n == true) goto L107;
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L107;
        IBaseUser r22 = r15.getUser();
        if (r22 == null) goto L91;
        String r23 = r22.getIdString();
    L92:
        if (r3 == null) goto L94;
        String r24 = r3.getOwnerUserIdString();
    L96:
        if (Intrinsics.areEqual(r23, r24) == false) goto L107;
        if (this.z.j() != 12) goto L107;
        if (je0.d.J(false, true) == false) goto L107;
        com.bytedance.android.live.liveinteract.videotalk.dialog.d r25 = new com.bytedance.android.live.liveinteract.videotalk.dialog.d(getContext(), r15, this.C);
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        if (DialogLancet.shouldBlockDialogShow(r25) == false) goto L134;
        DialogLancet.handleBlockedDialogShow(r25);
        return;
    L134:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L129
    L105:
        DialogLancet.beforeDialogShow(r25);
        r25.show();
        DialogLancet.afterDialogShow(r25);
        return;
    L94:
        r24 = null;
        goto L96
    L91:
        r23 = null;
    L107:
        if (hd0.c.f().h() == false) goto L109;
    L125:
        xs2.b.a().post(new UserProfileEvent(r15.getUser()).setClickUserPosition("pk_linked_audience").setReportSource("audience_audio").setReportType("data_card_linked_audience").setShowSendGift(true));
        return;
    L109:
        if (this.z.getUiLayout() != 7) goto L111;
    L114:
        IBaseUser r26 = r15.getUser();
        if (r26 == null) goto L117;
        String r27 = r26.getIdString();
    L118:
        if (r3 == null) goto L121;
        r2 = r3.getOwnerUserIdString();
    L121:
        if (Intrinsics.areEqual(r27, r2) == false) goto L125;
        if (r15.getUserPosition() != 0) goto L125;
        return;
    L117:
        r27 = null;
        goto L118
    L111:
        if (this.z.getUiLayout() == 15) goto L114;
        if (this.z.getUiLayout() != 62) goto L125;
    L19:
        r3 = null;
        goto L20
    L5:
        if (r0.isEngineOn() == true) goto L16;
        com.bytedance.android.livesdk.chatroom.o r28 = com.bytedance.android.live.liveinteract.api.utils.m.l(this.C, 0L);
        if (r28 == null) goto L16;
        com.bytedance.live.datacontext.m r29 = r28.getCleanMode();
        if (r29 == null) goto L16;
        if (((Number) r29.getValue()).intValue() != 2) goto L16;
        if (vm2.e.h() == false) goto L16;
        ALogger.w("BaseMultiLinkWindowManager", "rejected guest stub click for pure clean mode");
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean wc(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return this.J.f(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final int zl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return k(r2);
    }

    public static EPointF f1(CommonMultiLinkWindowManager r1, View r2) {
        r1.getClass();
        Rect r3 = new Rect();
        if (r2 == null) goto L5;
        r2.getGlobalVisibleRect(r3);
    L5:
        EPointF r4 = new EPointF();
        ((PointF) r4).x = r3.centerX();
        ((PointF) r4).y = r3.centerY();
        return r4;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final EPointF C7(int r5, int r6) {
        IInteractService r7 = (IInteractService) jc1.k.f(IInteractService.class);
        View r0 = null;
        if (r7 == null) goto L7;
        ih0.b r8 = r7.dynamicService(this.C);
        if (r8 == null) goto L7;
        ih0.c r9 = r8.Z9();
    L9:
        if (BaseMultiLinkWindowManager.t0(r9) == false) goto L32;
        if (r9 == null) goto L13;
        r0 = r9.getHybridView();
    L13:
        if ((r0 instanceof LynxView) == false) goto L31;
        LynxView r1 = r9.getHybridView();
        if (r1 == null) goto L29;
        View r2 = r1.findViewByName("micseat_container_" + r5);
        int r3 = dd0.a.a;
        if (r2 == null) goto L19;
        float r4 = r2.getScaleX();
    L20:
        LynxView r10 = r9.getHybridView();
        if (r10 == null) goto L27;
        View r11 = r10.findViewByName("micseat_guest_avatar_" + r5);
        if (dd0.a.i(r11) == false) goto L42;
        return dd0.a.f(r2, r4);
    L42:
        return dd0.a.f(r11, r4);
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.LynxView");
    L19:
        r4 = 1.0f;
        goto L20
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.LynxView");
    L31:
        return new EPointF(0.0f, 0.0f);
    L32:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r12 = this.d;
        if (r12 == null) goto L40;
        LinkMicRecyclerView r13 = r12.getRecyclerView();
        if (r13 == null) goto L40;
        RecyclerView.ViewHolder r14 = r13.findViewHolderForAdapterPosition(r5);
        if (r14 == null) goto L40;
        return f1(this, r14.itemView);
    L40:
        return new EPointF();
    L7:
        r9 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.animation.InteractAnimationController.d
    public EmojiSoundManager I8(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fromUid");
        Intrinsics.checkNotNullParameter(r3, "toUid");
        return this.I;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean K5(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "fromUserId");
        Intrinsics.checkNotNullParameter(r4, "toUSerId");
        Intrinsics.checkNotNullParameter(r3, "fromUserId");
        Intrinsics.checkNotNullParameter(r4, "toUSerId");
        Intrinsics.checkNotNullParameter(r3, "fromUserId");
        Intrinsics.checkNotNullParameter(r4, "toUSerId");
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final EPointF Kl(int r1, int r2) {
        return g1(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public void U0(int r1, int r2) {
        super.U0(r1, r2);
        if (MultiLinkLoadWidgetUtils.f() == false) goto L11;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r3 = this.h;
        if (r3 == null) goto L17;
        BehaviorSubject<List<tf0.e>> r4 = r3.b;
        if (r4 == null) goto L18;
        List<? extends tf0.e> r5 = (List) r4.getValue();
        if (r5 == null) goto L19;
        n1(r5);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L11:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r6 = this.d;
        if (r6 == null) goto L21;
        ViewGroup r7 = r6.td();
        if (r7 == null) goto L22;
        r7.post(new h(this));
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean W7(EPointF r3, EPointF r4) {
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void a(View r7, MotionEvent r8) {
        int r0 = this.z.getUiLayout();
        int r2 = 0;
        boolean r3 = true;
        if (r0 != 1) goto L5;
    L15:
        if (r3 == true) goto L17;
        return;
    L17:
        if (r7 == null) goto L70;
        if (r8 == null) goto L78;
        View r9 = null;
        pn0.f.c r10 = null;
        r10 = null;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(null, 0, 7) == false) goto L57;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r1 = this.d;
        if (r1 == null) goto L25;
        ConstraintLayout.LayoutParams r4 = r1.getCurRvLayoutParams();
    L26:
        if (r4 == null) goto L28;
        int r5 = ((ViewGroup.MarginLayoutParams) r4).topMargin;
    L29:
        if (r4 == null) goto L31;
        int r6 = ((ViewGroup.MarginLayoutParams) r4).leftMargin;
    L32:
        pn0.f r11 = this.z.d;
        if (r11 == null) goto L37;
        List<pn0.f.c> r12 = r11.d;
        if (r12 == null) goto L37;
        r10 = (pn0.f.c) CollectionsKt.firstOrNull(r12);
    L37:
        if (r10 == null) goto L39;
        int r13 = r10.c;
    L40:
        if (r10 == null) goto L42;
        int r14 = r10.d;
    L43:
        if (r10 == null) goto L45;
        int r15 = r10.e;
    L46:
        if (r10 == null) goto L48;
        r2 = r10.f;
    L48:
        int r16 = r6 + r13;
        int r17 = (r5 + r14) + s1.A();
        if (((int) r8.getRawX()) > r16) goto L51;
        return;
    L51:
        if (((int) r8.getRawX()) < (r16 + r15)) goto L53;
        return;
    L53:
        if (((int) r8.getRawY()) > r17) goto L55;
        return;
    L55:
        if (((int) r8.getRawY()) >= (r17 + r2)) goto L74;
        this.S.onTouchEvent(r8);
        return;
    L74:
        return;
    L45:
        r15 = 0;
        goto L46
    L42:
        r14 = 0;
        goto L43
    L39:
        r13 = 0;
        goto L40
    L31:
        r6 = 0;
        goto L32
    L28:
        r5 = 0;
        goto L29
    L25:
        r4 = null;
        goto L26
    L57:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r18 = this.d;
        if (r18 == null) goto L60;
        r9 = r18.vb();
    L60:
        if (r9 != null) goto L62;
        return;
    L62:
        if (r8.getAction() != 0) goto L67;
        if (this.R.isEmpty() == false) goto L67;
        r9.getGlobalVisibleRect(this.R);
    L67:
        if (this.R.contains((int) r8.getRawX(), (int) r8.getRawY()) == false) goto L77;
        this.S.onTouchEvent(r8);
        return;
    L77:
        return;
    L78:
        return;
    L70:
        return;
    L5:
        if (r0 == 6) goto L15;
        if (r0 == 9) goto L15;
        if (r0 == 7) goto L15;
        if (r0 == 15) goto L15;
        MultiLinkFrequencyOptConfig r19 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.m(Integer.valueOf(this.z.m()), Integer.valueOf(this.z.getUiLayout())) == true) goto L15;
        r3 = false;
        goto L15
    }

    public final void k1(int r3, boolean r4) {
        String r0 = ChatMatchWidget.o;
        ChatMatchViewModel r1 = (ChatMatchViewModel) com.bytedance.live.datacontext.d.e("ChatMatchWidget", ChatMatchViewModel.class);
        if (r1 == null) goto L5;
        r1.showMatchDialog(r4);
        return;
    L5:
        VideoTalkRoomApplyCancelDialog r5 = new VideoTalkRoomApplyCancelDialog(getContext(), this.C, r3);
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

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final int ma(int r1, int r2) {
        return s1.j(2131169229);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void r0(int r1, int r2) {
        super.r0(r1, r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void z0(boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "emptySeatUrl");
        if (vm2.k.b() == true) goto L5;
        return;
    L5:
        boolean r5 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a = r3;
        this.C.put("data_micseat_mix_stream_state", Boolean.valueOf(r3));
        if (r3 == false) goto L8;
        h1("setMicseatMixStreamEnable");
    L9:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r6 = this.h;
        if (r6 == null) goto L17;
        BehaviorSubject<List<tf0.e>> r7 = r6.b;
        if (r7 == null) goto L18;
        List<? extends tf0.e> r8 = (List) r7.getValue();
        if (r8 == null) goto L19;
        n1(r8);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L8:
        e1("setMicseatMixStreamEnable");
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public int D0(List<ti6.f> r3, Map<String, Integer> r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "list");
        Intrinsics.checkNotNullParameter(r4, "posMap");
        this.P.j(r3, r4, r5, new c(this));
        if (je0.d.v() == false) goto L10;
        if (e0.a(this.z.getUiLayout()) == false) goto L10;
        List<Object> r6 = this.z.i();
        if (r6 != null) goto L27;
        return 0;
    L27:
        return r6.size();
    L10:
        if (this.z.getUiLayout() != 2) goto L14;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r7 = this.d;
        if (r7 != null) goto L29;
        return 0;
    L29:
        return r7.getCurrentWindowCount();
    L14:
        int r8 = this.z.getUiLayout();
        if (r8 != 102) goto L17;
    L20:
        boolean r9 = true;
    L21:
        if (r9 == false) goto L30;
        List<Object> r10 = this.z.i();
        if (r10 != null) goto L25;
        return 0;
    L25:
        return r10.size();
    L30:
        return 0;
    L17:
        if (r8 == 103) goto L20;
        r9 = false;
        goto L21
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

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void S(String r4, int r5, int r6) {
        List r7 = (List) this.B.f().getValue();
        boolean r0 = false;
        if (r7 == null) goto L10;
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L10;
        if (Intrinsics.areEqual(((ch0.e) r8.next()).a.getInteractId(), tc0.c.h().e) == false) goto L6;
        r0 = true;
    L10:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r9 = this.d;
        if (r9 == null) goto L17;
        r9.hi(r4, true, r0, true);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean ha(EPointF r2, EPointF r3, EPointF r4) {
        Intrinsics.checkNotNullParameter(r2, "currentPoint");
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        InteractAnimationController.d.a.b(r2, r3, r4);
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public void l(boolean r2, Pair<Integer, Integer> r3, Pair<Integer, Integer> r4) {
        Intrinsics.checkNotNullParameter(r3, "livePlayerVideoSize");
        Intrinsics.checkNotNullParameter(r4, "livePlayerLayoutSize");
        super.l(r2, r3, r4);
        if (this.n == true) goto L8;
        if (hd0.c.f().h() == false) goto L8;
        l1();
    L8:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L10;
    L12:
        boolean r5 = false;
    L13:
        if (r5 == true) goto L18;
        o r6 = new o(je0.d.r(), this.C);
        this.Q = r6;
        i0 r7 = j0.a(r6.b);
        if (r7 == null) goto L17;
        r7.d(sh0.t.b, new p(r6));
        r7.d(sh0.a0.b, new q(r6));
        r7.d(sh0.z.b, new r(r6));
        r7.d(sh0.e0.b, new s(r6));
    L17:
        r6.a.d();
    L18:
        Disposable r8 = null;
        vlc.d r9 = (vlc.d) this.C.get("data_message_manager", null);
        this.K = r9;
        if (r9 == null) goto L21;
        r9.addMessageListener(MessageType.LINK_MIC_DYNAMIC_EMOJI_MESSAGE.getKey(), this);
    L21:
        vlc.d r10 = this.K;
        if (r10 == null) goto L24;
        r10.addMessageListener(MessageType.LINK_MIC_FRIEND_ONLINE_MESSAGE.getKey(), this);
    L24:
        vlc.d r11 = this.K;
        if (r11 == null) goto L28;
        r11.addMessageListener(MessageType.LINKER.getKey(), this);
    L28:
        if (this.z.getUiLayout() != 7) goto L47;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.j r12 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.j(this);
        Intrinsics.checkNotNullParameter(r12, "observer");
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L38;
        com.bytedance.android.livesdk.chatroom.t r13 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r13 == null) goto L45;
        com.bytedance.live.datacontext.m r14 = r13.isCasting();
        if (r14 == null) goto L45;
        Observable r15 = r14.a();
        if (r15 == null) goto L45;
        r8 = r15.subscribe(r12);
    L45:
        if (r8 == null) goto L47;
        RxUtilKt.c(r8, this.e);
        goto L47
    L38:
        com.bytedance.android.livesdk.chatroom.t r16 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r16 == null) goto L45;
        com.bytedance.live.datacontext.m r17 = r16.b();
        if (r17 == null) goto L45;
        Observable r18 = r17.a();
        if (r18 == null) goto L45;
        r8 = r18.subscribe(r12);
    L47:
        i0 r19 = j0.a(this.C);
        if (r19 == null) goto L50;
        r19.d(sh0.a.b, new n(this));
    L50:
        RxUtilKt.c(xs2.b.a().b(com.bytedance.android.livesdk.event.d.class).subscribe(new m(this)), this.e);
        RxUtilKt.c(xs2.b.a().b(zg1.g.class).subscribe(new k(this)), this.e);
        h1("start");
        return;
    L10:
        if (vm2.h.W().enableEffectJSBOnly() == false) goto L12;
        r5 = true;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final EPointF Se(int r5, int r6, EPointF r7, EPointF r8) {
        Intrinsics.checkNotNullParameter(r7, "startPoint");
        Intrinsics.checkNotNullParameter(r8, "endPoint");
        EPointF r9 = new EPointF();
        float r10 = ((PointF) r7).x;
        float r0 = ((PointF) r8).x;
        if (r10 != r0) goto L5;
        ((PointF) r9).x = r10;
        ((PointF) r9).y = (((PointF) r7).y + ((PointF) r8).y) / 2.0f;
    L9:
        return r9;
    L5:
        float r1 = ((PointF) r7).y;
        if (r1 != ((PointF) r8).y) goto L8;
        ((PointF) r9).x = (r10 + r0) / 2;
        ((PointF) r9).y = r1 - (Math.abs(((PointF) r8).x - ((PointF) r7).x) / 3.0f);
        goto L9
    L8:
        float r2 = r0 + r10;
        float r11 = 2;
        ((PointF) r9).x = (r2 / r11) + s1.e(45.0f);
        ((PointF) r9).y = ((((PointF) r8).y + ((PointF) r7).y) / r11) - s1.e(35.0f);
        goto L9
    }

    public CommonMultiLinkWindowManager(Context r17, ConstraintLayout r18, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r19, zj0.c r20, com.bytedance.android.live.liveinteract.plantform.datamerge.d r21, DataCenter r22, tf0.o.a r23, LifecycleOwner r24, View r25, GLSurfaceView r26, com.bytedance.android.live.pushstream.d r27, j1 r28) {
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
        this.U = r25;
        this.V = r26;
        this.I = new EmojiSoundManager(r17, this.n, r27);
        this.J = new SeatAnimManager(r19.j());
        this.N = new sj0.a(r18, r22);
        this.P = new com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c(r22, r21, r19, r28);
        this.R = new Rect();
        this.S = new GestureDetector(r17, new b(this));
    }
}

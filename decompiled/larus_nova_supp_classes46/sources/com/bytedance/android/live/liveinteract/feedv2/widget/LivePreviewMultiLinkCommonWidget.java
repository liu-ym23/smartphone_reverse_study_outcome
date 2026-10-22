package com.bytedance.android.live.liveinteract.feedv2.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.a3;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.liveinteract.api.utils.j;
import com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview;
import com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVoiceFeedPreview;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.g;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.h;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkerBaseInfo;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.model.q;
import com.bytedance.android.live.liveinteract.plantform.model.v0;
import com.bytedance.android.live.liveinteract.utils.MultiScenePreviewStatisticsUtils;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.config.ob0;
import com.bytedance.android.livesdk.config.uj0;
import com.bytedance.android.livesdk.config.vb0;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.message.model.cj;
import com.bytedance.android.livesdk.message.model.gc;
import com.bytedance.android.livesdk.message.model.qb;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.wrds.MultiPreviewSyncDataType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.ILivePreviewMultiLinkCommonWidget;
import com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import com.bytedance.android.livesdkapi.model.ParseSeiData;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LivePreviewMultiLinkDelayConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LivePreviewMultiLinkCommonWidget implements ILivePreviewMultiLinkCommonWidget, te0.a, ILivePreviewMultiLinkCommonWidget.IEnterBundleExtraParamsProvider, l, OnWRDSDataUpdateListener, ILivePreviewMultiLinkCommonWidget.IPreviewMultiLinkEffectProvider {
    public final Lazy A;
    public ParseSeiData B;
    public SeiAppData C;
    public String D;
    public int E;
    public int F;
    public int G;
    public String H;
    public long I;
    public final long J;
    public boolean K;
    public qb L;
    public cj M;
    public boolean N;
    public final Lazy O;
    public final Lazy P;
    public final String Q;
    public final b R;
    public final c S;
    public final a T;
    public IRoom a;
    public int b;
    public int c;
    public Disposable d;
    public IPreviewMultiLinkOuterConfigProvider e;
    public IPreviewMultiLinkOuterConfigProvider.IMobLoggerProvider f;
    public IPreviewPlayerContainerAbility g;
    public MessageHub h;
    public ue0.c i;
    public i j;
    public h k;
    public com.bytedance.android.live.liveinteract.plantform.datamergev2.f l;
    public com.bytedance.android.live.liveinteract.plantform.datamergev2.e m;
    public com.bytedance.android.live.liveinteract.feed.datamerge.h n;
    public com.bytedance.android.live.liveinteract.feed.datamerge.c o;
    public j p;
    public ue0.d q;
    public ue0.a r;
    public ld0.a s;
    public boolean t;
    public final Lazy u;
    public final CompositeDisposable v;
    public MultiScenePreviewStatisticsUtils w;
    public FrameLayout x;
    public com.bytedance.android.live.liveinteract.feedv2.feedview.a y;
    public ylc.c z;

    public static final class a implements com.bytedance.android.live.liveinteract.plantform.datamergev2.c {
        public final /* synthetic */ LivePreviewMultiLinkCommonWidget a;

        @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.c
        public final void a() {
            i r0 = this.a.j;
            if ((r0 instanceof i) == true) goto L5;
            r0 = null;
        L5:
            if (r0 != null) goto L7;
        L15:
            com.bytedance.android.live.liveinteract.feedv2.feedview.a r1 = this.a.y;
            if (r1 == null) goto L19;
            r1.s();
            return;
        L19:
            return;
        L7:
            if (r0.f.getFeedLiveType() != 1) goto L9;
        L14:
            r0.j(false);
            goto L15
        L9:
            if (r0.f.getFeedLiveType() == 9) goto L14;
            if (((Boolean) ob0.a.getValue()).booleanValue() == false) goto L15;
            if (r0.f.getRoom().isOfficialChannelRoom() == false) goto L15;
            goto L14
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.c
        public final IRoom getRoom() {
            IRoom r0 = this.a.a;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mRoom");
        L5:
            return r0;
        }

        public a(LivePreviewMultiLinkCommonWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.c
        public final void b(int r3) {
            LivePreviewMultiLinkCommonWidget r0 = this.a;
            r0.c = r3;
            com.bytedance.android.live.liveinteract.feedv2.feedview.a r1 = r0.y;
            if ((r1 instanceof MultiLinkCommonVideoFeedPreview) == true) goto L5;
            r1 = null;
        L5:
            MultiLinkCommonVideoFeedPreview r2 = (MultiLinkCommonVideoFeedPreview) r1;
            if (r2 == null) goto L9;
            r2.M(r3);
            return;
        }
    }

    public static final class b implements md0.a.b {
        public final /* synthetic */ LivePreviewMultiLinkCommonWidget a;

        public b(LivePreviewMultiLinkCommonWidget r1) {
            this.a = r1;
        }

        @Override // md0.a.b
        public final void onKtvSeiUpdate(String r2) {
            if (r2 == null) goto L7;
            com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.a.y;
            if (r0 == null) goto L8;
            r0.e(r2);
            return;
        L8:
            return;
        }
    }

    public static final class c implements md0.a.c {
        public final /* synthetic */ LivePreviewMultiLinkCommonWidget a;

        @Override // md0.a.InterfaceC0236a
        public final boolean isVersionSupported(int r1, int r2) {
            return true;
        }

        @Override // md0.a.InterfaceC0236a
        public final /* synthetic */ void onBusinessAppSeiUpdate(JSONObject r1) {
        }

        public c(LivePreviewMultiLinkCommonWidget r1) {
            this.a = r1;
        }

        @Override // md0.a.c
        public final void onAudioMvControllerUpdate(String r2) {
            if (r2 == null) goto L7;
            com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.a.y;
            if (r0 == null) goto L8;
            r0.updateMvControllerSei(r2);
            return;
        L8:
            return;
        }

        @Override // md0.a.c
        public final void onAudioSubtitleUpdate(String r3) {
            LivePreviewMultiLinkCommonWidget r0 = this.a;
            String r1 = r0.Q;
            if (r3 == null) goto L8;
            com.bytedance.android.live.liveinteract.feedv2.feedview.a r2 = r0.y;
            if (r2 == null) goto L9;
            r2.updateSubtitleSei(r3);
            return;
        L9:
            return;
        }

        @Override // md0.a.c
        public final void onRadioSeiUpdate(JSONObject r2) {
            com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.a.y;
            if (r0 == null) goto L6;
            r0.updateRadioSei(r2);
            return;
        }

        @Override // md0.a.c
        public final void onRadioTextSeiUpdate(JSONObject r2) {
            com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.a.y;
            if (r0 == null) goto L6;
            r0.updateRadioTextSei(r2);
            return;
        }

        @Override // md0.a.InterfaceC0236a
        public final void onSeiUpdated(SeiAppData r12) {
            if (r12 == null) goto L58;
            LivePreviewMultiLinkCommonWidget r0 = this.a;
            r0.C = r12;
            com.bytedance.android.live.liveinteract.feed.datamerge.h r1 = r0.n;
            if (r1 == null) goto L6;
            r1.e(r12);
        L6:
            h r2 = this.a.k;
            if (r2 == null) goto L11;
            com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b r3 = r2.n;
            if (r3 == null) goto L11;
            r3.d(r12);
        L11:
            com.bytedance.android.live.liveinteract.plantform.datamergev2.f r4 = this.a.l;
            if (r4 == null) goto L14;
            r4.t0(r12);
        L14:
            com.bytedance.android.live.liveinteract.plantform.datamergev2.e r5 = this.a.m;
            if (r5 == null) goto L17;
            r5.t0(r12);
        L17:
            LivePreviewMultiLinkCommonWidget r6 = this.a;
            IRoom r7 = r6.a;
            if (r7 == null) goto L53;
            ue0.a r8 = r6.r;
            if (r8 == null) goto L53;
            if (r7 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("mRoom");
        L23:
            Long r9 = Long.valueOf(r7.getRoomId());
            Intrinsics.checkNotNullParameter(r12, "sei");
            String r10 = r12.getChannelId();
            ch0.e r11 = null;
            String r13 = null;
            if (r9 == null) goto L26;
            String r14 = String.valueOf(r9.longValue());
        L28:
            if ((!Intrinsics.areEqual(r10, r14)) == false) goto L34;
            StringBuilder r15 = new StringBuilder("sei channel id wrong ");
            r15.append(r12.getChannelId());
            r15.append(" room ");
            if (r9 == null) goto L32;
            r13 = String.valueOf(r9.longValue());
        L32:
            r15.append(r13);
            ALogger.d("FeedViewInteractSongDataHandler", r15.toString());
            goto L53
        L34:
            if (r8.b == true) goto L36;
        L41:
            List<ch0.e> r16 = r8.c().o();
            ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
            Iterator<T> r18 = r16.iterator();
        L43:
            if (r18.hasNext() == false) goto L45;
            ch0.e r19 = (ch0.e) r18.next();
            HashMap r20 = new HashMap(r19.d);
            r20.put("EXT_KEY_UPDATE_FEED_VIEW_INTERACT_SONG_SUB_UI_LAYOUT", Integer.valueOf(r12.getSubUILayout()));
            r11 = ch0.e.a(r19, null, null, null, r20, 7);
            r17.add(r11);
            goto L43
        L45:
            HamletAvatarContext r21 = HamletAvatarContext.Companion.getContext();
            if (r21 == null) goto L50;
            m<Integer> r22 = r21.getSeiSubUILayout();
            if (r22 == null) goto L50;
            r22.setValue(Integer.valueOf(r12.getSubUILayout()));
        L50:
            com.bytedance.android.live.liveinteract.feed.datamerge.j.a r23 = new com.bytedance.android.live.liveinteract.feed.datamerge.j.a(true, r17, r11);
            if (r23.a == false) goto L53;
            r8.c().t(r23);
            goto L53
        L36:
            if (r8.a == null) goto L38;
            boolean r24 = true;
        L39:
            if (r24 == true) goto L41;
            ALogger.e("FeedViewInteractSongDataHandler", "proxy not init");
            goto L53
        L38:
            r24 = false;
            goto L39
        L26:
            r14 = null;
        L53:
            com.bytedance.android.live.liveinteract.feedv2.feedview.a r25 = this.a.y;
            if (r25 == null) goto L59;
            r25.h(r12);
            return;
        L59:
            return;
        }

        @Override // md0.a.c
        public final void onSpeechRecognitionSeiUpdate(String r2) {
            if (r2 == null) goto L7;
            com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.a.y;
            if (r0 == null) goto L8;
            r0.updateSpeechRecognitionSei(r2);
            return;
        L8:
            return;
        }

        @Override // md0.a.c
        public final void onSpeechRhythm(String r2) {
            if (r2 == null) goto L7;
            com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.a.y;
            if (r0 == null) goto L8;
            r0.updateSpeechRhythmSei(r2);
            return;
        L8:
            return;
        }

        @Override // md0.a.c
        public final void onVideoStateSeiUpdate(ld0.a r3) {
            com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.a.y;
            if ((r0 instanceof com.bytedance.android.live.liveinteract.feedv2.feedview.b) == true) goto L5;
            r0 = null;
        L5:
            com.bytedance.android.live.liveinteract.feedv2.feedview.b r1 = (com.bytedance.android.live.liveinteract.feedv2.feedview.b) r0;
            if (r1 == null) goto L8;
            r1.onKtvVideoStateChange(r3);
        L8:
            this.a.s = r3;
        }
    }

    public static final class d<T> implements ObservableOnSubscribe {
        public final /* synthetic */ String a;

        public d(String r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<Pair<String, ParseSeiData>> r4) {
            Intrinsics.checkNotNullParameter(r4, "emitter");
            int r0 = ve0.a.a;
            ParseSeiData r1 = ve0.a.b(this.a);
            r4.onNext(new Pair(this.a, r1));
            r4.onComplete();
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ LivePreviewMultiLinkCommonWidget a;
        public final /* synthetic */ String b;

        public e(LivePreviewMultiLinkCommonWidget r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            Pair r9 = (Pair) r8;
            LivePreviewMultiLinkCommonWidget r0 = this.a;
            r0.D = (String) r9.getFirst();
            ParseSeiData r10 = (ParseSeiData) r9.getSecond();
            if (r10 != null) goto L5;
        L7:
            LivePreviewMultiLinkCommonWidget r1 = this.a;
            r1.getClass();
            if (r10 != null) goto L10;
        L15:
            j r11 = this.a.p;
            if (r11 == null) goto L19;
            r11.d(this.b);
            return;
        L19:
            return;
        L10:
            if (r10.getSeiVersion() == 0) goto L15;
            MultiScenePreviewStatisticsUtils r2 = r1.w;
            if (r2 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("multiScenePreviewStatistics");
        L14:
            IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r2, "first_sei_load", 0, 2, null);
            goto L15
        L5:
            if (r10.getSeiVersion() < 3) goto L7;
            this.a.B = r10;
            goto L7
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ LivePreviewMultiLinkCommonWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ParseSeiData d;

        public f(LivePreviewMultiLinkCommonWidget r1, int r2, int r3, ParseSeiData r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            this.a.j(this.b, this.c, this.d);
        }
    }

    public final void onSeiRawUpdatedV2(String r2, ye1.a r3) {
        Intrinsics.checkNotNullParameter(r2, "seiRaw");
        Intrinsics.checkNotNullParameter(r3, "info");
    }

    public final void release() {
        this.N = true;
        IPreviewMultiLinkOuterConfigProvider r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        r1.printALogger(this.Q, hashCode(), "call release", true);
        ue0.c r0 = this.i;
        if (r0 == null) goto L12;
        Iterator<com.bytedance.android.live.liveinteract.feed.datamerge.j> r2 = r0.j.iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        r2.next().detach();
        goto L9
    L11:
        r0.j.clear();
    L12:
        i r3 = this.j;
        if (r3 == null) goto L15;
        r3.m("LinkUserDataSourceFeedWrapper", r3.hashCode(), "detach: MessageHub = " + r3.f.getMessageHub(), false, true);
        r3.f.getMessageHub().removeMessageListener(MessageType.LINK_MIC.getKey(), r3.d);
        r3.f.getMessageHub().removeWRDSListener(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, r3.e);
        r3.b.dispose();
    L15:
        h r4 = this.k;
        if (r4 == null) goto L18;
        r4.detach();
    L18:
        IPreviewMultiLinkOuterConfigProvider r5 = this.e;
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L21:
        r5.getMessageHub().removeMessageListener(MessageType.VOICE_LIVE_THEME_MESSAGE.getKey(), this);
        IPreviewMultiLinkOuterConfigProvider r6 = this.e;
        if (r6 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L24:
        r6.getMessageHub().removeMessageListener(MessageType.LINKER.getKey(), this);
        IPreviewMultiLinkOuterConfigProvider r7 = this.e;
        if (r7 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L27:
        r7.getMessageHub().removeMessageListener(MessageType.LINK_MIC.getKey(), this);
        IPreviewMultiLinkOuterConfigProvider r8 = this.e;
        if (r8 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L30:
        r8.getMessageHub().removeWRDSListener(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, this);
        IPreviewMultiLinkOuterConfigProvider r9 = this.e;
        if (r9 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L33:
        r9.getMessageHub().removeMessageListener(MessageType.ROOM_TEXT_BG_MESSAGE.getIntType(), this);
        IPreviewMultiLinkOuterConfigProvider r10 = this.e;
        if (r10 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L36:
        r10.getMessageHub().removeMessageListener(MessageType.GIFT_COMMENT_MESSAGE.getIntType(), this);
        this.v.clear();
        h();
        this.D = null;
        this.B = new ParseSeiData(0, 0, 0, null, 0, false, null, 0, 255, null);
        this.C = null;
        k(false);
        Disposable r11 = this.d;
        if (r11 == null) goto L39;
        r11.dispose();
    L39:
        this.d = null;
    }

    @Override // te0.a
    public final IMultiScenePreviewStatistics g() {
        MultiScenePreviewStatisticsUtils r0 = this.w;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("multiScenePreviewStatistics");
    L5:
        return r0;
    }

    public final HashMap<String, Object> getChatRoomEnterRoomExtraParam() {
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.y;
        if ((r0 instanceof MultiLinkCommonVoiceFeedPreview) == true) goto L5;
        r0 = null;
    L5:
        MultiLinkCommonVoiceFeedPreview r1 = (MultiLinkCommonVoiceFeedPreview) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getChatRoomEnterRoomExtraParam();
    }

    @Override // te0.a
    public final int getContainerWidth() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewPlayerContainerAbility r1 = r0.getPlayerContainerAbility();
        Integer r2 = null;
        if (r1 == null) goto L19;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if (r3 == null) goto L19;
        Integer r4 = Integer.valueOf(r3.width);
        if (r4.intValue() <= 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L19;
        r2 = r4;
    L25:
        if (r2 == null) goto L28;
        return r2.intValue();
    L28:
        return s1.y();
    L12:
        r5 = false;
    L19:
        IPreviewMultiLinkOuterConfigProvider r6 = this.e;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L22:
        IPreviewPlayerContainerAbility r7 = r6.getPlayerContainerAbility();
        if (r7 == null) goto L25;
        r2 = r7.getWidth();
        goto L25
    }

    public final Object getCurrentSeiParseResultData() {
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.y;
        if ((r0 instanceof com.bytedance.android.live.liveinteract.feedv2.feedview.b) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.live.liveinteract.feedv2.feedview.b r1 = (com.bytedance.android.live.liveinteract.feedv2.feedview.b) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getCurrentSeiParseResultData();
    }

    public final String getCurrentSingUserIdString() {
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.y;
        if ((r0 instanceof com.bytedance.android.live.liveinteract.feedv2.feedview.b) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.live.liveinteract.feedv2.feedview.b r1 = (com.bytedance.android.live.liveinteract.feedv2.feedview.b) r0;
        if (r1 == null) goto L9;
        String r2 = r1.getCurrentSingUserIdString();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return "";
    }

    public final View getFeedPreview() {
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.y;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getViewCompat();
    }

    public final FrameLayout.LayoutParams getKtvComponentLayoutParams() {
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.y;
        if (r0 == null) goto L7;
        FrameLayout.LayoutParams r1 = r0.getKtvComponentLayoutParams();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new FrameLayout.LayoutParams(-1, -2);
    }

    public final HashMap<String, Object> getKtvEnterRoomExtraParam() {
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.y;
        if ((r0 instanceof com.bytedance.android.live.liveinteract.feedv2.feedview.b) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.live.liveinteract.feedv2.feedview.b r1 = (com.bytedance.android.live.liveinteract.feedv2.feedview.b) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getKtvEnterRoomExtraParam();
    }

    public final Object getKtvSeiModelObject() {
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.y;
        if ((r0 instanceof com.bytedance.android.live.liveinteract.feedv2.feedview.b) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.live.liveinteract.feedv2.feedview.b r1 = (com.bytedance.android.live.liveinteract.feedv2.feedview.b) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getKtvSeiModelObject();
    }

    public final void h() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        String r1 = this.Q;
        int r2 = hashCode();
        StringBuilder r3 = new StringBuilder("clearMultiLinkFeedPreview ");
        r3.append(this.y);
        r3.append(", ");
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r4 = this.y;
        if (r4 == null) goto L8;
        int r5 = r4.hashCode();
    L9:
        r3.append(r5);
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r0, r1, r2, r3.toString(), false, 8, null);
        if (((Boolean) vm2.d.w2.getValue(null, vm2.d.a[176(0xb0, float:2.47E-43)])).booleanValue() == false) goto L14;
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r6 = this.y;
        if (r6 == null) goto L14;
        r6.onViewHolderUnSelected();
    L14:
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r7 = this.y;
        if (r7 == null) goto L17;
        r7.release();
    L17:
        FrameLayout r8 = this.x;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L20:
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r9 = this.y;
        if (r9 == null) goto L23;
        View r10 = r9.getViewCompat();
    L24:
        r8.removeView(r10);
        FrameLayout r11 = this.x;
        if (r11 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L27:
        a1.j(r11, 0);
        this.y = null;
        FrameLayout r12 = this.x;
        if (r12 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L31:
        if (r12.getVisibility() != 0) goto L39;
        FrameLayout r13 = this.x;
        if (r13 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L35:
        r13.setVisibility(8);
        if (shouldUseNewLivePlayerLayout() == false) goto L40;
        this.E = 0;
        this.G = 0;
        this.H = null;
        return;
    L40:
        return;
    L39:
        return;
    L23:
        r10 = null;
        goto L24
    L8:
        r5 = 0;
        goto L9
    }

    public final boolean i() {
        if (((Boolean) this.O.getValue()).booleanValue() == false) goto L10;
        LinkFeedTypeConstant.Companion r0 = LinkFeedTypeConstant.Companion;
        IPreviewMultiLinkOuterConfigProvider r1 = this.e;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L8:
        if (r0.isDouyinFullScreen(r1.getFeedLiveType()) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // te0.a
    public final int l() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewPlayerContainerAbility r1 = r0.getPlayerContainerAbility();
        Integer r2 = null;
        if (r1 == null) goto L19;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if (r3 == null) goto L19;
        Integer r4 = Integer.valueOf(r3.height);
        if (r4.intValue() <= 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L19;
        r2 = r4;
    L25:
        if (r2 == null) goto L28;
        return r2.intValue();
    L28:
        return s1.w();
    L12:
        r5 = false;
    L19:
        IPreviewMultiLinkOuterConfigProvider r6 = this.e;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L22:
        IPreviewPlayerContainerAbility r7 = r6.getPlayerContainerAbility();
        if (r7 == null) goto L25;
        r2 = r7.getHeight();
        goto L25
    }

    @Override // te0.a
    public final IInteractPlayView n() {
        return (IInteractPlayView) this.A.getValue();
    }

    public final void onLivePlayerVideoSizeChanged() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r0, this.Q, hashCode(), "onLivePlayerVideoSizeChanged", false, 8, null);
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r1 = this.y;
        if (r1 == null) goto L8;
        r1.onLivePlayerVideoSizeChanged();
    L8:
        m();
    }

    public final void onViewHolderPause() {
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.y;
        if (r0 == null) goto L6;
        r0.onViewHolderPause();
        return;
    }

    public final void onViewHolderResume() {
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.y;
        if (r0 == null) goto L6;
        r0.onViewHolderResume();
        return;
    }

    public final void onViewHolderSelect() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r0, this.Q, hashCode(), "onViewHolderSelect: ", false, 8, null);
        this.K = true;
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r1 = this.y;
        if (r1 == null) goto L8;
        r1.onViewHolderSelected();
    L8:
        MultiScenePreviewStatisticsUtils r2 = this.w;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("multiScenePreviewStatistics");
    L11:
        r2.startObserveLoadEnd();
        MultiScenePreviewStatisticsUtils r3 = this.w;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("multiScenePreviewStatistics");
    L14:
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r3, "feed_view_selected", 0, 2, null);
    }

    public final void onViewHolderUnSelect() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r0, this.Q, hashCode(), "onViewHolderUnSelect: ", false, 8, null);
        this.K = false;
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r1 = this.y;
        if (r1 == null) goto L8;
        r1.onViewHolderUnSelected();
    L8:
        k(false);
        MultiScenePreviewStatisticsUtils r2 = this.w;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("multiScenePreviewStatistics");
    L11:
        r2.onViewHolderUnSelected();
    }

    public final void removeEffectView() {
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.y;
        if (r0 == null) goto L6;
        r0.removeEffectView();
        return;
    }

    public final void resetKtvSeiModelObject() {
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.y;
        if ((r0 instanceof com.bytedance.android.live.liveinteract.feedv2.feedview.b) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.live.liveinteract.feedv2.feedview.b r1 = (com.bytedance.android.live.liveinteract.feedv2.feedview.b) r0;
        if (r1 == null) goto L9;
        r1.resetKtvSeiModelObject();
        return;
    }

    public final void setRenderViewBitmapToMockView() {
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.y;
        if ((r0 instanceof com.bytedance.android.live.liveinteract.feedv2.feedview.b) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.live.liveinteract.feedv2.feedview.b r1 = (com.bytedance.android.live.liveinteract.feedv2.feedview.b) r0;
        if (r1 == null) goto L9;
        r1.setRenderViewBitmapToMockView();
        return;
    }

    @Override // te0.a
    public final boolean shouldUseNewLivePlayerLayout() {
        int r0 = this.b;
        if (r0 != 2) goto L5;
    L10:
        boolean r1 = true;
    L11:
        IMiddlewareLiveService r2 = TTLiveServiceMiddleware.getLiveService();
        if (r2 != null) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == false) goto L21;
        if (r1 == false) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L14:
        if (r2.shouldUseNewLivePlayerLayout() != true) goto L16;
        r3 = true;
        goto L17
    L5:
        if (r0 == 3) goto L10;
        if (r0 == 4) goto L10;
        r1 = false;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList] */
    public final void updateFeedDataToPreLoad() {
        int r0 = g.a;
        IPreviewMultiLinkOuterConfigProvider r1 = this.e;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        if (g.a(r1.getShowFrom()) == false) goto L18;
        h r2 = this.k;
        if (r2 == null) goto L17;
        BehaviorSubject<List<ch0.e>> r3 = r2.b;
        if (r3 == null) goto L17;
        List r4 = (List) r3.getValue();
        if (r4 == null) goto L17;
        List r5 = r4;
        ?? r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L15:
        if (r7.hasNext() == false) goto L29;
        r6.add(((ch0.e) r7.next()).a);
    L29:
        IPreviewMultiLinkOuterConfigProvider r8 = this.e;
        if (r8 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L32:
        v0 r9 = new v0(r8.getRoom().getId(), r6, this.C);
        IRoomModuleService r10 = k.f(IRoomModuleService.class);
        if (r10 == null) goto L40;
        hn1.b r11 = r10.getPreEnterRoomManager();
        if (r11 == null) goto L41;
        r11.f(r9.a, r9, v0.class);
        return;
    L41:
        return;
    L40:
        return;
    L17:
        r6 = CollectionsKt.emptyList();
        goto L29
    L18:
        ue0.c r12 = this.i;
        if (r12 == null) goto L28;
        BehaviorSubject<List<ch0.e>> r13 = r12.b;
        if (r13 == null) goto L28;
        List r14 = (List) r13.getValue();
        if (r14 == null) goto L28;
        List r15 = r14;
        r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r16 = r15.iterator();
    L26:
        if (r16.hasNext() == false) goto L29;
        r6.add(((ch0.e) r16.next()).a);
    L28:
        r6 = CollectionsKt.emptyList();
        goto L29
    }

    public LivePreviewMultiLinkCommonWidget() {
        this.u = LazyKt.lazy(LivePreviewMultiLinkCommonWidget$liveRealTimeChorusEnterRoomOpt$2.INSTANCE);
        this.v = new CompositeDisposable();
        this.A = LazyKt.lazy(new LivePreviewMultiLinkCommonWidget$mInteractPlayView$2(this));
        this.B = new ParseSeiData(0, 0, 0, null, 0, false, null, 0, 255, null);
        this.D = "";
        this.J = 15000;
        this.O = LazyKt.lazy(LivePreviewMultiLinkCommonWidget$liveSmoothEnterRoomSwitch$2.INSTANCE);
        this.P = LazyKt.lazy(LivePreviewMultiLinkCommonWidget$seiUpdateTimeoutSwitchPreview$2.INSTANCE);
        this.Q = "CommonWidget";
        this.R = new b(this);
        this.S = new c(this);
        this.T = new a(this);
    }

    public final List<ILinkPlayerInfoBridge> getOnlineList() {
        return CollectionsKt.emptyList();
    }

    public final void m() {
        if (i() == true) goto L5;
    L26:
        String r0 = this.D;
        if (r0 == null) goto L31;
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r1 = this.y;
        if (r1 == null) goto L31;
        r1.e(r0);
    L31:
        SeiAppData r2 = this.C;
        if (r2 == null) goto L37;
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r3 = this.y;
        if (r3 == null) goto L38;
        r3.h(r2);
        return;
    L38:
        return;
    L37:
        return;
    L5:
        if (this.C == null) goto L26;
        int r4 = this.B.getSeiVersion();
        SeiAppData r5 = this.C;
        if (r5 == null) goto L26;
        if (r4 != r5.getVersion()) goto L26;
        IInteractPlayView r6 = (IInteractPlayView) this.A.getValue();
        if (r6 == null) goto L26;
        JSONObject r7 = this.B.getCanvas();
        IPreviewMultiLinkOuterConfigProvider r8 = this.e;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L15:
        LivePlayerView r9 = r8.getLivePlayerView();
        if (r9 == null) goto L18;
        IRenderView r10 = r9.getRenderView();
    L19:
        IRoom r11 = this.a;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L22:
        IPreviewMultiLinkOuterConfigProvider r12 = this.e;
        if (r12 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L25:
        int r13 = r12.getFeedLiveType();
        int r14 = this.B.getSeiVersion();
        int r15 = this.B.getSeiUiLayout();
        r6.resizeRenderViewByLastSei(r7, r10, r11, r13, r14, r15);
        goto L26
    L18:
        r10 = null;
        goto L19
    }

    @Override // te0.a
    public final eh0.b Y3() {
        return this.m;
    }

    @Override // te0.a
    public final int a() {
        return this.c;
    }

    @Override // te0.a
    public final cj b() {
        return this.M;
    }

    @Override // te0.a
    public final h c() {
        return this.k;
    }

    @Override // te0.a
    public final SeiAppData d() {
        return this.C;
    }

    @Override // te0.a
    public final qb e() {
        return this.L;
    }

    @Override // te0.a
    public final ue0.c f() {
        return this.i;
    }

    public final ld0.a getCurrentVideoStateSeiData() {
        return this.s;
    }

    public final ylc.c getDataSyncListener() {
        return this.z;
    }

    public final String getSeiRaw() {
        return this.D;
    }

    public final int getSeiVersion() {
        return this.E;
    }

    public final String getShowPlayer() {
        return this.H;
    }

    public final int getSubScene() {
        return this.F;
    }

    public final int getUILayout() {
        return this.G;
    }

    @Override // te0.a
    public final eh0.b p5() {
        return this.l;
    }

    public final void clickEnterRoomEventUpdate(boolean r1) {
        k(r1);
    }

    public final void k(boolean r11) {
        IPreviewMultiLinkOuterConfigProvider r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        if (r0.getRoom() == null) goto L27;
        IPreviewMultiLinkOuterConfigProvider r1 = this.e;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L11:
        if (r1.isLiveAlive() == false) goto L28;
        MultiScenePreviewStatisticsUtils r2 = this.w;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("multiScenePreviewStatistics");
    L16:
        IPreviewMultiLinkOuterConfigProvider r3 = this.e;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L19:
        IRoom r4 = r3.getRoom();
        int r6 = this.E;
        int r7 = this.F;
        IPreviewMultiLinkOuterConfigProvider r5 = this.e;
        if (r5 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L22:
        String r8 = r5.getEnterFromMerge();
        IPreviewMultiLinkOuterConfigProvider r9 = this.e;
        if (r9 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L25:
        r2.recordAudiencePreviewStayDuration("multi_scene_preview", r4, r11, r6, r7, r8, r9.getEnterMethod());
        return;
    L28:
        return;
    }

    public final void o(RoomLinkMicSyncData r6) {
        int r0 = g.a;
        IPreviewMultiLinkOuterConfigProvider r1 = this.e;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        if (g.a(r1.getShowFrom()) == false) goto L33;
        i r2 = this.j;
        if (r2 == null) goto L43;
        Intrinsics.checkNotNullParameter(r6, "wrds");
        r2.g(r6.mLinkUsers, r6.clientUIInfo);
        Iterator r3 = ((ArrayList) r2.a).iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        ((com.bytedance.android.live.liveinteract.plantform.base.i.d) r3.next()).e(r6.lockedPositions);
        goto L11
    L13:
        Map r4 = r6.linkerContentMap;
        if (r4 == null) goto L26;
        Map.Entry r5 = z0.a(r4);
        if (r5 == null) goto L26;
        RoomLinkerContent r7 = (RoomLinkerContent) r5.getValue();
        if (r7 == null) goto L26;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r8 = r7.linkedUsers;
        if (r8 == null) goto L26;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r9 = r8;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L23:
        if (r11.hasNext() == false) goto L25;
        r10.add(je0.d.d0((com.bytedance.android.livesdk.link.model.bridge.k) r11.next(), true));
        goto L23
    L25:
        List<ILinkPlayerInfoBridge> r12 = CollectionsKt.toMutableList(r10);
    L27:
        if (r12 == null) goto L32;
        Iterator<T> r13 = r12.iterator();
    L30:
        if (r13.hasNext() == false) goto L32;
        ILinkPlayerInfoBridge r14 = (ILinkPlayerInfoBridge) r13.next();
        int r15 = tc0.e.a;
        tc0.e.b(r14, r6.linkerContentMap);
    L32:
        r2.h(r12, r6.linkerContentMap, r6.clientUIInfo);
        return;
    L26:
        r12 = null;
        goto L27
    L43:
        return;
    L33:
        ue0.d r16 = this.q;
        if (r16 == null) goto L45;
        Intrinsics.checkNotNullParameter(r6, "wrds");
        List r17 = r6.mLinkUsers;
        if (r17 == null) goto L38;
        ClientUIInfo r18 = r6.clientUIInfo;
        r16.f(je0.d.f0(r17, false), r18);
    L38:
        r16.e(r6.lockedPositions);
        return;
    }

    public final void onMessage(tlc.d r9) {
        if (r9 == null) goto L5;
        r9.getMessageMethod();
    L5:
        if (r9 == null) goto L8;
        r9.getMessageId();
    L8:
        if ((r9 instanceof h1) == false) goto L14;
        IPreviewMultiLinkOuterConfigProvider r0 = this.e;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L12:
        r0.printALogger(this.Q, hashCode(), "onMessage: ILinkerMessageBridge, msgMethod = " + r9.getMessageMethod() + ", msgId = " + r9.getMessageId() + ", msgType = " + ((h1) r9).getType2(), true);
        return;
    L14:
        if ((r9 instanceof com.bytedance.android.livesdk.link.model.bridge.z0) == false) goto L20;
        IPreviewMultiLinkOuterConfigProvider r1 = this.e;
        if (r1 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L18:
        r1.printALogger(this.Q, hashCode(), "onMessage: ILinkerMessageBridge, msgMethod = " + r9.getMessageMethod() + ", msgId = " + r9.getMessageId() + ", msgType = " + ((com.bytedance.android.livesdk.link.model.bridge.z0) r9).getType2(), true);
        return;
    L20:
        if ((r9 instanceof gc) == false) goto L25;
        IPreviewMultiLinkOuterConfigProvider r2 = this.e;
        if (r2 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L24:
        String r3 = this.Q;
        int r4 = hashCode();
        StringBuilder r5 = new StringBuilder("receive VoiceLiveThemeManager, msg_id = ");
        r5.append(r9.getMessageId());
        r5.append(", type = ");
        gc r10 = (gc) r9;
        r5.append(r10.getBgType());
        r5.append(", theme = ");
        r5.append(r10.getVoiceLiveTheme());
        r2.printALogger(r3, r4, r5.toString(), true);
        return;
    L25:
        boolean r6 = r9 instanceof qb;
        if (r6 == false) goto L37;
        if (r6 == true) goto L30;
        tlc.d r7 = null;
    L31:
        this.L = (qb) r7;
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r8 = this.y;
        if (r8 == null) goto L45;
        if (r6 == true) goto L35;
        r9 = null;
    L35:
        r8.f((qb) r9);
        return;
    L45:
        return;
    L30:
        r7 = r9;
        goto L31
    L37:
        if ((r9 instanceof cj) == false) goto L47;
        cj r11 = (cj) r9;
        this.M = r11;
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r12 = this.y;
        if (r12 == null) goto L48;
        r12.j(r11);
        return;
    L48:
        return;
    }

    public final void onSeiRawUpdated(String r8) {
        Intrinsics.checkNotNullParameter(r8, "seiRaw");
        if (((Boolean) vb0.a.getValue()).booleanValue() == false) goto L5;
        this.d = Observable.create(new d(r8)).subscribeOn(Schedulers.single()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r8));
        return;
    L5:
        this.D = r8;
        ParseSeiData r0 = ve0.a.b(r8);
        if (r0 != null) goto L8;
    L10:
        if (r0 != null) goto L12;
    L17:
        j r1 = this.p;
        if (r1 == null) goto L22;
        r1.d(r8);
        return;
    L22:
        return;
    L12:
        if (r0.getSeiVersion() == 0) goto L17;
        MultiScenePreviewStatisticsUtils r2 = this.w;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("multiScenePreviewStatistics");
    L16:
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r2, "first_sei_load", 0, 2, null);
        goto L17
    L8:
        if (r0.getSeiVersion() < 3) goto L10;
        this.B = r0;
        goto L10
    }

    public final void recordPlayerFirstFrameLoad(long r7) {
        MultiScenePreviewStatisticsUtils r0 = this.w;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("multiScenePreviewStatistics");
    L5:
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r0, "player_first_frame", 0, 2, null);
    }

    public final void setDataSyncListener(ylc.c r1) {
        this.z = r1;
    }

    public final void updatePreloadRoomLinkMicSyncData(RoomLinkMicSyncData r5) {
        Intrinsics.checkNotNullParameter(r5, "wrds");
        MultiScenePreviewStatisticsUtils r0 = this.w;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("multiScenePreviewStatistics");
    L5:
        r0.updateIsPreload(true, "updatePreloadRoomLinkMicSyncData", "");
        o(r5);
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r1 = this.y;
        if (r1 == null) goto L9;
        r1.updatePreloadRoomLinkMicSyncData(r5);
        return;
    }

    public final void insertEffectView(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.y;
        if (r0 == null) goto L6;
        r0.insertEffectView(r2, r3);
        return;
    }

    public final void onKtvWRDSDataUpdate(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "syncKey");
        com.bytedance.android.live.liveinteract.feedv2.feedview.a r0 = this.y;
        if (r0 == null) goto L6;
        r0.b(r2, r3);
        return;
    }

    public final void onWRDSDataUpdate(String r14, Object r15) {
        Intrinsics.checkNotNullParameter(r14, "syncKey");
        LinkerBaseInfo r0 = null;
        if ((r15 instanceof IRoomLinkMicSyncData) == true) goto L5;
        Object r16 = null;
    L6:
        IRoomLinkMicSyncData r17 = (IRoomLinkMicSyncData) r16;
        if (r17 == null) goto L43;
        ue0.c r1 = this.i;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNullParameter(r17, "syncData");
        r1.a.onNext(r17);
    L11:
        h r2 = this.k;
        if (r2 == null) goto L14;
        Intrinsics.checkNotNullParameter(r17, "syncData");
        r2.v.onNext(r17);
    L14:
        q r18 = r17.getLinkerBaseInfo();
        if (r18 == null) goto L21;
        List<Long> r3 = r18.getPlayModes();
        if (r3 == null) goto L21;
        if (r3.contains(Long.valueOf(13)) != true) goto L21;
        boolean r4 = true;
    L22:
        com.bytedance.android.live.liveinteract.feed.datamerge.c r5 = this.o;
        if (r5 == null) goto L25;
        r5.e(r4);
    L25:
        if (r18 == null) goto L43;
        List<Long> r19 = r18.getPlayModes();
        if (r19 == null) goto L43;
        ArrayList r6 = new ArrayList();
        Iterator<T> r110 = r19.iterator();
    L30:
        if (r110.hasNext() == false) goto L32;
        r6.add(Integer.valueOf((int) ((Number) r110.next()).longValue()));
        goto L30
    L32:
        int r111 = com.bytedance.android.live.liveinteract.aimv.b.a;
        IPreviewMultiLinkOuterConfigProvider r112 = this.e;
        if (r112 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L35:
        boolean r113 = com.bytedance.android.live.liveinteract.aimv.b.b(r112.getRoom());
        if (r6.contains(19) == false) goto L38;
        InteractiveSongContext.Companion.g(true, true, r113, String.valueOf(19));
    L39:
        ue0.c r114 = this.i;
        if (r114 == null) goto L43;
        r114.l(ch0.a.a(r114.e(), 0, 0, r6, 3));
        goto L43
    L38:
        InteractiveSongContext.Companion.g(false, false, r113, "");
    L21:
        r4 = false;
    L43:
        if ((r15 instanceof RoomLinkMicSyncData) == true) goto L45;
        r15 = null;
    L45:
        RoomLinkMicSyncData r115 = (RoomLinkMicSyncData) r15;
        if (r115 == null) goto L49;
        r0 = r115.linkerBaseInfo;
    L49:
        if (((Boolean) this.u.getValue()).booleanValue() == false) goto L56;
        if (r0 != null) goto L52;
        return;
    L52:
        if (r0.getScene() != 9) goto L58;
        updateUILayoutBySei(r0.getUiLayout(), this.G, new ParseSeiData(3, 9, r0.getUiLayout(), null, 0, false, null, 0, 248, null));
        return;
    L58:
        return;
    L56:
        return;
    L5:
        r16 = r15;
        goto L6
    }

    /* JADX WARN: Failed to calculate best type for var: r15v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v5 ??, new type: com.bytedance.android.live.liveinteract.feedv2.feedview.a
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v6 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v7 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v8 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v2 ??, new type: java.lang.StringBuilder
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v4 ??, new type: com.bytedance.android.live.liveinteract.feedv2.feedview.a
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v1 ??, new type: com.bytedance.android.live.liveinteract.feedv2.feedview.a
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderAllow(TypeUpdate.java:66)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryWiderObjects(FixTypesVisitor.java:795)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:249)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public final void j(int r27, int r28, com.bytedance.android.livesdkapi.model.ParseSeiData r29) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0209: CONST (r13v16 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (0 ??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) A[DECLARE_VAR] (LINE:50332169) in method: com.bytedance.android.live.liveinteract.feedv2.widget.LivePreviewMultiLinkCommonWidget.j(int, int, com.bytedance.android.livesdkapi.model.ParseSeiData):void, file: /private/tmp/nixiang/classes46.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1075
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.live.liveinteract.feedv2.widget.LivePreviewMultiLinkCommonWidget.j(int, int, com.bytedance.android.livesdkapi.model.ParseSeiData):void");
    }

    public final void updateUILayoutBySei(int r6, int r7, ParseSeiData r8) {
        Intrinsics.checkNotNullParameter(r8, "parseSeiData");
        ReadOnlyProperty r0 = vm2.d.z2;
        KProperty[] r1 = vm2.d.a;
        if (((LivePreviewMultiLinkDelayConfig) r0.getValue(null, r1[179(0xb3, float:2.51E-43)])).getEnable() == false) goto L5;
        Disposable r9 = Observable.timer(((LivePreviewMultiLinkDelayConfig) r0.getValue(null, r1[179(0xb3, float:2.51E-43)])).getDelayTime(), TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this, r6, r7, r8));
        this.v.add(r9);
        return;
    L5:
        j(r6, r7, r8);
    }

    public final void init(IPreviewMultiLinkOuterConfigProvider r23, IPreviewMultiLinkOuterConfigProvider.IMobLoggerProvider r24, boolean r25, long r26, boolean r28, String r29) {
        Intrinsics.checkNotNullParameter(r23, "configProvider");
        Intrinsics.checkNotNullParameter(r24, "mobLoggerProvider");
        Intrinsics.checkNotNullParameter(r29, "from");
        r23.printALogger(this.Q, hashCode(), "call init", true);
        String r2 = this.Q;
        int r3 = hashCode();
        StringBuilder r1 = new StringBuilder("multiLinkPreviewUseSetting=");
        ReadOnlyProperty r4 = vm2.d.x2;
        KProperty[] r5 = vm2.d.a;
        xlc.a r13 = null;
        r1.append(((Boolean) r4.getValue(null, r5[177(0xb1, float:2.48E-43)])).booleanValue());
        r1.append(", tryLoadByRoomSetting=");
        r1.append(((Boolean) vm2.d.A2.getValue(null, r5[180(0xb4, float:2.52E-43)])).booleanValue());
        r1.append(",tryLoadByRoomForRadioSetting=");
        r1.append(((Boolean) vm2.d.B2.getValue(null, r5[181(0xb5, float:2.54E-43)])).booleanValue());
        r1.append(",loadCommonWidgetOptSetting=");
        r1.append(((Boolean) vm2.d.C2.getValue(null, r5[182(0xb6, float:2.55E-43)])).booleanValue());
        r1.append(",livePreviewMultiLinkModeOpt=");
        r1.append((Boolean) uj0.a.getValue());
        r1.append(",isPreload = ");
        r1.append(r28);
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r23, r2, r3, r1.toString(), false, 8, null);
        this.e = r23;
        this.f = r24;
        this.x = r23.getContainerView();
        this.g = r23.getPlayerContainerAbility();
        this.h = r23.getMessageHub();
        this.b = r23.getShowFrom();
        this.a = r23.getRoom();
        c r6 = this.S;
        this.p = new j(r6, this.R, r6);
        this.t = r25;
        MultiScenePreviewStatisticsUtils r7 = new MultiScenePreviewStatisticsUtils(System.currentTimeMillis());
        this.w = r7;
        IPreviewMultiLinkOuterConfigProvider r8 = this.e;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IRoom r9 = r8.getRoom();
        IPreviewMultiLinkOuterConfigProvider r10 = this.e;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L8:
        String r11 = r10.getEnterFromMerge();
        IPreviewMultiLinkOuterConfigProvider r12 = this.e;
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L11:
        String r14 = r12.getEnterMethod();
        IPreviewMultiLinkOuterConfigProvider r15 = this.e;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L14:
        r7.init(r9, r11, r14, r15.getFeedLiveType(), r26);
        if (this.t == false) goto L20;
        MultiScenePreviewStatisticsUtils r16 = this.w;
        if (r16 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("multiScenePreviewStatistics");
    L19:
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r16, "player_first_frame", 0, 2, null);
    L20:
        MultiScenePreviewStatisticsUtils r17 = this.w;
        if (r17 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("multiScenePreviewStatistics");
    L23:
        r17.updateIsPreload(r28, "init", r29);
        IPreviewMultiLinkOuterConfigProvider r18 = this.e;
        if (r18 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L26:
        String r19 = r18.getLastAppData();
        IPreviewMultiLinkOuterConfigProvider r20 = this.e;
        if (r20 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L29:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r20, this.Q, hashCode(), "handleLastAppData lastAppData=" + r19, false, 8, null);
        if (((Boolean) a3.a.getValue()).booleanValue() == true) goto L32;
    L36:
        int r21 = g.a;
        IPreviewMultiLinkOuterConfigProvider r22 = this.e;
        if (r22 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L40:
        if (g.a(r22.getShowFrom()) == false) goto L63;
        IPreviewMultiLinkOuterConfigProvider r27 = this.e;
        if (r27 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L44:
        String r30 = this.Q;
        int r31 = hashCode();
        StringBuilder r32 = new StringBuilder("call initDataMergeCenterV2， showFrom = ");
        r32.append(this.b);
        r32.append(", messageHub = ");
        MessageHub r33 = this.h;
        if (r33 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("messageHub");
    L47:
        r32.append(r33);
        r32.append(", messageHubByOuterProvider");
        IPreviewMultiLinkOuterConfigProvider r34 = this.e;
        if (r34 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L50:
        r32.append(r34.getMessageHub());
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r27, r30, r31, r32.toString(), false, 8, null);
        IPreviewMultiLinkOuterConfigProvider r35 = this.e;
        if (r35 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L53:
        i r36 = new i(r35, this, this.T);
        this.j = r36;
        r36.e();
        i r37 = this.j;
        IPreviewMultiLinkOuterConfigProvider r38 = this.e;
        if (r38 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L56:
        h r39 = new h(null, r37, null, null, r38.getShowFrom(), null, null);
        this.k = r39;
        r39.O1();
        IPreviewMultiLinkOuterConfigProvider r40 = this.e;
        if (r40 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L59:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.f r41 = new com.bytedance.android.live.liveinteract.plantform.datamergev2.f(null, null, null, r40.getShowFrom(), this.j);
        this.l = r41;
        r41.O1();
        IPreviewMultiLinkOuterConfigProvider r42 = this.e;
        if (r42 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L62:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.e r43 = new com.bytedance.android.live.liveinteract.plantform.datamergev2.e(null, null, null, null, r42.getShowFrom(), this.j);
        this.m = r43;
        r43.O1();
    L102:
        IPreviewMultiLinkOuterConfigProvider r44 = this.e;
        if (r44 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L106:
        if (g.a(r44.getShowFrom()) == false) goto L110;
        h r45 = this.k;
        if (r45 == null) goto L113;
        BehaviorSubject<List<ch0.e>> r46 = r45.b;
    L114:
        if (r46 == null) goto L118;
        Disposable r47 = r46.subscribe(new com.bytedance.android.live.liveinteract.feedv2.widget.a(this));
        if (r47 == null) goto L118;
        RxUtilKt.c(r47, this.v);
    L118:
        IPreviewMultiLinkOuterConfigProvider r48 = this.e;
        if (r48 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L121:
        r48.getMessageHub().addMessageListener(MessageType.VOICE_LIVE_THEME_MESSAGE.getKey(), this);
        IPreviewMultiLinkOuterConfigProvider r49 = this.e;
        if (r49 != null) goto L124;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L124:
        r49.getMessageHub().addMessageListener(MessageType.LINKER.getKey(), this);
        IPreviewMultiLinkOuterConfigProvider r50 = this.e;
        if (r50 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L127:
        r50.getMessageHub().addMessageListener(MessageType.LINK_MIC.getKey(), this);
        IPreviewMultiLinkOuterConfigProvider r51 = this.e;
        if (r51 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L130:
        r51.getMessageHub().addWRDSListener(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, this, true);
        int r52 = ng0.e.f;
        IPreviewMultiLinkOuterConfigProvider r53 = this.e;
        if (r53 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L133:
        int r54 = r53.getShowFrom();
        if (r54 != 0) goto L137;
        boolean r55 = vm2.h.e();
    L140:
        if (r55 == false) goto L150;
        IPreviewMultiLinkOuterConfigProvider r56 = this.e;
        if (r56 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L144:
        MessageHub r57 = r56.getMessageHub();
        if ((r57 instanceof xlc.a) == true) goto L147;
        r57 = null;
    L147:
        xlc.a r58 = (xlc.a) r57;
        if (r58 == null) goto L150;
        r58.y(MessageType.ROOM_TEXT_BG_MESSAGE.getIntType(), this);
    L150:
        int r59 = com.bytedance.android.live.liveinteract.voicechat.radio.e.a;
        if (this.a != null) goto L153;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L153:
        LinkFeedTypeConstant.Companion r60 = LinkFeedTypeConstant.Companion;
        IPreviewMultiLinkOuterConfigProvider r61 = this.e;
        if (r61 != null) goto L157;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L157:
        if (r60.isDouyinFullScreen(r61.getShowFrom()) == false) goto L168;
        IPreviewMultiLinkOuterConfigProvider r62 = this.e;
        if (r62 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L161:
        xlc.a r63 = r62.getMessageHub();
        if ((r63 instanceof xlc.a) == false) goto L165;
        r13 = r63;
    L165:
        xlc.a r110 = r13;
        if (r110 == null) goto L168;
        r110.D(MessageType.GIFT_COMMENT_MESSAGE.getIntType(), this, "MetaSubSyncKey");
    L168:
        IPreviewMultiLinkOuterConfigProvider r65 = this.e;
        if (r65 != null) goto L171;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L171:
        RoomLinkMicSyncData r66 = r65.getPreloadRoomLinkMicSyncData();
        if (r66 == null) goto L175;
        o(r66);
        return;
    L175:
        return;
    L137:
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(r54) == false) goto L139;
        r55 = vm2.h.f();
        goto L140
    L139:
        r55 = false;
    L113:
        r46 = null;
        goto L114
    L110:
        ue0.c r67 = this.i;
        if (r67 == null) goto L113;
        r46 = r67.b;
        goto L114
    L63:
        IPreviewMultiLinkOuterConfigProvider r68 = this.e;
        if (r68 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L66:
        String r69 = this.Q;
        int r70 = hashCode();
        StringBuilder r71 = new StringBuilder("call initDataMergeCenter， showFrom = ");
        r71.append(this.b);
        r71.append(", messageHub = ");
        MessageHub r72 = this.h;
        if (r72 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("messageHub");
    L69:
        r71.append(r72);
        r71.append(", messageHubByOuterProvider");
        IPreviewMultiLinkOuterConfigProvider r73 = this.e;
        if (r73 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L72:
        r71.append(r73.getMessageHub());
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r68, r69, r70, r71.toString(), false, 8, null);
        MessageHub r74 = this.h;
        if (r74 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("messageHub");
    L75:
        int r75 = this.b;
        IRoom r76 = this.a;
        if (r76 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L78:
        this.i = new ue0.c(r74, r75, r76.getVoiceLiveTheme());
        this.n = new com.bytedance.android.live.liveinteract.feed.datamerge.h(this.T);
        ArrayList r77 = new ArrayList();
        com.bytedance.android.live.liveinteract.feed.datamerge.h r78 = this.n;
        Intrinsics.checkNotNull(r78);
        ue0.c r79 = this.i;
        Intrinsics.checkNotNull(r79);
        r78.d(r79);
        r77.add(r78);
        IPreviewMultiLinkOuterConfigProvider r80 = this.e;
        if (r80 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L81:
        this.q = new ue0.d(r77, r80);
        this.o = new com.bytedance.android.live.liveinteract.feed.datamerge.c();
        com.bytedance.android.live.liveinteract.feed.datamerge.d r81 = new com.bytedance.android.live.liveinteract.feed.datamerge.d();
        this.r = new ue0.a();
        IRoom r82 = this.a;
        if (r82 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L84:
        com.bytedance.android.live.liveinteract.feed.datamerge.a r83 = new ue0.g(r82);
        ue0.c r84 = this.i;
        if (r84 == null) goto L87;
        com.bytedance.android.live.liveinteract.feed.datamerge.h r85 = this.n;
        Intrinsics.checkNotNull(r85);
        r84.u(r85);
    L87:
        ue0.c r86 = this.i;
        if (r86 == null) goto L90;
        ue0.d r87 = this.q;
        Intrinsics.checkNotNull(r87);
        ue0.c r88 = this.i;
        Intrinsics.checkNotNull(r88);
        r87.d(r88);
        r86.u(r87);
    L90:
        ue0.c r89 = this.i;
        if (r89 == null) goto L93;
        com.bytedance.android.live.liveinteract.feed.datamerge.c r90 = this.o;
        Intrinsics.checkNotNull(r90);
        ue0.c r91 = this.i;
        Intrinsics.checkNotNull(r91);
        r90.d(r91);
        r89.u(r90);
    L93:
        ue0.c r92 = this.i;
        if (r92 == null) goto L96;
        Intrinsics.checkNotNull(r92);
        Intrinsics.checkNotNullParameter(r92, "proxy");
        r81.a = r92;
        r92.u(r81);
    L96:
        ue0.c r93 = this.i;
        if (r93 == null) goto L99;
        ue0.a r94 = this.r;
        Intrinsics.checkNotNull(r94);
        ue0.c r95 = this.i;
        Intrinsics.checkNotNull(r95);
        r94.d(r95);
        r93.u(r94);
    L99:
        ue0.c r96 = this.i;
        if (r96 == null) goto L102;
        Intrinsics.checkNotNull(r96);
        r83.d(r96);
        r96.u(r83);
        goto L102
    L32:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r19) == false) goto L36;
        j r97 = this.p;
        if (r97 == null) goto L36;
        r97.d(r19);
        goto L36
    }
}

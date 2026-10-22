package com.bytedance.android.live.liveinteract.bgComponent.platform;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.bgComponent.theme.VideoThemeView;
import com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.AudioLiveThemeReporter;
import com.bytedance.android.live.liveinteract.feed.d0;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.l;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.model.LinkerBaseInfo;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.videotalk.utils.h;
import com.bytedance.android.live.liveinteract.wrdspreload.MultiLinkWRDSPreloadManager;
import com.bytedance.android.live.ui.ClipImageView;
import com.bytedance.android.live.ui.o;
import com.bytedance.android.live.ui.q;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.chatroom.viewmodel.j;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.y0;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.gc;
import com.bytedance.android.livesdk.message.model.in;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.multilink.IMultiLinkWRDSPreloadService;
import com.bytedance.android.livesdkapi.multilink.MultiLinkMsgPreloadBizListener;
import com.bytedance.android.livesdkapi.multilink.RoomLinkMicSyncDataPreloadBizListener;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006:\u0001\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/bgComponent/platform/MultiLinkThemeBgUIWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/live/liveinteract/bgComponent/platform/a;", "Lcom/bytedance/android/livesdkapi/multilink/MultiLinkMsgPreloadBizListener;", "Lcom/bytedance/android/livesdkapi/multilink/RoomLinkMicSyncDataPreloadBizListener;", "Lcom/bytedance/android/live/ui/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkThemeBgUIWidget extends MiddlewareRoomWidget implements com.bytedance.android.live.liveinteract.bgComponent.platform.a, MultiLinkMsgPreloadBizListener, RoomLinkMicSyncDataPreloadBizListener, com.bytedance.android.live.ui.a, Observer<KVData> {
    public static final /* synthetic */ int D = 0;
    public Integer A;
    public Integer B;
    public final IMultiScenePreviewStatistics C;
    public x00.c a;
    public ViewGroup b;
    public ClipImageView c;
    public ClipImageView d;
    public VideoThemeView e;
    public View f;
    public ImageView g;
    public HSImageView h;
    public com.bytedance.android.live.ui.c i;
    public q j;
    public IVoiceLiveTheme k;
    public final Lazy l;
    public vd0.a m;
    public boolean n;
    public final CompositeDisposable o;
    public m p;
    public List<? extends tf0.e> q;
    public h r;
    public Integer s;
    public Integer t;
    public Disposable u;
    public boolean v;
    public final com.bytedance.android.livesdk.a w;
    public final boolean x;
    public final String y;
    public final IRoom z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MultiLinkThemeBgUIWidget a;

        public b(MultiLinkThemeBgUIWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            i r7 = (i) r6;
            Intrinsics.checkNotNullParameter(r7, "event");
            Integer r0 = this.a.A;
            int r1 = r7.a;
            if (r0 != null) goto L6;
        L7:
            MultiLinkThemeBgUIWidget r2 = this.a;
            r2.Cq("MultiLinkThemeBgUIWidget#observeSceneUILayoutChange", r2.hashCode(), "voiceTalkRoomSubScene scenChanged scene=" + r7.a + ", lastScene=" + this.a.A);
            this.a.Fq(r7.a);
        L8:
            Integer r3 = this.a.B;
            int r4 = r7.b;
            if (r3 != null) goto L12;
        L13:
            MultiLinkThemeBgUIWidget r5 = this.a;
            r5.Cq("MultiLinkThemeBgUIWidget#observeSceneUILayoutChange", r5.hashCode(), "voiceTalkRoomSubScene uiLayoutChanged uiLayout=" + r7.b + ", lastUILayout=" + this.a.B);
            this.a.Aj(r7.b);
            return;
        L12:
            if (r3.intValue() != r4) goto L13;
            return;
        L6:
            if (r0.intValue() == r1) goto L8;
            goto L7
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MultiLinkThemeBgUIWidget a;

        public c(MultiLinkThemeBgUIWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            j r7 = (j) r6;
            Intrinsics.checkNotNullParameter(r7, "event");
            if (r7.f == true) goto L11;
            Integer r0 = this.a.A;
            int r2 = r7.a;
            if (r0 != null) goto L8;
        L9:
            MultiLinkThemeBgUIWidget r1 = this.a;
            r1.Cq("MultiLinkThemeBgUIWidget#observeSceneUILayoutChange", r1.hashCode(), "videoTalkRoomSubScene scenChanged scene=" + r7.a + ", lastScene=" + this.a.A);
            this.a.Fq(r7.a);
            goto L11
        L8:
            if (r0.intValue() != r2) goto L9;
        L11:
            if (r7.f == true) goto L19;
            Integer r3 = this.a.B;
            int r4 = r7.c;
            if (r3 != null) goto L16;
        L17:
            MultiLinkThemeBgUIWidget r5 = this.a;
            r5.Cq("MultiLinkThemeBgUIWidget#observeSceneUILayoutChange", r5.hashCode(), "videoTalkRoomSubScene uiLayoutChanged uiLayout=" + r7.c + ", lastUILayout=" + this.a.B);
            this.a.Aj(r7.c);
            return;
        L16:
            if (r3.intValue() != r4) goto L17;
            return;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ MultiLinkThemeBgUIWidget a;

        public d(MultiLinkThemeBgUIWidget r1) {
            this.a = r1;
        }

        public final void a() {
            MiddlewareRoomContext r0 = this.a.getMiddlewareRoomContext();
            Long r1 = null;
            if (r0 == null) goto L7;
            n r2 = r0.isRoomVisible();
            if (r2 == null) goto L7;
            Boolean r3 = (Boolean) r2.getValue();
        L8:
            MultiLinkThemeBgUIWidget r4 = this.a;
            int r5 = r4.hashCode();
            StringBuilder r6 = new StringBuilder("isVisible=");
            r6.append(r3);
            r6.append(", isFeed=");
            r6.append(this.a.x);
            r6.append(", room=");
            IRoom r7 = this.a.z;
            if (r7 == null) goto L11;
            String r8 = r7.getTitle();
        L12:
            r6.append(r8);
            r4.Cq("MultiLinkThemeBgUIWidget#onCreate", r5, r6.toString());
            MultiLinkThemeBgUIWidget r9 = this.a;
            if (r9.x == true) goto L32;
            IRoom r10 = r9.z;
            if (r10 == null) goto L17;
            r1 = Long.valueOf(r10.getRoomId());
        L17:
            String r11 = r9.y;
            if (r1 == null) goto L21;
            if (r11 == null) goto L21;
            long r12 = r1.longValue();
            Lazy r13 = MultiLinkWRDSPreloadManager.i;
            MultiLinkWRDSPreloadManager.a.a().removeBgMsgBizListener(r11, r12, r9);
            MultiLinkWRDSPreloadManager.a.a().removeRoomLinkMicSyncDataBizListener(r11, r12, r9);
        L21:
            Disposable r14 = r9.u;
            if (r14 != null) goto L24;
        L28:
            MultiLinkThemeBgUIWidget r15 = this.a;
            if (r15.n == true) goto L33;
            r15.Aq();
            return;
        L33:
            return;
        L24:
            if (r14.isDisposed() == true) goto L28;
            Disposable r16 = r9.u;
            if (r16 == null) goto L28;
            r16.dispose();
            goto L28
        L32:
            return;
        L11:
            r8 = null;
        L7:
            r3 = null;
            goto L8
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

    public final int getLayoutId() {
        return 2131567021;
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.platform.a
    public final AudioLiveThemeReporter Mf() {
        return (AudioLiveThemeReporter) this.l.getValue();
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.platform.a
    public final x00.c an() {
        if (this.a != null) goto L6;
        zq();
    L6:
        return this.a;
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.platform.a
    public final void lb() {
        if (this.x == false) goto L7;
        IMultiScenePreviewStatistics r1 = this.C;
        if (r1 == null) goto L15;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r1, "background_Load", 0, 2, null);
        return;
    L15:
        return;
    L7:
        int r0 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r2 = ((Widget) this).dataCenter;
        IRoom r3 = this.z;
        if (r3 == null) goto L10;
        long r4 = r3.getId();
    L11:
        MultiSceneEnterRoomStatisticsUtils r5 = MultiSceneEnterRoomStatisticsUtils.a.a(r2, Long.valueOf(r4));
        if (r5 == null) goto L17;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r5, "background_Load", 0, 2, null);
        return;
    L17:
        return;
    L10:
        r4 = 0;
        goto L11
    }

    public final void onCreate() {
        super.onCreate();
        int r1 = vd0.a.g;
        vd0.a r2 = vd0.a.C0284a.a(((Widget) this).dataCenter);
        this.m = r2;
        r2.e(this.z);
        Integer r3 = this.A;
        boolean r4 = false;
        if (r3 != null) goto L5;
    L15:
        Integer r5 = this.B;
        if (r5 != null) goto L18;
    L28:
        FrameLayout r6 = (FrameLayout) findViewById(2131364141);
        vd0.a r7 = this.m;
        if (r7 == null) goto L31;
        r7.a(1000, new zd0.b(r6));
    L31:
        FrameLayout r8 = (FrameLayout) findViewById(2131364143);
        vd0.a r9 = this.m;
        if (r9 == null) goto L34;
        r9.a(2000, new zd0.b(r8));
    L34:
        FrameLayout r10 = (FrameLayout) findViewById(2131364142);
        vd0.a r11 = this.m;
        if (r11 == null) goto L37;
        r11.a(3000, new zd0.b(r10));
    L37:
        IRoom r12 = this.z;
        if (r12 == null) goto L51;
        if (r12.isLiveTypeAudio() != true) goto L51;
        zd0.d r13 = new zd0.d();
        vd0.a r14 = vd0.a.C0284a.a(((Widget) this).dataCenter);
        Intrinsics.checkNotNullParameter(r13, "bgView");
        ((ArrayList) r14.b.a).add(r13);
        Boolean r15 = (Boolean) ((Widget) this).dataCenter.get("data_show_player", null);
        Integer r16 = (Integer) ((Widget) this).dataCenter.get("feed_live_enter_ui_layout", null);
        if (r15 == null) goto L46;
        vd0.a r17 = this.m;
        if (r17 == null) goto L46;
        r17.g(r15.booleanValue());
    L46:
        if (r16 == null) goto L51;
        vd0.a r18 = this.m;
        if (r18 == null) goto L51;
        r18.h(r16.intValue());
    L51:
        if (vm2.d.S0() == false) goto L67;
        IRoom r19 = this.z;
        if (r19 == null) goto L62;
        z5 r20 = r19.getLinkerDetail();
        if (r20 == null) goto L62;
        List r21 = r20.getFeatureList();
        if (r21 == null) goto L62;
        if (r21.contains(4L) != true) goto L62;
        boolean r22 = true;
    L63:
        if (r22 == false) goto L67;
        vd0.a r23 = this.m;
        if (r23 == null) goto L67;
        r23.d(true);
    L62:
        r22 = false;
    L67:
        vd0.a r24 = this.m;
        if (r24 == null) goto L70;
        r24.c();
    L70:
        Boolean r25 = (Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE);
        if (r25 == null) goto L73;
        boolean r26 = r25.booleanValue();
    L74:
        this.n = r26;
        int r27 = hashCode();
        StringBuilder r28 = new StringBuilder("isAnchor = ");
        r28.append(this.n);
        r28.append(", anchor=");
        IRoom r29 = this.z;
        if (r29 == null) goto L79;
        IBaseUser r30 = r29.getOwner();
        if (r30 == null) goto L79;
        String r31 = r30.getNickName();
    L80:
        r28.append(r31);
        r28.append(", preloadScene=");
        r28.append(this.y);
        r28.append(", ");
        r28.append(this);
        Cq("MultiLinkThemeBgUIWidget#initContext", r27, r28.toString());
        int r32 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        DataCenter r33 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter(r33, "dataCenter");
        Intrinsics.checkNotNullParameter(this, "service");
        r33.put("data_multi_link_theme_bg_service", this);
        ViewGroup r34 = ((Widget) this).containerView;
        if (r34 == null) goto L83;
        r34.setVisibility(0);
    L83:
        View r35 = ((Widget) this).contentView;
        if (r35 == null) goto L86;
        ViewGroup r36 = (ViewGroup) r35.findViewById(2131388552);
    L87:
        this.b = r36;
        View r37 = ((Widget) this).contentView;
        if (r37 == null) goto L90;
        ClipImageView r38 = (ClipImageView) r37.findViewById(2131388562);
    L91:
        this.c = r38;
        View r39 = ((Widget) this).contentView;
        if (r39 == null) goto L94;
        ClipImageView r40 = (ClipImageView) r39.findViewById(2131388547);
    L95:
        this.d = r40;
        View r41 = ((Widget) this).contentView;
        if (r41 == null) goto L98;
        VideoThemeView r42 = (VideoThemeView) r41.findViewById(2131388566);
    L99:
        this.e = r42;
        View r43 = ((Widget) this).contentView;
        if (r43 == null) goto L102;
        ImageView r44 = (ImageView) r43.findViewById(2131388554);
    L103:
        this.g = r44;
        View r45 = ((Widget) this).contentView;
        if (r45 == null) goto L106;
        View r46 = r45.findViewById(2131388558);
    L107:
        this.f = r46;
        View r47 = ((Widget) this).contentView;
        if (r47 == null) goto L110;
        HSImageView r48 = (HSImageView) r47.findViewById(2131388567);
    L111:
        this.h = r48;
        xq();
        zq();
        x00.c r49 = this.a;
        if (r49 == null) goto L126;
        r49.j(this, new com.bytedance.android.live.liveinteract.bgComponent.platform.b(this), 3);
        x00.c r50 = this.a;
        if (r50 == null) goto L117;
        r50.j(this, new com.bytedance.android.live.liveinteract.bgComponent.platform.c(this), 2);
    L117:
        x00.c r51 = this.a;
        if (r51 == null) goto L120;
        r51.j(this, new com.bytedance.android.live.liveinteract.bgComponent.platform.d(this), 1);
    L120:
        x00.c r52 = this.a;
        if (r52 == null) goto L123;
        r52.j(this, new e(this), 100);
    L123:
        x00.c r53 = this.a;
        if (r53 == null) goto L126;
        r53.j(this, new f(this), 5);
    L126:
        Cq("MultiLinkThemeBgUIWidget#preloadBackground", hashCode(), "isAnchor = " + this.n + ", preloadScene=" + this.y);
        if (this.n == false) goto L129;
    L320:
        ((Widget) this).dataCenter.observe("data_show_player", this);
        ((Widget) this).dataCenter.observe("data_link_state", this);
        if (this.n == false) goto L323;
        Aq();
    L323:
        runWithRoomVisible(new d(this));
        if (gh0.a.d() == false) goto L359;
        IRoom r54 = this.z;
        if (r54 != null) goto L328;
        return;
    L328:
        if (r54.isLiveTypeAudio() != true) goto L361;
        Integer r55 = this.A;
        if (r55 != null) goto L333;
    L334:
        Integer r56 = this.A;
        if (r56 != null) goto L338;
    L339:
        ViewGroup r57 = this.b;
        if (r57 == null) goto L364;
        l r58 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(((Widget) this).dataCenter);
        if (r58 == null) goto L346;
        ViewGroup r59 = r58.td();
        if (r59 == null) goto L346;
        FrameLayout r60 = (FrameLayout) r59.findViewById(2131388550);
    L347:
        if (r60 == null) goto L349;
        r60.removeAllViews();
    L349:
        ViewGroup r61 = UtilityKotlinExtentionsKt.p(r57);
        if (r61 == null) goto L352;
        r61.removeView(r57);
    L352:
        if (r60 == null) goto L365;
        r60.addView(r57, new FrameLayout.LayoutParams(-1, -1));
        return;
    L365:
        return;
    L346:
        r60 = null;
        goto L347
    L364:
        return;
    L338:
        if (r56.intValue() != 9) goto L339;
        return;
    L333:
        if (r55.intValue() != 0) goto L334;
        return;
    L361:
        return;
    L359:
        return;
    L129:
        if (this.y == null) goto L320;
        IRoom r62 = this.z;
        if (r62 != null) goto L134;
    L140:
        IRoom r63 = this.z;
        if (r63 != null) goto L143;
    L151:
        Lazy r65 = MultiLinkWRDSPreloadManager.i;
        RoomLinkMicSyncData r66 = IMultiLinkWRDSPreloadService.DefaultImpls.getRoomLinkMicSyncData$default(MultiLinkWRDSPreloadManager.a.a(), this.y, this.z, false, 4, null);
        if (r66 == null) goto L163;
        int r110 = hashCode();
        StringBuilder r111 = new StringBuilder("roomSyncData: scene=");
        LinkerBaseInfo r112 = r66.linkerBaseInfo;
        if (r112 == null) goto L156;
        Integer r113 = Integer.valueOf(r112.getScene());
    L157:
        r111.append(r113);
        r111.append(", uiLayout=");
        LinkerBaseInfo r67 = r66.linkerBaseInfo;
        if (r67 == null) goto L160;
        Integer r68 = Integer.valueOf(r67.getUiLayout());
    L161:
        r111.append(r68);
        Cq("MultiLinkThemeBgUIWidget#preloadBackground", r110, r111.toString());
        goto L163
    L160:
        r68 = null;
        goto L161
    L156:
        r113 = null;
    L163:
        if (this.x == true) goto L231;
        IRoom r69 = this.z;
        if (r69 == null) goto L206;
        Map r70 = r69.getLinkMap();
        if (r70 == null) goto L206;
        if ((!r70.isEmpty()) == true) goto L172;
        r70 = null;
    L172:
        if (r70 == null) goto L206;
        IRoom r114 = this.z;
        if (r114 != null) goto L176;
    L178:
        boolean r115 = false;
    L179:
        if (r115 == false) goto L192;
        boolean r116 = r70.containsKey(String.valueOf(5));
        com.bytedance.android.livesdk.chatroom.viewmodel.f.a.getClass();
        Iterator r117 = com.bytedance.android.livesdk.chatroom.viewmodel.f.a.a.iterator();
        int r118 = 0;
    L182:
        if (r117.hasNext() == false) goto L189;
        int r71 = ((Number) r117.next()).intValue();
        if (r71 == 5) goto L182;
        if (r70.containsKey(String.valueOf(r71)) == false) goto L182;
        r118 = r71;
        goto L182
    L189:
        if (r118 != 0) goto L199;
        if (r116 == false) goto L199;
        r118 = 5;
    L199:
        this.A = Integer.valueOf(r118);
        int r72 = hashCode();
        StringBuilder r73 = new StringBuilder("After getSceneFromLinkerMap roomInfo: scene = ");
        r73.append(this.A);
        r73.append(", uiLayout = $");
        IRoom r74 = this.z;
        if (r74 == null) goto L204;
        z5 r75 = r74.getLinkerDetail();
        if (r75 == null) goto L204;
        Integer r76 = Integer.valueOf(r75.getUiLayout());
    L205:
        r73.append(r76);
        Cq("MultiLinkThemeBgUIWidget#preloadBackground", r72, r73.toString());
    L204:
        r76 = null;
        goto L205
    L192:
        r118 = 16;
        if (r70.containsKey(String.valueOf(16)) == true) goto L199;
        r118 = 12;
        if (r70.containsKey(String.valueOf(12)) == true) goto L199;
        r118 = 8;
        goto L199
    L176:
        if (r114.isLiveTypeAudio() != true) goto L178;
        r115 = true;
    L206:
        IRoom r77 = this.z;
        if (r77 == null) goto L211;
        z5 r78 = r77.getLinkerDetail();
        if (r78 == null) goto L211;
        int r79 = r78.getUiLayout();
    L212:
        this.B = Integer.valueOf(r79);
        Lazy r80 = MultiLinkWRDSPreloadManager.i;
        RoomLinkMicSyncData r81 = IMultiLinkWRDSPreloadService.DefaultImpls.getRoomLinkMicSyncData$default(MultiLinkWRDSPreloadManager.a.a(), this.y, this.z, false, 4, null);
        if (r81 == null) goto L231;
        int r82 = hashCode();
        StringBuilder r83 = new StringBuilder("roomSyncData: scene=");
        LinkerBaseInfo r84 = r81.linkerBaseInfo;
        if (r84 == null) goto L217;
        Integer r85 = Integer.valueOf(r84.getScene());
    L218:
        r83.append(r85);
        r83.append(", uiLayout=");
        LinkerBaseInfo r86 = r81.linkerBaseInfo;
        if (r86 == null) goto L221;
        Integer r87 = Integer.valueOf(r86.getUiLayout());
    L222:
        r83.append(r87);
        Cq("MultiLinkThemeBgUIWidget#preloadBackground", r82, r83.toString());
        LinkerBaseInfo r88 = r81.linkerBaseInfo;
        if (r88 == null) goto L225;
        int r89 = r88.getScene();
    L226:
        this.A = Integer.valueOf(r89);
        LinkerBaseInfo r90 = r81.linkerBaseInfo;
        if (r90 == null) goto L229;
        int r91 = r90.getUiLayout();
    L230:
        this.B = Integer.valueOf(r91);
        goto L231
    L229:
        r91 = -1;
        goto L230
    L225:
        r89 = -1;
        goto L226
    L221:
        r87 = null;
        goto L222
    L217:
        r85 = null;
    L211:
        r79 = -1;
    L231:
        Cq("MultiLinkThemeBgUIWidget#preloadBackground", hashCode(), "preload final scene=" + this.A + ", final uiLayout=" + this.B);
        Integer r92 = this.A;
        if (r92 != null) goto L235;
    L246:
        int r93 = hashCode();
        StringBuilder r94 = new StringBuilder("preloadBackground :  preloadScene=");
        r94.append(this.y);
        r94.append(", scene=");
        r94.append(this.A);
        r94.append(", uiLayout=");
        r94.append(this.B);
        r94.append(", room=");
        IRoom r95 = this.z;
        if (r95 == null) goto L249;
        String r96 = r95.getTitle();
    L250:
        r94.append(r96);
        r94.append(", mLiveBgViewManagerService=");
        r94.append(this.m);
        Cq("MultiLinkThemeBgUIWidget#preloadBackground", r93, r94.toString());
        Integer r97 = this.B;
        if (r97 == null) goto L255;
        int r98 = r97.intValue();
        vd0.a r99 = this.m;
        if (r99 == null) goto L255;
        r99.h(r98);
    L255:
        Integer r100 = this.A;
        if (r100 == null) goto L260;
        int r101 = r100.intValue();
        vd0.a r102 = this.m;
        if (r102 == null) goto L260;
        r102.f(r101);
    L260:
        gc r103 = MultiLinkWRDSPreloadManager.a.a().getBgMsg(this.y, this.z);
        int r104 = hashCode();
        StringBuilder r105 = new StringBuilder("preloadBackground wrdsMsg theme = ");
        if (r103 == null) goto L263;
        IVoiceLiveTheme r106 = r103.getVoiceLiveTheme();
    L264:
        r105.append(r106);
        r105.append(", room theme = ");
        IRoom r107 = this.z;
        if (r107 == null) goto L267;
        IVoiceLiveTheme r108 = r107.getVoiceLiveTheme();
    L268:
        r105.append(r108);
        r105.append(", themeManager=");
        r105.append(this.a);
        Cq("MultiLinkThemeBgUIWidget#preloadBackground", r104, r105.toString());
        if (r103 == null) goto L271;
        IVoiceLiveTheme r109 = r103.getVoiceLiveTheme();
    L272:
        if (r103 == null) goto L277;
        if (r109 == null) goto L277;
        r109.setFromPush(true);
        x00.c r119 = this.a;
        if (r119 == null) goto L292;
        r119.c(r109, r103.getBgType());
    L292:
        IRoom r120 = this.z;
        if (r120 == null) goto L295;
        long r121 = r120.getRoomId();
        MultiLinkWRDSPreloadManager.a.a().addBgMsgBizListener(this.y, r121, this);
        MultiLinkWRDSPreloadManager.a.a().addRoomLinkMicSyncDataBizListener(this.y, r121, this);
    L295:
        int r122 = hashCode();
        StringBuilder r123 = new StringBuilder("micSeatDataService=");
        int r124 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        r123.append(com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter));
        r123.append(", windowListObservable=");
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r125 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter);
        if (r125 == null) goto L298;
        BehaviorSubject<List<tf0.e>> r126 = r125.el();
    L299:
        r123.append(r126);
        r123.append("}, micSeatDataService=");
        r123.append(com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter));
        Cq("MultiLinkThemeBgUIWidget#registerWindowListObservable", r122, r123.toString());
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r127 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter);
        if (r127 == null) goto L304;
        BehaviorSubject<List<tf0.e>> r128 = r127.el();
        if (r128 == null) goto L304;
        Disposable r129 = r128.subscribe(new g(this));
    L305:
        this.u = r129;
        Integer r130 = (Integer) ((Widget) this).dataCenter.get("data_hide_audio_bg", 0);
        if (r130 == null) goto L320;
        if (r130.intValue() <= 0) goto L310;
        boolean r131 = true;
    L311:
        if (r131 == true) goto L314;
        r130 = null;
    L314:
        if (r130 == null) goto L320;
        int r132 = r130.intValue();
        vd0.a r133 = this.m;
        if (r133 == null) goto L320;
        if (r132 != 2) goto L319;
        r4 = true;
    L319:
        r133.d(r4);
        goto L320
    L310:
        r131 = false;
    L304:
        r129 = null;
        goto L305
    L298:
        r126 = null;
    L277:
        IRoom r134 = this.z;
        if (r134 == null) goto L280;
        IVoiceLiveTheme r135 = r134.getVoiceLiveTheme();
    L281:
        if (r135 == null) goto L285;
        r135.setFromPush(false);
        x00.c r136 = this.a;
        if (r136 == null) goto L292;
        r136.c(r135, r135.getBgType());
        goto L292
    L285:
        q r137 = this.j;
        if (r137 == null) goto L288;
        IVoiceLiveTheme r138 = r137.b();
    L289:
        this.k = r138;
        q r139 = this.j;
        if (r139 == null) goto L292;
        r139.c(r138);
        goto L292
    L288:
        r138 = null;
        goto L289
    L280:
        r135 = null;
        goto L281
    L271:
        r109 = null;
        goto L272
    L267:
        r108 = null;
        goto L268
    L263:
        r106 = null;
        goto L264
    L249:
        r96 = null;
        goto L250
    L235:
        if (r92.intValue() != 5) goto L246;
        Integer r140 = this.B;
        if (r140 == null) goto L246;
        if (r140.intValue() != 29) goto L246;
        IRoom r141 = this.z;
        if (r141 == null) goto L246;
        IVoiceLiveTheme r142 = r141.getVoiceLiveTheme();
        if (r142 == null) goto L246;
        r142.setBgType(5);
        goto L246
    L143:
        if (r63.getLinkMap() == null) goto L151;
        int r143 = hashCode();
        StringBuilder r144 = new StringBuilder("roomInfo: scene = ");
        r144.append(this.A);
        r144.append(", uiLayout = $");
        IRoom r145 = this.z;
        if (r145 == null) goto L149;
        z5 r146 = r145.getLinkerDetail();
        if (r146 == null) goto L149;
        Integer r147 = Integer.valueOf(r146.getUiLayout());
    L150:
        r144.append(r147);
        Cq("MultiLinkThemeBgUIWidget#preloadBackground", r143, r144.toString());
    L149:
        r147 = null;
        goto L150
    L134:
        if (r62.getVoiceLiveTheme() == null) goto L140;
        IVoiceLiveTheme r148 = this.z.getVoiceLiveTheme();
        Intrinsics.checkNotNull(r148);
        if (r148.isRealTimeChorusTheme() == false) goto L140;
        if (vm2.c.k() == false) goto L140;
        IVoiceLiveTheme r149 = this.z.getVoiceLiveTheme();
        Intrinsics.checkNotNull(r149);
        r149.setBgType(100);
        goto L140
    L110:
        r48 = null;
        goto L111
    L106:
        r46 = null;
        goto L107
    L102:
        r44 = null;
        goto L103
    L98:
        r42 = null;
        goto L99
    L94:
        r40 = null;
        goto L95
    L90:
        r38 = null;
        goto L91
    L86:
        r36 = null;
    L79:
        r31 = null;
        goto L80
    L73:
        r26 = false;
        goto L74
    L18:
        if (r5.intValue() == (-1)) goto L20;
        boolean r150 = true;
    L21:
        if (r150 == true) goto L24;
        r5 = null;
    L24:
        if (r5 == null) goto L28;
        int r151 = r5.intValue();
        vd0.a r152 = this.m;
        if (r152 == null) goto L28;
        r152.h(r151);
        goto L28
    L20:
        r150 = false;
        goto L21
    L5:
        if (r3.intValue() == (-1)) goto L7;
        boolean r153 = true;
    L8:
        if (r153 == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L15;
        int r154 = r3.intValue();
        vd0.a r155 = this.m;
        if (r155 == null) goto L15;
        r155.f(r154);
        goto L15
    L7:
        r153 = false;
        goto L8
    }

    public final int wq() {
        IRoom r0 = this.z;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L48:
        Integer r2 = this.A;
        if (r2 != null) goto L52;
        return 3;
    L52:
        if (r2.intValue() != 0) goto L54;
        return 0;
    L54:
        return 3;
    L5:
        if (r0.isLiveTypeAudio() != true) goto L48;
        Integer r3 = this.A;
        if (r3 != null) goto L10;
    L18:
        if (r3 != null) goto L21;
    L37:
        if (r3 != null) goto L40;
    L42:
        if (r3 != null) goto L45;
    L47:
        return 2;
    L45:
        if (r3.intValue() != 0) goto L47;
        return 5;
    L40:
        if (r3.intValue() != 16) goto L42;
        return 2;
    L21:
        if (r3.intValue() != 9) goto L37;
        Integer r4 = this.A;
        if (r4 != null) goto L26;
    L33:
        if (r1 == false) goto L36;
        return 100;
    L36:
        return 1;
    L26:
        if (r4.intValue() != 9) goto L33;
        Integer r5 = this.B;
        if (r5 == null) goto L33;
        if (r5.intValue() != 61) goto L33;
        r1 = true;
        goto L33
    L10:
        if (r3.intValue() != 5) goto L18;
        Integer r6 = this.B;
        if (r6 != null) goto L15;
    L17:
        return 2;
    L15:
        if (r6.intValue() != 29) goto L17;
        return 5;
    }

    public final void xq() {
        int r0 = com.bytedance.android.live.liveinteract.bgComponent.theme.util.b.a;
        boolean r2 = com.bytedance.android.live.ktv.common.util.j.i();
        boolean r1 = this.x;
        IRoom r3 = this.z;
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        Integer r5 = this.A;
        ClipImageView r6 = this.c;
        ClipImageView r7 = this.d;
        VideoThemeView r8 = this.e;
        HSImageView r9 = this.h;
        ImageView r10 = this.g;
        if (r4 == false) goto L20;
        if (r5 != null) goto L13;
    L17:
        if (r1 == false) goto L19;
        com.bytedance.android.live.ui.c r11 = new d0(r2, r6, r7, r8, this, 48);
    L23:
        this.i = r11;
        IRoom r12 = this.z;
        if (r12 != null) goto L26;
    L28:
        q.a r13 = new com.bytedance.android.live.liveinteract.videotalk.ui.theme.b.a();
    L29:
        q.a.c(r13, r11);
        AudioLiveThemeReporter r14 = (AudioLiveThemeReporter) this.l.getValue();
        Intrinsics.checkNotNullParameter(r14, "callback");
        r13.c = r14;
        this.j = r13.a();
        com.bytedance.android.livesdk.a r15 = this.w;
        Function2<Integer, Boolean, Unit> r16 = new MultiLinkThemeBgUIWidget$initBackground$2(this);
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "cb");
        r15.a = r16;
        IService r17 = k.f(IInteractService.class);
        Intrinsics.checkNotNull(r17);
        ((IInteractService) r17).addBusinessDegradeStrategy(this.w);
        return;
    L26:
        if (r12.isLiveTypeAudio() != true) goto L28;
        r13 = new q.a();
        goto L29
    L19:
        r11 = new com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.a(r2, r6, r7, r8, r9, r10, this);
        goto L23
    L13:
        if (r5.intValue() != 0) goto L17;
        if (r1 == false) goto L16;
        r11 = new com.bytedance.android.live.liveinteract.feed.a(r2, r6, r7, r8, this);
        goto L23
    L16:
        r11 = new com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.a(r2, r6, r7, r8, r9, r10, this);
        goto L23
    L20:
        if (r1 == false) goto L22;
        r11 = new d0(r2, r6, r7, null, this, 56);
        goto L23
    L22:
        r11 = new com.bytedance.android.live.liveinteract.videotalk.ui.theme.a(r2, r6, r7, this);
        goto L23
    L5:
        if (r3.isLiveTypeAudio() != true) goto L7;
        r4 = true;
        goto L8
    }

    public final void yq() {
        m r0 = this.p;
        if (r0 != null) goto L5;
        return;
    L5:
        Integer r1 = this.s;
        Integer r2 = this.t;
        int r3 = ((Widget) this).containerView.getWidth();
        int r4 = ((Widget) this).containerView.getHeight();
        if (r2 != null) goto L8;
    L10:
        if (r1 != null) goto L12;
    L14:
        int r5 = ug0.b.a;
        int r6 = r0.m();
        int r7 = r0.getUiLayout();
        int r8 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.i.a;
        hs0.a r9 = hs0.a.b;
        View r10 = r9.getCurrentLivePlayerParent();
        Integer r11 = null;
        if (r10 == null) goto L24;
        Integer r12 = Integer.valueOf(r10.getWidth());
        if (r12.intValue() <= 0) goto L19;
        boolean r13 = true;
    L20:
        if (r13 == true) goto L23;
        r12 = null;
    L23:
        if (r12 == null) goto L24;
    L31:
        if (r12 == null) goto L33;
        int r14 = r12.intValue();
    L34:
        View r15 = r9.getCurrentLivePlayerParent();
        if (r15 == null) goto L46;
        Integer r16 = Integer.valueOf(r15.getHeight());
        if (r16.intValue() <= 0) goto L39;
        boolean r17 = true;
    L40:
        if (r17 == true) goto L43;
        r16 = null;
    L43:
        if (r16 == null) goto L46;
        r11 = r16;
    L52:
        if (r11 == null) goto L54;
        int r18 = r11.intValue();
    L55:
        Pair r19 = ug0.b.b(r6, r7, r14, r18);
        IRoom r20 = this.z;
        if (r20 != null) goto L58;
    L60:
        int r21 = ((Number) r19.getFirst()).intValue();
        int r22 = ((Number) r19.getSecond()).intValue();
        float r23 = r0.q(r22);
        float r110 = r0.s(r21, r22);
        boolean r111 = gh0.b.a;
        gh0.b.a("ScreenAdjust", "createImageViewStrategy, containerWidth = " + r21 + ", containerHeight = " + r22 + ", sx = 0.0, sy = " + r23 + ", windowWidth = " + r21 + ", windowHeight = " + r110, false);
        this.r = com.bytedance.android.live.liveinteract.videotalk.utils.d.a(r21, r22, r0);
        return;
    L58:
        if (r20.isLiveTypeAudio() != true) goto L60;
        int r24 = ((Number) r19.getFirst()).intValue();
        int r25 = ((Number) r19.getSecond()).intValue();
        float r26 = r0.q(r25);
        float r112 = r0.s(r24, r25);
        boolean r113 = gh0.b.a;
        gh0.b.a("ScreenAdjust", "createImageViewStrategy, containerWidth = " + r24 + ", containerHeight = " + r25 + ", sx = 0.0, sy = " + r26 + ", windowWidth = " + r24 + ", windowHeight = " + r112, false);
        this.r = com.bytedance.android.live.liveinteract.videotalk.utils.d.a(r24, r25, r0);
        return;
    L54:
        r18 = s1.w();
        goto L55
    L39:
        r17 = false;
    L46:
        Integer r27 = Integer.valueOf(r4);
        if (r27.intValue() <= 0) goto L49;
        boolean r28 = true;
    L50:
        if (r28 == false) goto L52;
        r11 = r27;
        goto L52
    L49:
        r28 = false;
        goto L50
    L33:
        r14 = s1.y();
        goto L34
    L19:
        r13 = false;
    L24:
        r12 = Integer.valueOf(r3);
        if (r12.intValue() <= 0) goto L27;
        boolean r29 = true;
    L28:
        if (r29 == true) goto L31;
        r12 = null;
        goto L31
    L27:
        r29 = false;
        goto L28
    L12:
        if (r1.intValue() <= 0) goto L14;
        r3 = r1.intValue();
        goto L14
    L8:
        if (r2.intValue() <= 0) goto L10;
        r4 = r2.intValue();
        goto L10
    }

    public final void zq() {
        x00.c r0 = (x00.c) ((Widget) this).dataCenter.get("data_multi_link_theme_manager", null);
        this.a = r0;
        if (r0 == null) goto L5;
        return;
    L5:
        if (this.n == false) goto L7;
        x00.c r1 = new com.bytedance.android.live.liveinteract.bgComponent.theme.j();
    L8:
        this.a = r1;
        ((Widget) this).dataCenter.put("data_multi_link_theme_manager", r1);
        return;
    L7:
        r1 = new com.bytedance.android.live.liveinteract.bgComponent.theme.a();
        goto L8
    }

    public final void Aq() {
        com.bytedance.live.datacontext.j r0 = o3.d().getVideoTalkRoomSubScene();
        com.bytedance.live.datacontext.j r1 = o3.d().s();
        int r2 = hashCode();
        StringBuilder r3 = new StringBuilder("room=");
        IRoom r4 = this.z;
        Boolean r5 = null;
        if (r4 == null) goto L5;
        String r6 = r4.getTitle();
    L6:
        r3.append(r6);
        r3.append(" isLiveTypeAudio=");
        IRoom r7 = this.z;
        if (r7 == null) goto L9;
        r5 = Boolean.valueOf(r7.isLiveTypeAudio());
    L9:
        r3.append(r5);
        Cq("MultiLinkThemeBgUIWidget#observeSceneUILayoutChange", r2, r3.toString());
        IRoom r8 = this.z;
        if (r8 != null) goto L12;
    L21:
        if (r0 == null) goto L35;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r9 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r9 == null) goto L36;
        BehaviorSubject r10 = r9.a();
        if (r10 == null) goto L37;
        Disposable r11 = r10.subscribe(new c(this));
        if (r11 == null) goto L38;
        this.o.add(r11);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L12:
        if (r8.isLiveTypeAudio() != true) goto L21;
        if (r1 == null) goto L30;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r12 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.getValue();
        if (r12 == null) goto L31;
        BehaviorSubject r13 = r12.a();
        if (r13 == null) goto L32;
        Disposable r14 = r13.subscribe(new b(this));
        if (r14 == null) goto L33;
        this.o.add(r14);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void Eq() {
        int r0 = hashCode();
        StringBuilder r1 = new StringBuilder("updateClipPath, uiLayout=");
        m r2 = this.p;
        Integer r3 = null;
        if (r2 == null) goto L5;
        Integer r4 = Integer.valueOf(r2.getUiLayout());
    L6:
        r1.append(r4);
        r1.append(", windowListSize=");
        List<? extends tf0.e> r5 = this.q;
        if (r5 == null) goto L9;
        r3 = Integer.valueOf(r5.size());
    L9:
        r1.append(r3);
        Cq("MultiLinkThemeBgUIWidget#updateClipPath", r0, r1.toString());
        m r6 = this.p;
        if (r6 != null) goto L12;
        return;
    L12:
        List<? extends tf0.e> r7 = this.q;
        if (r7 != null) goto L15;
        return;
    L15:
        int r8 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.i.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.i.a(r6, r7, this.r, this.i, false, MultiLinkThemeBgUIWidget$updateClipPath$1.INSTANCE);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        int r0 = hashCode();
        StringBuilder r1 = new StringBuilder("onDestroy, roomId = ");
        IRoom r2 = this.z;
        if (r2 == null) goto L5;
        Long r3 = Long.valueOf(r2.getRoomId());
    L6:
        r1.append(r3);
        r1.append(", preloadScene = ");
        r1.append(this.y);
        Cq("MultiLinkThemeBgUIWidget#onDestroy", r0, r1.toString());
        IRoom r4 = this.z;
        if (r4 == null) goto L9;
        Long r5 = Long.valueOf(r4.getRoomId());
    L10:
        String r6 = this.y;
        if (r5 == null) goto L14;
        if (r6 == null) goto L14;
        long r7 = r5.longValue();
        Lazy r8 = MultiLinkWRDSPreloadManager.i;
        MultiLinkWRDSPreloadManager.a.a().removeBgMsgBizListener(r6, r7, this);
        MultiLinkWRDSPreloadManager.a.a().removeRoomLinkMicSyncDataBizListener(r6, r7, this);
    L14:
        Disposable r9 = this.u;
        if (r9 != null) goto L17;
    L21:
        this.o.dispose();
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L24;
        r10.removeObserver(this);
    L24:
        int r11 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        DataCenter r12 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter(r12, "dataCenter");
        r12.put("data_multi_link_theme_bg_service", null);
        this.v = false;
        return;
    L17:
        if (r9.isDisposed() == true) goto L21;
        Disposable r13 = this.u;
        if (r13 == null) goto L21;
        r13.dispose();
        goto L21
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.platform.a
    public final void oq() {
        int r0 = hashCode();
        StringBuilder r1 = new StringBuilder("onMultiLinkWidgetScopeEnter,  room=");
        IRoom r2 = this.z;
        if (r2 == null) goto L5;
        String r3 = r2.getTitle();
    L6:
        r1.append(r3);
        Cq("MultiLinkThemeBgUIWidget#onMultiLinkWidgetScopeEnter", r0, r1.toString());
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.platform.a
    public final ViewGroup Pn() {
        return this.b;
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.platform.a
    public final View c() {
        return this.f;
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.platform.a
    public final com.bytedance.android.live.ui.c kb() {
        return this.i;
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.platform.a
    public final void Aj(int r4) {
        Integer r0 = this.B;
        if (r0 != null) goto L6;
    L7:
        Cq("MultiLinkThemeBgUIWidget#updateUILayout", hashCode(), "updateUILayout, uiLayout = " + r4 + ", this.uiLayout = " + this.B);
        this.B = Integer.valueOf(r4);
        xq();
        vd0.a r1 = this.m;
        if (r1 == null) goto L10;
        r1.h(r4);
    L10:
        x00.c r5 = this.a;
        if (r5 == null) goto L17;
        IVoiceLiveTheme r6 = r5.q(wq());
        if (r6 == null) goto L18;
        Bq(r6, wq());
        return;
    L18:
        return;
    L17:
        return;
    L6:
        if (r0.intValue() != r4) goto L7;
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.platform.a
    public final void Bo(boolean r4) {
        Cq("MultiLinkThemeBgUIWidget#onAIMVPlayChanged", hashCode(), "onAIMVPlayChanged, isPlaying=" + r4);
        this.v = r4;
        if (r4 == false) goto L14;
        com.bytedance.android.live.ui.c r5 = this.i;
        if (r5 == null) goto L7;
        r5.k();
    L7:
        IVoiceLiveTheme r6 = this.k;
        if (r6 != null) goto L10;
    L20:
        vd0.a r7 = this.m;
        if (r7 == null) goto L24;
        r7.c();
        return;
    L24:
        return;
    L10:
        if (r6.getImageType() != 3) goto L20;
        com.bytedance.android.live.ui.c r8 = this.i;
        if (r8 == null) goto L20;
        r8.a(com.bytedance.android.live.liveinteract.aimv.b.a());
        goto L20
    L14:
        com.bytedance.android.live.ui.c r9 = this.i;
        if (r9 == null) goto L17;
        r9.a(null);
    L17:
        com.bytedance.android.live.ui.c r10 = this.i;
        if (r10 == null) goto L20;
        r10.n();
        goto L20
    }

    public final void Ek(IVoiceLiveTheme r3) {
        Intrinsics.checkNotNullParameter(r3, "theme");
        Cq("MultiLinkThemeBgUIWidget#onStart", hashCode(), "on start load");
    }

    public final void Fq(int r4) {
        Integer r0 = this.A;
        if (r0 != null) goto L6;
    L7:
        Cq("MultiLinkThemeBgUIWidget#updateScene", hashCode(), "updateScene, scene = " + r4 + ", this.scene = " + this.A);
        this.A = Integer.valueOf(r4);
        xq();
        vd0.a r1 = this.m;
        if (r1 == null) goto L10;
        r1.f(r4);
    L10:
        x00.c r2 = this.a;
        if (r2 == null) goto L15;
        IVoiceLiveTheme r3 = r2.q(wq());
        if (r3 == null) goto L15;
        Bq(r3, wq());
    L15:
        if (r4 != 0) goto L17;
    L18:
        ViewGroup r5 = this.b;
        if (r5 == null) goto L21;
        ViewGroup r6 = UtilityKotlinExtentionsKt.p(r5);
    L23:
        if ((!Intrinsics.areEqual(((Widget) this).containerView, r6)) == false) goto L34;
        ViewGroup r7 = this.b;
        if (r7 == null) goto L35;
        if (r6 == null) goto L28;
        r6.removeView(r7);
    L28:
        ViewGroup r8 = ((Widget) this).containerView;
        if (r8 == null) goto L36;
        r8.addView(this.b);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L21:
        r6 = null;
        goto L23
    L17:
        if (r4 == 9) goto L18;
        return;
    L6:
        if (r0.intValue() != r4) goto L7;
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.platform.a
    public final void Xe(List<? extends tf0.e> r4) {
        Intrinsics.checkNotNullParameter(r4, "windowList");
        this.q = r4;
        Cq("MultiLinkThemeBgUIWidget#updateWindowList", hashCode(), "updateWindowList, windowList=" + r4.size());
        yq();
        Eq();
        vd0.a r0 = this.m;
        if (r0 == null) goto L6;
        wd0.b r1 = r0.c;
        r1.i = r4;
        r0.d.a(r1, r0.a, r0.b);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.platform.a
    public final void fo(boolean r2) {
        vd0.a r0 = this.m;
        if (r0 == null) goto L6;
        r0.g(r2);
        return;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (isViewValid() == false) goto L23;
        if (r4 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4.getKey()) == false) goto L8;
        return;
    L8:
        if (r4.getData() == null) goto L31;
        String r0 = r4.getKey();
        if (Intrinsics.areEqual(r0, "data_show_player") == false) goto L18;
        Boolean r5 = (Boolean) r4.getData();
        if (r5 == null) goto L26;
        vd0.a r1 = this.m;
        if (r1 == null) goto L27;
        r1.g(r5.booleanValue());
        return;
    L27:
        return;
    L26:
        return;
    L18:
        if (Intrinsics.areEqual(r0, "data_link_state") == false) goto L29;
        vd0.a r6 = this.m;
        if (r6 == null) goto L30;
        r6.c();
        return;
    L30:
        return;
    L29:
        return;
    L31:
        return;
    }

    public final void receiveMsg(o0 r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        if ((r5 instanceof in) == false) goto L8;
        int r0 = hashCode();
        StringBuilder r1 = new StringBuilder("receiveMsg, msg = (bg_type=");
        in r6 = (in) r5;
        r1.append(r6.getBgType());
        r1.append(", msg_id=");
        r1.append(r6.getMessageId());
        r1.append(')');
        Cq("MultiLinkThemeBgUIWidget#receiveMsg", r0, r1.toString());
        x00.c r2 = this.a;
        if (r2 == null) goto L9;
        r2.c(r6.voiceLiveTheme, r6.getBgType());
        return;
    L9:
        return;
    }

    public final void receiveWrds(RoomLinkMicSyncData r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        int r0 = hashCode();
        StringBuilder r1 = new StringBuilder("receiveWrds, scene=");
        LinkerBaseInfo r2 = r5.linkerBaseInfo;
        Integer r3 = null;
        if (r2 == null) goto L5;
        Integer r4 = Integer.valueOf(r2.getScene());
    L6:
        r1.append(r4);
        r1.append(", uiLayout=");
        LinkerBaseInfo r6 = r5.linkerBaseInfo;
        if (r6 == null) goto L9;
        r3 = Integer.valueOf(r6.getUiLayout());
    L9:
        r1.append(r3);
        Cq("MultiLinkThemeBgUIWidget#receiveWrds", r0, r1.toString());
        LinkerBaseInfo r7 = r5.linkerBaseInfo;
        if (r7 == null) goto L12;
        Fq(r7.getScene());
    L12:
        LinkerBaseInfo r8 = r5.linkerBaseInfo;
        if (r8 == null) goto L16;
        Aj(r8.getUiLayout());
        return;
    L16:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void Bq(IVoiceLiveTheme r11, int r12) {
        int r0 = hashCode();
        StringBuilder r1 = new StringBuilder("onCurrentThemeChanged, theme = ");
        r1.append(r11);
        r1.append(", bgType=");
        r1.append(r12);
        r1.append(", currentThemeType=");
        r1.append(wq());
        r1.append(", scene=");
        r1.append(this.A);
        r1.append(", uiLayout=");
        r1.append(this.B);
        r1.append(", theme.id=");
        if (r11 == null) goto L5;
        Long r3 = Long.valueOf(r11.getId());
    L6:
        r1.append(r3);
        r1.append(", this.currentThemeId=");
        IVoiceLiveTheme r4 = this.k;
        if (r4 == null) goto L9;
        Long r5 = Long.valueOf(r4.getId());
    L10:
        r1.append(r5);
        Cq("MultiLinkThemeBgUIWidget#onCurrentThemeChanged", r0, r1.toString());
        if (r11 != null) goto L14;
        return;
    L14:
        if (r12 == wq()) goto L16;
        return;
    L16:
        IVoiceLiveTheme r2 = this.k;
        if (r2 != null) goto L19;
    L25:
        com.bytedance.android.live.ui.c r6 = this.i;
        VideoThemeView r7 = this.e;
        if (r12 != 5) goto L28;
        boolean r8 = true;
    L29:
        if (r8 == true) goto L31;
    L46:
        if (r12 == 1) goto L51;
        q r13 = this.j;
        if (r13 == null) goto L50;
        r13.a(r11);
    L50:
        int r14 = vd0.a.g;
        vd0.a r15 = vd0.a.C0284a.a(((Widget) this).dataCenter);
        wd0.b r9 = r15.c;
        r9.f = r11;
        r15.d.a(r9, r15.a, r15.b);
    L57:
        this.k = r11;
        Bo(this.v);
        return;
    L51:
        IVoiceLiveTheme r16 = this.k;
        if (r16 == null) goto L54;
        r16.setChangeByAnchor(true);
    L54:
        q r17 = this.j;
        if (r17 == null) goto L57;
        r17.d(this.k);
        goto L57
    L31:
        if ((r6 instanceof com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.a) == false) goto L46;
        if (this.f == null) goto L46;
        if (r7 == null) goto L46;
        ViewGroup r10 = (ViewGroup) ((Widget) this).contentView.findViewById(2131364143);
        if (r10 == null) goto L46;
        int r18 = r10.indexOfChild(r7);
        if (r18 == (-1)) goto L46;
        r10.removeView(r7);
        r7.c();
        VideoThemeView r19 = new VideoThemeView(r10.getContext(), null, 6, 0);
        r19.setId(2131388566);
        r19.setLayoutParams(r7.getLayoutParams());
        r19.setVisibility(r7.getVisibility());
        r10.addView(r19, r18);
        com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.a r20 = (com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.a) r6;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r19, "newVideoThemeView");
        o r21 = ((com.bytedance.android.live.ui.c) r20).q;
        if (r21 == null) goto L42;
        r21.c();
    L42:
        o r22 = ((com.bytedance.android.live.ui.c) r20).q;
        if (r22 == null) goto L45;
        r22.hide();
    L45:
        ((com.bytedance.android.live.ui.c) r20).q = r19;
        this.e = r19;
        goto L46
    L28:
        r8 = false;
        goto L29
    L19:
        if (r2.getId() != r11.getId()) goto L25;
        IVoiceLiveTheme r23 = this.k;
        if (r23 != null) goto L23;
        return;
    L23:
        if (r23.getId() == 0) goto L25;
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void W9(boolean r1, IVoiceLiveTheme r2) {
        Intrinsics.checkNotNullParameter(r2, "theme");
        lb();
    }

    public final void Cq(String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "subTag");
        Intrinsics.checkNotNullParameter(r5, "content");
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.p(((Widget) this).dataCenter, r3 + '#' + r4, r5);
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.platform.a
    public final void Hp(m r5, int r6, int r7) {
        int r0 = hashCode();
        StringBuilder r1 = new StringBuilder("updateLayoutConfig, anchor=");
        IRoom r2 = this.z;
        Integer r3 = null;
        if (r2 == null) goto L7;
        IBaseUser r4 = r2.getOwner();
        if (r4 == null) goto L7;
        String r8 = r4.getNickName();
    L8:
        r1.append(r8);
        r1.append(", uiLayout=");
        if (r5 == null) goto L11;
        r3 = Integer.valueOf(r5.getUiLayout());
    L11:
        r1.append(r3);
        r1.append("， width=");
        r1.append(r6);
        r1.append(", height=");
        r1.append(r7);
        Cq("MultiLinkThemeBgUIWidget#updateLayoutConfig", r0, r1.toString());
        this.p = r5;
        this.s = Integer.valueOf(r6);
        this.t = Integer.valueOf(r7);
        yq();
        Eq();
        if (r5 == null) goto L14;
        Fq(r5.j());
    L14:
        if (r5 == null) goto L17;
        Aj(r5.getUiLayout());
        return;
    L17:
        return;
    L7:
        r8 = null;
        goto L8
    }

    public MultiLinkThemeBgUIWidget(boolean r1, String r2, IRoom r3, Integer r4, Integer r5, IMultiScenePreviewStatistics r6) {
        this.x = r1;
        this.y = r2;
        this.z = r3;
        this.A = r4;
        this.B = r5;
        this.C = r6;
        this.l = LazyKt.lazy(MultiLinkThemeBgUIWidget$mReporter$2.INSTANCE);
        this.o = new CompositeDisposable();
        this.w = new com.bytedance.android.livesdk.a(new y0.a(0));
    }
}

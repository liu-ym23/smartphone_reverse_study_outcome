package com.bytedance.android.live.liveinteract.plantform.commonwindow.audio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.s2;
import com.bytedance.android.live.core.setting.y2;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.customizestream.CustomizeStreamContext;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder.MultiLinkPreOnlineViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.LiveTypeForMultiLink;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAnimViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserVirtualAvatarViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkDummyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkDynamicIslandViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkLastEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkRadioMainViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.b;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.d;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.voicechat.radio.context.RadioStageContext;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import fd2.v;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import jk0.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;
import pn0.f;
import tf0.e;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\rj\b\u0012\u0004\u0012\u00020\u000b`\u000eH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0016R\u001b\u0010\u0015\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R$\u0010 \u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/audio/VoiceCommonLinkSeatWindowView;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;", "", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkAudioFirstUserVirtualAvatarViewBinder$b;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/audio/viewbinder/MultiLinkPreOnlineViewBinder$b;", "", "getLayoutId", "Landroid/widget/FrameLayout;", "getInteractiveSongMvBg", "", "getNitaTag", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;", "getCurrentLayoutConfig", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/bytedance/revenue/platform/api/core/rx/BehaviorSubject;", "getLayoutConfigObservable", "getLinkSeatWindowView", "C", "Lkotlin/Lazy;", "getAnchorSurfaceViewContainer", "()Landroid/widget/FrameLayout;", "anchorSurfaceViewContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "D", "getLyricsContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "lyricsContainer", "I", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getSingleSurfaceViewContainer", "setSingleSurfaceViewContainer", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "singleSurfaceViewContainer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VoiceCommonLinkSeatWindowView extends BaseLinkSeatWindowView implements MultiLinkGuestViewBinder.b, MultiLinkAudioFirstUserVirtualAvatarViewBinder.b, MultiLinkPreOnlineViewBinder.b {
    public final Lazy C;
    public final Lazy D;
    public String E;
    public boolean F;
    public final CompositeDisposable G;
    public Integer H;
    public ConstraintLayout I;

    public VoiceCommonLinkSeatWindowView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VoiceCommonLinkSeatWindowView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final FrameLayout getAnchorSurfaceViewContainer() {
        return (FrameLayout) this.C.getValue();
    }

    private final ConstraintLayout getLyricsContainer() {
        return (ConstraintLayout) this.D.getValue();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView
    public int getLayoutId() {
        return 2131566838;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public BaseLinkSeatWindowView getLinkSeatWindowView() {
        return this;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void T8() {
        this.E = "";
        if (Gi() == false) goto L8;
        getAnchorSurfaceViewContainer().removeAllViews();
        c r0 = RadioStageContext.Companion.a();
        if (r0 == null) goto L9;
        r0.yk(null);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView
    public BehaviorSubject<m> getLayoutConfigObservable() {
        return BehaviorSubject.createDefault(new m());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView
    public String getNitaTag() {
        return VerticalNitaInflate.Tag.MultiLinkVoiceCommonWindowView.name();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void jf() {
        if (this.H != null) goto L5;
        return;
    L5:
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L10;
        n<v> r1 = r0.getLyricsRecognizer();
        if (r1 == null) goto L10;
        v r2 = (v) r1.getValue();
    L11:
        ConstraintLayout r3 = getLyricsContainer();
        if (r3 == null) goto L15;
        if (r2 == null) goto L15;
        r2.f(r3);
    L15:
        ConstraintLayout r4 = getLyricsContainer();
        if (r4 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r4);
    L18:
        this.G.dispose();
        this.H = null;
        return;
    L10:
        r2 = null;
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final boolean Gi() {
        if (getAnchorSurfaceViewContainer().getChildCount() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserVirtualAvatarViewBinder.b
    public final void S4() {
        vg0.a r0 = getItemListener();
        if (r0 == null) goto L6;
        r0.S4();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public m getCurrentLayoutConfig() {
        return getLayoutConfig();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView
    public FrameLayout getInteractiveSongMvBg() {
        return (FrameLayout) findViewById(2131375554);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public ConstraintLayout getSingleSurfaceViewContainer() {
        return this.I;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView
    public final void U5(MultiTypeAdapter r6) {
        Intrinsics.checkNotNullParameter(r6, "adapter");
        if (getLayoutConfig().getUiLayout() == 29) goto L19;
        IRoom r0 = getMRoom();
        if (r0 == null) goto L9;
        IRoomBasisData r1 = r0.getBasisRoomData();
        if (r1 == null) goto L9;
        Boolean r2 = r1.isCustomizeAudioRoom();
    L11:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L16;
        if (getLayoutConfig().getUiLayout() == 25) goto L19;
    L16:
        if (getLayoutConfig().getUiLayout() != 24) goto L18;
        r6.z2(e.class, new MultiLinkDynamicIslandViewBinder(LiveTypeForMultiLink.Audio, getMDataCenter(), getLinkSeatAbilityProvider()));
        return;
    L18:
        r6.z2(MultiLinkAudioFirstUserVirtualAvatarViewBinder.a.class, new MultiLinkAudioFirstUserVirtualAvatarViewBinder(getLinkSeatAbilityProvider()));
        r6.z2(MultiLinkAudioFirstUserViewBinder.a.class, new MultiLinkAudioFirstUserViewBinder(getLinkSeatAbilityProvider()));
        LiveTypeForMultiLink r3 = LiveTypeForMultiLink.Audio;
        r6.z2(MultiLinkGuestViewBinder.a.class, new MultiLinkGuestViewBinder(r3, getLinkSeatAbilityProvider()));
        r6.z2(MultiLinkPreOnlineViewBinder.a.class, new MultiLinkPreOnlineViewBinder(getLinkSeatAbilityProvider()));
        r6.z2(MultiLinkNormalEmptyViewBinder.a.class, new MultiLinkNormalEmptyViewBinder(r3, getLinkSeatAbilityProvider()));
        r6.z2(b.a.class, new b(r3, getLinkSeatAbilityProvider()));
        r6.z2(com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.c.a.class, new com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.c(r3, getLinkSeatAbilityProvider()));
        r6.z2(MultiLinkSpecialViewBinder.a.class, new MultiLinkSpecialViewBinder(r3, getLinkSeatAbilityProvider()));
        return;
    L9:
        r2 = null;
    L19:
        LiveTypeForMultiLink r4 = LiveTypeForMultiLink.Video;
        r6.z2(MultiLinkSpecialViewBinder.a.class, new MultiLinkSpecialViewBinder(r4, getLinkSeatAbilityProvider()));
        r6.z2(MultiLinkNormalEmptyViewBinder.a.class, new MultiLinkNormalEmptyViewBinder(r4, getLinkSeatAbilityProvider()));
        r6.z2(MultiLinkGuestViewBinder.a.class, new MultiLinkGuestViewBinder(r4, getLinkSeatAbilityProvider()));
        r6.z2(MultiLinkLastEmptyViewBinder.a.class, new MultiLinkLastEmptyViewBinder(getLinkSeatAbilityProvider()));
        if (getLayoutConfig().getUiLayout() != 29) goto L22;
        r6.z2(MultiLinkFirstUserViewBinder.a.class, new MultiLinkRadioMainViewBinder(getLinkSeatAbilityProvider()));
        return;
    L22:
        r6.z2(MultiLinkFirstUserViewBinder.a.class, new MultiLinkFirstUserViewBinder(getLinkSeatAbilityProvider()));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder.MultiLinkPreOnlineViewBinder.b
    public final void V3(MultiLinkPreOnlineViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        vg0.a r0 = getItemListener();
        if (r0 == null) goto L6;
        r0.V3(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void Ye(View r7) {
        Intrinsics.checkNotNullParameter(r7, "surfaceView");
        if (Gi() == true) goto L29;
        ViewParent r0 = r7.getParent();
        if ((r0 instanceof ViewGroup) == true) goto L7;
        r0 = null;
    L7:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L11;
        r1.removeView(r7);
    L11:
        if (getLayoutConfig().j() == 5) goto L13;
        return;
    L13:
        if (getLayoutConfig().getUiLayout() != 25) goto L31;
        getAnchorSurfaceViewContainer().addView(r7);
        List<m.d> r2 = getLayoutConfig().h();
        if (r2 == null) goto L32;
        m.d r3 = (m.d) CollectionsKt.first(r2);
        if (r3 != null) goto L20;
        return;
    L20:
        if (r3.b() != 0.0d) goto L22;
    L24:
        double r4 = 1.7777777777777777d;
    L25:
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams((int) (((double) s1.r()) / r4), s1.r(), 1);
        ALogger.i("pc_audio_casting_tag", " rtc addAnchorSurfaceViewToContainer ;;  layoutParams.gravity == " + r5.gravity + " ;; " + r5.width + " ;; " + r5.height);
        r7.setLayoutParams(r5);
        c r8 = RadioStageContext.Companion.a();
        if (r8 == null) goto L33;
        r8.yk(this);
        return;
    L33:
        return;
    L22:
        if (r3.d() == 0.0d) goto L24;
        r4 = r3.b() / r3.d();
        goto L25
    L32:
        return;
    L31:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView
    public void setSingleSurfaceViewContainer(ConstraintLayout r1) {
        this.I = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void Ha(m r7, boolean r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        Integer r0 = this.H;
        int r1 = r7.getUiLayout();
        if (r0 != null) goto L8;
    L10:
        this.H = Integer.valueOf(r7.getUiLayout());
        f r2 = r7.d;
        Intrinsics.checkNotNull(r2);
        boolean r3 = false;
        Y5(r7, (f.c) ListProtector.get(r2.d, 0), r8);
        List<Integer> r4 = r7.e;
        if (r4 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        ALogger.i(getTAG(), "attachLyricsContainer, isCustomizeStreamLayout: , " + r5);
        v r6 = null;
        if (((Boolean) h.H4.getValue(null, h.a[292(0x124, float:4.09E-43)])).booleanValue() == false) goto L22;
        if (r5 == false) goto L22;
        ConstraintLayout r9 = getLyricsContainer();
        if (r9 == null) goto L25;
        UtilityKotlinExtentionsKt.t(r9);
    L25:
        InteractiveSongContext.a r10 = InteractiveSongContext.Companion;
        r10.b(r8);
        InteractiveSongContext r11 = r10.getContext();
        if (r11 == null) goto L31;
        n<v> r12 = r11.getLyricsRecognizer();
        if (r12 == null) goto L31;
        r6 = (v) r12.getValue();
    L31:
        if (getMFeedType() == 0) goto L33;
        r3 = true;
    L33:
        InteractiveSongContext r13 = r10.getContext();
        if (r13 == null) goto L44;
        i<Boolean> r14 = r13.isFeed();
        if (r14 != null) goto L38;
        return;
    L38:
        if (r3 != ((Boolean) r14.getValue()).booleanValue()) goto L46;
        ConstraintLayout r15 = getLyricsContainer();
        if (r15 == null) goto L47;
        if (r6 == null) goto L48;
        r6.o(r15.getContext(), r15, r3, r7.getUiLayout());
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L44:
        return;
    L22:
        ConstraintLayout r16 = getLyricsContainer();
        if (r16 == null) goto L25;
        UtilityKotlinExtentionsKt.w(r16);
        goto L25
    L13:
        if (r4.contains(8) != true) goto L15;
        r5 = true;
        goto L16
    L8:
        if (r0.intValue() != r1) goto L10;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView
    public final void T5(MultiTypeAdapter r4, SeatAnimEngineWrapper r5) {
        Intrinsics.checkNotNullParameter(r4, "animAdapter");
        r4.z2(MultiLinkAudioFirstUserVirtualAvatarViewBinder.a.class, new com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.e(this, this, r5, getLinkSeatAbilityProvider()));
        r4.z2(MultiLinkAudioFirstUserViewBinder.a.class, new d(this, this, r5, getLinkSeatAbilityProvider()));
        r4.z2(MultiLinkGuestViewBinder.a.class, new MultiLinkAnimViewBinder(this, this, r5, getLinkSeatAbilityProvider()));
        r4.z2(e.class, new MultiLinkDummyViewBinder());
    }

    public VoiceCommonLinkSeatWindowView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.C = LazyKt.lazy(new VoiceCommonLinkSeatWindowView$anchorSurfaceViewContainer$2(this));
        this.D = LazyKt.lazy(new VoiceCommonLinkSeatWindowView$lyricsContainer$2(this));
        this.E = "";
        this.G = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void Pj(String r5, View r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "interactId");
        Intrinsics.checkNotNullParameter(r6, "surfaceView");
        com.bytedance.android.live.liveinteract.customizestream.a.a(getTAG(), "updateCustomizeSurfaceView interactId=" + r5 + ", surfaceView=" + r6 + ", isCameraOn=true, isMicSeatVisible=" + r7);
        this.E = r5;
        f r0 = getLayoutConfig().d;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.d.size();
        fg0.a r2 = getMultiAdapterWrapper();
        if (r2 == null) goto L8;
        int r8 = r2.a("", r5);
    L9:
        if (r8 < 0) goto L28;
        if (r8 < r1) goto L13;
        return;
    L13:
        if (r7 == false) goto L15;
        boolean r9 = true;
    L16:
        ConstraintLayout.LayoutParams r3 = getAnchorSurfaceViewContainer().getLayoutParams();
        if (r3 == null) goto L27;
        ConstraintLayout.LayoutParams r4 = r3;
        if (r9 == false) goto L24;
        ViewGroup r10 = UtilityKotlinExtentionsKt.p(r6);
        if (r10 == null) goto L23;
        r10.removeView(r6);
    L23:
        r6.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        r4.topToTop = 0;
        r4.leftToLeft = 0;
        r4.bottomToBottom = 0;
        r4.rightToRight = 0;
        r6.setOutlineProvider(null);
        getAnchorSurfaceViewContainer().addView(r6);
        return;
    L24:
        r4.topToTop = 2131378009;
        r4.leftToLeft = 2131378009;
        r4.bottomToBottom = 2131378009;
        r4.rightToRight = 2131378009;
        r6.setOutlineProvider(null);
        getAnchorSurfaceViewContainer().removeView(r6);
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L15:
        r9 = false;
        goto L16
    L28:
        return;
    L8:
        r8 = S5(r5);
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void U3(m r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "layoutConfig");
        super.U3(r6, r7, r8);
        CustomizeStreamContext r9 = CustomizeStreamContext.Companion.getContext();
        if (r9 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r10 = r9.getCustomizeStreamStarted();
        if (r10 == null) goto L9;
        Boolean r11 = (Boolean) r10.getValue();
        if (r11 == null) goto L9;
        boolean r12 = r11.booleanValue();
    L11:
        if (((Boolean) y2.a.getValue()).booleanValue() == false) goto L30;
        if (r2.a(this.E) == false) goto L30;
        if (Gi() == false) goto L30;
        if (r12 == true) goto L30;
        f r13 = r6.d;
        if (r13 != null) goto L20;
        return;
    L20:
        int r0 = r13.d.size();
        fg0.a r1 = getMultiAdapterWrapper();
        if (r1 == null) goto L23;
        int r2 = r1.a("", this.E);
    L24:
        if (r2 < 0) goto L28;
        if (r2 >= r0) goto L51;
        f.c r14 = (f.c) ListProtector.get(r13.d, r2);
        View r3 = getAnchorSurfaceViewContainer().getChildAt(0);
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(r14.e, r14.f, 51);
        r4.leftMargin = r14.c;
        r4.topMargin = r14.d;
        r3.setLayoutParams(r4);
        goto L30
    L51:
        return;
    L28:
        return;
    L23:
        r2 = S5(this.E);
    L30:
        if (((Boolean) h.H4.getValue(null, h.a[292(0x124, float:4.09E-43)])).booleanValue() == true) goto L32;
        return;
    L32:
        if (r6.getUiLayout() != 30) goto L57;
        List<Integer> r15 = r6.e;
        if (r15 == null) goto L39;
        boolean r5 = true;
        if (r15.contains(8) != true) goto L39;
    L40:
        ALogger.i(getTAG(), "onCustomizeStreamLayoutChanged, uiLayout: " + r6.getUiLayout() + ", isCustomizeLayout: , " + r5);
        if (r5 == false) goto L45;
        ConstraintLayout r16 = getLyricsContainer();
        if (r16 == null) goto L53;
        UtilityKotlinExtentionsKt.t(r16);
        return;
    L53:
        return;
    L45:
        f r17 = r6.d;
        if (r17 == null) goto L55;
        int r18 = com.bytedance.android.live.liveinteract.aimv.b.a;
        Y5(r6, (f.c) ListProtector.get(r17.d, 0), com.bytedance.android.live.liveinteract.aimv.b.b(getMRoom()));
        ConstraintLayout r19 = getLyricsContainer();
        if (r19 == null) goto L56;
        UtilityKotlinExtentionsKt.w(r19);
        return;
    L56:
        return;
    L55:
        return;
    L39:
        r5 = false;
        goto L40
    L57:
        return;
    L9:
        r12 = false;
        goto L11
    }

    public final void Y5(m r8, f.c r9, boolean r10) {
        ALogger.i(getTAG(), "updateLyricsLayoutParams, uiLayout: " + r8.getUiLayout() + ", seatItem: " + r9);
        if (r8.getUiLayout() != 30) goto L6;
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(s1.f(224.0f), s1.f(150.0f));
        ((ViewGroup.MarginLayoutParams) r11).topMargin = (r9.d + ((int) (((double) r9.f) * 0.72d))) + s1.f(26.0f);
        ((ViewGroup.MarginLayoutParams) r11).leftMargin = r9.c - ((s1.f(224.0f) - r9.e) / 2);
        r11.topToTop = 0;
        r11.leftToLeft = 0;
    L10:
        ConstraintLayout r12 = getLyricsContainer();
        if (r12 == null) goto L14;
        r12.setLayoutParams(r11);
        return;
    L14:
        return;
    L6:
        if (r8.getUiLayout() != 26) goto L9;
        if (r10 == false) goto L9;
        r11 = new ConstraintLayout.LayoutParams(s1.f(132.0f), s1.f(87.0f));
        ((ViewGroup.MarginLayoutParams) r11).topMargin = s1.f(-8.0f);
        r11.topToTop = 0;
        r11.leftToLeft = 0;
        r11.rightToRight = 0;
    L9:
        r11 = new ConstraintLayout.LayoutParams(s1.f(164.0f), r9.f);
        ((ViewGroup.MarginLayoutParams) r11).leftMargin = (r9.c + r9.e) + s1.f(15.0f);
        ((ViewGroup.MarginLayoutParams) r11).topMargin = r9.d;
        r11.leftToLeft = 0;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void zk(String r8, View r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "interactId");
        Intrinsics.checkNotNullParameter(r9, "surfaceView");
        ALogger.i(getTAG(), "[3d-avatar] updateNonSingleViewSurfaceView interactId=" + r8 + ", surfaceView=" + r9 + ", isCameraOn=true, isMicSeatVisible=" + r10);
        this.E = r8;
        f r0 = getLayoutConfig().d;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.d.size();
        CustomizeStreamContext.a r2 = CustomizeStreamContext.Companion;
        CustomizeStreamContext r3 = r2.getContext();
        boolean r4 = false;
        if (r3 == null) goto L12;
        com.bytedance.live.datacontext.m<Boolean> r5 = r3.getCustomizeStreamStarted();
        if (r5 == null) goto L12;
        Boolean r6 = (Boolean) r5.getValue();
        if (r6 == null) goto L12;
        boolean r7 = r6.booleanValue();
    L13:
        if (r7 == false) goto L15;
        return;
    L15:
        fg0.a r11 = getMultiAdapterWrapper();
        if (r11 == null) goto L18;
        int r12 = r11.a("", r8);
    L19:
        if (r12 < 0) goto L53;
        if (r12 >= r1) goto L55;
        f.c r13 = (f.c) ListProtector.get(r0.d, r12);
        if (r10 == false) goto L26;
        r4 = true;
    L26:
        if (r4 == false) goto L45;
        ViewGroup r14 = UtilityKotlinExtentionsKt.p(r9);
        if (r14 == null) goto L30;
        r14.removeView(r9);
    L30:
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(r13.e, r13.f, 51);
        r15.leftMargin = r13.c;
        r15.topMargin = r13.d;
        r9.setLayoutParams(r15);
        if (((Boolean) s2.a.getValue()).booleanValue() == true) goto L33;
    L43:
        getAnchorSurfaceViewContainer().addView(r9);
        return;
    L33:
        if (getLayoutConfig().getUiLayout() != 27) goto L35;
    L36:
        CustomizeStreamContext r16 = r2.getContext();
        if (r16 == null) goto L42;
        com.bytedance.live.datacontext.m<Boolean> r17 = r16.getCustomizeStreamStarted();
        if (r17 == null) goto L42;
        if (((Boolean) r17.getValue()).booleanValue() == true) goto L43;
    L42:
        this.F = r9.getClipToOutline();
        r9.setOutlineProvider(new a(r13));
        r9.setClipToOutline(true);
        goto L43
    L35:
        if (getLayoutConfig().getUiLayout() != 30) goto L43;
    L45:
        if (((Boolean) s2.a.getValue()).booleanValue() == true) goto L47;
    L51:
        getAnchorSurfaceViewContainer().removeView(r9);
        return;
    L47:
        if (getLayoutConfig().getUiLayout() != 27) goto L49;
    L50:
        r9.setOutlineProvider(null);
        r9.setClipToOutline(this.F);
        goto L51
    L49:
        if (getLayoutConfig().getUiLayout() != 30) goto L51;
    L55:
        return;
    L53:
        return;
    L18:
        r12 = S5(r8);
    L12:
        r7 = false;
        goto L13
    }

    public /* synthetic */ VoiceCommonLinkSeatWindowView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.LiveTypeForMultiLink;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAnimViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkDummyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFoldButtonViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkLastEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkPCLandscapeViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkPaidViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkPlaceHolderViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSelfDisciplineEndViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.utils.n1;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;
import org.json.JSONObject;
import uf2.a0;
import uf2.b1;
import uf2.d0;
import uf2.m1;
import uf2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\n0\fj\b\u0012\u0004\u0012\u00020\n`\rH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/CommonLinkSeatWindowView;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/BaseLinkSeatWindowView;", "Luf2/z$a;", "anchorLayer", "", "setAnchorLayerToOriginLayer", "", "getLayoutId", "", "getNitaTag", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/m;", "getCurrentLayoutConfig", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/bytedance/revenue/platform/api/core/rx/BehaviorSubject;", "getLayoutConfigObservable", "getLinkSeatWindowView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "C", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getSingleSurfaceViewContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setSingleSurfaceViewContainer", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "singleSurfaceViewContainer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonLinkSeatWindowView extends BaseLinkSeatWindowView {
    public static final /* synthetic */ int D = 0;
    public ConstraintLayout C;

    public interface a {
    }

    public CommonLinkSeatWindowView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommonLinkSeatWindowView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void Pj(String r1, View r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
        Intrinsics.checkNotNullParameter(r2, "surfaceView");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView
    public int getLayoutId() {
        return 2131566837;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public BaseLinkSeatWindowView getLinkSeatWindowView() {
        return this;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView
    public BehaviorSubject<m> getLayoutConfigObservable() {
        return BehaviorSubject.createDefault(new m());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView
    public String getNitaTag() {
        return VerticalNitaInflate.Tag.MultiLinkVideoCommonWindowView.name();
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

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final View vb() {
        LinkMicRecyclerView r0 = getRecyclerView();
        if (r0 == null) goto L5;
        RecyclerView.ViewHolder r1 = r0.findViewHolderForAdapterPosition(0);
    L7:
        if ((r1 instanceof MultiLinkFirstUserViewBinder.ItemViewHolder) == true) goto L9;
        return null;
    L9:
        return r1.itemView;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public ConstraintLayout getSingleSurfaceViewContainer() {
        return this.C;
    }

    private final void setAnchorLayerToOriginLayer(z.a r2) {
        n1.f.getClass();
        if (n1.b.a() == true) goto L12;
        tf0.o.a r0 = getCallBack();
        if (r0 == null) goto L13;
        d0 r1 = r0.getLiveCore();
        if (r1 == null) goto L14;
        z r3 = r1.C();
        if (r3 == null) goto L15;
        r2.name();
        r3.e();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkPCLandscapeViewBinder.b, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void K1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        hi(r2, true, true, true);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView
    public final void U5(MultiTypeAdapter r5) {
        Intrinsics.checkNotNullParameter(r5, "adapter");
        LiveTypeForMultiLink r2 = LiveTypeForMultiLink.Video;
        r5.z2(MultiLinkSpecialViewBinder.a.class, new MultiLinkSpecialViewBinder(r2, getLinkSeatAbilityProvider()));
        r5.z2(MultiLinkNormalEmptyViewBinder.a.class, new MultiLinkNormalEmptyViewBinder(r2, getLinkSeatAbilityProvider()));
        r5.z2(MultiLinkGuestViewBinder.a.class, new MultiLinkGuestViewBinder(r2, getLinkSeatAbilityProvider()));
        r5.z2(MultiLinkPaidViewBinder.a.class, new MultiLinkPaidViewBinder());
        r5.z2(MultiLinkSelfDisciplineEndViewBinder.a.class, new MultiLinkSelfDisciplineEndViewBinder());
        r5.z2(MultiLinkPCLandscapeViewBinder.a.class, new MultiLinkPCLandscapeViewBinder(getLinkSeatAbilityProvider()));
        r5.z2(MultiLinkFirstUserViewBinder.a.class, new MultiLinkFirstUserViewBinder(getLinkSeatAbilityProvider()));
        r5.z2(MultiLinkLastEmptyViewBinder.a.class, new MultiLinkLastEmptyViewBinder(getLinkSeatAbilityProvider()));
        r5.z2(MultiLinkFoldButtonViewBinder.a.class, new MultiLinkFoldButtonViewBinder(getLinkSeatAbilityProvider()));
        r5.z2(MultiLinkPlaceHolderViewBinder.a.class, new MultiLinkPlaceHolderViewBinder());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void le(SurfaceView r3) {
        Intrinsics.checkNotNullParameter(r3, "surfaceView");
        ConstraintLayout r0 = getSingleSurfaceViewContainer();
        if (r0 != null) goto L5;
    L6:
        ConstraintLayout r1 = getSingleSurfaceViewContainer();
        if (r1 == null) goto L11;
        r1.removeView(r3);
        return;
    L11:
        return;
    L5:
        if (r0.indexOfChild(r3) != (-1)) goto L6;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void pd(View r7) {
        Intrinsics.checkNotNullParameter(r7, "surfaceView");
        gh0.b.a("SingleView", "addSurfaceView4SingleViewMode, add surfaceView width=" + r7.getWidth() + "-height=" + r7.getHeight() + " measuredWidth=" + r7.getMeasuredWidth() + "-measuredHeight=" + r7.getMeasuredHeight(), false);
        ViewParent r0 = r7.getParent();
        b1 r3 = null;
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L8;
        r1.removeView(r7);
    L8:
        ConstraintLayout r2 = getSingleSurfaceViewContainer();
        if (r2 == null) goto L21;
        if (r2.indexOfChild(r7) != (-1)) goto L21;
        if (((Boolean) vm2.d.e6.getValue(null, vm2.d.a[366(0x16e, float:5.13E-43)])).booleanValue() == false) goto L17;
        ConstraintLayout.LayoutParams r4 = new ConstraintLayout.LayoutParams(-1, -1);
        r4.leftToLeft = 0;
        r4.rightToRight = 0;
        r4.bottomToBottom = 0;
        r4.topToTop = 0;
        ConstraintLayout r5 = getSingleSurfaceViewContainer();
        if (r5 == null) goto L21;
        r5.addView(r7, r4);
        goto L21
    L17:
        ConstraintLayout r6 = getSingleSurfaceViewContainer();
        if (r6 == null) goto L21;
        r6.addView(r7);
    L21:
        if (((Boolean) vm2.d.d6.getValue(null, vm2.d.a[365(0x16d, float:5.11E-43)])).booleanValue() == false) goto L36;
        tf0.o.a r8 = getCallBack();
        if (r8 == null) goto L37;
        d0 r9 = r8.getLiveCore();
        if (r9 == null) goto L38;
        a0 r10 = r9.C();
        if (r10 == null) goto L39;
        r10.f();
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r11 = ILiveWrappedLivePusher.a.b();
        if (r11 == null) goto L31;
        r3 = r11.newTEBundle();
    L31:
        if (r3 == null) goto L33;
        r3.b();
    L33:
        if (r3 == null) goto L40;
        r3.release();
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView
    public void setSingleSurfaceViewContainer(ConstraintLayout r1) {
        this.C = r1;
    }

    public static final /* synthetic */ void Y5(CommonLinkSeatWindowView r0, z.a r1) {
        r0.setAnchorLayerToOriginLayer(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView
    public final void T5(MultiTypeAdapter r4, SeatAnimEngineWrapper r5) {
        Intrinsics.checkNotNullParameter(r4, "animAdapter");
        r4.z2(MultiLinkFirstUserViewBinder.a.class, new com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.d(this, this, r5, getLinkSeatAbilityProvider()));
        r4.z2(MultiLinkGuestViewBinder.a.class, new MultiLinkAnimViewBinder(this, this, r5, getLinkSeatAbilityProvider()));
        r4.z2(tf0.e.class, new MultiLinkDummyViewBinder());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.b, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void m3(MultiLinkGuestViewBinder.a r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "itemData");
        if (this.f == false) goto L18;
        IBaseUser r0 = r4.k.a.getUser();
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.getIdString();
    L8:
        com.bytedance.live.datacontext.m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r3 == null) goto L13;
        IRoom r6 = (IRoom) r3.getValue();
        if (r6 == null) goto L13;
        r1 = r6.getOwnerUserIdString();
    L13:
        boolean r7 = Intrinsics.areEqual(r2, r1);
        String r8 = r4.k.a.getInteractId();
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        hi(r8, r5, r7, r4.j);
        return;
    L7:
        r2 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonLinkSeatWindowView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setSingleSurfaceViewContainer(findViewById(2131387772));
    }

    public static float Z5(boolean r5, float r6, int r7) {
        if (r5 == true) goto L4;
        return r6;
    L4:
        if (wf0.b.e() == true) goto L6;
        return r6;
    L6:
        if (wf0.b.f() == true) goto L8;
        return r6;
    L8:
        if (((Boolean) vm2.d.u2.getValue(null, vm2.d.a[174(0xae, float:2.44E-43)])).booleanValue() == false) goto L39;
        float r8 = 0.0f;
        if (wf0.b.e() == true) goto L12;
        return 0.0f;
    L12:
        if (wf0.b.f() == false) goto L41;
        String r0 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.b.a(0);
        if (r0 == null) goto L42;
        JSONObject r1 = new JSONObject(r0).optJSONObject("PushBase");     // Catch: Exception -> L31
        if (r1 == null) goto L18;
        int r2 = r1.optInt("cap_adapted_width", -1);     // Catch: Exception -> L31
    L19:
        if (r1 == null) goto L22;
        int r3 = r1.optInt("cap_adapted_height", -1);     // Catch: Exception -> L31
    L23:
        if (r2 == (-1)) goto L26;
        if (r3 == (-1)) goto L26;
        float r9 = r2;
        float r4 = (r9 / r3) * r7;
        float r10 = ((r9 - r4) / r4) / 2.0f;
        r8 = r4;
    L34:
        ALogger.e("MultiCastHelper", "getLeftOffset ;; capAdaptedWidth == " + r2 + " ;; adaptedWidth == " + r8 + " ;; containerHeight == " + r7 + " ;; leftOffset == " + r10);     // Catch: Exception -> L30
    L29:
        return r10;
    L26:
        r10 = 0.0f;
        goto L34
    L22:
        r3 = -1;
        goto L23
    L18:
        r2 = -1;
    L43:
        return 0.0f;
    L42:
        return 0.0f;
    L41:
        return 0.0f;
    L39:
        return r6;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void U3(m r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "layoutConfig");
        super.U3(r4, r5, r6);
        if (((Boolean) vm2.c.c.getValue(null, vm2.c.a[1])).booleanValue() == true) goto L5;
        return;
    L5:
        if (r4.getUiLayout() != 2) goto L37;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r7 = getLinkUserDataMergeCenter();
        if (r7 == null) goto L12;
        BehaviorSubject<List<ch0.e>> r8 = r7.f();
        if (r8 == null) goto L12;
        List r9 = (List) r8.getValue();
        if (r9 == null) goto L12;
    L13:
        if (r9 == null) goto L38;
        Iterator r10 = r9.iterator();
    L16:
        if (r10.hasNext() == false) goto L39;
        ch0.e r11 = (ch0.e) r10.next();
        IBaseUser r12 = r11.a.getUser();
        if (r12 == null) goto L20;
        String r13 = r12.getIdString();
    L21:
        com.bytedance.android.livesdk.chatroom.o r2 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r2 == null) goto L28;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L28;
        IRoom r14 = (IRoom) r3.getValue();
        if (r14 == null) goto L28;
        String r15 = r14.getOwnerUserIdString();
    L29:
        boolean r16 = Intrinsics.areEqual(r13, r15);
        boolean r17 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a(r11, null);
        String r18 = r11.a.getInteractId();
        if (r18 != null) goto L32;
        r18 = "";
    L32:
        hi(r18, r17, r16, true);
    L28:
        r15 = null;
        goto L29
    L20:
        r13 = null;
        goto L21
    L39:
        return;
    L38:
        return;
    L12:
        r9 = CollectionsKt.emptyList();
        goto L13
    }

    public /* synthetic */ CommonLinkSeatWindowView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void b6(z.a r12, m1.b r13, String r14, int r15) {
        m1.b r0 = r12.Y();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r13 != null) goto L8;
        return;
    L8:
        if (r0.isVisible() == false) goto L10;
    L12:
        tf0.o.a r1 = getCallBack();
        if (r1 == null) goto L19;
        d0 r2 = r1.getLiveCore();
        if (r2 == null) goto L19;
        z r3 = r2.C();
        if (r3 == null) goto L19;
        int r4 = r3.d();
    L20:
        tf0.o.a r5 = getCallBack();
        if (r5 == null) goto L27;
        d0 r6 = r5.getLiveCore();
        if (r6 == null) goto L27;
        z r7 = r6.C();
        if (r7 == null) goto L27;
        int r8 = r7.c();
    L28:
        if (r4 <= 0) goto L39;
        if (r8 <= 0) goto L39;
        double r9 = Math.abs(r13.getRight() - r13.getLeft()) * r4;
        double r10 = Math.abs(r13.getBottom() - r13.getTop()) * r8;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.e.a r11 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.e.c;
        tf0.o.a r16 = getCallBack();
        if (r16 == null) goto L33;
        j1 r17 = r16.Zb();
    L34:
        j1 r18 = r17;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r14, "interactId");
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.e.a.b(r18) == false) goto L39;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.e.a.a(r14, r9, r10, r18);
        goto L39
    L33:
        r17 = null;
    L39:
        if (r0.getLeft() == r13.getLeft()) goto L41;
    L52:
        gh0.b.a("SingleView", "updateLayerDescription, interactId: " + r14 + ", uiPosition: " + r15 + "\nparams[" + r13.getLeft() + ", " + r13.getTop() + ", " + r13.getRight() + ", " + r13.getBottom() + "], visible = " + r13.isVisible() + ", mode = " + r13.getMode() + ", zOrder = " + r13.d(), false);
        r12.b();
        List<String> r19 = uh0.a.a;
        if (uh0.a.a.contains(String.valueOf(getLayoutConfig().getUiLayout())) == false) goto L59;
        IInteractService r110 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r110 == null) goto L60;
        r110.commonWMUpdateLiveCoreAndRtcInfo("SingleViewLayerUpdate");
        return;
    L60:
        return;
    L59:
        return;
    L41:
        if (r0.getTop() != r13.getTop()) goto L52;
        if (r0.getRight() != r13.getRight()) goto L52;
        if (r0.getBottom() != r13.getBottom()) goto L52;
        if (r0.isVisible() != r13.isVisible()) goto L52;
        if (r0.getMode() != r0.getMode()) goto L52;
        if (r0.d() != r13.d()) goto L52;
        return;
    L27:
        r8 = 0;
    L19:
        r4 = 0;
        goto L20
    L10:
        if (r13.isVisible() == true) goto L12;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void hi(String r14, boolean r15, boolean r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r14, "interactId");
        int r0 = c1.a;
        boolean r1 = false;
        m.d r4 = null;
        m1.b r5 = null;
        r5 = null;
        Object r6 = null;
        if (c1.a(Integer.valueOf(getLayoutConfig().m()), Integer.valueOf(getLayoutConfig().getUiLayout())) == true) goto L71;
        if (TextUtils.equals(r14, tc0.c.h().f) == false) goto L13;
        tf0.o.a r2 = getCallBack();
        if (r2 == null) goto L20;
        d0 r3 = r2.getLiveCore();
        if (r3 == null) goto L20;
        z r7 = r3.C();
        if (r7 == null) goto L20;
        z.a r8 = r7.K0();
    L21:
        if (r8 == null) goto L122;
        pn0.f r9 = getLayoutConfig().d;
        if (r9 == null) goto L123;
        int r10 = r9.d.size();
        fg0.a r11 = getMultiAdapterWrapper();
        if (r11 == null) goto L29;
        int r12 = r11.a("", r14);
    L30:
        if (r12 < 0) goto L119;
        if (r12 >= r10) goto L124;
        pn0.f.c r13 = (pn0.f.c) ListProtector.get(r9.d, r12);
        if (TextUtils.equals(r14, tc0.c.h().f()) == true) goto L59;
        tf0.o.a r18 = getCallBack();
        if (r18 == null) goto L46;
        j1 r19 = r18.Zb();
        if (r19 == null) goto L46;
        cg6.a r110 = r19.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r110 == null) goto L46;
        hg6.g r111 = r110.getRtcManager();
        if (r111 == null) goto L46;
        if (r111.isEngineOn() != true) goto L46;
        boolean r112 = true;
    L47:
        m r113 = getLayoutConfig();
        if (r113 != null) goto L50;
    L53:
        boolean r114 = false;
    L54:
        if (r114 == true) goto L59;
        if (getLayoutConfig().getUiLayout() != 63) goto L58;
        r1 = true;
    L58:
        if (r1 == true) goto L59;
    L60:
        pn0.f.b r20 = r9.c;
        int r21 = r20.a;
        if (r21 >= 0) goto L63;
        int r22 = r20.c + r21;
    L64:
        float r23 = r13.c / r22;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r24 = ILiveWrappedLivePusher.a.b();
        if (r24 == null) goto L69;
        m1.b r25 = r24.newVideoMixerDescription(null);
        if (r25 == null) goto L69;
        Z5(r16, r23, r13.f);
        r25.e();
        r25.b();
        r25.c();
        r25.f();
        r25.i();
        r25.g();
        r25.h();
        r5 = r25;
    L69:
        int r26 = com.bytedance.android.live.liveinteract.linkcast.a.a;
        com.bytedance.android.live.liveinteract.linkcast.a.C0037a.b(r5, r16, getLayoutConfig().getUiLayout());
        int r27 = pi0.a.a;
        pi0.a.b(getMDataCenter(), r5, r16, getLayoutConfig().getUiLayout());
        b6(r8, r5, r14, r12);
        return;
    L63:
        r22 = r20.c;
        goto L64
    L50:
        if (r113.getUiLayout() != 62) goto L53;
        if (r112 == false) goto L53;
        r114 = true;
    L46:
        r112 = false;
    L59:
        setAnchorLayerToOriginLayer(r8);
        goto L60
    L124:
        return;
    L119:
        return;
    L29:
        r12 = S5(r14);
        goto L30
    L123:
        return;
    L122:
        return;
    L20:
        r8 = null;
        goto L21
    L13:
        tf0.o.a r28 = getCallBack();
        if (r28 == null) goto L20;
        d0 r29 = r28.getLiveCore();
        if (r29 == null) goto L20;
        z r30 = r29.C();
        if (r30 == null) goto L20;
        r8 = r30.l();
        goto L21
    L71:
        if (TextUtils.equals(r14, tc0.c.h().f) == false) goto L79;
        tf0.o.a r31 = getCallBack();
        if (r31 == null) goto L87;
        d0 r32 = r31.getLiveCore();
        if (r32 == null) goto L87;
        z r33 = r32.C();
        if (r33 == null) goto L87;
        z.a r34 = r33.K0();
    L86:
        z.a r35 = r34;
    L88:
        fg0.a r36 = getMultiAdapterWrapper();
        if (r36 == null) goto L91;
        int r37 = r36.a("", r14);
    L92:
        int r38 = r37;
        if (r38 == (-1)) goto L125;
        List<m.d> r39 = getLayoutConfig().h();
        if (r39 == null) goto L107;
        Iterator<T> r40 = r39.iterator();
    L99:
        if (r40.hasNext() == false) goto L106;
        Object r41 = r40.next();
        if (((m.d) r41).c() != r38) goto L103;
        boolean r115 = true;
    L104:
        if (r115 == false) goto L99;
        r6 = r41;
        goto L106
    L103:
        r115 = false;
    L106:
        r4 = (m.d) r6;
    L107:
        m.d r42 = r4;
        if (r42 == null) goto L126;
        ConstraintLayout r116 = getSingleSurfaceViewContainer();
        if (r116 == null) goto L121;
        r116.post(new f(this, r35, r14, r38, r42, r15, r17, r16));
        return;
    L121:
        return;
    L126:
        return;
    L125:
        return;
    L91:
        r37 = S5(r14);
    L87:
        r35 = null;
        goto L88
    L79:
        tf0.o.a r43 = getCallBack();
        if (r43 == null) goto L87;
        d0 r44 = r43.getLiveCore();
        if (r44 == null) goto L87;
        z r45 = r44.C();
        if (r45 == null) goto L87;
        r34 = r45.l();
        goto L86
    }
}

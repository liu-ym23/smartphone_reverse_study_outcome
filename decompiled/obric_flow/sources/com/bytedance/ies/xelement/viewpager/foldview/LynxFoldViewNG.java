package com.bytedance.ies.xelement.viewpager.foldview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.ies.xelement.viewpager.CustomAppBarLayoutNG;
import com.bytedance.ies.xelement.viewpager.childitem.LynxFoldHeader;
import com.bytedance.ies.xelement.viewpager.childitem.LynxFoldSlot;
import com.bytedance.ies.xelement.viewpager.childitem.LynxFoldToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.scroll.UIScrollView;
import com.lynx.tasm.behavior.y0;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.utils.g;
import com.lynx.tasm.utils.j;
import com.lynx.tasm.utils.k;
import com.obric.launcher.widget.R$id;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\nJ\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u001a\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/foldview/LynxFoldViewNG;", "Lcom/bytedance/ies/xelement/viewpager/foldview/BaseLynxFoldView;", "Lcom/bytedance/ies/xelement/viewpager/CustomAppBarLayoutNG;", "Lcom/bytedance/ies/xelement/viewpager/foldview/FoldViewLayoutNG;", "Lrn/a;", "Lrn/b;", "", "enable", "", "setTabMovableEnable", "(Z)V", "setToolbarInteractionEnable", "setHeaderScrollViewEnable", "setEnableTouchStopFling", "isOverSlot", "setAndroidHeaderOverSlot", "setUnifiedHeaderOverSlot", "setNestedScrollAsChild", "", "tapSlop", "setAndroidHeaderTapSlop", "(I)V", "Lcom/lynx/react/bridge/ReadableMap;", LynxResourceModule.PARAMS_KEY, "Lcom/lynx/react/bridge/Callback;", "callback", "scrollBy", "(Lcom/lynx/react/bridge/ReadableMap;Lcom/lynx/react/bridge/Callback;)V", "setFoldExpanded", "getScrollInfo", "(Lcom/lynx/react/bridge/Callback;)V", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxFoldViewNG extends BaseLynxFoldView<CustomAppBarLayoutNG, FoldViewLayoutNG> implements rn.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f6556h = 0;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    public static final void k(LynxFoldViewNG r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        T r11 = r5.mView;
        if (r11 != 0) goto L5;
        return;
    L5:
        ((FoldViewLayoutNG) r11).scrollBy(0, (int) r10);
    }

    public static boolean l(wm.a r5) {
        if ((r5 instanceof UIScrollView) == false) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
        return false;
    L8:
        if ((r5 instanceof LynxFoldViewNG) == false) goto L11;
        return false;
    L11:
        return l(r5.parent());
    }

    public static boolean m(wm.a r5) {
        if ((r5 instanceof LynxFoldToolbar) == true) goto L5;
    L8:
        if (r5 != null) goto L10;
        return false;
    L10:
        if ((r5 instanceof LynxFoldViewNG) == false) goto L13;
        return false;
    L13:
        return m(r5.parent());
    L5:
        if (((LynxFoldToolbar) r5).isUserInteractionEnabled() == true) goto L8;
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void afterPropsUpdated(y0 r5) {
        super.afterPropsUpdated(r5);
        if (isEnableScrollMonitor() == false) goto L6;
        ((CustomAppBarLayoutNG) ((FoldViewLayoutNG) j()).f6510b).getClass();
        return;
    }

    @Override // rn.a
    public final boolean canConsumeGesture(float r5, float r10) {
        if (isEnableNewGesture() == true) goto L5;
    L12:
        return false;
    L5:
        if (this.mView == 0) goto L12;
        isAtBorder(true);
        if (r10 < 0.0f) goto L12;
        isAtBorder(false);
        if (r10 > 0.0f) goto L12;
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void consumeGesture(boolean r5) {
        ((FoldViewLayoutNG) this.mView).getClass();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        LynxLog.b(2, "LynxFoldViewNG", "createView start: " + this + ' ' + r5 + " realActivity is: " + kk.a.c(getLynxContext()));
        if (r5 != null) goto L5;
        return null;
    L5:
        FoldViewLayoutNG r10 = new FoldViewLayoutNG(r5, this);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6551a = r10;
        c(r5);
        LynxLog.b(2, "LynxFoldViewNG", "createView end: " + this + ", " + j());
        return (FoldViewLayoutNG) j();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        ((CustomAppBarLayoutNG) ((FoldViewLayoutNG) j()).f6510b).getClass();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final wm.a findUIWithCustomLayout(float r5, float r10, UIGroup r11) {
        wm.a r12 = super.findUIWithCustomLayout(r5, r10, r11);
        if (this.d == true) goto L26;
        if (m(r12) == false) goto L26;
        Iterator<LynxBaseUI> r13 = this.mChildren.iterator();
    L8:
        if (r13.hasNext() == false) goto L36;
        if ((r13.next() instanceof LynxFoldHeader) == false) goto L8;
        HashMap r14 = new HashMap();
        int r15 = getChildCount();
    L12:
        r15 = r15 - 1;
        if ((-1) >= r15) goto L24;
        LynxBaseUI r16 = getChildAt(r15);
        if ((r16 instanceof LynxFoldToolbar) == true) goto L12;
        if ((r16 instanceof UIShadowProxy) == false) goto L21;
        r16 = ((UIShadowProxy) r16).f10388a;
    L21:
        if ((r16 instanceof LynxUI) == false) goto L12;
        r14.put(((LynxUI) r16).getView(), r16);
        goto L12
    L24:
        r12 = findUIWithCustomLayoutByChildren(r5, r10, this, r14);
    L36:
        return r12;
    L26:
        if (this.e == false) goto L36;
        boolean r17 = l(r12);
        ViewGroup.LayoutParams r18 = ((FoldViewLayoutNG) j()).f6511c.getLayoutParams();
        if (r18 == null) goto L35;
        AppBarLayout.LayoutParams r19 = (AppBarLayout.LayoutParams) r18;
        if (r17 == true) goto L32;
        r19.setScrollFlags(r19.getScrollFlags() | 1);
    L33:
        ((FoldViewLayoutNG) j()).f6511c.setLayoutParams(r19);
        goto L36
    L32:
        r19.setScrollFlags((r19.getScrollFlags() >> 1) << 1);
        goto L33
    L35:
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
    }

    @Override // rn.a
    public final int getMemberScrollX() {
        return 0;
    }

    @Override // rn.a
    public final int getMemberScrollY() {
        ((CustomAppBarLayoutNG) ((FoldViewLayoutNG) this.mView).f6510b).getClass();
        return 0;
    }

    @Override // rn.a
    public final int getScrollContainerDirection() {
        return 1;
    }

    @f0
    public final void getScrollInfo(Callback r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        JavaOnlyMap r10 = new JavaOnlyMap();
        r10.putInt("scrollX", 0);
        LynxContext r11 = this.mContext;
        ((CustomAppBarLayoutNG) ((FoldViewLayoutNG) this.mView).f6510b).getClass();
        r10.putInt("scrollY", i.a.b(r11, Math.abs(0)));
        r10.putInt("scrollRange", i.a.b(this.mContext, ((FoldViewLayoutNG) j()).f6511c.getHeight() - ((FoldViewLayoutNG) j()).d.getHeight()));
        r5.invoke(new Object[]{0, r10});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "child");
        if ((r5 instanceof LynxUI) == false) goto L16;
        this.mChildren.add(r10, r5);
        ((LynxUI) r5).setParent(this);
        if ((r5 instanceof LynxFoldToolbar) == false) goto L9;
        FoldViewLayoutNG r11 = (FoldViewLayoutNG) j();
        LynxFoldToolbar r12 = (LynxFoldToolbar) r5;
        ?? r13 = r12.getView();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r13, "mView");
        Toolbar r14 = r11.d;
        r14.setVisibility(0);
        ViewCompat.setPaddingRelative(r14, 0, 0, 0, 0);
        r14.addView(r13);
        ((FoldViewLayoutNG) j()).d.setClipChildren(!r12.f6544a);
        return;
    L9:
        if ((r5 instanceof LynxFoldHeader) == false) goto L13;
        FoldViewLayoutNG r15 = (FoldViewLayoutNG) j();
        LynxFoldHeader r16 = (LynxFoldHeader) r5;
        ?? r17 = r16.getView();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r17, "needFoldView");
        r15.f6511c.addView(r17, 0);
        FoldViewLayoutNG r18 = (FoldViewLayoutNG) j();
        r18.f6511c.setClipChildren(!r16.f6538a);
        return;
    L13:
        if ((r5 instanceof LynxFoldSlot) == false) goto L17;
        FoldViewLayoutNG r19 = (FoldViewLayoutNG) j();
        ?? r20 = ((LynxFoldSlot) r5).getView();
        r19.getClass();
        Intrinsics.checkNotNullParameter(r20, "unFoldView");
        CoordinatorLayout.LayoutParams r21 = new CoordinatorLayout.LayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r21.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        r20.setLayoutParams(r21);
        r19.addView(r20);
        n();
        return;
    L17:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void interceptGesture(boolean r5) {
        ((FoldViewLayoutNG) this.mView).getClass();
    }

    @Override // rn.a
    public final boolean isAtBorder(boolean r5) {
        ((CustomAppBarLayoutNG) ((FoldViewLayoutNG) this.mView).f6510b).getClass();
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollContainer() {
        return true;
    }

    public final void n() {
        if (this.f6551a != null) goto L5;
        return;
    L5:
        if (this.f == true) goto L7;
        return;
    L7:
        if (this.g == false) goto L12;
        FoldViewLayoutNG r5 = (FoldViewLayoutNG) j();
        r5.bringChildToFront(r5.f6510b);
        return;
    }

    @Override // rn.a
    public final void onGestureScrollBy(float r5, final float r10) {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        j.f(new c(this, r10));
    }

    @Override // rn.a
    public final void onInvalidate() {
        if (this.mView != 0) goto L5;
        return;
    L5:
        if (isEnableNewGesture() == false) goto L9;
        ViewCompat.postInvalidateOnAnimation(this.mView);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r5) {
        Intrinsics.checkNotNullParameter(r5, "child");
        if ((r5 instanceof LynxUI) == false) goto L16;
        this.mChildren.remove(r5);
        ((LynxUI) r5).setParent(null);
        if ((r5 instanceof LynxFoldToolbar) == false) goto L9;
        FoldViewLayoutNG r10 = (FoldViewLayoutNG) j();
        ?? r11 = ((LynxFoldToolbar) r5).getView();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "view");
        Toolbar r12 = r10.d;
        r12.setVisibility(8);
        r12.removeView(r11);
        return;
    L9:
        if ((r5 instanceof LynxFoldHeader) == false) goto L13;
        FoldViewLayoutNG r13 = (FoldViewLayoutNG) j();
        ?? r14 = ((LynxFoldHeader) r5).getView();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "view");
        r13.f6511c.removeView(r14);
        return;
    L13:
        if ((r5 instanceof LynxFoldSlot) == false) goto L17;
        FoldViewLayoutNG r15 = (FoldViewLayoutNG) j();
        View r16 = ((LynxFoldSlot) r5).getView();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "view");
        r15.removeView(r16);
        return;
    L17:
        return;
    }

    @f0
    public final void scrollBy(ReadableMap r10, Callback r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r10 != null) goto L6;
    L10:
        r11.invoke(new Object[]{4, "Invoke scrollBy failed due to param is null"});
        return;
    L6:
        if (r10.hasKey("offset") == false) goto L10;
        j.f(new d(this, g.a((float) r10.getDouble("offset", 0.0d), 0.0f), r11, 0));
    }

    @c0(name = "android-header-over-slot")
    public final void setAndroidHeaderOverSlot(boolean r5) {
        this.g = r5;
        n();
    }

    @c0(defaultInt = 0, name = "android-header-tap-slop")
    public final void setAndroidHeaderTapSlop(int r5) {
    }

    @c0(defaultBoolean = true, name = "android-enable-touch-stop-fling")
    public final void setEnableTouchStopFling(boolean r5) {
        ((CustomAppBarLayoutNG) ((FoldViewLayoutNG) j()).findViewById(R$id.app_bar_layout)).getClass();
        if (r5 == true) goto L6;
        LynxFeatureCounter.a(73, this.mContext.A);
        return;
    }

    @f0
    public final void setFoldExpanded(ReadableMap r10, Callback r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        JavaOnlyMap r5 = new JavaOnlyMap();
        r5.put("success", Boolean.FALSE);
        if (r10.hasKey("offset") == false) goto L19;
        String r12 = r10.getString("offset", "");
        if (StringsKt.k(r12, "px") == false) goto L7;
    L10:
        int r13 = (int) k.d(r12, 0.0f, -1.0f, this.mContext.f10152u);
    L12:
        if (r10.hasKey("smooth") == false) goto L14;
        boolean r14 = r10.getBoolean("smooth");
    L15:
        if (r14 == false) goto L17;
        b(-1.0d, r13);
    L18:
        r5.put("success", Boolean.TRUE);
    L20:
        if (r11 == null) goto L23;
        r11.invoke(new Object[]{0, r5});
        return;
    L23:
        return;
    L17:
        BaseLynxFoldView.i(this, 0.0d, r13, 1);
        goto L18
    L14:
        r14 = true;
        goto L15
    L7:
        if (StringsKt.k(r12, "rpx") == true) goto L10;
        r13 = -1;
        goto L12
    L19:
        r5.put("msg", "no index key");
        goto L20
    }

    @c0(defaultBoolean = false, name = "header-scrollview-enable")
    public final void setHeaderScrollViewEnable(boolean r5) {
        this.e = r5;
    }

    @c0(defaultBoolean = false, name = "android-nested-scroll-as-child")
    public final void setNestedScrollAsChild(boolean r5) {
        FoldViewLayoutNG r10 = (FoldViewLayoutNG) j();
        r10.e = r5;
        r10.f.setNestedScrollingEnabled(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setOverflow(Integer r5) {
        super.setOverflow(r5);
        Object r10 = r5;
        if (r5 != null) goto L5;
        r10 = Boolean.FALSE;
    L5:
        boolean r11 = Intrinsics.areEqual(r10, 1);
        this.f = !r11;
        ((FoldViewLayoutNG) this.mView).setClipChildren(r11);
        ((FoldViewLayoutNG) j()).f6510b.setClipChildren(r11);
        n();
    }

    @c0(defaultBoolean = true, name = "tab-movable-enable")
    public final void setTabMovableEnable(boolean r5) {
        ((CustomAppBarLayoutNG) ((FoldViewLayoutNG) j()).f6510b).getClass();
    }

    @c0(defaultBoolean = true, name = "toolbar-interaction-enable")
    public final void setToolbarInteractionEnable(boolean r5) {
        this.d = r5;
    }

    @c0(name = "header-over-slot")
    public final void setUnifiedHeaderOverSlot(boolean r5) {
        this.g = r5;
        n();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float[] scrollBy(float r10, float r11) {
        BaseLynxFoldView.i(this, 0.0d, (int) r11, 1);
        if (Math.abs(r10) <= Float.MIN_VALUE) goto L5;
    L6:
        recognizeGesturere();
    L7:
        ((CustomAppBarLayoutNG) ((FoldViewLayoutNG) this.mView).f6510b).getClass();
        float r5 = Math.abs(0);
        return new float[]{0.0f, r5, r10, r11 - r5};
    L5:
        if (Math.abs(r11) <= Float.MIN_VALUE) goto L7;
        goto L6
    }
}

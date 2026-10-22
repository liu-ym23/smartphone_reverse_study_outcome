package com.bytedance.ies.xelement.viewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import bf.g;
import com.bytedance.ies.xelement.viewpager.childitem.LynxFoldHeader;
import com.bytedance.ies.xelement.viewpager.childitem.LynxFoldToolbar;
import com.bytedance.ies.xelement.viewpager.foldview.BaseLynxFoldView;
import com.bytedance.ies.xelement.viewpager.foldview.FoldViewLayout;
import com.bytedance.ies.xelement.viewpager.foldview.b;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.z;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vn.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J#\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/LynxFoldView;", "Lcom/bytedance/ies/xelement/viewpager/foldview/BaseLynxFoldView;", "Lcom/bytedance/ies/xelement/viewpager/CustomAppBarLayout;", "Lcom/bytedance/ies/xelement/viewpager/foldview/FoldViewLayout;", "Lcom/lynx/react/bridge/ReadableMap;", LynxResourceModule.PARAMS_KEY, "Lcom/lynx/react/bridge/Callback;", "callback", "", "setFoldExpanded", "(Lcom/lynx/react/bridge/ReadableMap;Lcom/lynx/react/bridge/Callback;)V", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxFoldView extends BaseLynxFoldView<CustomAppBarLayout, FoldViewLayout> {
    public static final /* synthetic */ int f = 0;
    public final ArrayList d;
    public Handler e;

    public LynxFoldView(b0 r5, z r10) {
        super(r5, r10);
        this.d = new ArrayList();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        FoldViewLayout r10 = new FoldViewLayout(r5);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6551a = r10;
        c(r5);
        return (FoldViewLayout) j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.view.View, java.lang.Object] */
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
        if ((r5 instanceof LynxUI) == false) goto L32;
        this.mChildren.add(r10, r5);
        LynxUI r11 = (LynxUI) r5;
        r11.setParent(this);
        if ((r5 instanceof LynxFoldToolbar) == false) goto L9;
        FoldViewLayout r12 = (FoldViewLayout) j();
        ?? r13 = ((LynxFoldToolbar) r5).getView();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "mView");
        Toolbar r14 = r12.d;
        r14.setVisibility(0);
        ViewCompat.setPaddingRelative(r14, 0, 0, 0, 0);
        r14.addView(r13);
        return;
    L9:
        if ((r5 instanceof LynxFoldHeader) == false) goto L12;
        FoldViewLayout r15 = (FoldViewLayout) j();
        ?? r16 = ((LynxFoldHeader) r5).getView();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "needFoldView");
        r15.f6511c.addView(r16, 0);
        return;
    L12:
        FoldViewLayout r17 = (FoldViewLayout) j();
        View r18 = r11.getView();
        r17.getClass();
        Intrinsics.checkNotNullParameter(r18, "unFoldView");
        if ((r18 instanceof g) == false) goto L25;
        g r19 = (g) r18;
        r19.setTabLayoutUpdateListener$x_element_fold_view_release(new b((g) r18, r17));
        if (r19.getMTabLayout() == null) goto L24;
        TabLayout r20 = r19.getMTabLayout();
        if (r20 == null) goto L19;
        r19.removeView(r20);
    L19:
        TabLayout r21 = r19.getMTabLayout();
        if (r21 == null) goto L23;
        Intrinsics.checkNotNullParameter(r21, "mView");
        r17.f6510b.addView(r21);
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L24:
        CoordinatorLayout.LayoutParams r22 = new CoordinatorLayout.LayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r22.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        r19.setLayoutParams(r22);
    L25:
        r17.addView(r18);
        if (this.e != null) goto L28;
        this.e = new Handler(Looper.getMainLooper());
    L28:
        Handler r23 = this.e;
        if (r23 == null) goto L33;
        r23.post(new h(this, 2));
        return;
    L33:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void layoutChildren() {
        super.layoutChildren();
        Iterator r5 = this.d.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        LynxBaseUI r10 = (LynxBaseUI) r5.next();
        if ((r10 instanceof UIGroup) == false) goto L4;
        ((UIGroup) r10).layoutChildren();
        goto L4
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void measureChildren() {
        super.measureChildren();
        Iterator r5 = this.d.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        LynxBaseUI r10 = (LynxBaseUI) r5.next();
        if (r10 == null) goto L4;
        r10.measure();
        goto L4
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void removeAll() {
        this.d.clear();
        super.removeAll();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r5) {
        Intrinsics.checkNotNullParameter(r5, "child");
        if ((r5 instanceof LynxUI) == false) goto L8;
        this.mChildren.remove(r5);
        LynxUI r10 = (LynxUI) r5;
        r10.setParent(null);
        ((FoldViewLayout) j()).removeView(r10.getView());
        View r11 = ((CustomAppBarLayout) ((FoldViewLayout) j()).f6510b).getChildAt(((CustomAppBarLayout) ((FoldViewLayout) j()).f6510b).getChildCount() - 1);
        if ((r11 instanceof TabLayout) == false) goto L9;
        ((CustomAppBarLayout) ((FoldViewLayout) j()).f6510b).removeView(r11);
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void removeView(LynxBaseUI r5) {
        if ((r5 instanceof LynxViewPager) == false) goto L11;
        Iterator<LynxBaseUI> r10 = ((LynxViewPager) r5).getChildren().iterator();
    L6:
        if (r10.hasNext() == false) goto L11;
        LynxBaseUI r11 = r10.next();
        if ((r11 instanceof LynxTabBarView) == false) goto L6;
        if (r11 == null) goto L11;
        this.d.remove(r11);
    L11:
        super.removeView(r5);
    }

    @f0
    public final void setFoldExpanded(ReadableMap r11, Callback r12) {
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        JavaOnlyMap r5 = new JavaOnlyMap();
        r5.put("success", Boolean.FALSE);
        if (r11.hasKey("expanded") == false) goto L18;
        double r10 = r11.getDouble("expanded", -9999.0d);
        if (r10 >= 0.0d) goto L7;
    L17:
        r5.put("msg", "expanded value must be 0~1");
    L19:
        if (r12 == null) goto L22;
        r12.invoke(new Object[]{0, r5});
        return;
    L22:
        return;
    L7:
        if (r10 > 1.0d) goto L17;
        if (r11.hasKey("enableAnimation") == false) goto L12;
        boolean r13 = r11.getBoolean("enableAnimation");
    L13:
        if (r13 == false) goto L15;
        b(r10, -1);
    L16:
        r5.put("success", Boolean.TRUE);
        goto L19
    L15:
        BaseLynxFoldView.i(this, r10, 0, 2);
        goto L16
    L12:
        r13 = true;
        goto L13
    L18:
        r5.put("msg", "no index key");
        goto L19
    }
}

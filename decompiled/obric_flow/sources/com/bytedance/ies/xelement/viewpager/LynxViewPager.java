package com.bytedance.ies.xelement.viewpager;

import android.content.Context;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import bf.g;
import com.bytedance.ies.xelement.viewpager.childitem.LynxViewpagerItem;
import com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager;
import com.bytedance.ies.xelement.viewpager.viewpager.CustomViewPager;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/LynxViewPager;", "Lcom/bytedance/ies/xelement/viewpager/viewpager/BaseLynxViewPager;", "Lcom/bytedance/ies/xelement/viewpager/viewpager/CustomViewPager;", "Lbf/g;", "Lcom/lynx/react/bridge/ReadableMap;", LynxResourceModule.PARAMS_KEY, "Lcom/lynx/react/bridge/Callback;", "callback", "", "selectTab", "(Lcom/lynx/react/bridge/ReadableMap;Lcom/lynx/react/bridge/Callback;)V", "", "isDynamic", "setViewPagerDynamic", "(Z)V", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxViewPager extends BaseLynxViewPager<CustomViewPager, g> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f6519j = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6520i;

    @Override // com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager
    public final void c(LynxViewpagerItem r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "child");
        if (this.f6520i == true) goto L5;
        g r11 = (g) j();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "child");
        r11.f = true;
        r11.f23116h.add(r5);
        return;
    L5:
        if (((g) j()).getMTabLayout() != null) goto L7;
    L11:
        g r12 = (g) j();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r5, "child");
        r12.setMChanged(true);
        r12.getMPendingChildren().add(r10, r5);
        return;
    L7:
        if (((g) j()).getTabLayoutCodeMode() == 0) goto L11;
        g r13 = (g) j();
        int r14 = RangesKt.coerceAtLeast(r10 - 1, 0);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r5, "child");
        r13.setMChanged(true);
        r13.getMPendingChildren().add(r14, r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        g r10 = new g(r5);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f = r10;
        b(r5);
        return (g) j();
    }

    @Override // com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager
    public final void k() {
        ((CustomViewPager) ((g) j()).getMViewPager()).addOnPageChangeListener(new LynxViewPager$initViewPagerChangeListener$1(this));
    }

    @Override // com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager
    @f0
    public void selectTab(ReadableMap r10, Callback r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        JavaOnlyMap r5 = new JavaOnlyMap();
        r5.put("success", Boolean.FALSE);
        int r12 = 0;
        if (r10.hasKey("index") == false) goto L18;
        int r13 = r10.getInt("index");
        if (r13 < 0) goto L14;
        PagerAdapter r14 = ((CustomViewPager) ((g) j()).getMViewPager()).getAdapter();
        if (r14 == null) goto L9;
        r12 = r14.getCount();
    L9:
        if (r13 >= r12) goto L14;
        ((g) j()).setCurrentSelectIndex(r13);
        r5.put("success", Boolean.TRUE);
        if (r11 == null) goto L22;
        r11.invoke(new Object[]{0, r5});
        return;
    L22:
        return;
    L14:
        r5.put("msg", "index out of bounds");
        if (r11 == null) goto L23;
        r11.invoke(new Object[]{0, r5});
        return;
    L23:
        return;
    L18:
        r5.put("msg", "no index key");
        if (r11 == null) goto L24;
        r11.invoke(new Object[]{0, r5});
        return;
    }

    @c0(name = "viewpager-dynamic")
    public final void setViewPagerDynamic(boolean r5) {
        this.f6520i = r5;
    }
}

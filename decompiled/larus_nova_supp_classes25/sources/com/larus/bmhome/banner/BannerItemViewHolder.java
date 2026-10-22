package com.larus.bmhome.banner;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import bb8.g;
import bb8.i;
import bb8.j;
import by7.e;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.business.banner.databinding.LarusItemBannerBinding;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.platform.service.z2;
import com.zhpan.bannerview.indicator.DrawableIndicator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0015H\u0007J\b\u0010\u0017\u001a\u00020\u0015H\u0007J\u0016\u0010\u0018\u001a\u00020\u00152\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001aJ \u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/banner/BannerItemViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/ixigua/lib/track/ITrackNode;", "viewBinding", "Lcom/larus/business/banner/databinding/LarusItemBannerBinding;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "parent", "<init>", "(Lcom/larus/business/banner/databinding/LarusItemBannerBinding;Landroidx/lifecycle/Lifecycle;Lcom/ixigua/lib/track/ITrackNode;)V", "pendingEventBannerShow", "Ljava/lang/Runnable;", "enableBannerOpt", "", "getEnableBannerOpt", "()Z", "enableBannerOpt$delegate", "Lkotlin/Lazy;", "parentTrackNode", "onPause", "", "onResume", "onDestroy", "bindViewHolder", "data", "", "Lcom/larus/bmhome/banner/BannerModel;", "getValidBanner", "banner_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BannerItemViewHolder extends ViewBindingHolder implements LifecycleObserver, e {
    public static final /* synthetic */ int f = 0;
    public final LarusItemBannerBinding a;
    public final Lifecycle b;
    public final e c;
    public Runnable d;
    public final Lazy e;

    public final void fillTrackParams(TrackParams r1) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.a.b.g();
        if (((Boolean) this.e.getValue()).booleanValue() == false) goto L8;
        this.a.b.setBannerAutoPlay(false);
        Lifecycle r0 = this.b;
        if (r0 == null) goto L9;
        r0.removeObserver(this);
        return;
    L9:
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        if (((Boolean) this.e.getValue()).booleanValue() == false) goto L5;
        this.a.b.setBannerAutoPlay(false);
    L5:
        this.a.b.g();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        BannerViewPager r0 = this.a.b;
        r0.setBannerAutoPlay(true);
        r0.f();
        Runnable r1 = this.d;
        if (r1 == null) goto L5;
        r1.run();
    L5:
        this.d = null;
    }

    public final e referrerTrackNode() {
        return e.a.a(this);
    }

    public final e parentTrackNode() {
        return this.c;
    }

    public final void T3(List<i> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        final BannerViewPager r0 = this.a.b;
        final ArrayList r1 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        i r2 = (i) r11.next();
        if (j.a(r2) == true) goto L4;
        r1.add(r2);
        goto L4
    L9:
        if (r0.getAdapter() != null) goto L11;
    L13:
        ((com.zhpan.bannerview.BannerViewPager) r0).i = new BannerAdapter(this, this.b);
        ((com.zhpan.bannerview.BannerViewPager) r0).j = new BannerItemViewHolder$bindViewHolder$1$1(this, r1, r0);
        DrawableIndicator r12 = this.a.c;
        r12.d(2131238534, 2131238533);
        Lifecycle.State r3 = null;
        int r4 = i5.y0(c.b(2130971367, null, 2131167105));
        if (r4 < 0) goto L16;
        r12.g = r4;
        r12.postInvalidate();
    L16:
        r12.l = new DrawableIndicator.a(i5.y0(c.b(2130971501, null, 2131167372)), i5.y0(c.b(2130971480, null, 2131167331)), i5.y0(c.b(2130971501, null, 2131167372)), i5.y0(c.b(2130971480, null, 2131167331)));
        r12.c();
        r12.postInvalidate();
        Lifecycle r13 = this.b;
        if (r13 == null) goto L20;
        r3 = r13.getCurrentState();
    L20:
        if (r3 != Lifecycle.State.RESUMED) goto L22;
        r0.setBannerAutoPlay(true);
    L23:
        ((com.zhpan.bannerview.BannerViewPager) r0).g.a().a = z2.a.m1();
        DrawableIndicator r14 = this.a.c;
        if ((r14 instanceof View) == false) goto L26;
        ((com.zhpan.bannerview.BannerViewPager) r0).b = true;
        ((com.zhpan.bannerview.BannerViewPager) r0).d = r14;
    L26:
        Lifecycle r15 = this.b;
        if (r15 == null) goto L29;
        r15.addObserver(this);
    L29:
        r0.b();
        r0.d(r1);
        return;
    L22:
        r0.setBannerAutoPlay(false);
        goto L23
    L11:
        if (Intrinsics.areEqual(r1, r0.getData()) == false) goto L13;
    }

    public BannerItemViewHolder(LarusItemBannerBinding r2, Lifecycle r3, e r4) {
        Intrinsics.checkNotNullParameter(r2, "viewBinding");
        Intrinsics.checkNotNullParameter(r4, "parent");
        super(r2);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = LazyKt.lazy(new g());
    }
}

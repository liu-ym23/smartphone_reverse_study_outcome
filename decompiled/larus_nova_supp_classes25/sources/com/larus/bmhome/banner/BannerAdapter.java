package com.larus.bmhome.banner;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewbinding.ViewBindings;
import bb8.d;
import bb8.i;
import by7.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.business.banner.databinding.LarusItemBannerSingleBinding;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.t0;
import com.zhpan.bannerview.BaseBannerAdapter;
import com.zhpan.bannerview.BaseViewHolder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u00012B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 2\u0006\u0010\u0005\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J0\u0010&\u001a\u00020\u00192\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020 2\b\u0010(\u001a\u0004\u0018\u00010\u00022\u0006\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020%H\u0014J$\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010#H\u0002J\u0010\u00101\u001a\u00020%2\u0006\u0010$\u001a\u00020%H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016¨\u00063"}, d2 = {"Lcom/larus/bmhome/banner/BannerAdapter;", "Lcom/zhpan/bannerview/BaseBannerAdapter;", "Lcom/larus/bmhome/banner/BannerModel;", "Lcom/ixigua/lib/track/ITrackNode;", "Landroidx/lifecycle/LifecycleEventObserver;", "parent", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "<init>", "(Lcom/ixigua/lib/track/ITrackNode;Landroidx/lifecycle/Lifecycle;)V", "getParent", "()Lcom/ixigua/lib/track/ITrackNode;", "isNeedPlayGif", "", "enableBannerOpt", "getEnableBannerOpt", "()Z", "enableBannerOpt$delegate", "Lkotlin/Lazy;", "delayRefreshTask", "Ljava/lang/Runnable;", "getDelayRefreshTask", "()Ljava/lang/Runnable;", "delayRefreshTask$delegate", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "parentTrackNode", "createViewHolder", "Lcom/zhpan/bannerview/BaseViewHolder;", "Landroid/view/ViewGroup;", "itemView", "Landroid/view/View;", "viewType", "", "bindData", "holder", "data", "position", "pageSize", "handleBannerClickForOpenVideo", "context", "Landroid/content/Context;", "bannerSchema", "", "animateView", "getLayoutId", "Companion", "banner_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BannerAdapter extends BaseBannerAdapter<i> implements e, LifecycleEventObserver {
    public static final int h = 0;
    public static final int i = 0;
    public final e c;
    public final Lifecycle d;
    public boolean e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public final void fillTrackParams(TrackParams r1) {
    }

    public final int getLayoutId(int r1) {
        return 2131562500;
    }

    static {
        int r0 = com.larus.utils.i.d(AppHost.a.getApplication()) - i5.y0(c.b(2130971390, null, 2131167150));
        h = r0;
        i = (r0 * 2) / 5;
    }

    public final e referrerTrackNode() {
        return e.a.a(this);
    }

    public final e parentTrackNode() {
        return this.c;
    }

    public BannerAdapter(e r2, Lifecycle r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        this.c = r2;
        this.d = r3;
        Lazy r4 = LazyKt.lazy(new bb8.c());
        this.f = r4;
        this.g = LazyKt.lazy(new d(this));
        if (((Boolean) r4.getValue()).booleanValue() == false) goto L7;
        if (r3 == null) goto L8;
        r3.addObserver(this);
        return;
    L8:
        return;
    }

    public final void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "event");
        int r5 = b.a[r4.ordinal()];
        if (r5 != 1) goto L5;
        this.e = true;
        t0.a.removeCallbacks((Runnable) this.g.getValue());
        ((Runnable) this.g.getValue()).run();
        return;
    L5:
        if (r5 != 2) goto L7;
        this.e = false;
        t0.a.postDelayed((Runnable) this.g.getValue(), 1000);
        return;
    L7:
        if (r5 != 3) goto L18;
        this.e = false;
        t0.a.removeCallbacks((Runnable) this.g.getValue());
        Lifecycle r6 = this.d;
        if (r6 == null) goto L15;
        r6.removeObserver(this);
        return;
    L15:
        return;
    }

    public final BaseViewHolder z2(ViewGroup r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        SimpleDraweeView r1 = ViewBindings.findChildViewById(r4, 2131363939);
        if (r1 == null) goto L7;
        return new BannerViewBindingViewHolder(new LarusItemBannerSingleBinding((RelativeLayout) r4, r1));
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(2131363939)));
    }

    public final void y2(BaseViewHolder r6, Object r7, final int r8) {
        final i r9 = (i) r7;
        Intrinsics.checkNotNullParameter(r6, "holder");
        if ((r6 instanceof BannerViewBindingViewHolder) == false) goto L10;
        BannerViewBindingViewHolder r10 = (BannerViewBindingViewHolder) r6;
        final SimpleDraweeView r0 = r10.a.b;
        if (r9 == null) goto L7;
        String r1 = r9.b();
    L8:
        ImageLoaderKt.y(r0, r1, "notification.banner", new bb8.a(r0, this), 4);
        r10.a.b.setOnClickListener(new bb8.b(this, r0, r9, r8));
        return;
    L7:
        r1 = null;
        goto L8
    }
}

package com.ss.android.lark.feed.shared.page.binder2;

import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractSwipeableItemViewHolder;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.ActionScene;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ com.ss.android.lark.feed.export.feedcard.d a;
    public final /* synthetic */ UIFeedCard b;
    public final /* synthetic */ FeedCommonViewHolder c;

    public d(yeb.a r1, UIFeedCard r2, FeedCommonViewHolder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        FragmentActivity r0 = this.a.getHost().getActivity();
        peb.b.f r1 = com.ss.android.lark.feed.shared.fg.c.a;
        if (r0 == null) goto L10;
        int r3 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.ux_optimization") == false) goto L10;
        if (ForsetiConfig.a(r0) == false) goto L10;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L20;
        if (com.ss.android.lark.feed.shared.fg.c.b(this.a.getHost().getActivity()) == false) goto L20;
        if (Intrinsics.areEqual(jeb.b.a().q3(), this.b.getId()) == false) goto L20;
        Log.i("FeedSharedModule_FeedCommonViewHolder", "click same feed, skip click event");
        return;
    L20:
        if (com.ss.android.lark.feed.shared.fg.c.c() == true) goto L22;
    L24:
        FeedCommonViewHolder r4 = this.c;
        UIFeedCard r5 = this.b;
        n r6 = FeedCommonViewHolder.M;
        if (((AbstractSwipeableItemViewHolder) r4).e != 0.0f) goto L27;
        boolean r7 = true;
    L28:
        if (r7 == true) goto L30;
    L34:
        r5.setSwipedLeftPinned(false);
        r5.setSwipeRightPinned(false);
        int r8 = r4.getBindingAdapterPosition();
        if (r8 < 0) goto L39;
        RecyclerView.Adapter r9 = r4.getBindingAdapter();
        if (r9 == null) goto L40;
        r9.notifyItemChanged(r8);
    L40:
        this.c.s.setHovered(false);
        long r10 = SystemClock.uptimeMillis();
        FeedCommonViewHolder r12 = this.c;
        if ((r10 - r12.o) >= r12.p) goto L44;
        Log.i("FeedSharedModule_FeedCommonViewHolder", "click had been throttle");
        return;
    L44:
        r12.o = r10;
        Log.i("FeedSharedModule_FeedCommonViewHolder", "onItemClick: " + this.b.getId());
        com.ss.android.lark.feed.shared.hitpoint.a.a(this.b.getId());
        aeb.f r13 = this.c.z;
        if (r13 == null) goto L47;
        UIFeedCard r14 = this.b;
        Intrinsics.checkNotNull(r11);
        r13.j(r14, r11, this.c.getBindingAdapterPosition(), ActionScene.FEED);
    L47:
        com.ss.android.lark.feed.shared.hitpoint.b.a(this.b, null);
        this.c.s.setSelected(true);
        FeedCommonViewHolder r15 = this.c;
        com.ss.android.lark.feed.export.feedcard.d r16 = this.a;
        UIFeedCard r17 = this.b;
        Job r18 = r15.C;
        if (r18 == null) goto L50;
        Job.DefaultImpls.cancel$default(r18, null, 1, null);
    L50:
        r15.C = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r16.getHost()), null, null, new FeedCommonViewHolder$delayUpdate$1(r15, r16, r17, null), 3, null);
        return;
    L39:
        r4.s.animate().translationX(0.0f).setDuration(300).withEndAction(new j(r4)).start();
        goto L40
    L30:
        if (r5.isSwipedLeftPinned() == true) goto L34;
        if (r5.isSwipeRightPinned() == true) goto L34;
    L27:
        r7 = false;
        goto L28
    L22:
        if (this.b.getType() == FeedCard.Type.APP) goto L24;
        jeb.b.a().k4(this.b.getId());
    L10:
        r2 = false;
        goto L12
    }
}

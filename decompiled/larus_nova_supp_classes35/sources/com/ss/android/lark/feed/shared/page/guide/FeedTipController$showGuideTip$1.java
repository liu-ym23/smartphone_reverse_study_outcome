package com.ss.android.lark.feed.shared.page.guide;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.guide.ui.config.AnchorConfig;
import com.ss.android.lark.guide.ui.config.MaskConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ujb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class FeedTipController$showGuideTip$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ View $anchorView;
    final /* synthetic */ FeedTipGuideHelper$GuideType $guideType;
    final /* synthetic */ UIFeedCard.AtInfo $info;
    final /* synthetic */ a.InterfaceC0205a $listener;

    public FeedTipController$showGuideTip$1(View r1, Activity r2, UIFeedCard.AtInfo r3, FeedTipGuideHelper$GuideType r4, a.InterfaceC0205a r5) {
        this.$anchorView = r1;
        this.$activity = r2;
        this.$info = r3;
        this.$guideType = r4;
        this.$listener = r5;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1228invoke() {
        int r0 = a.a;
        View r1 = this.$anchorView;
        Activity r2 = this.$activity;
        UIFeedCard.AtInfo r3 = this.$info;
        FeedTipGuideHelper$GuideType r4 = this.$guideType;
        a.InterfaceC0205a r5 = this.$listener;
        int r6 = a.b.a[r4.ordinal()];
        if (r6 == 1) goto L11;
        if (r6 != 2) goto L6;
        a.a(r1, r2, r3, true, r5);
        return;
    L6:
        if (r6 != 3) goto L9;
        a.a(r1, r2, r3, false, r5);
        return;
    L9:
        throw new NoWhenBranchMatchedException();
    L11:
        if (r1 == null) goto L15;
        if (r2 == null) goto L15;
        int[] r7 = new int[2];
        r1.getLocationInWindow(r7);
        int r8 = r7[0];
        Rect r9 = new Rect(r8, r7[1], r1.getMeasuredWidth() + r8, r7[1] + r1.getMeasuredHeight());
        AnchorConfig r10 = new AnchorConfig(r1, AnchorConfig.AnchorGravity.TOP);
        MaskConfig r11 = new MaskConfig(MaskConfig.ShapeType.CIRCLE, r9, null, 50);
        d r12 = new d(UIUtils.getString(r1.getContext(), 2131891829), new c(r5));
        String r13 = UIUtils.getString(r1.getContext(), 2131892708);
        Intrinsics.checkNotNull(r13);
        ujb.c r14 = new ujb.c(r10, r11, r13, r12);
        int r15 = qjb.a.a;
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r14, "config");
        new tjb.c(new WeakReference(r2), r14).o();
        heb.a.a.getGuideDependency().c();
        return;
    L15:
        if (r5 == null) goto L21;
        r5.onClose();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1228invoke();
        return Unit.INSTANCE;
    }
}

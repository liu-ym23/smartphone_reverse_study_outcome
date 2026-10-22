package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickGroupMostlyUsedItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftGroupItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftGroupMostlyUsedInfo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowGiftMostlyUsedStateChangeToast;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o extends BaseMVIListItem<GiftGroupItem, GiftAction> {
    public final TextView l;
    public final ImageView m;
    public boolean n;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ o a;

        public a(o r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            o r4 = this.a;
            r4.o(new ClickGroupMostlyUsedItem(r4.n));
        }
    }

    public o(View r2) {
        Intrinsics.checkNotNullParameter(r2, "inflateView");
        super(r2, new GiftGroupItem());
        this.l = (TextView) ((BaseMVIListItem) this).j.findViewById(2131373718);
        this.m = (ImageView) ((BaseMVIListItem) this).j.findViewById(2131376377);
        ((BaseMVIListItem) this).j.setOnClickListener(new a(this));
    }

    public final boolean d(com.bytedance.android.anya.a0 r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        if ((r3 instanceof ShowGiftMostlyUsedStateChangeToast) == true) goto L5;
        return false;
    L5:
        if (((ShowGiftMostlyUsedStateChangeToast) r3).isMostlyUsed() == false) goto L7;
        String r4 = "添加成功，礼物已放入\"常用\"";
    L8:
        f2.c(r4, 0);
        return true;
    L7:
        r4 = "已移除添加";
        goto L8
    }

    public final void b(com.bytedance.android.anya.k r2, MVIState r3) {
        GiftGroupItem r4 = (GiftGroupItem) r3;
        Intrinsics.checkNotNullParameter(r2, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r4, "state");
        r0<GiftGroupItem, GiftGroupMostlyUsedInfo> r5 = r4.getMostlyUsedInfo();
        Object r0 = r2.c.a(r5);
        if (r0 == null) goto L20;
        r2.b.a.invoke(r5);
        GiftGroupMostlyUsedInfo r1 = (GiftGroupMostlyUsedInfo) r0;
        if (r1.getShow() == false) goto L21;
        this.n = r1.isCurMostlyUsed();
        TextView r6 = this.l;
        if (r1.isCurMostlyUsed() == false) goto L9;
        String r7 = "移除常用";
    L10:
        r6.setText(r7);
        if (r1.isLoading() == true) goto L18;
        this.l.setVisibility(0);
        this.m.clearAnimation();
        this.m.setVisibility(8);
        return;
    L18:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L14
        this.l.setVisibility(8);     // Catch: Throwable -> L14
        this.m.setVisibility(0);     // Catch: Throwable -> L14
        this.m.startAnimation(AnimationUtils.loadAnimation(s1.getContext(), 2130772712));     // Catch: Throwable -> L14
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L9:
        r7 = "添加常用";
        goto L10
    L21:
        return;
    }
}

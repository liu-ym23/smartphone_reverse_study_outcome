package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.broadcastgame.opengame.message.m0;
import com.bytedance.android.live.core.gift.IGiftCoreService;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.common.utility.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/RewardItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/live/broadcastgame/opengame/view/g;", "Lcom/bytedance/android/live/broadcastgame/opengame/message/m0;", "reward", "", "setReward", "Landroid/view/View;", "b", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "Lkotlin/Function0;", "c", "Lkotlin/jvm/functions/Function0;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "onClick", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RewardItemView extends ConstraintLayout implements g {
    public Map<Integer, View> a;
    public final View b;
    public final Function0<Unit> c;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.view.RewardItemView$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m358invoke() {
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m358invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ RewardItemView a;
        public final /* synthetic */ m0 b;

        public b(RewardItemView r1, m0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
            Logger.d("PayFlowView", "RewardItemView, click, jump to gift bag, reward=" + this.b);
        L5:
            ((IGiftCoreService) jc1.k.n(IGiftCoreService.class)).openGiftDialog(5, this.b.d, "0", null, null);
            this.a.getOnClick().invoke();
        }
    }

    static {
    }

    public final View getItemView() {
        return this.b;
    }

    public final Function0<Unit> getOnClick() {
        return this.c;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.g
    public final void j(Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "endAction");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        Logger.d("PayFlowView", "RewardItemView, fadeIn, " + this);
    L5:
        z.a(this.b, 250, 0.0f, r5);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.g
    public final void k(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onHide");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        Logger.d("PayFlowView", "RewardItemView, slideOut, " + this);
    L5:
        z.f(this.b, r3);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.g
    public final void o(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "endAction");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        Logger.d("PayFlowView", "RewardItemView, slideIn, " + this);
    L5:
        z.e(this.b, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.broadcastgame.opengame.view.g
    public void setReward(m0 r5) {
        Intrinsics.checkNotNullParameter(r5, "reward");
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = (View) ((LinkedHashMap) this.a).get(2131379959);
        if (r0 != null) goto L11;
        r0 = findViewById(2131379959);
        if (r0 == null) goto L10;
        this.a.put(2131379959, r0);
        goto L11
    L10:
        r0 = null;
    L11:
        ((TextView) r0).setText(s1.C(2131917062, new Object[]{r5.g, Integer.valueOf(r5.f), r3.c(), Integer.valueOf(r5.e)}));
        setOnClickListener(new b(this, r5));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.g
    public final void x(Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "onHide");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        Logger.d("PayFlowView", "RewardItemView, fadeOut, " + this);
    L5:
        z.c(this.b, 250, 0.0f, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RewardItemView(Context r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onClick");
        super(r2);
        this.c = r3;
        this.a = new LinkedHashMap();
        this.b = View.inflate(r2, 2131567096, this);
    }
}

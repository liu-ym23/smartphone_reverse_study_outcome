package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.model.h0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.LiveGiftGroupComboViewNew;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickGiftGroupItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftGroupItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.GroupWaveAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s extends BaseMVIListItem<GiftGroupItem, GiftAction> {
    public final View l;
    public final TextView m;
    public final TextView n;
    public final LiveGiftGroupComboViewNew o;
    public boolean p;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ s a;

        public a(s r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            s r4 = this.a;
            r4.o(new ClickGiftGroupItem(r4.p()));
        }
    }

    public static final class b {
    }

    static {
    }

    public s(View r2) {
        Intrinsics.checkNotNullParameter(r2, "inflateView");
        super(r2, new GiftGroupItem());
        this.l = ((BaseMVIListItem) this).j.findViewById(2131373711);
        this.m = (TextView) ((BaseMVIListItem) this).j.findViewById(2131373714);
        this.n = (TextView) ((BaseMVIListItem) this).j.findViewById(2131373719);
        this.o = (LiveGiftGroupComboViewNew) ((BaseMVIListItem) this).j.findViewById(2131373712);
        new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel.e();
        ((BaseMVIListItem) this).j.setOnClickListener(new a(this));
    }

    public final void b(com.bytedance.android.anya.k r9, MVIState r10) {
        GiftGroupItem r11 = (GiftGroupItem) r10;
        Intrinsics.checkNotNullParameter(r9, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r11, "state");
        r0<GiftGroupItem, h0> r0 = r11.getGroupInfo();
        Object r1 = r9.c.a(r0);
        Object r3 = null;
        if (r1 == null) goto L18;
        r9.b.a.invoke(r0);
        h0 r2 = (h0) r1;
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        ((BaseMVIListItem) this).j.setAlpha(0.4f);
        this.m.setText(((BaseMVIListItem) this).j.getContext().getString(2131919141, new Object[]{Integer.valueOf(r2.getGroupCount())}));
        boolean r4 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r2.getGroupText());
        this.p = r4;
        if (r4 == false) goto L7;
        this.n.setVisibility(0);
        this.n.setText(r2.getGroupText());
    L8:
        ViewGroup.LayoutParams r5 = this.m.getLayoutParams();
        if ((r5 instanceof ConstraintLayout.LayoutParams) == true) goto L11;
        r5 = null;
    L11:
        ConstraintLayout.LayoutParams r6 = (ConstraintLayout.LayoutParams) r5;
        if (r6 == null) goto L18;
        r6.topToTop = 0;
        if (this.p == false) goto L16;
        int r7 = -1;
    L17:
        r6.bottomToBottom = r7;
        goto L18
    L16:
        r7 = 0;
        goto L17
    L7:
        this.n.setVisibility(8);
    L18:
        r0<GiftGroupItem, Integer> r13 = r11.getComboCount();
        Object r8 = r9.c.a(r13);
        if (r8 == null) goto L40;
        r9.b.a.invoke(r13);
        if (((Number) r8).intValue() != 0) goto L31;
        LiveGiftGroupComboViewNew r14 = this.o;
        r14.a();
        LottieAnimationView r15 = r14.e;
        if (r15 == null) goto L25;
        r15.cancelAnimation();
    L25:
        GroupWaveAnimationView r16 = r14.f;
        if (r16 == null) goto L28;
        r16.removeAllViews();
    L28:
        r14.b = 0;
        this.o.setVisibility(8);
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        ((BaseMVIListItem) this).j.setAlpha(1.0f);
        if (this.p == false) goto L41;
        this.n.setVisibility(0);
        return;
    L41:
        return;
    L31:
        Object r17 = ((BaseMVIListItem) this).j.getContext().getSystemService("vibrator");
        if ((r17 instanceof Vibrator) == false) goto L35;
        r3 = r17;
    L35:
        Vibrator r18 = (Vibrator) r3;
        if (r18 == null) goto L38;
        r18.vibrate(50);
    L38:
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        this.o.setVisibility(0);
        this.n.setVisibility(8);
        ((BaseMVIListItem) this).j.setAlpha(1.0f);
        this.o.b(new t(this, p()));
        return;
    }
}

package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickBuffCard;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftBuffCardItem;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends BaseMVIListItem<GiftBuffCardItem, GiftAction> {
    public final TextView l;
    public final HSImageView m;
    public final HSImageView n;
    public final TextView o;
    public final HSImageView p;
    public final ImageView q;
    public Disposable r;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            i r4 = this.a;
            r4.o(new ClickBuffCard(r4.p()));
        }
    }

    public final void i() {
        Disposable r0 = this.r;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public i(View r2) {
        Intrinsics.checkNotNullParameter(r2, "inflateView");
        super(r2, new GiftBuffCardItem());
        this.l = (TextView) ((BaseMVIListItem) this).j.findViewById(2131364938);
        this.m = ((BaseMVIListItem) this).j.findViewById(2131385851);
        this.n = ((BaseMVIListItem) this).j.findViewById(2131373669);
        this.o = (TextView) ((BaseMVIListItem) this).j.findViewById(2131364943);
        this.p = ((BaseMVIListItem) this).j.findViewById(2131364942);
        this.q = (ImageView) ((BaseMVIListItem) this).j.findViewById(2131364940);
        ((BaseMVIListItem) this).j.setOnClickListener(new a(this));
    }

    public final void b(com.bytedance.android.anya.k r13, MVIState r14) {
        GiftBuffCardItem r15 = (GiftBuffCardItem) r14;
        Intrinsics.checkNotNullParameter(r13, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r15, "state");
        r0<GiftBuffCardItem, Boolean> r0 = r15.getSelected();
        Object r1 = r13.c.a(r0);
        if (r1 == null) goto L8;
        r13.b.a.invoke(r0);
        if (((Boolean) r1).booleanValue() == false) goto L7;
        ViewUtilsKt.f(this.m);
        this.p.setVisibility(8);
        goto L8
    L7:
        ViewUtilsKt.e(this.m);
    L8:
        r0<GiftBuffCardItem, l1> r2 = r15.getBuffInfo();
        Object r3 = r13.c.a(r2);
        if (r3 == null) goto L36;
        r13.b.a.invoke(r2);
        l1 r4 = (l1) r3;
        ImageLoader.bindImage(this.n, r4.getBgImg());
        com.bytedance.android.livesdk.gift.model.i r5 = r4.getLockInfo();
        if (r5 == null) goto L15;
        if (r5.getLocked() != true) goto L15;
    L17:
        this.p.setVisibility(8);
    L18:
        String r6 = r4.getText();
        this.l.setText(r6);
        if (TextUtils.isEmpty(r6) == true) goto L21;
        this.l.setTextColor(ColorProtector.parseColor(r4.getTextColor()));
    L21:
        View r7 = ((BaseMVIListItem) this).j;
        com.bytedance.android.livesdk.gift.model.i r8 = r4.getLockInfo();
        if (r8 != null) goto L24;
    L27:
        float r9 = 1.0f;
    L28:
        r7.setAlpha(r9);
        ImageView r10 = this.q;
        com.bytedance.android.livesdk.gift.model.i r11 = r4.getLockInfo();
        if (r11 != null) goto L31;
    L34:
        int r16 = 8;
    L35:
        r10.setVisibility(r16);
        goto L36
    L31:
        if (r11.getLocked() != true) goto L34;
        r16 = 0;
        goto L35
    L24:
        if (r8.getLocked() != true) goto L27;
        r9 = 0.5f;
    L15:
        if (r4.getSweepLightImg() == null) goto L17;
        ImageLoader.bindImage(this.p, r4.getSweepLightImg());
    L36:
        r0<GiftBuffCardItem, Pair<Long, Long>> r17 = r15.getExpireTime();
        Object r18 = r13.c.a(r17);
        if (r18 == null) goto L50;
        r13.b.a.invoke(r17);
        Pair r19 = (Pair) r18;
        long r20 = ((Number) r19.getFirst()).longValue();
        long r110 = (r20 - System.currentTimeMillis()) - ((Number) r19.getSecond()).longValue();
        if (r20 != 0) goto L41;
        this.o.setVisibility(8);
    L43:
        if (r110 >= 0) goto L45;
        String r21 = s1.B(2131917093);
    L49:
        this.o.setText(r21);
        goto L50
    L45:
        long r23 = u0.j.a;
        if (r110 >= r23) goto L48;
        r21 = s1.C(2131917095, new Object[]{Integer.valueOf((int) (r110 / u0.i.a))});
        goto L49
    L48:
        r21 = s1.C(2131917094, new Object[]{Integer.valueOf((int) (r110 / r23))});
        goto L49
    L41:
        this.o.setVisibility(0);
    L50:
        r0<GiftBuffCardItem, Boolean> r111 = r15.getShowAnim();
        Object r24 = r13.c.a(r111);
        if (r24 == null) goto L60;
        r13.b.a.invoke(r111);
        if (((Boolean) r24).booleanValue() == false) goto L61;
        Disposable r112 = this.r;
        if (r112 == null) goto L58;
        r112.dispose();
    L58:
        ObjectAnimator r113 = ObjectAnimator.ofFloat(this.p, "translationX", new float[]{s1.f(-74.0f), s1.f(171.0f)});
        Ref.IntRef r114 = new Ref.IntRef();
        r114.element = 0;
        r113.setDuration(700);
        r113.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        this.p.setVisibility(0);
        com.bytedance.android.live.core.utils.rxutils.j.a r25 = com.bytedance.android.live.core.utils.rxutils.j.a;
        this.r = com.bytedance.android.live.core.utils.rxutils.j.a(0, 500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this, r114, r113));
        r113.start();
        return;
    L61:
        return;
    }
}

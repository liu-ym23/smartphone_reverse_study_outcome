package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.NitaInflateUtil;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftLabelTextView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.LiveSendGiftAnimationView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowProbCountErrorTipsEffect;
import com.bytedance.android.livesdk.gift.platform.core.utils.GiftPanelNitaViewInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class f0 extends BasePanelViewHolderItem {
    public final TextView e0;

    public static final class a implements p0 {
        public final /* synthetic */ f0 a;

        public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
        }

        public final /* synthetic */ void d(ImageInfo r1) {
        }

        public final /* synthetic */ void e(py.k r1) {
        }

        public a(f0 r1) {
            this.a = r1;
        }

        public final void b(py.k r1, Exception r2) {
            this.a.s.setVisibility(8);
        }

        public final void c(py.k r1, int r2, int r3, boolean r4) {
            ViewGroup.LayoutParams r5 = this.a.s.getLayoutParams();
            r5.width = (int) (r5.height * (r2 / r3));
            this.a.s.setLayoutParams(r5);
            this.a.s.setVisibility(0);
        }
    }

    public final void F(ItemStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
        if (e0.a[r2.ordinal()] == 1) goto L5;
        this.e0.setVisibility(0);
        return;
    L5:
        this.e0.setVisibility(8);
    }

    public void G(vz1.e r13) {
        Intrinsics.checkNotNullParameter(r13, "dialogIconModel");
        boolean r2 = true;
        boolean r5 = false;
        this.e0.setText(((BaseMVIListItem) this).j.getContext().getString(2131919154, new Object[]{Integer.valueOf(r13.g.b)}));
        this.e0.setVisibility(0);
        long r0 = r13.g.d;
        if (r0 <= 0) goto L15;
        long r1 = r0 - ((System.currentTimeMillis() / 1000) + r13.g.e);
        if (r1 > 0) goto L7;
        this.A.setAlpha(this.l);
    L8:
        GiftLabelTextView r3 = this.z;
        vz1.h r4 = r13.g;
        long r6 = r4.d;
        long r8 = r4.e;
        r3.getClass();
        long r10 = u0.g.a;
        r3.z(r6 * r10, r8 * r10);
        this.z.setVisibility(0);
        if (r1 >= TimeUnit.DAYS.toSeconds(1)) goto L12;
        this.z.setBackground(s1.m(2131249167));
    L14:
        r5 = r2;
    L16:
        vz1.h r14 = r13.g;
        if (r14.b <= 0) goto L19;
    L20:
        if (r5 == false) goto L22;
    L21:
        this.A.setAlpha(this.l);
        return;
    L22:
        this.A.setAlpha(this.m);
        return;
    L19:
        if (r14.f != 4) goto L21;
    L12:
        if (((Boolean) nz1.a.K.getValue(null, nz1.a.a[35])).booleanValue() == false) goto L14;
        this.z.setBackground(s1.m(2131249170));
        goto L14
    L7:
        r2 = false;
        goto L8
    L15:
        this.z.setVisibility(8);
        goto L16
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.BasePanelViewHolderItem
    public final boolean d(com.bytedance.android.anya.a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        if ((r2 instanceof ShowProbCountErrorTipsEffect) == false) goto L7;
        ToastUtil.a(2131919787, 0);
        return true;
    L7:
        return super.d(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.BasePanelViewHolderItem
    public final String t(vz1.e r2) {
        Intrinsics.checkNotNullParameter(r2, "dialogIconModel");
        if (r2.e == false) goto L17;
        String r0 = r2.g.c;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L17;
        String r3 = r2.g.c;
        if (r3 != null) goto L18;
        return BuildConfig.FLAVOR;
    L18:
        return r3;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
    L17:
        return super.t(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.BasePanelViewHolderItem
    public final void w(py.k r5) {
        if (r5 == null) goto L4;
        this.s.setVisibility(0);
        HSImageView r0 = this.s;
        ImageLoader.bindImage(r0, r5, r0.getWidth(), this.s.getHeight(), new a(this));
        return;
    L4:
        this.s.setVisibility(8);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.BasePanelViewHolderItem
    public void v(com.bytedance.android.anya.k<ItemListData> r9, ItemListData r10) {
        Intrinsics.checkNotNullParameter(r9, "$this$handleUIDiff");
        Intrinsics.checkNotNullParameter(r10, "state");
        r0<ItemListData, vz1.e> r0 = r10.getItemData();
        Object r1 = r9.c.a(r0);
        if (r1 == null) goto L22;
        r9.b.a.invoke(r0);
        vz1.e r2 = (vz1.e) r1;
        G(r2);
        vz1.h r3 = r2.g;
        if (r3 != null) goto L7;
    L13:
        if (r3 == null) goto L22;
        if (r3.f != 5) goto L22;
        s().g(s1.getResources().getString(2131923014));
        qz1.s r4 = s();
        SpannableString r5 = new SpannableString(s1.getResources().getString(2131923014));
        if (r4.a == false) goto L21;
        LiveSendGiftAnimationView r6 = r4.b;
        if (r6 == null) goto L21;
        r6.setSendText(r5);
    L21:
        r4.e = r5;
        s().e(r2.g.i);
        this.u.setText(r2.g.i);
        goto L22
    L7:
        if (r3.f != 4) goto L13;
        s1.getResources().getColor(2131106882);
        if (r2.g.b > 0) goto L11;
        String r7 = s1.getResources().getString(2131922975);
        int r8 = s1.getResources().getColor(2131108107);
        this.u.setAlpha(1.0f);
    L12:
        this.u.setText(r7);
        this.u.setTextColor(r8);
        s().g(s1.getResources().getString(2131923014));
        goto L22
    L11:
        r8 = s1.getResources().getColor(2131106882);
        r7 = BuildConfig.FLAVOR;
    L22:
        r0<ItemListData, ItemStatus> r11 = r10.getItemStatus();
        Object r13 = r9.c.a(r11);
        if (r13 == null) goto L26;
        r9.b.a.invoke(r11);
        F((ItemStatus) r13);
        return;
    }

    public f0(ViewGroup r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        if (com.bytedance.android.livesdk.gift.platform.core.a0.e().L3() == false) goto L9;
        GiftPanelNitaViewInfo r0 = GiftPanelNitaViewInfo.TTLIVE_BASE_PROP_VIEW_HOLDER_NEW_VERTICAL;
        int r2 = r0.getResId();
        String r1 = r0.getTag();
        Context r3 = r8.getContext();
        if (r3 == null) goto L8;
        View r4 = NitaInflateUtil.a(r2, r1, (Activity) r3, r8, false);
    L10:
        super(r8, r4, r9, r10, 16);
        this.e0 = (TextView) ((BaseMVIListItem) this).j.findViewById(2131383398);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L9:
        r4 = LayoutInflater.from(r8.getContext()).inflate(2131565263, r8, false);
        goto L10
    }
}

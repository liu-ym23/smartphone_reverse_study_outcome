package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/TogetherComboView;", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/NormalGiftCombViewV2;", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/model/NormalGiftMessage;", "msg", BuildConfig.FLAVOR, "setDuration", "Luu0/b;", "H0", "Luu0/b;", "getPreviewData", "()Luu0/b;", "previewData", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TogetherComboView extends NormalGiftCombViewV2 {
    public final uu0.b H0;
    public Map<Integer, View> k0;
    public final boolean p0;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ TogetherComboView a;
        public final /* synthetic */ NormalGiftMessage b;

        public a(TogetherComboView r1, NormalGiftMessage r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            s02.c r4 = this.a.getClickListener();
            if (r4 == null) goto L9;
            NormalGiftMessage r0 = this.b;
            String r1 = ((com.bytedance.android.livesdk.gift.platform.business.tray.l) r0).T;
            if (r1 != null) goto L7;
            r1 = BuildConfig.FLAVOR;
        L7:
            r4.d(r1, r0);
            return;
        }
    }

    public TogetherComboView(Context r7) {
        this(r7, null, 0, false, 30);
    }

    public TogetherComboView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, false, 28);
    }

    public TogetherComboView(Context r7, AttributeSet r8, int r9) {
        this(r7, r8, r9, false, 24);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2
    public uu0.b getPreviewData() {
        return this.H0;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2
    public final void C(NormalGiftMessage r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        if ((r3 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.l) == true) goto L6;
        super.C(r3);
        return;
    L6:
        D(((com.bytedance.android.livesdk.gift.platform.business.tray.l) r3).o, true, new NormalGiftCombViewV2$bindNormalIconImage$1(this));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2
    public final void E(NormalGiftMessage r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        if ((r4 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.l) == false) goto L19;
        com.bytedance.android.livesdk.gift.platform.business.tray.l r0 = (com.bytedance.android.livesdk.gift.platform.business.tray.l) r4;
        py.k r1 = r0.Z;
        if (r1 == null) goto L19;
        if (Lists.isEmpty(r1.getUrls()) == true) goto L19;
        py.k r2 = r0.Z;
        if (r2 == null) goto L13;
        List r3 = r2.getUrls();
        if (r3 == null) goto L13;
        String r5 = (String) ListProtector.get(r3, 0);
    L15:
        if (TextUtils.isEmpty(r5) == true) goto L19;
        x((ImageView) o(2131380985), r0.Z, false);
        return;
    L13:
        r5 = null;
    L19:
        super.E(r4);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2
    public final void F(NormalGiftMessage r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        if ((r3 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.l) == true) goto L6;
        super.F(r3);
        return;
    L6:
        LinearLayout r0 = (LinearLayout) o(2131373930);
        if (r0 == null) goto L9;
        r0.setVisibility(8);
    L9:
        LinearLayout r1 = (LinearLayout) o(2131367231);
        if (r1 == null) goto L12;
        r1.setVisibility(0);
    L12:
        TextView r2 = (TextView) o(2131367236);
        if (r2 == null) goto L16;
        r2.setText(String.valueOf(((com.bytedance.android.livesdk.gift.platform.business.tray.l) r3).Y));
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2
    public final void G(NormalGiftMessage r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        if ((r3 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.l) == true) goto L6;
        super.G(r3);
        return;
    L6:
        TextView r0 = (TextView) o(2131392055);
        if (r0 == null) goto L9;
        r0.setText(((com.bytedance.android.livesdk.gift.platform.business.tray.l) r3).V);
    L9:
        TextView r1 = (TextView) o(2131373680);
        if (r1 == null) goto L12;
        r1.setText(((com.bytedance.android.livesdk.gift.platform.business.tray.l) r3).W);
    L12:
        u();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2
    public final void H(NormalGiftMessage r8) {
        Intrinsics.checkNotNullParameter(r8, "msg");
        if ((r8 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.l) == true) goto L6;
        super.H(r8);
        return;
    L6:
        HSImageView r0 = o(2131376022);
        if (r0 == null) goto L9;
        r0.setVisibility(8);
    L9:
        HSImageView r1 = o(2131391999);
        if (r1 == null) goto L12;
        r1.setVisibility(8);
    L12:
        com.bytedance.android.livesdk.gift.platform.business.tray.l r2 = (com.bytedance.android.livesdk.gift.platform.business.tray.l) r8;
        if (r2.U == null) goto L15;
        boolean r3 = true;
    L17:
        if (r3 == false) goto L35;
        ImageView r4 = (ImageView) o(2131392002);
        if (r4 == null) goto L21;
        r4.setVisibility(4);
    L21:
        ConstraintLayout r5 = o(2131380461);
        if (r5 == null) goto L24;
        r5.setVisibility(0);
    L24:
        py.k r6 = r2.S;
        if (r6 == null) goto L27;
        x((ImageView) o(2131380462), r6, true);
    L27:
        py.k r7 = r2.U;
        if (r7 == null) goto L31;
        ImageView r9 = (ImageView) o(2131380460);
        a1.k(r7).compose(RxUtil.rxSchedulerHelper()).subscribe(new k(this, r9));
    L31:
        if (this.p0 == true) goto L45;
        ConstraintLayout r10 = o(2131380461);
        if (r10 == null) goto L46;
        r10.setOnClickListener(new a(this, r8));
        return;
    L46:
        return;
    L45:
        return;
    L35:
        ImageView r11 = (ImageView) o(2131392002);
        if (r11 == null) goto L38;
        r11.setVisibility(0);
    L38:
        ConstraintLayout r13 = o(2131380461);
        if (r13 == null) goto L41;
        r13.setVisibility(8);
    L41:
        py.k r14 = r2.S;
        if (r14 == null) goto L48;
        x((ImageView) o(2131392002), r14, true);
        return;
    L48:
        return;
    L15:
        r3 = false;
        goto L17
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2
    public final View o(int r3) {
        if (this.k0 != null) goto L5;
        this.k0 = new LinkedHashMap();
    L5:
        View r0 = this.k0.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.k0.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2
    public void setDuration(NormalGiftMessage r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        if ((r3 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.l) == true) goto L6;
        super.setDuration(r3);
        return;
    L6:
        setDuration(((com.bytedance.android.livesdk.gift.platform.business.tray.l) r3).X);
    }

    public TogetherComboView(Context r7, AttributeSet r8, int r9, boolean r10, int r11) {
        if ((r11 & 2) == 0) goto L5;
        r8 = null;
    L5:
        AttributeSet r2 = r8;
        if ((r11 & 4) == 0) goto L8;
        int r3 = 0;
    L10:
        if ((r11 & 8) == 0) goto L12;
        r10 = false;
    L12:
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r2, r3, r10, null);
        this.p0 = r10;
        this.H0 = null;
        this.k0 = new LinkedHashMap();
        return;
    L8:
        r3 = r9;
        goto L10
    }
}

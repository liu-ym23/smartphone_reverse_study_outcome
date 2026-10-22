package com.ss.android.lark.officesdk.minutes.ui.style.provider;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.framework.utils.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class o extends e {
    public o() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable a(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r8, "context");
        int r0 = zvb.a.b;
        return zvb.a.C0209a.c(r8, 2131102029, Integer.valueOf(jwb.a.a(r8)), null, null, 52);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable b(Context r13) {
        Intrinsics.checkNotNullParameter(r13, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r13, "context");
        StateListDrawable r0 = new StateListDrawable();
        int r2 = zvb.a.b;
        GradientDrawable r3 = zvb.a.C0209a.c(r13, 2131102041, null, null, null, 60);
        Intrinsics.checkNotNullParameter(r3, "drawable");
        r0.addState(new int[]{R.attr.state_pressed}, r3);
        GradientDrawable r14 = zvb.a.C0209a.c(r13, 2131102030, null, null, null, 60);
        Intrinsics.checkNotNullParameter(r14, "drawable");
        r0.addState(new int[0], r14);
        return r0;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable c(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r6, "context");
        return new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{UIUtils.getColor(r6, 2131106784), UIUtils.getColor(r6, 2131102022)});
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable d(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r8, "context");
        int r0 = zvb.a.b;
        GradientDrawable r2 = zvb.a.C0209a.c(r8, 2131100557, 8, null, null, 52);
        if ((r2 instanceof GradientDrawable) == false) goto L5;
        GradientDrawable r3 = r2;
    L6:
        if (r3 == null) goto L8;
        r3.setStroke(UIUtils.dp2px(r8, 1.0f), UIUtils.getColor(r8, 2131103351));
    L8:
        return r2;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable e(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r6, "context");
        return new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{UIUtils.getColor(r6, 2131108700), UIUtils.getColor(r6, 2131100557)});
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable f(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        zvb.a r0 = new zvb.a();
        r0.a.setShape(1);
        r0.c(r4, 2131102042, null);
        r0.b(Integer.valueOf(UIUtils.dp2px(r4, 3.0f)), Integer.valueOf(UIUtils.dp2px(r4, 3.0f)));
        return r0.a;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable g(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r6, "context");
        return new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{UIUtils.getColor(r6, 2131100557), UIUtils.getColor(r6, 2131108700)});
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable h(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r10, "context");
        int r0 = jwb.a.a(r10);
        int r2 = zvb.a.b;
        return zvb.a.C0209a.d(r10, 2131102025, Integer.valueOf(r0), Integer.valueOf(r0), null, null, 240);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable i(Context r13) {
        Intrinsics.checkNotNullParameter(r13, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r13, "context");
        StateListDrawable r0 = new StateListDrawable();
        int r2 = zvb.a.b;
        GradientDrawable r3 = zvb.a.C0209a.c(r13, 2131102035, 100, null, null, 52);
        Intrinsics.checkNotNullParameter(r3, "drawable");
        r0.addState(new int[]{R.attr.state_pressed}, r3);
        GradientDrawable r14 = zvb.a.C0209a.c(r13, Integer.valueOf(R.color.transparent), 100, null, null, 52);
        Intrinsics.checkNotNullParameter(r14, "drawable");
        r0.addState(new int[0], r14);
        return r0;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable j(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r8, "context");
        int r0 = zvb.a.b;
        GradientDrawable r2 = zvb.a.C0209a.c(r8, 2131102025, 8, null, null, 52);
        if ((r2 instanceof GradientDrawable) == false) goto L5;
        GradientDrawable r3 = r2;
    L6:
        if (r3 == null) goto L8;
        r3.setStroke(UIUtils.dp2px(r8, 0.5f), UIUtils.getColor(r8, 2131103351));
    L8:
        return r2;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable k(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r9, "context");
        int r0 = jwb.a.a(r9);
        int r2 = zvb.a.b;
        return zvb.a.C0209a.c(r9, 2131102030, Integer.valueOf(r0), null, null, 52);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable l(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        zvb.a r0 = new zvb.a();
        r0.c(r4, 2131102045, null);
        int r5 = UIUtils.dp2px(r4, 6.0f);
        r0.a(r5, r5, r5, r5);
        return r0.a;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable m(Context r14) {
        Intrinsics.checkNotNullParameter(r14, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r14, "context");
        int r0 = jwb.a.a(r14);
        StateListDrawable r2 = new StateListDrawable();
        int r3 = zvb.a.b;
        GradientDrawable r4 = zvb.a.C0209a.c(r14, 2131102041, Integer.valueOf(r0), null, null, 52);
        Intrinsics.checkNotNullParameter(r4, "drawable");
        r2.addState(new int[]{R.attr.state_pressed}, r4);
        GradientDrawable r15 = zvb.a.C0209a.c(r14, 2131102030, Integer.valueOf(r0), null, null, 52);
        Intrinsics.checkNotNullParameter(r15, "drawable");
        r2.addState(new int[0], r15);
        return r2;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable n(Context r14) {
        Intrinsics.checkNotNullParameter(r14, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r14, "context");
        int r0 = jwb.a.a(r14);
        StateListDrawable r2 = new StateListDrawable();
        int r3 = zvb.a.b;
        GradientDrawable r4 = zvb.a.C0209a.d(r14, 2131102041, null, null, Integer.valueOf(r0), Integer.valueOf(r0), 204);
        Intrinsics.checkNotNullParameter(r4, "drawable");
        r2.addState(new int[]{R.attr.state_pressed}, r4);
        GradientDrawable r15 = zvb.a.C0209a.d(r14, 2131102030, null, null, Integer.valueOf(r0), Integer.valueOf(r0), 204);
        Intrinsics.checkNotNullParameter(r15, "drawable");
        r2.addState(new int[0], r15);
        return r2;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable o(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r6, "context");
        return new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{UIUtils.getColor(r6, 2131102022), UIUtils.getColor(r6, 2131106784)});
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable p(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        int r0 = zvb.a.b;
        return zvb.a.C0209a.a(r4, 2131102055, null, null, 60);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable q(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r8, "context");
        int r9 = UIUtils.dp2px(r8, 4.0f);
        zvb.a r0 = new zvb.a();
        r0.a.setColor(-1);
        r0.a(r9, r9, r9, r9);
        GradientDrawable r2 = r0.a;
        zvb.a r3 = new zvb.a();
        int[] r4 = {ColorProtector.parseColor("#26B791FA"), ColorProtector.parseColor("#265B65F5")};
        Intrinsics.checkNotNullParameter(r4, "colors");
        r3.a.setColors(r4);
        GradientDrawable.Orientation r5 = GradientDrawable.Orientation.TL_BR;
        Intrinsics.checkNotNullParameter(r5, "orientation");
        r3.a.setOrientation(r5);
        r3.a(r9, r9, r9, r9);
        return new LayerDrawable(new GradientDrawable[]{r2, r3.a});
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable r(Context r15) {
        Intrinsics.checkNotNullParameter(r15, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r15, "context");
        int r0 = jwb.a.a(r15);
        StateListDrawable r2 = new StateListDrawable();
        int r3 = zvb.a.b;
        GradientDrawable r4 = zvb.a.C0209a.d(r15, 2131102041, Integer.valueOf(r0), Integer.valueOf(r0), null, null, 240);
        Intrinsics.checkNotNullParameter(r4, "drawable");
        r2.addState(new int[]{R.attr.state_pressed}, r4);
        GradientDrawable r16 = zvb.a.C0209a.d(r15, 2131102030, Integer.valueOf(r0), Integer.valueOf(r0), null, null, 240);
        Intrinsics.checkNotNullParameter(r16, "drawable");
        r2.addState(new int[0], r16);
        return r2;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable s(Context r13) {
        Intrinsics.checkNotNullParameter(r13, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r13, "context");
        StateListDrawable r0 = new StateListDrawable();
        int r2 = zvb.a.b;
        GradientDrawable r3 = zvb.a.C0209a.c(r13, 2131102035, 100, null, null, 52);
        Intrinsics.checkNotNullParameter(r3, "drawable");
        r0.addState(new int[]{R.attr.state_pressed}, r3);
        GradientDrawable r14 = zvb.a.C0209a.c(r13, 2131102032, 100, null, null, 52);
        Intrinsics.checkNotNullParameter(r14, "drawable");
        r0.addState(new int[0], r14);
        return r0;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable t(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        zvb.a r0 = new zvb.a();
        r0.c(r4, 2131102049, null);
        r0.b(Integer.valueOf(UIUtils.dp2px(r4, 2.0f)), null);
        return r0.a;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable u(Context r13) {
        Intrinsics.checkNotNullParameter(r13, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r13, "context");
        StateListDrawable r0 = new StateListDrawable();
        int r2 = zvb.a.b;
        GradientDrawable r3 = zvb.a.C0209a.c(r13, 2131102035, 8, null, null, 52);
        Intrinsics.checkNotNullParameter(r3, "drawable");
        r0.addState(new int[]{R.attr.state_pressed}, r3);
        GradientDrawable r14 = zvb.a.C0209a.c(r13, Integer.valueOf(R.color.transparent), 8, null, null, 52);
        Intrinsics.checkNotNullParameter(r14, "drawable");
        r0.addState(new int[0], r14);
        return r0;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable v(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r8, "context");
        int r0 = zvb.a.b;
        return zvb.a.C0209a.c(r8, 2131102022, 24, 2131102045, 1, 4);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable w(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r5, "context");
        int r0 = zvb.a.b;
        return zvb.a.C0209a.a(r5, 2131103941, Float.valueOf(0.6f), 40, 48);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable x(Context r13) {
        Intrinsics.checkNotNullParameter(r13, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r13, "context");
        StateListDrawable r0 = new StateListDrawable();
        int r2 = zvb.a.b;
        GradientDrawable r3 = zvb.a.C0209a.c(r13, 2131102035, 100, null, null, 52);
        Intrinsics.checkNotNullParameter(r3, "drawable");
        r0.addState(new int[]{R.attr.state_pressed}, r3);
        GradientDrawable r14 = zvb.a.C0209a.c(r13, 2131102026, 100, null, null, 52);
        Intrinsics.checkNotNullParameter(r14, "drawable");
        r0.addState(new int[0], r14);
        return r0;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable y(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r8, "context");
        int r0 = zvb.a.b;
        return zvb.a.C0209a.c(r8, 2131102045, 100, null, null, 52);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable z(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        int r1 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r8, "context");
        int r0 = zvb.a.b;
        return zvb.a.C0209a.c(r8, 2131102026, 100, null, null, 52);
    }
}

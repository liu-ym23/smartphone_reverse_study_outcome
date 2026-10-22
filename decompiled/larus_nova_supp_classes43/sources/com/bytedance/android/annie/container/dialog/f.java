package com.bytedance.android.annie.container.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.container.fragment.AnnieFragment;
import com.bytedance.android.annie.scheme.vo.refactor.PopupHybridParamVoNew;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.util.m;
import com.bytedance.android.annie.util.p;
import com.bytedance.android.annie.view.PullDownCloseIndicatorContainer;
import com.bytedance.android.livesdk.pannel.SheetBaseDialog;
import com.bytedance.common.utility.UIUtils;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements com.bytedance.android.livesdk.pannel.f {
    public final /* synthetic */ BaseDialogFragment a;
    public final /* synthetic */ SheetBaseDialog b;

    public final boolean disableDragDown() {
        PopupHybridParamVoNew r0 = this.a.e;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L15;
        PopupHybridParamVoNew r10 = this.a.e;
        if (r10 == null) goto L12;
        int r11 = r10.k3();
    L13:
        if (r11 > 0) goto L15;
        return true;
    L12:
        r11 = 0;
    L15:
        if (m.a(this.a.getActivity()) == true) goto L28;
        HybridFragment r12 = this.a.f;
        if ((r12 instanceof AnnieFragment) == false) goto L19;
        AnnieFragment r13 = (AnnieFragment) r12;
    L20:
        if (r13 == null) goto L22;
        boolean r14 = r13.disableDragDown();
    L23:
        if (r14 == true) goto L29;
        return false;
    L29:
        return true;
    L22:
        r14 = false;
        goto L23
    L19:
        r13 = null;
        goto L20
    L28:
        return true;
    L5:
        if (r0.q() == true) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean a(MotionEvent r10) {
        if (AnnieConfigSettingKeys.ANNIE_ALLOW_NEW_INDICATOR_PULL_DOWN.a().booleanValue() == true) goto L5;
        return false;
    L5:
        if (r10 == null) goto L27;
        View r0 = this.a.i;     // Catch: Exception -> L24
        if (r0 == null) goto L9;
        PullDownCloseIndicatorContainer r1 = (PullDownCloseIndicatorContainer) r0.findViewById(2131383441);     // Catch: Exception -> L24
    L10:
        Rect r11 = new Rect();     // Catch: Exception -> L24
        if (r1 == null) goto L14;
        r1.getGlobalVisibleRect(r11);     // Catch: Exception -> L24
    L14:
        if (r10.getRawX() >= r11.left) goto L16;
        return false;
    L16:
        if (r10.getRawX() <= r11.right) goto L18;
        return false;
    L18:
        if (r10.getRawY() < r11.top) goto L30;
        if (r10.getRawY() <= r11.bottom) goto L23;
        return false;
    L23:
        return true;
    L30:
        return false;
    L9:
        r1 = null;
    L32:
        return false;
    L27:
        return false;
    }

    public final boolean shouldInterceptSlide(int r10) {
        BaseDialogFragment r0 = this.a;
        SheetBaseDialog r1 = this.b;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L13
        PopupHybridParamVoNew r12 = r0.e;     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L13
        if (r12.k3() != 0) goto L6;
        int r13 = ((FrameLayout) r1.findViewById(2131383767)).getHeight();     // Catch: Throwable -> L13
    L8:
        if (r10 <= (p.a.d() - r13)) goto L10;
        boolean r14 = true;
    L11:
        Object r15 = Result.constructor-impl(Boolean.valueOf(r14));     // Catch: Throwable -> L13
    L16:
        if (Result.isSuccess-impl(r15) == true) goto L18;
        Result.exceptionOrNull-impl(r15);
        return true;
    L18:
        return ((Boolean) r15).booleanValue();
    L10:
        r14 = false;
        goto L11
    L6:
        Context r16 = r1.getContext();     // Catch: Throwable -> L13
        PopupHybridParamVoNew r17 = r0.e;     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L13
        r13 = (int) UIUtils.dip2Px(r16, r17.k3());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public f(BaseDialogFragment r1, SheetBaseDialog r10) {
        this.a = r1;
        this.b = r10;
    }
}

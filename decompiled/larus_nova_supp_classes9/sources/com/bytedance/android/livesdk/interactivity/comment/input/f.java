package com.bytedance.android.livesdk.interactivity.comment.input;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.comment.input.framework.InputPanelLayout;
import com.bytedance.android.livesdk.interactivity.comment.input.framework.PanelType;
import com.bytedance.android.livesdk.r3;
import kotlin.jvm.internal.Intrinsics;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements InputPanelLayout.a {
    public final /* synthetic */ LiveCommonInputDialog a;

    public f(LiveCommonInputDialog r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.framework.InputPanelLayout.a
    public final void a(PanelType r6, PanelType r7) {
        Intrinsics.checkNotNullParameter(r6, "previousPanelType");
        Intrinsics.checkNotNullParameter(r7, "currentPanelType");
        if (r7 != PanelType.EMOJI) goto L11;
        LiveCommonInputDialog r8 = this.a;
        ImageView r9 = r8.h;
        if (r9 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("iconSwitchEmoji");
    L7:
        r9.setImageResource(2131251081);
        ImageView r10 = r8.h;
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("iconSwitchEmoji");
    L10:
        r3.a(r10, s1.B(2131914443));
    L18:
        LiveCommonInputDialog r11 = this.a;
        InputPanelLayout r13 = r11.g;
        if (r13 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L22:
        if (r13.getCurrentPanelType() == PanelType.NONE) goto L24;
        boolean r14 = true;
    L25:
        InputPanelLayout r1 = r11.g;
        if (r1 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L28:
        View r2 = r1.getCurrentPanelView();
        InputPanelLayout r3 = r11.g;
        if (r3 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L31:
        int r4 = r3.getKeyboardHeight();
        InputPanelLayout r5 = r11.g;
        if (r5 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L35:
        if (r5.getCurrentPanelType() != PanelType.KEYBOARD) goto L44;
        InputPanelLayout r15 = r11.g;
        if (r15 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L39:
        r4 = r15.getKeyboardHeight();
        if (r11.d.a == false) goto L43;
        if (r4 == 0) goto L43;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r16 = l42.a.k;
        Integer r0 = Integer.valueOf(r4);
        r16.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r16, r0);
    L59:
        i1 r17 = new i1(r4, r14);
        xs2.b.a().post(r17);
        return;
    L43:
        com.bytedance.android.livesdk.sharedpref.e<Integer> r18 = l42.a.l;
        Integer r19 = Integer.valueOf(r4);
        r18.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r18, r19);
        goto L59
    L44:
        InputPanelLayout r20 = r11.g;
        if (r20 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L48:
        if (r20.getHeight() <= 0) goto L53;
        InputPanelLayout r21 = r11.g;
        if (r21 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInputPanelLayout");
    L52:
        r4 = r21.getHeight();
        goto L59
    L53:
        if (r2 == null) goto L59;
        if (r2.getLayoutParams() == null) goto L59;
        if (r2.getLayoutParams().height <= 0) goto L59;
        r4 = r2.getLayoutParams().height;
        goto L59
    L24:
        r14 = false;
        goto L25
    L11:
        LiveCommonInputDialog r23 = this.a;
        ImageView r24 = r23.h;
        if (r24 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("iconSwitchEmoji");
    L14:
        r24.setImageResource(2131251079);
        ImageView r25 = r23.h;
        if (r25 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("iconSwitchEmoji");
    L17:
        r3.a(r25, s1.B(2131914438));
        goto L18
    }
}

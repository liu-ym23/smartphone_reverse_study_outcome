package com.bytedance.android.livesdk.floatview;

import android.view.View;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y implements View.OnClickListener {
    public final /* synthetic */ VideoFloatWindowView a;

    public y(VideoFloatWindowView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        InnerContextEntity r4 = this.a.l;
        if (r4 == null) goto L7;
        InnerContextEntity.InnerFloatExtra r5 = r4.getEnterExtra();
        if (r5 == null) goto L7;
        InnerContextEntity.UserCustomJump r6 = r5.getUserCustomJump();
    L8:
        if (r6 == null) goto L33;
        InnerContextEntity r7 = this.a.l;
        if (r7 == null) goto L17;
        InnerContextEntity.InnerFloatExtra r8 = r7.getEnterExtra();
        if (r8 == null) goto L17;
        InnerContextEntity.UserCustomJump r9 = r8.getUserCustomJump();
        if (r9 == null) goto L17;
        if (r9.getEnable() == false) goto L33;
    L17:
        InnerContextEntity r10 = this.a.l;
        if (r10 == null) goto L33;
        InnerContextEntity.InnerFloatExtra r11 = r10.getEnterExtra();
        if (r11 == null) goto L33;
        InnerContextEntity.UserCustomJump r12 = r11.getUserCustomJump();
        if (r12 == null) goto L33;
        Function0 r13 = r12.getEnableClickActionPredict();
        if (r13 == null) goto L33;
        if (((Boolean) r13.invoke()).booleanValue() != true) goto L33;
        InnerContextEntity r14 = this.a.l;
        if (r14 == null) goto L36;
        InnerContextEntity.InnerFloatExtra r15 = r14.getEnterExtra();
        if (r15 == null) goto L36;
        if (r15.getReportFloatRoomReturnFull() == true) goto L33;
    L36:
        e r16 = this.a.b;
        if (r16 == null) goto L40;
        r16.onClick();
        return;
    L40:
        return;
    L33:
        VideoFloatWindowView r17 = this.a;
        com.bytedance.android.livesdk.floatview.mob.b r0 = r17.n;
        if (r0 == null) goto L36;
        r0.k(r17.h, r17.getContainContext());
    L7:
        r6 = null;
        goto L8
    }
}

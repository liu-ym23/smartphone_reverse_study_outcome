package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.graphics.drawable.Animatable;
import android.widget.TextView;
import com.bytedance.android.livesdkapi.depend.model.live.ToolBarCouponExtraData;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a2 extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ z1 a;

    public a2(z1 r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
        super.onFinalImageSet(r3, (ImageInfo) r4, r5);
        z1 r6 = this.a;
        ToolBarCouponExtraData r7 = r6.a;
        if (r7 == null) goto L5;
        Integer r8 = Integer.valueOf(r7.getCouponPrice());
    L7:
        if (r8 != null) goto L9;
    L14:
        String r9 = "¥";
    L16:
        if (Intrinsics.areEqual("¥", r9) == false) goto L20;
        TextView r10 = r6.e;
        if (r10 == null) goto L23;
        r10.setTextSize(1, 14.0f);
    L23:
        TextView r11 = r6.e;
        if (r11 == null) goto L27;
        r11.setText(r9);
        return;
    L27:
        return;
    L20:
        TextView r12 = r6.e;
        if (r12 == null) goto L23;
        r12.setTextSize(1, 9.0f);
        goto L23
    L9:
        if (r8.intValue() <= 0) goto L14;
        if (r8.intValue() >= 100) goto L14;
        r9 = "¥" + r8;
        goto L16
    L5:
        r8 = null;
        goto L7
    }
}

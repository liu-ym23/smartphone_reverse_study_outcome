package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements a3.b {
    public final /* synthetic */ BaseEnterView a;

    public final void onFail() {
        ALogger.d("BaseEnterView", "error load nine patch");
    }

    public c(BaseEnterView r1) {
        this.a = r1;
    }

    public final void a(NinePatchDrawable r5) {
        Intrinsics.checkNotNullParameter(r5, "ninePatchDrawable");
        View r6 = this.a.f;
        if (r6 == null) goto L5;
        int r7 = r6.getPaddingLeft();
    L7:
        if (r7 <= InteractivityOpt.a(6.0f)) goto L19;
        HSImageView r8 = this.a.a;
        if (r8 == null) goto L19;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == true) goto L13;
        r9 = null;
    L13:
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
        if (r10 == null) goto L16;
        r10.leftMargin = 0;
    L16:
        HSImageView r0 = this.a.a;
        if (r0 == null) goto L30;
        r0.setLayoutParams(r10);
    L30:
        BaseEnterView r11 = this.a;
        e r1 = r11.g;
        if (r1 == null) goto L34;
        ((UserEnterLevelView) r1).e(r11);
        return;
    L34:
        return;
    L19:
        View r13 = this.a.f;
        if (r13 == null) goto L30;
        int r2 = r13.getPaddingTop();
        View r3 = this.a.f;
        if (r3 == null) goto L24;
        int r4 = r3.getPaddingRight();
    L25:
        View r14 = this.a.f;
        if (r14 == null) goto L28;
        int r15 = r14.getPaddingBottom();
    L29:
        r13.setPadding(0, r2, r4, r15);
        goto L30
    L28:
        r15 = 0;
        goto L29
    L24:
        r4 = 0;
        goto L25
    L5:
        r7 = 0;
        goto L7
    }
}

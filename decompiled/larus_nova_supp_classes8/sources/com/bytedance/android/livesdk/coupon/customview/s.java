package com.bytedance.android.livesdk.coupon.customview;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.utils.p6;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s extends Dialog {
    public final View a;
    public final FrameLayout b;
    public final FrameLayout c;

    public interface a {
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        com.bytedance.android.livesdk.f.d().a();
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        com.bytedance.android.livesdk.f.d().f();
    }

    public s(Context r9, com.bytedance.android.livesdk.coupon.b.c r10, com.bytedance.android.livesdk.coupon.f r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "callback");
        super(r9, 2131954829);
        View r12 = LayoutInflater.from(getContext()).inflate(2131565787, null);
        this.a = r12;
        HSImageView r0 = r12.findViewById(2131389863);
        FrameLayout r1 = (FrameLayout) r12.findViewById(2131389855);
        this.b = r1;
        TextView r2 = (TextView) r12.findViewById(2131389865);
        TextView r3 = (TextView) r12.findViewById(2131389862);
        FrameLayout r4 = (FrameLayout) r12.findViewById(2131389856);
        this.c = r4;
        TextView r5 = (TextView) r12.findViewById(2131389864);
        TextView r6 = (TextView) r12.findViewById(2131389861);
        TextView r7 = (TextView) r12.findViewById(2131389859);
        setContentView(r12);
        r4.setOnClickListener(new p(this, r11, r10));
        r5.setOnClickListener(new q(this, r11));
        r1.setOnClickListener(new r(this, r11));
        String r13 = r10.icon;
        if (r13 != null) goto L5;
    L8:
        boolean r14 = true;
    L9:
        if (r14 == true) goto L11;
        ImageLoader.bindImage(r0, r10.icon);
    L11:
        String r15 = r10.title;
        if (r15 != null) goto L14;
    L17:
        boolean r16 = true;
    L18:
        if (r16 == true) goto L20;
        r2.setText(r10.title);
    L20:
        String r17 = r10.description;
        if (r17 != null) goto L23;
    L26:
        boolean r18 = true;
    L27:
        if (r18 == true) goto L29;
        r3.setText(r10.description);
    L29:
        double r8 = r10.credit / ((double) 100);
        if (Double.valueOf(r8 % ((double) 1)).equals(Double.valueOf(0.0d)) == false) goto L32;
        String r19 = String.valueOf((int) r8);
    L33:
        r6.setText(r19);
        r7.setText(LiveResUtil.getString(2131922991, new Object[]{p6.a.format(new Date(r10.expireTimestamp * ((long) BubbleId.PadCast)))}));
        return;
    L32:
        r19 = String.valueOf(r8);
        goto L33
    L23:
        if (r17.length() == 0) goto L26;
        r18 = false;
        goto L27
    L14:
        if (r15.length() == 0) goto L17;
        r16 = false;
        goto L18
    L5:
        if (r13.length() == 0) goto L8;
        r14 = false;
        goto L9
    }
}

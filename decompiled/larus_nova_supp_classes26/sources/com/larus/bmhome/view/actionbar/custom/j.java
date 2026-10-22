package com.larus.bmhome.view.actionbar.custom;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public final ImageView a;
    public final TextView b;

    public j(AppCompatImageView r1, TextView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(com.larus.bmhome.actionbar.model.z0 r10, String r11) {
        boolean r0 = false;
        if (r10 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        Long r4 = null;
        GradientDrawable r5 = null;
        GradientDrawable r6 = null;
        if (r2 == false) goto L89;
        com.larus.bmhome.chat.api.e0 r3 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r3 == null) goto L15;
        LaunchInfo r7 = r3.a;
        if (r7 == null) goto L15;
        String r8 = r7.W();
    L17:
        if (Intrinsics.areEqual(r11, r8) == false) goto L89;
        com.larus.platform.service.z2 r12 = com.larus.platform.service.z2.a;
        if (r12.getActionBarEntryConfig().c == false) goto L89;
        if (r12.getActionBarEntryConfig().d == true) goto L23;
    L25:
        if (r0 == true) goto L40;
        wa8.u1 r13 = r10.z;
        if (r13 == null) goto L29;
        String r14 = r13.a;
    L31:
        if (com.larus.utils.o0.d(r14) == true) goto L40;
        ImageView r15 = this.a;
        if (r15 == null) goto L36;
        com.larus.utils.e1.x(r15);
    L36:
        TextView r16 = this.b;
        if (r16 == null) goto L39;
        com.larus.utils.e1.o(r16);
    L39:
        FLogger.a.i("ActionBarRedDotVisibleHelper", "redDotIcon visible, blueUpdateIcon gone, itemId:" + r10.a);
        return;
    L29:
        r14 = null;
    L40:
        ImageView r17 = this.a;
        if (r17 == null) goto L43;
        com.larus.utils.e1.o(r17);
    L43:
        TextView r18 = this.b;
        if (r18 == null) goto L46;
        com.larus.utils.e1.x(r18);
    L46:
        TextView r19 = this.b;
        if (r19 == null) goto L51;
        Drawable r110 = r19.getBackground();
        if (r110 == null) goto L51;
        Drawable r111 = r110.mutate();
    L52:
        wa8.u1 r1 = r10.z;
        if (r1 == null) goto L55;
        String r9 = r1.a;
    L57:
        if (com.larus.utils.o0.d(r9) == false) goto L77;
        TextView r20 = this.b;
        if (r20 == null) goto L88;
        wa8.u1 r21 = r10.z;
        if (r21 == null) goto L63;
        int r22 = r21.b;
    L64:
        r20.setTextColor(r22);
        TextView r23 = this.b;
        wa8.u1 r24 = r10.z;
        if (r24 == null) goto L67;
        String r25 = r24.a;
    L68:
        r23.setText(r25);
        if ((r111 instanceof GradientDrawable) == false) goto L71;
        r5 = (GradientDrawable) r111;
    L71:
        if (r5 == null) goto L88;
        wa8.u1 r112 = r10.z;
        if (r112 == null) goto L75;
        int r113 = r112.c;
    L76:
        r5.setColor(r113);
        goto L88
    L75:
        r113 = ContextCompat.getColor(this.b.getContext(), v19.c.b(2130973611, this.b.getContext(), 2131105590));
        goto L76
    L67:
        r25 = null;
        goto L68
    L63:
        r22 = ContextCompat.getColor(r20.getContext(), v19.c.b(2130972123, this.b.getContext(), 2131103203));
    L88:
        FLogger.a.i("ActionBarRedDotVisibleHelper", "redDotIcon gone, blueUpdateIcon visible, itemId:" + r10.a);
        return;
    L77:
        TextView r26 = this.b;
        if (r26 == null) goto L80;
        r26.setTextColor(ContextCompat.getColor(r26.getContext(), v19.c.b(2130972123, this.b.getContext(), 2131103203)));
    L80:
        TextView r27 = this.b;
        if (r27 == null) goto L84;
        r27.setText(wa8.n0.a());
    L84:
        if ((r111 instanceof GradientDrawable) == false) goto L86;
        r6 = (GradientDrawable) r111;
    L86:
        if (r6 == null) goto L88;
        r6.setColor(ContextCompat.getColor(this.b.getContext(), v19.c.b(2130973611, this.b.getContext(), 2131105590)));
        goto L88
    L55:
        r9 = null;
    L51:
        r111 = null;
        goto L52
    L23:
        if (com.larus.utils.o0.d(wa8.n0.a()) == false) goto L25;
        r0 = true;
    L15:
        r8 = null;
    L89:
        ImageView r114 = this.a;
        if (r114 == null) goto L92;
        com.larus.utils.e1.o(r114);
    L92:
        TextView r115 = this.b;
        if (r115 == null) goto L95;
        com.larus.utils.e1.o(r115);
    L95:
        FLogger r116 = FLogger.a;
        StringBuilder r28 = new StringBuilder("redDot gone, itemId:");
        if (r10 == null) goto L98;
        r4 = r10.a;
    L98:
        r28.append(r4);
        r116.i("ActionBarRedDotVisibleHelper", r28.toString());
        return;
    L5:
        if (r10.y != true) goto L7;
        r2 = true;
        goto L8
    }
}

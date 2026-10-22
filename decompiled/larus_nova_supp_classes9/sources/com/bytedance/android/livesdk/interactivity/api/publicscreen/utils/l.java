package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.api.IPublicScreenService;
import com.bytedance.android.livesdk.interactivity.api.utils.MessageCommonColorUtil;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public static final int a = 0;
    public static final int b = 0;

    static {
        a = ColorProtector.parseColor("#7F000000");
        b = ColorProtector.parseColor("#4C000000");
    }

    public static boolean d() {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        com.bytedance.android.livesdk.chatroom.o r1 = null;
        if (r0 == null) goto L5;
        r1 = IRoomContextService.a.a(r0, null, 0, 3);
    L5:
        if (r1 == null) goto L9;
        Boolean r2 = r1.isPortraitInteraction();
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return true;
    }

    @JvmStatic
    public static final float b(e52.a r0) {
        if (r0 == null) goto L6;
        g52.e r1 = r0.getTextConfig();
        if (r1 == null) goto L6;
        return r1.i;
    L6:
        return 1.0f;
    }

    public static yb2.a c(e52.a r1, com.bytedance.android.livesdk.interactivity.api.publicscreen.s r2) {
        Intrinsics.checkNotNullParameter(r1, "textMessageConfig");
        Intrinsics.checkNotNullParameter(r2, "messageModel");
        if (d() == false) goto L5;
        n42.a r3 = r1.h();
    L6:
        r3.getClass();
        yb2.a r4 = r2.k().a.b;
        if (r4 != null) goto L10;
        int r5 = MessageCommonColorUtil.a;
        int r6 = MessageCommonColorUtil.d();
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.s.a(r6, r6);
    L10:
        return r4;
    L5:
        r3 = r1.d();
        goto L6
    }

    @JvmStatic
    public static final void e(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "backgroundView");
        Drawable r0 = r3.getBackground();
        Drawable r2 = null;
        if ((r0 instanceof GradientDrawable) == true) goto L5;
        r0 = null;
    L5:
        GradientDrawable r1 = (GradientDrawable) r0;
        if (r1 != null) goto L12;
        r3.setBackgroundResource(2131249529);
        Drawable r5 = r3.getBackground();
        if ((r5 instanceof GradientDrawable) == false) goto L11;
        r2 = r5;
    L11:
        r1 = (GradientDrawable) r2;
    L12:
        if (r1 == null) goto L15;
        r1.setColor(r4);
        return;
    }

    @JvmStatic
    public static final int a(boolean r2, com.bytedance.android.livesdk.interactivity.api.entity.f r3, e52.a r4) {
        IPublicScreenService r0 = (IPublicScreenService) jc1.k.f(IPublicScreenService.class);
        Integer r1 = null;
        if (r0 == null) goto L5;
        Integer r5 = r0.getVSMessageBackgroundColor();
    L6:
        if (r5 != null) goto L8;
        if (r3 == null) goto L11;
        String r6 = r3.h();
    L12:
        if (r6 != null) goto L44;
    L17:
        Integer r7 = null;
    L18:
        if (r7 != null) goto L20;
        if (r4 != null) goto L23;
        n42.a r8 = null;
    L27:
        if (r8 == null) goto L37;
        if (r2 == false) goto L31;
    L33:
        if (r2 == false) goto L37;
        if (r8.f == false) goto L37;
        r1 = r8.h;
        goto L37
    L31:
        if (r8.e == false) goto L33;
        r1 = r8.g;
    L37:
        if (r1 != null) goto L39;
        if (r2 == false) goto L43;
        return a;
    L43:
        return b;
    L39:
        return r1.intValue();
    L23:
        if (d() == false) goto L25;
        r8 = r4.h();
        goto L27
    L25:
        r8 = r4.d();
        goto L27
    L20:
        return r7.intValue();
    L44:
        r7 = Integer.valueOf(Color.parseColor(r6));     // Catch: Exception -> L16
    L11:
        r6 = null;
        goto L12
    L8:
        return r5.intValue();
    L5:
        r5 = null;
        goto L6
    }
}

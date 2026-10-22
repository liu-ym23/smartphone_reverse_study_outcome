package com.bytedance.android.livesdk.interactivity.comment.view;

import am2.x;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class CommentWidgetAnimator {
    public q4.b a;
    public q4.b b;
    public c c;
    public int d;
    public boolean e;
    public String f;
    public String g;
    public final View h;
    public final View i;
    public final View j;
    public final LottieAnimationView k;
    public final boolean l;

    public static final class a {
    }

    static {
    }

    public final void a() {
        boolean r0 = ((Boolean) l42.a.g.getValue()).booleanValue();
        this.e = r0;
        c(r0, false);
    }

    public final void d() {
        View r0 = this.i;
        if (r0 == null) goto L5;
        r0.setAlpha(1.0f);
    L5:
        View r1 = this.j;
        if (r1 == null) goto L8;
        r1.setAlpha(1.0f);
    L8:
        View r2 = this.h;
        if (r2 == null) goto L12;
        r2.setBackground(this.c.getDrawable());
    L12:
        if (this.d != 1) goto L17;
        View r3 = this.h;
        if (r3 == null) goto L18;
        r3.setPadding(0, 0, 0, 0);
        return;
    L18:
        return;
    }

    public void b(boolean r6) {
        j0 r0 = j0.l();
        Pair[] r2 = new Pair[2];
        r2[0] = TuplesKt.to("room_orientation", "1");
        if (r6 == false) goto L5;
        String r7 = "close";
    L6:
        r2[1] = TuplesKt.to("mute_barrage_type", r7);
        Map r8 = MapsKt.mapOf(r2);
        x r3 = new x();
        r3.a = "live";
        r3.e = "click";
        r3.b = "live_detail";
        r0.sendLog("livesdk_landscape_mute_gift_barrage_click", r8, new Object[]{IRoom.class, r3});
        return;
    L5:
        r7 = "open";
        goto L6
    }

    public void c(boolean r6, boolean r7) {
        View r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.getWidth();
        if (r6 == false) goto L29;
        r3.c(this.k, s1.B(2131922763), true);
        LottieAnimationView r8 = this.k;
        if (r8 == null) goto L10;
        r8.setAnimation(this.f);
    L10:
        if (r7 == true) goto L24;
        if (this.l == true) goto L22;
        View r9 = this.i;
        if (r9 == null) goto L16;
        r9.setAlpha(0.0f);
    L16:
        View r10 = this.j;
        if (r10 == null) goto L19;
        r10.setAlpha(0.0f);
    L19:
        View r11 = this.h;
        if (r11 == null) goto L40;
        r11.setBackground(null);
    L40:
        LottieAnimationView r13 = this.k;
        if (r13 == null) goto L44;
        r13.playAnimation();
        return;
    L44:
        return;
    L22:
        d();
        goto L40
    L24:
        if (this.l == true) goto L40;
        this.c.a();
        r0.setBackground(this.c.getDrawable());
        if (this.d != 1) goto L28;
        r0.setPadding(0, 0, 0, 0);
    L28:
        q4.b r14 = u4.c(new CommentWidgetAnimator$setBlock$1(this, r1));
        r14.c();
        this.a = r14;
        goto L40
    L29:
        r3.c(this.k, s1.B(2131922762), true);
        LottieAnimationView r15 = this.k;
        if (r15 == null) goto L32;
        r15.setAnimation(this.g);
    L32:
        if (r7 == true) goto L35;
        d();
        goto L40
    L35:
        if (this.l == true) goto L40;
        r0.setBackground(this.c.getDrawable());
        if (this.d != 1) goto L39;
        r0.setPadding(0, 0, 0, 0);
    L39:
        q4.b r16 = u4.c(new CommentWidgetAnimator$setBlock$2(this, r1));
        r16.c();
        this.b = r16;
        goto L40
    }

    public CommentWidgetAnimator(View r1, View r2, View r3, LottieAnimationView r4, int r5, boolean r6) {
        this.h = r1;
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r6;
        this.c = new com.bytedance.android.livesdk.interactivity.comment.view.a(r5);
        this.f = "comment/close.json";
        this.g = "comment/open.json";
    }
}

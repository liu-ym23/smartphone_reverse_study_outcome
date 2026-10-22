package com.bytedance.android.live.broadcastgame.opengame.dialog.control;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class OpenControlDialogManager {
    public static final Map<Long, String> c = null;
    public com.bytedance.android.live.broadcastgame.opengame.dialog.control.a a;
    public final Context b;

    public static final class a {
    }

    static {
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to(3L, "adult"), TuplesKt.to(2L, "teen_within_regulated_time"), TuplesKt.to(1L, "")});
    }

    public void a() {
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    public void b() {
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    public final Context getContext() {
        return this.b;
    }

    public OpenControlDialogManager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
    }

    public final void c(com.bytedance.android.livesdk.wrds.interact.a.b r9, Context r11) {
        Intrinsics.checkNotNullParameter(r9, "popBoxContent");
        if (r11 != null) goto L5;
        r11 = this.b;
    L5:
        Integer r0 = r9.largeType;
        boolean r2 = false;
        if (r0 != null) goto L9;
    L11:
        String r1 = r9.a;
        Integer r4 = null;
        if (r1 != null) goto L14;
    L22:
        Integer r3 = r9.largeType;
        if (r3 != null) goto L26;
    L28:
        if (r3 != null) goto L31;
        return;
    L31:
        if (r3.intValue() != 2) goto L100;
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r5 = new OpenControlBottomDialog(r11);
    L33:
        this.a = r5;
        Integer r12 = r9.iconType;
        if (r12 != null) goto L37;
    L39:
        if (r12 != null) goto L42;
    L44:
        if (r12 != null) goto L47;
    L49:
        Drawable r13 = null;
    L50:
        if (r13 == null) goto L54;
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r6 = this.a;
        if (r6 == null) goto L54;
        r6.setIcon(r13);
    L54:
        String r14 = r9.title;
        if (r14 == null) goto L59;
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r7 = this.a;
        if (r7 == null) goto L59;
        r7.setTitle(r14);
    L59:
        String r15 = r9.description;
        if (r15 == null) goto L64;
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r8 = this.a;
        if (r8 == null) goto L64;
        r8.setContent(r15);
    L64:
        String r16 = r9.url;
        if (r16 != null) goto L67;
    L77:
        Integer r17 = r9.countDownSec;
        if (r17 != null) goto L80;
    L88:
        String r18 = r9.buttonDesc;
        if (r18 == null) goto L93;
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r19 = this.a;
        if (r19 == null) goto L93;
        r19.y(r18);
    L93:
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r21 = this.a;
        if (r21 == null) goto L96;
        r21.v(new OpenControlDialogManager$processPopBoxContentAndShow$$inlined$apply$lambda$2(this));
    L96:
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r22 = this.a;
        if (r22 == null) goto L101;
        r22.show();
        return;
    L101:
        return;
    L80:
        if (r17.intValue() <= 0) goto L82;
        r2 = true;
    L82:
        if (r2 == false) goto L84;
        r4 = r17;
    L84:
        if (r4 == null) goto L88;
        int r110 = r4.intValue();
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r23 = this.a;
        if (r23 == null) goto L88;
        r23.n0(r110, new OpenControlDialogManager$processPopBoxContentAndShow$$inlined$apply$lambda$1(this));
        goto L88
    L67:
        if (r16.length() <= 0) goto L69;
        boolean r24 = true;
    L70:
        if (r24 == true) goto L73;
        r16 = null;
    L73:
        if (r16 == null) goto L77;
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r25 = this.a;
        if (r25 == null) goto L77;
        r25.F0(r16);
        goto L77
    L69:
        r24 = false;
        goto L70
    L47:
        if (r12.intValue() != 4) goto L49;
        r13 = s1.m(2131251711);
        goto L50
    L42:
        if (r12.intValue() != 3) goto L44;
        r13 = s1.m(2131251709);
        goto L50
    L37:
        if (r12.intValue() != 2) goto L39;
        r13 = s1.m(2131251277);
        goto L50
    L100:
        return;
    L26:
        if (r3.intValue() != 3) goto L28;
        r5 = new b(r11);
        goto L33
    L14:
        if (r1.length() <= 0) goto L16;
        boolean r26 = true;
    L17:
        if (r26 == true) goto L20;
        r1 = null;
    L20:
        if (r1 == null) goto L22;
        f2.c(r1, 0);
        goto L22
    L16:
        r26 = false;
        goto L17
    L9:
        if (r0.intValue() != 4) goto L11;
        f2.c(r9.description, 0);
        goto L11
    }
}

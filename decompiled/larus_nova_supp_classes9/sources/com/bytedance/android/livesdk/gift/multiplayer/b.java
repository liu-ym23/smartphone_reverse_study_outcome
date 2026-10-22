package com.bytedance.android.livesdk.gift.multiplayer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.widget.EdgeTransparentView;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final void a(View r6, float r7, float r8, DataSource.ScaleType r9) {
        Intrinsics.checkNotNullParameter(r6, "alphaView");
        if (r6.getParent() != null) goto L5;
        return;
    L5:
        if ((r6.getParent() instanceof FrameLayout) == false) goto L51;
        EdgeTransparentView r10 = r6.getParent();
        if (r10 == null) goto L49;
        EdgeTransparentView r11 = (FrameLayout) r10;
        ViewGroup.LayoutParams r0 = r11.getLayoutParams();
        if (r0 == null) goto L47;
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        int r2 = s1.y();
        int r3 = s1.w();
        float r13 = r8 / r7;
        if (r9 == null) goto L23;
        int r14 = a.a[r9.ordinal()];
        if (r14 == 1) goto L28;
        if (r14 != 2) goto L18;
        r1.width = r2;
        r1.height = (int) (r2 * r13);
        r1.gravity = 48;
    L34:
        if (vh6.c.b(wh6.a.class).getCurrentActivity() != null) goto L36;
    L44:
        r11.setLayoutParams(r1);
        return;
    L36:
        if ((r11 instanceof EdgeTransparentView) == false) goto L44;
        if (PadConfigUtils.c() == false) goto L44;
        float r15 = r2;
        if (r2 <= r3) goto L42;
        float r16 = 0.3f;
    L43:
        float r17 = (int) (r15 * r16);
        float r4 = r17 * 0.12f;
        int r18 = (int) ((2 * r4) + r17);
        float r19 = r17 * r13;
        r11.a(15, r4);
        r1.width = r18;
        r1.height = (int) (r19 + (0.12f * r19));
        r1.gravity = 81;
        goto L44
    L42:
        r16 = 0.5f;
        goto L43
    L18:
        if (r14 != 3) goto L20;
        r1.width = r2;
        r1.height = (int) (r2 * r13);
        r1.gravity = 80;
        goto L34
    L20:
        if (r14 != 4) goto L22;
        r1.height = r3;
        r1.width = (int) (r3 / r13);
        r1.gravity = 8388611;
        goto L34
    L22:
        if (r14 != 5) goto L23;
        r1.height = r3;
        r1.width = (int) (r3 / r13);
        r1.gravity = 8388613;
        goto L34
    L28:
        float r20 = r3;
        float r5 = r2 * r13;
        if (r20 <= r5) goto L31;
        r1.width = r2;
        r1.height = (int) r5;
    L32:
        r1.gravity = 17;
        goto L34
    L31:
        r1.height = r3;
        r1.width = (int) (r20 / r13);
    L23:
        r1.width = -1;
        r1.height = -1;
        r1.gravity = 17;
        goto L34
    L47:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L49:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public static final void b(float r5, float r6, float r7, float r8, DataSource.ScaleType r9, IPlayerActionListener r10) {
        float r0 = r5 / r6;
        float r11 = r7 / r8;
        if (r9 == DataSource.ScaleType.ScaleAspectFill) goto L17;
        if (r9 == DataSource.ScaleType.TopFill) goto L17;
        if (r9 == DataSource.ScaleType.BottomFill) goto L17;
        if (r9 == DataSource.ScaleType.RightFill) goto L17;
        if (r9 == DataSource.ScaleType.LeftFill) goto L17;
        if (r0 > r11) goto L19;
    L18:
        float r1 = r5 / r11;
        float r13 = r5;
    L20:
        float r2 = 0.0f;
        if (r9 != null) goto L24;
    L55:
        r5 = r13;
        r6 = r1;
    L56:
        float r14 = 0.0f;
    L57:
        if (r10 == null) goto L60;
        r10.updateTextEffectPosition(r5, r6, r2, r14);
        return;
    L60:
        return;
    L24:
        switch(a.b[r9.ordinal()]) {
            case 1: goto L56;
            case 2: goto L48;
            case 3: goto L45;
            case 4: goto L42;
            case 5: goto L39;
            case 6: goto L35;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L28;
            case 10: goto L27;
            case 11: goto L26;
            default: goto L55;
        };
    L26:
        float r15 = r11 * r6;
        r2 = r5 - r15;
        r5 = r15;
        goto L56
    L27:
        r5 = r6 * r11;
        goto L56
    L28:
        float r16 = r5 / r11;
        r14 = r6 - r16;
        r6 = r16;
        goto L57
    L29:
        r6 = r5 / r11;
        goto L56
    L31:
        if (r0 <= r11) goto L33;
        float r17 = r5 - r13;
    L53:
        float r18 = r17 / 2;
    L54:
        r2 = r18;
        goto L55
    L33:
        r14 = (r6 - r1) / 2;
    L51:
        r5 = r13;
        r6 = r1;
        goto L57
    L35:
        if (r0 > r11) goto L49;
        r18 = -(r13 - r5);
    L49:
        float r19 = (-(r1 - r6)) / 2;
    L50:
        r14 = r19;
        goto L51
    L39:
        if (r0 <= r11) goto L55;
    L42:
        if (r0 <= r11) goto L52;
        r19 = -(r1 - r6);
    L52:
        r17 = -(r13 - r5);
        goto L53
    L45:
        if (r0 <= r11) goto L52;
    L48:
        if (r0 <= r11) goto L52;
    L19:
        r13 = r6 * r11;
        r1 = r6;
    L17:
        if (r0 <= r11) goto L19;
        goto L18
    }
}

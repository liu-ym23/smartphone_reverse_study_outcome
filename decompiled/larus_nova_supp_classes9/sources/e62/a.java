package e62;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.m0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final int a = 0;
    public static final int b = 0;
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final int f = 0;

    static {
        a = (int) UtilityKotlinExtentionsKt.h(480);
        b = (int) UtilityKotlinExtentionsKt.h(320);
        c = (int) UtilityKotlinExtentionsKt.h(38);
        d = 2131248977;
        e = 2131248979;
        f = 2131248978;
    }

    public static int b(RoomContext r5) {
        Integer r0 = null;
        if (r5 != null) goto L5;
        r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
    L5:
        if (r5 == null) goto L7;
        m0 r1 = (m0) r5.getRoomUISizeGetter().getValue();
        if (r1 == null) goto L30;
        Rect r2 = r1.a();
        if (r2 == null) goto L30;
        m0 r6 = (m0) r5.getRoomUISizeGetter().getValue();
        if (r6 == null) goto L30;
        Rect r7 = r6.c();
        if (r7 == null) goto L30;
        if (r2.height() >= r2.width()) goto L21;
        boolean r3 = true;
    L22:
        boolean r4 = PadConfigUtils.c();
        boolean r8 = e5.n();
        if (r4 == true) goto L26;
        if (r3 == false) goto L26;
        r0 = Integer.valueOf(r7.bottom - r2.bottom);
    L26:
        if (r4 == false) goto L30;
        if (r8 == true) goto L30;
        if (r3 == false) goto L30;
        r0 = Integer.valueOf((r7.bottom - r2.bottom) - c);
        goto L30
    L21:
        r3 = false;
    L30:
        if (r0 == null) goto L34;
        int r9 = r0.intValue();
        int r10 = b;
        if (r9 >= r10) goto L34;
        r0 = Integer.valueOf(r10);
    L34:
        if (r0 != null) goto L37;
        r0 = Integer.valueOf(a);
    L37:
        return r0.intValue();
    L7:
        return a;
    }

    public static void a(Window r5, View r6, RoomContext r7) {
        if (r5 != null) goto L4;
    L10:
        int r0 = b(r7);
        if (r6 == null) goto L33;
        ViewGroup.LayoutParams r1 = r6.getLayoutParams();
        r1.height = r0;
        r6.setLayoutParams(r1);
        if (r7 != null) goto L15;
        r7 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
    L15:
        if (r7 != null) goto L17;
        int r8 = e;
    L31:
        r6.setBackgroundResource(r8);
        goto L33
    L17:
        boolean r2 = PadConfigUtils.c();
        m0 r9 = (m0) r7.getRoomUISizeGetter().getValue();
        if (r9 == null) goto L25;
        Rect r10 = r9.a();
        if (r10 == null) goto L25;
        if (r10.height() >= r10.width()) goto L25;
        boolean r11 = true;
    L26:
        if (r2 == false) goto L28;
        r8 = d;
        goto L31
    L28:
        if (r11 == false) goto L30;
        r8 = f;
        goto L31
    L30:
        r8 = e;
    L25:
        r11 = false;
    L33:
        if (PadConfigUtils.c() == true) goto L39;
        if (r5 == null) goto L40;
        View r13 = r5.findViewById(2131389843);
        if (r13 == null) goto L41;
        a1.l(r13, r0);
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L4:
        if (PadConfigUtils.c() == true) goto L9;
        int r3 = s1.w() - s1.A();
        if (r3 != 0) goto L8;
        r3 = -1;
    L8:
        r5.setLayout(-1, r3);
    L9:
        r5.setBackgroundDrawableResource(2131106784);
        WindowManager.LayoutParams r4 = r5.getAttributes();
        r4.alpha = 1.0f;
        r4.dimAmount = 0.0f;
        r5.setAttributes(r4);
        goto L10
    }
}

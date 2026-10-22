package g72;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.c;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.h;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import kotlin.jvm.internal.Intrinsics;
import r52.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements h {
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final int f = 0;
    public static final Boolean g = null;
    public static final a h = null;

    public a() {
    }

    static {
        h = new a();
        InteractionWidgetsPosContext.a r0 = InteractionWidgetsPosContext.Companion;
        r0.getClass();
        c = InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp();
        r0.getClass();
        d = InteractionWidgetsPosContext.access$getANCHOR_TOOLBAR_HEIGHT$cp();
        r0.getClass();
        e = InteractionWidgetsPosContext.access$getPAD_TOOLBAR_HEIGHT$cp();
        f = s1.f(8.0f);
        g = (Boolean) l3.a.getValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.h
    public final d e(Object r7, d r8, e r9, com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.d r10, com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.e r11) {
        Intrinsics.checkNotNullParameter(r7, "source");
        Intrinsics.checkNotNullParameter(r8, "heightInfo");
        Intrinsics.checkNotNullParameter(r9, "uiContext");
        Intrinsics.checkNotNullParameter(r10, "roomStatus");
        Intrinsics.checkNotNullParameter(r11, "roomType");
        if (g.booleanValue() == true) goto L5;
    L11:
        int r13 = r8.b;
        if (r13 != (-10086)) goto L21;
        if (PadConfigUtils.a() == false) goto L17;
        r13 = e;
        goto L21
    L17:
        if (r10.isAnchor() == false) goto L19;
        r13 = d;
        goto L21
    L19:
        r13 = c;
    L21:
        if (r10.c() == true) goto L23;
    L25:
        int r14 = 0;
    L26:
        int r3 = r13 + r14;
        if ((r8 instanceof c) == false) goto L31;
        return new c(((c) r8).e, r8.a, r3, r8.c, r8.d);
    L31:
        return new d(r8.a, r3, r8.c, r8.d);
    L23:
        if (r10.f() <= 0) goto L25;
        r14 = r10.f() + f;
        goto L26
    L5:
        if (r10.isAnchor() == false) goto L7;
    L10:
        return r8;
    L7:
        if (r11.isVSRoom() == true) goto L10;
        if (r11.isMediaRoom() == false) goto L11;
        goto L10
    }
}

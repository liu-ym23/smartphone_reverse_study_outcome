package com.larus.bmhome.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.DeviceUtils;
import com.larus.bmhome.chat.ChatBubbleParams;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kga.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z1 {
    public static final Lazy a = null;

    public z1() {
    }

    static {
        a = LazyKt.lazy(new y1());
    }

    public static boolean a(Fragment r1) {
        if ((r1 instanceof xe8.a) == false) goto L5;
        xe8.a r2 = (xe8.a) r1;
    L6:
        if (r2 == null) goto L12;
        ChatBubbleParams r3 = r2.Mz();
        if (r3 == null) goto L12;
        if (r3.a != true) goto L12;
        return true;
    L12:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    public static View d(View r2) {
        if ((r2 instanceof RecyclerView) == false) goto L6;
        return r2;
    L6:
        if (r2 == null) goto L8;
        Object r3 = r2.getParent();
    L10:
        if ((r3 instanceof RecyclerView) == false) goto L14;
        return (View) r3;
    L14:
        if ((r3 instanceof View) == false) goto L16;
        View r4 = (View) r3;
    L17:
        if (r4 != null) goto L19;
        return null;
    L19:
        return d(r4);
    L16:
        r4 = null;
        goto L17
    L8:
        r3 = null;
        goto L10
    }

    public static int e(Fragment r6) {
        View r1 = null;
        Integer r2 = null;
        if ((r6 instanceof xe8.a) == false) goto L5;
        xe8.a r0 = (xe8.a) r6;
    L6:
        boolean r3 = false;
        if (r0 != null) goto L9;
    L11:
        boolean r4 = false;
    L13:
        if ((r0 instanceof Fragment) == false) goto L15;
        Fragment r5 = (Fragment) r0;
    L16:
        if (r5 == null) goto L20;
        View r7 = r5.getView();
        if (r7 == null) goto L20;
        Integer r8 = Integer.valueOf(r7.getWidth());
    L21:
        if (r4 == false) goto L26;
        if (r8 == null) goto L26;
        int r9 = r8.intValue();
        if (r9 <= 0) goto L26;
        return r9;
    L26:
        if (r0 != null) goto L28;
    L30:
        if (r6 == null) goto L39;
        View r10 = r6.getView();
        if (r10 == null) goto L39;
        Context r11 = r10.getContext();
        if (r11 == null) goto L39;
        Resources r12 = r11.getResources();
        if (r12 == null) goto L39;
        DisplayMetrics r13 = WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics());
        if (r13 == null) goto L39;
    L40:
        if (r3 == false) goto L52;
        if (r8 == null) goto L43;
        int r14 = r8.intValue();
    L58:
        com.larus.platform.service.e2 r15 = com.larus.platform.service.e2.a;
        if (r15.isPad() == false) goto L62;
        r14 = RangesKt.coerceAtMost(r14, r15.d(Integer.valueOf(r14)));
    L62:
        return i(r14);
    L43:
        if (r6 == null) goto L45;
        View r16 = r6.getView();
    L46:
        View r17 = d(r16);
        if (r17 == null) goto L49;
        r2 = Integer.valueOf(r17.getWidth());
    L49:
        if (r2 == null) goto L51;
        r14 = r2.intValue();
        goto L58
    L51:
        r14 = r13.widthPixels;
        goto L58
    L45:
        r16 = null;
        goto L46
    L52:
        if (r6 == null) goto L54;
        r1 = r6.getView();
    L54:
        View r18 = d(r1);
        if (r18 == null) goto L57;
        r14 = r18.getWidth();
        goto L58
    L57:
        r14 = r13.widthPixels;
    L39:
        Resources r19 = AppHost.a.getApplication().getResources();
        r13 = WindowDisplayMetricsOverride.apply(r19, r19.getDisplayMetrics());
        goto L40
    L28:
        if (r0.AU() != true) goto L30;
        r3 = true;
    L20:
        r8 = null;
        goto L21
    L15:
        r5 = null;
        goto L16
    L9:
        if (r0.F50() != true) goto L11;
        r4 = true;
        goto L13
    L5:
        r0 = null;
        goto L6
    }

    public static int f(Fragment r3) {
        if (com.larus.platform.service.e2.a.isPad() == false) goto L19;
        if ((r3 instanceof xe8.a) == false) goto L7;
        xe8.a r4 = (xe8.a) r3;
    L9:
        if (r4 == null) goto L13;
        ChatBubbleParams r5 = r4.Mz();
        if (r5 == null) goto L13;
        int r6 = r5.c;
    L14:
        if (r6 <= 0) goto L17;
        FLogger.a.i("MsgBoxWidthTag", "[marginStartFromHost] " + r6);
        return r6;
    L17:
        return 0;
    L13:
        r6 = 0;
        goto L14
    L7:
        r4 = null;
        goto L9
    L19:
        return AppHost.a.getApplication().getResources().getDimensionPixelSize(2131167568);
    }

    public static int i(int r2) {
        Integer r3 = Integer.valueOf(r2);
        if (r3.intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r3 = null;
    L9:
        if (r3 == null) goto L11;
        int r4 = r3.intValue();
    L13:
        if (com.larus.platform.service.e2.a.isPad() == true) goto L19;
        Integer r1 = b.a().h(AppHost.a.getApplication());
        if (r1 != null) goto L18;
        return r4;
    L18:
        return r1.intValue();
    L19:
        return RangesKt.coerceAtMost(r4, com.larus.platform.api.f3.a.a());
    L11:
        Resources r5 = AppHost.a.getApplication().getResources();
        r4 = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).widthPixels;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public static boolean b(int r1, Integer r2) {
        if (((Boolean) a.getValue()).booleanValue() == true) goto L5;
    L11:
        return false;
    L5:
        if (DeviceUtils.isFoldableScreenV2(AppHost.a.getApplication()) == true) goto L11;
        if (r1 != 0) goto L8;
    L9:
        if (r2 != null) goto L11;
        return true;
    L8:
        if (r1 != 3) goto L11;
        goto L9
    }

    public static boolean c(int r0, Integer r1, boolean r2, boolean r3) {
        if (b(r0, r1) == false) goto L7;
        if (r2 == true) goto L7;
        if (r3 == true) goto L7;
        return true;
    L7:
        return false;
    }

    public static int g(int r1, Integer r2, boolean r3, boolean r4, Integer r5) {
        Resources r0 = AppHost.a.getApplication().getResources();
        if (c(r1, r2, r3, r4) == false) goto L5;
        int r6 = r0.getDimensionPixelSize(2131167568);
        int r7 = r0.getDimensionPixelSize(2131167564);
    L6:
        int r8 = r6 + r7;
        if (r5 == null) goto L9;
        int r9 = r5.intValue();
    L11:
        return r9 - r8;
    L9:
        r9 = i(0);
        goto L11
    L5:
        r6 = r0.getDimensionPixelSize(2131167568);
        r7 = r0.getDimensionPixelSize(2131167563);
        goto L6
    }

    public static /* synthetic */ int h(int r2, Integer r3, boolean r4, boolean r5, int r6) {
        if ((r6 & 4) == 0) goto L6;
        r4 = false;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = false;
    L9:
        return g(r2, r3, r4, r5, null);
    }
}

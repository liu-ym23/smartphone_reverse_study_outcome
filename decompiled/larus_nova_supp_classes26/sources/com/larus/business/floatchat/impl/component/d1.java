package com.larus.business.floatchat.impl.component;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.im.bean.message.Message;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d1 {
    public static final d1 a = null;
    public static final int b = 0;
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;

    public d1() {
    }

    static {
        a = new d1();
        int r0 = (int) we8.a.a(i5.f0(), false);
        b = r0;
        int r1 = (int) we8.a.a(i5.f0(), false);
        c = r1;
        int r2 = i5.q();
        d = r2;
        int r3 = i5.r0();
        e = r3;
        int r4 = i5.q();
        f = r4;
        g = (((r0 + r2) + r1) + r3) + r4;
    }

    public static String e(Message r5) {
        String r0 = r5.getMessageId();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L14:
        String r6 = r5.getLocalMessageId();
        if (r6 != null) goto L17;
        return null;
    L17:
        if (r6.length() <= 0) goto L19;
        r1 = true;
    L19:
        if (r1 == true) goto L21;
        return null;
    L21:
        return r6;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L14;
        return r0;
    L7:
        r4 = false;
        goto L8
    }

    public static boolean a(Message r3, Message r4) {
        if (r3.getSourceFromAsr() == true) goto L5;
        return false;
    L5:
        String r5 = com.larus.bmhome.chat.bean.d.H(r3);
        String r0 = "";
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        if (StringsKt.isBlank(r5) == false) goto L11;
        return false;
    L11:
        String r6 = com.larus.bmhome.chat.bean.d.H(r4);
        if (r6 == null) goto L16;
        r0 = r6;
    L16:
        return !Intrinsics.areEqual(r5, r0);
    }

    public static boolean b(Message r3, Message r4) {
        if (c(r3, r4) == true) goto L6;
        return false;
    L6:
        if (com.larus.bmhome.chat.bean.d.G0(r3) == com.larus.bmhome.chat.bean.d.G0(r4)) goto L9;
        return false;
    L9:
        if (com.larus.bmhome.chat.bean.d.G0(r4) == true) goto L11;
    L12:
        return true;
    L11:
        if (r3.getContentType() == r4.getContentType()) goto L12;
        return false;
    }

    public static boolean c(Message r5, Message r6) {
        String r0 = r5.getMessageId();
        String r2 = null;
        if (r0 != null) goto L5;
    L15:
        boolean r1 = false;
    L16:
        if (r1 == true) goto L31;
        String r7 = r5.getLocalMessageId();
        if (r7 != null) goto L20;
    L29:
        boolean r8 = false;
    L30:
        if (r8 == true) goto L31;
        return false;
    L20:
        if (r7.length() <= 0) goto L22;
        boolean r3 = true;
    L23:
        if (r3 == false) goto L25;
        r2 = r7;
    L25:
        if (r2 == null) goto L29;
        if (Intrinsics.areEqual(r2, r6.getLocalMessageId()) != true) goto L29;
        r8 = true;
        goto L30
    L22:
        r3 = false;
    L31:
        return true;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L15;
        if (Intrinsics.areEqual(r0, r6.getMessageId()) != true) goto L15;
        r1 = true;
        goto L16
    L7:
        r4 = false;
        goto L8
    }

    public static int d(View r5, RecyclerView r6) {
        if (r5.getLayoutParams() != null) goto L5;
        r5.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    L5:
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        ViewGroup.MarginLayoutParams r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L9:
        int r3 = 0;
        if (r1 == null) goto L12;
        int r4 = r1.leftMargin + r1.rightMargin;
    L13:
        Integer r7 = Integer.valueOf(((r6.getWidth() - r6.getPaddingLeft()) - r6.getPaddingRight()) - r4);
        if (r7.intValue() <= 0) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == true) goto L20;
        r7 = null;
    L20:
        if (r7 == null) goto L22;
        int r9 = r7.intValue();
    L23:
        r5.measure(View.MeasureSpec.makeMeasureSpec(r9, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        r5.layout(0, 0, r9, r5.getMeasuredHeight());
        int r10 = r5.getMeasuredHeight();
        ViewGroup.LayoutParams r11 = r5.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        r2 = (ViewGroup.MarginLayoutParams) r11;
    L26:
        if (r2 == null) goto L29;
        r3 = r2.topMargin + r2.bottomMargin;
    L29:
        return r10 + r3;
    L22:
        Resources r12 = r6.getResources();
        r9 = RangesKt.coerceAtLeast(WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics()).widthPixels - r4, 0);
        goto L23
    L16:
        r8 = false;
        goto L17
    L12:
        r4 = 0;
        goto L13
    L8:
        r1 = null;
        goto L9
    }
}

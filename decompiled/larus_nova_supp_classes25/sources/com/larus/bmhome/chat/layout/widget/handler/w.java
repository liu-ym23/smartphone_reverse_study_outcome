package com.larus.bmhome.chat.layout.widget.handler;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.utils.z1;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.e2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w {
    public static final w a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static int g;

    public w() {
    }

    static {
        a = new w();
        b = LazyKt.lazy(new r());
        c = LazyKt.lazy(new s());
        d = LazyKt.lazy(new t());
        e = LazyKt.lazy(new u());
        f = LazyKt.lazy(new v());
        g = c7.b(16);
        e2.a.isPad();
    }

    public static Map a(fh8.f r2) {
        Intrinsics.checkNotNullParameter(r2, "commonInputData");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r2 == null) goto L5;
        r0.put("markdown_common_input_data", r2);
    L5:
        return r0;
    }

    public static CustomMarkdownTextView b(Context r7, Boolean r8, Boolean r9, RectF r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        int r3 = 0;
        CustomMarkdownTextView r0 = new CustomMarkdownTextView(r7, null, 6, 0);
        r0.setBottomLineWeight(i5.x0(v19.c.b(2130971253, null, 2131166876)));
        r0.setLineColor(1207959551);
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r9, r1) == false) goto L5;
        float r2 = we8.a.a(i5.o(), true);
    L6:
        r0.setTextSize(0, r2);
        r0.setLineSpacing(0.0f, 1.1f);
        if (r10 == null) goto L12;
        int r4 = (int) r10.left;
        int r5 = (int) r10.right;
        int r6 = (int) r10.top;
        if (Intrinsics.areEqual(r8, r1) == false) goto L11;
        r3 = (int) r10.bottom;
    L11:
        FLogger.a.i("updatePaddingRelative", "view:CustomMarkdownTextView,source:,start:" + r4 + ",top:" + r6 + ",end:" + r5 + ",bottom:" + r3);
        r0.setPaddingRelative(r4, r6, r5, r3);
    L12:
        r0.setTag(2131388543, Integer.valueOf(r0.getPaddingStart()));
        r0.setTag(2131388544, Integer.valueOf(r0.getPaddingTop()));
        r0.setTag(2131388542, Integer.valueOf(r0.getPaddingEnd()));
        r0.setTag(2131388541, Integer.valueOf(r0.getPaddingBottom()));
        if (Intrinsics.areEqual(r9, r1) == false) goto L15;
        r0.setTextColor(ContextCompat.getColor(r7, 2131103298));
    L16:
        return r0;
    L15:
        r0.setTextColor(ContextCompat.getColor(r7, v19.c.b(2130972079, r7, 2131103136)));
        goto L16
    L5:
        r2 = we8.a.a(i5.t(), false);
        goto L6
    }

    public static int c(w r3, Context r4, Message r5, Integer r6, Boolean r7, boolean r8, boolean r9, Integer r10, View r11, int r12) {
        boolean r1 = false;
        if ((r12 & 32) == 0) goto L5;
        r9 = false;
    L5:
        Fragment r2 = null;
        if ((r12 & 64) == 0) goto L9;
        r10 = null;
    L9:
        if ((r12 & 128) == 0) goto L11;
        r11 = null;
    L11:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "data");
        boolean r13 = com.larus.bmhome.chat.bean.d.J0(r5);
        if (r6 == null) goto L19;
        if (Intrinsics.areEqual(r7, Boolean.FALSE) == false) goto L19;
        Lazy r14 = z1.a;
        if (z1.c(r6.intValue(), null, r8, r13) == false) goto L19;
        int r15 = ((Number) b.getValue()).intValue();
        int r16 = ((Number) c.getValue()).intValue();
    L22:
        int r17 = r15 + r16;
        if (r9 == false) goto L26;
        int r18 = 0;
    L33:
        if (AppHost.a.isDebug() == false) goto L47;
        Lazy r19 = z1.a;
        if (r11 == null) goto L41;
        t1a.b r20 = ei9.c.a(r11);
        if (r20 == null) goto L41;
        va8.m r21 = r20.getAbility(va8.m.class);
        if (r21 == null) goto L41;
        Fragment r22 = r21.getChatFragment();
    L42:
        int r23 = z1.e(r22);
        int r24 = z1.i(0) - r17;
        int r25 = m0.b(r4);
        FLogger r26 = FLogger.a;
        StringBuilder r27 = new StringBuilder("getContainerWidth = ");
        r27.append(r23);
        r27.append(" widthPixels = ");
        r27.append(r24);
        r27.append(" screen width = ");
        r27.append(r25);
        r27.append(" view.width = ");
        if (r11 == null) goto L45;
        Integer r28 = Integer.valueOf(r11.getWidth());
    L46:
        r27.append(r28);
        r26.i("InBoxMsgExpandManager", r27.toString());
        goto L47
    L45:
        r28 = null;
    L41:
        r22 = null;
    L47:
        if (r10 != null) goto L49;
    L56:
        Lazy r29 = z1.a;
        if (r11 == null) goto L63;
        t1a.b r30 = ei9.c.a(r11);
        if (r30 == null) goto L63;
        va8.m r31 = r30.getAbility(va8.m.class);
        if (r31 == null) goto L63;
        r2 = r31.getChatFragment();
    L63:
        int r32 = z1.e(r2) - r17;
    L65:
        return r32 - r18;
    L49:
        if (r10.intValue() <= 0) goto L51;
        r1 = true;
    L51:
        if (r1 == true) goto L54;
        r10 = null;
    L54:
        if (r10 == null) goto L56;
        r32 = r10.intValue();
        goto L65
    L26:
        if (Intrinsics.areEqual(r5.getBizContentType(), "deep_search_card") == false) goto L29;
        r18 = i5.e0() + i5.e0();
        goto L33
    L29:
        if (g != (-1)) goto L31;
        g = r4.getResources().getDimensionPixelSize(2131167561);
    L31:
        r18 = g * 2;
    L19:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L21;
        r15 = ((Number) d.getValue()).intValue();
        r16 = ((Number) e.getValue()).intValue();
        goto L22
    L21:
        r15 = ((Number) b.getValue()).intValue();
        r16 = ((Number) f.getValue()).intValue();
        goto L22
    }
}

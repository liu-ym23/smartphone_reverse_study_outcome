package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final a d(com.larus.bmhome.actionbar.model.w r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        a r0 = g(r4);
        if (r0 != null) goto L30;
        List r5 = r4.v;
        if (r5 != null) goto L7;
        r5 = CollectionsKt.emptyList();
    L7:
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L19;
        Object r1 = r6.next();
        Integer r2 = ((com.larus.bmhome.actionbar.model.c2) r1).getType();
        if (r2 != null) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == false) goto L9;
    L20:
        com.larus.bmhome.actionbar.model.c2 r7 = (com.larus.bmhome.actionbar.model.c2) r1;
        if (r7 == null) goto L24;
        return e(r7);
    L24:
        return null;
    L14:
        if (r2.intValue() != 4) goto L16;
        r3 = true;
        goto L17
    L19:
        r1 = null;
        goto L20
    L30:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final a e(com.larus.bmhome.actionbar.model.c2 r14) {
        boolean r0 = v19.h.a;
        Object r1 = null;
        boolean r2 = false;
        if (v19.h.a(null) == false) goto L19;
        com.larus.bmhome.actionbar.model.g1 r3 = r14.d;
        if (r3 == null) goto L18;
        String r4 = r3.b;
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L14:
        if ((!r5) == true) goto L17;
        r3 = null;
    L17:
        if (r3 == null) goto L18;
    L20:
        if (r3 == null) goto L26;
        String r6 = r3.b;
        if (r6 == null) goto L26;
        if ((!StringsKt.isBlank(r6)) == false) goto L26;
        String r9 = r6;
    L27:
        String r7 = r14.b;
        if (r7 != null) goto L30;
    L32:
        String r8 = null;
    L33:
        Integer r10 = r14.getType();
        if (r10 != null) goto L37;
    L108:
        if (r10 != null) goto L111;
        return null;
    L111:
        if (r10.intValue() != 4) goto L155;
        if (r9 != null) goto L115;
        return null;
    L115:
        if (r3 == null) goto L127;
        Integer r15 = r3.c;
        if (r15 == null) goto L127;
        if (r15.intValue() <= 0) goto L121;
        boolean r11 = true;
    L122:
        if (r11 == true) goto L125;
        r15 = null;
    L125:
        if (r15 == null) goto L127;
        int r12 = r15.intValue();
    L128:
        if (r3 == null) goto L140;
        Integer r16 = r3.d;
        if (r16 == null) goto L140;
        if (r16.intValue() <= 0) goto L134;
        boolean r13 = true;
    L135:
        if (r13 == true) goto L138;
        r16 = null;
    L138:
        if (r16 == null) goto L140;
        int r17 = r16.intValue();
    L141:
        if (r3 == null) goto L149;
        Integer r18 = r3.e;
        if (r18 == null) goto L149;
        if (r18.intValue() < 0) goto L147;
        r2 = true;
    L147:
        if (r2 == false) goto L149;
        Integer r19 = r18;
    L151:
        return new a(4, null, r9, r12, r17, r19, null);
    L149:
        r19 = null;
        goto L151
    L134:
        r13 = false;
    L140:
        r17 = 10;
        goto L141
    L121:
        r11 = false;
    L127:
        r12 = 10;
        goto L128
    L155:
        return null;
    L37:
        if (r10.intValue() != 5) goto L108;
        if (r9 != null) goto L42;
        if (r8 != null) goto L42;
        return null;
    L42:
        if (r3 == null) goto L54;
        Integer r20 = r3.c;
        if (r20 == null) goto L54;
        if (r20.intValue() <= 0) goto L48;
        boolean r110 = true;
    L49:
        if (r110 == true) goto L52;
        r20 = null;
    L52:
        if (r20 == null) goto L54;
        int r111 = r20.intValue();
    L55:
        if (r3 == null) goto L67;
        Integer r21 = r3.d;
        if (r21 == null) goto L67;
        if (r21.intValue() <= 0) goto L61;
        boolean r112 = true;
    L62:
        if (r112 == true) goto L65;
        r21 = null;
    L65:
        if (r21 == null) goto L67;
        int r113 = r21.intValue();
    L68:
        if (r3 == null) goto L77;
        Integer r22 = r3.e;
        if (r22 == null) goto L77;
        if (r22.intValue() < 0) goto L74;
        boolean r23 = true;
    L75:
        if (r23 == false) goto L77;
        Integer r114 = r22;
    L79:
        if (v19.h.a(null) == false) goto L88;
        String r24 = r14.f;
        if (r24 != null) goto L83;
    L87:
        r24 = r14.e;
    L89:
        if (r24 == null) goto L154;
        String r115 = StringsKt.removePrefix(StringsKt.trim(r24).toString(), "#");
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L100
        int r26 = r115.length();     // Catch: Throwable -> L100
        if (r26 != 6) goto L94;
        Integer r116 = Integer.valueOf(Color.rgb(CastIntegerProtector.parseInt(r115.substring(0, 2), CharsKt.checkRadix(16)), CastIntegerProtector.parseInt(r115.substring(2, 4), CharsKt.checkRadix(16)), CastIntegerProtector.parseInt(r115.substring(4, 6), CharsKt.checkRadix(16))));     // Catch: Throwable -> L100
    L98:
        Object r117 = Result.constructor-impl(r116);     // Catch: Throwable -> L100
    L103:
        if (Result.isFailure-impl(r117) == true) goto L106;
        r1 = r117;
    L106:
        r1 = (Integer) r1;
        goto L154
    L94:
        if (r26 == 8) goto L96;
        r116 = null;
        goto L98
    L96:
        r116 = Integer.valueOf(Color.argb(CastIntegerProtector.parseInt(r115.substring(6, 8), CharsKt.checkRadix(16)), CastIntegerProtector.parseInt(r115.substring(0, 2), CharsKt.checkRadix(16)), CastIntegerProtector.parseInt(r115.substring(2, 4), CharsKt.checkRadix(16)), CastIntegerProtector.parseInt(r115.substring(4, 6), CharsKt.checkRadix(16))));     // Catch: Throwable -> L100
    L100:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r117 = Result.constructor-impl(ResultKt.createFailure(th));
    L154:
        return new a(5, r8, r9, r111, r113, r114, r1);
    L83:
        if ((true ^ StringsKt.isBlank(r24)) == true) goto L86;
        r24 = null;
    L86:
        if (r24 != null) goto L89;
    L88:
        r24 = r14.e;
        goto L89
    L74:
        r23 = false;
    L77:
        r114 = null;
        goto L79
    L61:
        r112 = false;
    L67:
        r113 = 10;
        goto L68
    L48:
        r110 = false;
    L54:
        r111 = 10;
        goto L55
    L30:
        if ((!StringsKt.isBlank(r7)) == false) goto L32;
        r8 = r7;
    L26:
        r9 = null;
        goto L27
    L9:
        if (StringsKt.isBlank(r4) == true) goto L12;
        r5 = false;
    L18:
        r3 = r14.c;
        goto L20
    L19:
        r3 = r14.c;
        goto L20
    }

    public static final String f(com.larus.bmhome.actionbar.model.w r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (g(r2) != null) goto L5;
        return null;
    L5:
        com.larus.bmhome.actionbar.model.z1 r3 = r2.w;
        if (r3 == null) goto L13;
        String r4 = r3.a;
        if (r4 != null) goto L10;
        return null;
    L10:
        if ((!StringsKt.isBlank(r4)) == true) goto L12;
        return null;
    L12:
        return r4;
    L13:
        return null;
    }

    public static final a g(com.larus.bmhome.actionbar.model.w r4) {
        List r5 = r4.v;
        if (r5 != null) goto L5;
        r5 = CollectionsKt.emptyList();
    L5:
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L17;
        Object r0 = r6.next();
        Integer r2 = ((com.larus.bmhome.actionbar.model.c2) r0).getType();
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == false) goto L7;
    L18:
        com.larus.bmhome.actionbar.model.c2 r1 = (com.larus.bmhome.actionbar.model.c2) r0;
        if (r1 != null) goto L21;
        return null;
    L21:
        return e(r1);
    L12:
        if (r2.intValue() != 5) goto L14;
        r3 = true;
        goto L15
    L17:
        r0 = null;
        goto L18
    }

    public static final View a(Context r8, a r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "badge");
        if (r9.getType() != 5) goto L20;
        LinearLayout r0 = new LinearLayout(r8);
        r0.setOrientation(0);
        r0.setGravity(17);
        r0.setMinimumHeight(c(r8, 18));
        r0.setPadding(c(r8, 4), c(r8, 2), c(r8, 5), c(r8, 2));
        GradientDrawable r1 = new GradientDrawable();
        Integer r4 = r9.g;
        if (r4 == null) goto L7;
        int r5 = r4.intValue();
    L8:
        r1.setColor(r5);
        r1.setCornerRadius(c(r8, 6));
        r0.setBackground(r1);
        String r2 = r9.c;
        if (r2 == null) goto L11;
        r0.addView(b(r8, r9, r2), new LinearLayout.LayoutParams(c(r8, r9.d), c(r8, r9.e)));
    L11:
        String r3 = r9.b;
        if (r3 == null) goto L25;
        TextView r6 = new TextView(r0.getContext());
        r6.setText(r3);
        r6.setTextSize(11.0f);
        r6.setIncludeFontPadding(false);
        if (Build.VERSION.SDK_INT < 28) goto L16;
        r6.setLineHeight(c(r8, 14));
    L16:
        r6.setMaxLines(1);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.setGravity(17);
        r6.setTypeface(Typeface.create("sans-serif-medium", 0));
        r6.setTextColor(ColorProtector.parseColor("#0066FF"));
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-2, -2);
        if (r9.c == null) goto L19;
        r7.setMarginStart(c(r8, 2));
    L19:
        Unit r10 = Unit.INSTANCE;
        r0.addView(r6, r7);
        return r0;
    L25:
        return r0;
    L7:
        r5 = Color.argb(26, 0, 102, 255);
        goto L8
    L20:
        String r11 = r9.c;
        if (r11 != null) goto L24;
        r11 = "";
    L24:
        return b(r8, r9, r11);
    }

    public static final int c(Context r1, int r2) {
        Resources r3 = r1.getResources();
        return (int) ((r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
    }

    public static final SimpleDraweeView b(Context r4, a r5, String r6) {
        SimpleDraweeView r0 = new SimpleDraweeView(r4);
        r0.setMinimumWidth(c(r4, r5.d));
        r0.setMinimumHeight(c(r4, r5.e));
        r0.setLayoutParams(new ViewGroup.LayoutParams(c(r4, r5.d), c(r4, r5.e)));
        Integer r7 = r5.f;
        if (r7 == null) goto L5;
        r0.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(c(r4, r7.intValue())));
    L5:
        r0.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        ImageLoaderKt.u(r0, r6, "template_item_photo");
        return r0;
    }
}

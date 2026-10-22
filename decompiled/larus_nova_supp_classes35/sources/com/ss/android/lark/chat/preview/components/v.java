package com.ss.android.lark.chat.preview.components;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.ss.android.lark.chat.preview.entity.component.property.TimeZoneProperty;
import com.ss.android.lark.export.entity.preview.FontLevel;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.time.format.entity.DatePreciseness;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.time.format.entity.TimePreciseness;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import java.util.Date;
import java.util.TimeZone;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class v extends q6c.e<TimeZoneProperty, TextView, r6c.a> {
    public final Style f;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;
        public static final /* synthetic */ int[] d = null;
        public static final /* synthetic */ int[] e = null;
        public static final /* synthetic */ int[] f = null;

        static {
            int[] r0 = new int[TimeZoneProperty.TimeZoneType.values().length];
            r0[TimeZoneProperty.TimeZoneType.MERIDIEM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L88:
            r0[TimeZoneProperty.TimeZoneType.WEEK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L98:
            r0[TimeZoneProperty.TimeZoneType.MONTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L64:
            r0[TimeZoneProperty.TimeZoneType.TIME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L37
        L66:
            r0[TimeZoneProperty.TimeZoneType.DATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L38
        L84:
            r0[TimeZoneProperty.TimeZoneType.FULL_DATE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L39
        L94:
            r0[TimeZoneProperty.TimeZoneType.DATE_TIME.ordinal()] = 7;     // Catch: NoSuchFieldError -> L40
        L76:
            r0[TimeZoneProperty.TimeZoneType.FULL_DATE_TIME.ordinal()] = 8;     // Catch: NoSuchFieldError -> L41
        L90:
            r0[TimeZoneProperty.TimeZoneType.DATE_RANGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L42
        L92:
            r0[TimeZoneProperty.TimeZoneType.DATE_TIME_RANGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L43
        L15:
            a = r0;
            int[] r1 = new int[TimeZoneProperty.FormatType.values().length];
            r1[TimeZoneProperty.FormatType.LONG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L44
        L82:
            r1[TimeZoneProperty.FormatType.SHORT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L45
        L18:
            b = r1;
            int[] r2 = new int[TimeZoneProperty.DateStatusType.values().length];
            r2[TimeZoneProperty.DateStatusType.RELATIVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L46
        L70:
            r2[TimeZoneProperty.DateStatusType.ABSOLUTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L47
        L21:
            c = r2;
            int[] r3 = new int[TimeZoneProperty.TimePrecisionType.values().length];
            r3[TimeZoneProperty.TimePrecisionType.SECOND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L48
        L58:
            r3[TimeZoneProperty.TimePrecisionType.MINUTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L49
        L72:
            r3[TimeZoneProperty.TimePrecisionType.HOUR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L50
        L25:
            d = r3;
            int[] r4 = new int[TimeZoneProperty.TimeStyle.values().length];
            r4[TimeZoneProperty.TimeStyle.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L51
        L74:
            r4[TimeZoneProperty.TimeStyle.BY_12_HOUR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L52
        L86:
            r4[TimeZoneProperty.TimeStyle.BY_24_HOUR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L53
        L29:
            e = r4;
            int[] r5 = new int[TimeZoneProperty.DatePrecisionType.values().length];
            r5[TimeZoneProperty.DatePrecisionType.DAY_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L54
        L80:
            r5[TimeZoneProperty.DatePrecisionType.MONTH_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L55
        L32:
            f = r5;
        }
    }

    static {
    }

    public final String i() {
        return "android.widget.TextView";
    }

    public final boolean j() {
        return true;
    }

    public final DisplayPattern k() {
        TimeZoneProperty.DateStatusType r0 = ((TimeZoneProperty) ((q6c.e) this).e).getDateStatusType();
        int r1 = b.c[r0.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L8;
        return DisplayPattern.ABSOLUTE;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return DisplayPattern.RELATIVE;
    }

    public final LengthType l() {
        TimeZoneProperty.FormatType r0 = ((TimeZoneProperty) ((q6c.e) this).e).getFormatType();
        int r1 = b.b[r0.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L8;
        return LengthType.SHORT;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return LengthType.LONG;
    }

    public final TimePreciseness n() {
        TimeZoneProperty.TimePrecisionType r0 = ((TimeZoneProperty) ((q6c.e) this).e).getTimePrecisionType();
        int r1 = b.d[r0.ordinal()];
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L15;
        if (r1 != 3) goto L10;
        return TimePreciseness.HOUR;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return TimePreciseness.MINUTE;
    L13:
        return TimePreciseness.SECOND;
    }

    public final boolean o() {
        TimeZoneProperty.TimeStyle r0 = ((TimeZoneProperty) ((q6c.e) this).e).getTimeStyle();
        int r1 = b.e[r0.ordinal()];
        if (r1 != 1) goto L5;
        g6b.a.InterfaceC0223a r2 = g6b.a.a;
        if (r2 == null) goto L16;
        com.ss.android.lark.officesdk.integrator.im.b r3 = r2.getCoreDependency();
        if (r3 == null) goto L16;
        return r3.a();
    L16:
        return false;
    L5:
        if (r1 != 2) goto L7;
        return true;
    L7:
        if (r1 == 3) goto L16;
        throw new NoWhenBranchMatchedException();
    }

    public final View a(RectF r3) {
        Intrinsics.checkNotNullParameter(r3, "size");
        r6c.a r1 = ((q6c.a) this).a;
        if (r1 != null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "size");
        return null;
    L5:
        return new TextView(r1.getContext());
    }

    public final s6c.b.a d(s6c.b.a r10) {
        Intrinsics.checkNotNullParameter(r10, "size");
        int r1 = UIHelper.dp2px(r10.a);
        r6c.a r2 = ((q6c.a) this).a;
        if (r2 == null) goto L49;
        Context r3 = r2.getContext();
        if (r3 == null) goto L49;
        int r4 = h6b.a.a;
        Style r5 = this.f;
        FontLevel r6 = null;
        if (r5 == null) goto L10;
        FontLevel r7 = r5.getFontLevel();
    L11:
        int r8 = (int) h6b.a.c(r3, r7);
        Style r9 = this.f;
        if (r9 == null) goto L16;
        ThemeColor r11 = r9.getTextColorV2();
        if (r11 == null) goto L16;
        int r12 = com.ss.android.lark.export.entity.preview.a.a(r11, r3, null);
    L17:
        Style r13 = this.f;
        if (r13 == null) goto L20;
        r6 = r13.getFontLevel();
    L20:
        int r14 = 0;
        if (h6b.a.a(r6) == false) goto L23;
        Typeface r15 = h18.e.b(r3, 1);
    L24:
        TextLayoutBuilder r16 = new TextLayoutBuilder();
        r16.h(m(r3));
        r16.j(r8);
        r16.i(r12);
        r16.f(r1);
        r16.g(true);
        r16.m(r15);
        Layout r17 = r16.a();
        if (r17 != null) goto L28;
        Intrinsics.checkNotNullParameter(r10, "size");
        return r10;
    L28:
        Style r18 = this.f;
        float r0 = 0.0f;
        if (r18 == null) goto L31;
        float r19 = r18.getWidth();
    L32:
        int r110 = UIHelper.dp2px(r19);
        if (r110 <= 0) goto L36;
    L39:
        int r20 = UIHelper.px2dp(r110);
        if (UIHelper.dp2px(r20) == r110) goto L43;
        r14 = 2;
    L43:
        float r21 = r20 + r14;
        if (r110 == 0) goto L48;
        r0 = UIHelper.px2dp(com.ss.android.lark.widget.light.layout.e.a(r17));
    L48:
        return new s6c.b.a(r21, r0);
    L36:
        if (r17.getWidth() <= 0) goto L38;
        r110 = r17.getWidth();
        goto L39
    L38:
        r110 = 0;
        goto L39
    L31:
        r19 = 0.0f;
        goto L32
    L23:
        r15 = h18.e.b(r3, 0);
    L16:
        r12 = UIHelper.getColor(2131106622);
        goto L17
    L10:
        r7 = null;
    L49:
        Intrinsics.checkNotNullParameter(r10, "size");
        return r10;
    }

    public final String m(Context r21) {
        long r5 = 1000;
        Date r2 = new Date(((TimeZoneProperty) ((q6c.e) this).e).getStartTimeStamp() * r5);
        Date r3 = new Date(((TimeZoneProperty) ((q6c.e) this).e).getEndTimeStamp() * r5);
        c7c.a r4 = new c7c.a(null, null, null, null, null, false, false, false, false, 2047);
        String r6 = TimeZone.getDefault().getID();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r4.a = r6;
        switch(b.a[((TimeZoneProperty) ((q6c.e) this).e).getTimeZoneType().ordinal()]) {
            case 1: goto L33;
            case 2: goto L30;
            case 3: goto L28;
            case 4: goto L26;
            case 5: goto L16;
            case 6: goto L14;
            case 7: goto L12;
            case 8: goto L10;
            case 9: goto L8;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        r4.d(n());
        r4.c(l());
        r4.b(k());
        r4.h = o();
        r4.g = ((TimeZoneProperty) ((q6c.e) this).e).getEnableGmt();
        r4.i = false;
        return c7c.b.d(r21, r2, r3, r4);
    L8:
        r4.c(l());
        return c7c.b.b(r21, r2, r3, r4);
    L10:
        r4.d(n());
        r4.c(l());
        r4.b(k());
        r4.h = o();
        r4.g = ((TimeZoneProperty) ((q6c.e) this).e).getEnableGmt();
        r4.i = false;
        return c7c.b.f(r21, r2, r4);
    L12:
        r4.d(n());
        r4.c(l());
        r4.b(k());
        r4.h = o();
        r4.i = false;
        return c7c.b.c(r21, r2, r4);
    L14:
        r4.c(l());
        r4.b(k());
        return c7c.b.e(r21, r2, r4);
    L16:
        int r7 = b.f[((TimeZoneProperty) ((q6c.e) this).e).getDatePrecisionType().ordinal()];
        if (r7 != 1) goto L19;
        DatePreciseness r8 = DatePreciseness.DAY;
    L24:
        r4.a(r8);
        r4.c(l());
        r4.b(k());
        return c7c.b.a(r21, r2, r4);
    L19:
        if (r7 != 2) goto L22;
        r8 = DatePreciseness.MONTH;
        goto L24
    L22:
        throw new NoWhenBranchMatchedException();
    L26:
        r4.d(n());
        r4.h = o();
        r4.i = false;
        return c7c.b.i(r21, r2, r4);
    L28:
        r4.c(l());
        return c7c.b.h(r21, r2, r4);
    L30:
        r4.c(l());
        return c7c.b.l(r21, r2, r4);
    L5:
        throw new NoWhenBranchMatchedException();
    L33:
        return c7c.b.g(r21, r2, r4);
    }

    public void update(TextView r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        r5.setIncludeFontPadding(false);
        r5.setGravity(16);
        Context r1 = r5.getContext();
        Style r2 = this.f;
        if (r2 == null) goto L7;
        ThemeColor r3 = r2.getTextColorV2();
        if (r3 == null) goto L7;
        int r4 = com.ss.android.lark.export.entity.preview.a.a(r3, r1, null);
    L8:
        r5.setTextColor(r4);
        int r6 = h6b.a.a;
        Context r7 = r5.getContext();
        Style r8 = this.f;
        if (r8 == null) goto L11;
        FontLevel r9 = r8.getFontLevel();
    L12:
        r5.setTextSize(0, h6b.a.c(r7, r9));
        TextPaint r10 = r5.getPaint();
        Style r11 = this.f;
        if (r11 == null) goto L15;
        FontLevel r12 = r11.getFontLevel();
    L16:
        r10.setFakeBoldText(h6b.a.a(r12));
        Style r13 = this.f;
        if (r13 == null) goto L19;
        Style.applyBackground$default(r13, r5, null, 2, null);
    L19:
        r5.setText(m(r5.getContext()));
        r5.setOnClickListener(null);
        r5.setClickable(false);
        return;
    L15:
        r12 = null;
        goto L16
    L11:
        r9 = null;
    L7:
        r4 = UIHelper.getColor(2131106622);
        goto L8
    }

    public /* bridge */ /* synthetic */ void update(View r1) {
        update((TextView) r1);
    }

    public v(TimeZoneProperty r2, Style r3, vcb.d r4) {
        Intrinsics.checkNotNullParameter(r2, "props");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2, r3, r4);
        this.f = r3;
    }
}

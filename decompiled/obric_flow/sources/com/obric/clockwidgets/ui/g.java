package com.obric.clockwidgets.ui;

import ai.j0;
import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import com.lynx.tasm.behavior.v0;
import com.obric.clockwidgets.R$array;
import com.obric.clockwidgets.R$id;
import com.obric.clockwidgets.R$string;
import com.obric.clockwidgets.data.WidgetClockCity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements com.obric.clockwidgets.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gu.f f11310c;
    public final WidgetViewBinder$Type d;

    public g(Context r5, int r10, gu.f r11, WidgetViewBinder$Type r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r11, "root");
        Intrinsics.checkNotNullParameter(r12, "type");
        this.f11308a = r5;
        this.f11309b = r10;
        this.f11310c = r11;
        this.d = r12;
    }

    public final void a() {
        ConcurrentHashMap r5 = com.obric.clockwidgets.c.f11255a;
        Intrinsics.checkNotNullParameter(this, "listener");
        ConcurrentHashMap r10 = com.obric.clockwidgets.c.f11255a;
        int r11 = this.f11309b;
        Integer r12 = Integer.valueOf(r11);
        Object r13 = r10.get(r12);
        if (r13 != null) goto L8;
        r13 = new LinkedHashSet();
        Object r14 = r10.putIfAbsent(r12, r13);
        if (r14 == null) goto L8;
        r13 = r14;
    L8:
        ((Set) r13).add(new WeakReference(this));
        b(v0.v(r11, this.f11308a));
    }

    public final void b(ArrayList r10) {
        int r5 = e.f11305a[this.d.ordinal()];
        gu.f r11 = this.f11310c;
        String r12 = "";
        TextView r13 = null;
        if (r5 == 1) goto L29;
        if (r5 != 2) goto L134;
        WidgetClockCity r14 = (WidgetClockCity) CollectionsKt.getOrNull(r10, 0);
        WidgetClockCity r15 = (WidgetClockCity) CollectionsKt.getOrNull(r10, 1);
        WidgetClockCity r16 = (WidgetClockCity) CollectionsKt.getOrNull(r10, 2);
        View r17 = r11.findViewById(R$id.square_clock_analog);
        if ((r17 instanceof SquareClockView) == false) goto L9;
        SquareClockView r18 = (SquareClockView) r17;
    L10:
        if (r18 == null) goto L20;
        if (r14 == null) goto L19;
        String r19 = r14.f11259c;
        if (r19 != null) goto L18;
        TimeZone r20 = r14.e;
        if (r20 == null) goto L17;
        r19 = r20.getID();
        goto L18
    L17:
        r19 = null;
    L18:
        r18.setTimeZoneId(r19);
    L19:
        f r21 = new f(this, r10);
        Intrinsics.checkNotNullParameter(r21, "listener");
        r18.f11289o.add(r21);
    L20:
        View r22 = r11.findViewById(R$id.square_clock_analog_name);
        if ((r22 instanceof TextView) == false) goto L23;
        r13 = (TextView) r22;
    L23:
        if (r13 == null) goto L28;
        if (r14 == null) goto L27;
        r12 = f(r14);
    L27:
        r13.setText(r12);
    L28:
        g(r10);
        return;
    L9:
        r18 = null;
        goto L10
    L134:
        return;
    L29:
        boolean r23 = r11.findViewById(R$id.circle_clock_1) instanceof CircleClockView;
        WidgetClockCity r24 = (WidgetClockCity) CollectionsKt.getOrNull(r10, 0);
        WidgetClockCity r25 = (WidgetClockCity) CollectionsKt.getOrNull(r10, 1);
        WidgetClockCity r26 = (WidgetClockCity) CollectionsKt.getOrNull(r10, 2);
        View r27 = r11.findViewById(R$id.circle_clock_1);
        if ((r27 instanceof CircleClockView) == false) goto L32;
        CircleClockView r28 = (CircleClockView) r27;
    L33:
        if (r28 == null) goto L42;
        if (r24 == null) goto L42;
        String r29 = r24.f11259c;
        if (r29 != null) goto L41;
        TimeZone r30 = r24.e;
        if (r30 == null) goto L40;
        r29 = r30.getID();
        goto L41
    L40:
        r29 = null;
    L41:
        r28.setTimeZoneId(r29);
    L42:
        View r31 = r11.findViewById(R$id.city_name_1);
        if ((r31 instanceof TextView) == false) goto L45;
        TextView r32 = (TextView) r31;
    L46:
        if (r32 == null) goto L52;
        if (r24 == null) goto L50;
        String r33 = f(r24);
    L51:
        r32.setText(r33);
        goto L52
    L50:
        r33 = "";
    L52:
        View r34 = r11.findViewById(R$id.city_offset_1);
        if ((r34 instanceof TextView) == false) goto L55;
        TextView r35 = (TextView) r34;
    L56:
        if (r35 == null) goto L64;
        if (r24 == null) goto L62;
        String r36 = c(r24);
        if (r36 == null) goto L62;
    L63:
        r35.setText(r36);
    L62:
        r36 = "";
    L64:
        View r37 = r11.findViewById(R$id.circle_clock_2);
        if ((r37 instanceof CircleClockView) == false) goto L67;
        CircleClockView r38 = (CircleClockView) r37;
    L68:
        if (r38 == null) goto L77;
        if (r25 == null) goto L77;
        String r39 = r25.f11259c;
        if (r39 != null) goto L76;
        TimeZone r40 = r25.e;
        if (r40 == null) goto L75;
        r39 = r40.getID();
        goto L76
    L75:
        r39 = null;
    L76:
        r38.setTimeZoneId(r39);
    L77:
        View r41 = r11.findViewById(R$id.city_name_2);
        if ((r41 instanceof TextView) == false) goto L80;
        TextView r42 = (TextView) r41;
    L81:
        if (r42 == null) goto L87;
        if (r25 == null) goto L85;
        String r43 = f(r25);
    L86:
        r42.setText(r43);
        goto L87
    L85:
        r43 = "";
    L87:
        View r44 = r11.findViewById(R$id.city_offset_2);
        if ((r44 instanceof TextView) == false) goto L90;
        TextView r45 = (TextView) r44;
    L91:
        if (r45 == null) goto L99;
        if (r25 == null) goto L97;
        String r46 = c(r25);
        if (r46 == null) goto L97;
    L98:
        r45.setText(r46);
    L97:
        r46 = "";
    L99:
        View r47 = r11.findViewById(R$id.circle_clock_3);
        if ((r47 instanceof CircleClockView) == false) goto L102;
        CircleClockView r48 = (CircleClockView) r47;
    L103:
        if (r48 == null) goto L112;
        if (r26 == null) goto L112;
        String r49 = r26.f11259c;
        if (r49 != null) goto L111;
        TimeZone r50 = r26.e;
        if (r50 == null) goto L110;
        r49 = r50.getID();
        goto L111
    L110:
        r49 = null;
    L111:
        r48.setTimeZoneId(r49);
    L112:
        View r51 = r11.findViewById(R$id.city_name_3);
        if ((r51 instanceof TextView) == false) goto L115;
        TextView r52 = (TextView) r51;
    L116:
        if (r52 == null) goto L122;
        if (r26 == null) goto L120;
        String r53 = f(r26);
    L121:
        r52.setText(r53);
        goto L122
    L120:
        r53 = "";
    L122:
        View r54 = r11.findViewById(R$id.city_offset_3);
        if ((r54 instanceof TextView) == false) goto L125;
        r13 = (TextView) r54;
    L125:
        if (r13 == null) goto L135;
        if (r26 == null) goto L131;
        String r55 = c(r26);
        if (r55 == null) goto L131;
        r12 = r55;
    L131:
        r13.setText(r12);
        return;
    L135:
        return;
    L115:
        r52 = null;
        goto L116
    L102:
        r48 = null;
        goto L103
    L90:
        r45 = null;
        goto L91
    L80:
        r42 = null;
        goto L81
    L67:
        r38 = null;
        goto L68
    L55:
        r35 = null;
        goto L56
    L45:
        r32 = null;
        goto L46
    L32:
        r28 = null;
        goto L33
    }

    public final String c(WidgetClockCity r5) {
        String r10 = this.f11308a.getString(R$string.widget_unit_hour);
        TimeZone r11 = TimeZone.getDefault();
        TimeZone r12 = r5.e;
        if (r12 != null) goto L11;
        String r13 = r5.f11259c;
        if (r13 == null) goto L8;
        TimeZone r14 = TimeZone.getTimeZone(r13);
    L7:
        r12 = r14;
        if (r12 != null) goto L11;
        r12 = r11;
        goto L11
    L8:
        r14 = null;
    L11:
        long r15 = System.currentTimeMillis();
        int r16 = (r12.getOffset(r15) - r11.getOffset(r15)) / 3600000;
        if (r16 > 0) goto L18;
        if (r16 >= 0) goto L17;
        return r16 + r10;
    L17:
        return j0.C("+0", r10);
    L18:
        return j0.h(r16, "+", r10);
    }

    public final String d(WidgetClockCity r5) {
        boolean r10 = DateFormat.is24HourFormat(this.f11308a);
        TimeZone r11 = r5.e;
        if (r11 != null) goto L11;
        String r12 = r5.f11259c;
        if (r12 == null) goto L8;
        TimeZone r13 = TimeZone.getTimeZone(r12);
    L7:
        r11 = r13;
        if (r11 != null) goto L11;
        r11 = TimeZone.getDefault();
        goto L11
    L8:
        r13 = null;
    L11:
        Calendar r14 = Calendar.getInstance(r11);
        int r15 = 12;
        int r16 = r14.get(12);
        if (r10 == false) goto L16;
        int r17 = r14.get(11);
        StringCompanionObject r18 = StringCompanionObject.INSTANCE;
        return String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r17), Integer.valueOf(r16)}, 2));
    L16:
        if (r14.get(9) != 0) goto L18;
        String r19 = "AM";
    L19:
        int r20 = r14.get(10);
        if (r20 == 0) goto L23;
        r15 = r20;
    L23:
        StringCompanionObject r21 = StringCompanionObject.INSTANCE;
        return String.format("%02d:%02d %s", Arrays.copyOf(new Object[]{Integer.valueOf(r15), Integer.valueOf(r16), r19}, 3));
    L18:
        r19 = "PM";
        goto L19
    }

    public final String e(WidgetClockCity r5) {
        String r10 = f(r5);
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), Locale.CHINESE.getLanguage()) == false) goto L5;
        int r11 = 5;
    L7:
        if (r10.length() > r11) goto L9;
        return r10;
    L9:
        return r10.substring(0, r11) + "...";
    L5:
        r11 = 12;
        goto L7
    }

    public final String f(WidgetClockCity r10) {
        String r5 = r10.f11257a;
        Context r11 = this.f11308a;
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r11, "context");
        int r12 = -1;
        if (r5 != null) goto L5;
    L13:
        String r13 = null;
        if (r12 < 0) goto L20;
        String[] r14 = r11.getResources().getStringArray(R$array.cities_names);
        if (r12 >= r14.length) goto L20;
        r13 = r14[r12];
    L20:
        if (r13 != null) goto L27;
        String r15 = r10.f11258b;
        if (r15 != null) goto L28;
        return "";
    L28:
        return r15;
    L27:
        return r13;
    L5:
        if (r5.length() == 0) goto L13;
        String[] r16 = r11.getResources().getStringArray(R$array.cities_id);
        int r17 = r16.length;
        int r18 = 0;
    L8:
        if (r18 >= r17) goto L13;
        if (Intrinsics.areEqual(r5, r16[r18]) == true) goto L11;
        r18 = r18 + 1;
        goto L8
    L11:
        r12 = r18;
        goto L13
    }

    public final void g(ArrayList r10) {
        WidgetClockCity r5 = (WidgetClockCity) CollectionsKt.getOrNull(r10, 1);
        WidgetClockCity r11 = (WidgetClockCity) CollectionsKt.getOrNull(r10, 2);
        int r12 = R$id.square_city_time_2;
        gu.f r13 = this.f11310c;
        View r14 = r13.findViewById(r12);
        TextView r15 = null;
        if ((r14 instanceof TextView) == false) goto L5;
        TextView r16 = (TextView) r14;
    L6:
        String r17 = "";
        if (r16 == null) goto L13;
        if (r5 == null) goto L11;
        String r18 = d(r5);
    L12:
        r16.setText(r18);
        goto L13
    L11:
        r18 = "";
    L13:
        View r19 = r13.findViewById(R$id.square_city_time_3);
        if ((r19 instanceof TextView) == false) goto L16;
        TextView r20 = (TextView) r19;
    L17:
        if (r20 == null) goto L23;
        if (r11 == null) goto L21;
        String r21 = d(r11);
    L22:
        r20.setText(r21);
        goto L23
    L21:
        r21 = "";
    L23:
        View r22 = r13.findViewById(R$id.square_city_offset_2);
        if ((r22 instanceof TextView) == false) goto L26;
        TextView r23 = (TextView) r22;
    L28:
        if (r23 == null) goto L40;
        if (r5 == null) goto L38;
        StringBuilder r24 = new StringBuilder();
        r24.append(e(r5));
        r24.append(' ');
        if (TextUtils.isEmpty(c(r5)) == false) goto L34;
        String r25 = "";
    L35:
        r24.append(r25);
        String r26 = r24.toString();
        if (r26 == null) goto L38;
    L39:
        r23.setText(r26);
        goto L40
    L34:
        r25 = "| " + c(r5);
    L38:
        r26 = "";
    L40:
        View r27 = r13.findViewById(R$id.square_city_offset_3);
        if ((r27 instanceof TextView) == false) goto L43;
        r15 = (TextView) r27;
    L43:
        if (r15 == null) goto L55;
        if (r11 == null) goto L53;
        StringBuilder r28 = new StringBuilder();
        r28.append(e(r11));
        r28.append(' ');
        if (TextUtils.isEmpty(c(r11)) == false) goto L49;
        String r29 = "";
    L50:
        r28.append(r29);
        String r30 = r28.toString();
        if (r30 == null) goto L53;
        r17 = r30;
        goto L53
    L49:
        r29 = "| " + c(r11);
    L53:
        r15.setText(r17);
        return;
    L55:
        return;
    L26:
        r23 = null;
        goto L28
    L16:
        r20 = null;
        goto L17
    L5:
        r16 = null;
        goto L6
    }
}

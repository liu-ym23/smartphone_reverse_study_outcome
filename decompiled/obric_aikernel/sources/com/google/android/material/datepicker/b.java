package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    final a f3201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    final a f3202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    final a f3203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    final a f3204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    final a f3205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    final a f3206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    final a f3207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    final Paint f3208h;

    b(@NonNull Context r10) {
        TypedArray r11 = r10.obtainStyledAttributes(com.google.android.material.resources.b.d(r10, q5.b.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), l.MaterialCalendar);
        this.f3201a = a.a(r10, r11.getResourceId(l.MaterialCalendar_dayStyle, 0));
        this.f3207g = a.a(r10, r11.getResourceId(l.MaterialCalendar_dayInvalidStyle, 0));
        this.f3202b = a.a(r10, r11.getResourceId(l.MaterialCalendar_daySelectedStyle, 0));
        this.f3203c = a.a(r10, r11.getResourceId(l.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList r12 = com.google.android.material.resources.c.a(r10, r11, l.MaterialCalendar_rangeFillColor);
        this.f3204d = a.a(r10, r11.getResourceId(l.MaterialCalendar_yearStyle, 0));
        this.f3205e = a.a(r10, r11.getResourceId(l.MaterialCalendar_yearSelectedStyle, 0));
        this.f3206f = a.a(r10, r11.getResourceId(l.MaterialCalendar_yearTodayStyle, 0));
        Paint r13 = new Paint();
        this.f3208h = r13;
        r13.setColor(r12.getDefaultColor());
        r11.recycle();
    }
}

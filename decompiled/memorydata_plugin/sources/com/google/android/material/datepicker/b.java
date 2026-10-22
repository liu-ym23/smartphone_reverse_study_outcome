package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a f3881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a f3882b;
    final a c;
    final a d;
    final a e;
    final a f;
    final a g;
    final Paint h;

    b(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        TypedArray r0 = r8.obtainStyledAttributes(com.google.android.material.resources.b.a(r8, ZeusTransformUtils.mapRes(R.attr.materialCalendarStyle, "attr", "materialCalendarStyle"), MaterialCalendar.class.getCanonicalName()), R.styleable.MaterialCalendar);
        this.f3881a = a.a(r8, r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendar_dayStyle, "styleable", "MaterialCalendar_dayStyle"), 0));
        this.g = a.a(r8, r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendar_dayInvalidStyle, "styleable", "MaterialCalendar_dayInvalidStyle"), 0));
        this.f3882b = a.a(r8, r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendar_daySelectedStyle, "styleable", "MaterialCalendar_daySelectedStyle"), 0));
        this.c = a.a(r8, r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendar_dayTodayStyle, "styleable", "MaterialCalendar_dayTodayStyle"), 0));
        ColorStateList r1 = com.google.android.material.resources.c.a(r8, r0, ZeusTransformUtils.mapRes(R.styleable.MaterialCalendar_rangeFillColor, "styleable", "MaterialCalendar_rangeFillColor"));
        this.d = a.a(r8, r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendar_yearStyle, "styleable", "MaterialCalendar_yearStyle"), 0));
        this.e = a.a(r8, r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendar_yearSelectedStyle, "styleable", "MaterialCalendar_yearSelectedStyle"), 0));
        this.f = a.a(r8, r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendar_yearTodayStyle, "styleable", "MaterialCalendar_yearTodayStyle"), 0));
        Paint r9 = new Paint();
        this.h = r9;
        r9.setColor(r1.getDefaultColor());
        r0.recycle();
    }
}

package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class e extends BaseAdapter {
    private static final int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Calendar f3889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3890b;
    private final int c;

    static {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        int r0 = 4;
    L6:
        d = r0;
        return;
    L5:
        r0 = 1;
        goto L6
    }

    public e() {
        Calendar r0 = j.c();
        this.f3889a = r0;
        this.f3890b = r0.getMaximum(7);
        this.c = r0.getFirstDayOfWeek();
    }

    private int b(int r2) {
        int r3 = r2 + this.c;
        int r1 = this.f3890b;
        if (r3 > r1) goto L5;
        return r3;
    L5:
        return r3 - r1;
    }

    public Integer a(int r2) {
        if (r2 < this.f3890b) goto L7;
        return null;
    L7:
        return Integer.valueOf(b(r2));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3890b;
    }

    @Override // android.widget.Adapter
    public /* synthetic */ Object getItem(int r1) {
        return a(r1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int r6, View r7, ViewGroup r8) {
        TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        r0 = (TextView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.mtrl_calendar_day_of_week, "layout", "mtrl_calendar_day_of_week"), r8, false, "com.obric.memorydata.plugin"), TextView.class, "com.obric.memorydata.plugin");
    L5:
        this.f3889a.set(7, b(r6));
        r0.setText(this.f3889a.getDisplayName(7, d, ZeusTransformUtils.getResources(r0, "com.obric.memorydata.plugin").getConfiguration().locale));
        r0.setContentDescription(String.format(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_day_of_week_column_header, TypedValues.Custom.S_STRING, "mtrl_picker_day_of_week_column_header")), new Object[]{this.f3889a.getDisplayName(7, 2, Locale.getDefault())}));
        return r0;
    }
}

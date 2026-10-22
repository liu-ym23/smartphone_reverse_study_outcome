package com.obric.clockwidgets.providers;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;
import com.obric.clockwidgets.R$layout;
import com.obric.clockwidgets.c;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/clockwidgets/providers/ClockWidgetLargeCircleProvider;", "Landroid/appwidget/AppWidgetProvider;", "<init>", "()V", "clockwidgets_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@RemoteViews.RemoteView
public final class ClockWidgetLargeCircleProvider extends AppWidgetProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComponentName f11260a = null;

    static {
        ConcurrentHashMap r5 = c.f11255a;
        f11260a = new ComponentName("com.android.launcher3", ClockWidgetLargeCircleProvider.class.getName());
    }

    public ClockWidgetLargeCircleProvider() {
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context r10, AppWidgetManager r11, int[] r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appWidgetManager");
        Intrinsics.checkNotNullParameter(r12, "appWidgetIds");
        int r5 = r12.length;
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L5;
        r11.updateAppWidget(r12[r13], new RemoteViews(r10.getPackageName(), R$layout.widget_clock_large_circle));
        r13 = r13 + 1;
        goto L3
    }
}

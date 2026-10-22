package com.obric.clockwidgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lynx.tasm.behavior.v0;
import com.obric.clockwidgets.data.WidgetClockCity;
import com.obric.clockwidgets.ui.WidgetClockCityAdapter;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.ArrayList;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/clockwidgets/ClockWidgetConfigActivity;", "Landroid/app/Activity;", "<init>", "()V", "clockwidgets_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClockWidgetConfigActivity extends Activity {
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f11247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f11248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11249c;
    public int d;

    public ClockWidgetConfigActivity() {
        this.f11247a = LazyKt.lazy(new ClockWidgetConfigActivity$titleBar$2(this));
        this.f11248b = LazyKt.lazy(new ClockWidgetConfigActivity$recyclerView$2(this));
        this.f11249c = -1;
    }

    @Override // android.app.Activity
    public final void onActivityResult(int r10, int r11, Intent r12) {
        super.onActivityResult(r10, r11, r12);
        if (r10 == 1001) goto L5;
        return;
    L5:
        if (r11 != (-1)) goto L33;
        if (r12 == null) goto L34;
        Bundle r13 = r12.getExtras();
        String r14 = null;
        if (r13 == null) goto L10;
        String r5 = r13.getString("city_id");
    L11:
        if (r13 == null) goto L13;
        r14 = r13.getString("city_time_zone");
    L13:
        String r15 = r14;
        if (r5 != null) goto L16;
        return;
    L16:
        if (r5.length() == 0) goto L38;
        if (r15 != null) goto L20;
        return;
    L20:
        if (r15.length() != 0) goto L23;
        return;
    L23:
        if (this.f11249c == (-1)) goto L37;
        WidgetClockCity r16 = new WidgetClockCity(r5, r15, System.currentTimeMillis(), TimeZone.getTimeZone(r15));
        RecyclerView.Adapter r17 = ((RecyclerView) this.f11248b.getValue()).getAdapter();
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type com.obric.clockwidgets.ui.WidgetClockCityAdapter");
        WidgetClockCityAdapter r18 = (WidgetClockCityAdapter) r17;
        int r19 = this.f11249c;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r16, "newItem");
        ArrayList r20 = r18.f11291b;
        if (r19 >= 0) goto L27;
    L30:
        v0.A(this, new ArrayList(r20), this.d);
        c.a(this.d, this);
        this.f11249c = -1;
        return;
    L27:
        if (r19 >= r20.size()) goto L30;
        r20.set(r19, r16);
        r18.notifyItemChanged(r19);
        goto L30
    L37:
        return;
    L38:
        return;
    L10:
        r5 = null;
        goto L11
    L34:
        return;
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        setContentView(R$layout.widget_clock_config_activity);
        Intent r10 = getIntent();
        boolean r11 = false;
        if (r10 == null) goto L7;
        Bundle r12 = r10.getExtras();
        if (r12 == null) goto L7;
        int r13 = r12.getInt("appWidgetId", 0);
    L8:
        this.d = r13;
        Log.d("ClockWidgetConfigActivity", "onCreate, widgetId: " + this.d);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L11;
        r11 = true;
    L11:
        WindowInsetsControllerCompat r14 = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        boolean r15 = !r11;
        r14.setAppearanceLightStatusBars(r15);
        r14.setAppearanceLightNavigationBars(r15);
        OFloatingTitleBar r16 = (OFloatingTitleBar) this.f11247a.getValue();
        int r17 = com.obric.common.oui.R$drawable.o_floating_title_bar_icon_close;
        ar.a r18 = new ar.a(this, 10);
        int r19 = OFloatingTitleBar.C;
        r16.c(r17, -1, r18);
        Lazy r20 = this.f11248b;
        ((RecyclerView) r20.getValue()).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView) r20.getValue()).setAdapter(new WidgetClockCityAdapter(this, v0.v(this.d, this), new AnonymousClass3(this)));
        RecyclerView.Adapter r21 = ((RecyclerView) r20.getValue()).getAdapter();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type com.obric.clockwidgets.ui.WidgetClockCityAdapter");
        final WidgetClockCityAdapter r22 = (WidgetClockCityAdapter) r21;
        new ItemTouchHelper(new ClockWidgetConfigActivity$onCreate$touchHelper$1(r22, this)).attachToRecyclerView((RecyclerView) r20.getValue());
        return;
    L7:
        r13 = 0;
        goto L8
    }
}

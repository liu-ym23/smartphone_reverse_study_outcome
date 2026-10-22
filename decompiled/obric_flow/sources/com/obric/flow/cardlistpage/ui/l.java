package com.obric.flow.cardlistpage.ui;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.obric.feature.miniapp.widget.MiniAppWidgetProviderInfo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gu.d f11783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppWidgetManager f11784c;
    public final CoroutineScope d;
    public final Function1 e;
    public final Function1 f;
    public final Function0 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ResultReceiver f11786i;

    public l(Context r5, gu.d r10, AppWidgetManager r11, CoroutineScope r12, Function1 r13, Function1 r14, Function0 r15) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "appWidgetHost");
        Intrinsics.checkNotNullParameter(r11, "appWidgetManager");
        Intrinsics.checkNotNullParameter(r12, "coroutineScope");
        Intrinsics.checkNotNullParameter(r13, "onWidgetPicked");
        Intrinsics.checkNotNullParameter(r14, "onMiniAppWidgetPicked");
        Intrinsics.checkNotNullParameter(r15, "onPickerCancelled");
        this.f11782a = r5;
        this.f11783b = r10;
        this.f11784c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f11785h = -1;
        final Handler r16 = new Handler(Looper.getMainLooper());
        ResultReceiver r17 = new WidgetPickerCoordinator$pickWidgetResultReceiver$1$receiver$1(this, r16);
        Parcel r18 = Parcel.obtain();
        r17.writeToParcel(r18, 0);
        r18.setDataPosition(0);
        this.f11786i = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(r18);
    }

    public final void a() {
        int r5 = this.f11785h;
        if (r5 == (-1)) goto L5;
        this.f11783b.deleteAppWidgetId(r5);
    L5:
        this.f11785h = -1;
    }

    public final void b(Intent r5) {
        obric.flow.miniappwidget.f r10 = obric.flow.miniappwidget.g.d(r5);
        if (r10 != null) goto L10;
        Intrinsics.checkNotNullParameter("WidgetPickerCoordinator", "tag");
        Intrinsics.checkNotNullParameter("handleMiniAppWidgetPickerResult failed: definition is invalid", "msg");
        org.koin.core.a r11 = su.a.f22013b;
        if (r11 == null) goto L9;
        ((ju.b) r11.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("WidgetPickerCoordinator", "handleMiniAppWidgetPickerResult failed: definition is invalid");
        a();
        this.g.invoke();
        return;
    L9:
        throw new IllegalStateException("KoinApplication has not been started");
    L10:
        a();
        this.f.invoke(r10);
    }

    public final void c(int r11, Intent r12) {
        Function0 r5 = this.g;
        if (r11 == (-1)) goto L7;
        a();
        r5.invoke();
        return;
    L7:
        if (r12 != null) goto L15;
        Intrinsics.checkNotNullParameter("WidgetPickerCoordinator", "tag");
        Intrinsics.checkNotNullParameter("handlePickerResult ignored: data is null", "msg");
        org.koin.core.a r10 = su.a.f22013b;
        if (r10 == null) goto L13;
        ((ju.b) r10.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("WidgetPickerCoordinator", "handlePickerResult ignored: data is null");
        a();
        r5.invoke();
        return;
    L13:
        throw new IllegalStateException("KoinApplication has not been started");
    L15:
        if (this.f11785h != (-1)) goto L22;
        Intrinsics.checkNotNullParameter("WidgetPickerCoordinator", "tag");
        Intrinsics.checkNotNullParameter("handlePickerResult ignored: pendingSession is -1", "msg");
        org.koin.core.a r13 = su.a.f22013b;
        if (r13 == null) goto L21;
        ((ju.b) r13.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("WidgetPickerCoordinator", "handlePickerResult ignored: pendingSession is -1");
        return;
    L21:
        throw new IllegalStateException("KoinApplication has not been started");
    L22:
        int r14 = r12.getIntExtra("appWidgetId", 0);
        if (r14 != 0) goto L45;
        ComponentName r15 = (ComponentName) r12.getParcelableExtra("android.intent.extra.COMPONENT_NAME");
        if (r15 != null) goto L29;
        r15 = (ComponentName) r12.getParcelableExtra("appWidgetProvider");
        if (r15 != null) goto L29;
        r15 = r12.getComponent();
    L29:
        if (r15 == null) goto L34;
        Intrinsics.checkNotNullParameter(r15, "<this>");
        if (MiniAppWidgetProviderInfo.Companion.isMiniAppWidgetComponent(r15) == false) goto L34;
        b(r12);
        return;
    L34:
        if (r15 == null) goto L45;
        if (this.f11784c.bindAppWidgetIdIfAllowed(this.f11785h, r15) == false) goto L38;
        r14 = this.f11785h;
        goto L45
    L38:
        String r16 = "handlePickerResult bindAppWidgetIdIfAllowed failed: component=" + r15;
        Intrinsics.checkNotNullParameter("WidgetPickerCoordinator", "tag");
        Intrinsics.checkNotNullParameter(r16, "msg");
        org.koin.core.a r17 = su.a.f22013b;
        if (r17 == null) goto L43;
        ((ju.b) r17.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("WidgetPickerCoordinator", r16);
        a();
        r5.invoke();
        return;
    L43:
        throw new IllegalStateException("KoinApplication has not been started");
    L45:
        if (obric.flow.miniappwidget.g.b(r12) == false) goto L48;
        b(r12);
        return;
    L48:
        if (r14 != 0) goto L55;
        Intrinsics.checkNotNullParameter("WidgetPickerCoordinator", "tag");
        Intrinsics.checkNotNullParameter("handlePickerResult ignored: appWidgetId is invalid", "msg");
        org.koin.core.a r18 = su.a.f22013b;
        if (r18 == null) goto L54;
        ((ju.b) r18.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("WidgetPickerCoordinator", "handlePickerResult ignored: appWidgetId is invalid");
        a();
        r5.invoke();
        return;
    L54:
        throw new IllegalStateException("KoinApplication has not been started");
    L55:
        this.f11785h = -1;
        this.e.invoke(Integer.valueOf(r14));
    }
}

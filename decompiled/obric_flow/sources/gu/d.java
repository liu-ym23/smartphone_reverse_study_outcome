package gu;

import ai.j0;
import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.os.DeadObjectException;
import android.os.TransactionTooLargeException;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import obric.flow.appwidget.FlowAppWidgetProviderInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends AppWidgetHost {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f17229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray f17230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f17231c;

    public d(Context r5) {
        super(r5, 1024);
        this.f17229a = new ArrayList();
        this.f17230b = new SparseArray();
        this.f17231c = r5;
    }

    @Override // android.appwidget.AppWidgetHost
    public final void clearViews() {
        super.clearViews();
        this.f17230b.clear();
    }

    @Override // android.appwidget.AppWidgetHost
    public final void deleteAppWidgetId(int r5) {
        super.deleteAppWidgetId(r5);
        this.f17230b.remove(r5);
    }

    @Override // android.appwidget.AppWidgetHost
    public final void onAppWidgetRemoved(int r5) {
    }

    @Override // android.appwidget.AppWidgetHost
    public final AppWidgetHostView onCreateView(Context r5, int r10, AppWidgetProviderInfo r11) {
        f r12 = new f(r5);
        this.f17230b.put(r10, r12);
        return r12;
    }

    @Override // android.appwidget.AppWidgetHost
    public final void onProviderChanged(int r10, AppWidgetProviderInfo r11) {
        String r5 = "onProviderChanged: " + r10;
        Intrinsics.checkNotNullParameter("FlowAppWidgetHost", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        org.koin.core.a r12 = su.a.f22013b;
        if (r12 == null) goto L12;
        ((ju.b) r12.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).d("FlowAppWidgetHost", r5);
        onProvidersChanged();
        if (r11 != null) goto L7;
    L9:
        super.onProviderChanged(r10, r11);
        return;
    L7:
        if ((r11 instanceof FlowAppWidgetProviderInfo) == true) goto L9;
        r11 = FlowAppWidgetProviderInfo.c(r11);
        goto L9
    L12:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // android.appwidget.AppWidgetHost
    public final void onProvidersChanged() {
        ArrayList r5 = this.f17229a;
        if (r5.isEmpty() == true) goto L9;
        Iterator r10 = new ArrayList(r5).iterator();
        if (r10.hasNext() == false) goto L10;
        j0.A(r10.next());
        throw null;
    L10:
        return;
    }

    @Override // android.appwidget.AppWidgetHost
    public final void startListening() {
        super.startListening();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        if ((e.getCause() instanceof TransactionTooLargeException) == false) goto L8;
        return;
    L8:
        if ((e.getCause() instanceof DeadObjectException) == false) goto L11;
        return;
    L11:
        throw new RuntimeException(e);
    }
}

package fq;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import gu.d;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppWidgetManager f16973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f16974b;

    public a(Context r5, AppWidgetManager r10, d r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "appWidgetManager");
        Intrinsics.checkNotNullParameter(r11, "appWidgetHost");
        this.f16973a = r10;
        this.f16974b = r11;
    }

    public final boolean a(int r5) {
        if (r5 != (-1)) goto L5;
        return false;
    L5:
        if (r5 == Integer.parseInt("-100")) goto L27;
        AppWidgetManager r10 = this.f16973a;
        AppWidgetProviderInfo r11 = r10.getAppWidgetInfo(r5);
        if (r11 != null) goto L10;
        return false;
    L10:
        List<AppWidgetProviderInfo> r12 = r10.getInstalledProviders();
        if (r12 != null) goto L14;
        return false;
    L14:
        if (r12.isEmpty() == true) goto L28;
        Iterator<T> r13 = r12.iterator();
    L18:
        if (r13.hasNext() == false) goto L29;
        if (Intrinsics.areEqual(((AppWidgetProviderInfo) r13.next()).provider, r11.provider) == false) goto L18;
        return true;
    L29:
        return false;
    L28:
        return false;
    L27:
        return false;
    }
}

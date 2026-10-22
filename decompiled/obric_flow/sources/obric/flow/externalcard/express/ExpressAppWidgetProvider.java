package obric.flow.externalcard.express;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lobric/flow/externalcard/express/ExpressAppWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "<init>", "()V", "ExternalCard_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ExpressAppWidgetProvider extends AppWidgetProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComponentName f20443a = null;

    static {
        f20443a = new ComponentName("obric.home.flow", "obric.flow.externalcard.express.ExpressAppWidgetProvider");
    }

    public ExpressAppWidgetProvider() {
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context r5, AppWidgetManager r10, int[] r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "appWidgetManager");
        Intrinsics.checkNotNullParameter(r11, "appWidgetIds");
    }
}

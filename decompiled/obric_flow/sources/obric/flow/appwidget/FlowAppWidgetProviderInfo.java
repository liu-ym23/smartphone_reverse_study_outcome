package obric.flow.appwidget;

import android.appwidget.AppWidgetProviderInfo;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public class FlowAppWidgetProviderInfo extends AppWidgetProviderInfo {
    public static FlowAppWidgetProviderInfo c(AppWidgetProviderInfo r5) {
        if ((r5 instanceof FlowAppWidgetProviderInfo) == false) goto L5;
        FlowAppWidgetProviderInfo r10 = (FlowAppWidgetProviderInfo) r5;
    L6:
        r10.getClass();
        return r10;
    L5:
        Parcel r11 = Parcel.obtain();
        r5.writeToParcel(r11, 0);
        r11.setDataPosition(0);
        r10 = new FlowAppWidgetProviderInfo(r11);
        r11.recycle();
        goto L6
    }
}

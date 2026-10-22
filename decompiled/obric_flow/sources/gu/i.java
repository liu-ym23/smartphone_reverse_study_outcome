package gu;

import com.obric.clockwidgets.R$layout;
import com.obric.clockwidgets.R$string;
import com.obric.clockwidgets.providers.ClockWidgetLargeCircleProvider;
import com.obric.clockwidgets.providers.ClockWidgetLargeSquareProvider;
import com.obric.clockwidgets.providers.ClockWidgetSmallCircleProvider;
import com.obric.clockwidgets.providers.ClockWidgetSmallSquareProvider;
import com.zte.miboard.cards.R;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import obric.flow.externalcard.express.ExpressAppWidgetProvider;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f17250a = null;

    static {
        f17250a = MapsKt.mapOf(new Pair[]{TuplesKt.to(ClockWidgetSmallCircleProvider.f11262a, new c(R$layout.widget_clock_small_circle, Integer.valueOf(R$string.launcher_widget_name))), TuplesKt.to(ClockWidgetSmallSquareProvider.f11263a, new c(R$layout.widget_clock_small_square, Integer.valueOf(R$string.launcher_widget_name))), TuplesKt.to(ClockWidgetLargeCircleProvider.f11260a, new c(R$layout.widget_clock_large_circle, Integer.valueOf(R$string.launcher_widget_name))), TuplesKt.to(ClockWidgetLargeSquareProvider.f11261a, new c(R$layout.widget_clock_large_square, Integer.valueOf(R$string.launcher_widget_name))), TuplesKt.to(ExpressAppWidgetProvider.f20443a, new c(obric.flow.externalcard.R$layout.external_express_appwidget, Integer.valueOf(R.string.express_card)))});
    }
}

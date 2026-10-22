package com.obric.clockwidgets.ui;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/obric/clockwidgets/ui/WidgetViewBinder$Type", "", "Lcom/obric/clockwidgets/ui/WidgetViewBinder$Type;", "CircleLarge", "SquareLarge", "clockwidgets_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum WidgetViewBinder$Type extends Enum<WidgetViewBinder$Type> {
    public static final WidgetViewBinder$Type CircleLarge = null;
    public static final WidgetViewBinder$Type SquareLarge = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WidgetViewBinder$Type[] f11294a = null;

    static {
        WidgetViewBinder$Type r5 = new WidgetViewBinder$Type("CircleLarge", 0);
        CircleLarge = r5;
        WidgetViewBinder$Type r10 = new WidgetViewBinder$Type("SquareLarge", 1);
        SquareLarge = r10;
        f11294a = new WidgetViewBinder$Type[]{r5, r10};
    }

    public static WidgetViewBinder$Type valueOf(String r5) {
        return (WidgetViewBinder$Type) Enum.valueOf(WidgetViewBinder$Type.class, r5);
    }

    public static WidgetViewBinder$Type[] values() {
        return (WidgetViewBinder$Type[]) f11294a.clone();
    }
}

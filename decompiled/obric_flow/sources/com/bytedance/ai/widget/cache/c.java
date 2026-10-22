package com.bytedance.ai.widget.cache;

import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.bytedance.keva.Keva;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f2983a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ConversationWidgetData f2984b;

    static {
        f2983a = Keva.getRepo("AI_SDK_LAST_WIDGET_REPO");
    }

    public static void a() {
        BuildersKt.launch$default(h0.a(t2.b.f22089a), null, null, new LastWidgetPreloader$preloadLastWidget$1(null), 3, null);
    }

    public static void b(ConversationWidgetData r5) {
        Intrinsics.checkNotNullParameter(r5, "widgetCache");
        if (Intrinsics.areEqual(f2984b, r5) == true) goto L9;
        String r10 = "saveLastWidget: packageName = " + r5.getPackageName() + ", widgetId = " + r5.getWidgetId();
        Intrinsics.checkNotNullParameter("LastWidgetPreloader", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L7;
        r11.i("LastWidgetPreloader", r10);
    L7:
        f2984b = r5;
        Intrinsics.checkNotNullParameter(r5, "value");
        f2983a.storeString("LAST_WIDGET", z0.a.a().toJson(r5));
        return;
    }
}

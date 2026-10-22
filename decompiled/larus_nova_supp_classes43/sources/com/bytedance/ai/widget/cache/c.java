package com.bytedance.ai.widget.cache;

import com.bytedance.ai.utils.g;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.bytedance.keva.Keva;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final Keva a = null;
    public static ConversationWidgetData b;
    public static volatile String c;

    static {
        a = Keva.getRepo("AI_SDK_LAST_WIDGET_REPO");
    }

    public static void a() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new LastWidgetPreloader$preloadLastWidget$1(null), 3, null);
    }

    public static void b(ConversationWidgetData r10) {
        Intrinsics.checkNotNullParameter(r10, "widgetCache");
        if (Intrinsics.areEqual(b, r10) == true) goto L6;
        g.a.i("LastWidgetPreloader", "saveLastWidget: packageName = " + r10.getPackageName() + ", widgetId = " + r10.getWidgetId());
        b = r10;
        a.storeString("LAST_WIDGET", com.bytedance.ai.applet.base.gson.e.c(r10));
        return;
    }
}

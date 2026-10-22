package com.larus.canvas.feature.component.logic.exit;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CanvasExitAnchorManager {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(new a());
        b = LazyKt.lazy(new b());
    }

    public static void a(String r6, String r7, boolean r8) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CanvasExitAnchorManager$notifyCanvasAnchorEvent$1(r6, r7, r8, null), 3, null);
    }
}

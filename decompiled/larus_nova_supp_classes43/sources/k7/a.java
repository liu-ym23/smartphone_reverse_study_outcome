package k7;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final String c(AnnieXLiveContext r10) {
        StringBuilder r0 = new StringBuilder("[");
        if (r10 == null) goto L6;
        String r11 = Integer.valueOf(r10.hashCode()).toString();
        if (r11 == null) goto L6;
    L7:
        r0.append(r11);
        r0.append(']');
        return r0.toString();
    L6:
        r11 = "unknown";
        goto L7
    }

    public static final void a(String r10, String r11, AnnieXLiveContext r12) {
        Intrinsics.checkNotNullParameter(HybridLogger.a, "<this>");
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        HybridLogger.i(r10, c(r12) + r11, null, 12);
    }

    public static final void b(String r10, String r11, AnnieXLiveContext r12) {
        Intrinsics.checkNotNullParameter(HybridLogger.a, "<this>");
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        HybridLogger.m(r10, c(r12) + r11, null, null, 12);
    }
}

package obric.flow.miniappwidget;

import com.obric.widget.host.runtime.WidgetDataChangedEvent;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final void a(CoroutineScope r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        BuildersKt.launch$default(r10, null, null, new MiniAppHostedWidgetKt$launchSafely$1(r11, null), 3, null);
    }

    public static final String b(WidgetDataChangedEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r5 = r10.getAppletId();
        String r11 = r10.getWidgetId();
        String r12 = String.valueOf(r10.getInstanceId());
        String r13 = r10.getWidgetData();
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        Long r14 = r10.getDataVersion();
        String r15 = null;
        if (r14 == null) goto L8;
        String r16 = r14.toString();
    L9:
        if (r16 != null) goto L11;
        r16 = "";
    L11:
        Long r17 = r10.getUpdatedAt();
        if (r17 == null) goto L14;
        r15 = r17.toString();
    L14:
        if (r15 != null) goto L16;
        r15 = "";
    L16:
        String r18 = r10.getState();
        if (r18 != null) goto L19;
        String r19 = "";
    L21:
        return CollectionsKt.q(CollectionsKt.listOf(new String[]{r5, r11, r12, r13, r16, r15, r19}), "\u001f", null, null, 0, null, null, 62);
    L19:
        r19 = r18;
        goto L21
    L8:
        r16 = null;
        goto L9
    }
}

package y7;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.debug.AnnieDebugTool;
import com.bytedance.android.annie.debug.service.GeckoOfflineInfoHolder;
import com.bytedance.android.annie.debug.ui.DialogItem;
import com.bytedance.android.annie.debug.ui.i;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements d {
    public final AnnieCard a;

    @Override // y7.d
    public final String getTitle() {
        return "OFFLINE";
    }

    @Override // y7.d
    public final List<DialogItem> a() {
        LinkedList r0 = new LinkedList();
        View r1 = this.a.getHybridView();
        int r10 = a8.a.a;
        String r11 = "";
        if (r1 == null) goto L15;
        Intrinsics.checkNotNullParameter(r1, "view");
        if ((r1 instanceof WebView) == false) goto L12;
        String r12 = ((WebView) r1).getUrl();
        if (r12 == null) goto L15;
    L10:
        r11 = r12;
        goto L15
    L12:
        if (((r9.c) Annie.getService$default(r9.c.class, null, 2, null)).c(r1) == false) goto L15;
        r12 = ((r9.c) Annie.getService$default(r9.c.class, null, 2, null)).Q(r1);
        if (r12 != null) goto L10;
    L15:
        AnnieDebugTool r13 = AnnieDebugTool.a;
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        GeckoOfflineInfoHolder r14 = (GeckoOfflineInfoHolder) GeckoOfflineInfoHolder.b.getValue();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        String r15 = GeckoOfflineInfoHolder.a(r11);
        if (r15 == null) goto L23;
        monitor-enter(r14);
        g r16 = (g) ((Map) r14.a.getValue()).get(r15);     // Catch: Throwable -> L40
        monitor-exit(r14);
        if (r16 == null) goto L23;
    L24:
        r0.add(new i("URL", r11));
        CardParamVoNew r17 = this.a.getMHybridParamVoNew();
        if (r17 == null) goto L28;
        String r18 = r17.o();
        if (r18 == null) goto L28;
    L29:
        r0.add(new i(com.bytedance.android.ec.core.event.a.KEY_SCHEMA, r18));
        if (r16 == null) goto L33;
        String r19 = Boolean.valueOf(r16.a).toString();
        if (r19 == null) goto L33;
    L34:
        r0.add(new DialogItem("offline", r19, null, 4));
        if (r16 == null) goto L39;
        r0.add(new DialogItem("resource_from", r16.c, null, 4));
        r0.add(new DialogItem("forest", String.valueOf(r16.b), null, 4));
        if (r16.a == false) goto L39;
        r0.add(new DialogItem("offline_version", r16.d, null, 4));
    L39:
        return r0;
    L33:
        r19 = "false";
    L28:
        r18 = "-";
    L40:
        th = move-exception;
        throw th;
    L23:
        r16 = null;
        goto L24
    }

    public f(AnnieCard r10) {
        Intrinsics.checkNotNullParameter(r10, "card");
        this.a = r10;
    }
}

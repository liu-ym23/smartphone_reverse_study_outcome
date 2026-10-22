package y7;

import android.content.Context;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.debug.ui.DialogItem;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements d {
    public final AnnieCard a;

    @Override // y7.d
    public final String getTitle() {
        return "Metric";
    }

    @Override // y7.d
    public final List<DialogItem> a() {
        LinkedList r0 = new LinkedList();
        AnnieCard r1 = this.a;
        if (r1 == null) goto L20;
        com.bytedance.android.annie.param.a r10 = r1.getMAnnieContext();
        if (r10 == null) goto L20;
        String r11 = r10.getMonitorID();
        if (r11 == null) goto L20;
        ConcurrentHashMap<String, com.bytedance.android.monitorV2.event.c> r12 = z7.e.a;
        Intrinsics.checkNotNullParameter(r11, "monitorID");
        JSONObject r13 = new JSONObject();
        com.bytedance.android.monitorV2.event.c r14 = z7.e.a.get(r11);
        if (r14 == null) goto L19;
        Object r15 = r14.d.opt("nativeBase");
        if ((r15 instanceof JSONObject) == false) goto L13;
        JSONObject r16 = (JSONObject) r15;
    L15:
        if (r16 == null) goto L17;
        String r17 = r16.optString("navigation_id");
    L18:
        r13.put("navigation_id", r17);
        r13.put("device_id", com.bytedance.android.annie.ng.g.b().b.b);
        com.bytedance.android.annie.ng.g.b().getClass();
        r13.put("aid", String.valueOf(com.bytedance.android.annie.ng.e.a.a));
        r13.put("ev_types", new JSONArray().put(r14.a));
        goto L19
    L17:
        r17 = null;
        goto L18
    L13:
        r16 = null;
    L19:
        String r18 = r13.toString();
    L21:
        r0.add(new DialogItem("链接", UriProtector.parse("https://annie-analytics.goofy-web.bytedance.net/#/analytics").buildUpon().appendQueryParameter("logParams", r18).build().toString(), null, 4));
        return r0;
    L20:
        r18 = null;
        goto L21
    }

    public a(Context r10, AnnieCard r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.a = r11;
    }
}

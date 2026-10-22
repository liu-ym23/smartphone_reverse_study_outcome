package vpb;

import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.text.DecimalFormat;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public static final DecimalFormat a = null;

    static {
        a = new DecimalFormat("#.#");
    }

    public static void a(String r5, IconScene r6, int r7, boolean r8, long r9, String r11) {
        JSONObject r0 = new JSONObject();
        String r2 = "";
        r0.put("BIZ_SCENE", "");
        r0.put("type", r7);
        r0.put("stage", r5);
        r0.put("success", r8 ? 1 : 0);
        DecimalFormat r10 = a;
        double r12 = r9 / 1000000.0d;
        r0.put("cost_time", r10.format(r12));
        if (r11 == null) goto L6;
        r2 = r11;
    L6:
        r0.put("error_message", r2);
        if (r6 == null) goto L10;
        String r13 = r6.name();
        if (r13 == null) goto L10;
    L11:
        r0.put("scene", r13);
        StringBuilder r14 = new StringBuilder("reportIconLoad ");
        if (r6 == null) goto L14;
        String r15 = r6.name();
    L15:
        r14.append(r15);
        r14.append("  ");
        r14.append(r8);
        r14.append(' ');
        r14.append(r10.format(r12));
        r14.append(' ');
        r14.append(r11);
        Log.d("LarkIconReport", r14.toString());
        ((o5c.b) k.a(LarkContext.getApplication(), o5c.b.class)).sendEvent("lark_icon_render_performance", r0);
        return;
    L14:
        r15 = null;
    L10:
        r13 = "UNKNOW";
        goto L11
    }
}

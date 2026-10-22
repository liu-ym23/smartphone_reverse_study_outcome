package xob;

import android.content.Context;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.ContextsKt;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Context r2) {
        if (KeyboardUtils.isSoftShowing(ContextsKt.requireActivity(r2)) == false) goto L8;
        return "keyboard_unfold";
    L8:
        return "keyboard_fold";
    L6:
        e = move-exception;
        Log.e("KeyboardAssemblerHitPointUtils", "Error while checking keyboard status: " + e.getMessage(), e);
        goto L8
    }

    public static void b(Pair... r6) {
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L14
        int r2 = r6.length;     // Catch: Exception -> L14
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L6;
        Pair r4 = r6[r3];     // Catch: Exception -> L14
        r1.put((String) r4.getFirst(), r4.getSecond());     // Catch: Exception -> L14
        r3 = r3 + 1;     // Catch: Exception -> L14
        goto L4
    L6:
        Map r7 = ChatParamUtils.e();     // Catch: Exception -> L14
        if (r7 == null) goto L12;
        Iterator r8 = r7.entrySet().iterator();     // Catch: Exception -> L14
    L10:
        if (r8.hasNext() == false) goto L12;
        Map.Entry r5 = (Map.Entry) r8.next();     // Catch: Exception -> L14
        r1.put((String) r5.getKey(), r5.getValue());     // Catch: Exception -> L14
    L12:
        Statistics.sendEvent("im_chat_main_click", r1);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Log.e("KeyboardAssemblerHitPointUtils", "sendHitPoint / event: im_chat_main_click, error: " + e);
    }
}

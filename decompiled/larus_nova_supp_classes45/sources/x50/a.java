package x50;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.crash.Npth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final AtomicBoolean a = null;
    public static volatile Boolean b;
    public static volatile Boolean c;
    public static volatile Boolean d;

    static {
        a = new AtomicBoolean();
    }

    public static void c() {
        Boolean r0 = b;
        if (r0 != null) goto L5;
    L7:
        b = Boolean.FALSE;
        HashMap r1 = new HashMap();
        r1.put("is_live_streaming", "0");
        Npth.addTags(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r0.booleanValue() == true) goto L7;
    }

    public static void b(boolean r2) {
        Boolean r0 = d;
        if (r0 != null) goto L5;
    L7:
        d = Boolean.valueOf(r2);
        HashMap r1 = new HashMap();
        if (r2 == false) goto L10;
        String r3 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L11:
        r1.put("is_live_page", r3);
        Npth.addTags(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L10:
        r3 = "0";
        goto L11
    L5:
        if (r0.booleanValue() != r2) goto L7;
    }

    public static void d(boolean r2) {
        Boolean r0 = c;
        if (r0 != null) goto L5;
    L7:
        c = Boolean.valueOf(r2);
        HashMap r1 = new HashMap();
        if (r2 == false) goto L10;
        String r3 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L11:
        r1.put("is_live_watching", r3);
        Npth.addTags(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L10:
        r3 = "0";
        goto L11
    L5:
        if (r0.booleanValue() != r2) goto L7;
    }

    public static void a(long r6, List r8, Map r9) {
        JSONObject r1 = new JSONObject();
        r1.put("duration", r6);     // Catch: Exception -> L21
        r1.put("task_exe_thread", "WorkThread");     // Catch: Exception -> L21
        Iterator r11 = ((ArrayList) r8).iterator();     // Catch: Exception -> L21
        String r3 = "";
    L6:
        if (r11.hasNext() == false) goto L14;
        String r4 = (String) r11.next();     // Catch: Exception -> L21
        if (r4 == null) goto L6;
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L21
        r5.append(r3);     // Catch: Exception -> L21
        if (r3.length() != 0) goto L12;
        String r7 = "";
    L13:
        r5.append(r7);     // Catch: Exception -> L21
        r5.append(r4);     // Catch: Exception -> L21
        r3 = r5.toString();     // Catch: Exception -> L21
        goto L6
    L12:
        r7 = ", ";
        goto L13
    L14:
        r1.put("exe_tasks", r3);     // Catch: Exception -> L21
        HashMap r12 = (HashMap) r9;     // Catch: Exception -> L21
        Set r13 = r12.keySet();     // Catch: Exception -> L21
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L21
        Iterator r15 = r13.iterator();     // Catch: Exception -> L21
    L16:
        if (r15.hasNext() == false) goto L18;
        String r16 = (String) r15.next();     // Catch: Exception -> L21
        r14.put(r16, r12.get(r16));     // Catch: Exception -> L21
        goto L16
    L18:
        r1.put("task_duration", r14);     // Catch: Exception -> L21
        r1.put("exception_task", "");     // Catch: Exception -> L21
        r1.put("exception_msg", "");     // Catch: Exception -> L21
        r1.put("duration", r6);     // Catch: Exception -> L21
        r1.toString();     // Catch: Exception -> L21
    L19:
        LiveSlardarMonitor.monitorDuration("ttlive_sdk_launch", r6, r1);
    }
}

package ez8;

import android.os.SystemClock;
import com.larus.chat.job.impl.page.g0;
import com.larus.chat.job.impl.page.i;
import com.larus.im.bean.job.AIJob;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final a a = null;
    public static final Set<String> b = null;
    public static final Map<String, Long> c = null;

    public a() {
    }

    static {
        a = new a();
        b = new LinkedHashSet();
        c = new LinkedHashMap();
    }

    public static String c(AIJob r2) {
        JSONObject r0 = g(r2.getContent());
        if (r0 == null) goto L13;
        JSONObject r1 = r0.optJSONObject("recommend_job");
        if (r1 == null) goto L13;
        String r3 = r1.optString("job_id");
        if (StringsKt.isBlank(r3) == false) goto L10;
        r3 = r2.getJobId();
    L10:
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank(r3)) == false) goto L13;
        return r3;
    L13:
        return null;
    }

    public static String e(AIJob r9) {
        JSONObject r0 = g(r9.getContent());
        if (r0 == null) goto L5;
        JSONObject r2 = r0.optJSONObject("cron_job");
    L6:
        String r3 = r9.getContent();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
        Object r5 = Result.constructor-impl(new JSONTokener(r3).nextValue());     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r5) == false) goto L15;
        r5 = null;
    L15:
        if ((r5 instanceof JSONArray) == false) goto L17;
        JSONArray r6 = (JSONArray) r5;
    L19:
        if (r6 == null) goto L38;
        int r7 = r6.length();
        int r8 = 0;
    L22:
        if (r8 >= r7) goto L38;
        JSONObject r10 = r6.optJSONObject(r8);
        if (r10 == null) goto L37;
        JSONObject r11 = r10.optJSONObject("content");
        if (r11 == null) goto L37;
        JSONObject r12 = r11.optJSONObject("lynx_block");
        if (r12 == null) goto L37;
        String r13 = r12.optString("lynx_data");
        if (r13 == null) goto L37;
        if ((!StringsKt.isBlank(r13)) == true) goto L35;
        r13 = null;
    L35:
        if (r13 == null) goto L37;
    L39:
        if (r13 == null) goto L41;
        JSONObject r14 = g(r13);
    L43:
        if (r14 == null) goto L46;
        JSONObject r15 = r14.optJSONObject("schedule_config");
        if (r15 == null) goto L46;
    L74:
        JSONObject r16 = r15;
    L75:
        if (r16 != null) goto L77;
    L81:
        Integer r17 = null;
    L82:
        if (r17 != null) goto L85;
    L87:
        if (r17 != null) goto L90;
    L92:
        if (r17 != null) goto L95;
    L97:
        if (r17 != null) goto L100;
    L102:
        if (r17 != null) goto L105;
        return null;
    L105:
        if (r17.intValue() != 5) goto L121;
        return "custom";
    L121:
        return null;
    L100:
        if (r17.intValue() != 4) goto L102;
        return "weekly";
    L95:
        if (r17.intValue() != 3) goto L97;
        return "daily";
    L90:
        if (r17.intValue() != 2) goto L92;
        return "hourly";
    L85:
        if (r17.intValue() != 1) goto L87;
        return "never";
    L77:
        if (r16.has("repeat_type") == false) goto L81;
        if (r16.isNull("repeat_type") == true) goto L81;
        r17 = Integer.valueOf(r16.optInt("repeat_type"));
    L46:
        if (r2 == null) goto L48;
        r15 = r2.optJSONObject("schedule_config");
    L49:
        if (r15 != null) goto L74;
        if (r2 == null) goto L53;
        JSONObject r18 = r2.optJSONObject("schedule");
    L54:
        if (r18 != null) goto L73;
        if (r0 == null) goto L57;
        r18 = r0.optJSONObject("schedule_config");
    L58:
        if (r18 != null) goto L73;
        if (r0 == null) goto L61;
        JSONObject r1 = r0.optJSONObject("schedule");
    L62:
        if (r1 != null) goto L72;
        JSONObject r19 = g(r9.getExt());
        if (r19 == null) goto L66;
        r1 = r19.optJSONObject("schedule_config");
    L67:
        if (r1 != null) goto L72;
        JSONObject r20 = g(r9.getExt());
        if (r20 == null) goto L71;
        r16 = r20.optJSONObject("schedule");
        goto L75
    L71:
        r16 = null;
        goto L75
    L66:
        r1 = null;
    L72:
        r16 = r1;
        goto L75
    L61:
        r1 = null;
        goto L62
    L57:
        r18 = null;
    L73:
        r16 = r18;
        goto L75
    L53:
        r18 = null;
        goto L54
    L48:
        r15 = null;
        goto L49
    L41:
        r14 = null;
    L37:
        r8 = r8 + 1;
    L38:
        r13 = null;
        goto L39
    L17:
        r6 = null;
    L9:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public static JSONObject g(String r2) {
        Object r1 = null;
        if (StringsKt.isBlank(r2) == true) goto L21;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        Object r3 = new JSONTokener(r2).nextValue();     // Catch: Throwable -> L11
        if ((r3 instanceof JSONObject) == false) goto L8;
        JSONObject r4 = (JSONObject) r3;     // Catch: Throwable -> L11
    L9:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r5) == true) goto L18;
        r1 = r5;
    L18:
        return (JSONObject) r1;
    L8:
        r4 = null;
    L11:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L21:
        return null;
    }

    public static String l(AIJob r4) {
        JSONObject r0 = g(r4.getContent());
        String r1 = null;
        if (r0 == null) goto L11;
        int r2 = g0.a;
        JSONObject r3 = r0.optJSONObject(g0.a(r4.getJobType()));
        if (r3 == null) goto L11;
        if (r3.has("last_run_status") == false) goto L11;
        if (r3.isNull("last_run_status") == true) goto L11;
        Integer r5 = Integer.valueOf(r3.optInt("last_run_status"));
    L13:
        if (r5 != null) goto L16;
    L18:
        int r6 = r4.getStatus();
        if (r6 != (-1)) goto L21;
    L28:
        r1 = "ongoing";
    L30:
        return r1;
    L21:
        if (r6 == 1) goto L28;
        if (r6 != 2) goto L24;
        r1 = "paused";
        goto L30
    L24:
        if (r6 != 3) goto L30;
        r1 = "finished";
        goto L30
    L16:
        if (r5.intValue() != 2) goto L18;
        return "failed";
    L11:
        r5 = null;
        goto L13
    }

    public static Pair b(List r4, String r5) {
        Iterator r6 = r4.iterator();
        int r0 = 0;
    L4:
        if (r6.hasNext() == false) goto L14;
        i r1 = (i) r6.next();
        if ((r1 instanceof i.a) == false) goto L4;
        i.a r2 = (i.a) r1;
        if (r2.b == false) goto L13;
        a r3 = a;
        AIJob r7 = r2.a;
        r3.getClass();
        if (Intrinsics.areEqual(c(r7), r5) == false) goto L13;
        return TuplesKt.to(r2.a, Integer.valueOf(r0));
    L13:
        r0 = r0 + 1;
        goto L4
    L14:
        return null;
    }

    public static void f(String r4, JSONObject r5) {
        FLogger r0 = FLogger.a;
        if (r0.isDebug() == false) goto L5;
        r0.i("ChatJobTracker", "track event=" + r4 + " params=" + r5);
    L6:
        o.a.reportEvent(r4, r5);
        return;
    L5:
        r0.i("ChatJobTracker", "track event=" + r4 + " keys=" + SequencesKt.toList(SequencesKt.asSequence(r5.keys())));
        goto L6
    }

    public static void i(AIJob r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "job");
        if (StringsKt.isBlank(r9.getJobId()) == false) goto L5;
        return;
    L5:
        String r0 = r9.getJobId();
        long r1 = SystemClock.elapsedRealtime();
        Map<String, Long> r3 = c;
        Long r4 = (Long) ((LinkedHashMap) r3).get(r0);
        if (r4 != null) goto L8;
    L10:
        r3.put(r0, Long.valueOf(r1));
        boolean r2 = true;
    L11:
        if (r2 == true) goto L13;
        return;
    L13:
        JSONObject r11 = new JSONObject().put("job_id", r9.getJobId()).put("index", r10);
        a.getClass();
        String r12 = l(r9);
        if (r12 == null) goto L16;
        r11.put("job_status", r12);
    L16:
        f("cron_job_click", r11);
        return;
    L8:
        if ((r1 - r4.longValue()) > 500) goto L10;
        r2 = false;
        goto L11
    }

    public static void k(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "jobId");
        if (StringsKt.isBlank(r2) == false) goto L5;
        return;
    L5:
        JSONObject r4 = new JSONObject().put("job_id", r2);
        if (r3 == false) goto L8;
        String r5 = "confirm";
    L9:
        f("cron_job_remove_confirm_click", r4.put("click_from", r5));
        return;
    L8:
        r5 = "cancel";
        goto L9
    }

    public static void a(String r2, String r3, boolean r4) {
        b.clear();
        ((LinkedHashMap) c).clear();
        if (r4 == true) goto L5;
        return;
    L5:
        JSONObject r5 = new JSONObject().put("current_page", "cron_job_manage");
        if (r2 != null) goto L8;
    L13:
        if (r3 != null) goto L15;
    L20:
        Unit r6 = Unit.INSTANCE;
        f("enter_page", r5);
        return;
    L15:
        if ((!StringsKt.isBlank(r3)) == true) goto L18;
        r3 = null;
    L18:
        if (r3 == null) goto L20;
        r5.put("enter_method", r3);
        goto L20
    L8:
        if ((!StringsKt.isBlank(r2)) == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L13;
        r5.put("previous_page", r2);
        goto L13
    }

    public static JSONObject d(AIJob r3, String r4, int r5) {
        JSONObject r6 = new JSONObject().put("template_source", "onboarding").put("template_id", r4).put("index", r5);
        a.getClass();
        JSONObject r7 = g(r3.getContent());
        if (r7 == null) goto L16;
        JSONObject r8 = r7.optJSONObject("recommend_job");
        if (r8 == null) goto L16;
        String r9 = r8.optString("title");
        if (r9 == null) goto L16;
        String r10 = StringsKt.trim(r9).toString();
        if (r10 == null) goto L16;
        if (r10.length() <= 0) goto L13;
        boolean r11 = true;
    L14:
        if (r11 == false) goto L16;
    L17:
        if (r10 == null) goto L19;
        r6.put("job_title", r10);
    L19:
        return r6;
    L13:
        r11 = false;
    L16:
        r10 = null;
        goto L17
    }

    public static void j(String r2, String r3, String r4) {
        if (StringsKt.isBlank(r2) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r4) == true) goto L13;
        JSONObject r5 = new JSONObject().put("job_id", r2).put("click_from", r4);
        if (r3 == null) goto L10;
        r5.put("job_status", r3);
    L10:
        f("cron_job_operate", r5);
        return;
    }

    public static void h(String r9, List r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r9, "jobId");
        Intrinsics.checkNotNullParameter(r10, "editFields");
        if (StringsKt.isBlank(r9) == false) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L10;
        f("edit_cron_job_status", new JSONObject().put("job_id", r9).put("edit_field", CollectionsKt.joinToString$default(r10, ",", null, null, 0, null, null, 62, null)).put("repeat_type", r11).put("is_success", r12));
        return;
    }
}

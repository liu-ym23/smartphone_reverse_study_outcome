package od8;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements sr9.d {
    public static final d a = null;
    public static final Lazy b = null;
    public static final HashMap<String, HashMap<String, String>> c = null;
    public static final ConcurrentHashMap<String, Pair<Integer, Integer>> d = null;

    public d() {
    }

    static {
        a = new d();
        b = LazyKt.lazy(new c());
        c = new HashMap();
        d = new ConcurrentHashMap();
    }

    public static void i(Map r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L10
        if (r4 == null) goto L8;
        ArrayList r2 = new ArrayList(r4.size());     // Catch: Throwable -> L10
        Iterator r5 = r4.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r5.hasNext() == false) goto L8;
        Map.Entry r3 = (Map.Entry) r5.next();     // Catch: Throwable -> L10
        r2.add(r1.put((String) r3.getKey(), r3.getValue()));     // Catch: Throwable -> L10
    L8:
        Object r6 = Result.constructor-impl(r1);     // Catch: Throwable -> L10
    L12:
        String r7 = null;
        if (Result.isFailure-impl(r6) == false) goto L15;
        r6 = null;
    L15:
        JSONObject r8 = (JSONObject) r6;
        if (r8 == null) goto L18;
        r7 = r8.toString();
    L18:
        ((Keva) b.getValue()).storeString("SAVE_KEY_INSTRUCT_EXT_", r7);
        return;
    L10:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static String p(String r1) {
        if (r1 != null) goto L4;
    L45:
        return null;
    L4:
        switch(r1.hashCode()) {
            case -1775152378: goto L42;
            case -1519652696: goto L39;
            case -1104494850: goto L36;
            case -751697127: goto L33;
            case -701204130: goto L30;
            case -106106972: goto L27;
            case 120426756: goto L23;
            case 451709046: goto L20;
            case 1086767678: goto L16;
            case 1504163779: goto L13;
            case 1840109215: goto L10;
            case 1970358852: goto L7;
            default: goto L45;
        };
    L7:
        if (r1.equals("send_photo_preview") == false) goto L45;
    L44:
        return "SAVE_KEY_TAB_COMMON";
    L10:
        if (r1.equals("common_bottom_menu") == true) goto L44;
    L13:
        if (r1.equals("prompt_direct_send") == true) goto L44;
    L16:
        if (r1.equals("edu_photo_search") == false) goto L45;
        return "SAVE_KEY_TAB_EDU_PHOTO_SEARCH";
    L20:
        if (r1.equals("common_input") == true) goto L44;
    L23:
        if (r1.equals("edu_homework_correct") == false) goto L45;
        return "SAVE_KEY_TAB_EDU_HOMEWORK_CORRECT";
    L27:
        if (r1.equals("welcome_back") == true) goto L44;
    L30:
        if (r1.equals("common_action_bar") == true) goto L44;
    L33:
        if (r1.equals("attach_menu") == false) goto L45;
    L36:
        if (r1.equals("inject_input_photo_picker") == true) goto L44;
    L39:
        if (r1.equals("message_sug_action") == true) goto L44;
    L42:
        if (r1.equals("outer_input") == true) goto L44;
        goto L44
    }

    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        HashMap<String, String> r3 = c.get(r2);
        if (r3 == null) goto L6;
        String r4 = r3.get("is_photo_marked");
        if (r4 == null) goto L6;
        return r4;
    L6:
        return "0";
    }

    public final Pair<Integer, Integer> b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return d.get(r2);
    }

    public final String c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        HashMap<String, String> r3 = c.get(r2);
        if (r3 == null) goto L6;
        String r4 = r3.get("previous_page");
        if (r4 == null) goto L6;
        return r4;
    L6:
        return "-1";
    }

    public final String f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        HashMap<String, String> r3 = c.get(r2);
        if (r3 == null) goto L6;
        String r4 = r3.get("content_source");
        if (r4 == null) goto L6;
        return r4;
    L6:
        return "-1";
    }

    public final boolean g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        HashMap<String, String> r3 = c.get(r2);
        if (r3 == null) goto L5;
        String r4 = r3.get("is_from_photo_edit");
    L7:
        return Intrinsics.areEqual(r4, "1");
    L5:
        r4 = null;
        goto L7
    }

    public final String h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        HashMap<String, String> r3 = c.get(r2);
        if (r3 == null) goto L6;
        String r4 = r3.get("if_edu_intention");
        if (r4 == null) goto L6;
        return r4;
    L6:
        return "-1";
    }

    public static void j(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        String r0 = p(r4);
        if (r0 != null) goto L5;
        return;
    L5:
        ((Keva) b.getValue()).storeString(r0, r5);
        FLogger.a.i("ChatCameraCache", "saveTab, scene:" + r4 + ",saveKey:" + r0 + ",mode:" + r5);
    }

    public static void l(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "localUri");
        Intrinsics.checkNotNullParameter(r2, "detectIntent");
        k(r1, "if_edu_intention", r2);
    }

    public static void m(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "localUri");
        if (r2 == false) goto L5;
        String r3 = "1";
    L6:
        k(r1, "is_from_photo_edit", r3);
        return;
    L5:
        r3 = "0";
        goto L6
    }

    public static void n(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "localUri");
        if (r2 == false) goto L5;
        String r3 = "1";
    L6:
        k(r1, "is_photo_marked", r3);
        return;
    L5:
        r3 = "0";
        goto L6
    }

    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "localUri");
        Intrinsics.checkNotNullParameter(r3, "contentSource");
        k(r2, "content_source", r3);
    }

    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "localUri");
        Intrinsics.checkNotNullParameter(r3, "previousPage");
        k(r2, "previous_page", r3);
    }

    public static void k(String r2, String r3, String r4) {
        HashMap<String, HashMap<String, String>> r0 = c;
        if (r0.get(r2) != null) goto L5;
        HashMap<String, String> r1 = new HashMap();
        r1.put(r3, r4);
        r0.put(r2, r1);
        return;
    L5:
        HashMap<String, String> r5 = r0.get(r2);
        if (r5 == null) goto L10;
        String r6 = r5.put(r3, r4);
        return;
    }

    public static void o(String r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "localUri");
        FLogger.a.i("lsy", "saveUriToVideoSize, localUri:" + r3 + ", width:" + r4 + ", height:" + r5);
        d.put(r3, new Pair(Integer.valueOf(r4), Integer.valueOf(r5)));
    }
}

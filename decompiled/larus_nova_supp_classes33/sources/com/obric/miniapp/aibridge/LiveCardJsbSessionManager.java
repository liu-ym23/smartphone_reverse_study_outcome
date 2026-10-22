package com.obric.miniapp.aibridge;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.LiveCardType;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.island.IslandApi;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class LiveCardJsbSessionManager {
    public static final LiveCardJsbSessionManager a = null;
    public static final CoroutineScope b = null;
    public static final Handler c = null;
    public static final ConcurrentHashMap<String, Job> d = null;
    public static final ConcurrentHashMap<String, Long> e = null;
    public static final ConcurrentHashMap<String, AtomicReference<IslandSession>> f = null;
    public static final Set<String> g = null;

    public LiveCardJsbSessionManager() {
    }

    static {
        a = new LiveCardJsbSessionManager();
        b = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        c = new Handler(Looper.getMainLooper());
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
        g = SetsKt.setOf(new String[]{"com.obric.island_assistant:common_collapse_template", "com.obric.island_assistant:common_expand_template", "com.obric.island_assistant:common_notification_template", "com.obric.island_assistant:complex_task_dialogue_island", "com.obric.island_assistant:car_collapse_template", "com.obric.island_assistant:car_expand_template", "com.obric.island_applet:common_collapse_template", "com.obric.island_applet:common_expand_template", "com.obric.island_applet:common_notification_template", "com.obric.island_applet:car_collapse_template", "com.obric.island_applet:car_expand_template"});
    }

    public static String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionKey");
        return "jsb/" + r2;
    }

    public static Map g(JSONObject r4) {
        if (r4 == null) goto L4;
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<String> r1 = r4.keys();
    L7:
        if (r1.hasNext() == false) goto L12;
        String r2 = r1.next();
        Object r3 = r4.opt(r2);
        if (r3 == null) goto L7;
        r0.put(r2, r3.toString());
        goto L7
    L12:
        return r0;
    L4:
        return MapsKt.emptyMap();
    }

    public static String o(String r6) {
        if (r6 == null) goto L5;
        String r7 = StringsKt.trim(r6).toString();
    L6:
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        boolean r2 = false;
        if (r7.length() != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L16;
        return "sessionKey is required";
    L16:
        if (r7.length() <= 64) goto L19;
        return "sessionKey too long";
    L19:
        int r3 = 0;
    L21:
        if (r3 >= r7.length()) goto L38;
        char r4 = r7.charAt(r3);
        if (Character.isLetterOrDigit(r4) == false) goto L25;
    L34:
        boolean r5 = true;
    L35:
        if (r5 == false) goto L39;
        r3 = r3 + 1;
    L39:
        if (r2 == true) goto L42;
        return "sessionKey contains invalid characters";
    L42:
        return null;
    L25:
        if (r4 == '_') goto L34;
        if (r4 == '-') goto L34;
        if (r4 == ':') goto L34;
        if (r4 == '.') goto L34;
        r5 = false;
        goto L35
    L38:
        r2 = true;
        goto L39
    L11:
        r1 = false;
        goto L12
    L5:
        r7 = null;
        goto L6
    }

    public static String p(JSONObject r1) {
        if (r1 == null) goto L12;
        String r2 = r1.toString();
        if (r2 != null) goto L7;
        return "templateData is required";
    L7:
        if (r2.getBytes(Charsets.UTF_8).length <= 50000) goto L10;
        return "templateData too large";
    L10:
        return null;
    L12:
        return "templateData is required";
    }

    public static String q(String r2) {
        if (r2 == null) goto L5;
        String r3 = StringsKt.trim(r2).toString();
    L6:
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        if (r3.length() != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L16;
        return "templateId is required";
    L16:
        if (g.contains(r3) == false) goto L18;
        return null;
    L18:
        return "templateId not allowed";
    L11:
        r1 = false;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public static JSONObject d(JSONObject r5, JSONObject r6) {
        if (r5 != null) goto L4;
        JSONObject r7 = new JSONObject();
    L5:
        Iterator<String> r0 = r6.keys();
    L7:
        if (r0.hasNext() == false) goto L14;
        String r1 = r0.next();
        Object r2 = r6.opt(r1);
        Object r3 = r7.opt(r1);
        if ((r2 instanceof JSONObject) == false) goto L13;
        if ((r3 instanceof JSONObject) == false) goto L13;
        r7.put(r1, d((JSONObject) r3, (JSONObject) r2));
    L13:
        r7.put(r1, r2);
        goto L7
    L14:
        return r7;
    L4:
        r7 = new JSONObject(r5.toString());
        goto L5
    }

    public static String f(LiveCardJsbSessionManager r9, JSONObject r10) {
        r9.getClass();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L15
        Iterator<String> r12 = r10.keys();     // Catch: Throwable -> L15
        ArrayList r0 = new ArrayList(12);     // Catch: Throwable -> L15
    L5:
        if (r12.hasNext() == false) goto L10;
        if (r0.size() >= 12) goto L10;
        r0.add(r12.next());     // Catch: Throwable -> L15
    L10:
        if (r12.hasNext() == false) goto L12;
        String r13 = "+";
    L13:
        Object r14 = Result.constructor-impl(CollectionsKt.joinToString$default(r0, null, "[", ']' + r13, 0, null, null, 57, null));     // Catch: Throwable -> L15
    L18:
        if (Result.exceptionOrNull-impl(r14) == null) goto L22;
        r14 = "<keys_error>";
    L22:
        return (String) r14;
    L12:
        r13 = "";
    L15:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    public static void i(String r10, long r11) {
        if (r11 > 0) goto L5;
        return;
    L5:
        ConcurrentHashMap<String, Job> r0 = d;
        Job r1 = r0.remove(r10);
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        Long r2 = Long.valueOf(r11);
        e.put(r10, r2);
        r0.put(r10, BuildersKt.launch$default(b, null, null, new LiveCardJsbSessionManager$scheduleAutoDismiss$1(r11, r10, null), 3, null));
    }

    public final boolean e(String r16, String r17) {
        String r1 = r17;
        ILiveCard.Companion.getInst().init(AppHost.a.getApplication());     // Catch: Throwable -> L30
    L4:
        Job r6 = d.remove(r16);
        if (r6 == null) goto L7;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L7:
        e.remove(r16);
        ConcurrentHashMap<String, AtomicReference<IslandSession>> r7 = f;
        AtomicReference<IslandSession> r9 = r7.get(r16);
        if (r9 != null) goto L10;
        return false;
    L10:
        IslandSession r10 = r9.getAndSet(null);
        if (r10 != null) goto L31;
        return false;
    L31:
        StringBuilder r12 = new StringBuilder("reason=");     // Catch: Throwable -> L24
        if (r1 != null) goto L16;
        String r13 = "";
    L17:
        r12.append(r13);     // Catch: Throwable -> L24
        r12.append(" flags=");     // Catch: Throwable -> L24
        r12.append(r10.getFlags());     // Catch: Throwable -> L24
        n("destroy.callSdk", null, r16, r12.toString());     // Catch: Throwable -> L24
        IslandApi r8 = ILiveCard.Companion.getInst().getIslandService();     // Catch: Throwable -> L24
        if (r8 == null) goto L20;
        r8.destroySession(r10);     // Catch: Throwable -> L24
    L20:
        r7.remove(r16);     // Catch: Throwable -> L24
        if (r1 == null) goto L35;
        FLogger.a.i("LiveCardJSB", "destroy sessionTag=" + r16 + " reason=" + r1);     // Catch: Throwable -> L24
        return true;
    L35:
        return true;
    L16:
        r13 = r1;
    L24:
        th = move-exception;
        FLogger.a.e("LiveCardJSB", "destroy failed, sessionTag=" + r16, th);
        if (r1 != null) goto L28;
        r1 = "";
    L28:
        m(this, "destroy.callSdk", null, r16, "reason=".concat(r1), th, 2);
        return false;
    }

    public static PendingIntent c(Context r2, int r3, String r4) {
        Intent r0 = r2.getPackageManager().getLaunchIntentForPackage(r2.getPackageName());
        if (r0 != null) goto L5;
        r0 = new Intent("android.intent.action.MAIN");
        r0.addCategory("android.intent.category.LAUNCHER");
        r0.setPackage(r2.getPackageName());
    L5:
        r0.addFlags(872415232);
        if (r4 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L18;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L15
        r0.setData(UriProtector.parse(r4));     // Catch: Throwable -> L15
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L18:
        if (Build.VERSION.SDK_INT < 23) goto L20;
        int r7 = 201326592;
    L22:
        return PendingIntent.getActivity(r2, r3, r0, r7);
    L20:
        r7 = 134217728;
        goto L22
    L8:
        if (StringsKt.isBlank(r4) == true) goto L11;
        r1 = false;
        goto L12
    }

    public static void j(final String r3, final String r4, final long r5) {
        if (r5 > 0) goto L5;
        return;
    L5:
        c.postDelayed(new q(r3, r4, r5), r5);
    }

    public static void a(JSONObject r18, IslandWidget r19, final String r20, final String r21) {
        JSONArray r13 = r18.optJSONArray("callbacks");
        if (r13 != null) goto L5;
        return;
    L5:
        n("callbacks.parse", r20, r21, "templateId=" + r19.getTemplateId() + " count=" + r13.length());
        int r14 = r13.length();
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L50;
        JSONObject r0 = r13.optJSONObject(r15);
        if (r0 == null) goto L48;
        String r2 = r0.optString("event");
        final String r7 = r0.optString("viewId");
        final JSONObject r1 = r0.optJSONObject("action");
        if (Intrinsics.areEqual(r2, "onViewClick") == false) goto L48;
        Intrinsics.checkNotNull(r7);
        if (StringsKt.isBlank(r7) == true) goto L48;
        if (r1 == null) goto L48;
        String r6 = r1.optString("type");
        if (r6 == null) goto L48;
        switch(r6.hashCode()) {
            case -1162004306: goto L33;
            case -505153342: goto L29;
            case -504772615: goto L25;
            case 1176137020: goto L22;
            default: goto L48;
        };     // Catch: Throwable -> L45
    L22:
        if (r6.equals("destroySession") == false) goto L48;
        n("callbacks.bind", r20, r21, "type=" + r6 + " viewId=" + r7);     // Catch: Throwable -> L45
        r19.addOnViewClickCallback(r7, new l(r21, r7));     // Catch: Throwable -> L45
        goto L48
    L25:
        if (r6.equals("openPage") == false) goto L48;
        n("callbacks.bind", r20, r21, "type=" + r6 + " viewId=" + r7);     // Catch: Throwable -> L45
        r19.addOnViewClickCallback(r7, new n(r20, r21, r7, r1));     // Catch: Throwable -> L45
        goto L48
    L29:
        if (r6.equals("openChat") == false) goto L48;
        n("callbacks.bind", r20, r21, "type=" + r6 + " viewId=" + r7);     // Catch: Throwable -> L45
        r19.addOnViewClickCallback(r7, new m(r20, r21, r7));     // Catch: Throwable -> L45
        goto L48
    L33:
        if (r6.equals("jsCallback") == false) goto L48;
        final String r16 = r1.optString("name");     // Catch: Throwable -> L45
        final JSONObject r3 = r1.optJSONObject("payload");     // Catch: Throwable -> L45
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L45
        r4.append("type=");     // Catch: Throwable -> L45
        r4.append(r6);     // Catch: Throwable -> L45
        r4.append(" viewId=");     // Catch: Throwable -> L45
        r4.append(r7);     // Catch: Throwable -> L45
        r4.append(" name=");     // Catch: Throwable -> L45
        if (r16 != null) goto L38;
        String r5 = "";
    L39:
        r4.append(r5);     // Catch: Throwable -> L45
        n("callbacks.bind", r20, r21, r4.toString());     // Catch: Throwable -> L45
        JSONArray r110 = r13;
        int r17 = r14;
        int r111 = r15;
        String r112 = r7;
        r19.addOnViewClickCallback(r112, new o(r20, r21, r7, r16, r3));     // Catch: Throwable -> L43
    L49:
        r15 = r111 + 1;
        r13 = r110;
        r14 = r17;
    L43:
        th = th;
    L47:
        FLogger.a.e("LiveCardJSB", "addOnViewClickCallback failed, type=" + r6 + " viewId=" + r112 + " tag=" + r21, th);
        StringBuilder r8 = new StringBuilder("type=");
        r8.append(r6);
        r8.append(" viewId=");
        r8.append(r112);
        l("callbacks.bind", r20, r21, r8.toString(), th);
        goto L49
    L38:
        r5 = r16;
    L45:
        th = th;
        r110 = r13;
        r17 = r14;
        r111 = r15;
        r112 = r7;
    L48:
        r110 = r13;
        r17 = r14;
        r111 = r15;
        goto L49
    }

    public static void h(String r12, String r13, String r14, String r15) {
        int r0 = StringsKt.indexOf$default(r14, ':', 0, false, 6, null);
        if (r0 > 0) goto L5;
    L8:
        Pair r1 = null;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        BuildersKt.launch$default(b, Dispatchers.getIO(), null, new LiveCardJsbSessionManager$prefetchTemplateResourceAsync$1(r12, r13, r15, r14, (String) r1.component1(), (String) r1.component2(), null), 2, null);
        return;
    L5:
        if (r0 >= (r14.length() - 1)) goto L8;
        r1 = TuplesKt.to(r14.substring(0, r0), r14.substring(r0 + 1));
        goto L9
    }

    public static void n(String r3, String r4, String r5, String r6) {
        String r0 = null;
        if (r4 == null) goto L5;
        String r7 = StringsKt.trim(r4).toString();
    L6:
        String r1 = "";
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        if (r5 == null) goto L11;
        String r8 = StringsKt.trim(r5).toString();
    L12:
        if (r8 != null) goto L14;
        r8 = "";
    L14:
        if (r6 == null) goto L16;
        r0 = StringsKt.trim(r6).toString();
    L16:
        if (r0 == null) goto L19;
        r1 = r0;
    L19:
        FLogger.a.i("LiveCardJSB", "[LC_TRACE] stage=" + r3 + " sessionKey=" + r7 + " tag=" + r8 + ' ' + r1);
        return;
    L11:
        r8 = null;
        goto L12
    L5:
        r7 = null;
        goto L6
    }

    public final t update(String r8, JSONObject r9, JSONObject r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "sessionKey");
        String r1 = b(r8);
        StringBuilder r2 = new StringBuilder("thread=");
        r2.append(ThreadMethodProxy.currentThread().getName());
        r2.append(" mode=");
        if (r11 != null) goto L5;
        String r3 = "";
    L6:
        r2.append(r3);
        r2.append(" hasCollapsePatch=");
        boolean r4 = false;
        if (r9 == null) goto L9;
        boolean r5 = true;
    L10:
        r2.append(r5);
        r2.append(" hasExpandPatch=");
        if (r10 == null) goto L13;
        boolean r6 = true;
    L14:
        r2.append(r6);
        n("update.enter", r8, r1, r2.toString());
        ILiveCard.Companion.getInst().init(AppHost.a.getApplication());     // Catch: Throwable -> L71
    L17:
        if (ILiveCard.Companion.getInst().getIslandService() != null) goto L20;
        int r12 = t.e;
        return t.a.a(r8, r1, "SDK_NOT_READY", "islandService is null");
    L20:
        AtomicReference<IslandSession> r7 = f.get(r1);
        if (r7 == null) goto L69;
        IslandSession r13 = r7.get();
        if (r13 == null) goto L69;
        if (r11 != null) goto L27;
    L79:
        r13.setCanFrontShow(Boolean.TRUE);     // Catch: Throwable -> L72
    L75:
        r13.setFlags(64);     // Catch: Throwable -> L63
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L34
        r13.updateFlags();     // Catch: Throwable -> L34
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L36:
        JSONObject r15 = null;
        if (r9 == null) goto L48;
        IslandWidget r16 = r13.getCollapseWidget();     // Catch: Throwable -> L63
        if (r16 == null) goto L48;
        Object r17 = r16.getTemplateData();     // Catch: Throwable -> L63
        if ((r17 instanceof JSONObject) == false) goto L43;
        JSONObject r18 = (JSONObject) r17;     // Catch: Throwable -> L63
    L44:
        if (r4 == true) goto L47;
        a.getClass();     // Catch: Throwable -> L63
        r9 = d(r18, r9);     // Catch: Throwable -> L63
    L47:
        r16.setTemplateData(r9);     // Catch: Throwable -> L63
        r13.update(r16);     // Catch: Throwable -> L63
        goto L48
    L43:
        r18 = null;
    L48:
        if (r10 == null) goto L58;
        IslandWidget r19 = r13.getExpandWidget();     // Catch: Throwable -> L63
        if (r19 == null) goto L58;
        Object r20 = r19.getTemplateData();     // Catch: Throwable -> L63
        if ((r20 instanceof JSONObject) == false) goto L54;
        r15 = (JSONObject) r20;     // Catch: Throwable -> L63
    L54:
        if (r4 == true) goto L57;
        a.getClass();     // Catch: Throwable -> L63
        r10 = d(r15, r10);     // Catch: Throwable -> L63
    L57:
        r19.setTemplateData(r10);     // Catch: Throwable -> L63
        r13.update(r19);     // Catch: Throwable -> L63
    L58:
        Long r21 = e.get(r1);     // Catch: Throwable -> L63
        if (r21 == null) goto L61;
        long r22 = r21.longValue();     // Catch: Throwable -> L63
        a.getClass();     // Catch: Throwable -> L63
        i(r1, r22);     // Catch: Throwable -> L63
    L61:
        n("update.exit", r8, r1, "ok=true");     // Catch: Throwable -> L63
        int r23 = t.e;     // Catch: Throwable -> L63
        return t.a.b(r8, r1);
    L34:
        th = move-exception;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L63
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        FLogger.a.e("LiveCardJSB", "update failed, sessionKey=" + r8 + " tag=" + r1, th);
        l("update.exit", r8, r1, "ok=false", th);
        int r110 = t.e;
        String r25 = th.getMessage();
        if (r25 != null) goto L68;
        r25 = "update failed";
    L68:
        return t.a.a(r8, r1, "INTERNAL_ERROR", r25);
    L27:
        if (StringsKt.equals(r11, "replace", true) != true) goto L79;
        r4 = true;
    L69:
        int r26 = t.e;
        return t.a.a(r8, r1, "SESSION_NOT_FOUND", "session not found");
    L13:
        r6 = false;
        goto L14
    L9:
        r5 = false;
        goto L10
    L5:
        r3 = r11;
        goto L6
    }

    public static void l(String r7, String r8, String r9, String r10, Throwable r11) {
        String r0 = null;
        if (r8 == null) goto L5;
        String r12 = StringsKt.trim(r8).toString();
    L6:
        String r1 = "";
        if (r12 != null) goto L9;
        r12 = "";
    L9:
        if (r9 == null) goto L11;
        String r13 = StringsKt.trim(r9).toString();
    L12:
        if (r13 != null) goto L14;
        r13 = "";
    L14:
        if (r10 == null) goto L16;
        r0 = StringsKt.trim(r10).toString();
    L16:
        if (r0 == null) goto L20;
        r1 = r0;
    L20:
        if (r11 == null) goto L22;
        FLogger.a.e("LiveCardJSB", "[LC_TRACE] stage=" + r7 + " sessionKey=" + r12 + " tag=" + r13 + ' ' + r1, r11);
        return;
    L22:
        FLogger.a.e("LiveCardJSB", "[LC_TRACE] stage=" + r7 + " sessionKey=" + r12 + " tag=" + r13 + ' ' + r1);
        return;
    L11:
        r13 = null;
        goto L12
    L5:
        r12 = null;
        goto L6
    }

    public static /* synthetic */ void m(LiveCardJsbSessionManager r2, String r3, String r4, String r5, String r6, Throwable r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r8 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 16) == 0) goto L14;
        r7 = null;
    L14:
        r2.getClass();
        l(r3, r4, r5, r6, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final t k(Context r54, String r55, Boolean r56, JSONObject r57, JSONObject r58, JSONObject r59, Long r60) {
        Context r2 = r54;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r55, "sessionKey");
        Intrinsics.checkNotNullParameter(r57, "collapseSpec");
        Intrinsics.checkNotNullParameter(r58, "expandSpec");
        String r10 = b(r55);
        StringBuilder r0 = new StringBuilder("thread=");
        r0.append(ThreadMethodProxy.currentThread().getName());
        r0.append(" canFrontShow=");
        if (r56 == null) goto L5;
        boolean r12 = r56.booleanValue();
    L6:
        r0.append(r12);
        r0.append(" autoDismissMs=");
        if (r60 == null) goto L9;
        long r13 = r60.longValue();
    L10:
        r0.append(r13);
        n("show.enter", r55, r10, r0.toString());
        ILiveCard.Companion.getInst().init(AppHost.a.getApplication());     // Catch: Throwable -> L184
    L12:
        String r15 = r57.optString("templateId");
        JSONObject r14 = r57.optJSONObject("templateData");
        String r16 = q(r15);
        if (r16 == null) goto L16;
        int r1 = t.e;
        return t.a.a(r55, r10, "TEMPLATE_NOT_ALLOWED", r16);
    L16:
        String r17 = p(r14);
        if (r17 == null) goto L20;
        int r3 = t.e;
        return t.a.a(r55, r10, "INVALID_PARAM", "collapse.".concat(r17));
    L20:
        if (r14 != null) goto L23;
        int r4 = t.e;
        return t.a.a(r55, r10, "INVALID_PARAM", "collapse.templateData is required");
    L23:
        String r18 = r58.optString("templateId");
        JSONObject r19 = r58.optJSONObject("templateData");
        String r5 = q(r18);
        if (r5 == null) goto L27;
        int r6 = t.e;
        return t.a.a(r55, r10, "TEMPLATE_NOT_ALLOWED", r5);
    L27:
        String r7 = p(r19);
        if (r7 == null) goto L31;
        int r8 = t.e;
        return t.a.a(r55, r10, "INVALID_PARAM", "expand.".concat(r7));
    L31:
        if (r19 != null) goto L189;
        int r9 = t.e;
        return t.a.a(r55, r10, "INVALID_PARAM", "expand.templateData is required");
    L189:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L36
        Object r20 = Result.constructor-impl(JsonParser.parseString(r14.toString()).getAsJsonObject());     // Catch: Throwable -> L36
    L39:
        if (Result.isFailure-impl(r20) == false) goto L41;
        r20 = null;
    L41:
        String r110 = (JsonObject) r20;
        if (r110 != null) goto L191;
        int r21 = t.e;
        return t.a.a(r55, r10, "INVALID_PARAM", "collapse.templateData json parse failed");
    L191:
        Object r22 = Result.constructor-impl(JsonParser.parseString(r19.toString()).getAsJsonObject());     // Catch: Throwable -> L47
    L50:
        if (Result.isFailure-impl(r22) == false) goto L52;
        r22 = null;
    L52:
        JsonObject r23 = (JsonObject) r22;
        if (r23 != null) goto L56;
        int r24 = t.e;
        return t.a.a(r55, r10, "INVALID_PARAM", "expand.templateData json parse failed");
    L56:
        StringBuilder r25 = new StringBuilder("collapseTemplateId=");
        r25.append(r15);
        r25.append(" expandTemplateId=");
        r25.append(r18);
        r25.append(" collapseBytes=");
        String r26 = r14.toString();
        Charset r27 = Charsets.UTF_8;
        r25.append(r26.getBytes(r27).length);
        r25.append(" expandBytes=");
        r25.append(r19.toString().getBytes(r27).length);
        r25.append(" collapseKeys=");
        r25.append(f(this, r14));
        r25.append(" expandKeys=");
        r25.append(f(this, r19));
        n("show.paramOk", r55, r10, r25.toString());
        BuildersKt.launch$default(b, Dispatchers.getIO(), null, new LiveCardJsbSessionManager$ensureIslandPackagesInstalledAsync$1(CollectionsKt.listOf(new String[]{"com.obric.island_assistant", "com.obric.island_applet"}), r55, r10, null), 2, null);
        Intrinsics.checkNotNull(r15);
        h(r55, r10, r15, "collapse");
        Intrinsics.checkNotNull(r18);
        h(r55, r10, r18, "expand");
        Boolean r28 = Boolean.TRUE;
        IslandWidget r29 = new IslandWidget(r15, r110, r28, null, null, null, null, null, null, 504, null);
        String r30 = r110;
        IslandWidget r111 = new IslandWidget(r18, r23, r28, null, null, null, null, null, null, 504, null);
        a(r57, r29, r55, r10);
        a(r58, r111, r55, r10);
        JsonObject r31 = new JsonObject();
        r31.addProperty("jsb_session_tag", r10);
        if (r59 == null) goto L66;
        String r32 = r59.optString("biz");
        if (r32 == null) goto L66;
        if ((!StringsKt.isBlank(r32)) == true) goto L64;
        r32 = null;
    L64:
        if (r32 == null) goto L66;
        r31.addProperty("biz", r32);
    L66:
        if (r59 == null) goto L76;
        String r33 = r59.optString("traceId");
        if (r33 == null) goto L76;
        if ((!StringsKt.isBlank(r33)) == true) goto L73;
        r33 = null;
    L73:
        if (r33 == null) goto L76;
        r31.addProperty("traceId", r33);
    L76:
        IslandApi r34 = ILiveCard.Companion.getInst().getIslandService();
        if (r34 != null) goto L80;
        int r35 = t.e;
        return t.a.a(r55, r10, "SDK_NOT_READY", "islandService is null");
    L80:
        ConcurrentHashMap<String, AtomicReference<IslandSession>> r36 = f;
        AtomicReference<IslandSession> r37 = r36.get(r10);
        if (r37 != null) goto L86;
        String r38 = null;
        r37 = new AtomicReference(null);
        AtomicReference<IslandSession> r39 = r36.putIfAbsent(r10, r37);
        if (r39 == null) goto L87;
        r37 = r39;
    L87:
        AtomicReference<IslandSession> r40 = r37;
        IslandSession r41 = r40.get();
        String r112 = StringsKt.trim(r14.optString("jump_url")).toString();     // Catch: Throwable -> L177
        if (r112.length() <= 0) goto L91;
        boolean r113 = true;
    L92:
        if (r113 == true) goto L95;
        r112 = r38;
    L95:
        if (r112 != null) goto L103;
        String r114 = StringsKt.trim(r19.optString("jump_url")).toString();     // Catch: Throwable -> L177
        if (r114.length() <= 0) goto L99;
        boolean r115 = true;
    L100:
        if (r115 == true) goto L195;
        r114 = r38;
    L195:
        if (r41 != null) goto L118;
        IslandSession r42 = new IslandSession(r29, r111, null, null, c(r2, r55.hashCode(), r114), null, null, 0, LiveCardType.ASSISTANT, null, null, r31, 64, null, null, null, 0, 124620, null);     // Catch: Throwable -> L115
        if (r56 == null) goto L110;
        boolean r43 = r56.booleanValue();     // Catch: Throwable -> L115
    L187:
        r42.setCanFrontShow(Boolean.valueOf(r43));     // Catch: Throwable -> L113
    L114:
        IslandSession r44 = r42;
        r30 = r10;
    L151:
        if (r41 != null) goto L164;
        r40.set(r44);     // Catch: Throwable -> L162
        n("show.createSession", r55, r30, "type=" + r44.getType() + " flags=" + r44.getFlags());     // Catch: Throwable -> L162
        r34.createSession(r44, r2);     // Catch: Throwable -> L162
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L155
        r44.update(r29);     // Catch: Throwable -> L155
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L155
    L202:
        r44.update(r111);     // Catch: Throwable -> L159
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L159
    L161:
        j(r30, r55, 300);     // Catch: Throwable -> L162
        j(r30, r55, 1000);     // Catch: Throwable -> L162
        goto L164
    L159:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L162
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L162
    L155:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L162
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L162
    L162:
        th = th;
    L117:
        String r48 = "show.exit";
    L179:
        FLogger.a.e("LiveCardJSB", "show failed, sessionKey=" + r55 + " tag=" + r30, th);
        l(r48, r55, r30, "ok=false", th);
        int r49 = t.e;
        String r50 = th.getMessage();
        if (r50 != null) goto L183;
        r50 = "show failed";
    L183:
        return t.a.a(r55, r30, "INTERNAL_ERROR", r50);
    L164:
        if (r60 == null) goto L166;
        long r51 = r60.longValue();     // Catch: Throwable -> L162
        a.getClass();     // Catch: Throwable -> L162
        i(r30, r51);     // Catch: Throwable -> L162
    L166:
        StringBuilder r52 = new StringBuilder("ok=true existed=");     // Catch: Throwable -> L162
        if (r41 == null) goto L169;
        boolean r116 = true;
    L170:
        r52.append(r116);     // Catch: Throwable -> L162
        n("show.exit", r55, r30, r52.toString());     // Catch: Throwable -> L173
        int r53 = t.e;     // Catch: Throwable -> L173
        return t.a.b(r55, r30);
    L169:
        r116 = false;
        goto L170
    L110:
        r43 = true;
        goto L187
    L118:
        IslandWidget r61 = r41.getCollapseWidget();     // Catch: Throwable -> L115
        if (r61 == null) goto L121;
        String r62 = r61.getTemplateId();     // Catch: Throwable -> L115
    L123:
        if (Intrinsics.areEqual(r62, r15) == false) goto L175;
        IslandWidget r63 = r41.getExpandWidget();     // Catch: Throwable -> L115
        if (r63 == null) goto L127;
        String r64 = r63.getTemplateId();     // Catch: Throwable -> L115
    L129:
        if (Intrinsics.areEqual(r64, r18) == false) goto L175;
        r41.setFlags(64);     // Catch: Throwable -> L115
        r41.updateFlags();     // Catch: Throwable -> L134
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L134
    L136:
        IslandWidget r65 = r41.getCollapseWidget();     // Catch: Throwable -> L115
        if (r65 == null) goto L139;
        r65.setTemplateData(r30);     // Catch: Throwable -> L115
        r41.update(r65);     // Catch: Throwable -> L115
    L139:
        IslandWidget r66 = r41.getExpandWidget();     // Catch: Throwable -> L115
        if (r66 == null) goto L142;
        r66.setTemplateData(r23);     // Catch: Throwable -> L115
        r41.update(r66);     // Catch: Throwable -> L115
    L142:
        r41.setIntent(c(r2, r55.hashCode(), r114));     // Catch: Throwable -> L115
        r30 = r10;
        j(r30, r55, 300);     // Catch: Throwable -> L162
        j(r30, r55, 1000);     // Catch: Throwable -> L162
        if (r56 == null) goto L196;
        Boolean r67 = r56;
    L149:
        r41.setCanFrontShow(r67);     // Catch: Throwable -> L147
    L150:
        r44 = r41;
        goto L151
    L196:
        r67 = Boolean.TRUE;     // Catch: Throwable -> L147
        goto L149
    L134:
        th = move-exception;
        Result.Companion r68 = Result.Companion;     // Catch: Throwable -> L115
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L115
        goto L136
    L127:
        r64 = null;
    L175:
        int r69 = t.e;     // Catch: Throwable -> L173
        return t.a.a(r55, r10, "INVALID_PARAM", "templateId cannot be changed for existing session");
    L121:
        r62 = null;
    L115:
        th = th;
        r30 = r10;
    L173:
        th = th;
        r48 = r2;
        goto L179
    L99:
        r115 = false;
        goto L100
    L103:
        r114 = r112;
        goto L195
    L91:
        r113 = false;
    L177:
        th = th;
        r30 = r10;
        goto L117
    L86:
        r38 = null;
    L47:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
    L36:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L9:
        r13 = -1;
        goto L10
    L5:
        r12 = true;
        goto L6
    }
}

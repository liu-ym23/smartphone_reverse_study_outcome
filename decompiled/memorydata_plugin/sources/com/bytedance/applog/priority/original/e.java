package com.bytedance.applog.priority.original;

import android.database.sqlite.SQLiteDatabase;
import com.bytedance.applog.priority.PriorityCallback;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.constants.Constants;
import com.ss.android.common.lib.AppLogNewUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007\u001a*\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0001\u001a\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0000\u001a\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002\u001a\u0016\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u000f\u001a\u000e\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0007\u001a\u0018\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000fH\u0000\u001a\u0014\u0010'\u001a\u00020\u001b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001b0)\u001a*\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020,2\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0011\u001a.\u0010-\u001a\u00020\r2\u001c\u0010.\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r00\u0012\u0006\u0012\u0004\u0018\u0001010/H\u0000ø\u0001\u0000¢\u0006\u0002\u00102\u001a6\u00103\u001a\u00020\r2\u0006\u0010+\u001a\u00020,2\u0006\u00104\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u000f2\u0006\u00105\u001a\u0002062\u0006\u0010\b\u001a\u00020\t\u001a:\u00107\u001a\u00020\r2\u0006\u0010+\u001a\u00020,2\u0006\u00104\u001a\u00020\u00072\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u00105\u001a\u0002062\u0006\u0010\b\u001a\u00020\t\u001a\u001a\u00108\u001a\u0004\u0018\u00010\u000f2\u0006\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020\tH\u0000\u001a\f\u0010;\u001a\u00020\r*\u0004\u0018\u00010<\u001a\u000e\u0010=\u001a\u0004\u0018\u00010\u000f*\u0004\u0018\u00010\u0007\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, d2 = {"getUft8StringSizeByChars", "", "getGetUft8StringSizeByChars", "()Z", "setGetUft8StringSizeByChars", "(Z)V", "buildPriorityReportUrl", "", "groupId", "", "reportHost", "reportPath", "fillEventToPackJson", "", "packJson", "Lorg/json/JSONObject;", "events", "", "Lcom/bytedance/applog/priority/original/Model$EventKey;", "logger", "Lcom/bytedance/applog/log/AbsLogger;", "fillExtraToPackJson", "fillUidEnableToPackJson", "Lkotlin/Pair;", LBSLightLocationTraceLogger.ENCRYPT, "formatDateTime", "timeInMs", "", "gcdMin1", "a", "b", "getEventNameFromJson", "eventType", "json", "getUtf8StringSize", "input", "mergeJson", "targetJson", "sourceJson", "minInterval", "intervals", "", "monitorEventsLatency", "callback", "Lcom/bytedance/applog/priority/PriorityCallback;", "runOnIOThread", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "stageEvent", "stage", "priorityName", "Lcom/bytedance/applog/priority/original/Model$PriorityName;", "stageEvents", "waitHeader", "priorityCallback", "cnt", "endTransactionSafely", "Landroid/database/sqlite/SQLiteDatabase;", "toJson", "priority_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1832a = true;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1833a = null;

        static {
            int[] r0 = new int[Model.EventType.values().length];
            r0[Model.EventType.V3.ordinal()] = 1;
            r0[Model.EventType.V1.ordinal()] = 2;
            r0[Model.EventType.LogData.ordinal()] = 3;
            r0[Model.EventType.Launch.ordinal()] = 4;
            r0[Model.EventType.Terminate.ordinal()] = 5;
            f1833a = r0;
        }
    }

    static {
    }

    public static final int a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        int r2 = 0;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        if (f1832a == true) goto L12;
        byte[] r6 = r5.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).getBytes(charset)");
        return r6.length;
    L12:
        int r1 = 0;
    L14:
        if (r2 >= r5.length()) goto L26;
        char r3 = r5.charAt(r2);
        if (r3 > 127) goto L19;
        r1 = r1 + 1;
    L25:
        r2 = r2 + 1;
        goto L14
    L19:
        if (r3 > 2047) goto L22;
        r1 = r1 + 2;
        goto L25
    L22:
        if (Character.isHighSurrogate(r3) == false) goto L24;
        r1 = r1 + 4;
        r2 = r2 + 1;
        goto L25
    L24:
        r1 = r1 + 3;
        goto L25
    L26:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    private static final long a(long r4, long r6) {
        long r5 = RangesKt.coerceAtLeast(1, r4);
        long r7 = RangesKt.coerceAtLeast(1, r6);
    L3:
        long r2 = r5;
        r5 = r7;
        if (r5 == 0) goto L6;
        r7 = r2 % r5;
        goto L3
    L6:
        return r2;
    }

    public static final long a(List<Long> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "intervals");
        int r0 = r6.size();
        if (r0 != 0) goto L5;
        return Long.MAX_VALUE;
    L5:
        if (r0 == 1) goto L11;
        return a(((Number) ZeusTransformUtils.preCheckCast(r6.get(0), Number.class, "com.obric.memorydata.plugin")).longValue(), a(r6.subList(1, r6.size())));
    L11:
        return RangesKt.coerceAtLeast(1, ((Number) ZeusTransformUtils.preCheckCast(r6.get(0), Number.class, "com.obric.memorydata.plugin")).longValue());
    }

    public static final String a(int r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "reportHost");
        Intrinsics.checkNotNullParameter(r3, "reportPath");
        return r2 + r3 + "?app_log_priority=" + r1;
    }

    public static final String a(int r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "json");
        Model.EventType r3 = Model.EventType.Companion.a(r1);
        int r4 = a.f1833a[r3.ordinal()];
        if (r4 != 1) goto L5;
        String r5 = r2.optString("event");
        String r6 = "{\n            json.optString(\"event\")\n        }";
    L12:
        Intrinsics.checkNotNullExpressionValue(r5, r6);
        return r5;
    L5:
        if (r4 != 2) goto L7;
        r5 = r2.optString(LocationMonitorConst.TAG);
        r6 = "{\n            json.optString(\"tag\")\n        }";
        goto L12
    L7:
        if (r4 == 3) goto L9;
        return "";
    L9:
        r5 = r2.optString("log_type");
        r6 = "{\n            json.optString(\"log_type\")\n        }";
        goto L12
    }

    public static final String a(long r3) {
        String r4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(r3));
        Intrinsics.checkNotNullExpressionValue(r4, "SimpleDateFormat(\"yyyy-M…S).format(Date(timeInMs))");
        return r4;
    }

    public static final Pair<String, String> a(JSONObject r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "packJson");
        r3.put("uid_enable", 1);
        if (r4 == true) goto L5;
        return null;
    L5:
        Pair<String, String> r5 = h.a();
        if (r5 != null) goto L8;
        return null;
    L8:
        String r0 = (String) ZeusTransformUtils.preCheckCast(r5.component1(), String.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.component2(), String.class, "com.obric.memorydata.plugin");
        r3.put("key", r0);
        r3.put("iv", r6);
        return TuplesKt.to(r0, r6);
    }

    public static final JSONObject a(PriorityCallback r4, int r5) {
        PriorityCallback r6 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r4, PriorityCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "priorityCallback");
        String r0 = r6.getHeaderJson();
        if (r0 != null) goto L5;
    L12:
        if (r5 <= 0) goto L15;
        Thread.sleep(300);
        return a(r6, r5 - 1);
    L15:
        return null;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L12;
        return new JSONObject(r0);
    L7:
        r1 = false;
        goto L8
    }

    public static final void a(SQLiteDatabase r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.isOpen() == true) goto L6;
        return;
    L6:
        if (r1.inTransaction() == false) goto L14;
        r1.endTransaction();     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    public static final void a(PriorityCallback r6, int r7, Map<Model.a, ? extends JSONObject> r8) {
        PriorityCallback r9 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r6, PriorityCallback.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r10, "events");
        Iterator r11 = r10.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Model.a r0 = (Model.a) ZeusTransformUtils.preCheckCast(r11.next(), Model.a.class, "com.obric.memorydata.plugin");
        long r2 = (System.currentTimeMillis() / ((long) 1000)) - r0.c();
        r9.monitorLatency(r7, r0.d().getType(), (int) r2);
        goto L4
    }

    public static final void a(PriorityCallback r9, String r10, int r11, JSONObject r12, Model.PriorityName r13, int r14) {
        PriorityCallback r0 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r9, PriorityCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "callback");
        Intrinsics.checkNotNullParameter(r10, "stage");
        Intrinsics.checkNotNullParameter(r12, "json");
        Intrinsics.checkNotNullParameter(r13, "priorityName");
        if (r0.isStageEnabled() == true) goto L6;
        return;
    L6:
        if (r12.optInt("event_stained") > 0) goto L8;
        return;
    L8:
        r0.monitorStage(r10, r13.name(), r14, r11, a(r11, r12), r12.optString("monitor_id"), r12.optLong("local_time_ms", System.currentTimeMillis()));
    }

    public static final void a(PriorityCallback r8, String r9, Map<Model.a, ? extends JSONObject> r10, Model.PriorityName r11, int r12) {
        PriorityCallback r13 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r8, PriorityCallback.class, "com.obric.memorydata.plugin");
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "callback");
        Intrinsics.checkNotNullParameter(r9, "stage");
        Intrinsics.checkNotNullParameter(r14, "events");
        Intrinsics.checkNotNullParameter(r11, "priorityName");
        if (r13.isStageEnabled() == true) goto L5;
        return;
    L5:
        Iterator r15 = r14.entrySet().iterator();
    L7:
        if (r15.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Model.a r2 = (Model.a) ZeusTransformUtils.preCheckCast(r0.getKey(), Model.a.class, "com.obric.memorydata.plugin");
        JSONObject r5 = (JSONObject) ZeusTransformUtils.preCheckCast(r0.getValue(), JSONObject.class, "com.obric.memorydata.plugin");
        a(r13, r9, r2.d().getType(), r5, r11, r12);
        goto L7
    }

    public static final void a(Function1<? super Continuation<? super Unit>, ? extends Object> r9) {
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "block");
        al r3 = am.a(ba.c().plus((CoroutineContext) ZeusTransformUtils.preCheckCast(cu.a(null, 1, null), CoroutineContext.class, "com.obric.memorydata.plugin")));
        kotlinx.coroutines.i.a(r3, null, null, (Function2) ZeusTransformUtils.preCheckCast(new CommonKt$runOnIOThread$1$1(r10, r3, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public static final void a(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "packJson");
        r4.put(Api.KEY_MAGIC, Api.MSG_MAGIC);
        r4.put("local_time", System.currentTimeMillis() / ((long) 1000));
        r4.put("_gen_time", System.currentTimeMillis());
    }

    public static final void a(JSONObject r9, Map<Model.a, ? extends JSONObject> r10, com.bytedance.applog.log.a r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        com.bytedance.applog.log.a r13 = (com.bytedance.applog.log.a) ZeusTransformUtils.wrapperContextForParams(r11, com.bytedance.applog.log.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "packJson");
        Intrinsics.checkNotNullParameter(r12, "events");
        Intrinsics.checkNotNullParameter(r13, "logger");
        final JSONArray r3 = new JSONArray();
        final JSONArray r4 = new JSONArray();
        final JSONArray r5 = new JSONArray();
        final JSONArray r6 = new JSONArray();
        final JSONArray r7 = new JSONArray();
        Iterator r14 = r12.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L22;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Model.a r2 = (Model.a) ZeusTransformUtils.preCheckCast(r0.getKey(), Model.a.class, "com.obric.memorydata.plugin");
        JSONObject r1 = (JSONObject) ZeusTransformUtils.preCheckCast(r0.getValue(), JSONObject.class, "com.obric.memorydata.plugin");
        Model.EventType r8 = r2.d();
        int r15 = a.f1833a[r8.ordinal()];
        if (r15 != 1) goto L8;
        r3.put(r1);
        goto L4
    L8:
        if (r15 != 2) goto L10;
        r4.put(r1);
        goto L4
    L10:
        if (r15 != 3) goto L12;
        r5.put(r1);
        goto L4
    L12:
        if (r15 != 4) goto L14;
        r6.put(r1);
        goto L4
    L14:
        if (r15 != 5) goto L4;
        r7.put(r1);
        goto L4
    L22:
        if (r3.length() <= 0) goto L25;
        r9.put(AppLogNewUtils.EVENT_V3_CATEGORY, r3);
    L25:
        if (r4.length() <= 0) goto L28;
        r9.put("event", r4);
    L28:
        if (r5.length() <= 0) goto L31;
        r9.put("log_data", r5);
    L31:
        if (r6.length() <= 0) goto L34;
        r9.put(Constants.LAUNCH_TAG, r6);
    L34:
        if (r7.length() <= 0) goto L36;
        r9.put("terminate", r7);
    L36:
        r13.a("fillEventToPackJson", (Function0) ZeusTransformUtils.preCheckCast(new CommonKt$fillEventToPackJson$1(r3, r4, r5, r6, r7), Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final void a(JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, "targetJson");
        Intrinsics.checkNotNullParameter(r5, "sourceJson");
        if (r5.length() > 0) goto L5;
        return;
    L5:
        Iterator<String> r0 = r5.keys();
        Intrinsics.checkNotNullExpressionValue(r0, "sourceJson.keys()");
    L7:
        if (r0.hasNext() == false) goto L9;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        r4.put(r1, r5.get(r1));
        goto L7
    }

    public static final JSONObject b(String r2) {
        if (r2 != null) goto L8;
        return null;
    L8:
        return new JSONObject(r2);
    L7:
        return null;
    }
}

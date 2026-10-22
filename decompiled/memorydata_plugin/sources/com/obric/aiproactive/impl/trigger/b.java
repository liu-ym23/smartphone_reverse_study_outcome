package com.obric.aiproactive.impl.trigger;

import com.obric.memorydata.task.cron.CronJobRunnerTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\u0010\n\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/aiproactive/impl/trigger/EcaTimerConfigParser;", "", "<init>", "()V", "whitespace", "Lkotlin/text/Regex;", "parse", "", "", "", "raw", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6525a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Regex f6526b = null;

    static {
        f6525a = new b();
        f6526b = new Regex("\\s+");
    }

    private b() {
    }

    public final Map<String, Boolean> a(String r12) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == true) goto L11;
        String r14 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.startsWith$default(r14, "[", false, 2, null) == false) goto L16;
        JSONArray r15 = new JSONArray(r14);
    L21:
        LinkedHashMap r16 = new LinkedHashMap();
        int r3 = r15.length();
        int r5 = 0;
    L22:
        if (r5 >= r3) goto L47;
        Object r6 = r15.opt(r5);
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L27;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
    L29:
        Intrinsics.checkNotNull(r7);
        String r8 = f6526b.replace((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin"), " ");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L45;
        if (ZeusTransformUtils.instanceOf(r6, JSONObject.class) == false) goto L34;
        JSONObject r9 = (JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.memorydata.plugin");
    L35:
        if (r9 == null) goto L37;
        boolean r10 = r9.optBoolean("triggerExactly", false);
    L38:
        Map r17 = (Map) ZeusTransformUtils.preCheckCast(r16, Map.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r16.get(r8), true) == true) goto L43;
        if (r10 == true) goto L43;
        boolean r18 = false;
    L44:
        r17.put(r8, Boolean.valueOf(r18));
    L43:
        r18 = true;
        goto L44
    L37:
        r10 = false;
        goto L38
    L34:
        r9 = null;
    L45:
        r5 = r5 + 1;
        goto L22
    L27:
        if (ZeusTransformUtils.instanceOf(r6, JSONObject.class) == false) goto L45;
        r7 = ((JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.memorydata.plugin")).optString(CronJobRunnerTask.KEY_CRON);
        goto L29
    L47:
        return (Map) ZeusTransformUtils.preCheckCast(r16, Map.class, "com.obric.memorydata.plugin");
    L16:
        if (StringsKt.startsWith$default(r14, "{", false, 2, null) == false) goto L20;
        r15 = new JSONObject(r14).optJSONArray("timers");
        if (r15 != null) goto L21;
        r15 = new JSONArray();
        goto L21
    L20:
        r15 = new JSONArray();
        goto L21
    L11:
        return MapsKt.emptyMap();
    L5:
        if (StringsKt.isBlank(r11) == true) goto L8;
        r13 = false;
        goto L9
    }
}

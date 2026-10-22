package com.obric.memorydata.awareness.impl.b;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.memorydata.ability.data.AudioAppInfo;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J:\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/awareness/impl/tracker/FeatureTracker;", "", "<init>", "()V", "AWARENESS_EVENT_CHANGE", "", "TAG", "lastChargeOnTs", "", "trackOnEventChanged", "", "eventName", "track", "featureName", "oldValue", EventBody.KEY_VALUE, WsConstants.KEY_EXTRA, "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8634a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f8635b;

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.impl.b.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0436a extends TypeToken<List<? extends AudioAppInfo>> {
        public C0436a() {
        }
    }

    static {
        f8634a = new a();
    }

    private a() {
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        JSONObject r1 = new JSONObject();
        r1.put("event_name", r2);
        r1.put(WsConstants.KEY_EXTRA, "");
        Tracker.INSTANCE.reportEvent("awareness_event_changed", r1);
    }

    public final void a(String r17, Object r18, Object r19, Map<String, ? extends Object> r20) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "featureName");
        Object r7 = 0;
        long r8 = 0;
        switch(r17.hashCode()) {
            case -1439533888: goto L46;
            case -1225903362: goto L41;
            case -1142385697: goto L31;
            case 1587177638: goto L6;
            default: goto L76;
        };
    L76:
        return;
    L6:
        if (r17.equals("device_active_audio") == true) goto L9;
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r19, String.class) == false) goto L66;
        List r1 = null;
        r1 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson((String) ZeusTransformUtils.preCheckCast(r19, String.class, "com.obric.memorydata.plugin"), new C0436a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L13 JsonSyntaxException -> L15
    L18:
        if (r1 != null) goto L20;
        r1 = CollectionsKt.emptyList();
    L20:
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L22:
        if (r0.hasNext() == false) goto L81;
        AudioAppInfo r2 = (AudioAppInfo) ZeusTransformUtils.preCheckCast(r0.next(), AudioAppInfo.class, "com.obric.memorydata.plugin");
        if (r2.getActive() == true) goto L22;
        RunLog.INSTANCE.debug("FeatureTracker", "report packageName: " + r2.getPackageName());
        Tracker r4 = Tracker.INSTANCE;
        JSONObject r5 = new JSONObject();
        r5.put("audio_type", r2.getAudioType());
        r5.put("output_type", r2.getOutputType());
        r5.put("package_name", r2.getPackageName());
        Long r6 = r2.getEndTime();
        if (r6 == null) goto L28;
        long r9 = r6.longValue() - r2.getBeginTime();
    L29:
        r5.put("duration", r9);
        Unit r10 = Unit.INSTANCE;
        r4.reportEvent("audio_output_end", r5);
        goto L22
    L28:
        r9 = 0;
        goto L29
    L81:
        return;
    L15:
        e = e;
        IRunLog r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r12 = new StringBuilder();
    L17:
        IRunLog.a.b(r11, "GsonExt", r12.append("toListObj error : ").append(e).toString(), null, 4, null);
    L13:
        e = e;
        r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r12 = new StringBuilder();
        goto L17
    L66:
        return;
    L31:
        if (r17.equals("device_is_power_save_mode") == false) goto L78;
        Tracker r13 = Tracker.INSTANCE;
        JSONObject r14 = new JSONObject();
        r14.put("operation_status", r19);
        if (r3 == null) goto L39;
        Object r15 = r3.get("power");
        if (r15 == null) goto L39;
        r7 = r15;
    L39:
        r14.put("device_battery", r7);
        Unit r16 = Unit.INSTANCE;
        String r21 = "power_save_mode";
    L44:
        r13.reportEvent(r21, r14);
        return;
    L78:
        return;
    L41:
        if (r17.equals("device_active_network") == false) goto L79;
        r13 = Tracker.INSTANCE;
        r14 = new JSONObject();
        r14.put("network_before", r18);
        r14.put("network_after", r19);
        Unit r22 = Unit.INSTANCE;
        r21 = "network_connection_method";
        goto L44
    L79:
        return;
    L46:
        if (r17.equals("device_is_charge") == true) goto L49;
        return;
    L49:
        if (Intrinsics.areEqual(r19, true) == false) goto L57;
        f8635b = System.currentTimeMillis();
        Tracker r23 = Tracker.INSTANCE;
        JSONObject r24 = new JSONObject();
        r24.put("charge_status", r19);
        if (r3 == null) goto L56;
        Object r25 = r3.get("power");
        if (r25 == null) goto L56;
    L55:
        r7 = r25;
    L56:
        r24.put("device_battery", r7);
        Unit r26 = Unit.INSTANCE;
        r23.reportEvent("charging_the_device", r24);
        return;
    L57:
        r23 = Tracker.INSTANCE;
        r24 = new JSONObject();
        r24.put("charge_status", r19);
        if (f8635b == 0) goto L61;
        r8 = System.currentTimeMillis() - f8635b;
    L61:
        r24.put("charge_time", r8);
        if (r3 == null) goto L56;
        r25 = r3.get("power");
        if (r25 != null) goto L55;
        goto L55
    }
}

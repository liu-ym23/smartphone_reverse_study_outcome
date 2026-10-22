package com.obric.memorydata.awareness.persistent;

import android.os.Bundle;
import com.bytedance.crash.entity.EventBody;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.AwarenessEventData;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJU\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0018J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010*\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/awareness/persistent/AwarenessEventReportDispatcher;", "", "<init>", "()V", "eventDeduplicator", "Lcom/obric/memorydata/awareness/persistent/AwarenessEventDeduplicator;", "report", "Lcom/obric/memorydata/sdk/MemoryResponse;", "Ljava/lang/Void;", "data", "Lcom/obric/memorydata/sdk/awareness/AwarenessEventData;", "now", "", "eventSink", "Lkotlin/Function2;", "", "", "", "deduplicator", "report$awareness_obricRelease", "resolveEventName", "normalizeValue", "", EventBody.KEY_VALUE, "(Ljava/lang/Object;)Ljava/lang/Integer;", "normalizeFloatingPointValue", "", "(D)Ljava/lang/Integer;", "normalizeTimestamp", "timestamp", "toMap", "Landroid/os/Bundle;", "TAG", "ONE_DAY_MS", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8766a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f8767b = null;

    static {
        f8766a = new c();
        f8767b = new b();
    }

    private c() {
    }

    private final long a(long r5, long r7) {
        if (r5 > 0) goto L6;
        return r7;
    L6:
        if (r5 < r7) goto L8;
        long r0 = r5 - r7;
    L10:
        if (r0 > WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) goto L12;
        return r5;
    L12:
        return r7;
    L8:
        r0 = r7 - r5;
        goto L10
    }

    public static /* synthetic */ MemoryResponse a(c r6, AwarenessEventData r7, long r8, Function2 r10, b r11, int r12, Object r13) {
        Function2<? super String, ? super Map<String, ? extends Object>, Unit> r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r10, Function2.class, "com.obric.memorydata.plugin");
        if ((r12 & 8) == 0) goto L6;
        r11 = f8767b;
    L6:
        return r6.a(r7, r8, r4, r11);
    }

    private final Integer a(double r8) {
        boolean r0 = true;
        if (Double.isInfinite(r8) == false) goto L5;
    L7:
        boolean r7 = false;
    L9:
        if (r7 == true) goto L11;
    L23:
        return null;
    L11:
        if ((r8 % 1.0d) == 0.0d) goto L14;
        r0 = false;
    L14:
        if (r0 == false) goto L23;
        if (r8 < (-2.147483648E9d)) goto L23;
        if (r8 > 2.147483647E9d) goto L23;
        return Integer.valueOf((int) r8);
    L5:
        if (Double.isNaN(r8) == true) goto L7;
        r7 = true;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Integer a(Object r8) {
        if (ZeusTransformUtils.instanceOf(r8, Boolean.class) == false) goto L6;
        int r7 = ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L42:
        return Integer.valueOf(r7);
    L6:
        if (ZeusTransformUtils.instanceOf(r8, Byte.class) == false) goto L10;
        r7 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).byteValue();
        goto L42
    L10:
        if (ZeusTransformUtils.instanceOf(r8, Short.class) == false) goto L13;
        r7 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).shortValue();
        goto L42
    L13:
        if (ZeusTransformUtils.instanceOf(r8, Integer.class) == false) goto L16;
        return (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.memorydata.plugin");
    L16:
        if (ZeusTransformUtils.instanceOf(r8, Long.class) == false) goto L29;
        long r3 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).longValue();
        boolean r0 = false;
        if ((-2147483648L) <= r3) goto L20;
    L22:
        if (r0 == true) goto L25;
        r8 = null;
    L25:
        Long r9 = (Long) ZeusTransformUtils.preCheckCast(r8, Long.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L44;
        r7 = (int) r9.longValue();
        goto L42
    L44:
        return null;
    L20:
        if (r3 > 2147483647L) goto L22;
        r0 = true;
        goto L22
    L29:
        if (ZeusTransformUtils.instanceOf(r8, Float.class) == false) goto L33;
        double r1 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).floatValue();
    L45:
        return a(r1);
    L33:
        if (ZeusTransformUtils.instanceOf(r8, Double.class) == false) goto L36;
        r1 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        goto L45
    L36:
        if (ZeusTransformUtils.instanceOf(r8, Character.class) == false) goto L39;
        return CharsKt.digitToIntOrNull(((Character) ZeusTransformUtils.preCheckCast(r8, Character.class, "com.obric.memorydata.plugin")).charValue());
    L39:
        if (ZeusTransformUtils.instanceOf(r8, String.class) == true) goto L41;
        return null;
    L41:
        return StringsKt.toIntOrNull(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
    }

    private final Map<String, Object> a(Bundle r6) {
        Set<String> r5 = r6.keySet();
        Intrinsics.checkNotNullExpressionValue(r5, "keySet(...)");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        LinkedHashMap r0 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16));
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        Object r2 = r8.next();
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(r2, r6.get((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin")));
        goto L4
    L7:
        return (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin");
    }

    private static final Unit a(Function2 r2, String r3, Map r4) {
        ((Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin")).invoke(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private final String b(AwarenessEventData r5) {
        Integer r4 = a(r5.getValue());
        if (r4 == null) goto L37;
        int r6 = r4.intValue();
        String r7 = r5.getKey();
        switch(r7.hashCode()) {
            case 666122425: goto L29;
            case 1328800982: goto L24;
            case 1925907146: goto L16;
            case 2125585246: goto L8;
            default: goto L45;
        };
    L45:
        return null;
    L8:
        if (r7.equals("wearing_event") == false) goto L46;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L47;
        return EventNames.GLASSES_PUT_ON;
    L47:
        return null;
    L14:
        return EventNames.GLASSES_TAKEN_OFF;
    L46:
        return null;
    L16:
        if (r7.equals("sedentary_event") == false) goto L48;
        if (r6 == 1) goto L22;
        if (r6 != 2) goto L49;
        return EventNames.SEDENTARY_ENDED;
    L49:
        return null;
    L22:
        return EventNames.SEDENTARY_STARTED;
    L48:
        return null;
    L24:
        if (r7.equals("fall_event") == false) goto L50;
        if (r6 != 1) goto L42;
        return EventNames.FALL_DETECTED;
    L42:
        return null;
    L50:
        return null;
    L29:
        if (r7.equals("long_head_down_event") == false) goto L51;
        if (r6 == 1) goto L35;
        if (r6 != 2) goto L52;
        return EventNames.PROLONGED_HEAD_DOWN_ENDED;
    L52:
        return null;
    L35:
        return EventNames.PROLONGED_HEAD_DOWN_STARTED;
    L51:
        return null;
    L37:
        return null;
    }

    public static /* synthetic */ Unit lambda$f1SrhMh4PetWO2gk7xf9ZAmc3EI(Function2 r0, String r1, Map r2) {
        return a(r0, r1, r2);
    }

    public final MemoryResponse<Void> a(AwarenessEventData r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        return a(this, r10, System.currentTimeMillis(), (Function2) ZeusTransformUtils.preCheckCast(new AwarenessEventReportDispatcher$report$1(AwarenessManager.INSTANCE), Function2.class, "com.obric.memorydata.plugin"), null, 8, null);
    }

    public final MemoryResponse<Void> a(AwarenessEventData r9, long r10, Function2<? super String, ? super Map<String, ? extends Object>, Unit> r12, b r13) {
        final Function2 r14 = (Function2) ZeusTransformUtils.wrapperContextForParams(r12, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r14, "eventSink");
        Intrinsics.checkNotNullParameter(r13, "deduplicator");
        final String r0 = b(r9);
        if (r0 == null) goto L5;
        long r11 = a(r9.getTimestamp(), r10);
        Long r2 = Long.valueOf(r9.getTimestamp());
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L15;
        long r5 = r2.longValue();
    L16:
        final Map r8 = MapsKt.toMutableMap(a(r9.getExtras()));
        r8.put("timestamp", Long.valueOf(r11));
        if (r13.a(r9.getKey(), r0, r5, new $$Lambda$c$f1SrhMh4PetWO2gk7xf9ZAmc3EI(r14, r0, r8)) == true) goto L20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AwarenessEventReport", "感知信号重复，跳过分发，key=" + r9.getKey() + ", event=" + r0, false, 4, null);
        return MemoryResponse.CREATOR.a();
    L20:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AwarenessEventReport", "感知信号已分发，key=" + r9.getKey() + ", event=" + r0 + ", timestamp=" + r11, false, 4, null);
        return MemoryResponse.CREATOR.a();
    L15:
        r5 = r11;
        goto L16
    L9:
        r3 = false;
        goto L10
    L5:
        return new MemoryResponse(405, "unsupported awareness event", null, 4, null);
    }
}

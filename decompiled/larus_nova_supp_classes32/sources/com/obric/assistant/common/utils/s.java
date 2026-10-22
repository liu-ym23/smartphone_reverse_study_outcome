package com.obric.assistant.common.utils;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AssistAudioEventProto;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new q());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.util.EventsUtils");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.util.EventsUtils");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.util.EventsUtils");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.util.EventsUtils");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.util.EventsUtils");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.util.EventsUtils");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.util.EventsUtils");
    }

    public static Integer c(byte[] r6) {
        Intrinsics.checkNotNullParameter(r6, "eventData");
        Lazy r0 = a;
        if (((Method) r0.getValue()) != null) goto L11;
        FLogger.a.w("PbReportUtils", "report via sys pb: fail: writePbEventMethod is null");
        return null;
    L11:
        Method r1 = (Method) r0.getValue();     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L8
        return (Integer) r1.invoke(null, new Object[]{Long.valueOf(System.currentTimeMillis()), 106, r6});
    L8:
        e = move-exception;
        FLogger.a.w("PbReportUtils", "report via sys pb: reportPbEvent failed: " + e);
        return null;
    }

    public static AssistAudioEventProto.AssistAudioEventDataTraceViewer.Builder b(String r2, String r3, JSONObject r4) {
        AssistAudioEventProto.AssistAudioEventDataTraceViewer.Builder r5 = AssistAudioEventProto.AssistAudioEventDataTraceViewer.newBuilder().setTraceViewerType(r3).setTraceViewerBizTag("wakeup").setTraceViewerTrack(r2).setTraceViewerVal(r2).addTraceViewerExpansionKeyList("extra");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        if (Intrinsics.areEqual(r3, "instant") == false) goto L7;
        AssistAudioEventProto.AssistAudioEventDataTraceViewer.Builder r6 = r5.setTraceViewerEventTs(r4.optLong("timestamp"));     // Catch: Throwable -> L12
    L10:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L12
    L14:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L17;
        FLogger.a.w("PbReportUtils", "createTraceViewerInfoBuilder failed: " + r8);
    L17:
        return r5;
    L7:
        if (Intrinsics.areEqual(r3, "slice") == false) goto L9;
        long r1 = r4.optLong("raw_start_time");     // Catch: Throwable -> L12
        r5.setTraceViewerStartTs(r1);     // Catch: Throwable -> L12
        r6 = r5.setTraceViewerEndTs(r1 + r4.optLong("wakeup_total_duration"));     // Catch: Throwable -> L12
        goto L10
    L9:
        r6 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static Integer e(String r10, String r11, boolean r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, "wakeupStage");
        Intrinsics.checkNotNullParameter(r13, "payload");
        AssistAudioEventProto.AssistAudioEventDataTraceViewer r0 = b(r10, "instant", r13).m96build();
        AssistAudioEventProto.AssistAudioEventData.Builder r1 = AssistAudioEventProto.AssistAudioEventData.newBuilder();
        String r2 = r13.optString("session_type");
        AssistAudioEventProto.BreathWakeupEvent.Builder r4 = null;
        AssistAudioEventProto.VoiceWakeupEvent.Builder r5 = null;
        if (Intrinsics.areEqual(r2, "VOICE") == false) goto L28;
        AssistAudioEventProto.VoiceWakeupEvent.Builder r14 = AssistAudioEventProto.VoiceWakeupEvent.newBuilder().setEventName(r10).setEventReportSource("Assist").setWakeupStage(r11).setWakeupSuccess(r12);
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L19
        Iterator<String> r16 = r13.keys();     // Catch: Throwable -> L19
    L7:
        if (r16.hasNext() == false) goto L17;
        String r3 = r16.next();     // Catch: Throwable -> L19
        if (TextUtils.equals(r3, "reject_reason") == false) goto L11;
        r14.setRejectReason(r13.optString(r3));     // Catch: Throwable -> L19
    L11:
        Object r6 = r13.opt(r3);     // Catch: Throwable -> L19
        if (r6 == null) goto L15;
        String r7 = r6.toString();     // Catch: Throwable -> L19
        if (r7 == null) goto L15;
    L16:
        r14.putExtra(r3, r7);     // Catch: Throwable -> L19
    L15:
        r7 = NameKeys.UnloadStrategy_No_Strategy;
        goto L16
    L17:
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L24;
        FLogger.a.w("PbReportUtils", "createBreathWakeupEventBuilder failed: " + r18);
    L24:
        if (r14 == null) goto L26;
        r5 = r14.addTraceViewers(r0);
    L26:
        r1.addVoiceWakeupEvent(r5);
    L52:
        AssistAudioEventProto.AssistAudioEventData r19 = r1.m49build();
        Integer r110 = c(r19.toByteArray());
        FLogger.a.d("PbReportUtils", "reportWakeupEventViaSysPb, eventName: " + r10 + ", data = " + r19 + ", res = " + r110);
        return r110;
    L19:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L28:
        if (Intrinsics.areEqual(r2, "BREATH") == false) goto L52;
        AssistAudioEventProto.BreathWakeupEvent.Builder r112 = AssistAudioEventProto.BreathWakeupEvent.newBuilder().setEventName(r10).setEventReportSource("Assist").setWakeupStage(r11).setWakeupSuccess(r12);
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L44
        Iterator<String> r114 = r13.keys();     // Catch: Throwable -> L44
    L32:
        if (r114.hasNext() == false) goto L42;
        String r8 = r114.next();     // Catch: Throwable -> L44
        if (TextUtils.equals(r8, "reject_reason") == false) goto L36;
        r112.setRejectReason(r13.optString(r8));     // Catch: Throwable -> L44
    L36:
        Object r9 = r13.opt(r8);     // Catch: Throwable -> L44
        if (r9 == null) goto L40;
        String r20 = r9.toString();     // Catch: Throwable -> L44
        if (r20 == null) goto L40;
    L41:
        r112.putExtra(r8, r20);     // Catch: Throwable -> L44
    L40:
        r20 = NameKeys.UnloadStrategy_No_Strategy;
        goto L41
    L42:
        Object r115 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L46:
        Throwable r116 = Result.exceptionOrNull-impl(r115);
        if (r116 == null) goto L49;
        FLogger.a.w("PbReportUtils", "createBreathWakeupEventBuilder failed: " + r116);
    L49:
        if (r112 == null) goto L51;
        r4 = r112.addTraceViewers(r0);
    L51:
        r1.addBreathWakeupEvent(r4);
    L44:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    }

    public static Integer d(String r4, long r5, long r7, long r9, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r11, "payload");
        AssistAudioEventProto.AssistAudioEventDataTraceViewer r0 = b(r4, "slice", r11).m96build();
        AssistAudioEventProto.AssistAudioEventData.Builder r1 = AssistAudioEventProto.AssistAudioEventData.newBuilder();
        AssistAudioEventProto.VoiceWakeupDuration.Builder r6 = AssistAudioEventProto.VoiceWakeupDuration.newBuilder().setEventName(r4).setEventReportSource("Assist").setWakeupStage1Duration(r5).setWakeupStage2Duration(r7).setWakeupStage3Duration(r9).addTraceViewers(r0);
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L14
        Iterator<String> r10 = r11.keys();     // Catch: Throwable -> L14
    L5:
        if (r10.hasNext() == false) goto L12;
        String r12 = r10.next();     // Catch: Throwable -> L14
        Object r13 = r11.opt(r12);     // Catch: Throwable -> L14
        if (r13 == null) goto L10;
        String r14 = r13.toString();     // Catch: Throwable -> L14
        if (r14 == null) goto L10;
    L11:
        r6.putExtra(r12, r14);     // Catch: Throwable -> L14
    L10:
        r14 = NameKeys.UnloadStrategy_No_Strategy;
        goto L11
    L12:
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L19;
        FLogger.a.w("PbReportUtils", "reportWakeupDurationViaSysPb failed: " + r16);
    L19:
        AssistAudioEventProto.AssistAudioEventData r17 = r1.addVoiceWakeupDuration(r6).m49build();
        Integer r18 = c(r17.toByteArray());
        FLogger.a.d("PbReportUtils", "reportWakeupDurationViaSysPb, eventName: " + r4 + ", data = " + r17 + ", res = " + r18);
        return r18;
    L14:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }
}

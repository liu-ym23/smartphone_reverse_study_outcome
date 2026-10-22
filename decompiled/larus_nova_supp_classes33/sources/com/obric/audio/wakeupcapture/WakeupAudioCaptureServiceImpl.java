package com.obric.audio.wakeupcapture;

import com.larus.audio.call.record.CaptureBackTraceReadScene;
import com.larus.audio.call.record.h;
import com.larus.audio.call.record.l;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService;
import com.obric.assistant.spi.audio.WakeupAudioCaptureReadScene;
import com.obric.assistant.spi.audio.WakeupAudioCaptureTriggerType;
import com.obric.assistant.t1;
import com.obric.assistant.voice.IWakeupTruthCaptureSwitchSyncService;
import com.obric.capabilitykit.common.Ext;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hga.c;
import hga.e;
import hga.f;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tia.g;
import tia.i;
import tia.j;
import tia.k;
import tia.p;
import tia.q;
import tia.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/audio/wakeupcapture/WakeupAudioCaptureServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricWakeupAudioCaptureService;", "<init>", "()V", "isCaptureEnabled", "", "hasActiveCapture", "onWakeupTrigger", "", WindowEvent.Params.TRIGGER, "Lcom/obric/assistant/spi/audio/WakeupAudioCaptureTrigger;", "openReader", "Lcom/obric/assistant/spi/audio/IObricWakeupAudioCaptureReader;", Ext.KEY_REQUEST, "Lcom/obric/assistant/spi/audio/WakeupAudioCaptureReadRequest;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeupAudioCaptureServiceImpl implements IObricWakeupAudioCaptureService {

    public static final class a implements h {
        public final /* synthetic */ WakeupAudioCaptureServiceImpl a;

        public a(WakeupAudioCaptureServiceImpl r1) {
            this.a = r1;
        }

        public final k a(l r9) {
            Intrinsics.checkNotNullParameter(r9, Ext.KEY_REQUEST);
            WakeupAudioCaptureServiceImpl r0 = this.a;
            CaptureBackTraceReadScene r1 = r9.a;
            int r2 = i.a[r1.ordinal()];
            if (r2 != 1) goto L5;
            WakeupAudioCaptureReadScene r3 = WakeupAudioCaptureReadScene.REALTIME_CALL;
        L10:
            c r10 = r0.c(new e(r3, r9.b, r9.c, r9.d));
            if (r10 != null) goto L15;
            return null;
        L15:
            return new k((tia.e) r10);
        L5:
            if (r2 != 2) goto L8;
            r3 = WakeupAudioCaptureReadScene.CONTINUOUS_TALK;
            goto L10
        L8:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b {
    }

    static {
    }

    public static boolean d() {
        j.a.getClass();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        String r2 = t1.a.getObricFlowSettingsJson("obric_wakeup_audio_capture_config");     // Catch: Throwable -> L12
        if (StringsKt.isBlank(r2) == false) goto L6;
    L9:
        boolean r3 = false;
    L10:
        Object r4 = Result.constructor-impl(Boolean.valueOf(r3));     // Catch: Throwable -> L12
    L14:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L17;
        FLogger.a.e("WakeupAudioCaptureSettings", "parse cloud config failed", r5);
    L17:
        Boolean r6 = Boolean.FALSE;
        if (Result.isFailure-impl(r4) == false) goto L20;
        r4 = r6;
    L20:
        boolean r7 = ((Boolean) r4).booleanValue();
        IWakeupTruthCaptureSwitchSyncService.a.getClass();     // Catch: Throwable -> L27
        IWakeupTruthCaptureSwitchSyncService r0 = (IWakeupTruthCaptureSwitchSyncService) ServiceManager.get().getService(IWakeupTruthCaptureSwitchSyncService.class, false, false);     // Catch: Throwable -> L27
        if (r0 == null) goto L24;
        r0.a(r7);     // Catch: Throwable -> L27
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L27
    L25:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L27
    L29:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L32;
        FLogger.a.e("WakeupAudioCaptureSettings", "sync wakeup truth capture switch failed", r10);
    L32:
        FLogger r11 = FLogger.a;
        r11.i("WakeupAudioCaptureSettings", "isEnabled cloudEnabled=" + r7);
        r11.i("WakeupAudioCaptureService", "isCaptureEnabled=" + r7);
        return r7;
    L24:
        r8 = null;
    L27:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L6:
        if (Intrinsics.areEqual(r2, "null") == true) goto L9;
        r3 = new JSONObject(r2).optBoolean("enable", false);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public WakeupAudioCaptureServiceImpl() {
        h r0 = com.larus.audio.call.record.i.a;
        com.larus.audio.call.record.i.a = new a(this);
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService
    public final boolean a() {
        if (d() == false) goto L13;
        Object r0 = tia.h.a;
        r r1 = tia.h.b;
        if (r1 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r1.b() != true) goto L9;
        r2 = true;
        goto L10
    L13:
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [tia.g] */
    @Override // com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService
    public final void b(f r9) {
        Intrinsics.checkNotNullParameter(r9, WindowEvent.Params.TRIGGER);
        if (d() == true) goto L6;
        FLogger.a.i("WakeupAudioCaptureService", "onWakeupTrigger ignored: disabled trigger=" + r9);
        return;
    L6:
        Object r0 = tia.h.a;
        Intrinsics.checkNotNullParameter(r9, WindowEvent.Params.TRIGGER);
        if (r9.a > 0) goto L9;
        FLogger.a.w("WakeupAudioCaptureCoordinator", "ignore invalid trigger=" + r9);
        return;
    L9:
        Object r3 = tia.h.a;
        monitor-enter(r3);
        r r4 = tia.h.b;     // Catch: Throwable -> L34
        boolean r5 = false;
        if (r4 != null) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == false) goto L22;
        FLogger.a.i("WakeupAudioCaptureCoordinator", "reuse active session for trigger=" + r9);     // Catch: Throwable -> L34
        r4.a(r9);     // Catch: Throwable -> L34
        monitor-exit(r3);
        return;
    L22:
        if (r9.b != WakeupAudioCaptureTriggerType.VOICE_WAKEUP) goto L24;
        r5 = true;
    L24:
        if (r5 == true) goto L28;
        FLogger.a.i("WakeupAudioCaptureCoordinator", "trigger cannot start producer and no active session=" + r9);     // Catch: Throwable -> L34
        monitor-exit(r3);
        return;
    L28:
        r r1 = new r(r9, new g());     // Catch: Throwable -> L34
        tia.h.b = r1;     // Catch: Throwable -> L34
        boolean r2 = r1.d();     // Catch: Throwable -> L34
        FLogger.a.i("WakeupAudioCaptureCoordinator", "start new session result=" + r2 + " trigger=" + r9);     // Catch: Throwable -> L34
        if (r2 == true) goto L31;
        tia.h.b = null;     // Catch: Throwable -> L34
    L31:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(r3);
        return;
    L14:
        if (r4.b() != true) goto L16;
        r7 = true;
    L34:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService
    public final c c(e r11) {
        Intrinsics.checkNotNullParameter(r11, Ext.KEY_REQUEST);
        if (d() == true) goto L5;
        return null;
    L5:
        Object r0 = tia.h.a;
        Intrinsics.checkNotNullParameter(r11, Ext.KEY_REQUEST);
        final r r1 = tia.h.b;
        if (r1 != null) goto L8;
        return null;
    L8:
        if (r1.b() == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L39;
        Intrinsics.checkNotNullParameter(r11, Ext.KEY_REQUEST);
        if (r11.a != WakeupAudioCaptureReadScene.UPLOAD) goto L17;
        long r2 = r11.b;
    L16:
        long r6 = r2;
        WakeupAudioCaptureReadScene r5 = r11.a;
        String r8 = r11.c;
        int r9 = r11.d;
        Intrinsics.checkNotNullParameter(r5, "scene");
        Intrinsics.checkNotNullParameter(r8, WindowEvent.Params.REASON);
        tia.e r3 = new tia.e(r1.c, new e(r5, r6, r8, r9), new p(r1), new q(r1));
        Object r12 = r1.d;
        monitor-enter(r12);
    L32:
        th = move-exception;
        throw th;
    L26:
        if (r1.e.get() == false) goto L29;
        monitor-exit(r12);
        return null;
    L29:
        r1.f.add(r3);     // Catch: Throwable -> L32
        monitor-exit(r12);
        return r3;
    L17:
        Long r4 = r1.g.get(Integer.valueOf(r11.d));
        if (r4 != null) goto L20;
    L22:
        r2 = r11.b;
        goto L16
    L20:
        if (r4.longValue() <= 0) goto L22;
        FLogger.a.i("WakeupCaptureSession", "openReader use interaction start request=" + r11 + " interactionAudioStartTimeMs=" + r4);
        r2 = r4.longValue();
        goto L16
    L39:
        return null;
    }
}

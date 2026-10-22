package com.obric.assistant.dora.record_minutes;

import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.message.MessageStatus;
import com.larus.utils.logger.FLogger;
import com.mammon.speechaudiosdk.session.SpeechSessionManager;
import com.mammon.speechaudiosdk.session.param.SpeechRecorderAudioConsumerTaskCreateParam;
import com.mammon.speechaudiosdk.session.task.SpeechRecorderAudioConsumerTask;
import com.obric.assistant.IObricAvailableManager;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraConnectState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class DoraRecordMinutesService {
    public static final DoraRecordMinutesService a = null;
    public static final Uri b = null;
    public static final CoroutineScope c = null;
    public static Job d;
    public static Job e;
    public static volatile DoraConnectState f;
    public static volatile c g;
    public static final ConcurrentHashMap<String, i> h = null;

    public static final class a {
        public final boolean a;
        public final boolean b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L10;
            r1 = 1237;
        L10:
            int r3 = (r2 + r1) * 31;
            String r4 = this.c;
            int r5 = 0;
            if (r4 != null) goto L13;
            int r6 = 0;
        L14:
            int r7 = (r3 + r6) * 31;
            String r8 = this.d;
            if (r8 == null) goto L19;
            r5 = r8.hashCode();
        L19:
            return r7 + r5;
        L13:
            r6 = r4.hashCode();
            goto L14
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "AudioRecordControlResult(success=" + this.a + ", wasRecording=" + this.b + ", recordingId=" + this.c + ", errorMessage=" + this.d + ')';
        }

        public a(boolean r1, boolean r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public /* synthetic */ a(boolean r3, boolean r4, String r5, String r6, int r7) {
            if ((r7 & 2) == 0) goto L6;
            r4 = false;
        L6:
            if ((r7 & 4) == 0) goto L9;
            r5 = null;
        L9:
            if ((r7 & 8) == 0) goto L11;
            r6 = null;
        L11:
            this(r3, r4, r5, r6);
        }
    }

    public static final class b implements f {
        public final String a;
        public final e b;
        public final ArrayBlockingQueue<byte[]> c;
        public final AtomicBoolean d;
        public final AtomicBoolean e;
        public ParcelFileDescriptor f;
        public ExecutorService g;
        public volatile ParcelFileDescriptor.AutoCloseOutputStream h;
        public Function1<? super String, Unit> i;
        public final AtomicBoolean j;
        public final g k;
        public volatile boolean l;
        public final AtomicBoolean m;
        public final AtomicBoolean n;

        public final void b() {
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
            ParcelFileDescriptor.AutoCloseOutputStream r2 = this.h;     // Catch: Throwable -> L13
            if (r2 == null) goto L7;
            r2.close();     // Catch: Throwable -> L13
        L6:
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L13
        L11:
            Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L13
        L15:
            Throwable r5 = Result.exceptionOrNull-impl(r4);
            if (r5 == null) goto L18;
            FLogger.a.w("DoraRecordMinutesService", "close recorder pcm output failed, sessionId=" + this.a + ", error=" + r5.getMessage());
        L18:
            this.h = null;
            this.f = null;
            return;
        L7:
            ParcelFileDescriptor r6 = this.f;     // Catch: Throwable -> L13
            if (r6 == null) goto L10;
            r6.close();     // Catch: Throwable -> L13
            goto L6
        L10:
            r3 = null;
        L13:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            r4 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L15
        }

        @Override // com.obric.assistant.dora.record_minutes.DoraRecordMinutesService.f
        public final void onStarted() {
            FLogger.a.i("DoraRecordMinutesService", "recorder pcm capture started, sessionId=" + this.a);
        }

        @Override // com.obric.assistant.dora.record_minutes.DoraRecordMinutesService.f
        public final void onStopped() {
            FLogger.a.i("DoraRecordMinutesService", "recorder pcm capture stopped, sessionId=" + this.a);
        }

        public final void c(String r8) {
            Intrinsics.checkNotNullParameter(r8, WindowEvent.Params.REASON);
            if (this.e.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            this.d.set(false);
            this.c.clear();
            b();
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
            ExecutorService r3 = this.g;     // Catch: Throwable -> L15
            if (r3 == null) goto L9;
            r3.shutdownNow();     // Catch: Throwable -> L15
        L9:
            ExecutorService r4 = this.g;     // Catch: Throwable -> L15
            if (r4 == null) goto L12;
            Boolean r5 = Boolean.valueOf(r4.awaitTermination(300, TimeUnit.MILLISECONDS));     // Catch: Throwable -> L15
        L13:
            Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L15
        L17:
            Throwable r7 = Result.exceptionOrNull-impl(r6);
            if (r7 == null) goto L20;
            FLogger.a.w("DoraRecordMinutesService", "stop recorder pcm writer failed, sessionId=" + this.a + ", error=" + r7.getMessage());
        L20:
            this.g = null;
            this.l = false;
            this.m.set(false);
            this.i = null;
            FLogger.a.i("DoraRecordMinutesService", "recorder pcm forwarder stopped, sessionId=" + this.a + ", reason=" + r8);
            return;
        L12:
            r5 = null;
        L15:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r6 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L17
        }

        public b(String r3, e r4) {
            Intrinsics.checkNotNullParameter(r3, "sessionId");
            Intrinsics.checkNotNullParameter(r4, "format");
            this.a = r3;
            this.b = r4;
            this.c = new ArrayBlockingQueue(100);
            this.d = new AtomicBoolean(false);
            this.e = new AtomicBoolean(false);
            this.j = new AtomicBoolean(false);
            this.k = new g(r3, r4);
            this.m = new AtomicBoolean(false);
            this.n = new AtomicBoolean(false);
        }

        @Override // com.obric.assistant.dora.record_minutes.DoraRecordMinutesService.f
        public final void a(byte[] r2, e r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            Intrinsics.checkNotNullParameter(r3, "format");
            if (this.d.get() == true) goto L5;
            return;
        L5:
            if (this.e.get() == false) goto L8;
            return;
        L8:
            if (this.m.get() == false) goto L11;
            return;
        L11:
            if (this.l == true) goto L14;
            return;
        L14:
            if (this.c.offer(Arrays.copyOf(r2, r2.length)) == true) goto L22;
            FLogger.a.e("DoraRecordMinutesService", "recorder pcm queue overflow, sessionId=" + this.a);
            if (this.j.compareAndSet(false, true) == false) goto L23;
            Function1<? super String, Unit> r4 = this.i;
            if (r4 == null) goto L24;
            r4.invoke("recorder pcm queue overflow");
            return;
        L24:
            return;
        L23:
            return;
        }
    }

    public static final class c {
        public final String a;
        public final String b;
        public final b c;
        public final d d;

        public c(int r3, String r4, String r5) {
            e r0 = new e(0);
            Intrinsics.checkNotNullParameter(r4, "sessionId");
            Intrinsics.checkNotNullParameter(r0, "format");
            this.a = r4;
            this.b = r5;
            b r6 = new b(r4, r0);
            this.c = r6;
            this.d = new d(r3, r0, r6);
        }
    }

    public static final class d {
        public final int a;
        public final e b;
        public final f c;
        public SpeechRecorderAudioConsumerTask d;
        public SpeechSessionManager e;
        public final AtomicBoolean f;
        public final AtomicBoolean g;
        public final com.obric.assistant.dora.record_minutes.f h;

        public final void a() {
            if (this.g.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            this.f.set(false);
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
            SpeechRecorderAudioConsumerTask r2 = this.d;     // Catch: Throwable -> L12
            if (r2 == null) goto L9;
            Integer r3 = Integer.valueOf(r2.stop());     // Catch: Throwable -> L12
        L10:
            Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L12
        L14:
            Throwable r5 = Result.exceptionOrNull-impl(r4);
            if (r5 == null) goto L17;
            FLogger.a.w("DoraRecordMinutesService", "stop pcm capture failed, wakeId=" + this.a + ", error=" + r5.getMessage());
        L17:
            SpeechRecorderAudioConsumerTask r6 = this.d;
            if (r6 == null) goto L22;
            SpeechSessionManager r7 = this.e;
            if (r7 == null) goto L22;
            r7.releaseRecorderAudioConsumerTask(r6);
        L22:
            this.d = null;
            this.e = null;
            this.c.onStopped();
            FLogger.a.i("DoraRecordMinutesService", "close pcm capture, wakeId=" + this.a);
            return;
        L9:
            r3 = null;
        L12:
            th = move-exception;
            Result.Companion r8 = Result.Companion;
            r4 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L14
        }

        public d(int r2, e r3, b r4) {
            Intrinsics.checkNotNullParameter(r3, "pcmFormat");
            Intrinsics.checkNotNullParameter(r4, "callback");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.f = new AtomicBoolean(false);
            this.g = new AtomicBoolean(false);
            this.h = new com.obric.assistant.dora.record_minutes.f(this);
        }
    }

    public static final class e {
        public final String a;
        public final int b;
        public final int c;
        public final int d;

        public e() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "PcmFormat(format=" + this.a + ", sampleRate=" + this.b + ", channel=" + this.c + ", packetDurationMs=" + this.d + ')';
        }

        public e(int r2) {
            Intrinsics.checkNotNullParameter("pcm", "format");
            this.a = "pcm";
            this.b = 16000;
            this.c = 1;
            this.d = 20;
        }
    }

    public interface f {
        void a(byte[] r1, e r2);

        void onStarted();

        void onStopped();
    }

    public static final class g {
        public final String a;
        public final e b;
        public long c;
        public long d;
        public long e;
        public long f;
        public double g;
        public int h;

        public g(String r2, e r3) {
            Intrinsics.checkNotNullParameter(r2, "sessionId");
            Intrinsics.checkNotNullParameter(r3, "format");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class h {
        public final boolean a;
        public final String b;
        public final ParcelFileDescriptor c;
        public final e d;
        public final String e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof h) == true) goto L8;
            return false;
        L8:
            h r6 = (h) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            String r2 = this.b;
            int r3 = 0;
            if (r2 != null) goto L9;
            int r4 = 0;
        L10:
            int r5 = (r1 + r4) * 31;
            ParcelFileDescriptor r6 = this.c;
            if (r6 != null) goto L13;
            int r7 = 0;
        L14:
            int r8 = (((r5 + r7) * 31) + this.d.hashCode()) * 31;
            String r9 = this.e;
            if (r9 == null) goto L19;
            r3 = r9.hashCode();
        L19:
            return r8 + r3;
        L13:
            r7 = r6.hashCode();
            goto L14
        L9:
            r4 = r2.hashCode();
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "PcmReadFdResult(success=" + this.a + ", sessionId=" + this.b + ", readFd=" + this.c + ", format=" + this.d + ", errorMessage=" + this.e + ')';
        }

        public h(boolean r3, String r4, ParcelFileDescriptor r5, e r6, String r7, int r8) {
            if ((r8 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r8 & 4) == 0) goto L9;
            r5 = null;
        L9:
            if ((r8 & 8) == 0) goto L12;
            r6 = new e(0);
        L12:
            if ((r8 & 16) == 0) goto L14;
            r7 = null;
        L14:
            Intrinsics.checkNotNullParameter(r6, "format");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
        }
    }

    public static final class i {
        public final CountDownLatch a;
        public volatile h b;

        public i() {
            this.a = new CountDownLatch(1);
        }
    }

    public static final class j {
        public final boolean a;
        public final String b;

        public /* synthetic */ j() {
            this(true, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof j) == true) goto L8;
            return false;
        L8:
            j r6 = (j) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            String r2 = this.b;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "StartResult(success=" + this.a + ", errorMessage=" + this.b + ')';
        }

        public j(boolean r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public DoraRecordMinutesService() {
    }

    static {
        a = new DoraRecordMinutesService();
        b = UriProtector.parse("content://com.obric.recorder.dora.provider");
        c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        f = DoraConnectState.NA;
        h = new ConcurrentHashMap();
    }

    public static void b() {
        Job r0 = e;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        FLogger.a.i("DoraRecordMinutesService", "cancelDisconnectNotify");
    L10:
        Job r2 = e;
        if (r2 == null) goto L13;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L13:
        e = null;
        return;
    L5:
        if (r0.isActive() != true) goto L7;
        r1 = true;
        goto L8
    }

    public static h g() {
        c r0 = g;
        if (r0 != null) goto L6;
        FLogger.a.w("DoraRecordMinutesService", "startCapturePcm failed, no pcm session");
        return new h(false, null, null, null, "no pcm session", 14);
    L6:
        final b r2 = r0.c;
        if (r2.d.get() == true) goto L9;
    L63:
        FLogger.a.w("DoraRecordMinutesService", "acquire recorder pcm read fd failed, sessionId=" + r2.a + ", error=pcm forwarder not running");
        return new h(false, r2.a, null, r2.b, "pcm forwarder not running", 4);
    L9:
        if (r2.e.get() == true) goto L63;
        if (r2.n.compareAndSet(false, true) == true) goto L67;
        FLogger.a.w("DoraRecordMinutesService", "acquire recorder pcm read fd failed, already requested, sessionId=" + r2.a);
        return new h(false, r2.a, null, r2.b, "read fd already requested", 4);
    L67:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        Object r3 = Result.constructor-impl(ParcelFileDescriptor.createPipe());     // Catch: Throwable -> L16
    L18:
        Throwable r5 = Result.exceptionOrNull-impl(r3);
        if (r5 == null) goto L21;
        FLogger.a.e("DoraRecordMinutesService", "create recorder pcm pipe failed, sessionId=" + r2.a, r5);
    L21:
        Unit r6 = null;
        if (Result.isFailure-impl(r3) == false) goto L24;
        r3 = null;
    L24:
        ParcelFileDescriptor[] r4 = (ParcelFileDescriptor[]) r3;
        if (r4 != null) goto L27;
        r2.n.set(false);
        return new h(false, r2.a, null, r2.b, "create pipe failed", 4);
    L27:
        ParcelFileDescriptor r7 = r4[0];
        r2.f = r4[1];
        Object r8 = Result.constructor-impl(r7.dup());     // Catch: Throwable -> L30
    L32:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L36;
        FLogger.a.e("DoraRecordMinutesService", "dup recorder pcm read fd failed, sessionId=" + r2.a, r9);
    L36:
        if (Result.isFailure-impl(r8) == false) goto L38;
        r8 = null;
    L38:
        ParcelFileDescriptor r10 = (ParcelFileDescriptor) r8;
        if (r10 != null) goto L48;
        if (r7 != null) goto L71;
    L44:
        Result.constructor-impl(r6);     // Catch: Throwable -> L42
    L47:
        r2.b();
        r2.n.set(false);
        return new h(false, r2.a, null, r2.b, "dup read fd failed", 4);
    L42:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L47
    L71:
        r7.close();     // Catch: Throwable -> L42
        r6 = Unit.INSTANCE;     // Catch: Throwable -> L42
        goto L44
    L48:
        if (r7 != null) goto L69;
    L52:
        Result.constructor-impl(r6);     // Catch: Throwable -> L50
    L55:
        ParcelFileDescriptor r12 = r2.f;
        if (r12 == null) goto L58;
        r2.h = new ParcelFileDescriptor.AutoCloseOutputStream(r12);
    L58:
        r2.l = true;
        if (r2.g != null) goto L62;
        ExecutorService r13 = PThreadExecutorsUtils.newSingleThreadExecutor(new com.obric.assistant.dora.record_minutes.c());
        r13.execute(new com.obric.assistant.dora.record_minutes.d(r2));
        r2.g = r13;
    L62:
        FLogger.a.i("DoraRecordMinutesService", "acquire recorder pcm read fd success, sessionId=" + r2.a);
        return new h(true, r2.a, r10, r2.b, null, 16);
    L50:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    L69:
        r7.close();     // Catch: Throwable -> L50
        r6 = Unit.INSTANCE;     // Catch: Throwable -> L50
    L30:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L16:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    public static void j() {
        if (d == null) goto L5;
        FLogger.a.i("DoraRecordMinutesService", "stopObserveDoraConnectState");
    L5:
        Job r0 = d;
        if (r0 == null) goto L8;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L8:
        d = null;
        b();
        f = DoraConnectState.NA;
    }

    public static void e(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Object r0 = r7.getSystemService("activity");
        String r2 = null;
        if ((r0 instanceof ActivityManager) == false) goto L5;
        ActivityManager r1 = (ActivityManager) r0;
    L6:
        boolean r3 = false;
        if (r1 == null) goto L27;
        List<ActivityManager.RunningAppProcessInfo> r4 = r1.getRunningAppProcesses();
        if (r4 == null) goto L27;
        List<ActivityManager.RunningAppProcessInfo> r5 = r4;
        if ((r5 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r6 = r5.iterator();
    L17:
        if (r6.hasNext() == false) goto L27;
        ActivityManager.RunningAppProcessInfo r8 = (ActivityManager.RunningAppProcessInfo) r6.next();
        boolean r9 = true;
        if (Intrinsics.areEqual(r8.processName, "com.obric.recorder") == false) goto L21;
    L24:
        boolean r10 = true;
    L25:
        if (r10 == false) goto L17;
    L28:
        FLogger r11 = FLogger.a;
        r11.i("DoraRecordMinutesService", "isRecorderAppRunning " + r9);
        if (r9 == true) goto L45;
        r11.i("DoraRecordMinutesService", "notifyDoraDisconnected skipped, recorder app not running");
        return;
    L45:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L39
        Bundle r13 = r7.getContentResolver().call(b, "notify_dora_disconnected", null, null);     // Catch: Throwable -> L39
        if (r13 == null) goto L35;
        r3 = r13.getBoolean("accepted", false);     // Catch: Throwable -> L39
    L35:
        if (r13 == null) goto L37;
        r2 = r13.getString(WindowEvent.Params.REASON);     // Catch: Throwable -> L39
    L37:
        r11.i("DoraRecordMinutesService", "notifyDoraDisconnected accepted=" + r3 + ", reason=" + r2);     // Catch: Throwable -> L39
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L52;
        FLogger.a.e("DoraRecordMinutesService", "notifyDoraDisconnected failed", r15);
        return;
    L52:
        return;
    L39:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L21:
        if (StringsKt.startsWith$default(r8.processName, "com.obric.recorder:", false, 2, null) == true) goto L24;
        r10 = false;
        goto L25
    L13:
        if (r5.isEmpty() == false) goto L15;
    L27:
        r9 = false;
        goto L28
    L5:
        r1 = null;
        goto L6
    }

    public static void h(Context r10) {
        Job r0 = d;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L12;
        FLogger.a.i("DoraRecordMinutesService", "startObserveDoraConnectState skipped, already observing");
        return;
    L12:
        CoWakeupApi r3 = uha.a.a();
        if (r3 != null) goto L15;
    L17:
        if (r1 == false) goto L19;
        DoraConnectState r4 = DoraConnectState.CONNECTED;
    L20:
        f = r4;
        FLogger.a.i("DoraRecordMinutesService", "startObserveDoraConnectState lastConnectState=" + f);
        d = BuildersKt.launch$default(c, null, null, new DoraRecordMinutesService$startObserveDoraConnectState$1(r10, null), 3, null);
        return;
    L19:
        r4 = DoraConnectState.NA;
        goto L20
    L15:
        if (r3.b() != true) goto L17;
        r1 = true;
        goto L17
    L5:
        if (r0.isActive() != true) goto L7;
        r2 = true;
        goto L9
    }

    public static final String a(DoraRecordMinutesService r4, double r5) {
        r4.getClass();
        if (r5 > 0.0d) goto L5;
        return "-inf";
    L5:
        StringCompanionObject r6 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(Math.log10(r5 / 32768.0d) * 20.0d)}, 1));
    }

    public static boolean c(String r1, h r2) {
        i r0 = h.remove(r1);
        if (r0 != null) goto L6;
        FLogger.a.w("DoraRecordMinutesService", "completeRecorderAppStart skipped, no pending start, sessionId=".concat(r1));
        return false;
    L6:
        Intrinsics.checkNotNullParameter(r2, WindowEvent.Params.RESULT);
        r0.b = r2;
        r0.a.countDown();
        return true;
    }

    public static boolean i(String r5, boolean r6) {
        c r0 = g;
        if (r0 != null) goto L8;
        if (r6 == false) goto L18;
        j();
        return false;
    L18:
        return false;
    L8:
        g = null;
        if ((!StringsKt.isBlank(r5)) == true) goto L12;
        r5 = null;
    L12:
        if (r5 != null) goto L14;
        r5 = "stop_dora_g_record_pcm";
    L14:
        FLogger.a.i("DoraRecordMinutesService", "stopDoraGRecordPcm sessionId=" + r0.a + ", reason=" + r5);
        Intrinsics.checkNotNullParameter(r5, WindowEvent.Params.REASON);
        r0.d.a();
        r0.c.c(r5);
        if (r6 == false) goto L17;
        j();
    L17:
        return true;
    }

    public final boolean d(int r17, int r18, int r19, int r20, String r21, String r22, String r23) {
        if (r22 != null) goto L5;
    L9:
        String r2 = UUID.randomUUID().toString();
    L10:
        boolean r3 = Intrinsics.areEqual(r23, "recorder_app");
        FLogger r4 = FLogger.a;
        r4.i("DoraRecordMinutesService", "handleStartRecordMinutes start vuiId=" + r20 + ", sessionId=" + r2 + ", source=" + r23);
        if (r3 == true) goto L13;
    L16:
        r4.i("DoraRecordMinutesService", "startDoraGRecordPcm start vuiId=" + r20 + ", sessionId=" + r2 + ", source=" + r23);
        i("restart_dora_g_record_pcm", true);
        final c r9 = new c(r20, r2, r23);
        g = r9;
        b r0 = r9.c;
        Function1<? super String, Unit> r11 = new com.obric.assistant.dora.record_minutes.e(r9);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r11, "onBroken");
        r0.i = r11;
        r0.d.set(true);
        r0.e.set(false);
        r0.j.set(false);
        r4.i("DoraRecordMinutesService", "recorder pcm forwarder started, sessionId=" + r0.a + ", sampleRate=" + r0.b.b + ", channel=" + r0.b.c);
        d r1 = r9.d;
        if (r1.g.get() == false) goto L20;
        j r5 = new j(false, "pcm capture session already closed");
    L38:
        if (r5.a == true) goto L41;
        r9.d.a();
        r9.c.c("capture_start_failed");
    L41:
        if (r5.a == true) goto L46;
        r4.e("DoraRecordMinutesService", "startDoraGRecordPcm failed, sessionId=" + r2 + ", error=" + r5.b);
        if (g != r9) goto L45;
        g = null;
    L45:
        boolean r6 = false;
    L47:
        if (r6 == true) goto L51;
        if (r3 == false) goto L50;
        c(r2, new h(false, r2, null, null, "start pcm failed", 12));
    L50:
        return false;
    L51:
        if (r3 == false) goto L58;
        h(FlowRuntime.a().getApplication());
        h r7 = g();
        boolean r8 = c(r2, r7);
        if (r7.a == true) goto L55;
        i("recorder_app_acquire_fd_failed", true);
    L55:
        r4.i("DoraRecordMinutesService", "handleStartRecordMinutes recorder app pcm ready=" + r7.a + ", completed=" + r8 + ", sessionId=" + r2);
        return r7.a;
    L58:
        if (r18 != 14) goto L60;
        boolean r10 = true;
    L61:
        boolean r12 = f("开始录音", "wakeUp", r17, r18, r19, r20, r21, r10);
        if (r12 == true) goto L64;
        i("start_record_minutes_query_failed", true);
    L65:
        return r12;
    L64:
        h(FlowRuntime.a().getApplication());
        goto L65
    L60:
        r10 = false;
        goto L61
    L46:
        r4.i("DoraRecordMinutesService", "startDoraGRecordPcm success, sessionId=".concat(r2));
        r6 = true;
        goto L47
    L20:
        if (r1.f.compareAndSet(false, true) == true) goto L22;
        r5 = new j();
        goto L38
    L22:
        SpeechSessionManager r13 = new SpeechSessionManager();
        r1.e = r13;
        SpeechRecorderAudioConsumerTaskCreateParam r14 = new SpeechRecorderAudioConsumerTaskCreateParam();
        r14.vuiId = String.valueOf(r1.a);
        e r15 = r1.b;
        r14.sampleRate = r15.b;
        r14.channel = r15.c;
        r14.format = "pcm";
        r14.packetDurationMs = r15.d;
        r14.userCallback = r1.h;
        SpeechRecorderAudioConsumerTask r16 = r13.createRecorderAudioConsumerTask(r14);
        if (r16 != null) goto L30;
        r4.e("DoraRecordMinutesService", "create pcm recorder audio consumer task failed, wakeId=" + r1.a);
        SpeechRecorderAudioConsumerTask r24 = r1.d;
        if (r24 == null) goto L29;
        SpeechSessionManager r110 = r1.e;
        if (r110 == null) goto L29;
        r110.releaseRecorderAudioConsumerTask(r24);
    L29:
        r1.d = null;
        r1.e = null;
        r1.f.set(false);
        r5 = new j(false, "create pcm recorder audio consumer task failed");
        goto L38
    L30:
        r1.d = r16;
        int r111 = r16.init();
        if (r111 == 0) goto L33;
        String r25 = "init pcm recorder audio consumer task failed, code=" + r111;
        r4.e("DoraRecordMinutesService", r25 + ", wakeId=" + r1.a);
        r1.a();
        r5 = new j(false, r25);
        goto L38
    L33:
        int r26 = r16.start();
        if (r26 == 0) goto L36;
        String r27 = "start pcm recorder audio consumer task failed, code=" + r26;
        r4.e("DoraRecordMinutesService", r27 + ", wakeId=" + r1.a);
        r1.a();
        r5 = new j(false, r27);
        goto L38
    L36:
        r4.i("DoraRecordMinutesService", "start pcm capture, wakeId=" + r1.a + ", sampleRate=" + r1.b.b + ", channel=" + r1.b.c);
        r1.c.onStarted();
        r5 = new j();
        goto L38
    L13:
        if (h.containsKey(r2) == true) goto L16;
        r4.w("DoraRecordMinutesService", "handleStartRecordMinutes skipped, recorder app start is not pending, sessionId=" + r2);
        return false;
    L5:
        if ((!StringsKt.isBlank(r22)) == false) goto L7;
        r2 = r22;
    L8:
        if (r2 != null) goto L10;
    L7:
        r2 = null;
        goto L8
    }

    public static boolean f(String r21, String r22, int r23, int r24, int r25, int r26, String r27, boolean r28) {
        IObricAvailableManager.a.getClass();
        IObricAvailableManager r1 = IObricAvailableManager.a.a();
        if (r1 == null) goto L5;
        boolean r2 = r1.a();
    L6:
        IObricChatService.a.getClass();
        IObricChatService r3 = IObricChatService.a.a();
        if (r3 == null) goto L11;
        wc9.e r4 = r3.h();
        if (r4 == null) goto L11;
        String r7 = r4.a;
    L12:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("sendDoraGRecordMinutesQuery action=");
        r6.append(r22);
        r6.append(", isDefaultAssistant=");
        r6.append(r2);
        r6.append(", hasConversation=");
        if (r7 == null) goto L15;
        boolean r8 = true;
    L16:
        r6.append(r8);
        r6.append(", state=");
        r6.append(r23);
        r6.append(", mode=");
        r6.append(r24);
        r6.append(", query=");
        r6.append(r25);
        r6.append(", vuiId=");
        r6.append(r26);
        r6.append(", kw=");
        r6.append(r27);
        r6.append(", hideMessage=");
        r6.append(r28);
        r5.i("DoraRecordMinutesService", r6.toString());
        if (r2 == false) goto L100;
        if (r7 == null) goto L104;
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put("create_time_ms", String.valueOf(System.currentTimeMillis()));
        r9.put("record_status", "1");
        r9.put("wiki", "2");
        r9.put("search_engine_type", "4");
        r9.put("media_search_type", "1");
        r9.put("answer_with_suggest", "1");
        r9.put("system_language", "zh");
        IDoraService r10 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r10 == null) goto L23;
        DeviceService r11 = r10.device();
    L24:
        if (r11 == null) goto L28;
        String r12 = r11.n();
        if ((!StringsKt.isBlank(r12)) == false) goto L28;
    L29:
        Object r13 = AppHost.a.getApplication().getSystemService("audio");
        if ((r13 instanceof AudioManager) == false) goto L32;
        AudioManager r14 = (AudioManager) r13;
    L33:
        if (r14 == null) goto L82;
        AudioDeviceInfo[] r15 = r14.getDevices(1);
        AudioDeviceInfo[] r16 = r14.getDevices(2);
        Intrinsics.checkNotNull(r15);
        int r17 = r15.length;
        int r18 = 0;
    L36:
        if (r18 >= r17) goto L70;
        AudioDeviceInfo r19 = r15[r18];
        DoraRecordMinutesService r110 = a;
        Intrinsics.checkNotNull(r19);
        r110.getClass();
        IDoraService r111 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r111 == null) goto L44;
        DeviceService r112 = r111.device();
        if (r112 == null) goto L44;
        if (r112.M() != true) goto L44;
        boolean r113 = true;
    L45:
        IDoraService r20 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r20 == null) goto L52;
        DeviceService r29 = r20.device();
        if (r29 == null) goto L52;
        if (r29.K(r12) != true) goto L52;
        boolean r30 = true;
    L54:
        if (r19.getType() != 7) goto L56;
    L61:
        boolean r31 = true;
    L62:
        if (r31 == false) goto L66;
        if (r113 == false) goto L66;
        if (r30 == false) goto L66;
        boolean r32 = true;
    L67:
        if (r32 == true) goto L68;
        r18 = r18 + 1;
        goto L36
    L68:
        AudioDeviceInfo r33 = r19;
    L71:
        FLogger r34 = FLogger.a;
        StringBuilder r114 = new StringBuilder("getDoraBluetoothId hasDoraMac=");
        if (r12 == null) goto L74;
        boolean r35 = true;
    L75:
        r114.append(r35);
        r114.append(", bluetoothId=");
        if (r33 == null) goto L78;
        Integer r36 = Integer.valueOf(r33.getId());
    L79:
        r114.append(r36);
        r114.append(", inputDevices=");
        r114.append(ArraysKt.joinToString$default(r15, null, "[", "]", 0, null, new com.obric.assistant.dora.record_minutes.b(), 25, null));
        r114.append(", outputDevices=");
        Intrinsics.checkNotNull(r16);
        r114.append(ArraysKt.joinToString$default(r16, null, "[", "]", 0, null, new com.obric.assistant.dora.record_minutes.b(), 25, null));
        r34.i("DoraRecordMinutesService", r114.toString());
        if (r33 == null) goto L82;
        Integer r37 = Integer.valueOf(r33.getId());
    L83:
        IDoraService r38 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r38 == null) goto L88;
        DeviceService r39 = r38.device();
        if (r39 == null) goto L88;
        Integer r40 = Integer.valueOf(r39.y());
    L89:
        FLogger.a.i("DoraRecordMinutesService", "buildDoraRecordParams bluetoothId=" + r37 + ", productId=" + r40);
        JSONObject r41 = new JSONObject();
        r41.put("is_from_dora", true);
        if (r37 == null) goto L92;
        r41.put("dora_bluetooth_id", String.valueOf(r37.intValue()));
    L92:
        if (r40 == null) goto L94;
        r41.put("dora_product_id", String.valueOf(r40.intValue()));
    L94:
        r9.put("o_dora_params", r41.toString());
        u1 r42 = RepoDispatcherDelegate.b.e().u1();
        String r115 = UUID.randomUUID().toString();
        MessageStatus r43 = MessageStatus.MessageStatus_INVISIBLE;
        if (r28 == false) goto L97;
        MessageStatus r116 = r43;
    L98:
        u1.a.f(r42, r21, r7, "doraGRecordMinutes", r9, null, r116, r115, false, null, String.valueOf(r24), null, null, null, false, 27432);
        return true;
    L97:
        r116 = null;
    L88:
        r40 = null;
        goto L89
    L78:
        r36 = null;
        goto L79
    L74:
        r35 = false;
    L66:
        r32 = false;
        goto L67
    L56:
        if (r19.getType() == 8) goto L61;
        if (r19.getType() == 26) goto L61;
        r31 = false;
    L52:
        r30 = false;
    L44:
        r113 = false;
        goto L45
    L70:
        r33 = null;
    L82:
        r37 = null;
        goto L83
    L32:
        r14 = null;
    L28:
        r12 = null;
        goto L29
    L23:
        r11 = null;
        goto L24
    L104:
        return false;
    L100:
        return false;
    L15:
        r8 = false;
    L11:
        r7 = null;
        goto L12
    L5:
        r2 = true;
        goto L6
    }
}

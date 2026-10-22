package com.larus.avlink.record.util;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.avlink.n1;
import com.larus.avlink.record.page.Action;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.LightEffectBrightness;
import com.larus.dora.api.LightEffectStatus;
import com.larus.dora.impl.device.manage.holder.d0;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.minutes.api.IMinutesService;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.platform.service.AccountService;
import com.larus.settings.value.e10;
import com.larus.utils.j0;
import com.mammon.speechaudiosdk.session.SpeechSessionManager;
import com.mammon.speechaudiosdk.session.callback.SpeechRecorderAudioConsumerCallback;
import com.mammon.speechaudiosdk.session.param.SpeechRecorderAudioConsumerCallbackParam;
import com.mammon.speechaudiosdk.session.param.SpeechRecorderAudioConsumerTaskCreateParam;
import com.mammon.speechaudiosdk.session.task.SpeechRecorderAudioConsumerTask;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.b1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LarkRecordMinutesManager {
    public static volatile String A;
    public static volatile boolean B;
    public static volatile String C;
    public static volatile String D;
    public static long E;
    public static volatile b F;
    public static f09.a.b G;
    public static volatile String H;
    public static volatile String I;
    public static String J;
    public static volatile String K;
    public static CommonDialog L;
    public static final LarkRecordMinutesManager a = null;
    public static final Lazy b = null;
    public static final CoroutineScope c = null;
    public static final Object d = null;
    public static volatile RecordingLifecycle e;
    public static boolean f;
    public static boolean g;
    public static Job h;
    public static long i;
    public static long j;
    public static volatile String k;
    public static int l;
    public static int m;
    public static String n;
    public static long o;
    public static final NetworkAwareRetrier p = null;
    public static final NetworkAwareRetrier q = null;
    public static final CopyOnWriteArrayList<Function1<Integer, Unit>> r = null;
    public static final CopyOnWriteArrayList<Function1<Boolean, Unit>> s = null;
    public static final CopyOnWriteArrayList<Function1<Action, Unit>> t = null;
    public static volatile boolean u;
    public static final CopyOnWriteArrayList<Function1<Boolean, Unit>> v = null;
    public static Job w;
    public static Job x;
    public static Job y;
    public static final e z = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/avlink/record/util/LarkRecordMinutesManager$RecordingLifecycle;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "START_REQUESTED", "STARTING", "RECORDING", "STOP_PENDING", "STOPPING", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum RecordingLifecycle extends Enum<RecordingLifecycle> {
        public static final RecordingLifecycle IDLE = null;
        public static final RecordingLifecycle RECORDING = null;
        public static final RecordingLifecycle STARTING = null;
        public static final RecordingLifecycle START_REQUESTED = null;
        public static final RecordingLifecycle STOPPING = null;
        public static final RecordingLifecycle STOP_PENDING = null;
        public static final /* synthetic */ RecordingLifecycle[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<RecordingLifecycle> getEntries() {
            return b;
        }

        static {
            RecordingLifecycle r0 = new RecordingLifecycle("IDLE", 0);
            IDLE = r0;
            RecordingLifecycle r1 = new RecordingLifecycle("START_REQUESTED", 1);
            START_REQUESTED = r1;
            RecordingLifecycle r3 = new RecordingLifecycle("STARTING", 2);
            STARTING = r3;
            RecordingLifecycle r5 = new RecordingLifecycle("RECORDING", 3);
            RECORDING = r5;
            RecordingLifecycle r7 = new RecordingLifecycle("STOP_PENDING", 4);
            STOP_PENDING = r7;
            RecordingLifecycle r9 = new RecordingLifecycle("STOPPING", 5);
            STOPPING = r9;
            RecordingLifecycle[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static RecordingLifecycle[] values() {
            return (RecordingLifecycle[]) a.clone();
        }

        public static RecordingLifecycle valueOf(String r1) {
            return (RecordingLifecycle) r27.a.a(RecordingLifecycle.class, r1);
        }

        public RecordingLifecycle(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.larus.avlink.record.util.LarkRecordMinutesManager$a$a, reason: collision with other inner class name */
        public static final class C0023a extends a {
            public static final C0023a a = null;

            static {
                a = new C0023a();
            }

            public C0023a() {
            }
        }

        public static final class b extends a {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Reject(reason=" + this.a + ')';
            }

            public b(String r2) {
                Intrinsics.checkNotNullParameter(r2, "reason");
                this.a = r2;
            }
        }

        public a() {
        }
    }

    public static final class b implements yk9.a {
        public final int a;
        public final Object b;
        public final fa8.a c;
        public volatile boolean d;
        public volatile boolean e;
        public volatile boolean f;
        public int g;
        public int h;
        public SpeechRecorderAudioConsumerTask i;
        public SpeechSessionManager j;
        public final C0024b k;

        public static final class a {
        }

        /* JADX INFO: renamed from: com.larus.avlink.record.util.LarkRecordMinutesManager$b$b, reason: collision with other inner class name */
        public static final class C0024b implements SpeechRecorderAudioConsumerCallback {
            public final /* synthetic */ b a;

            public C0024b(b r1) {
                this.a = r1;
            }

            public final void onCallback(SpeechRecorderAudioConsumerCallbackParam r14) {
                Integer r0 = null;
                if (r14 == null) goto L5;
                Integer r1 = Integer.valueOf(r14.msgType);
            L7:
                if (r1 == null) goto L13;
                if (r1.intValue() != 1) goto L13;
                n1.d("LarkRecordMinutesManager", "GRecord audio consumer start, wakeId=" + this.a.a + ", sessionId=" + r14.sessionId);
                return;
            L13:
                if (r1 != null) goto L16;
            L18:
                if (r1 != null) goto L21;
            L62:
                StringBuilder r2 = new StringBuilder("GRecord audio consumer unknown msg, wakeId=");
                r2.append(this.a.a);
                r2.append(", msgType=");
                if (r14 == null) goto L65;
                r0 = Integer.valueOf(r14.msgType);
            L65:
                r2.append(r0);
                n1.e("LarkRecordMinutesManager", r2.toString());
                return;
            L21:
                if (r1.intValue() != 5000) goto L62;
                byte[] r15 = r14.audioData;
                b r3 = this.a;
                int r4 = r3.a;
                if (r15 != null) goto L26;
                return;
            L26:
                if (r15.length != 0) goto L28;
                boolean r5 = true;
            L29:
                if (r5 == false) goto L32;
                return;
            L32:
                if (r3.d == true) goto L34;
                return;
            L34:
                if (r3.e == false) goto L36;
                return;
            L36:
                if (r3.f == true) goto L77;
                int r6 = r3.h;
                if (r6 > 1) goto L42;
                byte[] r16 = Arrays.copyOf(r15, r15.length);
            L51:
                Object r7 = r3.b;
                monitor-enter(r7);
            L59:
                th = move-exception;
                throw th;
            L54:
                if (r3.c.b < (((((r3.g * r3.h) * 2) * 20) / 1000) * DoraCallStateCode.DORA_OB_USER_END)) goto L56;
                n1.e("LarkRecordMinutesManager", "GRecord dora audio buffer overflow, clear old data, wakeId=" + r3.a);     // Catch: Throwable -> L59
                fa8.a r8 = r3.c;     // Catch: Throwable -> L59
                r8.a.clear();     // Catch: Throwable -> L59
                r8.b = 0;     // Catch: Throwable -> L59
            L56:
                r3.c.a(r16);     // Catch: Throwable -> L59
                r3.b.notifyAll();     // Catch: Throwable -> L59
                Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L59
                monitor-exit(r7);
                return;
            L42:
                if ((r15.length % 2) == 0) goto L44;
                n1.e("LarkRecordMinutesManager", "GRecord upmix skipped, frame not 16bit aligned, size=" + r15.length + ", wakeId=" + r3.a);
                r16 = Arrays.copyOf(r15, r15.length);
                goto L51
            L44:
                int r9 = r15.length / 2;
                byte[] r10 = new byte[r15.length * r6];
                int r11 = 0;
                int r12 = 0;
            L45:
                if (r11 >= r9) goto L50;
                int r13 = r11 * 2;
                byte r18 = r15[r13];
                byte r19 = r15[r13 + 1];
                int r110 = 0;
            L47:
                if (r110 >= r6) goto L49;
                int r111 = r12 + 1;
                r10[r12] = r18;
                r12 = r111 + 1;
                r10[r111] = r19;
                r110 = r110 + 1;
                goto L47
            L49:
                r11 = r11 + 1;
                goto L45
            L50:
                r16 = r10;
                goto L51
            L77:
                return;
            L28:
                r5 = false;
                goto L29
            L16:
                if (r1.intValue() != 2) goto L18;
                n1.d("LarkRecordMinutesManager", "GRecord audio consumer stop, wakeId=" + this.a.a + ", sessionId=" + r14.sessionId);
                return;
            L5:
                r1 = null;
                goto L7
            }
        }

        static {
        }

        public final void close() {
            if (this.f == false) goto L5;
            return;
        L5:
            this.f = true;
            this.d = false;
            this.e = false;
            SpeechRecorderAudioConsumerTask r0 = this.i;
            if (r0 == null) goto L8;
            r0.stop();
        L8:
            SpeechRecorderAudioConsumerTask r1 = this.i;
            if (r1 == null) goto L13;
            SpeechSessionManager r2 = this.j;
            if (r2 == null) goto L13;
            r2.releaseRecorderAudioConsumerTask(r1);
        L13:
            this.i = null;
            this.j = null;
            Object r3 = this.b;
            monitor-enter(r3);
            fa8.a r4 = this.c;     // Catch: Throwable -> L19
            r4.a.clear();     // Catch: Throwable -> L19
            r4.b = 0;     // Catch: Throwable -> L19
            this.b.notifyAll();     // Catch: Throwable -> L19
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L19
            monitor-exit(r3);
            n1.d("LarkRecordMinutesManager", "GRecord close DoraHardwareAudioSource, wakeId=" + this.a);
            return;
        L19:
            th = move-exception;
            throw th;
        }

        public final void pause() {
            n1.e("LarkRecordMinutesManager", "GRecord pause, wakeId=" + this.a);
            this.e = true;
        }

        public final yk9.a.c startCapture() {
            if (this.e == false) goto L7;
            this.e = false;
            return new yk9.a.c();
        L7:
            if (this.f == true) goto L9;
            SpeechRecorderAudioConsumerTask r0 = this.i;
            if (r0 == null) goto L13;
            Object r2 = this.b;
            monitor-enter(r2);
            fa8.a r3 = this.c;     // Catch: Throwable -> L24
            r3.a.clear();     // Catch: Throwable -> L24
            r3.b = 0;     // Catch: Throwable -> L24
            Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L24
            monitor-exit(r2);
            this.d = true;
            int r1 = r0.start();
            if (r1 == 0) goto L22;
            this.d = false;
            String r5 = "start recorder audio consumer task failed, code=" + r1;
            n1.b("LarkRecordMinutesManager", "GRecord " + r5 + ", wakeId=" + this.a);
            return new yk9.a.c(false, r5);
        L22:
            n1.d("LarkRecordMinutesManager", "GRecord start DoraHardwareAudioSource capture, wakeId=" + this.a);
            return new yk9.a.c();
        L24:
            th = move-exception;
            throw th;
        L13:
            return new yk9.a.c(false, "audio consumer task not init");
        L9:
            return new yk9.a.c(false, "audio source already closed");
        }

        public b(int r1) {
            this.a = r1;
            this.b = new Object();
            this.c = new fa8.a();
            this.g = 16000;
            this.h = 1;
            this.k = new C0024b(this);
        }

        public final yk9.a.b a(yk9.a.a r7) {
            Intrinsics.checkNotNullParameter(r7, "format");
            Integer r0 = Integer.valueOf(r7.a);
            if (r0.intValue() <= 0) goto L5;
            boolean r1 = true;
        L7:
            if (r1 == true) goto L10;
            r0 = null;
        L10:
            if (r0 == null) goto L12;
            int r2 = r0.intValue();
        L13:
            this.g = r2;
            Integer r8 = Integer.valueOf(r7.b);
            if (r8.intValue() <= 0) goto L16;
            boolean r3 = true;
        L17:
            if (r3 == true) goto L20;
            r8 = null;
        L20:
            if (r8 == null) goto L22;
            int r9 = r8.intValue();
        L23:
            this.h = r9;
            SpeechSessionManager r10 = new SpeechSessionManager();
            this.j = r10;
            SpeechRecorderAudioConsumerTaskCreateParam r4 = new SpeechRecorderAudioConsumerTaskCreateParam();
            r4.vuiId = String.valueOf(this.a);
            r4.sampleRate = this.g;
            r4.channel = 1;
            r4.format = "pcm";
            r4.packetDurationMs = 20;
            r4.userCallback = this.k;
            SpeechRecorderAudioConsumerTask r11 = r10.createRecorderAudioConsumerTask(r4);
            if (r11 != null) goto L27;
            n1.b("LarkRecordMinutesManager", "GRecord create recorder audio consumer task failed, wakeId=" + this.a);
            return new yk9.a.b(false, 0, "create recorder audio consumer task failed");
        L27:
            this.i = r11;
            int r12 = r11.init();
            if (r12 == 0) goto L36;
            String r13 = "init recorder audio consumer task failed, code=" + r12;
            n1.b("LarkRecordMinutesManager", "GRecord " + r13 + ", wakeId=" + this.a);
            SpeechRecorderAudioConsumerTask r5 = this.i;
            if (r5 == null) goto L34;
            SpeechSessionManager r6 = this.j;
            if (r6 == null) goto L34;
            r6.releaseRecorderAudioConsumerTask(r5);
        L34:
            this.i = null;
            this.j = null;
            return new yk9.a.b(false, 0, r13);
        L36:
            n1.d("LarkRecordMinutesManager", "GRecord init DoraHardwareAudioSource, wakeId=" + this.a + ", sampleRate=" + this.g + ", channel=" + this.h);
            return new yk9.a.b(true, (((this.g * this.h) * 2) * 20) / 1000, null);
        L22:
            r9 = 1;
            goto L23
        L16:
            r3 = false;
            goto L17
        L12:
            r2 = 16000;
            goto L13
        L5:
            r1 = false;
            goto L7
        }

        public final int read(byte[] r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "audioData");
            if (r10 >= 0) goto L5;
        L32:
            n1.e("LarkRecordMinutesManager", "GRecord read invalid params, wakeId=" + this.a + ", offset=0, size=" + r10 + ", bufferSize=" + r9.length);
            return 0;
        L5:
            if ((r9.length - r10) < 0) goto L32;
            if (r10 != 0) goto L9;
            return 0;
        L9:
            Object r1 = this.b;
            monitor-enter(r1);
        L34:
        L29:
            th = move-exception;
            throw th;
        L12:
            if (this.f == true) goto L21;
            if (this.c.b != 0) goto L21;
            this.b.wait(200);     // Catch: InterruptedException -> L18 Throwable -> L29
        L18:
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L29
            n1.e("LarkRecordMinutesManager", "GRecord read interrupted, wakeId=" + this.a);     // Catch: Throwable -> L29
            return 0;
        L21:
            fa8.a r2 = this.c;     // Catch: Throwable -> L29
            if (r2.b != 0) goto L26;
            monitor-exit(r1);
            return 0;
        L26:
            int r11 = r2.b(r9, r10);     // Catch: Throwable -> L29
            monitor-exit(r1);
            return r11;
        }
    }

    public static final class c {
        public final long a;
        public final boolean b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r9 = (c) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            if (this.b == false) goto L5;
            int r2 = 1231;
        L7:
            return r1 + r2;
        L5:
            r2 = 1237;
            goto L7
        }

        public final String toString() {
            return "SdkStartClaim(token=" + this.a + ", shouldNotifyStarting=" + this.b + ')';
        }

        public c(long r1, boolean r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RecordingLifecycle.values().length];
            r0[RecordingLifecycle.START_REQUESTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[RecordingLifecycle.STARTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[RecordingLifecycle.RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[RecordingLifecycle.STOP_PENDING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[RecordingLifecycle.STOPPING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[RecordingLifecycle.IDLE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public static final class e implements com.larus.dora.api.offline.record.c {
        public e() {
        }

        public final void a(com.larus.dora.api.offline.record.a r5) {
            Intrinsics.checkNotNullParameter(r5, "notify");
            StringBuilder r0 = new StringBuilder("globalOfflineRecordListener onFileReadyNotify, isOfflineRecording=");
            boolean r2 = false;
            if (r5.a != 1) goto L5;
            boolean r1 = true;
        L6:
            r0.append(r1);
            r0.append(", status=");
            r0.append(r5.a);
            r0.append(", businessType=");
            r0.append(r5.b);
            r0.append(", vuiId=");
            r0.append(r5.c);
            r0.append(", fileType=");
            r0.append(r5.f);
            n1.d("LarkRecordMinutesManager", r0.toString());
            LarkRecordMinutesManager r3 = LarkRecordMinutesManager.a;
            if (r5.a != 1) goto L9;
            r2 = true;
        L9:
            r3.getClass();
            LarkRecordMinutesManager.O(r2, "dorasdk callback");
            return;
        L5:
            r1 = false;
            goto L6
        }

        public final void b(com.larus.dora.api.offline.record.e r2) {
            Intrinsics.checkNotNullParameter(r2, "recording");
        }

        public final void c(com.larus.dora.api.offline.record.d r2) {
            Intrinsics.checkNotNullParameter(r2, "progress");
        }
    }

    public static final class f implements p0 {
        public final /* synthetic */ Function0<Unit> a;

        public final void confirm() {
            this.a.invoke();
        }

        public f(Function0<Unit> r1) {
            this.a = r1;
        }
    }

    public static final class g implements u {
        public g() {
        }

        public final void cancel() {
        }
    }

    public static final class h extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public h(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r2, Throwable r3) {
            n1.b("LarkRecordMinutesManager", "GRecord Coroutine Exception: " + r3.getMessage());
        }
    }

    public LarkRecordMinutesManager() {
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.avlink.record.util.d] */
    static {
        a = new LarkRecordMinutesManager();
        b = LazyKt.lazy(new com.larus.avlink.record.util.b());
        h r1 = new h(CoroutineExceptionHandler.Key);
        CoroutineScope r2 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()).plus(r1));
        c = r2;
        d = new Object();
        e = RecordingLifecycle.IDLE;
        p = new NetworkAwareRetrier(r2, "LarkRecordMinutesManager_PushCard", new com.larus.avlink.record.util.c(), new com.larus.avlink.record.util.d(), new LarkRecordMinutesManager$pushCardRetrier$3(null), 12);
        q = new NetworkAwareRetrier(r2, "LarkRecordMinutesManager_SecondaryConnect", new com.larus.avlink.record.util.e(), null, new LarkRecordMinutesManager$secondaryConnectRetrier$2(null), 44);
        r = new CopyOnWriteArrayList();
        s = new CopyOnWriteArrayList();
        t = new CopyOnWriteArrayList();
        v = new CopyOnWriteArrayList();
        z = new e();
    }

    public static void B() {
        Job r0 = h;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.isActive() != true) goto L7;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        h = BuildersKt.launch$default(c, null, null, new LarkRecordMinutesManager$schedulePendingStopReset$1(null), 3, null);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public static void N() {
        n1.d("LarkRecordMinutesManager", "tryStopSoftwareRecording, isSoftwareRecording=" + w());
        IMinutesService r0 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.L0() != true) goto L7;
    L9:
        if (r1 == false) goto L14;
        IMinutesService r2 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r2 == null) goto L14;
        r2.a("hfp_calling");
    L14:
        if (ia8.e.a().g() == false) goto L17;
        ia8.e.a().a("hfp_calling");
        return;
    L17:
        return;
    L7:
        r1 = false;
        goto L9
    }

    public static void g() {
        Object r0 = d;
        monitor-enter(r0);
        e = RecordingLifecycle.IDLE;     // Catch: Throwable -> L20
        f = false;     // Catch: Throwable -> L20
        g = false;     // Catch: Throwable -> L20
        i = 0;     // Catch: Throwable -> L20
        D = null;     // Catch: Throwable -> L20
        j++;     // Catch: Throwable -> L20
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r0);
        Job r1 = h;
        if (r1 == null) goto L9;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L9:
        h = null;
        A = null;
        k = null;
        H = null;
        I = null;
        K = null;
        l = 0;
        m = 0;
        n = null;
        o = 0;
        C = null;
        E = 0;
        F = null;
        H("clearRecordState");
        f09.a.b r2 = G;
        if (r2 == null) goto L12;
        AppHost.a.a().c(r2);
        G = null;
    L12:
        NetworkAwareRetrier r3 = p;
        Job r4 = r3.j;
        if (r4 == null) goto L15;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L15:
        r3.j = null;
        r3.c();
        NetworkAwareRetrier r6 = q;
        Job r7 = r6.j;
        if (r7 == null) goto L18;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L18:
        r6.j = null;
        r6.c();
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static String i() {
        Object r0 = d;
        monitor-enter(r0);
        String r1 = D;     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        r1 = null;
    L8:
        monitor-exit(r0);
        return r1;
    L7:
        D = null;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static Integer k() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L12;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L12;
        Integer r2 = Integer.valueOf(r1.y());
        if (r2.intValue() < 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        return r2;
    L9:
        r3 = false;
    L12:
        return null;
    }

    public static boolean r() {
        return ((Boolean) b.getValue()).booleanValue();
    }

    public static boolean s() {
        e10 r0 = e10.a;
        return e10.m();
    }

    public static boolean v() {
        IMinutesService r0 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.m() != true) goto L7;
        return true;
    }

    public static void y() {
        Iterator<Function1<Boolean, Unit>> r0 = s.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().invoke(Boolean.TRUE);
        goto L4
    L6:
        x(Action.START_PULL);
    }

    public static String j() {
        if (s() == true) goto L5;
        return null;
    L5:
        String r0 = A;
        if (r0 != null) goto L9;
        return null;
    L9:
        if (B == false) goto L11;
        return r0;
    L11:
        IMinutesService r1 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r1 == null) goto L18;
        String r2 = r1.F0(r0);
        if (r2 != null) goto L17;
        return r0;
    L17:
        return r2;
    L18:
        return r0;
    }

    public static boolean q() {
        if (s() == true) goto L6;
        return false;
    L6:
        if (B == true) goto L15;
        RecordingLifecycle r0 = e;
        switch(d.a[r0.ordinal()]) {
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L11;
            default: goto L10;
        };
    L11:
        boolean r1 = v();
    L14:
        if (r1 == true) goto L15;
        return false;
    L12:
        r1 = false;
        goto L14
    L13:
        r1 = true;
        goto L14
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return true;
    }

    public static boolean t() {
        if (s() == true) goto L6;
        return false;
    L6:
        n1.d("LarkRecordMinutesManager", "isHardwareOfflineRecording read, value=" + u);
        return u;
    }

    public static boolean u() {
        if (s() == true) goto L5;
        return false;
    L5:
        String r0 = A;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        return false;
    L14:
        if (q.h == true) goto L18;
        return true;
    L18:
        return false;
    L8:
        if (r0.length() == 0) goto L11;
        r1 = false;
        goto L12
    }

    public static boolean w() {
        if (ia8.e.a().g() == true) goto L14;
        IMinutesService r0 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (r0.L0() != true) goto L9;
        r1 = true;
        goto L10
    L14:
        return true;
    }

    public static void A(String r8) {
        CommonDialog r0 = L;
        if (r0 != null) goto L5;
    L12:
        L = null;
        AppHost.Companion r1 = AppHost.a;
        Context r2 = r1.a().getTopActivity();
        if (r2 != null) goto L15;
        r2 = r1.getApplication();
    L15:
        Context r3 = r2;
        IMinutesService r4 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r4 != null) goto L19;
        n1.b("LarkRecordMinutesManager", "GRecord open recording page failed, minutes service is null");
        return;
    L19:
        n1.d("LarkRecordMinutesManager", "GRecord auto open recording page, recordingId=" + r8);
        r4.Q0(r3, r8, "recording_start_auto_open", "0", "");
        return;
    L5:
        if (r0.isAdded() == false) goto L12;
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L12;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    }

    public static void C(String r2) {
        if (s() == true) goto L5;
        return;
    L5:
        J = r2;
        n1.d("LarkRecordMinutesManager", "GRecord setPendingReplyMessageId=" + r2);
    }

    public static boolean D(int r8) {
        boolean r1 = false;
        if (r8 == 17) goto L5;
    L31:
        return r1;
    L5:
        if (r() == false) goto L31;
        IObricDoraService r9 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r9 != null) goto L10;
    L12:
        boolean r10 = false;
    L13:
        if (r10 == true) goto L32;
        return false;
    L32:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L17
        Object r12 = Result.constructor-impl(Long.valueOf(AppHost.a.getApplication().getPackageManager().getPackageInfo("com.obric.recorder", 0).getLongVersionCode()));     // Catch: Throwable -> L17
    L19:
        Throwable r2 = Result.exceptionOrNull-impl(r12);
        if (r2 == null) goto L23;
        n1.e("LarkRecordMinutesManager", "GRecord call record gate: failed to query recorder app version, error=" + r2.getMessage());
    L23:
        if (Result.isFailure-impl(r12) == false) goto L25;
        r12 = null;
    L25:
        Long r13 = (Long) r12;
        if (r13 != null) goto L28;
    L30:
        n1.d("LarkRecordMinutesManager", "GRecord call record gate: shouldDisable=" + r1 + ", recorderVersionCode=" + r13 + ", minVersionCode=1020600000");
        goto L31
    L28:
        if (r13.longValue() < 1020600000) goto L30;
        r1 = true;
    L17:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L10:
        if (r9.k() != true) goto L12;
        r10 = true;
        goto L13
    }

    public static void H(String r4) {
        boolean r0 = B;
        B = false;
        Job r1 = y;
        if (r1 == null) goto L5;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L5:
        y = null;
        n1.d("LarkRecordMinutesManager", "GRecord clear external recorder pcm, shouldStop=" + r0 + ", reason=" + r4);
    }

    public static a L(String r6) {
        Intrinsics.checkNotNullParameter(r6, "requestId");
        if (StringsKt.isBlank(r6) == false) goto L7;
        n1.e("LarkRecordMinutesManager", "GRecord recorder app start rejected: empty requestId");
        return new a.b("invalid_request_id");
    L7:
        if (q() == false) goto L10;
        n1.e("LarkRecordMinutesManager", "GRecord recorder app start rejected: already recording");
        return new a.b("already_recording");
    L10:
        Object r1 = d;
        monitor-enter(r1);
        boolean r4 = true;
        if (e == RecordingLifecycle.IDLE) goto L16;
        n1.e("LarkRecordMinutesManager", "GRecord recorder app start rejected: lifecycle=" + e);     // Catch: Throwable -> L47
        boolean r0 = false;
    L17:
        monitor-exit(r1);
        if (r0 == false) goto L20;
        a r2 = M(99, 16, r6);
        r2.getClass();
        if ((r2 instanceof a.C0023a) == false) goto L36;
        monitor-enter(r1);
    L33:
        th = move-exception;
        throw th;
    L25:
        if (e != RecordingLifecycle.START_REQUESTED) goto L29;
        if (Intrinsics.areEqual(D, r6) == false) goto L29;
        boolean r3 = true;
    L30:
        monitor-exit(r1);
        if (r3 == false) goto L36;
    L37:
        if (r4 == true) goto L39;
        h(r6);
    L39:
        n1.d("LarkRecordMinutesManager", "GRecord recorder app start requested, requestId=" + r6 + ", accepted=" + r4);
        if (r4 == false) goto L43;
        return r2;
    L43:
        if ((r2 instanceof a.b) == false) goto L46;
        return r2;
    L46:
        return new a.b("already_recording");
    L29:
        r3 = false;
    L36:
        r4 = false;
        goto L37
    L20:
        return new a.b("already_recording");
    L16:
        r0 = true;
    L47:
        th = move-exception;
        throw th;
    }

    public static final boolean b(LarkRecordMinutesManager r3) {
        r3.getClass();
        Object r4 = d;
        monitor-enter(r4);
        boolean r2 = false;
        if (e != RecordingLifecycle.START_REQUESTED) goto L9;
        e = RecordingLifecycle.IDLE;     // Catch: Throwable -> L11
        g = false;     // Catch: Throwable -> L11
        D = null;     // Catch: Throwable -> L11
        r2 = true;
    L9:
        monitor-exit(r4);
        return r2;
    L11:
        th = move-exception;
        throw th;
    }

    public static void c(Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (s() == true) goto L5;
        return;
    L5:
        CopyOnWriteArrayList<Function1<Boolean, Unit>> r0 = v;
        r0.add(r3);
        n1.d("LarkRecordMinutesManager", "addOfflineRecordingUpdateListener seed initial value=" + u + ", count=" + r0.size());
        r3.invoke(Boolean.valueOf(u));
    }

    public static void d(Function1 r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        if (s() == true) goto L5;
        return;
    L5:
        r.add(r6);
        if (q() == false) goto L22;
        int r1 = 0;
        if (B == false) goto L13;
        long r2 = o;
        if (r2 <= 0) goto L20;
        r1 = RangesKt.coerceAtLeast((int) ((System.currentTimeMillis() - r2) / ((long) 1000)), 0);
    L20:
        r6.invoke(Integer.valueOf(r1));
        return;
    L13:
        IMinutesService r0 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r0 == null) goto L20;
        b1 r3 = r0.l();
        if (r3 == null) goto L20;
        Pair r4 = (Pair) r3.getValue();
        if (r4 == null) goto L20;
        r1 = (int) ((Number) r4.getSecond()).longValue();
        goto L20
    }

    public static void f(String r11) {
        H(r11);
        String r0 = A;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("end_type", r11);
        String r2 = k;
        if (r2 == null) goto L8;
        r1.put("start_type", r2);
    L8:
        r1.put("message_id", r0);
        if (o != 0) goto L11;
        n1.d("LarkRecordMinutesManager", "GRecord ending before it officially begins, endType is " + r11 + ", recordId is " + r0);
        r1.put("duration", 0);
    L12:
        IDoraService r12 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r12 == null) goto L16;
        r12.A0("dora_recording_end", r1);
    L16:
        if (r() == false) goto L18;
        BuildersKt.launch$default(c, Dispatchers.getIO(), null, new LarkRecordMinutesManager$cleanupAfterRecordingStopped$1(null), 2, null);
    L18:
        b98.b.f(7, 2);
        n1.d("LarkRecordMinutesManager", "GRecord end-pull triggered, meetingId=" + j());
        x(Action.END_PULL);
        g();
        Job r13 = w;
        if (r13 == null) goto L21;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);
    L21:
        w = null;
        Job r14 = x;
        if (r14 == null) goto L24;
        Job.DefaultImpls.cancel$default(r14, null, 1, null);
    L24:
        x = null;
        return;
    L11:
        r1.put("duration", Long.valueOf(System.currentTimeMillis() - o));
        goto L12
    }

    public static void h(String r2) {
        Object r0 = d;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(D, r2) == false) goto L7;
        D = null;     // Catch: Throwable -> L10
    L7:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
    }

    public static void x(Action r2) {
        Iterator<Function1<Action, Unit>> r0 = t.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().invoke(r2);
        goto L4
    }

    public static void z(Action r3) {
        Iterator<Function1<Boolean, Unit>> r0 = s.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().invoke(Boolean.FALSE);
        goto L4
    L6:
        x(r3);
    }

    public final void K(String r10) {
        Intrinsics.checkNotNullParameter(r10, "endSource");
        if (s() == true) goto L5;
        return;
    L5:
        n1.d("LarkRecordMinutesManager", "GRecord stopVUIRecord endSource=" + r10);
        Object r0 = d;
        monitor-enter(r0);
        boolean r2 = true;
        switch(d.a[e.ordinal()]) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L23;
            case 5: goto L23;
            case 6: goto L10;
            default: goto L34;
        };     // Catch: Throwable -> L35
    L10:
        a.getClass();     // Catch: Throwable -> L35
        if (v() == true) goto L24;
        String r1 = A;     // Catch: Throwable -> L35
        if (r1 != null) goto L15;
    L18:
        boolean r3 = true;
    L19:
        if (r3 == true) goto L23;
    L15:
        if (r1.length() == 0) goto L18;
        r3 = false;
    L24:
        monitor-exit(r0);
        BuildersKt.launch$default(c, Dispatchers.getIO(), null, new LarkRecordMinutesManager$stopVUIRecord$1(r10, null), 2, null);
        if (r2 == false) goto L29;
        J(this, r10);
        return;
    L29:
        if (e != RecordingLifecycle.STOP_PENDING) goto L31;
        z(Action.END_PULL);
        B();
        return;
    L31:
        n1.e("LarkRecordMinutesManager", "GRecord stopVUIRecord without active SDK session");
        g();
        z(Action.END_PULL);
        return;
    L21:
        e = RecordingLifecycle.STOPPING;     // Catch: Throwable -> L35
        goto L24
    L22:
        e = RecordingLifecycle.STOP_PENDING;     // Catch: Throwable -> L35
        i = System.currentTimeMillis() + 6000;     // Catch: Throwable -> L35
    L23:
        r2 = false;
        goto L24
    L34:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    }

    public static void E(String r5, Function0 r6) {
        FragmentActivity r0 = AppHost.a.a().getCurrentActivity();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L6:
        if (r1 == null) goto L27;
        FragmentManager r2 = r1.getSupportFragmentManager();
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.isStateSaved() == false) goto L15;
        n1.d(r5, "GRecord skip show end-record dialog because stateSaved");
        return;
    L15:
        if (L == null) goto L18;
        n1.d(r5, "GRecord skip duplicate end-record dialog");
        return;
    L18:
        CommonDialog.a r7 = new CommonDialog.a();
        int r3 = j0.a;
        r7.i(j0.d(2131907333));
        r7.g(j0.d(2131907332));
        CommonDialog.a.f(r7, new f(r6), j0.d(2131907331), false, 12);
        CommonDialog.a.e(r7, new g(), j0.d(2131907330), 4);
        DialogInterface.OnDismissListener r8 = new com.larus.avlink.record.util.h();
        Intrinsics.checkNotNullParameter(r8, "listener");
        r7.x = r8;
        CommonDialog r9 = r7.a();
        L = r9;
        LandscapeRestrictionOperation r10 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r9, null, r10);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r9, r10) == true) goto L29;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L22:
        r9.show(r2, null);
        return;
    L29:
        return;
    L27:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.avlink.record.util.LarkRecordMinutesManager$startRecordByLarkSdk$2] */
    public static void G(final k r4, final long r5) {
        final IMinutesService r0 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r0 != null) goto L16;
        n1.b("LarkRecordMinutesManager", "GRecord lark minutes service is null");
        Object r6 = d;
        monitor-enter(r6);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (j != r5) goto L9;
        f = false;     // Catch: Throwable -> L13
        e = RecordingLifecycle.IDLE;     // Catch: Throwable -> L13
    L9:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r6);
        g();
        z(Action.ERROR);
        return;
    L16:
        n1.d("LarkRecordMinutesManager", "GRecord startRecordByLarkSdk, recordSession=" + r4);
        yk9.c r1 = new yk9.c(k());
        b r3 = new b(r4.a);
        F = r3;
        r0.D0(r1, r3, new LarkRecordMinutesManager$startRecordByLarkSdk$2(r5, r0, r4));
    }

    public static /* synthetic */ void J(LarkRecordMinutesManager r7, String r8) {
        r7.I(r8, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_EXCEPTION, l, 1, m, n);
    }

    public static void O(boolean r3, String r4) {
        StringBuilder r0 = new StringBuilder("updateHardwareOfflineRecording called from ");
        r0.append(r4);
        r0.append(", target=");
        r0.append(r3);
        r0.append(", current=");
        r0.append(u);
        r0.append(", listenerCount=");
        CopyOnWriteArrayList<Function1<Boolean, Unit>> r5 = v;
        r0.append(r5.size());
        n1.d("LarkRecordMinutesManager", r0.toString());
        if (u != r3) goto L6;
        n1.d("LarkRecordMinutesManager", "updateHardwareOfflineRecording skip, state unchanged=" + r3);
        return;
    L6:
        u = r3;
        n1.d("LarkRecordMinutesManager", "hardware offline recording changed, recording=" + r3);
        if (r3 == false) goto L9;
        N();
    L9:
        Iterator<Function1<Boolean, Unit>> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        r6.next().invoke(Boolean.valueOf(r3));
        goto L11
    }

    public static String e(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "messageId");
        Intrinsics.checkNotNullParameter(r6, "replyMessageId");
        String r1 = "";
        if (s() == true) goto L5;
        return "";
    L5:
        wc9.e r0 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r0 == null) goto L8;
        String r2 = r0.a;
    L9:
        JSONObject r3 = new JSONObject();
        r3.put("UserID", AccountService.a.getUserId());
        if (r2 == null) goto L13;
        r1 = r2;
    L13:
        r3.put("ConversationID", r1);
        r3.put("MessageID", r5);
        r3.put("ReplyMessageID", r6);
        r3.put("BizID", "1");
        r3.put("AppID", String.valueOf(AppHost.a.getAppId()));
        r3.put("TenantID", "1");
        r3.put("DeviceID", com.larus.platform.service.o.a.getDeviceId());
        return r3.toString();
    L8:
        r2 = null;
        goto L9
    }

    public static a M(int r11, int r12, String r13) {
        n1.d("LarkRecordMinutesManager", "GRecord preCheck start in Lark record, state is " + r11 + ", mode is " + r12);
        if (s() == true) goto L6;
        n1.d("LarkRecordMinutesManager", "GRecord preCheck call rejected: setting disabled");
        return new a.b("setting_disabled");
    L6:
        boolean r2 = true;
        if (r12 != 17) goto L82;
        if (D(r12) == false) goto L12;
        a r14 = new a.b("obric_call_record_disabled");
    L103:
        if ((r14 instanceof a.C0023a) == false) goto L119;
        Object r0 = d;
        monitor-enter(r0);
    L115:
        th = move-exception;
        throw th;
    L107:
        if (e == RecordingLifecycle.IDLE) goto L109;
        r2 = false;
    L110:
        monitor-exit(r0);
        if (r2 == true) goto L114;
        n1.d("LarkRecordMinutesManager", "GRecord ignore duplicate start request, lifecycle=" + e + ", mode=" + r12);
        return r14;
    L114:
        y();
        N();
        n1.d("LarkRecordMinutesManager", "GRecord preCheck call passed, sending startVUI in background");
        BuildersKt.launch$default(c, Dispatchers.getIO(), null, new LarkRecordMinutesManager$tryStartRecordInternal$1(r12, null), 2, null);
    L121:
        return r14;
    L109:
        e = RecordingLifecycle.START_REQUESTED;     // Catch: Throwable -> L115
        g = true;     // Catch: Throwable -> L115
        D = r13;     // Catch: Throwable -> L115
        goto L110
    L119:
        if ((r14 instanceof a.b) == false) goto L123;
        n1.d("LarkRecordMinutesManager", "GRecord preCheck call rejected: " + ((a.b) r14).a);
        goto L121
    L123:
        throw new NoWhenBranchMatchedException();
    L12:
        if (r11 == 39) goto L14;
    L16:
        Object r15 = AppHost.a.getApplication().getSystemService("audio");
        if ((r15 instanceof AudioManager) == false) goto L19;
        AudioManager r16 = (AudioManager) r15;
    L20:
        if (r16 != null) goto L22;
        n1.e("LarkRecordMinutesManager", "GRecord ValidCallRecordCheck: PASS current AudioManager is null, Unable to determine");
    L76:
        boolean r17 = true;
    L79:
        if (r17 == true) goto L82;
        r14 = new a.b("not_valid_call");
        goto L103
    L22:
        int r1 = r16.getMode();
        if (r1 != 2) goto L25;
    L35:
        boolean r5 = true;
    L36:
        n1.d("LarkRecordMinutesManager", "GRecord ValidCallRecordCheck current mode is " + r1);
        if (Build.VERSION.SDK_INT >= 24) goto L126;
        if (r5 == true) goto L40;
        n1.e("LarkRecordMinutesManager", "GRecord ValidCallRecordCheck: REJECT, API < 24, not isStrongCallMode");
    L78:
        r17 = false;
        goto L79
    L40:
        n1.d("LarkRecordMinutesManager", "GRecord ValidCallRecordCheck: PASS, API < 24, isStrongCallMode");
        goto L76
    L126:
        List<AudioRecordingConfiguration> r18 = r16.getActiveRecordingConfigurations();     // Catch: Exception -> L43
    L45:
        List<AudioRecordingConfiguration> r3 = r18;
        if (r3 != null) goto L48;
    L51:
        boolean r4 = true;
    L52:
        if (r4 == false) goto L56;
        if (r5 == false) goto L55;
        n1.d("LarkRecordMinutesManager", "GRecord ValidCallRecordCheck: PASS Configs empty and isStrongCallMode");
        goto L76
    L55:
        n1.e("LarkRecordMinutesManager", "GRecord ValidCallRecordCheck: REJECT Configs empty and not isStrongCallMode");
        goto L78
    L56:
        Iterator<AudioRecordingConfiguration> r19 = r18.iterator();
        boolean r6 = false;
        boolean r7 = false;
    L58:
        if (r19.hasNext() == false) goto L65;
        switch(r19.next().getClientAudioSource()) {
            case 1: goto L64;
            case 2: goto L63;
            case 3: goto L63;
            case 4: goto L63;
            case 5: goto L64;
            case 6: goto L62;
            case 7: goto L63;
            default: goto L58;
        };
    L62:
        r7 = true;
        goto L58
    L63:
        boolean r110 = true;
    L66:
        if (r110 == false) goto L68;
        n1.d("LarkRecordMinutesManager", "GRecord ValidCallRecordCheck: PASS - Confirmed VoIP source");
        goto L76
    L68:
        if (r6 == false) goto L72;
        if (r5 == false) goto L71;
        n1.d("LarkRecordMinutesManager", "GRecord ValidCallRecordCheck: PASS - Mode is Call, Source is MIC");
        goto L76
    L71:
        n1.e("LarkRecordMinutesManager", "GRecord ValidCallRecordCheck: REJECT - Mode 0 + MIC");
        goto L78
    L72:
        if (r7 == false) goto L74;
        n1.e("LarkRecordMinutesManager", "GRecord ValidCallRecordCheck: REJECT - Source is RECOGNITION");
        goto L78
    L74:
        if (r5 == false) goto L77;
        n1.d("LarkRecordMinutesManager", "GRecord ValidCallRecordCheck: PASS - Fallback");
        goto L76
    L77:
        n1.e("LarkRecordMinutesManager", "GRecord ValidCallRecordCheck: REJECT - Fallback");
        goto L78
    L64:
        r6 = true;
        goto L58
    L65:
        r110 = false;
        goto L66
    L48:
        if (r3.isEmpty() == true) goto L51;
        r4 = false;
    L43:
        e = move-exception;
        n1.c("LarkRecordMinutesManager", "GRecord ValidCallRecordCheck: Error getting configs", e);
        r18 = null;
        goto L45
    L25:
        if (r1 == 3) goto L35;
        if (r1 == 1) goto L35;
        if (r1 == 4) goto L35;
        if (r1 == 5) goto L35;
        if (r1 == 6) goto L35;
        r5 = false;
        goto L36
    L19:
        r16 = null;
        goto L20
    L14:
        if (DoraConfig.a.getBoolean("key_auto_record_in_call", false) == true) goto L16;
        r14 = new a.b("not_auto_call");
    L82:
        if (r() == false) goto L101;
        IDoraService r111 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r111 == null) goto L86;
        DeviceService r8 = r111.device();
    L87:
        if (r111 != null) goto L89;
    L91:
        boolean r112 = false;
    L92:
        if (r112 == false) goto L94;
        n1.d("LarkRecordMinutesManager", "lark meeting start reject: not worn");
        r14 = new a.b("not_worn");
        goto L103
    L94:
        if (r8 != null) goto L96;
    L98:
        boolean r113 = false;
    L99:
        if (r113 == false) goto L101;
        n1.d("LarkRecordMinutesManager", "lark meeting start reject: headphone mode");
        r14 = new a.b("is_headphone_mode");
        goto L103
    L96:
        if (r8.W() != true) goto L98;
        r113 = true;
        goto L99
    L89:
        if (r111.d0() != 0) goto L91;
        r112 = true;
        goto L92
    L86:
        r8 = null;
    L101:
        r14 = a.C0023a.a;
        goto L103
    }

    public static final Object a(LarkRecordMinutesManager r35, s r36, Continuation r37) {
        r35.getClass();
        if ((r37 instanceof LarkRecordMinutesManager$doRequestPushRecordCard$1) == false) goto L7;
        LarkRecordMinutesManager$doRequestPushRecordCard$1 r1 = (LarkRecordMinutesManager$doRequestPushRecordCard$1) r37;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        LarkRecordMinutesManager$doRequestPushRecordCard$1 r9 = r1;
        Object r0 = r9.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r9.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        long r5 = r9.J$0;
        String r6 = (String) r9.L$4;
        Integer r7 = (Integer) r9.L$3;
        String r8 = (String) r9.L$2;
        String r10 = (String) r9.L$1;
        s r11 = (s) r9.L$0;
        ResultKt.throwOnFailure(r0);
        String r15 = r6;
        Integer r14 = r7;
        String r16 = r8;
    L67:
        dm9.a.b r12 = (dm9.a) r0;
        long r26 = System.currentTimeMillis() - r5;
        boolean r13 = r12 instanceof dm9.a.b;
        if (r13 == false) goto L109;
        dm9.a.b r17 = r12;
        if (r17.a.isSuccess() == false) goto L109;
        l r18 = (l) r17.a.getData();
        if (r18 == null) goto L74;
        String r19 = r18.a();
    L75:
        H = r19;
        if (r18 == null) goto L78;
        String r20 = r18.c();
    L79:
        I = r20;
        String r21 = K;
        if (r21 != null) goto L82;
    L85:
        boolean r22 = true;
    L86:
        if (r22 == false) goto L91;
        if (r18 == null) goto L89;
        String r23 = r18.b();
    L90:
        K = r23;
        goto L91
    L89:
        r23 = null;
    L91:
        n1.d("LarkRecordMinutesManager", "GRecord push card success, msgId=" + H + ", taskId=" + I + ", replyMessageId=" + K);
        String r28 = H;
        if (r28 != null) goto L94;
    L97:
        boolean r110 = true;
    L98:
        if (r110 == false) goto L104;
        int r24 = com.larus.avlink.record.util.a.a;
        if (r18 == null) goto L102;
        String r25 = r18.b();
    L103:
        String r27 = r10;
        String r29 = r15;
        String r210 = r16;
        Integer r211 = r14;
        s r33 = r11;
        com.larus.avlink.record.util.a.h(false, r27, r29, r210, r211, r25, r26, null, "lark_record_start_empty_message_id", null, null, com.larus.avlink.record.util.a.b(r17.a), r33, 1664);
        com.larus.avlink.record.util.a.l(false, r27, r29, r210, r211, null, System.currentTimeMillis() - E, "interface", "lark_record_start_empty_message_id", null, null, com.larus.avlink.record.util.a.b(r17.a), r33, 1536);
        return RetryDecision.RETRY;
    L102:
        r25 = null;
        goto L103
    L104:
        int r30 = com.larus.avlink.record.util.a.a;
        if (r18 == null) goto L107;
        String r212 = r18.b();
    L108:
        com.larus.avlink.record.util.a.h(true, r10, r15, r16, r14, r212, r26, r28, null, null, null, null, r11, 3840);
        return RetryDecision.SUCCESS;
    L107:
        r212 = null;
        goto L108
    L94:
        if (r28.length() == 0) goto L97;
        r110 = false;
        goto L98
    L82:
        if (r21.length() == 0) goto L85;
        r22 = false;
        goto L86
    L78:
        r20 = null;
        goto L79
    L74:
        r19 = null;
    L109:
        if (r13 == false) goto L111;
        dm9.a.b r31 = r12;
    L112:
        if (r31 == null) goto L114;
        BizResponse r32 = r31.a;
    L115:
        if (r13 == false) goto L118;
        int r34 = com.larus.avlink.record.util.a.a;
        String r38 = "response_code_" + r12.a.getCode();
    L121:
        if (r13 == false) goto L124;
        StringBuilder r39 = new StringBuilder("code=");
        dm9.a.b r40 = r12;
        r39.append(r40.a.getCode());
        r39.append(", msg=");
        r39.append(r40.a.getMsg());
        String r41 = r39.toString();
    L126:
        n1.b("LarkRecordMinutesManager", "GRecord push card failed, " + r41);
        int r42 = com.larus.avlink.record.util.a.a;
        String r43 = com.larus.avlink.record.util.a.b(r32);
        String r213 = r10;
        String r214 = r15;
        String r215 = r16;
        Integer r216 = r14;
        String r310 = r38;
        String r311 = r41;
        s r312 = r11;
        com.larus.avlink.record.util.a.h(false, r213, r214, r215, r216, null, r26, null, "lark_record_start_request_failed", r310, r311, r43, r312, 128);
        com.larus.avlink.record.util.a.k(false, r213, r214, r215, r216, null, System.currentTimeMillis() - E, "interface", "lark_record_start_request_failed", r310, r311, r43, r312);
        return RetryDecision.RETRY;
    L124:
        if ((r12 instanceof dm9.a.a) == false) goto L129;
        StringBuilder r44 = new StringBuilder("code=");
        dm9.a.a r45 = (dm9.a.a) r12;
        r44.append(r45.a);
        r44.append(", msg=");
        r44.append(r45.b);
        r41 = r44.toString();
        goto L126
    L129:
        throw new NoWhenBranchMatchedException();
    L118:
        if ((r12 instanceof dm9.a.a) == false) goto L131;
        r38 = "request_failed";
        goto L121
    L131:
        throw new NoWhenBranchMatchedException();
    L114:
        r32 = null;
        goto L115
    L111:
        r31 = null;
        goto L112
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (E != 0) goto L17;
        E = System.currentTimeMillis();
    L17:
        String r46 = C;
        String r111 = k;
        Integer r47 = k();
        wc9.e r48 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r48 == null) goto L20;
        String r49 = r48.a;
    L21:
        if (r49 != null) goto L23;
    L26:
        boolean r50 = true;
    L27:
        if (r50 == false) goto L29;
        n1.e("LarkRecordMinutesManager", "GRecord push card skipped, mainBot conversationId is null");
        int r51 = com.larus.avlink.record.util.a.a;
        com.larus.avlink.record.util.a.l(false, r46, A, r111, r47, H, System.currentTimeMillis() - E, "client", "main_bot_conversation_unavailable", null, null, null, r36, 3584);
        return RetryDecision.RETRY;
    L29:
        String r52 = DoraConfig.g();
        if (r52.length() != 0) goto L32;
        boolean r53 = true;
    L33:
        if (r53 == false) goto L35;
        n1.e("LarkRecordMinutesManager", "GRecord push card skipped, mainBotId is invalid");
        return RetryDecision.RETRY;
    L35:
        r15 = A;
        if (r15 != null) goto L38;
    L41:
        boolean r54 = true;
    L42:
        if (r54 == false) goto L44;
        n1.e("LarkRecordMinutesManager", "GRecord push card skipped, recordingId is null");
        return RetryDecision.RETRY;
    L44:
        String r55 = k;
        if (r55 != null) goto L47;
    L62:
        int r56 = 1;
    L63:
        n1.d("LarkRecordMinutesManager", "GRecord push record card, cvsId=" + r49 + ", recordingId=" + r15 + ", startScene=" + r56 + ", productId=" + r47);
        long r57 = System.currentTimeMillis();
        LarkRecordStartApi.a r112 = LarkRecordStartApi.a;
        r14 = r47;
        LarkRecordMinutesManager$doRequestPushRecordCard$result$1 r113 = new LarkRecordMinutesManager$doRequestPushRecordCard$result$1(r52, r49, r47, r15, r56, null);
        r9.L$0 = r36;
        r9.L$1 = r46;
        r9.L$2 = r111;
        r9.L$3 = r14;
        r9.L$4 = r15;
        r9.J$0 = r57;
        r9.label = 1;
        r112.getClass();
        FlowHttpConnection r58 = FlowHttpConnection.a;
        r16 = r111;
        Object r59 = FlowHttpConnection.g("Audio", LarkRecordStartApi.class, r113, false, null, null, null, r9, 248);
        if (r59 == r3) goto L137;
        r11 = r36;
        r10 = r46;
        r0 = r59;
        r5 = r57;
        goto L67
    L137:
        return r3;
    L47:
        switch(r55.hashCode()) {
            case -22802329: goto L59;
            case 350657360: goto L57;
            case 519170381: goto L54;
            case 768267754: goto L50;
            default: goto L62;
        };
    L57:
        r55.equals("voice_control");
        goto L62
    L50:
        if (r55.equals("auto_enter_on_call_start") == false) goto L62;
        r56 = 4;
        goto L63
    L54:
        if (r55.equals("click_start_icon") == false) goto L62;
        r56 = 3;
        goto L63
    L59:
        if (r55.equals("gesture_control") == false) goto L62;
        r56 = 2;
        goto L63
    L38:
        if (r15.length() == 0) goto L41;
        r54 = false;
        goto L42
    L32:
        r53 = false;
        goto L33
    L23:
        if (r49.length() == 0) goto L26;
        r50 = false;
        goto L27
    L20:
        r49 = null;
    L7:
        r1 = new LarkRecordMinutesManager$doRequestPushRecordCard$1(r35, r37);
        goto L8
    }

    public static void l(Context r9, boolean r10, String r11, d0 r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "sourceTag");
        if (s() == true) goto L6;
        n1.d(r11, "GRecord not start record in GUI due to setting disabled");
        return;
    L6:
        if (r10 == true) goto L9;
        n1.d(r11, "GRecord not start record in GUI due to not connected");
        t19.s r0 = t19.s.a;
        int r13 = j0.a;
        t19.s.j(r0, r9, j0.d(2131902920), null, false, 28);
        return;
    L9:
        n1.d(r11, "GRecord start record in GUI by lark sdk");
        a r14 = M(99, 16, null);
        r14.getClass();
        if ((r14 instanceof a.C0023a) == false) goto L13;
        if (r12 == null) goto L28;
        r12.invoke();
        return;
    L28:
        return;
    L13:
        boolean r15 = r14 instanceof a.b;
        String r1 = "";
        if (r15 == false) goto L16;
        String r2 = ((a.b) r14).a;
    L18:
        if (Intrinsics.areEqual(r2, "not_worn") == false) goto L21;
        t19.s r3 = t19.s.a;
        int r16 = j0.a;
        t19.s.j(r3, r9, j0.d(2131902918), null, false, 28);
        return;
    L21:
        if (Intrinsics.areEqual(r2, "is_headphone_mode") == false) goto L23;
        t19.s r4 = t19.s.a;
        int r17 = j0.a;
        t19.s.j(r4, r9, j0.d(2131903952), null, false, 28);
        return;
    L23:
        StringBuilder r18 = new StringBuilder("GRecord start record in GUI rejected: ");
        if (r15 == false) goto L26;
        r1 = ((a.b) r14).a;
    L26:
        r18.append(r1);
        n1.d(r11, r18.toString());
        return;
    L16:
        r2 = "";
        goto L18
    }

    public static void o(int r6, int r7, int r8, int r9, String r10) {
        if (s() == true) goto L5;
        return;
    L5:
        n1.d("LarkRecordMinutesManager", "GRecord handleRecordWakeReject in Lark record state:" + r6 + ", mode:" + r7 + ", query:" + r8 + ", vuiId:" + r9 + ", kw:" + r10);
        Object r11 = d;
        monitor-enter(r11);
    L22:
        th = move-exception;
        throw th;
    L8:
        if (e != RecordingLifecycle.START_REQUESTED) goto L11;
        e = RecordingLifecycle.IDLE;     // Catch: Throwable -> L22
        boolean r12 = true;
    L12:
        monitor-exit(r11);
        if (r12 == false) goto L16;
        g();
        z(Action.ERROR);
    L16:
        if (r6 != 35) goto L19;
        t19.s r0 = t19.s.a;
        Application r1 = AppHost.a.getApplication();
        int r13 = j0.a;
        t19.s.j(r0, r1, j0.d(2131903958), null, false, 28);
    L19:
        if (r6 != 45) goto L27;
        t19.s r2 = t19.s.a;
        Application r3 = AppHost.a.getApplication();
        int r14 = j0.a;
        t19.s.j(r2, r3, j0.d(2131903957), null, false, 28);
        return;
    L27:
        return;
    L11:
        r12 = false;
        goto L12
    }

    public static void p(int r11, int r12, int r13, int r14, String r15) {
        if (s() == true) goto L10;
        n1.d("LarkRecordMinutesManager", "GRecord handleRecordWakeUp skipped because setting disabled");
        IDoraService r16 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r16 == null) goto L12;
        SessionService r17 = r16.d();
        if (r17 == null) goto L13;
        r17.y(4, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_EXCEPTION, false);
        return;
    L13:
        return;
    L12:
        return;
    L10:
        BuildersKt.launch$default(c, null, null, new LarkRecordMinutesManager$handleRecordWakeUp$1(r11, r12, r13, r14, r15, null), 3, null);
    }

    public final void n(int r9, int r10, int r11, int r12, String r13) {
        if (s() == true) goto L5;
        return;
    L5:
        RecordingLifecycle r0 = e;
        if (r0 != RecordingLifecycle.START_REQUESTED) goto L8;
    L49:
        n1.d("LarkRecordMinutesManager", "GRecord ignore device STOP while starting, lifecycle=" + r0 + ", state=" + r9);
        return;
    L8:
        if (r0 == RecordingLifecycle.STARTING) goto L49;
        if (r0 != RecordingLifecycle.STOP_PENDING) goto L15;
        B();
        n1.d("LarkRecordMinutesManager", "GRecord device STOP while stop pending, sdkStartInFlight=" + f + ", vuiStartCommandInFlight=" + g);
        return;
    L15:
        if (r9 != 175) goto L29;
        if (r0 != RecordingLifecycle.IDLE) goto L29;
        String r1 = A;
        if (r1 != null) goto L21;
    L24:
        boolean r2 = true;
    L25:
        if (r2 == false) goto L29;
        n1.d("LarkRecordMinutesManager", "GRecord ignore own VUI END callback after local cleanup");
        return;
    L21:
        if (r1.length() == 0) goto L24;
        r2 = false;
    L29:
        if (v() == false) goto L31;
    L37:
        n1.d("LarkRecordMinutesManager", "GRecord handleRecordWakeOff in Lark record state:" + r9 + ", mode:" + r10 + ", query:" + r11 + ", vuiId:" + r12 + ", kw:" + r13);
        if (r9 != 9) goto L40;
        String r3 = "hfp_calling";
    L47:
        I(r3, r9, r10, r11, r12, r13);
        return;
    L40:
        if (r9 != 32) goto L42;
        r3 = "gesture_control";
        goto L47
    L42:
        if (r9 == 39) goto L44;
        r3 = "out_of_time";
        goto L47
    L44:
        r3 = "auto_exit_on_call_end";
        goto L47
    L31:
        if (r0 == RecordingLifecycle.RECORDING) goto L37;
        if (t() == false) goto L36;
        n1.d("LarkRecordMinutesManager", "GRecord handleRecordWakeOff in hardware offline recording, state:" + r9 + ", mode:" + r10 + ", query:" + r11 + ", vuiId:" + r12 + ", kw:" + r13);
        O(false, "handleRecordWakeOff in isHardwareOfflineRecording");
        return;
    L36:
        n1.d("LarkRecordMinutesManager", "GRecord not handleRecordWakeOff in Lark record state:" + r9 + ", mode:" + r10 + ", query:" + r11 + ", vuiId:" + r12 + ", kw:" + r13);
    }

    public final void F(k r12, long r13, int r15, int r16, int r17, String r18) {
        o = System.currentTimeMillis();
        if (Intrinsics.areEqual(r12.b, "recorder_app") == false) goto L7;
        String r1 = C;
        if (r1 != null) goto L8;
        r1 = UUID.randomUUID().toString();
    L8:
        C = r1;
        NetworkAwareRetrier r2 = p;
        Job r3 = r2.j;
        if (r3 == null) goto L11;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L11:
        r2.j = null;
        r2.c();
        r2.h = false;
        r2.i = false;
        NetworkAwareRetrier r4 = q;
        Job r5 = r4.j;
        if (r5 == null) goto L14;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L14:
        r4.j = null;
        r4.c();
        r4.h = false;
        r4.i = false;
        H = null;
        I = null;
        K = J;
        J = null;
        l = r16;
        m = r12.a;
        n = r18;
        n1.d("LarkRecordMinutesManager", "GRecord startRecordByLarkSdk replyMessageId=" + K);
        if (m(this, r15, r16, r17, r12.a, r18, r12, false, 64) == false) goto L19;
        n1.d("LarkRecordMinutesManager", "GRecord startRecord intercepted by Obric");
        return;
    L19:
        if (Intrinsics.areEqual(r12.b, "recorder_app") == false) goto L37;
        n1.e("LarkRecordMinutesManager", "GRecord recorder app start not handled by Obric, skip lark sdk fallback");
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L25;
        SessionService r6 = r0.d();
        if (r6 == null) goto L25;
        r6.y(3, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_EXCEPTION, false);
    L25:
        Object r7 = d;
        monitor-enter(r7);
    L34:
        th = move-exception;
        throw th;
    L28:
        if (j != r13) goto L30;
        f = false;     // Catch: Throwable -> L34
        e = RecordingLifecycle.IDLE;     // Catch: Throwable -> L34
    L30:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(r7);
        g();
        z(Action.ERROR);
        return;
    L37:
        G(r12, r13);
        return;
    L7:
        r1 = UUID.randomUUID().toString();
        Intrinsics.checkNotNull(r1);
        goto L8
    }

    public final void I(String r12, int r13, int r14, int r15, int r16, String r17) {
        Intrinsics.checkNotNullParameter(r12, "endSource");
        if (s() == true) goto L5;
        return;
    L5:
        n1.d("LarkRecordMinutesManager", "GRecord stopRecord endSource=" + r12);
        if (v() == true) goto L17;
        String r1 = A;
        boolean r6 = false;
        if (r1 != null) goto L10;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == false) goto L17;
        if (SetsKt.setOf(new RecordingLifecycle[]{RecordingLifecycle.RECORDING, RecordingLifecycle.STOP_PENDING, RecordingLifecycle.STOPPING}).contains(e) == true) goto L17;
    L18:
        if (r6 == true) goto L21;
        n1.e("LarkRecordMinutesManager", "GRecord stopRecord but not recording");
        return;
    L21:
        boolean r10 = B;
        if (r10 == true) goto L24;
    L33:
        Object r3 = d;
        monitor-enter(r3);
        e = RecordingLifecycle.STOPPING;     // Catch: Throwable -> L50
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L50
        monitor-exit(r3);
        if (r10 == false) goto L39;
        n1.d("LarkRecordMinutesManager", "GRecord stop external recorder pcm by Obric, handled=" + m(this, r13, r14, r15, r16, r17, null, true, 32) + ", endSource=" + r12);
    L39:
        f(r12);
        if (r10 == true) goto L44;
        IMinutesService r4 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r4 == null) goto L45;
        r4.a(r12);
    L45:
        Iterator<Function1<Boolean, Unit>> r0 = s.iterator();
    L47:
        if (r0.hasNext() == false) goto L49;
        r0.next().invoke(Boolean.FALSE);
        goto L47
    L49:
        return;
    L44:
        n1.d("LarkRecordMinutesManager", "GRecord stop external recorder pcm, skipFeishu=true, endSource=" + r12);
    L50:
        th = move-exception;
        throw th;
    L24:
        if (e == RecordingLifecycle.RECORDING) goto L33;
        if (Intrinsics.areEqual(r12, "out_of_time") == false) goto L33;
        if (r14 != 16) goto L33;
        if (r15 != 1) goto L33;
        if (r16 != 0) goto L33;
        n1.d("LarkRecordMinutesManager", "GRecord ignore cleanup stop for external recorder pcm, state:" + r13 + ", mode:" + r14 + ", query:" + r15 + ", vuiId:" + r16);
        return;
    L10:
        if (r1.length() == 0) goto L13;
        r2 = false;
    L17:
        r6 = true;
        goto L18
    }

    public static boolean m(LarkRecordMinutesManager r13, int r14, int r15, int r16, int r17, String r18, k r19, boolean r20, int r21) {
        if ((r21 & 32) == 0) goto L5;
        k r0 = null;
    L7:
        if ((r21 & 64) == 0) goto L9;
        boolean r2 = false;
    L10:
        r13.getClass();
        IObricDoraService r5 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r5 == null) goto L55;
        if (r2 == false) goto L16;
        return r5.f(r14, r15, r16, r17, r18);
    L16:
        if (D(r15) == false) goto L18;
        n1.d("LarkRecordMinutesManager", "GRecord call record discarded by Obric");
        g();
        z(Action.END_PULL);
    L45:
        return true;
    L18:
        if (r0 == null) goto L56;
        String r3 = C;
        if (r3 != null) goto L23;
        r3 = UUID.randomUUID().toString();
        C = r3;
    L23:
        n1.d("LarkRecordMinutesManager", "GRecord try external_recorder_pcm, wakeId=" + r0.a + ", sessionId=" + r3);
        if (r5.s(r14, r15, r16, r0.a, r18, r3, r0.b) == true) goto L26;
        n1.d("LarkRecordMinutesManager", "GRecord external recorder pcm not intercepted, fallback to lark sdk");
        return false;
    L26:
        A = r3;
        k = r0.b;
        B = true;
        Object r6 = d;
        monitor-enter(r6);
        f = false;     // Catch: Throwable -> L47
        e = RecordingLifecycle.RECORDING;     // Catch: Throwable -> L47
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L47
        monitor-exit(r6);
        Job r4 = y;
        if (r4 == null) goto L33;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L33:
        y = BuildersKt.launch$default(c, null, null, new LarkRecordMinutesManager$startObserveExternalRecordingDuration$1(null), 3, null);
        if (r() == false) goto L40;
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r7 == null) goto L40;
        DeviceService r8 = r7.device();
        if (r8 == null) goto L40;
        r8.G0(LightEffectStatus.TURN_ON, LightEffectBrightness.LOW);
    L40:
        x(Action.START_PULL);
        Iterator<Function1<Boolean, Unit>> r9 = s.iterator();
    L42:
        if (r9.hasNext() == false) goto L44;
        r9.next().invoke(Boolean.TRUE);
        goto L42
    L44:
        b98.b.f(7, 1);
        n1.d("LarkRecordMinutesManager", "GRecord external recorder pcm start success, sessionId=" + r3);
    L47:
        th = move-exception;
        throw th;
    L56:
        return false;
    L55:
        return false;
    L9:
        r2 = r20;
        goto L10
    L5:
        r0 = r19;
        goto L7
    }
}

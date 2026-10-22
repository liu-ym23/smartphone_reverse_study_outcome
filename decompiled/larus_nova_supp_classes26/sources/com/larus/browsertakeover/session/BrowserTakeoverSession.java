package com.larus.browsertakeover.session;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.lifecycle.ViewModel;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.browsertakeover.cdp.BrowserCdpClient;
import com.larus.browsertakeover.signaling.LocalPcSignaling;
import com.larus.browsertakeover.transport.BrowserTransport;
import com.larus.browsertakeover.transport.RtcBrowserTransport;
import com.larus.im.internal.jni.bean.RoomMeta;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0000\u0018\u0000 a2\u00020\u0001:\u0004^_`aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\tJ\u000e\u0010>\u001a\u00020?2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010@\u001a\u00020?J\u0016\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u0015J\"\u0010D\u001a\u00020?2\u0006\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\t2\u0006\u0010H\u001a\u00020\u0015H\u0002J\b\u0010I\u001a\u00020?H\u0002J\u0006\u0010J\u001a\u00020?J\u0006\u0010K\u001a\u00020?J\b\u0010L\u001a\u00020?H\u0002J\u0006\u0010M\u001a\u00020?J\u0010\u0010N\u001a\u00020?2\u0006\u0010O\u001a\u00020\tH\u0002J\u0012\u0010P\u001a\u00020?2\b\b\u0002\u0010Q\u001a\u00020\u0017H\u0002J\u0010\u0010R\u001a\u00020?2\u0006\u0010S\u001a\u00020&H\u0002J\u000e\u0010T\u001a\u00020?2\u0006\u0010U\u001a\u00020\u0015J\u0006\u0010V\u001a\u00020?J\u0006\u0010W\u001a\u00020?J\u0006\u0010X\u001a\u00020?J\b\u0010Y\u001a\u00020?H\u0014J$\u0010Z\u001a\u00020?2\u0006\u0010[\u001a\u00020\t2\b\b\u0002\u0010\\\u001a\u00020\t2\b\b\u0002\u0010]\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001e\u0010'\u001a\u00020&2\u0006\u0010!\u001a\u00020&@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001e\u0010+\u001a\u00020*2\u0006\u0010!\u001a\u00020*@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\"\u0010/\u001a\u0004\u0018\u00010.2\b\u0010!\u001a\u0004\u0018\u00010.@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b6\u00104R\u0011\u00107\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b8\u00104R\u0011\u00109\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006b"}, d2 = {"Lcom/larus/browsertakeover/session/BrowserTakeoverSession;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "main", "Landroid/os/Handler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "logId", "", "connectStartedAtMs", "", "frameCount", "id", "entry", "Lcom/larus/browsertakeover/entry/TakeoverEntryStore$Entry;", "monitor", "Lcom/larus/browsertakeover/monitor/BrowserTakeoverMonitor;", "screencastParameters", "Lcom/larus/browsertakeover/experiment/BrowserScreencastParameters;", "generation", "", "pageReady", "", "firstFrame", "invitation", "Lcom/larus/browsertakeover/signaling/LocalPcSignaling$Cancellable;", "observer", "Lcom/larus/browsertakeover/session/BrowserTakeoverSession$Observer;", "startupTimeout", "Ljava/lang/Runnable;", "completionRequested", "host", "value", "Lcom/larus/browsertakeover/cdp/BrowserCdpClient$NavigationState;", "navigationState", "getNavigationState", "()Lcom/larus/browsertakeover/cdp/BrowserCdpClient$NavigationState;", "Lcom/larus/browsertakeover/session/BrowserTakeoverSession$State;", "state", "getState", "()Lcom/larus/browsertakeover/session/BrowserTakeoverSession$State;", "Lcom/larus/browsertakeover/session/BrowserTakeoverSession$ErrorReason;", "errorReason", "getErrorReason", "()Lcom/larus/browsertakeover/session/BrowserTakeoverSession$ErrorReason;", "Lcom/larus/browsertakeover/cdp/BrowserCdpClient;", "client", "getClient", "()Lcom/larus/browsertakeover/cdp/BrowserCdpClient;", "canControl", "getCanControl", "()Z", "canComplete", "getCanComplete", "usesRtsInputPacing", "getUsesRtsInputPacing", "connectionAttempt", "getConnectionAttempt", "()I", "initialize", "entryId", "attach", "", "detach", "connect", "width", "height", "createClient", "transport", "Lcom/larus/browsertakeover/transport/BrowserTransport;", "pageId", "connectionGeneration", "becomeActiveIfReady", "completeAfterPendingInput", "complete", "startPendingCompletion", "disconnect", "fail", MusicAppletPage.KEY_SOURCE, "releaseConnection", "preservePageInfo", "update", "next", "onFirstFrameSubmitted", "attempt", "onBackgrounded", "onUserClosed", "onPageDismissed", "onCleared", "log", "event", "details", "debug", "State", "ErrorReason", "Observer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BrowserTakeoverSession extends ViewModel {
    private static final a Companion = null;
    public static final String TAG = "BrowserTakeoverSession";
    private BrowserCdpClient client;
    private boolean completionRequested;
    private long connectStartedAtMs;
    private com.larus.browsertakeover.entry.a.C0068a entry;
    private ErrorReason errorReason;
    private boolean firstFrame;
    private long frameCount;
    private int generation;
    private String host;
    private String id;
    private LocalPcSignaling.a invitation;
    private final String logId;
    private final Handler main;
    private kv8.a monitor;
    private BrowserCdpClient.i navigationState;
    private b observer;
    private boolean pageReady;
    private final CoroutineScope scope;
    private jv8.a screencastParameters;
    private Runnable startupTimeout;
    private State state;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/browsertakeover/session/BrowserTakeoverSession$ErrorReason;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTION", "MEDIA_BUSY", "MESSAGE_TOO_LARGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ErrorReason extends Enum<ErrorReason> {
        public static final ErrorReason CONNECTION = null;
        public static final ErrorReason MEDIA_BUSY = null;
        public static final ErrorReason MESSAGE_TOO_LARGE = null;
        public static final /* synthetic */ ErrorReason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ErrorReason> getEntries() {
            return b;
        }

        static {
            ErrorReason r0 = new ErrorReason("CONNECTION", 0);
            CONNECTION = r0;
            ErrorReason r1 = new ErrorReason("MEDIA_BUSY", 1);
            MEDIA_BUSY = r1;
            ErrorReason r3 = new ErrorReason("MESSAGE_TOO_LARGE", 2);
            MESSAGE_TOO_LARGE = r3;
            ErrorReason[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ErrorReason[] values() {
            return (ErrorReason[]) a.clone();
        }

        public static ErrorReason valueOf(String r1) {
            return (ErrorReason) r27.a.a(ErrorReason.class, r1);
        }

        public ErrorReason(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/browsertakeover/session/BrowserTakeoverSession$State;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "CONNECTING", "ACTIVE", "DISCONNECTED", "ERROR", "COMPLETING", "COMPLETION_FAILED", "COMPLETE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State ACTIVE = null;
        public static final State COMPLETE = null;
        public static final State COMPLETING = null;
        public static final State COMPLETION_FAILED = null;
        public static final State CONNECTING = null;
        public static final State DISCONNECTED = null;
        public static final State ERROR = null;
        public static final State IDLE = null;
        public static final /* synthetic */ State[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<State> getEntries() {
            return b;
        }

        static {
            State r0 = new State("IDLE", 0);
            IDLE = r0;
            State r1 = new State("CONNECTING", 1);
            CONNECTING = r1;
            State r3 = new State("ACTIVE", 2);
            ACTIVE = r3;
            State r5 = new State("DISCONNECTED", 3);
            DISCONNECTED = r5;
            State r7 = new State("ERROR", 4);
            ERROR = r7;
            State r9 = new State("COMPLETING", 5);
            COMPLETING = r9;
            State r11 = new State("COMPLETION_FAILED", 6);
            COMPLETION_FAILED = r11;
            State r13 = new State("COMPLETE", 7);
            COMPLETE = r13;
            State[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
            a = r15;
            b = EnumEntriesKt.enumEntries(r15);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public interface b extends BrowserCdpClient.d {
        void aC(State r1);
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RtcBrowserTransport.Failure.values().length];
            r0[RtcBrowserTransport.Failure.MEDIA_BUSY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[RtcBrowserTransport.Failure.MESSAGE_TOO_LARGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.browsertakeover.session.BrowserTakeoverSession$completeAfterPendingInput$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(Object r8) {
            super(0, r8, BrowserTakeoverSession.class, "startPendingCompletion", "startPendingCompletion()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m88invoke() {
            BrowserTakeoverSession.access$startPendingCompletion((BrowserTakeoverSession) ((CallableReference) this).receiver);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m88invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.browsertakeover.session.BrowserTakeoverSession$completeAfterPendingInput$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass2(Object r8) {
            super(0, r8, BrowserTakeoverSession.class, "startPendingCompletion", "startPendingCompletion()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m89invoke() {
            BrowserTakeoverSession.access$startPendingCompletion((BrowserTakeoverSession) ((CallableReference) this).receiver);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m89invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class d implements BrowserCdpClient.d {
        public final /* synthetic */ BrowserTakeoverSession a;
        public final /* synthetic */ int b;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[BrowserCdpClient.State.values().length];
                r0[BrowserCdpClient.State.READY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[BrowserCdpClient.State.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[BrowserCdpClient.State.DISCONNECTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
        public final void OH(String r3) {
            Intrinsics.checkNotNullParameter(r3, "host");
            if (BrowserTakeoverSession.access$getGeneration$p(this.a) != this.b) goto L8;
            BrowserTakeoverSession.access$setHost$p(this.a, r3);
            b r0 = BrowserTakeoverSession.access$getObserver$p(this.a);
            if (r0 == null) goto L9;
            r0.OH(r3);
            return;
        L9:
            return;
        }

        @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
        public final void iu(String r3) {
            Intrinsics.checkNotNullParameter(r3, "stage");
            if (BrowserTakeoverSession.access$getGeneration$p(this.a) != this.b) goto L8;
            kv8.a r0 = BrowserTakeoverSession.access$getMonitor$p(this.a);
            if (r0 == null) goto L9;
            r0.g(r3);
            return;
        L9:
            return;
        }

        @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
        public final void ko(BrowserCdpClient.l r3) {
            Intrinsics.checkNotNullParameter(r3, "focus");
            if (BrowserTakeoverSession.access$getGeneration$p(this.a) == this.b) goto L5;
            return;
        L5:
            if (this.a.getCanControl() == false) goto L11;
            b r0 = BrowserTakeoverSession.access$getObserver$p(this.a);
            if (r0 == null) goto L12;
            r0.ko(r3);
            return;
        L12:
            return;
        }

        @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
        public final void m70(BrowserCdpClient.i r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            if (BrowserTakeoverSession.access$getGeneration$p(this.a) != this.b) goto L8;
            BrowserTakeoverSession.access$setNavigationState$p(this.a, r3);
            b r0 = BrowserTakeoverSession.access$getObserver$p(this.a);
            if (r0 == null) goto L9;
            r0.m70(r3);
            return;
        L9:
            return;
        }

        @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
        public final void v30(BrowserCdpClient.State r9) {
            Intrinsics.checkNotNullParameter(r9, "state");
            if (BrowserTakeoverSession.access$getGeneration$p(this.a) == this.b) goto L5;
            return;
        L5:
            BrowserTakeoverSession.log$default(this.a, "cdp_state_changed", "newState=" + r9, false, 4, null);
            int r0 = a.a[r9.ordinal()];
            if (r0 != 1) goto L8;
            BrowserTakeoverSession.access$setPageReady$p(this.a, true);
            BrowserTakeoverSession.access$becomeActiveIfReady(this.a);
            return;
        L8:
            if (r0 != 2) goto L10;
        L12:
            BrowserTakeoverSession.access$fail(this.a, "cdp_" + r9.name());
            return;
        L10:
            if (r0 == 3) goto L12;
        }

        public d(BrowserTakeoverSession r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
        public final void pW(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "stage");
            Intrinsics.checkNotNullParameter(r4, "code");
            if (BrowserTakeoverSession.access$getGeneration$p(this.a) != this.b) goto L8;
            kv8.a r0 = BrowserTakeoverSession.access$getMonitor$p(this.a);
            if (r0 == null) goto L9;
            r0.e(r3, r4);
            return;
        L9:
            return;
        }

        @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
        public final void R50(Bitmap r7, float r8, float r9, float r10) {
            Intrinsics.checkNotNullParameter(r7, "bitmap");
            if (BrowserTakeoverSession.access$getGeneration$p(this.a) == this.b) goto L5;
        L17:
            r7.recycle();
            return;
        L5:
            if (BrowserTakeoverSession.access$getObserver$p(this.a) == null) goto L17;
            BrowserTakeoverSession.access$setFrameCount$p(this.a, BrowserTakeoverSession.access$getFrameCount$p(this.a) + 1);
            if (BrowserTakeoverSession.access$getFirstFrame$p(this.a) == true) goto L10;
        L11:
            BrowserTakeoverSession r0 = this.a;
            StringBuilder r2 = new StringBuilder("count=");
            r2.append(BrowserTakeoverSession.access$getFrameCount$p(this.a));
            r2.append(" first=");
            r2.append(!BrowserTakeoverSession.access$getFirstFrame$p(this.a));
            r2.append(" bitmap=");
            r2.append(r7.getWidth());
            r2.append('x');
            r2.append(r7.getHeight());
            r2.append(" viewport=");
            r2.append(r8);
            r2.append('x');
            r2.append(r9);
            r2.append(" offsetTop=");
            r2.append(r10);
            BrowserTakeoverSession.access$log(r0, "frame_received", r2.toString(), BrowserTakeoverSession.access$getFirstFrame$p(this.a));
        L12:
            BrowserTakeoverSession.access$setFirstFrame$p(this.a, true);
            b r1 = BrowserTakeoverSession.access$getObserver$p(this.a);
            if (r1 == null) goto L15;
            r1.R50(r7, r8, r9, r10);
        L15:
            BrowserTakeoverSession.access$becomeActiveIfReady(this.a);
            return;
        L10:
            if ((BrowserTakeoverSession.access$getFrameCount$p(this.a) % 30) != 0) goto L12;
            goto L11
        }
    }

    /* JADX INFO: renamed from: com.larus.browsertakeover.session.BrowserTakeoverSession$startPendingCompletion$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.browsertakeover.session.BrowserTakeoverSession$startPendingCompletion$1", f = "BrowserTakeoverSession.kt", i = {}, l = {295}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.browsertakeover.entry.a.C0068a $current;
        int label;
        final /* synthetic */ BrowserTakeoverSession this$0;

        public C02211(BrowserTakeoverSession r1, com.larus.browsertakeover.entry.a.C0068a r2, Continuation<? super C02211> r3) {
            this.this$0 = r1;
            this.$current = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02211(this.this$0, this.$current, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r7);     // Catch: Exception -> L15 CancellationException -> L34
        L13:
            boolean r8 = Intrinsics.areEqual(r7, Boxing.boxBoolean(true));     // Catch: Exception -> L15 CancellationException -> L34
        L17:
            BrowserTakeoverSession.log$default(this.this$0, "complete_result", "success=" + r8, false, 4, null);
            kv8.a r2 = BrowserTakeoverSession.access$getMonitor$p(this.this$0);
            if (r2 != null) goto L20;
        L28:
            BrowserTakeoverSession r3 = this.this$0;
            if (r8 == false) goto L31;
            State r9 = State.COMPLETE;
        L32:
            BrowserTakeoverSession.access$update(r3, r9);
            return Unit.INSTANCE;
        L31:
            r9 = State.COMPLETION_FAILED;
            goto L32
        L20:
            if (r2.e == true) goto L28;
            if (r8 == false) goto L24;
            String r4 = "success";
        L25:
            r2.g = r4;
            if (r8 == false) goto L28;
            r2.f = "completed";
            goto L28
        L24:
            r4 = "fail";
            goto L25
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
            BrowserTakeoverSession$startPendingCompletion$1$success$1 r10 = new BrowserTakeoverSession$startPendingCompletion$1$success$1(this.$current, null);     // Catch: Exception -> L15 CancellationException -> L34
            this.label = 1;     // Catch: Exception -> L15 CancellationException -> L34
            r7 = TimeoutKt.c(65000, r10, this);     // Catch: Exception -> L15 CancellationException -> L34
            if (r7 != r0) goto L13;
            return r0;
        L34:
            e = move-exception;
            BrowserTakeoverSession.log$default(this.this$0, "complete_cancelled", null, false, 6, null);
            throw e;
        L15:
            e = move-exception;
            BrowserTakeoverSession.log$default(this.this$0, "complete_exception", "type=".concat(e.getClass().getSimpleName()), false, 4, null);
            r8 = false;
            goto L17
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit Mo(BrowserTakeoverSession r0, int r1, LocalPcSignaling.Failure r2) {
        return connect$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ void No(BrowserTakeoverSession r0) {
        r0.startPendingCompletion();
    }

    public static /* synthetic */ Unit Oo(BrowserTakeoverSession r0, int r1, hv8.a r2, hv8.c r3, RoomMeta r4) {
        return connect$lambda$5(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void Po(BrowserTakeoverSession r0, int r1) {
        connect$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit yo(BrowserTakeoverSession r0, int r1, RtcBrowserTransport.Failure r2) {
        return connect$lambda$5$lambda$4(r0, r1, r2);
    }

    private final void becomeActiveIfReady() {
        if (this.state == State.CONNECTING) goto L5;
        return;
    L5:
        if (this.pageReady == true) goto L7;
        return;
    L7:
        if (this.firstFrame == false) goto L21;
        Runnable r0 = this.startupTimeout;
        if (r0 == null) goto L11;
        this.main.removeCallbacks(r0);
    L11:
        this.startupTimeout = null;
        LocalPcSignaling.a r1 = this.invitation;
        if (r1 == null) goto L14;
        r1.cancel();
    L14:
        this.invitation = null;
        kv8.a r2 = this.monitor;
        if (r2 == null) goto L17;
        r2.d("success");
        r2.f();
    L17:
        update(State.ACTIVE);
        return;
    }

    private final void startPendingCompletion() {
        if (this.completionRequested == true) goto L5;
        return;
    L5:
        this.completionRequested = false;
        com.larus.browsertakeover.entry.a.C0068a r0 = this.entry;
        if (r0 != null) goto L15;
        log$default(this, "complete_ignored", "reason=missing_entry", false, 4, null);
        kv8.a r1 = this.monitor;
        if (r1 != null) goto L10;
    L13:
        update(State.COMPLETION_FAILED);
        return;
    L10:
        if (r1.e == true) goto L13;
        r1.g = "fail";
        goto L13
    L15:
        log$default(this, "complete_requested", null, false, 6, null);
        releaseConnection(true);
        BuildersKt.launch$default(this.scope, null, null, new C02211(this, r0, null), 3, null);
    }

    public final void detach() {
        log$default(this, "observer_detached", "state=" + this.state, false, 4, null);
        this.observer = null;
    }

    public final void disconnect() {
        log$default(this, "disconnect_requested", "state=" + this.state, false, 4, null);
        kv8.a r0 = this.monitor;
        if (r0 == null) goto L5;
        r0.d("cancel");
    L5:
        State r1 = this.state;
        State r2 = State.COMPLETING;
        if (r1 != r2) goto L8;
    L13:
        boolean r3 = true;
    L14:
        releaseConnection(r3);
        State r4 = this.state;
        if (r4 != r2) goto L17;
        return;
    L17:
        if (r4 != State.COMPLETE) goto L19;
        return;
    L19:
        if (r4 == State.COMPLETION_FAILED) goto L24;
        update(State.DISCONNECTED);
        return;
    L24:
        return;
    L8:
        if (r1 == State.COMPLETION_FAILED) goto L13;
        if (r1 == State.COMPLETE) goto L13;
        r3 = false;
        goto L14
    }

    public final boolean getCanComplete() {
        State r0 = this.state;
        if (r0 != State.ACTIVE) goto L5;
    L8:
        return true;
    L5:
        if (r0 == State.COMPLETION_FAILED) goto L8;
        return false;
    }

    public final boolean getCanControl() {
        if (this.state != State.ACTIVE) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getConnectionAttempt() {
        kv8.a r0 = this.monitor;
        if (r0 == null) goto L8;
        kv8.a.C0115a r1 = r0.d;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.a;
    L8:
        return 0;
    }

    public final boolean getUsesRtsInputPacing() {
        BrowserCdpClient r0 = this.client;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.n() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void onBackgrounded() {
        kv8.a r0 = this.monitor;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.f != null) goto L7;
        r0.f = "background";
    L7:
        r0.d("cancel");
    }

    public void onCleared() {
        log$default(this, "cleared", "state=" + this.state, false, 4, null);
        kv8.a r0 = this.monitor;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.observer = null;
        this.completionRequested = false;
        this.main.removeCallbacksAndMessages(null);
        releaseConnection$default(this, false, 1, null);
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        this.entry = null;
        String r1 = com.larus.browsertakeover.entry.a.a;
        String r2 = this.id;
        Intrinsics.checkNotNullParameter(r2, "id");
        if (Intrinsics.areEqual(com.larus.browsertakeover.entry.a.a, r2) == false) goto L9;
        com.larus.browsertakeover.entry.a.a = null;
        com.larus.browsertakeover.entry.a.b = null;
        return;
    }

    public final void onPageDismissed() {
        kv8.a r0 = this.monitor;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    public final void onUserClosed() {
        kv8.a r0 = this.monitor;
        if (r0 == null) goto L10;
        String r1 = r0.f;
        if (r1 != null) goto L7;
    L8:
        r0.f = "user_close";
        return;
    L7:
        if (Intrinsics.areEqual(r1, "background") == true) goto L8;
        return;
    }

    public BrowserTakeoverSession() {
        this.main = new Handler(Looper.getMainLooper());
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.logId = Integer.toString(System.identityHashCode(this), CharsKt.checkRadix(16));
        this.id = "";
        this.host = "";
        this.navigationState = new BrowserCdpClient.i(false, false);
        this.state = State.IDLE;
        this.errorReason = ErrorReason.CONNECTION;
    }

    public final void complete() {
        if (getCanComplete() == true) goto L7;
        log$default(this, "complete_ignored", "state=" + this.state, false, 4, null);
        return;
    L7:
        if (this.completionRequested == false) goto L9;
        return;
    L9:
        this.completionRequested = true;
        kv8.a r0 = this.monitor;
        if (r0 != null) goto L12;
    L14:
        update(State.COMPLETING);
        startPendingCompletion();
        return;
    L12:
        if (r0.e == true) goto L14;
        r0.g = null;
        goto L14
    }

    public final void completeAfterPendingInput() {
        if (getCanComplete() == true) goto L7;
        log$default(this, "complete_ignored", "state=" + this.state, false, 4, null);
        return;
    L7:
        if (this.completionRequested == false) goto L9;
        return;
    L9:
        this.completionRequested = true;
        kv8.a r0 = this.monitor;
        if (r0 != null) goto L12;
    L14:
        update(State.COMPLETING);
        BrowserCdpClient r1 = this.client;
        if (r1 != null) goto L17;
        startPendingCompletion();
        return;
    L17:
        r1.R(new AnonymousClass1(this), new AnonymousClass2(this));
        return;
    L12:
        if (r0.e == true) goto L14;
        r0.g = null;
        goto L14
    }

    public final BrowserCdpClient getClient() {
        return this.client;
    }

    public final ErrorReason getErrorReason() {
        return this.errorReason;
    }

    public final BrowserCdpClient.i getNavigationState() {
        return this.navigationState;
    }

    public final State getState() {
        return this.state;
    }

    public static final /* synthetic */ void access$becomeActiveIfReady(BrowserTakeoverSession r0) {
        r0.becomeActiveIfReady();
    }

    public static final /* synthetic */ boolean access$getFirstFrame$p(BrowserTakeoverSession r0) {
        return r0.firstFrame;
    }

    public static final /* synthetic */ long access$getFrameCount$p(BrowserTakeoverSession r2) {
        return r2.frameCount;
    }

    public static final /* synthetic */ int access$getGeneration$p(BrowserTakeoverSession r0) {
        return r0.generation;
    }

    public static final /* synthetic */ kv8.a access$getMonitor$p(BrowserTakeoverSession r0) {
        return r0.monitor;
    }

    public static final /* synthetic */ b access$getObserver$p(BrowserTakeoverSession r0) {
        return r0.observer;
    }

    public static final /* synthetic */ void access$startPendingCompletion(BrowserTakeoverSession r0) {
        r0.startPendingCompletion();
    }

    private final void fail(String r7) {
        log$default(this, "connection_failed", "source=" + r7 + " state=" + this.state + " pageReady=" + this.pageReady + " firstFrame=" + this.firstFrame + " errorReason=" + this.errorReason, false, 4, null);
        kv8.a r0 = this.monitor;
        if (r0 == null) goto L15;
        String r8 = r7.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullParameter(r8, "fallbackCode");
        if (r0.e == true) goto L15;
        kv8.a.C0115a r1 = r0.d;
        if (r1 == null) goto L15;
        if (r1.g != null) goto L13;
        r1.g = new kv8.a.c(r1.f, r8);
    L13:
        r0.f = "disconnected";
        r0.d("fail");
    L15:
        if (this.completionRequested == false) goto L18;
        releaseConnection(true);
        return;
    L18:
        releaseConnection$default(this, false, 1, null);
        update(State.ERROR);
    }

    private final void releaseConnection(boolean r9) {
        StringBuilder r0 = new StringBuilder("hasClient=");
        if (this.client == null) goto L5;
        boolean r2 = true;
    L6:
        r0.append(r2);
        r0.append(" hasInvitation=");
        if (this.invitation == null) goto L9;
        boolean r3 = true;
    L10:
        r0.append(r3);
        r0.append(" frames=");
        r0.append(this.frameCount);
        log$default(this, "connection_release", r0.toString(), false, 4, null);
        this.generation++;
        if (r9 == true) goto L18;
        this.host = "";
        this.navigationState = new BrowserCdpClient.i(false, false);
        b r1 = this.observer;
        if (r1 == null) goto L15;
        r1.OH("");
    L15:
        b r10 = this.observer;
        if (r10 == null) goto L18;
        r10.m70(this.navigationState);
    L18:
        Runnable r11 = this.startupTimeout;
        if (r11 == null) goto L21;
        this.main.removeCallbacks(r11);
    L21:
        this.startupTimeout = null;
        LocalPcSignaling.a r4 = this.invitation;
        if (r4 == null) goto L24;
        r4.cancel();
    L24:
        this.invitation = null;
        BrowserCdpClient r5 = this.client;
        this.client = null;
        if (r5 == null) goto L31;
        if (r5.w == true) goto L31;
        r5.g();
        r5.w = true;
        r5.d.removeCallbacksAndMessages(null);
        r5.e.shutdownNow();
        r5.a.release();
    L31:
        if (this.completionRequested == false) goto L34;
        this.main.post(new com.larus.browsertakeover.session.d(this));
        return;
    L34:
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    private final void update(State r7) {
        log$default(this, "state_changed", "oldState=" + this.state + " newState=" + r7 + " pageReady=" + this.pageReady + " firstFrame=" + this.firstFrame, false, 4, null);
        this.state = r7;
        b r0 = this.observer;
        if (r0 == null) goto L6;
        r0.aC(r7);
        return;
    }

    public final void attach(b r8) {
        Intrinsics.checkNotNullParameter(r8, "observer");
        this.observer = r8;
        log$default(this, "observer_attached", "state=" + this.state, false, 4, null);
        r8.aC(this.state);
        r8.OH(this.host);
        r8.m70(this.navigationState);
    }

    public final boolean initialize(String r9) {
        Intrinsics.checkNotNullParameter(r9, "entryId");
        if (this.entry == null) goto L6;
        log$default(this, "initialize_reused", null, false, 6, null);
        return true;
    L6:
        this.id = r9;
        String r0 = com.larus.browsertakeover.entry.a.a;
        Intrinsics.checkNotNullParameter(r9, "id");
        com.larus.browsertakeover.entry.a.C0068a r1 = null;
        if (Intrinsics.areEqual(com.larus.browsertakeover.entry.a.a, r9) == false) goto L9;
        com.larus.browsertakeover.entry.a.C0068a r10 = com.larus.browsertakeover.entry.a.b;
        com.larus.browsertakeover.entry.a.b = null;
        r1 = r10;
    L9:
        this.entry = r1;
        if (r1 == null) goto L12;
        this.monitor = new kv8.a(r1.a);
        int r2 = ka9.a.a;
        jv8.b r3 = new jv8.b(0);
        AtomicReference r4 = ga9.a.a;
        ga9.e.a.getClass();
        this.screencastParameters = ((jv8.b) ga9.e.a(ga9.a.c("mobile_browser_screencast_size", ga9.e.c(r3)), jv8.b.class, r3)).a(r1.a.g instanceof hv8.c.a);
    L12:
        StringBuilder r5 = new StringBuilder("entryPresent=");
        if (this.entry == null) goto L15;
        boolean r6 = true;
    L16:
        r5.append(r6);
        log$default(this, "initialize", r5.toString(), false, 4, null);
        if (this.entry != null) goto L21;
        return false;
    L21:
        return true;
    L15:
        r6 = false;
        goto L16
    }

    public final void onFirstFrameSubmitted(int r5) {
        kv8.a r0 = this.monitor;
        if (r0 == null) goto L23;
        kv8.a.C0115a r1 = r0.d;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r0.e == false) goto L10;
        return;
    L10:
        if (r5 == r1.a) goto L12;
        return;
    L12:
        if (r1.d == false) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r1.c, "fail") == false) goto L16;
        return;
    L16:
        if (Intrinsics.areEqual(r1.c, "cancel") == false) goto L19;
        return;
    L19:
        if (r1.e != null) goto L21;
        r1.e = Long.valueOf(SystemClock.elapsedRealtime());
    L21:
        r0.f();
        return;
    }

    public static final /* synthetic */ void access$fail(BrowserTakeoverSession r0, String r1) {
        r0.fail(r1);
    }

    public static final /* synthetic */ void access$setFirstFrame$p(BrowserTakeoverSession r0, boolean r1) {
        r0.firstFrame = r1;
    }

    public static final /* synthetic */ void access$setFrameCount$p(BrowserTakeoverSession r0, long r1) {
        r0.frameCount = r1;
    }

    public static final /* synthetic */ void access$setHost$p(BrowserTakeoverSession r0, String r1) {
        r0.host = r1;
    }

    public static final /* synthetic */ void access$setNavigationState$p(BrowserTakeoverSession r0, BrowserCdpClient.i r1) {
        r0.navigationState = r1;
    }

    public static final /* synthetic */ void access$setPageReady$p(BrowserTakeoverSession r0, boolean r1) {
        r0.pageReady = r1;
    }

    public static final /* synthetic */ void access$update(BrowserTakeoverSession r0, State r1) {
        r0.update(r1);
    }

    private static final void connect$lambda$2(BrowserTakeoverSession r1, int r2) {
        if (r1.generation == r2) goto L5;
        return;
    L5:
        if (r1.state != State.CONNECTING) goto L9;
        r1.fail("startup_timeout");
        return;
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [com.larus.browsertakeover.session.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.larus.browsertakeover.session.c, java.lang.Object] */
    public final void connect(int r21, int r22) {
        State r0 = this.state;
        State r7 = State.CONNECTING;
        if (r0 != r7) goto L5;
    L57:
        log$default(this, "connect_ignored", "state=" + this.state, false, 4, null);
        return;
    L5:
        if (r0 == State.ACTIVE) goto L57;
        if (r0 == State.COMPLETING) goto L57;
        if (r0 == State.COMPLETE) goto L57;
        if (r0 == State.COMPLETION_FAILED) goto L57;
        com.larus.browsertakeover.entry.a.C0068a r1 = this.entry;
        if (r1 == null) goto L55;
        final hv8.a r8 = r1.a;
        if (r8 == null) goto L55;
        releaseConnection$default(this, false, 1, null);
        final int r10 = this.generation;
        this.connectStartedAtMs = SystemClock.elapsedRealtime();
        kv8.a r11 = this.monitor;
        if (r11 != null) goto L21;
    L28:
        this.frameCount = 0;
        boolean r2 = r8.g instanceof hv8.c.a;
        StringBuilder r3 = new StringBuilder("target=");
        if (r2 == false) goto L31;
        String r4 = "cloud";
    L32:
        r3.append(r4);
        r3.append(" viewport=");
        r3.append(r21);
        r3.append('x');
        r3.append(r22);
        log$default(this, "connect_requested", r3.toString(), false, 4, null);
        this.pageReady = false;
        this.firstFrame = false;
        this.errorReason = ErrorReason.CONNECTION;
        update(r7);
        Runnable r5 = new com.larus.browsertakeover.session.a(this, r10);
        this.main.postDelayed(r5, 60000);
        this.startupTimeout = r5;
        final hv8.c r12 = r8.g;
        if ((r12 instanceof hv8.c.a) == false) goto L36;
        hv8.c.a r13 = (hv8.c.a) r12;
        createClient(new com.larus.browsertakeover.transport.d(r13.a), r13.b, r10);
        return;
    L36:
        if ((r12 instanceof hv8.c.b) == false) goto L54;
        kv8.a r6 = this.monitor;
        if (r6 == null) goto L40;
        r6.g("invite");
    L40:
        log$default(this, "pc_invite_requested", "command=600", false, 4, null);
        int r9 = LocalPcSignaling.a;
        hv8.c.b r14 = (hv8.c.b) r12;
        String r15 = r14.a;
        String r16 = r14.b;
        if (r16 == null) goto L45;
        Integer r17 = StringsKt.toIntOrNull(r16);
        if (r17 == null) goto L45;
        int r18 = r17.intValue();
    L46:
        String r19 = o.a.getDeviceId();
        String r20 = r8.a;
        ?? r23 = new com.larus.browsertakeover.session.b(this, r10, r8, r12);
        ?? r24 = new com.larus.browsertakeover.session.c(this, r10);
        Intrinsics.checkNotNullParameter(r15, "deviceId");
        Intrinsics.checkNotNullParameter(r19, "sourceDeviceId");
        Intrinsics.checkNotNullParameter(r20, "conversationId");
        Intrinsics.checkNotNullParameter(r23, "onRoomMeta");
        Intrinsics.checkNotNullParameter(r24, "onFailure");
        final LocalPcSignaling.b r25 = new LocalPcSignaling.b(r15, r18, r19, r20, null, r23, r24);
        r25.c(new com.larus.browsertakeover.signaling.a(r25));
        if (this.generation == r10) goto L49;
    L51:
        r25.cancel();
        return;
    L49:
        if (this.state != r7) goto L51;
        this.invitation = r25;
        return;
    L45:
        r18 = 0;
        goto L46
    L54:
        throw new NoWhenBranchMatchedException();
    L31:
        r4 = "local_pc";
        goto L32
    L21:
        if (r11.e == true) goto L28;
        r11.d("cancel");
        kv8.a.C0115a r26 = r11.d;
        if (r26 == null) goto L26;
        int r27 = r26.a;
    L27:
        int r28 = r27 + 1;
        r11.d = new kv8.a.C0115a(r28, SystemClock.elapsedRealtime());
        r11.f = null;
        kv8.a.b(r11, "browser_takeover_connect", new JSONObject().put("status", "start"), null, Integer.valueOf(r28), 4);
        goto L28
    L26:
        r27 = 0;
    L55:
        log$default(this, "connect_ignored", "reason=missing_entry", false, 4, null);
    }

    private static final Unit connect$lambda$5$lambda$4(BrowserTakeoverSession r7, int r8, RtcBrowserTransport.Failure r9) {
        Intrinsics.checkNotNullParameter(r9, "reason");
        if (r7.generation != r8) goto L16;
        log$default(r7, "rtc_failure", "reason=" + r9, false, 4, null);
        kv8.a r10 = r7.monitor;
        if (r10 == null) goto L7;
        r10.e("transport", r9.name().toLowerCase(Locale.ROOT));
    L7:
        int r11 = c.a[r9.ordinal()];
        if (r11 != 1) goto L10;
        ErrorReason r12 = ErrorReason.MEDIA_BUSY;
    L14:
        r7.errorReason = r12;
        goto L16
    L10:
        if (r11 == 2) goto L12;
        r12 = ErrorReason.CONNECTION;
        goto L14
    L12:
        r12 = ErrorReason.MESSAGE_TOO_LARGE;
    L16:
        return Unit.INSTANCE;
    }

    private static final Unit connect$lambda$6(BrowserTakeoverSession r2, int r3, LocalPcSignaling.Failure r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        if (r2.generation != r3) goto L13;
        kv8.a r5 = r2.monitor;
        if (r5 != null) goto L7;
    L11:
        r2.fail("signaling_" + r4.name());
        goto L13
    L7:
        if (r4 != LocalPcSignaling.Failure.TIMEOUT) goto L9;
        String r0 = "invite_timeout";
    L10:
        r5.e("invite", r0);
        goto L11
    L9:
        r0 = r4.name().toLowerCase(Locale.ROOT);
    L13:
        return Unit.INSTANCE;
    }

    private final void createClient(BrowserTransport r10, String r11, int r12) {
        kv8.a r0 = this.monitor;
        if (r0 == null) goto L5;
        r0.g("transport");
    L5:
        StringBuilder r1 = new StringBuilder("transport=");
        r1.append(r10.getClass().getSimpleName());
        r1.append(" transportId=");
        r1.append(Integer.toString(System.identityHashCode(r10), CharsKt.checkRadix(16)));
        r1.append(" pageIdPresent=");
        boolean r2 = true;
        if (r11 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        r1.append(!r3);
        log$default(this, "client_create", r1.toString(), false, 4, null);
        jv8.a r4 = this.screencastParameters;
        if (r4 != null) goto L19;
        jv8.b r5 = new jv8.b(0);
        if (r10.c() == BrowserTransport.EndpointMode.BROWSER) goto L18;
        r2 = false;
    L18:
        r4 = r5.a(r2);
    L19:
        BrowserCdpClient r6 = new BrowserCdpClient(r10, new d(this, r12), r4);
        this.client = r6;
        if (r6.w == true) goto L30;
        r6.g();
        r6.G = r11;
        int r13 = r6.g.incrementAndGet();
        r6.J(BrowserCdpClient.State.CONNECTING);
        if (r6.n() == true) goto L25;
    L27:
        r6.a.b(new com.larus.browsertakeover.cdp.a(r13, r6));
        return;
    L25:
        if (r6.y() == true) goto L27;
        r6.j("RTP.pageEndpoint", "initialization_failed");
        return;
    L30:
        return;
    L8:
        if (StringsKt.isBlank(r11) == true) goto L11;
        r3 = false;
        goto L12
    }

    private final void log(String r6, String r7, boolean r8) {
        long r2 = 0;
        if (this.connectStartedAtMs == 0) goto L6;
        r2 = SystemClock.elapsedRealtime() - this.connectStartedAtMs;
    L6:
        String r9 = "session=" + this.logId + " generation=" + this.generation + " event=" + r6 + " elapsedMs=" + r2 + ' ' + r7;
        if (r8 == false) goto L9;
        FLogger.a.d(TAG, r9);
        return;
    L9:
        FLogger.a.i(TAG, r9);
    }

    public static final /* synthetic */ void access$log(BrowserTakeoverSession r0, String r1, String r2, boolean r3) {
        r0.log(r1, r2, r3);
    }

    public static /* synthetic */ void releaseConnection$default(BrowserTakeoverSession r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.releaseConnection(r1);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.larus.browsertakeover.session.e] */
    private static final Unit connect$lambda$5(final BrowserTakeoverSession r7, final int r8, hv8.a r9, hv8.c r10, RoomMeta r11) {
        Intrinsics.checkNotNullParameter(r11, "meta");
        if (r7.generation != r8) goto L5;
        log$default(r7, "http_room_meta_received", "serverExpireTimeMs=" + r11.expireTimeMs + " testDomain=" + r11.useRtcTestDomain, false, 4, null);
        r7.createClient(new RtcBrowserTransport(r11, r9.a, new e(r7, r8)), ((hv8.c.b) r10).c, r8);
    L7:
        return Unit.INSTANCE;
    L5:
        log$default(r7, "http_room_meta_ignored", "callbackGeneration=" + r8, false, 4, null);
        goto L7
    }

    public static /* synthetic */ void log$default(BrowserTakeoverSession r0, String r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = false;
    L8:
        r0.log(r1, r2, r3);
    }
}

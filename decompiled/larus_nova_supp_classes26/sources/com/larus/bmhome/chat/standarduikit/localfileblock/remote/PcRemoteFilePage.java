package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import android.app.Application;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.larus.bmhome.chat.standarduikit.localfileblock.provider.PcLocalFilePreviewProvider;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.service.TaskModeService;
import com.larus.common.apphost.AppHost;
import com.larus.im.internal.jni.bean.DispatchErrorCode;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.platform.service.p1;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0002GHB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u0015J\"\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00112\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0017H\u0002J\u0018\u00104\u001a\u0002022\u0006\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000202H\u0002J\b\u00109\u001a\u000202H\u0002J\u0012\u0010:\u001a\u0002022\b\u0010;\u001a\u0004\u0018\u00010%H\u0002J\u000e\u0010<\u001a\u0002022\u0006\u0010=\u001a\u00020\u001bJ\u0012\u0010>\u001a\u00020+2\b\u0010?\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010@\u001a\u000202H\u0002J\b\u0010A\u001a\u000202H\u0014J\u0014\u0010B\u001a\u00020C2\n\u0010D\u001a\u00060Ej\u0002`FH\u0002R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R!\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b&\u0010'R\u0010\u0010)\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010+0.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/localfileblock/remote/PcRemoteFilePage;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleEventObserver;", "<init>", "()V", "mutableState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/bmhome/chat/standarduikit/localfileblock/remote/PcRemoteFilePage$State;", "kotlin.jvm.PlatformType", "state", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "host", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "conversationId", "", "conversationIdProvider", "Lkotlin/Function0;", "openJob", "Lkotlinx/coroutines/Job;", "pendingRequest", "Lcom/larus/bmhome/chat/standarduikit/localfileblock/remote/PcRemoteFileRequest;", "operationId", "", "deviceListProvider", "Lcom/larus/bmhome/taskskill/service/PcDeviceListProviderInterface;", "getDeviceListProvider", "()Lcom/larus/bmhome/taskskill/service/PcDeviceListProviderInterface;", "deviceListProvider$delegate", "Lkotlin/Lazy;", "deviceCollection", "Lcom/larus/bmhome/taskskill/model/GroupedDeviceCollection;", "getDeviceCollection", "()Landroidx/lifecycle/MutableLiveData;", "deviceCollection$delegate", "deviceRefreshJob", "isObservingDevices", "", "confirmedDeviceAccountId", "deviceOnlineStatuses", "", "isSourceDeviceOffline", "deviceId", "bind", "", "fragment", "onStateChanged", MusicAppletPage.KEY_SOURCE, "event", "Landroidx/lifecycle/Lifecycle$Event;", "startObservingDevices", "stopObservingDevices", "updateDevices", "devices", "open", "request", "canOpen", "expectedConversation", "cancelOpen", "onCleared", "errorMessage", "", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "State", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PcRemoteFilePage extends ViewModel implements LifecycleEventObserver {
    public static final a Companion = null;
    private static final String TAG = "PcRemoteFilePage";
    private String confirmedDeviceAccountId;
    private String conversationId;
    private Function0<String> conversationIdProvider;
    private final Lazy deviceCollection$delegate;
    private final Lazy deviceListProvider$delegate;
    private Map<String, Boolean> deviceOnlineStatuses;
    private Job deviceRefreshJob;
    private WeakReference<Fragment> host;
    private boolean isObservingDevices;
    private final MutableLiveData<b> mutableState;
    private Job openJob;
    private long operationId;
    private LifecycleOwner owner;
    private g pendingRequest;
    private final CoroutineScope scope;
    private final LiveData<b> state;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final g a;
        public final Map<String, String> b;

        public b() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            g r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "State(loading=" + this.a + ", deviceNames=" + this.b + ')';
        }

        public /* synthetic */ b(int r2) {
            this(null, MapsKt.emptyMap());
        }

        public b(g r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r3, "deviceNames");
            this.a = r2;
            this.b = r3;
        }

        public static b a(b r1, g r2, Map r3, int r4) {
            if ((r4 & 1) == 0) goto L6;
            r2 = r1.a;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = r1.b;
        L8:
            Intrinsics.checkNotNullParameter(r3, "deviceNames");
            return new b(r2, r3);
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            r0[Lifecycle.Event.ON_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[Lifecycle.Event.ON_STOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFilePage$open$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFilePage$open$1", f = "PcRemoteFilePage.kt", i = {0, 0, 1, 2, 2, 3, 3}, l = {166, 169, 182, 186}, m = "invokeSuspend", n = {"$this$launch", "preparingPreview", "preparingPreview", ShareType.FILE, "preparingPreview", ShareType.FILE, "preparingPreview"}, s = {"L$0", "I$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $autoOpenTimeoutMs;
        final /* synthetic */ String $expectedAccount;
        final /* synthetic */ String $expectedConversation;
        final /* synthetic */ long $identifier;
        final /* synthetic */ g $request;
        final /* synthetic */ long $triggeredAt;
        int I$0;
        long J$0;
        long J$1;
        long J$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ PcRemoteFilePage this$0;

        public AnonymousClass1(g r1, String r2, long r3, PcRemoteFilePage r5, String r6, long r7, long r9, Continuation<? super AnonymousClass1> r11) {
            this.$request = r1;
            this.$expectedAccount = r2;
            this.$identifier = r3;
            this.this$0 = r5;
            this.$expectedConversation = r6;
            this.$triggeredAt = r7;
            this.$autoOpenTimeoutMs = r9;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
            AnonymousClass1 r12 = new AnonymousClass1(this.$request, this.$expectedAccount, this.$identifier, this.this$0, this.$expectedConversation, this.$triggeredAt, this.$autoOpenTimeoutMs, r15);
            r12.L$0 = r14;
            return r12;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r22) {
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = this.label;
            if (r4 != 0) goto L212;
            String r16 = PcRemoteFilePage.TAG;
            ResultKt.throwOnFailure(r22);
            CoroutineScope r5 = (CoroutineScope) this.L$0;
            PcRemoteFileRepository r6 = PcRemoteFileRepository.a;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L180
            g r7 = this.$request;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L180
            this.L$0 = r5;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L180
            this.I$0 = 0;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L180
            this.label = 1;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L180
            Object r8 = PcRemoteFileRepository.f(r7, this);     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L180
            if (r8 != r3) goto L34;
            return r3;
        L34:
            int r9 = 0;
        L227:
            File r10 = (File) r8;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L178
            if (r10 == null) goto L223;
            String r20 = "stage=file_open_failed preview=";
            Object r11 = r3;
        L105:
            String r2 = r16;
            FlowDriveSdkService r0 = FlowDriveSdkService.a;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L175
            this.L$0 = r10;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L175
            this.L$1 = null;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L175
            this.L$2 = null;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L175
            this.I$0 = 1;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L173
            this.label = 3;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L173
            Object r1 = r0.v(this);     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L173
            if (r1 != r11) goto L111;
            return r11;
        L111:
            r9 = 1;
        L219:
        L143:
            e = e;
        L182:
            FLogger r12 = FLogger.a;     // Catch: Throwable -> L141
            StringBuilder r13 = new StringBuilder(r20);     // Catch: Throwable -> L141
            if (r9 == 0) goto L185;
            boolean r14 = true;
        L186:
            r13.append(r14);     // Catch: Throwable -> L141
            r13.append(" type=");     // Catch: Throwable -> L141
            r13.append(e.getClass().getSimpleName());     // Catch: Throwable -> L141
            r12.w(r2, r13.toString());     // Catch: Throwable -> L141
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L197;
            if (Intrinsics.areEqual(AccountService.a.getUserId(), this.$expectedAccount) == false) goto L197;
            if (PcRemoteFilePage.access$canOpen(this.this$0, this.$expectedConversation) == false) goto L197;
            if (r9 == 0) goto L194;
            int r15 = 2131899914;
        L195:
            s r17 = s.a;     // Catch: Throwable -> L141
            Application r18 = AppHost.a.getApplication();     // Catch: Throwable -> L141
            r17.getClass();     // Catch: Throwable -> L141
            s.b(r18, r15, false);     // Catch: Throwable -> L141
            goto L197
        L194:
            r15 = PcRemoteFilePage.access$errorMessage(this.this$0, e);     // Catch: Throwable -> L141
        L197:
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L203;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            MutableLiveData r19 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            b r21 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r21 != null) goto L201;
            r21 = new b(0);
        L201:
            r19.setValue(b.a(r21, null, null, 2));
            PcRemoteFilePage.access$setOpenJob$p(this.this$0, null);
        L203:
            return Unit.INSTANCE;
        L185:
            r14 = false;
            goto L186
        L113:
            if (((Boolean) r1).booleanValue() == false) goto L172;
            PcRemoteFileRepository r23 = PcRemoteFileRepository.a;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            g r24 = this.$request;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            this.L$0 = r10;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            this.I$0 = r9;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            this.label = 4;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            Object r25 = PcRemoteFileRepository.f(r24, this);     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            if (r25 != r11) goto L118;
            return r11;
        L118:
            if (Intrinsics.areEqual((File) r25, r10) == true) goto L120;
        L163:
            Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L170;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            MutableLiveData r27 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            b r28 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r28 != null) goto L169;
            r28 = new b(0);
        L169:
            r27.setValue(b.a(r28, null, null, 2));
            PcRemoteFilePage.access$setOpenJob$p(this.this$0, null);
        L170:
            return r26;
        L120:
            if (Intrinsics.areEqual(AccountService.a.getUserId(), this.$expectedAccount) == false) goto L163;
            if (this.$identifier == PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L125;
        L155:
            Unit r29 = Unit.INSTANCE;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L162;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            MutableLiveData r30 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            b r31 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r31 != null) goto L161;
            r31 = new b(0);
        L161:
            r30.setValue(b.a(r31, null, null, 2));
            PcRemoteFilePage.access$setOpenJob$p(this.this$0, null);
        L162:
            return r29;
        L125:
            if (PcRemoteFilePage.access$canOpen(this.this$0, this.$expectedConversation) == false) goto L155;
            Fragment r32 = (Fragment) PcRemoteFilePage.access$getHost$p(this.this$0).get();     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            if (r32 == null) goto L147;
            FragmentActivity r33 = r32.getActivity();     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            if (r33 == null) goto L147;
            FlowDriveSdkService r34 = FlowDriveSdkService.a;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            String r35 = r10.getAbsolutePath();     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            String r36 = r10.getName();     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            int r37 = PcLocalFilePreviewProvider.a;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            if (r34.s(r33, r35, r36, PcLocalFilePreviewProvider.a.a(r33)) == false) goto L140;
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L203;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            r19 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            r21 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r21 != null) goto L201;
            r21 = new b(0);
            goto L201
        L140:
            throw new IllegalStateException("local_preview_open_failed");     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
        L147:
            Unit r38 = Unit.INSTANCE;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L154;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            MutableLiveData r39 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            b r40 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r40 != null) goto L153;
            r40 = new b(0);
        L153:
            r39.setValue(b.a(r40, null, null, 2));
            PcRemoteFilePage.access$setOpenJob$p(this.this$0, null);
        L154:
            return r38;
        L172:
            throw new IllegalStateException("local_preview_unavailable");     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
        L173:
            e = e;
        L177:
            r9 = 1;
        L175:
            e = e;
            goto L177
        L223:
            PcRemoteFilePage r110 = this.this$0;     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            g r41 = this.$request;     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            long r111 = this.$triggeredAt;     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            long r112 = this.$identifier;     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            long r42 = this.$autoOpenTimeoutMs;     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            String r43 = this.$expectedAccount;     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            String r44 = this.$expectedConversation;     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            MutableLiveData r45 = PcRemoteFilePage.access$getMutableState$p(r110);     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            b r113 = (b) PcRemoteFilePage.access$getMutableState$p(r110).getValue();     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            if (r113 != null) goto L46;
            r20 = "stage=file_open_failed preview=";
            b r46 = new b(0);     // Catch: Exception -> L43 Throwable -> L141 CancellationException -> L145
        L229:
            r45.setValue(b.a(r46, r41, null, 2));     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            PcRemoteFileRepository r47 = PcRemoteFileRepository.a;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            this.L$0 = r110;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            this.L$1 = r43;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            this.L$2 = r44;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            this.I$0 = r9;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            this.J$0 = r111;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            this.J$1 = r112;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            this.J$2 = r42;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            this.label = 2;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            Object r48 = r47.j(r41, this);     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            r11 = r3;
            if (r48 != r11) goto L52;
            return r11;
        L52:
            long r114 = r112;
            long r115 = r42;
            String r116 = r43;
        L233:
            r10 = (File) r48;     // Catch: Exception -> L95 Throwable -> L141 CancellationException -> L145
            long r49 = SystemClock.elapsedRealtime() - r111;     // Catch: Exception -> L95 Throwable -> L141 CancellationException -> L145
            if (r114 == PcRemoteFilePage.access$getOperationId$p(r110)) goto L63;
            Unit r50 = Unit.INSTANCE;     // Catch: Exception -> L95 Throwable -> L141 CancellationException -> L145
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L62;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            MutableLiveData r51 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            b r52 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r52 != null) goto L61;
            r52 = new b(0);
        L61:
            r51.setValue(b.a(r52, null, null, 2));
            PcRemoteFilePage.access$setOpenJob$p(this.this$0, null);
        L62:
            return r50;
        L63:
            MutableLiveData r53 = PcRemoteFilePage.access$getMutableState$p(r110);     // Catch: Exception -> L95 Throwable -> L141 CancellationException -> L145
            b r117 = (b) PcRemoteFilePage.access$getMutableState$p(r110).getValue();     // Catch: Exception -> L95 Throwable -> L141 CancellationException -> L145
            if (r117 != null) goto L66;
            r117 = new b(0);     // Catch: Exception -> L95 Throwable -> L141 CancellationException -> L145
        L66:
            r53.setValue(b.a(r117, null, null, 2));     // Catch: Exception -> L95 Throwable -> L141 CancellationException -> L145
            if (r115 <= 0) goto L84;
            if (r49 > r115) goto L84;
            if (Intrinsics.areEqual(AccountService.a.getUserId(), r116) == true) goto L74;
        L75:
            Unit r54 = Unit.INSTANCE;     // Catch: Exception -> L95 Throwable -> L141 CancellationException -> L145
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L82;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            MutableLiveData r55 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            b r56 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r56 != null) goto L81;
            r56 = new b(0);
        L81:
            r55.setValue(b.a(r56, null, null, 2));
            PcRemoteFilePage.access$setOpenJob$p(this.this$0, null);
        L82:
            return r54;
        L74:
            if (PcRemoteFilePage.access$canOpen(r110, r44) == true) goto L105;
        L84:
            r2 = r16;
            FLogger.a.i(r2, "stage=auto_open_skipped elapsed_ms=" + r49 + " timeout_ms=" + r115);     // Catch: Exception -> L93 Throwable -> L141 CancellationException -> L145
            Unit r57 = Unit.INSTANCE;     // Catch: Exception -> L93 Throwable -> L141 CancellationException -> L145
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L92;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            MutableLiveData r58 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            b r59 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r59 != null) goto L91;
            r59 = new b(0);
        L91:
            r58.setValue(b.a(r59, null, null, 2));
            PcRemoteFilePage.access$setOpenJob$p(this.this$0, null);
        L92:
            return r57;
        L93:
            e = e;
        L101:
            int r60 = r9;
        L102:
            r9 = r60;
        L95:
            e = e;
        L45:
            r2 = r16;
        L97:
            e = e;
        L43:
            e = e;
            r60 = r9;
        L29:
            r2 = r16;
            goto L102
        L46:
            r20 = "stage=file_open_failed preview=";
            r46 = r113;
        L99:
            e = e;
            r20 = "stage=file_open_failed preview=";
        L178:
            e = e;
            r20 = "stage=file_open_failed preview=";
            r2 = r16;
        L180:
            e = e;
            r20 = "stage=file_open_failed preview=";
            r2 = r16;
            r9 = 0;
            goto L182
        L212:
            if (r4 == 1) goto L23;
            if (r4 == 2) goto L20;
            if (r4 == 3) goto L15;
            if (r4 != 4) goto L14;
            r60 = this.I$0;
            File r61 = (File) this.L$0;
            ResultKt.throwOnFailure(r22);     // Catch: Exception -> L11 Throwable -> L141 CancellationException -> L145
            r10 = r61;
            r25 = r22;
        L11:
            e = e;
            r20 = "stage=file_open_failed preview=";
            r2 = PcRemoteFilePage.TAG;
            goto L102
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            int r62 = this.I$0;
            File r63 = (File) this.L$0;
            ResultKt.throwOnFailure(r22);     // Catch: Exception -> L18 Throwable -> L141 CancellationException -> L145
            r20 = "stage=file_open_failed preview=";
            r11 = r3;
            r9 = r62;
            r2 = PcRemoteFilePage.TAG;
            r10 = r63;
            r1 = r22;
        L18:
            e = e;
            r60 = r62;
            r16 = PcRemoteFilePage.TAG;
        L28:
            r20 = "stage=file_open_failed preview=";
            goto L29
        L20:
            long r118 = this.J$2;
            long r119 = this.J$1;
            r16 = PcRemoteFilePage.TAG;
            long r64 = this.J$0;
            int r65 = this.I$0;
            r44 = (String) this.L$2;
            r116 = (String) this.L$1;
            r110 = (PcRemoteFilePage) this.L$0;
            ResultKt.throwOnFailure(r22);     // Catch: Exception -> L26 Throwable -> L141 CancellationException -> L145
            r20 = "stage=file_open_failed preview=";
            r11 = r3;
            r114 = r119;
            r48 = r22;
            r115 = r118;
            r111 = r64;
            r9 = r65;
            goto L233
        L23:
            r16 = PcRemoteFilePage.TAG;
            int r66 = this.I$0;
            CoroutineScope r67 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r22);     // Catch: Exception -> L26 Throwable -> L141 CancellationException -> L145
            r9 = r66;
            r8 = r22;
        L26:
            e = e;
            r60 = r4;
        L145:
            e = move-exception;
            throw e;     // Catch: Throwable -> L141
        L141:
            th = move-exception;
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L211;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            MutableLiveData r68 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            b r69 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r69 != null) goto L210;
            r69 = new b(0);
        L210:
            r68.setValue(b.a(r69, null, null, 2));
            PcRemoteFilePage.access$setOpenJob$p(this.this$0, null);
        L211:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFilePage$startObservingDevices$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFilePage$startObservingDevices$1", f = "PcRemoteFilePage.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $accountId;
        int label;
        final /* synthetic */ PcRemoteFilePage this$0;

        public C01461(PcRemoteFilePage r1, String r2, Continuation<? super C01461> r3) {
            this.this$0 = r1;
            this.$accountId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01461(this.this$0, this.$accountId, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L13;
            if (r1 != 1) goto L12;
            ResultKt.throwOnFailure(r5);     // Catch: Exception -> L7 CancellationException -> L9
        L17:
            bs8.f r6 = (bs8.f) r5;     // Catch: Exception -> L7 CancellationException -> L9
            if (Intrinsics.areEqual(this.$accountId, AccountService.a.getUserId()) == true) goto L22;
            return Unit.INSTANCE;
        L22:
            if (r6.b == false) goto L28;
            PcRemoteFilePage r2 = this.this$0;     // Catch: Exception -> L7 CancellationException -> L9
            String r3 = this.$accountId;     // Catch: Exception -> L7 CancellationException -> L9
            if ((true ^ StringsKt.isBlank(r3)) == true) goto L27;
            r3 = null;
        L27:
            PcRemoteFilePage.access$setConfirmedDeviceAccountId$p(r2, r3);     // Catch: Exception -> L7 CancellationException -> L9
        L28:
            PcRemoteFilePage.access$updateDevices(this.this$0, r6.a);     // Catch: Exception -> L7 CancellationException -> L9
        L32:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            ResultKt.throwOnFailure(r5);
            com.larus.bmhome.taskskill.service.d r7 = PcRemoteFilePage.access$getDeviceListProvider(this.this$0);     // Catch: Exception -> L7 CancellationException -> L9
            this.label = 1;     // Catch: Exception -> L7 CancellationException -> L9
            r5 = r7.a(this);     // Catch: Exception -> L7 CancellationException -> L9
            if (r5 != r0) goto L17;
            return r0;
        L9:
            e = move-exception;
            throw e;
        L7:
            e = move-exception;
            FLogger.a.w(PcRemoteFilePage.TAG, "stage=device_names_failed type=".concat(e.getClass().getSimpleName()));
            goto L32
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ com.larus.bmhome.taskskill.service.d Mo() {
        return deviceListProvider_delegate$lambda$0();
    }

    public static /* synthetic */ MutableLiveData No(PcRemoteFilePage r0) {
        return deviceCollection_delegate$lambda$1(r0);
    }

    public static /* synthetic */ Unit yo(PcRemoteFilePage r0, bs8.e r1) {
        return bind$lambda$4$lambda$3(r0, r1);
    }

    private final void cancelOpen() {
        this.operationId++;
        Job r0 = this.openJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.openJob = null;
        this.pendingRequest = null;
        MutableLiveData<b> r1 = this.mutableState;
        b r2 = (b) r1.getValue();
        if (r2 != null) goto L8;
        r2 = new b(0);
    L8:
        r1.setValue(b.a(r2, null, null, 2));
    }

    private static final com.larus.bmhome.taskskill.service.d deviceListProvider_delegate$lambda$0() {
        return TaskModeService.a.d();
    }

    private final MutableLiveData<bs8.e> getDeviceCollection() {
        return (MutableLiveData) this.deviceCollection$delegate.getValue();
    }

    private final com.larus.bmhome.taskskill.service.d getDeviceListProvider() {
        return (com.larus.bmhome.taskskill.service.d) this.deviceListProvider$delegate.getValue();
    }

    private final void startObservingDevices() {
        if (this.isObservingDevices == false) goto L5;
        return;
    L5:
        this.isObservingDevices = true;
        getDeviceListProvider().f();
        updateDevices(getDeviceListProvider().b());
        String r0 = AccountService.a.getUserId();
        this.deviceRefreshJob = BuildersKt.launch$default(this.scope, null, null, new C01461(this, r0, null), 3, null);
    }

    private final void stopObservingDevices() {
        if (this.isObservingDevices == true) goto L5;
        return;
    L5:
        this.isObservingDevices = false;
        Job r0 = this.deviceRefreshJob;
        if (r0 == null) goto L8;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L8:
        this.deviceRefreshJob = null;
        getDeviceListProvider().e();
    }

    public PcRemoteFilePage() {
        MutableLiveData<b> r0 = new MutableLiveData(new b(0));
        this.mutableState = r0;
        this.state = r0;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.host = new WeakReference(null);
        this.deviceListProvider$delegate = LazyKt.lazy(new com.larus.bmhome.chat.standarduikit.localfileblock.remote.a());
        this.deviceCollection$delegate = LazyKt.lazy(new com.larus.bmhome.chat.standarduikit.localfileblock.remote.b(this));
        this.deviceOnlineStatuses = MapsKt.emptyMap();
    }

    public void onCleared() {
        cancelOpen();
        stopObservingDevices();
        LifecycleOwner r0 = this.owner;
        if (r0 == null) goto L5;
        r0.getLifecycle().removeObserver(this);
        getDeviceCollection().removeObservers(r0);
    L5:
        this.owner = null;
        this.host.clear();
        this.conversationIdProvider = null;
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }

    public final LiveData<b> getState() {
        return this.state;
    }

    public static final /* synthetic */ com.larus.bmhome.taskskill.service.d access$getDeviceListProvider(PcRemoteFilePage r0) {
        return r0.getDeviceListProvider();
    }

    public static final /* synthetic */ WeakReference access$getHost$p(PcRemoteFilePage r0) {
        return r0.host;
    }

    public static final /* synthetic */ MutableLiveData access$getMutableState$p(PcRemoteFilePage r0) {
        return r0.mutableState;
    }

    public static final /* synthetic */ long access$getOperationId$p(PcRemoteFilePage r2) {
        return r2.operationId;
    }

    private final boolean canOpen(String r5) {
        Fragment r0 = this.host.get();
        if (r0 != null) goto L5;
        return false;
    L5:
        FragmentActivity r2 = r0.getActivity();
        if (r2 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.conversationId, r5) == false) goto L48;
        Function0<String> r3 = this.conversationIdProvider;
        if (r3 == null) goto L13;
        String r4 = (String) r3.invoke();
    L15:
        if (Intrinsics.areEqual(r4, r5) == true) goto L17;
        return false;
    L17:
        if (r0.isAdded() == true) goto L19;
        return false;
    L19:
        if (r0.isRemoving() == false) goto L21;
        return false;
    L21:
        if (r0.isHidden() == false) goto L23;
        return false;
    L23:
        if (r0.isVisible() == true) goto L25;
        return false;
    L25:
        if (r2.isFinishing() == false) goto L27;
        return false;
    L27:
        if (r2.isDestroyed() == true) goto L55;
        LifecycleOwner r6 = this.owner;
        if (r6 == null) goto L37;
        Lifecycle r7 = r6.getLifecycle();
        if (r7 == null) goto L37;
        Lifecycle.State r8 = r7.getCurrentState();
        if (r8 == null) goto L37;
        if (r8.isAtLeast(Lifecycle.State.RESUMED) != true) goto L37;
        boolean r9 = true;
    L38:
        if (r9 == false) goto L56;
        View r10 = r0.getView();
        if (r10 != null) goto L42;
    L44:
        boolean r11 = false;
    L45:
        if (r11 == false) goto L57;
        return true;
    L57:
        return false;
    L42:
        if (r10.hasWindowFocus() != true) goto L44;
        r11 = true;
        goto L45
    L56:
        return false;
    L37:
        r9 = false;
        goto L38
    L55:
        return false;
    L13:
        r4 = null;
        goto L15
    L48:
        return false;
    }

    private static final MutableLiveData deviceCollection_delegate$lambda$1(PcRemoteFilePage r0) {
        return r0.getDeviceListProvider().d();
    }

    private final int errorMessage(Exception r7) {
        Integer r1 = null;
        if ((r7 instanceof PcRemoteFileException) == false) goto L5;
        PcRemoteFileException r8 = (PcRemoteFileException) r7;
    L6:
        if (r8 == null) goto L8;
        PcRemoteFileError r0 = r8.getKind();
    L10:
        if (r0 != PcRemoteFileError.DOWNLOAD_FAILED) goto L12;
        return 2131909776;
    L12:
        if (r8 == null) goto L14;
        PcRemoteFileError r2 = r8.getKind();
    L16:
        if (r2 == PcRemoteFileError.FILE_NOT_FOUND) goto L65;
        boolean r3 = true;
        if (r8 == null) goto L25;
        Integer r4 = r8.getCode();
        if (r4 == null) goto L25;
        if (r4.intValue() != 11) goto L25;
        boolean r5 = true;
    L26:
        if (r5 == true) goto L65;
        Set r6 = SetsKt.setOf(new Integer[]{2, 6, 10});
        if (r8 == null) goto L32;
        r1 = r8.getCode();
    L32:
        if (CollectionsKt.contains(r6, r1) == false) goto L34;
        return 2131908292;
    L34:
        if (r8 == null) goto L41;
        Integer r9 = r8.getCode();
        if (r9 == null) goto L41;
        if (r9.intValue() != 7) goto L41;
        boolean r10 = true;
    L42:
        if (r10 == false) goto L44;
        return 2131908291;
    L44:
        if (r8 == null) goto L51;
        Integer r11 = r8.getCode();
        int r12 = DispatchErrorCode.DISPATCH_ERROR_CODE_UNSUPPORTED_FILE_TYPE.value;
        if (r11 == null) goto L51;
        if (r11.intValue() != r12) goto L51;
        boolean r13 = true;
    L52:
        if (r13 == false) goto L54;
        return 2131908294;
    L54:
        if (r8 == null) goto L61;
        Integer r14 = r8.getCode();
        if (r14 == null) goto L61;
        if (r14.intValue() != 14) goto L61;
    L62:
        if (r3 == false) goto L64;
        return 2131908293;
    L64:
        return 2131908289;
    L61:
        r3 = false;
    L51:
        r13 = false;
    L41:
        r10 = false;
    L25:
        r5 = false;
    L65:
        return 2131908290;
    L14:
        r2 = null;
        goto L16
    L8:
        r0 = null;
        goto L10
    L5:
        r8 = null;
        goto L6
    }

    private final void updateDevices(bs8.e r8) {
        if (r8 == null) goto L5;
        List<PcDevice> r1 = r8.a();
    L6:
        if (r1 != null) goto L8;
        r1 = CollectionsKt.emptyList();
    L8:
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L10:
        if (r3.hasNext() == false) goto L23;
        PcDevice r4 = (PcDevice) r3.next();
        String r5 = r4.getDeviceId();
        if (r5 != null) goto L14;
    L20:
        Pair r6 = null;
    L21:
        if (r6 == null) goto L10;
        r2.add(r6);
        goto L10
    L14:
        if ((true ^ StringsKt.isBlank(r5)) == true) goto L17;
        r5 = null;
    L17:
        if (r5 == null) goto L20;
        r6 = TuplesKt.to(r5, r4.r());
        goto L21
    L23:
        this.deviceOnlineStatuses = MapsKt.toMap(r2);
        if (r8 == null) goto L26;
        List<PcDevice> r9 = r8.a();
    L27:
        if (r9 != null) goto L29;
        r9 = CollectionsKt.emptyList();
    L29:
        ArrayList r7 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L30:
        int r11 = 0;
        if (r10.hasNext() == false) goto L56;
        PcDevice r12 = (PcDevice) r10.next();
        String r13 = r12.getDeviceId();
        if (r13 != null) goto L35;
    L53:
        Pair r14 = null;
    L54:
        if (r14 == null) goto L30;
        r7.add(r14);
        goto L30
    L35:
        if ((!StringsKt.isBlank(r13)) == true) goto L38;
        r13 = null;
    L38:
        if (r13 == null) goto L53;
        String r15 = r12.d();
        if (r15 == null) goto L53;
        String r16 = StringsKt.trim(r15).toString();
        if (r16 == null) goto L53;
        if (r16.length() <= 0) goto L47;
        r11 = 1;
    L47:
        if (r11 != 0) goto L50;
        r16 = null;
    L50:
        if (r16 == null) goto L53;
        r14 = TuplesKt.to(r13, r16);
        goto L54
    L56:
        Map r17 = MapsKt.toMap(r7);
        b r18 = (b) this.mutableState.getValue();
        if (r18 != null) goto L60;
        r18 = new b(r11);
    L60:
        if (Intrinsics.areEqual(r18.b, r17) == true) goto L73;
        this.mutableState.setValue(b.a(r18, null, r17, 1));
        return;
    L73:
        return;
    L26:
        r9 = null;
        goto L27
    L5:
        r1 = null;
        goto L6
    }

    public final boolean isSourceDeviceOffline(String r3) {
        Intrinsics.checkNotNullParameter(r3, "deviceId");
        String r0 = this.confirmedDeviceAccountId;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(r0, AccountService.a.getUserId()) == false) goto L9;
        if (Intrinsics.areEqual(this.deviceOnlineStatuses.get(r3), Boolean.FALSE) == false) goto L9;
        return true;
    }

    public final void open(g r20) {
        Intrinsics.checkNotNullParameter(r20, "request");
        if (FlowDriveSdkService.a.o() == true) goto L6;
        s r0 = s.a;
        Application r1 = AppHost.a.getApplication();
        r0.getClass();
        s.s(r1, 2131908287);
        return;
    L6:
        g r2 = this.pendingRequest;
        boolean r3 = true;
        if (r2 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L24;
        b r5 = (b) this.mutableState.getValue();
        if (r5 == null) goto L20;
        g r6 = r5.a;
        if (r6 == null) goto L20;
        if (d.a(r6, r20) != true) goto L20;
    L21:
        if (r3 == false) goto L29;
        s r7 = s.a;
        Application r8 = AppHost.a.getApplication();
        r7.getClass();
        s.s(r8, 2131908288);
        return;
    L29:
        return;
    L20:
        r3 = false;
        goto L21
    L24:
        String r9 = this.conversationId;
        String r10 = AccountService.a.getUserId();
        if (canOpen(r9) == true) goto L27;
        return;
    L27:
        long r11 = SystemClock.elapsedRealtime();
        long r12 = 1000 * ((long) RangesKt.coerceAtLeast(p1.a.remoteFileAutoOpenTimeoutSeconds(), 0));
        cancelOpen();
        long r13 = this.operationId;
        this.pendingRequest = r20;
        this.openJob = BuildersKt.launch$default(this.scope, null, null, new AnonymousClass1(r20, r10, r13, this, r9, r11, r12, null), 3, null);
        return;
    L9:
        if (d.a(r2, r20) != true) goto L11;
        r4 = true;
        goto L12
    }

    public static final /* synthetic */ boolean access$canOpen(PcRemoteFilePage r0, String r1) {
        return r0.canOpen(r1);
    }

    public static final /* synthetic */ int access$errorMessage(PcRemoteFilePage r0, Exception r1) {
        return r0.errorMessage(r1);
    }

    public static final /* synthetic */ void access$setConfirmedDeviceAccountId$p(PcRemoteFilePage r0, String r1) {
        r0.confirmedDeviceAccountId = r1;
    }

    public static final /* synthetic */ void access$setOpenJob$p(PcRemoteFilePage r0, Job r1) {
        r0.openJob = r1;
    }

    public static final /* synthetic */ void access$setPendingRequest$p(PcRemoteFilePage r0, g r1) {
        r0.pendingRequest = r1;
    }

    public static final /* synthetic */ void access$updateDevices(PcRemoteFilePage r0, bs8.e r1) {
        r0.updateDevices(r1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.standarduikit.localfileblock.remote.c] */
    private final void bind(Fragment r4, Function0<String> r5) {
        if (r5 == null) goto L5;
        String r1 = (String) r5.invoke();
    L7:
        if (Intrinsics.areEqual(this.conversationId, r1) == true) goto L9;
        cancelOpen();
    L9:
        this.conversationId = r1;
        this.conversationIdProvider = r5;
        this.host = new WeakReference(r4);
        LifecycleOwner r6 = (LifecycleOwner) r4.getViewLifecycleOwnerLiveData().getValue();
        if (this.owner == r6) goto L18;
        cancelOpen();
        stopObservingDevices();
        this.confirmedDeviceAccountId = null;
        LifecycleOwner r7 = this.owner;
        if (r7 == null) goto L14;
        r7.getLifecycle().removeObserver(this);
        getDeviceCollection().removeObservers(r7);
    L14:
        this.owner = r6;
        if (r6 == null) goto L19;
        getDeviceCollection().observe(r6, new d.a(new com.larus.bmhome.chat.standarduikit.localfileblock.remote.c(this)));
        r6.getLifecycle().addObserver(this);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r1 = null;
        goto L7
    }

    private static final Unit bind$lambda$4$lambda$3(PcRemoteFilePage r0, bs8.e r1) {
        r0.updateDevices(r1);
        return Unit.INSTANCE;
    }

    public void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, MusicAppletPage.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r3, "event");
        int r4 = c.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        startObservingDevices();
        return;
    L5:
        if (r4 != 2) goto L7;
        cancelOpen();
        return;
    L7:
        if (r4 != 3) goto L9;
    L11:
        cancelOpen();
        stopObservingDevices();
        return;
    L9:
        if (r4 == 4) goto L11;
    }

    public static final /* synthetic */ void access$bind(PcRemoteFilePage r0, Fragment r1, Function0 r2) {
        r0.bind(r1, r2);
    }
}

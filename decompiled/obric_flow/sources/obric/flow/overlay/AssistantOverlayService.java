package obric.flow.overlay;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.obric.flow.R$mipmap;
import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.p;
import com.obric.flow.cardlistpage.util.g;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lobric/flow/overlay/AssistantOverlayService;", "Landroid/app/Service;", "<init>", "()V", "obric/flow/overlay/b", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AssistantOverlayService extends Service {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f20527h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindowManager f20528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CardFeedLayout f20529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WindowManager.LayoutParams f20530c;
    public final kotlinx.coroutines.internal.c d;
    public Job e;
    public b f;
    public int g;

    /* JADX INFO: renamed from: obric.flow.overlay.AssistantOverlayService$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "obric.flow.overlay.AssistantOverlayService$onCreate$1", f = "AssistantOverlayService.kt", i = {}, l = {554}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AssistantOverlayService this$0;

        public AnonymousClass1(AssistantOverlayService r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new AnonymousClass1(this.this$0, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            kotlinx.coroutines.flow.b r12 = g.b(this.this$0.getApplicationContext());
            c r13 = new c(this.this$0);
            this.label = 1;
            if (r12.collect(r13, this) != r10) goto L12;
            return r10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public AssistantOverlayService() {
        this.d = h0.a(CoroutineContext.Element.DefaultImpls.plus(j0.b(), Dispatchers.getMain().getImmediate()));
    }

    public static final void a(AssistantOverlayService r10, Function1 r11) {
        r10.getClass();
        boolean r5 = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
        kotlinx.coroutines.internal.c r12 = r10.d;
        if (r5 == false) goto L5;
        BuildersKt.launch$default(r12, Dispatchers.getMain().getImmediate(), null, new AssistantOverlayService$runOnMain$1(r11, null), 2, null);
        return;
    L5:
        BuildersKt.launch$default(r12, null, null, new AssistantOverlayService$runOnMain$2(r11, null), 3, null);
    }

    public static void b(AssistantOverlayService r5, int r10, int r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = 0;
    L8:
        CardFeedLayout r13 = r5.f20529b;
        if (r13 == null) goto L26;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        WindowManager r15 = null;
        if ((r14 instanceof WindowManager.LayoutParams) == false) goto L14;
        WindowManager.LayoutParams r16 = (WindowManager.LayoutParams) r14;
    L15:
        if (r16 == null) goto L27;
        int r17 = r16.flags;
        int r18 = (r10 | r17) & (~r11);
        if (r17 == r18) goto L28;
        r16.flags = r18;
        WindowManager r19 = r5.f20528a;
        if (r19 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("windowManager");
    L24:
        r15.updateViewLayout(r13, r16);
        return;
    L23:
        r15 = r19;
        goto L24
    L28:
        return;
    L27:
        return;
    L14:
        r16 = null;
        goto L15
    }

    public final Notification c() {
        PendingIntent r5 = PendingIntent.getActivity(this, 0, new Intent(this, AssistantOverlayService.class), AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        Notification r10 = new NotificationCompat.Builder(this, "ObricFlowServiceChannel").setContentTitle("").setContentText("").setSmallIcon(R$mipmap.ic_obric_flow).setPriority(0).setContentIntent(r5).setForegroundServiceBehavior(1).build();
        r10.extras.putBoolean("obric_foreground_notification_show", false);
        return r10;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r5) {
        Intrinsics.checkNotNullParameter(r5, "intent");
        b r10 = this.f;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binder");
        return null;
    L6:
        return r10;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter("onCreate", "msg");
        org.koin.core.a r5 = su.a.f22013b;
        if (r5 == null) goto L10;
        ((ju.b) r5.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("AssistantOverlayService", "onCreate");
        NotificationChannel r10 = new NotificationChannel("ObricFlowServiceChannel", "ObricFlow Service Channel", 3);
        NotificationManager r11 = (NotificationManager) getSystemService(NotificationManager.class);
        if (r11 == null) goto L7;
        r11.createNotificationChannel(r10);
    L7:
        Object r12 = getSystemService("window");
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.view.WindowManager");
        this.f20528a = (WindowManager) r12;
        this.g = getResources().getDisplayMetrics().widthPixels;
        this.f = new b(this);
        z r13 = Dispatchers.getDefault();
        AnonymousClass1 r14 = new AnonymousClass1(this, null);
        this.e = BuildersKt.launch$default(this.d, r13, null, r14, 2, null);
        return;
    L10:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // android.app.Service
    public final void onDestroy() {
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter("onDestroy", "msg");
        org.koin.core.a r5 = su.a.f22013b;
        if (r5 == null) goto L38;
        ((ju.b) r5.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("AssistantOverlayService", "onDestroy");
        CardFeedLayout r10 = this.f20529b;
        if (r10 == null) goto L10;
        p r11 = r10.G;
        if (r11 == null) goto L9;
        r11.f(com.obric.flow.cardlistpage.ui.component.overlayanimator.a.f11644a);
        r11.e.clear();
    L9:
        r10.G = null;
        r10.F = null;
    L10:
        h0.c(this.d, null);
        b r12 = this.f;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binder");
        r12 = null;
    L13:
        bb.b r13 = r12.d;
        r13.removeMessages(100);
        r13.removeCallbacksAndMessages(null);
        cq.c r14 = r12.f20534c;
        if (r14 == null) goto L16;
        IBinder r15 = r14.f16499a;
    L17:
        if (r15 != null) goto L42;
    L19:
        r12.f20534c = null;
        CardFeedLayout r16 = this.f20529b;
        if (r16 != null) goto L40;
    L35:
        this.f20529b = null;
        super.onDestroy();
        Process.killProcess(Process.myPid());
        return;
    L40:
    L26:
        e = move-exception;
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter("Error removing view", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r17 = su.a.f22013b;
        if (r17 == null) goto L34;
        ((ju.b) r17.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("AssistantOverlayService", "Error removing view", e);
        goto L35
    L34:
        throw new IllegalStateException("KoinApplication has not been started");
    L22:
        if (r16.isAttachedToWindow() == false) goto L35;
        WindowManager r18 = this.f20528a;     // Catch: Exception -> L26
        if (r18 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("windowManager");     // Catch: Exception -> L26
        r18 = null;
    L28:
        r18.removeViewImmediate(r16);     // Catch: Exception -> L26
        goto L35
    L42:
        r15.unlinkToDeath(r12.e, 0);     // Catch: NoSuchElementException -> L39
        goto L19
    L16:
        r15 = null;
        goto L17
    L38:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r5, int r10, int r11) {
        ju.a r12 = ju.a.f18481a;
        r12.i("AssistantOverlayService", "onStartCommand intent: " + r5 + "  flags: " + r10);
        startForeground(1001, c(), 1);     // Catch: Exception -> L5
        r12.d("AssistantOverlayService", " startForeground success");     // Catch: Exception -> L5
    L9:
        return 1;
    L5:
        e = move-exception;
        String r13 = " startForeground Exception  message:  " + e.getMessage();
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter(r13, "msg");
        org.koin.core.a r14 = su.a.f22013b;
        if (r14 == null) goto L11;
        ((ju.b) r14.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("AssistantOverlayService", r13);
        goto L9
    L11:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    public final void onTimeout(int r11, int r12) {
        super.onTimeout(r11, r12);
        String r5 = ai.j0.f(r11, r12, "onTimeout startId: ", " fgsType: ");
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        org.koin.core.a r10 = su.a.f22013b;
        if (r10 == null) goto L28;
        ((ju.b) r10.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("AssistantOverlayService", r5);
        if (Build.VERSION.SDK_INT >= 35) goto L7;
        return;
    L7:
        if ((r12 & 1) == 0) goto L34;
        stopForeground(1);     // Catch: Exception -> L11
    L29:
        stopSelf(r11);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter("stopSelf on timeout failed", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r13 = su.a.f22013b;
        if (r13 == null) goto L23;
        ((ju.b) r13.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("AssistantOverlayService", "stopSelf on timeout failed", e);
        return;
    L23:
        throw new IllegalStateException("KoinApplication has not been started");
    L11:
        e = move-exception;
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter("stopForeground on timeout failed", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r14 = su.a.f22013b;
        if (r14 == null) goto L25;
        ((ju.b) r14.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("AssistantOverlayService", "stopForeground on timeout failed", e);
        goto L29
    L25:
        throw new IllegalStateException("KoinApplication has not been started");
    L34:
        return;
    L28:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent r5) {
        stopForeground(1);
        stopSelf();
        return super.onUnbind(r5);
    }
}

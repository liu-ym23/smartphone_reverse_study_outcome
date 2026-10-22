package com.bytedance.ai.applet.render.core.camera;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.camera.core.ImageCapture;
import androidx.camera.video.Recording;
import androidx.camera.view.PreviewView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.byted.cast.sink.api.CastInfo;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 y2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001yB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010P\u001a\u00020QH\u0016J\u0018\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u0018H\u0016J\u0018\u0010V\u001a\u00020Q2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u0018H\u0016J\u0014\u0010W\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010JH\u0014J\b\u0010X\u001a\u00020QH\u0002J\b\u0010Y\u001a\u00020QH\u0002J\u0012\u0010Z\u001a\u00020Q2\b\u0010[\u001a\u0004\u0018\u00010\u0018H\u0007J\b\u0010\\\u001a\u00020QH\u0016J\b\u0010]\u001a\u00020QH\u0016J\u0010\u0010^\u001a\u00020Q2\u0006\u0010_\u001a\u00020\u0011H\u0002J\b\u0010`\u001a\u00020QH\u0002J\b\u0010a\u001a\u00020QH\u0002J\b\u0010b\u001a\u00020QH\u0016J\b\u0010c\u001a\u00020QH\u0016J\b\u0010d\u001a\u00020QH\u0002J\b\u0010e\u001a\u00020fH\u0002J\b\u0010g\u001a\u00020.H\u0002J\u001c\u0010h\u001a\u00020Q2\u0006\u0010i\u001a\u00020j2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010?H\u0007J\u001c\u0010l\u001a\u00020Q2\u0006\u0010i\u001a\u00020j2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010?H\u0007J\u001c\u0010m\u001a\u00020Q2\u0006\u0010i\u001a\u00020j2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010?H\u0007J\u001c\u0010n\u001a\u00020Q2\u0006\u0010i\u001a\u00020j2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010?H\u0007J\b\u0010o\u001a\u00020QH\u0016J\b\u0010p\u001a\u00020QH\u0002J\u0012\u0010q\u001a\u00020.2\b\b\u0002\u0010_\u001a\u00020\u0011H\u0002J\b\u0010r\u001a\u00020TH\u0002J\n\u0010s\u001a\u0004\u0018\u00010tH\u0002J\u0018\u0010u\u001a\u00020Q2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u0018H\u0002J\u001a\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\u00182\b\b\u0002\u0010S\u001a\u00020TH\u0002R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0004\n\u0002\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010@\u001a\u0004\u0018\u00010*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0016\u0010C\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010\fR\u001c\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0013R\"\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u001aR\u0016\u0010I\u001a\u0004\u0018\u00010J8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0016\u0010M\u001a\u0004\u0018\u0001068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006z"}, d2 = {"Lcom/bytedance/ai/applet/render/core/camera/LynxCameraUI;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ai/applet/render/core/camera/CameraSessionClient;", "Lcom/lynx/tasm/behavior/ForegroundListener;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "tempDirectory", "Ljava/io/File;", "getTempDirectory", "()Ljava/io/File;", "setTempDirectory", "(Ljava/io/File;)V", "availableQuota", "Lkotlin/Function0;", "", "getAvailableQuota", "()Lkotlin/jvm/functions/Function0;", "setAvailableQuota", "(Lkotlin/jvm/functions/Function0;)V", "toVirtualPath", "Lkotlin/Function1;", "", "getToVirtualPath", "()Lkotlin/jvm/functions/Function1;", "setToVirtualPath", "(Lkotlin/jvm/functions/Function1;)V", "authorizer", "Lcom/bytedance/ai/applet/render/core/camera/CameraAuthorizer;", "getAuthorizer", "()Lcom/bytedance/ai/applet/render/core/camera/CameraAuthorizer;", "setAuthorizer", "(Lcom/bytedance/ai/applet/render/core/camera/CameraAuthorizer;)V", "recordAuthorizer", "Lcom/bytedance/ai/applet/render/core/camera/RecordAuthorizer;", "getRecordAuthorizer", "()Lcom/bytedance/ai/applet/render/core/camera/RecordAuthorizer;", "setRecordAuthorizer", "(Lcom/bytedance/ai/applet/render/core/camera/RecordAuthorizer;)V", "_previewView", "Landroidx/camera/view/PreviewView;", "clientId", "devicePosition", "nodeReady", "", "registered", "nodeGeneration", "sessionManager", "Lcom/bytedance/ai/applet/render/core/camera/CameraSessionManager;", "lifecycleObserver", "Landroidx/lifecycle/DefaultLifecycleObserver;", "observedLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "activityForeground", "lynxViewForeground", "Ljava/lang/Boolean;", "authorizationJob", "Lkotlinx/coroutines/Job;", "recordAuthorizationJob", "recordAuthorizationRequestId", "pendingRecordAuthorizationCallback", "Lcom/lynx/react/bridge/Callback;", "clientPreviewView", "getClientPreviewView", "()Landroidx/camera/view/PreviewView;", "clientTempDirectory", "getClientTempDirectory", "clientAvailableQuota", "getClientAvailableQuota", "clientToVirtualPath", "getClientToVirtualPath", "clientContext", "Landroid/content/Context;", "getClientContext", "()Landroid/content/Context;", "clientLifecycleOwner", "getClientLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "onSessionReady", "", "onSessionError", "errCode", "", "errMessage", "onFocusLost", "createView", "registerWithSessionManagerIfNeeded", "unregisterFromSessionManagerIfNeeded", "setDevicePosition", "position", "onNodeReady", "onNodeRemoved", "onPermissionGranted", "generation", "observePageLifecycle", "removePageLifecycleObserver", "onLynxViewEnterForeground", "onLynxViewEnterBackground", "updatePageForeground", "pageTag", "", "isPageForeground", "takePhoto", "params", "Lcom/lynx/react/bridge/ReadableMap;", "callback", "startRecord", "stopRecord", "requestFocus", "destroy", "releaseNode", "isActiveNode", "currentRotation", "findActivity", "Landroid/app/Activity;", "postErrorEvent", "errMap", "Lcom/lynx/react/bridge/JavaOnlyMap;", MessageIndication.MESSAGE_TYPE_MSG, "Companion", "applet-render-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxCameraUI extends UISimpleView<FrameLayout> implements b, com.lynx.tasm.behavior.j {
    public static final /* synthetic */ int u = 0;
    public File a;
    public Function0<Long> b;
    public Function1<? super File, String> c;
    public com.bytedance.ai.applet.render.core.camera.a d;
    public a0 e;
    public PreviewView f;
    public final String g;
    public String h;
    public boolean i;
    public boolean j;
    public long k;
    public u l;
    public LynxCameraUI$observePageLifecycle$observer$1 m;
    public LifecycleOwner n;
    public boolean o;
    public Boolean p;
    public Job q;
    public Job r;
    public long s;
    public Callback t;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.applet.render.core.camera.LynxCameraUI$onNodeReady$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.applet.render.core.camera.LynxCameraUI$onNodeReady$1", f = "LynxCameraUI.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.bytedance.ai.applet.render.core.camera.a $auth;
        final /* synthetic */ long $generation;
        int label;
        final /* synthetic */ LynxCameraUI this$0;

        public AnonymousClass1(com.bytedance.ai.applet.render.core.camera.a r1, LynxCameraUI r10, long r11, Continuation<? super AnonymousClass1> r12) {
            this.$auth = r1;
            this.this$0 = r10;
            this.$generation = r11;
            super(2, r12);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$auth, this.this$0, this.$generation, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L13;
            if (r1 != 1) goto L12;
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L7 CancellationException -> L9
        L17:
            boolean r11 = ((Boolean) r10).booleanValue();     // Catch: Exception -> L7 CancellationException -> L9
            LynxCameraUI r12 = this.this$0;     // Catch: Exception -> L7 CancellationException -> L9
            long r13 = this.$generation;     // Catch: Exception -> L7 CancellationException -> L9
            int r14 = LynxCameraUI.u;     // Catch: Exception -> L7 CancellationException -> L9
            if (r12.Q(r13) == true) goto L22;
            return Unit.INSTANCE;
        L22:
            if (r11 == false) goto L24;
            LynxCameraUI.M(this.this$0, this.$generation);     // Catch: Exception -> L7 CancellationException -> L9
        L32:
            return Unit.INSTANCE;
        L24:
            this.this$0.s(CastInfo.TYPE_DISCONNECT, "Camera permission denied by user");     // Catch: Exception -> L7 CancellationException -> L9
            goto L32
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            ResultKt.throwOnFailure(r10);
            com.bytedance.ai.applet.render.core.camera.a r15 = this.$auth;     // Catch: Exception -> L7 CancellationException -> L9
            this.label = 1;     // Catch: Exception -> L7 CancellationException -> L9
            r10 = r15.a(this);     // Catch: Exception -> L7 CancellationException -> L9
            if (r10 != r0) goto L17;
            return r0;
        L9:
            e = move-exception;
            throw e;
        L7:
            e = move-exception;
            LynxCameraUI r16 = this.this$0;
            long r17 = this.$generation;
            int r18 = LynxCameraUI.u;
            if (r16.Q(r17) == false) goto L29;
            this.this$0.s(CastInfo.TYPE_DISCONNECT, "Authorization failed: " + e.getMessage());
            goto L32
        L29:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.applet.render.core.camera.LynxCameraUI$startRecord$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.applet.render.core.camera.LynxCameraUI$startRecord$1", f = "LynxCameraUI.kt", i = {}, l = {298}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ a0 $auth;
        final /* synthetic */ Callback $callback;
        final /* synthetic */ Context $context;
        final /* synthetic */ long $generation;
        final /* synthetic */ long $requestId;
        int label;
        final /* synthetic */ LynxCameraUI this$0;

        public C02221(a0 r1, long r10, LynxCameraUI r11, long r12, Callback r13, Context r14, Continuation<? super C02221> r15) {
            this.$auth = r1;
            this.$requestId = r10;
            this.this$0 = r11;
            this.$generation = r12;
            this.$callback = r13;
            this.$context = r14;
            super(2, r15);
        }

        public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
            return new C02221(this.$auth, this.$requestId, this.this$0, this.$generation, this.$callback, this.$context, r12);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r14);     // Catch: Exception -> L22 CancellationException -> L24
        L13:
            boolean r15 = ((Boolean) r14).booleanValue();     // Catch: Exception -> L22 CancellationException -> L24
            long r10 = this.$requestId;     // Catch: Exception -> L22 CancellationException -> L24
            LynxCameraUI r11 = this.this$0;     // Catch: Exception -> L22 CancellationException -> L24
            if (r10 != r11.s) goto L16;
            r11.r = null;     // Catch: Exception -> L22 CancellationException -> L24
            r11.t = null;     // Catch: Exception -> L22 CancellationException -> L24
            if (r11.Q(this.$generation) == true) goto L29;
            Callback r16 = this.$callback;     // Catch: Exception -> L22 CancellationException -> L24
            if (r16 == null) goto L27;
            this.this$0.getClass();     // Catch: Exception -> L22 CancellationException -> L24
            r16.invoke(new Object[]{Boxing.boxInt(1), LynxCameraUI.O("Camera node was removed", 119)});     // Catch: Exception -> L22 CancellationException -> L24
        L27:
            return Unit.INSTANCE;
        L29:
            if (r15 == true) goto L35;
            Callback r12 = this.$callback;     // Catch: Exception -> L22 CancellationException -> L24
            if (r12 == null) goto L33;
            this.this$0.getClass();     // Catch: Exception -> L22 CancellationException -> L24
            r12.invoke(new Object[]{Boxing.boxInt(1), LynxCameraUI.O("Microphone permission denied by user", CastInfo.TYPE_DISCONNECT)});     // Catch: Exception -> L22 CancellationException -> L24
        L33:
            this.this$0.s(CastInfo.TYPE_DISCONNECT, "Microphone permission denied by user");     // Catch: Exception -> L22 CancellationException -> L24
            return Unit.INSTANCE;
        L35:
            LynxCameraUI r17 = this.this$0;     // Catch: Exception -> L22 CancellationException -> L24
            u r13 = r17.l;     // Catch: Exception -> L22 CancellationException -> L24
            if (r13 == null) goto L38;
            r13.m(r17.g, this.$context, this.$callback);     // Catch: Exception -> L22 CancellationException -> L24
        L58:
            return Unit.INSTANCE;
        L38:
            Callback r18 = this.$callback;     // Catch: Exception -> L22 CancellationException -> L24
            if (r18 == null) goto L58;
            r18.invoke(new Object[]{Boxing.boxInt(1), LynxCameraUI.P(this.this$0, "Camera not initialized")});     // Catch: Exception -> L22 CancellationException -> L24
            goto L58
        L16:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r14);
            a0 r19 = this.$auth;     // Catch: Exception -> L22 CancellationException -> L24
            this.label = 1;     // Catch: Exception -> L22 CancellationException -> L24
            r14 = r19.a(this);     // Catch: Exception -> L22 CancellationException -> L24
            if (r14 != r0) goto L13;
            return r0;
        L24:
            e = move-exception;
            long r20 = this.$requestId;
            LynxCameraUI r21 = this.this$0;
            if (r20 != r21.s) goto L64;
            r21.r = null;
            r21.t = null;
            Callback r22 = this.$callback;
            if (r22 == null) goto L64;
            this.this$0.getClass();
            r22.invoke(new Object[]{Boxing.boxInt(1), LynxCameraUI.O("Record authorization was cancelled", 119)});
        L64:
            throw e;
        L22:
            e = move-exception;
            long r23 = this.$requestId;
            LynxCameraUI r24 = this.this$0;
            if (r23 != r24.s) goto L45;
            r24.r = null;
            r24.t = null;
            if (r24.Q(this.$generation) == true) goto L53;
            Callback r110 = this.$callback;
            if (r110 == null) goto L52;
            this.this$0.getClass();
            r110.invoke(new Object[]{Boxing.boxInt(1), LynxCameraUI.O("Camera node was removed", 119)});
        L52:
            return Unit.INSTANCE;
        L53:
            String r111 = "Record authorization failed: " + e.getMessage();
            Callback r25 = this.$callback;
            if (r25 == null) goto L56;
            this.this$0.getClass();
            r25.invoke(new Object[]{Boxing.boxInt(1), LynxCameraUI.O(r111, CastInfo.TYPE_DISCONNECT)});
        L56:
            this.this$0.s(CastInfo.TYPE_DISCONNECT, r111);
            goto L58
        L45:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void B() {
        this.p = Boolean.FALSE;
        if (Q(this.k) == false) goto L6;
        U();
        return;
    }

    public final int N() {
        FrameLayout r0 = (FrameLayout) ((LynxUI) this).mView;
        if (r0 == null) goto L6;
        Display r1 = r0.getDisplay();
        if (r1 == null) goto L6;
    L23:
        if (r1 != null) goto L36;
        return 0;
    L36:
        return r1.getRotation();
    L6:
        FrameLayout r10 = (FrameLayout) ((LynxUI) this).mView;
        if (r10 == null) goto L9;
        Context r11 = r10.getContext();
    L10:
        if (r11 == null) goto L17;
        if ((r11 instanceof Activity) == true) goto L13;
        if ((r11 instanceof ContextWrapper) == false) goto L9;
        r11 = ((ContextWrapper) r11).getBaseContext();
        goto L10
    L9:
        r11 = null;
        goto L10
    L13:
        Activity r12 = (Activity) r11;
    L18:
        if (r12 == null) goto L22;
        WindowManager r13 = r12.getWindowManager();
        if (r13 == null) goto L22;
        r1 = r13.getDefaultDisplay();
    L22:
        r1 = null;
        goto L23
    L17:
        r12 = null;
        goto L18
    L27:
        r11 = null;
        goto L10
    }

    public final void T() {
        this.k++;
        this.i = false;
        Job r1 = this.q;
        if (r1 == null) goto L5;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L5:
        this.q = null;
        this.s++;
        Callback r10 = this.t;
        this.t = null;
        Job r11 = this.r;
        if (r11 == null) goto L8;
        Job.DefaultImpls.cancel$default(r11, null, 1, null);
    L8:
        this.r = null;
        if (r10 == null) goto L11;
        r10.invoke(new Object[]{1, O("Camera node was removed", 119)});
    L11:
        LynxCameraUI$observePageLifecycle$observer$1 r12 = this.m;
        if (r12 == null) goto L18;
        LifecycleOwner r13 = this.n;
        if (r13 == null) goto L18;
        Lifecycle r14 = r13.getLifecycle();
        if (r14 == null) goto L18;
        r14.removeObserver(r12);
    L18:
        this.m = null;
        this.n = null;
        this.o = false;
        this.p = null;
        if (this.j == true) goto L21;
        this.l = null;
        return;
    L21:
        u r15 = this.l;
        this.j = false;
        this.l = null;
        if (r15 == null) goto L66;
        u r16 = u.z;
        Intrinsics.checkNotNullParameter(r15, "manager");
        Object r17 = u.B;
        monitor-enter(r17);
    L60:
        th = move-exception;
        throw th;
    L26:
        if (Intrinsics.areEqual(u.z, r15) == false) goto L30;
        int r18 = u.A;     // Catch: Throwable -> L60
        if (r18 <= 0) goto L30;
        u.A = r18 - 1;     // Catch: Throwable -> L60
    L30:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L60
        monitor-exit(r17);
        String r20 = this.g;
        Intrinsics.checkNotNullParameter(r20, "identifier");
        boolean r110 = Intrinsics.areEqual(r15.p, r20);
        r15.a.remove(r20);
        ((ArrayList) r15.b).remove(r20);
        r15.j();
        if (Intrinsics.areEqual(r15.t, r20) == false) goto L37;
        Callback r111 = r15.v;
        r15.t = null;
        r15.u = null;
        r15.v = null;
        if (r111 == null) goto L37;
        r111.invoke(new Object[]{1, u.f(119, "Camera instance was removed before focus could be acquired")});
    L37:
        if (r110 == false) goto L40;
        r15.s++;
        r15.p = null;
        r15.r = false;
    L40:
        if (Intrinsics.areEqual(r15.g, r20) == false) goto L45;
        r15.b("Camera instance was removed before recording could start");
        Recording r0 = r15.f;
        if (r0 == null) goto L45;
        r0.stop();
    L45:
        if (r15.a.isEmpty() == false) goto L59;
        Recording r21 = r15.f;
        if (r21 == null) goto L49;
    L56:
        r15.w = true;
        if (r21 == null) goto L68;
        r21.stop();
        return;
    L68:
        return;
    L49:
        if (r15.k == true) goto L56;
        if (r15.n == true) goto L56;
        if (r15.o > 0) goto L56;
        r15.e();
        return;
    L59:
        r15.l();
        return;
    }

    public final void U() {
        u r0 = this.l;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.o == true) goto L7;
    L9:
        boolean r1 = false;
    L10:
        LynxContext r10 = getLynxContext();
        Intrinsics.checkNotNullParameter(r10, "pageTag");
        Iterator r11 = ((ArrayList) r0.b).iterator();
        String r12 = null;
    L12:
        if (r11.hasNext() == false) goto L27;
        String r13 = (String) r11.next();
        x r14 = (x) ((LinkedHashMap) r0.a).get(r13);
        if (r14 == null) goto L12;
        WeakReference<Object> r15 = r14.f;
        if (r15 == null) goto L19;
        Object r16 = r15.get();
    L20:
        if (r16 == null) goto L12;
        if (r16 != r10) goto L12;
        r14.e = r1;
        if (r14.a() == false) goto L12;
        if (r14.d == false) goto L12;
        r12 = r13;
        goto L12
    L19:
        r16 = null;
        goto L20
    L27:
        if (r1 == false) goto L30;
        if (r12 == null) goto L30;
        Object r17 = ((LinkedHashMap) r0.a).get(r12);
        Intrinsics.checkNotNull(r17);
        x r18 = (x) r17;
        r0.k(r12, r18.b, r18.c, null);
        return;
    L30:
        r0.l();
        return;
    L7:
        if (Intrinsics.areEqual(this.p, Boolean.FALSE) == true) goto L9;
        r1 = true;
        goto L10
    }

    public final void destroy() {
        T();
        super/*com.lynx.tasm.behavior.ui.UIGroup*/.destroy();
        this.f = null;
    }

    @Override // com.bytedance.ai.applet.render.core.camera.b
    public final void onSessionReady() {
        final long r0 = this.k;
        if (Q(r0) == true) goto L5;
        return;
    L5:
        FrameLayout r10 = (FrameLayout) ((LynxUI) this).mView;
        if (r10 == null) goto L9;
        r10.post(new z(this, r0));
        return;
    }

    public final void p() {
        this.p = Boolean.TRUE;
        if (Q(this.k) == false) goto L6;
        U();
        return;
    }

    @Override // com.bytedance.ai.applet.render.core.camera.b
    public final Context u() {
        FrameLayout r0 = (FrameLayout) ((LynxUI) this).mView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContext();
    }

    @Override // com.bytedance.ai.applet.render.core.camera.b
    public final LifecycleOwner w() {
        FrameLayout r0 = (FrameLayout) ((LynxUI) this).mView;
        if (r0 == null) goto L5;
        Context r1 = r0.getContext();
    L6:
        if (r1 == null) goto L14;
        if ((r1 instanceof LifecycleOwner) == true) goto L10;
        if ((r1 instanceof ContextWrapper) == false) goto L5;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L6
    L5:
        r1 = null;
        goto L6
    L10:
        return (LifecycleOwner) r1;
    L14:
        return null;
    L15:
        r1 = null;
        goto L6
    }

    public final void onNodeReady() {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.onNodeReady();
        if (this.i == false) goto L5;
        return;
    L5:
        this.i = true;
        long r10 = this.k + 1;
        this.k = r10;
        if (this.j == true) goto L16;
        Object r1 = u.B;
        monitor-enter(r1);
        u r11 = u.z;     // Catch: Throwable -> L24
        if (r11 != null) goto L13;
        r11 = new u();     // Catch: Throwable -> L24
        u.z = r11;     // Catch: Throwable -> L24
    L13:
        u.A++;     // Catch: Throwable -> L24
        monitor-exit(r1);
        this.l = r11;
        this.j = true;
        String r12 = this.g;
        String r13 = this.h;
        int r14 = N();
        Intrinsics.checkNotNullParameter(this, "client");
        Intrinsics.checkNotNullParameter(r12, "identifier");
        Intrinsics.checkNotNullParameter(r13, "devicePosition");
        r11.a.put(r12, new x(new WeakReference(this), r13, r14));
        ((ArrayList) r11.b).remove(r12);
        ((ArrayList) r11.b).add(r12);
        r11.w = false;
    L24:
        th = move-exception;
        throw th;
    L16:
        com.bytedance.ai.applet.render.core.camera.a r15 = this.d;
        if (r15 == null) goto L22;
        Job r16 = this.q;
        if (r16 == null) goto L21;
        Job.DefaultImpls.cancel$default(r16, null, 1, null);
    L21:
        this.q = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(r15, this, r10, null), 3, null);
        return;
    L22:
        s(CastInfo.TYPE_DISCONNECT, "No authorization provider configured");
    }

    public final void onNodeRemoved() {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.onNodeRemoved();
        T();
    }

    @Override // com.bytedance.ai.applet.render.core.camera.b
    public final PreviewView A() {
        return this.f;
    }

    @Override // com.bytedance.ai.applet.render.core.camera.b
    public final Function1<File, String> F() {
        return this.c;
    }

    @Override // com.bytedance.ai.applet.render.core.camera.b
    public final File G() {
        return this.a;
    }

    @Override // com.bytedance.ai.applet.render.core.camera.b
    public final Function0<Long> L() {
        return this.b;
    }

    public LynxCameraUI(LynxContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, null);
        this.g = UUID.randomUUID().toString();
        this.h = "front";
    }

    public static /* synthetic */ boolean R(LynxCameraUI r10) {
        return r10.Q(r10.k);
    }

    public final boolean Q(long r10) {
        if (r10 == this.k) goto L5;
    L9:
        return false;
    L5:
        if (this.i == false) goto L9;
        if (this.j == false) goto L9;
        return true;
    }

    public final View createView(Context r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        FrameLayout r0 = new FrameLayout(r10);
        PreviewView r1 = new PreviewView(r10);
        r1.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f = r1;
        r0.addView(r1);
        return r0;
    }

    @Override // com.bytedance.ai.applet.render.core.camera.b
    public final void m(String r10) {
        Intrinsics.checkNotNullParameter(r10, "errMessage");
        if (Q(this.k) == true) goto L5;
        return;
    L5:
        S(119, r10);
    }

    @LynxProp(name = "device-position")
    public final void setDevicePosition(String r10) {
        if (r10 != null) goto L6;
        r10 = "front";
    L6:
        if (Intrinsics.areEqual(r10, "front") == true) goto L11;
        if (Intrinsics.areEqual(r10, "back") == true) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r10, this.h) == false) goto L13;
        return;
    L13:
        this.h = r10;
        u r0 = this.l;
        if (r0 == null) goto L37;
        String r1 = this.g;
        int r11 = N();
        Intrinsics.checkNotNullParameter(r1, "identifier");
        Intrinsics.checkNotNullParameter(r10, "devicePosition");
        x r12 = (x) ((LinkedHashMap) r0.a).get(r1);
        if (r12 == null) goto L40;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r12.b = r10;
        r12.c = r11;
        if (Intrinsics.areEqual(r0.p, r1) == true) goto L22;
        return;
    L22:
        if (Intrinsics.areEqual(r0.q, r10) == false) goto L25;
        return;
    L25:
        if (r0.f == null) goto L27;
    L33:
        b r13 = r12.a.get();
        if (r13 == null) goto L39;
        r13.s(119, "Cannot switch camera while recording is starting or in progress");
        return;
    L39:
        return;
    L27:
        if (r0.k == true) goto L33;
        r0.q = r10;
        b r14 = r12.a.get();
        if (r14 == null) goto L43;
        r0.a(r1, r14, r10, r11);
        return;
    L43:
        return;
    L40:
        return;
    }

    public static final void M(final LynxCameraUI r10, long r11) {
        if (r10.Q(r11) == false) goto L40;
        LynxCameraUI$observePageLifecycle$observer$1 r0 = r10.m;
        if (r0 == null) goto L12;
        LifecycleOwner r1 = r10.n;
        if (r1 == null) goto L12;
        Lifecycle r12 = r1.getLifecycle();
        if (r12 == null) goto L12;
        r12.removeObserver(r0);
    L12:
        r10.m = null;
        r10.n = null;
        LifecycleOwner r13 = r10.w();
        if (r13 == null) goto L17;
        r10.o = r13.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED);
        LifecycleObserver r14 = new LynxCameraUI$observePageLifecycle$observer$1(r10);
        r10.n = r13;
        r10.m = r14;
        r13.getLifecycle().addObserver(r14);
    L17:
        if (r10.Q(r11) == true) goto L20;
        return;
    L20:
        if (r10.o == true) goto L22;
    L24:
        boolean r15 = false;
    L25:
        u r16 = r10.l;
        if (r16 == null) goto L38;
        String r17 = r10.g;
        LynxContext r18 = r10.getLynxContext();
        Intrinsics.checkNotNullParameter(r17, "identifier");
        x r19 = (x) ((LinkedHashMap) r16.a).get(r17);
        if (r19 == null) goto L42;
        r19.d = true;
        r19.e = r15;
        if (r18 == null) goto L33;
        WeakReference<Object> r20 = new WeakReference(r18);
    L34:
        r19.f = r20;
        if (r15 == false) goto L39;
        r16.k(r17, r19.b, r19.c, null);
        return;
    L39:
        return;
    L33:
        r20 = null;
        goto L34
    L42:
        return;
    L38:
        return;
    L22:
        if (Intrinsics.areEqual(r10.p, Boolean.FALSE) == true) goto L24;
        r15 = true;
        goto L25
    }

    public static JavaOnlyMap O(String r10, int r11) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.put("errCode", Integer.valueOf(r11));
        r0.put("errMessage", r10);
        return r0;
    }

    public static /* synthetic */ JavaOnlyMap P(LynxCameraUI r0, String r1) {
        r0.getClass();
        return O(r1, 102);
    }

    public final void S(final int r10, final String r11) {
        final long r12 = this.k;
        if (Q(r12) == true) goto L5;
        return;
    L5:
        FrameLayout r13 = (FrameLayout) ((LynxUI) this).mView;
        if (r13 == null) goto L9;
        r13.post(new y(this, r12, r10, r11));
        return;
    }

    @LynxUIMethod
    public final void requestFocus(ReadableMap r10, Callback r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        u r12 = this.l;
        if (r12 == null) goto L5;
        String r0 = this.g;
        String r1 = this.h;
        int r13 = N();
        Intrinsics.checkNotNullParameter(r0, "identifier");
        Intrinsics.checkNotNullParameter(r1, "devicePosition");
        r12.k(r0, r1, r13, r11);
        return;
    L5:
        if (r11 == null) goto L9;
        r11.invoke(new Object[]{1, O("Camera not initialized", 102)});
        return;
    }

    @Override // com.bytedance.ai.applet.render.core.camera.b
    public final void s(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errMessage");
        if (Q(this.k) == true) goto L5;
        return;
    L5:
        S(r10, r11);
    }

    @LynxUIMethod
    public final void startRecord(ReadableMap r18, Callback r19) {
        Intrinsics.checkNotNullParameter(r18, "params");
        long r10 = this.k;
        if (Q(r10) == true) goto L7;
        if (r19 == null) goto L35;
        r19.invoke(new Object[]{1, O("Camera is not ready", 119)});
        return;
    L35:
        return;
    L7:
        FrameLayout r0 = (FrameLayout) ((LynxUI) this).mView;
        if (r0 == null) goto L10;
        Context r1 = r0.getContext();
    L11:
        Context r11 = r1;
        if (r11 != null) goto L16;
        if (r19 == null) goto L36;
        r19.invoke(new Object[]{1, O("No context", 102)});
        return;
    L36:
        return;
    L16:
        a0 r12 = this.e;
        if (r12 == null) goto L19;
        Job r13 = this.r;
        if (r13 != null) goto L26;
    L28:
        boolean r14 = false;
    L29:
        if (r14 == false) goto L33;
        if (r19 == null) goto L37;
        r19.invoke(new Object[]{1, O("Record authorization is already in progress", 118)});
        return;
    L37:
        return;
    L33:
        long r15 = 1 + this.s;
        this.s = r15;
        this.t = r19;
        this.r = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C02221(r12, r15, this, r10, r19, r11, null), 3, null);
        return;
    L26:
        if (r13.isActive() != true) goto L28;
        r14 = true;
        goto L29
    L19:
        if (r19 == null) goto L21;
        r19.invoke(new Object[]{1, O("No record authorization provider configured", CastInfo.TYPE_DISCONNECT)});
    L21:
        s(CastInfo.TYPE_DISCONNECT, "No record authorization provider configured");
        return;
    L10:
        r1 = null;
        goto L11
    }

    @LynxUIMethod
    public final void stopRecord(ReadableMap r10, Callback r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        u r12 = this.l;
        if (r12 == null) goto L23;
        String r13 = this.g;
        Intrinsics.checkNotNullParameter(r13, "identifier");
        if (r12.k == true) goto L7;
    L11:
        Recording r14 = r12.f;
        if (r14 != null) goto L14;
    L21:
        if (r11 == null) goto L29;
        r11.invoke(new Object[]{1, u.f(119, "This camera instance is not recording")});
        return;
    L29:
        return;
    L14:
        if (Intrinsics.areEqual(r12.g, r13) == false) goto L21;
        if (r12.n == true) goto L21;
        if (r12.j != null) goto L21;
        r12.j = r11;
        r14.stop();
        return;
    L7:
        if (Intrinsics.areEqual(r12.g, r13) == false) goto L11;
        r12.b("Recording was stopped before it could start");
        if (r11 == null) goto L26;
        r11.invoke(new Object[]{1, u.f(119, "Recording was stopped before it could start")});
        return;
    L26:
        return;
    L23:
        if (r11 == null) goto L31;
        r11.invoke(new Object[]{1, O("Camera not initialized", 102)});
        return;
    }

    @LynxUIMethod
    public final void takePhoto(ReadableMap r12, final Callback r13) {
        Intrinsics.checkNotNullParameter(r12, "params");
        final u r10 = this.l;
        if (r10 == null) goto L39;
        final String r11 = this.g;
        Intrinsics.checkNotNullParameter(r11, "identifier");
        if (Intrinsics.areEqual(r10.p, r11) == true) goto L7;
    L37:
        if (r13 == null) goto L47;
        r13.invoke(new Object[]{1, u.f(119, "Camera does not have focus")});
        return;
    L47:
        return;
    L7:
        if (r10.r == false) goto L37;
        final ImageCapture r14 = r10.d;
        if (r14 != null) goto L13;
        if (r13 == null) goto L42;
        r13.invoke(new Object[]{1, u.f(102, "Camera not initialized")});
        return;
    L42:
        return;
    L13:
        x r15 = (x) ((LinkedHashMap) r10.a).get(r11);
        Function1<File, String> r16 = null;
        if (r15 == null) goto L18;
        WeakReference<b> r17 = r15.a;
        if (r17 == null) goto L18;
        b r18 = r17.get();
    L19:
        if (r18 == null) goto L21;
        File r19 = r18.G();
    L22:
        if (r18 == null) goto L24;
        Function0<Long> r110 = r18.L();
    L25:
        if (r18 == null) goto L27;
        r16 = r18.F();
    L27:
        if (r19 == null) goto L35;
        if (r110 == null) goto L35;
        if (r16 == null) goto L35;
        x r0 = (x) ((LinkedHashMap) r10.a).get(r11);
        if (r0 == null) goto L34;
        r14.setTargetRotation(r0.c);
    L34:
        r10.o++;
        final Function0<Long> r20 = r110;
        final File r21 = r19;
        final Function1<File, String> r22 = r16;
        r10.x.execute(new c(r10, r20, r21, r22, r13, r11, r14));
        return;
    L35:
        if (r13 == null) goto L45;
        r13.invoke(new Object[]{1, u.f(102, "Temp file provider not initialized")});
        return;
    L45:
        return;
    L24:
        r110 = null;
        goto L25
    L21:
        r19 = null;
    L18:
        r18 = null;
        goto L19
    L39:
        if (r13 == null) goto L49;
        r13.invoke(new Object[]{1, O("Camera not initialized", 102)});
        return;
    }
}

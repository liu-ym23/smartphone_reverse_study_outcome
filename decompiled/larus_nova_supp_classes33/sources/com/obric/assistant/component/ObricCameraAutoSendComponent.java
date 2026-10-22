package com.obric.assistant.component;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.internal.ChatSender;
import com.obric.assistant.upload.IObricUploadService;
import com.obric.assistant.upload.Scene;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0082@¢\u0006\u0002\u0010\u0015R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/component/ObricCameraAutoSendComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "<init>", "()V", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "sendingRequestId", "", "onResume", "", "tryConsumeCameraAutoSend", "sendPayload", "payload", "Lcom/obric/assistant/camera/CameraAutoSendPayload;", "(Lcom/obric/assistant/camera/CameraAutoSendPayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitSendDependenciesReady", "Lcom/obric/assistant/chat/api/ISenderApi;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricCameraAutoSendComponent extends BaseContentWidget {
    public static final /* synthetic */ int o = 0;
    public final Lazy m;
    public String n;

    public static final class a {
    }

    public static final class b implements Function0<de8.c> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(de8.c.class));
        }
    }

    static {
    }

    public final void onResume() {
        de8.c r0 = (de8.c) this.m.getValue();
        if (r0 == null) goto L23;
        Bundle r1 = r0.b;
        if (r1 == null) goto L26;
        String r2 = r1.getString("camera_auto_send_request_id");
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        if (r2.length() != 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
        return;
    L16:
        if (Intrinsics.areEqual(this.n, r2) == true) goto L27;
        r1.remove("camera_auto_send_request_id");
        ica.a r4 = ica.b.b(r2);
        if (r4 != null) goto L21;
        FLogger.a.w("ObricCameraAutoSend", "payload missing requestId=".concat(r2));
        return;
    L21:
        this.n = r2;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricCameraAutoSendComponent$tryConsumeCameraAutoSend$1(this, r4, null), 3, null);
        return;
    L27:
        return;
    L13:
        r3 = false;
        goto L14
    L26:
        return;
    }

    public ObricCameraAutoSendComponent() {
        this.m = LazyKt.lazy(new b(this));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x006a -> B:27:0x006d). Please report as a decompilation issue!!! */
    public final Object h3(Continuation<? super com.obric.assistant.chat.api.c> r8) {
        if ((r8 instanceof ObricCameraAutoSendComponent$waitSendDependenciesReady$1) == false) goto L7;
        ObricCameraAutoSendComponent$waitSendDependenciesReady$1 r0 = (ObricCameraAutoSendComponent$waitSendDependenciesReady$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r4 = r0.I$1;
        int r5 = r0.I$0;
        ResultKt.throwOnFailure(r9);
    L27:
        r4 = r4 + 1;
    L15:
        ChatSender r10 = null;
        if (r4 >= r5) goto L28;
        IObricChatService.a.getClass();
        IObricChatService r6 = IObricChatService.a.a();
        if (r6 == null) goto L20;
        r10 = r6.getSender();
    L20:
        IObricUploadService.a.getClass();
        IObricUploadService r7 = IObricUploadService.a.a();
        if (r10 == null) goto L24;
        if (r7 == null) goto L24;
        return r10;
    L24:
        r0.I$0 = r5;
        r0.I$1 = r4;
        r0.label = 1;
        if (DelayKt.delay(150, r0) != r2) goto L27;
        return r2;
    L28:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        r4 = 0;
        r5 = 20;
    L7:
        r0 = new ObricCameraAutoSendComponent$waitSendDependenciesReady$1(this, r8);
        goto L8
    }

    public static final Object Y2(ObricCameraAutoSendComponent r16, ica.a r17, Continuation r18) {
        r16.getClass();
        if ((r18 instanceof ObricCameraAutoSendComponent$sendPayload$1) == false) goto L7;
        ObricCameraAutoSendComponent$sendPayload$1 r2 = (ObricCameraAutoSendComponent$sendPayload$1) r18;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        ica.a r6 = (ica.a) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: CancellationException -> L14
    L23:
        com.obric.assistant.chat.api.c r8 = (com.obric.assistant.chat.api.c) r0;     // Catch: CancellationException -> L14
        if (r8 != null) goto L26;
        FLogger.a.w("ObricCameraAutoSend", "send dependencies timeout requestId=" + r6.a);
        r6.a();
        r16.n = null;
        return Unit.INSTANCE;
    L26:
        PolarisFileWrapper r12 = new PolarisFileWrapper(r6.c);
        if (r12.exists() == true) goto L42;
        FLogger.a.w("ObricCameraAutoSend", "image file missing requestId=" + r6.a);
        r6.a();
        r16.n = null;
        return Unit.INSTANCE;
    L42:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L31
        r8.a(r6.b, "camera_auto_send", MapsKt.mapOf(TuplesKt.to("caller_package", r6.d)), r12, Scene.SCREEN_SEMANTIC, new f(r6, r16), null);     // Catch: Throwable -> L31
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r9 = Result.exceptionOrNull-impl(r7);
        if (r9 == null) goto L37;
        FLogger.a.e("ObricCameraAutoSend", "send exception requestId=" + r6.a, r9);
        r6.a();
        r16.n = null;
    L37:
        return Unit.INSTANCE;
    L31:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        e = e;
    L40:
        FLogger.a.w("ObricCameraAutoSend", "send cancelled requestId=" + r6.a);
        r6.a();
        r16.n = null;
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        r2.L$0 = r17;     // Catch: CancellationException -> L38
        r2.label = 1;     // Catch: CancellationException -> L38
        r0 = r16.h3(r2);     // Catch: CancellationException -> L38
        if (r0 == r4) goto L50;
        r6 = r17;
        goto L23
    L50:
        return r4;
    L38:
        e = e;
        r6 = r17;
    L7:
        r2 = new ObricCameraAutoSendComponent$sendPayload$1(r16, r18);
        goto L8
    }
}

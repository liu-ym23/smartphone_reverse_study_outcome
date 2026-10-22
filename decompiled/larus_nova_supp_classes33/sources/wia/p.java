package wia;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.capabilitykit.ErrorCodeCallback;
import com.obric.capabilitykit.TaskStateChangeCallback;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.ICapabilityManager;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.corecommon.BinderExceptionHandlerProxy;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.logger.Logger;
import java.lang.reflect.Proxy;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class p implements n {
    public final ICapabilityManager a;

    public p(ICapabilityManager r6) {
        Intrinsics.checkNotNullParameter(r6, "api");
        Object r1 = Proxy.newProxyInstance(ICapabilityManager.class.getClassLoader(), new Class[]{ICapabilityManager.class}, new BinderExceptionHandlerProxy(r6, "CapabilityManagerClient", ICapabilityManager.class));     // Catch: Throwable -> L8
        if (r1 == null) goto L7;
        r6 = (ICapabilityManager) r1;     // Catch: Throwable -> L8
    L12:
        this.a = r6;
        int r7 = r6.getVersion();
        Logger.INSTANCE.i("CapabilityManagerClient", "ICapabilityManager version: " + r7);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.capabilitykit.common.ICapabilityManager");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th))) == null) goto L12;
        r6.getClass().toString();
        goto L12
    }

    @Override // wia.n
    public final void a(long r2) {
        this.a.hideIntentResultCard(r2);
    }

    @Override // wia.n
    public final void a(String r8, TaskStateInfo r9, TaskStateChangeCallback r10, Long r11) {
        Intrinsics.checkNotNullParameter(r8, "id");
        Intrinsics.checkNotNullParameter(r9, "stateInfo");
        ICapabilityManager r1 = this.a;
        if (r11 == null) goto L5;
        long r2 = r11.longValue();
    L6:
        r1.requestStateChanged(r8, r9, r10, r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // wia.n
    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "implClassName");
        this.a.unregisterIntent(r2, r3);
    }

    @Override // wia.n
    public final void a(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "implClassName");
        this.a.registerIntent(r2, r3, r4);
    }

    @Override // wia.n
    public final boolean a() {
        return this.a.isKeyguardReallyLocked();
    }

    @Override // wia.n
    public final void b(long r2) {
        this.a.finishFloatingActivity(r2);
    }

    @Override // wia.n
    public final void b(IMAppAction r3) {
        Intrinsics.checkNotNullParameter(r3, WindowEvent.Params.RESULT);
        this.a.sendActionExecuteResult(GsonProtectorUtils.toJson(UtilsKt.a(), r3));
    }

    @Override // wia.n
    public final Boolean c(long r2) {
        return Boolean.valueOf(this.a.isCardViewVisible(r2));
    }

    @Override // wia.n
    public final void c(Uri r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, "packageName");
        this.a.requestCloseFile(r3, r2);
    }

    @Override // wia.n
    public final void d(Uri r3, String r4, IUriFileReceiver r5) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        Intrinsics.checkNotNullParameter(r4, "packageName");
        Intrinsics.checkNotNullParameter(r5, "requester");
        if (this.a.requestOpenFile(r5, r3, r4) == true) goto L6;
        r5.onSessionReady(new UriFileAccessSession(1, "无权限或无法访问 URI。", 4));
        return;
    }

    @Override // wia.n
    public final PendingIntent e(long r2, Intent r4, FloatingIntentParams r5) {
        Intrinsics.checkNotNullParameter(r4, MemorySourceLinkType.INTENT);
        Intrinsics.checkNotNullParameter(r5, "params");
        return this.a.getFloatingPendingIntent(r2, r4, r5);
    }

    @Override // wia.n
    public final void f(IntentResult<?> r8, long r9, boolean r11, Map<String, String> r12) {
        Intrinsics.checkNotNullParameter(r8, WindowEvent.Params.RESULT);
        this.a.updateIntentResult(r8, r9, r11, r12);
    }

    @Override // wia.n
    public final void g(ErrorCodeCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.registerResultCallback(r2);
    }

    @Override // wia.n
    public final void h(ErrorCodeCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.unregisterResultCallback(r2);
    }

    @Override // wia.n
    public final void i(IntentResult<?> r3, IMAppAction r4) {
        Intrinsics.checkNotNullParameter(r3, "intentResult");
        Intrinsics.checkNotNullParameter(r4, "oldResult");
        this.a.sendIntentExecutionResult(r3, GsonProtectorUtils.toJson(UtilsKt.a(), r4));
    }
}

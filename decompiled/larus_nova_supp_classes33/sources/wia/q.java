package wia;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.capabilitykit.ErrorCodeCallback;
import com.obric.capabilitykit.TaskStateChangeCallback;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.logger.Logger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class q implements n {
    public static final q a = null;

    static {
        a = new q();
    }

    public q() {
    }

    @Override // wia.n
    public final void a(long r2) {
        Logger.INSTANCE.w("EmptyCapabilityManager", "hideIntentResultCard");
    }

    @Override // wia.n
    public final void a(String r1, TaskStateInfo r2, TaskStateChangeCallback r3, Long r4) {
        Intrinsics.checkNotNullParameter(r1, "id");
        Intrinsics.checkNotNullParameter(r2, "stateInfo");
        Logger.INSTANCE.w("EmptyCapabilityManager", "requestStateChanged");
    }

    @Override // wia.n
    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "implClassName");
        Logger.INSTANCE.w("EmptyCapabilityManager", "unregisterIntent");
    }

    @Override // wia.n
    public final void a(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "name");
        Intrinsics.checkNotNullParameter(r2, "implClassName");
        Logger.INSTANCE.w("EmptyCapabilityManager", "registerIntent");
    }

    @Override // wia.n
    public final boolean a() {
        Logger.INSTANCE.w("EmptyCapabilityManager", "isKeyguardReallyLocked");
        return true;
    }

    @Override // wia.n
    public final void b(long r2) {
        Logger.INSTANCE.w("EmptyCapabilityManager", "finishFloatingActivity");
    }

    @Override // wia.n
    public final void b(IMAppAction r3) {
        Intrinsics.checkNotNullParameter(r3, WindowEvent.Params.RESULT);
        Logger.INSTANCE.w("EmptyCapabilityManager", "sendActionExecuteResult");
    }

    @Override // wia.n
    public final Boolean c(long r2) {
        Logger.INSTANCE.w("EmptyCapabilityManager", "isCardViewVisible");
        return null;
    }

    @Override // wia.n
    public final void c(Uri r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, "packageName");
        Logger.INSTANCE.w("EmptyCapabilityManager", "stopUriFileAccess");
    }

    @Override // wia.n
    public final void d(Uri r2, String r3, IUriFileReceiver r4) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, "packageName");
        Intrinsics.checkNotNullParameter(r4, "requester");
        Logger.INSTANCE.w("EmptyCapabilityManager", "requestUriFileAccess");
    }

    @Override // wia.n
    public final PendingIntent e(long r1, Intent r3, FloatingIntentParams r4) {
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        Intrinsics.checkNotNullParameter(r4, "params");
        Logger.INSTANCE.w("EmptyCapabilityManager", "getFloatingPendingIntent");
        return null;
    }

    @Override // wia.n
    public final void f(IntentResult<?> r1, long r2, boolean r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r1, WindowEvent.Params.RESULT);
        Logger.INSTANCE.w("EmptyCapabilityManager", "updateIntentResult");
    }

    @Override // wia.n
    public final void g(ErrorCodeCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Logger.INSTANCE.w("EmptyCapabilityManager", "registerResultCallback");
    }

    @Override // wia.n
    public final void h(ErrorCodeCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Logger.INSTANCE.w("EmptyCapabilityManager", "unregisterResultCallback");
    }

    @Override // wia.n
    public final void i(IntentResult<?> r2, IMAppAction r3) {
        Intrinsics.checkNotNullParameter(r2, "intentResult");
        Intrinsics.checkNotNullParameter(r3, "oldResult");
        Logger.INSTANCE.w("EmptyCapabilityManager", "sendActionExecuteResult");
    }
}

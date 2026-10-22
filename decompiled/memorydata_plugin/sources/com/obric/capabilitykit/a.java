package com.obric.capabilitykit;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u000eH&J\"\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J5\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010 J \u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H&J\u001c\u0010*\u001a\u00020\u00032\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010-\u001a\u00020)H&J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0013H&J\u0018\u0010/\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0010\u00100\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J:\u00101\u001a\u00020\u00032\n\u0010(\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u000e2\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u000104H&¨\u00065"}, d2 = {"Lcom/obric/capabilitykit/AbstractCapabilityManager;", "", "finishFloatingActivity", "", "questionId", "", "getFloatingPendingIntent", "Landroid/app/PendingIntent;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", TrackerImpl.PARAMS, "Lcom/obric/capabilitykit/common/FloatingIntentParams;", "hideIntentResultCard", "isCardViewVisible", "", "(J)Ljava/lang/Boolean;", "isKeyguardReallyLocked", "registerIntent", ActivityLifecycle.NAME, "", "implClassName", "serviceName", "registerResultCallback", "listener", "Lcom/obric/capabilitykit/ErrorCodeCallback;", "requestStateChanged", OaidModel.KEY_ID, "stateInfo", "Lcom/obric/capabilitykit/common/TaskStateInfo;", "callback", "Lcom/obric/capabilitykit/TaskStateChangeCallback;", LocationMonitorConst.TIMEOUT, "(Ljava/lang/String;Lcom/obric/capabilitykit/common/TaskStateInfo;Lcom/obric/capabilitykit/TaskStateChangeCallback;Ljava/lang/Long;)V", "requestUriFileAccess", "uri", "Landroid/net/Uri;", ObricMemoryConstants.KEY_PACKAGE_NAME, "requester", "Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver;", "sendActionExecuteResult", "result", "Lcom/obric/capabilitykit/common/IMAppAction;", "sendIntentExecutionResult", "intentResult", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "oldResult", "stopUriFileAccess", "unregisterIntent", "unregisterResultCallback", "updateIntentResult", "isStatusChange", "ext", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface a {

    /* JADX INFO: renamed from: com.obric.capabilitykit.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class C0367a {
        public static /* synthetic */ void a(a r2, String r3, TaskStateInfo r4, TaskStateChangeCallback r5, Long r6, int r7, Object r8) {
            a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L13;
            if ((r7 & 4) == 0) goto L8;
            r5 = null;
        L8:
            if ((r7 & 8) == 0) goto L10;
            r6 = null;
        L10:
            r9.a(r3, r4, r5, r6);
            return;
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestStateChanged");
        }
    }

    PendingIntent a(long r1, Intent r3, FloatingIntentParams r4);

    void a(long r1);

    void a(Uri r1, String r2);

    void a(Uri r1, String r2, IUriFileReceiver r3);

    void a(ErrorCodeCallback r1);

    void a(IMAppAction r1);

    void a(IntentResult<?> r1, long r2, boolean r4, Map<String, String> r5);

    void a(IntentResult<?> r1, IMAppAction r2);

    void a(String r1, TaskStateInfo r2, TaskStateChangeCallback r3, Long r4);

    void a(String r1, String r2);

    void a(String r1, String r2, String r3);

    boolean a();

    void b(long r1);

    void b(ErrorCodeCallback r1);

    Boolean c(long r1);
}

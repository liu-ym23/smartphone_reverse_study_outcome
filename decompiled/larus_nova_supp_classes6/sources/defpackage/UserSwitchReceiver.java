package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.KtUtils;
import com.obric.sva.sdk.utils.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class UserSwitchReceiver {
    public static boolean a;
    public static final SwitchReceiver b = null;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"LUserSwitchReceiver$SwitchReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class SwitchReceiver extends BroadcastReceiver {
        public SwitchReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r5, Intent r6) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "intent");
            String r7 = r6.getAction();
            if (r7 != null) goto L5;
            return;
        L5:
            int r8 = KtUtils.myUserId();
            if (Intrinsics.areEqual(r7, "android.intent.action.USER_FOREGROUND") == false) goto L9;
            LogUtils.d("UserSwitchReceiver", "UserSwitch userID [" + r8 + "] to FOREGROUND", new Object[0]);
            return;
        L9:
            if (Intrinsics.areEqual(r7, "android.intent.action.USER_BACKGROUND") == false) goto L13;
            LogUtils.d("UserSwitchReceiver", "UserSwitch userID [" + r8 + "] to BACKGROUND", new Object[0]);
            return;
        }
    }

    static {
        b = new SwitchReceiver();
    }
}

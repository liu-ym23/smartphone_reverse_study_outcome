package sea;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static Bundle a(DMTaskInfo r2) {
        String r0 = null;
        if (r2 == null) goto L7;
        IMMessage r3 = r2.getMessage();
        if (r3 == null) goto L7;
        Message r4 = com.obric.assistant.special_input.util.i.a(r3);
    L8:
        if (r4 == null) goto L10;
        r0 = r4.getMessageId();
    L10:
        if (r4 == null) goto L14;
        boolean r1 = true;
        if (com.obric.assistant.utils.k.c(r4) != true) goto L14;
    L16:
        return c(r0, r1);
    L14:
        r1 = false;
    L7:
        r4 = null;
        goto L8
    }

    public static Bundle b(ObricState r2) {
        Intrinsics.checkNotNullParameter(r2, "obricState");
        String r0 = r2.getSourceMessageId();
        if (r2.getScene() != ObricInteractionScene.COMPLEX_TASK_SCENE) goto L5;
        boolean r3 = true;
    L7:
        return c(r0, r3);
    L5:
        r3 = false;
        goto L7
    }

    public static Bundle d(Intent r1) {
        Intrinsics.checkNotNullParameter(r1, MemorySourceLinkType.INTENT);
        Bundle r2 = r1.getBundleExtra("lockScreenAuthReportParams");
        Context r0 = BadParcelableCrashOptimizer.getContext();
        if (r2 == null) goto L6;
        if (r0 == null) goto L6;
        r2.setClassLoader(r0.getClassLoader());
    L6:
        return r2;
    }

    public static Bundle c(String r5, boolean r6) {
        if (r5 != null) goto L5;
    L12:
        FLogger.a.i("LockScreenAuthReportParams", "build reportParams=null, messageId=" + r5 + ", isOmni=" + r6);
        return null;
    L5:
        if ((!StringsKt.isBlank(r5)) == false) goto L7;
        String r2 = r5;
    L8:
        if (r2 == null) goto L12;
        Bundle r7 = new Bundle();
        r7.putString("message_id", r2);
        r7.putInt("is_omni", r6 ? 1 : 0);
        FLogger.a.i("LockScreenAuthReportParams", "build reportParams=".concat(com.obric.assistant.common.utils.e.b(r7)));
        return r7;
    L7:
        r2 = null;
        goto L8
    }

    public static void e(Intent r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, MemorySourceLinkType.INTENT);
        if (r2 == null) goto L6;
        r1.putExtra("lockScreenAuthReportParams", r2);
        return;
    }

    public static void f(Intent r2, ObricState r3) {
        Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
        Intrinsics.checkNotNullParameter(r3, "obricState");
        if (r3.getScene() != ObricInteractionScene.COMPLEX_TASK_SCENE) goto L6;
        e(r2, b(r3));
        return;
    }
}

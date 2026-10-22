package com.obric.miniapp.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/miniapp/alarm/LiveCardAlarmExpireReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveCardAlarmExpireReceiver extends BroadcastReceiver {

    public static final class a {
    }

    static {
    }

    public LiveCardAlarmExpireReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r19, Intent r20) {
        com.bytedance.ai.utils.g r1 = com.bytedance.ai.utils.g.a;
        r1.i("LiveCardAlarmExpireReceiver", "onReceive");
        if (r20 != null) goto L5;
        return;
    L5:
        String r2 = r20.getAction();
        boolean r4 = false;
        if (r2 != null) goto L8;
    L10:
        if (r4 == true) goto L13;
        r1.i("LiveCardAlarmExpireReceiver", "onReceive ignore action=" + r2);
        return;
    L13:
        String r5 = r20.getStringExtra("extra_id");
        if (r5 != null) goto L16;
        return;
    L16:
        long r8 = r20.getLongExtra("extra_task_id", 0);
        long r10 = r20.getLongExtra("extra_expire_at_ms", 0);
        r1.i("LiveCardAlarmExpireReceiver", "onReceive id=" + r5 + ", taskId=" + r8 + ", expireAtMs=" + r10);
        LiveCardAlarmExpirationController r0 = LiveCardAlarmExpirationController.a;
        Intrinsics.checkNotNullParameter(r5, "id");
        BuildersKt.launch$default(LiveCardAlarmExpirationController.b, null, null, new LiveCardAlarmExpirationController$handleExpireAlarm$1(r5, r8, r10, null), 3, null);
        return;
    L8:
        if (StringsKt.startsWith$default(r2, "com.obric.miniapp.alarm.action.EXPIRE_LIVE_CARD", false, 2, null) != true) goto L10;
        r4 = true;
        goto L10
    }
}

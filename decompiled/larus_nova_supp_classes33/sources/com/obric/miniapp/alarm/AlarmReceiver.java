package com.obric.miniapp.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/miniapp/alarm/AlarmReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlarmReceiver extends BroadcastReceiver {

    public static final class a {
    }

    static {
    }

    public AlarmReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r7, Intent r8) {
        if (r8 == null) goto L5;
        String r9 = r8.getAction();
    L6:
        if (r9 == null) goto L26;
        int r0 = r9.hashCode();
        if (r0 == (-2099525221)) goto L22;
        if (r0 == (-1918634688)) goto L18;
        if (r0 == 798292259) goto L15;
        return;
    L15:
        if (r9.equals("android.intent.action.BOOT_COMPLETED") == false) goto L27;
    L20:
        AlarmManager.a.getClass();
        BuildersKt.launch$default(AlarmManager.b, null, null, new AlarmManager$launchRescheduleAlarm$1(null), 3, null);
        return;
    L27:
        return;
    L18:
        if (r9.equals("android.app.action.SCHEDULE_EXACT_ALARM_PERMISSION_STATE_CHANGED") == true) goto L20;
        return;
    L22:
        if (r9.equals("com.obric.appletapp.action.TRIGGER_ALARM") == false) goto L31;
        AlarmManager.a.getClass();
        BuildersKt.launch$default(AlarmManager.b, null, null, new AlarmManager$triggerAlarms$1(null), 3, null);
        return;
    L31:
        return;
    L26:
        return;
    L5:
        r9 = null;
        goto L6
    }
}

package com.larus.dora.o.impl.diary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/dora/o/impl/diary/ODiaryEnvObserveMark$initResident$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiaryEnvObserveMark$initResident$1 extends BroadcastReceiver {
    public ODiaryEnvObserveMark$initResident$1() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r3, Intent r4) {
        if (r4 == null) goto L4;
        String r5 = r4.getAction();
    L6:
        if (Intrinsics.areEqual(r5, "action.DEVICE_UNBIND") == true) goto L8;
        return;
    L8:
        String r6 = r4.getStringExtra("mac");
        if (r6 != null) goto L11;
    L14:
        boolean r7 = true;
    L16:
        if (r7 == false) goto L19;
        FLogger.a.w("ODiaryEnvMark", "unbind without mac, skip clear");
        return;
    L19:
        FLogger.a.i("ODiaryEnvMark", "device unbind, clear diary env mark");
        IDoraPageConfig r8 = d0.a();
        if (r8 == null) goto L23;
        r8.h(r6);
        return;
    L23:
        return;
    L11:
        if (r6.length() == 0) goto L14;
        r7 = false;
        goto L16
    L4:
        r5 = null;
        goto L6
    }
}

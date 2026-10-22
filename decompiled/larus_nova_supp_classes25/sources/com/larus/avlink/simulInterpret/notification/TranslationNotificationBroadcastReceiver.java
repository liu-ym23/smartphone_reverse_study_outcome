package com.larus.avlink.simulInterpret.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.keva.Keva;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import da8.a;
import ha8.d;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/avlink/simulInterpret/notification/TranslationNotificationBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class TranslationNotificationBroadcastReceiver extends BroadcastReceiver {
    public TranslationNotificationBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r4, Intent r5) {
        if (r4 == null) goto L23;
        if (r5 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r5.getAction(), "com.larus.dora.translation.speaker.icon.click") == false) goto L13;
        a.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "context");
        Keva r6 = DoraConfig.a;
        if (r6.getBoolean("key_si_mute", false) == false) goto L10;
        r6.storeBoolean("key_si_mute", false);
    L11:
        a.a(r4, a.c);
        return;
    L10:
        r6.storeBoolean("key_si_mute", true);
        goto L11
    L13:
        if (Intrinsics.areEqual(r5.getAction(), "com.larus.dora.translation.end.si.click") == false) goto L25;
        a.a.getClass();
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r7 == null) goto L19;
        SessionService r8 = r7.d();
        if (r8 == null) goto L19;
        r8.y(3, DoraCallStateCode.DOUBAO_STOP_SI_BY_NOTIFICATION, false);
    L19:
        LinkedHashMap r9 = new LinkedHashMap();
        boolean r10 = d.a;
        r9.put("task_id", d.b);
        r9.put("click_position", "live_activity");
        IDoraService r11 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r11 == null) goto L26;
        r11.A0("dora_interpretation_end_click", r9);
        return;
    L26:
        return;
    L25:
        return;
    }
}

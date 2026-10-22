package com.obric.assistant.ipc;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.voice.IWakeupTruthCaptureSwitchSyncService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sna.c;
import sna.f;
import sna.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/ipc/WakeupTruthCaptureSwitchSyncServiceImpl;", "Lcom/obric/assistant/voice/IWakeupTruthCaptureSwitchSyncService;", "<init>", "()V", "syncCloudEnabled", "", "cloudEnabled", "", WindowEvent.Params.REASON, "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeupTruthCaptureSwitchSyncServiceImpl implements IWakeupTruthCaptureSwitchSyncService {

    public static final class a {
    }

    static {
    }

    public WakeupTruthCaptureSwitchSyncServiceImpl() {
    }

    @Override // com.obric.assistant.voice.IWakeupTruthCaptureSwitchSyncService
    public final void a(boolean r7) {
        Intrinsics.checkNotNullParameter("audio_capture_settings_read", WindowEvent.Params.REASON);
        boolean r2 = i.a();
        if (r2 != r7) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter("audio_capture_settings_read", WindowEvent.Params.REASON);
        Context r3 = f.a;
        Intrinsics.checkNotNullParameter("wakeup_truth_capture_enabled", "key");
        c r5 = f.b();
        r5.getClass();
        Intrinsics.checkNotNullParameter("wakeup_truth_capture_enabled", "key");
        r5.a().storeBoolean("wakeup_truth_capture_enabled", r7);
        WakeupTruthCaptureSwitchRefresher.a.getClass();
        Intrinsics.checkNotNullParameter("audio_capture_settings_read", WindowEvent.Params.REASON);
        IpcMessenger.k(IpcMessenger.a, 10, r7 ? 1 : 0, "audio_capture_settings_read", 4);
        FLogger.a.i("WakeupTruthCaptureSwitchSyncService", "syncCloudEnabled updated enabled=" + r7 + " previous=" + r2 + " reason=audio_capture_settings_read");
    }
}

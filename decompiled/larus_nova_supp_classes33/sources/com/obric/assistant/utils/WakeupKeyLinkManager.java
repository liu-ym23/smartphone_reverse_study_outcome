package com.obric.assistant.utils;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class WakeupKeyLinkManager {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a() {
        String r0 = rna.b.a;
        sna.h.a().erase("voiceprint_fail_time");
        sna.h.a().erase("voiceprint_fail_wakeup_id");
        sna.h.b("clearVoiceprintFailRecord success");
        FLogger.a.i("WakeupKeyLinkManager", "clearVoiceprintFailRecord: cleared=true");
    }

    @JvmStatic
    public static final void b() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WakeupKeyLinkManager$onManualWakeup$1(null), 3, null);
    }
}

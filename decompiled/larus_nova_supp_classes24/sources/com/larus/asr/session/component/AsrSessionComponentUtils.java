package com.larus.asr.session.component;

import com.larus.asr.VoiceInputType;
import com.larus.asr.x5;
import com.larus.im.bean.message.Message;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AsrSessionComponentUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public AsrSessionComponentUtils() {
    }

    public static void e() {
        if (x5.c().a() == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AsrSessionComponentUtils$restoreDoraAudio$1(null), 3, null);
    }

    public static void d(f0 r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        IObricDoraService r0 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.t() != true) goto L7;
    L8:
        if (r2 == true) goto L10;
    L11:
        e();
    L12:
        if (r2 == true) goto L14;
        return;
    L14:
        if (r3.q == false) goto L18;
        r3.q = false;
        return;
    L18:
        return;
    L10:
        if (r3.q == true) goto L12;
    L7:
        r2 = false;
        goto L8
    }

    public static void c(com.larus.asr.session.p r65, f0 r66) {
        Intrinsics.checkNotNullParameter(r65, "sessionContext");
        Intrinsics.checkNotNullParameter(r66, "context");
        String r19 = UUID.randomUUID().toString();
        String r4 = null;
        Message r2 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, r19, r19, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -49153, 31, null);
        Map r3 = r2.getExt();
        if (r3 == null) goto L5;
        Map r5 = MapsKt.toMutableMap(r3);
    L6:
        r65.Q9(r5);
        Message r0 = Message.copy$default(r2, null, null, null, 0, 0, null, 0, false, null, null, null, null, null, r5, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -8193, 31, null);
        r66.d = r0;
        if (r0 == null) goto L9;
        r4 = r0.getLocalMessageId();
    L9:
        r66.m = r4;
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static void a(com.larus.asr.session.p r7, String r8, VoiceInputType r9, boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r7, "sessionContext");
        Intrinsics.checkNotNullParameter(r8, "taskId");
        Intrinsics.checkNotNullParameter(r9, "voiceInputType");
        Intrinsics.checkNotNullParameter(r11, "reason");
        r7.L8(false, r10, r11, r9, r8);
    }

    public static /* synthetic */ void b(com.larus.asr.session.p r0, String r1, VoiceInputType r2, String r3, int r4) {
        if ((r4 & 4) == 0) goto L5;
        r2 = VoiceInputType.TouchSpeaker;
    L5:
        a(r0, r1, r2, false, r3);
    }
}

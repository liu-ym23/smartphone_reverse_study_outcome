package com.larus.audio.utils;

import com.larus.media.MediaResourceManager;
import com.obric.assistant.spi.audio.IObricRealtimeCallExtService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j0 {
    static {
    }

    public static boolean a() {
        IObricRealtimeCallExtService r0 = (IObricRealtimeCallExtService) ServiceManager.get().getService(IObricRealtimeCallExtService.class);
        if (r0 == null) goto L5;
        boolean r1 = r0.isAssistantListening();
    L6:
        int r2 = c68.b.a;
        c68.b.a("AudioUtils", "O_CALL isListening: " + r1);
        Lazy r3 = MediaResourceManager.a;
        if (MediaResourceManager.i("O_CALL") == false) goto L11;
        if (r1 == false) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    L5:
        r1 = false;
        goto L6
    }
}

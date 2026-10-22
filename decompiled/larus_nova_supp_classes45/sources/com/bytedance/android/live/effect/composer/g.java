package com.bytedance.android.live.effect.composer;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.log.d0;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g<T> implements Consumer {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        List r0 = com.bytedance.android.livesdk.log.a.a;
        Intrinsics.checkNotNullParameter("loadStickerByEffectId", "message");
        Iterator r1 = ((ArrayList) com.bytedance.android.livesdk.log.a.a).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        if (((d0) r1.next()).a("ttlive_anchor_effect_LiveComposerManagerB") == true) goto L4;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L16;
        ALogger.w("ttlive_anchor_effect_LiveComposerManagerB", "loadStickerByEffectId", r6);
        return;
    L16:
        return;
    L8:
        r2 = false;
        goto L9
    }
}

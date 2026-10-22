package com.ss.ugc.effectplatform.extension;

import bytekn.foundation.encryption.d;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.model.Effect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final boolean a(Effect r7) {
        String r0 = r7.getExtra();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        boolean r1 = Intrinsics.areEqual(bytekn.foundation.encryption.b.a(d.a(ByteArrayExKt.a(r7.getId() + "swv2naghkXiK5usX" + r0))), r7.getExtra_tag());
        if (r1 == true) goto L9;
        Logger.e$default(Logger.INSTANCE, "EffectEx", r7.getEffect_id() + " verify failed", null, 4, null);
    L9:
        return r1;
    }
}

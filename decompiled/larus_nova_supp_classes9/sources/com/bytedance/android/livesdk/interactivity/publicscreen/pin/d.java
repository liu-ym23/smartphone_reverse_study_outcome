package com.bytedance.android.livesdk.interactivity.publicscreen.pin;

import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> {
    public final /* synthetic */ f a;

    public d(f r1) {
        this.a = r1;
    }

    public final boolean a(f r2) {
        if ((r2 instanceof z) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((z) r2).H, ((z) this.a).H) == false) goto L7;
        return true;
    }
}

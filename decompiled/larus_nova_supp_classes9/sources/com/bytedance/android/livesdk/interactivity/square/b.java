package com.bytedance.android.livesdk.interactivity.square;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends BaseTimingUpdater<Object> {
    public final long c;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final void c() {
        e(Unit.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final long d() {
        return this.c;
    }

    public b(long r1) {
        this.c = r1;
    }
}

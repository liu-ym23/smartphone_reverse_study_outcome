package j52;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater;
import l52.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends BaseTimingUpdater<d> {
    public final long c;
    public final int d;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final void c() {
        e(new d(this.d));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final long d() {
        return this.c;
    }

    public b(int r5, int r6) {
        this.c = ((long) r5) * 1000;
        this.d = r6;
    }
}

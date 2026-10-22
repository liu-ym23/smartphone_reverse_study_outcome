package dv0;

import com.bytedance.android.live.profit.scoreboard.dto.r;
import com.bytedance.android.livesdk.message.model.k7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements e {
    public final e a;

    @Override // dv0.e
    public final k7 getEntranceInfo() {
        return this.a.getEntranceInfo();
    }

    @Override // dv0.e
    public final r getExtra() {
        return this.a.getExtra();
    }

    @Override // dv0.e
    public final String getMiniAppId() {
        return this.a.getMiniAppId();
    }

    @Override // dv0.e
    public final long getRoundId() {
        return this.a.getRoundId();
    }

    public j(i r2) {
        Intrinsics.checkNotNullParameter(r2, "common");
        this.a = r2;
    }
}

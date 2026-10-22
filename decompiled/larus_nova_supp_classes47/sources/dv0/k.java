package dv0;

import com.bytedance.android.live.profit.scoreboard.dto.r;
import com.bytedance.android.livesdk.message.model.k7;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements e {
    public final e a;
    public final long b;
    public final long c;
    public final long d;
    public final List<d> e;
    public final long f;

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

    public k(i r2, long r3, long r5, long r7, List r9, long r10) {
        Intrinsics.checkNotNullParameter(r2, "common");
        Intrinsics.checkNotNullParameter(r9, "players");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r9;
        this.f = r10;
    }
}

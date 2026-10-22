package com.bytedance.android.live.network;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.annotation.PbRequest;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public final String a;
    public final int b;
    public final boolean c;

    public /* synthetic */ d() {
        this("", 1, false);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L12;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = ((r1 * 31) + this.b) * 31;
        boolean r3 = this.c;
        ?? r4 = r3;
        if (r3 == false) goto L10;
        r4 = 1;
    L10:
        return r2 + r4;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "PbAdapterConfig(pbRequestSwitches=" + this.a + ", enterSwitches=" + this.b + ", strategySwitch=" + this.c + ")";
    }

    public final JSONObject a() {
        int r0 = this.b;
        if (r0 != 1) goto L5;
        JSONObject r1 = new JSONObject(this.a).put(PbRequest.SwitchType.ROOM, false);
    L9:
        r1.put(PbRequest.SwitchType.RANK_LIST, false);
        r1.put(PbRequest.SwitchType.POPULAR, false);
        r1.put(PbRequest.SwitchType.REPORT, false);
        r1.put(PbRequest.SwitchType.DYNAMIC_STRATEGY, this.c);
        ALogger.i("PbAdapterConfig", "response-format proto override setting to closed cause aggressive fuse");
        return r1;
    L5:
        if (r0 == 2) goto L7;
        r1 = new JSONObject(this.a);
        goto L9
    L7:
        r1 = new JSONObject(this.a).put(PbRequest.SwitchType.ROOM, true);
        goto L9
    }

    public d(String r1, int r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

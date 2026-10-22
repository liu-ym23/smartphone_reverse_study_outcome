package com.bytedance.android.live.broadcastgame.api.openplatform;

import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public final Room a;
    public final String b;
    public final boolean c;
    public final boolean d;

    public e() {
        this(null, null, 15);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L14;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        Room r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        boolean r6 = this.c;
        ?? r7 = 1;
        ?? r8 = r6;
        if (r6 == false) goto L12;
        r8 = 1;
    L12:
        int r9 = (r5 + r8) * 31;
        boolean r11 = this.d;
        if (r11 == true) goto L17;
        r7 = r11;
    L17:
        return r9 + r7;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LaunchLogParam(room=" + this.a + ", launchFrom=" + this.b + ", isRetry=" + this.c + ", isAutoLaunch=" + this.d + ")";
    }

    public final void a(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "json");
        r4.put("is_retry", this.c);
        Room r0 = this.a;
        if (r0 == null) goto L5;
        LiveMode r1 = r0.getStreamType();
        int r2 = h1.a;
        r4.put("live_type", i1.a(r1));
        r4.put("room_id", this.a.getRoomId());
        r4.put("anchor_id", this.a.getAnchorId());
    L5:
        r4.put("auto_launch", this.d);
    }

    public e(Room r2, String r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = "anchor";
    L8:
        Intrinsics.checkNotNullParameter(r3, "launchFrom");
        this.a = r2;
        this.b = r3;
        this.c = false;
        this.d = false;
    }
}

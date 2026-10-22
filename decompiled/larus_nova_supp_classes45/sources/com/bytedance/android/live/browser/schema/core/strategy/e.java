package com.bytedance.android.live.browser.schema.core.strategy;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends c {
    public final long b;
    public final long c;
    public final b d;

    public static final class a implements c.b {
        public final b a;

        public a(q30.a r2) {
            Intrinsics.checkNotNullParameter(r2, "timeProvider");
            this.a = r2;
        }

        @Override // com.bytedance.android.live.browser.schema.core.strategy.c.b
        public final c a(JSONObject r8) {
            Intrinsics.checkNotNullParameter(r8, "json");
            return new e(r8.optLong("startTime", 0), r8.optLong("endTime", Long.MAX_VALUE), this.a);
        }
    }

    public interface b {
        long a();
    }

    @Override // com.bytedance.android.live.browser.schema.core.strategy.c
    public final boolean a(JSONObject r11) {
        Intrinsics.checkNotNullParameter(r11, "currentState");
        long r0 = this.b;
        if (r0 == 0) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L25;
        if (r0 >= this.c) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L23;
        long r3 = this.d.a();
        r11.put("current_ts", String.valueOf(r3));
        long r4 = this.b;
        long r6 = this.c;
        if (r4 <= r3) goto L19;
        return false;
    L19:
        if (r6 <= r3) goto L26;
        return true;
    L26:
        return false;
    L23:
        throw new IllegalStateException("startTime must less than endTime, please check config".toString());
    L13:
        r1 = false;
        goto L14
    L25:
        throw new IllegalStateException("startTime and endTime not exists, please check config".toString());
    L5:
        if (this.c != Long.MAX_VALUE) goto L8;
        r2 = false;
        goto L9
    }

    public e(long r2, long r4, b r6) {
        Intrinsics.checkNotNullParameter(r6, "timeProvider");
        super(2);
        this.b = r2;
        this.c = r4;
        this.d = r6;
    }
}

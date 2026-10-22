package com.ss.android.lark.optrace.core;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.optrace.api.TracingSpanData;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class TracingSpanMemData implements TracingSpanData {
    private final String span;

    public String toString() {
        return "TracingSpanMemData{span='" + this.span + "'}";
    }

    public TracingSpanMemData() {
        String[] r0 = lyb.a.a;
        String r1 = UUID.randomUUID().toString().replace("-", "");
        StringBuilder r3 = new StringBuilder();     // Catch: Exception -> L8
        int r4 = 0;
    L4:
        if (r4 >= 8) goto L6;
        int r5 = r4 * 4;     // Catch: Exception -> L8
        int r6 = CastIntegerProtector.parseInt(r1.substring(r5, r5 + 4), 16);     // Catch: Exception -> L8
        String[] r7 = lyb.a.a;     // Catch: Exception -> L8
        r3.append(r7[r6 % r7.length]);     // Catch: Exception -> L8
        r4 = r4 + 1;     // Catch: Exception -> L8
        goto L4
    L6:
        String r2 = r3.toString();     // Catch: Exception -> L8
    L9:
        this.span = r2;
        return;
    L8:
        r2 = r1.substring(0, 8);
        goto L9
    }

    @Override // com.ss.android.lark.optrace.api.TracingSpanData
    public String getSpan() {
        return this.span;
    }
}

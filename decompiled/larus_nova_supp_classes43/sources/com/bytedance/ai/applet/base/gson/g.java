package com.bytedance.ai.applet.base.gson;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonParseException;
import com.google.gson.ToNumberStrategy;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static final a a = null;

    public static final class a implements ToNumberStrategy {
        public a() {
        }

        public final Number readNumber(JsonReader r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            String r0 = r11.nextString();
            Intrinsics.checkNotNull(r0);     // Catch: NumberFormatException -> L5
            return Long.valueOf(CastLongProtector.parseLong(r0));
        L5:
            Intrinsics.checkNotNull(r0);
            double r10 = CastDoubleProtector.parseDouble(r0);     // Catch: NumberFormatException -> L22
            if (Double.isInfinite(r10) == true) goto L11;
            if (Double.isNaN(r10) == true) goto L11;
        L12:
            boolean r12 = true;
            if ((r10 % ((double) 1)) == 0.0d) goto L16;
            r12 = false;
        L16:
            if (r12 == false) goto L19;
            return Long.valueOf((long) r10);
        L19:
            return Double.valueOf(r10);
        L11:
            if (r11.isLenient() == true) goto L12;
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + r10 + "; at path " + r11.getPreviousPath());     // Catch: NumberFormatException -> L22
        L22:
            e = move-exception;
            throw new JsonParseException("Cannot parse " + r0 + "; at path " + r11.getPreviousPath(), e);
        }
    }

    static {
        a = new a();
    }
}

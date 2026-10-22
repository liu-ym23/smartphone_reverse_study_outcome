package hda;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o0 {
    public final JSONObject a;

    /* JADX WARN: Multi-variable type inference failed */
    public final String d() {
        JSONObject r0 = this.a.optJSONObject("sourceInfo");
        if (r0 == null) goto L6;
        String r1 = p0.b(r0, "appName");
        if (r1 == null) goto L6;
        return r1;
    L6:
        String r2 = p0.b(this.a, "sourceAppName");
        if (r2 != null) goto L51;
        JSONArray r3 = this.a.optJSONArray("appNames");
        boolean r4 = true;
        Object r5 = null;
        if (r3 == null) goto L23;
        String r6 = r3.optString(0);
        if (r6 == null) goto L23;
        if ((!StringsKt.isBlank(r6)) == true) goto L15;
    L17:
        boolean r7 = false;
    L18:
        if (r7 == true) goto L21;
        r6 = null;
    L21:
        if (r6 == null) goto L23;
        return r6;
    L15:
        if (Intrinsics.areEqual(r6, "null") == true) goto L17;
        r7 = true;
    L23:
        String r8 = p0.b(this.a, "appNames");
        if (r8 == null) goto L47;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L37
        String r10 = new JSONArray(r8).optString(0);     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L37
        if ((!StringsKt.isBlank(r10)) == true) goto L29;
    L31:
        r4 = false;
    L32:
        if (r4 == true) goto L35;
        r10 = null;
    L35:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L37
    L40:
        if (Result.isFailure-impl(r11) == true) goto L43;
        r5 = r11;
    L43:
        r5 = (String) r5;
        if (r5 != null) goto L47;
        return r8;
    L29:
        if (Intrinsics.areEqual(r10, "null") == true) goto L31;
    L37:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L47:
        return r5;
    L51:
        return r2;
    }

    public o0(q0 r2) {
        Intrinsics.checkNotNullParameter(r2, "record");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(new JSONObject(r2.e));     // Catch: Throwable -> L5
    L8:
        if (Result.exceptionOrNull-impl(r3) == null) goto L11;
        r3 = new JSONObject();
    L11:
        this.a = (JSONObject) r3;
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final JSONArray a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.a.optJSONArray(r2);
    }

    public final Long b(String... r5) {
        Intrinsics.checkNotNullParameter(r5, "keys");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        String r2 = r5[r1];
        if (this.a.has(r2) == false) goto L13;
        if (this.a.isNull(r2) == true) goto L13;
        Long r3 = StringsKt.toLongOrNull(this.a.optString(r2));
        if (r3 == null) goto L13;
        return Long.valueOf(r3.longValue());
    L13:
        r1 = r1 + 1;
        goto L3
    L14:
        return null;
    }

    public final String c(String... r5) {
        Intrinsics.checkNotNullParameter(r5, "keys");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        String r2 = r5[r1];
        String r3 = p0.b(this.a, r2);
        if (r3 != null) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }
}

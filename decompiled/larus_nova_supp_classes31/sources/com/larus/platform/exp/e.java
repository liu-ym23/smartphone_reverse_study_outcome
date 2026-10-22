package com.larus.platform.exp;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static final e a = null;
    public static final Object b = null;
    public static final Map<String, Boolean> c = null;
    public static final Lazy d = null;

    public static final class a {
        public final boolean a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            long r1 = this.b;
            return (r0 * 31) + ((int) (r1 ^ (r1 >>> 32)));
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "Record(opened=" + this.a + ", updateTimestampMs=" + this.b + ')';
        }

        public a(boolean r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public e() {
    }

    static {
        a = new e();
        b = new Object();
        c = new LinkedHashMap();
        d = LazyKt.lazy(new d());
    }

    public static boolean a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "doubaoUid");
        String r5 = StringsKt.trim(r4).toString();
        boolean r1 = false;
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        FLogger.a.e("DoubaoIMFeatureStore", "freezeSnapshot normalizedUid is empty");
        return false;
    L9:
        Object r2 = b;
        monitor-enter(r2);
        LinkedHashMap r3 = (LinkedHashMap) c;     // Catch: Throwable -> L20
        Object r6 = r3.get(r5);     // Catch: Throwable -> L20
        if (r6 != null) goto L17;
        a.getClass();     // Catch: Throwable -> L20
        a r7 = b(r5);     // Catch: Throwable -> L20
        if (r7 == null) goto L16;
        r1 = r7.a;     // Catch: Throwable -> L20
    L16:
        r6 = Boolean.valueOf(r1);     // Catch: Throwable -> L20
        r3.put(r5, r6);     // Catch: Throwable -> L20
    L17:
        boolean r8 = ((Boolean) r6).booleanValue();     // Catch: Throwable -> L20
        monitor-exit(r2);
        return r8;
    L20:
        th = move-exception;
        throw th;
    L5:
        r0 = false;
        goto L6
    }

    public static a b(String r6) {
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L17
        String r4 = ((Keva) d.getValue()).getString("doubao_im_feature_opened::" + r6, null);     // Catch: Throwable -> L17
        if (r4 == null) goto L14;
        JSONObject r5 = new JSONObject(r4);     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(r5.optString("doubao_uid"), r6) == false) goto L14;
        if ((r5.opt("im_feature_opened") instanceof Boolean) == false) goto L14;
        if ((r5.opt("update_timestamp_ms") instanceof Number) == false) goto L14;
        a r7 = new a(r5.optBoolean("im_feature_opened"), r5.optLong("update_timestamp_ms"));     // Catch: Throwable -> L17
    L15:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L17
    L19:
        Throwable r0 = Result.exceptionOrNull-impl(r8);
        if (r0 == null) goto L23;
        FLogger.a.e("DoubaoIMFeatureStore", "read persisted IM feature value failed", r0);
    L23:
        if (Result.isFailure-impl(r8) == true) goto L27;
        r2 = r8;
    L27:
        return (a) r2;
    L14:
        r7 = null;
    L17:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }
}

package com.obric.assistant;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static final e a = null;
    public static final Lazy b = null;

    public static final class a {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Model(displayModel=" + this.a + ", model=" + this.b + ')';
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "displayModel");
            Intrinsics.checkNotNullParameter(r3, "model");
            this.a = r2;
            this.b = r3;
        }
    }

    public e() {
    }

    static {
        a = new e();
        b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new d());
    }

    public static a a(String r6) {
        boolean r0 = true;
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        Object r3 = null;
        if (r2 == false) goto L50;
        return null;
    L50:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L42
        JsonObject r7 = (JsonObject) ((Gson) b.getValue()).fromJson(r6, JsonObject.class);     // Catch: Throwable -> L42
        JsonElement r5 = r7.get("display_model");     // Catch: Throwable -> L42
        if (r5 == null) goto L16;
        String r8 = r5.getAsString();     // Catch: Throwable -> L42
    L17:
        String r9 = NameKeys.UnloadStrategy_No_Strategy;
        if (r8 != null) goto L20;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L20:
        JsonElement r10 = r7.get("model");     // Catch: Throwable -> L42
        if (r10 == null) goto L23;
        String r11 = r10.getAsString();     // Catch: Throwable -> L42
    L24:
        if (r11 == null) goto L28;
        r9 = r11;
    L28:
        if (r8.length() != 0) goto L30;
        boolean r12 = true;
    L31:
        if (r12 == false) goto L33;
    L39:
        a r13 = null;
    L40:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L42
    L45:
        if (Result.isFailure-impl(r14) == true) goto L49;
        r3 = r14;
    L49:
        return (a) r3;
    L33:
        if (r9.length() == 0) goto L36;
        r0 = false;
    L36:
        if (r0 == true) goto L39;
        r13 = new a(r8, r9);     // Catch: Throwable -> L42
        goto L40
    L30:
        r12 = false;
        goto L31
    L23:
        r11 = null;
        goto L24
    L16:
        r8 = null;
    L42:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static String b(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "displayModel");
        Intrinsics.checkNotNullParameter(r5, "model");
        return GsonProtectorUtils.toJson((Gson) b.getValue(), MapsKt.mapOf(new Pair[]{TuplesKt.to("display_model", r4), TuplesKt.to("model", r5)}));
    }
}

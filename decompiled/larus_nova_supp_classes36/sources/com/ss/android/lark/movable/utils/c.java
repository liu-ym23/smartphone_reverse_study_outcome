package com.ss.android.lark.movable.utils;

import android.graphics.fonts.Font;
import com.google.gson.Gson;
import com.ss.android.lark.storage.LarkKVStorage;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final c a = null;
    public static final String b = null;
    public static final Map<String, a> c = null;
    public static final Map<String, Font> d = null;

    public static final class a {
        public final String a;
        public final int b;

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
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "ResolvedFontInfo(path=" + this.a + ", ttcIndex=" + this.b + ')';
        }

        public a(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "path");
            this.a = r2;
            this.b = r3;
        }
    }

    public c() {
    }

    static {
        a = new c();
        b = "FontPathRecorder";
        LinkedHashMap r0 = new LinkedHashMap();
        c = r0;
        d = new LinkedHashMap();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        boolean r3 = true;
        String r2 = LarkKVStorage.p(new com.ss.android.lark.storage.a("movable"), "movable::font_path", true).getString("movable::font_map", "");     // Catch: Throwable -> L13
        if (r2 != null) goto L6;
    L9:
        if (r3 == true) goto L11;
        Type r4 = new d().getType();     // Catch: Throwable -> L13
        r0.putAll((Map) new Gson().fromJson(r2, r4));     // Catch: Throwable -> L13
    L11:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L6:
        if (r2.length() == 0) goto L9;
        r3 = false;
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}

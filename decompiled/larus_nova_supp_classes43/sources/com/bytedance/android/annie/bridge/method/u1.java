package com.bytedance.android.annie.bridge.method;

import android.util.Pair;
import com.bytedance.android.annie.bridge.method.abs.RequestResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u1 {
    public int a;
    public List<? extends Pair<String, String>> b;
    public byte[] c;

    public static abstract class a {
        public final e7.s0 a;

        public a(e7.s0 r10) {
            Intrinsics.checkNotNullParameter(r10, "params");
            this.a = r10;
        }

        public final RequestResultModel a(u1 r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            RequestResultModel r0 = new RequestResultModel();
            r0.b(RequestResultModel.Code.Success);
            String r1 = this.a.f();
            Intrinsics.checkNotNull(r1);
            byte[] r11 = r10.c;
            if (Intrinsics.areEqual(r1, "json") == false) goto L5;
            JsonParser r12 = new JsonParser();
            Intrinsics.checkNotNull(r11);
            JsonObject r13 = GsonProtectorUtils.parse(r12, new String(r11, Charsets.UTF_8)).getAsJsonObject();
        L6:
            r0.f(r13);
            r0.d(Integer.valueOf(r10.a));
            r0.g(this.a.f());
            List<? extends Pair<String, String>> r14 = r10.b;
            if (r14 == null) goto L12;
            JsonObject r15 = new JsonObject();
            Iterator<T> r16 = r14.iterator();
        L10:
            if (r16.hasNext() == false) goto L13;
            Pair r17 = (Pair) r16.next();
            r15.addProperty((String) r17.first, (String) r17.second);
        L13:
            r0.c(r15);
            return r0;
        L12:
            r15 = null;
            goto L13
        L5:
            Intrinsics.checkNotNull(r11);
            r13 = new String(r11, Charsets.UTF_8);
            goto L6
        }
    }

    public static final class b extends a {
        public final e7.s0 b;
        public final c c;
        public final CallContext d;

        public static String b(JsonElement r10) {
            if (r10 != null) goto L16;
            return "";
        L16:
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
            Object r1 = Result.constructor-impl(r10.getAsString());     // Catch: Throwable -> L7
        L10:
            if (Result.isFailure-impl(r1) == false) goto L12;
            r1 = null;
        L12:
            String r11 = (String) r1;
            if (r11 == null) goto L15;
            return r11;
        L15:
            return com.bytedance.android.annie.api.data.subscribe.d.c(r10);
        L7:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L10
        }

        public static List c(JsonObject r10) {
            if (r10 == null) goto L14;
            ArrayList r0 = new ArrayList();
            Iterator r11 = r10.entrySet().iterator();
        L5:
            if (r11.hasNext() == false) goto L18;
            Map.Entry r1 = (Map.Entry) r11.next();
            Object r12 = r1.getKey();
            JsonElement r13 = (JsonElement) r1.getValue();
            if (r13 == null) goto L9;
            String r14 = r13.getAsString();
        L10:
            if (r14 != null) goto L12;
            r14 = "";
        L12:
            r0.add(new Pair(r12, r14));
            goto L5
        L9:
            r14 = null;
            goto L10
        L18:
            return r0;
        L14:
            return CollectionsKt.emptyList();
        }

        public b(e7.s0 r10, t1 r11, CallContext r12) {
            Intrinsics.checkNotNullParameter(r10, "params");
            Intrinsics.checkNotNullParameter(r11, "callback");
            Intrinsics.checkNotNullParameter(r12, "context");
            super(r10);
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }
    }

    public interface c {
        void a(RequestResultModel r1);

        void onFail(Throwable r1);
    }

    public u1() {
    }
}

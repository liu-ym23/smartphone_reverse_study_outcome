package com.bytedance.android.ec.common.api.jump.model;

import java.util.Iterator;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f extends com.bytedance.android.ec.common.api.jump.model.a implements d, c {
    public final String a;
    public final String b;
    public final jf.b c;
    public final jf.e d;
    public final String e;
    public final JSONObject f;
    public final JSONObject g;

    public static final class a implements com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0115a {
        public final String a;
        public final String b;
        public final jf.b c;
        public final jf.e d;
        public final String e;
        public final JSONObject f;
        public final JSONObject g;

        @Override // com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0115a
        public final <T extends com.bytedance.android.ec.common.api.jump.model.a> T a(KClass<T> r10) {
            Intrinsics.checkNotNullParameter(r10, "modelClass");
            if (Intrinsics.areEqual(r10, Reflection.getOrCreateKotlinClass(f.class)) == false) goto L7;
            return new f(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        L7:
            return (T) JvmClassMappingKt.getJavaClass(r10).newInstance();
        }

        public a(String r10, String r11, jf.b r12, jf.e r13, String r14, JSONObject r15, JSONObject r16, int r17) {
            if ((r17 & 16) == 0) goto L6;
            r14 = null;
        L6:
            if ((r17 & 32) == 0) goto L9;
            r15 = null;
        L9:
            if ((r17 & 64) == 0) goto L11;
            r16 = null;
        L11:
            Intrinsics.checkNotNullParameter(r12, "ecomEntranceForm");
            Intrinsics.checkNotNullParameter(r13, "sourcePage");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
            this.g = r16;
        }
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof f) == false) goto L20;
        f r11 = (f) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.b;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        jf.b r15 = this.c;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        jf.e r18 = this.d;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.e;
        if (r21 == null) goto L21;
        int r22 = r21.hashCode();
    L22:
        int r23 = (r20 + r22) * 31;
        JSONObject r24 = this.f;
        if (r24 == null) goto L25;
        int r25 = r24.hashCode();
    L26:
        int r26 = (r23 + r25) * 31;
        JSONObject r27 = this.g;
        if (r27 == null) goto L30;
        r1 = r27.hashCode();
    L30:
        return r26 + r1;
    L25:
        r25 = 0;
        goto L26
    L21:
        r22 = 0;
        goto L22
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "PageParams(btm=" + this.a + ", btmPageId=" + this.b + ", ecomEntranceForm=" + this.c + ", sourcePage=" + this.d + ", newSourceType=" + this.e + ", customEntranceInfo=" + this.f + ", customAddToCartEntranceInfo=" + this.g + ")";
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.c
    public final JSONObject addToCartEntranceInfo() {
        JSONObject r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new JSONObject();
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.d
    public final JSONObject entranceInfo() {
        JSONObject r0 = new JSONObject();
        r0.put(com.bytedance.android.ec.core.event.a.KEY_CARRIER_TYPE, this.c.a);     // Catch: JSONException -> L10
        JSONObject r1 = this.f;     // Catch: JSONException -> L10
        if (r1 == null) goto L12;
        Iterator<String> r10 = r1.keys();     // Catch: JSONException -> L10
    L7:
        if (r10.hasNext() == false) goto L12;
        String r11 = r10.next();     // Catch: JSONException -> L10
        r0.put(r11, r1.opt(r11));     // Catch: JSONException -> L10
    L12:
        return r0;
    L10:
        e = move-exception;
        ye.a.b(e);
        goto L12
    }

    public f(String r10, String r11, jf.b r12, jf.e r13, String r14, JSONObject r15, JSONObject r16) {
        Intrinsics.checkNotNullParameter(r12, "ecomEntranceForm");
        Intrinsics.checkNotNullParameter(r13, "sourcePage");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
    }
}

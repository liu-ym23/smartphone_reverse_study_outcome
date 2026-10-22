package com.bytedance.android.anniex.web.model;

import android.net.Uri;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.ies.bullet.core.BulletContext;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import q26.c;
import q26.h;
import q26.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXWebModel implements j {
    public final String a;
    public final String b;
    public final Uri c;
    public final String d;
    public final boolean e;
    public final Map<String, Object> f;
    public final Map<String, Object> g;
    public final t36.j h;
    public final String i;
    public final boolean j;
    public final Lazy k;
    public final BulletContext l;
    public final Lazy m;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AnnieXWebModel) == true) goto L8;
        return false;
    L8:
        AnnieXWebModel r11 = (AnnieXWebModel) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r11.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r11.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        int r10 = 1231;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L6:
        int r11 = (r0 + r1) * 31;
        Map<String, Object> r12 = this.f;
        int r13 = 0;
        if (r12 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r11 + r14) * 31;
        Map<String, Object> r16 = this.g;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        t36.j r19 = this.h;
        if (r19 == null) goto L18;
        r13 = r19.hashCode();
    L18:
        int r20 = (((r18 + r13) * 31) + this.i.hashCode()) * 31;
        if (this.j == true) goto L23;
        r10 = 1237;
    L23:
        return r20 + r10;
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r12.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "AnnieXWebModel(businessId=" + this.a + ", url=" + this.b + ", originalUri=" + this.c + ", sessionId=" + this.d + ", enablePIA=" + this.e + ", injectData=" + this.f + ", globalProps=" + this.g + ", schemaModelUnion=" + this.h + ", enterFrom=" + this.i + ", needSccDelegate=" + this.j + ')';
    }

    public final h getServiceContext() {
        return (h) this.m.getValue();
    }

    public final Map<Class<?>, Object> getAllDependency() {
        return getServiceContext().getAllDependency();
    }

    public final String getBid() {
        return this.a;
    }

    public final <T> T a(Class<T> r1) {
        return (T) j.a.a(this, r1);
    }

    public final <T extends c> T getService(Class<T> r1) {
        return (T) j.a.b(this, r1);
    }

    public AnnieXWebModel(String r10, String r11, Uri r12, String r13, boolean r14, Map<String, Object> r15, Map<String, Object> r16, t36.j r17, String r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r10, "businessId");
        Intrinsics.checkNotNullParameter(r11, a.KEY_URL);
        Intrinsics.checkNotNullParameter(r12, "originalUri");
        Intrinsics.checkNotNullParameter(r13, "sessionId");
        Intrinsics.checkNotNullParameter(r18, "enterFrom");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = LazyKt.lazy(AnnieXWebModel$appendQueryMap$2.INSTANCE);
        BulletContext r20 = new BulletContext(r13);
        r20.f = r10;
        r20.C = true;
        this.l = r20;
        this.m = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AnnieXWebModel$serviceContext$2.INSTANCE);
    }
}

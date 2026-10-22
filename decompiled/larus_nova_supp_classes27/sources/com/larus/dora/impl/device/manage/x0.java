package com.larus.dora.impl.device.manage;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class x0 {
    public static final x0 a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final int d;
        public final int e;
        public final int f;
        public final String g;
        public final Integer h;
        public final String i;
        public final String j;

        public a() {
            this(null, null, null, 0, 0, 0, null, null, null, null);
        }

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (((((((r6 + r8) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31;
            String r10 = this.g;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            Integer r13 = this.h;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.i;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            String r20 = this.j;
            if (r20 == null) goto L31;
            r1 = r20.hashCode();
        L31:
            return r18 + r1;
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "CachedDeviceInfo(name=" + this.a + ", mac=" + this.b + ", sn=" + this.c + ", sku=" + this.d + ", type=" + this.e + ", productId=" + this.f + ", model=" + this.g + ", vendorId=" + this.h + ", softVersion=" + this.i + ", caseSoftVersion=" + this.j + ')';
        }

        public final DoraDevice a() {
            DoraDevice r0 = new DoraDevice();
            r0.name = this.a;
            r0.mac = this.b;
            r0.sn = this.c;
            r0.sku = this.d;
            r0.type = this.e;
            r0.productId = this.f;
            r0.model = this.g;
            Integer r1 = this.h;
            if (r1 == null) goto L5;
            r0.vendorId = r1.intValue();
        L5:
            r0.softVersion = this.i;
            r0.caseSoftVersion = this.j;
            return r0;
        }

        public final int getType() {
            return this.e;
        }

        public a(String r1, String r2, String r3, int r4, int r5, int r6, String r7, Integer r8, String r9, String r10) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
        }
    }

    public x0() {
    }

    static {
        a = new x0();
        b = LazyKt.lazy(new v0());
        c = LazyKt.lazy(new w0());
    }

    public static DoraDevice a() {
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L18
        String r4 = ((Keva) b.getValue()).getString("last_connected_device_info", "");     // Catch: Throwable -> L18
        if (r4 != null) goto L6;
    L9:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
        g49.d.d("DoraLastConnectedDeviceCache", "getDevice empty cache");     // Catch: Throwable -> L18
    L15:
        DoraDevice r6 = null;
    L16:
        Object r1 = Result.constructor-impl(r6);     // Catch: Throwable -> L18
    L20:
        Throwable r7 = Result.exceptionOrNull-impl(r1);
        if (r7 == null) goto L24;
        g49.d.b("DoraLastConnectedDeviceCache", "getDevice failed error=" + r7.getMessage());
    L24:
        if (Result.isFailure-impl(r1) == true) goto L28;
        r2 = r1;
    L28:
        return (DoraDevice) r2;
    L12:
        a r8 = (a) ((Gson) c.getValue()).fromJson(r4, a.class);     // Catch: Throwable -> L18
        if (r8 == null) goto L15;
        r6 = r8.a();     // Catch: Throwable -> L18
        g49.d.d("DoraLastConnectedDeviceCache", "getDevice mac=" + r6.mac + ", productId=" + r6.productId + ", model=" + r6.model);     // Catch: Throwable -> L18
        goto L16
    L6:
        if (r4.length() == 0) goto L9;
        r5 = false;
    L18:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    public static void b(DoraDevice r110, String r20) {
        Intrinsics.checkNotNullParameter(r110, "device");
        Intrinsics.checkNotNullParameter(r20, "source");
        String r6 = r110.name;
        String r15 = r110.mac;
        String r8 = r110.sn;
        int r9 = r110.sku;
        int r10 = r110.type;
        int r14 = r110.productId;
        String r13 = r110.model;
        a r4 = new a(r6, r15, r8, r9, r10, r14, r13, Integer.valueOf(r110.vendorId), r110.softVersion, r110.caseSoftVersion);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        ((Keva) b.getValue()).storeString("last_connected_device_info", ((Gson) c.getValue()).toJson(r4));     // Catch: Throwable -> L9
        String r2 = "DoraLastConnectedDeviceCache";
        g49.d.d(r2, "save source=" + r20 + ", mac=" + r15 + ", productId=" + r14 + ", model=" + r13);     // Catch: Throwable -> L7
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L12:
        Throwable r3 = Result.exceptionOrNull-impl(r1);
        if (r3 == null) goto L20;
        g49.d.b(r2, "save failed source=" + r20 + ", error=" + r3.getMessage());
        return;
    L20:
        return;
    L7:
        th = th;
    L11:
        Result.Companion r5 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
    L9:
        th = th;
        r2 = "DoraLastConnectedDeviceCache";
        goto L11
    }
}

package com.bytedance.android.ec.core.vmsdk;

import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final Function3<JSModuleManager, ai.b, String, Unit> f;
    public final String g;

    public b() {
        throw null;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof b) == false) goto L24;
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r11.c) goto L12;
        return false;
    L12:
        if (this.d == r11.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(null, null) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
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
        boolean r15 = this.c;
        ?? r16 = 1;
        ?? r17 = r15;
        if (r15 == false) goto L13;
        r17 = 1;
    L13:
        int r18 = (r14 + r17) * 31;
        boolean r19 = this.d;
        if (r19 == true) goto L17;
        r16 = r19;
    L17:
        int r20 = (r18 + r16) * 31;
        String r21 = this.e;
        if (r21 == null) goto L20;
        int r22 = r21.hashCode();
    L21:
        int r23 = (r20 + r22) * 31;
        Function3<JSModuleManager, ai.b, String, Unit> r24 = this.f;
        if (r24 == null) goto L24;
        int r25 = r24.hashCode();
    L25:
        int r26 = (((((r23 + r25) * 31) + 0) * 31) + 0) * 31;
        String r27 = this.g;
        if (r27 == null) goto L29;
        r1 = r27.hashCode();
    L29:
        return r26 + r1;
    L24:
        r25 = 0;
        goto L25
    L20:
        r22 = 0;
        goto L21
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "VmSdkConfig(scriptPath=" + this.a + ", name=" + this.b + ", enableEcJsb=" + this.c + ", enableXBridge=" + this.d + ", initPath=" + this.e + ", initJsModuleManager=" + this.f + ", initListener=null, serviceListener=null, bizName=" + this.g + ")";
    }

    public b(String r10, String r11, boolean r12, int r13) {
        boolean r1 = true;
        if ((r13 & 4) == 0) goto L6;
        r12 = true;
    L6:
        if ((r13 & 8) != 0) goto L10;
        r1 = false;
    L10:
        if ((r13 & 16) == 0) goto L12;
        String r0 = VmSdkSetting.a().c();
    L14:
        if ((r13 & 256) == 0) goto L16;
        String r14 = "shopping";
    L17:
        Intrinsics.checkNotNullParameter(r10, "scriptPath");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r14, "bizName");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r1;
        this.e = r0;
        this.f = null;
        this.g = r14;
        return;
    L16:
        r14 = null;
        goto L17
    L12:
        r0 = null;
        goto L14
    }
}

package com.larus.bmhome.taskskill.network;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q {
    public final String a;
    public final String b;
    public final String c;

    public q() {
        String r0 = null;
        this(r0, r0, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
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
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "TaskSkillRequestParam(conversationId=" + this.a + ", pcDeviceId=" + this.b + ", folderWorkspace=" + this.c + ')';
    }

    public final String a() {
        String r0 = this.a;
        String r1 = "";
        if (r0 == null) goto L23;
        String r4 = null;
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L23;
        String r2 = this.b;
        if (r2 == null) goto L23;
        if ((!StringsKt.isBlank(r2)) == false) goto L15;
        r4 = r2;
    L15:
        if (r4 == null) goto L23;
        String[] r3 = new String[3];
        r3[0] = r0;
        r3[1] = r4;
        String r5 = this.c;
        if (r5 == null) goto L21;
        r1 = r5;
    L21:
        r3[2] = r1;
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r3), "#", null, null, 0, null, null, 62, null);
    L23:
        return "";
    }

    public final boolean b() {
        String r0 = this.b;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        return !r1;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    public /* synthetic */ q(String r3, String r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(null, r3, r4);
    }

    public q(String r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

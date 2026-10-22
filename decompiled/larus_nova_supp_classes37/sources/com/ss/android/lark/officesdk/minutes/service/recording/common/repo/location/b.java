package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final String a;
    public final MmLocationIdentityType b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmLocationIdentityType.values().length];
            r0[MmLocationIdentityType.RECORDING_ID.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MmLocationIdentityType.MINUTES_TOKEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "MmLocationIdentity(value=" + this.a + ", type=" + this.b + ')';
    }

    public final MmLocationIdentityType getType() {
        return this.b;
    }

    public b(String r2, MmLocationIdentityType r3) {
        Intrinsics.checkNotNullParameter(r2, "value");
        Intrinsics.checkNotNullParameter(r3, "type");
        this.a = r2;
        this.b = r3;
    }
}

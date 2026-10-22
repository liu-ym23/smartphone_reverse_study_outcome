package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final String a;
    public final MmAudioSaveIdentityType b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmAudioSaveIdentityType.values().length];
            r0[MmAudioSaveIdentityType.RECORDING_ID.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MmAudioSaveIdentityType.MINUTES_TOKEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
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
        return "MmAudioSaveIdentity(value=" + this.a + ", type=" + this.b + ')';
    }

    public final MmAudioSaveIdentityType getType() {
        return this.b;
    }

    public c(String r2, MmAudioSaveIdentityType r3) {
        Intrinsics.checkNotNullParameter(r2, "value");
        Intrinsics.checkNotNullParameter(r3, "type");
        this.a = r2;
        this.b = r3;
    }
}

package com.larus.avlink.activeSummary;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Serializable
public final class b {
    public static final C0095b Companion = null;
    public final int a;
    public final Integer b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<b> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            w0 r1 = w0.a;
            return new juc.d[]{r1, kuc.a.d(r1)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.avlink.activeSummary.OccupyAvoidConfig", r0, 2);
            r1.j("avoid_window_timestamp", true);
            r1.j("system_notify_queue_size", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r10) {
            Intrinsics.checkNotNullParameter(r10, "decoder");
            g2 r0 = b;
            muc.c r11 = r10.beginStructure(r0);
            if (r11.decodeSequentially() == false) goto L5;
            int r1 = r11.decodeIntElement(r0, 0);
            Integer r2 = (Integer) r11.decodeNullableSerializableElement(r0, 1, w0.a, null);
            int r3 = 3;
        L17:
            r11.endStructure(r0);
            return new b(r3, r1, r2);
        L5:
            Integer r5 = null;
            r1 = 0;
            int r4 = 0;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L16;
            int r7 = r11.decodeElementIndex(r0);
            if (r7 != (-1)) goto L9;
            r6 = false;
            goto L6
        L9:
            if (r7 != 0) goto L10;
            r1 = r11.decodeIntElement(r0, 0);
            r4 = r4 | 1;
            goto L6
        L10:
            if (r7 != 1) goto L13;
            r5 = (Integer) r11.decodeNullableSerializableElement(r0, 1, w0.a, r5);
            r4 = r4 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r7);
        L16:
            r3 = r4;
            r2 = r5;
            goto L17
        }

        public final void serialize(muc.f r5, Object r6) {
            b r7 = (b) r6;
            Intrinsics.checkNotNullParameter(r5, "encoder");
            Intrinsics.checkNotNullParameter(r7, "value");
            g2 r0 = b;
            muc.d r8 = r5.beginStructure(r0);
            C0095b r1 = b.Companion;
            boolean r2 = false;
            if (r8.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r8.encodeIntElement(r0, 0, r7.a);
        L12:
            if (r8.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r8.encodeNullableSerializableElement(r0, 1, w0.a, r7.b);
        L19:
            r8.endStructure(r0);
            return;
        L15:
            if (r7.b == null) goto L17;
        L6:
            if (r7.a != 0) goto L7;
            r3 = false;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.activeSummary.b$b, reason: collision with other inner class name */
    public static final class C0095b {
        public C0095b() {
        }

        public final juc.d<b> serializer() {
            return a.a;
        }
    }

    public b() {
        this(3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        Integer r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "OccupyAvoidConfig(avoidTimestamp=" + this.a + ", systemNotifyQueueSize=" + this.b + ')';
    }

    static {
        Companion = new C0095b();
    }

    public b(int r1) {
        this.a = 0;
        this.b = null;
    }

    public b(int r4, int r5, Integer r6) {
        if ((r4 & 0) == 0) goto L5;
        b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        this.a = 0;
    L9:
        if ((r4 & 2) != 0) goto L11;
        this.b = null;
        return;
    L11:
        this.b = r6;
        return;
    L7:
        this.a = r5;
        goto L9
    }
}

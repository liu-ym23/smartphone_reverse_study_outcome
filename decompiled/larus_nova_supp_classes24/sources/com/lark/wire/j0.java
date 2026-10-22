package com.lark.wire;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j0 {
    public static final /* synthetic */ int b = 0;
    public final BufferedSink a;

    public static final class a {
        public static int a(int r1) {
            if ((r1 & (-128)) != 0) goto L7;
            return 1;
        L7:
            if ((r1 & (-16384)) != 0) goto L11;
            return 2;
        L11:
            if (((-2097152) & r1) != 0) goto L15;
            return 3;
        L15:
            if ((r1 & (-268435456)) != 0) goto L17;
            return 4;
        L17:
            return 5;
        }

        public static int b(long r5) {
            if (((-128) & r5) != 0) goto L7;
            return 1;
        L7:
            if (((-16384) & r5) != 0) goto L11;
            return 2;
        L11:
            if (((-2097152) & r5) != 0) goto L15;
            return 3;
        L15:
            if (((-268435456) & r5) != 0) goto L19;
            return 4;
        L19:
            if (((-34359738368L) & r5) != 0) goto L23;
            return 5;
        L23:
            if (((-4398046511104L) & r5) != 0) goto L27;
            return 6;
        L27:
            if (((-562949953421312L) & r5) != 0) goto L31;
            return 7;
        L31:
            if (((-72057594037927936L) & r5) != 0) goto L35;
            return 8;
        L35:
            if ((r5 & Long.MIN_VALUE) != 0) goto L37;
            return 9;
        L37:
            return 10;
        }
    }

    static {
    }

    public j0(BufferedSink r2) {
        Intrinsics.checkNotNullParameter(r2, "sink");
        this.a = r2;
    }

    public final void a(ByteString r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a.write(r2);
    }

    public final void c(int r3) throws IOException {
    L3:
        if ((r3 & (-128)) == 0) goto L5;
        this.a.writeByte((r3 & 127) | 128);
        r3 = r3 >>> 7;
        goto L3
    L5:
        this.a.writeByte(r3);
    }

    public final void d(long r6) throws IOException {
    L3:
        if (((-128) & r6) == 0) goto L5;
        this.a.writeByte((((int) r6) & 127) | 128);
        r6 = r6 >>> 7;
        goto L3
    L5:
        this.a.writeByte((int) r6);
    }

    public final void b(int r2, FieldEncoding r3) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "fieldEncoding");
        Intrinsics.checkNotNullParameter(r3, "fieldEncoding");
        c((r2 << 3) | r3.getValue$wire_runtime());
    }
}

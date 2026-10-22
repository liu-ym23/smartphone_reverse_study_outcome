package ksb;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final ByteBuffer a;

    public final float a() {
        return this.a.getFloat();
    }

    public final int b() {
        return this.a.getShort() & 65535;
    }

    public a(ByteBuffer r2) {
        Intrinsics.checkNotNullParameter(r2, "buf");
        this.a = r2;
        r2.order(ByteOrder.LITTLE_ENDIAN);
    }
}

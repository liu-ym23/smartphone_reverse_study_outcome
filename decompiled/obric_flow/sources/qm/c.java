package qm;

import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f21526b;

    public c(d r5, int r10) {
        this.f21526b = r5;
        this.f21525a = r10;
    }

    public final double a() {
        d r5 = this.f21526b;
        int r10 = r5.f21529c;
        int r11 = this.f21525a + r10;
        return r5.f21527a.getDouble(r11);
    }

    public final int b() {
        d r5 = this.f21526b;
        int r10 = r5.f21529c;
        int r11 = this.f21525a + r10;
        return r5.f21527a.getInt(r11);
    }

    public final ReadableMapBuffer c() {
        d r5 = this.f21526b;
        int r10 = r5.f21529c;
        int r11 = this.f21525a + r10;
        ByteBuffer r12 = r5.f21527a;
        int r13 = r12.getInt(r11) + r5.d;
        int r14 = r12.getInt(r13);
        byte[] r15 = new byte[r14];
        r12.position(r13 + 4);
        r12.get(r15, 0, r14);
        return new ReadableMapBuffer(ByteBuffer.wrap(r15), -1, 4);
    }
}

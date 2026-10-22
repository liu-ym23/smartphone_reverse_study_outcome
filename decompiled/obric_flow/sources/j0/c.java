package j0;

import com.bumptech.glide.load.engine.d0;
import com.bumptech.glide.load.resource.bitmap.v;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.nio.ByteBuffer;
import z.f;

/* JADX INFO: loaded from: classes.dex */
public final class c implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f18219b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18220a;

    static {
        f18219b = new c(0);
    }

    public /* synthetic */ c(int r5) {
        this.f18220a = r5;
    }

    @Override // j0.a
    public final d0 e(d0 r5, f r10) {
        switch(this.f18220a) {
            case 0: goto L18;
            default: goto L4;
        };
    L4:
        ByteBuffer r11 = ((GifDrawable) r5.get()).a();
        int r12 = q0.b.f21445a;
        if (r11.isReadOnly() == false) goto L7;
    L9:
        lh.a r13 = null;
    L10:
        if (r13 != null) goto L12;
    L16:
        ByteBuffer r14 = r11.asReadOnlyBuffer();
        byte[] r15 = new byte[r14.limit()];
        r14.position(0);
        r14.get(r15);
        byte[] r16 = r15;
    L17:
        r5 = new v(r16);
        goto L18
    L12:
        if (r13.f19612a != 0) goto L16;
        int r17 = r13.f19614c.length;
        if (r13.f19613b != r17) goto L16;
        r16 = r11.array();
        goto L17
    L7:
        if (r11.hasArray() == false) goto L9;
        r13 = new lh.a(r11.array(), r11.arrayOffset(), r11.limit());
    L18:
        return r5;
    }
}

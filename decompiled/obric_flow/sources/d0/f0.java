package d0;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class f0 implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f16543b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f16544a;

    static {
        f16543b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "android.resource", "content"})));
    }

    public f0(e0 r5) {
        this.f16544a = r5;
    }

    @Override // d0.r
    public final boolean a(Object r5) {
        return f16543b.contains(((Uri) r5).getScheme());
    }

    @Override // d0.r
    public final q b(Object r5, int r10, int r11, z.f r12) {
        Uri r13 = (Uri) r5;
        p0.b r14 = new p0.b(r13);
        e0 r15 = (e0) this.f16544a;
        switch(r15.f16540a) {
            case 0: goto L6;
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        com.bumptech.glide.load.data.e r16 = new com.bumptech.glide.load.data.n(1, r13, r15.f16541b);
    L8:
        return new q(r14, r16);
    L5:
        r16 = new com.bumptech.glide.load.data.a(r15.f16541b, r13, 1);
        goto L8
    L6:
        r16 = new com.bumptech.glide.load.data.a(r15.f16541b, r13, 0);
        goto L8
    }
}

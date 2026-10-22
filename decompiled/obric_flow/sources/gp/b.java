package gp;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f17118b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f17119c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17120a;

    static {
        f17118b = new b(0);
        f17119c = new b(1);
    }

    public /* synthetic */ b(int r5) {
        this.f17120a = r5;
    }

    @Override // gp.a
    public final boolean a(long r5, long r10, com.obric.common.oea.foundation.animation.spec.spring.b r11) {
        switch(this.f17120a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r11, "spec");
        if (r5 < ((((long) r11.e) * 1000000) + r10)) goto L7;
        return true;
    L7:
        return false;
    L9:
        Intrinsics.checkNotNullParameter(r11, "spec");
        if (r5 < ((((long) r11.e) * 1000000) + r10)) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // gp.a
    public final Object b(long r10, Float r11, Float r12, float r13, com.obric.common.oea.foundation.animation.spec.spring.b r14) {
        switch(this.f17120a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        int r15 = r11.intValue();
        int r16 = r12.intValue();
        Intrinsics.checkNotNullParameter(r14, "spec");
        return (Integer) r14.b(r10, Integer.valueOf(r15), Integer.valueOf(r16), r13);
    L6:
        float r17 = r11.floatValue();
        float r18 = r12.floatValue();
        Intrinsics.checkNotNullParameter(r14, "spec");
        return r14.b(r10, Float.valueOf(r17), Float.valueOf(r18), r13);
    }

    @Override // gp.a
    public final float c(long r10, Float r11, Float r12, float r13, com.obric.common.oea.foundation.animation.spec.spring.b r14) {
        switch(this.f17120a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        int r15 = r11.intValue();
        int r16 = r12.intValue();
        Intrinsics.checkNotNullParameter(r14, "spec");
        return r14.c(r10, Integer.valueOf(r15), Integer.valueOf(r16), r13);
    L6:
        float r17 = r11.floatValue();
        float r18 = r12.floatValue();
        Intrinsics.checkNotNullParameter(r14, "spec");
        return r14.c(r10, Float.valueOf(r17), Float.valueOf(r18), r13);
    }
}

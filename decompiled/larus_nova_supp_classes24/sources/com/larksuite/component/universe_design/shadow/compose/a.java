package com.larksuite.component.universe_design.shadow.compose;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;

    /* JADX INFO: renamed from: com.larksuite.component.universe_design.shadow.compose.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0042a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UDShadowSize.values().length];
            r0[UDShadowSize.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[UDShadowSize.S1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[UDShadowSize.S2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[UDShadowSize.S3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[UDShadowSize.S4.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[UDShadowSize.S5.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public a(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r19, long r20, long r22) {
        this.a = r4;
        this.b = r6;
        this.c = r8;
        this.d = r10;
        this.e = r12;
    }
}

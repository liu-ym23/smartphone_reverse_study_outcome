package org.tensorflow.lite;

/* JADX INFO: loaded from: classes2.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9826a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9827b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f9828m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f9829n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f9830o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f9831p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f9832q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f9833r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ a[] f9834s = null;

    static {
        a r8 = new a("FLOAT32", 0);
        f9826a = r8;
        a r10 = new a("INT32", 1);
        f9827b = r10;
        a r11 = new a("UINT8", 2);
        f9828m = r11;
        a r12 = new a("INT64", 3);
        f9829n = r12;
        a r13 = new a("STRING", 4);
        f9830o = r13;
        a r14 = new a("BOOL", 5);
        f9831p = r14;
        a r15 = new a("INT16", 6);
        f9832q = r15;
        a r16 = new a("INT8", 7);
        f9833r = r16;
        f9834s = new a[]{r8, r10, r11, r12, r13, r14, r15, r16};
    }

    public a(String r8, int r10) {
        super(r8, r10);
    }

    public static a valueOf(String r8) {
        return (a) Enum.valueOf(a.class, r8);
    }

    public static a[] values() {
        return (a[]) f9834s.clone();
    }

    public final int a() {
        switch(ordinal()) {
            case 0: goto L13;
            case 1: goto L13;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L5;
        };
    L6:
        return -1;
    L7:
        return 8;
    L9:
        return 1;
    L11:
        return 2;
    L13:
        return 4;
    L5:
        throw new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
    }
}

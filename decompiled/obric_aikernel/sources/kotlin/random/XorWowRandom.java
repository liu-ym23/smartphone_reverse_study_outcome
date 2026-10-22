package kotlin.random;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nXorWowRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XorWowRandom.kt\nkotlin/random/XorWowRandom\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n1#2:61\n*E\n"})
public final class XorWowRandom extends Random implements Serializable {
    private static final Companion Companion = null;
    private static final long serialVersionUID = 0;
    private int addend;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f10201v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f10202w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f10203x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f10204y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f10205z;

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public XorWowRandom(int r10, int r11) {
        this(r10, r11, 0, 0, ~r10, (r10 << 10) ^ (r11 >>> 4));
    }

    public XorWowRandom(int r10, int r11, int r12, int r13, int r14, int r15) {
        this.f10203x = r10;
        this.f10204y = r11;
        this.f10205z = r12;
        this.f10202w = r13;
        this.f10201v = r14;
        this.addend = r15;
        int r16 = (((r10 | r11) | r12) | r13) | r14;
        int r17 = 0;
        if (r16 == 0) goto L5;
        boolean r18 = true;
    L6:
        if (r18 == false) goto L12;
    L8:
        if (r17 >= 64) goto L10;
        nextInt();
        r17 = r17 + 1;
        goto L8
    L10:
        return;
    L12:
        throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
    L5:
        r18 = false;
        goto L6
    }

    @Override // kotlin.random.Random
    public int nextBits(int r10) {
        return RandomKt.takeUpperBits(nextInt(), r10);
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        int r10 = this.f10203x;
        int r11 = r10 ^ (r10 >>> 2);
        this.f10203x = this.f10204y;
        this.f10204y = this.f10205z;
        this.f10205z = this.f10202w;
        int r12 = this.f10201v;
        this.f10202w = r12;
        int r13 = ((r11 ^ (r11 << 1)) ^ r12) ^ (r12 << 4);
        this.f10201v = r13;
        int r14 = this.addend + 362437;
        this.addend = r14;
        return r13 + r14;
    }
}

package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0000\u0018\u0000 \u00122\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u0012B\u0017\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B7\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "seed1", "", "seed2", "(II)V", "x", "y", "z", "w", "v", "addend", "(IIIIII)V", "nextBits", "bitCount", "nextInt", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nXorWowRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XorWowRandom.kt\nkotlin/random/XorWowRandom\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n1#2:61\n*E\n"})
public final class XorWowRandom extends Random implements Serializable {
    private static final Companion Companion = null;
    private static final long serialVersionUID = 0;
    private int addend;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f18737v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f18738w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f18739x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f18740y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f18741z;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/random/XorWowRandom$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public XorWowRandom(int r5, int r10, int r11, int r12, int r13, int r14) {
        this.f18739x = r5;
        this.f18740y = r10;
        this.f18741z = r11;
        this.f18738w = r12;
        this.f18737v = r13;
        this.addend = r14;
        if (((((r5 | r10) | r11) | r12) | r13) == 0) goto L10;
        int r15 = 0;
    L6:
        if (r15 >= 64) goto L8;
        nextInt();
        r15 = r15 + 1;
        goto L6
    L8:
        return;
    L10:
        throw new IllegalArgumentException("Initial state must have at least one non-zero element.");
    }

    @Override // kotlin.random.Random
    public int nextBits(int r5) {
        return RandomKt.takeUpperBits(nextInt(), r5);
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        int r5 = this.f18739x;
        int r10 = r5 ^ (r5 >>> 2);
        this.f18739x = this.f18740y;
        this.f18740y = this.f18741z;
        this.f18741z = this.f18738w;
        int r11 = this.f18737v;
        this.f18738w = r11;
        int r12 = ((r10 ^ (r10 << 1)) ^ r11) ^ (r11 << 4);
        this.f18737v = r12;
        int r13 = this.addend + 362437;
        this.addend = r13;
        return r12 + r13;
    }

    public XorWowRandom(int r10, int r11) {
        this(r10, r11, 0, 0, ~r10, (r10 << 10) ^ (r11 >>> 4));
    }
}

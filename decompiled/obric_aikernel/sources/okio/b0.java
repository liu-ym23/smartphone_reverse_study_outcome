package okio;

import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSegment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Segment.kt\nokio/Segment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n1#2:188\n*E\n"})
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final byte[] f12172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public int f12173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public int f12174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public boolean f12175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    public boolean f12176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @JvmField
    public b0 f12177f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public b0 f12178g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public b0() {
        this.f12172a = new byte[8192];
        this.f12176e = true;
        this.f12175d = false;
    }

    public b0(byte[] r10, int r11, int r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "data");
        this.f12172a = r10;
        this.f12173b = r11;
        this.f12174c = r12;
        this.f12175d = r13;
        this.f12176e = r14;
    }

    public final void a() {
        b0 r10 = this.f12178g;
        int r11 = 0;
        if (r10 == this) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L20;
        Intrinsics.checkNotNull(r10);
        if (r10.f12176e == true) goto L10;
        return;
    L10:
        int r13 = this.f12174c - this.f12173b;
        b0 r14 = this.f12178g;
        Intrinsics.checkNotNull(r14);
        int r15 = 8192 - r14.f12174c;
        b0 r16 = this.f12178g;
        Intrinsics.checkNotNull(r16);
        if (r16.f12175d == true) goto L15;
        b0 r17 = this.f12178g;
        Intrinsics.checkNotNull(r17);
        r11 = r17.f12173b;
    L15:
        if (r13 <= (r15 + r11)) goto L17;
        return;
    L17:
        b0 r18 = this.f12178g;
        Intrinsics.checkNotNull(r18);
        f(r18, r13);
        b();
        c0.b(this);
        return;
    L20:
        throw new IllegalStateException("cannot compact".toString());
    L5:
        r12 = false;
        goto L6
    }

    public final b0 b() {
        b0 r10 = this.f12177f;
        if (r10 != this) goto L6;
        r10 = null;
    L6:
        b0 r11 = this.f12178g;
        Intrinsics.checkNotNull(r11);
        r11.f12177f = this.f12177f;
        b0 r12 = this.f12177f;
        Intrinsics.checkNotNull(r12);
        r12.f12178g = this.f12178g;
        this.f12177f = null;
        this.f12178g = null;
        return r10;
    }

    public final b0 c(b0 r10) {
        Intrinsics.checkNotNullParameter(r10, "segment");
        r10.f12178g = this;
        r10.f12177f = this.f12177f;
        b0 r11 = this.f12177f;
        Intrinsics.checkNotNull(r11);
        r11.f12178g = r10;
        this.f12177f = r10;
        return r10;
    }

    public final b0 d() {
        this.f12175d = true;
        return new b0(this.f12172a, this.f12173b, this.f12174c, true, false);
    }

    public final b0 e(int r10) {
        if (r10 > 0) goto L4;
    L6:
        boolean r11 = false;
    L7:
        if (r11 == false) goto L15;
        if (r10 < 1024) goto L11;
        b0 r12 = d();
    L12:
        r12.f12174c = r12.f12173b + r10;
        this.f12173b += r10;
        b0 r13 = this.f12178g;
        Intrinsics.checkNotNull(r13);
        r13.c(r12);
        return r12;
    L11:
        r12 = c0.c();
        byte[] r14 = this.f12172a;
        byte[] r15 = r12.f12172a;
        int r16 = this.f12173b;
        ArraysKt.copyInto$default(r14, r15, 0, r16, r16 + r10, 2, null);
        goto L12
    L15:
        throw new IllegalArgumentException("byteCount out of range".toString());
    L4:
        if (r10 > (this.f12174c - this.f12173b)) goto L6;
        r11 = true;
        goto L7
    }

    public final void f(b0 r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        if (r10.f12176e == false) goto L18;
        int r12 = r10.f12174c;
        if ((r12 + r11) > 8192) goto L7;
    L15:
        byte[] r13 = this.f12172a;
        byte[] r14 = r10.f12172a;
        int r15 = r10.f12174c;
        int r16 = this.f12173b;
        ArraysKt.copyInto(r13, r14, r15, r16, r16 + r11);
        r10.f12174c += r11;
        this.f12173b += r11;
        return;
    L7:
        if (r10.f12175d == true) goto L14;
        int r17 = r10.f12173b;
        if (((r12 + r11) - r17) > 8192) goto L12;
        byte[] r18 = r10.f12172a;
        ArraysKt.copyInto$default(r18, r18, 0, r17, r12, 2, null);
        r10.f12174c -= r10.f12173b;
        r10.f12173b = 0;
        goto L15
    L12:
        throw new IllegalArgumentException();
    L14:
        throw new IllegalArgumentException();
    L18:
        throw new IllegalStateException("only owner can write".toString());
    }
}

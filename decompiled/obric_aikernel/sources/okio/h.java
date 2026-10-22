package okio;

import java.util.ArrayList;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f12218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final y f12220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Long f12221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f12222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Long f12223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Long f12224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<KClass<?>, Object> f12225h;

    public h(boolean r10, boolean r11, y r12, Long r13, Long r14, Long r15, Long r16, Map<KClass<?>, ? extends Object> r17) {
        Intrinsics.checkNotNullParameter(r17, "extras");
        this.f12218a = r10;
        this.f12219b = r11;
        this.f12220c = r12;
        this.f12221d = r13;
        this.f12222e = r14;
        this.f12223f = r15;
        this.f12224g = r16;
        this.f12225h = MapsKt.toMap(r17);
    }

    public /* synthetic */ h(boolean r10, boolean r11, y r12, Long r13, Long r14, Long r15, Long r16, Map r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L6;
        r10 = false;
    L6:
        if ((r18 & 2) == 0) goto L9;
        r11 = false;
    L9:
        if ((r18 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r18 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r18 & 16) == 0) goto L18;
        r14 = null;
    L18:
        if ((r18 & 32) == 0) goto L21;
        r15 = null;
    L21:
        if ((r18 & 64) == 0) goto L24;
        r16 = null;
    L24:
        if ((r18 & 128) == 0) goto L26;
        r17 = MapsKt.emptyMap();
    L26:
        this(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public final Long a() {
        return this.f12223f;
    }

    public final Long b() {
        return this.f12221d;
    }

    public final y c() {
        return this.f12220c;
    }

    public final boolean d() {
        return this.f12219b;
    }

    public final boolean e() {
        return this.f12218a;
    }

    public String toString() {
        ArrayList r10 = new ArrayList();
        if (this.f12218a == false) goto L6;
        r10.add("isRegularFile");
    L6:
        if (this.f12219b == false) goto L9;
        r10.add("isDirectory");
    L9:
        if (this.f12221d == null) goto L12;
        r10.add("byteCount=" + this.f12221d);
    L12:
        if (this.f12222e == null) goto L15;
        r10.add("createdAt=" + this.f12222e);
    L15:
        if (this.f12223f == null) goto L18;
        r10.add("lastModifiedAt=" + this.f12223f);
    L18:
        if (this.f12224g == null) goto L21;
        r10.add("lastAccessedAt=" + this.f12224g);
    L21:
        if ((!this.f12225h.isEmpty()) == false) goto L24;
        r10.add("extras=" + this.f12225h);
    L24:
        return CollectionsKt.joinToString$default(r10, ", ", "FileMetadata(", ")", 0, null, null, 56, null);
    }
}

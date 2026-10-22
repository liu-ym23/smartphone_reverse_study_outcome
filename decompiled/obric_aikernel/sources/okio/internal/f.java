package okio.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.y;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y f12247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f12249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Long f12250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f12251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<y> f12252f;

    public f(y r10, boolean r11, String r12, long r13, long r14, long r15, int r16, Long r17, long r18) {
        Intrinsics.checkNotNullParameter(r10, "canonicalPath");
        Intrinsics.checkNotNullParameter(r12, "comment");
        this.f12247a = r10;
        this.f12248b = r11;
        this.f12249c = r15;
        this.f12250d = r17;
        this.f12251e = r18;
        this.f12252f = new ArrayList();
    }

    public /* synthetic */ f(y r14, boolean r15, String r16, long r17, long r19, long r21, int r23, Long r24, long r25, int r27, DefaultConstructorMarker r28) {
        if ((r27 & 2) == 0) goto L5;
        boolean r10 = false;
    L7:
        if ((r27 & 4) == 0) goto L9;
        String r11 = "";
    L10:
        long r12 = -1;
        if ((r27 & 8) == 0) goto L13;
        long r13 = -1;
    L15:
        if ((r27 & 16) == 0) goto L17;
        long r18 = -1;
    L19:
        if ((r27 & 32) == 0) goto L21;
        long r110 = -1;
    L23:
        if ((r27 & 64) == 0) goto L25;
        int r20 = -1;
    L27:
        if ((r27 & 128) == 0) goto L29;
        Long r111 = null;
    L31:
        if ((r27 & 256) != 0) goto L34;
        r12 = r25;
    L34:
        this(r14, r10, r11, r13, r18, r110, r20, r111, r12);
        return;
    L29:
        r111 = r24;
        goto L31
    L25:
        r20 = r23;
        goto L27
    L21:
        r110 = r21;
        goto L23
    L17:
        r18 = r19;
        goto L19
    L13:
        r13 = r17;
        goto L15
    L9:
        r11 = r16;
        goto L10
    L5:
        r10 = r15;
        goto L7
    }

    public final y a() {
        return this.f12247a;
    }

    public final List<y> b() {
        return this.f12252f;
    }

    public final Long c() {
        return this.f12250d;
    }

    public final long d() {
        return this.f12251e;
    }

    public final long e() {
        return this.f12249c;
    }

    public final boolean f() {
        return this.f12248b;
    }
}

package com.obric.memorydata.markdown.stream;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/markdown/stream/StreamingCursorConfig;", "", "enabled", "", "cursorChar", "", "blinkEnabled", "blinkIntervalMs", "", "<init>", "(ZLjava/lang/String;ZJ)V", "getEnabled", "()Z", "getCursorChar", "()Ljava/lang/String;", "getBlinkEnabled", "getBlinkIntervalMs", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10032a = null;
    private static final p f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10033b;
    private final String c;
    private final boolean d;
    private final long e;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/markdown/stream/StreamingCursorConfig$Companion;", "", "<init>", "()V", "CURSOR_TINY_BULLET", "", "CURSOR_SMALL_CIRCLE", "CURSOR_LARGE_CIRCLE", "CURSOR_BLOCK", "CURSOR_BAR", "DEFAULT", "Lcom/obric/memorydata/markdown/stream/StreamingCursorConfig;", "getDEFAULT", "()Lcom/obric/memorydata/markdown/stream/StreamingCursorConfig;", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final p a() {
            return p.e();
        }
    }

    static {
        f10032a = new a(null);
        f = new p(false, null, false, 0, 15, null);
    }

    public p() {
        this(false, null, false, 0, 15, null);
    }

    public p(boolean r2, String r3, boolean r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "cursorChar");
        this.f10033b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public /* synthetic */ p(boolean r2, String r3, boolean r4, long r5, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = "●";
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = true;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r5 = 500;
    L14:
        this(r2, r3, r4, r5);
    }

    public static final /* synthetic */ p e() {
        return f;
    }

    public final boolean a() {
        return this.f10033b;
    }

    public final String b() {
        return this.c;
    }

    public final boolean c() {
        return this.d;
    }

    public final long d() {
        return this.e;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, p.class) == true) goto L8;
        return false;
    L8:
        p r8 = (p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.memorydata.plugin");
        if (this.f10033b == r8.f10033b) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r8.c) == true) goto L15;
        return false;
    L15:
        if (this.d == r8.d) goto L18;
        return false;
    L18:
        if (this.e == r8.e) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f10033b) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d)) * 31) + Long.hashCode(this.e);
    }

    public String toString() {
        return "StreamingCursorConfig(enabled=" + this.f10033b + ", cursorChar=" + this.c + ", blinkEnabled=" + this.d + ", blinkIntervalMs=" + this.e + ')';
    }
}

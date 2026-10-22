package com.obric.memorydata.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\""}, d2 = {"Lcom/obric/memorydata/utils/PlaceholderConfig;", "", "mode", "Lcom/obric/memorydata/utils/PlaceholderMode;", "prefix", "", "suffix", "caseSensitive", "", "wholeWordOnly", "<init>", "(Lcom/obric/memorydata/utils/PlaceholderMode;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getMode", "()Lcom/obric/memorydata/utils/PlaceholderMode;", "getPrefix", "()Ljava/lang/String;", "getSuffix", "getCaseSensitive", "()Z", "getWholeWordOnly", "buildPlaceholder", "keyword", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13166a = null;
    private static final al g = null;
    private static final al h = null;
    private static final al i = null;
    private static final al j = null;
    private static final al k = null;
    private static final al l = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PlaceholderMode f13167b;
    private final String c;
    private final String d;
    private final boolean e;
    private final boolean f;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/utils/PlaceholderConfig$Companion;", "", "<init>", "()V", "BRACES", "Lcom/obric/memorydata/utils/PlaceholderConfig;", "getBRACES", "()Lcom/obric/memorydata/utils/PlaceholderConfig;", "BRACKETS", "getBRACKETS", "ANGLE_BRACKETS", "getANGLE_BRACKETS", "DOUBLE_BRACES", "getDOUBLE_BRACES", "DOLLAR_BRACES", "getDOLLAR_BRACES", "NONE", "getNONE", "custom", "prefix", "", "suffix", "caseSensitive", "", "wholeWordOnly", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final al a() {
            return al.d();
        }

        public final al b() {
            return al.e();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13168a = null;

        static {
            int[] r0 = new int[PlaceholderMode.values().length];
            r0[PlaceholderMode.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f13168a = r0;
        }
    }

    static {
        f13166a = new a(null);
        boolean r6 = false;
        g = new al(PlaceholderMode.BRACES, "{", "}", r6, false, 24, null);
        boolean r14 = false;
        h = new al(PlaceholderMode.BRACKETS, "[", "]", r14, false, 24, null);
        boolean r5 = false;
        int r7 = 24;
        DefaultConstructorMarker r8 = null;
        i = new al(PlaceholderMode.ANGLE_BRACKETS, "<", ">", r5, r6, r7, r8);
        boolean r13 = false;
        int r15 = 24;
        DefaultConstructorMarker r16 = null;
        j = new al(PlaceholderMode.DOUBLE_BRACES, "{{", "}}", r13, r14, r15, r16);
        k = new al(PlaceholderMode.DOLLAR_BRACES, "${", "}", r5, r6, r7, r8);
        l = new al(PlaceholderMode.NONE, "", "", r13, r14, r15, r16);
    }

    public al(PlaceholderMode r2, String r3, String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        Intrinsics.checkNotNullParameter(r4, "suffix");
        this.f13167b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public /* synthetic */ al(PlaceholderMode r8, String r9, String r10, boolean r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r13 & 4) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r13 & 8) == 0) goto L13;
        boolean r5 = false;
    L15:
        if ((r13 & 16) == 0) goto L17;
        boolean r6 = false;
    L18:
        this(r8, r3, r4, r5, r6);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public static final /* synthetic */ al d() {
        return g;
    }

    public static final /* synthetic */ al e() {
        return l;
    }

    public final PlaceholderMode a() {
        return this.f13167b;
    }

    public final String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "keyword");
        if (b.f13168a[this.f13167b.ordinal()] != 1) goto L6;
        return r3;
    L6:
        return this.c + r3 + this.d;
    }

    public final boolean b() {
        return this.e;
    }

    public final boolean c() {
        return this.f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, al.class) == true) goto L8;
        return false;
    L8:
        al r6 = (al) ZeusTransformUtils.preCheckCast(r5, al.class, "com.obric.memorydata.plugin");
        if (this.f13167b == r6.f13167b) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
        return false;
    L18:
        if (this.e == r6.e) goto L21;
        return false;
    L21:
        if (this.f == r6.f) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f13167b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f);
    }

    public String toString() {
        return "PlaceholderConfig(mode=" + this.f13167b + ", prefix=" + this.c + ", suffix=" + this.d + ", caseSensitive=" + this.e + ", wholeWordOnly=" + this.f + ')';
    }
}

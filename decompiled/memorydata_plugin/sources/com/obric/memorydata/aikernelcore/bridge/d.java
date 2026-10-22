package com.obric.memorydata.aikernelcore.bridge;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\""}, d2 = {"Lcom/obric/memorydata/aikernelcore/bridge/SQLColumn;", "", ActivityLifecycle.NAME, "", "type", "", "dValue", "", "iValue", "", "strValue", "<init>", "(Ljava/lang/String;IDJLjava/lang/String;)V", "getName", "()Ljava/lang/String;", "getType", "()I", "getDValue", "()D", "getIValue", "()J", "getStrValue", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8472a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8473b;
    private final int c;
    private final double d;
    private final long e;
    private final String f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/aikernelcore/bridge/SQLColumn$Companion;", "", "<init>", "()V", "FIELD_TYPE_NULL", "", "FIELD_TYPE_INTEGER", "FIELD_TYPE_FLOAT", "FIELD_TYPE_STRING", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8472a = new a(null);
    }

    public d(String r1, int r2, double r3, long r5, String r7) {
        this.f8473b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r5;
        this.f = r7;
    }

    public /* synthetic */ d(String r11, int r12, double r13, long r15, String r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r18 & 4) == 0) goto L9;
        double r5 = 0.0d;
    L11:
        if ((r18 & 8) == 0) goto L13;
        long r7 = 0;
    L15:
        if ((r18 & 16) == 0) goto L17;
        String r9 = null;
    L18:
        this(r3, r12, r5, r7, r9);
        return;
    L17:
        r9 = r17;
        goto L18
    L13:
        r7 = r15;
        goto L15
    L9:
        r5 = r13;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public final String a() {
        return this.f8473b;
    }

    public final double b() {
        return this.d;
    }

    public final long c() {
        return this.e;
    }

    public final String d() {
        return this.f;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
        return false;
    L8:
        d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8473b, r10.f8473b) == true) goto L12;
        return false;
    L12:
        if (this.c == r10.c) goto L15;
        return false;
    L15:
        if (Double.compare(this.d, r10.d) == 0) goto L18;
        return false;
    L18:
        if (this.e == r10.e) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int getType() {
        return this.c;
    }

    public int hashCode() {
        String r0 = this.f8473b;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((((r2 * 31) + Integer.hashCode(this.c)) * 31) + Double.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31;
        String r4 = this.f;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SQLColumn(name=" + this.f8473b + ", type=" + this.c + ", dValue=" + this.d + ", iValue=" + this.e + ", strValue=" + this.f + ')';
    }
}

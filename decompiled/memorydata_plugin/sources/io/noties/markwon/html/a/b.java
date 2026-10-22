package io.noties.markwon.html.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lio/noties/markwon/html/customdata/CachedWidget;", "", "startIndex", "", "endIndex", "dataType", "", "dataValue", "dataValueId", "dataTag", "widget", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/noties/markwon/html/customdata/ICustomDataWidget;)V", "getDataTag", "()Ljava/lang/String;", "getDataType", "getDataValue", "getDataValueId", "getEndIndex", "()I", "getStartIndex", "getWidget", "()Lio/noties/markwon/html/customdata/ICustomDataWidget;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16553b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final g g;

    public b(int r3, int r4, String r5, String r6, String r7, String r8, g r9) {
        g r10 = (g) ZeusTransformUtils.wrapperContextForParams(r9, g.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, "dataType");
        Intrinsics.checkParameterIsNotNull(r6, "dataValue");
        Intrinsics.checkParameterIsNotNull(r7, "dataValueId");
        Intrinsics.checkParameterIsNotNull(r8, "dataTag");
        Intrinsics.checkParameterIsNotNull(r10, "widget");
        this.f16552a = r3;
        this.f16553b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r10;
    }

    public final int a() {
        return this.f16552a;
    }

    public final int b() {
        return this.f16553b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
    L28:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == false) goto L27;
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (this.f16552a != r6.f16552a) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L27;
        if (this.f16553b != r6.f16553b) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == false) goto L27;
        if (Intrinsics.areEqual(this.c, r6.c) == false) goto L27;
        if (Intrinsics.areEqual(this.d, r6.d) == false) goto L27;
        if (Intrinsics.areEqual(this.e, r6.e) == false) goto L27;
        if (Intrinsics.areEqual(this.f, r6.f) == false) goto L27;
        if (Intrinsics.areEqual(this.g, r6.g) == false) goto L27;
    L14:
        r1 = false;
        goto L15
    L9:
        r0 = false;
    L27:
        return false;
    }

    public final String f() {
        return this.f;
    }

    public final g g() {
        return this.g;
    }

    public int hashCode() {
        int r0 = ((this.f16552a * 31) + this.f16553b) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.e;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.f;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        g r14 = this.g;
        if (r14 == null) goto L22;
        r2 = r14.hashCode();
    L22:
        return r13 + r2;
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return "CachedWidget(startIndex=" + this.f16552a + ", endIndex=" + this.f16553b + ", dataType=" + this.c + ", dataValue=" + this.d + ", dataValueId=" + this.e + ", dataTag=" + this.f + ", widget=" + this.g + ")";
    }
}

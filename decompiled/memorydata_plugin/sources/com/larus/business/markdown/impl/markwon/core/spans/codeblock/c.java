package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jp\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012¨\u00061"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockSpan2Info;", "", "codeBlockStartIndex", "", "codeBlockEndIndex", "titleBgColor", "cornerRadius", "", "borderWidth", "borderColor", "enableBackground", "", "scrollableInfo", "Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockScrollableInfo;", "numberInfo", "Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockLineNumberInfo;", "(Ljava/lang/Integer;Ljava/lang/Integer;IFFIZLcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockScrollableInfo;Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockLineNumberInfo;)V", "getBorderColor", "()I", "getBorderWidth", "()F", "getCodeBlockEndIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCodeBlockStartIndex", "getCornerRadius", "getEnableBackground", "()Z", "getNumberInfo", "()Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockLineNumberInfo;", "getScrollableInfo", "()Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockScrollableInfo;", "getTitleBgColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;IFFIZLcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockScrollableInfo;Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockLineNumberInfo;)Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockSpan2Info;", "equals", "other", "hashCode", "toString", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f5204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f5205b;
    private final int c;
    private final float d;
    private final float e;
    private final int f;
    private final boolean g;
    private final b h;
    private final a i;

    public c(Integer r1, Integer r2, int r3, float r4, float r5, int r6, boolean r7, b r8, a r9) {
        this.f5204a = r1;
        this.f5205b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    public /* synthetic */ c(Integer r14, Integer r15, int r16, float r17, float r18, int r19, boolean r20, b r21, a r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 128) == 0) goto L5;
        b r11 = null;
    L7:
        if ((r23 & 256) == 0) goto L9;
        a r12 = null;
    L10:
        this(r14, r15, r16, r17, r18, r19, r20, r11, r12);
        return;
    L9:
        r12 = r22;
        goto L10
    L5:
        r11 = r21;
        goto L7
    }

    public final Integer a() {
        return this.f5204a;
    }

    public final Integer b() {
        return this.f5205b;
    }

    public final int c() {
        return this.c;
    }

    public final float d() {
        return this.d;
    }

    public final float e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f5204a, r6.f5204a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5205b, r6.f5205b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r6.e) == 0) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int f() {
        return this.f;
    }

    public final boolean g() {
        return this.g;
    }

    public final b h() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v19 */
    public int hashCode() {
        Integer r0 = this.f5204a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.f5205b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((((((((r3 + r5) * 31) + Integer.hashCode(this.c)) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31;
        boolean r7 = this.g;
        ?? r8 = r7;
        if (r7 == false) goto L13;
        r8 = 1;
    L13:
        int r9 = (r6 + r8) * 31;
        b r10 = this.h;
        if (r10 != null) goto L16;
        int r11 = 0;
    L17:
        int r12 = (r9 + r11) * 31;
        a r13 = this.i;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L16:
        r11 = r10.hashCode();
        goto L17
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final a i() {
        return this.i;
    }

    public String toString() {
        return "CodeBlockSpan2Info(codeBlockStartIndex=" + this.f5204a + ", codeBlockEndIndex=" + this.f5205b + ", titleBgColor=" + this.c + ", cornerRadius=" + this.d + ", borderWidth=" + this.e + ", borderColor=" + this.f + ", enableBackground=" + this.g + ", scrollableInfo=" + this.h + ", numberInfo=" + this.i + ')';
    }
}

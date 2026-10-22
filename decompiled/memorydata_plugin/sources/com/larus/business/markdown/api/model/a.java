package com.larus.business.markdown.api.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJl\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0015\u0010\u000eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\u000eR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\u000e¨\u0006'"}, d2 = {"Lcom/larus/business/markdown/api/model/BlockQuoteConfig;", "", "enableNewQuoteStyle", "", "blockQuoteWidth", "", "blockQuoteColor", "lineCornerRadius", "blockMargin", "textColorInQuote", "orderedListItemColorInQuote", "bulletListItemColorInQuote", "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBlockMargin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBlockQuoteColor", "getBlockQuoteWidth", "getBulletListItemColorInQuote", "getEnableNewQuoteStyle", "()Z", "getLineCornerRadius", "getOrderedListItemColorInQuote", "getTextColorInQuote", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/business/markdown/api/model/BlockQuoteConfig;", "equals", "other", "hashCode", "toString", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f5156b;
    private final Integer c;
    private final Integer d;
    private final Integer e;
    private final Integer f;
    private final Integer g;
    private final Integer h;

    public a() {
        this(false, null, null, null, null, null, null, null, 255, null);
    }

    public a(boolean r1, Integer r2, Integer r3, Integer r4, Integer r5, Integer r6, Integer r7, Integer r8) {
        this.f5155a = r1;
        this.f5156b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    public /* synthetic */ a(boolean r10, Integer r11, Integer r12, Integer r13, Integer r14, Integer r15, Integer r16, Integer r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        boolean r1 = true;
    L6:
        Integer r3 = null;
        if ((r18 & 2) == 0) goto L9;
        Integer r2 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r3 = r17;
    L34:
        this(r1, r2, r4, r5, r6, r7, r8, r3);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L6
    }

    public final boolean a() {
        return this.f5155a;
    }

    public final Integer b() {
        return this.f5156b;
    }

    public final Integer c() {
        return this.c;
    }

    public final Integer d() {
        return this.d;
    }

    public final Integer e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (this.f5155a == r6.f5155a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5156b, r6.f5156b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final Integer f() {
        return this.f;
    }

    public final Integer g() {
        return this.g;
    }

    public final Integer h() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public int hashCode() {
        boolean r0 = this.f5155a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        Integer r3 = this.f5156b;
        int r4 = 0;
        if (r3 != null) goto L8;
        int r5 = 0;
    L9:
        int r6 = (r2 + r5) * 31;
        Integer r7 = this.c;
        if (r7 != null) goto L12;
        int r8 = 0;
    L13:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.d;
        if (r10 != null) goto L16;
        int r11 = 0;
    L17:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.e;
        if (r13 != null) goto L20;
        int r14 = 0;
    L21:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.f;
        if (r16 != null) goto L24;
        int r17 = 0;
    L25:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.g;
        if (r19 != null) goto L28;
        int r20 = 0;
    L29:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.h;
        if (r22 == null) goto L34;
        r4 = r22.hashCode();
    L34:
        return r21 + r4;
    L28:
        r20 = r19.hashCode();
        goto L29
    L24:
        r17 = r16.hashCode();
        goto L25
    L20:
        r14 = r13.hashCode();
        goto L21
    L16:
        r11 = r10.hashCode();
        goto L17
    L12:
        r8 = r7.hashCode();
        goto L13
    L8:
        r5 = r3.hashCode();
        goto L9
    }

    public String toString() {
        return "BlockQuoteConfig(enableNewQuoteStyle=" + this.f5155a + ", blockQuoteWidth=" + this.f5156b + ", blockQuoteColor=" + this.c + ", lineCornerRadius=" + this.d + ", blockMargin=" + this.e + ", textColorInQuote=" + this.f + ", orderedListItemColorInQuote=" + this.g + ", bulletListItemColorInQuote=" + this.h + ')';
    }
}

package com.obric.memorydata.memory.ui.automemory.create;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003J\t\u0010)\u001a\u00020\u000eHÆ\u0003JY\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010+\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u000eHÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0017R\u0011\u0010!\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b!\u0010\u0017¨\u0006/"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionUiState;", "", "ruleId", "", ActivityLifecycle.NAME, "", Params.CONTENT, "useClientModel", "", "iconKey", "iconColorKey", "step", "Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionStep;", "imeBottom", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionStep;I)V", "getRuleId", "()J", "getName", "()Ljava/lang/String;", "getContent", "getUseClientModel", "()Z", "getIconKey", "getIconColorKey", "getStep", "()Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionStep;", "getImeBottom", "()I", "contentLength", "getContentLength", "isContentOverLimit", "isInfoValid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10662b;
    private final String c;
    private final boolean d;
    private final String e;
    private final String f;
    private final AutoMemoryCreateCollectionStep g;
    private final int h;

    public b(long r2, String r4, String r5, boolean r6, String r7, String r8, AutoMemoryCreateCollectionStep r9, int r10) {
        Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r7, "iconKey");
        Intrinsics.checkNotNullParameter(r8, "iconColorKey");
        Intrinsics.checkNotNullParameter(r9, "step");
        this.f10661a = r2;
        this.f10662b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }

    public /* synthetic */ b(long r14, String r16, String r17, boolean r18, String r19, String r20, AutoMemoryCreateCollectionStep r21, int r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 2) == 0) goto L5;
        String r6 = "";
    L7:
        if ((r23 & 4) == 0) goto L9;
        String r7 = "";
    L11:
        if ((r23 & 8) == 0) goto L13;
        boolean r8 = false;
    L15:
        if ((r23 & 16) == 0) goto L17;
        String r9 = "";
    L19:
        if ((r23 & 32) == 0) goto L21;
        String r10 = "";
    L23:
        if ((r23 & 64) == 0) goto L25;
        AutoMemoryCreateCollectionStep r11 = AutoMemoryCreateCollectionStep.EDIT_INFO;
    L27:
        if ((r23 & 128) == 0) goto L29;
        int r12 = 0;
    L30:
        this(r14, r6, r7, r8, r9, r10, r11, r12);
        return;
    L29:
        r12 = r22;
        goto L30
    L25:
        r11 = r21;
        goto L27
    L21:
        r10 = r20;
        goto L23
    L17:
        r9 = r19;
        goto L19
    L13:
        r8 = r18;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }

    public static /* synthetic */ b a(b r10, long r11, String r13, String r14, boolean r15, String r16, String r17, AutoMemoryCreateCollectionStep r18, int r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        long r2 = r10.f10661a;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r4 = r10.f10662b;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r5 = r10.c;
    L15:
        if ((r20 & 8) == 0) goto L17;
        boolean r6 = r10.d;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r7 = r10.e;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r8 = r10.f;
    L27:
        if ((r20 & 64) == 0) goto L29;
        AutoMemoryCreateCollectionStep r9 = r10.g;
    L31:
        if ((r20 & 128) == 0) goto L33;
        int r1 = r10.h;
    L35:
        return r10.a(r2, r4, r5, r6, r7, r8, r9, r1);
    L33:
        r1 = r19;
        goto L35
    L29:
        r9 = r18;
        goto L31
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r4 = r13;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    private final int j() {
        return this.c.length();
    }

    private final boolean k() {
        if (j() <= 2000) goto L5;
        return true;
    L5:
        return false;
    }

    public final long a() {
        return this.f10661a;
    }

    public final b a(long r12, String r14, String r15, boolean r16, String r17, String r18, AutoMemoryCreateCollectionStep r19, int r20) {
        Intrinsics.checkNotNullParameter(r14, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r15, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r17, "iconKey");
        Intrinsics.checkNotNullParameter(r18, "iconColorKey");
        Intrinsics.checkNotNullParameter(r19, "step");
        return new b(r12, r14, r15, r16, r17, r18, r19, r20);
    }

    public final String b() {
        return this.f10662b;
    }

    public final String c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
        return false;
    L8:
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
        if (this.f10661a == r10.f10661a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10662b, r10.f10662b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final AutoMemoryCreateCollectionStep g() {
        return this.g;
    }

    public final int h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.f10661a) * 31) + this.f10662b.hashCode()) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h);
    }

    public final boolean i() {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(this.f10662b, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L18;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(this.c, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L18;
        if (k() == true) goto L18;
        if (this.g == AutoMemoryCreateCollectionStep.AI_OPTIMIZING) goto L18;
        return true;
    L10:
        r1 = false;
    L18:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public String toString() {
        return "AutoMemoryCreateCollectionUiState(ruleId=" + this.f10661a + ", name=" + this.f10662b + ", content=" + this.c + ", useClientModel=" + this.d + ", iconKey=" + this.e + ", iconColorKey=" + this.f + ", step=" + this.g + ", imeBottom=" + this.h + ')';
    }
}

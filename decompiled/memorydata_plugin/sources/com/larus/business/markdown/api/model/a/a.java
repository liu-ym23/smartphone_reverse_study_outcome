package com.larus.business.markdown.api.model.a;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001BÃ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f\u0012:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fHÆ\u0003J;\u00107\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000eHÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003JÇ\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0003HÆ\u0001J\u0013\u0010:\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0003HÖ\u0001J\t\u0010=\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u001eR\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&RC\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006>"}, d2 = {"Lcom/larus/business/markdown/api/model/latex/LatexGlobalConfig;", "", "markdownLatexPatternStrategy", "", "enableMarkdownLatexOpt", "", "customizedSingleDollarLatexPattern", "", "disableLatexSplit", "enableLatexSplitOptimize", "enableLatexFallback", "unSupportLatexCommandList", "", "latexFallbackAbility", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "latex", "Lcom/larus/business/markdown/api/depend/OnLatexUrlCallBack;", "callback", "", "enableBlockLatex", "isDisableLatex", "enableLatexNewCommand", "enableUseLatexBitmapCache", "latexBitmapCacheSize", "(IZLjava/lang/String;ZZZLjava/util/List;Lkotlin/jvm/functions/Function2;ZZZZI)V", "getCustomizedSingleDollarLatexPattern", "()Ljava/lang/String;", "getDisableLatexSplit", "()Z", "getEnableBlockLatex", "getEnableLatexFallback", "getEnableLatexNewCommand", "getEnableLatexSplitOptimize", "getEnableMarkdownLatexOpt", "getEnableUseLatexBitmapCache", "getLatexBitmapCacheSize", "()I", "getLatexFallbackAbility", "()Lkotlin/jvm/functions/Function2;", "getMarkdownLatexPatternStrategy", "getUnSupportLatexCommandList", "()Ljava/util/List;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f5158b;
    private final String c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final List<String> g;
    private final Function2<String, Object, Unit> h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final int m;

    public a() {
        this(0, false, null, false, false, false, null, null, false, false, false, false, 0, 8191, null);
    }

    public a(int r3, boolean r4, String r5, boolean r6, boolean r7, boolean r8, List<String> r9, Function2<? super String, ? super Object, Unit> r10, boolean r11, boolean r12, boolean r13, boolean r14, int r15) {
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Function2<String, Object, Unit> r17 = (Function2) ZeusTransformUtils.wrapperContextForParams(r10, Function2.class, "com.obric.memorydata.plugin");
        this.f5157a = r3;
        this.f5158b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r16;
        this.h = r17;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
    }

    public /* synthetic */ a(int r15, boolean r16, String r17, boolean r18, boolean r19, boolean r20, List r21, Function2 r22, boolean r23, boolean r24, boolean r25, boolean r26, int r27, int r28, DefaultConstructorMarker r29) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        Function2 r2 = (Function2) ZeusTransformUtils.wrapperContextForParams(r22, Function2.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        if ((r28 & 1) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r28 & 2) == 0) goto L9;
        boolean r5 = false;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r28 & 8) == 0) goto L17;
        boolean r8 = false;
    L19:
        if ((r28 & 16) == 0) goto L21;
        boolean r9 = false;
    L23:
        if ((r28 & 32) == 0) goto L25;
        boolean r10 = false;
    L27:
        if ((r28 & 64) == 0) goto L30;
        r1 = null;
    L30:
        if ((r28 & 128) == 0) goto L33;
        r2 = null;
    L33:
        if ((r28 & 256) == 0) goto L35;
        boolean r7 = true;
    L37:
        if ((r28 & 512) == 0) goto L39;
        boolean r11 = false;
    L41:
        if ((r28 & 1024) == 0) goto L43;
        boolean r12 = false;
    L45:
        if ((r28 & 2048) == 0) goto L47;
        boolean r13 = false;
    L49:
        if ((r28 & 4096) != 0) goto L52;
        r4 = r27;
    L52:
        this(r3, r5, r6, r8, r9, r10, r1, r2, r7, r11, r12, r13, r4);
        return;
    L47:
        r13 = r26;
        goto L49
    L43:
        r12 = r25;
        goto L45
    L39:
        r11 = r24;
        goto L41
    L35:
        r7 = r23;
        goto L37
    L25:
        r10 = r20;
        goto L27
    L21:
        r9 = r19;
        goto L23
    L17:
        r8 = r18;
        goto L19
    L13:
        r6 = r17;
        goto L15
    L9:
        r5 = r16;
        goto L11
    L5:
        r3 = r15;
        goto L7
    }

    public final boolean a() {
        return this.f5158b;
    }

    public final boolean b() {
        return this.j;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (this.f5157a == r6.f5157a) goto L12;
        return false;
    L12:
        if (this.f5158b == r6.f5158b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L47;
        return false;
    L47:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r0 = Integer.hashCode(this.f5157a) * 31;
        boolean r1 = this.f5158b;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        int r6 = 0;
        if (r5 != null) goto L8;
        int r7 = 0;
    L9:
        int r8 = (r4 + r7) * 31;
        boolean r9 = this.d;
        ?? r10 = r9;
        if (r9 == false) goto L12;
        r10 = 1;
    L12:
        int r11 = (r8 + r10) * 31;
        boolean r12 = this.e;
        ?? r13 = r12;
        if (r12 == false) goto L15;
        r13 = 1;
    L15:
        int r14 = (r11 + r13) * 31;
        boolean r15 = this.f;
        ?? r16 = r15;
        if (r15 == false) goto L18;
        r16 = 1;
    L18:
        int r17 = (r14 + r16) * 31;
        List<String> r18 = this.g;
        if (r18 != null) goto L21;
        int r19 = 0;
    L22:
        int r20 = (r17 + r19) * 31;
        Function2<String, Object, Unit> r21 = this.h;
        if (r21 == null) goto L26;
        r6 = r21.hashCode();
    L26:
        int r22 = (r20 + r6) * 31;
        boolean r23 = this.i;
        ?? r24 = r23;
        if (r23 == false) goto L29;
        r24 = 1;
    L29:
        int r25 = (r22 + r24) * 31;
        boolean r26 = this.j;
        ?? r27 = r26;
        if (r26 == false) goto L32;
        r27 = 1;
    L32:
        int r28 = (r25 + r27) * 31;
        boolean r29 = this.k;
        ?? r30 = r29;
        if (r29 == false) goto L35;
        r30 = 1;
    L35:
        int r31 = (r28 + r30) * 31;
        boolean r32 = this.l;
        if (r32 == true) goto L40;
        r2 = r32;
    L40:
        return ((r31 + r2) * 31) + Integer.hashCode(this.m);
    L21:
        r19 = r18.hashCode();
        goto L22
    L8:
        r7 = r5.hashCode();
        goto L9
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("LatexGlobalConfig(markdownLatexPatternStrategy=").append(this.f5157a).append(", enableMarkdownLatexOpt=").append(this.f5158b).append(", customizedSingleDollarLatexPattern=").append(this.c).append(", disableLatexSplit=").append(this.d).append(", enableLatexSplitOptimize=").append(this.e).append(", enableLatexFallback=").append(this.f).append(", unSupportLatexCommandList=").append(this.g).append(", latexFallbackAbility=").append(this.h).append(", enableBlockLatex=").append(this.i).append(", isDisableLatex=").append(this.j).append(", enableLatexNewCommand=").append(this.k).append(", enableUseLatexBitmapCache=");
        r0.append(this.l).append(", latexBitmapCacheSize=").append(this.m).append(')');
        return r0.toString();
    }
}

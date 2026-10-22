package io.noties.markwon.ext.tables;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0016\u0018\u0000 -2\u00020\u0001:\u0001-B\u009b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0003\u0010\b\u001a\u00020\u0005\u0012\b\b\u0003\u0010\t\u001a\u00020\u0005\u0012\b\b\u0003\u0010\n\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u000b\u001a\u00020\f\u0012\b\b\u0003\u0010\r\u001a\u00020\f\u0012\b\b\u0003\u0010\u000e\u001a\u00020\f\u0012\b\b\u0003\u0010\u000f\u001a\u00020\f\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005¢\u0006\u0002\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u001a\u0010#\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0018¨\u0006."}, d2 = {"Lio/noties/markwon/ext/tables/TableTheme2;", "Lio/noties/markwon/ext/tables/TableTheme;", "builder", "Lio/noties/markwon/ext/tables/TableTheme$Builder;", "tableWidth", "", "cellMinWidth", "cellMaxWidth", "cellVerticalPadding", "cellHorizontalPadding", "shaderColor", "tableTextSize", "", "roundCornerRadius", "bottomRoundCornerRadius", "topRoundCornerRadius", "tableTextColor", "enableTableWidthMatchParent", "", "foregroundProvider", "Lio/noties/markwon/ext/tables/ForegroundProvider;", "placeholderStyle", "(Lio/noties/markwon/ext/tables/TableTheme$Builder;IIIIIIFFFFIZLio/noties/markwon/ext/tables/ForegroundProvider;I)V", "getBottomRoundCornerRadius", "()F", "getCellMaxWidth", "()I", "getCellMinWidth", "getEnableTableWidthMatchParent", "()Z", "getForegroundProvider", "()Lio/noties/markwon/ext/tables/ForegroundProvider;", "getPlaceholderStyle", "getRoundCornerRadius", "getShaderColor", "tableCellHorizontalPadding", "getTableCellHorizontalPadding", "setTableCellHorizontalPadding", "(I)V", "tableCellVerticalPadding", "getTableCellVerticalPadding", "getTableTextColor", "getTableTextSize", "getTableWidth", "getTopRoundCornerRadius", "Companion", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
public class m extends l {
    public static final a g = null;
    private final int h;
    private int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final float n;
    private final float o;
    private final float p;
    private final float q;
    private final int r;
    private final boolean s;
    private final d t;
    private final int u;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lio/noties/markwon/ext/tables/TableTheme2$Companion;", "", "()V", "PLACEHOLDER_STYLE_DEFAULT", "", "PLACEHOLDER_STYLE_WHITE_SPACE", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        g = new a(null);
    }

    public m(l.a r7, int r8, int r9, int r10, int r11, int r12, int r13, float r14, float r15, float r16, float r17, int r18, boolean r19, d r20, int r21) {
        d r2 = (d) ZeusTransformUtils.wrapperContextForParams(r20, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r7, "builder");
        super(r7);
        this.j = r8;
        this.k = r9;
        this.l = r10;
        this.m = r13;
        this.n = r14;
        this.o = r15;
        this.p = r16;
        this.q = r17;
        this.r = r18;
        this.s = r19;
        this.t = r2;
        this.u = r21;
        if (r11 >= 0) goto L5;
        int r3 = this.f16521a;
    L6:
        this.h = r3;
        if (r12 >= 0) goto L9;
        int r4 = this.f16521a;
    L10:
        this.i = r4;
        if ((r4 * 2) > r10) goto L14;
        return;
    L14:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Padding(" + (this.f16521a * 2) + ") can't larger than width(" + r10 + ')'), Throwable.class, "com.obric.memorydata.plugin"));
    L9:
        r4 = r12;
        goto L10
    L5:
        r3 = r11;
        goto L6
    }

    public /* synthetic */ m(l.a r22, int r23, int r24, int r25, int r26, int r27, int r28, float r29, float r30, float r31, float r32, int r33, boolean r34, d r35, int r36, int r37, DefaultConstructorMarker r38) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r35, d.class, "com.obric.memorydata.plugin");
        if ((r37 & 16) == 0) goto L5;
        int r10 = -1;
    L7:
        if ((r37 & 32) == 0) goto L9;
        int r11 = -1;
    L11:
        if ((r37 & 64) == 0) goto L13;
        int r12 = 0;
    L15:
        if ((r37 & 128) == 0) goto L17;
        float r13 = -1.0f;
    L19:
        if ((r37 & 256) == 0) goto L21;
        float r14 = 0.0f;
    L23:
        if ((r37 & 512) == 0) goto L25;
        float r15 = 0.0f;
    L27:
        if ((r37 & 1024) == 0) goto L29;
        float r16 = 0.0f;
    L31:
        if ((r37 & 2048) == 0) goto L33;
        int r17 = -16777216;
    L35:
        if ((r37 & 4096) == 0) goto L37;
        boolean r18 = false;
    L39:
        if ((r37 & 8192) == 0) goto L41;
        r1 = (d) ZeusTransformUtils.preCheckCast(null, d.class, "com.obric.memorydata.plugin");
    L41:
        d r19 = r1;
        if ((r37 & 16384) == 0) goto L44;
        int r20 = 0;
    L45:
        this(r22, r23, r24, r25, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
        return;
    L44:
        r20 = r36;
        goto L45
    L37:
        r18 = r34;
        goto L39
    L33:
        r17 = r33;
        goto L35
    L29:
        r16 = r32;
        goto L31
    L25:
        r15 = r31;
        goto L27
    L21:
        r14 = r30;
        goto L23
    L17:
        r13 = r29;
        goto L19
    L13:
        r12 = r28;
        goto L15
    L9:
        r11 = r27;
        goto L11
    L5:
        r10 = r26;
        goto L7
    }

    public final int a() {
        return this.h;
    }

    public final int b() {
        return this.i;
    }

    public final int c() {
        return this.j;
    }

    public final int d() {
        return this.k;
    }

    public final int e() {
        return this.l;
    }

    public final int f() {
        return this.m;
    }

    public final float g() {
        return this.n;
    }

    public final float h() {
        return this.p;
    }

    public final float i() {
        return this.q;
    }

    public final int j() {
        return this.r;
    }

    public final boolean k() {
        return this.s;
    }

    public final d l() {
        return this.t;
    }

    public final int m() {
        return this.u;
    }
}

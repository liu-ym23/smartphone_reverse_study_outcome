package com.obric.memorydata.markdown.stream;

import android.graphics.Color;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b)\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 @2\u00020\u0001:\u0002?@B\u0099\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\fHÆ\u0003J\t\u00104\u001a\u00020\u000eHÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0014HÆ\u0003J\t\u00108\u001a\u00020\u000eHÆ\u0003J\u009b\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u000eHÆ\u0001J\u0013\u0010:\u001a\u00020\u00032\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u000eHÖ\u0001J\t\u0010=\u001a\u00020>HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$¨\u0006A"}, d2 = {"Lcom/obric/memorydata/markdown/stream/MarkwonConfig;", "", "enableSyntaxHighlight", "", "enableTables", "enableStrikethrough", "enableTaskList", "enableHtml", "enableImages", "enableLinkify", "useCoilForImages", "syntaxTheme", "Lcom/obric/memorydata/markdown/stream/MarkwonConfig$SyntaxTheme;", "codeBlockBackgroundColor", "", "customPlugins", "", "Lio/noties/markwon/MarkwonPlugin;", "enableLatex", "latexTextSize", "", "latexTextColor", "<init>", "(ZZZZZZZZLcom/obric/memorydata/markdown/stream/MarkwonConfig$SyntaxTheme;ILjava/util/List;ZFI)V", "getEnableSyntaxHighlight", "()Z", "getEnableTables", "getEnableStrikethrough", "getEnableTaskList", "getEnableHtml", "getEnableImages", "getEnableLinkify", "getUseCoilForImages", "getSyntaxTheme", "()Lcom/obric/memorydata/markdown/stream/MarkwonConfig$SyntaxTheme;", "getCodeBlockBackgroundColor", "()I", "getCustomPlugins", "()Ljava/util/List;", "getEnableLatex", "getLatexTextSize", "()F", "getLatexTextColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "", "SyntaxTheme", "Companion", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MarkwonConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10006a = null;
    private static final MarkwonConfig p = null;
    private static final MarkwonConfig q = null;
    private static final MarkwonConfig r = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10007b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final SyntaxTheme j;
    private final int k;
    private final List<io.noties.markwon.k> l;
    private final boolean m;
    private final float n;
    private final int o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/markdown/stream/MarkwonConfig$SyntaxTheme;", "", "<init>", "(Ljava/lang/String;I)V", "DARKULA", "DEFAULT", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum SyntaxTheme extends Enum<SyntaxTheme> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ SyntaxTheme[] $VALUES = null;
        public static final SyntaxTheme DARKULA = null;
        public static final SyntaxTheme DEFAULT = null;

        private static final /* synthetic */ SyntaxTheme[] $values() {
            return new SyntaxTheme[]{DARKULA, DEFAULT};
        }

        static {
            DARKULA = new SyntaxTheme("DARKULA", 0);
            DEFAULT = new SyntaxTheme("DEFAULT", 1);
            SyntaxTheme[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private SyntaxTheme(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<SyntaxTheme> getEntries() {
            return $ENTRIES;
        }

        public static SyntaxTheme valueOf(String r2) {
            return (SyntaxTheme) ZeusTransformUtils.preCheckCast(Enum.valueOf(SyntaxTheme.class, r2), SyntaxTheme.class, "com.obric.memorydata.plugin");
        }

        public static SyntaxTheme[] values() {
            return (SyntaxTheme[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SyntaxTheme[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/markdown/stream/MarkwonConfig$Companion;", "", "<init>", "()V", "DEFAULT", "Lcom/obric/memorydata/markdown/stream/MarkwonConfig;", "getDEFAULT", "()Lcom/obric/memorydata/markdown/stream/MarkwonConfig;", "MINIMAL", "getMINIMAL", "FULL", "getFULL", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10006a = new a(null);
        p = new MarkwonConfig(false, false, false, false, false, false, false, false, null, 0, null, false, 0.0f, 0, 16383, null);
        q = new MarkwonConfig(false, false, true, false, false, false, true, false, null, 0, null, false, 0.0f, 0, 16128, null);
        r = new MarkwonConfig(true, true, true, true, true, true, true, true, null, 0, null, false, 0.0f, 0, 16128, null);
    }

    public MarkwonConfig() {
        this(false, false, false, false, false, false, false, false, null, 0, null, false, 0.0f, 0, 16383, null);
    }

    public MarkwonConfig(boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, SyntaxTheme r14, int r15, List<? extends io.noties.markwon.k> r16, boolean r17, float r18, int r19) {
        List<io.noties.markwon.k> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "syntaxTheme");
        Intrinsics.checkNotNullParameter(r2, "customPlugins");
        this.f10007b = r6;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r2;
        this.m = r17;
        this.n = r18;
        this.o = r19;
    }

    public /* synthetic */ MarkwonConfig(boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, boolean r21, boolean r22, SyntaxTheme r23, int r24, List r25, boolean r26, float r27, int r28, int r29, DefaultConstructorMarker r30) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.memorydata.plugin");
        boolean r3 = true;
        if ((r29 & 1) == 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r29 & 2) == 0) goto L9;
        boolean r4 = true;
    L11:
        if ((r29 & 4) == 0) goto L13;
        boolean r5 = true;
    L15:
        if ((r29 & 8) == 0) goto L17;
        boolean r6 = true;
    L19:
        if ((r29 & 16) == 0) goto L21;
        boolean r7 = true;
    L23:
        if ((r29 & 32) == 0) goto L25;
        boolean r8 = true;
    L27:
        if ((r29 & 64) == 0) goto L29;
        boolean r9 = true;
    L31:
        if ((r29 & 128) == 0) goto L33;
        boolean r10 = true;
    L35:
        if ((r29 & 256) == 0) goto L37;
        SyntaxTheme r11 = SyntaxTheme.DARKULA;
    L39:
        if ((r29 & 512) == 0) goto L41;
        int r12 = Color.parseColor("#2B2B2B");
    L43:
        if ((r29 & 1024) == 0) goto L46;
        r1 = CollectionsKt.emptyList();
    L46:
        if ((r29 & 2048) != 0) goto L50;
        r3 = r26;
    L50:
        if ((r29 & 4096) == 0) goto L52;
        float r13 = 16.0f;
    L54:
        if ((r29 & 8192) == 0) goto L56;
        int r0 = ViewCompat.MEASURED_STATE_MASK;
    L57:
        this(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1, r3, r13, r0);
        return;
    L56:
        r0 = r28;
        goto L57
    L52:
        r13 = r27;
        goto L54
    L41:
        r12 = r24;
        goto L43
    L37:
        r11 = r23;
        goto L39
    L33:
        r10 = r22;
        goto L35
    L29:
        r9 = r21;
        goto L31
    L25:
        r8 = r20;
        goto L27
    L21:
        r7 = r19;
        goto L23
    L17:
        r6 = r18;
        goto L19
    L13:
        r5 = r17;
        goto L15
    L9:
        r4 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MarkwonConfig.class) == true) goto L8;
        return false;
    L8:
        MarkwonConfig r6 = (MarkwonConfig) ZeusTransformUtils.preCheckCast(r5, MarkwonConfig.class, "com.obric.memorydata.plugin");
        if (this.f10007b == r6.f10007b) goto L12;
        return false;
    L12:
        if (this.c == r6.c) goto L15;
        return false;
    L15:
        if (this.d == r6.d) goto L18;
        return false;
    L18:
        if (this.e == r6.e) goto L21;
        return false;
    L21:
        if (this.f == r6.f) goto L24;
        return false;
    L24:
        if (this.g == r6.g) goto L27;
        return false;
    L27:
        if (this.h == r6.h) goto L30;
        return false;
    L30:
        if (this.i == r6.i) goto L33;
        return false;
    L33:
        if (this.j == r6.j) goto L36;
        return false;
    L36:
        if (this.k == r6.k) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L42;
        return false;
    L42:
        if (this.m == r6.m) goto L45;
        return false;
    L45:
        if (Float.compare(this.n, r6.n) == 0) goto L48;
        return false;
    L48:
        if (this.o == r6.o) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((Boolean.hashCode(this.f10007b) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + Boolean.hashCode(this.i)) * 31) + this.j.hashCode()) * 31) + Integer.hashCode(this.k)) * 31) + this.l.hashCode()) * 31) + Boolean.hashCode(this.m)) * 31) + Float.hashCode(this.n)) * 31) + Integer.hashCode(this.o);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("MarkwonConfig(enableSyntaxHighlight=").append(this.f10007b).append(", enableTables=").append(this.c).append(", enableStrikethrough=").append(this.d).append(", enableTaskList=").append(this.e).append(", enableHtml=").append(this.f).append(", enableImages=").append(this.g).append(", enableLinkify=").append(this.h).append(", useCoilForImages=").append(this.i).append(", syntaxTheme=").append(this.j).append(", codeBlockBackgroundColor=").append(this.k).append(", customPlugins=").append(this.l).append(", enableLatex=");
        r0.append(this.m).append(", latexTextSize=").append(this.n).append(", latexTextColor=").append(this.o).append(')');
        return r0.toString();
    }
}

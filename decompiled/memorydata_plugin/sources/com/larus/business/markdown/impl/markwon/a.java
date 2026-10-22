package com.larus.business.markdown.impl.markwon;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.Node;
import org.commonmark.node.Paragraph;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\r\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0014\u0010\u001b\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0002J2\u0010\u001c\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\b\b\u0002\u0010\u001d\u001a\u00020\u00122\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00040\u001fH\u0002J&\u0010!\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\"\u001a\u00020 2\b\b\u0002\u0010\u001d\u001a\u00020\u0012H\u0002J\f\u0010#\u001a\u00020\u0004*\u00020 H\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006%"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/ASTModifier;", "", "()V", EventBody.KEY_VALUE, "", "enable", "getEnable", "()Z", "setEnable", "(Z)V", "latexOptEnable", "getLatexOptEnable", "setLatexOptEnable", "checkDigit", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "startIndex", "", "endIndex", "modifyLastNode", "", "node", "Lorg/commonmark/node/Node;", "modifyLastTextNode", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "Lorg/commonmark/node/Text;", "tryDeleteListToken", "tryDeleteTailToken", "maxCount", "predicate", "Lkotlin/Function1;", "", "tryDeleteToken", "token", "isEmoji", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0216a f5185a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5186b;
    private boolean c;

    /* JADX INFO: renamed from: com.larus.business.markdown.impl.markwon.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/ASTModifier$Companion;", "", "()V", "TAG", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0216a {
        private C0216a() {
        }

        public /* synthetic */ C0216a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f5185a = new C0216a(null);
    }

    public a() {
    }

    private final void a(Text r10) {
        String r0 = r10.getLiteral();
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        StringBuilder r3 = new StringBuilder(r0);
        boolean r9 = a(r3, '_', 3) | ((a(this, r3, 0, (Function1) ZeusTransformUtils.preCheckCast(new ASTModifier$modifyLastTextNode$changed$1(this), Function1.class, "com.obric.memorydata.plugin"), 2, null) | a(r3)) | a(r3, '*', 3));
        r10.setLiteral(r3.toString());
        if (r9 == false) goto L20;
        com.larus.business.markdown.api.depend.f r11 = com.larus.business.markdown.api.depend.g.a();
        if (r11 == null) goto L16;
        r11.d("ASTModifier", "==>literal_1=" + r0);
    L16:
        com.larus.business.markdown.api.depend.f r12 = com.larus.business.markdown.api.depend.g.a();
        if (r12 == null) goto L21;
        r12.d("ASTModifier", "==>literal_2=" + r10.getLiteral());
        return;
    L21:
        return;
    L20:
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private final boolean a(char r4) {
        if (9728 <= r4) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return true;
    L10:
        if (62208 > r4) goto L13;
        if (r4 >= 62976) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L45;
        if (62976 <= r4) goto L17;
    L19:
        boolean r3 = false;
    L20:
        if (r3 == false) goto L22;
        return true;
    L22:
        if (63104 <= r4) goto L24;
    L26:
        boolean r5 = false;
    L27:
        if (r5 == false) goto L29;
        return true;
    L29:
        if (63744 <= r4) goto L31;
    L33:
        boolean r6 = false;
    L34:
        if (r6 == false) goto L36;
        return true;
    L36:
        if (Character.isHighSurrogate(r4) == false) goto L38;
        return true;
    L38:
        if (Character.isLowSurrogate(r4) == false) goto L40;
        return true;
    L40:
        if (r4 != 8205) goto L43;
        return true;
    L43:
        return false;
    L31:
        if (r4 >= 64000) goto L33;
        r6 = true;
        goto L34
    L24:
        if (r4 >= 63232) goto L26;
        r5 = true;
        goto L27
    L17:
        if (r4 >= 63056) goto L19;
        r3 = true;
        goto L20
    L45:
        return true;
    L13:
        r2 = false;
        goto L14
    L5:
        if (r4 >= 9984) goto L7;
        r1 = true;
        goto L8
    }

    public static final /* synthetic */ boolean a(a r0, char r1) {
        return r0.a(r1);
    }

    static /* synthetic */ boolean a(a r1, StringBuilder r2, int r3, Function1 r4, int r5, Object r6) {
        Function1<? super Character, Boolean> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = Integer.MAX_VALUE;
    L6:
        return r1.a(r2, r3, r7);
    }

    private final boolean a(StringBuilder r6) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return false;
    L8:
        char r1 = r6.charAt(r6.length() - 1);
        if (r6.length() != 1) goto L23;
        if (r1 != '-') goto L13;
    L20:
        StringsKt.clear(r6);
        return true;
    L13:
        if (r1 == '*') goto L20;
        if (r1 == '+') goto L20;
        if (Character.isDigit(r1) == true) goto L20;
        return false;
    L23:
        if (r6.length() > 3) goto L29;
        if (a(r6, 0, r6.length() - 1) == false) goto L29;
        StringsKt.clear(r6);
        return true;
    L29:
        if (r1 == '.') goto L33;
        if (r1 == ')') goto L33;
    L36:
        return false;
    L33:
        if (a(r6, 0, r6.length() - 2) == false) goto L36;
        StringsKt.clear(r6);
        return true;
    L5:
        r0 = false;
        goto L6
    }

    private final boolean a(StringBuilder r10, char r11, int r12) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == false) goto L8;
        return false;
    L8:
        int r13 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), r11, 0, false, 6, null);
        if (r13 >= 0) goto L11;
        return false;
    L11:
        int r0 = r13 + 1;
    L13:
        if (r0 >= r10.length()) goto L19;
        if (r0 >= (r13 + r12)) goto L19;
        if (r10.charAt(r0) != r11) goto L19;
        r0 = r0 + 1;
    L19:
        r10.delete(r13, r0);
        return true;
    L5:
        r9 = false;
        goto L6
    }

    private final boolean a(StringBuilder r2, int r3, int r4) {
        if (r3 >= 0) goto L5;
        return false;
    L5:
        if (r4 >= r2.length()) goto L19;
        if (r3 > r4) goto L20;
        if (r3 <= r4) goto L10;
    L14:
        return true;
    L10:
        if (Character.isDigit(r2.charAt(r3)) == false) goto L11;
        if (r3 == r4) goto L14;
        r3 = r3 + 1;
        goto L10
    L11:
        return false;
    L20:
        return false;
    L19:
        return false;
    }

    private final boolean a(StringBuilder r7, int r8, Function1<? super Character, Boolean> r9) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        boolean r3 = false;
    L4:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L6;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L12;
        if (r2 >= r8) goto L12;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r6.invoke(Character.valueOf(r7.charAt(r7.length() - 1))), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L12;
        r7.delete(r7.length() - 1, r7.length());
        r2 = r2 + 1;
        r3 = true;
    L12:
        return r3;
    L6:
        r4 = false;
        goto L7
    }

    public final void a(Node r3) {
        Intrinsics.checkNotNullParameter(r3, "node");
        if (this.f5186b == true) goto L6;
        return;
    L6:
        if (r3.lastChild == null) goto L9;
        r3 = r3.lastChild;
        Intrinsics.checkNotNullExpressionValue(r3, "currNode.lastChild");
        goto L6
    L9:
        if (ZeusTransformUtils.instanceOf(r3, Text.class) == false) goto L14;
        if (ZeusTransformUtils.instanceOf(r3.parent, Paragraph.class) == false) goto L14;
        a((Text) ZeusTransformUtils.preCheckCast(r3, Text.class, "com.obric.memorydata.plugin"));
    L14:
        if (this.c == false) goto L20;
        com.larus.business.markdown.api.extplugin.latex.a r2 = com.larus.business.markdown.api.extplugin.latex.b.a();
        if (r2 == null) goto L21;
        r2.a(r3, "");
        return;
    L21:
        return;
    }

    public final void a(boolean r4) {
        com.larus.business.markdown.api.depend.f r0 = com.larus.business.markdown.api.depend.g.a();
        if (r0 == null) goto L5;
        r0.d("ASTModifier", "==>optimized=" + r4);
    L5:
        this.f5186b = r4;
    }

    public final boolean a() {
        return this.c;
    }

    public final void b(boolean r4) {
        com.larus.business.markdown.api.depend.f r0 = com.larus.business.markdown.api.depend.g.a();
        if (r0 == null) goto L5;
        r0.d("ASTModifier", "==>latex optimized=" + r4);
    L5:
        this.c = r4;
    }
}

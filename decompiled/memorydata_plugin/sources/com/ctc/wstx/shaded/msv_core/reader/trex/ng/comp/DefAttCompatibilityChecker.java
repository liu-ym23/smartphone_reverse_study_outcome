package com.ctc.wstx.shaded.msv_core.reader.trex.ng.comp;

import com.ctc.wstx.shaded.msv_core.grammar.AttributeExp;
import com.ctc.wstx.shaded.msv_core.grammar.ChoiceExp;
import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ListExp;
import com.ctc.wstx.shaded.msv_core.grammar.OneOrMoreExp;
import com.ctc.wstx.shaded.msv_core.grammar.SimpleNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.a.g;
import com.ctc.wstx.shaded.msv_core.util.StringPair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.xml.sax.Locator;

/* JADX INFO: loaded from: classes2.dex */
class DefAttCompatibilityChecker extends com.ctc.wstx.shaded.msv_core.reader.trex.ng.comp.a {
    private final Map c;
    private final g d;

    /* JADX INFO: renamed from: com.ctc.wstx.shaded.msv_core.reader.trex.ng.comp.DefAttCompatibilityChecker$1, reason: invalid class name */
    class AnonymousClass1 extends com.ctc.wstx.shaded.msv_core.grammar.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f3625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f3626b;
        final /* synthetic */ DefAttCompatibilityChecker c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private Map h;
        private SimpleNameClass i;

        @Override // com.ctc.wstx.shaded.msv_core.grammar.a.b, com.ctc.wstx.shaded.msv_core.grammar.f
        public void a(AttributeExp r9) {
            if (DefAttCompatibilityChecker.a(this.c).containsKey(r9) == true) goto L5;
            return;
        L5:
            if (this.f == true) goto L7;
        L22:
            DefAttCompatibilityChecker r8 = this.c;
            r8.a(new Locator[]{r8.f3629a.a(r9)}, "RELAXNGReader.Compatibility.DefaultValue.NotOptional");
            return;
        L7:
            if (this.e == false) goto L22;
            if (this.d == false) goto L14;
            DefAttCompatibilityChecker r10 = this.c;
            r10.a(new Locator[]{r10.f3629a.a(r9)}, "RELAXNGReader.Compatibility.DefaultValue.Repeatable");
            return;
        L14:
            if (this.g == true) goto L17;
            DefAttCompatibilityChecker r11 = this.c;
            r11.a(new Locator[]{r11.f3629a.a(r9)}, "RELAXNGReader.Compatibility.DefaultValue.ComplexElementName");
            return;
        L17:
            String r0 = (String) ZeusTransformUtils.preCheckCast(DefAttCompatibilityChecker.a(this.c).get(r9), String.class, "com.obric.memorydata.plugin");
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.h.put(new StringPair((SimpleNameClass) ZeusTransformUtils.preCheckCast(r9.nameClass, SimpleNameClass.class, "com.obric.memorydata.plugin")), r0), String.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L20;
            return;
        L20:
            if (r3.equals(r0) == true) goto L26;
            DefAttCompatibilityChecker r5 = this.c;
            r5.a(new Locator[]{r5.f3629a.a(r9)}, "RELAXNGReader.Compatibility.DefaultValue.DifferentValues", new Object[]{r3, r0, this.i.localName, ((SimpleNameClass) ZeusTransformUtils.preCheckCast(r9.nameClass, SimpleNameClass.class, "com.obric.memorydata.plugin")).localName});
            return;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.a.b, com.ctc.wstx.shaded.msv_core.grammar.f
        public void a(ChoiceExp r5) {
            boolean r0 = this.f;
            boolean r1 = this.e;
            this.e = true;
            if (DefAttCompatibilityChecker.a(this.c, r5.exp1) == false) goto L5;
        L7:
            super.a(r5);
            this.f = r0;
            this.e = r1;
            return;
        L5:
            if (DefAttCompatibilityChecker.a(this.c, r5.exp2) == true) goto L7;
            this.f = false;
            goto L7
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.a.b, com.ctc.wstx.shaded.msv_core.grammar.f
        public void a(ElementExp r17) {
            if (this.f3625a.add(r17) == true) goto L5;
            return;
        L5:
            boolean r2 = this.g;
            boolean r3 = this.f;
            boolean r4 = this.e;
            boolean r5 = this.d;
            SimpleNameClass r6 = this.i;
            Map r7 = this.h;
            boolean r8 = ZeusTransformUtils.instanceOf(r17.getNameClass(), SimpleNameClass.class);
            this.g = r8;
            this.f = true;
            this.e = false;
            this.d = false;
            StringPair r11 = null;
            if (r8 == false) goto L8;
            this.i = (SimpleNameClass) ZeusTransformUtils.preCheckCast(r17.getNameClass(), SimpleNameClass.class, "com.obric.memorydata.plugin");
            r11 = new StringPair(this.i);
            this.h = new HashMap();
        L9:
            r17.contentModel.visit(this);
            if (r11 == null) goto L17;
            a r9 = (a) ZeusTransformUtils.preCheckCast(this.f3626b.get(r11), a.class, "com.obric.memorydata.plugin");
            if (r9 != null) goto L15;
            this.f3626b.put(r11, new a(r17, this.h));
            goto L17
        L15:
            if (r9.f3627a.equals(this.h) == true) goto L17;
            DefAttCompatibilityChecker r13 = this.c;
            r13.a(new Locator[]{r13.f3629a.a(r9.f3628b), this.c.f3629a.a(r17)}, "RELAXNGReader.Compatibility.DefaultValue.CompetingElements", new Object[]{((SimpleNameClass) ZeusTransformUtils.preCheckCast(r9.f3628b.getNameClass(), SimpleNameClass.class, "com.obric.memorydata.plugin")).localName});
            this.f3626b.remove(r11);
        L17:
            this.g = r2;
            this.f = r3;
            this.e = r4;
            this.d = r5;
            this.i = r6;
            this.h = r7;
            return;
        L8:
            this.i = null;
            goto L9
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.a.b, com.ctc.wstx.shaded.msv_core.grammar.f
        public void a(ListExp r1) {
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.a.b, com.ctc.wstx.shaded.msv_core.grammar.f
        public void a(OneOrMoreExp r3) {
            boolean r0 = this.d;
            this.d = true;
            r3.exp.visit(this);
            this.d = r0;
        }
    }

    private static final class Abort extends RuntimeException {
        private Abort() {
        }

        /* synthetic */ Abort(AnonymousClass1 r1) {
            this();
        }
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f3627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ElementExp f3628b;

        a(ElementExp r3, Map r4) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            this.f3628b = r3;
            this.f3627a = r5;
        }
    }

    static /* synthetic */ Map a(DefAttCompatibilityChecker r0) {
        return r0.c;
    }

    private boolean a(Expression r3) {
        if (r3 != Expression.epsilon) goto L6;
        return true;
    L6:
        if (r3.visit(this.d) == Expression.epsilon) goto L10;
        return false;
    L10:
        return true;
    }

    static /* synthetic */ boolean a(DefAttCompatibilityChecker r0, Expression r1) {
        return r0.a(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.trex.ng.comp.a
    public void a(boolean r1) {
        this.f3630b.isDefaultAttributeValueCompatible = r1;
    }
}

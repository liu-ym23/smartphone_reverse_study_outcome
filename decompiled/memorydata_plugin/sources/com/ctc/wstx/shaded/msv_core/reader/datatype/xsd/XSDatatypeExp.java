package com.ctc.wstx.shaded.msv_core.reader.datatype.xsd;

import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.FinalComponent;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.StringType;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;
import org.xml.sax.Locator;

/* JADX INFO: loaded from: classes2.dex */
public class XSDatatypeExp extends ReferenceExp {
    private XSDatatype dt;
    private final String namespaceUri;
    private transient com.ctc.wstx.shaded.msv_core.reader.i ownerState;
    private ExpressionPool pool;
    private transient a renderer;

    public interface a {
        XSDatatype a(b r1);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Stack f3614a;

        b() {
            this.f3614a = new Stack();
        }

        static /* synthetic */ Stack a(b r0) {
            return r0.f3614a;
        }
    }

    public XSDatatypeExp(XSDatatype r3, ExpressionPool r4) {
        XSDatatype r5 = (XSDatatype) ZeusTransformUtils.wrapperContextForParams(r3, XSDatatype.class, "com.obric.memorydata.plugin");
        super(r5.getName());
        this.namespaceUri = r5.getNamespaceUri();
        this.dt = r5;
        this.pool = r4;
        this.ownerState = null;
        this.renderer = null;
        this.exp = r4.createData(r5);
    }

    private XSDatatypeExp(String r1, String r2) {
        super(r2);
        this.namespaceUri = r1;
    }

    public XSDatatypeExp(String r3, String r4, com.ctc.wstx.shaded.msv_core.reader.d r5, a r6) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.memorydata.plugin");
        super(r4);
        this.namespaceUri = r3;
        this.dt = null;
        this.ownerState = r5.b();
        this.renderer = r7;
        this.pool = r5.c;
        r5.a(this);
    }

    static /* synthetic */ XSDatatype access$000(XSDatatypeExp r0) {
        return r0.dt;
    }

    static /* synthetic */ ExpressionPool access$100(XSDatatypeExp r0) {
        return r0.pool;
    }

    public static XSDatatypeExp makeList(final String r2, final String r3, final XSDatatypeExp r4, com.ctc.wstx.shaded.msv_core.reader.d r5) {
        if (r4.isLateBind() == true) goto L7;
        return new XSDatatypeExp(com.ctc.wstx.shaded.msv_core.datatype.xsd.b.a(r2, r3, r4.dt), r5.c);
    L7:
        return new XSDatatypeExp(r2, r3, r5, new AnonymousClass3(r2, r3, r4));
    }

    public static XSDatatypeExp makeUnion(final String r6, final String r7, Collection r8, com.ctc.wstx.shaded.msv_core.reader.d r9) {
        final Collection r10 = (Collection) ZeusTransformUtils.wrapperContextForParams(r8, Collection.class, "com.obric.memorydata.plugin");
        final XSDatatype[] r0 = new XSDatatype[r10.size()];
        Iterator r2 = r10.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L11;
        XSDatatypeExp r4 = (XSDatatypeExp) ZeusTransformUtils.preCheckCast(r2.next(), XSDatatypeExp.class, "com.obric.memorydata.plugin");
        if (r4.isLateBind() == true) goto L8;
        r0[r3] = r4.dt;
        r3 = r3 + 1;
        goto L4
    L8:
        return new XSDatatypeExp(r6, r7, r9, new AnonymousClass4(r10, r0, r6, r7));
    L11:
        return new XSDatatypeExp(com.ctc.wstx.shaded.msv_core.datatype.xsd.b.a(r6, r7, r0), r9.c);
    }

    public XSDatatypeExp createFinalizedType(final int r5, com.ctc.wstx.shaded.msv_core.reader.d r6) {
        if (r5 != 0) goto L5;
        return this;
    L5:
        if (isLateBind() == true) goto L9;
        return new XSDatatypeExp(new FinalComponent((XSDatatypeImpl) ZeusTransformUtils.preCheckCast(this.dt, XSDatatypeImpl.class, "com.obric.memorydata.plugin"), r5), this.pool);
    L9:
        return new XSDatatypeExp(this.namespaceUri, this.name, r6, new AnonymousClass2(this, r5));
    }

    public k createIncubator() {
        if (isLateBind() == false) goto L7;
        return new c(this, this.ownerState.f3622b);
    L7:
        return new AnonymousClass1(this);
    }

    public XSDatatypeExp getClone() {
        XSDatatypeExp r0 = new XSDatatypeExp(this.namespaceUri, this.name);
        r0.redefine(this);
        return r0;
    }

    public XSDatatype getCreatedType() {
        XSDatatype r0 = this.dt;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException();
    }

    public com.ctc.wstx.shaded.msv_core.reader.i getOwnerState() {
        return this.ownerState;
    }

    public XSDatatype getType(b r7) {
        XSDatatype r0 = this.dt;
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (r7 != null) goto L8;
        r7 = new b();
    L8:
        if (b.a(r7).contains(this) == false) goto L15;
        Vector r1 = new Vector();
        int r2 = 0;
    L11:
        if (r2 >= b.a(r7).size()) goto L13;
        r1.add(((XSDatatypeExp) ZeusTransformUtils.preCheckCast(b.a(r7).get(r2), XSDatatypeExp.class, "com.obric.memorydata.plugin")).ownerState.c_());
        r2 = r2 + 1;
        goto L11
    L13:
        this.ownerState.f3622b.a((Locator[]) ZeusTransformUtils.preCheckCast((Locator[]) ZeusTransformUtils.preCheckCast(r1.toArray(new Locator[0]), Locator[].class, "com.obric.memorydata.plugin"), Locator[].class, "com.obric.memorydata.plugin"), "GrammarReader.RecursiveDatatypeDefinition", null);
        return StringType.theInstance;
    L15:
        b.a(r7).push(this);
        this.dt = this.renderer.a(r7);     // Catch: DatatypeException -> L18
    L20:
        b.a(r7).pop();
        XSDatatype r8 = this.dt;
        if (r8 == null) goto L25;
        this.exp = this.pool.createData(r8);
        return this.dt;
    L25:
        throw new Error();
    L18:
        e = move-exception;
        this.ownerState.f3622b.a("GrammarReader.BadType", new Object[]{e}, e, new Locator[]{this.ownerState.c_()});
        this.dt = StringType.theInstance;
        goto L20
    }

    public final boolean isLateBind() {
        if (this.dt != null) goto L5;
        return true;
    L5:
        return false;
    }

    public void patch() {
        getType(null);
    }

    public void redefine(XSDatatypeExp r2) {
        this.exp = r2.exp;
        this.dt = r2.dt;
        this.pool = r2.pool;
        com.ctc.wstx.shaded.msv_core.reader.i r0 = r2.ownerState;
        this.ownerState = r0;
        this.renderer = r2.renderer;
        if (r0 == null) goto L6;
        r0.f3622b.a(this);
        return;
    }
}

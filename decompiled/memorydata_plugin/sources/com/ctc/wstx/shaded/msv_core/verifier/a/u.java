package com.ctc.wstx.shaded.msv_core.verifier.a;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.StringType;
import com.ctc.wstx.shaded.msv_core.grammar.DataExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ListExp;
import com.ctc.wstx.shaded.msv_core.grammar.ValueExp;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class u extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.ctc.wstx.shaded.msv.relaxng_datatype.a[] f3676a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3677b;
    public final com.ctc.wstx.shaded.msv_core.grammar.g c;
    protected final q d;
    protected final boolean e;
    public com.ctc.wstx.shaded.msv_core.util.a f;
    protected boolean g;

    static {
        f3676a = new com.ctc.wstx.shaded.msv.relaxng_datatype.a[0];
    }

    public u(p r3, String r4, com.ctc.wstx.shaded.msv_core.grammar.g r5) {
        com.ctc.wstx.shaded.msv_core.grammar.g r6 = (com.ctc.wstx.shaded.msv_core.grammar.g) ZeusTransformUtils.wrapperContextForParams(r5, com.ctc.wstx.shaded.msv_core.grammar.g.class, "com.obric.memorydata.plugin");
        this(r3.c, r4, r6, null);
    }

    public u(p r3, String r4, com.ctc.wstx.shaded.msv_core.grammar.g r5, com.ctc.wstx.shaded.msv_core.util.a r6) {
        com.ctc.wstx.shaded.msv_core.grammar.g r7 = (com.ctc.wstx.shaded.msv_core.grammar.g) ZeusTransformUtils.wrapperContextForParams(r5, com.ctc.wstx.shaded.msv_core.grammar.g.class, "com.obric.memorydata.plugin");
        this(r3.c, r4, r7, r6);
    }

    public u(q r3, String r4, com.ctc.wstx.shaded.msv_core.grammar.g r5, com.ctc.wstx.shaded.msv_core.util.a r6) {
        com.ctc.wstx.shaded.msv_core.grammar.g r7 = (com.ctc.wstx.shaded.msv_core.grammar.g) ZeusTransformUtils.wrapperContextForParams(r5, com.ctc.wstx.shaded.msv_core.grammar.g.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        this.g = false;
        this.d = r3;
        this.f3677b = r4;
        this.c = r7;
        this.f = r6;
        if (r4.trim().length() != 0) goto L5;
        r0 = true;
    L5:
        this.e = r0;
        if (r0 == false) goto L10;
        if (r6 == null) goto L11;
        r6.f3638a = f3676a;
        return;
    L11:
        return;
    }

    private void a(com.ctc.wstx.shaded.msv.relaxng_datatype.a r5) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.a r6 = (com.ctc.wstx.shaded.msv.relaxng_datatype.a) ZeusTransformUtils.wrapperContextForParams(r5, com.ctc.wstx.shaded.msv.relaxng_datatype.a.class, "com.obric.memorydata.plugin");
        if (this.g == true) goto L5;
        com.ctc.wstx.shaded.msv.relaxng_datatype.a[] r3 = {r6};
        this.f.f3638a = r3;
        this.g = true;
        return;
    L5:
        if (this.f.f3638a != null) goto L7;
        return;
    L7:
        if (this.f.f3638a[0] == r6) goto L9;
    L10:
        this.f.f3638a = null;
        return;
    L9:
        if (this.f.f3638a.length != 1) goto L10;
    }

    public u a(String r3, com.ctc.wstx.shaded.msv_core.util.a r4) {
        return new u(this.d, r3, this.c, r4);
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a.v
    public boolean a(DataExp r4) {
        if (r4.dt.isValid(this.f3677b, this.c) == true) goto L6;
        return false;
    L6:
        if (r4.except == Expression.nullSet) goto L11;
        if (this.d.a(r4.except, this).isEpsilonReducible() == false) goto L11;
        return false;
    L11:
        if (this.f == null) goto L14;
        a(r4.dt);
    L14:
        if (r4.dt.getIdType() == 0) goto L20;
        com.ctc.wstx.shaded.msv_core.grammar.g r0 = this.c;
        if (r0 == null) goto L21;
        r0.a(r4.dt, this);
        return true;
    L21:
        return true;
    L20:
        return true;
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a.v
    public boolean a(ListExp r10) {
        StringTokenizer r0 = new StringTokenizer(this.f3677b);
        Expression r11 = r10.exp;
        int r2 = 0;
        if (this.f == null) goto L5;
        com.ctc.wstx.shaded.msv_core.util.a r1 = new com.ctc.wstx.shaded.msv_core.util.a();
        com.ctc.wstx.shaded.msv.relaxng_datatype.a[] r4 = new com.ctc.wstx.shaded.msv.relaxng_datatype.a[r0.countTokens()];
    L7:
        if (r0.hasMoreTokens() == false) goto L21;
        r11 = this.d.a(r11, a(r0.nextToken(), r1));
        if (r11 == Expression.nullSet) goto L10;
        if (r1 == null) goto L7;
        if (r1.f3638a == null) goto L14;
        if (r1.f3638a.length != 1) goto L19;
        r4[r2] = r1.f3638a[0];
        r2 = r2 + 1;
        goto L7
    L19:
        throw new Error();
    L14:
        this.g = true;
        this.f.f3638a = null;
        r1 = null;
        goto L7
    L10:
        return false;
    L21:
        if (r11.isEpsilonReducible() == true) goto L23;
        return false;
    L23:
        if (r4 != null) goto L25;
    L29:
        return true;
    L25:
        if (this.g == false) goto L27;
        this.f.f3638a = null;
    L28:
        this.g = true;
        goto L29
    L27:
        this.f.f3638a = r4;
        goto L28
    L5:
        r1 = null;
        r4 = null;
        goto L7
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a.v
    public boolean a(ValueExp r4) {
        Object r0 = r4.dt.createValue(this.f3677b, this.c);
        if (r4.dt.sameValue(r0, r4.value) == true) goto L7;
        return false;
    L7:
        if (this.f == null) goto L10;
        a(r4.dt);
    L10:
        if (r4.dt.getIdType() == 0) goto L16;
        com.ctc.wstx.shaded.msv_core.grammar.g r1 = this.c;
        if (r1 == null) goto L17;
        r1.a(r4.dt, this);
        return true;
    L17:
        return true;
    L16:
        return true;
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a.v
    public boolean d_() {
        if (this.f == null) goto L7;
        a(StringType.theInstance);
        return true;
    L7:
        return true;
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a.v
    boolean e_() {
        return this.e;
    }
}

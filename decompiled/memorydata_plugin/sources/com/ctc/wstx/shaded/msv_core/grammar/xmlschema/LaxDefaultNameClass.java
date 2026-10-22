package com.ctc.wstx.shaded.msv_core.grammar.xmlschema;

import com.ctc.wstx.shaded.msv_core.grammar.DifferenceNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.NameClass;
import com.ctc.wstx.shaded.msv_core.grammar.SimpleNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.h;
import com.ctc.wstx.shaded.msv_core.util.StringPair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class LaxDefaultNameClass extends NameClass {
    private static final long serialVersionUID = 1;
    private NameClass base;
    protected NameClass equivalentNameClass;
    private final Set names;

    public LaxDefaultNameClass(NameClass r2) {
        HashSet r0 = new HashSet();
        this.names = r0;
        this.base = r2;
        r0.add(new StringPair("*", "*"));
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.NameClass
    public boolean accepts(String r2, String r3) {
        if (this.base.accepts(r2, r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.names.contains(new StringPair(r2, r3)) == true) goto L7;
        return true;
    }

    public void addName(String r4, String r5) {
        this.names.add(new StringPair(r4, r5));
        this.names.add(new StringPair(r4, "*"));
        this.names.add(new StringPair("*", r5));
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.NameClass
    public Object visit(h r7) {
        h r8 = (h) ZeusTransformUtils.wrapperContextForParams(r7, h.class, "com.obric.memorydata.plugin");
        if (this.equivalentNameClass != null) goto L16;
        NameClass r0 = this.base;
        int r3 = 0;
        StringPair[] r1 = (StringPair[]) ZeusTransformUtils.preCheckCast((StringPair[]) ZeusTransformUtils.preCheckCast(this.names.toArray(new StringPair[0]), StringPair[].class, "com.obric.memorydata.plugin"), StringPair[].class, "com.obric.memorydata.plugin");
    L6:
        if (r3 >= r1.length) goto L14;
        if (r1[r3].namespaceURI == "*") goto L13;
        if (r1[r3].localName == "*") goto L13;
        r0 = new DifferenceNameClass(r0, new SimpleNameClass(r1[r3]));
    L13:
        r3 = r3 + 1;
        goto L6
    L14:
        this.equivalentNameClass = r0;
    L16:
        return this.equivalentNameClass.visit(r8);
    }
}

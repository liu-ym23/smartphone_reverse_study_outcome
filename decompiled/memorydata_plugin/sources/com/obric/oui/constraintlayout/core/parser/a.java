package com.obric.oui.constraintlayout.core.parser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<b> f13595a;

    public a a() {
        a r0 = (a) ZeusTransformUtils.preCheckCast(super.b(), a.class, "com.obric.memorydata.plugin");
        ArrayList<b> r1 = new ArrayList(this.f13595a.size());
        Iterator<b> r5 = this.f13595a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        b r3 = ((b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.memorydata.plugin")).b();
        r3.a(r0);
        r1.add(r3);
        goto L4
    L6:
        r0.f13595a = r1;
        return r0;
    }

    @Override // com.obric.oui.constraintlayout.core.parser.b
    public /* synthetic */ b b() {
        return a();
    }

    @Override // com.obric.oui.constraintlayout.core.parser.b
    public /* synthetic */ Object clone() {
        return a();
    }

    @Override // com.obric.oui.constraintlayout.core.parser.b
    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L11;
        return false;
    L11:
        return this.f13595a.equals(((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin")).f13595a);
    }

    @Override // com.obric.oui.constraintlayout.core.parser.b
    public int hashCode() {
        return Objects.hash(new Object[]{this.f13595a, Integer.valueOf(super.hashCode())});
    }

    @Override // com.obric.oui.constraintlayout.core.parser.b
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        Iterator<b> r1 = this.f13595a.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.memorydata.plugin");
        if (r0.length() <= 0) goto L8;
        r0.append("; ");
    L8:
        r0.append(r2);
        goto L4
    L10:
        return super.toString() + " = <" + r0 + " >";
    }
}

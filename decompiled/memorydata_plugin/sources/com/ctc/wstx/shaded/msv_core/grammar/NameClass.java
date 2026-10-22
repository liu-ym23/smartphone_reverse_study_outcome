package com.ctc.wstx.shaded.msv_core.grammar;

import com.ctc.wstx.shaded.msv_core.util.StringPair;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NameClass implements Serializable {
    public static final NameClass ALL = null;
    public static final String LOCALNAME_WILDCARD = "*";
    public static final String NAMESPACE_WILDCARD = "*";
    public static final NameClass NONE = null;
    private static final long serialVersionUID = 1;

    static {
        AnyNameClass r0 = new AnyNameClass();
        ALL = r0;
        NONE = new NotNameClass(r0);
    }

    public NameClass() {
    }

    public static NameClass intersection(NameClass r2, NameClass r3) {
        return com.ctc.wstx.shaded.msv_core.grammar.a.e.a(new DifferenceNameClass(r2, new NotNameClass(r3)));
    }

    public static NameClass union(NameClass r1, NameClass r2) {
        return com.ctc.wstx.shaded.msv_core.grammar.a.e.a(new ChoiceNameClass(r1, r2));
    }

    public final boolean accepts(StringPair r2) {
        return accepts(r2.namespaceURI, r2.localName);
    }

    public abstract boolean accepts(String r1, String r2);

    public final boolean includes(NameClass r2) {
        return !new AnonymousClass1(this).a(this, r2);
    }

    public final boolean isEqualTo(NameClass r2) {
        return !new AnonymousClass2(this).a(this, r2);
    }

    public boolean isNull() {
        return !new com.ctc.wstx.shaded.msv_core.grammar.a.c().a(this, ALL);
    }

    public NameClass simplify() {
        return com.ctc.wstx.shaded.msv_core.grammar.a.e.a(this);
    }

    public abstract Object visit(h r1);
}

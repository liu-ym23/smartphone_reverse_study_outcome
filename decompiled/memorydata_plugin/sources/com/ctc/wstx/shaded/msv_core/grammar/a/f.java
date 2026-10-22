package com.ctc.wstx.shaded.msv_core.grammar.a;

import com.ctc.wstx.shaded.msv_core.grammar.AnyNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.ChoiceNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.DifferenceNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.NameClass;
import com.ctc.wstx.shaded.msv_core.grammar.NamespaceNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.NotNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.SimpleNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.h;
import com.ctc.wstx.shaded.msv_core.util.StringPair;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class f implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final StringPair f3590a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set f3591b;

    static {
        f3590a = new StringPair("\u0000", "\u0000");
    }

    public f() {
        this.f3591b = new HashSet();
    }

    public static Set a(NameClass r1) {
        f r0 = new f();
        r1.visit(r0);
        return r0.f3591b;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.h
    public Object a(AnyNameClass r1) {
        this.f3591b.add(f3590a);
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.h
    public Object a(ChoiceNameClass r2) {
        r2.nc1.visit(this);
        r2.nc2.visit(this);
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.h
    public Object a(DifferenceNameClass r2) {
        r2.nc1.visit(this);
        r2.nc2.visit(this);
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.h
    public Object a(NamespaceNameClass r3) {
        this.f3591b.add(new StringPair(r3.namespaceURI, "\u0000"));
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.h
    public Object a(NotNameClass r3) {
        this.f3591b.add(f3590a);
        r3.child.visit(this);
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.h
    public Object a(SimpleNameClass r3) {
        this.f3591b.add(new StringPair(r3.namespaceURI, r3.localName));
        return null;
    }
}

package com.ctc.wstx.shaded.msv_core.grammar.a;

import com.ctc.wstx.shaded.msv_core.grammar.AnyNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.ChoiceNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.DifferenceNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.NameClass;
import com.ctc.wstx.shaded.msv_core.grammar.NamespaceNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.NotNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.SimpleNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected NameClass f3589b;
    protected NameClass c;
    protected final RuntimeException d;

    public d() {
        this.d = new RuntimeException();
        this.f3588a = "\u0000";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.h
    public Object a(AnyNameClass r1) {
        a("\u0000", "\u0000");
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
    public Object a(NamespaceNameClass r2) {
        a(r2.namespaceURI, "\u0000");
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.h
    public Object a(NotNameClass r1) {
        r1.child.visit(this);
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.h
    public Object a(SimpleNameClass r2) {
        a(r2.namespaceURI, r2.localName);
        return null;
    }

    public abstract void a(String r1, String r2);

    public boolean a(NameClass r1, NameClass r2) {
        this.f3589b = r1;     // Catch: RuntimeException -> L5
        this.c = r2;     // Catch: RuntimeException -> L5
        r2.visit(this);     // Catch: RuntimeException -> L5
        r1.visit(this);     // Catch: RuntimeException -> L5
        return false;
    L5:
        e = move-exception;
        if (e != this.d) goto L10;
        return true;
    L10:
        throw e;
    }
}

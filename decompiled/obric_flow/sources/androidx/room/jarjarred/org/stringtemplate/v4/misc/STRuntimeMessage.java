package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import androidx.room.jarjarred.org.stringtemplate.v4.InstanceScope;
import androidx.room.jarjarred.org.stringtemplate.v4.Interpreter;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.CompiledST;

/* JADX INFO: loaded from: classes.dex */
public class STRuntimeMessage extends STMessage {
    final Interpreter interp;

    /* JADX INFO: renamed from: ip, reason: collision with root package name */
    public final int f686ip;
    public final InstanceScope scope;

    public STRuntimeMessage(Interpreter r5, ErrorType r10, int r11) {
        this(r5, r10, r11, null);
    }

    public String getSourceLocation() {
        int r5 = this.f686ip;
        if (r5 < 0) goto L12;
        CompiledST r10 = this.self.impl;
        if (r10 == null) goto L12;
        Interval r11 = r10.sourceMap[r5];
        if (r11 != null) goto L10;
        return null;
    L10:
        int r12 = r11.f683a;
        return Misc.getLineCharPosition(r10.template, r12).toString();
    L12:
        return null;
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.misc.STMessage
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        String r10 = getSourceLocation();
        if (this.self == null) goto L9;
        r5.append("context [");
        if (this.interp == null) goto L7;
        r5.append(Interpreter.getEnclosingInstanceStackString(this.scope));
    L7:
        r5.append("]");
    L9:
        if (r10 == null) goto L11;
        r5.append(" ".concat(r10));
    L11:
        r5.append(" " + super.toString());
        return r5.toString();
    }

    public STRuntimeMessage(Interpreter r10, ErrorType r11, int r12, InstanceScope r13) {
        this(r10, r11, r12, r13, null);
    }

    public STRuntimeMessage(Interpreter r10, ErrorType r11, int r12, InstanceScope r13, Object r14) {
        this(r10, r11, r12, r13, null, r14, null);
    }

    public STRuntimeMessage(Interpreter r10, ErrorType r11, int r12, InstanceScope r13, Throwable r14, Object r15) {
        this(r10, r11, r12, r13, r14, r15, null);
    }

    public STRuntimeMessage(Interpreter r10, ErrorType r11, int r12, InstanceScope r13, Throwable r14, Object r15, Object r16) {
        this(r10, r11, r12, r13, r14, r15, r16, null);
    }

    public STRuntimeMessage(Interpreter r10, ErrorType r11, int r12, InstanceScope r13, Throwable r14, Object r15, Object r16, Object r17) {
        if (r13 == null) goto L6;
        ST r5 = r13.f675st;
    L7:
        super(r11, r5, r14, r15, r16, r17);
        this.interp = r10;
        this.f686ip = r12;
        this.scope = r13;
        return;
    L6:
        r5 = null;
        goto L7
    }
}

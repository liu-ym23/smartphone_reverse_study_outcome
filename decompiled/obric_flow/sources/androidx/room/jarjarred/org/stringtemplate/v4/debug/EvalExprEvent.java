package androidx.room.jarjarred.org.stringtemplate.v4.debug;

import ai.j0;
import androidx.room.jarjarred.org.stringtemplate.v4.InstanceScope;

/* JADX INFO: loaded from: classes.dex */
public class EvalExprEvent extends InterpEvent {
    public final String expr;
    public final int exprStartChar;
    public final int exprStopChar;

    public EvalExprEvent(InstanceScope r5, int r10, int r11, int r12, int r13) {
        super(r5, r10, r11);
        this.exprStartChar = r12;
        this.exprStopChar = r13;
        if (r12 < 0) goto L6;
        if (r13 < 0) goto L6;
        this.expr = r5.f675st.impl.template.substring(r12, r13 + 1);
        return;
    L6:
        this.expr = "";
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.debug.InterpEvent
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(getClass().getSimpleName());
        r5.append("{self=");
        r5.append(this.scope.f675st);
        r5.append(", expr='");
        r5.append(this.expr);
        r5.append("', exprStartChar=");
        r5.append(this.exprStartChar);
        r5.append(", exprStopChar=");
        r5.append(this.exprStopChar);
        r5.append(", start=");
        r5.append(this.outputStartChar);
        r5.append(", stop=");
        return j0.n(r5, this.outputStopChar, '}');
    }
}

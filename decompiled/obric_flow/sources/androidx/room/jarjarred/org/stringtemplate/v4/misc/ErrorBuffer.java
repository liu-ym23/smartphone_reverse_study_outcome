package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import androidx.room.jarjarred.org.stringtemplate.v4.STErrorListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ErrorBuffer implements STErrorListener {
    public List<STMessage> errors;

    public ErrorBuffer() {
        this.errors = new ArrayList();
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STErrorListener
    public void IOError(STMessage r5) {
        this.errors.add(r5);
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STErrorListener
    public void compileTimeError(STMessage r5) {
        this.errors.add(r5);
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STErrorListener
    public void internalError(STMessage r5) {
        this.errors.add(r5);
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STErrorListener
    public void runTimeError(STMessage r5) {
        if (r5.error == ErrorType.NO_SUCH_PROPERTY) goto L6;
        this.errors.add(r5);
        return;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        Iterator<STMessage> r10 = this.errors.iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        r5.append(r10.next().toString() + Misc.newline);
        goto L4
    L7:
        return r5.toString();
    }
}

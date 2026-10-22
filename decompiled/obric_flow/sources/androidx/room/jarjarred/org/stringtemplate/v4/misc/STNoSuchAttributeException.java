package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import ai.j0;
import androidx.room.jarjarred.org.stringtemplate.v4.InstanceScope;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.STException;

/* JADX INFO: loaded from: classes.dex */
public class STNoSuchAttributeException extends STException {
    public String name;
    public InstanceScope scope;

    public STNoSuchAttributeException(String r5, InstanceScope r10) {
        this.name = r5;
        this.scope = r10;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder r5 = new StringBuilder("from template ");
        r5.append(this.scope.f675st.getName());
        r5.append(" no attribute ");
        return j0.q(r5, this.name, " is visible");
    }
}

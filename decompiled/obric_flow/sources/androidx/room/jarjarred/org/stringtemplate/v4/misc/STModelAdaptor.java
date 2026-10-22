package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import androidx.room.jarjarred.org.stringtemplate.v4.Interpreter;
import androidx.room.jarjarred.org.stringtemplate.v4.ModelAdaptor;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;

/* JADX INFO: loaded from: classes.dex */
public class STModelAdaptor implements ModelAdaptor {
    public STModelAdaptor() {
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.ModelAdaptor
    public Object getProperty(Interpreter r5, ST r10, Object r11, Object r12, String r13) throws STNoSuchPropertyException {
        return ((ST) r11).getAttribute(r13);
    }
}

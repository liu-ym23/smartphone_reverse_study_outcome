package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import androidx.room.jarjarred.org.stringtemplate.v4.Interpreter;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;

/* JADX INFO: loaded from: classes.dex */
public class AggregateModelAdaptor extends MapModelAdaptor {
    public AggregateModelAdaptor() {
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.misc.MapModelAdaptor, androidx.room.jarjarred.org.stringtemplate.v4.ModelAdaptor
    public Object getProperty(Interpreter r10, ST r11, Object r12, Object r13, String r14) throws STNoSuchPropertyException {
        return super.getProperty(r10, r11, ((Aggregate) r12).properties, r13, r14);
    }
}

package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import androidx.room.jarjarred.org.stringtemplate.v4.Interpreter;
import androidx.room.jarjarred.org.stringtemplate.v4.ModelAdaptor;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MapModelAdaptor implements ModelAdaptor {
    public MapModelAdaptor() {
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.ModelAdaptor
    public Object getProperty(Interpreter r5, ST r10, Object r11, Object r12, String r13) throws STNoSuchPropertyException {
        Map r14 = (Map) r11;
        if (r12 != null) goto L6;
        Object r15 = r14.get("default");
    L19:
        if (r15 != STGroup.DICT_KEY) goto L22;
        return r12;
    L22:
        return r15;
    L6:
        if (r12.equals("keys") == false) goto L9;
        r15 = r14.keySet();
        goto L19
    L9:
        if (r12.equals("values") == false) goto L12;
        r15 = r14.values();
        goto L19
    L12:
        if (r14.containsKey(r12) == false) goto L15;
        r15 = r14.get(r12);
        goto L19
    L15:
        if (r14.containsKey(r13) == false) goto L17;
        r15 = r14.get(r13);
        goto L19
    L17:
        r15 = r14.get("default");
        goto L19
    }
}

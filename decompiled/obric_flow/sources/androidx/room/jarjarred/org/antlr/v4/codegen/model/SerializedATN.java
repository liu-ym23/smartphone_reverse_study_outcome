package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.Target;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNSerializer;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntegerList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SerializedATN extends OutputModelObject {
    public List<String> serialized;

    public SerializedATN(OutputModelFactory r10, ATN r11) {
        super(r10);
        IntegerList r12 = ATNSerializer.getSerialized(r11);
        this.serialized = new ArrayList(r12.size());
        int[] r13 = r12.toArray();
        int r5 = r13.length;
        int r14 = 0;
    L3:
        if (r14 >= r5) goto L8;
        int r15 = r13[r14];
        Target r16 = r10.getGenerator().getTarget();
        if (r15 != (-1)) goto L7;
        r15 = 65535;
    L7:
        String r17 = r16.encodeIntAsCharEscape(r15);
        this.serialized.add(r17);
        r14 = r14 + 1;
        goto L3
    }

    public String[][] getSegments() {
        ArrayList r5 = new ArrayList();
        int r10 = this.factory.getGenerator().getTarget().getSerializedATNSegmentLimit();
        int r11 = 0;
    L4:
        if (r11 >= this.serialized.size()) goto L7;
        List<String> r12 = this.serialized;
        int r13 = r11 + r10;
        List<String> r14 = r12.subList(r11, Math.min(r13, r12.size()));
        r5.add(r14.toArray(new String[r14.size()]));
        r11 = r13;
        goto L4
    L7:
        return (String[][]) r5.toArray(new String[r5.size()][]);
    }
}

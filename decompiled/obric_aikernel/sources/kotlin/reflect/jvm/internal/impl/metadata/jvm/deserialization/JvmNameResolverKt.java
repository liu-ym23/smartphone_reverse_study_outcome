package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* JADX INFO: loaded from: classes3.dex */
public final class JvmNameResolverKt {
    public static final List<JvmProtoBuf.StringTableTypes.Record> toExpandedRecordsList(List<JvmProtoBuf.StringTableTypes.Record> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArrayList r11 = new ArrayList();
        r11.ensureCapacity(r10.size());
        Iterator<JvmProtoBuf.StringTableTypes.Record> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        JvmProtoBuf.StringTableTypes.Record r13 = r12.next();
        int r14 = r13.getRange();
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        r11.add(r13);
        r15 = r15 + 1;
        goto L6
    L8:
        r11.trimToSize();
        return r11;
    }
}

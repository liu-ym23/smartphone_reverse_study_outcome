package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* JADX INFO: loaded from: classes3.dex */
public final class JvmNameResolverKt {
    public static final List<JvmProtoBuf.StringTableTypes.Record> toExpandedRecordsList(List<JvmProtoBuf.StringTableTypes.Record> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ArrayList r10 = new ArrayList();
        r10.ensureCapacity(r5.size());
        Iterator<JvmProtoBuf.StringTableTypes.Record> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        JvmProtoBuf.StringTableTypes.Record r12 = r11.next();
        int r13 = r12.getRange();
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L4;
        r10.add(r12);
        r14 = r14 + 1;
        goto L6
    L8:
        r10.trimToSize();
        return r10;
    }
}
